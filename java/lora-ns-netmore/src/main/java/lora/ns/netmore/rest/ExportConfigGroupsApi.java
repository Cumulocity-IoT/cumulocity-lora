package lora.ns.netmore.rest;

import lora.ns.netmore.rest.model.CreateExportConfigGroupRequest;
import lora.ns.netmore.rest.model.ExportConfigGroup;
import lora.ns.netmore.rest.model.UpdateExportConfigGroupRequest;

import java.util.HashMap;
import java.util.List;
import feign.*;

public interface ExportConfigGroupsApi {


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createExportConfigGroupRequest  (required)
   * @return ExportConfigGroup
   */
  @RequestLine("POST /customers/{customerId}/exportConfigGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfigGroup createExportConfigGroup(@Param("customerId") String customerId, CreateExportConfigGroupRequest createExportConfigGroupRequest);

  /**
   * 
   * Similar to <code>createExportConfigGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param createExportConfigGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /customers/{customerId}/exportConfigGroups")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfigGroup createExportConfigGroupWithHttpInfo(@Param("customerId") String customerId, CreateExportConfigGroupRequest createExportConfigGroupRequest);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteExportConfigGroup(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId);

  /**
   * 
   * Similar to <code>deleteExportConfigGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   */
  @RequestLine("DELETE /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Accept: application/json",
  })
  void deleteExportConfigGroupWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   * @return ExportConfigGroup
   */
  @RequestLine("GET /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ExportConfigGroup getExportConfigGroup(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId);

  /**
   * 
   * Similar to <code>getExportConfigGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Accept: application/json",
  })
  ExportConfigGroup getExportConfigGroupWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId);



  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param includeInherited  (optional, default to false)
   * @return List&lt;ExportConfigGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/exportConfigGroups?includeInherited={includeInherited}")
  @Headers({
    "Accept: application/json",
  })
  List<ExportConfigGroup> listExportConfigGroups(@Param("customerId") String customerId, @Param("includeInherited") Boolean includeInherited);

  /**
   * 
   * Similar to <code>listExportConfigGroups</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param includeInherited  (optional, default to false)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /customers/{customerId}/exportConfigGroups?includeInherited={includeInherited}")
  @Headers({
    "Accept: application/json",
  })
  List<ExportConfigGroup> listExportConfigGroupsWithHttpInfo(@Param("customerId") String customerId, @Param("includeInherited") Boolean includeInherited);


  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
   * Note, this is equivalent to the other <code>listExportConfigGroups</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListExportConfigGroupsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param customerId  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>includeInherited -  (optional, default to false)</li>
   *   </ul>
   * @return List&lt;ExportConfigGroup&gt;
   */
  @RequestLine("GET /customers/{customerId}/exportConfigGroups?includeInherited={includeInherited}")
  @Headers({
  "Accept: application/json",
  })
  List<ExportConfigGroup> listExportConfigGroups(@Param("customerId") String customerId, @QueryMap(encoded=true) ListExportConfigGroupsQueryParams queryParams);

  /**
  * 
  * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;, &#x60;DBasicData&#x60;, &#x60;DBasicDataRW&#x60;&lt;br&gt;
  * Note, this is equivalent to the other <code>listExportConfigGroups</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param customerId  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>includeInherited -  (optional, default to false)</li>
      *   </ul>
          * @return List&lt;ExportConfigGroup&gt;
      */
      @RequestLine("GET /customers/{customerId}/exportConfigGroups?includeInherited={includeInherited}")
      @Headers({
    "Accept: application/json",
      })
   List<ExportConfigGroup> listExportConfigGroupsWithHttpInfo(@Param("customerId") String customerId, @QueryMap(encoded=true) ListExportConfigGroupsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>listExportConfigGroups</code> method in a fluent style.
   */
  public static class ListExportConfigGroupsQueryParams extends HashMap<String, Object> {
    public ListExportConfigGroupsQueryParams includeInherited(final Boolean value) {
      put("includeInherited", value);
      return this;
    }
  }

  /**
   * 
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   * @param updateExportConfigGroupRequest  (required)
   * @return ExportConfigGroup
   */
  @RequestLine("PATCH /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfigGroup updateExportConfigGroup(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId, UpdateExportConfigGroupRequest updateExportConfigGroupRequest);

  /**
   * 
   * Similar to <code>updateExportConfigGroup</code> but it also returns the http response headers .
   * **Security**&lt;br&gt;user-jwt: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;api-key: &#x60;GlobalAdmin&#x60;, &#x60;CustomerAdmin&#x60;, &#x60;OperatorAdmin&#x60;&lt;br&gt;
   * @param customerId  (required)
   * @param exportConfigGroupId  (required)
   * @param updateExportConfigGroupRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /customers/{customerId}/exportConfigGroups/{exportConfigGroupId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ExportConfigGroup updateExportConfigGroupWithHttpInfo(@Param("customerId") String customerId, @Param("exportConfigGroupId") String exportConfigGroupId, UpdateExportConfigGroupRequest updateExportConfigGroupRequest);


}
