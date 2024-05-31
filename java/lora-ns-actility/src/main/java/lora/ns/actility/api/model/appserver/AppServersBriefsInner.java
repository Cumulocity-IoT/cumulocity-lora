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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;

import lora.ns.actility.api.model.common.Domain;

/**
 * AppServersBriefsInner
 */
@JsonPropertyOrder({ AppServersBriefsInner.JSON_PROPERTY_I_D, AppServersBriefsInner.JSON_PROPERTY_BASE_STATION_COUNT,
    AppServersBriefsInner.JSON_PROPERTY_DEVICE_COUNT, AppServersBriefsInner.JSON_PROPERTY_DOMAINS,
    AppServersBriefsInner.JSON_PROPERTY_HREF, AppServersBriefsInner.JSON_PROPERTY_MULTICAST_GROUP_COUNT,
    AppServersBriefsInner.JSON_PROPERTY_NAME, AppServersBriefsInner.JSON_PROPERTY_STATE,
    AppServersBriefsInner.JSON_PROPERTY_HEALTH_STATE, AppServersBriefsInner.JSON_PROPERTY_NOTIFICATION,
    AppServersBriefsInner.JSON_PROPERTY_TPX_IOT_FLOW, AppServersBriefsInner.JSON_PROPERTY_TYPE,
    AppServersBriefsInner.JSON_PROPERTY_VALIDATION_STATE })
