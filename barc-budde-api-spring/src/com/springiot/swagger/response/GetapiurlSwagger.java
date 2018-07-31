package com.springiot.swagger.response;

import java.util.List;

/**
 * To generate swagger response classes
 * 
 * @author Ankita Shrothi
 *
 */
public class GetapiurlSwagger {
	private String description;

	private List<Getapiurl> object;

	private boolean valid;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the object
	 */
	public List<Getapiurl> getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(List<Getapiurl> object) {
		this.object = object;
	}

	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}

/*
 * TO get response parameter getter setter
 */
class Getapiurl {
	private String is_added;
	private String url;

	/**
	 * @return the is_added
	 */
	public String getIs_added() {
		return is_added;
	}

	/**
	 * @param is_added
	 *            the is_added to set
	 */
	public void setIs_added(String is_added) {
		this.is_added = is_added;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
