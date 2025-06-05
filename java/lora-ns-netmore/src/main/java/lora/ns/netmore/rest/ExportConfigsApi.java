package lora.ns.netmore.rest;

import java.util.HashMap;
import java.util.List;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import lora.ns.netmore.rest.model.CreateExportConfigRequest;
import lora.ns.netmore.rest.model.ExportConfig;
import lora.ns.netmore.rest.model.ExportFormatData;
import lora.ns.netmore.rest.model.UpdateExportConfigRequest;

public interface ExportConfigsApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createExportConfigRequest  (required)
   * @return ExportConfig
   */
  @RequestLine("POST /customers/{customerId}/exportConfigs")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfig createExportConfig(@Param("customerId") String customerId, CreateExportConfigRequest createExportConfigRequest);

  /**
   * 
   * Similar to <code>createExportConfig</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createExportConfigRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/exportConfigs")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfig createExportConfigWithHttpInfo(@Param("customerId") String customerId, CreateExportConfigRequest createExportConfigRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteExportConfig(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId);

  /**
   * 
   * Similar to <code>deleteExportConfig</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteExportConfigWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   * @return ExportConfig
   */
  @RequestLine("GET /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Accept: application/json",
  })
  ExportConfig getExportConfig(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId);

  /**
   * 
   * Similar to <code>getExportConfig</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Accept: application/json",
  })
  ExportConfig getExportConfigWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param includeCommon  (optional, default to false)
   * @param includeInherited  (optional, default to false)
   * @return List&lt;ExportConfig&gt;
   */
  @RequestLine("GET /customers/{customerId}/exportConfigs?includeCommon={includeCommon}&includeInherited={includeInherited}")
  @Headers({
    "Accept: application/json",
  })
  List<ExportConfig> listExportConfig(@Param("customerId") String customerId, @Param("includeCommon") Boolean includeCommon, @Param("includeInherited") Boolean includeInherited);

  /**
   * 
   * Similar to <code>listExportConfig</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param includeCommon  (optional, default to false)
   * @param includeInherited  (optional, default to false)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/exportConfigs?includeCommon={includeCommon}&includeInherited={includeInherited}")
  @Headers({
    "Accept: application/json",
  })
  List<ExportConfig> listExportConfigWithHttpInfo(@Param("customerId") String customerId, @Param("includeCommon") Boolean includeCommon, @Param("includeInherited") Boolean includeInherited);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>listExportConfig</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListExportConfigQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeCommon -  (optional, default to false)</li>
   *   <li>includeInherited -  (optional, default to false)</li>
   *   </ul>
   * @return List&lt;ExportConfig&gt;
   */
  @RequestLine("GET /customers/{customerId}/exportConfigs?includeCommon={includeCommon}&includeInherited={includeInherited}")
  @Headers({
  "Accept: application/json",
  })
  List<ExportConfig> listExportConfig(@Param("customerId") String customerId, @QueryMap(encoded=true) ListExportConfigQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>listExportConfig</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>includeCommon -  (optional, default to false)</li>
          *   <li>includeInherited -  (optional, default to false)</li>
      *   </ul>
          * @return List&lt;ExportConfig&gt;
      */
      @RequestLine("GET /customers/{customerId}/exportConfigs?includeCommon={includeCommon}&includeInherited={includeInherited}")
      @Headers({
    "Accept: application/json",
      })
   List<ExportConfig> listExportConfigWithHttpInfo(@Param("customerId") String customerId, @QueryMap(encoded=true) ListExportConfigQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>listExportConfig</code> method in a fluent style.
   */
  public static class ListExportConfigQueryParams extends HashMap<String, Object> {
    public ListExportConfigQueryParams includeCommon(final Boolean value) {
      put("includeCommon", value);
      return this;
    }
    public ListExportConfigQueryParams includeInherited(final Boolean value) {
      put("includeInherited", value);
      return this;
    }
  }

  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @return List&lt;ExportFormatData&gt;
   */
  @RequestLine("GET /customers/{customerId}/exportFormats")
  @Headers({
    "Accept: application/json",
  })
  List<ExportFormatData> listExportFormats(@Param("customerId") String customerId);

  /**
   * 
   * Similar to <code>listExportFormats</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/exportFormats")
  @Headers({
    "Accept: application/json",
  })
  List<ExportFormatData> listExportFormatsWithHttpInfo(@Param("customerId") String customerId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   * @param updateExportConfigRequest  (required)
   * @return ExportConfig
   */
  @RequestLine("PATCH /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfig updateExportConfig(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId, UpdateExportConfigRequest updateExportConfigRequest);

  /**
   * 
   * Similar to <code>updateExportConfig</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigId  (required)
   * @param updateExportConfigRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/exportConfigs/{exportConfigId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfig updateExportConfigWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigId") String exportConfigId, UpdateExportConfigRequest updateExportConfigRequest);


}
