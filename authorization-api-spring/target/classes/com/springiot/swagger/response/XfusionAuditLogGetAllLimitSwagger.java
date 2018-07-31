package com.springiot.swagger.response;
import java.util.List;
public class XfusionAuditLogGetAllLimitSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionAuditLogGetAllLimit> object;
public List<XfusionAuditLogGetAllLimit> getObject() {return object;}
public void setObject(List<XfusionAuditLogGetAllLimit> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionAuditLogGetAllLimit{
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String controller_name;
public String getController_name() {return controller_name;}
public void setController_name(String controller_name) {this.controller_name = controller_name;}
private String input_parameters;
public String getInput_parameters() {return input_parameters;}
public void setInput_parameters(String input_parameters) {this.input_parameters = input_parameters;}
private String ip_address;
public String getIp_address() {return ip_address;}
public void setIp_address(String ip_address) {this.ip_address = ip_address;}
private String log_audit_timeaccessed;
public String getLog_audit_timeaccessed() {return log_audit_timeaccessed;}
public void setLog_audit_timeaccessed(String log_audit_timeaccessed) {this.log_audit_timeaccessed = log_audit_timeaccessed;}
private String url_accessed;
public String getUrl_accessed() {return url_accessed;}
public void setUrl_accessed(String url_accessed) {this.url_accessed = url_accessed;}
private String user_id;
public String getUser_id() {return user_id;}
public void setUser_id(String user_id) {this.user_id = user_id;}
private String application_id;
public String getApplication_id() {return application_id;}
public void setApplication_id(String application_id) {this.application_id = application_id;}
private String log_type;
public String getLog_type() {return log_type;}
public void setLog_type(String log_type) {this.log_type = log_type;}
private String name;
public String getName() {return name;}
public void setName(String name) {this.name = name;}
}
