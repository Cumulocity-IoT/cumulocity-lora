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
import lora.ns.netmore.rest.model.Roles;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * UpdateDeviceGroupAccess
 */
@JsonPropertyOrder({
  UpdateDeviceGroupAccess.JSON_PROPERTY_EXPORT_CONFIG_IDS,
  UpdateDeviceGroupAccess.JSON_PROPERTY_ROLE
})
public class UpdateDeviceGroupAccess {
  public static final String JSON_PROPERTY_EXPORT_CONFIG_IDS = "exportConfigIds";
  private List<String> exportConfigIds;

  public static final String JSON_PROPERTY_ROLE = "role";
  private Roles role;

  public UpdateDeviceGroupAccess() {
  }

  public UpdateDeviceGroupAccess exportConfigIds(List<String> exportConfigIds) {
    
    this.exportConfigIds = exportConfigIds;
    return this;
  }

  public UpdateDeviceGroupAccess addExportConfigIdsItem(String exportConfigIdsItem) {
    if (this.exportConfigIds == null) {
      this.exportConfigIds = new ArrayList<>();
    }
    this.exportConfigIds.add(exportConfigIdsItem);
    return this;
  }

   /**
   * Export config ids that the customer wants to use for this device group.
   * @return exportConfigIds
  **/

  @JsonProperty(JSON_PROPERTY_EXPORT_CONFIG_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getExportConfigIds() {
    return exportConfigIds;
  }


  @JsonProperty(JSON_PROPERTY_EXPORT_CONFIG_IDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExportConfigIds(List<String> exportConfigIds) {
    this.exportConfigIds = exportConfigIds;
  }


  public UpdateDeviceGroupAccess role(Roles role) {
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/

  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Roles getRole() {
    return role;
  }


  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRole(Roles role) {
    this.role = role;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDeviceGroupAccess updateDeviceGroupAccess = (UpdateDeviceGroupAccess) o;
    return Objects.equals(this.exportConfigIds, updateDeviceGroupAccess.exportConfigIds) &&
        Objects.equals(this.role, updateDeviceGroupAccess.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exportConfigIds, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDeviceGroupAccess {\n");
    sb.append("    exportConfigIds: ").append(toIndentedString(exportConfigIds)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
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

