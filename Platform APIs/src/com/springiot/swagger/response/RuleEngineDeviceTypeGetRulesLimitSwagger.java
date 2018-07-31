/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /rule/engine/device/type/get/rules/limit API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleEngineDeviceTypeGetRulesLimitSwagger {
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

	private List<RuleEngineDeviceTypeGetRulesLimit> object;

	/**
	 * @return the object
	 */
	public List<RuleEngineDeviceTypeGetRulesLimit> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleEngineDeviceTypeGetRulesLimit> object) {
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
 * Set the response parameters of /rule/engine/device/type/get/rules/limit API.
 * 
 *
 */
class RuleEngineDeviceTypeGetRulesLimit {
	// Initializing the variables
	private Integer global_rule_id;
	private String trigger_method;
	private String created_on;
	private String data_source;
	private Integer value_from;
	private String model_name;
	private String service_service_alias;
	private Integer rule_order;
	private String device_model;
	private String modified_by;
	private String description;
	private String name;
	private Integer value_over;
	private Boolean is_alert;
	private Boolean created_by;
	private Boolean modified_on;
	private Integer value_under;
	private Integer value_equal;
	private Integer device_id;
	private Boolean severity;
	private Boolean rule_engine_rule_severity_colour;
	private Integer rule_engine_rule_rule_id;
	private Boolean model_alias;
	private Boolean service_servicedatasource_alias;
	private Boolean operator;
	private Integer value_to;
	private Integer rule_engine_rule_severity_priority;
	private Boolean is_conditional;
	private Integer model_id;
	private Integer organization_id;
	private Boolean service;
	private Integer alarm_age;

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
	 * @return the model_name
	 */
	public String getModel_name() {
		return model_name;
	}

	/**
	 * @param model_name
	 *            the model_name to set
	 */
	public void setModel_name(String model_name) {
		this.model_name = model_name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	public Boolean getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by
	 *            the created_by to set
	 */
	public void setCreated_by(Boolean created_by) {
		this.created_by = created_by;
	}

	/**
	 * @return the modified_on
	 */
	public Boolean getModified_on() {
		return modified_on;
	}

	/**
	 * @param modified_on
	 *            the modified_on to set
	 */
	public void setModified_on(Boolean modified_on) {
		this.modified_on = modified_on;
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
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the severity
	 */
	public Boolean getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(Boolean severity) {
		this.severity = severity;
	}

	/**
	 * @return the rule_engine_rule_severity_colour
	 */
	public Boolean getRule_engine_rule_severity_colour() {
		return rule_engine_rule_severity_colour;
	}

	/**
	 * @param rule_engine_rule_severity_colour
	 *            the rule_engine_rule_severity_colour to set
	 */
	public void setRule_engine_rule_severity_colour(Boolean rule_engine_rule_severity_colour) {
		this.rule_engine_rule_severity_colour = rule_engine_rule_severity_colour;
	}

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
	 * @return the model_alias
	 */
	public Boolean getModel_alias() {
		return model_alias;
	}

	/**
	 * @param model_alias
	 *            the model_alias to set
	 */
	public void setModel_alias(Boolean model_alias) {
		this.model_alias = model_alias;
	}

	/**
	 * @return the service_servicedatasource_alias
	 */
	public Boolean getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}

	/**
	 * @param service_servicedatasource_alias
	 *            the service_servicedatasource_alias to set
	 */
	public void setService_servicedatasource_alias(Boolean service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}

	/**
	 * @return the operator
	 */
	public Boolean getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(Boolean operator) {
		this.operator = operator;
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
	 * @return the model_id
	 */
	public Integer getModel_id() {
		return model_id;
	}

	/**
	 * @param model_id
	 *            the model_id to set
	 */
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
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
	 * @return the service
	 */
	public Boolean getService() {
		return service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(Boolean service) {
		this.service = service;
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

}