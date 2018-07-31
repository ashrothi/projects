/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/engine/device/get/by/rule/id API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleDeviceGetByRuleIdSwagger {
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

	private List<RuleDeviceGetByRuleId> object;

	/**
	 * @return the object
	 */
	public List<RuleDeviceGetByRuleId> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleDeviceGetByRuleId> object) {
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
 * Set the response parameters of /rule/engine/device/get/by/rule/id API.
 * 
 *
 */
class RuleDeviceGetByRuleId {
	// Initializing the variables
	private Integer device_device_id;
	private Integer device_device_device_id;
	private String device_device_name;
	private String device_device_alias;

	/**
	 * @return the device_device_id
	 */
	public Integer getDevice_device_id() {
		return device_device_id;
	}

	/**
	 * @param device_device_id
	 *            the device_device_id to set
	 */
	public void setDevice_device_id(Integer device_device_id) {
		this.device_device_id = device_device_id;
	}

	/**
	 * @return the device_device_device_id
	 */
	public Integer getDevice_device_device_id() {
		return device_device_device_id;
	}

	/**
	 * @param device_device_device_id
	 *            the device_device_device_id to set
	 */
	public void setDevice_device_device_id(Integer device_device_device_id) {
		this.device_device_device_id = device_device_device_id;
	}

	/**
	 * @return the device_device_name
	 */
	public String getDevice_device_name() {
		return device_device_name;
	}

	/**
	 * @param device_device_name
	 *            the device_device_name to set
	 */
	public void setDevice_device_name(String device_device_name) {
		this.device_device_name = device_device_name;
	}

	/**
	 * @return the device_device_alias
	 */
	public String getDevice_device_alias() {
		return device_device_alias;
	}

	/**
	 * @param device_device_alias
	 *            the device_device_alias to set
	 */
	public void setDevice_device_alias(String device_device_alias) {
		this.device_device_alias = device_device_alias;
	}

}