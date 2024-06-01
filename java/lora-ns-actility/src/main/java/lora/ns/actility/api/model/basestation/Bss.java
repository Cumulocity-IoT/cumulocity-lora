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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Bss
 */
@JsonPropertyOrder({ Bss.JSON_PROPERTY_BRIEFS, Bss.JSON_PROPERTY_MORE, Bss.JSON_PROPERTY_NOW, Bss.JSON_PROPERTY_COUNT })
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-05-31T16:08:44.630492043+02:00[Europe/Paris]", comments = "Generator version: 7.6.0")
public class Bss {
  public static final String JSON_PROPERTY_BRIEFS = "briefs";
  private List<BsBrief> briefs = new ArrayList<>();

  public static final String JSON_PROPERTY_MORE = "more";
  private Boolean more;

  public static final String JSON_PROPERTY_NOW = "now";
  private Long now;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public Bss() {
  }

  public Bss briefs(List<BsBrief> briefs) {

    this.briefs = briefs;
    return this;
  }

  public Bss addBriefsItem(BsBrief briefsItem) {
    if (this.briefs == null) {
      this.briefs = new ArrayList<>();
    }
    this.briefs.add(briefsItem);
    return this;
  }

  /**
   * Get briefs
   * 
   * @return briefs
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_BRIEFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<BsBrief> getBriefs() {
    return briefs;
  }

  @JsonProperty(JSON_PROPERTY_BRIEFS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBriefs(List<BsBrief> briefs) {
    this.briefs = briefs;
  }

  public Bss more(Boolean more) {

    this.more = more;
    return this;
  }

  /**
   * *TRUE when more briefs can be retrieved with an upper page index.*
   * 
   * @return more
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_MORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getMore() {
    return more;
  }

  @JsonProperty(JSON_PROPERTY_MORE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMore(Boolean more) {
    this.more = more;
  }

  public Bss now(Long now) {

    this.now = now;
    return this;
  }

  /**
   * Current time of the server, epoch time in milliseconds
   * 
   * @return now
   **/
  @javax.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_NOW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNow() {
    return now;
  }

  @JsonProperty(JSON_PROPERTY_NOW)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNow(Long now) {
    this.now = now;
  }

  public Bss count(Integer count) {

    this.count = count;
    return this;
  }

  /**
   * Total number of matching base stations
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bss bss = (Bss) o;
    return Objects.equals(this.briefs, bss.briefs) && Objects.equals(this.more, bss.more)
            && Objects.equals(this.now, bss.now) && Objects.equals(this.count, bss.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(briefs, more, now, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bss {\n");
    sb.append("    briefs: ").append(toIndentedString(briefs)).append("\n");
    sb.append("    more: ").append(toIndentedString(more)).append("\n");
    sb.append("    now: ").append(toIndentedString(now)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
