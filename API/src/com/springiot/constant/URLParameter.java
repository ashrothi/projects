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
	private String authResetPasswordURL;
	private String authExpireURL;
	private String authForgotPasswordURL;
	private String authUpdateURL;
	private String XfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	private String xfusionPerformanceServiceMultipleDevicesGetMany;
	private String XfusionPerformanceEventstatusAlertDeviceGetAllLimit;
	private String EventstatusAlertDeviceGetAllLimit;
	private String xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	private String xfusionPlatformGetDeviceByUser;
	private String validateToken;

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
	 * @return the eventstatusAlertDeviceGetAllLimit
	 */
	public String getEventstatusAlertDeviceGetAllLimit() {
		return EventstatusAlertDeviceGetAllLimit;
	}

	/**
	 * @param eventstatusAlertDeviceGetAllLimit
	 *            the eventstatusAlertDeviceGetAllLimit to set
	 */
	public void setEventstatusAlertDeviceGetAllLimit(String eventstatusAlertDeviceGetAllLimit) {
		EventstatusAlertDeviceGetAllLimit = eventstatusAlertDeviceGetAllLimit;
	}

	/**
	 * @return the xfusionPerformanceEventstatusAlertDeviceGetAllLimit
	 */
	public String getXfusionPerformanceEventstatusAlertDeviceGetAllLimit() {
		return XfusionPerformanceEventstatusAlertDeviceGetAllLimit;
	}

	/**
	 * @param xfusionPerformanceEventstatusAlertDeviceGetAllLimit
	 *            the xfusionPerformanceEventstatusAlertDeviceGetAllLimit to set
	 */
	public void setXfusionPerformanceEventstatusAlertDeviceGetAllLimit(
			String xfusionPerformanceEventstatusAlertDeviceGetAllLimit) {
		XfusionPerformanceEventstatusAlertDeviceGetAllLimit = xfusionPerformanceEventstatusAlertDeviceGetAllLimit;
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
	 * @return the xfusionPlatformDeviceGetMetadataStatusByTypeLimit
	 */
	public String getXfusionPlatformDeviceGetMetadataStatusByTypeLimit() {
		return XfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	}

	/**
	 * @param xfusionPlatformDeviceGetMetadataStatusByTypeLimit
	 *            the xfusionPlatformDeviceGetMetadataStatusByTypeLimit to set
	 */
	public void setXfusionPlatformDeviceGetMetadataStatusByTypeLimit(
			String xfusionPlatformDeviceGetMetadataStatusByTypeLimit) {
		XfusionPlatformDeviceGetMetadataStatusByTypeLimit = xfusionPlatformDeviceGetMetadataStatusByTypeLimit;
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

	public String getXfusionPlatformGetDeviceByUser() {
		return xfusionPlatformGetDeviceByUser;
	}

	public void setXfusionPlatformGetDeviceByUser(String xfusionPlatformGetDeviceByUser) {
		this.xfusionPlatformGetDeviceByUser = xfusionPlatformGetDeviceByUser;
	}

}
