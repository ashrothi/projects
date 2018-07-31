package com.teramatrix.processData;

/**
 * This is model class for storing all the data of a trip for a device.
 * 
 * @author Mandeep Singh
 *
 */
public class TripModel {
	private String severity;
	private String min_value;
	private String device_id;
	private String service_name;
	private String check_timestamp;
	private String avg_value;
	private String id;
	private String sys_timestamp;
	private String data_source;
	private String current_value;
	private String max_value;
	private String device_alias;
	private String organization_alias;
	private String organization_path;
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}
	/**
	 * @param severity the severity to set
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
	 * @param min_value the min_value to set
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
	 * @param device_id the device_id to set
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
	 * @param service_name the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	/**
	 * @return the check_timestamp
	 */
	public String getCheck_timestamp() {
		return check_timestamp;
	}
	/**
	 * @param check_timestamp the check_timestamp to set
	 */
	public void setCheck_timestamp(String check_timestamp) {
		this.check_timestamp = check_timestamp;
	}
	/**
	 * @return the avg_value
	 */
	public String getAvg_value() {
		return avg_value;
	}
	/**
	 * @param avg_value the avg_value to set
	 */
	public void setAvg_value(String avg_value) {
		this.avg_value = avg_value;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the sys_timestamp
	 */
	public String getSys_timestamp() {
		return sys_timestamp;
	}
	/**
	 * @param sys_timestamp the sys_timestamp to set
	 */
	public void setSys_timestamp(String sys_timestamp) {
		this.sys_timestamp = sys_timestamp;
	}
	/**
	 * @return the data_source
	 */
	public String getData_source() {
		return data_source;
	}
	/**
	 * @param data_source the data_source to set
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
	 * @param current_value the current_value to set
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
	 * @return the device_alias
	 */
	public String getDevice_alias() {
		return device_alias;
	}
	/**
	 * @param device_alias the device_alias to set
	 */
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	}
	/**
	 * @param max_value the max_value to set
	 */
	public void setMax_value(String max_value) {
		this.max_value = max_value;
	}
	/**
	 * @return the organization_alias
	 */
	public String getOrganization_alias() {
		return organization_alias;
	}
	/**
	 * @param organization_alias the organization_alias to set
	 */
	public void setOrganization_alias(String organization_alias) {
		this.organization_alias = organization_alias;
	}
	/**
	 * @return the organization_path
	 */
	public String getOrganization_path() {
		return organization_path;
	}
	/**
	 * @param organization_path the organization_path to set
	 */
	public void setOrganization_path(String organization_path) {
		this.organization_path = organization_path;
	}
	
	@Override
	public String toString() {
		
		String row = "";
		// Here return all the variable values.
		if(current_value.equalsIgnoreCase("0.0") || current_value.equalsIgnoreCase("0")){
			
		}
		else{
			row = "('" + severity + "', '" + min_value + "', '" + device_id + "', '" + service_name
					+ "', '" + check_timestamp + "', '" + avg_value + "', '" + id + "', '" 
					+ sys_timestamp + "', '" + data_source + "', '" + current_value + "', '" + max_value 
					+ "', '" + device_alias + "', '" + organization_alias + "', '" + organization_path + "'),";
		}
		return row;
		
	}
	

}
