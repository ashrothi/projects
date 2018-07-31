/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/metadata API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetMetadataSwagger {
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

	private List<DeviceGetMetadata> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetMetadata> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetMetadata> object) {
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
 * Set the response parameters of /device/get/metadata API.
 * 
 *
 */
class DeviceGetMetadata {
	// Initializing the variables
	private String device_device_parent_alias;
	private String device_device_creation_date;
	private String property_alias;
	private String device_devicemodel_name;
	private String data_source;
	private Integer device_devicetechnology_id;
	private String state_name;
	private String device_device_last_modified_date;
	private String country_name;
	private String device_devicevendor_name;
	private String device_device_description;
	private Integer state_id;
	private String data_source_alias;
	private String device_device_created_by;
	private Integer organization_organization_id;
	private String device_devicetype_alias;
	private String device_devicemodel_alias;
	private Integer property_id;
	private String device_device_status;
	private String device_devicetechnology_name;
	private String country_alias;
	private String device_devicetype_name;
	private Boolean device_device_is_active;
	private String device_device_modified_by;
	private String organization_organization_alias;
	private String device_device_name;
	private String city_alias;
	private String device_device_mac_address;
	private Float device_device_lattitude;
	private String device_device_elevation;
	private Boolean device_device_is_configurable;
	private Float device_device_longitude;
	private Integer device_devicetype_id;
	private String city_name;
	private String device_device_hardware_version;
	private Long status_timestamp;
	private String device_devicetechnology_alias;
	private String device_devicevendor_alias;
	private Integer city_id;
	private Integer device_device_parent_id;
	private Integer device_devicemodel_id;
	private String device_device_ipaddress;
	private String organization_organization_name;
	private String device_tags;
	private Integer device_devicevendor_id;
	private Integer country_id;
	private Integer device_device_device_id;
	private String device_device_software_version;
	private String property_value;
	private String state_alias;
	private String device_device_parent_name;
	private String device_device_alias;
	private Boolean device_device_is_deleted;

	/**
	 * @return the device_device_parent_alias
	 */
	public String getDevice_device_parent_alias() {
		return device_device_parent_alias;
	}

	/**
	 * @param device_device_parent_alias
	 *            the device_device_parent_alias to set
	 */
	public void setDevice_device_parent_alias(String device_device_parent_alias) {
		this.device_device_parent_alias = device_device_parent_alias;
	}

	/**
	 * @return the device_device_creation_date
	 */
	public String getDevice_device_creation_date() {
		return device_device_creation_date;
	}

	/**
	 * @param device_device_creation_date
	 *            the device_device_creation_date to set
	 */
	public void setDevice_device_creation_date(String device_device_creation_date) {
		this.device_device_creation_date = device_device_creation_date;
	}

	/**
	 * @return the property_alias
	 */
	public String getProperty_alias() {
		return property_alias;
	}

	/**
	 * @param property_alias
	 *            the property_alias to set
	 */
	public void setProperty_alias(String property_alias) {
		this.property_alias = property_alias;
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
	 * @return the data_source
	 */
	public String getData_source() {
		return data_source;
	}

	/**
	 * @param data_source
	 *            the data_source to set
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
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
	 * @return the device_device_last_modified_date
	 */
	public String getDevice_device_last_modified_date() {
		return device_device_last_modified_date;
	}

	/**
	 * @param device_device_last_modified_date
	 *            the device_device_last_modified_date to set
	 */
	public void setDevice_device_last_modified_date(String device_device_last_modified_date) {
		this.device_device_last_modified_date = device_device_last_modified_date;
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
	 * @return the data_source_alias
	 */
	public String getData_source_alias() {
		return data_source_alias;
	}

	/**
	 * @param data_source_alias
	 *            the data_source_alias to set
	 */
	public void setData_source_alias(String data_source_alias) {
		this.data_source_alias = data_source_alias;
	}

	/**
	 * @return the device_device_created_by
	 */
	public String getDevice_device_created_by() {
		return device_device_created_by;
	}

	/**
	 * @param device_device_created_by
	 *            the device_device_created_by to set
	 */
	public void setDevice_device_created_by(String device_device_created_by) {
		this.device_device_created_by = device_device_created_by;
	}

	/**
	 * @return the organization_organization_id
	 */
	public Integer getOrganization_organization_id() {
		return organization_organization_id;
	}

	/**
	 * @param organization_organization_id
	 *            the organization_organization_id to set
	 */
	public void setOrganization_organization_id(Integer organization_organization_id) {
		this.organization_organization_id = organization_organization_id;
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
	 * @return the property_id
	 */
	public Integer getProperty_id() {
		return property_id;
	}

	/**
	 * @param property_id
	 *            the property_id to set
	 */
	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	/**
	 * @return the device_device_status
	 */
	public String getDevice_device_status() {
		return device_device_status;
	}

	/**
	 * @param device_device_status
	 *            the device_device_status to set
	 */
	public void setDevice_device_status(String device_device_status) {
		this.device_device_status = device_device_status;
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
	 * @return the device_device_is_active
	 */
	public Boolean getDevice_device_is_active() {
		return device_device_is_active;
	}

	/**
	 * @param device_device_is_active
	 *            the device_device_is_active to set
	 */
	public void setDevice_device_is_active(Boolean device_device_is_active) {
		this.device_device_is_active = device_device_is_active;
	}

	/**
	 * @return the device_device_modified_by
	 */
	public String getDevice_device_modified_by() {
		return device_device_modified_by;
	}

	/**
	 * @param device_device_modified_by
	 *            the device_device_modified_by to set
	 */
	public void setDevice_device_modified_by(String device_device_modified_by) {
		this.device_device_modified_by = device_device_modified_by;
	}

	/**
	 * @return the organization_organization_alias
	 */
	public String getOrganization_organization_alias() {
		return organization_organization_alias;
	}

	/**
	 * @param organization_organization_alias
	 *            the organization_organization_alias to set
	 */
	public void setOrganization_organization_alias(String organization_organization_alias) {
		this.organization_organization_alias = organization_organization_alias;
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

	/**
	 * @return the device_device_is_configurable
	 */
	public Boolean getDevice_device_is_configurable() {
		return device_device_is_configurable;
	}

	/**
	 * @param device_device_is_configurable
	 *            the device_device_is_configurable to set
	 */
	public void setDevice_device_is_configurable(Boolean device_device_is_configurable) {
		this.device_device_is_configurable = device_device_is_configurable;
	}

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
	 * @return the status_timestamp
	 */
	public Long getStatus_timestamp() {
		return status_timestamp;
	}

	/**
	 * @param status_timestamp
	 *            the status_timestamp to set
	 */
	public void setStatus_timestamp(Long status_timestamp) {
		this.status_timestamp = status_timestamp;
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
	 * @return the device_device_parent_id
	 */
	public Integer getDevice_device_parent_id() {
		return device_device_parent_id;
	}

	/**
	 * @param device_device_parent_id
	 *            the device_device_parent_id to set
	 */
	public void setDevice_device_parent_id(Integer device_device_parent_id) {
		this.device_device_parent_id = device_device_parent_id;
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
	 * @return the organization_organization_name
	 */
	public String getOrganization_organization_name() {
		return organization_organization_name;
	}

	/**
	 * @param organization_organization_name
	 *            the organization_organization_name to set
	 */
	public void setOrganization_organization_name(String organization_organization_name) {
		this.organization_organization_name = organization_organization_name;
	}

	/**
	 * @return the device_tags
	 */
	public String getDevice_tags() {
		return device_tags;
	}

	/**
	 * @param device_tags
	 *            the device_tags to set
	 */
	public void setDevice_tags(String device_tags) {
		this.device_tags = device_tags;
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
	 * @return the property_value
	 */
	public String getProperty_value() {
		return property_value;
	}

	/**
	 * @param property_value
	 *            the property_value to set
	 */
	public void setProperty_value(String property_value) {
		this.property_value = property_value;
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
	 * @return the device_device_parent_name
	 */
	public String getDevice_device_parent_name() {
		return device_device_parent_name;
	}

	/**
	 * @param device_device_parent_name
	 *            the device_device_parent_name to set
	 */
	public void setDevice_device_parent_name(String device_device_parent_name) {
		this.device_device_parent_name = device_device_parent_name;
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
	 * @return the device_device_is_deleted
	 */
	public Boolean getDevice_device_is_deleted() {
		return device_device_is_deleted;
	}

	/**
	 * @param device_device_is_deleted
	 *            the device_device_is_deleted to set
	 */
	public void setDevice_device_is_deleted(Boolean device_device_is_deleted) {
		this.device_device_is_deleted = device_device_is_deleted;
	}

}
