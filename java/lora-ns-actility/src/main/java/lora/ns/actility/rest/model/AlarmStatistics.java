/*
 * ThingPark Enterprise - Dx-Core API
 * API providing configuration and provisioning features for ThingPark Enterprise.
 *
 * OpenAPI spec version: 1.8.1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package lora.ns.actility.rest.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Resource representing a set of statistics related to alarms.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlarmStatistics {
  private Integer nonAckedClearedCount = null;

  private Integer nonAckedUnclearedCount = null;

  private Integer nonAckedWarningCount = null;

  private Integer nonAckedMinorCount = null;

  private Integer nonAckedMajorCount = null;

  private Integer nonAckedCriticalCount = null;

  private Integer nonAckedIndeterminateCount = null;

  public AlarmStatistics nonAckedClearedCount(Integer nonAckedClearedCount) {
    this.nonAckedClearedCount = nonAckedClearedCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the CLEARED state.
   * 
   * @return nonAckedClearedCount
   **/
  public Integer getNonAckedClearedCount() {
    return nonAckedClearedCount;
  }

  public void setNonAckedClearedCount(Integer nonAckedClearedCount) {
    this.nonAckedClearedCount = nonAckedClearedCount;
  }

  public AlarmStatistics nonAckedUnclearedCount(Integer nonAckedUnclearedCount) {
    this.nonAckedUnclearedCount = nonAckedUnclearedCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the UNCLEARED state.
   * 
   * @return nonAckedUnclearedCount
   **/
  public Integer getNonAckedUnclearedCount() {
    return nonAckedUnclearedCount;
  }

  public void setNonAckedUnclearedCount(Integer nonAckedUnclearedCount) {
    this.nonAckedUnclearedCount = nonAckedUnclearedCount;
  }

  public AlarmStatistics nonAckedWarningCount(Integer nonAckedWarningCount) {
    this.nonAckedWarningCount = nonAckedWarningCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the WARNING state.
   * 
   * @return nonAckedWarningCount
   **/
  public Integer getNonAckedWarningCount() {
    return nonAckedWarningCount;
  }

  public void setNonAckedWarningCount(Integer nonAckedWarningCount) {
    this.nonAckedWarningCount = nonAckedWarningCount;
  }

  public AlarmStatistics nonAckedMinorCount(Integer nonAckedMinorCount) {
    this.nonAckedMinorCount = nonAckedMinorCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the MINOR state.
   * 
   * @return nonAckedMinorCount
   **/
  public Integer getNonAckedMinorCount() {
    return nonAckedMinorCount;
  }

  public void setNonAckedMinorCount(Integer nonAckedMinorCount) {
    this.nonAckedMinorCount = nonAckedMinorCount;
  }

  public AlarmStatistics nonAckedMajorCount(Integer nonAckedMajorCount) {
    this.nonAckedMajorCount = nonAckedMajorCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the MAJOR state.
   * 
   * @return nonAckedMajorCount
   **/
  public Integer getNonAckedMajorCount() {
    return nonAckedMajorCount;
  }

  public void setNonAckedMajorCount(Integer nonAckedMajorCount) {
    this.nonAckedMajorCount = nonAckedMajorCount;
  }

  public AlarmStatistics nonAckedCriticalCount(Integer nonAckedCriticalCount) {
    this.nonAckedCriticalCount = nonAckedCriticalCount;
    return this;
  }

  /**
   * Number of non-acked alarms with the CRITICAL state.
   * 
   * @return nonAckedCriticalCount
   **/
  public Integer getNonAckedCriticalCount() {
    return nonAckedCriticalCount;
  }

  public void setNonAckedCriticalCount(Integer nonAckedCriticalCount) {
    this.nonAckedCriticalCount = nonAckedCriticalCount;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlarmStatistics alarmStatistics = (AlarmStatistics) o;
    return Objects.equals(this.nonAckedClearedCount, alarmStatistics.nonAckedClearedCount)
            && Objects.equals(this.nonAckedUnclearedCount, alarmStatistics.nonAckedUnclearedCount)
            && Objects.equals(this.nonAckedWarningCount, alarmStatistics.nonAckedWarningCount)
            && Objects.equals(this.nonAckedMinorCount, alarmStatistics.nonAckedMinorCount)
            && Objects.equals(this.nonAckedMajorCount, alarmStatistics.nonAckedMajorCount)
            && Objects.equals(this.nonAckedCriticalCount, alarmStatistics.nonAckedCriticalCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nonAckedClearedCount, nonAckedUnclearedCount, nonAckedWarningCount, nonAckedMinorCount,
            nonAckedMajorCount, nonAckedCriticalCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmStatistics {\n");

    sb.append("    nonAckedClearedCount: ").append(toIndentedString(nonAckedClearedCount)).append("\n");
    sb.append("    nonAckedUnclearedCount: ").append(toIndentedString(nonAckedUnclearedCount)).append("\n");
    sb.append("    nonAckedWarningCount: ").append(toIndentedString(nonAckedWarningCount)).append("\n");
    sb.append("    nonAckedMinorCount: ").append(toIndentedString(nonAckedMinorCount)).append("\n");
    sb.append("    nonAckedMajorCount: ").append(toIndentedString(nonAckedMajorCount)).append("\n");
    sb.append("    nonAckedCriticalCount: ").append(toIndentedString(nonAckedCriticalCount)).append("\n");
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

  public Integer getNonAckedIndeterminateCount() {
    return nonAckedIndeterminateCount;
  }

  public void setNonAckedIndeterminateCount(Integer nonAckedIndeterminateCount) {
    this.nonAckedIndeterminateCount = nonAckedIndeterminateCount;
  }

}
