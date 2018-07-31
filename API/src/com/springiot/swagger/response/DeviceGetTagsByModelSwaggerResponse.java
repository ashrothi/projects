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
 * This class contains response of /device/get/tags/by/model API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetTagsByModelSwaggerResponse {
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
	private List<DeviceGetTagsByModel> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<DeviceGetTagsByModel> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<DeviceGetTagsByModel> object) {
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
 * Set the response parameters of /device/get/tags/by/model API.
 * 
 * @author tanvigarg
 *
 */
class DeviceGetTagsByModel {
	// Initializing the variables
	private Integer device_devicetags_id;
	private String device_devicetags_name;

	/**
	 * @return the device_devicetags_id
	 */
	public Integer getDevice_devicetags_id() {
		return device_devicetags_id;
	}

	/**
	 * @param device_devicetags_id
	 *            the device_devicetags_id to set
	 */
	public void setDevice_devicetags_id(Integer device_devicetags_id) {
		this.device_devicetags_id = device_devicetags_id;
	}

	/**
	 * @return the device_devicetags_name
	 */
	public String getDevice_devicetags_name() {
		return device_devicetags_name;
	}

	/**
	 * @param device_devicetags_name
	 *            the device_devicetags_name to set
	 */
	public void setDevice_devicetags_name(String device_devicetags_name) {
		this.device_devicetags_name = device_devicetags_name;
	}

}
