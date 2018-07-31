/**
 * This package contains the response classes for API calling.
 */
package com.springiot.response;

import java.util.List;

/**
 * 
 * This Class to Define response message For API's
 */
public class Message {

	private String description;
	private Object object;
	private List<Object> list;
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
	 * to get the List
	 * 
	 * @return
	 */
	public List<Object> getList() {
		return list;
	}

	/**
	 * To set the list
	 * 
	 * @param list
	 */
	public void setList(List<Object> list) {
		this.list = list;
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

	@Override
	public String toString() {
		return "Message [description=" + description + ", object=" + object + ", list=" + list + ", valid=" + valid
				+ ", getDescription()=" + getDescription() + ", getObject()=" + getObject() + ", getList()=" + getList()
				+ ", isValid()=" + isValid() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
