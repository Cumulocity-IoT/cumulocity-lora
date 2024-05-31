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
 * BsLog
 */
@JsonPropertyOrder({ BsLog.JSON_PROPERTY_RAM_DIR_USED, BsLog.JSON_PROPERTY_TRACE_LEVEL,
    BsLog.JSON_PROPERTY_TRACE_SINCE })
@JsonTypeName("Bs_log")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BsLog {
  public static final String JSON_PROPERTY_RAM_DIR_USED = "ramDirUsed";
  private Boolean ramDirUsed;

  public static final String JSON_PROPERTY_TRACE_LEVEL = "traceLevel";
  private Integer traceLevel;

  public static final String JSON_PROPERTY_TRACE_SINCE = "traceSince";
  private Long traceSince;

  public BsLog() {
  }

  public BsLog ramDirUsed(Boolean ramDirUsed) {

    this.ramDirUsed = ramDirUsed;
    return this;
  }

  /**
   * TRUE when RAM disk is used for logging
   * 
   * @return ramDirUsed
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RAM_DIR_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getRamDirUsed() {
    return ramDirUsed;
  }

  @JsonProperty(JSON_PROPERTY_RAM_DIR_USED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRamDirUsed(Boolean ramDirUsed) {
    this.ramDirUsed = ramDirUsed;
  }

  public BsLog traceLevel(Integer traceLevel) {

    this.traceLevel = traceLevel;
    return this;
  }

  /**
   * LRR trace level (0..3). 0 means no trace.
   * 
   * @return traceLevel
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRACE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getTraceLevel() {
    return traceLevel;
  }

  @JsonProperty(JSON_PROPERTY_TRACE_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTraceLevel(Integer traceLevel) {
    this.traceLevel = traceLevel;
  }

  public BsLog traceSince(Long traceSince) {

    this.traceSince = traceSince;
    return this;
  }

  /**
   * LRR trace activated (1..3) or deactivated (0) since timestamp, epoch time in
   * milliseconds.
   * 
   * @return traceSince
   **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_TRACE_SINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Long getTraceSince() {
    return traceSince;
  }

  @JsonProperty(JSON_PROPERTY_TRACE_SINCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTraceSince(Long traceSince) {
    this.traceSince = traceSince;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BsLog bsLog = (BsLog) o;
    return Objects.equals(this.ramDirUsed, bsLog.ramDirUsed) && Objects.equals(this.traceLevel, bsLog.traceLevel)
            && Objects.equals(this.traceSince, bsLog.traceSince);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ramDirUsed, traceLevel, traceSince);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BsLog {\n");
    sb.append("    ramDirUsed: ").append(toIndentedString(ramDirUsed)).append("\n");
    sb.append("    traceLevel: ").append(toIndentedString(traceLevel)).append("\n");
    sb.append("    traceSince: ").append(toIndentedString(traceSince)).append("\n");
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
