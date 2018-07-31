/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /hero/notification/settings/get/rules API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationSettingsGetRulesSwagger {
	private String description;
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

	private List<HeroNotificationSettingsGetRules> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationSettingsGetRules> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationSettingsGetRules> object) {
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
/*
*TO get response parameter getter setter
*/
class HeroNotificationSettingsGetRules {

	private int id; 
	private String component; 
	private String parameter_name; 
	private int no_of_cycle; 
	private String parameter_alias; 
	private Date last_modified_on;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the component
	 */
	public String getComponent() {
		return component;
	}
	/**
	 * @param component the component to set
	 */
	public void setComponent(String component) {
		this.component = component;
	}
	/**
	 * @return the parameter_name
	 */
	public String getParameter_name() {
		return parameter_name;
	}
	/**
	 * @param parameter_name the parameter_name to set
	 */
	public void setParameter_name(String parameter_name) {
		this.parameter_name = parameter_name;
	}
	/**
	 * @return the no_of_cycle
	 */
	public int getNo_of_cycle() {
		return no_of_cycle;
	}
	/**
	 * @param no_of_cycle the no_of_cycle to set
	 */
	public void setNo_of_cycle(int no_of_cycle) {
		this.no_of_cycle = no_of_cycle;
	}
	/**
	 * @return the parameter_alias
	 */
	public String getParameter_alias() {
		return parameter_alias;
	}
	/**
	 * @param parameter_alias the parameter_alias to set
	 */
	public void setParameter_alias(String parameter_alias) {
		this.parameter_alias = parameter_alias;
	}
	/**
	 * @return the last_modified_on
	 */
	public Date getLast_modified_on() {
		return last_modified_on;
	}
	/**
	 * @param last_modified_on the last_modified_on to set
	 */
	public void setLast_modified_on(Date last_modified_on) {
		this.last_modified_on = last_modified_on;
	} 
	
	
	
}
