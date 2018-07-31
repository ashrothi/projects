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
 * This class contains response on /hero/notification/escalation/get/escalationlevel API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationEscalationGetEscalationlevelSwagger {
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

	private List<HeroNotificationEscalationGetEscalationlevel> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationEscalationGetEscalationlevel> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationEscalationGetEscalationlevel> object) {
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
class HeroNotificationEscalationGetEscalationlevel {

	private int notification_code_code; 
	private String notification_code_alias; 
	private int notification_code_id; 
	private int esc_level_id; 
	private String esc_level_email; 
	private String esc_level_sms;
	private int esc_level_order; 
	private int _esc_level_duration;
	/**
	 * @return the notification_code_code
	 */
	public int getNotification_code_code() {
		return notification_code_code;
	}
	/**
	 * @param notification_code_code the notification_code_code to set
	 */
	public void setNotification_code_code(int notification_code_code) {
		this.notification_code_code = notification_code_code;
	}
	/**
	 * @return the notification_code_alias
	 */
	public String getNotification_code_alias() {
		return notification_code_alias;
	}
	/**
	 * @param notification_code_alias the notification_code_alias to set
	 */
	public void setNotification_code_alias(String notification_code_alias) {
		this.notification_code_alias = notification_code_alias;
	}
	/**
	 * @return the notification_code_id
	 */
	public int getNotification_code_id() {
		return notification_code_id;
	}
	/**
	 * @param notification_code_id the notification_code_id to set
	 */
	public void setNotification_code_id(int notification_code_id) {
		this.notification_code_id = notification_code_id;
	}
	/**
	 * @return the esc_level_id
	 */
	public int getEsc_level_id() {
		return esc_level_id;
	}
	/**
	 * @param esc_level_id the esc_level_id to set
	 */
	public void setEsc_level_id(int esc_level_id) {
		this.esc_level_id = esc_level_id;
	}
	/**
	 * @return the esc_level_email
	 */
	public String getEsc_level_email() {
		return esc_level_email;
	}
	/**
	 * @param esc_level_email the esc_level_email to set
	 */
	public void setEsc_level_email(String esc_level_email) {
		this.esc_level_email = esc_level_email;
	}
	/**
	 * @return the esc_level_sms
	 */
	public String getEsc_level_sms() {
		return esc_level_sms;
	}
	/**
	 * @param esc_level_sms the esc_level_sms to set
	 */
	public void setEsc_level_sms(String esc_level_sms) {
		this.esc_level_sms = esc_level_sms;
	}
	/**
	 * @return the esc_level_order
	 */
	public int getEsc_level_order() {
		return esc_level_order;
	}
	/**
	 * @param esc_level_order the esc_level_order to set
	 */
	public void setEsc_level_order(int esc_level_order) {
		this.esc_level_order = esc_level_order;
	}
	/**
	 * @return the _esc_level_duration
	 */
	public int get_esc_level_duration() {
		return _esc_level_duration;
	}
	/**
	 * @param _esc_level_duration the _esc_level_duration to set
	 */
	public void set_esc_level_duration(int _esc_level_duration) {
		this._esc_level_duration = _esc_level_duration;
	} 
	
	
}
