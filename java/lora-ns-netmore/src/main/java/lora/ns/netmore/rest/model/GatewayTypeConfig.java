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
import lora.ns.netmore.rest.model.FrequencyPlan;
import lora.ns.netmore.rest.model.PacketForwarder;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * GatewayTypeConfig
 */
@JsonPropertyOrder({
  GatewayTypeConfig.JSON_PROPERTY_GATEWAY_TYPE_ID,
  GatewayTypeConfig.JSON_PROPERTY_NETWORK_SERVER_ID,
  GatewayTypeConfig.JSON_PROPERTY_PACKET_FORWARDER,
  GatewayTypeConfig.JSON_PROPERTY_FREQUENCY_PLAN,
  GatewayTypeConfig.JSON_PROPERTY_SUPPORTED_OS_VERSIONS,
  GatewayTypeConfig.JSON_PROPERTY_LNS_CONFIG,
  GatewayTypeConfig.JSON_PROPERTY_CREATED,
  GatewayTypeConfig.JSON_PROPERTY_CREATED_BY,
  GatewayTypeConfig.JSON_PROPERTY_LAST_UPDATED,
  GatewayTypeConfig.JSON_PROPERTY_LAST_UPDATED_BY
})
public class GatewayTypeConfig {
  public static final String JSON_PROPERTY_GATEWAY_TYPE_ID = "gatewayTypeId";
  private String gatewayTypeId;

  public static final String JSON_PROPERTY_NETWORK_SERVER_ID = "networkServerId";
  private String networkServerId;

  public static final String JSON_PROPERTY_PACKET_FORWARDER = "packetForwarder";
  private PacketForwarder packetForwarder;

  public static final String JSON_PROPERTY_FREQUENCY_PLAN = "frequencyPlan";
  private FrequencyPlan frequencyPlan;

  public static final String JSON_PROPERTY_SUPPORTED_OS_VERSIONS = "supportedOsVersions";
  private String supportedOsVersions;

  public static final String JSON_PROPERTY_LNS_CONFIG = "lnsConfig";
  private String lnsConfig;

  public static final String JSON_PROPERTY_CREATED = "created";
  private String created;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
  private String lastUpdated;

  public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
  private String lastUpdatedBy;

  public GatewayTypeConfig() {
  }

  public GatewayTypeConfig gatewayTypeId(String gatewayTypeId) {
    
    this.gatewayTypeId = gatewayTypeId;
    return this;
  }

   /**
   * Get gatewayTypeId
   * @return gatewayTypeId
  **/

