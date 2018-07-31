/**
 * This package contain class for URL Parameter to store all urls to call API's of OauthEngine and  XFusionPlatform
 */
package com.springiot.constant;

/**
 * This class is URL Parameter to store all urls to call API's of OauthEngine
 * and XFusionPlatform Map
 * 
 * @author Ankita Shrothi, Mandeep Singh
 */
public class URLParameter {
	/**
	 * URL's Name of XfusionPlatform and OAuth Engine Which are defined in
	 * mvc-dispatcher-servlet.xml for their urls addresses
	 */
	private String authURL;
	private String xfusionPlatformDeviceRegister;
	private String xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	private String xfusionPerformanceServiceMultipleDevicesGetMany;
	private String xFusionPlatformDeviceMApping;
	private String xFusionPlatformOrganizationGetAllUser;
	private String xfusionperformanceDeviceStatusDeviceGetAll;
	private String xfusionDeviceGetByUser;
	private String XfusionPlatformDeviceGetMetadataStatusByTypeLimit;
	private String XfusionPerformanceEventstatusAlertDeviceGetAllLimit;
	private String EventstatusAlertDeviceGetAllLimit;
	private String rootOrganization;
	private String validateToken;

	private String xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData;
	
	private String platformOrganizationCheck;
	private String platformUserCreation;
	private String authLogout;
	private String platformLogin;
	private String platformOrgInsert;
	private String platformUserOrgMapping;
	private String platformInheritTemplate;
	private String platformLogout;
	
	private String userCreate;
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
	 * @return the xfusionDeviceGetByUser
	 */
	public String getXfusionDeviceGetByUser() {
		return xfusionDeviceGetByUser;
	}

	/**
	 * @param xfusionDeviceGetByUser
	 *            the xfusionDeviceGetByUser to set
	 */
	public void setXfusionDeviceGetByUser(String xfusionDeviceGetByUser) {
		this.xfusionDeviceGetByUser = xfusionDeviceGetByUser;
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
	 * @return the rootOrganization
	 */
	public String getRootOrganization() {
		return rootOrganization;
	}

	/**
	 * @param rootOrganization
	 *            the rootOrganization to set
	 */
	public void setRootOrganization(String rootOrganization) {
		this.rootOrganization = rootOrganization;
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
	 * @return the xfusionperformanceDeviceStatusDeviceGetAll
	 */
	public String getXfusionperformanceDeviceStatusDeviceGetAll() {
		return xfusionperformanceDeviceStatusDeviceGetAll;
	}

	/**
	 * @param xfusionperformanceDeviceStatusDeviceGetAll
	 *            the xfusionperformanceDeviceStatusDeviceGetAll to set
	 */
	public void setXfusionperformanceDeviceStatusDeviceGetAll(String xfusionperformanceDeviceStatusDeviceGetAll) {
		this.xfusionperformanceDeviceStatusDeviceGetAll = xfusionperformanceDeviceStatusDeviceGetAll;
	}

	/**
	 * @return the xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData
	 */
	public String getXfusionPerformanceServicedailyDeviceGetManyLimitWithoutData() {
		return xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData;
	}

	/**
	 * @param xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData the xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData to set
	 */
	public void setXfusionPerformanceServicedailyDeviceGetManyLimitWithoutData(
			String xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData) {
		this.xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData = xfusionPerformanceServicedailyDeviceGetManyLimitWithoutData;
	}

	/**
	 * @return the platformOrganizationCheck
	 */
	public String getPlatformOrganizationCheck() {
		return platformOrganizationCheck;
	}

	/**
	 * @param platformOrganizationCheck the platformOrganizationCheck to set
	 */
	public void setPlatformOrganizationCheck(String platformOrganizationCheck) {
		this.platformOrganizationCheck = platformOrganizationCheck;
	}

	/**
	 * @return the platformUserCreation
	 */
	public String getPlatformUserCreation() {
		return platformUserCreation;
	}

	/**
	 * @param platformUserCreation the platformUserCreation to set
	 */
	public void setPlatformUserCreation(String platformUserCreation) {
		this.platformUserCreation = platformUserCreation;
	}

	/**
	 * @return the authLogout
	 */
	public String getAuthLogout() {
		return authLogout;
	}

	/**
	 * @param authLogout the authLogout to set
	 */
	public void setAuthLogout(String authLogout) {
		this.authLogout = authLogout;
	}

	/**
	 * @return the platformLogin
	 */
	public String getPlatformLogin() {
		return platformLogin;
	}

	/**
	 * @param platformLogin the platformLogin to set
	 */
	public void setPlatformLogin(String platformLogin) {
		this.platformLogin = platformLogin;
	}

	/**
	 * @return the platformOrgInsert
	 */
	public String getPlatformOrgInsert() {
		return platformOrgInsert;
	}

	/**
	 * @param platformOrgInsert the platformOrgInsert to set
	 */
	public void setPlatformOrgInsert(String platformOrgInsert) {
		this.platformOrgInsert = platformOrgInsert;
	}

	/**
	 * @return the platformUserOrgMapping
	 */
	public String getPlatformUserOrgMapping() {
		return platformUserOrgMapping;
	}

	/**
	 * @param platformUserOrgMapping the platformUserOrgMapping to set
	 */
	public void setPlatformUserOrgMapping(String platformUserOrgMapping) {
		this.platformUserOrgMapping = platformUserOrgMapping;
	}

	/**
	 * @return the platformInheritTemplate
	 */
	public String getPlatformInheritTemplate() {
		return platformInheritTemplate;
	}

	/**
	 * @param platformInheritTemplate the platformInheritTemplate to set
	 */
	public void setPlatformInheritTemplate(String platformInheritTemplate) {
		this.platformInheritTemplate = platformInheritTemplate;
	}

	/**
	 * @return the platformLogout
	 */
	public String getPlatformLogout() {
		return platformLogout;
	}

	/**
	 * @param platformLogout the platformLogout to set
	 */
	public void setPlatformLogout(String platformLogout) {
		this.platformLogout = platformLogout;
	}

	/**
	 * @return the userCreate
	 */
	public String getUserCreate() {
		return userCreate;
	}

	/**
	 * @param userCreate the userCreate to set
	 */
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
}
