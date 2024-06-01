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

/**
 * BsBriefVendor
 */
@JsonPropertyOrder({ BsBriefVendor.JSON_PROPERTY_LOGO, BsBriefVendor.JSON_PROPERTY_NAME,
    BsBriefVendor.JSON_PROPERTY_COMMERCIAL_NAME, BsBriefVendor.JSON_PROPERTY_COMMERCIAL_DESCRIPTION })
@JsonTypeName("BsBrief_vendor")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsBriefVendor {
  public static final String JSON_PROPERTY_LOGO = "logo";
  private String logo;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_COMMERCIAL_NAME = "commercialName";
  private String commercialName;

  public static final String JSON_PROPERTY_COMMERCIAL_DESCRIPTION = "commercialDescription";
  private String commercialDescription;

  public BsBriefVendor() {
  }

  public BsBriefVendor logo(String logo) {

    this.logo = logo;
    return this;
  }

  /**
   * BS vendor logo HREF
   * 
   * @return logo
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLogo() {
    return logo;
  }

  @JsonProperty(JSON_PROPERTY_LOGO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLogo(String logo) {
    this.logo = logo;
  }

  public BsBriefVendor name(String name) {

    this.name = name;
    return this;
  }

  /**
   * BS vendor name This property must no longer be used: the property
   * &#x60;commercialName&#x60; must be used in replacement.
   * 
   * @return name
   * @deprecated
   **/
  @Deprecated
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

  public BsBriefVendor commercialName(String commercialName) {

    this.commercialName = commercialName;
    return this;
  }

  /**
   * Commercial name of the base station manufacturer
   * 
   * @return commercialName
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMMERCIAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCommercialName() {
    return commercialName;
  }

  @JsonProperty(JSON_PROPERTY_COMMERCIAL_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCommercialName(String commercialName) {
    this.commercialName = commercialName;
  }

  public BsBriefVendor commercialDescription(String commercialDescription) {

    this.commercialDescription = commercialDescription;
    return this;
  }

  /**
   * Commercial description of the base station manufacturer
   * 
   * @return commercialDescription
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_COMMERCIAL_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCommercialDescription() {
    return commercialDescription;
  }

  @JsonProperty(JSON_PROPERTY_COMMERCIAL_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCommercialDescription(String commercialDescription) {
    this.commercialDescription = commercialDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsBriefVendor bsBriefVendor = (BsBriefVendor) o;
    return Objects.equals(this.logo, bsBriefVendor.logo) && Objects.equals(this.name, bsBriefVendor.name)
            && Objects.equals(this.commercialName, bsBriefVendor.commercialName)
            && Objects.equals(this.commercialDescription, bsBriefVendor.commercialDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logo, name, commercialName, commercialDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsBriefVendor {\n");
    sb.append("    logo: ").append(toIndentedString(logo)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    commercialName: ").append(toIndentedString(commercialName)).append("\n");
    sb.append("    commercialDescription: ").append(toIndentedString(commercialDescription)).append("\n");
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