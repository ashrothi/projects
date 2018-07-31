/**
 * This package contains classes for processing on data.
 */
package com.teramatrix.processData;

/**
 * This is model class for storing all the alerts of a device.
 * 
 * @author Mandeep Singh
 *
 */
public class AlertsModel {
	private String severity;
	private String device_id;
	private String service_name;
	private String check_timestamp;
	private String service_servicedatasource_unit;
	private String service_servicedatasource_max_value;
	private String severity_colour;
	private String service_servicedatasource_min_value;
	private String data_source;
	private String current_value;
	private String service_servicedatasource_alias;
	private String rule_id;
	private String device_name;
	private String service_service_alias;
	private String sys_timestamp;
	private String device_alias;
	private String organization_alias;
	private String organization_path;
	
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
	public String getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
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
	public String getCheck_timestamp() {
		return check_timestamp;
	}
	/**
	 * @param check_timestamp the check_timestamp to set
	 */
	public void setCheck_timestamp(String check_timestamp) {
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
	 * @return the severity_colour
	 */
	public String getSeverity_colour() {
		return severity_colour;
	}
	/**
	 * @param severity_colour the severity_colour to set
	 */
	public void setSeverity_colour(String severity_colour) {
		this.severity_colour = severity_colour;
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
	 * @return the rule_id
	 */
	public String getRule_id() {
		return rule_id;
	}
	/**
	 * @param rule_id the rule_id to set
	 */
	public void setRule_id(String rule_id) {
		this.rule_id = rule_id;
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
	 * @return the sys_timestamp
	 */
	public String getSys_timestamp() {
		return sys_timestamp;
	}
	/**
	 * @param sys_timestamp the sys_timestamp to set
	 */
	public void setSys_timestamp(String sys_timestamp) {
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
	 * @return the organization_alias
	 */
	public String getOrganization_alias() {
		return organization_alias;
	}
	/**
	 * @param organization_alias the organization_alias to set
	 */
	public void setOrganization_alias(String organization_alias) {
		this.organization_alias = organization_alias;
	}
	/**
	 * @return the organization_path
	 */
	public String getOrganization_path() {
		return organization_path;
	}
	/**
	 * @param organization_path the organization_path to set
	 */
	public void setOrganization_path(String organization_path) {
		this.organization_path = organization_path;
	}
	
	/**
	 * This method is used to return all the variables values.
	 */
	@Override
	public String toString() {
		String row = "";
		// Here return all the variable values.
		if(current_value.equalsIgnoreCase("0.0") || current_value.equalsIgnoreCase("0")){
			
		}
		else{
			row = "('" + severity + "', '" + device_id + "', '" + service_name + "', '" + check_timestamp
					+ "', '" + service_servicedatasource_unit + "', '" + service_servicedatasource_max_value + "', '" + severity_colour
					+ "', '" + service_servicedatasource_min_value + "', '" + data_source + "', '" + current_value 
					+ "', '" + service_servicedatasource_alias + "', '" + rule_id + "', '" + device_name + "', '" + service_service_alias
					+ "', '" + sys_timestamp + "', '" + device_alias + "', '" + organization_alias + "', '" + organization_path + "'),";
		}
		// Here return all the variable values.
		return row;
		
	}
}
