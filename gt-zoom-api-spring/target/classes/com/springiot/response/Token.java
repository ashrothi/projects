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
	private String access_token;
	private Integer org_id;
	private String  level;

	

	public Integer getOrg_id() {
		return org_id;
	}

	public void setOrg_id(Integer org_id) {
		this.org_id = org_id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	/*
	 * Getter Function to get Role Name from Authorization Engine
	 */
	public String getRoles_name() {
		return roles_name;
	}

	/*
	 * Setter Function to set Role Name from Authorization Engine
	 */
	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}

	/*
	 * Getter Function to get Role Id from Authorization Engine
	 */
	public String getRoles_id() {
		return roles_id;
	}

	public String getUser_key() {
		return user_key;
	}

	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	/*
	 * Setter Function to set Role Id from Authorization Engine
	 */
	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}

	private Integer token_type;
	private String message;
	private String status;
	private String user_key;
	private String access_key;
	private String roles_name;
	private String roles_id;
	private String device_id;
	private String registration_number;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String user_id;

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
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the registration_number
	 */
	public String getRegistration_number() {
		return registration_number;
	}

	/**
	 * @param registration_number
	 *            the registration_number to set
	 */
	public void setRegistration_number(String registration_number) {
		this.registration_number = registration_number;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [access_token=" + access_token + ", org_id=" + org_id + ", level=" + level + ", token_type="
				+ token_type + ", message=" + message + ", status=" + status + ", user_key=" + user_key
				+ ", access_key=" + access_key + ", roles_name=" + roles_name + ", roles_id=" + roles_id
				+ ", device_id=" + device_id + ", registration_number=" + registration_number + ", user_id=" + user_id
				+ "]";
	}
}