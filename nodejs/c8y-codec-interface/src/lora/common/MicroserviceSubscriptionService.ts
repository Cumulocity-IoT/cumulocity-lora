import { BasicAuth, Client, FetchClient } from "@c8y/client";
import { EventEmitter } from "events";
import { Request } from "express";
import cron from "node-cron";
import { Logger } from "./Logger";

export class MicroserviceSubscriptionService extends EventEmitter {
  protected baseUrl: string = process.env.C8Y_BASEURL;
  protected tenant: string = process.env.C8Y_BOOTSTRAP_TENANT;
  protected user: string = process.env.C8Y_BOOTSTRAP_USER;
  protected password: string = process.env.C8Y_BOOTSTRAP_PASSWORD;
  protected client: FetchClient;
  protected clients: Map<string, Client> = new Map<string, Client>();
  protected logger = Logger.getLogger("MicroserviceSubscriptionService");

  constructor(testmode?) {
    super();
    this.client = new FetchClient(
      new BasicAuth({
        tenant: this.tenant,
        user: this.user,
        password: this.password,
      }),
      this.baseUrl
    );
    if (testmode) {
      this.getUsers();
    } else {
      cron.schedule("*/10 * * * * *", () => {
        this.getUsers();
      });
    }
  }

  async getUsers() {
    try {
      let result = await this.client.fetch(
        "/application/currentApplication/subscriptions"
      );
      let allUsers = await result.json();
      let newClients: Map<string, Client> = new Map<string, Client>();
      allUsers?.users?.forEach((user) => {
        if (!Array.from(this.clients.keys()).includes(user.tenant)) {
          const auth = new BasicAuth({
            user: user.name,
            password: user.password,
            tenant: user.tenant,
          });
          let client: Client = new Client(auth, this.baseUrl);
          newClients.set(user.tenant, client);

          this.emit("newMicroserviceSubscription", client);
        } else {
          newClients.set(user.tenant, this.clients.get(user.tenant));
        }
      });
      this.clients = newClients;
    } catch (e) {
      console.log(e);
      this.logger.error(e);
    }
  }

  getClients(): Map<string, Client> {
    return this.clients;
  }

  /**
   * Get the client for the current tenant based on the authentication information in the request
   */
  getClient(request: Request): Promise<Client> {
    Object.entries(request.headers).forEach(([key, value]) => {
      this.logger.info(`${key}: ${value}`);
    });

    let currentTenant: string;

    try {
      // Try to extract tenant from request using appropriate authentication method
      if (request.headers.authorization) {
        // Basic authentication
        this.logger.info("Using Basic Authentication");
        this.logger.info("Authorization: " + request.headers.authorization);
        
        currentTenant = this.extractTenantFromBasicAuth(request.headers.authorization);
        this.logger.info("Current Tenant (Basic): " + currentTenant);
      } 
      else if (request.cookies && request.cookies.authorization) {
        // OAI authentication
        this.logger.info("Using OAI Authentication");
        
        currentTenant = this.extractTenantFromOAIAuth(request.cookies.authorization);
        this.logger.info("Current Tenant (OAI): " + currentTenant);
      }
      else {
        // No valid authentication found
        this.logger.error("No valid authentication method found");
        return Promise.reject(
          new Error(
            "No valid authentication found. Please provide either Basic Authentication or OAI Authentication."
          )
        );
      }

      // Get client for the extracted tenant (common for both authentication methods)
      return this.getClientForTenant(currentTenant);
    } 
    catch (error) {
      this.logger.error("Error processing authentication: " + error.message);
      return Promise.reject(error);
    }
  }

  /**
   * Extract tenant from Basic Authentication header
   */
  private extractTenantFromBasicAuth(authHeader: string): string {
    // Format: "Basic base64(tenant/username:password)"
    const base64Credentials = authHeader.split(" ")[1];
    const credentials = Buffer.from(base64Credentials, "base64").toString("binary");
    const tenant = credentials.split("/")[0];
    
    if (!tenant) {
      throw new Error("Could not extract tenant from Basic Authentication");
    }
    
    return tenant;
  }

  /**
   * Extract tenant from OAI Authentication cookie
   */
  private extractTenantFromOAIAuth(authCookie: string): string {
    // Parse JWT token (assuming the cookie contains a JWT)
    // Format is typically: header.payload.signature
    const parts = authCookie.split('.');
    if (parts.length !== 3) {
      throw new Error("Invalid authorization cookie format");
    }
    
    // Decode the payload part (second part)
    const payload = JSON.parse(Buffer.from(parts[1], 'base64').toString('utf8'));
    
    // Extract tenant information from the payload
    const tenant = payload.ten;
    
    if (!tenant) {
      throw new Error("Could not extract tenant from authorization cookie");
    }
    
    return tenant;
  }

  /**
   * Get client for a specific tenant
   */
  private getClientForTenant(tenant: string): Promise<Client> {
    const client = this.clients.get(tenant);
    
    return new Promise<Client>((resolve, reject) => {
      if (client) {
        resolve(client);
      } else {
        reject(
          new Error(
            `Tenant ${tenant} didn't subsribe to this microservice!`
          )
        );
      }
    });
  }
}
