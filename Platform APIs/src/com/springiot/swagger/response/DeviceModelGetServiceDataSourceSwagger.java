/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /device/model/get/service/data/source API
 * response
 * 
 * @author tanvigarg
 *
 */
public class DeviceModelGetServiceDataSourceSwagger {
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
	private List<DeviceModelGetServiceDataSource> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<DeviceModelGetServiceDataSource> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<DeviceModelGetServiceDataSource> object) {
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
 * Set the response parameters of /device/model/get/service/data/source API.
 * 
 * @author tanvigarg
 *
 */

class DeviceModelGetServiceDataSource {
	// Initializing the variables
	private String service_service_id;
	private String service_service_name;
	private String service_service_alias;
	private String service_servicedatasource_id;
	private String service_servicedatasource_name;
	private String service_servicedatasource_alias;
	private String service_servicedatasource_min_value;
	private String service_servicedatasource_max_value;
	private String service_servicedatasource_unit;
	private String charts_id;
	private String charts_alias;
	private String colours_id;
	private String colours_name;
	private String colours_alias;
	private String colours_code;
	private String service_servicedatasource_priority;
	private String service_servicedatasource_data_source_type;

	/**
	 * @return the service_service_id
	 */
	public String getService_service_id() {
		return service_service_id;
	}

	/**
	 * @param service_service_id
	 *            the service_service_id to set
	 */
	public void setService_service_id(String service_service_id) {
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
	public String getService_servicedatasource_id() {
		return service_servicedatasource_id;
	}

	/**
	 * @param service_servicedatasource_id
	 *            the service_servicedatasource_id to set
	 */
	public void setService_servicedatasource_id(String service_servicedatasource_id) {
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
	 * @return the charts_id
	 */
	public String getCharts_id() {
		return charts_id;
	}

	/**
	 * @param charts_id
	 *            the charts_id to set
	 */
	public void setCharts_id(String charts_id) {
		this.charts_id = charts_id;
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
	public String getColours_id() {
		return colours_id;
	}

	/**
	 * @param colours_id
	 *            the colours_id to set
	 */
	public void setColours_id(String colours_id) {
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

}