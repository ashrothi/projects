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
	private String xfusionURL;
	private String authExpireURL;
	private String authForgotPasswordURL;
	private String authUpdateURL;
	private String authResetPasswordURL;
	private String xfusionOAuthURL;
	private String xfusionPlatformThirdPartyIntegrationToken;
	private String xfusionPlatformServicestatusDevicesGetMany;
	private String xfusionPerformanceServiceMultipleDevicesGetMany;
	private String xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	private String xFusionPlatformOrganizationGetAllUser;
	private String xfusionPlatformDeviceRegister;
	private String xFusionPlatformDeviceMApping;
	private String xfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	private String validateToken;
	private String rootOrganization;
	/**
	 * XfusionPlatformDeviceGetMetadataStatusByTypeLimit
	 * 
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
	 * @return the xfusionURL
	 */
	public String getXfusionURL() {
		return xfusionURL;
	}

	/**
	 * @param xfusionURL
	 *            the xfusionURL to set
	 */
	public void setXfusionURL(String xfusionURL) {
		this.xfusionURL = xfusionURL;
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
	 * @return the xfusionOAuthURL
	 */
	public String getXfusionOAuthURL() {
		return xfusionOAuthURL;
	}

	/**
	 * @param xfusionOAuthURL
	 *            the xfusionOAuthURL to set
	 */
	public void setXfusionOAuthURL(String xfusionOAuthURL) {
		this.xfusionOAuthURL = xfusionOAuthURL;
	}

	/**
	 * @return the xfusionPlatformThirdPartyIntegrationToken
	 */
	public String getXfusionPlatformThirdPartyIntegrationToken() {
		return xfusionPlatformThirdPartyIntegrationToken;
	}

	/**
	 * @param xfusionPlatformThirdPartyIntegrationToken
	 *            the xfusionPlatformThirdPartyIntegrationToken to set
	 */
	public void setXfusionPlatformThirdPartyIntegrationToken(String xfusionPlatformThirdPartyIntegrationToken) {
		this.xfusionPlatformThirdPartyIntegrationToken = xfusionPlatformThirdPartyIntegrationToken;
	}

	/**
	 * @return the xfusionPlatformServicestatusDevicesGetMany
	 */
	public String getXfusionPlatformServicestatusDevicesGetMany() {
		return xfusionPlatformServicestatusDevicesGetMany;
	}

	/**
	 * @param xfusionPlatformServicestatusDevicesGetMany
	 *            the xfusionPlatformServicestatusDevicesGetMany to set
	 */
	public void setXfusionPlatformServicestatusDevicesGetMany(String xfusionPlatformServicestatusDevicesGetMany) {
		this.xfusionPlatformServicestatusDevicesGetMany = xfusionPlatformServicestatusDevicesGetMany;
	}

	/**
	 * @return the xfusionPerformanceServiceMultipleDevicesGetMany
	 */
	public String getXfusionPerformanceServiceMultipleDevicesGetMany() {
		return xfusionPerformanceServiceMultipleDevicesGetMany;
	}

	/**
	 * @param xfusionPerformanceServiceMultipleDevicesGetMany
	 *            the xfusionPerformanceServiceMultipleDevicesGetMany to set
	 */
	public void setXfusionPerformanceServiceMultipleDevicesGetMany(
			String xfusionPerformanceServiceMultipleDevicesGetMany) {
		this.xfusionPerformanceServiceMultipleDevicesGetMany = xfusionPerformanceServiceMultipleDevicesGetMany;
	}

	/**
	 * @return the xfusionPlatformPerformanceServiceStatusDevicesGetMany
	 */
	public String getXfusionPlatformPerformanceServiceStatusDevicesGetMany() {
		return xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	}

	/**
	 * @param xfusionPlatformPerformanceServiceStatusDevicesGetMany
	 *            the xfusionPlatformPerformanceServiceStatusDevicesGetMany to
	 *            set
	 */
	public void setXfusionPlatformPerformanceServiceStatusDevicesGetMany(
			String xfusionPlatformPerformanceServiceStatusDevicesGetMany) {
		this.xfusionPlatformPerformanceServiceStatusDevicesGetMany = xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	}

	/**
	 * @return the xFusionPlatformOrganizationGetAllUser
	 */
	public String getxFusionPlatformOrganizationGetAllUser() {
		return xFusionPlatformOrganizationGetAllUser;
	}

	/**
	 * @param xFusionPlatformOrganizationGetAllUser
	 *            the xFusionPlatformOrganizationGetAllUser to set
	 */
	public void setxFusionPlatformOrganizationGetAllUser(String xFusionPlatformOrganizationGetAllUser) {
		this.xFusionPlatformOrganizationGetAllUser = xFusionPlatformOrganizationGetAllUser;
	}

	/**
	 * @return the xfusionPlatformDeviceRegister
	 */
	public String getXfusionPlatformDeviceRegister() {
		return xfusionPlatformDeviceRegister;
	}

	/**
	 * @param xfusionPlatformDeviceRegister
	 *            the xfusionPlatformDeviceRegister to set
	 */
	public void setXfusionPlatformDeviceRegister(String xfusionPlatformDeviceRegister) {
		this.xfusionPlatformDeviceRegister = xfusionPlatformDeviceRegister;
	}

	/**
	 * @return the xFusionPlatformDeviceMApping
	 */
	public String getxFusionPlatformDeviceMApping() {
		return xFusionPlatformDeviceMApping;
	}

	/**
	 * @param xFusionPlatformDeviceMApping
	 *            the xFusionPlatformDeviceMApping to set
	 */
	public void setxFusionPlatformDeviceMApping(String xFusionPlatformDeviceMApping) {
		this.xFusionPlatformDeviceMApping = xFusionPlatformDeviceMApping;
	}

	/**
	 * @return the xfusionPlatformDeviceGetMetadataStatusByTypeLimit
	 */
	public String getXfusionPlatformDeviceGetMetadataStatusByTypeLimit() {
		return xfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	}

	/**
	 * @param xfusionPlatformDeviceGetMetadataStatusByTypeLimit
	 *            the xfusionPlatformDeviceGetMetadataStatusByTypeLimit to set
	 */
	public void setXfusionPlatformDeviceGetMetadataStatusByTypeLimit(
			String xfusionPlatformDeviceGetMetadataStatusByTypeLimit) {
		this.xfusionPlatformDeviceGetMetadataStatusByTypeLimit = xfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	}

	/**
	 * @return the validateToken
	 */
	public String getValidateToken() {
		return validateToken;
	}

	/**
	 * @param validateToken the validateToken to set
	 */
	public void setValidateToken(String validateToken) {
		this.validateToken = validateToken;
	}

	/**
	 * @return the rootOrganization
	 */
	public String getRootOrganization() {
		return rootOrganization;
	}

	/**
	 * @param rootOrganization the rootOrganization to set
	 */
	public void setRootOrganization(String rootOrganization) {
		this.rootOrganization = rootOrganization;
	}

}
