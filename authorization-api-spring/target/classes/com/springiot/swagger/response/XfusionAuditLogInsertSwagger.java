package com.springiot.swagger.response;
import java.util.List;
public class XfusionAuditLogInsertSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionAuditLogInsert> object;
public List<XfusionAuditLogInsert> getObject() {return object;}
public void setObject(List<XfusionAuditLogInsert> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionAuditLogInsert{
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
