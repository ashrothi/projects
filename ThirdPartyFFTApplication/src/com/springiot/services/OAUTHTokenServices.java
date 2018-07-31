/**
 * This package contain the Service class for for OAuthEngine ApI's
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
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

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
					+ "&application_id="+ String.valueOf(environment.getProperty("application.key"));
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
					Token token = genericMessage.getObject();

					Map<String, String> passingMap = new LinkedHashMap<>();
					passingMap.put("token", String.valueOf(token.getAccess_token()));
					passingMap.put("user_key", String.valueOf(token.getUserKey()));
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
							if (token.getUserKey() != null) {
								Constant.addOrganizationId(String.valueOf(token.getUserKey()), organisationId);
							}
						}

					}
					/**
					 * To print json format of token
					 */
					/**
					 * To Check if token has status bit in urlResponseAsObject
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
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */

						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(String.valueOf(token.getAccess_key()));
						thirdPartyToken.setAccess_token(String.valueOf(token.getAccess_token()));
						thirdPartyToken.setMessage(String.valueOf(token.getMessage()));
						thirdPartyToken.setUserKey(String.valueOf(token.getUserKey()));
						thirdPartyToken.setUser_id(String.valueOf(token.getUser_id()));
						thirdPartyToken.setRoles_name(String.valueOf(token.getRoles_name()));
						thirdPartyToken.setRoles_id(String.valueOf(token.getRoles_id()));
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
						 * parameter and initialize the object of class Token.
						 */
						Token thirdToken = new Token();
						/*
						 * Set the parameter in setter method.
						 */
						thirdToken.setAccess_key(String.valueOf(token.getAccess_key()));
						thirdToken.setAccess_token("Please login to get token");
						thirdToken.setMessage(String.valueOf(token.getMessage()));
						thirdToken.setUserKey(String.valueOf(token.getUserKey()));

						thirdToken.setUser_id(String.valueOf(token.getUser_id()));

						thirdToken.setRoles_name(String.valueOf(token.getRoles_name()));
						thirdToken.setRoles_id(String.valueOf(token.getRoles_id()));
						responseMessage.setDescription(token.getMessage());
						responseMessage.setObject(thirdToken);
						responseMessage.setValid(
								false);/*
										 * Return the response responseMessage.
										 */
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
	 * Services for Forgot Password API
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @param request2
	 * @param request
	 * @return response Message
	 */
	public Message forgotPassword(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * to append every parameter in map to passingParameter
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : passingMap.keySet()) {

				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			/*
			 * to Print the parameters
			 */
			passingParameter.deleteCharAt(0);

			/*
			 * Calling the Oauth Engine Forgot Password API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthForgotPasswordURL(),
					passingParameter.toString(), headerMap);
			/**
			 * Printing the response from api
			 */

			/**
			 * Checking the if response is null or not
			 */
			if (urlResponseResult != null) {
				/**
				 * Converting message is json format into Message format
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking message is valid or not
				 */
				if (urlMessage.isValid()) {
					/**
					 * Sending Response of the API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/**
					 * Sending Error response if their is any on OAuthEEngine
					 * API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the exception
			 */
			e.printStackTrace();
			/**
			 * If issue with API than error response
			 */
			responseMessage.setDescription("Process Fail" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * Service To Call the API of Password Update
	 * 
	 * @param passingMap
	 *            :- Contains the parameter
	 * @return:- response Message
	 */
	public Message passwordUpdate(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * to append every parameter in map to passingParameter
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : passingMap.keySet()) {

				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			/*
			 * to Print the parameters
			 */
			passingParameter.deleteCharAt(0);

			/*
			 * Calling the Oauth Engine Update Password API
			 */

			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthUpdateURL(), passingParameter.toString(),
					headerMap);

			/**
			 * Printing the response from api
			 */

			/**
			 * Checking the if response is null or not
			 */
			if (urlResponseResult != null) {
				/**
				 * Converting message is json format into Message format
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking message is valid or not
				 */
				if (urlMessage.isValid()) {
					/**
					 * Sending Response of the API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/**
					 * Sending Error response if their is any on OAuthEEngine
					 * API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the ecxeption
			 */
			e.printStackTrace();
			responseMessage.setDescription("Process Fail" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/**
		 * If issue with API than error response
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * Service to call API for Password Reset
	 * 
	 * @param passingMap
	 *            :- Contains the parameter
	 * @return:- response Message
	 */
	public Message passwordReset(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse httpServletResponse) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * to append every parameter in map to passingParameter
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : passingMap.keySet()) {

				// passingParameter.append("token=" +
				// token.getAccess_token());
				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			/*
			 * to Print the parameters
			 */
			passingParameter.deleteCharAt(0);

			/*
			 * Calling the Oauth Engine Update Password API
			 */

			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthResetPasswordURL(),
					passingParameter.toString(), headerMap);

			/**
			 * Printing the response from api
			 */

			/**
			 * Checking the if response is null or not
			 */
			if (urlResponseResult != null) {
				/**
				 * Converting message is json format into Message format
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/**
				 * Checking message is valid or not
				 */
				if (urlMessage.isValid()) {
					/**
					 * Sending Response of the API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/**
					 * Sending Error response if their is any on OAuthEEngine
					 * API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}

			}

		} catch (Exception e) {
			/**
			 * To print the ecxeption
			 */
			e.printStackTrace();
			responseMessage.setDescription("Process Fail" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/**
		 * If issue with API than error response
		 */
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
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

	@SuppressWarnings("unchecked")
	public Message oauthMobileToken(String user_name, String gcm_id, String imei, String mac_address,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * Passing parameter
			 */
			Map<String, String> passingMap = new HashMap<>();
			passingMap.put("licence_key", user_name);
			passingMap.put("imei", imei);
			passingMap.put("gcm_id", gcm_id);
			passingMap.put("mac_address", mac_address);

			/**
			 * To get device id from Third Party database with vehicle_id and
			 * vehicle_key to login user
			 */
			Message DeviceIdResultMessage = genericProcess.GenericProcedureCalling("1", passingMap, null, null, null);
			/**
			 * To cast Message into List of Map
			 */
			List<Map<String, String>> getDeviceIdResult = (List<Map<String, String>>) DeviceIdResultMessage.getObject();
			System.out.println("getDeviceIdResult :-" + getDeviceIdResult);
			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			if (String.valueOf(getDeviceIdResult.get(0).get("is_active")).equalsIgnoreCase("0")) {
				responseMessage.setDescription("License Key does not belong to User ");
				responseMessage.setValid(false);
				return responseMessage;
			}

			String passingParameters = "user_name=" + getDeviceIdResult.get(0).get("user_name").trim() + "&password="
					+ String.valueOf(environment.getProperty("user.password")) + "&application_id="
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
					passingOrganiztionMap.put("user_key", String.valueOf(token.getUserKey()));
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
							if (token.getUserKey() != null) {
								Constant.addOrganizationId(String.valueOf(token.getUserKey()), organisationId);
							}
						}

					}
					/**
					 * To print json format of token
					 */

					/**
					 * To Check if token has status bit in urlResponseAsObject
					 */
					if (urlResponseAsObject.toString().contains("status")) {

						Constant.addTokon(token.getAccess_token().toString(), token);
						/**
						 * To Get Platform Token and validate user through
						 * Plateform
						 */

						Map<String, String> headerMap = new LinkedHashMap<>();

						if (String.valueOf(getDeviceIdResult.get(0).get("device_id")).equalsIgnoreCase("0")) {

							Token tokenXfusion = (Token) Constant.map.get(token.getAccess_token());
							/**
							 * To get the organization of user to map the Device
							 * in that organization
							 */

							headerMap.put("token", tokenXfusion.getAccess_token());
							headerMap.put("user_key", token.getUserKey());
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
										+ String.valueOf(environment.getProperty("device.protocol"));
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
												+ String.valueOf(environment.getProperty("device.template_id"))
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

												/*
												 * If Notification Doesn't send
												 * than also gives token
												 */
												Map<String, String> passingDeviceMap = new HashMap<>();
												passingDeviceMap.put("licence_key", user_name);
												passingDeviceMap.put("device_id",
														deviceModelObject.get(0).get("id").toString());
												passingDeviceMap.put("imei", imei);
												passingDeviceMap.put("gcm_id", gcm_id);

												/*
												 * Calling Stored Procedure to
												 * store detail in ThirdParty
												 * Database
												 */
												Message registerDeviceInThirdParty = genericProcess
														.GenericProcedureCalling("2", passingDeviceMap, null, null,
																null);
												if (registerDeviceInThirdParty.isValid()) {
													Token thirdPartyToken = new Token();
													thirdPartyToken.setAccess_key(token.getAccess_key());
													thirdPartyToken.setAccess_token(token.getAccess_token());
													thirdPartyToken.setMessage(token.getMessage());
													thirdPartyToken.setUserKey(token.getUserKey());

													thirdPartyToken.setUser_id(token.getUser_id());

													thirdPartyToken.setRoles_name(token.getRoles_name());
													thirdPartyToken.setRoles_id(token.getRoles_id());
													thirdPartyToken.setDevice_id(
															String.valueOf(deviceModelObject.get(0).get("id")));
													thirdPartyToken.setRegistration_number(
															getDeviceIdResult.get(0).get("user_name").toString());
													/*
													 * Response Message from API
													 */
													responseMessage.setDescription(token.getMessage().toString());
													responseMessage.setObject(thirdPartyToken);
													responseMessage.setValid(true);

													return responseMessage;

												}

											}
										}

									}

								}
							}
						} else {
							/*
							 * If Notification Doesn't send than also gives
							 * token
							 */
							Map<String, String> passingDeviceMap = new HashMap<>();
							passingDeviceMap.put("licence_key", user_name);
							passingDeviceMap.put("device_id",
									String.valueOf(getDeviceIdResult.get(0).get("device_id")));
							passingDeviceMap.put("imei", imei);
							passingDeviceMap.put("gcm_id", gcm_id);

							/*
							 * Calling Stored Procedure to store detail in
							 * ThirdParty Database
							 */

							Message registerDeviceInThirdParty = genericProcess.GenericProcedureCalling("2",
									passingDeviceMap, null, null, null);
							if (registerDeviceInThirdParty.isValid()) {
								Token thirdPartyToken = new Token();
								thirdPartyToken.setAccess_key(token.getAccess_key());
								thirdPartyToken.setAccess_token(token.getAccess_token());
								thirdPartyToken.setMessage(token.getMessage());
								thirdPartyToken.setUserKey(token.getUserKey());

								thirdPartyToken.setUser_id(token.getUser_id());

								thirdPartyToken.setRoles_name(token.getRoles_name());
								thirdPartyToken.setRoles_id(token.getRoles_id());
								thirdPartyToken.setDevice_id(String.valueOf(getDeviceIdResult.get(0).get("device_id")));
								thirdPartyToken
										.setRegistration_number(getDeviceIdResult.get(0).get("user_name").toString());
								/*
								 * Response Message from API
								 */
								responseMessage.setDescription(token.getMessage().toString());
								responseMessage.setObject(thirdPartyToken);
								responseMessage.setValid(true);

								return responseMessage;
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
						thirdToken.setUserKey(token.getUserKey());

						thirdToken.setUser_id(token.getUser_id());

						thirdToken.setRoles_id(token.getRoles_id());
						thirdToken.setRoles_name(token.getRoles_name());
						thirdToken.setDevice_id(String.valueOf(getDeviceIdResult.get(0).get("device_id")));
						thirdToken.setRegistration_number(getDeviceIdResult.get(0).get("user_name").toString());

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

	@SuppressWarnings("unchecked")
	public Message validateToken(Map<String, String> parameterMap, Integer token_type, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();

		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		System.out.println("type" + RequestType);

		parameterMap.put("token_type", token_type.toString());

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
			System.out.println("passingParameter" + passingParameter);

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
