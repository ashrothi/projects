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
 * This class contains response on /flint/driver/insert API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintDriverInsertSwagger {
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

	private List<FlintDriverInsert> object;

	/**
	 * @return the object
	 */
	public List<FlintDriverInsert> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintDriverInsert> object) {
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
class FlintDriverInsert {
	private String msg;
	private String license_Key;
	

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
	 * @return the license_Key
	 */
	public String getLicense_Key() {
		return license_Key;
	}

	/**
	 * @param license_Key the license_Key to set
	 */
	public void setLicense_Key(String license_Key) {
		this.license_Key = license_Key;
	}
	
}
