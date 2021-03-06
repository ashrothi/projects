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
	private String xfusionServiceStatusDeviceGetManyWithoutData;
	private String xfusionInventoryStatusDeviceGetManyWithoutData;
	private String xfusionOAuthURL;
	private String xfusionPlatformDeviceGetMetaData;
	private String xfusionPlatformThirdPartyIntegrationToken;
	private String xfusionPlatformDeviceExecuteCommand;
	private String xfusionPlatformDeviceModelGetAllByDeviceTechnology;
	private String xfusionPlatformUsersGetAllByUserOrganization;
	private String xfusionPlatformDeviceRegister;
	private String xfusionPlatformPerformanceServiceStatusDevicesGetMany;
	private String xfusionPlatformPerformanceOrganizationGetAll;
	private String xfusionPerformanceServiceMultipleDevicesStatusGetMany;
	private String xfusionPerformanceServiceMultipleDevicesGetMany;
	private String xfusionOrganizationCountryGet;
	private String xfusionOrganizationGetAll;
	private String xfusionOrganizationStateGet; 
	private String xfusionOrganizationCityGet;
	private String xfusionOrganizationInsert;
	private String xfusionOrganizationUpdate;
	private String xfusionOrganizationDelete;
	private String userCreate;
	private String userUpdate;
	private String userDelete;
	private String userGetAll;
	private String userRoleGetAll;
	private String attributeGetAllByUser;
	private String xfusionOrganizationUserMapping;
	private String oauthCountryGet;
	private String oauthRolesGetALlUserApplication;
	private String oauthUserGetAttribute;
	private String oauthUserUpdateLockStatus;
	private String oauthApplictionUserRemove;
	private String oauthUsersGetAllExceptApplication;
	private String oauthUserUpdateAttribute;
	private String oauthApplicationUserAdd;
	private String oauthUserInactive;
	private String oauthCityGet;
	private String oauthStateGet;
	private String deviceGetMetadataStatusBytType;
	private String performanceService;

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

	public String getXfusionPlatformUsersGetAllByUserOrganization() {
		return xfusionPlatformUsersGetAllByUserOrganization;
	}

	public void setXfusionPlatformUsersGetAllByUserOrganization(String xfusionPlatformUsersGetAllByUserOrganization) {
		this.xfusionPlatformUsersGetAllByUserOrganization = xfusionPlatformUsersGetAllByUserOrganization;
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
	 * @return the xfusionPlatformDeviceModelGetAllByDeviceTechnology
	 */
	public String getXfusionPlatformDeviceModelGetAllByDeviceTechnology() {
		return xfusionPlatformDeviceModelGetAllByDeviceTechnology;
	}

	/**
	 * @param xfusionPlatformDeviceModelGetAllByDeviceTechnology
	 *            the xfusionPlatformDeviceModelGetAllByDeviceTechnology to set
	 */
	public void setXfusionPlatformDeviceModelGetAllByDeviceTechnology(
			String xfusionPlatformDeviceModelGetAllByDeviceTechnology) {
		this.xfusionPlatformDeviceModelGetAllByDeviceTechnology = xfusionPlatformDeviceModelGetAllByDeviceTechnology;
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
	 * @return the xfusionPlatformPerformanceOrganizationGetAll
	 */
	public String getXfusionPlatformPerformanceOrganizationGetAll() {
		return xfusionPlatformPerformanceOrganizationGetAll;
	}

	/**
	 * @param xfusionPlatformPerformanceOrganizationGetAll
	 *            the xfusionPlatformPerformanceOrganizationGetAll to set
	 */
	public void setXfusionPlatformPerformanceOrganizationGetAll(String xfusionPlatformPerformanceOrganizationGetAll) {
		this.xfusionPlatformPerformanceOrganizationGetAll = xfusionPlatformPerformanceOrganizationGetAll;
	}

	/**
	 * @return the xfusionPerformanceServiceMultipleDevicesStatusGetMany
	 */
	public String getXfusionPerformanceServiceMultipleDevicesStatusGetMany() {
		return xfusionPerformanceServiceMultipleDevicesStatusGetMany;
	}

	/**
	 * @param xfusionPerformanceServiceMultipleDevicesStatusGetMany
	 *            the xfusionPerformanceServiceMultipleDevicesStatusGetMany to
	 *            set
	 */
	public void setXfusionPerformanceServiceMultipleDevicesStatusGetMany(
			String xfusionPerformanceServiceMultipleDevicesStatusGetMany) {
		this.xfusionPerformanceServiceMultipleDevicesStatusGetMany = xfusionPerformanceServiceMultipleDevicesStatusGetMany;
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
	 * @return the xfusionOrganizationCountryGet
	 */
	public String getXfusionOrganizationCountryGet() {
		return xfusionOrganizationCountryGet;
	}

	/**
	 * @param xfusionOrganizationCountryGet
	 *            the xfusionOrganizationCountryGet to set
	 */
	public void setXfusionOrganizationCountryGet(String xfusionOrganizationCountryGet) {
		this.xfusionOrganizationCountryGet = xfusionOrganizationCountryGet;
	}

	/**
	 * @return the xfusionOrganizationGetAll
	 */
	public String getXfusionOrganizationGetAll() {
		return xfusionOrganizationGetAll;
	}

	/**
	 * @param xfusionOrganizationGetAll
	 *            the xfusionOrganizationGetAll to set
	 */
	public void setXfusionOrganizationGetAll(String xfusionOrganizationGetAll) {
		this.xfusionOrganizationGetAll = xfusionOrganizationGetAll;
	}

	/**
	 * @return the xfusionOrganizationStateGet
	 */
	public String getXfusionOrganizationStateGet() {
		return xfusionOrganizationStateGet;
	}

	/**
	 * @param xfusionOrganizationStateGet
	 *            the xfusionOrganizationStateGet to set
	 */
	public void setXfusionOrganizationStateGet(String xfusionOrganizationStateGet) {
		this.xfusionOrganizationStateGet = xfusionOrganizationStateGet;
	}

	/**
	 * @return the xfusionOrganizationCityGet
	 */
	public String getXfusionOrganizationCityGet() {
		return xfusionOrganizationCityGet;
	}

	/**
	 * @param xfusionOrganizationCityGet
	 *            the xfusionOrganizationCityGet to set
	 */
	public void setXfusionOrganizationCityGet(String xfusionOrganizationCityGet) {
		this.xfusionOrganizationCityGet = xfusionOrganizationCityGet;
	}

	/**
	 * @return the xfusionOrganizationInsert
	 */
	public String getXfusionOrganizationInsert() {
		return xfusionOrganizationInsert;
	}

	/**
	 * @param xfusionOrganizationInsert
	 *            the xfusionOrganizationInsert to set
	 */
	public void setXfusionOrganizationInsert(String xfusionOrganizationInsert) {
		this.xfusionOrganizationInsert = xfusionOrganizationInsert;
	}

	/**
	 * @return the xfusionOrganizationUpdate
	 */
	public String getXfusionOrganizationUpdate() {
		return xfusionOrganizationUpdate;
	}

	/**
	 * @param xfusionOrganizationUpdate
	 *            the xfusionOrganizationUpdate to set
	 */
	public void setXfusionOrganizationUpdate(String xfusionOrganizationUpdate) {
		this.xfusionOrganizationUpdate = xfusionOrganizationUpdate;
	}

	/**
	 * @return the xfusionOrganizationDelete
	 */
	public String getXfusionOrganizationDelete() {
		return xfusionOrganizationDelete;
	}

	/**
	 * @param xfusionOrganizationDelete
	 *            the xfusionOrganizationDelete to set
	 */
	public void setXfusionOrganizationDelete(String xfusionOrganizationDelete) {
		this.xfusionOrganizationDelete = xfusionOrganizationDelete;
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
	 * @return the userRoleGetAll
	 */
	public String getUserRoleGetAll() {
		return userRoleGetAll;
	}

	/**
	 * @param userRoleGetAll
	 *            the userRoleGetAll to set
	 */
	public void setUserRoleGetAll(String userRoleGetAll) {
		this.userRoleGetAll = userRoleGetAll;
	}

	/**
	 * @return the attributeGetAllByUser
	 */
	public String getAttributeGetAllByUser() {
		return attributeGetAllByUser;
	}

	/**
	 * @param attributeGetAllByUser
	 *            the attributeGetAllByUser to set
	 */
	public void setAttributeGetAllByUser(String attributeGetAllByUser) {
		this.attributeGetAllByUser = attributeGetAllByUser;
	}

	/**
	 * @return the xfusionOrganizationUserMapping
	 */
	public String getXfusionOrganizationUserMapping() {
		return xfusionOrganizationUserMapping;
	}

	/**
	 * @param xfusionOrganizationUserMapping
	 *            the xfusionOrganizationUserMapping to set
	 */
	public void setXfusionOrganizationUserMapping(String xfusionOrganizationUserMapping) {
		this.xfusionOrganizationUserMapping = xfusionOrganizationUserMapping;
	}

	/**
	 * @return the oauthRolesGetALlUserApplication
	 */
	public String getOauthRolesGetALlUserApplication() {
		return oauthRolesGetALlUserApplication;
	}

	/**
	 * @param oauthRolesGetALlUserApplication
	 *            the oauthRolesGetALlUserApplication to set
	 */
	public void setOauthRolesGetALlUserApplication(String oauthRolesGetALlUserApplication) {
		this.oauthRolesGetALlUserApplication = oauthRolesGetALlUserApplication;
	}

	/**
	 * @return the oauthUserGetAttribute
	 */
	public String getOauthUserGetAttribute() {
		return oauthUserGetAttribute;
	}

	/**
	 * @param oauthUserGetAttribute
	 *            the oauthUserGetAttribute to set
	 */
	public void setOauthUserGetAttribute(String oauthUserGetAttribute) {
		this.oauthUserGetAttribute = oauthUserGetAttribute;
	}

	/**
	 * @return the oauthUserUpdateLockStatus
	 */
	public String getOauthUserUpdateLockStatus() {
		return oauthUserUpdateLockStatus;
	}

	/**
	 * @param oauthUserUpdateLockStatus
	 *            the oauthUserUpdateLockStatus to set
	 */
	public void setOauthUserUpdateLockStatus(String oauthUserUpdateLockStatus) {
		this.oauthUserUpdateLockStatus = oauthUserUpdateLockStatus;
	}

	/**
	 * @return the oauthApplictionUserRemove
	 */
	public String getOauthApplictionUserRemove() {
		return oauthApplictionUserRemove;
	}

	/**
	 * @param oauthApplictionUserRemove
	 *            the oauthApplictionUserRemove to set
	 */
	public void setOauthApplictionUserRemove(String oauthApplictionUserRemove) {
		this.oauthApplictionUserRemove = oauthApplictionUserRemove;
	}

	/**
	 * @return the oauthUsersGetAllExceptApplication
	 */
	public String getOauthUsersGetAllExceptApplication() {
		return oauthUsersGetAllExceptApplication;
	}

	/**
	 * @param oauthUsersGetAllExceptApplication
	 *            the oauthUsersGetAllExceptApplication to set
	 */
	public void setOauthUsersGetAllExceptApplication(String oauthUsersGetAllExceptApplication) {
		this.oauthUsersGetAllExceptApplication = oauthUsersGetAllExceptApplication;
	}

	/**
	 * @return the oauthUserUpdateAttribute
	 */
	public String getOauthUserUpdateAttribute() {
		return oauthUserUpdateAttribute;
	}

	/**
	 * @param oauthUserUpdateAttribute
	 *            the oauthUserUpdateAttribute to set
	 */
	public void setOauthUserUpdateAttribute(String oauthUserUpdateAttribute) {
		this.oauthUserUpdateAttribute = oauthUserUpdateAttribute;
	}

	/**
	 * @return the oauthApplicationUserAdd
	 */
	public String getOauthApplicationUserAdd() {
		return oauthApplicationUserAdd;
	}

	/**
	 * @param oauthApplicationUserAdd
	 *            the oauthApplicationUserAdd to set
	 */
	public void setOauthApplicationUserAdd(String oauthApplicationUserAdd) {
		this.oauthApplicationUserAdd = oauthApplicationUserAdd;
	}

	/**
	 * @return the oauthUserInactive
	 */
	public String getOauthUserInactive() {
		return oauthUserInactive;
	}

	/**
	 * @param oauthUserInactive
	 *            the oauthUserInactive to set
	 */
	public void setOauthUserInactive(String oauthUserInactive) {
		this.oauthUserInactive = oauthUserInactive;
	}

	/**
	 * @return the oauthCountryGet
	 */
	public String getOauthCountryGet() {
		return oauthCountryGet;
	}

	/**
	 * @param oauthCountryGet
	 *            the oauthCountryGet to set
	 */
	public void setOauthCountryGet(String oauthCountryGet) {
		this.oauthCountryGet = oauthCountryGet;
	}

	/**
	 * @return the oauthCityGet
	 */
	public String getOauthCityGet() {
		return oauthCityGet;
	}

	/**
	 * @param oauthCityGet
	 *            the oauthCityGet to set
	 */
	public void setOauthCityGet(String oauthCityGet) {
		this.oauthCityGet = oauthCityGet;
	}

	/**
	 * @return the oauthStateGet
	 */
	public String getOauthStateGet() {
		return oauthStateGet;
	}

	/**
	 * @param oauthStateGet
	 *            the oauthStateGet to set
	 */
	public void setOauthStateGet(String oauthStateGet) {
		this.oauthStateGet = oauthStateGet;
	}

}
