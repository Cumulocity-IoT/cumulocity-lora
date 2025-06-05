package lora.ns.netmore.rest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.ApiResponse;
import lora.ns.netmore.rest.model.Gateway;
import lora.ns.netmore.rest.model.PatchGatewayRequest;

public interface LoRaWanGatewaysApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param gwEui  (required)
   * @return Gateway
   */
  @RequestLine("GET /gateways/LoRaWAN/{gwEui}")
  @Headers({
    "Accept: application/json",
  })
  Gateway getLoraGateway(@Param("gwEui") String gwEui);

  /**
   * 
   * Similar to <code>getLoraGateway</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GBasicDataRW&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;&lt;br&gt;
   * @param gwEui  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gateways/LoRaWAN/{gwEui}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Gateway> getLoraGatewayWithHttpInfo(@Param("gwEui") String gwEui);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param gwEui  (required)
   * @param patchGatewayRequest  (required)
   * @return Gateway
   */
  @RequestLine("PATCH /gateways/LoRaWAN/{gwEui}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Gateway patchGatewayLoraWan(@Param("gwEui") String gwEui, PatchGatewayRequest patchGatewayRequest);

  /**
   * 
   * Similar to <code>patchGatewayLoraWan</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param gwEui  (required)
   * @param patchGatewayRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /gateways/LoRaWAN/{gwEui}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Gateway> patchGatewayLoraWanWithHttpInfo(@Param("gwEui") String gwEui, PatchGatewayRequest patchGatewayRequest);


}
