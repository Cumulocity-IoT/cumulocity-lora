/*
 * netmore-web-backend
 * Front end for web services.
 *
 * The version of the OpenAPI document: 1.2.83
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package lora.ns.netmore.rest.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lora.ns.netmore.rest.model.UserRights;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * JwtUser
 */
@JsonPropertyOrder({
  JwtUser.JSON_PROPERTY_USER_ID,
  JwtUser.JSON_PROPERTY_USERNAME,
  JwtUser.JSON_PROPERTY_CUSTOMER_ID,
  JwtUser.JSON_PROPERTY_GLOBAL_ADMIN,
  JwtUser.JSON_PROPERTY_RIGHTS,
  JwtUser.JSON_PROPERTY_CREATED,
  JwtUser.JSON_PROPERTY_CREATED_BY,
  JwtUser.JSON_PROPERTY_LAST_UPDATED,
  JwtUser.JSON_PROPERTY_LAST_UPDATED_BY,
  JwtUser.JSON_PROPERTY_EMAIL,
  JwtUser.JSON_PROPERTY_ACCESS_TOKEN
})
public class JwtUser {
  public static final String JSON_PROPERTY_USER_ID = "userId";
  private String userId;

  public static final String JSON_PROPERTY_USERNAME = "username";
  private String username;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_GLOBAL_ADMIN = "globalAdmin";
  private Boolean globalAdmin;

  public static final String JSON_PROPERTY_RIGHTS = "rights";
  private List<UserRights> rights = new ArrayList<>();

  public static final String JSON_PROPERTY_CREATED = "created";
  private String created;

  public static final String JSON_PROPERTY_CREATED_BY = "createdBy";
  private String createdBy;

  public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
  private String lastUpdated;

  public static final String JSON_PROPERTY_LAST_UPDATED_BY = "lastUpdatedBy";
  private String lastUpdatedBy;

  public static final String JSON_PROPERTY_EMAIL = "email";
  private String email;

  public static final String JSON_PROPERTY_ACCESS_TOKEN = "accessToken";
  private String accessToken;

  public JwtUser() {
  }

  public JwtUser userId(String userId) {
    
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/

  @JsonProperty(JSON_PROPERTY_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUserId() {
    return userId;
  }


  @JsonProperty(JSON_PROPERTY_USER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUserId(String userId) {
    this.userId = userId;
  }


  public JwtUser username(String username) {
    
    this.username = username;
    return this;
  }

   /**
   * Get username
   * @return username
  **/

  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getUsername() {
    return username;
  }


  @JsonProperty(JSON_PROPERTY_USERNAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setUsername(String username) {
    this.username = username;
  }


  public JwtUser customerId(String customerId) {
    
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/

  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCustomerId() {
    return customerId;
  }


  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public JwtUser globalAdmin(Boolean globalAdmin) {
    
    this.globalAdmin = globalAdmin;
    return this;
  }

   /**
   * Get globalAdmin
   * @return globalAdmin
  **/

  @JsonProperty(JSON_PROPERTY_GLOBAL_ADMIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getGlobalAdmin() {
    return globalAdmin;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ADMIN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalAdmin(Boolean globalAdmin) {
    this.globalAdmin = globalAdmin;
  }


  public JwtUser rights(List<UserRights> rights) {
    
    this.rights = rights;
    return this;
  }

  public JwtUser addRightsItem(UserRights rightsItem) {
    if (this.rights == null) {
      this.rights = new ArrayList<>();
    }
    this.rights.add(rightsItem);
    return this;
  }

   /**
   * Get rights
   * @return rights
  **/

  @JsonProperty(JSON_PROPERTY_RIGHTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<UserRights> getRights() {
    return rights;
  }


  @JsonProperty(JSON_PROPERTY_RIGHTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRights(List<UserRights> rights) {
    this.rights = rights;
  }


  public JwtUser created(String created) {
    
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/

  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreated() {
    return created;
  }


  @JsonProperty(JSON_PROPERTY_CREATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreated(String created) {
    this.created = created;
  }


  public JwtUser createdBy(String createdBy) {
    
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Get createdBy
   * @return createdBy
  **/

  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getCreatedBy() {
    return createdBy;
  }


  @JsonProperty(JSON_PROPERTY_CREATED_BY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }


  public JwtUser lastUpdated(String lastUpdated) {
    
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastUpdated() {
    return lastUpdated;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }


  public JwtUser lastUpdatedBy(String lastUpdatedBy) {
    
    this.lastUpdatedBy = lastUpdatedBy;
    return this;
  }

   /**
   * Get lastUpdatedBy
   * @return lastUpdatedBy
  **/

  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getLastUpdatedBy() {
    return lastUpdatedBy;
  }


  @JsonProperty(JSON_PROPERTY_LAST_UPDATED_BY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setLastUpdatedBy(String lastUpdatedBy) {
    this.lastUpdatedBy = lastUpdatedBy;
  }


  public JwtUser email(String email) {
    
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/

  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEmail() {
    return email;
  }


  @JsonProperty(JSON_PROPERTY_EMAIL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEmail(String email) {
    this.email = email;
  }


  public JwtUser accessToken(String accessToken) {
    
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Get accessToken
   * @return accessToken
  **/

  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccessToken() {
    return accessToken;
  }


  @JsonProperty(JSON_PROPERTY_ACCESS_TOKEN)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JwtUser jwtUser = (JwtUser) o;
    return Objects.equals(this.userId, jwtUser.userId) &&
        Objects.equals(this.username, jwtUser.username) &&
        Objects.equals(this.customerId, jwtUser.customerId) &&
        Objects.equals(this.globalAdmin, jwtUser.globalAdmin) &&
        Objects.equals(this.rights, jwtUser.rights) &&
        Objects.equals(this.created, jwtUser.created) &&
        Objects.equals(this.createdBy, jwtUser.createdBy) &&
        Objects.equals(this.lastUpdated, jwtUser.lastUpdated) &&
        Objects.equals(this.lastUpdatedBy, jwtUser.lastUpdatedBy) &&
        Objects.equals(this.email, jwtUser.email) &&
        Objects.equals(this.accessToken, jwtUser.accessToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, username, customerId, globalAdmin, rights, created, createdBy, lastUpdated, lastUpdatedBy, email, accessToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JwtUser {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    globalAdmin: ").append(toIndentedString(globalAdmin)).append("\n");
    sb.append("    rights: ").append(toIndentedString(rights)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    lastUpdatedBy: ").append(toIndentedString(lastUpdatedBy)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

