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
 * This class contains response on /hero/notification/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationGetAllSwagger {
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

	private List<HeroNotificationGetAll> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationGetAll> object) {
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
class HeroNotificationGetAll {

	private String notice_id; 
	private String notification_code_id; 
	private String is_closed; 
	private String created_on; 
	private String last_modified_on; 
	private String last_notification_action; 
	private String last_escalated_level; 
	private String notification_code_code; 
	private String notification_code_alias; 
	private String notification_code_description; 
	private String notification_code_is_hidden; 
	private String notification_code_css_icon_class; 
	private String notification_detail_id; 
	private String notification_id; 
	private String description; 
	private String part_code;  
	private String vendor_code; 
	private String vendor_name; 
	private String testing_version; 
	private String report_date; 
	private String notification_count;
	/**
	 * @return the notice_id
	 */
	public String getNotice_id() {
		return notice_id;
	}
	/**
	 * @param notice_id the notice_id to set
	 */
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	/**
	 * @return the notification_code_id
	 */
	public String getNotification_code_id() {
		return notification_code_id;
	}
	/**
	 * @param notification_code_id the notification_code_id to set
	 */
	public void setNotification_code_id(String notification_code_id) {
		this.notification_code_id = notification_code_id;
	}
	/**
	 * @return the is_closed
	 */
	public String getIs_closed() {
		return is_closed;
	}
	/**
	 * @param is_closed the is_closed to set
	 */
	public void setIs_closed(String is_closed) {
		this.is_closed = is_closed;
	}
	/**
	 * @return the created_on
	 */
	public String getCreated_on() {
		return created_on;
	}
	/**
	 * @param created_on the created_on to set
	 */
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	/**
	 * @return the last_modified_on
	 */
	public String getLast_modified_on() {
		return last_modified_on;
	}
	/**
	 * @param last_modified_on the last_modified_on to set
	 */
	public void setLast_modified_on(String last_modified_on) {
		this.last_modified_on = last_modified_on;
	}
	/**
	 * @return the last_notification_action
	 */
	public String getLast_notification_action() {
		return last_notification_action;
	}
	/**
	 * @param last_notification_action the last_notification_action to set
	 */
	public void setLast_notification_action(String last_notification_action) {
		this.last_notification_action = last_notification_action;
	}
	/**
	 * @return the last_escalated_level
	 */
	public String getLast_escalated_level() {
		return last_escalated_level;
	}
	/**
	 * @param last_escalated_level the last_escalated_level to set
	 */
	public void setLast_escalated_level(String last_escalated_level) {
		this.last_escalated_level = last_escalated_level;
	}
	/**
	 * @return the notification_code_code
	 */
	public String getNotification_code_code() {
		return notification_code_code;
	}
	/**
	 * @param notification_code_code the notification_code_code to set
	 */
	public void setNotification_code_code(String notification_code_code) {
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
	 * @return the notification_code_description
	 */
	public String getNotification_code_description() {
		return notification_code_description;
	}
	/**
	 * @param notification_code_description the notification_code_description to set
	 */
	public void setNotification_code_description(String notification_code_description) {
		this.notification_code_description = notification_code_description;
	}
	/**
	 * @return the notification_code_is_hidden
	 */
	public String getNotification_code_is_hidden() {
		return notification_code_is_hidden;
	}
	/**
	 * @param notification_code_is_hidden the notification_code_is_hidden to set
	 */
	public void setNotification_code_is_hidden(String notification_code_is_hidden) {
		this.notification_code_is_hidden = notification_code_is_hidden;
	}
	/**
	 * @return the notification_code_css_icon_class
	 */
	public String getNotification_code_css_icon_class() {
		return notification_code_css_icon_class;
	}
	/**
	 * @param notification_code_css_icon_class the notification_code_css_icon_class to set
	 */
	public void setNotification_code_css_icon_class(String notification_code_css_icon_class) {
		this.notification_code_css_icon_class = notification_code_css_icon_class;
	}
	/**
	 * @return the notification_detail_id
	 */
	public String getNotification_detail_id() {
		return notification_detail_id;
	}
	/**
	 * @param notification_detail_id the notification_detail_id to set
	 */
	public void setNotification_detail_id(String notification_detail_id) {
		this.notification_detail_id = notification_detail_id;
	}
	/**
	 * @return the notification_id
	 */
	public String getNotification_id() {
		return notification_id;
	}
	/**
	 * @param notification_id the notification_id to set
	 */
	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}
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
	/**
	 * @return the part_code
	 */
	public String getPart_code() {
		return part_code;
	}
	/**
	 * @param part_code the part_code to set
	 */
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	/**
	 * @return the vendor_code
	 */
	public String getVendor_code() {
		return vendor_code;
	}
	/**
	 * @param vendor_code the vendor_code to set
	 */
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	/**
	 * @return the vendor_name
	 */
	public String getVendor_name() {
		return vendor_name;
	}
	/**
	 * @param vendor_name the vendor_name to set
	 */
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	/**
	 * @return the testing_version
	 */
	public String getTesting_version() {
		return testing_version;
	}
	/**
	 * @param testing_version the testing_version to set
	 */
	public void setTesting_version(String testing_version) {
		this.testing_version = testing_version;
	}
	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	/**
	 * @return the notification_count
	 */
	public String getNotification_count() {
		return notification_count;
	}
	/**
	 * @param notification_count the notification_count to set
	 */
	public void setNotification_count(String notification_count) {
		this.notification_count = notification_count;
	}
	
}
