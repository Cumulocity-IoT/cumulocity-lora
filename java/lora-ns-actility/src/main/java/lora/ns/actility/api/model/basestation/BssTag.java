/*
 * ThingPark things management Networks API
 * REST interface for networks management. 
 *
 * The version of the OpenAPI document: 7.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package lora.ns.actility.api.model.basestation;

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
 * BssTag
 */
@JsonPropertyOrder({ BssTag.JSON_PROPERTY_MANAGED_NETWORK_VISIBILITY, BssTag.JSON_PROPERTY_MULTICAST_VISIBILITY,
    BssTag.JSON_PROPERTY_NAME, BssTag.JSON_PROPERTY_LR_R_I_DS })
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BssTag {
  public static final String JSON_PROPERTY_MANAGED_NETWORK_VISIBILITY = "managedNetworkVisibility";
  private Boolean managedNetworkVisibility = true;

  public static final String JSON_PROPERTY_MULTICAST_VISIBILITY = "multicastVisibility";
  private Boolean multicastVisibility = true;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_LR_R_I_DS = "LRRIDs";
  private List<String> lrRIDs = new ArrayList<>();

  public BssTag() {
  }

  public BssTag managedNetworkVisibility(Boolean managedNetworkVisibility) {

    this.managedNetworkVisibility = managedNetworkVisibility;
    return this;
  }

  /**
   * TRUE if the tag is visible for managed customer network. This parameter must
   * no longer be used: it is ignored and always set to false.
   * 
   * @return managedNetworkVisibility
   * @deprecated
   **/
  @Deprecated
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MANAGED_NETWORK_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getManagedNetworkVisibility() {
    return managedNetworkVisibility;
  }

  @JsonProperty(JSON_PROPERTY_MANAGED_NETWORK_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setManagedNetworkVisibility(Boolean managedNetworkVisibility) {
    this.managedNetworkVisibility = managedNetworkVisibility;
  }

  public BssTag multicastVisibility(Boolean multicastVisibility) {

    this.multicastVisibility = multicastVisibility;
    return this;
  }

  /**
   * TRUE if the tag is visible for multicast.
   * 
   * @return multicastVisibility
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_MULTICAST_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getMulticastVisibility() {
    return multicastVisibility;
  }

  @JsonProperty(JSON_PROPERTY_MULTICAST_VISIBILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMulticastVisibility(Boolean multicastVisibility) {
    this.multicastVisibility = multicastVisibility;
  }

  public BssTag name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  public BssTag lrRIDs(List<String> lrRIDs) {

    this.lrRIDs = lrRIDs;
    return this;
  }

  public BssTag addLrRIDsItem(String lrRIDsItem) {
    if (this.lrRIDs == null) {
      this.lrRIDs = new ArrayList<>();
    }
    this.lrRIDs.add(lrRIDsItem);
    return this;
  }

  /**
   * Only tags/untags base stations matching these LRR IDs (exact match).
   * 
   * @return lrRIDs
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LR_R_I_DS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getLrRIDs() {
    return lrRIDs;
  }

  @JsonProperty(JSON_PROPERTY_LR_R_I_DS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLrRIDs(List<String> lrRIDs) {
    this.lrRIDs = lrRIDs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BssTag bssTag = (BssTag) o;
    return Objects.equals(this.managedNetworkVisibility, bssTag.managedNetworkVisibility)
            && Objects.equals(this.multicastVisibility, bssTag.multicastVisibility)
            && Objects.equals(this.name, bssTag.name) && Objects.equals(this.lrRIDs, bssTag.lrRIDs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(managedNetworkVisibility, multicastVisibility, name, lrRIDs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BssTag {\n");
    sb.append("    managedNetworkVisibility: ").append(toIndentedString(managedNetworkVisibility)).append("\n");
    sb.append("    multicastVisibility: ").append(toIndentedString(multicastVisibility)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    lrRIDs: ").append(toIndentedString(lrRIDs)).append("\n");
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