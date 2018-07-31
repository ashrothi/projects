/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /hero/notification/settings/get/component/parameter API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationSettingsGetComponentParameterSwagger {
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

	private List<HeroNotificationSettingsGetComponentParameter> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationSettingsGetComponentParameter> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationSettingsGetComponentParameter> object) {
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
class HeroNotificationSettingsGetComponentParameter {
	private String parameter_name; 
	private int component_type; 
	private String type;
	private String parameter_alias;
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
	 * @return the component_type
	 */
	public int getComponent_type() {
		return component_type;
	}
	/**
	 * @param component_type the component_type to set
	 */
	public void setComponent_type(int component_type) {
		this.component_type = component_type;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	
	

}
