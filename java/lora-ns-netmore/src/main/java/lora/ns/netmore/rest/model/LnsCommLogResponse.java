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
import lora.ns.netmore.rest.model.LnsCommLogResponseDetails;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * LnsCommLogResponse
 */
@JsonPropertyOrder({
  LnsCommLogResponse.JSON_PROPERTY_TIMESTAMP,
  LnsCommLogResponse.JSON_PROPERTY_M_TYPE,
  LnsCommLogResponse.JSON_PROPERTY_GW_EUI,
  LnsCommLogResponse.JSON_PROPERTY_DR,
  LnsCommLogResponse.JSON_PROPERTY_FREQ,
  LnsCommLogResponse.JSON_PROPERTY_PORT,
  LnsCommLogResponse.JSON_PROPERTY_RSSI,
  LnsCommLogResponse.JSON_PROPERTY_F_CNT,
  LnsCommLogResponse.JSON_PROPERTY_SNR,
  LnsCommLogResponse.JSON_PROPERTY_ADR,
  LnsCommLogResponse.JSON_PROPERTY_ADR_ACK_REQ,
  LnsCommLogResponse.JSON_PROPERTY_ACK,
  LnsCommLogResponse.JSON_PROPERTY_DEV_NONCE,
  LnsCommLogResponse.JSON_PROPERTY_DEV_ADDR,
  LnsCommLogResponse.JSON_PROPERTY_DETAILS
})
public class LnsCommLogResponse {
  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private String timestamp;

  public static final String JSON_PROPERTY_M_TYPE = "mType";
  private String mType;

  public static final String JSON_PROPERTY_GW_EUI = "gwEui";
  private String gwEui;

  public static final String JSON_PROPERTY_DR = "dr";
  private Double dr;

  public static final String JSON_PROPERTY_FREQ = "freq";
  private Double freq;

  public static final String JSON_PROPERTY_PORT = "port";
  private Double port;

  public static final String JSON_PROPERTY_RSSI = "rssi";
  private Double rssi;

  public static final String JSON_PROPERTY_F_CNT = "fCnt";
  private Double fCnt;

  public static final String JSON_PROPERTY_SNR = "snr";
  private Double snr;

  public static final String JSON_PROPERTY_ADR = "adr";
  private Boolean adr;

  public static final String JSON_PROPERTY_ADR_ACK_REQ = "adrAckReq";
  private Boolean adrAckReq;

  public static final String JSON_PROPERTY_ACK = "ack";
  private Boolean ack;

  public static final String JSON_PROPERTY_DEV_NONCE = "devNonce";
  private String devNonce;

  public static final String JSON_PROPERTY_DEV_ADDR = "devAddr";
  private String devAddr;

  public static final String JSON_PROPERTY_DETAILS = "details";
  private LnsCommLogResponseDetails details;

  public LnsCommLogResponse() {
  }

  public LnsCommLogResponse timestamp(String timestamp) {
    
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTimestamp() {
    return timestamp;
  }


  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }


  public LnsCommLogResponse mType(String mType) {
    
    this.mType = mType;
    return this;
  }

   /**
   * Get mType
   * @return mType
  **/

