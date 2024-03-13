/*
 * ThingPark Enterprise - Dx-Core API
 * API providing configuration and provisioning features for ThingPark Enterprise.
 *
 * OpenAPI spec version: 1.8.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package lora.ns.actility.rest.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * BaseStationTag
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseStationTag {
  private String id = null;

  private String name = null;

  private Boolean multicastVisibility = null;

  private Boolean managedNetworkVisibility = null;

  public BaseStationTag id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of the base station tag.
   * 
   * @return id
   **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public BaseStationTag name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the tag
   * 
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BaseStationTag multicastVisibility(Boolean multicastVisibility) {
    this.multicastVisibility = multicastVisibility;
    return this;
  }

  /**
   * TRUE if the tag is visible for multicast. Mandatory if the tag is a new one.
   * Ignored otherwise.
   * 
   * @return multicastVisibility
   **/
  public Boolean isMulticastVisibility() {
    return multicastVisibility;
  }

  public void setMulticastVisibility(Boolean multicastVisibility) {
    this.multicastVisibility = multicastVisibility;
  }

  public BaseStationTag managedNetworkVisibility(Boolean managedNetworkVisibility) {
    this.managedNetworkVisibility = managedNetworkVisibility;
    return this;
  }

  /**
   * TRUE if the tag is visible for managed customer network. Mandatory if the tag
   * is a new one. Ignored otherwise.
   * 
   * @return managedNetworkVisibility
   **/
  public Boolean isManagedNetworkVisibility() {
    return managedNetworkVisibility;
  }

  public void setManagedNetworkVisibility(Boolean managedNetworkVisibility) {
    this.managedNetworkVisibility = managedNetworkVisibility;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseStationTag baseStationTag = (BaseStationTag) o;
    return Objects.equals(this.id, baseStationTag.id) && Objects.equals(this.name, baseStationTag.name)
            && Objects.equals(this.multicastVisibility, baseStationTag.multicastVisibility)
            && Objects.equals(this.managedNetworkVisibility, baseStationTag.managedNetworkVisibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, multicastVisibility, managedNetworkVisibility);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseStationTag {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    multicastVisibility: ").append(toIndentedString(multicastVisibility)).append("\n");
    sb.append("    managedNetworkVisibility: ").append(toIndentedString(managedNetworkVisibility)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
