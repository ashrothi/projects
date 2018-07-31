/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for api /device/get/command/parameters/by/id/swagger.
 * 
 * @author mandeepsingh
 */
public class DeviceGetCommandParametersByIdSwagger {
	private String description;
	private List<DeviceGetCommandParametersById> object;
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
	public List<DeviceGetCommandParametersById> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<DeviceGetCommandParametersById> object) {
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
class DeviceGetCommandParametersById{
	// Initializing the variables.
	private Integer commandId; 
	private String userKey; 
	private String userEmail;
	
	/**
	 * @return the commandId
	 */
	public Integer getCommandId() {
		return commandId;
	}
	/**
	 * @param commandId the commandId to set
	 */
	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}
	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}
	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}