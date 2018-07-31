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
 * This class contains response on /flint/get/all/driver/by/vehicle API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetAllDriverByVehicleSwagger {
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

	private List<FlintGetAllDriverByVehicle> object;

	/**
	 * @return the object
	 */
	public List<FlintGetAllDriverByVehicle> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetAllDriverByVehicle> object) {
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
class FlintGetAllDriverByVehicle {
	private String vehicle_driver_mapping_id; 
	private String vehicle_key;
	private String vehicle_id;
	private String vehicle_driver_mapping_license_key;
	private String reated_by;
	private String vehicle_driver_mapping_created_on;
	private String vehicle_driver_mapping_last_modified_by;
	private String vehicle_driver_mapping_last_modified_on;
	private String vehicle_driver_mapping_is_inactive;
	private String vehicle_driver_mapping_is_deleted;
	private String transporter_organization_path;
	private String device_driver_vehicle_id;
	private String imei; 
	private String device_driver_vehicle_license_key;
	private String device_id;
	private String gcm_id;
	private String device_driver_vehicle_is_inactive;
	private String device_driver_vehicle_is_deleted;
	private String device_driver_vehicle_created_on;
	private String device_driver_vehicle_last_modified_on;
	private String driver_first_name;
	private String driver_middle_name; 
	private String driver_last_name;
	private String driver_contact_number; 
	private String last_inactive_on;
	private String device_driver_vehicle_last_active_on;
	private String driver_email_id; 
	private String driver_address;
	private String driver_city;
	private String driver_state;
	private String driving_license;
	private String driving_license_expiry_date;
	private String driver_country;
	private String document_name;
	private String document_path;
	/**
	 * @return the vehicle_driver_mapping_id
	 */
	public String getVehicle_driver_mapping_id() {
		return vehicle_driver_mapping_id;
	}
	/**
	 * @param vehicle_driver_mapping_id the vehicle_driver_mapping_id to set
	 */
	public void setVehicle_driver_mapping_id(String vehicle_driver_mapping_id) {
		this.vehicle_driver_mapping_id = vehicle_driver_mapping_id;
	}
	/**
	 * @return the vehicle_key
	 */
	public String getVehicle_key() {
		return vehicle_key;
	}
	/**
	 * @param vehicle_key the vehicle_key to set
	 */
	public void setVehicle_key(String vehicle_key) {
		this.vehicle_key = vehicle_key;
	}
	/**
	 * @return the vehicle_id
	 */
	public String getVehicle_id() {
		return vehicle_id;
	}
	/**
	 * @param vehicle_id the vehicle_id to set
	 */
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	/**
	 * @return the vehicle_driver_mapping_license_key
	 */
	public String getVehicle_driver_mapping_license_key() {
		return vehicle_driver_mapping_license_key;
	}
	/**
	 * @param vehicle_driver_mapping_license_key the vehicle_driver_mapping_license_key to set
	 */
	public void setVehicle_driver_mapping_license_key(String vehicle_driver_mapping_license_key) {
		this.vehicle_driver_mapping_license_key = vehicle_driver_mapping_license_key;
	}
	/**
	 * @return the reated_by
	 */
	public String getReated_by() {
		return reated_by;
	}
	/**
	 * @param reated_by the reated_by to set
	 */
	public void setReated_by(String reated_by) {
		this.reated_by = reated_by;
	}
	/**
	 * @return the vehicle_driver_mapping_created_on
	 */
	public String getVehicle_driver_mapping_created_on() {
		return vehicle_driver_mapping_created_on;
	}
	/**
	 * @param vehicle_driver_mapping_created_on the vehicle_driver_mapping_created_on to set
	 */
	public void setVehicle_driver_mapping_created_on(String vehicle_driver_mapping_created_on) {
		this.vehicle_driver_mapping_created_on = vehicle_driver_mapping_created_on;
	}
	/**
	 * @return the vehicle_driver_mapping_last_modified_by
	 */
	public String getVehicle_driver_mapping_last_modified_by() {
		return vehicle_driver_mapping_last_modified_by;
	}
	/**
	 * @param vehicle_driver_mapping_last_modified_by the vehicle_driver_mapping_last_modified_by to set
	 */
	public void setVehicle_driver_mapping_last_modified_by(String vehicle_driver_mapping_last_modified_by) {
		this.vehicle_driver_mapping_last_modified_by = vehicle_driver_mapping_last_modified_by;
	}
	/**
	 * @return the vehicle_driver_mapping_last_modified_on
	 */
	public String getVehicle_driver_mapping_last_modified_on() {
		return vehicle_driver_mapping_last_modified_on;
	}
	/**
	 * @param vehicle_driver_mapping_last_modified_on the vehicle_driver_mapping_last_modified_on to set
	 */
	public void setVehicle_driver_mapping_last_modified_on(String vehicle_driver_mapping_last_modified_on) {
		this.vehicle_driver_mapping_last_modified_on = vehicle_driver_mapping_last_modified_on;
	}
	/**
	 * @return the vehicle_driver_mapping_is_inactive
	 */
	public String getVehicle_driver_mapping_is_inactive() {
		return vehicle_driver_mapping_is_inactive;
	}
	/**
	 * @param vehicle_driver_mapping_is_inactive the vehicle_driver_mapping_is_inactive to set
	 */
	public void setVehicle_driver_mapping_is_inactive(String vehicle_driver_mapping_is_inactive) {
		this.vehicle_driver_mapping_is_inactive = vehicle_driver_mapping_is_inactive;
	}
	/**
	 * @return the vehicle_driver_mapping_is_deleted
	 */
	public String getVehicle_driver_mapping_is_deleted() {
		return vehicle_driver_mapping_is_deleted;
	}
	/**
	 * @param vehicle_driver_mapping_is_deleted the vehicle_driver_mapping_is_deleted to set
	 */
	public void setVehicle_driver_mapping_is_deleted(String vehicle_driver_mapping_is_deleted) {
		this.vehicle_driver_mapping_is_deleted = vehicle_driver_mapping_is_deleted;
	}
	/**
	 * @return the transporter_organization_path
	 */
	public String getTransporter_organization_path() {
		return transporter_organization_path;
	}
	/**
	 * @param transporter_organization_path the transporter_organization_path to set
	 */
	public void setTransporter_organization_path(String transporter_organization_path) {
		this.transporter_organization_path = transporter_organization_path;
	}
	/**
	 * @return the device_driver_vehicle_id
	 */
	public String getDevice_driver_vehicle_id() {
		return device_driver_vehicle_id;
	}
	/**
	 * @param device_driver_vehicle_id the device_driver_vehicle_id to set
	 */
	public void setDevice_driver_vehicle_id(String device_driver_vehicle_id) {
		this.device_driver_vehicle_id = device_driver_vehicle_id;
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
	 * @return the device_driver_vehicle_license_key
	 */
	public String getDevice_driver_vehicle_license_key() {
		return device_driver_vehicle_license_key;
	}
	/**
	 * @param device_driver_vehicle_license_key the device_driver_vehicle_license_key to set
	 */
	public void setDevice_driver_vehicle_license_key(String device_driver_vehicle_license_key) {
		this.device_driver_vehicle_license_key = device_driver_vehicle_license_key;
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
	 * @return the device_driver_vehicle_is_inactive
	 */
	public String getDevice_driver_vehicle_is_inactive() {
		return device_driver_vehicle_is_inactive;
	}
	/**
	 * @param device_driver_vehicle_is_inactive the device_driver_vehicle_is_inactive to set
	 */
	public void setDevice_driver_vehicle_is_inactive(String device_driver_vehicle_is_inactive) {
		this.device_driver_vehicle_is_inactive = device_driver_vehicle_is_inactive;
	}
	/**
	 * @return the device_driver_vehicle_is_deleted
	 */
	public String getDevice_driver_vehicle_is_deleted() {
		return device_driver_vehicle_is_deleted;
	}
	/**
	 * @param device_driver_vehicle_is_deleted the device_driver_vehicle_is_deleted to set
	 */
	public void setDevice_driver_vehicle_is_deleted(String device_driver_vehicle_is_deleted) {
		this.device_driver_vehicle_is_deleted = device_driver_vehicle_is_deleted;
	}
	/**
	 * @return the device_driver_vehicle_created_on
	 */
	public String getDevice_driver_vehicle_created_on() {
		return device_driver_vehicle_created_on;
	}
	/**
	 * @param device_driver_vehicle_created_on the device_driver_vehicle_created_on to set
	 */
	public void setDevice_driver_vehicle_created_on(String device_driver_vehicle_created_on) {
		this.device_driver_vehicle_created_on = device_driver_vehicle_created_on;
	}
	/**
	 * @return the device_driver_vehicle_last_modified_on
	 */
	public String getDevice_driver_vehicle_last_modified_on() {
		return device_driver_vehicle_last_modified_on;
	}
	/**
	 * @param device_driver_vehicle_last_modified_on the device_driver_vehicle_last_modified_on to set
	 */
	public void setDevice_driver_vehicle_last_modified_on(String device_driver_vehicle_last_modified_on) {
		this.device_driver_vehicle_last_modified_on = device_driver_vehicle_last_modified_on;
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
	 * @return the last_inactive_on
	 */
	public String getLast_inactive_on() {
		return last_inactive_on;
	}
	/**
	 * @param last_inactive_on the last_inactive_on to set
	 */
	public void setLast_inactive_on(String last_inactive_on) {
		this.last_inactive_on = last_inactive_on;
	}
	/**
	 * @return the device_driver_vehicle_last_active_on
	 */
	public String getDevice_driver_vehicle_last_active_on() {
		return device_driver_vehicle_last_active_on;
	}
	/**
	 * @param device_driver_vehicle_last_active_on the device_driver_vehicle_last_active_on to set
	 */
	public void setDevice_driver_vehicle_last_active_on(String device_driver_vehicle_last_active_on) {
		this.device_driver_vehicle_last_active_on = device_driver_vehicle_last_active_on;
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
	/**
	 * @return the driving_license
	 */
	public String getDriving_license() {
		return driving_license;
	}
	/**
	 * @param driving_license the driving_license to set
	 */
	public void setDriving_license(String driving_license) {
		this.driving_license = driving_license;
	}
	/**
	 * @return the driving_license_expiry_date
	 */
	public String getDriving_license_expiry_date() {
		return driving_license_expiry_date;
	}
	/**
	 * @param driving_license_expiry_date the driving_license_expiry_date to set
	 */
	public void setDriving_license_expiry_date(String driving_license_expiry_date) {
		this.driving_license_expiry_date = driving_license_expiry_date;
	}
	/**
	 * @return the driver_country
	 */
	public String getDriver_country() {
		return driver_country;
	}
	/**
	 * @param driver_country the driver_country to set
	 */
	public void setDriver_country(String driver_country) {
		this.driver_country = driver_country;
	}
	/**
	 * @return the document_name
	 */
	public String getDocument_name() {
		return document_name;
	}
	/**
	 * @param document_name the document_name to set
	 */
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	/**
	 * @return the document_path
	 */
	public String getDocument_path() {
		return document_path;
	}
	/**
	 * @param document_path the document_path to set
	 */
	public void setDocument_path(String document_path) {
		this.document_path = document_path;
	}

}
