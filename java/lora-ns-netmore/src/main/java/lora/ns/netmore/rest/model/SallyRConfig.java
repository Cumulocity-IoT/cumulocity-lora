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
import lora.ns.netmore.rest.model.DeviceMap;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SallyRConfig
 */
@JsonPropertyOrder({
  SallyRConfig.JSON_PROPERTY_DEVICE_GROUP_ID,
  SallyRConfig.JSON_PROPERTY_CUSTOMER_ID,
  SallyRConfig.JSON_PROPERTY_DRY_RUN,
  SallyRConfig.JSON_PROPERTY_BUILDING_ID,
  SallyRConfig.JSON_PROPERTY_DEVICES
})
public class SallyRConfig {
  public static final String JSON_PROPERTY_DEVICE_GROUP_ID = "deviceGroupId";
  private String deviceGroupId;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_DRY_RUN = "dryRun";
  private Boolean dryRun;

  public static final String JSON_PROPERTY_BUILDING_ID = "buildingId";
  private String buildingId;

  public static final String JSON_PROPERTY_DEVICES = "devices";
  private List<DeviceMap> devices = new ArrayList<>();

  public SallyRConfig() {
  }

  public SallyRConfig deviceGroupId(String deviceGroupId) {
    
    this.deviceGroupId = deviceGroupId;
    return this;
  }

   /**
   * Get deviceGroupId
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


  public SallyRConfig customerId(String customerId) {
    
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


  public SallyRConfig dryRun(Boolean dryRun) {
    
    this.dryRun = dryRun;
    return this;
  }

   /**
   * Get dryRun
   * @return dryRun
  **/

  @JsonProperty(JSON_PROPERTY_DRY_RUN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getDryRun() {
    return dryRun;
  }


  @JsonProperty(JSON_PROPERTY_DRY_RUN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
  }


  public SallyRConfig buildingId(String buildingId) {
    
    this.buildingId = buildingId;
    return this;
  }

   /**
   * Get buildingId
   * @return buildingId
  **/

  @JsonProperty(JSON_PROPERTY_BUILDING_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBuildingId() {
    return buildingId;
  }


  @JsonProperty(JSON_PROPERTY_BUILDING_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBuildingId(String buildingId) {
    this.buildingId = buildingId;
  }


  public SallyRConfig devices(List<DeviceMap> devices) {
    
    this.devices = devices;
    return this;
  }

  public SallyRConfig addDevicesItem(DeviceMap devicesItem) {
    if (this.devices == null) {
      this.devices = new ArrayList<>();
    }
    this.devices.add(devicesItem);
    return this;
  }

   /**
   * Get devices
   * @return devices
  **/

  @JsonProperty(JSON_PROPERTY_DEVICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<DeviceMap> getDevices() {
    return devices;
  }


  @JsonProperty(JSON_PROPERTY_DEVICES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDevices(List<DeviceMap> devices) {
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
    SallyRConfig sallyRConfig = (SallyRConfig) o;
    return Objects.equals(this.deviceGroupId, sallyRConfig.deviceGroupId) &&
        Objects.equals(this.customerId, sallyRConfig.customerId) &&
        Objects.equals(this.dryRun, sallyRConfig.dryRun) &&
        Objects.equals(this.buildingId, sallyRConfig.buildingId) &&
        Objects.equals(this.devices, sallyRConfig.devices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deviceGroupId, customerId, dryRun, buildingId, devices);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SallyRConfig {\n");
    sb.append("    deviceGroupId: ").append(toIndentedString(deviceGroupId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    dryRun: ").append(toIndentedString(dryRun)).append("\n");
    sb.append("    buildingId: ").append(toIndentedString(buildingId)).append("\n");
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

