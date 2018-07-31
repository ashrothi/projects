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
 * This class contains response on /machine/get/lock API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class MachineGetLockSwagger {
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

	private List<MachineGetLock> object;

	/**
	 * @return the object
	 */
	public List<MachineGetLock> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<MachineGetLock> object) {
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
class MachineGetLock {

	private int device_id; 
	private String part_code;
	/**
	 * @return the device_id
	 */
	public int getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the part_code
	 */
	public String getPart_code() {
		return part_code;
	}
	/**
	 * @param part_code the part_code to set
	 */
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	} 
	
	
}
