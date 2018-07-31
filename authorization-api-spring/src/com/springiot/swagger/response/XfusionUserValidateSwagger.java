package com.springiot.swagger.response;
import java.util.List;
public class XfusionUserValidateSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionUserValidate> object;
public List<XfusionUserValidate> getObject() {return object;}
public void setObject(List<XfusionUserValidate> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionUserValidate{
public Object getIs_valid() {return is_valid;}
public void setIs_valid(Object is_valid) {this.is_valid = is_valid;}
private Object is_valid;
public Object getCode() {return code;}
public void setCode(Object code) {this.code = code;}
private Object code;
private String message;
public String getMessage() {return message;}
public void setMessage(String message) {this.message = message;}
public Object getUtc_time() {return utc_time;}
public void setUtc_time(Object utc_time) {this.utc_time = utc_time;}
private Object utc_time;
}
