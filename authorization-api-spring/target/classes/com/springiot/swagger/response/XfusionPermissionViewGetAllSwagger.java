package com.springiot.swagger.response;
import java.util.List;
public class XfusionPermissionViewGetAllSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionPermissionViewGetAll> object;
public List<XfusionPermissionViewGetAll> getObject() {return object;}
public void setObject(List<XfusionPermissionViewGetAll> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionPermissionViewGetAll{
private Integer view_id;
public Integer getView_id() {return view_id;}
public void setView_id(Integer view_id) {this.view_id = view_id;}
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
