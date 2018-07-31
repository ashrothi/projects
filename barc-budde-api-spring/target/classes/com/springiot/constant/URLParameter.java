/**
 * This package contain class for URL Parameter to store all urls to call API's of OauthEngine and  XFusionPlatform
 */
package com.springiot.constant;

/**
 * 
 * This class is URL Parameter to store all urls to call API's of OauthEngine
 * and XFusionPlatform Map
 * 
 * @author Ankita Shrothi
 *
 */
public class URLParameter {
	/**
	 * URL's Name of XfusionPlatform and OAuth Engine Which are defined in
	 * mvc-dispatcher-servlet.xml for their urls addresses
	 */
	private String authURL;
	private String authExpireURL;
	private String authForgotPasswordURL;
	private String authUpdateURL;
	private String authResetPasswordURL;
	private String validateToken;
	private String userCreate;
	private String userUpdate;
	private String userDelete;
	private String userGetAll;
	private String roleGetAll;
	private String getAllPermisions;
	private String authSessionconfigure;

	
	/**
	 * @return the roleGetAll
	 */
	public String getRoleGetAll() {
		return roleGetAll;
	}

	/**
	 * @param roleGetAll the roleGetAll to set
	 */
	public void setRoleGetAll(String roleGetAll) {
		this.roleGetAll = roleGetAll;
	}

	/**
	 * @return the authURL
	 */
	public String getAuthURL() {
		return authURL;
	}

	/**
	 * @param authURL
	 *            the authURL to set
	 */
	public void setAuthURL(String authURL) {
		this.authURL = authURL;
	}

	/**
	 * @return the authExpireURL
	 */
	public String getAuthExpireURL() {
		return authExpireURL;
	}

	/**
	 * @param authExpireURL
	 *            the authExpireURL to set
	 */
	public void setAuthExpireURL(String authExpireURL) {
		this.authExpireURL = authExpireURL;
	}

	/**
	 * @return the authForgotPasswordURL
	 */
	public String getAuthForgotPasswordURL() {
		return authForgotPasswordURL;
	}

	/**
	 * @param authForgotPasswordURL
	 *            the authForgotPasswordURL to set
	 */
	public void setAuthForgotPasswordURL(String authForgotPasswordURL) {
		this.authForgotPasswordURL = authForgotPasswordURL;
	}

	/**
	 * @return the authUpdateURL
	 */
	public String getAuthUpdateURL() {
		return authUpdateURL;
	}

	/**
	 * @param authUpdateURL
	 *            the authUpdateURL to set
	 */
	public void setAuthUpdateURL(String authUpdateURL) {
		this.authUpdateURL = authUpdateURL;
	}

	/**
	 * @return the authResetPasswordURL
	 */
	public String getAuthResetPasswordURL() {
		return authResetPasswordURL;
	}

	/**
	 * @param authResetPasswordURL
	 *            the authResetPasswordURL to set
	 */
	public void setAuthResetPasswordURL(String authResetPasswordURL) {
		this.authResetPasswordURL = authResetPasswordURL;
	}

	/**
	 * @return the validateToken
	 */
	public String getValidateToken() {
		return validateToken;
	}

	/**
	 * @param validateToken
	 *            the validateToken to set
	 */
	public void setValidateToken(String validateToken) {
		this.validateToken = validateToken;
	}

	/**
	 * @return the userCreate
	 */
	public String getUserCreate() {
		return userCreate;
	}

	/**
	 * @param userCreate
	 *            the userCreate to set
	 */
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	/**
	 * @return the userUpdate
	 */
	public String getUserUpdate() {
		return userUpdate;
	}

	/**
	 * @param userUpdate
	 *            the userUpdate to set
	 */
	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	/**
	 * @return the userDelete
	 */
	public String getUserDelete() {
		return userDelete;
	}

	/**
	 * @param userDelete
	 *            the userDelete to set
	 */
	public void setUserDelete(String userDelete) {
		this.userDelete = userDelete;
	}

	/**
	 * @return the userGetAll
	 */
	public String getUserGetAll() {
		return userGetAll;
	}

	/**
	 * @param userGetAll
	 *            the userGetAll to set
	 */
	public void setUserGetAll(String userGetAll) {
		this.userGetAll = userGetAll;
	}

	/**
	 * @return the getAllPermisions
	 */
	public String getGetAllPermisions() {
		return getAllPermisions;
	}

	/**
	 * @param getAllPermisions
	 *            the getAllPermisions to set
	 */
	public void setGetAllPermisions(String getAllPermisions) {
		this.getAllPermisions = getAllPermisions;
	}

	/**
	 * @return the authSessionconfigure
	 */
	public String getAuthSessionconfigure() {
		return authSessionconfigure;
	}

	/**
	 * @param authSessionconfigure
	 *            the authSessionconfigure to set
	 */
	public void setAuthSessionconfigure(String authSessionconfigure) {
		this.authSessionconfigure = authSessionconfigure;
	}

}
