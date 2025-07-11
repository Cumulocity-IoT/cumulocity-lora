/*
 * netmore-web-backend
 * Front end for web services.
 *
 * The version of the OpenAPI document: 1.2.83
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package lora.ns.netmore.rest.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * AzureExportConfig
 */
@JsonPropertyOrder({
  AzureExportConfig.JSON_PROPERTY_URL,
  AzureExportConfig.JSON_PROPERTY_TOPIC,
  AzureExportConfig.JSON_PROPERTY_SHARED_ACCESS_KEY,
  AzureExportConfig.JSON_PROPERTY_SHARED_ACCESS_KEY_NAME
})
public class AzureExportConfig {
  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TOPIC = "topic";
  private String topic;

  public static final String JSON_PROPERTY_SHARED_ACCESS_KEY = "sharedAccessKey";
  private String sharedAccessKey;

  public static final String JSON_PROPERTY_SHARED_ACCESS_KEY_NAME = "sharedAccessKeyName";
  private String sharedAccessKeyName;

  public AzureExportConfig() {
  }

  public AzureExportConfig url(String url) {
    
    this.url = url;
    return this;
  }

   /**
   * Get url
   * @return url
  **/

  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUrl() {
    return url;
  }


  @JsonProperty(JSON_PROPERTY_URL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUrl(String url) {
    this.url = url;
  }


  public AzureExportConfig topic(String topic) {
    
    this.topic = topic;
    return this;
  }

   /**
   * Get topic
   * @return topic
  **/

  @JsonProperty(JSON_PROPERTY_TOPIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTopic() {
    return topic;
  }


  @JsonProperty(JSON_PROPERTY_TOPIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTopic(String topic) {
    this.topic = topic;
  }


  public AzureExportConfig sharedAccessKey(String sharedAccessKey) {
    
    this.sharedAccessKey = sharedAccessKey;
    return this;
  }

   /**
   * Get sharedAccessKey
   * @return sharedAccessKey
  **/

  @JsonProperty(JSON_PROPERTY_SHARED_ACCESS_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSharedAccessKey() {
    return sharedAccessKey;
  }


  @JsonProperty(JSON_PROPERTY_SHARED_ACCESS_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSharedAccessKey(String sharedAccessKey) {
    this.sharedAccessKey = sharedAccessKey;
  }


  public AzureExportConfig sharedAccessKeyName(String sharedAccessKeyName) {
    
    this.sharedAccessKeyName = sharedAccessKeyName;
    return this;
  }

   /**
   * Get sharedAccessKeyName
   * @return sharedAccessKeyName
  **/

  @JsonProperty(JSON_PROPERTY_SHARED_ACCESS_KEY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSharedAccessKeyName() {
    return sharedAccessKeyName;
  }


  @JsonProperty(JSON_PROPERTY_SHARED_ACCESS_KEY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSharedAccessKeyName(String sharedAccessKeyName) {
    this.sharedAccessKeyName = sharedAccessKeyName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureExportConfig azureExportConfig = (AzureExportConfig) o;
    return Objects.equals(this.url, azureExportConfig.url) &&
        Objects.equals(this.topic, azureExportConfig.topic) &&
        Objects.equals(this.sharedAccessKey, azureExportConfig.sharedAccessKey) &&
        Objects.equals(this.sharedAccessKeyName, azureExportConfig.sharedAccessKeyName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, topic, sharedAccessKey, sharedAccessKeyName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureExportConfig {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    sharedAccessKey: ").append(toIndentedString(sharedAccessKey)).append("\n");
    sb.append("    sharedAccessKeyName: ").append(toIndentedString(sharedAccessKeyName)).append("\n");
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

