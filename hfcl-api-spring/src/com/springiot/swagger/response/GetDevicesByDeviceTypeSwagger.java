/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of API /get/devices/by/devicetype
 * 
 * 
 * @author tanvigarg
 *
 */
public class GetDevicesByDeviceTypeSwagger {
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

	private List<GetDevicesByDeviceType> object;

	/**
	 * @return the object
	 */
	public List<GetDevicesByDeviceType> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GetDevicesByDeviceType> object) {
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

/*
 * To get response parameter getter setter
 */
class GetDevicesByDeviceType {

	private String device_devicetype_name;
	private String city_alias;
	private String device_devicemodel_icon;
	private String device_device_imei;
	private String device_device_lattitude;
	private String device_device_elevation;
	private String device_devicetechnology_name;
	private String state_name;
	private String state_id;
	private String device_device_is_deleted;
	private String organization_organization_alias;
	private String device_device_alias;
	private String device_device_created_by;
	private String device_devicevendor_alias;
	private String device_device_longitude;
	private String device_device_modified_by;
	private String device_devicevendor_name;
	private String data_source;
	private String device_devicemodel_alias;
	private String organization_organization_path;
	private String device_device_iccid;
	private String device_device_software_version;
	private String device_device_last_modified_date;
	private String device_devicetype_alias;
	private String device_devicevendor_id;
	private String country_id;
	private String city_id;
	private String device_devicetechnology_id;
	private String device_device_is_configurable;
	private String device_device_name;
	private String device_device_is_active;
	private String device_device_ipaddress;
	private String city_name;
	private String state_alias;
	private String country_name;
	private String device_devicemodel_gis_icon;
	private String status_timestamp;
	private String device_device_description;
	private String country_alias;
	private String device_devicetype_id;
	private String data_source_alias;
	private String device_device_creation_date;
	private String check_timestamp;
	private String device_devicemodel_name;
	private String device_device_parent_id;
	private String device_device_hardware_version;
	private String device_devicemodel_id;
	private String device_device_device_id;
	private String device_device_mac_address;
	private String device_devicetechnology_alias;

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
	 * @return the device_device_imei
	 */
	public String getDevice_device_imei() {
		return device_device_imei;
	}

	/**
	 * @param device_device_imei
	 *            the device_device_imei to set
	 */
	public void setDevice_device_imei(String device_device_imei) {
		this.device_device_imei = device_device_imei;
	}

	/**
	 * @return the device_device_lattitude
	 */
	public String getDevice_device_lattitude() {
		return device_device_lattitude;
	}

	/**
	 * @param device_device_lattitude
	 *            the device_device_lattitude to set
	 */
	public void setDevice_device_lattitude(String device_device_lattitude) {
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
	 * @return the state_id
	 */
	public String getState_id() {
		return state_id;
	}

	/**
	 * @param state_id
	 *            the state_id to set
	 */
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	/**
	 * @return the device_device_is_deleted
	 */
	public String getDevice_device_is_deleted() {
		return device_device_is_deleted;
	}

	/**
	 * @param device_device_is_deleted
	 *            the device_device_is_deleted to set
	 */
	public void setDevice_device_is_deleted(String device_device_is_deleted) {
		this.device_device_is_deleted = device_device_is_deleted;
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
	 * @return the device_device_longitude
	 */
	public String getDevice_device_longitude() {
		return device_device_longitude;
	}

	/**
	 * @param device_device_longitude
	 *            the device_device_longitude to set
	 */
	public void setDevice_device_longitude(String device_device_longitude) {
		this.device_device_longitude = device_device_longitude;
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
	 * @return the organization_organization_path
	 */
	public String getOrganization_organization_path() {
		return organization_organization_path;
	}

	/**
	 * @param organization_organization_path
	 *            the organization_organization_path to set
	 */
	public void setOrganization_organization_path(String organization_organization_path) {
		this.organization_organization_path = organization_organization_path;
	}

	/**
	 * @return the device_device_iccid
	 */
	public String getDevice_device_iccid() {
		return device_device_iccid;
	}

	/**
	 * @param device_device_iccid
	 *            the device_device_iccid to set
	 */
	public void setDevice_device_iccid(String device_device_iccid) {
		this.device_device_iccid = device_device_iccid;
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
	 * @return the device_devicevendor_id
	 */
	public String getDevice_devicevendor_id() {
		return device_devicevendor_id;
	}

	/**
	 * @param device_devicevendor_id
	 *            the device_devicevendor_id to set
	 */
	public void setDevice_devicevendor_id(String device_devicevendor_id) {
		this.device_devicevendor_id = device_devicevendor_id;
	}

	/**
	 * @return the country_id
	 */
	public String getCountry_id() {
		return country_id;
	}

	/**
	 * @param country_id
	 *            the country_id to set
	 */
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	/**
	 * @return the city_id
	 */
	public String getCity_id() {
		return city_id;
	}

	/**
	 * @param city_id
	 *            the city_id to set
	 */
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	/**
	 * @return the device_devicetechnology_id
	 */
	public String getDevice_devicetechnology_id() {
		return device_devicetechnology_id;
	}

	/**
	 * @param device_devicetechnology_id
	 *            the device_devicetechnology_id to set
	 */
	public void setDevice_devicetechnology_id(String device_devicetechnology_id) {
		this.device_devicetechnology_id = device_devicetechnology_id;
	}

	/**
	 * @return the device_device_is_configurable
	 */
	public String getDevice_device_is_configurable() {
		return device_device_is_configurable;
	}

	/**
	 * @param device_device_is_configurable
	 *            the device_device_is_configurable to set
	 */
	public void setDevice_device_is_configurable(String device_device_is_configurable) {
		this.device_device_is_configurable = device_device_is_configurable;
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
	 * @return the device_device_is_active
	 */
	public String getDevice_device_is_active() {
		return device_device_is_active;
	}

	/**
	 * @param device_device_is_active
	 *            the device_device_is_active to set
	 */
	public void setDevice_device_is_active(String device_device_is_active) {
		this.device_device_is_active = device_device_is_active;
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
	 * @return the status_timestamp
	 */
	public String getStatus_timestamp() {
		return status_timestamp;
	}

	/**
	 * @param status_timestamp
	 *            the status_timestamp to set
	 */
	public void setStatus_timestamp(String status_timestamp) {
		this.status_timestamp = status_timestamp;
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
	 * @return the device_devicetype_id
	 */
	public String getDevice_devicetype_id() {
		return device_devicetype_id;
	}

	/**
	 * @param device_devicetype_id
	 *            the device_devicetype_id to set
	 */
	public void setDevice_devicetype_id(String device_devicetype_id) {
		this.device_devicetype_id = device_devicetype_id;
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
	 * @return the check_timestamp
	 */
	public String getCheck_timestamp() {
		return check_timestamp;
	}

	/**
	 * @param check_timestamp
	 *            the check_timestamp to set
	 */
	public void setCheck_timestamp(String check_timestamp) {
		this.check_timestamp = check_timestamp;
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
	 * @return the device_device_parent_id
	 */
	public String getDevice_device_parent_id() {
		return device_device_parent_id;
	}

	/**
	 * @param device_device_parent_id
	 *            the device_device_parent_id to set
	 */
	public void setDevice_device_parent_id(String device_device_parent_id) {
		this.device_device_parent_id = device_device_parent_id;
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
	 * @return the device_devicemodel_id
	 */
	public String getDevice_devicemodel_id() {
		return device_devicemodel_id;
	}

	/**
	 * @param device_devicemodel_id
	 *            the device_devicemodel_id to set
	 */
	public void setDevice_devicemodel_id(String device_devicemodel_id) {
		this.device_devicemodel_id = device_devicemodel_id;
	}

	/**
	 * @return the device_device_device_id
	 */
	public String getDevice_device_device_id() {
		return device_device_device_id;
	}

	/**
	 * @param device_device_device_id
	 *            the device_device_device_id to set
	 */
	public void setDevice_device_device_id(String device_device_device_id) {
		this.device_device_device_id = device_device_device_id;
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

}
