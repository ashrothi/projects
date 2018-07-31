/**
 * This package contain the classes used to store parameters and required data for token management and user validation.
 */
package com.springiot.constant;

/**
 * @author Garima Joshi
 * 
 *         This class is used to validate the userKey from OAuth Engine and
 *         check the permissions for the access to url.
 **/
public class URLParameter {

	private String validateAccesskey;
	private String gatewayAuthURL;
	private String forgotPassword;
	private String userProfileUpdate;
	private String userDetails;
	private String applicationsGetById;
	private String authSessionconfigure;
	private String validateToken;
	private String userSessionCheck;
	private String userSessionUpdate;
	private String authSessionDeleteSettings;
	private String grafanaRole;
	private String grafanaAPI;
	private String getAllPermisions;

	/**
	 * getAllPermisions;
	 * 
	 * @return the grafanaAPI
	 */
	public String getGrafanaAPI() {
		return grafanaAPI;
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
	 * @param grafanaAPI
	 *            the grafanaAPI to set
	 */
	public void setGrafanaAPI(String grafanaAPI) {
		this.grafanaAPI = grafanaAPI;
	}

	/**
	 * @return the grafanaRole
	 */
	public String getGrafanaRole() {
		return grafanaRole;
	}

	/**
	 * @param grafanaRole
	 *            the grafanaRole to set
	 */
	public void setGrafanaRole(String grafanaRole) {
		this.grafanaRole = grafanaRole;
	}

	/**
	 * @return the authSessionDeleteSettings
	 */
	public String getAuthSessionDeleteSettings() {
		return authSessionDeleteSettings;
	}

	/**
	 * @param authSessionDeleteSettings
	 *            the authSessionDeleteSettings to set
	 */
	public void setAuthSessionDeleteSettings(String authSessionDeleteSettings) {
		this.authSessionDeleteSettings = authSessionDeleteSettings;
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

	/**
	 * @return the userSessionUpdate
	 */
	public String getUserSessionUpdate() {
		return userSessionUpdate;
	}

	/**
	 * @param userSessionUpdate
	 *            the userSessionUpdate to set
	 */
	public void setUserSessionUpdate(String userSessionUpdate) {
		this.userSessionUpdate = userSessionUpdate;
	}

	public String getUserSessionCheck() {
		return userSessionCheck;
	}

	public void setUserSessionCheck(String userSessionCheck) {
		this.userSessionCheck = userSessionCheck;
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
	 * @return the applicationsGetById
	 */
	public String getApplicationsGetById() {
		return applicationsGetById;
	}

	/**
	 * @param applicationsGetById
	 *            the applicationsGetById to set
	 */
	public void setApplicationsGetById(String applicationsGetById) {
		this.applicationsGetById = applicationsGetById;
	}

	/**
	 * @return the userDetails
	 */
	public String getUserDetails() {
		return userDetails;
	}

	/**
	 * @param userDetails
	 *            the userDetails to set
	 */
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 * @return the userProfileUpdate
	 */
	public String getUserProfileUpdate() {
		return userProfileUpdate;
	}

	/**
	 * @param userProfileUpdate
	 *            the userProfileUpdate to set
	 */
	public void setUserProfileUpdate(String userProfileUpdate) {
		this.userProfileUpdate = userProfileUpdate;
	}

	/*
	 * This Getter Method is used to validate access Key from Authorization
	 * Engine.
	 */
	public String getValidateAccesskey() {
		return validateAccesskey;
	}

	/*
	 * This Setter Method is used to set access Key from Authorization Engine.
	 */
	public void setValidateAccesskey(String validateAccesskey) {
		this.validateAccesskey = validateAccesskey;
	}

	/*
	 * This Getter Method is used to get Gateway Authorization Details from
	 * Authorization Engine.
	 */
	public String getGatewayAuthURL() {
		return gatewayAuthURL;
	}

	/*
	 * This Setter Method is used to set Gateway Authorization Details from
	 * Authorization Engine.
	 */
	public void setGatewayAuthURL(String gatewayAuthURL) {
		this.gatewayAuthURL = gatewayAuthURL;
	}

	/*
	 * This Getter Method is used to get users List on the basis of particular
	 * role name from Authorization Engine.
	 */
	public String getUsersList() {
		return usersList;
	}

	/*
	 * This Setter Method is used to set users List on the basis of particular
	 * role name from Authorization Engine.
	 */
	public void setUsersList(String usersList) {
		this.usersList = usersList;
	}

	private String resetPassword;
	private String usersList;
	private String applicationGetAll;
	// private String gatewayauthURLByUserKey;

	/*
	 * This Getter Method is used to get Gateway Authorization Details on the
	 * basis of userKey from Authorization Engine.
	 */
	// public String getGatewayauthURLByUserKey() {
	// return gatewayauthURLByUserKey;
	// }

	/*
	 * This Setter Method is used to set third party integration token from
	 * Authorization Engine.
	 */
	/*
	 * public void setGatewayauthURLByUserKey(String gatewayauthURLByUserKey) {
	 * this.gatewayauthURLByUserKey = gatewayauthURLByUserKey; }
	 */

	/*
	 * This Getter Method is used to get token expire from Authorization Engine.
	 */
	public String getTokenExpire() {
		return tokenExpire;
	}

	/*
	 * This Getter Method is used to get all applications from Authorization
	 * Engine.
	 */
	public String getApplicationGetAll() {
		return applicationGetAll;
	}

	/*
	 * This Setter Method is used to set all applications from Authorization
	 * Engine.
	 */
	public void setApplicationGetAll(String applicationGetAll) {
		this.applicationGetAll = applicationGetAll;
	}

	/*
	 * This Setter Method is used to set token expire from Authorization Engine.
	 */
	public void setTokenExpire(String tokenExpire) {
		this.tokenExpire = tokenExpire;
	}

	private String tokenExpire;

	/*
	 * This Getter Method is used to get the reset password from Authorization
	 * Engine.
	 */
	public String getResetPassword() {
		return resetPassword;
	}

	/*
	 * This Setter Method is used to set the reset password from Authorization
	 * Engine.
	 */
	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	private String changePassword;

	/*
	 * This Getter Method is used to get the change password from Authorization
	 * Engine.
	 */
	public String getChangePassword() {
		return changePassword;
	}

	/*
	 * This Setter Method is used to set the change password from Authorization
	 * Engine.
	 */
	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

	/*
	 * This Getter Method is used to get the forgot password from Authorization
	 * Engine.
	 */
	public String getForgotPassword() {
		return forgotPassword;
	}

	/*
	 * This Setter Method is used to set the forgot password from Authorization
	 * Engine.
	 */
	public void setForgotPassword(String forgotPassword) {
		this.forgotPassword = forgotPassword;
	}

	/**
	 * Get the acessKey for validation between OAuth Engine and Xfusion
	 * Platform.
	 **/
	public String getValidateaccesskey() {
		return validateAccesskey;
	}

	/**
	 * Set the acessKey for validation between OAuth Engine and Xfusion
	 * Platform.
	 **/
	public void setValidateaccesskey(String validateaccesskey) {
		this.validateAccesskey = validateaccesskey;
	}

	/**
	 * Set the Gateway url for connection of gateway and Xfusion Platform.
	 **/
	public String getGatewayauthURL() {
		return gatewayAuthURL;
	}

	/**
	 * Set the Gateway url for connection of gateway and Xfusion Platform.
	 **/
	public void setGatewayauthURL(String gatewayauthURL) {
		this.gatewayAuthURL = gatewayauthURL;
	}
}