/**
 * This package contains the classes for maintaining the values which 
 * remains same in complete project and their getters and setters.
 */
package com.springiot.constant;

/**
 * This class is used for storing all URLs to call API's of XFusion Platform.
 * 
 * @author Mandeep Singh
 */
public class URLParameter {

	private String xFusionAuthURL;
	private String xfusionperformanceDeviceStatusDeviceGetAll;
	private String xfusionDeviceGetByUser;
	private String xfusionPerformanceServiceMultipleDevicesGetMany;
	private String OAuthValidateToken;

	/**
	 * @return the xFusionAuthURL
	 */
	public String getxFusionAuthURL() {
		return xFusionAuthURL;
	}
	/**
	 * @param xFusionAuthURL the xFusionAuthURL to set
	 */
	public void setxFusionAuthURL(String xFusionAuthURL) {
		this.xFusionAuthURL = xFusionAuthURL;
	}

	/**
	 * To get xfusionperformanceDeviceStatusDeviceGetAll
	 * 
	 * @return xfusionperformanceDeviceStatusDeviceGetAll
	 */
	public String getXfusionperformanceDeviceStatusDeviceGetAll() {
		return xfusionperformanceDeviceStatusDeviceGetAll;
	}

	/**
	 * To set XfusionperformanceDeviceStatusDeviceGetAll
	 * 
	 * @param xfusionperformanceDeviceStatusDeviceGetAll
	 */
	public void setXfusionperformanceDeviceStatusDeviceGetAll(String xfusionperformanceDeviceStatusDeviceGetAll) {
		this.xfusionperformanceDeviceStatusDeviceGetAll = xfusionperformanceDeviceStatusDeviceGetAll;
	}

	/**
	 * To get xfusionDeviceGetByUser
	 * 
	 * @return xfusionDeviceGetByUser
	 */
	public String getXfusionDeviceGetByUser() {
		return xfusionDeviceGetByUser;
	}

	/**
	 * To set XfusionDeviceGetByUser
	 * 
	 * @param xfusionDeviceGetByUser
	 */
	public void setXfusionDeviceGetByUser(String xfusionDeviceGetByUser) {
		this.xfusionDeviceGetByUser = xfusionDeviceGetByUser;
	}

	/**
	 * To get XfusionPerformanceServiceMultipleDevicesGetMany
	 * 
	 * @return xfusionPerformanceServiceMultipleDevicesGetMany
	 */
	public String getXfusionPerformanceServiceMultipleDevicesGetMany() {
		return xfusionPerformanceServiceMultipleDevicesGetMany;
	}

	/**
	 * To set XfusionPerformanceServiceMultipleDevicesGetMany
	 * 
	 * @param xfusionPerformanceServiceMultipleDevicesGetMany
	 */
	public void setXfusionPerformanceServiceMultipleDevicesGetMany(
			String xfusionPerformanceServiceMultipleDevicesGetMany) {
		this.xfusionPerformanceServiceMultipleDevicesGetMany = xfusionPerformanceServiceMultipleDevicesGetMany;
	}

	/**
	 * @return the oAuthValidateToken
	 */
	public String getOAuthValidateToken() {
		return OAuthValidateToken;
	}

	/**
	 * @param oAuthValidateToken the oAuthValidateToken to set
	 */
	public void setOAuthValidateToken(String oAuthValidateToken) {
		OAuthValidateToken = oAuthValidateToken;
	}

}
