/*
 * ThingPark things management Devices API
 * REST interface for Devices management. 
 *
 * The version of the OpenAPI document: 7.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package lora.ns.actility.api.model.appserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AppServerHttpCellularDestination
 */
@JsonPropertyOrder({ AppServerHttpCellularDestination.JSON_PROPERTY_ADDRESSES,
    AppServerHttpCellularDestination.JSON_PROPERTY_STRATEGY })
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-29T11:38:36.048437806+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class AppServerHttpCellularDestination {
  public static final String JSON_PROPERTY_ADDRESSES = "addresses";
  private List<String> addresses = new ArrayList<>();

  public static final String JSON_PROPERTY_STRATEGY = "strategy";
  private AppServerStrategy strategy;

  public AppServerHttpCellularDestination() {
  }

  public AppServerHttpCellularDestination addresses(List<String> addresses) {

    this.addresses = addresses;
    return this;
  }

  public AppServerHttpCellularDestination addAddressesItem(String addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

  /**
   * Get addresses
   * 
   * @return addresses
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<String> getAddresses() {
    return addresses;
  }

  @JsonProperty(JSON_PROPERTY_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddresses(List<String> addresses) {
    this.addresses = addresses;
  }

  public AppServerHttpCellularDestination strategy(AppServerStrategy strategy) {

    this.strategy = strategy;
    return this;
  }

  /**
   * Get strategy
   * 
   * @return strategy
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STRATEGY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AppServerStrategy getStrategy() {
    return strategy;
  }

  @JsonProperty(JSON_PROPERTY_STRATEGY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStrategy(AppServerStrategy strategy) {
    this.strategy = strategy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppServerHttpCellularDestination appServerHttpCellularDestination = (AppServerHttpCellularDestination) o;
    return Objects.equals(this.addresses, appServerHttpCellularDestination.addresses)
            && Objects.equals(this.strategy, appServerHttpCellularDestination.strategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addresses, strategy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppServerHttpCellularDestination {\n");
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
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
