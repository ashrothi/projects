/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/suggestion API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetSuggestionSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<DeviceGetSuggestion> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetSuggestion> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetSuggestion> object) {
		this.object = object;
	}

	private boolean valid;

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
}

/**
 * Set the response parameters of /device/get/tags/by/model API.
 * 
 *
 */
class DeviceGetSuggestion {
	// Initializing the variables
	private Integer device_id;
	private String device_name;

	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}

	/**
	 * @param device_name
	 *            the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

}