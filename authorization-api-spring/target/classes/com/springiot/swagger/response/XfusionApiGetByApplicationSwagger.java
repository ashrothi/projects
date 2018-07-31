package com.springiot.swagger.response;
import java.util.List;
public class XfusionApiGetByApplicationSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionApiGetByApplication> object;
public List<XfusionApiGetByApplication> getObject() {return object;}
public void setObject(List<XfusionApiGetByApplication> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionApiGetByApplication{
public Object getCode() {return code;}
public void setCode(Object code) {this.code = code;}
private Object code;
private String msg;
public String getMsg() {return msg;}
public void setMsg(String msg) {this.msg = msg;}
}
