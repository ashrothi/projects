/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of
 * /dashboard/main/get/command/count/by/device/type API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainGetCommandCountByDeviceTypeSwagger {
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

	private List<DashboardMainGetCommandCountByDeviceType> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainGetCommandCountByDeviceType> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainGetCommandCountByDeviceType> object) {
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
 * /dashboard/main/get/command/count/by/device/type API.
 * 
 *
 */
class DashboardMainGetCommandCountByDeviceType {
	// Initializing the variables
	private Integer device_devicetype_id;
	private String device_devicetype_name;
	private String device_devicetype_alias;
	private Integer total_command_count;
	private Integer total_active_command_count;
	private Integer total_response_command_count;
	private Integer total_active_command_percentage;
	private Float total_response_command_percentage;

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
	 * @return the total_command_count
	 */
	public Integer getTotal_command_count() {
		return total_command_count;
	}

	/**
	 * @param total_command_count
	 *            the total_command_count to set
	 */
	public void setTotal_command_count(Integer total_command_count) {
		this.total_command_count = total_command_count;
	}

	/**
	 * @return the total_active_command_count
	 */
	public Integer getTotal_active_command_count() {
		return total_active_command_count;
	}

	/**
	 * @param total_active_command_count
	 *            the total_active_command_count to set
	 */
	public void setTotal_active_command_count(Integer total_active_command_count) {
		this.total_active_command_count = total_active_command_count;
	}

	/**
	 * @return the total_response_command_count
	 */
	public Integer getTotal_response_command_count() {
		return total_response_command_count;
	}

	/**
	 * @param total_response_command_count
	 *            the total_response_command_count to set
	 */
	public void setTotal_response_command_count(Integer total_response_command_count) {
		this.total_response_command_count = total_response_command_count;
	}

	/**
	 * @return the total_active_command_percentage
	 */
	public Integer getTotal_active_command_percentage() {
		return total_active_command_percentage;
	}

	/**
	 * @param total_active_command_percentage
	 *            the total_active_command_percentage to set
	 */
	public void setTotal_active_command_percentage(Integer total_active_command_percentage) {
		this.total_active_command_percentage = total_active_command_percentage;
	}

	/**
	 * @return the total_response_command_percentage
	 */
	public Float getTotal_response_command_percentage() {
		return total_response_command_percentage;
	}

	/**
	 * @param total_response_command_percentage
	 *            the total_response_command_percentage to set
	 */
	public void setTotal_response_command_percentage(Float total_response_command_percentage) {
		this.total_response_command_percentage = total_response_command_percentage;
	}

}
