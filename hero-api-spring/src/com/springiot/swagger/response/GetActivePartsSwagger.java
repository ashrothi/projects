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
 * This class contains response on /get/active/parts  API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GetActivePartsSwagger {
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

	private List<GetActiveParts> object;

	/**
	 * @return the object
	 */
	public List<GetActiveParts> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GetActiveParts> object) {
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
class GetActiveParts {
private int device_id;

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


}
