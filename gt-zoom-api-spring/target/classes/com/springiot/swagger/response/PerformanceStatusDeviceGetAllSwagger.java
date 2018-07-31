/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API /performance/status/device/get/all.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class PerformanceStatusDeviceGetAllSwagger {
	private String description;
	private List<PerformanceStatusDeviceGetAll> object;
	private boolean valid;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the object
	 */
	public List<PerformanceStatusDeviceGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<PerformanceStatusDeviceGetAll> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * This class is used for setting data into the object.
 */
class PerformanceStatusDeviceGetAll {
	// Initializing the variables.
	private String severity;
	private Integer device_id;
	private String charts_alias;
	private String service_name;
	private long check_timestamp;
	private String service_servicedatasource_unit;
	private String service_servicedatasource_max_value;
	private Integer charts_id;
	private String service_servicedatasource_min_value;
	private String charts_name;
	private String data_source;
	private String current_value;
	private String service_servicedatasource_alias;
	private String device_name;
	private String service_service_alias;
	private Integer colours_id;
	private String colours_name;
	private long sys_timestamp;
	private String device_alias;
	private String colours_code;
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the charts_alias
	 */
	public String getCharts_alias() {
		return charts_alias;
	}
	/**
	 * @param charts_alias the charts_alias to set
	 */
	public void setCharts_alias(String charts_alias) {
		this.charts_alias = charts_alias;
	}
	/**
	 * @return the service_name
	 */
	public String getService_name() {
		return service_name;
	}
	/**
	 * @param service_name the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	/**
	 * @return the check_timestamp
	 */
	public long getCheck_timestamp() {
		return check_timestamp;
	}
	/**
	 * @param check_timestamp the check_timestamp to set
	 */
	public void setCheck_timestamp(long check_timestamp) {
		this.check_timestamp = check_timestamp;
	}
	/**
	 * @return the service_servicedatasource_unit
	 */
	public String getService_servicedatasource_unit() {
		return service_servicedatasource_unit;
	}
	/**
	 * @param service_servicedatasource_unit the service_servicedatasource_unit to set
	 */
	public void setService_servicedatasource_unit(String service_servicedatasource_unit) {
		this.service_servicedatasource_unit = service_servicedatasource_unit;
	}
	/**
	 * @return the service_servicedatasource_max_value
	 */
	public String getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}
	/**
	 * @param service_servicedatasource_max_value the service_servicedatasource_max_value to set
	 */
	public void setService_servicedatasource_max_value(String service_servicedatasource_max_value) {
		this.service_servicedatasource_max_value = service_servicedatasource_max_value;
	}
	/**
	 * @return the charts_id
	 */
	public Integer getCharts_id() {
		return charts_id;
	}
	/**
	 * @param charts_id the charts_id to set
	 */
	public void setCharts_id(Integer charts_id) {
		this.charts_id = charts_id;
	}
	/**
	 * @return the service_servicedatasource_min_value
	 */
	public String getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}
	/**
	 * @param service_servicedatasource_min_value the service_servicedatasource_min_value to set
	 */
	public void setService_servicedatasource_min_value(String service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}
	/**
	 * @return the charts_name
	 */
	public String getCharts_name() {
		return charts_name;
	}
	/**
	 * @param charts_name the charts_name to set
	 */
	public void setCharts_name(String charts_name) {
		this.charts_name = charts_name;
	}
	/**
	 * @return the data_source
	 */
	public String getData_source() {
		return data_source;
	}
	/**
	 * @param data_source the data_source to set
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}
	/**
	 * @return the current_value
	 */
	public String getCurrent_value() {
		return current_value;
	}
	/**
	 * @param current_value the current_value to set
	 */
	public void setCurrent_value(String current_value) {
		this.current_value = current_value;
	}
	/**
	 * @return the service_servicedatasource_alias
	 */
	public String getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}
	/**
	 * @param service_servicedatasource_alias the service_servicedatasource_alias to set
	 */
	public void setService_servicedatasource_alias(String service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}
	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	/**
	 * @return the service_service_alias
	 */
	public String getService_service_alias() {
		return service_service_alias;
	}
	/**
	 * @param service_service_alias the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}
	/**
	 * @return the colours_id
	 */
	public Integer getColours_id() {
		return colours_id;
	}
	/**
	 * @param colours_id the colours_id to set
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
	 * @param colours_name the colours_name to set
	 */
	public void setColours_name(String colours_name) {
		this.colours_name = colours_name;
	}
	/**
	 * @return the sys_timestamp
	 */
	public long getSys_timestamp() {
		return sys_timestamp;
	}
	/**
	 * @param sys_timestamp the sys_timestamp to set
	 */
	public void setSys_timestamp(long sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}
	/**
	 * @return the device_alias
	 */
	public String getDevice_alias() {
		return device_alias;
	}
	/**
	 * @param device_alias the device_alias to set
	 */
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}
	/**
	 * @return the colours_code
	 */
	public String getColours_code() {
		return colours_code;
	}
	/**
	 * @param colours_code the colours_code to set
	 */
	public void setColours_code(String colours_code) {
		this.colours_code = colours_code;
	}
}