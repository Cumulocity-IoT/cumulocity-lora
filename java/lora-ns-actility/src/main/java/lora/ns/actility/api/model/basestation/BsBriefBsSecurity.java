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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The base station security defines how the connection to the core network is
 * secured. It only applies when the base station identification mode is
 * &#x60;LRR_UUID&#x60;. When the base station identification mode is
 * &#x60;LRR_ID&#x60;, the management of the base station security is performed
 * outside the Network Manager API and type is set to &#x60;DISABLE&#x60;.
 */
@JsonPropertyOrder({ BsBriefBsSecurity.JSON_PROPERTY_EXPIRATION_DATE, BsBriefBsSecurity.JSON_PROPERTY_GENERATION_DATE,
    BsBriefBsSecurity.JSON_PROPERTY_TYPE })
@JsonTypeName("BsBrief_bsSecurity")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsBriefBsSecurity {
  public static final String JSON_PROPERTY_EXPIRATION_DATE = "expirationDate";
  private Long expirationDate;

  public static final String JSON_PROPERTY_GENERATION_DATE = "generationDate";
  private Long generationDate;

  /**
   * Base Station security type: - &#x60;IPSEC_X509&#x60;: the connection to the
   * core network is secured using IPsec or TLS (X.509 certificates) -
   * &#x60;DISABLE&#x60;: the connection to the core network is not secured
   */
  public enum TypeEnum {
    IPSEC_X509("IPSEC_X509"),

    DISABLE("DISABLE");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public BsBriefBsSecurity() {
  }

  public BsBriefBsSecurity expirationDate(Long expirationDate) {

    this.expirationDate = expirationDate;
    return this;
  }

  /**
   * Date of Base Station certificate expiration, epoch time in milliseconds
   * 
   * @return expirationDate
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_EXPIRATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getExpirationDate() {
    return expirationDate;
  }

  @JsonProperty(JSON_PROPERTY_EXPIRATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExpirationDate(Long expirationDate) {
    this.expirationDate = expirationDate;
  }

  public BsBriefBsSecurity generationDate(Long generationDate) {

    this.generationDate = generationDate;
    return this;
  }

  /**
   * Date of Base Station certificate generation, epoch time in milliseconds
   * 
   * @return generationDate
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_GENERATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getGenerationDate() {
    return generationDate;
  }

  @JsonProperty(JSON_PROPERTY_GENERATION_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGenerationDate(Long generationDate) {
    this.generationDate = generationDate;
  }

  public BsBriefBsSecurity type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * Base Station security type: - &#x60;IPSEC_X509&#x60;: the connection to the
   * core network is secured using IPsec or TLS (X.509 certificates) -
   * &#x60;DISABLE&#x60;: the connection to the core network is not secured
   * 
   * @return type
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TypeEnum getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsBriefBsSecurity bsBriefBsSecurity = (BsBriefBsSecurity) o;
    return Objects.equals(this.expirationDate, bsBriefBsSecurity.expirationDate)
            && Objects.equals(this.generationDate, bsBriefBsSecurity.generationDate)
            && Objects.equals(this.type, bsBriefBsSecurity.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expirationDate, generationDate, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsBriefBsSecurity {\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
    sb.append("    generationDate: ").append(toIndentedString(generationDate)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
