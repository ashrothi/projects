/**
 * This package contain the  class for Third Party Application Generic Responses.
 */
package com.teramatrix.apiCalling;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * 
 * This class work to get the Generic Responses from other API and Cast them in
 * a Message Form Responses
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GenericMessages<T extends Object> {
	/***
	 * Declaring Description ,object and valid bit
	 */
	private String description;
	private List<T> object;
	private boolean valid;

	/**
	 * To get Message
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set Message
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * to get object as list
	 * 
	 * @return
	 */
	public List<T> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<T> object) {
		this.object = object;
	}

	/**
	 * To get if object is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * To set Object Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "GenericMessages [description=" + description + ", object=" + object + ", valid=" + valid + "]";
	}

}
