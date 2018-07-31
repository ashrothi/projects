/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * 
 * This class contains response of /execute/command/tr069 API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ExecuteCommandSwagger {
	// Initialize the variable
	private String description;

	/*
	 * Getter method of description
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Setter method of description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// Initialize the variable
	private List<ExecuteCommand> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<ExecuteCommand> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<ExecuteCommand> object) {
		this.object = object;
	}

	// Initialize the variable
	private boolean valid;

	/*
	 * Getter method of boolean value isValid
	 */
	public boolean isValid() {
		return valid;
	}

	/*
	 * Setter method to set boolean value isValid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * Set the response parameters of /execute/command/tr069 API.
 * 
 * @author tanvigarg
 *
 */
class ExecuteCommand {
	// Initialize the variables
	private Integer device_id;
	private String status;

	/*
	 * Getter method to get device id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/*
	 * Setter method to set device id
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/*
	 * Getter method to get status
	 */
	public String getStatus() {
		return status;
	}

	/*
	 * Setter method to set status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}