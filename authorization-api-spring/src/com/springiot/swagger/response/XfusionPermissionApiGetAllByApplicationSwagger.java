package com.springiot.swagger.response;
import java.util.List;
public class XfusionPermissionApiGetAllByApplicationSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionPermissionApiGetAllByApplication> object;
public List<XfusionPermissionApiGetAllByApplication> getObject() {return object;}
public void setObject(List<XfusionPermissionApiGetAllByApplication> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionPermissionApiGetAllByApplication{
private Integer applications_id;
public Integer getApplications_id() {return applications_id;}
public void setApplications_id(Integer applications_id) {this.applications_id = applications_id;}
private String applications_name;
public String getApplications_name() {return applications_name;}
public void setApplications_name(String applications_name) {this.applications_name = applications_name;}
private String applications_url;
public String getApplications_url() {return applications_url;}
public void setApplications_url(String applications_url) {this.applications_url = applications_url;}
private String applications_description;
public String getApplications_description() {return applications_description;}
public void setApplications_description(String applications_description) {this.applications_description = applications_description;}
private String applications_service_url;
public String getApplications_service_url() {return applications_service_url;}
public void setApplications_service_url(String applications_service_url) {this.applications_service_url = applications_service_url;}
private String applications_view_url;
public String getApplications_view_url() {return applications_view_url;}
public void setApplications_view_url(String applications_view_url) {this.applications_view_url = applications_view_url;}
private String applications_api_url;
public String getApplications_api_url() {return applications_api_url;}
public void setApplications_api_url(String applications_api_url) {this.applications_api_url = applications_api_url;}
private String applications_application_key;
public String getApplications_application_key() {return applications_application_key;}
public void setApplications_application_key(String applications_application_key) {this.applications_application_key = applications_application_key;}
private Integer roles_id;
public Integer getRoles_id() {return roles_id;}
public void setRoles_id(Integer roles_id) {this.roles_id = roles_id;}
private String roles_name;
public String getRoles_name() {return roles_name;}
public void setRoles_name(String roles_name) {this.roles_name = roles_name;}
private Integer roles_application_id;
public Integer getRoles_application_id() {return roles_application_id;}
public void setRoles_application_id(Integer roles_application_id) {this.roles_application_id = roles_application_id;}
private Integer role_api_access_role_id;
public Integer getRole_api_access_role_id() {return role_api_access_role_id;}
public void setRole_api_access_role_id(Integer role_api_access_role_id) {this.role_api_access_role_id = role_api_access_role_id;}
private Integer role_api_access_api_id;
public Integer getRole_api_access_api_id() {return role_api_access_api_id;}
public void setRole_api_access_api_id(Integer role_api_access_api_id) {this.role_api_access_api_id = role_api_access_api_id;}
private Integer api_api_id;
public Integer getApi_api_id() {return api_api_id;}
public void setApi_api_id(Integer api_api_id) {this.api_api_id = api_api_id;}
private Integer api_application_id;
public Integer getApi_application_id() {return api_application_id;}
public void setApi_application_id(Integer api_application_id) {this.api_application_id = api_application_id;}
private String api_name;
public String getApi_name() {return api_name;}
public void setApi_name(String api_name) {this.api_name = api_name;}
private String api_url;
public String getApi_url() {return api_url;}
public void setApi_url(String api_url) {this.api_url = api_url;}
private String api_lowered_url;
public String getApi_lowered_url() {return api_lowered_url;}
public void setApi_lowered_url(String api_lowered_url) {this.api_lowered_url = api_lowered_url;}
public Object getApi_is_added() {return api_is_added;}
public void setApi_is_added(Object api_is_added) {this.api_is_added = api_is_added;}
private Object api_is_added;
}
