/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for checking existence of organization.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class CheckOrganizationSwagger {
	private String description;
	private List<CheckOrganization> object;
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
	public List<CheckOrganization> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<CheckOrganization> object) {
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
class CheckOrganization {
	// Initializing the variables.
	private String message;
	private Integer isExist;

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
	/**
	 * @return the isExist
	 */
	public Integer getIsExist() {
		return isExist;
	}
	/**
	 * @param isExist the isExist to set
	 */
	public void setIsExist(Integer isExist) {
		this.isExist = isExist;
	}	
}
