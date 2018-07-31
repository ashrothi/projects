/**
 * This package contain the Service class for sign up controller.
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

/**
 * This class contains business logic for registering new user into the third
 * party application.
 * 
 * @author mandeepsingh
 * @creation_date 05-03-2018
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class SignupServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	Environment environment;
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private XFusionService xFusionService;
	/**
	 * This controller is used to register and sign up new user into the platform as
	 * well as Thirdparty db by calling api and stored procedure.
	 * 
	 * @param passingMap
	 *            : Here pass the required parameters.
	 * @param request
	 *            : Here pass Http servlet request object.
	 * @param response
	 *            : Here pass Http servlet response object.
	 * @return Message object containing the reponse of this API.
	 */
	@SuppressWarnings("unchecked")
	public Message signUpProcess(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			Map<String, Object> userSignupMap = xFusionService.getPlatformQuery(passingMap, request, response);
			String queryString = userSignupMap.get("passingString").toString();
			Object userCreationObject = urlCalling.getData(urlParameter.getUserCreation(), queryString, null);

			Message userCreationMessage = (Message) new Gson().fromJson(userCreationObject.toString(), Message.class);
			if (userCreationMessage.isValid()) {

				Map<String, String> userCreationMap = (Map<String, String>) userCreationMessage.getObject();

				passingMap.putAll(userCreationMap);
				passingMap.put("insert_userKey", userCreationMap.get("userKey"));
				passingMap.put("insert_user_id", userCreationMap.get("user_id"));

				String passingParameters = "user_name="
						+ String.valueOf(environment.getProperty("admin.login.username")).trim() + "&password="
						+ String.valueOf(environment.getProperty("admin.login.password")).trim() + "&application_id="
						+ String.valueOf(environment.getProperty("application.key")).trim();
				/**
				 * Hitting Authorization API to get Token,Access_key,user_key,Expires_in,User_id
				 * as Response
				 */
				Message message = genericProcess.GenericProcedureCalling("101", passingMap, null, request, response);
				Object urlResponseAsObject = urlCalling.getData(urlParameter.getXauthURL(), passingParameters, null);
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

					Message genericMessage = (Message) new Gson().fromJson(urlResponseAsObject.toString(),
							Message.class);
					/**
					 * To check if genericMessage is valid
					 */
					if (genericMessage.isValid()) {
						Map<String, String> oauthMap = (Map<String, String>) genericMessage.getObject();

						passingMap.putAll(oauthMap);

						System.out.println("oauthMap " + oauthMap);
						StringBuilder passingNewParameter = new StringBuilder();
						Map<String, String> headerNewMap = new LinkedHashMap<>();
						for (String key : passingMap.keySet()) {
							/*
							 * Retrieving the xFusion Platform Token
							 */

							/*
							 * To append Token in query String
							 */
							// passingNewParameter.append("token=" +
							// token.getAccess_token());
							headerNewMap.put("token", passingMap.get("access_token"));

							/*
							 * To append rest Parameter
							 */
							if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
								headerNewMap.put(key, passingMap.get(key));

							}
							passingNewParameter.append("&" + key + "=" + String.valueOf(passingMap.get(key)));
						}

						/*
						 * To Print Passing Parameter query string
						 */

						/**
						 * calling Platform APi
						 */
						Object finalVehicleResponseMessage = urlCalling.getData(
								urlParameter.getXfusionOrganizationUserMapping(), passingNewParameter.toString(),
								headerNewMap);
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
							Type type1 = new TypeToken<GenericMessages<Map<String, Object>>>() {
							}.getType();
							/**
							 * Getting Response in formatted way
							 */
							GenericMessages<Map<String, Object>> urlMessageFinal = (GenericMessages<Map<String, Object>>) new Gson()
									.fromJson(finalVehicleResponseMessage.toString(), type1);
							/**
							 * Getting response in List of Map
							 */
							List<Map<String, Object>> deviceModelObject = urlMessageFinal.getObject();
							/*
							 * To Print Response
							 */
							System.out.println("deviceModelObject " + deviceModelObject);
							/*
							 * Check if response is not null
							 */
							if (deviceModelObject != null) {
								/*
								 * Response Message from API
								 */

								if (message.isValid()) {
									responseMessage.setDescription("Process Success User Created Successfully");
									responseMessage.setObject(message.getObject());
									responseMessage.setValid(true);

									return responseMessage;
								} else {
									responseMessage.setDescription("Process Fail User Not Created ");
									responseMessage.setValid(false);
									return responseMessage;
								}

							}
						}

					}
				}

			} else {
				return userCreationMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Message userVerification(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {

		Message responseMessage = new Message();
		try {

			String passingParameters = "user_name=" + map.get("username");
			Object urlResponseAsObject = urlCalling.getData(urlParameter.getUserVerification(), passingParameters,
					null);
			if (urlResponseAsObject != null) {
				/*
				 * To get response in Json Format in GetTokenResponse Model format
				 */

				Message genericMessage = (Message) new Gson().fromJson(urlResponseAsObject.toString(), Message.class);

				if (genericMessage.getDescription().equalsIgnoreCase("Email Sent")) {

					Message message = genericProcess.GenericProcedureCalling("113", map, null, request, response);
					List<Map<String, Object>> userData = (List<Map<String, Object>>) message.getObject();
					if (userData.get(0).get("code").toString().equalsIgnoreCase("0")) {

						responseMessage.setDescription("User already Exists In Application");
						responseMessage.setObject(userData.get(0));
						responseMessage.setValid(true);
						return responseMessage;
					} else {
						return genericMessage;
					}
				} else {
					return genericMessage;
				}

			} else {
				responseMessage.setDescription("Issue Occured in Creating User");

				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Issue Occured " + e.getMessage());

			responseMessage.setValid(false);
			return responseMessage;
		}

	}

}
