/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /get/device/by/user API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class GenericGetDeviceSwagger {
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

	private List<GenericGetDevice> object;

	/**
	 * @return the object
	 */
	public List<GenericGetDevice> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GenericGetDevice> object) {
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
 * Set the response parameters of /get/device/by/user API.
 * 
 *
 */
class GenericGetDevice {
	// Initializing the variables
	private Float device_device_longitude;
	private String city_name;
	private String device_devicetechnology_name;
	private String device_devicemodel_name;
	private String device_device_hardware_version;
	private Integer device_device_device_id;
	private String device_devicetechnology_alias;
	private String device_devicevendor_alias;
	private String country_name;
	private Long device_device_last_modified_date;
	private String device_devicevendor_name;
	private String device_device_software_version;
	private String device_device_description;
	private String device_device_name;
	private String device_device_mac_address;
	private Float device_device_lattitude;
	private String device_device_ipaddress;
	private String device_device_alias;
	private String device_devicetype_alias;
	private String device_devicemodel_alias;
	private String device_device_elevation;

	/**
	 * @return the device_device_longitude
	 */
	public Float getDevice_device_longitude() {
		return device_device_longitude;
	}

	/**
	 * @param device_device_longitude
	 *            the device_device_longitude to set
	 */
	public void setDevice_device_longitude(Float device_device_longitude) {
		this.device_device_longitude = device_device_longitude;
	}

	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}

	/**
	 * @param city_name
	 *            the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
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
	 * @return the device_device_hardware_version
	 */
	public String getDevice_device_hardware_version() {
		return device_device_hardware_version;
	}

	/**
	 * @param device_device_hardware_version
	 *            the device_device_hardware_version to set
	 */
	public void setDevice_device_hardware_version(String device_device_hardware_version) {
		this.device_device_hardware_version = device_device_hardware_version;
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
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/**
	 * @param country_name
	 *            the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/**
	 * @return the device_device_last_modified_date
	 */
	public Long getDevice_device_last_modified_date() {
		return device_device_last_modified_date;
	}

	/**
	 * @param device_device_last_modified_date
	 *            the device_device_last_modified_date to set
	 */
	public void setDevice_device_last_modified_date(Long device_device_last_modified_date) {
		this.device_device_last_modified_date = device_device_last_modified_date;
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
	 * @return the device_device_software_version
	 */
	public String getDevice_device_software_version() {
		return device_device_software_version;
	}

	/**
	 * @param device_device_software_version
	 *            the device_device_software_version to set
	 */
	public void setDevice_device_software_version(String device_device_software_version) {
		this.device_device_software_version = device_device_software_version;
	}

	/**
	 * @return the device_device_description
	 */
	public String getDevice_device_description() {
		return device_device_description;
	}

	/**
	 * @param device_device_description
	 *            the device_device_description to set
	 */
	public void setDevice_device_description(String device_device_description) {
		this.device_device_description = device_device_description;
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
	 * @return the device_device_mac_address
	 */
	public String getDevice_device_mac_address() {
		return device_device_mac_address;
	}

	/**
	 * @param device_device_mac_address
	 *            the device_device_mac_address to set
	 */
	public void setDevice_device_mac_address(String device_device_mac_address) {
		this.device_device_mac_address = device_device_mac_address;
	}

	/**
	 * @return the device_device_lattitude
	 */
	public Float getDevice_device_lattitude() {
		return device_device_lattitude;
	}

	/**
	 * @param device_device_lattitude
	 *            the device_device_lattitude to set
	 */
	public void setDevice_device_lattitude(Float device_device_lattitude) {
		this.device_device_lattitude = device_device_lattitude;
	}

	/**
	 * @return the device_device_ipaddress
	 */
	public String getDevice_device_ipaddress() {
		return device_device_ipaddress;
	}

	/**
	 * @param device_device_ipaddress
	 *            the device_device_ipaddress to set
	 */
	public void setDevice_device_ipaddress(String device_device_ipaddress) {
		this.device_device_ipaddress = device_device_ipaddress;
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
	 * @return the device_device_elevation
	 */
	public String getDevice_device_elevation() {
		return device_device_elevation;
	}

	/**
	 * @param device_device_elevation
	 *            the device_device_elevation to set
	 */
	public void setDevice_device_elevation(String device_device_elevation) {
		this.device_device_elevation = device_device_elevation;
	}

}