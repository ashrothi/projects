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
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private XFusionService xFusionService;

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
			Integer organisationId = 0;
			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "user_name=" + user_name.trim() + "&password=" + password.trim()
					+ "&application_id=" + String.valueOf(environment.getProperty("application.key"));
			/**
			 * Hitting Authorization API to get Token,Access_key,user_key,Expires_in,User_id
			 * as Response
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
				 * To get response in Json Format in GetTokenResponse Model format
				 */

				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();
				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);
				/**
				 * To check if genericMessage is valid
				 */
				if (genericMessage.isValid()) {/**
												 * To get response and set in token class
												 */
					Token token = genericMessage.getObject();

					Map<String, String> passingMap = new LinkedHashMap<>();
					passingMap.put("token", String.valueOf(token.getAccess_token()));
					passingMap.put("user_key", String.valueOf(token.getUser_key()));
					passingMap.put("user_id", String.valueOf(token.getUser_id()));

					Object urlOrganizationResponseAsObject = urlCalling
							.getData(urlParameter.getXfusionOrganizationGetAll(), "", passingMap);

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

							if (organizationMap.size() > 0) {
								organisationId = (int) Double.parseDouble(
										String.valueOf(organizationMap.get(0).get("organization_organization_id")));
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
						 * Setting Response For Oauth Engine API Of ThirdParty Application
						 */

						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(String.valueOf(token.getAccess_key()));
						thirdPartyToken.setAccess_token(String.valueOf(token.getAccess_token()));
						thirdPartyToken.setMessage(String.valueOf(token.getMessage()));
						thirdPartyToken.setUserKey(String.valueOf(token.getUser_key()));
						thirdPartyToken.setUser_key(String.valueOf(token.getUser_key()));
						thirdPartyToken.setUser_id(String.valueOf(token.getUser_id()));
						thirdPartyToken.setRoles_name(String.valueOf(token.getRoles_name()));
						thirdPartyToken.setRoles_id(String.valueOf(token.getRoles_id()));
						thirdPartyToken.setOrganization_id(String.valueOf(organisationId));
						;
						/*
						 * Response Message from API
						 */
						responseMessage.setDescription(String.valueOf(token.getMessage()));
						responseMessage.setObject(thirdPartyToken);
						responseMessage.setValid(true);

						return responseMessage;
					} else {
						/*
						 * If executeQuery object contains the "status" parameter and initialize the
						 * object of class Token.
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
						thirdToken.setOrganization_id(String.valueOf(organisationId));
						responseMessage.setDescription(token.getMessage());
						responseMessage.setObject(thirdToken);
						responseMessage.setValid(false);/*
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
					 * Sending Error response if their is any on OAuthEEngine API
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
					 * Sending Error response if their is any on OAuthEEngine API
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
					 * Sending Error response if their is any on OAuthEEngine API
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

	/**
	 * 
	 * This API is used to retrieve the token for security and authentication for
	 * mobile.
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
			Integer organisationId = 0;
			Map<String, String> passingMap = new HashMap<>();
			passingMap.put("license_key", user_name);
			passingMap.put("imei", imei);
			passingMap.put("gcm_id", gcm_id);
			passingMap.put("mac_address", mac_address);
			passingMap.put("bluetooth_address", bluetooth_address);
			/**
			 * To get device id from Third Party database with vehicle_id and vehicle_key to
			 * login user
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
			// if
			// (String.valueOf(getDeviceIdResult.get(0).get("license_key_is_inactive")).equalsIgnoreCase("1"))
			// {
			// responseMessage.setDescription(" License key is not Active");
			// responseMessage.setValid(false);
			// return responseMessage;
			// }

			String passingParameters = "user_name=" + getDeviceIdResult.get(0).get("driver_id").trim() + "&password="
					+ String.valueOf(environment.getProperty("driver.password")) + "&application_id="
					+ String.valueOf(environment.getProperty("application.key"));
			/**
			 * Hitting Authorization API to get Token,Access_key,user_key,Expires_in,User_id
			 * as Response
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

					Object urlOrganizationResponseAsObject = urlCalling
							.getData(urlParameter.getXfusionOrganizationGetAll(), "", passingOrganiztionMap);

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

							if (organizationMap.size() > 0) {
								organisationId = (int) Double
										.parseDouble(String.valueOf(organizationMap.get(0).get("organization_organization_id")));
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
						/*
						 * To Generate Application token to access application through out
						 */
						Constant.addTokon(token.getAccess_token().toString(), token);

						/**
						 * If Device is already registered than set Token and registered it in
						 * ThirdParty Database
						 */

						Map<String, String> passingFcmIdMap = new HashMap<>();

						passingFcmIdMap.put("user_Key", String.valueOf(token.getUser_key()).trim());
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
								 * Calling Stored Procedure to store detail in ThirdParty Database
								 */
								Message registerDeviceInThirdParty = genericProcess.GenericProcedureCalling("25",
										passingDeviceMap, null, null, null);
								if (registerDeviceInThirdParty.isValid()) {
									Token thirdPartyToken = new Token();
									thirdPartyToken.setAccess_key(token.getAccess_key());
									thirdPartyToken.setAccess_token(token.getAccess_token());
									thirdPartyToken.setMessage(token.getMessage());
									thirdPartyToken.setUserKey(String.valueOf(token.getUser_key()));
									thirdPartyToken.setUser_key(String.valueOf(token.getUser_key()));
									thirdPartyToken.setUser_id(token.getUser_id());

									thirdPartyToken.setRoles_name(token.getRoles_name());
									thirdPartyToken.setRoles_id(token.getRoles_id());
									thirdPartyToken
											.setDevice_id(String.valueOf(getDeviceIdResult.get(0).get("device_id")));
									thirdPartyToken.setRegistration_number(
											String.valueOf(getDeviceIdResult.get(0).get("registration_number")));
									thirdPartyToken.setOrganization_id(String.valueOf(organisationId));
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
									 * Calling Stored Procedure to store detail in ThirdParty Database
									 */
									Message registerDeviceInThirdParty = genericProcess.GenericProcedureCalling("25",
											passingDeviceMap, null, null, null);
									if (registerDeviceInThirdParty.isValid()) {
										Token thirdPartyToken = new Token();
										thirdPartyToken.setAccess_key(token.getAccess_key());
										thirdPartyToken.setAccess_token(token.getAccess_token());
										thirdPartyToken.setMessage(token.getMessage());
										thirdPartyToken.setUserKey(String.valueOf(token.getUser_key()));
										thirdPartyToken.setUser_key(String.valueOf(token.getUser_key()));

										thirdPartyToken.setUser_id(token.getUser_id());

										thirdPartyToken.setRoles_name(token.getRoles_name());
										thirdPartyToken.setRoles_id(token.getRoles_id());
										thirdPartyToken.setDevice_id(
												String.valueOf(getDeviceIdResult.get(0).get("device_id")));
										thirdPartyToken.setRegistration_number(
												String.valueOf(getDeviceIdResult.get(0).get("registration_number")));
										thirdPartyToken.setOrganization_id(String.valueOf(organisationId));
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

					} else {
						/*
						 * If executeQuery object contains the "status" parameter and initialize the
						 * object of class Token.
						 */
						Token thirdToken = new Token();
						/*
						 * Set the parameter in setter method.
						 */
						thirdToken.setAccess_key(token.getAccess_key());
						thirdToken.setAccess_token("Please login to get token");
						thirdToken.setMessage(token.getMessage());
						thirdToken.setUserKey(String.valueOf(token.getUser_key()));
						thirdToken.setUser_key(String.valueOf(token.getUser_key()));
						thirdToken.setUser_id(token.getUser_id());
						thirdToken.setRoles_id(token.getRoles_id());
						thirdToken.setRoles_name(token.getRoles_name());
						thirdToken.setDevice_id(String.valueOf(getDeviceIdResult.get(0).get("device_id")));
						thirdToken
								.setRegistration_number(getDeviceIdResult.get(0).get("registration_number").toString());
						thirdToken.setOrganization_id(String.valueOf(organisationId));
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

	/**
	 * Service to Returns all the user and their details from all the application in
	 * which given user is present
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message UserGetALL(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("applicationid", map.get("applicationid"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserGetAll(), passingParameter.toString(),
					headerMap);

			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					List<Map<String, Object>> userOauthList = (List<Map<String, Object>>) urlMessage.getObject();
					System.out.println("userOauthList:- " + userOauthList);
					/*
					 * Response Message from API
					 */
					Message responseUserListMessage = xFusionService.xfusionGetUserList(map, request, response);
					System.out.println("responseUserListMessage:- " + responseUserListMessage.getObject());

					Map<String, Object> userMap = (Map<String, Object>) responseUserListMessage.getObject();
					List<Map<String, Object>> userList = (List<Map<String, Object>>) userMap.get("operational");

					if (userList.size() > 0) {
						for (Map<String, Object> map2 : userOauthList) {
							map2.put("user_id_id", map2.get("users_id"));
							for (Map<String, Object> mapuserList : userList) {
								if (map2.get("membership_email").toString()
										.equalsIgnoreCase(mapuserList.get("users_id").toString())) {
									map2.putAll(mapuserList);
								}

							}

						}
					}

					responseMessage.setDescription("Process Sucess");
					responseMessage.setObject(userOauthList);
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * Service To Create User
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message UserCreate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			passingMap.put("username", map.get("email"));
			passingMap.put("password", map.get("password"));
			passingMap.put("password_question", map.get("password_question"));
			passingMap.put("password_answer", map.get("password_answer"));
			passingMap.put("is_approved", map.get("is_approved"));
			passingMap.put("application_id", map.get("application_id"));
			passingMap.put("role_id", map.get("role_id"));
			passingMap.put("first_name", map.get("first_name"));
			passingMap.put("last_name", map.get("last_name"));
			passingMap.put("country", map.get("country"));
			passingMap.put("state", map.get("state"));
			passingMap.put("city", map.get("city"));
			passingMap.put("preferred_number", map.get("preferred_number"));
			passingMap.put("phone_numbers", map.get("phone_numbers"));
			passingMap.put("address", map.get("address"));
			passingMap.put("creation_date", map.get("creation_date"));
			passingMap.put("is_permanent_address", map.get("is_permanent_address"));
			passingMap.put("image_path", map.get("image_path"));
			passingMap.put("thumbail_image_path", map.get("thumbail_image_path"));
			passingMap.put("csv_attributes_id", map.get("csv_attributes_id"));
			passingMap.put("csv_attributes_alias", map.get("csv_attributes_alias"));
			passingMap.put("csv_attributes_value", map.get("csv_attributes_value"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserCreate(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */
			System.out.println("Vehicle created +++++++++" + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				// System.out.println("urlMessage:-" + urlMessage);
				if (urlMessage.isValid()) {
					List<Map<String, Object>> createUserResponse = (List<Map<String, Object>>) urlMessage.getObject();
					/*
					 * Response Message from API
					 */

					System.out.println("createUserResponse:- " + createUserResponse);
					if (createUserResponse.get(0).containsKey("isUserCreated")) {
						StringBuilder passingNewParameter = new StringBuilder();
						Map<String, String> passingNewMap = new LinkedHashMap<>();
						// passingNewMap.put("token", request.getHeader("token"));
						passingNewMap.put("user_key", request.getHeader("user_key"));
						passingNewMap.put("user_id", request.getHeader("user_id"));
						passingNewMap.put("insert_userKey", String.valueOf(createUserResponse.get(0).get("userKey")));
						passingNewMap.put("insert_user_id", String.valueOf(createUserResponse.get(0).get("user_id")));
						passingNewMap.put("organization_ids", String.valueOf(map.get("organization_id")));
						/**
						 * To create Query String to call Platform API
						 */

						for (String key : passingNewMap.keySet()) {

							passingNewParameter.append("&" + key + "=" + passingNewMap.get(key));
						}

						/*
						 * To Print Passing Parameter query string
						 */

						/**
						 * calling Platform APi
						 */
						Object finalVehicleResponseMessage = urlCalling.getData(
								urlParameter.getXfusionOrganizationUserMapping(), passingNewParameter.toString(),
								headerMap);
						/*
						 * To Print response from platform
						 */
						System.out.println("finalVehicleResponseMessage" + finalVehicleResponseMessage);
						/*
						 * To Check if response is not null
						 */
						if (finalVehicleResponseMessage != null) {
							/*
							 * To Cast response in Generic Message Format
							 */
							Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
							}.getType();
							/**
							 * Getting Response in formatted way
							 */
							GenericMessages<Map<String, Object>> urlMessageFinal = (GenericMessages<Map<String, Object>>) new Gson()
									.fromJson(finalVehicleResponseMessage.toString(), type);
							/**
							 * Getting response in List of Map
							 */
							List<Map<String, Object>> deviceModelObject = urlMessageFinal.getObject();
							/*
							 * To Print Response
							 */

							/*
							 * Check if response is not null
							 */
							if (deviceModelObject != null) {
								/*
								 * Response Message from API
								 */
								responseMessage.setDescription("Process Success User Created Successfully");
								responseMessage.setObject(createUserResponse);
								responseMessage.setValid(true);

								return responseMessage;
							}
						}
					} else {
						return urlMessage;
					}

				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To update basic information of user.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message UserUpdate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize parameter query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("email", map.get("email"));
			passingMap.put("first_name", map.get("first_name"));
			passingMap.put("last_name", map.get("last_name"));
			passingMap.put("country", map.get("country"));
			passingMap.put("state", map.get("state"));
			passingMap.put("city", map.get("city"));
			passingMap.put("preferred_number", map.get("preferred_number"));
			passingMap.put("phone_numbers", map.get("phone_numbers"));
			passingMap.put("address", map.get("address"));
			passingMap.put("is_anonymous", map.get("is_anonymous"));
			passingMap.put("is_deleted", map.get("is_deleted"));
			passingMap.put("last_activity_date", map.get("last_activity_date"));
			passingMap.put("is_permanent_address", map.get("is_permanent_address"));
			passingMap.put("image_path", map.get("image_path"));
			passingMap.put("thumbail_image_path", map.get("thumbail_image_path"));
			/**
			 * To create Query String to call OAuth API
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : passingMap.keySet()) {

				/*
				 * to get Oauth token
				 */
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserUpdate(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */

			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				// System.out.println("urlResponseResult:-" +
				// urlResponseResult);
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("User Updated Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To delete the user.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message UserDelete(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("delete_user_id", map.get("delete_user_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserDelete(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success User Deleted Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message RoleGetAll(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserRoleGetAll(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message AttributeGetByRole(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("role_id", map.get("role_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getAttributeGetAllByUser(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {

					// Response Message from API

					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {

					// Response Message from API

					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthGetAllUserApplication(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			/**
			 * To get rest parameter from map
			 */
			for (String key : map.keySet()) {
				passingMap.put(key, map.get(key));
			}
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthRolesGetALlUserApplication(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {

					// Response Message from API

					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {

					// Response Message from API

					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserGetAttribute(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("role_id", map.get("role_id"));
			passingMap.put("member_user_key", map.get("member_user_key"));
			passingMap.put("member_user_id", map.get("member_user_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUserGetAttribute(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserUpdateLockStatus(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize parameter query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("edit_user_id", map.get("edit_user_id"));
			passingMap.put("lock_status", map.get("lock_status"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUserUpdateLockStatus(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthApplicationUserRemove(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize parameter query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("edit_user_id", map.get("edit_user_id"));
			passingMap.put("edit_role_id", map.get("edit_role_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthApplictionUserRemove(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserGetAllExceptApplication(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("application_id", map.get("application_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUsersGetAllExceptApplication(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserUpdateAttribute(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("member_user_key", map.get("member_user_key"));
			passingMap.put("member_user_id", map.get("member_user_id"));
			passingMap.put("role_id", map.get("role_id"));
			passingMap.put("attribute_id", map.get("attribute_id"));
			passingMap.put("attribute_value", map.get("attribute_value"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUserUpdateAttribute(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserAdd(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {/*
				 * Initialize parameter query string
				 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("edit_user_id", map.get("edit_user_id"));
			passingMap.put("edit_role_id", map.get("edit_role_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthApplicationUserAdd(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthUserInactive(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("inactive_user_id", map.get("inactive_user_id"));
			passingMap.put("isactive_status", map.get("isactive_status"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUserInactive(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get coutries.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message countryGet(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));

			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthCountryGet(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get state by country id.
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message stateGetByCountryId(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("country_id", map.get("country_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthStateGet(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get city by state id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	public Message cityGetBystateId(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("state_id", map.get("state_id"));
			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthCityGet(), passingParameter.toString(),
					headerMap);
			/*
			 * Printing response
			 */

			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * This API will helps to update basic information of user..
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * 
	 */
	public Message userUpdateRoleId(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize parameter query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("edit_user_id", map.get("edit_user_id"));
			passingMap.put("email", map.get("email"));
			passingMap.put("role_id", map.get("role_id"));
			passingMap.put("csv_attributes_id", map.get("csv_attributes_id"));
			passingMap.put("csv_attributes_alias", map.get("csv_attributes_alias"));
			passingMap.put("csv_attributes_value", map.get("csv_attributes_value"));

			/**
			 * To create Query String to call OAuth API
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

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getOauthUserUpdate(),
					passingParameter.toString(), headerMap);
			/*
			 * Printing response
			 */
			// System.out.println("urlResponseResult:-" + urlResponseResult);
			/*
			 * Checking if response is not null
			 */
			if (urlResponseResult != null) {
				/*
				 * Casting response in Message type
				 */
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				/*
				 * Checking if response is valid or not
				 */
				if (urlMessage.isValid()) {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					/*
					 * Response Message from API
					 */
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
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
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	@SuppressWarnings("unchecked")
	public Message validateToken(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();

		// // Remove access key from the map.
		// parameterMap.remove("access_key");
		//
		Integer organisationId = 0;
		Map<String, String> parameterMap = new LinkedHashMap<>();
		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API

		String Type = request.getHeader("User-Agent");

		Integer tokenType;
		if (Type.contains("okhttp")) {
			tokenType = 1;
		} else {
			tokenType = 0;
		}

		try {
			// Initilaizing the String Builder
			String passingParameter = "application_key=" + String.valueOf(environment.getProperty("application.key"))
					+ "&token_type=" + String.valueOf(tokenType);

			/*
			 * Calling of Authorization Engine API and retrieve the results in Object
			 * urlResponseResult
			 */
			// System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), passingParameter.toString(),
					parameterMap);

			Message OauthResponse = new Gson().fromJson(urlResponse.toString(), Message.class);

			List<Map<String, String>> OauthResponseList = (List<Map<String, String>>) OauthResponse.getObject();
			Token token = new Token();
			token.setAccess_token(OauthResponseList.get(0).get("access_token"));
			token.setAccess_key(String.valueOf(OauthResponseList.get(0).get("access_key")));
			token.setMessage(String.valueOf(OauthResponseList.get(0).get("access_token")));
			token.setUserKey(String.valueOf(OauthResponseList.get(0).get("user_key")));
			token.setUser_key(String.valueOf(OauthResponseList.get(0).get("access_token")));
			token.setUser_id(String.valueOf(OauthResponseList.get(0).get("user_id")));
			token.setRoles_name(String.valueOf(OauthResponseList.get(0).get("roles_name")));
			token.setRoles_id(String.valueOf(OauthResponseList.get(0).get("roles_id")));

			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", String.valueOf(OauthResponseList.get(0).get("access_token")));
			passingMap.put("user_key", String.valueOf(OauthResponseList.get(0).get("user_key")));
			passingMap.put("user_id", String.valueOf(OauthResponseList.get(0).get("user_id")));

			Object urlOrganizationResponseAsObject = urlCalling.getData(urlParameter.getXfusionOrganizationGetAll(), "",
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

					if (organizationMap.size() > 0) {
						organisationId = (int) Double.parseDouble(
								String.valueOf(organizationMap.get(0).get("organization_organization_id")));
					} else {
						organisationId = 0;
					}
					if (OauthResponseList.get(0).get("user_key") != null) {
						Constant.addOrganizationId(String.valueOf(OauthResponseList.get(0).get("user_key")),
								organisationId);
					}
				}

			}
			/**
			 * To print json format of token
			 */
			/**
			 * To Check if token has status bit in urlResponseAsObject
			 */
			if (urlResponse.toString().contains("status")) {
				/**
				 * To Store application token
				 */
				Constant.addTokon(token.getAccess_token().toString(), token);
				/*
				 * To Store OAuth Token
				 */

				/**
				 * Setting Response For Oauth Engine API Of ThirdParty Application
				 */

				Token thirdPartyToken = new Token();
				thirdPartyToken.setAccess_key(String.valueOf(token.getAccess_key()));
				thirdPartyToken.setAccess_token(String.valueOf(token.getAccess_token()));
				thirdPartyToken.setMessage(String.valueOf(token.getMessage()));
				thirdPartyToken.setUserKey(String.valueOf(token.getUser_key()));
				thirdPartyToken.setUser_key(String.valueOf(token.getUser_key()));
				thirdPartyToken.setUser_id(String.valueOf(token.getUser_id()));
				thirdPartyToken.setRoles_name(String.valueOf(token.getRoles_name()));
				thirdPartyToken.setRoles_id(String.valueOf(token.getRoles_id()));
				thirdPartyToken.setOrganization_id(String.valueOf(organisationId));
				;
				/*
				 * Response Message from API
				 */
				responseMessage.setDescription(String.valueOf(token.getMessage()));
				responseMessage.setObject(thirdPartyToken);
				responseMessage.setValid(true);

				return responseMessage;
			} else {
				/*
				 * If executeQuery object contains the "status" parameter and initialize the
				 * object of class Token.
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
				thirdToken.setOrganization_id(String.valueOf(organisationId));
				responseMessage.setDescription(token.getMessage());
				responseMessage.setObject(thirdToken);
				responseMessage.setValid(false);/*
												 * Return the response responseMessage.
												 */
				return responseMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();

			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}
}