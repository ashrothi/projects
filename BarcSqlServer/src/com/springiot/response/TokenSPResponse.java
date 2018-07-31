/**
 * This package contains the response classes for API calling.
 */
package com.springiot.response;

/**
 * This Class to Define Token authentication deatils For API's
 *
 */
public class TokenSPResponse {

	private Object status;
	private Object code;
	private Object message;
	private Object user_key;
	private Object access_key;
	private Object utc_time;
	private Object user_id;
	private Object last_activity_date;
	private Object last_password_change_date;
	private Object last_login_date;
	private Object roles_name;
	private Object roles_id;
	private Object is_valid;
	

	public Object getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(Object is_valid) {
		this.is_valid = is_valid;
	}

	/**
	 * To get Status
	 * 
	 * @return status
	 */
	public Object getStatus() {
		return status;
	}

	/**
	 * To set Status
	 * 
	 * @param status
	 */
	public void setStatus(Object status) {
		this.status = status;
	}

	/**
	 * To get Code
	 * 
	 * @return code
	 */
	public Object getCode() {
		return code;
	}

	/**
	 * To set Code
	 * 
	 * @param code
	 */
	public void setCode(Object code) {
		this.code = code;
	}

	/**
	 * To get Message
	 * 
	 * @return message
	 */
	public Object getMessage() {
		return message;
	}

	/**
	 * To set Message
	 * 
	 * @param message
	 */
	public void setMessage(Object message) {
		this.message = message;
	}

	/**
	 * To get User_key
	 * 
	 * @return user_key
	 */
	public Object getUser_key() {
		return user_key;
	}

	/**
	 * To set User_key
	 * 
	 * @param user_key
	 */
	public void setUser_key(Object user_key) {
		this.user_key = user_key;
	}

	/**
	 * To get Utc_time
	 * 
	 * @return utc_time
	 */
	public Object getUtc_time() {
		return utc_time;
	}

	/**
	 * To set Utc_time
	 * 
	 * @param utc_time
	 */
	public void setUtc_time(Object utc_time) {
		this.utc_time = utc_time;
	}

	/**
	 * To get Access_key
	 * 
	 * @return access_key
	 */
	public Object getAccess_key() {
		return access_key;
	}

	/**
	 * To set Access_key
	 * 
	 * @param access_key
	 */
	public void setAccess_key(Object access_key) {
		this.access_key = access_key;
	}

	/**
	 * To get User_id
	 * 
	 * @return
	 */
	public Object getUser_id() {
		return user_id;
	}

	/**
	 * To set User_id
	 * 
	 * @param user_id
	 */
	public void setUser_id(Object user_id) {
		this.user_id = user_id;
	}

	public Object getLast_activity_date() {
		return last_activity_date;
	}

	public void setLast_activity_date(Object last_activity_date) {
		this.last_activity_date = last_activity_date;
	}

	public Object getLast_password_change_date() {
		return last_password_change_date;
	}

	public void setLast_password_change_date(Object last_password_change_date) {
		this.last_password_change_date = last_password_change_date;
	}

	public Object getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(Object last_login_date) {
		this.last_login_date = last_login_date;
	}

	public Object getRoles_name() {
		return roles_name;
	}

	public void setRoles_name(Object roles_name) {
		this.roles_name = roles_name;
	}

	public Object getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(Object roles_id) {
		this.roles_id = roles_id;
	}

	@Override
	public String toString() {
		return "TokenSPResponse [status=" + status + ", code=" + code + ", message=" + message + ", user_key="
				+ user_key + ", access_key=" + access_key + ", utc_time=" + utc_time + ", user_id=" + user_id
				+ ", last_activity_date=" + last_activity_date + ", last_password_change_date="
				+ last_password_change_date + ", last_login_date=" + last_login_date + ", roles_name=" + roles_name
				+ ", roles_id=" + roles_id + "]";
	}

}