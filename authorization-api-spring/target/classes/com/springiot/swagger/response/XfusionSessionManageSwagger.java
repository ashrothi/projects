package com.springiot.swagger.response;
import java.util.List;
public class XfusionSessionManageSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionSessionManage> object;
public List<XfusionSessionManage> getObject() {return object;}
public void setObject(List<XfusionSessionManage> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionSessionManage{
public Object getStatus() {return status;}
public void setStatus(Object status) {this.status = status;}
private Object status;
public Object getCode() {return code;}
public void setCode(Object code) {this.code = code;}
private Object code;
private String message;
public String getMessage() {return message;}
public void setMessage(String message) {this.message = message;}
}
