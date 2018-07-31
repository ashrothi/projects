package com.springiot.response;

import java.util.List;
/**
 This Class to Define  Message For API's
*/
public class Message {

	private String description;
	private Object object;
	private List<Object> list;
	private boolean valid;
	/**
	 * To get the Message
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * To set the Message
	 * @return
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * to get Object
	 * @return
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * To set Object
	 * @param object
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 * to get the List
	 * @return
	 */
	public List<Object> getList() {
		return list;
	}
	/**
	 * To set the list
	 * @param list
	 */
	public void setList(List<Object> list) {
		this.list = list;
	}
	/**
	 * To get If Message is Valid
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
				+ "]";
	}

}
