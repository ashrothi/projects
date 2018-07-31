/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/all/templates API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetAllTemplatesSwagger {
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

	private List<DeviceGetAllTemplates> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetAllTemplates> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetAllTemplates> object) {
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
 * Set the response parameters of /device/get/all/templates API.
 * 
 *
 */
class DeviceGetAllTemplates {
	// Initializing the variables
	private String device_devicetemplate_name;
	private String city_name;
	private String device_devicetemplate_device_city;
	private String device_devicetechnology_name;
	private String country_alias;
	private String device_devicemodel_name;
	private Integer country_id;
	private String device_devicetype_name;
	private String device_devicetemplate_device_type;
	private String device_devicetechnology_alias;
	private String device_devicetemplate_device_vendor;
	private String state_name;
	private String device_devicevendor_alias;
	private String country_name;
	private String device_devicetemplate_device_country;
	private String device_devicevendor_name;
	private Integer city_id;
	private Integer state_id;
	private String state_alias;
	private String city_alias;
	private String device_devicetemplate_device_model;
	private String device_devicetype_alias;
	private String device_devicemodel_alias;
	private String device_devicetemplate_device_technology;

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
	 * @return the device_devicetemplate_device_city
	 */
	public String getDevice_devicetemplate_device_city() {
		return device_devicetemplate_device_city;
	}

	/**
	 * @param device_devicetemplate_device_city
	 *            the device_devicetemplate_device_city to set
	 */
	public void setDevice_devicetemplate_device_city(String device_devicetemplate_device_city) {
		this.device_devicetemplate_device_city = device_devicetemplate_device_city;
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
	 * @return the country_alias
	 */
	public String getCountry_alias() {
		return country_alias;
	}

	/**
	 * @param country_alias
	 *            the country_alias to set
	 */
	public void setCountry_alias(String country_alias) {
		this.country_alias = country_alias;
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
	 * @return the country_id
	 */
	public Integer getCountry_id() {
		return country_id;
	}

	/**
	 * @param country_id
	 *            the country_id to set
	 */
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
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
	 * @return the device_devicetemplate_device_type
	 */
	public String getDevice_devicetemplate_device_type() {
		return device_devicetemplate_device_type;
	}

	/**
	 * @param device_devicetemplate_device_type
	 *            the device_devicetemplate_device_type to set
	 */
	public void setDevice_devicetemplate_device_type(String device_devicetemplate_device_type) {
		this.device_devicetemplate_device_type = device_devicetemplate_device_type;
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
	 * @return the device_devicetemplate_device_vendor
	 */
	public String getDevice_devicetemplate_device_vendor() {
		return device_devicetemplate_device_vendor;
	}

	/**
	 * @param device_devicetemplate_device_vendor
	 *            the device_devicetemplate_device_vendor to set
	 */
	public void setDevice_devicetemplate_device_vendor(String device_devicetemplate_device_vendor) {
		this.device_devicetemplate_device_vendor = device_devicetemplate_device_vendor;
	}

	/**
	 * @return the state_name
	 */
	public String getState_name() {
		return state_name;
	}

	/**
	 * @param state_name
	 *            the state_name to set
	 */
	public void setState_name(String state_name) {
		this.state_name = state_name;
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
	 * @return the device_devicetemplate_device_country
	 */
	public String getDevice_devicetemplate_device_country() {
		return device_devicetemplate_device_country;
	}

	/**
	 * @param device_devicetemplate_device_country
	 *            the device_devicetemplate_device_country to set
	 */
	public void setDevice_devicetemplate_device_country(String device_devicetemplate_device_country) {
		this.device_devicetemplate_device_country = device_devicetemplate_device_country;
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
	 * @return the city_id
	 */
	public Integer getCity_id() {
		return city_id;
	}

	/**
	 * @param city_id
	 *            the city_id to set
	 */
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	/**
	 * @return the state_id
	 */
	public Integer getState_id() {
		return state_id;
	}

	/**
	 * @param state_id
	 *            the state_id to set
	 */
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	/**
	 * @return the state_alias
	 */
	public String getState_alias() {
		return state_alias;
	}

	/**
	 * @param state_alias
	 *            the state_alias to set
	 */
	public void setState_alias(String state_alias) {
		this.state_alias = state_alias;
	}

	/**
	 * @return the city_alias
	 */
	public String getCity_alias() {
		return city_alias;
	}

	/**
	 * @param city_alias
	 *            the city_alias to set
	 */
	public void setCity_alias(String city_alias) {
		this.city_alias = city_alias;
	}

	/**
	 * @return the device_devicetemplate_device_model
	 */
	public String getDevice_devicetemplate_device_model() {
		return device_devicetemplate_device_model;
	}

	/**
	 * @param device_devicetemplate_device_model
	 *            the device_devicetemplate_device_model to set
	 */
	public void setDevice_devicetemplate_device_model(String device_devicetemplate_device_model) {
		this.device_devicetemplate_device_model = device_devicetemplate_device_model;
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
	 * @return the device_devicetemplate_device_technology
	 */
	public String getDevice_devicetemplate_device_technology() {
		return device_devicetemplate_device_technology;
	}

	/**
	 * @param device_devicetemplate_device_technology
	 *            the device_devicetemplate_device_technology to set
	 */
	public void setDevice_devicetemplate_device_technology(String device_devicetemplate_device_technology) {
		this.device_devicetemplate_device_technology = device_devicetemplate_device_technology;
	}

}