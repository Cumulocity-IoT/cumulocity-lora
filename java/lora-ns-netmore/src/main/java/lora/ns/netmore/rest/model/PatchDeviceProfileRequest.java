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
import lora.ns.netmore.rest.model.DeviceProfileJoinDevClass;
import lora.ns.netmore.rest.model.DeviceProfileLoRaVer;
import lora.ns.netmore.rest.model.DeviceProfileLoraSet;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * PatchDeviceProfileRequest
 */
@JsonPropertyOrder({
  PatchDeviceProfileRequest.JSON_PROPERTY_NAME,
  PatchDeviceProfileRequest.JSON_PROPERTY_JOIN_DEV_CLASS,
  PatchDeviceProfileRequest.JSON_PROPERTY_LO_RA_VER,
  PatchDeviceProfileRequest.JSON_PROPERTY_REG_PARAM_VER,
  PatchDeviceProfileRequest.JSON_PROPERTY_LORA_SETS,
  PatchDeviceProfileRequest.JSON_PROPERTY_MIN_DR,
  PatchDeviceProfileRequest.JSON_PROPERTY_MAX_DR,
  PatchDeviceProfileRequest.JSON_PROPERTY_ALLOW_FCNT_RESET,
  PatchDeviceProfileRequest.JSON_PROPERTY_SEND_DEV_STATUS_REQ_MIN,
  PatchDeviceProfileRequest.JSON_PROPERTY_SUP_ADR,
  PatchDeviceProfileRequest.JSON_PROPERTY_ALLOW_NEW_CHNL_REQ,
  PatchDeviceProfileRequest.JSON_PROPERTY_ADR_USE_NB_TRANS,
  PatchDeviceProfileRequest.JSON_PROPERTY_MAX_MAC_CMD_PER_DL,
  PatchDeviceProfileRequest.JSON_PROPERTY_DYN_CHNL_MASK
})
public class PatchDeviceProfileRequest {
  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_JOIN_DEV_CLASS = "joinDevClass";
  private DeviceProfileJoinDevClass joinDevClass;

  public static final String JSON_PROPERTY_LO_RA_VER = "loRaVer";
  private DeviceProfileLoRaVer loRaVer;

  public static final String JSON_PROPERTY_REG_PARAM_VER = "regParamVer";
  private String regParamVer;

  public static final String JSON_PROPERTY_LORA_SETS = "loraSets";
  private List<DeviceProfileLoraSet> loraSets;

  public static final String JSON_PROPERTY_MIN_DR = "minDr";
  private Double minDr;

  public static final String JSON_PROPERTY_MAX_DR = "maxDr";
  private Double maxDr;

  public static final String JSON_PROPERTY_ALLOW_FCNT_RESET = "allowFcntReset";
  private Boolean allowFcntReset;

  public static final String JSON_PROPERTY_SEND_DEV_STATUS_REQ_MIN = "sendDevStatusReqMin";
  private Double sendDevStatusReqMin;

  public static final String JSON_PROPERTY_SUP_ADR = "supAdr";
  private Boolean supAdr;

  public static final String JSON_PROPERTY_ALLOW_NEW_CHNL_REQ = "allowNewChnlReq";
  private Boolean allowNewChnlReq;

  public static final String JSON_PROPERTY_ADR_USE_NB_TRANS = "adrUseNbTrans";
  private Boolean adrUseNbTrans;

  public static final String JSON_PROPERTY_MAX_MAC_CMD_PER_DL = "maxMacCmdPerDl";
  private Double maxMacCmdPerDl;

  public static final String JSON_PROPERTY_DYN_CHNL_MASK = "dynChnlMask";
  private String dynChnlMask;

  public PatchDeviceProfileRequest() {
  }

  public PatchDeviceProfileRequest name(String name) {
    
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getName() {
    return name;
  }


  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }


  public PatchDeviceProfileRequest joinDevClass(DeviceProfileJoinDevClass joinDevClass) {
    
    this.joinDevClass = joinDevClass;
    return this;
  }

   /**
   * Get joinDevClass
   * @return joinDevClass
  **/

