package com.springiot.swagger.response;
import java.util.List;
public class XfusionAuditLogCountSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionAuditLogCount> object;
public List<XfusionAuditLogCount> getObject() {return object;}
public void setObject(List<XfusionAuditLogCount> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionAuditLogCount{
public Object getLog_count() {return log_count;}
public void setLog_count(Object log_count) {this.log_count = log_count;}
private Object log_count;
}
