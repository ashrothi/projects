/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/device/status/count API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardDeviceStatusCountSwagger {
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

	private List<DashboardDeviceStatusCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardDeviceStatusCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardDeviceStatusCount> object) {
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
 * Set the response parameters of /dashboard/device/status/count API.
 * 
 *
 */
class DashboardDeviceStatusCount {
	// Initializing the variables
	private Integer total_count;
	private Integer total_up_count;
	private Integer total_down_count;
	private Float total_up_percentage;
	private Float total_down_percentage;
	private Integer alert_count;
	private Integer log_count;
	private Float alert_percentage;
	private Integer message_count;
	private String protocol_name;

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
	 * @return the total_count
	 */
	public Integer getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count
	 *            the total_count to set
	 */
	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the total_up_count
	 */
	public Integer getTotal_up_count() {
		return total_up_count;
	}

	/**
	 * @param total_up_count
	 *            the total_up_count to set
	 */
	public void setTotal_up_count(Integer total_up_count) {
		this.total_up_count = total_up_count;
	}

	/**
	 * @return the total_down_count
	 */
	public Integer getTotal_down_count() {
		return total_down_count;
	}

	/**
	 * @param total_down_count
	 *            the total_down_count to set
	 */
	public void setTotal_down_count(Integer total_down_count) {
		this.total_down_count = total_down_count;
	}

	/**
	 * @return the total_up_percentage
	 */
	public Float getTotal_up_percentage() {
		return total_up_percentage;
	}

	/**
	 * @param total_up_percentage
	 *            the total_up_percentage to set
	 */
	public void setTotal_up_percentage(Float total_up_percentage) {
		this.total_up_percentage = total_up_percentage;
	}

	/**
	 * @return the total_down_percentage
	 */
	public Float getTotal_down_percentage() {
		return total_down_percentage;
	}

	/**
	 * @param total_down_percentage
	 *            the total_down_percentage to set
	 */
	public void setTotal_down_percentage(Float total_down_percentage) {
		this.total_down_percentage = total_down_percentage;
	}

	/**
	 * @return the alert_count
	 */
	public Integer getAlert_count() {
		return alert_count;
	}

	/**
	 * @param alert_count
	 *            the alert_count to set
	 */
	public void setAlert_count(Integer alert_count) {
		this.alert_count = alert_count;
	}

	/**
	 * @return the log_count
	 */
	public Integer getLog_count() {
		return log_count;
	}

	/**
	 * @param log_count
	 *            the log_count to set
	 */
	public void setLog_count(Integer log_count) {
		this.log_count = log_count;
	}

	/**
	 * @return the alert_percentage
	 */
	public Float getAlert_percentage() {
		return alert_percentage;
	}

	/**
	 * @param alert_percentage
	 *            the alert_percentage to set
	 */
	public void setAlert_percentage(Float alert_percentage) {
		this.alert_percentage = alert_percentage;
	}

}