package com.springiot.swagger.response;
import java.util.List;
public class XfusionPasswordUpdateSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionPasswordUpdate> object;
public List<XfusionPasswordUpdate> getObject() {return object;}
public void setObject(List<XfusionPasswordUpdate> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionPasswordUpdate{
public Object getIs_valid() {return is_valid;}
public void setIs_valid(Object is_valid) {this.is_valid = is_valid;}
private Object is_valid;
public Object getCode() {return code;}
public void setCode(Object code) {this.code = code;}
private Object code;
private String msg;
public String getMsg() {return msg;}
public void setMsg(String msg) {this.msg = msg;}
}
