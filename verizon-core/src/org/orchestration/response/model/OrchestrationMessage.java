/**
 * This package contain the  class for GlobeTouchAPI Application to set Generic Responses for Calling  API
 */
package org.orchestration.response.model;

/**
 * 
 * This class work to to set Generic Responses for Calling API
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class OrchestrationMessage {
	/***
	 * Declaring Description ,object, list and valid bit
	 */
	private String description;
	private Object object;
	private boolean valid;

	/**
	 * To get the Message
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * To set the Message
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * to get Object
	 * 
	 * @return
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * To set Object
	 * 
	 * @param object
	 */
	public void setObject(Object object) {
		this.object = object;
	}

	/**
	 * To get If Message is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * To set Result Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
