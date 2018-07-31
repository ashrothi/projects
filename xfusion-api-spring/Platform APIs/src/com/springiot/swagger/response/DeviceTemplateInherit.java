/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /device/template/inherit API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceTemplateInherit {
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

	private List<DeviceTemplate> object;

	/**
	 * @return the object
	 */
	public List<DeviceTemplate> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceTemplate> object) {
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
 * Set the response parameters of /device/template/inherit API.
 * 
 *
 */
class DeviceTemplate {
	private String message;
	private boolean is_added;

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

	/**
	 * @return the is_added
	 */
	public boolean isIs_added() {
		return is_added;
	}

	/**
	 * @param is_added
	 *            the is_added to set
	 */
	public void setIs_added(boolean is_added) {
		this.is_added = is_added;
	}

}
