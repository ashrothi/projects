/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /device/template/default API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceTemplateDefault {
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

	private List<DeviceTemplateSwagger> object;

	/**
	 * @return the object
	 */
	public List<DeviceTemplateSwagger> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceTemplateSwagger> object) {
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
 * Set the response parameters of /device/template/default API.
 * 
 *
 */
class DeviceTemplateSwagger {
	private int device_devicetemplate_id;
	private String device_devicetemplate_name;
	private String device_devicetechnology_alias;
	private String device_devicevendor_alias;
	private String device_devicemodel_alias;

	/**
	 * @return the device_devicetemplate_id
	 */
	public int getDevice_devicetemplate_id() {
		return device_devicetemplate_id;
	}

	/**
	 * @param device_devicetemplate_id
	 *            the device_devicetemplate_id to set
	 */
	public void setDevice_devicetemplate_id(int device_devicetemplate_id) {
		this.device_devicetemplate_id = device_devicetemplate_id;
	}

	/**
	 * @return the device_devicetemplate_name
	 */
	public String getDevice_devicetemplate_name() {
		return device_devicetemplate_name;
	}

	/**
	 * @param device_devicetemplate_name
	 *            the device_devicetemplate_name to set
	 */
	public void setDevice_devicetemplate_name(String device_devicetemplate_name) {
		this.device_devicetemplate_name = device_devicetemplate_name;
	}

	/**
	 * @return the device_devicetechnology_alias
	 */
	public String getDevice_devicetechnology_alias() {
		return device_devicetechnology_alias;
	}

	/**
	 * @param device_devicetechnology_alias
	 *            the device_devicetechnology_alias to set
	 */
	public void setDevice_devicetechnology_alias(String device_devicetechnology_alias) {
		this.device_devicetechnology_alias = device_devicetechnology_alias;
	}

	/**
	 * @return the device_devicevendor_alias
	 */
	public String getDevice_devicevendor_alias() {
		return device_devicevendor_alias;
	}

	/**
	 * @param device_devicevendor_alias
	 *            the device_devicevendor_alias to set
	 */
	public void setDevice_devicevendor_alias(String device_devicevendor_alias) {
		this.device_devicevendor_alias = device_devicevendor_alias;
	}

	/**
	 * @return the device_devicemodel_alias
	 */
	public String getDevice_devicemodel_alias() {
		return device_devicemodel_alias;
	}

	/**
	 * @param device_devicemodel_alias
	 *            the device_devicemodel_alias to set
	 */
	public void setDevice_devicemodel_alias(String device_devicemodel_alias) {
		this.device_devicemodel_alias = device_devicemodel_alias;
	}

}