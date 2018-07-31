/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of
 * /dashboard/main/worst/device/type/grouped/hourly API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainWorstDeviceTypeGroupedHourlySwagger {
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

	private List<DashboardMainWorstDeviceTypeGroupedHourly> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainWorstDeviceTypeGroupedHourly> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainWorstDeviceTypeGroupedHourly> object) {
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
 * Set the response parameters of
 * /dashboard/main/worst/device/type/grouped/hourly API.
 * 
 *
 */
class DashboardMainWorstDeviceTypeGroupedHourly {
	// Initializing the variables
	private Integer device_devicetype_id;
	private String device_devicetype_name;
	private String device_devicetype_alias;
	private Integer total_failure_count;
	private Integer hours;

	/**
	 * @return the device_devicetype_id
	 */
	public Integer getDevice_devicetype_id() {
		return device_devicetype_id;
	}

	/**
	 * @param device_devicetype_id
	 *            the device_devicetype_id to set
	 */
	public void setDevice_devicetype_id(Integer device_devicetype_id) {
		this.device_devicetype_id = device_devicetype_id;
	}

	/**
	 * @return the device_devicetype_name
	 */
	public String getDevice_devicetype_name() {
		return device_devicetype_name;
	}

	/**
	 * @param device_devicetype_name
	 *            the device_devicetype_name to set
	 */
	public void setDevice_devicetype_name(String device_devicetype_name) {
		this.device_devicetype_name = device_devicetype_name;
	}

	/**
	 * @return the device_devicetype_alias
	 */
	public String getDevice_devicetype_alias() {
		return device_devicetype_alias;
	}

	/**
	 * @param device_devicetype_alias
	 *            the device_devicetype_alias to set
	 */
	public void setDevice_devicetype_alias(String device_devicetype_alias) {
		this.device_devicetype_alias = device_devicetype_alias;
	}

	/**
	 * @return the total_failure_count
	 */
	public Integer getTotal_failure_count() {
		return total_failure_count;
	}

	/**
	 * @param total_failure_count
	 *            the total_failure_count to set
	 */
	public void setTotal_failure_count(Integer total_failure_count) {
		this.total_failure_count = total_failure_count;
	}

	/**
	 * @return the hours
	 */
	public Integer getHours() {
		return hours;
	}

	/**
	 * @param hours
	 *            the hours to set
	 */
	public void setHours(Integer hours) {
		this.hours = hours;
	}
}