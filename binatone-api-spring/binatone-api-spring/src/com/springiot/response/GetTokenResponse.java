/**
 * This package contain the  class for Third Party Application Generic Responses from OAuth Engine
 */
package com.springiot.response;

/**
 * 
 * This class work to get the Generic Responses from other API and Cast them in
 * a Message Form Responses from OAUth Engine Token and cast in this model
 * format
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GetTokenResponse<T extends Object> {
	/***
	 * Declaring Description ,object and valid bit
	 */
	private String description;
	private T object;
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
	public T getObject() {
		return object;
	}

	/**
	 * @param object
	 *            the object to set
	 */
	public void setObject(T object) {
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