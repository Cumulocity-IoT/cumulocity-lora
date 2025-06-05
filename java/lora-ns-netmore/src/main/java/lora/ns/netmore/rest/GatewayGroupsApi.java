package lora.ns.netmore.rest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.AuditRecord;
import lora.ns.netmore.rest.model.CreateGatewayGroupRequest;
import lora.ns.netmore.rest.model.GatewayGroup;
import lora.ns.netmore.rest.model.UpdateGatewayGroupRequest;

public interface GatewayGroupsApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createGatewayGroupRequest  (required)
   * @return GatewayGroup
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  GatewayGroup createGatewayGroup(@Param("customerId") String customerId, CreateGatewayGroupRequest createGatewayGroupRequest);

  /**
   * 
   * Similar to <code>createGatewayGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createGatewayGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> createGatewayGroupWithHttpInfo(@Param("customerId") String customerId, CreateGatewayGroupRequest createGatewayGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createGatewayGroupRequest  (required)
   * @return GatewayGroup
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  GatewayGroup createGatewayGroup_1(@Param("customerId") String customerId, CreateGatewayGroupRequest createGatewayGroupRequest);

  /**
   * 
   * Similar to <code>createGatewayGroup_0</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createGatewayGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> createGatewayGroup_1WithHttpInfo(@Param("customerId") String customerId, CreateGatewayGroupRequest createGatewayGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteGatewayGroupFromCustomer(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>deleteGatewayGroupFromCustomer</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteGatewayGroupFromCustomerWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteGatewayGroupFromCustomer_2(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>deleteGatewayGroupFromCustomer_0</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteGatewayGroupFromCustomer_2WithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * Get all gateway groups you have access to including sub customer&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @return List&lt;GatewayGroup&gt;
   */
  @RequestLine("GET /gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayGroup> getByYourAccess();

  /**
   * 
   * Similar to <code>getByYourAccess</code> but it also returns the http response headers .
   * Get all gateway groups you have access to including sub customer&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<GatewayGroup>> getByYourAccessWithHttpInfo();



  /**
   * 
   * Get all gateway groups you have access to including sub customer&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @return List&lt;GatewayGroup&gt;
   */
  @RequestLine("GET /gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayGroup> getByYourAccess_3();

  /**
   * 
   * Similar to <code>getByYourAccess_0</code> but it also returns the http response headers .
   * Get all gateway groups you have access to including sub customer&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<GatewayGroup>> getByYourAccess_3WithHttpInfo();



  /**
   * 
   * Get a gateway group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param gatewayGroupId - Id of the gateway group. (required)
   * @return GatewayGroup
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  GatewayGroup getGatewayGroup(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>getGatewayGroup</code> but it also returns the http response headers .
   * Get a gateway group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param gatewayGroupId - Id of the gateway group. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> getGatewayGroupWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * Get audit logs for gateway Groups.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return List&lt;AuditRecord&gt;
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/audit")
  @Headers({
    "Accept: application/json",
  })
  List<AuditRecord> getGatewayGroupAudit(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>getGatewayGroupAudit</code> but it also returns the http response headers .
   * Get audit logs for gateway Groups.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/audit")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<AuditRecord>> getGatewayGroupAuditWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * Get audit logs for gateway Groups.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return List&lt;AuditRecord&gt;
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/audit")
  @Headers({
    "Accept: application/json",
  })
  List<AuditRecord> getGatewayGroupAudit_4(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>getGatewayGroupAudit_0</code> but it also returns the http response headers .
   * Get audit logs for gateway Groups.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/audit")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<AuditRecord>> getGatewayGroupAudit_4WithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * Get a gateway group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param gatewayGroupId - Id of the gateway group. (required)
   * @return GatewayGroup
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  GatewayGroup getGatewayGroup_5(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>getGatewayGroup_0</code> but it also returns the http response headers .
   * Get a gateway group id from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @param gatewayGroupId - Id of the gateway group. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> getGatewayGroup_5WithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * Get gateway groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return List&lt;GatewayGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayGroup> getGatewayGroups(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>getGatewayGroups</code> but it also returns the http response headers .
   * Get gateway groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<GatewayGroup>> getGatewayGroupsWithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * Get gateway groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return List&lt;GatewayGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayGroup> getGatewayGroups_6(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>getGatewayGroups_0</code> but it also returns the http response headers .
   * Get gateway groups from the customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId - Id of the customer. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<List<GatewayGroup>> getGatewayGroups_6WithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param updateGatewayGroupRequest  (required)
   * @return GatewayGroup
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  GatewayGroup updateGatewayGroup(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, UpdateGatewayGroupRequest updateGatewayGroupRequest);

  /**
   * 
   * Similar to <code>updateGatewayGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param updateGatewayGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> updateGatewayGroupWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, UpdateGatewayGroupRequest updateGatewayGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param updateGatewayGroupRequest  (required)
   * @return GatewayGroup
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  GatewayGroup updateGatewayGroup_7(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, UpdateGatewayGroupRequest updateGatewayGroupRequest);

  /**
   * 
   * Similar to <code>updateGatewayGroup_0</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param updateGatewayGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<GatewayGroup> updateGatewayGroup_7WithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, UpdateGatewayGroupRequest updateGatewayGroupRequest);


}
