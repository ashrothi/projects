package com.springiot.swagger.response;

import java.util.List;

public class XfusionApiAccessGetByApplicationSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<XfusionApiAccessGetByApplication> object;

	public List<XfusionApiAccessGetByApplication> getObject() {
		return object;
	}

	public void setObject(List<XfusionApiAccessGetByApplication> object) {
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

class XfusionApiAccessGetByApplication {
	private Integer roles_id;

	public Integer getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(Integer roles_id) {
		this.roles_id = roles_id;
	}

	private String roles_name;

	public String getRoles_name() {
		return roles_name;
	}

	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}

	private String api_url;

	public String getApi_url() {
		return api_url;
	}

	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}
}
