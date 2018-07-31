/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting all vehicles from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class VehicleGetAllSwagger {
	private String description;
	private List<VehicleGetAll> object;
	private boolean valid;
	
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
	/**
	 * @return the object
	 */
	public List<VehicleGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<VehicleGetAll> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * This class is used for setting data into the object.
 */
class VehicleGetAll {
	// Initializing the variables.
	private Integer vehicle_id;
	private String vehicle_identity_no;
	private String registration_no;
	private String vehicle_type;
	private String model_code;
	private Integer vehicle_type_id;
	private String fuel_type;
	private String vehicle_status;
	private String purchase_date;
	private String engine_number;
	private String chasis_number;
	private String condition;
	private String color_code;
	private Integer is_active;
	private String device_name;
	private String creation_time;
	private Integer obd_device_id;
	private String obd_device_key;
	private Integer mobile_device_id;
	private String mobile_device_key;
	private String device_type;
	private String user_key;
	private String user_name;
	private String userid;
	private Integer is_owner;
	private Integer owner_id;
	private String gender;
	private String address;
	private String org_name;
	private String driver_name;
	private String device_list;
	/**
	 * @return the vehicle_id
	 */
	public Integer getVehicle_id() {
		return vehicle_id;
	}
	/**
	 * @param vehicle_id the vehicle_id to set
	 */
	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	/**
	 * @return the vehicle_identity_no
	 */
	public String getVehicle_identity_no() {
		return vehicle_identity_no;
	}
	/**
	 * @param vehicle_identity_no the vehicle_identity_no to set
	 */
	public void setVehicle_identity_no(String vehicle_identity_no) {
		this.vehicle_identity_no = vehicle_identity_no;
	}
	/**
	 * @return the registration_no
	 */
	public String getRegistration_no() {
		return registration_no;
	}
	/**
	 * @param registration_no the registration_no to set
	 */
	public void setRegistration_no(String registration_no) {
		this.registration_no = registration_no;
	}
	/**
	 * @return the vehicle_type
	 */
	public String getVehicle_type() {
		return vehicle_type;
	}
	/**
	 * @param vehicle_type the vehicle_type to set
	 */
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	/**
	 * @return the model_code
	 */
	public String getModel_code() {
		return model_code;
	}
	/**
	 * @param model_code the model_code to set
	 */
	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}
	/**
	 * @return the vehicle_type_id
	 */
	public Integer getVehicle_type_id() {
		return vehicle_type_id;
	}
	/**
	 * @param vehicle_type_id the vehicle_type_id to set
	 */
	public void setVehicle_type_id(Integer vehicle_type_id) {
		this.vehicle_type_id = vehicle_type_id;
	}
	/**
	 * @return the fuel_type
	 */
	public String getFuel_type() {
		return fuel_type;
	}
	/**
	 * @param fuel_type the fuel_type to set
	 */
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	/**
	 * @return the vehicle_status
	 */
	public String getVehicle_status() {
		return vehicle_status;
	}
	/**
	 * @param vehicle_status the vehicle_status to set
	 */
	public void setVehicle_status(String vehicle_status) {
		this.vehicle_status = vehicle_status;
	}
	/**
	 * @return the purchase_date
	 */
	public String getPurchase_date() {
		return purchase_date;
	}
	/**
	 * @param purchase_date the purchase_date to set
	 */
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	/**
	 * @return the engine_number
	 */
	public String getEngine_number() {
		return engine_number;
	}
	/**
	 * @param engine_number the engine_number to set
	 */
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	/**
	 * @return the chasis_number
	 */
	public String getChasis_number() {
		return chasis_number;
	}
	/**
	 * @param chasis_number the chasis_number to set
	 */
	public void setChasis_number(String chasis_number) {
		this.chasis_number = chasis_number;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the color_code
	 */
	public String getColor_code() {
		return color_code;
	}
	/**
	 * @param color_code the color_code to set
	 */
	public void setColor_code(String color_code) {
		this.color_code = color_code;
	}
	/**
	 * @return the is_active
	 */
	public Integer getIs_active() {
		return is_active;
	}
	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}
	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	/**
	 * @return the creation_time
	 */
	public String getCreation_time() {
		return creation_time;
	}
	/**
	 * @param creation_time the creation_time to set
	 */
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	/**
	 * @return the obd_device_id
	 */
	public Integer getObd_device_id() {
		return obd_device_id;
	}
	/**
	 * @param obd_device_id the obd_device_id to set
	 */
	public void setObd_device_id(Integer obd_device_id) {
		this.obd_device_id = obd_device_id;
	}
	/**
	 * @return the obd_device_key
	 */
	public String getObd_device_key() {
		return obd_device_key;
	}
	/**
	 * @param obd_device_key the obd_device_key to set
	 */
	public void setObd_device_key(String obd_device_key) {
		this.obd_device_key = obd_device_key;
	}
	/**
	 * @return the mobile_device_id
	 */
	public Integer getMobile_device_id() {
		return mobile_device_id;
	}
	/**
	 * @param mobile_device_id the mobile_device_id to set
	 */
	public void setMobile_device_id(Integer mobile_device_id) {
		this.mobile_device_id = mobile_device_id;
	}
	/**
	 * @return the mobile_device_key
	 */
	public String getMobile_device_key() {
		return mobile_device_key;
	}
	/**
	 * @param mobile_device_key the mobile_device_key to set
	 */
	public void setMobile_device_key(String mobile_device_key) {
		this.mobile_device_key = mobile_device_key;
	}
	/**
	 * @return the device_type
	 */
	public String getDevice_type() {
		return device_type;
	}
	/**
	 * @param device_type the device_type to set
	 */
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}
	/**
	 * @param user_key the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the is_owner
	 */
	public Integer getIs_owner() {
		return is_owner;
	}
	/**
	 * @param is_owner the is_owner to set
	 */
	public void setIs_owner(Integer is_owner) {
		this.is_owner = is_owner;
	}
	/**
	 * @return the owner_id
	 */
	public Integer getOwner_id() {
		return owner_id;
	}
	/**
	 * @param owner_id the owner_id to set
	 */
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the org_name
	 */
	public String getOrg_name() {
		return org_name;
	}
	/**
	 * @param org_name the org_name to set
	 */
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	/**
	 * @return the driver_name
	 */
	public String getDriver_name() {
		return driver_name;
	}
	/**
	 * @param driver_name the driver_name to set
	 */
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	/**
	 * @return the device_list
	 */
	public String getDevice_list() {
		return device_list;
	}
	/**
	 * @param device_list the device_list to set
	 */
	public void setDevice_list(String device_list) {
		this.device_list = device_list;
	}
}