package lora.ns.netmore.rest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.CreateDeviceGroupRequest;
import lora.ns.netmore.rest.model.DeviceGroup;
import lora.ns.netmore.rest.model.UpdateDeviceGroupRequest;

public interface DeviceGroupsApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createDeviceGroupRequest  (required)
   * @return DeviceGroup
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceGroup createGroups(@Param("customerId") String customerId, CreateDeviceGroupRequest createDeviceGroupRequest);

  /**
   * 
   * Similar to <code>createGroups</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createDeviceGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> createGroupsWithHttpInfo(@Param("customerId") String customerId, CreateDeviceGroupRequest createDeviceGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createDeviceGroupRequest  (required)
   * @return DeviceGroup
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceGroup createGroups_1(@Param("customerId") String customerId, CreateDeviceGroupRequest createDeviceGroupRequest);

  /**
   * 
   * Similar to <code>createGroups_0</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createDeviceGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/deviceGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> createGroups_1WithHttpInfo(@Param("customerId") String customerId, CreateDeviceGroupRequest createDeviceGroupRequest);



  /**
   * 
   * Get a device group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Id of the device group. (required)
   * @return DeviceGroup
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Accept: application/json",
  })
  DeviceGroup getDeviceGroup(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId);

  /**
   * 
   * Similar to <code>getDeviceGroup</code> but it also returns the http response headers .
   * Get a device group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Id of the device group. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> getDeviceGroupWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId);



  /**
   * 
   * Get a device group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Id of the device group. (required)
   * @return DeviceGroup
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Accept: application/json",
  })
  DeviceGroup getDeviceGroup_2(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId);

  /**
   * 
   * Similar to <code>getDeviceGroup_0</code> but it also returns the http response headers .
   * Get a device group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param deviceGroupId - Id of the device group. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> getDeviceGroup_2WithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId);



  /**
   * 
   * Get device groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return List&lt;DeviceGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups")
  @Headers({
    "Accept: application/json",
  })
  List<DeviceGroup> getDeviceGroups(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>getDeviceGroups</code> but it also returns the http response headers .
   * Get device groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<DeviceGroup>> getDeviceGroupsWithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * Get device groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return List&lt;DeviceGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups")
  @Headers({
    "Accept: application/json",
  })
  List<DeviceGroup> getDeviceGroups_3(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>getDeviceGroups_0</code> but it also returns the http response headers .
   * Get device groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicDataRW&#x60;, &#x60;DeviceAdmin&#x60;, &#x60;DBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/deviceGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<DeviceGroup>> getDeviceGroups_3WithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param updateDeviceGroupRequest  (required)
   * @return DeviceGroup
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceGroup updateDeviceGroups(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, UpdateDeviceGroupRequest updateDeviceGroupRequest);

  /**
   * 
   * Similar to <code>updateDeviceGroups</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param updateDeviceGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> updateDeviceGroupsWithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, UpdateDeviceGroupRequest updateDeviceGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param updateDeviceGroupRequest  (required)
   * @return DeviceGroup
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  DeviceGroup updateDeviceGroups_4(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, UpdateDeviceGroupRequest updateDeviceGroupRequest);

  /**
   * 
   * Similar to <code>updateDeviceGroups_0</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param deviceGroupId  (required)
   * @param updateDeviceGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/deviceGroups/{deviceGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<DeviceGroup> updateDeviceGroups_4WithHttpInfo(@Param("customerId") String customerId, @Param("deviceGroupId") String deviceGroupId, UpdateDeviceGroupRequest updateDeviceGroupRequest);


}
