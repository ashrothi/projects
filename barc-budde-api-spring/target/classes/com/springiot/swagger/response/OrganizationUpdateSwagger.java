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
 * This class contains response on /organization/update API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class OrganizationUpdateSwagger {
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

	private List<OrganizationUpdate> object;

	/**
	 * @return the object
	 */
	public List<OrganizationUpdate> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OrganizationUpdate> object) {
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
class OrganizationUpdate {
private String msg;

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


}
