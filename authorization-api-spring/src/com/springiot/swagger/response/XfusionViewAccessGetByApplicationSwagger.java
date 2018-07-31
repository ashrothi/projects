package com.springiot.swagger.response;
import java.util.List;
public class XfusionViewAccessGetByApplicationSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionViewAccessGetByApplication> object;
public List<XfusionViewAccessGetByApplication> getObject() {return object;}
public void setObject(List<XfusionViewAccessGetByApplication> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionViewAccessGetByApplication{
private Integer roles_id;
public Integer getRoles_id() {return roles_id;}
public void setRoles_id(Integer roles_id) {this.roles_id = roles_id;}
private String roles_name;
public String getRoles_name() {return roles_name;}
public void setRoles_name(String roles_name) {this.roles_name = roles_name;}
private String view_url;
public String getView_url() {return view_url;}
public void setView_url(String view_url) {this.view_url = view_url;}
}
