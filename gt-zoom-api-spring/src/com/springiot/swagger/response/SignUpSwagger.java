/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for new user sign up API.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class SignUpSwagger {
	private String description;
	private List<SignUp> object;
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
	public List<SignUp> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<SignUp> object) {
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

/**
 * This class is used for setting data into the object.
 */
class SignUp {
	// Initializing the variables.
	private Integer is_successful;
	private String message;

	/**
	 * @return the is_successful
	 */
	public Integer getIs_successful() {
		return is_successful;
	}
	/**
	 * @param is_successful the is_successful to set
	 */
	public void setIs_successful(Integer is_successful) {
		this.is_successful = is_successful;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}