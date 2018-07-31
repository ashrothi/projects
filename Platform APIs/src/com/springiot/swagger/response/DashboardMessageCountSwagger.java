/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/message/count API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMessageCountSwagger {
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

	private List<DashboardMessageCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardMessageCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMessageCount> object) {
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
 * Set the response parameters of /dashboard/message/count API.
 * 
 *
 */
class DashboardMessageCount {
	// Initializing the variables
	private String protocol_name;
	private Integer message_count;
	private Long sys_timestamp;

	/**
	 * @return the protocol_name
	 */
	public String getProtocol_name() {
		return protocol_name;
	}

	/**
	 * @param protocol_name
	 *            the protocol_name to set
	 */
	public void setProtocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
	}

	/**
	 * @return the message_count
	 */
	public Integer getMessage_count() {
		return message_count;
	}

	/**
	 * @param message_count
	 *            the message_count to set
	 */
	public void setMessage_count(Integer message_count) {
		this.message_count = message_count;
	}

	/**
	 * @return the sys_timestamp
	 */
	public Long getSys_timestamp() {
		return sys_timestamp;
	}

	/**
	 * @param sys_timestamp
	 *            the sys_timestamp to set
	 */
	public void setSys_timestamp(Long sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}

}