  @JsonProperty(JSON_PROPERTY_M_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getmType() {
    return mType;
  }


  @JsonProperty(JSON_PROPERTY_M_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setmType(String mType) {
    this.mType = mType;
  }


  public LnsCommLogResponse gwEui(String gwEui) {
    
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


  public LnsCommLogResponse dr(Double dr) {
    
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


  public LnsCommLogResponse freq(Double freq) {
    
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


  public LnsCommLogResponse port(Double port) {
    
    this.port = port;
    return this;
  }

   /**
   * Get port
   * @return port
  **/

  @JsonProperty(JSON_PROPERTY_PORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getPort() {
    return port;
  }


  @JsonProperty(JSON_PROPERTY_PORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPort(Double port) {
    this.port = port;
  }


  public LnsCommLogResponse rssi(Double rssi) {
    
    this.rssi = rssi;
    return this;
  }

   /**
   * Get rssi
   * @return rssi
  **/

  @JsonProperty(JSON_PROPERTY_RSSI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getRssi() {
    return rssi;
  }


  @JsonProperty(JSON_PROPERTY_RSSI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRssi(Double rssi) {
    this.rssi = rssi;
  }


  public LnsCommLogResponse fCnt(Double fCnt) {
    
    this.fCnt = fCnt;
    return this;
  }

   /**
   * Get fCnt
   * @return fCnt
  **/

  @JsonProperty(JSON_PROPERTY_F_CNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getfCnt() {
    return fCnt;
  }


  @JsonProperty(JSON_PROPERTY_F_CNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setfCnt(Double fCnt) {
    this.fCnt = fCnt;
  }


  public LnsCommLogResponse snr(Double snr) {
    
    this.snr = snr;
    return this;
  }

   /**
   * Get snr
   * @return snr
  **/

  @JsonProperty(JSON_PROPERTY_SNR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getSnr() {
    return snr;
  }


  @JsonProperty(JSON_PROPERTY_SNR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSnr(Double snr) {
    this.snr = snr;
  }


  public LnsCommLogResponse adr(Boolean adr) {
    
    this.adr = adr;
    return this;
  }

   /**
   * Get adr
   * @return adr
  **/

  @JsonProperty(JSON_PROPERTY_ADR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdr() {
    return adr;
  }


  @JsonProperty(JSON_PROPERTY_ADR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdr(Boolean adr) {
    this.adr = adr;
  }


  public LnsCommLogResponse adrAckReq(Boolean adrAckReq) {
    
    this.adrAckReq = adrAckReq;
    return this;
  }

   /**
   * Get adrAckReq
   * @return adrAckReq
  **/

  @JsonProperty(JSON_PROPERTY_ADR_ACK_REQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdrAckReq() {
    return adrAckReq;
  }


  @JsonProperty(JSON_PROPERTY_ADR_ACK_REQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdrAckReq(Boolean adrAckReq) {
    this.adrAckReq = adrAckReq;
  }


  public LnsCommLogResponse ack(Boolean ack) {
    
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


  public LnsCommLogResponse devNonce(String devNonce) {
    
    this.devNonce = devNonce;
    return this;
  }

   /**
   * Get devNonce
   * @return devNonce
  **/

  @JsonProperty(JSON_PROPERTY_DEV_NONCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDevNonce() {
    return devNonce;
  }


  @JsonProperty(JSON_PROPERTY_DEV_NONCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDevNonce(String devNonce) {
    this.devNonce = devNonce;
  }


  public LnsCommLogResponse devAddr(String devAddr) {
    
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


  public LnsCommLogResponse details(LnsCommLogResponseDetails details) {
    
    this.details = details;
    return this;
  }

   /**
   * Get details
   * @return details
  **/

  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public LnsCommLogResponseDetails getDetails() {
    return details;
  }


  @JsonProperty(JSON_PROPERTY_DETAILS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetails(LnsCommLogResponseDetails details) {
    this.details = details;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LnsCommLogResponse lnsCommLogResponse = (LnsCommLogResponse) o;
    return Objects.equals(this.timestamp, lnsCommLogResponse.timestamp) &&
        Objects.equals(this.mType, lnsCommLogResponse.mType) &&
        Objects.equals(this.gwEui, lnsCommLogResponse.gwEui) &&
        Objects.equals(this.dr, lnsCommLogResponse.dr) &&
        Objects.equals(this.freq, lnsCommLogResponse.freq) &&
        Objects.equals(this.port, lnsCommLogResponse.port) &&
        Objects.equals(this.rssi, lnsCommLogResponse.rssi) &&
        Objects.equals(this.fCnt, lnsCommLogResponse.fCnt) &&
        Objects.equals(this.snr, lnsCommLogResponse.snr) &&
        Objects.equals(this.adr, lnsCommLogResponse.adr) &&
        Objects.equals(this.adrAckReq, lnsCommLogResponse.adrAckReq) &&
        Objects.equals(this.ack, lnsCommLogResponse.ack) &&
        Objects.equals(this.devNonce, lnsCommLogResponse.devNonce) &&
        Objects.equals(this.devAddr, lnsCommLogResponse.devAddr) &&
        Objects.equals(this.details, lnsCommLogResponse.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(timestamp, mType, gwEui, dr, freq, port, rssi, fCnt, snr, adr, adrAckReq, ack, devNonce, devAddr, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LnsCommLogResponse {\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    mType: ").append(toIndentedString(mType)).append("\n");
    sb.append("    gwEui: ").append(toIndentedString(gwEui)).append("\n");
    sb.append("    dr: ").append(toIndentedString(dr)).append("\n");
    sb.append("    freq: ").append(toIndentedString(freq)).append("\n");
    sb.append("    port: ").append(toIndentedString(port)).append("\n");
    sb.append("    rssi: ").append(toIndentedString(rssi)).append("\n");
    sb.append("    fCnt: ").append(toIndentedString(fCnt)).append("\n");
    sb.append("    snr: ").append(toIndentedString(snr)).append("\n");
    sb.append("    adr: ").append(toIndentedString(adr)).append("\n");
    sb.append("    adrAckReq: ").append(toIndentedString(adrAckReq)).append("\n");
    sb.append("    ack: ").append(toIndentedString(ack)).append("\n");
    sb.append("    devNonce: ").append(toIndentedString(devNonce)).append("\n");
    sb.append("    devAddr: ").append(toIndentedString(devAddr)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

