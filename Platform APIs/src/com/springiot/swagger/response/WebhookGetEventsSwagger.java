/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /webhook/get/events API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class WebhookGetEventsSwagger {
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

	private List<WebhookGetEvents> object;

	/**
	 * @return the object
	 */
	public List<WebhookGetEvents> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<WebhookGetEvents> object) {
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
 * Set the response parameters of /webhook/get/events API.
 * 
 *
 */
class WebhookGetEvents {
	// Initializing the variables
	private Integer id;
	private String name;
	private String global_rule_id;
	private String category;
	private String created_on;
	private String modified_on;
	private String user_key;
	private String user_id;
	private String webhook_destinations_name;
	private String webhook_destinations_description;
	private String webhook_event_destination_key;
	private String webhook_event_destination_value;

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
	 * @return the global_rule_id
	 */
	public String getGlobal_rule_id() {
		return global_rule_id;
	}

	/**
	 * @param global_rule_id
	 *            the global_rule_id to set
	 */
	public void setGlobal_rule_id(String global_rule_id) {
		this.global_rule_id = global_rule_id;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}

	/**
	 * @param user_key
	 *            the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the webhook_destinations_name
	 */
	public String getWebhook_destinations_name() {
		return webhook_destinations_name;
	}

	/**
	 * @param webhook_destinations_name
	 *            the webhook_destinations_name to set
	 */
	public void setWebhook_destinations_name(String webhook_destinations_name) {
		this.webhook_destinations_name = webhook_destinations_name;
	}

	/**
	 * @return the webhook_destinations_description
	 */
	public String getWebhook_destinations_description() {
		return webhook_destinations_description;
	}

	/**
	 * @param webhook_destinations_description
	 *            the webhook_destinations_description to set
	 */
	public void setWebhook_destinations_description(String webhook_destinations_description) {
		this.webhook_destinations_description = webhook_destinations_description;
	}

	/**
	 * @return the webhook_event_destination_key
	 */
	public String getWebhook_event_destination_key() {
		return webhook_event_destination_key;
	}

	/**
	 * @param webhook_event_destination_key
	 *            the webhook_event_destination_key to set
	 */
	public void setWebhook_event_destination_key(String webhook_event_destination_key) {
		this.webhook_event_destination_key = webhook_event_destination_key;
	}

	/**
	 * @return the webhook_event_destination_value
	 */
	public String getWebhook_event_destination_value() {
		return webhook_event_destination_value;
	}

	/**
	 * @param webhook_event_destination_value
	 *            the webhook_event_destination_value to set
	 */
	public void setWebhook_event_destination_value(String webhook_event_destination_value) {
		this.webhook_event_destination_value = webhook_event_destination_value;
	}

}