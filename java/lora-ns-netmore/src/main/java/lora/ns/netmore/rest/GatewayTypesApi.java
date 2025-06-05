package lora.ns.netmore.rest;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import lora.ns.netmore.rest.model.GatewayType;
import lora.ns.netmore.rest.model.GatewayTypeConfig;

public interface GatewayTypesApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param networkServerId  (required)
   * @return List&lt;GatewayTypeConfig&gt;
   */
  @RequestLine("GET /gatewayTypeConfigs/list/{networkServerId}")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayTypeConfig> getGatewayTypeConfigForNetworkServer(@Param("networkServerId") String networkServerId);

  /**
   * 
   * Similar to <code>getGatewayTypeConfigForNetworkServer</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @param networkServerId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gatewayTypeConfigs/list/{networkServerId}")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayTypeConfig> getGatewayTypeConfigForNetworkServerWithHttpInfo(@Param("networkServerId") String networkServerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @return List&lt;GatewayTypeConfig&gt;
   */
  @RequestLine("GET /gatewayTypeConfigs")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayTypeConfig> getGatewayTypeConfigs();

  /**
   * 
   * Similar to <code>getGatewayTypeConfigs</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gatewayTypeConfigs")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayTypeConfig> getGatewayTypeConfigsWithHttpInfo();



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @return List&lt;GatewayType&gt;
   */
  @RequestLine("GET /gatewayTypes")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayType> getGatewayTypes();

  /**
   * 
   * Similar to <code>getGatewayTypes</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;GatewayAdmin&#x60;, &#x60;GBasicData&#x60;, &#x60;GBasicDataRW&#x60;&lt;br&gt;
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /gatewayTypes")
  @Headers({
    "Accept: application/json",
  })
  List<GatewayType> getGatewayTypesWithHttpInfo();


}
