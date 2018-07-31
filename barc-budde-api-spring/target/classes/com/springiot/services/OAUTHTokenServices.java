/**
 * This package contain the Service class for for OAuthEngine ApI's
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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
import com.springiot.response.DesktopToken;
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
@SuppressWarnings("unchecked")
public class OAUTHTokenServices {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	Environment environment;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * oauthToken() to give authentication and give user_key,user_id,access_key
	 * and access_token in form of responseMessage
	 * 
	 * @param user_name:-
	 *            email id of user
	 * @param password:-
	 *            password of user
	 * @param application_id:-
	 *            application id for which user is logging in
	 * @return responseMessage
	 */

	public Message oauthToken(String user_name, String password, String application_id, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * To get device id from Third Party database with vehicle_id and
			 * vehicle_key to login user
			 */
			Map<String, String> map = new LinkedHashMap<>();
			map.put("user_name", user_name);
			Message checkUserOrg = genericProcess.GenericProcedureCalling("35", map, null, request, response);
			int OrganizationId = 0;
			List<Map<String, Object>> OrganizationIdList = (List<Map<String, Object>>) checkUserOrg.getObject();
			map.remove("user_name");

			if (OrganizationIdList.size() == 0) {
				map.put("message", "User Dosen't Exist.");
				responseMessage.setDescription("Login unsuccess");
				responseMessage.setObject(map);
				responseMessage.setValid(false);
				return responseMessage;
			}

			if (checkUserOrg.isValid()) {
				if (String.valueOf(OrganizationIdList.get(0).get("organization_is_active")).equalsIgnoreCase("false")) {
					map.put("message", "User Organization is Inactive");
					responseMessage.setDescription("User Organization is Inactive");
					responseMessage.setObject(map);
					responseMessage.setValid(false);
					return responseMessage;
				}
				if (OrganizationIdList.size() > 0) {
					OrganizationId = Integer.parseInt(String.valueOf(OrganizationIdList.get(0).get("org_id")));

				}
			}

			// Retrieve from where the request is coming to API
			String RequestType = request.getHeader("User-Agent");
			// System.out.println("type" + RequestType);

			Integer tokenType;
			if (RequestType.contains("okhttp")) {
				tokenType = 1;
			} else {
				tokenType = 0;
			}

			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "user_name=" + user_name.trim() + "&password=" + password.trim()
					+ "&application_id=" + application_id.trim() + "&token_type=" + tokenType;
			/**
			 * Hitting Auth Api to get
			 * Token,Access_key,user_key,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			/**
			 * Print response from OAuth Engine
			 */
			// System.out.println(urlResponseAsObject);

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
				if (genericMessage.isValid()) {
					/**
					 * To get response and set in token class
					 */
					Token token = genericMessage.getObject();

					String status = token.getStatus();

					if (status.equalsIgnoreCase("true")) {
						/*
						 * To Generate Application token to access application
						 * through out
						 */
						String applicaionToken = token.getAccess_token();
						String applicaionuserKey = token.getUser_key();

						/**
						 * To Store application token
						 */
						Constant.addTokon(applicaionuserKey, token);

						/**
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */

						request.setAttribute("token", applicaionToken);
						request.setAttribute("user_key", String.valueOf(token.getUser_key()));
						request.setAttribute("user_id", String.valueOf(token.getUser_id()));
						request.setAttribute("role_id", String.valueOf(token.getRoles_id()));
						request.setAttribute("access_key", String.valueOf(token.getAccess_key()));

						/**
						 * To get device id from Third Party database with // *
						 * vehicle_id and vehicle_key to login user //
						 */
						
						if (checkUserOrg.isValid()) {

							if (OrganizationIdList.size() > 0) {
								OrganizationId = Integer
										.parseInt(String.valueOf(OrganizationIdList.get(0).get("org_id")));

							}
						}
						// System.out.println("OrganizationId " +
						// OrganizationId);
						Constant.addOrgMap(String.valueOf(token.getUser_key()), OrganizationId);

						// System.out
						// .println("---------------" +
						// Constant.orgmap.get(String.valueOf(token.getUser_key())));
						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(token.getAccess_key());
						thirdPartyToken.setAccess_token(applicaionToken);
						thirdPartyToken.setMessage(token.getMessage());
						thirdPartyToken.setUserKey(token.getUser_key());
						thirdPartyToken.setUser_key(token.getUser_key());
						thirdPartyToken.setUser_id(token.getUser_id());
						thirdPartyToken.setRoles_name(token.getRoles_name());
						thirdPartyToken.setRoles_id(token.getRoles_id());
						thirdPartyToken.setStatus(token.getStatus());
						thirdPartyToken.setToken_type(tokenType);
						thirdPartyToken.setLevel(String.valueOf(OrganizationIdList.get(0).get("level")));
						thirdPartyToken.setOrg_id(OrganizationId);
						responseMessage.setDescription(token.getMessage().toString());
						responseMessage.setObject(thirdPartyToken);
						responseMessage.setValid(true);
						return responseMessage;

					} else {
						responseMessage.setDescription(genericMessage.getDescription());
						responseMessage.setObject(genericMessage.getObject());
						responseMessage.setValid(false);
					}
				} else {
					return (Message) urlResponseAsObject;
				}

			} else {
				return (Message) urlResponseAsObject;
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Login unsuccess");
			responseMessage.setValid(false);

			return responseMessage;
		}
		/*
		 * Return the Error responseMessage.
		 */
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
	public Message oauthTokenExpire(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Response Message
		Message responseMessage = new Message();

		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		try {
			// Initializing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : parameterMap.keySet()) {

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", parameterMap.get("user_key"));
					headerMap.put("user_id", parameterMap.get("user_id"));
					// Get the Authorization token
					headerMap.put("token", request.getHeader("token"));
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

			Object urlResponse = urlCalling.getData(urlParameter.getAuthExpireURL(), passingParameter.toString(),
					headerMap);

			// System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

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

	/**
	 * Services for Forgot Password API
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @return response Message
	 */
	public Message forgotPassword(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
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

				if (key.trim().equals("token")) {
					String token = request.getHeader("token");
					/*
					 * to check if token is null
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * to get Oauth token
					 */

					headerMap.put("token", token);
					continue;
				}
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
			HttpServletResponse response) {
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

				if (key.trim().equals("token")) {
					String token = request.getHeader("token");
					/*
					 * to check if token is null
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * to get Oauth token
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					continue;
				}
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
			HttpServletResponse response) {
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

				if (key.trim().equals("token")) {
					String token = request.getHeader("token");
					/*
					 * to check if token is null
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * to get Oauth token
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					headerMap.put("token", token);
					continue;
				}
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

	public Message desktopOauthToken(String user_name, String password, String application_id, String mac_address,
			String ram, String cpu, String ip_address, String os, HttpServletRequest req, HttpServletResponse res) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * Passing parameter
			 */
			Map<String, String> passingMap = new HashMap<>();

			passingMap.put("user_name", user_name);
			passingMap.put("password", password);
			passingMap.put("application_id", application_id);
			passingMap.put("mac_address", mac_address);
			passingMap.put("ram", ram);
			passingMap.put("cpu", cpu);
			passingMap.put("ip_address", ip_address);
			passingMap.put("os", os);

			/**
			 * To check user is validate or not from third party
			 */
			Message checkUserExistence = genericProcess.GenericProcedureCalling("3", passingMap, null, null, null);
			/**
			 * To cast Message into List of Map
			 */
			List<Map<String, String>> getcheckUserExistence = (List<Map<String, String>>) checkUserExistence
					.getObject();
			/**
			 * To check if user is not valid than send error response
			 */

			if (String.valueOf(getcheckUserExistence.get(0).get("is_valid")).equalsIgnoreCase("0")) {
				responseMessage.setDescription(String.valueOf(getcheckUserExistence.get(0).get("msg")));
				responseMessage.setObject(getcheckUserExistence.get(0));
				responseMessage.setValid(false);
				return responseMessage;
			}
			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "user_name=" + getcheckUserExistence.get(0).get("user_name").trim()
					+ "&password=" + password + "&application_id=" + application_id;
			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,user_key,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			System.out.println(urlResponseAsObject);
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

					String status = token.getStatus();

					if (status.equalsIgnoreCase("true")) {
						/*
						 * To Generate Application token to access application
						 * through out
						 */
						String applicaionToken = token.getAccess_token();
						String applicaionuserKey = token.getUser_key();

						/**
						 * To Store application token
						 */
						Constant.addTokon(applicaionuserKey, token);

						/**
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */

						String getPermissionParam = "role_id=" + token.getRoles_id();
						Map<String, String> headerMap = new LinkedHashMap<>();

						// Get the Authorization Engine token
						headerMap.put("token", String.valueOf(token.getAccess_token()));
						headerMap.put("user_key", String.valueOf(token.getUser_key()));
						headerMap.put("user_id", String.valueOf(token.getUser_id()));

						Object accessPermision = urlCalling.getData(urlParameter.getGetAllPermisions(),
								getPermissionParam, headerMap);
						System.out.println("accessPermision " + accessPermision);
						Type accesstype = new TypeToken<GenericMessages<Map<String, Object>>>() {
						}.getType();

						// Convert the response retrieved after calling api is
						// stored //
						// into Map

						Message accessPermisionMessage = (Message) new Gson().fromJson(accessPermision.toString(),
								Message.class);
						List<Map<String, Object>> accessPermisionMessageList = (List<Map<String, Object>>) accessPermisionMessage
								.getObject();
						// System.out.println(Constant.accessmap.get(token.getAccess_key()).toString());
						/**
						 * To set desktop response
						 */
						DesktopToken thirdPartyToken = new DesktopToken();
						thirdPartyToken.setAccess_key(token.getAccess_key());
						thirdPartyToken.setAccess_token(applicaionToken);
						thirdPartyToken.setMessage(token.getMessage());
						thirdPartyToken.setUserKey(token.getUser_key());
						thirdPartyToken.setUser_key(token.getUser_key());
						thirdPartyToken.setUser_id(token.getUser_id());
						thirdPartyToken.setRoles_name(token.getRoles_name());
						thirdPartyToken.setRoles_id(token.getRoles_id());
						thirdPartyToken.setStatus(token.getStatus());
						thirdPartyToken.setToken_type(0);
						thirdPartyToken.setFtp_ip(String.valueOf(getcheckUserExistence.get(0).get("ftp_ip")));
						thirdPartyToken.setFtp_port(String.valueOf(getcheckUserExistence.get(0).get("ftp_port")));
						thirdPartyToken
								.setFtp_user_name(String.valueOf(getcheckUserExistence.get(0).get("ftp_user_name")));
						thirdPartyToken
								.setFtp_user_password(String.valueOf(getcheckUserExistence.get(0).get("ftp_password")));
						thirdPartyToken.setOrg_id(String.valueOf(getcheckUserExistence.get(0).get("org_id")));
						thirdPartyToken
								.setOrg_access_key(String.valueOf(getcheckUserExistence.get(0).get("org_acces_key")));
						thirdPartyToken.setClient_connection_time(
								String.valueOf(getcheckUserExistence.get(0).get("client_connection_time")));

						Message urlMessage = (Message) new Gson().fromJson(urlResponseAsObject.toString(),
								Message.class);
						Map<String, String> finalData = (Map<String, String>) urlMessage.getObject();
						finalData.put("permission", String.valueOf(accessPermisionMessageList));
						// finalData.put("currentTime", String.valueOf(new
						// Date().getTime()));
						finalData.putAll(getcheckUserExistence.get(0));
						List<Object> list = new LinkedList<>();

						Map<String, Object> time = new LinkedHashMap<>();
						time.put("currentTime", new Date().getTime());
						list.add(time);

						responseMessage.setDescription(token.getMessage().toString());
						responseMessage.setObject(finalData);
						responseMessage.setList(list);
						responseMessage.setValid(true);
						return responseMessage;

					} else {
						responseMessage.setDescription(token.getMessage());
						responseMessage.setObject(genericMessage.getObject());
						responseMessage.setValid(false);
						return responseMessage;
					}
				} else {
					responseMessage.setDescription("Login unsuccess");
					responseMessage.setObject(genericMessage);
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
		responseMessage.setDescription("Login unsuccess");
		responseMessage.setValid(false);
		return responseMessage;
	}

	@SuppressWarnings("unused")
	public Message validateToken(Integer tokenType, HttpServletRequest request, HttpServletResponse response) {
		// System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();
		String applicationKey = String.valueOf(environment.getProperty("application.key"));

		Map<String, String> parameterMap = new HashMap<>();

		parameterMap.put("application_key", applicationKey);
		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		// System.out.println("type" + RequestType);

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

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), passingParameter.toString(),
					headerMap);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);
			System.out.println("urlMessage " + urlMessage);
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

	public Message rolesGetAll(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.putAll(map);
			/**
			 * Getting parameter query string to call Platform API
			 */
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(passingMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/**
			 * calling Oauth APi
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getRoleGetAll(), queryString, headerMap);
			/*
			 * Printing response
			 */
			// System.out.println(urlResponseResult);
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
				List<Map<String, Object>> getRolefromFinalList = new LinkedList<>();
				if (urlMessage.isValid()) {

					Message getRolefromDB = genericProcess.GenericProcedureCalling("42", map, null, request, response);
					if (getRolefromDB.isValid()) {

						List<Map<String, Object>> getRolefromDBList = (List<Map<String, Object>>) getRolefromDB
								.getObject();
						List<Map<String, Object>> getRolefromAuthList = (List<Map<String, Object>>) urlMessage
								.getObject();
						// System.out.println("getRolefromDBList : \n " +
						// getRolefromDBList + "getRolefromAuthList : \n "
						// + getRolefromAuthList);
						if (getRolefromDBList.size() > 0 && getRolefromAuthList.size() > 0) {
							// System.out.println("getRolefromDBList.size() " +
							// getRolefromDBList.size()
							// + "getRolefromAuthList" +
							// getRolefromAuthList.size());
							for (Map<String, Object> getRolefromAuthMap : getRolefromAuthList) {
								for (Map<String, Object> getRolefromDBMap : getRolefromDBList) {

									if (String.valueOf(getRolefromDBMap.get("auth_role_id")).replace(".0", "")
											.equalsIgnoreCase(String.valueOf(getRolefromAuthMap.get("roles_id"))
													.replace(".0", ""))
											&& map.get("application_id").replace(".0", "").equalsIgnoreCase(
													String.valueOf(getRolefromAuthMap.get("applications_id"))
															.replace(".0", ""))) {

										getRolefromFinalList.add(getRolefromAuthMap);

									} else if (!map.get("application_id").replace(".0", "").equalsIgnoreCase(String
											.valueOf(getRolefromAuthMap.get("applications_id")).replace(".0", ""))) {
										if (!getRolefromFinalList.contains(getRolefromAuthMap)) {
											getRolefromFinalList.add(getRolefromAuthMap);
										}

									}

								}
							}

						}

						responseMessage.setDescription("Process Success");
						responseMessage.setObject(getRolefromFinalList);
						responseMessage.setValid(true);
						return responseMessage;
						// return getRolefromDB;

					} else {
						responseMessage.setDescription("Process fail");
						responseMessage.setObject(getRolefromDB.getObject());
						responseMessage.setValid(false);
						return responseMessage;
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

}
