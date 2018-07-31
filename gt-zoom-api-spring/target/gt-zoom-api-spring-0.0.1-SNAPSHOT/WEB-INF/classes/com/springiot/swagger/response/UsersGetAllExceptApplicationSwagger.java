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
 * This class contains response on /users/get/all/except/application API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UsersGetAllExceptApplicationSwagger {
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

	private List<UsersGetAllExceptApplication> object;

	/**
	 * @return the object
	 */
	public List<UsersGetAllExceptApplication> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UsersGetAllExceptApplication> object) {
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
class UsersGetAllExceptApplication {

	private String users_id;
	private String users_name;
	private String users_is_deleted;
	private String membership_is_locked_out;
	private String membership_last_locked_out_date;
	/**
	 * @return the users_id
	 */
	public String getUsers_id() {
		return users_id;
	}
	/**
	 * @param users_id the users_id to set
	 */
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	/**
	 * @return the users_name
	 */
	public String getUsers_name() {
		return users_name;
	}
	/**
	 * @param users_name the users_name to set
	 */
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}
	/**
	 * @return the users_is_deleted
	 */
	public String getUsers_is_deleted() {
		return users_is_deleted;
	}
	/**
	 * @param users_is_deleted the users_is_deleted to set
	 */
	public void setUsers_is_deleted(String users_is_deleted) {
		this.users_is_deleted = users_is_deleted;
	}
	/**
	 * @return the membership_is_locked_out
	 */
	public String getMembership_is_locked_out() {
		return membership_is_locked_out;
	}
	/**
	 * @param membership_is_locked_out the membership_is_locked_out to set
	 */
	public void setMembership_is_locked_out(String membership_is_locked_out) {
		this.membership_is_locked_out = membership_is_locked_out;
	}
	/**
	 * @return the membership_last_locked_out_date
	 */
	public String getMembership_last_locked_out_date() {
		return membership_last_locked_out_date;
	}
	/**
	 * @param membership_last_locked_out_date the membership_last_locked_out_date to set
	 */
	public void setMembership_last_locked_out_date(String membership_last_locked_out_date) {
		this.membership_last_locked_out_date = membership_last_locked_out_date;
	}
	
}
