package com.springiot.swagger.response;
import java.util.List;
public class XfusionUsersGetAllSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionUsersGetAll> object;
public List<XfusionUsersGetAll> getObject() {return object;}
public void setObject(List<XfusionUsersGetAll> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionUsersGetAll{
private Integer users_id;
public Integer getUsers_id() {return users_id;}
public void setUsers_id(Integer users_id) {this.users_id = users_id;}
private String users_name;
public String getUsers_name() {return users_name;}
public void setUsers_name(String users_name) {this.users_name = users_name;}
private Integer roles_id;
public Integer getRoles_id() {return roles_id;}
public void setRoles_id(Integer roles_id) {this.roles_id = roles_id;}
private String roles_name;
public String getRoles_name() {return roles_name;}
public void setRoles_name(String roles_name) {this.roles_name = roles_name;}
private String users_user_key;
public String getUsers_user_key() {return users_user_key;}
public void setUsers_user_key(String users_user_key) {this.users_user_key = users_user_key;}
private Integer applications_id;
public Integer getApplications_id() {return applications_id;}
public void setApplications_id(Integer applications_id) {this.applications_id = applications_id;}
private String applications_name;
public String getApplications_name() {return applications_name;}
public void setApplications_name(String applications_name) {this.applications_name = applications_name;}
private String applications_alias;
public String getApplications_alias() {return applications_alias;}
public void setApplications_alias(String applications_alias) {this.applications_alias = applications_alias;}
private String applications_url;
public String getApplications_url() {return applications_url;}
public void setApplications_url(String applications_url) {this.applications_url = applications_url;}
private String applications_description;
public String getApplications_description() {return applications_description;}
public void setApplications_description(String applications_description) {this.applications_description = applications_description;}
}
