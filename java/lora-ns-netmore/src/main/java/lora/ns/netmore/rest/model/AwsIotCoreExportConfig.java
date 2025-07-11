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
 * AwsIotCoreExportConfig
 */
@JsonPropertyOrder({
  AwsIotCoreExportConfig.JSON_PROPERTY_URL,
  AwsIotCoreExportConfig.JSON_PROPERTY_TOPIC,
  AwsIotCoreExportConfig.JSON_PROPERTY_CA,
  AwsIotCoreExportConfig.JSON_PROPERTY_CERT,
  AwsIotCoreExportConfig.JSON_PROPERTY_KEY
})
public class AwsIotCoreExportConfig {
  public static final String JSON_PROPERTY_URL = "url";
  private String url;

  public static final String JSON_PROPERTY_TOPIC = "topic";
  private String topic;

  public static final String JSON_PROPERTY_CA = "ca";
  private String ca;

  public static final String JSON_PROPERTY_CERT = "cert";
  private String cert;

  public static final String JSON_PROPERTY_KEY = "key";
  private String key;

  public AwsIotCoreExportConfig() {
  }

  public AwsIotCoreExportConfig url(String url) {
    
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


  public AwsIotCoreExportConfig topic(String topic) {
    
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


  public AwsIotCoreExportConfig ca(String ca) {
    
    this.ca = ca;
    return this;
  }

   /**
   * Get ca
   * @return ca
  **/

  @JsonProperty(JSON_PROPERTY_CA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCa() {
    return ca;
  }


  @JsonProperty(JSON_PROPERTY_CA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCa(String ca) {
    this.ca = ca;
  }


  public AwsIotCoreExportConfig cert(String cert) {
    
    this.cert = cert;
    return this;
  }

   /**
   * Get cert
   * @return cert
  **/

  @JsonProperty(JSON_PROPERTY_CERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCert() {
    return cert;
  }


  @JsonProperty(JSON_PROPERTY_CERT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCert(String cert) {
    this.cert = cert;
  }


  public AwsIotCoreExportConfig key(String key) {
    
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/

  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getKey() {
    return key;
  }


  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setKey(String key) {
    this.key = key;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwsIotCoreExportConfig awsIotCoreExportConfig = (AwsIotCoreExportConfig) o;
    return Objects.equals(this.url, awsIotCoreExportConfig.url) &&
        Objects.equals(this.topic, awsIotCoreExportConfig.topic) &&
        Objects.equals(this.ca, awsIotCoreExportConfig.ca) &&
        Objects.equals(this.cert, awsIotCoreExportConfig.cert) &&
        Objects.equals(this.key, awsIotCoreExportConfig.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, topic, ca, cert, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwsIotCoreExportConfig {\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    topic: ").append(toIndentedString(topic)).append("\n");
    sb.append("    ca: ").append(toIndentedString(ca)).append("\n");
    sb.append("    cert: ").append(toIndentedString(cert)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

