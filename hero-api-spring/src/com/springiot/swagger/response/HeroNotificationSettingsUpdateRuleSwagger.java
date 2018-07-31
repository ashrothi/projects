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
 * This class contains response on /hero/notification/settings/update/rule API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationSettingsUpdateRuleSwagger {
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

	private List<HeroNotificationSettingsUpdateRule> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationSettingsUpdateRule> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationSettingsUpdateRule> object) {
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
class HeroNotificationSettingsUpdateRule {

	private int affected_rows;

	/**
	 * @return the affected_rows
	 */
	public int getAffected_rows() {
		return affected_rows;
	}

	/**
	 * @param affected_rows the affected_rows to set
	 */
	public void setAffected_rows(int affected_rows) {
		this.affected_rows = affected_rows;
	}
	
	
}
