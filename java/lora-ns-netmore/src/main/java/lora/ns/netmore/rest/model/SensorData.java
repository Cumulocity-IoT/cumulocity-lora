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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lora.ns.netmore.rest.model.SensorDataGatewayData;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SensorData
 */
@JsonPropertyOrder({
  SensorData.JSON_PROPERTY_DEV_EUI,
  SensorData.JSON_PROPERTY_PAYLOAD_HEX,
  SensorData.JSON_PROPERTY_ENC_PAYLOAD_HEX,
  SensorData.JSON_PROPERTY_SESSION_KEY_ID,
  SensorData.JSON_PROPERTY_COMM_TIMESTAMP,
  SensorData.JSON_PROPERTY_RSSI,
  SensorData.JSON_PROPERTY_SNR,
  SensorData.JSON_PROPERTY_SP_FACT,
  SensorData.JSON_PROPERTY_ADR_SP_FACT,
  SensorData.JSON_PROPERTY_F_PORT,
  SensorData.JSON_PROPERTY_F_CNT_UP,
  SensorData.JSON_PROPERTY_BATTERY_LEVEL,
  SensorData.JSON_PROPERTY_GATEWAY_IDENTIFIER,
  SensorData.JSON_PROPERTY_GW_EUI,
  SensorData.JSON_PROPERTY_ID_GATEWAY,
  SensorData.JSON_PROPERTY_ERROR_RATE,
  SensorData.JSON_PROPERTY_GATEWAYS,
  SensorData.JSON_PROPERTY_FREQ,
  SensorData.JSON_PROPERTY_TOA,
  SensorData.JSON_PROPERTY_ACK,
  SensorData.JSON_PROPERTY_OFFLINE,
  SensorData.JSON_PROPERTY_DR,
  SensorData.JSON_PROPERTY_LATITUDE,
  SensorData.JSON_PROPERTY_LONGITUDE,
  SensorData.JSON_PROPERTY_ACCURACY,
  SensorData.JSON_PROPERTY_APP_EUI,
  SensorData.JSON_PROPERTY_DEV_ADDR
})
public class SensorData {
  public static final String JSON_PROPERTY_DEV_EUI = "devEui";
  private String devEui;

  public static final String JSON_PROPERTY_PAYLOAD_HEX = "payloadHex";
  private String payloadHex;

  public static final String JSON_PROPERTY_ENC_PAYLOAD_HEX = "encPayloadHex";
  private String encPayloadHex;

  public static final String JSON_PROPERTY_SESSION_KEY_ID = "sessionKeyId";
  private String sessionKeyId;

  public static final String JSON_PROPERTY_COMM_TIMESTAMP = "commTimestamp";
  private String commTimestamp;

  public static final String JSON_PROPERTY_RSSI = "rssi";
  private String rssi;

  public static final String JSON_PROPERTY_SNR = "snr";
  private String snr;

  public static final String JSON_PROPERTY_SP_FACT = "spFact";
  private String spFact;

  public static final String JSON_PROPERTY_ADR_SP_FACT = "adrSpFact";
  private String adrSpFact;

  public static final String JSON_PROPERTY_F_PORT = "fPort";
  private String fPort;

  public static final String JSON_PROPERTY_F_CNT_UP = "fCntUp";
  private Double fCntUp;

  public static final String JSON_PROPERTY_BATTERY_LEVEL = "batteryLevel";
  private String batteryLevel;

  public static final String JSON_PROPERTY_GATEWAY_IDENTIFIER = "gatewayIdentifier";
  private String gatewayIdentifier;

  public static final String JSON_PROPERTY_GW_EUI = "gwEui";
  private String gwEui;

  public static final String JSON_PROPERTY_ID_GATEWAY = "idGateway";
  private Double idGateway;

  public static final String JSON_PROPERTY_ERROR_RATE = "errorRate";
  private Double errorRate;

  public static final String JSON_PROPERTY_GATEWAYS = "gateways";
  private List<SensorDataGatewayData> gateways;

  public static final String JSON_PROPERTY_FREQ = "freq";
  private Double freq;

  public static final String JSON_PROPERTY_TOA = "toa";
  private Double toa;

  public static final String JSON_PROPERTY_ACK = "ack";
  private Boolean ack;

