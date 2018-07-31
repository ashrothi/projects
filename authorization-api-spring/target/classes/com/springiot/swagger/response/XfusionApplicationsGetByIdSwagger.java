package com.springiot.swagger.response;

import java.util.List;

public class XfusionApplicationsGetByIdSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<XfusionApplicationsGetById> object;

	public List<XfusionApplicationsGetById> getObject() {
		return object;
	}

	public void setObject(List<XfusionApplicationsGetById> object) {
		this.object = object;
	}

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

class XfusionApplicationsGetById {
	private Integer users_id;
	private String users_name;
	private String users_user_key;
	private String membership_email;
	private Integer roles_id;
	private String roles_name;
	private String roles_access_key;
	private String roles_alias;
	private Integer applications_id;
	private String applications_name;
	private String applications_alias;
	private String application_key;

	public Integer getUsers_id() {
		return users_id;
	}

	public void setUsers_id(Integer users_id) {
		this.users_id = users_id;
	}

	public String getUsers_name() {
		return users_name;
	}

	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	public String getUsers_user_key() {
		return users_user_key;
	}

	public void setUsers_user_key(String users_user_key) {
		this.users_user_key = users_user_key;
	}

	public String getMembership_email() {
		return membership_email;
	}

	public void setMembership_email(String membership_email) {
		this.membership_email = membership_email;
	}

	public Integer getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(Integer roles_id) {
		this.roles_id = roles_id;
	}

	public String getRoles_name() {
		return roles_name;
	}

	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}

	public String getRoles_access_key() {
		return roles_access_key;
	}

	public void setRoles_access_key(String roles_access_key) {
		this.roles_access_key = roles_access_key;
	}

	public String getRoles_alias() {
		return roles_alias;
	}

	public void setRoles_alias(String roles_alias) {
		this.roles_alias = roles_alias;
	}

	public Integer getApplications_id() {
		return applications_id;
	}

	public void setApplications_id(Integer applications_id) {
		this.applications_id = applications_id;
	}

	public String getApplications_name() {
		return applications_name;
	}

	public void setApplications_name(String applications_name) {
		this.applications_name = applications_name;
	}

	public String getApplications_alias() {
		return applications_alias;
	}

	public void setApplications_alias(String applications_alias) {
		this.applications_alias = applications_alias;
	}

	public String getApplication_key() {
		return application_key;
	}

	public void setApplication_key(String application_key) {
		this.application_key = application_key;
	}

}