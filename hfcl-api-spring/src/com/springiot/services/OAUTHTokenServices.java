/**
 * This package contain the Service class for All Third Party Application for Flint
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
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
public class OAUTHTokenServices {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	/**
	 * oauthToken() is used to give authentication and give
	 * userKey,user_id,access_key and access_token in form of responseMessage
	 * 
	 * @param username:-
	 *            email id of user
	 * @param password:-
	 *            password of user
	 * @param applicationid:-
	 *            application id for which user is logging in
	 * @return responseMessage
	 */
	public Message oauthToken(String username, String password, String applicationid) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * Passing Query string Parameter to call OAuthEngine API
			 */
			String passingParameters = "username=" + username.trim() + "&password=" + password.trim()
					+ "&applicationid=" + applicationid.trim();
			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,UserKey,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters, null);
			/**
			 * Print response from OAuth Engine
			 */
//			System.out.println(urlResponseAsObject);

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
					/**
					 * To print json format of token
					 */
//					System.out.println(new Gson()
//							.toJson(token));
					/**
											 * To Check if token has status bit
											 * in urlResponseAsObject
											 */
					if (!urlResponseAsObject.toString().contains(
							"status")) {/*
										 * To Generate Application token to
										 * access application through out
										 */
						String applicaionToken = Constant.genrateToken().toString();
						/**
						 * To Store application token
						 */
						Constant.addTokon(applicaionToken,
								token);/*
										 * To Store OAuth Token
										 */
						Constant.addAOuthTokon(applicaionToken,
								token);/**
										 * To Get Platform Token and validate
										 * user through Plateform
										 */
						validateXfusionPlateForm(applicaionToken, token);
						/**
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */

						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(token.getAccess_key());
						thirdPartyToken.setAccess_token(applicaionToken);
						thirdPartyToken.setMessage(token.getMessage());
						thirdPartyToken.setUserKey(token.getUserKey());
						thirdPartyToken.setExpires_in(token.getExpires_in());
						thirdPartyToken.setUser_id(token.getUser_id());
						thirdPartyToken.setLast_password_change_date(token.getLast_password_change_date());
						thirdPartyToken.setLast_login_date(token.getLast_login_date());
						thirdPartyToken.setLast_activity_date(token.getLast_activity_date());
						thirdPartyToken.setRoles_name(token.getRoles_name());
						thirdPartyToken.setRoles_id(token.getRoles_id());

						/*
						 * Response Message from API
						 */
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
						thirdToken.setUserKey(token.getUserKey());
						thirdToken.setExpires_in(token.getExpires_in());
						thirdToken.setUser_id(token.getUser_id());
						thirdToken.setLast_activity_date(token.getLast_activity_date());
						thirdToken.setLast_password_change_date(token.getLast_password_change_date());
						thirdToken.setLast_login_date(token.getLast_login_date());
						thirdToken.setRoles_id(token.getRoles_id());
						thirdToken.setRoles_name(token.getRoles_name());
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
	 * validateXfusionPlateForm() method will take required parameter and give
	 * access_token of XFusionPlateForm
	 * 
	 * @param applicaionToken
	 * @param token
	 */
	public void validateXfusionPlateForm(final String applicaionToken, final Token token) throws Exception {
		try {

			/**
			 * to get useKey and application_id
			 */
			/**
			 * to get useKey and application_id
			 */
			String passingParameter = "applicationid=9a959887-5946-11e6-9bb0-fe984cc15272";
			Map<String, String> headerMap = new LinkedHashMap<>();
			headerMap.put("userKey", token.getUserKey());

			/**
			 * Hitting XFusion Platform API to validate user from Platform
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getXfusionPlatformThirdPartyIntegrationToken(),
					passingParameter, headerMap);
			/**
			 * To Print the response
			 */
//			System.out.println("urlResponseAsObject " + urlResponseAsObject);
			/*
			 * To get response in Json Format in GetTokenResponse Model format
			 */
			Type type = new TypeToken<GetTokenResponse<Token>>() {
			}.getType();
			GetTokenResponse<Token> urlResponseMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);
			/**
			 * To check if urlResponseMessage response is valid or not
			 */
			if (urlResponseMessage.isValid()) {/**
												 * to get the xfusion Token in
												 * Token model class format
												 */
				Token xfusionToken = urlResponseMessage
						.getObject();/*
										 * To Store Xfusion token
										 */
				Constant.addXfusionTokon(applicaionToken, xfusionToken);

			}

		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
		}

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
			Constant.oauthmap.remove(request.getHeader("token"));
			Constant.xfusionPaleteform.remove(request.getHeader("token"));
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

				if (key.trim().equals("token")) {
					Token token = (Token) Constant.oauthmap.get(passingMap.get(key).trim());
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
					headerMap.put("token", token.getAccess_token());
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
	public Message passwordUpdate(Map<String, String> passingMap) throws Exception {
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
					Token token = (Token) Constant.oauthmap.get(passingMap.get(key).trim());
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
					headerMap.put("token", token.getAccess_token());
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
	public Message passwordReset(Map<String, String> passingMap) throws Exception {
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
					Token token = (Token) Constant.oauthmap.get(passingMap.get(key).trim());
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
					headerMap.put("token", token.getAccess_token());
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
			Token token = (Token) Constant.oauthmap.get(passingMap.get("token").trim());
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

	/*
	 * This method is used to get token on basis of user_key
	 */
	@SuppressWarnings("unused")
	public Message oauthTokenByuser_key(String user_key, String application_id) throws Exception {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();

		try {

			/*
			 * Input parameter is Application id and user_key
			 */
			String passingParameters = "application_id=" + application_id.trim();
			Map<String, String> headerMap = new LinkedHashMap<>();
			headerMap.put("user_key", user_key.trim());

			/**
			 * To Check if user_key is null than return error message
			 */
			if (user_key == null) {
				responseMessage.setDescription("user_key is null");
				responseMessage.setValid(false);
				return responseMessage;

			}
			/**
			 * to Check if application id is null than return error response
			 */
			if (application_id == null) {
				responseMessage.setDescription("application_id is null");
				responseMessage.setValid(false);
				return responseMessage;
			}

			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,user_key,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getXfusionPlatformThirdPartyIntegrationToken(),
					passingParameters, headerMap);
			/**
			 * To Print the response from xfusion platform
			 */

			/**
			 * Checking if Object is not Null than continue with next process
			 */
			if (urlResponseAsObject != null) {

				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();
				/**
				 * Casting Message in TokenResponse model in json format
				 */
				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);
				/**
				 * Checking if response is valid or not
				 */
				if (genericMessage.isValid()) {
					/**
					 * To get Token and its information in config token
					 */
					Token configToken = genericMessage.getObject();
					/**
					 * To print Token and its information in config token
					 */

					/**
					 * to generate Token
					 */
					String applicaionToken = Constant.genrateToken().toString();
					/**
					 * to store apllication token
					 */
					Constant.addTokon(applicaionToken, configToken);
					/**
					 * to store the Platform token
					 */
					Constant.addXfusionTokon(applicaionToken, configToken);

					/**
					 * Setting Response For Oauth Engine API Of ThirdParty
					 * Application
					 */
					Token thirdPartyToken = new Token();
					thirdPartyToken.setAccess_key(configToken.getAccess_key());
					thirdPartyToken.setAccess_token(applicaionToken);
					thirdPartyToken.setMessage(configToken.getMessage());
					thirdPartyToken.setUserKey(configToken.getUserKey());
					thirdPartyToken.setExpires_in(configToken.getExpires_in());
					thirdPartyToken.setUser_id(configToken.getUser_id());
					thirdPartyToken.setLast_password_change_date(configToken.getLast_password_change_date());
					thirdPartyToken.setLast_login_date(configToken.getLast_login_date());
					thirdPartyToken.setLast_activity_date(configToken.getLast_activity_date());
					thirdPartyToken.setRoles_name(configToken.getRoles_name());
					thirdPartyToken.setRoles_id(configToken.getRoles_id());
					responseMessage.setDescription(configToken.getMessage().toString());
					/**
					 * Setting and Returning the Response Message
					 */
					responseMessage.setObject(thirdPartyToken);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}
		}
		/*
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			/**
			 * To Print the exception if some come in process
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

}
