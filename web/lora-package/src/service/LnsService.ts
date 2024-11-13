import { Injectable } from "@angular/core";
import {
  FetchClient,
  IManagedObject,
  IdentityService,
  InventoryService,
} from "@c8y/client";
import { AlertService } from "@c8y/ngx-components";
import { DeviceAdditionalProperty } from "./DeviceAdditionalProperty";
import { DeviceProvisioning } from "./DeviceProvisioning";

@Injectable({
  providedIn: "root",
})
export class LnsService {
  lnsProxies: IManagedObject[] = [];
  lnsInstances: IManagedObject[] = [];
  proxyMap: {};
  instanceMap: {};

  private lnsProxyFilter: object = {
    type: "LoRa Network Server agent",
    withTotalPages: true,
    pageSize: 1000,
  };

  private instanceFilter: object = {
    type: "LNS Connector",
    withTotalPages: true,
    pageSize: 1000,
  };

  constructor(
    private client: FetchClient,
    private inventory: InventoryService,
    private identityService: IdentityService,
    private alertService: AlertService
  ) {
    this.loadProxies();
    this.loadInstances();
  }

  async loadProxies() {
    const { data, res, paging } = await this.inventory.list(
      this.lnsProxyFilter
    );
    this.lnsProxies = data;
    this.proxyMap = {};
    data.forEach((proxy) => (this.proxyMap[proxy.lnsType] = proxy));
  }

  async loadInstances() {
    const { data, res, paging } = await this.inventory.list(
      this.instanceFilter
    );
    this.lnsInstances = data;
    this.instanceMap = {};
    data.forEach((instance) => (this.instanceMap[instance.id] = instance));
  }

  async getDevEUI(device: Partial<IManagedObject>) {
    let extIds = (await this.identityService.list(device.id)).data.filter(
      (extId) => extId.type === "LoRa devEUI"
    );
    let extId = "-";
    if (extIds.length > 0) {
      extId = extIds[0].externalId;
    }
    return extId;
  }

  async provisionDevice(
    deviceProvisioning: DeviceProvisioning,
    instance: string,
    additionalProperties
  ) {
    console.log("Will provision device on LNS instance " + instance);
    console.log({
      ...deviceProvisioning,
      provisioningMode: "OTAA",
      additionalProperties: additionalProperties,
    });
    let lnsInstance: IManagedObject = this.instanceMap[instance];
    let response = await this.client.fetch(
      "service/lora-ns-" + lnsInstance.lnsType + "/" + instance + "/devices",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ...deviceProvisioning,
          provisioningMode: "OTAA",
          additionalProperties: additionalProperties,
        }),
      }
    );
    console.log(response);
    if (!response.ok) {
      let error = await response.json();
      this.alertService.danger(error.message, error.detailedMessage);
    }
  }

  async deprovisionDevice(device: Partial<IManagedObject>) {
    let response = await this.client.fetch(
      "service/lora-ns-" +
        this.instanceMap[device.lnsConnectorId].lnsType +
        "/" +
        device.lnsConnectorId +
        "/devices/" +
        (await this.getDevEUI(device)),
      {
        method: "DELETE",
      }
    );
    console.log(response);
    if (!response.ok) {
      let error = await response.json();
      this.alertService.danger(error.message, error.detailedMessage);
    }
  }

  async getDeviceProvisioningAdditionalProperties(instance: string): Promise<{
    properties: Array<DeviceAdditionalProperty>;
    values: {};
  }> {
    let props: {
      properties: Array<DeviceAdditionalProperty>;
      values: {};
    } = { properties: [], values: {} };
    let lnsInstance: IManagedObject = this.instanceMap[instance];
    const response = await this.client.fetch(
      "service/lora-ns-" +
        lnsInstance.lnsType +
        "/deviceProvisioningAdditionalProperties"
    );
    props.properties = await response.json();
    if (props.properties && props.properties.forEach) {
      console.log(props.properties);
      props.properties.forEach(async (p) => {
        if (p.type === "LIST") {
          const values = await this.client.fetch(
            "service/lora-ns-" + lnsInstance.lnsType + "/" + instance + p.url,
            {
              method: "GET",
              headers: {
                "Content-Type": "application/json",
              },
            }
          );
          p.values = await values.json();
        }
        props.values[p.name] = undefined;
      });
    }

    return props;
  }

  async getGWId(gateway) {
    let extIds = (await this.identityService.list(gateway.id)).data.filter(
      (extId) => extId.type === "LoRa Gateway Id"
    );
    let extId = "-";
    if (extIds.length > 0) {
      extId = extIds[0].externalId;
    }
    return extId;
  }

  async provisionGateway(
    gatewayProvisioning: {
      name: string;
      gwEUI: string;
      type: string;
      lat?: number;
      lng?: number;
    },
    instance: string,
    additionalProperties
  ) {
    console.log("Will provision gateway on LNS instance " + instance);
    console.log({
      ...gatewayProvisioning,
      additionalProperties: additionalProperties,
    });
    let lnsInstance: IManagedObject = this.instanceMap[instance];
    let response = await this.client.fetch(
      "service/lora-ns-" + lnsInstance.lnsType + "/" + instance + "/gateways",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ...gatewayProvisioning,
          additionalProperties: additionalProperties,
        }),
      }
    );
    console.log(response);
    if (!response.ok) {
      let error = await response.json();
      this.alertService.danger(error.message, error.detailedMessage);
    }
  }

  async deprovisionGateway(gateway: Partial<IManagedObject>) {
    let response = await this.client.fetch(
      "service/lora-ns-" +
        this.instanceMap[gateway.lnsConnectorId].lnsType +
        "/" +
        gateway.lnsConnectorId +
        "/gateways/" +
        (await this.getGWId(gateway)),
      {
        method: "DELETE",
      }
    );
    if (!response.ok) {
      let error = await response.json();
      this.alertService.danger(error.message, error.detailedMessage);
    }
  }
}
