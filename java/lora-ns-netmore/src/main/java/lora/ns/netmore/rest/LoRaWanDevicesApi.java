package lora.ns.netmore.rest;

import java.util.HashMap;
import java.util.List;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.Device;
import lora.ns.netmore.rest.model.LnsCommLogResponse;
import lora.ns.netmore.rest.model.LookupLoRaWanDevEuiRequest;
import lora.ns.netmore.rest.model.LookupLoRaWanDevEuiResponse;
import lora.ns.netmore.rest.model.PatchDeviceRequest;

public interface LoRaWanDevicesApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param devEui  (required)
   */
  @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/clearDownlink")
  @Headers({
    "Accept: application/json",
  })
  void clearDownlinkQueueLoRaWAN(@Param("devEui") String devEui);

  /**
   * 
   * Similar to <code>clearDownlinkQueueLoRaWAN</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param devEui  (required)
   */
  @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/clearDownlink")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> clearDownlinkQueueLoRaWANWithHttpInfo(@Param("devEui") String devEui);



  /**
   * 
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param devEui - devEui of the devicessss. (required)
   * @param includeKeys - Optional include keys if available (default false). (optional)
   * @param filter - Optional filet to apply if only some data is needed comma separated string. (optional)
   * @return Device
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  Device getLoraDeviceData(@Param("devEui") String devEui, @Param("includeKeys") Boolean includeKeys, @Param("filter") String filter);

  /**
   * 
   * Similar to <code>getLoraDeviceData</code> but it also returns the http response headers .
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param devEui - devEui of the devicessss. (required)
   * @param includeKeys - Optional include keys if available (default false). (optional)
   * @param filter - Optional filet to apply if only some data is needed comma separated string. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Device> getLoraDeviceDataWithHttpInfo(@Param("devEui") String devEui, @Param("includeKeys") Boolean includeKeys, @Param("filter") String filter);


  /**
   * 
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>getLoraDeviceData</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetLoraDeviceDataQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param devEui - devEui of the devicessss. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeKeys - - Optional include keys if available (default false). (optional)</li>
   *   <li>filter - - Optional filet to apply if only some data is needed comma separated string. (optional)</li>
   *   </ul>
   * @return Device
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
  "Accept: application/json",
  })
  Device getLoraDeviceData(@Param("devEui") String devEui, @QueryMap(encoded=true) GetLoraDeviceDataQueryParams queryParams);

  /**
  * 
  * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>getLoraDeviceData</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param devEui - devEui of the devicessss. (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>includeKeys - - Optional include keys if available (default false). (optional)</li>
          *   <li>filter - - Optional filet to apply if only some data is needed comma separated string. (optional)</li>
      *   </ul>
          * @return Device
      */
      @RequestLine("GET /devices/LoRaWAN/{devEui}?includeKeys={includeKeys}&filter={filter}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Device> getLoraDeviceDataWithHttpInfo(@Param("devEui") String devEui, @QueryMap(encoded=true) GetLoraDeviceDataQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getLoraDeviceData</code> method in a fluent style.
   */
  public static class GetLoraDeviceDataQueryParams extends HashMap<String, Object> {
    public GetLoraDeviceDataQueryParams includeKeys(final Boolean value) {
      put("includeKeys", value);
      return this;
    }
    public GetLoraDeviceDataQueryParams filter(final String value) {
      put("filter", value);
      return this;
    }
  }

  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param from  (optional)
   * @param to  (optional)
   * @return List&lt;LnsCommLogResponse&gt;
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
    "Accept: application/json",
  })
  List<LnsCommLogResponse> listCommLogLoRaWAN(@Param("devEui") String devEui, @Param("from") String from, @Param("to") String to);

  /**
   * 
   * Similar to <code>listCommLogLoRaWAN</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param from  (optional)
   * @param to  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<LnsCommLogResponse>> listCommLogLoRaWANWithHttpInfo(@Param("devEui") String devEui, @Param("from") String from, @Param("to") String to);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>listCommLogLoRaWAN</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListCommLogLoRaWANQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param devEui  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>from -  (optional)</li>
   *   <li>to -  (optional)</li>
   *   </ul>
   * @return List&lt;LnsCommLogResponse&gt;
   */
  @RequestLine("GET /devices/LoRaWAN/{devEui}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
  "Accept: application/json",
  })
  List<LnsCommLogResponse> listCommLogLoRaWAN(@Param("devEui") String devEui, @QueryMap(encoded=true) ListCommLogLoRaWANQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>listCommLogLoRaWAN</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param devEui  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>from -  (optional)</li>
          *   <li>to -  (optional)</li>
      *   </ul>
          * @return List&lt;LnsCommLogResponse&gt;
      */
      @RequestLine("GET /devices/LoRaWAN/{devEui}/LoRaWAN/commLog?from={from}&to={to}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<LnsCommLogResponse>> listCommLogLoRaWANWithHttpInfo(@Param("devEui") String devEui, @QueryMap(encoded=true) ListCommLogLoRaWANQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>listCommLogLoRaWAN</code> method in a fluent style.
   */
  public static class ListCommLogLoRaWANQueryParams extends HashMap<String, Object> {
    public ListCommLogLoRaWANQueryParams from(final String value) {
      put("from", value);
      return this;
    }
    public ListCommLogLoRaWANQueryParams to(final String value) {
      put("to", value);
      return this;
    }
  }

  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &lt;br&gt;api-key: &lt;br&gt;
   * @param lookupLoRaWanDevEuiRequest  (required)
   * @return List&lt;LookupLoRaWanDevEuiResponse&gt;
   */
  @RequestLine("POST /lookupLoraWanDevEui")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  List<LookupLoRaWanDevEuiResponse> lookupLoRaWanDevEui(LookupLoRaWanDevEuiRequest lookupLoRaWanDevEuiRequest);

  /**
   * 
   * Similar to <code>lookupLoRaWanDevEui</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &lt;br&gt;api-key: &lt;br&gt;
   * @param lookupLoRaWanDevEuiRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /lookupLoraWanDevEui")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<List<LookupLoRaWanDevEuiResponse>> lookupLoRaWanDevEuiWithHttpInfo(LookupLoRaWanDevEuiRequest lookupLoRaWanDevEuiRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param patchDeviceRequest  (required)
   * @return Device
   */
  @RequestLine("PATCH /devices/LoRaWAN/{devEui}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Device patchDeviceLoRaWAN(@Param("devEui") String devEui, PatchDeviceRequest patchDeviceRequest);

  /**
   * 
   * Similar to <code>patchDeviceLoRaWAN</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param patchDeviceRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /devices/LoRaWAN/{devEui}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Device> patchDeviceLoRaWANWithHttpInfo(@Param("devEui") String devEui, PatchDeviceRequest patchDeviceRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param payloadHex  (required)
   * @param fPort  (required)
   * @param confirmed  (required)
   * @param validity  (required)
   * @return Double
   */
  @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
    "Accept: application/json",
  })
  Double sendDownlinkLoRaWAN(@Param("devEui") String devEui, @Param("payloadHex") String payloadHex, @Param("fPort") Double fPort, @Param("confirmed") Boolean confirmed, @Param("validity") Double validity);

  /**
   * 
   * Similar to <code>sendDownlinkLoRaWAN</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param devEui  (required)
   * @param payloadHex  (required)
   * @param fPort  (required)
   * @param confirmed  (required)
   * @param validity  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Double> sendDownlinkLoRaWANWithHttpInfo(@Param("devEui") String devEui, @Param("payloadHex") String payloadHex, @Param("fPort") Double fPort, @Param("confirmed") Boolean confirmed, @Param("validity") Double validity);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>sendDownlinkLoRaWAN</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SendDownlinkLoRaWANQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param devEui  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>payloadHex -  (required)</li>
   *   <li>fPort -  (required)</li>
   *   <li>confirmed -  (required)</li>
   *   <li>validity -  (required)</li>
   *   </ul>
   * @return Double
   */
  @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
  "Accept: application/json",
  })
  Double sendDownlinkLoRaWAN(@Param("devEui") String devEui, @QueryMap(encoded=true) SendDownlinkLoRaWANQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>sendDownlinkLoRaWAN</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param devEui  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>payloadHex -  (required)</li>
          *   <li>fPort -  (required)</li>
          *   <li>confirmed -  (required)</li>
          *   <li>validity -  (required)</li>
      *   </ul>
          * @return Double
      */
      @RequestLine("POST /devices/LoRaWAN/{devEui}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Double> sendDownlinkLoRaWANWithHttpInfo(@Param("devEui") String devEui, @QueryMap(encoded=true) SendDownlinkLoRaWANQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>sendDownlinkLoRaWAN</code> method in a fluent style.
   */
  public static class SendDownlinkLoRaWANQueryParams extends HashMap<String, Object> {
    public SendDownlinkLoRaWANQueryParams payloadHex(final String value) {
      put("payloadHex", value);
      return this;
    }
    public SendDownlinkLoRaWANQueryParams fPort(final Double value) {
      put("fPort", value);
      return this;
    }
    public SendDownlinkLoRaWANQueryParams confirmed(final Boolean value) {
      put("confirmed", value);
      return this;
    }
    public SendDownlinkLoRaWANQueryParams validity(final Double value) {
      put("validity", value);
      return this;
    }
  }
}
