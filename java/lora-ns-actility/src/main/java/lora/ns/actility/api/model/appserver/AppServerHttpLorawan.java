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
 * AppServerHttpLorawan
 */
@JsonPropertyOrder({ AppServerHttpLorawan.JSON_PROPERTY_CUSTOM_HTTP_HEADERS,
    AppServerHttpLorawan.JSON_PROPERTY_DESTINATIONS })
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-29T11:38:36.048437806+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class AppServerHttpLorawan {
  public static final String JSON_PROPERTY_CUSTOM_HTTP_HEADERS = "customHttpHeaders";
  private List<AppServerCustomHttpHeadersInner> customHttpHeaders = new ArrayList<>();

  public static final String JSON_PROPERTY_DESTINATIONS = "destinations";
  private List<AppServerHttpLorawanDestination> destinations = new ArrayList<>();

  public AppServerHttpLorawan() {
  }

  public AppServerHttpLorawan customHttpHeaders(List<AppServerCustomHttpHeadersInner> customHttpHeaders) {

    this.customHttpHeaders = customHttpHeaders;
    return this;
  }

  public AppServerHttpLorawan addCustomHttpHeadersItem(AppServerCustomHttpHeadersInner customHttpHeadersItem) {
    if (this.customHttpHeaders == null) {
      this.customHttpHeaders = new ArrayList<>();
    }
    this.customHttpHeaders.add(customHttpHeadersItem);
    return this;
  }

  /**
   * A list of HTTP headers to be added in HTTP requests sent to the application.
   * Accept, Host, User-Agent, Content-Length and Content-Type headers cannot be
   * customized. A given HTTP header name can be configured only once (case
   * insensitive). This field is not returned if the authenticated user has domain
   * restrictions but does not have &#x60;&lt;Subscription&gt;/a&#x60; access
   * right.
   * 
   * @return customHttpHeaders
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_CUSTOM_HTTP_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AppServerCustomHttpHeadersInner> getCustomHttpHeaders() {
    return customHttpHeaders;
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM_HTTP_HEADERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomHttpHeaders(List<AppServerCustomHttpHeadersInner> customHttpHeaders) {
    this.customHttpHeaders = customHttpHeaders;
  }

  public AppServerHttpLorawan destinations(List<AppServerHttpLorawanDestination> destinations) {

    this.destinations = destinations;
    return this;
  }

  public AppServerHttpLorawan addDestinationsItem(AppServerHttpLorawanDestination destinationsItem) {
    if (this.destinations == null) {
      this.destinations = new ArrayList<>();
    }
    this.destinations.add(destinationsItem);
    return this;
  }

  /**
   * Ordered list of Application Server destinations. Only one destination can be
   * defined in **ThingPark Enterprise**. This field is not returned if the
   * authenticated user has domain restrictions but does not have
   * &#x60;&lt;Subscription&gt;/a&#x60; access right.
   * 
   * @return destinations
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DESTINATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<AppServerHttpLorawanDestination> getDestinations() {
    return destinations;
  }

  @JsonProperty(JSON_PROPERTY_DESTINATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDestinations(List<AppServerHttpLorawanDestination> destinations) {
    this.destinations = destinations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppServerHttpLorawan appServerHttpLorawan = (AppServerHttpLorawan) o;
    return Objects.equals(this.customHttpHeaders, appServerHttpLorawan.customHttpHeaders)
            && Objects.equals(this.destinations, appServerHttpLorawan.destinations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customHttpHeaders, destinations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppServerHttpLorawan {\n");
    sb.append("    customHttpHeaders: ").append(toIndentedString(customHttpHeaders)).append("\n");
    sb.append("    destinations: ").append(toIndentedString(destinations)).append("\n");
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
