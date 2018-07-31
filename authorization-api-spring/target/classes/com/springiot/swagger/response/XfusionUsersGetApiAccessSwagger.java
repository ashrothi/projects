package com.springiot.swagger.response;
import java.util.List;
public class XfusionUsersGetApiAccessSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionUsersGetApiAccess> object;
public List<XfusionUsersGetApiAccess> getObject() {return object;}
public void setObject(List<XfusionUsersGetApiAccess> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionUsersGetApiAccess{
private Integer users_id;
public Integer getUsers_id() {return users_id;}
public void setUsers_id(Integer users_id) {this.users_id = users_id;}
private String users_user_key;
public String getUsers_user_key() {return users_user_key;}
public void setUsers_user_key(String users_user_key) {this.users_user_key = users_user_key;}
public Object getUsers_is_deleted() {return users_is_deleted;}
public void setUsers_is_deleted(Object users_is_deleted) {this.users_is_deleted = users_is_deleted;}
private Object users_is_deleted;
public Object getUsers_last_activity_date() {return users_last_activity_date;}
public void setUsers_last_activity_date(Object users_last_activity_date) {this.users_last_activity_date = users_last_activity_date;}
private Object users_last_activity_date;
private Integer roles_id;
public Integer getRoles_id() {return roles_id;}
public void setRoles_id(Integer roles_id) {this.roles_id = roles_id;}
private String roles_name;
public String getRoles_name() {return roles_name;}
public void setRoles_name(String roles_name) {this.roles_name = roles_name;}
private String roles_access_key;
public String getRoles_access_key() {return roles_access_key;}
public void setRoles_access_key(String roles_access_key) {this.roles_access_key = roles_access_key;}
private Integer applications_id;
public Integer getApplications_id() {return applications_id;}
public void setApplications_id(Integer applications_id) {this.applications_id = applications_id;}
private String applications_name;
public String getApplications_name() {return applications_name;}
public void setApplications_name(String applications_name) {this.applications_name = applications_name;}
private Integer role_api_access_id;
public Integer getRole_api_access_id() {return role_api_access_id;}
public void setRole_api_access_id(Integer role_api_access_id) {this.role_api_access_id = role_api_access_id;}
private Integer role_api_access_role_id;
public Integer getRole_api_access_role_id() {return role_api_access_role_id;}
public void setRole_api_access_role_id(Integer role_api_access_role_id) {this.role_api_access_role_id = role_api_access_role_id;}
private Integer role_api_access_view_id;
public Integer getRole_api_access_view_id() {return role_api_access_view_id;}
public void setRole_api_access_view_id(Integer role_api_access_view_id) {this.role_api_access_view_id = role_api_access_view_id;}
private String api_lowered_url;
public String getApi_lowered_url() {return api_lowered_url;}
public void setApi_lowered_url(String api_lowered_url) {this.api_lowered_url = api_lowered_url;}
private String api_url;
public String getApi_url() {return api_url;}
public void setApi_url(String api_url) {this.api_url = api_url;}
}
