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
import lora.ns.netmore.rest.model.LoraCustomerDevices;
import lora.ns.netmore.rest.model.LoraCustomerGateways;
import lora.ns.netmore.rest.model.ValidNetworkServer;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * LoraCustomer
 */
@JsonPropertyOrder({
  LoraCustomer.JSON_PROPERTY_CUSTOMER_ID,
  LoraCustomer.JSON_PROPERTY_OPERATOR,
  LoraCustomer.JSON_PROPERTY_VALID_NETWORK_SERVERS,
  LoraCustomer.JSON_PROPERTY_DEFAULT_NETWORK_SERVER_ID,
  LoraCustomer.JSON_PROPERTY_GATEWAYS,
  LoraCustomer.JSON_PROPERTY_DEVICES
})
public class LoraCustomer {
  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private Boolean operator;

  public static final String JSON_PROPERTY_VALID_NETWORK_SERVERS = "validNetworkServers";
  private List<ValidNetworkServer> validNetworkServers = new ArrayList<>();

  public static final String JSON_PROPERTY_DEFAULT_NETWORK_SERVER_ID = "defaultNetworkServerId";
  private String defaultNetworkServerId;

  public static final String JSON_PROPERTY_GATEWAYS = "gateways";
  private LoraCustomerGateways gateways;

  public static final String JSON_PROPERTY_DEVICES = "devices";
  private LoraCustomerDevices devices;

  public LoraCustomer() {
  }

  public LoraCustomer customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/

  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCustomerId() {
    return customerId;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public LoraCustomer operator(Boolean operator) {
    
    this.operator = operator;
    return this;
  }

   /**
   * Get operator
   * @return operator
  **/

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getOperator() {
    return operator;
  }


  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOperator(Boolean operator) {
    this.operator = operator;
  }


  public LoraCustomer validNetworkServers(List<ValidNetworkServer> validNetworkServers) {
    
    this.validNetworkServers = validNetworkServers;
    return this;
  }

  public LoraCustomer addValidNetworkServersItem(ValidNetworkServer validNetworkServersItem) {
    if (this.validNetworkServers == null) {
      this.validNetworkServers = new ArrayList<>();
    }
    this.validNetworkServers.add(validNetworkServersItem);
    return this;
  }

   /**
   * Get validNetworkServers
   * @return validNetworkServers
  **/

  @JsonProperty(JSON_PROPERTY_VALID_NETWORK_SERVERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ValidNetworkServer> getValidNetworkServers() {
    return validNetworkServers;
  }


  @JsonProperty(JSON_PROPERTY_VALID_NETWORK_SERVERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidNetworkServers(List<ValidNetworkServer> validNetworkServers) {
    this.validNetworkServers = validNetworkServers;
  }


  public LoraCustomer defaultNetworkServerId(String defaultNetworkServerId) {
    
    this.defaultNetworkServerId = defaultNetworkServerId;
    return this;
  }

   /**
   * Get defaultNetworkServerId
   * @return defaultNetworkServerId
  **/

  @JsonProperty(JSON_PROPERTY_DEFAULT_NETWORK_SERVER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDefaultNetworkServerId() {
    return defaultNetworkServerId;
  }


  @JsonProperty(JSON_PROPERTY_DEFAULT_NETWORK_SERVER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDefaultNetworkServerId(String defaultNetworkServerId) {
    this.defaultNetworkServerId = defaultNetworkServerId;
  }


  public LoraCustomer gateways(LoraCustomerGateways gateways) {
    
    this.gateways = gateways;
    return this;
  }

   /**
   * Get gateways
   * @return gateways
  **/

  @JsonProperty(JSON_PROPERTY_GATEWAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LoraCustomerGateways getGateways() {
    return gateways;
  }


  @JsonProperty(JSON_PROPERTY_GATEWAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGateways(LoraCustomerGateways gateways) {
    this.gateways = gateways;
  }


  public LoraCustomer devices(LoraCustomerDevices devices) {
    
    this.devices = devices;
    return this;
  }

   /**
   * Get devices
   * @return devices
  **/

  @JsonProperty(JSON_PROPERTY_DEVICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LoraCustomerDevices getDevices() {
    return devices;
  }


  @JsonProperty(JSON_PROPERTY_DEVICES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDevices(LoraCustomerDevices devices) {
    this.devices = devices;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoraCustomer loraCustomer = (LoraCustomer) o;
    return Objects.equals(this.customerId, loraCustomer.customerId) &&
        Objects.equals(this.operator, loraCustomer.operator) &&
        Objects.equals(this.validNetworkServers, loraCustomer.validNetworkServers) &&
        Objects.equals(this.defaultNetworkServerId, loraCustomer.defaultNetworkServerId) &&
        Objects.equals(this.gateways, loraCustomer.gateways) &&
        Objects.equals(this.devices, loraCustomer.devices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, operator, validNetworkServers, defaultNetworkServerId, gateways, devices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoraCustomer {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    validNetworkServers: ").append(toIndentedString(validNetworkServers)).append("\n");
    sb.append("    defaultNetworkServerId: ").append(toIndentedString(defaultNetworkServerId)).append("\n");
    sb.append("    gateways: ").append(toIndentedString(gateways)).append("\n");
    sb.append("    devices: ").append(toIndentedString(devices)).append("\n");
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

