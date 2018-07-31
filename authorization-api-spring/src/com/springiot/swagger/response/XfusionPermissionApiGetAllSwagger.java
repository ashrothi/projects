package com.springiot.swagger.response;
import java.util.List;
public class XfusionPermissionApiGetAllSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionPermissionApiGetAll> object;
public List<XfusionPermissionApiGetAll> getObject() {return object;}
public void setObject(List<XfusionPermissionApiGetAll> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionPermissionApiGetAll{
private Integer api_id;
public Integer getApi_id() {return api_id;}
public void setApi_id(Integer api_id) {this.api_id = api_id;}
private String name;
public String getName() {return name;}
public void setName(String name) {this.name = name;}
private String url;
public String getUrl() {return url;}
public void setUrl(String url) {this.url = url;}
private String lowered_url;
public String getLowered_url() {return lowered_url;}
public void setLowered_url(String lowered_url) {this.lowered_url = lowered_url;}
public Object getIs_bit() {return is_bit;}
public void setIs_bit(Object is_bit) {this.is_bit = is_bit;}
private Object is_bit;
}
