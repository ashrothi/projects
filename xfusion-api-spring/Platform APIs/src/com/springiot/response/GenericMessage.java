/**
 * This package is used to set the response code after calling of API's
 */
package com.springiot.response;

import java.util.List;

/**
 * 
 * @author tanvigarg This class is generic class for all the responses of API's.
 * @param <T>
 */
public class GenericMessage<T extends Object> {

	// Initializing the variables.
	private String description;
	private List<T> object;
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
	 * Getter function of the List<Object>, means the data will be in the
	 * list<object>
	 */
	public List<T> getObject() {
		return object;
	}

	/*
	 * Setter function to set the List<Object>, means the data will be in the
	 * list<object>
	 */
	public void setObject(List<T> object) {
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
