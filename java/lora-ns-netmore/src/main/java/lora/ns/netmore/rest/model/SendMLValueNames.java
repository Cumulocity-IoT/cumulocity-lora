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
 * Gets or Sets SendMLValueNames
 */
public enum SendMLValueNames {
  
  BINARY("binary"),
  
  TEMPERATURE("temperature"),
  
  HUMIDITY("humidity"),
  
  UNSPECIFIED("unspecified"),
  
  JSON("json"),
  
  RANGE("range"),
  
  WEIGHT("weight"),
  
  LUMINOSITY("luminosity"),
  
  FREQUENCY("frequency"),
  
  ANGLE("angle"),
  
  FORCE("force"),
  
  PRESSURE("pressure"),
  
  ENERGY("energy"),
  
  POWER("power"),
  
  LUMEN("lumen"),
  
  VELOCITY("velocity"),
  
  ACCELERATION("acceleration"),
  
  LIGHT("light"),
  
  RAW("raw"),
  
  TILT("tilt"),
  
  VIBRATION("vibration"),
  
  BATTERY("battery"),
  
  BATTERYPERCENTAGE("batteryPercentage"),
  
  BATTERYLOW("batteryLow"),
  
  VDD("vdd"),
  
  CONNECTED("connected"),
  
  RELAY("relay"),
  
  BUTTON("button"),
  
  DIMMER("dimmer"),
  
  USAGE("usage"),
  
  FREEDISK("freedisk"),
  
  CO2("co2"),
  
  MOTION("motion"),
  
  ERROR("error"),
  
  TVOC("tvoc"),
  
  TAGS("tags"),
  
  LATITUDE("latitude"),
  
  LONGITUDE("longitude"),
  
  ALTITUDE("altitude"),
  
  ACCURACY("accuracy"),
  
  ANTENNAS("antennas"),
  
  SPEED("speed"),
  
  VOLUME("volume"),
  
  DOORSTATE("doorState");

  private String value;

  SendMLValueNames(String value) {
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
  public static SendMLValueNames fromValue(String value) {
    for (SendMLValueNames b : SendMLValueNames.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

