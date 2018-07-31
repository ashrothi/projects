/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/main/device/with/most/alert/count
 * API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainDeviceWithMostAlertCountSwagger {
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

	private List<DashboardMainDeviceWithMostAlertCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainDeviceWithMostAlertCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainDeviceWithMostAlertCount> object) {
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
 * Set the response parameters of /dashboard/main/device/with/most/alert/count
 * API.
 * 
 *
 */
class DashboardMainDeviceWithMostAlertCount {
	// Initializing the variables
	private Integer device_id;
	private Integer device_alert_count;

	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the device_alert_count
	 */
	public Integer getDevice_alert_count() {
		return device_alert_count;
	}

	/**
	 * @param device_alert_count
	 *            the device_alert_count to set
	 */
	public void setDevice_alert_count(Integer device_alert_count) {
		this.device_alert_count = device_alert_count;
	}

}