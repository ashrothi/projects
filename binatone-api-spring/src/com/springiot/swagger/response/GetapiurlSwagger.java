package com.springiot.swagger.response;

import java.util.List;

public class GetapiurlSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<Getapiurl> object;

	public List<Getapiurl> getObject() {
		return object;
	}

	public void setObject(List<Getapiurl> object) {
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

class Getapiurl {
	private String is_added;
	private String url;
	
	public String getIs_added() {
		return is_added;
	}

	public void setIs_added(String is_added) {
		this.is_added = is_added;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
