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
	private String xfusionServiceStatusDeviceGetManyWithoutData;
	private String xfusionInventoryStatusDeviceGetManyWithoutData;
	private String validateToken;
	private String xfusionPlatformDeviceGetMetaData;
	private String xfusionPlatformThirdPartyIntegrationToken;
	private String xfusionPlatformDeviceExecuteCommand;
	private String xfusionPlatformUploadFirmwareFile;
	private String deviceGetAll;
	private String singleLimitWithoutData;
	private String xfusionPlatformDeviceModelGetAll;
	private String xfusionPlatformDeviceSearch;
	private String xfusionPlatformServicestatusDevicesGetMany;
	private String xfusionPlatformDeviceGetTagsByModel;
	private String xfusionPlatformRuleEngineDeviceGetByModel;

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

	public String getXfusionPlatformRuleEngineDeviceGetByModel() {
		return xfusionPlatformRuleEngineDeviceGetByModel;
	}

	public void setXfusionPlatformRuleEngineDeviceGetByModel(String xfusionPlatformRuleEngineDeviceGetByModel) {
		this.xfusionPlatformRuleEngineDeviceGetByModel = xfusionPlatformRuleEngineDeviceGetByModel;
	}

	public String getXfusionPlatformDeviceGetTagsByModel() {
		return xfusionPlatformDeviceGetTagsByModel;
	}

	public void setXfusionPlatformDeviceGetTagsByModel(String xfusionPlatformDeviceGetTagsByModel) {
		this.xfusionPlatformDeviceGetTagsByModel = xfusionPlatformDeviceGetTagsByModel;
	}

	public String getXfusionPlatformServicestatusDevicesGetMany() {
		return xfusionPlatformServicestatusDevicesGetMany;
	}

	public void setXfusionPlatformServicestatusDevicesGetMany(String xfusionPlatformServicestatusDevicesGetMany) {
		this.xfusionPlatformServicestatusDevicesGetMany = xfusionPlatformServicestatusDevicesGetMany;
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
	 * @return the xfusionServiceStatusDeviceGetManyWithoutData
	 */
	public String getXfusionServiceStatusDeviceGetManyWithoutData() {
		return xfusionServiceStatusDeviceGetManyWithoutData;
	}

	/**
	 * @param xfusionServiceStatusDeviceGetManyWithoutData
	 *            the xfusionServiceStatusDeviceGetManyWithoutData to set
	 */
	public void setXfusionServiceStatusDeviceGetManyWithoutData(String xfusionServiceStatusDeviceGetManyWithoutData) {
		this.xfusionServiceStatusDeviceGetManyWithoutData = xfusionServiceStatusDeviceGetManyWithoutData;
	}

	/**
	 * @return the xfusionInventoryStatusDeviceGetManyWithoutData
	 */
	public String getXfusionInventoryStatusDeviceGetManyWithoutData() {
		return xfusionInventoryStatusDeviceGetManyWithoutData;
	}

	/**
	 * @param xfusionInventoryStatusDeviceGetManyWithoutData
	 *            the xfusionInventoryStatusDeviceGetManyWithoutData to set
	 */
	public void setXfusionInventoryStatusDeviceGetManyWithoutData(
			String xfusionInventoryStatusDeviceGetManyWithoutData) {
		this.xfusionInventoryStatusDeviceGetManyWithoutData = xfusionInventoryStatusDeviceGetManyWithoutData;
	}

	/**
	 * @return the xfusionPlatformDeviceGetMetaData
	 */
	public String getXfusionPlatformDeviceGetMetaData() {
		return xfusionPlatformDeviceGetMetaData;
	}

	/**
	 * @param xfusionPlatformDeviceGetMetaData
	 *            the xfusionPlatformDeviceGetMetaData to set
	 */
	public void setXfusionPlatformDeviceGetMetaData(String xfusionPlatformDeviceGetMetaData) {
		this.xfusionPlatformDeviceGetMetaData = xfusionPlatformDeviceGetMetaData;
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
	 * @return the xfusionPlatformDeviceExecuteCommand
	 */
	public String getXfusionPlatformDeviceExecuteCommand() {
		return xfusionPlatformDeviceExecuteCommand;
	}

	/**
	 * @param xfusionPlatformDeviceExecuteCommand
	 *            the xfusionPlatformDeviceExecuteCommand to set
	 */
	public void setXfusionPlatformDeviceExecuteCommand(String xfusionPlatformDeviceExecuteCommand) {
		this.xfusionPlatformDeviceExecuteCommand = xfusionPlatformDeviceExecuteCommand;
	}

	/**
	 * @return the xfusionPlatformUploadFirmwareFile
	 */
	public String getXfusionPlatformUploadFirmwareFile() {
		return xfusionPlatformUploadFirmwareFile;
	}

	/**
	 * @param xfusionPlatformUploadFirmwareFile
	 *            the xfusionPlatformUploadFirmwareFile to set
	 */
	public void setXfusionPlatformUploadFirmwareFile(String xfusionPlatformUploadFirmwareFile) {
		this.xfusionPlatformUploadFirmwareFile = xfusionPlatformUploadFirmwareFile;
	}

	/**
	 * @return the deviceGetAll
	 */
	public String getDeviceGetAll() {
		return deviceGetAll;
	}

	/**
	 * @param deviceGetAll
	 *            the deviceGetAll to set
	 */
	public void setDeviceGetAll(String deviceGetAll) {
		this.deviceGetAll = deviceGetAll;
	}

	/**
	 * @return the singleLimitWithoutData
	 */
	public String getSingleLimitWithoutData() {
		return singleLimitWithoutData;
	}

	/**
	 * @param singleLimitWithoutData
	 *            the singleLimitWithoutData to set
	 */
	public void setSingleLimitWithoutData(String singleLimitWithoutData) {
		this.singleLimitWithoutData = singleLimitWithoutData;
	}

	/**
	 * @return the xfusionPlatformDeviceModelGetAll
	 */
	public String getXfusionPlatformDeviceModelGetAll() {
		return xfusionPlatformDeviceModelGetAll;
	}

	/**
	 * @param xfusionPlatformDeviceModelGetAll
	 *            the xfusionPlatformDeviceModelGetAll to set
	 */
	public void setXfusionPlatformDeviceModelGetAll(String xfusionPlatformDeviceModelGetAll) {
		this.xfusionPlatformDeviceModelGetAll = xfusionPlatformDeviceModelGetAll;
	}

	/**
	 * @return the xfusionPlatformDeviceSearch
	 */
	public String getXfusionPlatformDeviceSearch() {
		return xfusionPlatformDeviceSearch;
	}

	/**
	 * @param xfusionPlatformDeviceSearch
	 *            the xfusionPlatformDeviceSearch to set
	 */
	public void setXfusionPlatformDeviceSearch(String xfusionPlatformDeviceSearch) {
		this.xfusionPlatformDeviceSearch = xfusionPlatformDeviceSearch;
	}

}
