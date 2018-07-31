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
 * This class contains response of /device/get/metadata API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetMetadataSwagger {
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
	private List<DeviceGetMetadata> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<DeviceGetMetadata> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<DeviceGetMetadata> object) {
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
 * Set the response parameters of /device/get/metadata API.
 * 
 * @author tanvigarg
 *
 */
class DeviceGetMetadata {
	// Initialize the variables
	private String device_devicetype_name;
	private String city_alias;
	private String property_value;
	private String property_alias;
	private Float device_device_lattitude;
	private String device_device_elevation;
	private String device_devicetechnology_name;
	private String state_name;
	private Integer state_id;
	private Boolean device_device_is_deleted;
	private String organization_organization_alias;
	private String organization_organization_name;
	private String device_device_alias;
	private String device_device_created_by;
	private String device_device_parent_name;
	private String device_devicevendor_alias;
	private Float device_device_longitude;
	private String device_device_modified_by;
	private String device_devicevendor_name;
	private String data_source;
	private Integer property_id;
	private String device_device_status;
	private String device_devicemodel_alias;
	private String device_device_software_version;
	private String device_device_last_modified_date;
	private String device_devicetype_alias;
	private Integer device_devicevendor_id;
	private Integer country_id;
	private Integer city_id;
	private Integer device_devicetechnology_id;
	private Boolean device_device_is_configurable;
	private String device_device_name;
	private Integer organization_organization_id;
	private Boolean device_device_is_active;
	private String device_device_ipaddress;
	private String city_name;
	private String state_alias;
	private String country_name;
	private Long status_timestamp;
	private String device_device_description;
	private String country_alias;
	private Integer device_devicetype_id;
	private String data_source_alias;
	private String device_device_creation_date;
	private String device_devicemodel_name;
	private Integer device_device_parent_id;
	private String device_device_hardware_version;
	private String device_tags;
	private Integer device_devicemodel_id;
	private Integer device_device_device_id;
	private String device_device_mac_address;
	private String device_devicetechnology_alias;
	private String device_device_parent_alias;

	/*
	 * Getter method to get device_devicetype_name
	 */
	public String getDevice_devicetype_name() {
		return device_devicetype_name;
	}

	/*
	 * Setter method to set device_devicetype_name
	 */
	public void setDevice_devicetype_name(String device_devicetype_name) {
		this.device_devicetype_name = device_devicetype_name;
	}

	/*
	 * Getter method to get city_alias
	 */
	public String getCity_alias() {
		return city_alias;
	}

	/*
	 * Getter method to set city_alias
	 */
	public void setCity_alias(String city_alias) {
		this.city_alias = city_alias;
	}

	/*
	 * Getter method to get property_value
	 */
	public String getProperty_value() {
		return property_value;
	}

	/*
	 * Setter method to set property_value
	 */
	public void setProperty_value(String property_value) {
		this.property_value = property_value;
	}

	/*
	 * Getter method to get property_alias
	 */
	public String getProperty_alias() {
		return property_alias;
	}

	/*
	 * Setter method to set property_alias
	 */
	public void setProperty_alias(String property_alias) {
		this.property_alias = property_alias;
	}

	/*
	 * Getter method to get device_device_lattitude
	 */
	public Float getDevice_device_lattitude() {
		return device_device_lattitude;
	}

	/*
	 * Setter method to set device_device_lattitude
	 */
	public void setDevice_device_lattitude(Float device_device_lattitude) {
		this.device_device_lattitude = device_device_lattitude;
	}

	/*
	 * Getter method to get device_device_elevation
	 */
	public String getDevice_device_elevation() {
		return device_device_elevation;
	}

	/*
	 * Setter method to set device_device_elevation
	 */
	public void setDevice_device_elevation(String device_device_elevation) {
		this.device_device_elevation = device_device_elevation;
	}

	/*
	 * Getter method to get device_devicetechnology_name
	 */
	public String getDevice_devicetechnology_name() {
		return device_devicetechnology_name;
	}

	/*
	 * Setter method to set device_devicetechnology_name
	 */
	public void setDevice_devicetechnology_name(String device_devicetechnology_name) {
		this.device_devicetechnology_name = device_devicetechnology_name;
	}

	/*
	 * Getter method to get state_name
	 */
	public String getState_name() {
		return state_name;
	}

	/*
	 * Setter method to set state_name
	 */
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	/*
	 * Getter method to get state_id
	 */
	public Integer getState_id() {
		return state_id;
	}

	/*
	 * Setter method to set state_id
	 */
	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	/*
	 * Getter method to get device_device_is_deleted
	 */
	public Boolean getDevice_device_is_deleted() {
		return device_device_is_deleted;
	}

	/*
	 * Setter method to set device_device_is_deleted
	 */
	public void setDevice_device_is_deleted(Boolean device_device_is_deleted) {
		this.device_device_is_deleted = device_device_is_deleted;
	}

	/*
	 * Getter method to get organization_organization_alias
	 */
	public String getOrganization_organization_alias() {
		return organization_organization_alias;
	}

	/*
	 * Setter method to set organization_organization_alias
	 */
	public void setOrganization_organization_alias(String organization_organization_alias) {
		this.organization_organization_alias = organization_organization_alias;
	}

	/*
	 * Getter method to get organization_organization_name
	 */
	public String getOrganization_organization_name() {
		return organization_organization_name;
	}

	/*
	 * Setter method to set organization_organization_name
	 */
	public void setOrganization_organization_name(String organization_organization_name) {
		this.organization_organization_name = organization_organization_name;
	}

	/*
	 * Getter method to get device_device_alias
	 */
	public String getDevice_device_alias() {
		return device_device_alias;
	}

	/*
	 * Setter method to set device_device_alias
	 */
	public void setDevice_device_alias(String device_device_alias) {
		this.device_device_alias = device_device_alias;
	}

	/*
	 * Getter method to get device_device_created_by
	 */
	public String getDevice_device_created_by() {
		return device_device_created_by;
	}

	/*
	 * Setter method to set device_device_created_by
	 */
	public void setDevice_device_created_by(String device_device_created_by) {
		this.device_device_created_by = device_device_created_by;
	}

	/*
	 * Getter method to get device_device_parent_name
	 */
	public String getDevice_device_parent_name() {
		return device_device_parent_name;
	}

	/*
	 * Setter method to set device_device_parent_name
	 */
	public void setDevice_device_parent_name(String device_device_parent_name) {
		this.device_device_parent_name = device_device_parent_name;
	}

	/*
	 * Getter method to get device_devicevendor_alias
	 */
	public String getDevice_devicevendor_alias() {
		return device_devicevendor_alias;
	}

	/*
	 * Setter method to set device_devicevendor_alias
	 */
	public void setDevice_devicevendor_alias(String device_devicevendor_alias) {
		this.device_devicevendor_alias = device_devicevendor_alias;
	}

	/*
	 * Getter method to get device_device_longitude
	 */
	public Float getDevice_device_longitude() {
		return device_device_longitude;
	}

	/*
	 * Setter method to set device_device_longitude
	 */
	public void setDevice_device_longitude(Float device_device_longitude) {
		this.device_device_longitude = device_device_longitude;
	}

	/*
	 * Getter method to get device_device_modified_by
	 */
	public String getDevice_device_modified_by() {
		return device_device_modified_by;
	}

	/*
	 * Setter method to set device_device_modified_by
	 */
	public void setDevice_device_modified_by(String device_device_modified_by) {
		this.device_device_modified_by = device_device_modified_by;
	}

	/*
	 * Getter method to get device_devicevendor_name
	 */
	public String getDevice_devicevendor_name() {
		return device_devicevendor_name;
	}

	/*
	 * Setter method to set device_devicevendor_name
	 */
	public void setDevice_devicevendor_name(String device_devicevendor_name) {
		this.device_devicevendor_name = device_devicevendor_name;
	}

	/*
	 * Getter method to get data_source
	 */
	public String getData_source() {
		return data_source;
	}

	/*
	 * Setter method to set data_source
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	/*
	 * Getter method to get property_id
	 */
	public Integer getProperty_id() {
		return property_id;
	}

	/*
	 * Setter method to set property_id
	 */
	public void setProperty_id(Integer property_id) {
		this.property_id = property_id;
	}

	/*
	 * Getter method to get device_device_status
	 */
	public String getDevice_device_status() {
		return device_device_status;
	}

	/*
	 * Setter method to set device_device_status
	 */
	public void setDevice_device_status(String device_device_status) {
		this.device_device_status = device_device_status;
	}

	/*
	 * Getter method to get device_devicemodel_alias
	 */
	public String getDevice_devicemodel_alias() {
		return device_devicemodel_alias;
	}

	/*
	 * Setter method to set device_devicemodel_alias
	 */
	public void setDevice_devicemodel_alias(String device_devicemodel_alias) {
		this.device_devicemodel_alias = device_devicemodel_alias;
	}

	/*
	 * Getter method to get device_device_software_version
	 */
	public String getDevice_device_software_version() {
		return device_device_software_version;
	}

	/*
	 * Setter method to set device_device_software_version
	 */
	public void setDevice_device_software_version(String device_device_software_version) {
		this.device_device_software_version = device_device_software_version;
	}

	/*
	 * Getter method to get device_device_last_modified_date
	 */
	public String getDevice_device_last_modified_date() {
		return device_device_last_modified_date;
	}

	/*
	 * Setter method to set device_device_last_modified_date
	 */
	public void setDevice_device_last_modified_date(String device_device_last_modified_date) {
		this.device_device_last_modified_date = device_device_last_modified_date;
	}

	/*
	 * Getter method to get device_devicetype_alias
	 */
	public String getDevice_devicetype_alias() {
		return device_devicetype_alias;
	}

	/*
	 * Setter method to set device_devicetype_alias
	 */
	public void setDevice_devicetype_alias(String device_devicetype_alias) {
		this.device_devicetype_alias = device_devicetype_alias;
	}

	/*
	 * Getter method to get device_devicevendor_id
	 */
	public Integer getDevice_devicevendor_id() {
		return device_devicevendor_id;
	}

	/*
	 * Setter method to set device_devicevendor_id
	 */
	public void setDevice_devicevendor_id(Integer device_devicevendor_id) {
		this.device_devicevendor_id = device_devicevendor_id;
	}

	/*
	 * Getter method to get country_id
	 */
	public Integer getCountry_id() {
		return country_id;
	}

	/*
	 * Setter method to set country_id
	 */
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	/*
	 * Getter method to get city_id
	 */
	public Integer getCity_id() {
		return city_id;
	}

	/*
	 * Setter method to set city_id
	 */
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	/*
	 * Getter method to get device_devicetechnology_id
	 */
	public Integer getDevice_devicetechnology_id() {
		return device_devicetechnology_id;
	}

	/*
	 * Setter method to set device_devicetechnology_id
	 */
	public void setDevice_devicetechnology_id(Integer device_devicetechnology_id) {
		this.device_devicetechnology_id = device_devicetechnology_id;
	}

	/*
	 * Getter method to get device_device_is_configurable
	 */
	public Boolean getDevice_device_is_configurable() {
		return device_device_is_configurable;
	}

	/*
	 * Setter method to set device_device_is_configurable
	 */
	public void setDevice_device_is_configurable(Boolean device_device_is_configurable) {
		this.device_device_is_configurable = device_device_is_configurable;
	}

	/*
	 * Getter method to get device_device_name
	 */
	public String getDevice_device_name() {
		return device_device_name;
	}

	/*
	 * Setter method to set device_device_name
	 */
	public void setDevice_device_name(String device_device_name) {
		this.device_device_name = device_device_name;
	}

	/*
	 * Getter method to get organization_organization_id
	 */
	public Integer getOrganization_organization_id() {
		return organization_organization_id;
	}

	/*
	 * Setter method to set organization_organization_id
	 */
	public void setOrganization_organization_id(Integer organization_organization_id) {
		this.organization_organization_id = organization_organization_id;
	}

	/*
	 * Getter method to get device_device_is_active
	 */
	public Boolean getDevice_device_is_active() {
		return device_device_is_active;
	}

	/*
	 * Setter method to set device_device_is_active
	 */
	public void setDevice_device_is_active(Boolean device_device_is_active) {
		this.device_device_is_active = device_device_is_active;
	}

	/*
	 * Getter method to get device_device_ipaddress
	 */
	public String getDevice_device_ipaddress() {
		return device_device_ipaddress;
	}

	/*
	 * Setter method to set device_device_ipaddress
	 */
	public void setDevice_device_ipaddress(String device_device_ipaddress) {
		this.device_device_ipaddress = device_device_ipaddress;
	}

	/*
	 * Getter method to get city_name
	 */
	public String getCity_name() {
		return city_name;
	}

	/*
	 * Setter method to set city_name
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	/*
	 * Getter method to get state_alias
	 */
	public String getState_alias() {
		return state_alias;
	}

	/*
	 * Setter method to set state_alias
	 */
	public void setState_alias(String state_alias) {
		this.state_alias = state_alias;
	}

	/*
	 * Getter method to get country_name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/*
	 * Setter method to set country_name
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/*
	 * Getter method to get status_timestamp
	 */
	public Long getStatus_timestamp() {
		return status_timestamp;
	}

	/*
	 * Setter method to set status_timestamp
	 */
	public void setStatus_timestamp(Long status_timestamp) {
		this.status_timestamp = status_timestamp;
	}

	/*
	 * Getter method to get device_device_description
	 */
	public String getDevice_device_description() {
		return device_device_description;
	}

	/*
	 * Setter method to set device_device_description
	 */
	public void setDevice_device_description(String device_device_description) {
		this.device_device_description = device_device_description;
	}

	/*
	 * Getter method to get country_alias
	 */
	public String getCountry_alias() {
		return country_alias;
	}

	/*
	 * Setter method to set country_alias
	 */
	public void setCountry_alias(String country_alias) {
		this.country_alias = country_alias;
	}

	/*
	 * Getter method to get device_devicetype_id
	 */
	public Integer getDevice_devicetype_id() {
		return device_devicetype_id;
	}

	/*
	 * Setter method to set device_devicetype_id
	 */
	public void setDevice_devicetype_id(Integer device_devicetype_id) {
		this.device_devicetype_id = device_devicetype_id;
	}

	/*
	 * Getter method to get data_source_alias
	 */
	public String getData_source_alias() {
		return data_source_alias;
	}

	/*
	 * Setter method to set data_source_alias
	 */
	public void setData_source_alias(String data_source_alias) {
		this.data_source_alias = data_source_alias;
	}

	/*
	 * Getter method to get device_device_creation_date
	 */
	public String getDevice_device_creation_date() {
		return device_device_creation_date;
	}

	/*
	 * Setter method to set device_device_creation_date
	 */
	public void setDevice_device_creation_date(String device_device_creation_date) {
		this.device_device_creation_date = device_device_creation_date;
	}

	/*
	 * Getter method to get device_devicemodel_name
	 */
	public String getDevice_devicemodel_name() {
		return device_devicemodel_name;
	}

	/*
	 * Setter method to set device_devicemodel_name
	 */
	public void setDevice_devicemodel_name(String device_devicemodel_name) {
		this.device_devicemodel_name = device_devicemodel_name;
	}

	/*
	 * Getter method to get device_device_parent_id
	 */
	public Integer getDevice_device_parent_id() {
		return device_device_parent_id;
	}

	/*
	 * Setter method to set device_device_parent_id
	 */
	public void setDevice_device_parent_id(Integer device_device_parent_id) {
		this.device_device_parent_id = device_device_parent_id;
	}

	/*
	 * Getter method to get device_device_hardware_version
	 */
	public String getDevice_device_hardware_version() {
		return device_device_hardware_version;
	}

	/*
	 * Setter method to set device_device_hardware_version
	 */
	public void setDevice_device_hardware_version(String device_device_hardware_version) {
		this.device_device_hardware_version = device_device_hardware_version;
	}

	/*
	 * Getter method to get device_tags
	 */
	public String getDevice_tags() {
		return device_tags;
	}

	/*
	 * Setter method to set device_tags
	 */
	public void setDevice_tags(String device_tags) {
		this.device_tags = device_tags;
	}

	/*
	 * Getter method to get device_devicemodel_id
	 */
	public Integer getDevice_devicemodel_id() {
		return device_devicemodel_id;
	}

	/*
	 * Setter method to set device_devicemodel_id
	 */
	public void setDevice_devicemodel_id(Integer device_devicemodel_id) {
		this.device_devicemodel_id = device_devicemodel_id;
	}

	/*
	 * Getter method to get device_device_device_id
	 */
	public Integer getDevice_device_device_id() {
		return device_device_device_id;
	}

	/*
	 * Setter method to set device_device_device_id
	 */
	public void setDevice_device_device_id(Integer device_device_device_id) {
		this.device_device_device_id = device_device_device_id;
	}

	/*
	 * Getter method to get device_device_mac_address
	 */
	public String getDevice_device_mac_address() {
		return device_device_mac_address;
	}

	/*
	 * Setter method to set device_device_mac_address
	 */
	public void setDevice_device_mac_address(String device_device_mac_address) {
		this.device_device_mac_address = device_device_mac_address;
	}

	/*
	 * Getter method to get device_devicetechnology_alias
	 */
	public String getDevice_devicetechnology_alias() {
		return device_devicetechnology_alias;
	}

	/*
	 * Setter method to set device_devicetechnology_alias
	 */
	public void setDevice_devicetechnology_alias(String device_devicetechnology_alias) {
		this.device_devicetechnology_alias = device_devicetechnology_alias;
	}

	/*
	 * Getter method to get device_device_parent_alias
	 */
	public String getDevice_device_parent_alias() {
		return device_device_parent_alias;
	}

	/*
	 * Setter method to set device_device_parent_alias
	 */
	public void setDevice_device_parent_alias(String device_device_parent_alias) {
		this.device_device_parent_alias = device_device_parent_alias;
	}
}