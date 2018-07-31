/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/tags/by/model API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetTagsByModelSwagger {
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

	private List<DeviceGetTagsByModel> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetTagsByModel> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetTagsByModel> object) {
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
