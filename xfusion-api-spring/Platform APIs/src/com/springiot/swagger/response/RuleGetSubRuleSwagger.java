/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/get/sub/rule API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleGetSubRuleSwagger {
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

	private List<RuleGetSubRule> object;

	/**
	 * @return the object
	 */
	public List<RuleGetSubRule> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleGetSubRule> object) {
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
 * Set the response parameters of /rule/get/sub/rule API.
 * 
 *
 */
class RuleGetSubRule {
	// Initializing the variables
	private Integer rule_engine_rule_rule_id;
	private Integer global_rule_id;
	private Integer rule_order;
	private String operator;
	private Integer name;
	private String service;
	private String data_source;
	private String severity;
	private String trigger_method;
	private Integer value_under;
	private Integer value_over;
	private Integer value_from;
	private Integer value_to;
	private Integer value_equal;
	private Integer alarm_age;
	private String description;
	private Boolean is_conditional;
	private Boolean is_alert;
	private String created_by;
	private String modified_by;
	private String created_on;
	private String modified_on;
	private Integer organization_id;
	private String device_model;
	private String all_device_in_model;
	private Integer rule_device_rule_id;
	private String rule_engine_rule_severity_colour;
	private Integer rule_engine_rule_severity_id;
	private Integer rule_engine_rule_severity_priority;
	private Integer rule_engine_rule_service_id;
	private Integer rule_engine_rule_data_source_id;
	private Integer device_ids;
	private Integer device_devicetype_id;
	private String device_devicetype_name;
	private String device_devicetype_alias;

	/**
	 * @return the rule_engine_rule_rule_id
	 */
	public Integer getRule_engine_rule_rule_id() {
		return rule_engine_rule_rule_id;
	}

	/**
	 * @param rule_engine_rule_rule_id
	 *            the rule_engine_rule_rule_id to set
	 */
	public void setRule_engine_rule_rule_id(Integer rule_engine_rule_rule_id) {
		this.rule_engine_rule_rule_id = rule_engine_rule_rule_id;
	}

	/**
	 * @return the global_rule_id
	 */
	public Integer getGlobal_rule_id() {
		return global_rule_id;
	}

	/**
	 * @param global_rule_id
	 *            the global_rule_id to set
	 */
	public void setGlobal_rule_id(Integer global_rule_id) {
		this.global_rule_id = global_rule_id;
	}

	/**
	 * @return the rule_order
	 */
	public Integer getRule_order() {
		return rule_order;
	}

	/**
	 * @param rule_order
	 *            the rule_order to set
	 */
	public void setRule_order(Integer rule_order) {
		this.rule_order = rule_order;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	/**
	 * @return the name
	 */
	public Integer getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(Integer name) {
		this.name = name;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
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
	 * @return the trigger_method
	 */
	public String getTrigger_method() {
		return trigger_method;
	}

	/**
	 * @param trigger_method
	 *            the trigger_method to set
	 */
	public void setTrigger_method(String trigger_method) {
		this.trigger_method = trigger_method;
	}

	/**
	 * @return the value_under
	 */
	public Integer getValue_under() {
		return value_under;
	}

	/**
	 * @param value_under
	 *            the value_under to set
	 */
	public void setValue_under(Integer value_under) {
		this.value_under = value_under;
	}

	/**
	 * @return the value_over
	 */
	public Integer getValue_over() {
		return value_over;
	}

	/**
	 * @param value_over
	 *            the value_over to set
	 */
	public void setValue_over(Integer value_over) {
		this.value_over = value_over;
	}

	/**
	 * @return the value_from
	 */
	public Integer getValue_from() {
		return value_from;
	}

	/**
	 * @param value_from
	 *            the value_from to set
	 */
	public void setValue_from(Integer value_from) {
		this.value_from = value_from;
	}

	/**
	 * @return the value_to
	 */
	public Integer getValue_to() {
		return value_to;
	}

	/**
	 * @param value_to
	 *            the value_to to set
	 */
	public void setValue_to(Integer value_to) {
		this.value_to = value_to;
	}

	/**
	 * @return the value_equal
	 */
	public Integer getValue_equal() {
		return value_equal;
	}

	/**
	 * @param value_equal
	 *            the value_equal to set
	 */
	public void setValue_equal(Integer value_equal) {
		this.value_equal = value_equal;
	}

	/**
	 * @return the alarm_age
	 */
	public Integer getAlarm_age() {
		return alarm_age;
	}

	/**
	 * @param alarm_age
	 *            the alarm_age to set
	 */
	public void setAlarm_age(Integer alarm_age) {
		this.alarm_age = alarm_age;
	}

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

	/**
	 * @return the is_conditional
	 */
	public Boolean getIs_conditional() {
		return is_conditional;
	}

	/**
	 * @param is_conditional
	 *            the is_conditional to set
	 */
	public void setIs_conditional(Boolean is_conditional) {
		this.is_conditional = is_conditional;
	}

	/**
	 * @return the is_alert
	 */
	public Boolean getIs_alert() {
		return is_alert;
	}

	/**
	 * @param is_alert
	 *            the is_alert to set
	 */
	public void setIs_alert(Boolean is_alert) {
		this.is_alert = is_alert;
	}

	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by
	 *            the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	/**
	 * @return the modified_by
	 */
	public String getModified_by() {
		return modified_by;
	}

	/**
	 * @param modified_by
	 *            the modified_by to set
	 */
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	/**
	 * @return the created_on
	 */
	public String getCreated_on() {
		return created_on;
	}

	/**
	 * @param created_on
	 *            the created_on to set
	 */
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	/**
	 * @return the modified_on
	 */
	public String getModified_on() {
		return modified_on;
	}

	/**
	 * @param modified_on
	 *            the modified_on to set
	 */
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}

	/**
	 * @return the organization_id
	 */
	public Integer getOrganization_id() {
		return organization_id;
	}

	/**
	 * @param organization_id
	 *            the organization_id to set
	 */
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	/**
	 * @return the device_model
	 */
	public String getDevice_model() {
		return device_model;
	}

	/**
	 * @param device_model
	 *            the device_model to set
	 */
	public void setDevice_model(String device_model) {
		this.device_model = device_model;
	}

	/**
	 * @return the all_device_in_model
	 */
	public String getAll_device_in_model() {
		return all_device_in_model;
	}

	/**
	 * @param all_device_in_model
	 *            the all_device_in_model to set
	 */
	public void setAll_device_in_model(String all_device_in_model) {
		this.all_device_in_model = all_device_in_model;
	}

	/**
	 * @return the rule_device_rule_id
	 */
	public Integer getRule_device_rule_id() {
		return rule_device_rule_id;
	}

	/**
	 * @param rule_device_rule_id
	 *            the rule_device_rule_id to set
	 */
	public void setRule_device_rule_id(Integer rule_device_rule_id) {
		this.rule_device_rule_id = rule_device_rule_id;
	}

	/**
	 * @return the rule_engine_rule_severity_colour
	 */
	public String getRule_engine_rule_severity_colour() {
		return rule_engine_rule_severity_colour;
	}

	/**
	 * @param rule_engine_rule_severity_colour
	 *            the rule_engine_rule_severity_colour to set
	 */
	public void setRule_engine_rule_severity_colour(String rule_engine_rule_severity_colour) {
		this.rule_engine_rule_severity_colour = rule_engine_rule_severity_colour;
	}

	/**
	 * @return the rule_engine_rule_severity_id
	 */
	public Integer getRule_engine_rule_severity_id() {
		return rule_engine_rule_severity_id;
	}

	/**
	 * @param rule_engine_rule_severity_id
	 *            the rule_engine_rule_severity_id to set
	 */
	public void setRule_engine_rule_severity_id(Integer rule_engine_rule_severity_id) {
		this.rule_engine_rule_severity_id = rule_engine_rule_severity_id;
	}

	/**
	 * @return the rule_engine_rule_severity_priority
	 */
	public Integer getRule_engine_rule_severity_priority() {
		return rule_engine_rule_severity_priority;
	}

	/**
	 * @param rule_engine_rule_severity_priority
	 *            the rule_engine_rule_severity_priority to set
	 */
	public void setRule_engine_rule_severity_priority(Integer rule_engine_rule_severity_priority) {
		this.rule_engine_rule_severity_priority = rule_engine_rule_severity_priority;
	}

	/**
	 * @return the rule_engine_rule_service_id
	 */
	public Integer getRule_engine_rule_service_id() {
		return rule_engine_rule_service_id;
	}

	/**
	 * @param rule_engine_rule_service_id
	 *            the rule_engine_rule_service_id to set
	 */
	public void setRule_engine_rule_service_id(Integer rule_engine_rule_service_id) {
		this.rule_engine_rule_service_id = rule_engine_rule_service_id;
	}

	/**
	 * @return the rule_engine_rule_data_source_id
	 */
	public Integer getRule_engine_rule_data_source_id() {
		return rule_engine_rule_data_source_id;
	}

	/**
	 * @param rule_engine_rule_data_source_id
	 *            the rule_engine_rule_data_source_id to set
	 */
	public void setRule_engine_rule_data_source_id(Integer rule_engine_rule_data_source_id) {
		this.rule_engine_rule_data_source_id = rule_engine_rule_data_source_id;
	}

	/**
	 * @return the device_ids
	 */
	public Integer getDevice_ids() {
		return device_ids;
	}

	/**
	 * @param device_ids
	 *            the device_ids to set
	 */
	public void setDevice_ids(Integer device_ids) {
		this.device_ids = device_ids;
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

}