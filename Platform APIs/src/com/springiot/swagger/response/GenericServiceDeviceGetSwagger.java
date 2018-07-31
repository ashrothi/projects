/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /service/bi/hourly/device/get/single API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class GenericServiceDeviceGetSwagger {
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

	private List<GenericServiceDeviceGet> object;

	/**
	 * @return the object
	 */
	public List<GenericServiceDeviceGet> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GenericServiceDeviceGet> object) {
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
 * Set the response parameters of /service/bi/hourly/device/get/single API.
 * 
 *
 */
class GenericServiceDeviceGet {
	// Initializing the variables
	private Integer device_id;
	private String service_name;
	private String data_source;
	private Long check_timestamp;
	private Long sys_timestamp;
	private String severity;
	private String current_value;
	private String device_alias;
	private String device_name;
	private String service_service_alias;
	private String service_servicedatasource_alias;
	private Integer service_servicedatasource_min_value;
	private Integer service_servicedatasource_max_value;
	private String service_servicedatasource_unit;

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
	 * @return the device_alias
	 */
	public String getDevice_alias() {
		return device_alias;
	}

	/**
	 * @param device_alias
	 *            the device_alias to set
	 */
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}

	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}

	/**
	 * @param device_name
	 *            the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}

	/**
	 * @return the service_service_alias
	 */
	public String getService_service_alias() {
		return service_service_alias;
	}

	/**
	 * @param service_service_alias
	 *            the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}

	/**
	 * @return the service_servicedatasource_alias
	 */
	public String getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}

	/**
	 * @param service_servicedatasource_alias
	 *            the service_servicedatasource_alias to set
	 */
	public void setService_servicedatasource_alias(String service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}

	/**
	 * @return the service_servicedatasource_min_value
	 */
	public Integer getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}

	/**
	 * @param service_servicedatasource_min_value
	 *            the service_servicedatasource_min_value to set
	 */
	public void setService_servicedatasource_min_value(Integer service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}

	/**
	 * @return the service_servicedatasource_max_value
	 */
	public Integer getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}

	/**
	 * @param service_servicedatasource_max_value
	 *            the service_servicedatasource_max_value to set
	 */
	public void setService_servicedatasource_max_value(Integer service_servicedatasource_max_value) {
		this.service_servicedatasource_max_value = service_servicedatasource_max_value;
	}

	/**
	 * @return the service_servicedatasource_unit
	 */
	public String getService_servicedatasource_unit() {
		return service_servicedatasource_unit;
	}

	/**
	 * @param service_servicedatasource_unit
	 *            the service_servicedatasource_unit to set
	 */
	public void setService_servicedatasource_unit(String service_servicedatasource_unit) {
		this.service_servicedatasource_unit = service_servicedatasource_unit;
	}

}