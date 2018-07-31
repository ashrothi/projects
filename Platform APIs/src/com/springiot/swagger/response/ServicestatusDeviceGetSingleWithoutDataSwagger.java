/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /servicestatus/device/get/single/without/data
 * API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ServicestatusDeviceGetSingleWithoutDataSwagger {

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

	private List<ServicestatusDeviceGetSingleWithoutData> object;

	/**
	 * @return the object
	 */
	public List<ServicestatusDeviceGetSingleWithoutData> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ServicestatusDeviceGetSingleWithoutData> object) {
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
 * Set the response parameters of /servicestatus/device/get/single/without/data
 * API.
 * 
 *
 */
class ServicestatusDeviceGetSingleWithoutData {
	// Initializing the variables
	private String severity;
	private String min_value;
	private String device_id;
	private String service_name;
	private int check_timestamp;
	private String avg_value;
	private int id;
	private int sys_timestamp;
	private String data_source;
	private String current_value;
	private String max_value;

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the min_value
	 */
	public String getMin_value() {
		return min_value;
	}

	/**
	 * @param min_value
	 *            the min_value to set
	 */
	public void setMin_value(String min_value) {
		this.min_value = min_value;
	}

	/**
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the service_name
	 */
	public String getService_name() {
		return service_name;
	}

	/**
	 * @param service_name
	 *            the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	/**
	 * @return the check_timestamp
	 */
	public int getCheck_timestamp() {
		return check_timestamp;
	}

	/**
	 * @param check_timestamp
	 *            the check_timestamp to set
	 */
	public void setCheck_timestamp(int check_timestamp) {
		this.check_timestamp = check_timestamp;
	}

	/**
	 * @return the avg_value
	 */
	public String getAvg_value() {
		return avg_value;
	}

	/**
	 * @param avg_value
	 *            the avg_value to set
	 */
	public void setAvg_value(String avg_value) {
		this.avg_value = avg_value;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sys_timestamp
	 */
	public int getSys_timestamp() {
		return sys_timestamp;
	}

	/**
	 * @param sys_timestamp
	 *            the sys_timestamp to set
	 */
	public void setSys_timestamp(int sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}

	/**
	 * @return the data_source
	 */
	public String getData_source() {
		return data_source;
	}

	/**
	 * @param data_source
	 *            the data_source to set
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	/**
	 * @return the current_value
	 */
	public String getCurrent_value() {
		return current_value;
	}

	/**
	 * @param current_value
	 *            the current_value to set
	 */
	public void setCurrent_value(String current_value) {
		this.current_value = current_value;
	}

	/**
	 * @return the max_value
	 */
	public String getMax_value() {
		return max_value;
	}

	/**
	 * @param max_value
	 *            the max_value to set
	 */
	public void setMax_value(String max_value) {
		this.max_value = max_value;
	}

}
