/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/alert/count API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardAlertCountSwagger {
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

	private List<DashboardAlertCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardAlertCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardAlertCount> object) {
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
 * Set the response parameters of /dashboard/alert/count API.
 * 
 *
 */
class DashboardAlertCount {
	private Integer device_devicetype_id;
	private String device_devicetype_name;
	private String device_devicetype_alias;
	private String sequence;
	private Integer alert_count;
	private Long sys_timestamp;
	private String data_group;

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
	 * @return the sequence
	 */
	public String getSequence() {
		return sequence;
	}

	/**
	 * @param sequence
	 *            the sequence to set
	 */
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	/**
	 * @return the alert_count
	 */
	public Integer getAlert_count() {
		return alert_count;
	}

	/**
	 * @param alert_count
	 *            the alert_count to set
	 */
	public void setAlert_count(Integer alert_count) {
		this.alert_count = alert_count;
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
	 * @return the data_group
	 */
	public String getData_group() {
		return data_group;
	}

	/**
	 * @param data_group
	 *            the data_group to set
	 */
	public void setData_group(String data_group) {
		this.data_group = data_group;
	}

}