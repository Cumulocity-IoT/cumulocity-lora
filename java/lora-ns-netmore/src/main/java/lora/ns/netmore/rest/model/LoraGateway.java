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
 * LoraGateway
 */
@JsonPropertyOrder({
  LoraGateway.JSON_PROPERTY_ACTIVE,
  LoraGateway.JSON_PROPERTY_GW_EUI,
  LoraGateway.JSON_PROPERTY_PROVISIONED,
  LoraGateway.JSON_PROPERTY_PROVISIONED_TIMESTAMP,
  LoraGateway.JSON_PROPERTY_NETWORK_SERVER_ID,
  LoraGateway.JSON_PROPERTY_PACKET_FORWARDER,
  LoraGateway.JSON_PROPERTY_FREQUENCY_PLAN,
  LoraGateway.JSON_PROPERTY_CREATED,
  LoraGateway.JSON_PROPERTY_CREATED_BY,
  LoraGateway.JSON_PROPERTY_LAST_UPDATED,
  LoraGateway.JSON_PROPERTY_LAST_UPDATED_BY
})
public class LoraGateway {
  public static final String JSON_PROPERTY_ACTIVE = "active";
  private Boolean active;

  public static final String JSON_PROPERTY_GW_EUI = "gwEui";
  private String gwEui;

  public static final String JSON_PROPERTY_PROVISIONED = "provisioned";
  private Boolean provisioned;

  public static final String JSON_PROPERTY_PROVISIONED_TIMESTAMP = "provisionedTimestamp";
  private String provisionedTimestamp;

  public static final String JSON_PROPERTY_NETWORK_SERVER_ID = "networkServerId";
  private String networkServerId;

  public static final String JSON_PROPERTY_PACKET_FORWARDER = "packetForwarder";
  private PacketForwarder packetForwarder;

  public static final String JSON_PROPERTY_FREQUENCY_PLAN = "frequencyPlan";
  private FrequencyPlan frequencyPlan;

  public static final String JSON_PROPERTY_CREATED = "created";
  private String created;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
  private String lastUpdated;

  public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
  private String lastUpdatedBy;

  public LoraGateway() {
  }

  public LoraGateway active(Boolean active) {
    
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/

  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getActive() {
    return active;
  }


  @JsonProperty(JSON_PROPERTY_ACTIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setActive(Boolean active) {
    this.active = active;
  }


  public LoraGateway gwEui(String gwEui) {
    
    this.gwEui = gwEui;
    return this;
  }

   /**
   * Get gwEui
   * @return gwEui
  **/

  @JsonProperty(JSON_PROPERTY_GW_EUI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGwEui() {
    return gwEui;
  }


  @JsonProperty(JSON_PROPERTY_GW_EUI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGwEui(String gwEui) {
    this.gwEui = gwEui;
  }


  public LoraGateway provisioned(Boolean provisioned) {
    
    this.provisioned = provisioned;
    return this;
  }

   /**
   * Get provisioned
   * @return provisioned
  **/

  @JsonProperty(JSON_PROPERTY_PROVISIONED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getProvisioned() {
    return provisioned;
  }


  @JsonProperty(JSON_PROPERTY_PROVISIONED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProvisioned(Boolean provisioned) {
    this.provisioned = provisioned;
  }


  public LoraGateway provisionedTimestamp(String provisionedTimestamp) {
    
    this.provisionedTimestamp = provisionedTimestamp;
    return this;
  }

   /**
   * Get provisionedTimestamp
   * @return provisionedTimestamp
  **/

  @JsonProperty(JSON_PROPERTY_PROVISIONED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProvisionedTimestamp() {
    return provisionedTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_PROVISIONED_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProvisionedTimestamp(String provisionedTimestamp) {
    this.provisionedTimestamp = provisionedTimestamp;
  }


  public LoraGateway networkServerId(String networkServerId) {
    
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


  public LoraGateway packetForwarder(PacketForwarder packetForwarder) {
    
    this.packetForwarder = packetForwarder;
    return this;
  }

   /**
   * Get packetForwarder
   * @return packetForwarder
  **/

  @JsonProperty(JSON_PROPERTY_PACKET_FORWARDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PacketForwarder getPacketForwarder() {
    return packetForwarder;
  }


  @JsonProperty(JSON_PROPERTY_PACKET_FORWARDER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPacketForwarder(PacketForwarder packetForwarder) {
    this.packetForwarder = packetForwarder;
  }


  public LoraGateway frequencyPlan(FrequencyPlan frequencyPlan) {
    
    this.frequencyPlan = frequencyPlan;
    return this;
  }

   /**
   * Get frequencyPlan
   * @return frequencyPlan
  **/

  @JsonProperty(JSON_PROPERTY_FREQUENCY_PLAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public FrequencyPlan getFrequencyPlan() {
    return frequencyPlan;
  }


  @JsonProperty(JSON_PROPERTY_FREQUENCY_PLAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFrequencyPlan(FrequencyPlan frequencyPlan) {
    this.frequencyPlan = frequencyPlan;
  }


  public LoraGateway created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/

  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreated() {
    return created;
  }


  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreated(String created) {
    this.created = created;
  }


  public LoraGateway createdBy(String createdBy) {
    
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


  public LoraGateway lastUpdated(String lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastUpdated() {
    return lastUpdated;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public LoraGateway lastUpdatedBy(String lastUpdatedBy) {
    
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
    LoraGateway loraGateway = (LoraGateway) o;
    return Objects.equals(this.active, loraGateway.active) &&
        Objects.equals(this.gwEui, loraGateway.gwEui) &&
        Objects.equals(this.provisioned, loraGateway.provisioned) &&
        Objects.equals(this.provisionedTimestamp, loraGateway.provisionedTimestamp) &&
        Objects.equals(this.networkServerId, loraGateway.networkServerId) &&
        Objects.equals(this.packetForwarder, loraGateway.packetForwarder) &&
        Objects.equals(this.frequencyPlan, loraGateway.frequencyPlan) &&
        Objects.equals(this.created, loraGateway.created) &&
        Objects.equals(this.createdBy, loraGateway.createdBy) &&
        Objects.equals(this.lastUpdated, loraGateway.lastUpdated) &&
        Objects.equals(this.lastUpdatedBy, loraGateway.lastUpdatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, gwEui, provisioned, provisionedTimestamp, networkServerId, packetForwarder, frequencyPlan, created, createdBy, lastUpdated, lastUpdatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoraGateway {\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    gwEui: ").append(toIndentedString(gwEui)).append("\n");
    sb.append("    provisioned: ").append(toIndentedString(provisioned)).append("\n");
    sb.append("    provisionedTimestamp: ").append(toIndentedString(provisionedTimestamp)).append("\n");
    sb.append("    networkServerId: ").append(toIndentedString(networkServerId)).append("\n");
    sb.append("    packetForwarder: ").append(toIndentedString(packetForwarder)).append("\n");
    sb.append("    frequencyPlan: ").append(toIndentedString(frequencyPlan)).append("\n");
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

