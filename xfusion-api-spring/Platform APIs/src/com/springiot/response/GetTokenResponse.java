package com.springiot.response;

/**
 * 
 * @author tanvigarg This class is generic class to get the response
 * @param <T>
 */
public class GetTokenResponse<T extends Object> {
	// Initializing the variables.
	private String description;
	private T object;
	private boolean valid;

	/*
	 * Getter function of the Description, means the process can be success or
	 * fail
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Setter function to set the Description, means the process can be success
	 * or fail
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * Getter function of the T<Object>, means the data will be in the object
	 */
	public T getObject() {
		return object;
	}

	/*
	 * Setter function to set the T<Object>, means the data will be in the
	 * object
	 */
	public void setObject(T object) {
		this.object = object;
	}

	/*
	 * Getter function of the isValid,which can be true or false.
	 */
	public boolean isValid() {
		return valid;
	}

	/*
	 * Setter function to set the isValid,which can be true or false.
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
