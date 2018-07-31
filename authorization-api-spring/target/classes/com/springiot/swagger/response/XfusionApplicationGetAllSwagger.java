package com.springiot.swagger.response;
import java.util.List;
public class XfusionApplicationGetAllSwagger {
private String description;
public String getDescription() {return description;}
public void setDescription(String description) {this.description = description;}
private List<XfusionApplicationGetAll> object;
public List<XfusionApplicationGetAll> getObject() {return object;}
public void setObject(List<XfusionApplicationGetAll> object) {this.object = object;}
private boolean valid;
public boolean isValid() {return valid;}
public void setValid(boolean valid) {this.valid = valid;}
}
class XfusionApplicationGetAll{
private Integer applications_id;
public Integer getApplications_id() {return applications_id;}
public void setApplications_id(Integer applications_id) {this.applications_id = applications_id;}
private String applications_name;
public String getApplications_name() {return applications_name;}
public void setApplications_name(String applications_name) {this.applications_name = applications_name;}
private String applications_alias;
public String getApplications_alias() {return applications_alias;}
public void setApplications_alias(String applications_alias) {this.applications_alias = applications_alias;}
private String application_key;
public String getApplication_key() {return application_key;}
public void setApplication_key(String application_key) {this.application_key = application_key;}
private String applications_url;
public String getApplications_url() {return applications_url;}
public void setApplications_url(String applications_url) {this.applications_url = applications_url;}
private String applications_description;
public String getApplications_description() {return applications_description;}
public void setApplications_description(String applications_description) {this.applications_description = applications_description;}
private String applications_service_url;
public String getApplications_service_url() {return applications_service_url;}
public void setApplications_service_url(String applications_service_url) {this.applications_service_url = applications_service_url;}
private String applications_view_url;
public String getApplications_view_url() {return applications_view_url;}
public void setApplications_view_url(String applications_view_url) {this.applications_view_url = applications_view_url;}
private String applications_api_url;
public String getApplications_api_url() {return applications_api_url;}
public void setApplications_api_url(String applications_api_url) {this.applications_api_url = applications_api_url;}
}
