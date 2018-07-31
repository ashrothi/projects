/**
 * 
 */
package com.springiot.response;

/**
 * This Class to Define Token For API's
 * 
 * @author Mandeep Singh 
 *
 */
public class TokenSPResponse {

	private Object status;
	private Object code;
	private Object message;
	private Object user_key;
	private Object access_key;
	private Object utc_time;
	private Object last_activity_date;
	private Object last_password_change_date;
	private Object last_login_date;
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
	 * @return the last_activity_date
	 */
	public Object getLast_activity_date() {
		return last_activity_date;
	}

	/**
	 * @param last_activity_date the last_activity_date to set
	 */
	public void setLast_activity_date(Object last_activity_date) {
		this.last_activity_date = last_activity_date;
	}

	/**
	 * @return the last_password_change_date
	 */
	public Object getLast_password_change_date() {
		return last_password_change_date;
	}

	/**
	 * @param last_password_change_date the last_password_change_date to set
	 */
	public void setLast_password_change_date(Object last_password_change_date) {
		this.last_password_change_date = last_password_change_date;
	}

	/**
	 * @return the last_login_date
	 */
	public Object getLast_login_date() {
		return last_login_date;
	}

	/**
	 * @param last_login_date the last_login_date to set
	 */
	public void setLast_login_date(Object last_login_date) {
		this.last_login_date = last_login_date;
	}

	/**
	 * To convert object in String.
	 */
	@Override
	public String toString() {
		return "TokenSPResponse [status=" + status + ", code=" + code + ", message=" + message + ", user_key="
				+ user_key + ", access_key=" + access_key + ", utc_time=" + utc_time + ", last_activity_date="
				+ last_activity_date + ", last_password_change_date=" + last_password_change_date + ", last_login_date="
				+ last_login_date + "]";
	}
}
