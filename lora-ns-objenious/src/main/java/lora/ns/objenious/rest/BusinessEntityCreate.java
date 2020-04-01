package lora.ns.objenious.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * BusinessEntityCreate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-13T14:17:01.165Z")

public class BusinessEntityCreate   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("primary_color")
  private String primaryColor = null;

  @JsonProperty("secondary_color")
  private String secondaryColor = null;

  @JsonProperty("navbar_color")
  private String navbarColor = null;

  @JsonProperty("customer_reference")
  private String customerReference = null;

  @JsonProperty("allowed_packs")
  @Valid
  private List<Integer> allowedPacks = null;

  public BusinessEntityCreate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Business entity name
   * @return name
  **/
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BusinessEntityCreate primaryColor(String primaryColor) {
    this.primaryColor = primaryColor;
    return this;
  }

  /**
   * Color to custom the header and menu of SPOT (hex)
   * @return primaryColor
  **/


  public String getPrimaryColor() {
    return primaryColor;
  }

  public void setPrimaryColor(String primaryColor) {
    this.primaryColor = primaryColor;
  }

  public BusinessEntityCreate secondaryColor(String secondaryColor) {
    this.secondaryColor = secondaryColor;
    return this;
  }

  /**
   * Color to custom the buttons of SPOT (hex)
   * @return secondaryColor
  **/


  public String getSecondaryColor() {
    return secondaryColor;
  }

  public void setSecondaryColor(String secondaryColor) {
    this.secondaryColor = secondaryColor;
  }

  public BusinessEntityCreate navbarColor(String navbarColor) {
    this.navbarColor = navbarColor;
    return this;
  }

  /**
   * Color to custom the navbar of SPOT (hex)
   * @return navbarColor
  **/


  public String getNavbarColor() {
    return navbarColor;
  }

  public void setNavbarColor(String navbarColor) {
    this.navbarColor = navbarColor;
  }

  public BusinessEntityCreate customerReference(String customerReference) {
    this.customerReference = customerReference;
    return this;
  }

  /**
   * The id on the client platform
   * @return customerReference
  **/


  public String getCustomerReference() {
    return customerReference;
  }

  public void setCustomerReference(String customerReference) {
    this.customerReference = customerReference;
  }

  public BusinessEntityCreate allowedPacks(List<Integer> allowedPacks) {
    this.allowedPacks = allowedPacks;
    return this;
  }

  public BusinessEntityCreate addAllowedPacksItem(Integer allowedPacksItem) {
    if (this.allowedPacks == null) {
      this.allowedPacks = new ArrayList<Integer>();
    }
    this.allowedPacks.add(allowedPacksItem);
    return this;
  }

  /**
   * Array of packId (get from GET /available-packs)
   * @return allowedPacks
  **/


  public List<Integer> getAllowedPacks() {
    return allowedPacks;
  }

  public void setAllowedPacks(List<Integer> allowedPacks) {
    this.allowedPacks = allowedPacks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BusinessEntityCreate businessEntityCreate = (BusinessEntityCreate) o;
    return Objects.equals(this.name, businessEntityCreate.name) &&
        Objects.equals(this.primaryColor, businessEntityCreate.primaryColor) &&
        Objects.equals(this.secondaryColor, businessEntityCreate.secondaryColor) &&
        Objects.equals(this.navbarColor, businessEntityCreate.navbarColor) &&
        Objects.equals(this.customerReference, businessEntityCreate.customerReference) &&
        Objects.equals(this.allowedPacks, businessEntityCreate.allowedPacks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, primaryColor, secondaryColor, navbarColor, customerReference, allowedPacks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BusinessEntityCreate {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    primaryColor: ").append(toIndentedString(primaryColor)).append("\n");
    sb.append("    secondaryColor: ").append(toIndentedString(secondaryColor)).append("\n");
    sb.append("    navbarColor: ").append(toIndentedString(navbarColor)).append("\n");
    sb.append("    customerReference: ").append(toIndentedString(customerReference)).append("\n");
    sb.append("    allowedPacks: ").append(toIndentedString(allowedPacks)).append("\n");
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

