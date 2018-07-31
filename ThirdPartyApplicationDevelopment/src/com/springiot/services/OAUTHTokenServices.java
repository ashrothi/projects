package com.springiot.services;

import java.lang.reflect.Type;

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
 * This Class to Define OAUTHTokenServices component For API's.
 * 
 * @author Teramatrix
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
	 * and access_token in form of message
	 * 
	 * @param username
	 * @param password
	 * @param applicationid
	 * @return message
	 */
	public Message oauthToken(String user_name, String password, String application_id) {
		Message responseMessage = new Message();

		try {

			String passingParameters = "user_name=" + user_name.trim() + "&password=" + password.trim()
					+ "&application_id=" + application_id.trim();
			/**
			 * Hitting Authorization API to get
			 * Token,Access_key,UserKey,Expires_in,User_id as Response
			 */
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getxFusionAuthURL(), passingParameters, null);
			//System.out.println(urlResponseAsObject);

			if (urlResponseAsObject != null) {

				Type type = new TypeToken<GetTokenResponse<Token>>() {
				}.getType();
				GetTokenResponse<Token> genericMessage = new Gson().fromJson(urlResponseAsObject.toString(), type);

				if (genericMessage.isValid()) {
					Token token = genericMessage.getObject();
					
					
					String status = token.getStatus();
					//System.out.println("Status: " + status);
					if(status.equalsIgnoreCase("true")){
					
						Constant.addToken(token.getAccess_token(), token);
					
						/**
						 * Setting Response For Oauth Engine API Of ThirdParty
						 * Application
						 */
						Token thirdPartyToken = new Token();
						thirdPartyToken.setAccess_key(token.getAccess_key());
						thirdPartyToken.setAccess_token(token.getAccess_token());
						thirdPartyToken.setMessage(token.getMessage());
						thirdPartyToken.setUserKey(token.getUser_key());
						thirdPartyToken.setUser_key(token.getUser_key());
						thirdPartyToken.setUser_id(token.getUser_id());
						thirdPartyToken.setRoles_name(token.getRoles_name());
						thirdPartyToken.setRoles_id(token.getRoles_id());
						thirdPartyToken.setStatus(token.getStatus());
						thirdPartyToken.setToken_type(token.getToken_type());
	
						/**
						 * Response Message from API
						 */
						responseMessage.setDescription(token.getMessage().toString());
						responseMessage.setObject(thirdPartyToken);
						responseMessage.setValid(true);
	
						return responseMessage;
					} else {
						/**
					 	 * Set the parameter in setter method.
					 	 */
						responseMessage.setObject("Cannot retreive access token.");
						responseMessage.setValid(false);
						return responseMessage;
					}
				}
			}
		}
		/**
		 * Handling the occurring exceptions.
		 */
		catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * Response Message of API when some errors occurred in API.
		 */
		responseMessage.setDescription("Login unsuccess");
		responseMessage.setValid(false);
		return responseMessage;
	}

}
