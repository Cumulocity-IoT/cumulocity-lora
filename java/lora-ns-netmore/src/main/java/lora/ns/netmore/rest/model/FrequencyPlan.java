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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets FrequencyPlan
 */
public enum FrequencyPlan {
  
  AS923_1_8CH_922_0MHZ("AS923_1_8CH_922_0MHZ"),
  
  AS923_1_8CH_923_2MHZ("AS923_1_8CH_923_2MHZ"),
  
  AS923_1_16CH_920_6MHZ("AS923_1_16CH_920_6MHZ"),
  
  AS923_1_16CH_921_6MHZ("AS923_1_16CH_921_6MHZ"),
  
  AS923_2_8CH_921_4MHZ("AS923_2_8CH_921_4MHZ"),
  
  AS923_3_8CH_916_4MHZ("AS923_3_8CH_916_4MHZ"),
  
  AS923_4_8CH_917_3MHZ("AS923_4_8CH_917_3MHZ"),
  
  AU915_8CH("AU915_8CH"),
  
  AU915_16CH("AU915_16CH"),
  
  AU915_64CH("AU915_64CH"),
  
  EU868_1_8CH_867_1MHZ("EU868_1_8CH_867_1MHZ"),
  
  EU868_2_8CH_867_1MHZ("EU868_2_8CH_867_1MHZ"),
  
  EU868_3_8CH_866_5MHZ("EU868_3_8CH_866_5MHZ"),
  
  EU868_4_5CH_869_1MHZ("EU868_4_5CH_869_1MHZ"),
  
  IN865_8CH("IN865_8CH"),
  
  LA915_8CH_915_2MHZ("LA915_8CH_915_2MHZ"),
  
  LA915_16CH_915_2MHZ("LA915_16CH_915_2MHZ"),
  
  US915_8CH_903_9MHZ("US915_8CH_903_9MHZ"),
  
  US915_16CH_902_3MHZ("US915_16CH_902_3MHZ"),
  
  US915_64CH_902_3MHZ("US915_64CH_902_3MHZ"),
  
  ROAMING("ROAMING");

  private String value;

  FrequencyPlan(String value) {
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
  public static FrequencyPlan fromValue(String value) {
    for (FrequencyPlan b : FrequencyPlan.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

