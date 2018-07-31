/**
 * This package contain the Service class  for OAuthEngine ApI's
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * This class work as a Service class for OAUth Engine's API for Authorization
 * and other actions regarding OAUTh Engine
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
	 * oauthToken() to give authentication and give userKey,user_id,access_key
	 * and access_token in form of responseMessage
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
			 * Hitting Auth Api to get
			 * Token,Access_key,UserKey,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getAuthURL(), passingParameters);
			/**
			 * Print response from OAuth Engine
			 */
			System.out.println(urlResponseAsObject);

			if (urlResponseAsObject != null) {
				/*
				 * To get response in Json Format in GetTokenResponse Model
				 * format
				 */

				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();

				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);

				// Message urlMessage = (Message) new
				// Gson().fromJson(urlResponseAsObject.toString(),
				// Message.class);
				/**
				 * To check if genericMessage is valid
				 */
				if (genericMessage.isValid()) {
					/**
					 * To get response and set in token class
					 */
					Token token = genericMessage.getObject();
					/**
					 * To print json format of token
					 */
					System.out.println(new Gson().toJson(token));
					/**
					 * To Check if token has status bit in urlResponseAsObject
					 */
					if (!urlResponseAsObject.toString().contains("status")) {
						/*
						 * To Generate Application token to access application
						 * through out
						 */
						String applicaionToken = Constant.genrateToken().toString();
						/**
						 * To Store application token
						 */
						Constant.addTokon(applicaionToken, token);
						/*
						 * To Store OAuth Token
						 */
						Constant.addAOuthTokon(applicaionToken, token);
						/**
						 * To Get Platform Token and validate user through
						 * Plateform
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
	 * validateXfusionPlateForm() method will take required parameter and give
	 * access_token of XFusionPlateForm
	 * 
	 * @param applicaionToken
	 * @param token
	 */
	private void validateXfusionPlateForm(final String applicaionToken, final Token token) {
		try {

			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					/**
					 * To get UserKey
					 */
					String passingParameter = "userKey=" + token.getUserKey();

					/**
					 * Hitting XfusionURL Api to validate user from Platform
					 */
					Object urlResponseAsObject = urlCalling.getData(urlParameter.getXfusionURL(), passingParameter);

					//
					// Message urlResponseMessage = (Message) new
					// Gson().fromJson(urlResponseAsObject.toString(),
					// Message.class);
					/*
					 * To Print response from Platform
					 */
					System.out.println("Object:- " + urlResponseAsObject);
					/*
					 * To get response in Json Format in GetTokenResponse Model
					 * format
					 */
					Type type = new TypeToken<GetTokenResponse<Token>>() {
					}.getType();

					GetTokenResponse<Token> urlResponseMessage = new Gson().fromJson(urlResponseAsObject.toString(),
							type);
					/**
					 * To check if urlResponseMessage response is valid or not
					 */
					if (urlResponseMessage.isValid()) {
						/**
						 * to get the xfusion Token in Token model class format
						 */
						Token xfusionToken = urlResponseMessage.getObject();
						/*
						 * To Store Xfusion token
						 */
						Constant.addXfusionTokon(applicaionToken, xfusionToken);

					}
					/*
					 * To Print urlResponseAsObject
					 */
					System.out.println(urlResponseAsObject);
				}
			});

			thread.start();

		} catch (Exception e) {
			/**
			 * to catch the exception
			 */
			e.printStackTrace();
		}
	}

	/**
	 * oauthTokenExpire To Expire Token for Logout
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @return response Message
	 */
	public Message oauthTokenExpire(Map<String, String> passingMap) {
		/*
		 * To Initialize the response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * to check if parameters contain token or not
			 */
			if (passingMap.get("token") == null) {
				responseMessage.setDescription("Token field is required.");
				responseMessage.setValid(false);

				return responseMessage;
			}
			/**
			 * To print Oauth token and application token
			 */
			System.out.println(Constant.map.get(passingMap.get("token").trim()));
			System.out.println(Constant.oauthmap.get(passingMap.get("token").trim()));
			/**
			 * To remove Oauth token and application token
			 */
			Constant.map.remove(passingMap.get("token"));
			Constant.oauthmap.remove(passingMap.get("token"));
			/**
			 * Token Expire Message
			 */
			responseMessage.setDescription("Your Token is Expired.");
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			e.getMessage();
		}
		/**
		 * Token Already Expired Message
		 */
		responseMessage.setDescription("Your Token is already Expired.");
		responseMessage.setValid(false);

		return responseMessage;
	}

	/**
	 * Services for Forgot Password API
	 * 
	 * @param passingMap
	 *            Contains parameter to call api
	 * @return response Message
	 */
	public Message forgotPassword(Map<String, String> passingMap) {
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
					passingParameter.append("token=" + token.getAccess_token());
					continue;
				}
				/*
				 * to append rest of the parameter
				 */
				passingParameter.append("&" + key + "=" + passingMap.get(key));

			}
			/*
			 * to Print the parameters
			 */
			System.out.println("Send Data:- " + passingParameter);
			/*
			 * Calling the Oauth Engine Forgot Password API
			 */
			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthForgotPasswordURL(),
					passingParameter.toString());
			/**
			 * Printing the response from api
			 */
			System.out.println("result Object:- " + urlResponseResult);
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
		}
		/**
		 * If issue with API than error response
		 */
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
	public Message passwordUpdate(Map<String, String> passingMap) {
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
					passingParameter.append("token=" + token.getAccess_token());
					continue;
				}
				/*
				 * to append rest of the parameter
				 */
				passingParameter.append("&" + key + "=" + passingMap.get(key));

			}
			/*
			 * to Print the parameters
			 */
			System.out.println("Send Data:- " + passingParameter);
			/*
			 * Calling the Oauth Engine Update Password API
			 */

			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthUpdateURL(), passingParameter.toString());

			/**
			 * Printing the response from api
			 */
			System.out.println("result Object:- " + urlResponseResult);
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
	public Message passwordReset(Map<String, String> passingMap) {
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
					passingParameter.append("token=" + token.getAccess_token());
					continue;
				}
				/*
				 * to append rest of the parameter
				 */
				passingParameter.append("&" + key + "=" + passingMap.get(key));

			}
			/*
			 * to Print the parameters
			 */
			System.out.println("Send Data:- " + passingParameter);
			/*
			 * Calling the Oauth Engine Update Password API
			 */

			Object urlResponseResult = urlCalling.getData(urlParameter.getAuthResetPasswordURL(),
					passingParameter.toString());

			/**
			 * Printing the response from api
			 */
			System.out.println("result Object:- " + urlResponseResult);
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
	public Message returnOauthToken(Map<String, String> passingMap) {
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
		}
		/**
		 * If issue is getting token and token was already expire
		 */
		responseMessage.setDescription("Token Expire");
		responseMessage.setValid(false);
		return responseMessage;
	}

}
