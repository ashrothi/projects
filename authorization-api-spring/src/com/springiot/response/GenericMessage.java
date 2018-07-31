/**
 * This package contains the response classes for API calling.
 */
package com.springiot.response;

import java.util.List;

/**
 * 
 * This Class use to Define generic message For API's
 */
public class GenericMessage<T extends Object> {
	/**
	 * Declare required variable to store details.
	 */
	private String description;
	private List<T> object;
	private boolean valid;

	/**
	 * To get the description value
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set the description value
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * To get the object value
	 * 
	 * @return object
	 */
	public List<T> getObject() {
		return object;
	}

	/**
	 * To set the object value
	 * 
	 * @param object
	 */
	public void setObject(List<T> object) {
		this.object = object;
	}

	/**
	 * To get the valid value
	 * 
	 * @return valid
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * To set the valid value
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
