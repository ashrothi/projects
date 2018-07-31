/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /oauth/token Response API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class OauthTokenSwaggerResponse {
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

class OauthToken {
	// Initializing the variables
	private String access_token;
	private String expires_in;
	private String message;
	private String status;
	private String userKey;
	private String access_key;
	private String roles_name;
	private String roles_id;
	private String user_id;
	private String last_activity_date;
	private String last_password_change_date;
	private String last_login_date;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getAccess_key() {
		return access_key;
	}

	public void setAccess_key(String access_key) {
		this.access_key = access_key;
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

	public String getUser_id() {
		return user_id;
	}

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

}
