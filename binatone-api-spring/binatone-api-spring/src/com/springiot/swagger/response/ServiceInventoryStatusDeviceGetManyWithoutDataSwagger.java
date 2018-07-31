/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * 
 * This class contains response of
 * /service/inventory/status/device/get/many/without/data API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ServiceInventoryStatusDeviceGetManyWithoutDataSwagger {
	// Initialize the variable
	private String description;

	/*
	 * Getter method of description
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Setter method of description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// Initialize the variable
	private List<DeviceGetModelCategoryServiceDatasource> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<DeviceGetModelCategoryServiceDatasource> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<DeviceGetModelCategoryServiceDatasource> object) {
		this.object = object;
	}

	// Initialize the variable
	private boolean valid;

	/*
	 * Getter method of boolean value isValid
	 */
	public boolean isValid() {
		return valid;
	}

	/*
	 * Setter method to set boolean value isValid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * Set the response parameters of
 * /service/inventory/status/device/get/many/without/data API.
 * 
 * @author tanvigarg
 *
 */
class ServiceInventoryStatusDeviceGetManyWithoutData {
	// Initializing the variables
	private String severity;
	private Integer min_value;
	private Integer device_id;
	private String service_name;
	private Long check_timestamp;
	private Integer avg_value;
	private Integer id;
	private Long sys_timestamp;
	private String data_source;
	private String current_value;
	private Integer max_value;

	/*
	 * Getter method to get Severity
	 */
	public String getSeverity() {
		return severity;
	}

	/*
	 * Setter method to set Severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/*
	 * Getter method to get minimum value
	 */
	public Integer getMin_value() {
		return min_value;
	}

	/*
	 * Setter method to set minimum value
	 */
	public void setMin_value(Integer min_value) {
		this.min_value = min_value;
	}

	/*
	 * Getter method to get device id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/*
	 * Setter method to set device id
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/*
	 * Getter method to get service name
	 */
	public String getService_name() {
		return service_name;
	}

	/*
	 * Setter method to set service name
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	/*
	 * Getter method to get check timestamp
	 */
	public Long getCheck_timestamp() {
		return check_timestamp;
	}

	/*
	 * Setter method to set check timestamp
	 */
	public void setCheck_timestamp(Long check_timestamp) {
		this.check_timestamp = check_timestamp;
	}

	/*
	 * Getter method to get average value
	 */
	public Integer getAvg_value() {
		return avg_value;
	}

	/*
	 * Setter method to set average value
	 */
	public void setAvg_value(Integer avg_value) {
		this.avg_value = avg_value;
	}

	/*
	 * Getter method to get id
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * Setter method to set id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * Getter method to get sys timestamp
	 */
	public Long getSys_timestamp() {
		return sys_timestamp;
	}

	/*
	 * Setter method to set sys timestamp
	 */
	public void setSys_timestamp(Long sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}

	/*
	 * Getter method to get data source
	 */
	public String getData_source() {
		return data_source;
	}

	/*
	 * Setter method to set data source
	 */
	public void setData_source(String data_source) {
		this.data_source = data_source;
	}

	/*
	 * Getter method to get current value
	 */
	public String getCurrent_value() {
		return current_value;
	}

	/*
	 * Setter method to set current value
	 */
	public void setCurrent_value(String current_value) {
		this.current_value = current_value;
	}

	/*
	 * Getter method to get maximumm value
	 */
	public Integer getMax_value() {
		return max_value;
	}

	/*
	 * Setter method to set maximumm value
	 */
	public void setMax_value(Integer max_value) {
		this.max_value = max_value;
	}
}