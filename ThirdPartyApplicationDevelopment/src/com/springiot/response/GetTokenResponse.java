/**
 * 
 */
package com.springiot.response;

/**
 * 
 * @author Mandeep Singh
 *
 * @param <T>
 */
public class GetTokenResponse<T extends Object> {

	/**
	 * 
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
	 * @param description the description to set
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
	 * @param object the object to set
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
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}