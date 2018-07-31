package com.springiot.swagger.response;
import java.util.List;
public class XfusionValidateAccesskeyUrlSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionValidateAccesskeyUrl> object;
public List<XfusionValidateAccesskeyUrl> getObject() {return object;}
public void setObject(List<XfusionValidateAccesskeyUrl> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionValidateAccesskeyUrl{
public Object getCode() {return code;}
public void setCode(Object code) {this.code = code;}
private Object code;
private String msg;
public String getMsg() {return msg;}
public void setMsg(String msg) {this.msg = msg;}
public Object getIs_validate() {return is_validate;}
public void setIs_validate(Object is_validate) {this.is_validate = is_validate;}
private Object is_validate;
}
