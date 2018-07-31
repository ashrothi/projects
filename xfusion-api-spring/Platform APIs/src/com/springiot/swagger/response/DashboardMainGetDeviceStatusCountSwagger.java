/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/main/get/device/status/count API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainGetDeviceStatusCountSwagger {
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

	private List<DashboardMainGetDeviceStatusCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainGetDeviceStatusCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainGetDeviceStatusCount> object) {
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
 * Set the response parameters of /dashboard/main/get/device/status/count API.
 * 
 *
 */
class DashboardMainGetDeviceStatusCount {
	// Initializing the variables
	private Integer total_devices;
	private Integer total_up_devices;
	private Integer total_down_devices;
	private Integer total_device_types;
	private Integer total_unknown_devices;
	private Float total_up_device_percentage;
	private Float total_down_device_percentage;
	private Float total_unknown_device_percentage;

	/**
	 * @return the total_devices
	 */
	public Integer getTotal_devices() {
		return total_devices;
	}

	/**
	 * @param total_devices
	 *            the total_devices to set
	 */
	public void setTotal_devices(Integer total_devices) {
		this.total_devices = total_devices;
	}

	/**
	 * @return the total_up_devices
	 */
	public Integer getTotal_up_devices() {
		return total_up_devices;
	}

	/**
	 * @param total_up_devices
	 *            the total_up_devices to set
	 */
	public void setTotal_up_devices(Integer total_up_devices) {
		this.total_up_devices = total_up_devices;
	}

	/**
	 * @return the total_down_devices
	 */
	public Integer getTotal_down_devices() {
		return total_down_devices;
	}

	/**
	 * @param total_down_devices
	 *            the total_down_devices to set
	 */
	public void setTotal_down_devices(Integer total_down_devices) {
		this.total_down_devices = total_down_devices;
	}

	/**
	 * @return the total_device_types
	 */
	public Integer getTotal_device_types() {
		return total_device_types;
	}

	/**
	 * @param total_device_types
	 *            the total_device_types to set
	 */
	public void setTotal_device_types(Integer total_device_types) {
		this.total_device_types = total_device_types;
	}

	/**
	 * @return the total_unknown_devices
	 */
	public Integer getTotal_unknown_devices() {
		return total_unknown_devices;
	}

	/**
	 * @param total_unknown_devices
	 *            the total_unknown_devices to set
	 */
	public void setTotal_unknown_devices(Integer total_unknown_devices) {
		this.total_unknown_devices = total_unknown_devices;
	}

	/**
	 * @return the total_up_device_percentage
	 */
	public Float getTotal_up_device_percentage() {
		return total_up_device_percentage;
	}

	/**
	 * @param total_up_device_percentage
	 *            the total_up_device_percentage to set
	 */
	public void setTotal_up_device_percentage(Float total_up_device_percentage) {
		this.total_up_device_percentage = total_up_device_percentage;
	}

	/**
	 * @return the total_down_device_percentage
	 */
	public Float getTotal_down_device_percentage() {
		return total_down_device_percentage;
	}

	/**
	 * @param total_down_device_percentage
	 *            the total_down_device_percentage to set
	 */
	public void setTotal_down_device_percentage(Float total_down_device_percentage) {
		this.total_down_device_percentage = total_down_device_percentage;
	}

	/**
	 * @return the total_unknown_device_percentage
	 */
	public Float getTotal_unknown_device_percentage() {
		return total_unknown_device_percentage;
	}

	/**
	 * @param total_unknown_device_percentage
	 *            the total_unknown_device_percentage to set
	 */
	public void setTotal_unknown_device_percentage(Float total_unknown_device_percentage) {
		this.total_unknown_device_percentage = total_unknown_device_percentage;
	}

}
