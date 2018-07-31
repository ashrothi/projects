/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on
 * /performance/eventstatus/alert/device/type/get/all/limit API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class PerformanceEventstatusAlertDeviceTypeGetAllLimitSwagger {
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

	private List<PerformanceEventstatusAlertDeviceTypeGetAllLimit> object;

	/**
	 * @return the object
	 */
	public List<PerformanceEventstatusAlertDeviceTypeGetAllLimit> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<PerformanceEventstatusAlertDeviceTypeGetAllLimit> object) {
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
 * Set the response parameters of
 * /performance/eventstatus/alert/device/type/get/all/limit API.
 * 
 *
 */
class PerformanceEventstatusAlertDeviceTypeGetAllLimit {
	// Initializing the variables
	private String device_id;
	private String service_name;
	private String data_source;
	private Long sys_timestamp;
	private Long check_timestamp;
	private String severity;
	private String severity_colour;
	private String current_value;
	private String device_alias;
	private String device_name;
	private String service_service_alias;
	private String service_servicedatasource_alias;
	private Integer service_servicedatasource_min_value;
	private Integer service_servicedatasource_max_value;
	private String service_servicedatasource_unit;
	private String rule_engine_rule_description;
	private String rule_engine_rule_name;
	private Long rule_engine_rule_global_rule_id;
	private Integer rule_engine_rule_rule_order;
	private String rule_engine_rule_operator;
	private Integer rule_engine_rule_id;

	/**
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
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
	 * @param service_name
	 *            the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
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
	 * @return the sys_timestamp
	 */
	public Long getSys_timestamp() {
		return sys_timestamp;
	}

	/**
	 * @param sys_timestamp
	 *            the sys_timestamp to set
	 */
	public void setSys_timestamp(Long sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}

	/**
	 * @return the check_timestamp
	 */
	public Long getCheck_timestamp() {
		return check_timestamp;
	}

	/**
	 * @param check_timestamp
	 *            the check_timestamp to set
	 */
	public void setCheck_timestamp(Long check_timestamp) {
		this.check_timestamp = check_timestamp;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the severity_colour
	 */
	public String getSeverity_colour() {
		return severity_colour;
	}

	/**
	 * @param severity_colour
	 *            the severity_colour to set
	 */
	public void setSeverity_colour(String severity_colour) {
		this.severity_colour = severity_colour;
	}

	/**
	 * @return the current_value
	 */
	public String getCurrent_value() {
		return current_value;
	}

	/**
	 * @param current_value
	 *            the current_value to set
	 */
	public void setCurrent_value(String current_value) {
		this.current_value = current_value;
	}

	/**
	 * @return the device_alias
	 */
	public String getDevice_alias() {
		return device_alias;
	}

	/**
	 * @param device_alias
	 *            the device_alias to set
	 */
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}

	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}

	/**
	 * @param device_name
	 *            the device_name to set
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
	 * @param service_service_alias
	 *            the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
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
	 * @return the rule_engine_rule_description
	 */
	public String getRule_engine_rule_description() {
		return rule_engine_rule_description;
	}

	/**
	 * @param rule_engine_rule_description
	 *            the rule_engine_rule_description to set
	 */
	public void setRule_engine_rule_description(String rule_engine_rule_description) {
		this.rule_engine_rule_description = rule_engine_rule_description;
	}

	/**
	 * @return the rule_engine_rule_name
	 */
	public String getRule_engine_rule_name() {
		return rule_engine_rule_name;
	}

	/**
	 * @param rule_engine_rule_name
	 *            the rule_engine_rule_name to set
	 */
	public void setRule_engine_rule_name(String rule_engine_rule_name) {
		this.rule_engine_rule_name = rule_engine_rule_name;
	}

	/**
	 * @return the rule_engine_rule_global_rule_id
	 */
	public Long getRule_engine_rule_global_rule_id() {
		return rule_engine_rule_global_rule_id;
	}

	/**
	 * @param rule_engine_rule_global_rule_id
	 *            the rule_engine_rule_global_rule_id to set
	 */
	public void setRule_engine_rule_global_rule_id(Long rule_engine_rule_global_rule_id) {
		this.rule_engine_rule_global_rule_id = rule_engine_rule_global_rule_id;
	}

	/**
	 * @return the rule_engine_rule_rule_order
	 */
	public Integer getRule_engine_rule_rule_order() {
		return rule_engine_rule_rule_order;
	}

	/**
	 * @param rule_engine_rule_rule_order
	 *            the rule_engine_rule_rule_order to set
	 */
	public void setRule_engine_rule_rule_order(Integer rule_engine_rule_rule_order) {
		this.rule_engine_rule_rule_order = rule_engine_rule_rule_order;
	}

	/**
	 * @return the rule_engine_rule_operator
	 */
	public String getRule_engine_rule_operator() {
		return rule_engine_rule_operator;
	}

	/**
	 * @param rule_engine_rule_operator
	 *            the rule_engine_rule_operator to set
	 */
	public void setRule_engine_rule_operator(String rule_engine_rule_operator) {
		this.rule_engine_rule_operator = rule_engine_rule_operator;
	}

	/**
	 * @return the rule_engine_rule_id
	 */
	public Integer getRule_engine_rule_id() {
		return rule_engine_rule_id;
	}

	/**
	 * @param rule_engine_rule_id
	 *            the rule_engine_rule_id to set
	 */
	public void setRule_engine_rule_id(Integer rule_engine_rule_id) {
		this.rule_engine_rule_id = rule_engine_rule_id;
	}

}