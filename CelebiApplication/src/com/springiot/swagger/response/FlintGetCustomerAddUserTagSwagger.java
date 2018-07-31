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
 * This class contains response on /flint/get/customer/add/user/tag API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetCustomerAddUserTagSwagger {
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

	private List<FlintGetCustomerAddUserTag> object;

	/**
	 * @return the object
	 */
	public List<FlintGetCustomerAddUserTag> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetCustomerAddUserTag> object) {
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
class FlintGetCustomerAddUserTag {
private String msg;
private String user_tag_name;
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
 * @return the user_tag_name
 */
public String getUser_tag_name() {
	return user_tag_name;
}
/**
 * @param user_tag_name the user_tag_name to set
 */
public void setUser_tag_name(String user_tag_name) {
	this.user_tag_name = user_tag_name;
}

}
