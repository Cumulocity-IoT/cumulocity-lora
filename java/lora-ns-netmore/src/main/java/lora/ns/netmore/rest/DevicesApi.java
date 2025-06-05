package lora.ns.netmore.rest;

import java.util.HashMap;
import java.util.List;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.CreateDeviceRequest;
import lora.ns.netmore.rest.model.Device;
import lora.ns.netmore.rest.model.GetDeviceGroupDeviceDataFilterParameterInner;
import lora.ns.netmore.rest.model.LnsCommLogResponse;
import lora.ns.netmore.rest.model.MoveDeviceRequest;
import lora.ns.netmore.rest.model.PatchDeviceRequest;

public interface DevicesApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/clearDownlink")
  @Headers({
    "Accept: application/json",
  })
  void clearDownlinkQueue(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId);

  /**
   * 
   * Similar to <code>clearDownlinkQueue</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/clearDownlink")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> clearDownlinkQueueWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId);



  /**
   * 
   * Create meta data for a device.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param createDeviceRequest  (required)
   * @return Device
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Device createDevice(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, CreateDeviceRequest createDeviceRequest);

  /**
   * 
   * Similar to <code>createDevice</code> but it also returns the http response headers .
   * Create meta data for a device.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param createDeviceRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Device> createDeviceWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, CreateDeviceRequest createDeviceRequest);



  /**
   * 
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Device group id to fetch data for. (required)
   * @param deviceId - Device id to fetch data for. (required)
   * @param includeKeys - Optional include keys if available (default false). (optional)
   * @param filter - Optional filet to apply if only some data is needed comma separated string. (optional)
   * @return Device
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  Device getDeviceData(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("includeKeys") Boolean includeKeys, @Param("filter") String filter);

  /**
   * 
   * Similar to <code>getDeviceData</code> but it also returns the http response headers .
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Device group id to fetch data for. (required)
   * @param deviceId - Device id to fetch data for. (required)
   * @param includeKeys - Optional include keys if available (default false). (optional)
   * @param filter - Optional filet to apply if only some data is needed comma separated string. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Device> getDeviceDataWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("includeKeys") Boolean includeKeys, @Param("filter") String filter);


  /**
   * 
   * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>getDeviceData</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetDeviceDataQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Device group id to fetch data for. (required)
   * @param deviceId - Device id to fetch data for. (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeKeys - - Optional include keys if available (default false). (optional)</li>
   *   <li>filter - - Optional filet to apply if only some data is needed comma separated string. (optional)</li>
   *   </ul>
   * @return Device
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}?includeKeys={includeKeys}&filter={filter}")
  @Headers({
  "Accept: application/json",
  })
  Device getDeviceData(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) GetDeviceDataQueryParams queryParams);

  /**
  * 
  * This will get stored data from the database.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>getDeviceData</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId - Id of the customer. (required)
              * @param deviceGroupId - Device group id to fetch data for. (required)
              * @param deviceId - Device id to fetch data for. (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>includeKeys - - Optional include keys if available (default false). (optional)</li>
          *   <li>filter - - Optional filet to apply if only some data is needed comma separated string. (optional)</li>
      *   </ul>
          * @return Device
      */
      @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}?includeKeys={includeKeys}&filter={filter}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Device> getDeviceDataWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) GetDeviceDataQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getDeviceData</code> method in a fluent style.
   */
  public static class GetDeviceDataQueryParams extends HashMap<String, Object> {
    public GetDeviceDataQueryParams includeKeys(final Boolean value) {
      put("includeKeys", value);
      return this;
    }
    public GetDeviceDataQueryParams filter(final String value) {
      put("filter", value);
      return this;
    }
  }

  /**
   * 
   * This will get stored data from all devices for a deviceGroup. Note: You need to have access setup event if you own the deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer (required)
   * @param deviceGroupId - Id of the deviceGroup to get data for (required)
   * @param filter - Optional filter to apply if only cretin values are requested like temperature. (optional)
   * @return List&lt;Device&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices?filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  List<Device> getDeviceGroupDeviceData(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("filter") List<GetDeviceGroupDeviceDataFilterParameterInner> filter);

  /**
   * 
   * Similar to <code>getDeviceGroupDeviceData</code> but it also returns the http response headers .
   * This will get stored data from all devices for a deviceGroup. Note: You need to have access setup event if you own the deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer (required)
   * @param deviceGroupId - Id of the deviceGroup to get data for (required)
   * @param filter - Optional filter to apply if only cretin values are requested like temperature. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices?filter={filter}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<Device>> getDeviceGroupDeviceDataWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("filter") List<GetDeviceGroupDeviceDataFilterParameterInner> filter);


  /**
   * 
   * This will get stored data from all devices for a deviceGroup. Note: You need to have access setup event if you own the deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>getDeviceGroupDeviceData</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetDeviceGroupDeviceDataQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId - Id of the customer (required)
   * @param deviceGroupId - Id of the deviceGroup to get data for (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>filter - - Optional filter to apply if only cretin values are requested like temperature. (optional)</li>
   *   </ul>
   * @return List&lt;Device&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices?filter={filter}")
  @Headers({
  "Accept: application/json",
  })
  List<Device> getDeviceGroupDeviceData(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @QueryMap(encoded=true) GetDeviceGroupDeviceDataQueryParams queryParams);

  /**
  * 
  * This will get stored data from all devices for a deviceGroup. Note: You need to have access setup event if you own the deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>getDeviceGroupDeviceData</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId - Id of the customer (required)
              * @param deviceGroupId - Id of the deviceGroup to get data for (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>filter - - Optional filter to apply if only cretin values are requested like temperature. (optional)</li>
      *   </ul>
          * @return List&lt;Device&gt;
      */
      @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices?filter={filter}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<Device>> getDeviceGroupDeviceDataWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @QueryMap(encoded=true) GetDeviceGroupDeviceDataQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getDeviceGroupDeviceData</code> method in a fluent style.
   */
  public static class GetDeviceGroupDeviceDataQueryParams extends HashMap<String, Object> {
    public GetDeviceGroupDeviceDataQueryParams filter(final List<GetDeviceGroupDeviceDataFilterParameterInner> value) {
      put("filter", value);
      return this;
    }
  }

  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param from  (optional)
   * @param to  (optional)
   * @return List&lt;LnsCommLogResponse&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
    "Accept: application/json",
  })
  List<LnsCommLogResponse> listCommLog(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("from") String from, @Param("to") String to);

  /**
   * 
   * Similar to <code>listCommLog</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param from  (optional)
   * @param to  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<LnsCommLogResponse>> listCommLogWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("from") String from, @Param("to") String to);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>listCommLog</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListCommLogQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>from -  (optional)</li>
   *   <li>to -  (optional)</li>
   *   </ul>
   * @return List&lt;LnsCommLogResponse&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/commLog?from={from}&to={to}")
  @Headers({
  "Accept: application/json",
  })
  List<LnsCommLogResponse> listCommLog(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) ListCommLogQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>listCommLog</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId  (required)
              * @param deviceGroupId  (required)
              * @param deviceId  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>from -  (optional)</li>
          *   <li>to -  (optional)</li>
      *   </ul>
          * @return List&lt;LnsCommLogResponse&gt;
      */
      @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/commLog?from={from}&to={to}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<List<LnsCommLogResponse>> listCommLogWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) ListCommLogQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>listCommLog</code> method in a fluent style.
   */
  public static class ListCommLogQueryParams extends HashMap<String, Object> {
    public ListCommLogQueryParams from(final String value) {
      put("from", value);
      return this;
    }
    public ListCommLogQueryParams to(final String value) {
      put("to", value);
      return this;
    }
  }

  /**
   * 
   * Move a device to another deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DFieldService&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DFieldService&#x60;&lt;br&gt;
   * @param customerId - Id of current the customer (required)
   * @param deviceGroupId - Id of the deviceGroup to move from (required)
   * @param deviceId - Id of the device to move (required)
   * @param moveDeviceRequest - Id of the target deviceGroup and customer (required)
   * @return Device
   */
  @RequestLine("PUT /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Device moveDevice(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, MoveDeviceRequest moveDeviceRequest);

  /**
   * 
   * Similar to <code>moveDevice</code> but it also returns the http response headers .
   * Move a device to another deviceGroup.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DFieldService&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DFieldService&#x60;&lt;br&gt;
   * @param customerId - Id of current the customer (required)
   * @param deviceGroupId - Id of the deviceGroup to move from (required)
   * @param deviceId - Id of the device to move (required)
   * @param moveDeviceRequest - Id of the target deviceGroup and customer (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Device> moveDeviceWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, MoveDeviceRequest moveDeviceRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param patchDeviceRequest  (required)
   * @return Device
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Device patchDevice(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, PatchDeviceRequest patchDeviceRequest);

  /**
   * 
   * Similar to <code>patchDevice</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param patchDeviceRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Device> patchDeviceWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, PatchDeviceRequest patchDeviceRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param payloadHex  (required)
   * @param fPort  (required)
   * @param confirmed  (required)
   * @param validity  (required)
   * @return Double
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
    "Accept: application/json",
  })
  Double sendDownlink(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("payloadHex") String payloadHex, @Param("fPort") Double fPort, @Param("confirmed") Boolean confirmed, @Param("validity") Double validity);

  /**
   * 
   * Similar to <code>sendDownlink</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
   * @param payloadHex  (required)
   * @param fPort  (required)
   * @param confirmed  (required)
   * @param validity  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Double> sendDownlinkWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @Param("payloadHex") String payloadHex, @Param("fPort") Double fPort, @Param("confirmed") Boolean confirmed, @Param("validity") Double validity);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>sendDownlink</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SendDownlinkQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param deviceId  (required)
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
  @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
  @Headers({
  "Accept: application/json",
  })
  Double sendDownlink(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) SendDownlinkQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DSendDownlink&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>sendDownlink</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId  (required)
              * @param deviceGroupId  (required)
              * @param deviceId  (required)
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
      @RequestLine("POST /customers/{customerId}/deviceGroups/{deviceGroupId}/devices/{deviceId}/LoRaWAN/downlink?payloadHex={payloadHex}&fPort={fPort}&confirmed={confirmed}&validity={validity}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Double> sendDownlinkWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, @Param("deviceId") String deviceId, @QueryMap(encoded=true) SendDownlinkQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>sendDownlink</code> method in a fluent style.
   */
  public static class SendDownlinkQueryParams extends HashMap<String, Object> {
    public SendDownlinkQueryParams payloadHex(final String value) {
      put("payloadHex", value);
      return this;
    }
    public SendDownlinkQueryParams fPort(final Double value) {
      put("fPort", value);
      return this;
    }
    public SendDownlinkQueryParams confirmed(final Boolean value) {
      put("confirmed", value);
      return this;
    }
    public SendDownlinkQueryParams validity(final Double value) {
      put("validity", value);
      return this;
    }
  }
}
