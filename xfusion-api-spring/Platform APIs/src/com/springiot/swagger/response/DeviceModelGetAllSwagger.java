/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/model/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceModelGetAllSwagger {
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

	private List<DeviceModelGetAll> object;

	/**
	 * @return the object
	 */
	public List<DeviceModelGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceModelGetAll> object) {
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
 * Set the response parameters of /device/model/get/all API.
 * 
 *
 */
class DeviceModelGetAll {
	private String device_devicemodel_gis_icon;
	private Integer device_devicetype_id;
	private String device_devicetechnology_name;
	private String device_devicemodel_name;
	private Integer device_devicevendor_id;
	private String device_devicetype_name;
	private String device_devicetechnology_alias;
	private String device_devicevendor_alias;
	private Integer device_devicetechnology_id;
	private String device_devicevendor_name;
	private Integer device_devicemodel_id;
	private String device_devicetype_alias;
	private String device_devicemodel_alias;
	private String device_devicemodel_icon;

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
	 * @return the device_devicetype_id
	 */
	public Integer getDevice_devicetype_id() {
		return device_devicetype_id;
	}

	/**
	 * @param device_devicetype_id
	 *            the device_devicetype_id to set
	 */
	public void setDevice_devicetype_id(Integer device_devicetype_id) {
		this.device_devicetype_id = device_devicetype_id;
	}

	/**
	 * @return the device_devicetechnology_name
	 */
	public String getDevice_devicetechnology_name() {
		return device_devicetechnology_name;
	}

	/**
	 * @param device_devicetechnology_name
	 *            the device_devicetechnology_name to set
	 */
	public void setDevice_devicetechnology_name(String device_devicetechnology_name) {
		this.device_devicetechnology_name = device_devicetechnology_name;
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
	 * @return the device_devicevendor_id
	 */
	public Integer getDevice_devicevendor_id() {
		return device_devicevendor_id;
	}

	/**
	 * @param device_devicevendor_id
	 *            the device_devicevendor_id to set
	 */
	public void setDevice_devicevendor_id(Integer device_devicevendor_id) {
		this.device_devicevendor_id = device_devicevendor_id;
	}

	/**
	 * @return the device_devicetype_name
	 */
	public String getDevice_devicetype_name() {
		return device_devicetype_name;
	}

	/**
	 * @param device_devicetype_name
	 *            the device_devicetype_name to set
	 */
	public void setDevice_devicetype_name(String device_devicetype_name) {
		this.device_devicetype_name = device_devicetype_name;
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
	 * @return the device_devicetechnology_id
	 */
	public Integer getDevice_devicetechnology_id() {
		return device_devicetechnology_id;
	}

	/**
	 * @param device_devicetechnology_id
	 *            the device_devicetechnology_id to set
	 */
	public void setDevice_devicetechnology_id(Integer device_devicetechnology_id) {
		this.device_devicetechnology_id = device_devicetechnology_id;
	}

	/**
	 * @return the device_devicevendor_name
	 */
	public String getDevice_devicevendor_name() {
		return device_devicevendor_name;
	}

	/**
	 * @param device_devicevendor_name
	 *            the device_devicevendor_name to set
	 */
	public void setDevice_devicevendor_name(String device_devicevendor_name) {
		this.device_devicevendor_name = device_devicevendor_name;
	}

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
	 * @return the device_devicetype_alias
	 */
	public String getDevice_devicetype_alias() {
		return device_devicetype_alias;
	}

	/**
	 * @param device_devicetype_alias
	 *            the device_devicetype_alias to set
	 */
	public void setDevice_devicetype_alias(String device_devicetype_alias) {
		this.device_devicetype_alias = device_devicetype_alias;
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

}
