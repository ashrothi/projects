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
 * This class contains response on /flint/delete/vehicle API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintDeleteVehicleSwagger {
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

	private List<FlintDeleteVehicle> object;

	/**
	 * @return the object
	 */
	public List<FlintDeleteVehicle> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintDeleteVehicle> object) {
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
 * TO get response parameter getter setter
 */
class FlintDeleteVehicle {

	private String msg;
	private String vehicle_id;
	private String vehicle_key;
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
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
	
}
