/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting device details by vehicle id from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class GetDeviceDetailsByVehicleIdSwagger {
	private String description;
	private List<GetDeviceDetailsByVehicleId> object;
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
	public List<GetDeviceDetailsByVehicleId> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<GetDeviceDetailsByVehicleId> object) {
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
class GetDeviceDetailsByVehicleId {
	// Initializing the variables.
	private Integer id;
	private Integer vehicle_id;
	private Integer device_id;
	private String device_key;
	private Integer obd_id;
	private String bluetooth_addr;
	private String added_on;
	private Integer is_active;
	private String device_type;
	private Integer gcmid;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
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
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_key
	 */
	public String getDevice_key() {
		return device_key;
	}
	/**
	 * @param device_key the device_key to set
	 */
	public void setDevice_key(String device_key) {
		this.device_key = device_key;
	}
	/**
	 * @return the obd_id
	 */
	public Integer getObd_id() {
		return obd_id;
	}
	/**
	 * @param obd_id the obd_id to set
	 */
	public void setObd_id(Integer obd_id) {
		this.obd_id = obd_id;
	}
	/**
	 * @return the bluetooth_addr
	 */
	public String getBluetooth_addr() {
		return bluetooth_addr;
	}
	/**
	 * @param bluetooth_addr the bluetooth_addr to set
	 */
	public void setBluetooth_addr(String bluetooth_addr) {
		this.bluetooth_addr = bluetooth_addr;
	}
	/**
	 * @return the added_on
	 */
	public String getAdded_on() {
		return added_on;
	}
	/**
	 * @param added_on the added_on to set
	 */
	public void setAdded_on(String added_on) {
		this.added_on = added_on;
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
	 * @return the gcmid
	 */
	public Integer getGcmid() {
		return gcmid;
	}
	/**
	 * @param gcmid the gcmid to set
	 */
	public void setGcmid(Integer gcmid) {
		this.gcmid = gcmid;
	}
}