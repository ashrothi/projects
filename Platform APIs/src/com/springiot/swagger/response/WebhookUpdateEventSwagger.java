/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /webhook/update/event API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class WebhookUpdateEventSwagger {
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

	private List<WebhookUpdateEvent> object;

	/**
	 * @return the object
	 */
	public List<WebhookUpdateEvent> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<WebhookUpdateEvent> object) {
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
 * Set the response parameters of /webhook/update/event API.
 * 
 *
 */
class WebhookUpdateEvent {
	// Initializing the variables
	private String message;

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
