package lora.ns.netmore.rest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.CreateDeviceProfileRequest;
import lora.ns.netmore.rest.model.DeviceProfile;
import lora.ns.netmore.rest.model.PatchDeviceProfileRequest;

public interface DeviceProfilesApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param createDeviceProfileRequest  (required)
   * @return DeviceProfile
   */
  @RequestLine("POST /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceProfile createDeviceProfile(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, CreateDeviceProfileRequest createDeviceProfileRequest);

  /**
   * 
   * Similar to <code>createDeviceProfile</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param createDeviceProfileRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceProfile> createDeviceProfileWithHttpInfo(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, CreateDeviceProfileRequest createDeviceProfileRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteDeviceProfile(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId);

  /**
   * 
   * Similar to <code>deleteDeviceProfile</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteDeviceProfileWithHttpInfo(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   * @return DeviceProfile
   */
  @RequestLine("GET /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Accept: application/json",
  })
  DeviceProfile getDeviceProfile(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId);

  /**
   * 
   * Similar to <code>getDeviceProfile</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<DeviceProfile> getDeviceProfileWithHttpInfo(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @return List&lt;DeviceProfile&gt;
   */
  @RequestLine("GET /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles")
  @Headers({
    "Accept: application/json",
  })
  List<DeviceProfile> listDeviceProfiles(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId);

  /**
   * 
   * Similar to <code>listDeviceProfiles</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<DeviceProfile>> listDeviceProfilesWithHttpInfo(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   * @param patchDeviceProfileRequest  (required)
   * @return DeviceProfile
   */
  @RequestLine("PATCH /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceProfile updateDeviceProfile(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId, PatchDeviceProfileRequest patchDeviceProfileRequest);

  /**
   * 
   * Similar to <code>updateDeviceProfile</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param networkServerId  (required)
   * @param profId  (required)
   * @param patchDeviceProfileRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/networkServers/{networkServerId}/deviceProfiles/{profId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceProfile> updateDeviceProfileWithHttpInfo(@Param("customerId") String customerId, @Param("networkServerId") String networkServerId, @Param("profId") Double profId, PatchDeviceProfileRequest patchDeviceProfileRequest);


}
