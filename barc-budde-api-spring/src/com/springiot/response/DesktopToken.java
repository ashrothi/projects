
/**
 * This package contain the  class for Third Party Application to Set response parameter coming from OAuth engine in response and set thirdPartyApplication token value
 */
package com.springiot.response;

/**
 * 
 * This class work to get the response from OauthEngine oauth/token Api and set
 * their responses set thirdPartyApplication token value by getting value from
 * here for desktop Application
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DesktopToken {
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
	private String status;
	private String roles_name;
	private String roles_id;
	private Integer token_type;
	private String ftp_ip;
	private String ftp_port;
	private String ftp_user_name;
	private String ftp_user_password;
	private String org_id;
	private String org_access_key;
	private String client_connection_time;
	private String org_name;

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
	 * @return the ftp_user_name
	 */
	public String getFtp_user_name() {
		return ftp_user_name;
	}

	/**
	 * @param ftp_user_name
	 *            the ftp_user_name to set
	 */
	public void setFtp_user_name(String ftp_user_name) {
		this.ftp_user_name = ftp_user_name;
	}

	/**
	 * @return the ftp_user_password
	 */
	public String getFtp_user_password() {
		return ftp_user_password;
	}

	/**
	 * @param ftp_user_password
	 *            the ftp_user_password to set
	 */
	public void setFtp_user_password(String ftp_user_password) {
		this.ftp_user_password = ftp_user_password;
	}

	/**
	 * @return the ftp_ip
	 */
	public String getFtp_ip() {
		return ftp_ip;
	}

	/**
	 * @param ftp_ip
	 *            the ftp_ip to set
	 */
	public void setFtp_ip(String ftp_ip) {
		this.ftp_ip = ftp_ip;
	}

	

	/**
	 * @return the ftp_port
	 */
	public String getFtp_port() {
		return ftp_port;
	}

	/**
	 * @param ftp_port the ftp_port to set
	 */
	public void setFtp_port(String ftp_port) {
		this.ftp_port = ftp_port;
	}

	/**
	 * @return the org_id
	 */
	public String getOrg_id() {
		return org_id;
	}

	/**
	 * @param org_id
	 *            the org_id to set
	 */
	public void setOrg_id(String org_id) {
		this.org_id = org_id;
	}

	/**
	 * @return the org_access_key
	 */
	public String getOrg_access_key() {
		return org_access_key;
	}

	/**
	 * @param org_access_key
	 *            the org_access_key to set
	 */
	public void setOrg_access_key(String org_access_key) {
		this.org_access_key = org_access_key;
	}

	/**
	 * @return the client_connection_time
	 */
	public String getClient_connection_time() {
		return client_connection_time;
	}

	/**
	 * @param client_connection_time
	 *            the client_connection_time to set
	 */
	public void setClient_connection_time(String client_connection_time) {
		this.client_connection_time = client_connection_time;
	}

	/**
	 * @return the org_name
	 */
	public String getOrg_name() {
		return org_name;
	}

	/**
	 * @param org_name
	 *            the org_name to set
	 */
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

}
