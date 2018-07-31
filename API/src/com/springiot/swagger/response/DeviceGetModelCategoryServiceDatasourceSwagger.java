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
 * This class contains response of /device/get/model/category/service/datasource
 * API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetModelCategoryServiceDatasourceSwagger {
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
	private List<DeviceModelGetAll> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<DeviceModelGetAll> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<DeviceModelGetAll> object) {
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
 * Set the response parameters of /device/get/model/category/service/datasource
 * API.
 * 
 * @author tanvigarg
 *
 */
class DeviceGetModelCategoryServiceDatasource {
	// Initializing the variables
	private Integer device_devicemodel_id;
	private String device_devicemodel_name;
	private String device_devicemodel_alias;
	private String device_devicemodel_gis_icon;
	private String device_devicemodel_icon;
	private String device_modelcategory_category;
	private Integer service_servicecategory_id;
	private String service_servicecategory_name;
	private String service_servicecategory_alias;
	private String service_servicecategory_path;
	private String service_servicecategory_order;
	private String service_servicecategory_depth;
	private Integer service_service_id;
	private String service_service_name;
	private String service_service_alias;
	private Integer service_servicedatasource_id;
	private String service_servicedatasource_name;
	private String service_servicedatasource_alias;
	private Integer service_servicedatasource_min_value;
	private Integer service_servicedatasource_max_value;
	private String service_servicedatasource_unit;
	private String service_servicedatasource_data_type;
	private String service_servicedatasource_regex;
	private String service_servicedatatypes_name;
	private String service_servicedatasource_chart;
	private String service_servicedatasource_colour;
	private Boolean service_service_categoryservicedatasource_is_shown;
	private Boolean service_service_categoryservicedatasource_is_editable;
	private Integer colours_id;
	private String colours_alias;
	private String colours_code;
	private Integer charts_id;
	private String charts_name;
	private String charts_alias;
	private String control_type_name;
	private String default_values;
	private String default_text;
	private String max_select;

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
	 * @return the device_modelcategory_category
	 */
	public String getDevice_modelcategory_category() {
		return device_modelcategory_category;
	}

	/**
	 * @param device_modelcategory_category
	 *            the device_modelcategory_category to set
	 */
	public void setDevice_modelcategory_category(String device_modelcategory_category) {
		this.device_modelcategory_category = device_modelcategory_category;
	}

	/**
	 * @return the service_servicecategory_id
	 */
	public Integer getService_servicecategory_id() {
		return service_servicecategory_id;
	}

	/**
	 * @param service_servicecategory_id
	 *            the service_servicecategory_id to set
	 */
	public void setService_servicecategory_id(Integer service_servicecategory_id) {
		this.service_servicecategory_id = service_servicecategory_id;
	}

	/**
	 * @return the service_servicecategory_name
	 */
	public String getService_servicecategory_name() {
		return service_servicecategory_name;
	}

	/**
	 * @param service_servicecategory_name
	 *            the service_servicecategory_name to set
	 */
	public void setService_servicecategory_name(String service_servicecategory_name) {
		this.service_servicecategory_name = service_servicecategory_name;
	}

	/**
	 * @return the service_servicecategory_alias
	 */
	public String getService_servicecategory_alias() {
		return service_servicecategory_alias;
	}

	/**
	 * @param service_servicecategory_alias
	 *            the service_servicecategory_alias to set
	 */
	public void setService_servicecategory_alias(String service_servicecategory_alias) {
		this.service_servicecategory_alias = service_servicecategory_alias;
	}

	/**
	 * @return the service_servicecategory_path
	 */
	public String getService_servicecategory_path() {
		return service_servicecategory_path;
	}

	/**
	 * @param service_servicecategory_path
	 *            the service_servicecategory_path to set
	 */
	public void setService_servicecategory_path(String service_servicecategory_path) {
		this.service_servicecategory_path = service_servicecategory_path;
	}

	/**
	 * @return the service_servicecategory_order
	 */
	public String getService_servicecategory_order() {
		return service_servicecategory_order;
	}

	/**
	 * @param service_servicecategory_order
	 *            the service_servicecategory_order to set
	 */
	public void setService_servicecategory_order(String service_servicecategory_order) {
		this.service_servicecategory_order = service_servicecategory_order;
	}

	/**
	 * @return the service_servicecategory_depth
	 */
	public String getService_servicecategory_depth() {
		return service_servicecategory_depth;
	}

	/**
	 * @param service_servicecategory_depth
	 *            the service_servicecategory_depth to set
	 */
	public void setService_servicecategory_depth(String service_servicecategory_depth) {
		this.service_servicecategory_depth = service_servicecategory_depth;
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
	 * @return the service_servicedatasource_data_type
	 */
	public String getService_servicedatasource_data_type() {
		return service_servicedatasource_data_type;
	}

	/**
	 * @param service_servicedatasource_data_type
	 *            the service_servicedatasource_data_type to set
	 */
	public void setService_servicedatasource_data_type(String service_servicedatasource_data_type) {
		this.service_servicedatasource_data_type = service_servicedatasource_data_type;
	}

	/**
	 * @return the service_servicedatasource_regex
	 */
	public String getService_servicedatasource_regex() {
		return service_servicedatasource_regex;
	}

	/**
	 * @param service_servicedatasource_regex
	 *            the service_servicedatasource_regex to set
	 */
	public void setService_servicedatasource_regex(String service_servicedatasource_regex) {
		this.service_servicedatasource_regex = service_servicedatasource_regex;
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
	 * @return the service_service_categoryservicedatasource_is_shown
	 */
	public Boolean getService_service_categoryservicedatasource_is_shown() {
		return service_service_categoryservicedatasource_is_shown;
	}

	/**
	 * @param service_service_categoryservicedatasource_is_shown
	 *            the service_service_categoryservicedatasource_is_shown to set
	 */
	public void setService_service_categoryservicedatasource_is_shown(
			Boolean service_service_categoryservicedatasource_is_shown) {
		this.service_service_categoryservicedatasource_is_shown = service_service_categoryservicedatasource_is_shown;
	}

	/**
	 * @return the service_service_categoryservicedatasource_is_editable
	 */
	public Boolean getService_service_categoryservicedatasource_is_editable() {
		return service_service_categoryservicedatasource_is_editable;
	}

	/**
	 * @param service_service_categoryservicedatasource_is_editable
	 *            the service_service_categoryservicedatasource_is_editable to
	 *            set
	 */
	public void setService_service_categoryservicedatasource_is_editable(
			Boolean service_service_categoryservicedatasource_is_editable) {
		this.service_service_categoryservicedatasource_is_editable = service_service_categoryservicedatasource_is_editable;
	}

	/**
	 * @return the colours_id
	 */
	public Integer getColours_id() {
		return colours_id;
	}

	/**
	 * @param colours_id
	 *            the colours_id to set
	 */
	public void setColours_id(Integer colours_id) {
		this.colours_id = colours_id;
	}

	/**
	 * @return the colours_alias
	 */
	public String getColours_alias() {
		return colours_alias;
	}

	/**
	 * @param colours_alias
	 *            the colours_alias to set
	 */
	public void setColours_alias(String colours_alias) {
		this.colours_alias = colours_alias;
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
	 * @return the charts_id
	 */
	public Integer getCharts_id() {
		return charts_id;
	}

	/**
	 * @param charts_id
	 *            the charts_id to set
	 */
	public void setCharts_id(Integer charts_id) {
		this.charts_id = charts_id;
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
	 * @return the control_type_name
	 */
	public String getControl_type_name() {
		return control_type_name;
	}

	/**
	 * @param control_type_name
	 *            the control_type_name to set
	 */
	public void setControl_type_name(String control_type_name) {
		this.control_type_name = control_type_name;
	}

	/**
	 * @return the default_values
	 */
	public String getDefault_values() {
		return default_values;
	}

	/**
	 * @param default_values
	 *            the default_values to set
	 */
	public void setDefault_values(String default_values) {
		this.default_values = default_values;
	}

	/**
	 * @return the default_text
	 */
	public String getDefault_text() {
		return default_text;
	}

	/**
	 * @param default_text
	 *            the default_text to set
	 */
	public void setDefault_text(String default_text) {
		this.default_text = default_text;
	}

	/**
	 * @return the max_select
	 */
	public String getMax_select() {
		return max_select;
	}

	/**
	 * @param max_select
	 *            the max_select to set
	 */
	public void setMax_select(String max_select) {
		this.max_select = max_select;
	}

}