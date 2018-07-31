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
 * This class contains response on /user/update/lock/status API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UserUpdateLockStatusSwagger {
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

	private List<UserUpdateLockStatus> object;

	/**
	 * @return the object
	 */
	public List<UserUpdateLockStatus> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UserUpdateLockStatus> object) {
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
class UserUpdateLockStatus {
	public Object getAffected_rows() {return affected_rows;}
	public void setAffected_rows(Object affected_rows) {this.affected_rows = affected_rows;}
	private Object affected_rows;

}
