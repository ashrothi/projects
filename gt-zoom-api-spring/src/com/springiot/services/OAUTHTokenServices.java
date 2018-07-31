/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.notification.NotificationByFcm;
import com.springiot.response.GenericMessages;
import com.springiot.response.GetTokenResponse;
import com.springiot.response.Message;
import com.springiot.response.Token;

/**
 * 
 * This class work as a Service class for OAUth Engine's API and ThirdParty
 * Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@Transactional
@PropertySource(value = "classpath:/UserCreate.properties")
public class OAUTHTokenServices {
	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;
	// @Autowired
	// private OrganizationService xFusionService;

	/**
	 * oauthToken() is used to give authentication and give
	 * user_key,user_id,access_key and access_token in form of responseMessage
	 * 
	 * @param user_name:-
	 *            email id of user
	 * @param password:-
	 *            password of user
	 * @param application_id:-
	 *            application id for which user is logging in
	 * @return responseMessage
	 */
	@SuppressWarnings("unchecked")
	public Message oauthToken(String user_name, String password, String application_id) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "user_name=" + user_name.trim() + "&password=" + password.trim()
					+ "&application_id=" + String.valueOf(environment.getProperty("application.key"));
			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,user_key,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			// System.out.println("urlResponseAsObject :-" +
			// urlResponseAsObject);
			/**
			 * Print response from OAuth Engine
			 */
			System.out.println("urlResponseAsObject " + urlResponseAsObject);
			if (urlResponseAsObject != null) {
				/*
				 * To get response in Json Format in GetTokenResponse Model
				 * format
				 */

				System.out.println("inside urlResponseAsObject is not null " + urlResponseAsObject);
				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();
				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);
				/**
				 * To check if genericMessage is valid
				 */
				if (genericMessage.isValid()) {/**
												 * To get response and set in
												 * token class
												 */
					System.out.println("inside genericMessage is valid");
					Token token = genericMessage.getObject();

					Map<String, String> passingMap = new LinkedHashMap<>();
					passingMap.put("token", String.valueOf(token.getAccess_token()));
					// System.out.println("**"+String.valueOf(token.getUserKey()));
					passingMap.put("user_key", String.valueOf(token.getUser_key()));
					passingMap.put("user_id", String.valueOf(token.getUser_id()));

					Object urlOrganizationResponseAsObject = urlCalling.getData(urlParameter.getRootOrganization(), "",
							passingMap);

					System.out.println("urlOrganizationResponseAsObject " + urlOrganizationResponseAsObject);
					if (urlOrganizationResponseAsObject != null) {
						Type typeResponse = new TypeToken<GenericMessages<Map<String, Object>>>() {
						}.getType();
						GenericMessages<Map<String, Object>> urlOrganizationMessage = (GenericMessages<Map<String, Object>>) new Gson()
								.fromJson(urlOrganizationResponseAsObject.toString(), typeResponse);
						if (urlOrganizationMessage.isValid()) {
							List<Map<String, Object>> organizationMap = (List<Map<String, Object>>) urlOrganizationMessage
									.getObject();
							System.out.println("organizationMap" + organizationMap);

							Integer organisationId;
							if (organizationMap.size() > 0) {
								organisationId = (int) Double
										.parseDouble(String.valueOf(organizationMap.get(0).get("organization_id")));
							} else {
								organisationId = 0;
							}
							if (token.getUser_key() != null) {
								Constant.addOrganizationId(String.valueOf(token.getUser_key()), organisationId);
							}

							/**
							 * To print json format of token
							 */
							/**
							 * To Check if token has status bit in
							 * urlResponseAsObject
							 */
							if (urlResponseAsObject.toString().contains("status")) {
								/**
								 * To Store application token
								 */
								Constant.addTokon(token.getAccess_token().toString(), token);
								/*
								 * To Store OAuth Token
								 */

								/**
								 * Setting Response For Oauth Engine API Of
								 * ThirdParty Application
								 */

								Token thirdPartyToken = new Token();
								thirdPartyToken.setAccess_key(String.valueOf(token.getAccess_key()));
								thirdPartyToken.setAccess_token(String.valueOf(token.getAccess_token()));
								thirdPartyToken.setMessage(String.valueOf(token.getMessage()));
								thirdPartyToken.setUser_key(String.valueOf(token.getUser_key()));
								thirdPartyToken.setUser_id(String.valueOf(token.getUser_id()));
								thirdPartyToken.setRoles_name(String.valueOf(token.getRoles_name()));
								thirdPartyToken.setRoles_id((token.getRoles_id()));
								thirdPartyToken.setToken_type(token.getToken_type());
								thirdPartyToken.setStatus(String.valueOf(token.getStatus()));
								thirdPartyToken.setOrg_id(organisationId);
								// thirdPartyToken.setLevel(String.valueOf(organizationMap.get(0).get("level")));

								/*
								 * Response Message from API
								 */
								responseMessage.setDescription(String.valueOf(token.getMessage()));
								responseMessage.setObject(thirdPartyToken);
								responseMessage.setValid(true);

								return responseMessage;
							} else {
								/*
								 * If executeQuery object contains the "status"
								 * parameter and initialize the object of class
								 * Token.
								 */

								Token thirdToken = new Token();
								/*
								 * Set the parameter in setter method.
								 */
								thirdToken.setAccess_key(String.valueOf(token.getAccess_key()));
								thirdToken.setAccess_token("Please login to get token");
								thirdToken.setMessage(String.valueOf(token.getMessage()));
								thirdToken.setUser_key(String.valueOf(token.getUser_key()));

								thirdToken.setUser_id(String.valueOf(token.getUser_id()));

								thirdToken.setRoles_name(String.valueOf(token.getRoles_name()));
								thirdToken.setRoles_id((token.getRoles_id()));
								responseMessage.setDescription(token.getMessage());
								// System.out.println("2nd last");
								responseMessage.setObject(thirdToken);
								responseMessage.setValid(
										false);/*
												 * Return the response
												 * responseMessage.
												 */
								return responseMessage;
							}

						}
					} else {
						responseMessage.setDescription(genericMessage.getDescription());
						responseMessage.setObject(genericMessage.getObject());
						responseMessage.setValid(true);

						return responseMessage;
					}
				}

			}

		}

		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {/*
								 * Return the Error responseMessage.
								 */

			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			// responseMessage.setDescription(urlResponseAsObject);
			responseMessage.setValid(false);

			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Login unsuccess");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * oauthTokenExpire To Expire Token for Logout
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @param response
	 * @param request
	 * @return response Message
	 */
	public Message oauthTokenExpire(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * to check if parameters contain token or not
			 */
			if (request.getHeader("token") == null) {
				responseMessage.setDescription("Token field is required.");
				responseMessage.setValid(false);

				return responseMessage;
			}
			/**
			 * To print Oauth token and application token
			 */

			/**
			 * To remove Oauth token and application token
			 */
			Constant.map.remove(request.getHeader("token"));

			/**
			 * Token Expire Message
			 */
			responseMessage.setDescription("Your Token is Expired.");
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			e.getMessage();
			/**
			 * Token Already Expired Message
			 */
			responseMessage.setDescription("Your Token is already Expired." + e.getMessage());
			responseMessage.setValid(false);

			return responseMessage;
		}

	}

	/**
	 * Service For APi To get Oauth token
	 * 
	 * @param passingMap
	 *            :- Contains the parameter
	 * @return:- response Message
	 */
	public Message returnOauthToken(Map<String, String> passingMap) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * To Check if token is null if yes than send error response
			 */
			if (passingMap.get("token") == null) {
				responseMessage.setDescription("Token Expire");
				responseMessage.setValid(false);
				return responseMessage;

			}
			/**
			 * to get OAuth Token
			 */
			Token token = (Token) Constant.map.get(passingMap.get("token").trim());
			/**
			 * to check if token stored is null or not
			 */
			if (token == null) {
				responseMessage.setDescription("Token is Null");
				responseMessage.setValid(false);
				return responseMessage;
			}
			/**
			 * Sending Response
			 */
			responseMessage.setDescription("OAuth Token");
			responseMessage.setObject(token);
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			/**
			 * to print Exception
			 */
			e.printStackTrace();
			responseMessage.setDescription("Token Expire" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * 
	 * This API is used to retrieve the token for security and authentication
	 * for mobile.
	 * 
	 * @param user_name
	 * @param password
	 * @param application_id
	 * @param gcm_id
	 * @param imei
	 * @param package_name
	 * @param gatewayid
	 * @param protocol
	 * @param mac_address
	 * @param bluetooth_address
	 * @param response
	 * @param request
	 * @return Message
	 */
	@SuppressWarnings({ "unchecked" })
	public Message oauthMobileToken(String user_name, String gcm_id, String imei, String package_name,
			String mac_address, String bluetooth_address, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * Passing parameter
			 */
			Map<String, String> passingMap = new HashMap<>();
			passingMap.put("license_key", user_name);
			passingMap.put("imei", imei);
			passingMap.put("gcm_id", gcm_id);
			passingMap.put("mac_address", mac_address);
			passingMap.put("bluetooth_address", bluetooth_address);
			/**
			 * To get device id from Third Party database with vehicle_id and
			 * vehicle_key to login user
			 */
			Message DeviceIdResultMessage = genericProcess.GenericProcedureCalling("26", passingMap, null, null, null);
			/**
			 * To cast Message into List of Map
			 */
			List<Map<String, String>> getDeviceIdResult = (List<Map<String, String>>) DeviceIdResultMessage.getObject();

			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			if (String.valueOf(getDeviceIdResult.get(0).get("license_key_is_deleted")).equalsIgnoreCase("1")) {
				responseMessage.setDescription("License Key does not exist ");
				responseMessage.setValid(false);
				return responseMessage;
			}
			if (String.valueOf(getDeviceIdResult.get(0).get("license_key_is_inactive")).equalsIgnoreCase("1")) {
				responseMessage.setDescription(" License key is not Active");
				responseMessage.setValid(false);
				return responseMessage;
			}

			String passingParameters = "user_name=" + getDeviceIdResult.get(0).get("vehicle_id").trim() + "&password="
					+ String.valueOf(environment.getProperty("driver.password")) + "&application_id="
					+ String.valueOf(environment.getProperty("application.key"));
			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,user_key,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			/**
			 * Print response
			 */

			/**
			 * Checking if response is null
			 */
			if (urlResponseAsObject != null) {
				/**
				 * Casting response in Get Token Response Model Format
				 */
				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();
				/**
				 * To get response in formatted way
				 */
				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);
				/**
				 * To check if response is valid
				 */
				if (genericMessage.isValid()) {

					System.out.println("genericMessage " + genericMessage.getObject());
					/**
					 * To get response and set in token class
					 */
					Token token = genericMessage.getObject();
					Map<String, String> passingOrganiztionMap = new LinkedHashMap<>();
					passingOrganiztionMap.put("token", String.valueOf(token.getAccess_token()));
					passingOrganiztionMap.put("user_key", String.valueOf(token.getUser_key()));
					passingOrganiztionMap.put("user_id", String.valueOf(token.getUser_id()));

					Object urlOrganizationResponseAsObject = urlCalling.getData(urlParameter.getRootOrganization(), "",
							passingOrganiztionMap);

					System.out.println("urlOrganizationResponseAsObject " + urlOrganizationResponseAsObject);
					if (urlOrganizationResponseAsObject != null) {
						Type typeResponse = new TypeToken<GenericMessages<Map<String, Object>>>() {
						}.getType();
						GenericMessages<Map<String, Object>> urlOrganizationMessage = (GenericMessages<Map<String, Object>>) new Gson()
								.fromJson(urlOrganizationResponseAsObject.toString(), typeResponse);
						if (urlOrganizationMessage.isValid()) {
							List<Map<String, Object>> organizationMap = (List<Map<String, Object>>) urlOrganizationMessage
									.getObject();
							System.out.println("organizationMap" + organizationMap);

							Integer organisationId;
							if (organizationMap.size() > 0) {
								organisationId = (int) Double
										.parseDouble(String.valueOf(organizationMap.get(0).get("organization_id")));
							} else {
								organisationId = 0;
							}
							if (token.getUser_key() != null) {
								Constant.addOrganizationId(String.valueOf(token.getUser_key()), organisationId);
							}

							request.setAttribute("org_id",
									String.valueOf(organizationMap.get(0).get("organization_id")));
						}

					}
					/**
					 * To print json format of token
					 */

					/**
					 * To Check if token has status bit in urlResponseAsObject
					 */
					if (urlResponseAsObject.toString().contains("status")) {
						/*
						 * To Generate Application token to access application
						 * through out
						 */
						Constant.addTokon(token.getAccess_token().toString(), token);

						/**
						 * Setting Response For xfusion Paleteform API token Of
						 * ThirdParty Application
						 */
						Map<String, String> headerMap = new LinkedHashMap<>();

						if (String.valueOf(getDeviceIdResult.get(0).get("is_valid")).equalsIgnoreCase("0")) {

							Token tokenXfusion = (Token) Constant.map.get(token.getAccess_token());
							/**
							 * To get the organization of user to map the Device
							 * in that organization
							 */

							headerMap.put("token", tokenXfusion.getAccess_token());
							headerMap.put("user_key", token.getUser_key());
							headerMap.put("user_id", token.getUser_id());
							String passingParameterForOrganizationIdMap = "access_key" + "="
									+ token.getAccess_key().trim();
							Object finalOrganizationResponseMessage = urlCalling.getData(
									urlParameter.getxFusionPlatformOrganizationGetAllUser(),
									passingParameterForOrganizationIdMap, headerMap);
							// System.out.println("finalOrganizationResponseMessage
							// +" + finalOrganizationResponseMessage);
							String device_id = imei.trim() + "_" + user_name.trim();
							/**
							 * To check response from Platform
							 */
							if (finalOrganizationResponseMessage != null) {
								/*
								 * Casting of Response in Generic Message type
								 */
								Type typeResponse = new TypeToken<GenericMessages<Map<String, Object>>>() {
								}.getType();

								System.out.println(
										"finalOrganizationResponseMessage :-" + finalOrganizationResponseMessage);
								GenericMessages<Map<String, Object>> urlOrganizationMessage = (GenericMessages<Map<String, Object>>) new Gson()
										.fromJson(finalOrganizationResponseMessage.toString(), typeResponse);
								/**
								 * Getting Message in List of Map
								 */
								List<Map<String, Object>> deviceOrganizationObject = urlOrganizationMessage.getObject();
								/*
								 * to get all organization_id
								 */
								StringBuilder organizationBuilder = new StringBuilder();
								System.out.println("deviceOrganizationObject	 :-" + deviceOrganizationObject);
								deviceOrganizationObject.forEach((deviceOrganizationObjectMAp) -> {
									organizationBuilder.append(
											deviceOrganizationObjectMAp.get("organization_organization_id") + ",");
								});
								organizationBuilder.deleteCharAt(organizationBuilder.lastIndexOf(","));
								System.out.println("organizationBuilder " + organizationBuilder);
								/**
								 * Passing Parameter for device registration
								 */
								String passingParameterMap = "device_id=" + device_id + "&gateway_id="
										+ String.valueOf(environment.getProperty("device.gateway_id")) + "&protocol="
										+ String.valueOf(environment.getProperty("device.protocol")) + "&";
								/**
								 * Calling Platform api for device registration
								 */
								Object finalVehicleResponseMessage = urlCalling.getData(
										urlParameter.getXfusionPlatformDeviceRegister(), passingParameterMap,
										headerMap);
								/**
								 * To check if response is not null
								 */
								if (finalVehicleResponseMessage != null) {
									/*
									 * Casting of Response in Generic Message
									 * type
									 */

									GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
											.fromJson(finalVehicleResponseMessage.toString(), typeResponse);
									/**
									 * Getting Message in List of Map
									 */
									List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

									/*
									 * To check if device id is not null
									 */
									if (urlMessage.isValid()) {
										/**
										 * Calling Platform api for device
										 * Mapping
										 */
										String passingParameterForDeviceMappingMap = "name=" + device_id
												+ "&alias=Flint" + user_name.trim().trim() + "&ip_address="
												+ request.getRemoteAddr() + "&lattitude=" + "&longitutde="
												+ "&mac_address=" + mac_address.trim() + "&description=" + "&elevation="
												+ "&hardware_version=" + "&software_version=" + "&device_id="
												+ deviceModelObject.get(0).get("id").toString().trim() + "&iccid="
												+ "&imei=" + imei.trim() + "&is_movable"
												+ String.valueOf(environment.getProperty("device.is_movable"))
												+ "&template_id"
												+ String.valueOf(environment.getProperty("device.template.id"))
												+ "&device_country="
												+ String.valueOf(deviceOrganizationObject.get(0).get("country_alias"))
														.trim()
												+ "&device_state="
												+ String.valueOf(deviceOrganizationObject.get(0).get("state_alias"))
														.trim()
												+ "&device_city="
												+ String.valueOf(deviceOrganizationObject.get(0).get("city_alias"))
														.trim()
												+ "&parent_device=" + "&organization_ids="
												+ organizationBuilder.toString().trim() + "&properties_ids="
												+ "&properties_names=" + "&properties_values=" + "&is_configurable"
												+ String.valueOf(environment.getProperty("device.is_configurable"))
												+ "&tags=";
										/**
										 * Calling Platform api for device
										 * mapping
										 */
										Object responseForDeviceMapping = urlCalling.getData(
												urlParameter.getxFusionPlatformDeviceMApping(),
												passingParameterForDeviceMappingMap, headerMap);
										/**
										 * To check if response is not null
										 */
										if (responseForDeviceMapping != null) {
											/*
											 * Casting of Response in Generic
											 * Message type
											 */

											GenericMessages<Map<String, Object>> urlDeviceMappingMessage = (GenericMessages<Map<String, Object>>) new Gson()
													.fromJson(responseForDeviceMapping.toString(), typeResponse);
											/**
											 * Getting Message in List of Map
											 */
											List<Map<String, Object>> deviceMappingObject = urlDeviceMappingMessage
													.getObject();
											// System.out.println("deviceMappingObject:-
											// " + deviceMappingObject);
											/*
											 * To check if device id is not null
											 */
											if (deviceMappingObject != null) {
												/**
												 * Passing parameter map to call
												 * Flint APi to get Fcm id of
												 * Last Active device to disable
												 * it.
												 * 
												 */

												Map<String, String> passingFcmIdMap = new HashMap<>();

												passingFcmIdMap.put("user_Key", token.getUser_key().trim());
												passingFcmIdMap.put("user_ids", token.getUser_id().trim());
												passingFcmIdMap.put("license_key", user_name);
												passingFcmIdMap.put("device_id",
														deviceModelObject.get(0).get("id").toString());

												Message getFcmIdToDisableApp = genericProcess.GenericProcedureCalling(
														"70", passingFcmIdMap, null, null, null);
												/*
												 * To check if response is Valid
												 */
												if (getFcmIdToDisableApp.isValid()) {
													if (getFcmIdToDisableApp.getObject() != null) {

														Boolean status = pushFCMNotificationLogin(
																getFcmIdToDisableApp.getObject());

														/*
														 * To check if
														 * Notification is
														 * successfully sent
														 */
														if (status == true) {

															Map<String, String> passingDeviceMap = new HashMap<>();
															passingDeviceMap.put("license_key", user_name);
															passingDeviceMap.put("device_id",
																	deviceModelObject.get(0).get("id").toString());
															passingDeviceMap.put("imei", imei);
															passingDeviceMap.put("gcm_id", gcm_id);
															passingDeviceMap.put("mac_address", mac_address);
															passingDeviceMap.put("bluetooth_address",
																	bluetooth_address);
															/*
															 * Calling Stored
															 * Procedure to
															 * store detail in
															 * ThirdParty
															 * Database
															 */
															Message registerDeviceInThirdParty = genericProcess
																	.GenericProcedureCalling("25", passingDeviceMap,
																			null, null, null);
															/*
															 * To check if
															 * response is valid
															 */
															if (registerDeviceInThirdParty.isValid()) {
																Token thirdPartyToken = new Token();
																thirdPartyToken.setAccess_key(token.getAccess_key());
																thirdPartyToken
																		.setAccess_token(token.getAccess_token());
																thirdPartyToken.setMessage(token.getMessage());
																thirdPartyToken.setUser_key(token.getUser_key());

																thirdPartyToken.setUser_id(token.getUser_id());

																thirdPartyToken.setRoles_name(token.getRoles_name());
																thirdPartyToken.setRoles_id(token.getRoles_id());
																thirdPartyToken.setDevice_id(String
																		.valueOf(deviceModelObject.get(0).get("id")));
																thirdPartyToken.setRegistration_number(getDeviceIdResult
																		.get(0).get("registration_number").toString());
																/*
																 * Response
																 * Message from
																 * API
																 */
																responseMessage
																		.setDescription(token.getMessage().toString());
																responseMessage.setObject(thirdPartyToken);
																responseMessage.setValid(true);

																return responseMessage;

															} else {
																/*
																 * Response
																 * Message from
																 * API
																 */
																return registerDeviceInThirdParty;
															}
														} else {
															/*
															 * If Notification
															 * Doesn't send than
															 * also gives token
															 */
															Map<String, String> passingDeviceMap = new HashMap<>();
															passingDeviceMap.put("license_key", user_name);
															passingDeviceMap.put("device_id",
																	deviceModelObject.get(0).get("id").toString());
															passingDeviceMap.put("imei", imei);
															passingDeviceMap.put("gcm_id", gcm_id);
															passingDeviceMap.put("mac_address", mac_address);
															passingDeviceMap.put("bluetooth_address",
																	bluetooth_address);
															/*
															 * Calling Stored
															 * Procedure to
															 * store detail in
															 * ThirdParty
															 * Database
															 */
															Message registerDeviceInThirdParty = genericProcess
																	.GenericProcedureCalling("25", passingDeviceMap,
																			null, null, null);
															if (registerDeviceInThirdParty.isValid()) {
																Token thirdPartyToken = new Token();
																thirdPartyToken.setAccess_key(token.getAccess_key());
																thirdPartyToken
																		.setAccess_token(token.getAccess_token());
																thirdPartyToken.setMessage(token.getMessage());
																thirdPartyToken.setUser_key(token.getUser_key());

																thirdPartyToken.setUser_id(token.getUser_id());

																thirdPartyToken.setRoles_name(token.getRoles_name());
																thirdPartyToken.setRoles_id(token.getRoles_id());
																thirdPartyToken.setDevice_id(String
																		.valueOf(deviceModelObject.get(0).get("id")));
																thirdPartyToken.setRegistration_number(getDeviceIdResult
																		.get(0).get("registration_number").toString());
																/*
																 * Response
																 * Message from
																 * API
																 */
																responseMessage
																		.setDescription(token.getMessage().toString());
																responseMessage.setObject(thirdPartyToken);
																responseMessage.setValid(true);

																return responseMessage;

															} else {
																/*
																 * Response
																 * Message from
																 * API
																 */
																return registerDeviceInThirdParty;
															}
														}
													}

												}

											}
										}

									}

								}
							}
						} else {
							/**
							 * If Device is already registered than set Token
							 * and registered it in ThirdParty Database
							 */

							Map<String, String> passingFcmIdMap = new HashMap<>();

							passingFcmIdMap.put("user_key", token.getUser_key().trim());
							passingFcmIdMap.put("user_ids", token.getUser_id().trim());
							passingFcmIdMap.put("license_key", user_name);
							passingFcmIdMap.put("device_id", String.valueOf(getDeviceIdResult.get(0).get("device_id")));

							/**
							 * To get fcm_id of Last active user
							 */
							Message getFcmIdToDisableApp = genericProcess.GenericProcedureCalling("70", passingFcmIdMap,
									null, null, null);
							/*
							 * To check if it is valid
							 */
							if (getFcmIdToDisableApp.isValid()) {
								/**
								 * To check if object is not null
								 */

								List<Map<String, Object>> FcmIdList = (List<Map<String, Object>>) getFcmIdToDisableApp
										.getObject();
								if (FcmIdList.isEmpty()) {
									/**
									 * To push notification
									 */

									Map<String, String> passingDeviceMap = new HashMap<>();
									passingDeviceMap.put("license_key", user_name);
									passingDeviceMap.put("device_id",
											String.valueOf(getDeviceIdResult.get(0).get("device_id")));
									passingDeviceMap.put("imei", imei);
									passingDeviceMap.put("gcm_id", gcm_id);
									passingDeviceMap.put("mac_address", mac_address);
									passingDeviceMap.put("bluetooth_address", bluetooth_address);
									/*
									 * Calling Stored Procedure to store detail
									 * in ThirdParty Database
									 */
									Message registerDeviceInThirdParty = genericProcess.GenericProcedureCalling("25",
											passingDeviceMap, null, null, null);
									if (registerDeviceInThirdParty.isValid()) {
										Token thirdPartyToken = new Token();
										thirdPartyToken.setAccess_key(token.getAccess_key());
										thirdPartyToken.setAccess_token(token.getAccess_token());
										thirdPartyToken.setMessage(token.getMessage());
										thirdPartyToken.setUser_key(token.getUser_key());

										thirdPartyToken.setUser_id(token.getUser_id());

										thirdPartyToken.setRoles_name(token.getRoles_name());
										thirdPartyToken.setRoles_id(token.getRoles_id());
										thirdPartyToken.setDevice_id(
												String.valueOf(getDeviceIdResult.get(0).get("device_id")));
										thirdPartyToken.setRegistration_number(
												getDeviceIdResult.get(0).get("registration_number").toString());
										/*
										 * Response Message from API
										 */
										responseMessage.setDescription(token.getMessage().toString());
										responseMessage.setObject(thirdPartyToken);
										responseMessage.setValid(true);

										return responseMessage;

									} else {
										/*
										 * Response Message from API
										 */
										return registerDeviceInThirdParty;
									}

								} else {

									Boolean status = pushFCMNotificationLogin(getFcmIdToDisableApp.getObject());
									if (status == true) {
										Map<String, String> passingDeviceMap = new HashMap<>();
										passingDeviceMap.put("license_key", user_name);
										passingDeviceMap.put("device_id",
												String.valueOf(getDeviceIdResult.get(0).get("device_id")));
										passingDeviceMap.put("imei", imei);
										passingDeviceMap.put("gcm_id", gcm_id);
										passingDeviceMap.put("mac_address", mac_address);
										passingDeviceMap.put("bluetooth_address", bluetooth_address);
										/*
										 * Calling Stored Procedure to store
										 * detail in ThirdParty Database
										 */
										Message registerDeviceInThirdParty = genericProcess
												.GenericProcedureCalling("25", passingDeviceMap, null, null, null);
										if (registerDeviceInThirdParty.isValid()) {
											Token thirdPartyToken = new Token();
											thirdPartyToken.setAccess_key(token.getAccess_key());
											thirdPartyToken.setAccess_token(token.getAccess_token());
											thirdPartyToken.setMessage(token.getMessage());
											thirdPartyToken.setUser_key(token.getUser_key());

											thirdPartyToken.setUser_id(token.getUser_id());

											thirdPartyToken.setRoles_name(token.getRoles_name());
											thirdPartyToken.setRoles_id(token.getRoles_id());
											thirdPartyToken.setDevice_id(
													String.valueOf(getDeviceIdResult.get(0).get("device_id")));
											thirdPartyToken.setRegistration_number(
													getDeviceIdResult.get(0).get("registration_number").toString());
											/*
											 * Response Message from API
											 */
											responseMessage.setDescription(token.getMessage().toString());
											responseMessage.setObject(thirdPartyToken);
											responseMessage.setValid(true);

											return responseMessage;

										} else {
											/*
											 * Response Message from API
											 */
											return registerDeviceInThirdParty;
										}
									}
								}
							}

						}

					} else {
						/*
						 * If executeQuery object contains the "status"
						 * parameter and initialize the object of class Token.
						 */
						Token thirdToken = new Token();
						/*
						 * Set the parameter in setter method.
						 */
						thirdToken.setAccess_key(token.getAccess_key());
						thirdToken.setAccess_token("Please login to get token");
						thirdToken.setMessage(token.getMessage());
						thirdToken.setUser_key(token.getUser_key());
						thirdToken.setUser_id(token.getUser_id());
						thirdToken.setRoles_id(token.getRoles_id());
						thirdToken.setRoles_name(token.getRoles_name());
						thirdToken.setDevice_id(String.valueOf(getDeviceIdResult.get(0).get("device_id")));
						thirdToken
								.setRegistration_number(getDeviceIdResult.get(0).get("registration_number").toString());

						responseMessage.setDescription(token.getMessage());
						responseMessage.setObject(thirdToken);
						responseMessage.setValid(false);
						return responseMessage;
					}
				}
			}

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/*
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Login unsuccess");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To send Notification
	 * 
	 * @param object
	 * @return
	 */
	private Boolean pushFCMNotificationLogin(Object object) throws Exception {
		try {

			/**
			 * to get responseFromOpenTicket in List<Map<String, Object>> format
			 */
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> responseFcmIdsToDisable = (List<Map<String, Object>>) object;
			/*
			 * to print response
			 */

			if (responseFcmIdsToDisable.size() > 0) {
				/**
				 * to get FCM Id
				 */
				List<Map<String, Object>> responseForFCM = (List<Map<String, Object>>) responseFcmIdsToDisable;
				String fcmID = responseForFCM.get(0).get("gcm_id").toString();

				/**
				 * Calling push Notification Method
				 */
				Map<String, Object> map = new HashMap<>();
				/**
				 * To send it in notification
				 */
				map.put("status", 2);
				NotificationByFcm.pushFCMNotification(fcmID, map);

				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			/*
			 * to catch exception if it comes
			 */
			e.printStackTrace();
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	public Message validateToken(HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();
		Map<String, String> parameterMap = new LinkedHashMap<>();
		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));
		parameterMap.put("application_key", String.valueOf(environment.getProperty("application.key")));
		// Retrieve from where the request is coming to API
		String Type = request.getHeader("User-Agent");
		// System.out.println("type" + Type);
		Integer tokenType;
		if (Type.contains("okhttp")) {
			tokenType = 1;
		} else {
			tokenType = 0;
		}

		parameterMap.put("token_type", tokenType.toString());

		try {
			// Initilaizing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : parameterMap.keySet()) {

				// Get the Authorization token
				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", parameterMap.get("user_key"));
					headerMap.put("user_id", parameterMap.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + parameterMap.get(key));
				}

			}
			passingParameter.delete(0, 1);

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			// System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}
}