/**
 * 
 */
package com.springiot.response;

/**
 * 
 * @author Mandeep Singh This Class to Define Token For API's
 */
public class Token {

	private String access_token;
	private String message;
	private String userKey;
	private String user_key;
	private String user_id;
	private String access_key;
	private String status;
	private String roles_name;
	private String roles_id;
	private int token_type;

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

	/**
	 * @return the token_type
	 */
	public int getToken_type() {
		return token_type;
	}

	/**
	 * @param token_type
	 *            the token_type to set
	 */
	public void setToken_type(int token_type) {
		this.token_type = token_type;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", message=" + message + ", userKey=" + userKey + ", user_key="
				+ user_key + ", user_id=" + user_id + ", access_key=" + access_key + ", status=" + status
				+ ", roles_name=" + roles_name + ", roles_id=" + roles_id + ", token_type=" + token_type + "]";
	}

}
