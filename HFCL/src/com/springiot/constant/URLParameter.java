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
	private String deviceGetMetadataStatusBytType;
	private String performanceService;

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
	 * @return the deviceGetMetadataStatusBytType
	 */
	public String getDeviceGetMetadataStatusBytType() {
		return deviceGetMetadataStatusBytType;
	}

	/**
	 * @param deviceGetMetadataStatusBytType
	 *            the deviceGetMetadataStatusBytType to set
	 */
	public void setDeviceGetMetadataStatusBytType(String deviceGetMetadataStatusBytType) {
		this.deviceGetMetadataStatusBytType = deviceGetMetadataStatusBytType;
	}

	/**
	 * @return the performanceService
	 */
	public String getPerformanceService() {
		return performanceService;
	}

	/**
	 * @param performanceService
	 *            the performanceService to set
	 */
	public void setPerformanceService(String performanceService) {
		this.performanceService = performanceService;
	}

}
