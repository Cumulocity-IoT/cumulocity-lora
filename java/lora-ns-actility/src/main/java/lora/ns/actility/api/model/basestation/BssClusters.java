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

import lora.ns.actility.api.model.basestation.BssClustersClustersInner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * BssClusters
 */
@JsonPropertyOrder({ BssClusters.JSON_PROPERTY_COUNT, BssClusters.JSON_PROPERTY_CLUSTERS })
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class BssClusters {
  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_CLUSTERS = "clusters";
  private List<BssClustersClustersInner> clusters = new ArrayList<>();

  public BssClusters() {
  }

  public BssClusters count(Integer count) {

    this.count = count;
    return this;
  }

  /**
   * Total number of base stations in the bounding box
   * 
   * @return count
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getCount() {
    return count;
  }

  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCount(Integer count) {
    this.count = count;
  }

  public BssClusters clusters(List<BssClustersClustersInner> clusters) {

    this.clusters = clusters;
    return this;
  }

  public BssClusters addClustersItem(BssClustersClustersInner clustersItem) {
    if (this.clusters == null) {
      this.clusters = new ArrayList<>();
    }
    this.clusters.add(clustersItem);
    return this;
  }

  /**
   * Get clusters
   * 
   * @return clusters
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CLUSTERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<BssClustersClustersInner> getClusters() {
    return clusters;
  }

  @JsonProperty(JSON_PROPERTY_CLUSTERS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setClusters(List<BssClustersClustersInner> clusters) {
    this.clusters = clusters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BssClusters bssClusters = (BssClusters) o;
    return Objects.equals(this.count, bssClusters.count) && Objects.equals(this.clusters, bssClusters.clusters);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, clusters);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BssClusters {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    clusters: ").append(toIndentedString(clusters)).append("\n");
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