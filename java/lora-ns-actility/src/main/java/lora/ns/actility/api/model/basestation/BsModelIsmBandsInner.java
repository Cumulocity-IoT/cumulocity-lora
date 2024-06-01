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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lora.ns.actility.api.model.common.IsmBandID;

/**
 * List of IMS band IDs associated with the BS profile. If default ISM bands are
 * defined for the network partner, the list is filtered to only keep ISM bands
 * matching the default ones.
 */
@JsonPropertyOrder({ BsModelIsmBandsInner.JSON_PROPERTY_I_D })
@JsonTypeName("Bs_model_ismBands_inner")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsModelIsmBandsInner {
  public static final String JSON_PROPERTY_I_D = "ID";
  private IsmBandID ID;

  public BsModelIsmBandsInner() {
  }

  public BsModelIsmBandsInner ID(IsmBandID ID) {

    this.ID = ID;
    return this;
  }

  /**
   * Get ID
   * 
   * @return ID
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public IsmBandID getID() {
    return ID;
  }

  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setID(IsmBandID ID) {
    this.ID = ID;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsModelIsmBandsInner bsModelIsmBandsInner = (BsModelIsmBandsInner) o;
    return Objects.equals(this.ID, bsModelIsmBandsInner.ID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsModelIsmBandsInner {\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
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