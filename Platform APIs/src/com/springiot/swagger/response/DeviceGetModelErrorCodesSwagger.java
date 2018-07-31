/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/model/error/codes API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetModelErrorCodesSwagger {
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

	private List<DeviceGetModelErrorCodes> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetModelErrorCodes> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetModelErrorCodes> object) {
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
 * Set the response parameters of /device/get/model/error/codes API.
 * 
 *
 */
class DeviceGetModelErrorCodes {
	// Initializing the variables
	private Integer device_devicemodel_id;
	private String device_devicemodel_name;
	private String device_devicemodel_alias;
	private String device_devicemodel_devicetype;
	private String device_devicemodel_devicevendor;
	private String device_devicemodel_devicetechnology;
	private String device_devicemodel_gis_icon;
	private String device_devicemodel_icon;
	private String device_error_codes_name;
	private String device_error_codes_alias;

	/**
	 * @return the device_devicemodel_id
	 */
	public Integer getDevice_devicemodel_id() {
		return device_devicemodel_id;
	}

	/**
	 * @param device_devicemodel_id
	 *            the device_devicemodel_id to set
	 */
	public void setDevice_devicemodel_id(Integer device_devicemodel_id) {
		this.device_devicemodel_id = device_devicemodel_id;
	}

	/**
	 * @return the device_devicemodel_name
	 */
	public String getDevice_devicemodel_name() {
		return device_devicemodel_name;
	}

	/**
	 * @param device_devicemodel_name
	 *            the device_devicemodel_name to set
	 */
	public void setDevice_devicemodel_name(String device_devicemodel_name) {
		this.device_devicemodel_name = device_devicemodel_name;
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

	/**
	 * @return the device_devicemodel_devicetype
	 */
	public String getDevice_devicemodel_devicetype() {
		return device_devicemodel_devicetype;
	}

	/**
	 * @param device_devicemodel_devicetype
	 *            the device_devicemodel_devicetype to set
	 */
	public void setDevice_devicemodel_devicetype(String device_devicemodel_devicetype) {
		this.device_devicemodel_devicetype = device_devicemodel_devicetype;
	}

	/**
	 * @return the device_devicemodel_devicevendor
	 */
	public String getDevice_devicemodel_devicevendor() {
		return device_devicemodel_devicevendor;
	}

	/**
	 * @param device_devicemodel_devicevendor
	 *            the device_devicemodel_devicevendor to set
	 */
	public void setDevice_devicemodel_devicevendor(String device_devicemodel_devicevendor) {
		this.device_devicemodel_devicevendor = device_devicemodel_devicevendor;
	}

	/**
	 * @return the device_devicemodel_devicetechnology
	 */
	public String getDevice_devicemodel_devicetechnology() {
		return device_devicemodel_devicetechnology;
	}

	/**
	 * @param device_devicemodel_devicetechnology
	 *            the device_devicemodel_devicetechnology to set
	 */
	public void setDevice_devicemodel_devicetechnology(String device_devicemodel_devicetechnology) {
		this.device_devicemodel_devicetechnology = device_devicemodel_devicetechnology;
	}

	/**
	 * @return the device_devicemodel_gis_icon
	 */
	public String getDevice_devicemodel_gis_icon() {
		return device_devicemodel_gis_icon;
	}

	/**
	 * @param device_devicemodel_gis_icon
	 *            the device_devicemodel_gis_icon to set
	 */
	public void setDevice_devicemodel_gis_icon(String device_devicemodel_gis_icon) {
		this.device_devicemodel_gis_icon = device_devicemodel_gis_icon;
	}

	/**
	 * @return the device_devicemodel_icon
	 */
	public String getDevice_devicemodel_icon() {
		return device_devicemodel_icon;
	}

	/**
	 * @param device_devicemodel_icon
	 *            the device_devicemodel_icon to set
	 */
	public void setDevice_devicemodel_icon(String device_devicemodel_icon) {
		this.device_devicemodel_icon = device_devicemodel_icon;
	}

	/**
	 * @return the device_error_codes_name
	 */
	public String getDevice_error_codes_name() {
		return device_error_codes_name;
	}

	/**
	 * @param device_error_codes_name
	 *            the device_error_codes_name to set
	 */
	public void setDevice_error_codes_name(String device_error_codes_name) {
		this.device_error_codes_name = device_error_codes_name;
	}

	/**
	 * @return the device_error_codes_alias
	 */
	public String getDevice_error_codes_alias() {
		return device_error_codes_alias;
	}

	/**
	 * @param device_error_codes_alias
	 *            the device_error_codes_alias to set
	 */
	public void setDevice_error_codes_alias(String device_error_codes_alias) {
		this.device_error_codes_alias = device_error_codes_alias;
	}

}