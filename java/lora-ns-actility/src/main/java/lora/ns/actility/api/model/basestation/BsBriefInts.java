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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * WAN backhaul interfaces of the base station. Empty until the configuration is
 * reported by the base station.
 */
@JsonPropertyOrder({ BsBriefInts.JSON_PROPERTY_INT })
@JsonTypeName("BsBrief_ints")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsBriefInts {
  public static final String JSON_PROPERTY_INT = "int";
  private List<BsBriefInt> _int = new ArrayList<>();

  public BsBriefInts() {
  }

  public BsBriefInts _int(List<BsBriefInt> _int) {

    this._int = _int;
    return this;
  }

  public BsBriefInts addIntItem(BsBriefInt _intItem) {
    if (this._int == null) {
      this._int = new ArrayList<>();
    }
    this._int.add(_intItem);
    return this;
  }

  /**
   * Get _int
   * 
   * @return _int
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_INT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<BsBriefInt> getInt() {
    return _int;
  }

  @JsonProperty(JSON_PROPERTY_INT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInt(List<BsBriefInt> _int) {
    this._int = _int;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsBriefInts bsBriefInts = (BsBriefInts) o;
    return Objects.equals(this._int, bsBriefInts._int);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_int);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsBriefInts {\n");
    sb.append("    _int: ").append(toIndentedString(_int)).append("\n");
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