  @JsonProperty(JSON_PROPERTY_GATEWAY_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGatewayTypeId() {
    return gatewayTypeId;
  }


  @JsonProperty(JSON_PROPERTY_GATEWAY_TYPE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGatewayTypeId(String gatewayTypeId) {
    this.gatewayTypeId = gatewayTypeId;
  }


  public GatewayTypeConfig networkServerId(String networkServerId) {
    
    this.networkServerId = networkServerId;
    return this;
  }

   /**
   * Get networkServerId
   * @return networkServerId
  **/

  @JsonProperty(JSON_PROPERTY_NETWORK_SERVER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getNetworkServerId() {
    return networkServerId;
  }


  @JsonProperty(JSON_PROPERTY_NETWORK_SERVER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNetworkServerId(String networkServerId) {
    this.networkServerId = networkServerId;
  }


  public GatewayTypeConfig packetForwarder(PacketForwarder packetForwarder) {
    
    this.packetForwarder = packetForwarder;
    return this;
  }

   /**
   * Get packetForwarder
   * @return packetForwarder
  **/

  @JsonProperty(JSON_PROPERTY_PACKET_FORWARDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PacketForwarder getPacketForwarder() {
    return packetForwarder;
  }


  @JsonProperty(JSON_PROPERTY_PACKET_FORWARDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPacketForwarder(PacketForwarder packetForwarder) {
    this.packetForwarder = packetForwarder;
  }


  public GatewayTypeConfig frequencyPlan(FrequencyPlan frequencyPlan) {
    
    this.frequencyPlan = frequencyPlan;
    return this;
  }

   /**
   * Get frequencyPlan
   * @return frequencyPlan
  **/

  @JsonProperty(JSON_PROPERTY_FREQUENCY_PLAN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public FrequencyPlan getFrequencyPlan() {
    return frequencyPlan;
  }


  @JsonProperty(JSON_PROPERTY_FREQUENCY_PLAN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFrequencyPlan(FrequencyPlan frequencyPlan) {
    this.frequencyPlan = frequencyPlan;
  }


  public GatewayTypeConfig supportedOsVersions(String supportedOsVersions) {
    
    this.supportedOsVersions = supportedOsVersions;
    return this;
  }

   /**
   * Get supportedOsVersions
   * @return supportedOsVersions
  **/

  @JsonProperty(JSON_PROPERTY_SUPPORTED_OS_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSupportedOsVersions() {
    return supportedOsVersions;
  }


  @JsonProperty(JSON_PROPERTY_SUPPORTED_OS_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupportedOsVersions(String supportedOsVersions) {
    this.supportedOsVersions = supportedOsVersions;
  }


  public GatewayTypeConfig lnsConfig(String lnsConfig) {
    
    this.lnsConfig = lnsConfig;
    return this;
  }

   /**
   * Get lnsConfig
   * @return lnsConfig
  **/

  @JsonProperty(JSON_PROPERTY_LNS_CONFIG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLnsConfig() {
    return lnsConfig;
  }


  @JsonProperty(JSON_PROPERTY_LNS_CONFIG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLnsConfig(String lnsConfig) {
    this.lnsConfig = lnsConfig;
  }


  public GatewayTypeConfig created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/

  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCreated() {
    return created;
  }


  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreated(String created) {
    this.created = created;
  }


  public GatewayTypeConfig createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/

  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCreatedBy() {
    return createdBy;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public GatewayTypeConfig lastUpdated(String lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastUpdated() {
    return lastUpdated;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public GatewayTypeConfig lastUpdatedBy(String lastUpdatedBy) {
    
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

   /**
   * Get lastUpdatedBy
   * @return lastUpdatedBy
  **/

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GatewayTypeConfig gatewayTypeConfig = (GatewayTypeConfig) o;
    return Objects.equals(this.gatewayTypeId, gatewayTypeConfig.gatewayTypeId) &&
        Objects.equals(this.networkServerId, gatewayTypeConfig.networkServerId) &&
        Objects.equals(this.packetForwarder, gatewayTypeConfig.packetForwarder) &&
        Objects.equals(this.frequencyPlan, gatewayTypeConfig.frequencyPlan) &&
        Objects.equals(this.supportedOsVersions, gatewayTypeConfig.supportedOsVersions) &&
        Objects.equals(this.lnsConfig, gatewayTypeConfig.lnsConfig) &&
        Objects.equals(this.created, gatewayTypeConfig.created) &&
        Objects.equals(this.createdBy, gatewayTypeConfig.createdBy) &&
        Objects.equals(this.lastUpdated, gatewayTypeConfig.lastUpdated) &&
        Objects.equals(this.lastUpdatedBy, gatewayTypeConfig.lastUpdatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gatewayTypeId, networkServerId, packetForwarder, frequencyPlan, supportedOsVersions, lnsConfig, created, createdBy, lastUpdated, lastUpdatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GatewayTypeConfig {\n");
    sb.append("    gatewayTypeId: ").append(toIndentedString(gatewayTypeId)).append("\n");
    sb.append("    networkServerId: ").append(toIndentedString(networkServerId)).append("\n");
    sb.append("    packetForwarder: ").append(toIndentedString(packetForwarder)).append("\n");
    sb.append("    frequencyPlan: ").append(toIndentedString(frequencyPlan)).append("\n");
    sb.append("    supportedOsVersions: ").append(toIndentedString(supportedOsVersions)).append("\n");
    sb.append("    lnsConfig: ").append(toIndentedString(lnsConfig)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
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

