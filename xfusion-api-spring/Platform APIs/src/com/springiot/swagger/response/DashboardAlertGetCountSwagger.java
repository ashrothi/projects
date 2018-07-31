/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/alert/get/count API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardAlertGetCountSwagger {
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

	private List<DashboardAlertGetCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardAlertGetCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardAlertGetCount> object) {
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
 * Set the response parameters of /dashboard/alert/get/count API.
 * 
 *
 */
class DashboardAlertGetCount {
	// Initializing the variables
	private Integer temp_alert_count;
	private Integer temp_log_count;
	private Float temp_alert_percentage;

	/**
	 * @return the temp_alert_count
	 */
	public Integer getTemp_alert_count() {
		return temp_alert_count;
	}

	/**
	 * @param temp_alert_count
	 *            the temp_alert_count to set
	 */
	public void setTemp_alert_count(Integer temp_alert_count) {
		this.temp_alert_count = temp_alert_count;
	}

	/**
	 * @return the temp_log_count
	 */
	public Integer getTemp_log_count() {
		return temp_log_count;
	}

	/**
	 * @param temp_log_count
	 *            the temp_log_count to set
	 */
	public void setTemp_log_count(Integer temp_log_count) {
		this.temp_log_count = temp_log_count;
	}

	/**
	 * @return the temp_alert_percentage
	 */
	public Float getTemp_alert_percentage() {
		return temp_alert_percentage;
	}

	/**
	 * @param temp_alert_percentage
	 *            the temp_alert_percentage to set
	 */
	public void setTemp_alert_percentage(Float temp_alert_percentage) {
		this.temp_alert_percentage = temp_alert_percentage;
	}

}