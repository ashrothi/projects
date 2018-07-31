/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /service/inventory/status/device/get/all API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ServiceInventoryStatusDeviceGetAllSwagger {
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

	private List<ServiceInventoryStatusDeviceGetAll> object;

	/**
	 * @return the object
	 */
	public List<ServiceInventoryStatusDeviceGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ServiceInventoryStatusDeviceGetAll> object) {
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
 * Set the response parameters of /service/inventory/status/device/get/all API.
 * 
 *
 */
class ServiceInventoryStatusDeviceGetAll {
	// Initializing the variables
	private Integer id;
	private Integer device_id;
	private String service_name;
	private String data_source;
	private String severity;
	private String current_value;
	private Integer min_value;
	private Integer max_value;
	private Integer avg_value;
	private Long check_timestamp;
	private Long sys_timestamp;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	 * @return the min_value
	 */
	public Integer getMin_value() {
		return min_value;
	}

	/**
	 * @param min_value
	 *            the min_value to set
	 */
	public void setMin_value(Integer min_value) {
		this.min_value = min_value;
	}

	/**
	 * @return the max_value
	 */
	public Integer getMax_value() {
		return max_value;
	}

	/**
	 * @param max_value
	 *            the max_value to set
	 */
	public void setMax_value(Integer max_value) {
		this.max_value = max_value;
	}

	/**
	 * @return the avg_value
	 */
	public Integer getAvg_value() {
		return avg_value;
	}

	/**
	 * @param avg_value
	 *            the avg_value to set
	 */
	public void setAvg_value(Integer avg_value) {
		this.avg_value = avg_value;
	}

	/**
	 * @return the check_timestamp
	 */
	public Long getCheck_timestamp() {
		return check_timestamp;
	}

	/**
	 * @param check_timestamp
	 *            the check_timestamp to set
	 */
	public void setCheck_timestamp(Long check_timestamp) {
		this.check_timestamp = check_timestamp;
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