  public static final String JSON_PROPERTY_OFFLINE = "offline";
  private Boolean offline;

  public static final String JSON_PROPERTY_DR = "dr";
  private Double dr;

  public static final String JSON_PROPERTY_LATITUDE = "latitude";
  private Double latitude;

  public static final String JSON_PROPERTY_LONGITUDE = "longitude";
  private Double longitude;

  public static final String JSON_PROPERTY_ACCURACY = "accuracy";
  private Double accuracy;

  public static final String JSON_PROPERTY_APP_EUI = "appEui";
  private String appEui;

  public static final String JSON_PROPERTY_DEV_ADDR = "devAddr";
  private String devAddr;

  public SensorData() {
  }

  public SensorData devEui(String devEui) {
    
    this.devEui = devEui;
    return this;
  }

   /**
   * Get devEui
   * @return devEui
  **/

  @JsonProperty(JSON_PROPERTY_DEV_EUI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getDevEui() {
    return devEui;
  }


  @JsonProperty(JSON_PROPERTY_DEV_EUI)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDevEui(String devEui) {
    this.devEui = devEui;
  }


  public SensorData payloadHex(String payloadHex) {
    
    this.payloadHex = payloadHex;
    return this;
  }

   /**
   * Get payloadHex
   * @return payloadHex
  **/

  @JsonProperty(JSON_PROPERTY_PAYLOAD_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPayloadHex() {
    return payloadHex;
  }


  @JsonProperty(JSON_PROPERTY_PAYLOAD_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayloadHex(String payloadHex) {
    this.payloadHex = payloadHex;
  }


  public SensorData encPayloadHex(String encPayloadHex) {
    
    this.encPayloadHex = encPayloadHex;
    return this;
  }

   /**
   * Get encPayloadHex
   * @return encPayloadHex
  **/

  @JsonProperty(JSON_PROPERTY_ENC_PAYLOAD_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getEncPayloadHex() {
    return encPayloadHex;
  }


  @JsonProperty(JSON_PROPERTY_ENC_PAYLOAD_HEX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEncPayloadHex(String encPayloadHex) {
    this.encPayloadHex = encPayloadHex;
  }


  public SensorData sessionKeyId(String sessionKeyId) {
    
    this.sessionKeyId = sessionKeyId;
    return this;
  }

   /**
   * Get sessionKeyId
   * @return sessionKeyId
  **/

  @JsonProperty(JSON_PROPERTY_SESSION_KEY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSessionKeyId() {
    return sessionKeyId;
  }


  @JsonProperty(JSON_PROPERTY_SESSION_KEY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSessionKeyId(String sessionKeyId) {
    this.sessionKeyId = sessionKeyId;
  }


  public SensorData commTimestamp(String commTimestamp) {
    
    this.commTimestamp = commTimestamp;
    return this;
  }

   /**
   * Get commTimestamp
   * @return commTimestamp
  **/

  @JsonProperty(JSON_PROPERTY_COMM_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCommTimestamp() {
    return commTimestamp;
  }


  @JsonProperty(JSON_PROPERTY_COMM_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCommTimestamp(String commTimestamp) {
    this.commTimestamp = commTimestamp;
  }


  public SensorData rssi(String rssi) {
    
    this.rssi = rssi;
    return this;
  }

   /**
   * Get rssi
   * @return rssi
  **/

  @JsonProperty(JSON_PROPERTY_RSSI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRssi() {
    return rssi;
  }


  @JsonProperty(JSON_PROPERTY_RSSI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRssi(String rssi) {
    this.rssi = rssi;
  }


  public SensorData snr(String snr) {
    
    this.snr = snr;
    return this;
  }

   /**
   * Get snr
   * @return snr
  **/

  @JsonProperty(JSON_PROPERTY_SNR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSnr() {
    return snr;
  }


  @JsonProperty(JSON_PROPERTY_SNR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSnr(String snr) {
    this.snr = snr;
  }


  public SensorData spFact(String spFact) {
    
    this.spFact = spFact;
    return this;
  }

   /**
   * Get spFact
   * @return spFact
  **/

  @JsonProperty(JSON_PROPERTY_SP_FACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSpFact() {
    return spFact;
  }


  @JsonProperty(JSON_PROPERTY_SP_FACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSpFact(String spFact) {
    this.spFact = spFact;
  }


  public SensorData adrSpFact(String adrSpFact) {
    
    this.adrSpFact = adrSpFact;
    return this;
  }

   /**
   * Get adrSpFact
   * @return adrSpFact
  **/

  @JsonProperty(JSON_PROPERTY_ADR_SP_FACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAdrSpFact() {
    return adrSpFact;
  }


  @JsonProperty(JSON_PROPERTY_ADR_SP_FACT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdrSpFact(String adrSpFact) {
    this.adrSpFact = adrSpFact;
  }


  public SensorData fPort(String fPort) {
    
    this.fPort = fPort;
    return this;
  }

   /**
   * Get fPort
   * @return fPort
  **/

  @JsonProperty(JSON_PROPERTY_F_PORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getfPort() {
    return fPort;
  }


  @JsonProperty(JSON_PROPERTY_F_PORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setfPort(String fPort) {
    this.fPort = fPort;
  }


  public SensorData fCntUp(Double fCntUp) {
    
    this.fCntUp = fCntUp;
    return this;
  }

   /**
   * Get fCntUp
   * @return fCntUp
  **/

  @JsonProperty(JSON_PROPERTY_F_CNT_UP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getfCntUp() {
    return fCntUp;
  }


  @JsonProperty(JSON_PROPERTY_F_CNT_UP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setfCntUp(Double fCntUp) {
    this.fCntUp = fCntUp;
  }


  public SensorData batteryLevel(String batteryLevel) {
    
    this.batteryLevel = batteryLevel;
    return this;
  }

   /**
   * Get batteryLevel
   * @return batteryLevel
  **/

  @JsonProperty(JSON_PROPERTY_BATTERY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getBatteryLevel() {
    return batteryLevel;
  }


  @JsonProperty(JSON_PROPERTY_BATTERY_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBatteryLevel(String batteryLevel) {
    this.batteryLevel = batteryLevel;
  }


  public SensorData gatewayIdentifier(String gatewayIdentifier) {
    
    this.gatewayIdentifier = gatewayIdentifier;
    return this;
  }

   /**
   * Get gatewayIdentifier
   * @return gatewayIdentifier
  **/

  @JsonProperty(JSON_PROPERTY_GATEWAY_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGatewayIdentifier() {
    return gatewayIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_GATEWAY_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGatewayIdentifier(String gatewayIdentifier) {
    this.gatewayIdentifier = gatewayIdentifier;
  }


  public SensorData gwEui(String gwEui) {
    
    this.gwEui = gwEui;
    return this;
  }

   /**
   * Get gwEui
   * @return gwEui
  **/

  @JsonProperty(JSON_PROPERTY_GW_EUI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGwEui() {
    return gwEui;
  }


  @JsonProperty(JSON_PROPERTY_GW_EUI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGwEui(String gwEui) {
    this.gwEui = gwEui;
  }


  public SensorData idGateway(Double idGateway) {
    
    this.idGateway = idGateway;
    return this;
  }

   /**
   * Get idGateway
   * @return idGateway
  **/

  @JsonProperty(JSON_PROPERTY_ID_GATEWAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getIdGateway() {
    return idGateway;
  }


  @JsonProperty(JSON_PROPERTY_ID_GATEWAY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIdGateway(Double idGateway) {
    this.idGateway = idGateway;
  }


  public SensorData errorRate(Double errorRate) {
    
    this.errorRate = errorRate;
    return this;
  }

   /**
   * Get errorRate
   * @return errorRate
  **/

  @JsonProperty(JSON_PROPERTY_ERROR_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getErrorRate() {
    return errorRate;
  }


  @JsonProperty(JSON_PROPERTY_ERROR_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorRate(Double errorRate) {
    this.errorRate = errorRate;
  }


  public SensorData gateways(List<SensorDataGatewayData> gateways) {
    
    this.gateways = gateways;
    return this;
  }

  public SensorData addGatewaysItem(SensorDataGatewayData gatewaysItem) {
    if (this.gateways == null) {
      this.gateways = new ArrayList<>();
    }
    this.gateways.add(gatewaysItem);
    return this;
  }

   /**
   * Get gateways
   * @return gateways
  **/

  @JsonProperty(JSON_PROPERTY_GATEWAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<SensorDataGatewayData> getGateways() {
    return gateways;
  }


  @JsonProperty(JSON_PROPERTY_GATEWAYS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGateways(List<SensorDataGatewayData> gateways) {
    this.gateways = gateways;
  }


  public SensorData freq(Double freq) {
    
    this.freq = freq;
    return this;
  }

   /**
   * Get freq
   * @return freq
  **/

  @JsonProperty(JSON_PROPERTY_FREQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getFreq() {
    return freq;
  }


  @JsonProperty(JSON_PROPERTY_FREQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFreq(Double freq) {
    this.freq = freq;
  }


  public SensorData toa(Double toa) {
    
    this.toa = toa;
    return this;
  }

   /**
   * Get toa
   * @return toa
  **/

  @JsonProperty(JSON_PROPERTY_TOA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getToa() {
    return toa;
  }


  @JsonProperty(JSON_PROPERTY_TOA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToa(Double toa) {
    this.toa = toa;
  }


  public SensorData ack(Boolean ack) {
    
    this.ack = ack;
    return this;
  }

   /**
   * Get ack
   * @return ack
  **/

  @JsonProperty(JSON_PROPERTY_ACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAck() {
    return ack;
  }


  @JsonProperty(JSON_PROPERTY_ACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAck(Boolean ack) {
    this.ack = ack;
  }


  public SensorData offline(Boolean offline) {
    
    this.offline = offline;
    return this;
  }

   /**
   * Get offline
   * @return offline
  **/

  @JsonProperty(JSON_PROPERTY_OFFLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getOffline() {
    return offline;
  }


  @JsonProperty(JSON_PROPERTY_OFFLINE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOffline(Boolean offline) {
    this.offline = offline;
  }


  public SensorData dr(Double dr) {
    
    this.dr = dr;
    return this;
  }

   /**
   * Get dr
   * @return dr
  **/

  @JsonProperty(JSON_PROPERTY_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getDr() {
    return dr;
  }


  @JsonProperty(JSON_PROPERTY_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDr(Double dr) {
    this.dr = dr;
  }


  public SensorData latitude(Double latitude) {
    
    this.latitude = latitude;
    return this;
  }

   /**
   * Get latitude
   * @return latitude
  **/

  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLatitude() {
    return latitude;
  }


  @JsonProperty(JSON_PROPERTY_LATITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }


  public SensorData longitude(Double longitude) {
    
    this.longitude = longitude;
    return this;
  }

   /**
   * Get longitude
   * @return longitude
  **/

  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getLongitude() {
    return longitude;
  }


  @JsonProperty(JSON_PROPERTY_LONGITUDE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }


  public SensorData accuracy(Double accuracy) {
    
    this.accuracy = accuracy;
    return this;
  }

   /**
   * Get accuracy
   * @return accuracy
  **/

  @JsonProperty(JSON_PROPERTY_ACCURACY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getAccuracy() {
    return accuracy;
  }


  @JsonProperty(JSON_PROPERTY_ACCURACY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccuracy(Double accuracy) {
    this.accuracy = accuracy;
  }


  public SensorData appEui(String appEui) {
    
    this.appEui = appEui;
    return this;
  }

   /**
   * Get appEui
   * @return appEui
  **/

  @JsonProperty(JSON_PROPERTY_APP_EUI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getAppEui() {
    return appEui;
  }


  @JsonProperty(JSON_PROPERTY_APP_EUI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAppEui(String appEui) {
    this.appEui = appEui;
  }


  public SensorData devAddr(String devAddr) {
    
    this.devAddr = devAddr;
    return this;
  }

   /**
   * Get devAddr
   * @return devAddr
  **/

  @JsonProperty(JSON_PROPERTY_DEV_ADDR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDevAddr() {
    return devAddr;
  }


  @JsonProperty(JSON_PROPERTY_DEV_ADDR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDevAddr(String devAddr) {
    this.devAddr = devAddr;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorData sensorData = (SensorData) o;
    return Objects.equals(this.devEui, sensorData.devEui) &&
        Objects.equals(this.payloadHex, sensorData.payloadHex) &&
        Objects.equals(this.encPayloadHex, sensorData.encPayloadHex) &&
        Objects.equals(this.sessionKeyId, sensorData.sessionKeyId) &&
        Objects.equals(this.commTimestamp, sensorData.commTimestamp) &&
        Objects.equals(this.rssi, sensorData.rssi) &&
        Objects.equals(this.snr, sensorData.snr) &&
        Objects.equals(this.spFact, sensorData.spFact) &&
        Objects.equals(this.adrSpFact, sensorData.adrSpFact) &&
        Objects.equals(this.fPort, sensorData.fPort) &&
        Objects.equals(this.fCntUp, sensorData.fCntUp) &&
        Objects.equals(this.batteryLevel, sensorData.batteryLevel) &&
        Objects.equals(this.gatewayIdentifier, sensorData.gatewayIdentifier) &&
        Objects.equals(this.gwEui, sensorData.gwEui) &&
        Objects.equals(this.idGateway, sensorData.idGateway) &&
        Objects.equals(this.errorRate, sensorData.errorRate) &&
        Objects.equals(this.gateways, sensorData.gateways) &&
        Objects.equals(this.freq, sensorData.freq) &&
        Objects.equals(this.toa, sensorData.toa) &&
        Objects.equals(this.ack, sensorData.ack) &&
        Objects.equals(this.offline, sensorData.offline) &&
        Objects.equals(this.dr, sensorData.dr) &&
        Objects.equals(this.latitude, sensorData.latitude) &&
        Objects.equals(this.longitude, sensorData.longitude) &&
        Objects.equals(this.accuracy, sensorData.accuracy) &&
        Objects.equals(this.appEui, sensorData.appEui) &&
        Objects.equals(this.devAddr, sensorData.devAddr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(devEui, payloadHex, encPayloadHex, sessionKeyId, commTimestamp, rssi, snr, spFact, adrSpFact, fPort, fCntUp, batteryLevel, gatewayIdentifier, gwEui, idGateway, errorRate, gateways, freq, toa, ack, offline, dr, latitude, longitude, accuracy, appEui, devAddr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorData {\n");
    sb.append("    devEui: ").append(toIndentedString(devEui)).append("\n");
    sb.append("    payloadHex: ").append(toIndentedString(payloadHex)).append("\n");
    sb.append("    encPayloadHex: ").append(toIndentedString(encPayloadHex)).append("\n");
    sb.append("    sessionKeyId: ").append(toIndentedString(sessionKeyId)).append("\n");
    sb.append("    commTimestamp: ").append(toIndentedString(commTimestamp)).append("\n");
    sb.append("    rssi: ").append(toIndentedString(rssi)).append("\n");
    sb.append("    snr: ").append(toIndentedString(snr)).append("\n");
    sb.append("    spFact: ").append(toIndentedString(spFact)).append("\n");
    sb.append("    adrSpFact: ").append(toIndentedString(adrSpFact)).append("\n");
    sb.append("    fPort: ").append(toIndentedString(fPort)).append("\n");
    sb.append("    fCntUp: ").append(toIndentedString(fCntUp)).append("\n");
    sb.append("    batteryLevel: ").append(toIndentedString(batteryLevel)).append("\n");
    sb.append("    gatewayIdentifier: ").append(toIndentedString(gatewayIdentifier)).append("\n");
    sb.append("    gwEui: ").append(toIndentedString(gwEui)).append("\n");
    sb.append("    idGateway: ").append(toIndentedString(idGateway)).append("\n");
    sb.append("    errorRate: ").append(toIndentedString(errorRate)).append("\n");
    sb.append("    gateways: ").append(toIndentedString(gateways)).append("\n");
    sb.append("    freq: ").append(toIndentedString(freq)).append("\n");
    sb.append("    toa: ").append(toIndentedString(toa)).append("\n");
    sb.append("    ack: ").append(toIndentedString(ack)).append("\n");
    sb.append("    offline: ").append(toIndentedString(offline)).append("\n");
    sb.append("    dr: ").append(toIndentedString(dr)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    accuracy: ").append(toIndentedString(accuracy)).append("\n");
    sb.append("    appEui: ").append(toIndentedString(appEui)).append("\n");
    sb.append("    devAddr: ").append(toIndentedString(devAddr)).append("\n");
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

