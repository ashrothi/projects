/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/engine/rule/get/action/parameter API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleEngineRuleGetActionParameterSwagger {
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

	private List<RuleEngineRuleGetActionParameter> object;

	/**
	 * @return the object
	 */
	public List<RuleEngineRuleGetActionParameter> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleEngineRuleGetActionParameter> object) {
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
 * Set the response parameters of /rule/engine/rule/get/action/parameter API.
 * 
 *
 */

class RuleEngineRuleGetActionParameter {
	// Initializing the variables
	private Integer id;
	private Integer action_type_id;
	private String name;
	private String description;

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
	 * @return the action_type_id
	 */
	public Integer getAction_type_id() {
		return action_type_id;
	}

	/**
	 * @param action_type_id
	 *            the action_type_id to set
	 */
	public void setAction_type_id(Integer action_type_id) {
		this.action_type_id = action_type_id;
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

}