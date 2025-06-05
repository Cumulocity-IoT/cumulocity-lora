package lora.ns.netmore.rest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.CreateGatewayRequest;
import lora.ns.netmore.rest.model.Gateway;
import lora.ns.netmore.rest.model.PatchGatewayRequest;

public interface GatewaysApi {


  /**
   * 
   * Create meta data for a gateway.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param createGatewayRequest  (required)
   * @return Gateway
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Gateway createGateway(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, CreateGatewayRequest createGatewayRequest);

  /**
   * 
   * Similar to <code>createGateway</code> but it also returns the http response headers .
   * Create meta data for a gateway.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param createGatewayRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Gateway createGatewayWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, CreateGatewayRequest createGatewayRequest);



  /**
   * 
   * Get the information about all gateways for a customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @return List&lt;Gateway&gt;
   */
  @RequestLine("GET /customers/{customerId}/gateways")
  @Headers({
    "Accept: application/json",
  })
  List<Gateway> getAllByCustomer(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>getAllByCustomer</code> but it also returns the http response headers .
   * Get the information about all gateways for a customer.&lt;br&gt;&lt;br&gt;**Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gateways")
  @Headers({
    "Accept: application/json",
  })
  List<Gateway> getAllByCustomerWithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return List&lt;Gateway&gt;
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways")
  @Headers({
    "Accept: application/json",
  })
  List<Gateway> getAllByGatewayGroup(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);

  /**
   * 
   * Similar to <code>getAllByGatewayGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways")
  @Headers({
    "Accept: application/json",
  })
  List<Gateway> getAllByGatewayGroupWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param gatewayId  (required)
   * @return Gateway
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways/{gatewayId}")
  @Headers({
    "Accept: application/json",
  })
  Gateway getGateway(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, @Param("gatewayId") String gatewayId);

  /**
   * 
   * Similar to <code>getGateway</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param gatewayId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways/{gatewayId}")
  @Headers({
    "Accept: application/json",
  })
  Gateway getGatewayWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, @Param("gatewayId") String gatewayId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param gatewayId  (required)
   * @param patchGatewayRequest  (required)
   * @return Gateway
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways/{gatewayId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Gateway patchGateway(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, @Param("gatewayId") String gatewayId, PatchGatewayRequest patchGatewayRequest);

  /**
   * 
   * Similar to <code>patchGateway</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param gatewayGroupId  (required)
   * @param gatewayId  (required)
   * @param patchGatewayRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/gatewayGroups/{gatewayGroupId}/gateways/{gatewayId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Gateway patchGatewayWithHttpInfo(@Param("customerId") String customerId, @Param("gatewayGroupId") String gatewayGroupId, @Param("gatewayId") String gatewayId, PatchGatewayRequest patchGatewayRequest);


}
