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
 * BsUpFrameHistory
 */
@JsonPropertyOrder({ BsUpFrameHistory.JSON_PROPERTY_VAL })
@JsonTypeName("Bs_upFrame_history")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsUpFrameHistory {
  public static final String JSON_PROPERTY_VAL = "val";
  private List<Integer> val = new ArrayList<>();

  public BsUpFrameHistory() {
  }

  public BsUpFrameHistory val(List<Integer> val) {

    this.val = val;
    return this;
  }

  public BsUpFrameHistory addValItem(Integer valItem) {
    if (this.val == null) {
      this.val = new ArrayList<>();
    }
    this.val.add(valItem);
    return this;
  }

  /**
   * Get val
   * 
   * @return val
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_VAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Integer> getVal() {
    return val;
  }

  @JsonProperty(JSON_PROPERTY_VAL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVal(List<Integer> val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsUpFrameHistory bsUpFrameHistory = (BsUpFrameHistory) o;
    return Objects.equals(this.val, bsUpFrameHistory.val);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsUpFrameHistory {\n");
    sb.append("    val: ").append(toIndentedString(val)).append("\n");
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
