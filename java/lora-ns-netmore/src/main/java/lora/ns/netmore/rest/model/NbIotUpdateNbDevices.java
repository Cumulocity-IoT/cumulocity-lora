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
import lora.ns.netmore.rest.model.NbIotDeviceDetails;
import lora.ns.netmore.rest.model.NbIotOperatorDetails;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * NbIotUpdateNbDevices
 */
@JsonPropertyOrder({
  NbIotUpdateNbDevices.JSON_PROPERTY_DETAILS,
  NbIotUpdateNbDevices.JSON_PROPERTY_OPERATOR
})
public class NbIotUpdateNbDevices {
  public static final String JSON_PROPERTY_DETAILS = "details";
  private NbIotDeviceDetails details;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private NbIotOperatorDetails operator;

  public NbIotUpdateNbDevices() {
  }

  public NbIotUpdateNbDevices details(NbIotDeviceDetails details) {
    
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/

  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NbIotDeviceDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(NbIotDeviceDetails details) {
    this.details = details;
  }


  public NbIotUpdateNbDevices operator(NbIotOperatorDetails operator) {
    
    this.operator = operator;
    return this;
  }

   /**
   * Get operator
   * @return operator
  **/

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public NbIotOperatorDetails getOperator() {
    return operator;
  }


  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperator(NbIotOperatorDetails operator) {
    this.operator = operator;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NbIotUpdateNbDevices nbIotUpdateNbDevices = (NbIotUpdateNbDevices) o;
    return Objects.equals(this.details, nbIotUpdateNbDevices.details) &&
        Objects.equals(this.operator, nbIotUpdateNbDevices.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, operator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NbIotUpdateNbDevices {\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
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

