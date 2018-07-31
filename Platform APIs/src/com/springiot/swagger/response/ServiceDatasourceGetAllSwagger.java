/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /service/datasource/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ServiceDatasourceGetAllSwagger {
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

	private List<ServiceDatasourceGetAll> object;

	/**
	 * @return the object
	 */
	public List<ServiceDatasourceGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ServiceDatasourceGetAll> object) {
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
 * Set the response parameters of /service/datasource/get/all API.
 * 
 *
 */
class ServiceDatasourceGetAll {
	// Initializing the variables
	private String device_modelservice_id;
	private String device_modelservice_model;
	private String device_modelservice_service;
	private Integer device_devicemodel_id;
	private String device_devicemodel_name;
	private String device_devicemodel_alias;
	private String device_devicemodel_devicetype;
	private Integer device_devicetype_id;
	private String device_devicetype_name;
	private String device_devicetype_alias;
	private Integer service_service_id;
	private String service_service_name;
	private String service_service_alias;
	private String service_service_category;
	private Integer service_service_servicedatasource_id;
	private String service_service_servicedatasource_service;
	private String service_service_servicedatasource_datasource;
	private Integer service_servicedatasource_id;
	private String service_servicedatasource_name;
	private String service_servicedatasource_alias;
	private String service_servicedatasource_min_value;
	private String service_servicedatasource_max_value;
	private String service_servicedatasource_unit;
	private String service_servicedatasource_colour;
	private String service_servicedatasource_chart;
	private String service_servicedatasource_priority;
	private String service_servicedatasource_data_source_type;
	private Integer charts_id;
	private String charts_name;
	private String charts_alias;
	private Integer colours_id;
	private String colours_name;
	private String colours_alias;
	private String colours_code;
	private String service_servicedatasource_is_show_on_performance_report;
	private String service_servicedatasource_is_show_on_gis;

	/**
	 * @return the device_modelservice_id
	 */
	public String getDevice_modelservice_id() {
		return device_modelservice_id;
	}

	/**
	 * @param device_modelservice_id
	 *            the device_modelservice_id to set
	 */
	public void setDevice_modelservice_id(String device_modelservice_id) {
		this.device_modelservice_id = device_modelservice_id;
	}

	/**
	 * @return the device_modelservice_model
	 */
	public String getDevice_modelservice_model() {
		return device_modelservice_model;
	}

	/**
	 * @param device_modelservice_model
	 *            the device_modelservice_model to set
	 */
	public void setDevice_modelservice_model(String device_modelservice_model) {
		this.device_modelservice_model = device_modelservice_model;
	}

	/**
	 * @return the device_modelservice_service
	 */
	public String getDevice_modelservice_service() {
		return device_modelservice_service;
	}

	/**
	 * @param device_modelservice_service
	 *            the device_modelservice_service to set
	 */
	public void setDevice_modelservice_service(String device_modelservice_service) {
		this.device_modelservice_service = device_modelservice_service;
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
	 * @return the service_service_servicedatasource_id
	 */
	public Integer getService_service_servicedatasource_id() {
		return service_service_servicedatasource_id;
	}

	/**
	 * @param service_service_servicedatasource_id
	 *            the service_service_servicedatasource_id to set
	 */
	public void setService_service_servicedatasource_id(Integer service_service_servicedatasource_id) {
		this.service_service_servicedatasource_id = service_service_servicedatasource_id;
	}

	/**
	 * @return the service_service_servicedatasource_service
	 */
	public String getService_service_servicedatasource_service() {
		return service_service_servicedatasource_service;
	}

	/**
	 * @param service_service_servicedatasource_service
	 *            the service_service_servicedatasource_service to set
	 */
	public void setService_service_servicedatasource_service(String service_service_servicedatasource_service) {
		this.service_service_servicedatasource_service = service_service_servicedatasource_service;
	}

	/**
	 * @return the service_service_servicedatasource_datasource
	 */
	public String getService_service_servicedatasource_datasource() {
		return service_service_servicedatasource_datasource;
	}

	/**
	 * @param service_service_servicedatasource_datasource
	 *            the service_service_servicedatasource_datasource to set
	 */
	public void setService_service_servicedatasource_datasource(String service_service_servicedatasource_datasource) {
		this.service_service_servicedatasource_datasource = service_service_servicedatasource_datasource;
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
	public String getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}

	/**
	 * @param service_servicedatasource_min_value
	 *            the service_servicedatasource_min_value to set
	 */
	public void setService_servicedatasource_min_value(String service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}

	/**
	 * @return the service_servicedatasource_max_value
	 */
	public String getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}

	/**
	 * @param service_servicedatasource_max_value
	 *            the service_servicedatasource_max_value to set
	 */
	public void setService_servicedatasource_max_value(String service_servicedatasource_max_value) {
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
	 * @return the service_servicedatasource_priority
	 */
	public String getService_servicedatasource_priority() {
		return service_servicedatasource_priority;
	}

	/**
	 * @param service_servicedatasource_priority
	 *            the service_servicedatasource_priority to set
	 */
	public void setService_servicedatasource_priority(String service_servicedatasource_priority) {
		this.service_servicedatasource_priority = service_servicedatasource_priority;
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
	 * @return the colours_name
	 */
	public String getColours_name() {
		return colours_name;
	}

	/**
	 * @param colours_name
	 *            the colours_name to set
	 */
	public void setColours_name(String colours_name) {
		this.colours_name = colours_name;
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
	 * @return the service_servicedatasource_is_show_on_performance_report
	 */
	public String getService_servicedatasource_is_show_on_performance_report() {
		return service_servicedatasource_is_show_on_performance_report;
	}

	/**
	 * @param service_servicedatasource_is_show_on_performance_report
	 *            the service_servicedatasource_is_show_on_performance_report to
	 *            set
	 */
	public void setService_servicedatasource_is_show_on_performance_report(
			String service_servicedatasource_is_show_on_performance_report) {
		this.service_servicedatasource_is_show_on_performance_report = service_servicedatasource_is_show_on_performance_report;
	}

	/**
	 * @return the service_servicedatasource_is_show_on_gis
	 */
	public String getService_servicedatasource_is_show_on_gis() {
		return service_servicedatasource_is_show_on_gis;
	}

	/**
	 * @param service_servicedatasource_is_show_on_gis
	 *            the service_servicedatasource_is_show_on_gis to set
	 */
	public void setService_servicedatasource_is_show_on_gis(String service_servicedatasource_is_show_on_gis) {
		this.service_servicedatasource_is_show_on_gis = service_servicedatasource_is_show_on_gis;
	}

}