/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/main/worst/performing/devices API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainWorstPerformingDevicesSwagger {
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

	private List<DashboardMainWorstPerformingDevices> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainWorstPerformingDevices> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainWorstPerformingDevices> object) {
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
 * Set the response parameters of /dashboard/main/worst/performing/devices API.
 * 
 *
 */
class DashboardMainWorstPerformingDevices {
	// Initializing the variables
	private Integer total_failure_count;
	private Integer temp_device_count_data_device_id;
	private String device_device_name;
	private String device_devicetype_name;
	private String device_device_alias;
	private String device_devicevendor_alias;

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
	 * @return the temp_device_count_data_device_id
	 */
	public Integer getTemp_device_count_data_device_id() {
		return temp_device_count_data_device_id;
	}

	/**
	 * @param temp_device_count_data_device_id
	 *            the temp_device_count_data_device_id to set
	 */
	public void setTemp_device_count_data_device_id(Integer temp_device_count_data_device_id) {
		this.temp_device_count_data_device_id = temp_device_count_data_device_id;
	}

	/**
	 * @return the device_device_name
	 */
	public String getDevice_device_name() {
		return device_device_name;
	}

	/**
	 * @param device_device_name
	 *            the device_device_name to set
	 */
	public void setDevice_device_name(String device_device_name) {
		this.device_device_name = device_device_name;
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
	 * @return the device_device_alias
	 */
	public String getDevice_device_alias() {
		return device_device_alias;
	}

	/**
	 * @param device_device_alias
	 *            the device_device_alias to set
	 */
	public void setDevice_device_alias(String device_device_alias) {
		this.device_device_alias = device_device_alias;
	}

	/**
	 * @return the device_devicevendor_alias
	 */
	public String getDevice_devicevendor_alias() {
		return device_devicevendor_alias;
	}

	/**
	 * @param device_devicevendor_alias
	 *            the device_devicevendor_alias to set
	 */
	public void setDevice_devicevendor_alias(String device_devicevendor_alias) {
		this.device_devicevendor_alias = device_devicevendor_alias;
	}

}