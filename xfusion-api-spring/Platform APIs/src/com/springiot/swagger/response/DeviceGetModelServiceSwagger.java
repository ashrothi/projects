/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/model/service API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetModelServiceSwagger {
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

	private List<DeviceGetModelService> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetModelService> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetModelService> object) {
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
 * Set the response parameters of /device/get/model/service API.
 * 
 *
 */
class DeviceGetModelService {
	// Initializing the variables
	private Integer service_servicedatasource_max_value;
	private String service_service_name;
	private Integer service_servicedatasource_priority;
	private Integer service_servicedatasource_data_type;
	private String device_devicemodel_name;
	private String service_servicedatasource_data_source_type;
	private Integer device_devicemodel_id;
	private String service_service_alias;
	private String service_servicedatasource_chart;
	private Integer service_servicedatasource_min_value;
	private Boolean service_servicedatasource_is_show_on_gis;
	private String device_devicemodel_alias;
	private String device_devicemodel_icon;
	private String device_devicemodel_devicetype;
	private String device_devicemodel_gis_icon;
	private String device_priority_alias;
	private String device_devicemodel_devicevendor;
	private String service_servicedatasource_unit;
	private String service_service_category;
	private Integer service_service_id;
	private String device_priority_name;
	private String charts_name;
	private String service_servicedatasource_colour;
	private String service_servicedatasource_alias;
	private Integer service_servicedatasource_id;
	private String charts_alias;
	private String service_servicedatatypes_name;
	private String device_devicemodel_devicetechnology;
	private Boolean service_servicedatasource_is_editable;
	private String colours_code;
	private Boolean service_servicedatasource_is_show_on_performance_report;
	private String service_servicedatasource_name;

	/**
	 * @return the service_servicedatasource_max_value
	 */
	public Integer getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}

	/**
	 * @param service_servicedatasource_max_value
	 *            the service_servicedatasource_max_value to set
	 */
	public void setService_servicedatasource_max_value(Integer service_servicedatasource_max_value) {
		this.service_servicedatasource_max_value = service_servicedatasource_max_value;
	}

	/**
	 * @return the service_service_name
	 */
	public String getService_service_name() {
		return service_service_name;
	}

	/**
	 * @param service_service_name
	 *            the service_service_name to set
	 */
	public void setService_service_name(String service_service_name) {
		this.service_service_name = service_service_name;
	}

	/**
	 * @return the service_servicedatasource_priority
	 */
	public Integer getService_servicedatasource_priority() {
		return service_servicedatasource_priority;
	}

	/**
	 * @param service_servicedatasource_priority
	 *            the service_servicedatasource_priority to set
	 */
	public void setService_servicedatasource_priority(Integer service_servicedatasource_priority) {
		this.service_servicedatasource_priority = service_servicedatasource_priority;
	}

	/**
	 * @return the service_servicedatasource_data_type
	 */
	public Integer getService_servicedatasource_data_type() {
		return service_servicedatasource_data_type;
	}

	/**
	 * @param service_servicedatasource_data_type
	 *            the service_servicedatasource_data_type to set
	 */
	public void setService_servicedatasource_data_type(Integer service_servicedatasource_data_type) {
		this.service_servicedatasource_data_type = service_servicedatasource_data_type;
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
	 * @return the service_servicedatasource_data_source_type
	 */
	public String getService_servicedatasource_data_source_type() {
		return service_servicedatasource_data_source_type;
	}

	/**
	 * @param service_servicedatasource_data_source_type
	 *            the service_servicedatasource_data_source_type to set
	 */
	public void setService_servicedatasource_data_source_type(String service_servicedatasource_data_source_type) {
		this.service_servicedatasource_data_source_type = service_servicedatasource_data_source_type;
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
	 * @return the service_service_alias
	 */
	public String getService_service_alias() {
		return service_service_alias;
	}

	/**
	 * @param service_service_alias
	 *            the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}

	/**
	 * @return the service_servicedatasource_chart
	 */
	public String getService_servicedatasource_chart() {
		return service_servicedatasource_chart;
	}

	/**
	 * @param service_servicedatasource_chart
	 *            the service_servicedatasource_chart to set
	 */
	public void setService_servicedatasource_chart(String service_servicedatasource_chart) {
		this.service_servicedatasource_chart = service_servicedatasource_chart;
	}

	/**
	 * @return the service_servicedatasource_min_value
	 */
	public Integer getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}

	/**
	 * @param service_servicedatasource_min_value
	 *            the service_servicedatasource_min_value to set
	 */
	public void setService_servicedatasource_min_value(Integer service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}

	/**
	 * @return the service_servicedatasource_is_show_on_gis
	 */
	public Boolean getService_servicedatasource_is_show_on_gis() {
		return service_servicedatasource_is_show_on_gis;
	}

	/**
	 * @param service_servicedatasource_is_show_on_gis
	 *            the service_servicedatasource_is_show_on_gis to set
	 */
	public void setService_servicedatasource_is_show_on_gis(Boolean service_servicedatasource_is_show_on_gis) {
		this.service_servicedatasource_is_show_on_gis = service_servicedatasource_is_show_on_gis;
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
	 * @return the device_priority_alias
	 */
	public String getDevice_priority_alias() {
		return device_priority_alias;
	}

	/**
	 * @param device_priority_alias
	 *            the device_priority_alias to set
	 */
	public void setDevice_priority_alias(String device_priority_alias) {
		this.device_priority_alias = device_priority_alias;
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
	 * @return the service_servicedatasource_unit
	 */
	public String getService_servicedatasource_unit() {
		return service_servicedatasource_unit;
	}

	/**
	 * @param service_servicedatasource_unit
	 *            the service_servicedatasource_unit to set
	 */
	public void setService_servicedatasource_unit(String service_servicedatasource_unit) {
		this.service_servicedatasource_unit = service_servicedatasource_unit;
	}

	/**
	 * @return the service_service_category
	 */
	public String getService_service_category() {
		return service_service_category;
	}

	/**
	 * @param service_service_category
	 *            the service_service_category to set
	 */
	public void setService_service_category(String service_service_category) {
		this.service_service_category = service_service_category;
	}

	/**
	 * @return the service_service_id
	 */
	public Integer getService_service_id() {
		return service_service_id;
	}

	/**
	 * @param service_service_id
	 *            the service_service_id to set
	 */
	public void setService_service_id(Integer service_service_id) {
		this.service_service_id = service_service_id;
	}

	/**
	 * @return the device_priority_name
	 */
	public String getDevice_priority_name() {
		return device_priority_name;
	}

	/**
	 * @param device_priority_name
	 *            the device_priority_name to set
	 */
	public void setDevice_priority_name(String device_priority_name) {
		this.device_priority_name = device_priority_name;
	}

	/**
	 * @return the charts_name
	 */
	public String getCharts_name() {
		return charts_name;
	}

	/**
	 * @param charts_name
	 *            the charts_name to set
	 */
	public void setCharts_name(String charts_name) {
		this.charts_name = charts_name;
	}

	/**
	 * @return the service_servicedatasource_colour
	 */
	public String getService_servicedatasource_colour() {
		return service_servicedatasource_colour;
	}

	/**
	 * @param service_servicedatasource_colour
	 *            the service_servicedatasource_colour to set
	 */
	public void setService_servicedatasource_colour(String service_servicedatasource_colour) {
		this.service_servicedatasource_colour = service_servicedatasource_colour;
	}

	/**
	 * @return the service_servicedatasource_alias
	 */
	public String getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}

	/**
	 * @param service_servicedatasource_alias
	 *            the service_servicedatasource_alias to set
	 */
	public void setService_servicedatasource_alias(String service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}

	/**
	 * @return the service_servicedatasource_id
	 */
	public Integer getService_servicedatasource_id() {
		return service_servicedatasource_id;
	}

	/**
	 * @param service_servicedatasource_id
	 *            the service_servicedatasource_id to set
	 */
	public void setService_servicedatasource_id(Integer service_servicedatasource_id) {
		this.service_servicedatasource_id = service_servicedatasource_id;
	}

	/**
	 * @return the charts_alias
	 */
	public String getCharts_alias() {
		return charts_alias;
	}

	/**
	 * @param charts_alias
	 *            the charts_alias to set
	 */
	public void setCharts_alias(String charts_alias) {
		this.charts_alias = charts_alias;
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
	 * @return the service_servicedatasource_is_editable
	 */
	public Boolean getService_servicedatasource_is_editable() {
		return service_servicedatasource_is_editable;
	}

	/**
	 * @param service_servicedatasource_is_editable
	 *            the service_servicedatasource_is_editable to set
	 */
	public void setService_servicedatasource_is_editable(Boolean service_servicedatasource_is_editable) {
		this.service_servicedatasource_is_editable = service_servicedatasource_is_editable;
	}

	/**
	 * @return the colours_code
	 */
	public String getColours_code() {
		return colours_code;
	}

	/**
	 * @param colours_code
	 *            the colours_code to set
	 */
	public void setColours_code(String colours_code) {
		this.colours_code = colours_code;
	}

	/**
	 * @return the service_servicedatasource_is_show_on_performance_report
	 */
	public Boolean getService_servicedatasource_is_show_on_performance_report() {
		return service_servicedatasource_is_show_on_performance_report;
	}

	/**
	 * @param service_servicedatasource_is_show_on_performance_report
	 *            the service_servicedatasource_is_show_on_performance_report to
	 *            set
	 */
	public void setService_servicedatasource_is_show_on_performance_report(
			Boolean service_servicedatasource_is_show_on_performance_report) {
		this.service_servicedatasource_is_show_on_performance_report = service_servicedatasource_is_show_on_performance_report;
	}

	/**
	 * @return the service_servicedatasource_name
	 */
	public String getService_servicedatasource_name() {
		return service_servicedatasource_name;
	}

	/**
	 * @param service_servicedatasource_name
	 *            the service_servicedatasource_name to set
	 */
	public void setService_servicedatasource_name(String service_servicedatasource_name) {
		this.service_servicedatasource_name = service_servicedatasource_name;
	}

}
