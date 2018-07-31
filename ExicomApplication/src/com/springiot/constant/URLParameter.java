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
	private String rootOrganization;

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
