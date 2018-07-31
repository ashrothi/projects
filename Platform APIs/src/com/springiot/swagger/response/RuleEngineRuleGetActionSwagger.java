/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/engine/rule/get/action API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleEngineRuleGetActionSwagger {
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

	private List<RuleEngineRuleGetAction> object;

	/**
	 * @return the object
	 */
	public List<RuleEngineRuleGetAction> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleEngineRuleGetAction> object) {
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
 * Set the response parameters of /rule/engine/rule/get/action API.
 * 
 *
 */

class RuleEngineRuleGetAction {
	// Initializing the variables
	private Integer id;
	private Long global_rule_id;
	private String rule_engine_action_types_name;
	private String duration;
	private String phone;
	private String level;
	private String action_type;
	private Integer organization_id;
	private Integer user_id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the global_rule_id
	 */
	public Long getGlobal_rule_id() {
		return global_rule_id;
	}

	/**
	 * @param global_rule_id
	 *            the global_rule_id to set
	 */
	public void setGlobal_rule_id(Long global_rule_id) {
		this.global_rule_id = global_rule_id;
	}

	/**
	 * @return the rule_engine_action_types_name
	 */
	public String getRule_engine_action_types_name() {
		return rule_engine_action_types_name;
	}

	/**
	 * @param rule_engine_action_types_name
	 *            the rule_engine_action_types_name to set
	 */
	public void setRule_engine_action_types_name(String rule_engine_action_types_name) {
		this.rule_engine_action_types_name = rule_engine_action_types_name;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the action_type
	 */
	public String getAction_type() {
		return action_type;
	}

	/**
	 * @param action_type
	 *            the action_type to set
	 */
	public void setAction_type(String action_type) {
		this.action_type = action_type;
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
	 * @return the user_id
	 */
	public Integer getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}