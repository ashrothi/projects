/**
 * This package contain the  class for Third Party Application to Set response parameter coming from OAuth engine in response and set thirdPartyApplication token value
 */
package com.springiot.response;

/**
 * 
 * This class work to get the response from OauthEngine oauth/token Api and set
 * their responses set thirdPartyApplication token value by getting value from
 * here
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class Token {
	/***
	 * Declaring parameter coming in responses
	 */
	private String access_token;
	private int expires_in;
	private String message;
	private String user_key;
	private String userKey;
	private String user_id;
	private String access_key;
	private String last_activity_date;
	private String last_password_change_date;
	private String last_login_date;
	private String status;
	private String roles_name;
	private String roles_id;
	private Integer token_type;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the token_type
	 */
	public Integer getToken_type() {
		return token_type;
	}

	/**
	 * @param token_type
	 *            the token_type to set
	 */
	public void setToken_type(Integer token_type) {
		this.token_type = token_type;
	}

	/**
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public int getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}

	/**
	 * @param user_key
	 *            the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * @param userKey
	 *            the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the access_key
	 */
	public String getAccess_key() {
		return access_key;
	}

	/**
	 * @param access_key
	 *            the access_key to set
	 */
	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}

	/**
	 * @return the last_activity_date
	 */
	public String getLast_activity_date() {
		return last_activity_date;
	}

	/**
	 * @param last_activity_date
	 *            the last_activity_date to set
	 */
	public void setLast_activity_date(String last_activity_date) {
		this.last_activity_date = last_activity_date;
	}

	/**
	 * @return the last_password_change_date
	 */
	public String getLast_password_change_date() {
		return last_password_change_date;
	}

	/**
	 * @param last_password_change_date
	 *            the last_password_change_date to set
	 */
	public void setLast_password_change_date(String last_password_change_date) {
		this.last_password_change_date = last_password_change_date;
	}

	/**
	 * @return the last_login_date
	 */
	public String getLast_login_date() {
		return last_login_date;
	}

	/**
	 * @param last_login_date
	 *            the last_login_date to set
	 */
	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}

	/**
	 * @return the roles_name
	 */
	public String getRoles_name() {
		return roles_name;
	}

	/**
	 * @param roles_name
	 *            the roles_name to set
	 */
	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}

	/**
	 * @return the roles_id
	 */
	public String getRoles_id() {
		return roles_id;
	}

	/**
	 * @param roles_id
	 *            the roles_id to set
	 */
	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}

}
