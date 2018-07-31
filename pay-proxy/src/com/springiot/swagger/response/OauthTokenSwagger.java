/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response on /oauth/token API response
 * 
 * @author Mandeep Singh
 */
public class OauthTokenSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<OauthToken> object;

	/**
	 * @return the object
	 */
	public List<OauthToken> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OauthToken> object) {
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
 * TO get response parameter getter setter
 */
class OauthToken {
	private String access_token;
	private int expires_in;
	private String message;
	private String user_key;
	private String user_id;
	private String access_key;
	private String last_activity_date;
	private String last_password_change_date;
	private String last_login_date;
	private boolean status;
	private String roles_name;
	private String roles_id;
	private String device_id;

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
	public String getuser_key() {
		return user_key;
	}

	/**
	 * @param user_key
	 *            the user_key to set
	 */
	public void setuser_key(String user_key) {
		this.user_key = user_key;
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
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
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
}
