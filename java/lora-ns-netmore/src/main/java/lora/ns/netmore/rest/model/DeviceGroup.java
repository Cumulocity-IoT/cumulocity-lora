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
import lora.ns.netmore.rest.model.DecoderType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * DeviceGroup
 */
@JsonPropertyOrder({
  DeviceGroup.JSON_PROPERTY_DEVICE_GROUP_ID,
  DeviceGroup.JSON_PROPERTY_NAME,
  DeviceGroup.JSON_PROPERTY_CUSTOMER_ID,
  DeviceGroup.JSON_PROPERTY_CREATED,
  DeviceGroup.JSON_PROPERTY_LAST_UPDATED,
  DeviceGroup.JSON_PROPERTY_DECODER_TYPE,
  DeviceGroup.JSON_PROPERTY_CREATED_BY,
  DeviceGroup.JSON_PROPERTY_LAST_UPDATED_BY
})
public class DeviceGroup {
  public static final String JSON_PROPERTY_DEVICE_GROUP_ID = "deviceGroupId";
  private String deviceGroupId;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_CREATED = "created";
  private String created;

  public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
  private String lastUpdated;

  public static final String JSON_PROPERTY_DECODER_TYPE = "decoderType";
  private DecoderType decoderType;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
  private String lastUpdatedBy;

  public DeviceGroup() {
  }

  public DeviceGroup deviceGroupId(String deviceGroupId) {
    
    this.deviceGroupId = deviceGroupId;
    return this;
  }

   /**
   * Id of the edge node
   * @return deviceGroupId
  **/

  @JsonProperty(JSON_PROPERTY_DEVICE_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDeviceGroupId() {
    return deviceGroupId;
  }


  @JsonProperty(JSON_PROPERTY_DEVICE_GROUP_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDeviceGroupId(String deviceGroupId) {
    this.deviceGroupId = deviceGroupId;
  }


  public DeviceGroup name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Name, this is only assigned if node is claimed
   * @return name
  **/

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }


  public DeviceGroup customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * The current owner of the node
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


  public DeviceGroup created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * When the edge node first reported data and was created.
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


  public DeviceGroup lastUpdated(String lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Last time we received any data from the edge node.
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


  public DeviceGroup decoderType(DecoderType decoderType) {
    
    this.decoderType = decoderType;
    return this;
  }

   /**
   * Get decoderType
   * @return decoderType
  **/

  @JsonProperty(JSON_PROPERTY_DECODER_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DecoderType getDecoderType() {
    return decoderType;
  }


  @JsonProperty(JSON_PROPERTY_DECODER_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDecoderType(DecoderType decoderType) {
    this.decoderType = decoderType;
  }


  public DeviceGroup createdBy(String createdBy) {
    
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


  public DeviceGroup lastUpdatedBy(String lastUpdatedBy) {
    
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
    DeviceGroup deviceGroup = (DeviceGroup) o;
    return Objects.equals(this.deviceGroupId, deviceGroup.deviceGroupId) &&
        Objects.equals(this.name, deviceGroup.name) &&
        Objects.equals(this.customerId, deviceGroup.customerId) &&
        Objects.equals(this.created, deviceGroup.created) &&
        Objects.equals(this.lastUpdated, deviceGroup.lastUpdated) &&
        Objects.equals(this.decoderType, deviceGroup.decoderType) &&
        Objects.equals(this.createdBy, deviceGroup.createdBy) &&
        Objects.equals(this.lastUpdatedBy, deviceGroup.lastUpdatedBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceGroupId, name, customerId, created, lastUpdated, decoderType, createdBy, lastUpdatedBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceGroup {\n");
    sb.append("    deviceGroupId: ").append(toIndentedString(deviceGroupId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    decoderType: ").append(toIndentedString(decoderType)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
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

