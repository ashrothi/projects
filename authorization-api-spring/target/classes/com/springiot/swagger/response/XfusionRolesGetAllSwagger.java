package com.springiot.swagger.response;
import java.util.List;
public class XfusionRolesGetAllSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionRolesGetAll> object;
public List<XfusionRolesGetAll> getObject() {return object;}
public void setObject(List<XfusionRolesGetAll> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionRolesGetAll{
private Integer roles_id;
public Integer getRoles_id() {return roles_id;}
public void setRoles_id(Integer roles_id) {this.roles_id = roles_id;}
private String roles_name;
public String getRoles_name() {return roles_name;}
public void setRoles_name(String roles_name) {this.roles_name = roles_name;}
private Integer applications_id;
public Integer getApplications_id() {return applications_id;}
public void setApplications_id(Integer applications_id) {this.applications_id = applications_id;}
private String applications_name;
public String getApplications_name() {return applications_name;}
public void setApplications_name(String applications_name) {this.applications_name = applications_name;}
}
