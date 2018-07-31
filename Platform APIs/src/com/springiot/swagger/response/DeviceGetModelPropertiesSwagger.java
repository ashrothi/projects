/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/model/properties API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetModelPropertiesSwagger {
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

	private List<DeviceGetModelProperties> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetModelProperties> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetModelProperties> object) {
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
 * Set the response parameters of /device/get/model/properties API.
 * 
 *
 */
class DeviceGetModelProperties {
	// Initializing the variables
	private String device_devicemodel_gis_icon;
	private Integer device_properties_id;
	private Boolean device_model_properties_is_visible_on_gis;
	private String device_devicemodel_devicevendor;
	private String device_devicetechnology_name;
	private String device_devicemodel_name;
	private String device_properties_alias;
	private String device_properties_data_type;
	private String device_devicetype_name;
	private String device_model_properties_properties;
	private String device_model_properties_model;
	private String device_devicetechnology_alias;
	private String device_devicevendor_alias;
	private Boolean device_model_properties_is_visible_on_performance_report;
	private String device_devicevendor_name;
	private String service_servicedatatypes_name;
	private Integer device_devicemodel_id;
	private String device_devicemodel_devicetechnology;
	private String device_properties_name;
	private Integer device_model_properties_id;
	private String device_devicetype_alias;
	private String device_devicemodel_alias;
	private String device_devicemodel_icon;
	private String device_devicemodel_devicetype;

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
	 * @return the device_properties_id
	 */
	public Integer getDevice_properties_id() {
		return device_properties_id;
	}

	/**
	 * @param device_properties_id
	 *            the device_properties_id to set
	 */
	public void setDevice_properties_id(Integer device_properties_id) {
		this.device_properties_id = device_properties_id;
	}

	/**
	 * @return the device_model_properties_is_visible_on_gis
	 */
	public Boolean getDevice_model_properties_is_visible_on_gis() {
		return device_model_properties_is_visible_on_gis;
	}

	/**
	 * @param device_model_properties_is_visible_on_gis
	 *            the device_model_properties_is_visible_on_gis to set
	 */
	public void setDevice_model_properties_is_visible_on_gis(Boolean device_model_properties_is_visible_on_gis) {
		this.device_model_properties_is_visible_on_gis = device_model_properties_is_visible_on_gis;
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
	 * @return the device_properties_alias
	 */
	public String getDevice_properties_alias() {
		return device_properties_alias;
	}

	/**
	 * @param device_properties_alias
	 *            the device_properties_alias to set
	 */
	public void setDevice_properties_alias(String device_properties_alias) {
		this.device_properties_alias = device_properties_alias;
	}

	/**
	 * @return the device_properties_data_type
	 */
	public String getDevice_properties_data_type() {
		return device_properties_data_type;
	}

	/**
	 * @param device_properties_data_type
	 *            the device_properties_data_type to set
	 */
	public void setDevice_properties_data_type(String device_properties_data_type) {
		this.device_properties_data_type = device_properties_data_type;
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
	 * @return the device_model_properties_properties
	 */
	public String getDevice_model_properties_properties() {
		return device_model_properties_properties;
	}

	/**
	 * @param device_model_properties_properties
	 *            the device_model_properties_properties to set
	 */
	public void setDevice_model_properties_properties(String device_model_properties_properties) {
		this.device_model_properties_properties = device_model_properties_properties;
	}

	/**
	 * @return the device_model_properties_model
	 */
	public String getDevice_model_properties_model() {
		return device_model_properties_model;
	}

	/**
	 * @param device_model_properties_model
	 *            the device_model_properties_model to set
	 */
	public void setDevice_model_properties_model(String device_model_properties_model) {
		this.device_model_properties_model = device_model_properties_model;
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
	 * @return the device_model_properties_is_visible_on_performance_report
	 */
	public Boolean getDevice_model_properties_is_visible_on_performance_report() {
		return device_model_properties_is_visible_on_performance_report;
	}

	/**
	 * @param device_model_properties_is_visible_on_performance_report
	 *            the device_model_properties_is_visible_on_performance_report
	 *            to set
	 */
	public void setDevice_model_properties_is_visible_on_performance_report(
			Boolean device_model_properties_is_visible_on_performance_report) {
		this.device_model_properties_is_visible_on_performance_report = device_model_properties_is_visible_on_performance_report;
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
	 * @return the service_servicedatatypes_name
	 */
	public String getService_servicedatatypes_name() {
		return service_servicedatatypes_name;
	}

	/**
	 * @param service_servicedatatypes_name
	 *            the service_servicedatatypes_name to set
	 */
	public void setService_servicedatatypes_name(String service_servicedatatypes_name) {
		this.service_servicedatatypes_name = service_servicedatatypes_name;
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
	 * @return the device_properties_name
	 */
	public String getDevice_properties_name() {
		return device_properties_name;
	}

	/**
	 * @param device_properties_name
	 *            the device_properties_name to set
	 */
	public void setDevice_properties_name(String device_properties_name) {
		this.device_properties_name = device_properties_name;
	}

	/**
	 * @return the device_model_properties_id
	 */
	public Integer getDevice_model_properties_id() {
		return device_model_properties_id;
	}

	/**
	 * @param device_model_properties_id
	 *            the device_model_properties_id to set
	 */
	public void setDevice_model_properties_id(Integer device_model_properties_id) {
		this.device_model_properties_id = device_model_properties_id;
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
}