@JsonTypeName("AppServers_briefs_inner")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-29T11:38:36.048437806+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class AppServersBriefsInner {
  public static final String JSON_PROPERTY_I_D = "ID";
  private String ID;

  public static final String JSON_PROPERTY_BASE_STATION_COUNT = "baseStationCount";
  private Integer baseStationCount;

  public static final String JSON_PROPERTY_DEVICE_COUNT = "deviceCount";
  private Integer deviceCount;

  public static final String JSON_PROPERTY_DOMAINS = "domains";
  private List<Domain> domains = new ArrayList<>();

  public static final String JSON_PROPERTY_HREF = "href";
  private String href;

  public static final String JSON_PROPERTY_MULTICAST_GROUP_COUNT = "multicastGroupCount";
  private Integer multicastGroupCount;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_STATE = "state";
  private AppServerState state;

  /**
   * Application server health state: - ACTIVE: the application is up and running
   * - INIT: the application server is in a transient state, for example
   * connection is being established - ERROR: the application server is
   * unreachable - DEACTIVATED: the application server is deactivated
   */
  public enum HealthStateEnum {
    ACTIVE("ACTIVE"),

    INIT("INIT"),

    ERROR("ERROR"),

    DEACTIVATED("DEACTIVATED");

    private String value;

    HealthStateEnum(String value) {
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
    public static HealthStateEnum fromValue(String value) {
      for (HealthStateEnum b : HealthStateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_HEALTH_STATE = "healthState";
  private HealthStateEnum healthState;

  public static final String JSON_PROPERTY_NOTIFICATION = "notification";
  private AppServerKafkaNotification notification;

  public static final String JSON_PROPERTY_TPX_IOT_FLOW = "tpxIotFlow";
  private TpxIotFlow tpxIotFlow;

  /**
   * AS type (&#x60;HTTP&#x60;, &#x60;HTTP_CELLULAR&#x60; or &#x60;KAFKA&#x60;)
   * &#x60;HTTP_CELLULAR&#x60; is only applicable to **ThingPark Wireless** if the
   * cellular connectivity is enabled by the Operator.
   */
  public enum TypeEnum {
    HTTP("HTTP"),

    HTTP_CELLULAR("HTTP_CELLULAR"),

    KAFKA("KAFKA");

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

  public static final String JSON_PROPERTY_VALIDATION_STATE = "validationState";
  private AppServerValidationState validationState;

  public AppServersBriefsInner() {
  }

  public AppServersBriefsInner ID(String ID) {

    this.ID = ID;
    return this;
  }

  /**
   * Get ID
   * 
   * @return ID
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getID() {
    return ID;
  }

  @JsonProperty(JSON_PROPERTY_I_D)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setID(String ID) {
    this.ID = ID;
  }

  public AppServersBriefsInner baseStationCount(Integer baseStationCount) {

    this.baseStationCount = baseStationCount;
    return this;
  }

  /**
   * Number of Base Stations associated with the Application Server through direct
   * association. If the authenticated user has domain restrictions, only base
   * stations matching the domain restrictions are counted.
   * 
   * @return baseStationCount
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BASE_STATION_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getBaseStationCount() {
    return baseStationCount;
  }

  @JsonProperty(JSON_PROPERTY_BASE_STATION_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBaseStationCount(Integer baseStationCount) {
    this.baseStationCount = baseStationCount;
  }

  public AppServersBriefsInner deviceCount(Integer deviceCount) {

    this.deviceCount = deviceCount;
    return this;
  }

  /**
   * Number of Devices associated with the Application Server through direct
   * association. Devices associated with the Application Server through AS
   * Routing Profiles are not taken into account. If the authenticated user has
   * domain restrictions, only devices matching the domain restrictions are
   * counted.
   * 
   * @return deviceCount
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DEVICE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getDeviceCount() {
    return deviceCount;
  }

  @JsonProperty(JSON_PROPERTY_DEVICE_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDeviceCount(Integer deviceCount) {
    this.deviceCount = deviceCount;
  }

  public AppServersBriefsInner domains(List<Domain> domains) {

    this.domains = domains;
    return this;
  }

  public AppServersBriefsInner addDomainsItem(Domain domainsItem) {
    if (this.domains == null) {
      this.domains = new ArrayList<>();
    }
    this.domains.add(domainsItem);
    return this;
  }

  /**
   * List of associated domains. The list cannot contain more than one domain for
   * a given group.
   * 
   * @return domains
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_DOMAINS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Domain> getDomains() {
    return domains;
  }

  @JsonProperty(JSON_PROPERTY_DOMAINS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDomains(List<Domain> domains) {
    this.domains = domains;
  }

  public AppServersBriefsInner href(String href) {

    this.href = href;
    return this;
  }

  /**
   * Application Server HREF
   * 
   * @return href
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHref() {
    return href;
  }

  @JsonProperty(JSON_PROPERTY_HREF)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHref(String href) {
    this.href = href;
  }

  public AppServersBriefsInner multicastGroupCount(Integer multicastGroupCount) {

    this.multicastGroupCount = multicastGroupCount;
    return this;
  }

  /**
   * Number of Multicast Groups associated with the Application Server through
   * direct association. Multicast Groups associated with the Application Server
   * through AS Routing Profiles are not taken into account. If the authenticated
   * user has domain restrictions, only multicast groups matching the domain
   * restrictions are counted.
   * 
   * @return multicastGroupCount
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MULTICAST_GROUP_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getMulticastGroupCount() {
    return multicastGroupCount;
  }

  @JsonProperty(JSON_PROPERTY_MULTICAST_GROUP_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMulticastGroupCount(Integer multicastGroupCount) {
    this.multicastGroupCount = multicastGroupCount;
  }

  public AppServersBriefsInner name(String name) {

    this.name = name;
    return this;
  }

  /**
   * Get name
   * 
   * @return name
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getName() {
    return name;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
  }

  public AppServersBriefsInner state(AppServerState state) {

    this.state = state;
    return this;
  }

  /**
   * Get state
   * 
   * @return state
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AppServerState getState() {
    return state;
  }

  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(AppServerState state) {
    this.state = state;
  }

  public AppServersBriefsInner healthState(HealthStateEnum healthState) {

    this.healthState = healthState;
    return this;
  }

  /**
   * Application server health state: - ACTIVE: the application is up and running
   * - INIT: the application server is in a transient state, for example
   * connection is being established - ERROR: the application server is
   * unreachable - DEACTIVATED: the application server is deactivated
   * 
   * @return healthState
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_HEALTH_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public HealthStateEnum getHealthState() {
    return healthState;
  }

  @JsonProperty(JSON_PROPERTY_HEALTH_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHealthState(HealthStateEnum healthState) {
    this.healthState = healthState;
  }

  public AppServersBriefsInner notification(AppServerKafkaNotification notification) {

    this.notification = notification;
    return this;
  }

  /**
   * Get notification
   * 
   * @return notification
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_NOTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public AppServerKafkaNotification getNotification() {
    return notification;
  }

  @JsonProperty(JSON_PROPERTY_NOTIFICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotification(AppServerKafkaNotification notification) {
    this.notification = notification;
  }

  public AppServersBriefsInner tpxIotFlow(TpxIotFlow tpxIotFlow) {

    this.tpxIotFlow = tpxIotFlow;
    return this;
  }

  /**
   * Get tpxIotFlow
   * 
   * @return tpxIotFlow
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TPX_IOT_FLOW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TpxIotFlow getTpxIotFlow() {
    return tpxIotFlow;
  }

  @JsonProperty(JSON_PROPERTY_TPX_IOT_FLOW)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTpxIotFlow(TpxIotFlow tpxIotFlow) {
    this.tpxIotFlow = tpxIotFlow;
  }

  public AppServersBriefsInner type(TypeEnum type) {

    this.type = type;
    return this;
  }

  /**
   * AS type (&#x60;HTTP&#x60;, &#x60;HTTP_CELLULAR&#x60; or &#x60;KAFKA&#x60;)
   * &#x60;HTTP_CELLULAR&#x60; is only applicable to **ThingPark Wireless** if the
   * cellular connectivity is enabled by the Operator.
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

  public AppServersBriefsInner validationState(AppServerValidationState validationState) {

    this.validationState = validationState;
    return this;
  }

  /**
   * Get validationState
   * 
   * @return validationState
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_VALIDATION_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public AppServerValidationState getValidationState() {
    return validationState;
  }

  @JsonProperty(JSON_PROPERTY_VALIDATION_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidationState(AppServerValidationState validationState) {
    this.validationState = validationState;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppServersBriefsInner appServersBriefsInner = (AppServersBriefsInner) o;
    return Objects.equals(this.ID, appServersBriefsInner.ID)
            && Objects.equals(this.baseStationCount, appServersBriefsInner.baseStationCount)
            && Objects.equals(this.deviceCount, appServersBriefsInner.deviceCount)
            && Objects.equals(this.domains, appServersBriefsInner.domains)
            && Objects.equals(this.href, appServersBriefsInner.href)
            && Objects.equals(this.multicastGroupCount, appServersBriefsInner.multicastGroupCount)
            && Objects.equals(this.name, appServersBriefsInner.name)
            && Objects.equals(this.state, appServersBriefsInner.state)
            && Objects.equals(this.healthState, appServersBriefsInner.healthState)
            && Objects.equals(this.notification, appServersBriefsInner.notification)
            && Objects.equals(this.tpxIotFlow, appServersBriefsInner.tpxIotFlow)
            && Objects.equals(this.type, appServersBriefsInner.type)
            && Objects.equals(this.validationState, appServersBriefsInner.validationState);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, baseStationCount, deviceCount, domains, href, multicastGroupCount, name, state, healthState,
            notification, tpxIotFlow, type, validationState);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppServersBriefsInner {\n");
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    baseStationCount: ").append(toIndentedString(baseStationCount)).append("\n");
    sb.append("    deviceCount: ").append(toIndentedString(deviceCount)).append("\n");
    sb.append("    domains: ").append(toIndentedString(domains)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    multicastGroupCount: ").append(toIndentedString(multicastGroupCount)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    healthState: ").append(toIndentedString(healthState)).append("\n");
    sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
    sb.append("    tpxIotFlow: ").append(toIndentedString(tpxIotFlow)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validationState: ").append(toIndentedString(validationState)).append("\n");
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
