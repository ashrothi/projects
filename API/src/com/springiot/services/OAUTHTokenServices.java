/**
 * This package contain the Service class for for OAuthEngine ApI's
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
public class OAUTHTokenServices {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

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
	public Message oauthToken(String user_name, String password, String application_id, int token_type,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {

			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "user_name=" + user_name.trim() + "&password=" + password.trim()
					+ "&application_id=" + application_id.trim() + "&token_type=" + token_type;
			/**
			 * Hitting Auth Api to get
			 * Token,Access_key,UserKey,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			System.out.println("urlResponseAsObject" + urlResponseAsObject);

			/**
			 * Print response from OAuth Engine
			 */

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

						/**
						 * To Store application token
						 */
						Constant.addTokon(applicaionToken, token);

						/**
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */

						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(token.getAccess_key());
						thirdPartyToken.setAccess_token(applicaionToken);
						thirdPartyToken.setMessage(token.getMessage());
						thirdPartyToken.setUser_key(token.getUser_key());
						thirdPartyToken.setUserKey(token.getUser_key());
						thirdPartyToken.setUser_id(token.getUser_id());
						thirdPartyToken.setRoles_name(token.getRoles_name());
						thirdPartyToken.setRoles_id(token.getRoles_id());
						thirdPartyToken.setStatus(token.getStatus());
						thirdPartyToken.setToken_type(token_type);

						responseMessage.setDescription(token.getMessage().toString());
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
						thirdToken.setAccess_key(token.getAccess_key());
						thirdToken.setAccess_token("Please login to get token");
						thirdToken.setMessage(token.getMessage());
						thirdToken.setUser_key(token.getUser_key());
						thirdToken.setUser_id(token.getUser_id());
						thirdToken.setRoles_id(token.getRoles_id());
						thirdToken.setRoles_name(token.getRoles_name());
						thirdToken.setStatus(token.getStatus());
						thirdToken.setToken_type(token_type);
						thirdToken.setUserKey(token.getUser_key());
						responseMessage.setDescription(token.getMessage());
						responseMessage.setObject(thirdToken);
						responseMessage.setValid(false);
						/*
						 * Return the response responseMessage.
						 */
						return responseMessage;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * Return the Error responseMessage.
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
			System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getAuthExpireURL(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			@SuppressWarnings("unchecked")
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

	/**
	 * Services for Forgot Password API
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @param response
	 * @param request
	 * @return response Message
	 */
	public Message forgotPassword(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();
			headerMap.put("user_id", request.getHeader("user_id"));

			for (String key : map.keySet()) {
				/*
				 * to append rest of the parameter
				 */
				if (request.getHeader("user_id").equals("user_id")) {

					headerMap.put("user_id", map.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			passingParameter.delete(0, 1);

			// Calling of OAuth Engine API and get the result in Object
			// urlResponseResult
			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthForgotPasswordURL(),
					passingParameter.toString(), headerMap);

			// Check if response returned from API is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				if (urlMessage.isValid()) {

					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			responseMessage.setDescription(e.getMessage());
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
	 * @param response
	 * @param request
	 * @return:- response Message
	 */
	public Message passwordUpdate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			StringBuilder passingParameter = new StringBuilder();

			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : map.keySet()) {
				// Get the Authorization Engine token
				headerMap.put("token", request.getHeader("token"));
				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", map.get("user_key"));
					headerMap.put("user_id", map.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			passingParameter.delete(0, 1);

			// Get the result of calling OAuth Engine API
			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthUpdateURL(), passingParameter.toString(),
					headerMap);

			// Check if API's response is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					// Set the response Message for the success
					responseMessage.setDescription("Updated Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					// Set the response Message for the failure
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		} catch (Exception e) {
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		// Set the response Message for the failure
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * Service to call API for Password Reset
	 * 
	 * @param passingMap
	 *            :- Contains the parameter
	 * @param response
	 * @param request
	 * @return:- response Message
	 */
	public Message passwordReset(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			StringBuilder passingParameter = new StringBuilder();

			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : map.keySet()) {
				// Get the token for Authorization Engine
				headerMap.put("token", request.getHeader("token"));
				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", map.get("user_key"));
					headerMap.put("user_id", map.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + map.get(key));
				}

			}
			passingParameter.delete(0, 1);

			// Calling of OAuth Engine API
			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthResetPasswordURL(),
					passingParameter.toString(), headerMap);

			// Check the response from API is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					// Set the response Message for the success
					responseMessage.setDescription("Reset Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					// Set the response Message for the failure
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}
			}

		} catch (Exception e) {
			// Set the response Message for the failure
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		// Set the response Message for the failure
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}
}
