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
	private String message;
	private String user_key;
	private String userKey;
	private String user_id;
	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	private String access_key;
	private String status;
	private String roles_name;
	private String roles_id;
	private Integer token_type;

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
	 * To get Access_token
	 * 
	 * @return
	 */
	public String getAccess_token() {
		return access_token;
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
	 * To set Access_token
	 * 
	 * @param access_token
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
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
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}

	/**
	 * @param user_key the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", message=" + message + ", user_key=" + user_key + ", user_id="
				+ user_id + ", access_key=" + access_key + ", status=" + status + ", roles_name=" + roles_name
				+ ", roles_id=" + roles_id + ", token_type=" + token_type + "]";
	}


}
