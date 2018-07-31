/**
 * This package contains the response classes for API calling.
 */
package com.springiot.response;

/**
 * 
 * This class define token authentication process For API's
 */
public class Token {

	private String access_token;
	private int expires_in;
	private String message;
	private String userKey;
	private String user_id;
	private String access_key;
	private String last_activity_date;
	private String last_password_change_date;
	private String last_login_date;
	private String roles_name;
	private String roles_id;

	/**
	 * To get Access_token
	 * 
	 * @return
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * To set Access_token
	 * 
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * To get Expires_in
	 * 
	 * @return
	 */
	public int getExpires_in() {
		return expires_in;
	}

	/**
	 * To set Expires_in
	 * 
	 * @param expires_in
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * To get Message
	 * 
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * To set Message
	 * 
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * To get UserKey
	 * 
	 * @return
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * To set UserKey
	 * 
	 * @param userKey
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * To get Access_key
	 * 
	 * @return
	 */
	public String getAccess_key() {
		return access_key;
	}

	/**
	 * To set Access_key
	 * 
	 * @param access_key
	 */
	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}

	/**
	 * To get User_id
	 * 
	 * @return
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * To set User_id
	 * 
	 * @param user_id
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLast_activity_date() {
		return last_activity_date;
	}

	public void setLast_activity_date(String last_activity_date) {
		this.last_activity_date = last_activity_date;
	}

	public String getLast_password_change_date() {
		return last_password_change_date;
	}

	public void setLast_password_change_date(String last_password_change_date) {
		this.last_password_change_date = last_password_change_date;
	}

	public String getLast_login_date() {
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	public String getRoles_name() {
		return roles_name;
	}

	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}

	public String getRoles_id() {
		return roles_id;
	}

	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", expires_in=" + expires_in + ", message=" + message
				+ ", userKey=" + userKey + ", user_id=" + user_id + ", access_key=" + access_key
				+ ", last_activity_date=" + last_activity_date + ", last_password_change_date="
				+ last_password_change_date + ", last_login_date=" + last_login_date + ", roles_name=" + roles_name
				+ ", roles_id=" + roles_id + "]";
	}

}
