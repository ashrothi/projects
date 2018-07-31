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
 * This class contains response on /flint/driver/update API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintDriverUpdateSwagger {
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

	private List<FlintDriverUpdate> object;

	/**
	 * @return the object
	 */
	public List<FlintDriverUpdate> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintDriverUpdate> object) {
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
class FlintDriverUpdate {

	private String msg;
	private String license_key;
	private String driver_first_name ;
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
	
}
