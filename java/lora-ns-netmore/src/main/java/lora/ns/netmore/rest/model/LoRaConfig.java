/*
 * netmore-web-backend
 * Front end for web services.
 *
 * The version of the OpenAPI document: 1.2.83
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package lora.ns.netmore.rest.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * LoRaConfig
 */
@JsonPropertyOrder({
  LoRaConfig.JSON_PROPERTY_ORIGIN,
  LoRaConfig.JSON_PROPERTY_URL,
  LoRaConfig.JSON_PROPERTY_USERNAME,
  LoRaConfig.JSON_PROPERTY_PASSWORD,
  LoRaConfig.JSON_PROPERTY_SERVICE_PROVIDERS,
  LoRaConfig.JSON_PROPERTY_CUSTOMERS
})
public class LoRaConfig {
  public static final String JSON_PROPERTY_ORIGIN = "origin";
  private String origin;

  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_USERNAME = "username";
  private String username;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  private String password;

  public static final String JSON_PROPERTY_SERVICE_PROVIDERS = "serviceProviders";
  private List<String> serviceProviders;

  public static final String JSON_PROPERTY_CUSTOMERS = "customers";
  private List<String> customers;

  public LoRaConfig() {
  }

  public LoRaConfig origin(String origin) {
    
    this.origin = origin;
    return this;
  }

   /**
   * Get origin
   * @return origin
  **/

  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getOrigin() {
    return origin;
  }


  @JsonProperty(JSON_PROPERTY_ORIGIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOrigin(String origin) {
    this.origin = origin;
  }


  public LoRaConfig url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrl() {
    return url;
  }


  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrl(String url) {
    this.url = url;
  }


  public LoRaConfig username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/

  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUsername() {
    return username;
  }


  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUsername(String username) {
    this.username = username;
  }


  public LoRaConfig password(String password) {
    
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/

  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPassword() {
    return password;
  }


  @JsonProperty(JSON_PROPERTY_PASSWORD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPassword(String password) {
    this.password = password;
  }


  public LoRaConfig serviceProviders(List<String> serviceProviders) {
    
    this.serviceProviders = serviceProviders;
    return this;
  }

  public LoRaConfig addServiceProvidersItem(String serviceProvidersItem) {
    if (this.serviceProviders == null) {
      this.serviceProviders = new ArrayList<>();
    }
    this.serviceProviders.add(serviceProvidersItem);
    return this;
  }

   /**
   * This is populated using the username and password from the lora backend system
   * @return serviceProviders
  **/

  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getServiceProviders() {
    return serviceProviders;
  }


  @JsonProperty(JSON_PROPERTY_SERVICE_PROVIDERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setServiceProviders(List<String> serviceProviders) {
    this.serviceProviders = serviceProviders;
  }


  public LoRaConfig customers(List<String> customers) {
    
    this.customers = customers;
    return this;
  }

  public LoRaConfig addCustomersItem(String customersItem) {
    if (this.customers == null) {
      this.customers = new ArrayList<>();
    }
    this.customers.add(customersItem);
    return this;
  }

   /**
   * This is populated using the username and password from the lora backend system
   * @return customers
  **/

  @JsonProperty(JSON_PROPERTY_CUSTOMERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getCustomers() {
    return customers;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOMERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomers(List<String> customers) {
    this.customers = customers;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoRaConfig loRaConfig = (LoRaConfig) o;
    return Objects.equals(this.origin, loRaConfig.origin) &&
        Objects.equals(this.url, loRaConfig.url) &&
        Objects.equals(this.username, loRaConfig.username) &&
        Objects.equals(this.password, loRaConfig.password) &&
        Objects.equals(this.serviceProviders, loRaConfig.serviceProviders) &&
        Objects.equals(this.customers, loRaConfig.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, url, username, password, serviceProviders, customers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoRaConfig {\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    serviceProviders: ").append(toIndentedString(serviceProviders)).append("\n");
    sb.append("    customers: ").append(toIndentedString(customers)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