  @JsonProperty(JSON_PROPERTY_JOIN_DEV_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DeviceProfileJoinDevClass getJoinDevClass() {
    return joinDevClass;
  }


  @JsonProperty(JSON_PROPERTY_JOIN_DEV_CLASS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setJoinDevClass(DeviceProfileJoinDevClass joinDevClass) {
    this.joinDevClass = joinDevClass;
  }


  public PatchDeviceProfileRequest loRaVer(DeviceProfileLoRaVer loRaVer) {
    
    this.loRaVer = loRaVer;
    return this;
  }

   /**
   * Get loRaVer
   * @return loRaVer
  **/

  @JsonProperty(JSON_PROPERTY_LO_RA_VER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public DeviceProfileLoRaVer getLoRaVer() {
    return loRaVer;
  }


  @JsonProperty(JSON_PROPERTY_LO_RA_VER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLoRaVer(DeviceProfileLoRaVer loRaVer) {
    this.loRaVer = loRaVer;
  }


  public PatchDeviceProfileRequest regParamVer(String regParamVer) {
    
    this.regParamVer = regParamVer;
    return this;
  }

   /**
   * Get regParamVer
   * @return regParamVer
  **/

  @JsonProperty(JSON_PROPERTY_REG_PARAM_VER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRegParamVer() {
    return regParamVer;
  }


  @JsonProperty(JSON_PROPERTY_REG_PARAM_VER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRegParamVer(String regParamVer) {
    this.regParamVer = regParamVer;
  }


  public PatchDeviceProfileRequest loraSets(List<DeviceProfileLoraSet> loraSets) {
    
    this.loraSets = loraSets;
    return this;
  }

  public PatchDeviceProfileRequest addLoraSetsItem(DeviceProfileLoraSet loraSetsItem) {
    if (this.loraSets == null) {
      this.loraSets = new ArrayList<>();
    }
    this.loraSets.add(loraSetsItem);
    return this;
  }

   /**
   * Get loraSets
   * @return loraSets
  **/

  @JsonProperty(JSON_PROPERTY_LORA_SETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<DeviceProfileLoraSet> getLoraSets() {
    return loraSets;
  }


  @JsonProperty(JSON_PROPERTY_LORA_SETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLoraSets(List<DeviceProfileLoraSet> loraSets) {
    this.loraSets = loraSets;
  }


  public PatchDeviceProfileRequest minDr(Double minDr) {
    
    this.minDr = minDr;
    return this;
  }

   /**
   * Get minDr
   * @return minDr
  **/

  @JsonProperty(JSON_PROPERTY_MIN_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMinDr() {
    return minDr;
  }


  @JsonProperty(JSON_PROPERTY_MIN_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMinDr(Double minDr) {
    this.minDr = minDr;
  }


  public PatchDeviceProfileRequest maxDr(Double maxDr) {
    
    this.maxDr = maxDr;
    return this;
  }

   /**
   * Get maxDr
   * @return maxDr
  **/

  @JsonProperty(JSON_PROPERTY_MAX_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMaxDr() {
    return maxDr;
  }


  @JsonProperty(JSON_PROPERTY_MAX_DR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxDr(Double maxDr) {
    this.maxDr = maxDr;
  }


  public PatchDeviceProfileRequest allowFcntReset(Boolean allowFcntReset) {
    
    this.allowFcntReset = allowFcntReset;
    return this;
  }

   /**
   * Get allowFcntReset
   * @return allowFcntReset
  **/

  @JsonProperty(JSON_PROPERTY_ALLOW_FCNT_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAllowFcntReset() {
    return allowFcntReset;
  }


  @JsonProperty(JSON_PROPERTY_ALLOW_FCNT_RESET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllowFcntReset(Boolean allowFcntReset) {
    this.allowFcntReset = allowFcntReset;
  }


  public PatchDeviceProfileRequest sendDevStatusReqMin(Double sendDevStatusReqMin) {
    
    this.sendDevStatusReqMin = sendDevStatusReqMin;
    return this;
  }

   /**
   * Get sendDevStatusReqMin
   * @return sendDevStatusReqMin
  **/

  @JsonProperty(JSON_PROPERTY_SEND_DEV_STATUS_REQ_MIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getSendDevStatusReqMin() {
    return sendDevStatusReqMin;
  }


  @JsonProperty(JSON_PROPERTY_SEND_DEV_STATUS_REQ_MIN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSendDevStatusReqMin(Double sendDevStatusReqMin) {
    this.sendDevStatusReqMin = sendDevStatusReqMin;
  }


  public PatchDeviceProfileRequest supAdr(Boolean supAdr) {
    
    this.supAdr = supAdr;
    return this;
  }

   /**
   * Get supAdr
   * @return supAdr
  **/

  @JsonProperty(JSON_PROPERTY_SUP_ADR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getSupAdr() {
    return supAdr;
  }


  @JsonProperty(JSON_PROPERTY_SUP_ADR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSupAdr(Boolean supAdr) {
    this.supAdr = supAdr;
  }


  public PatchDeviceProfileRequest allowNewChnlReq(Boolean allowNewChnlReq) {
    
    this.allowNewChnlReq = allowNewChnlReq;
    return this;
  }

   /**
   * Get allowNewChnlReq
   * @return allowNewChnlReq
  **/

  @JsonProperty(JSON_PROPERTY_ALLOW_NEW_CHNL_REQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAllowNewChnlReq() {
    return allowNewChnlReq;
  }


  @JsonProperty(JSON_PROPERTY_ALLOW_NEW_CHNL_REQ)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllowNewChnlReq(Boolean allowNewChnlReq) {
    this.allowNewChnlReq = allowNewChnlReq;
  }


  public PatchDeviceProfileRequest adrUseNbTrans(Boolean adrUseNbTrans) {
    
    this.adrUseNbTrans = adrUseNbTrans;
    return this;
  }

   /**
   * Get adrUseNbTrans
   * @return adrUseNbTrans
  **/

  @JsonProperty(JSON_PROPERTY_ADR_USE_NB_TRANS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Boolean getAdrUseNbTrans() {
    return adrUseNbTrans;
  }


  @JsonProperty(JSON_PROPERTY_ADR_USE_NB_TRANS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdrUseNbTrans(Boolean adrUseNbTrans) {
    this.adrUseNbTrans = adrUseNbTrans;
  }


  public PatchDeviceProfileRequest maxMacCmdPerDl(Double maxMacCmdPerDl) {
    
    this.maxMacCmdPerDl = maxMacCmdPerDl;
    return this;
  }

   /**
   * Get maxMacCmdPerDl
   * @return maxMacCmdPerDl
  **/

  @JsonProperty(JSON_PROPERTY_MAX_MAC_CMD_PER_DL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Double getMaxMacCmdPerDl() {
    return maxMacCmdPerDl;
  }


  @JsonProperty(JSON_PROPERTY_MAX_MAC_CMD_PER_DL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxMacCmdPerDl(Double maxMacCmdPerDl) {
    this.maxMacCmdPerDl = maxMacCmdPerDl;
  }


  public PatchDeviceProfileRequest dynChnlMask(String dynChnlMask) {
    
    this.dynChnlMask = dynChnlMask;
    return this;
  }

   /**
   * Get dynChnlMask
   * @return dynChnlMask
  **/

  @JsonProperty(JSON_PROPERTY_DYN_CHNL_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getDynChnlMask() {
    return dynChnlMask;
  }


  @JsonProperty(JSON_PROPERTY_DYN_CHNL_MASK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDynChnlMask(String dynChnlMask) {
    this.dynChnlMask = dynChnlMask;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchDeviceProfileRequest patchDeviceProfileRequest = (PatchDeviceProfileRequest) o;
    return Objects.equals(this.name, patchDeviceProfileRequest.name) &&
        Objects.equals(this.joinDevClass, patchDeviceProfileRequest.joinDevClass) &&
        Objects.equals(this.loRaVer, patchDeviceProfileRequest.loRaVer) &&
        Objects.equals(this.regParamVer, patchDeviceProfileRequest.regParamVer) &&
        Objects.equals(this.loraSets, patchDeviceProfileRequest.loraSets) &&
        Objects.equals(this.minDr, patchDeviceProfileRequest.minDr) &&
        Objects.equals(this.maxDr, patchDeviceProfileRequest.maxDr) &&
        Objects.equals(this.allowFcntReset, patchDeviceProfileRequest.allowFcntReset) &&
        Objects.equals(this.sendDevStatusReqMin, patchDeviceProfileRequest.sendDevStatusReqMin) &&
        Objects.equals(this.supAdr, patchDeviceProfileRequest.supAdr) &&
        Objects.equals(this.allowNewChnlReq, patchDeviceProfileRequest.allowNewChnlReq) &&
        Objects.equals(this.adrUseNbTrans, patchDeviceProfileRequest.adrUseNbTrans) &&
        Objects.equals(this.maxMacCmdPerDl, patchDeviceProfileRequest.maxMacCmdPerDl) &&
        Objects.equals(this.dynChnlMask, patchDeviceProfileRequest.dynChnlMask);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, joinDevClass, loRaVer, regParamVer, loraSets, minDr, maxDr, allowFcntReset, sendDevStatusReqMin, supAdr, allowNewChnlReq, adrUseNbTrans, maxMacCmdPerDl, dynChnlMask);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchDeviceProfileRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    joinDevClass: ").append(toIndentedString(joinDevClass)).append("\n");
    sb.append("    loRaVer: ").append(toIndentedString(loRaVer)).append("\n");
    sb.append("    regParamVer: ").append(toIndentedString(regParamVer)).append("\n");
    sb.append("    loraSets: ").append(toIndentedString(loraSets)).append("\n");
    sb.append("    minDr: ").append(toIndentedString(minDr)).append("\n");
    sb.append("    maxDr: ").append(toIndentedString(maxDr)).append("\n");
    sb.append("    allowFcntReset: ").append(toIndentedString(allowFcntReset)).append("\n");
    sb.append("    sendDevStatusReqMin: ").append(toIndentedString(sendDevStatusReqMin)).append("\n");
    sb.append("    supAdr: ").append(toIndentedString(supAdr)).append("\n");
    sb.append("    allowNewChnlReq: ").append(toIndentedString(allowNewChnlReq)).append("\n");
    sb.append("    adrUseNbTrans: ").append(toIndentedString(adrUseNbTrans)).append("\n");
    sb.append("    maxMacCmdPerDl: ").append(toIndentedString(maxMacCmdPerDl)).append("\n");
    sb.append("    dynChnlMask: ").append(toIndentedString(dynChnlMask)).append("\n");
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

