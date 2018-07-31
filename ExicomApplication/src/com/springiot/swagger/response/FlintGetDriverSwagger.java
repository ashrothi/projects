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
 * This class contains response on /flint/get/driver API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetDriverSwagger {
	private String description;
/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<FlintGetDriver> object;

	/**
	 * @return the object
	 */
	public List<FlintGetDriver> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetDriver> object) {
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
/*
*TO get response parameter getter setter
*/
class FlintGetDriver {
	private String id;
	private String imei; 
	private String license_key;
	private String device_id;
	private String gcm_id;
	private String is_inactive;
	private String is_deleted;
	private String created_on;
	private String last_modified_on;
	private String driver_first_name;
	private String driver_middle_name;
	private String driver_last_name;
	private String driver_contact_number;
	private String ast_inactive_on;
	private String last_active_on;
	private String driver_email_id;
	private String driver_address;
	private String driver_city;
	private String driver_state;
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
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * @return the license_key
	 */
	public String getLicense_key() {
		return license_key;
	}
	/**
	 * @param license_key the license_key to set
	 */
	public void setLicense_key(String license_key) {
		this.license_key = license_key;
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
	 * @return the gcm_id
	 */
	public String getGcm_id() {
		return gcm_id;
	}
	/**
	 * @param gcm_id the gcm_id to set
	 */
	public void setGcm_id(String gcm_id) {
		this.gcm_id = gcm_id;
	}
	/**
	 * @return the is_inactive
	 */
	public String getIs_inactive() {
		return is_inactive;
	}
	/**
	 * @param is_inactive the is_inactive to set
	 */
	public void setIs_inactive(String is_inactive) {
		this.is_inactive = is_inactive;
	}
	/**
	 * @return the is_deleted
	 */
	public String getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted the is_deleted to set
	 */
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	/**
	 * @return the created_on
	 */
	public String getCreated_on() {
		return created_on;
	}
	/**
	 * @param created_on the created_on to set
	 */
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	/**
	 * @return the last_modified_on
	 */
	public String getLast_modified_on() {
		return last_modified_on;
	}
	/**
	 * @param last_modified_on the last_modified_on to set
	 */
	public void setLast_modified_on(String last_modified_on) {
		this.last_modified_on = last_modified_on;
	}
	/**
	 * @return the driver_first_name
	 */
	public String getDriver_first_name() {
		return driver_first_name;
	}
	/**
	 * @param driver_first_name the driver_first_name to set
	 */
	public void setDriver_first_name(String driver_first_name) {
		this.driver_first_name = driver_first_name;
	}
	/**
	 * @return the driver_middle_name
	 */
	public String getDriver_middle_name() {
		return driver_middle_name;
	}
	/**
	 * @param driver_middle_name the driver_middle_name to set
	 */
	public void setDriver_middle_name(String driver_middle_name) {
		this.driver_middle_name = driver_middle_name;
	}
	/**
	 * @return the driver_last_name
	 */
	public String getDriver_last_name() {
		return driver_last_name;
	}
	/**
	 * @param driver_last_name the driver_last_name to set
	 */
	public void setDriver_last_name(String driver_last_name) {
		this.driver_last_name = driver_last_name;
	}
	/**
	 * @return the driver_contact_number
	 */
	public String getDriver_contact_number() {
		return driver_contact_number;
	}
	/**
	 * @param driver_contact_number the driver_contact_number to set
	 */
	public void setDriver_contact_number(String driver_contact_number) {
		this.driver_contact_number = driver_contact_number;
	}
	/**
	 * @return the ast_inactive_on
	 */
	public String getAst_inactive_on() {
		return ast_inactive_on;
	}
	/**
	 * @param ast_inactive_on the ast_inactive_on to set
	 */
	public void setAst_inactive_on(String ast_inactive_on) {
		this.ast_inactive_on = ast_inactive_on;
	}
	/**
	 * @return the last_active_on
	 */
	public String getLast_active_on() {
		return last_active_on;
	}
	/**
	 * @param last_active_on the last_active_on to set
	 */
	public void setLast_active_on(String last_active_on) {
		this.last_active_on = last_active_on;
	}
	/**
	 * @return the driver_email_id
	 */
	public String getDriver_email_id() {
		return driver_email_id;
	}
	/**
	 * @param driver_email_id the driver_email_id to set
	 */
	public void setDriver_email_id(String driver_email_id) {
		this.driver_email_id = driver_email_id;
	}
	/**
	 * @return the driver_address
	 */
	public String getDriver_address() {
		return driver_address;
	}
	/**
	 * @param driver_address the driver_address to set
	 */
	public void setDriver_address(String driver_address) {
		this.driver_address = driver_address;
	}
	/**
	 * @return the driver_city
	 */
	public String getDriver_city() {
		return driver_city;
	}
	/**
	 * @param driver_city the driver_city to set
	 */
	public void setDriver_city(String driver_city) {
		this.driver_city = driver_city;
	}
	/**
	 * @return the driver_state
	 */
	public String getDriver_state() {
		return driver_state;
	}
	/**
	 * @param driver_state the driver_state to set
	 */
	public void setDriver_state(String driver_state) {
		this.driver_state = driver_state;
	}

}
