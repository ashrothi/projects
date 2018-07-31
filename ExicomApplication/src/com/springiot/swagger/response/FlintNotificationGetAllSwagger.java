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
 * This class contains response on /flint/notification/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintNotificationGetAllSwagger {
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

	private List<FlintNotificationGetAll> object;

	/**
	 * @return the object
	 */
	public List<FlintNotificationGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintNotificationGetAll> object) {
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
class FlintNotificationGetAll {
	private String id;
	private String ticket_id;
	private String task_id;
	private String task_status;
	private String notification_time;
	private String task_status_name;
	private String task_status_alias;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the ticket_id
	 */
	public String getTicket_id() {
		return ticket_id;
	}
	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	/**
	 * @return the task_id
	 */
	public String getTask_id() {
		return task_id;
	}
	/**
	 * @param task_id the task_id to set
	 */
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	/**
	 * @return the task_status
	 */
	public String getTask_status() {
		return task_status;
	}
	/**
	 * @param task_status the task_status to set
	 */
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	/**
	 * @return the notification_time
	 */
	public String getNotification_time() {
		return notification_time;
	}
	/**
	 * @param notification_time the notification_time to set
	 */
	public void setNotification_time(String notification_time) {
		this.notification_time = notification_time;
	}
	/**
	 * @return the task_status_name
	 */
	public String getTask_status_name() {
		return task_status_name;
	}
	/**
	 * @param task_status_name the task_status_name to set
	 */
	public void setTask_status_name(String task_status_name) {
		this.task_status_name = task_status_name;
	}
	/**
	 * @return the task_status_alias
	 */
	public String getTask_status_alias() {
		return task_status_alias;
	}
	/**
	 * @param task_status_alias the task_status_alias to set
	 */
	public void setTask_status_alias(String task_status_alias) {
		this.task_status_alias = task_status_alias;
	}

}
