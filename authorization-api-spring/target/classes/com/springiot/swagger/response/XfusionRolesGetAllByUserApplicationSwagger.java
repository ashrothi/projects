package com.springiot.swagger.response;
import java.util.List;
public class XfusionRolesGetAllByUserApplicationSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionRolesGetAllByUserApplication> object;
public List<XfusionRolesGetAllByUserApplication> getObject() {return object;}
public void setObject(List<XfusionRolesGetAllByUserApplication> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionRolesGetAllByUserApplication{
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String name;
public String getName() {return name;}
public void setName(String name) {this.name = name;}
private String access_key;
public String getAccess_key() {return access_key;}
public void setAccess_key(String access_key) {this.access_key = access_key;}
private Integer application_id;
public Integer getApplication_id() {return application_id;}
public void setApplication_id(Integer application_id) {this.application_id = application_id;}
}
