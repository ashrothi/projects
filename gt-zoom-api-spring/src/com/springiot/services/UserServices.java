/**
 * This package contain the Service class for Third Party Services Service to get all 
 * API with some manipulation and logic applied on api to manage the user.
 */
package com.springiot.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.env.Environment;

import com.google.gson.Gson;

import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;

/**
 * This class works as service for APIs for managing the users into the third party and Auth engine.
 * 
 * @author Mandeep Singh
 * @creation_date : 28-03-2018 
 */
@Service
@Transactional
@PropertySource(value = "classpath:/UserCreate.properties")
public class UserServices {
	// Autowired is used to inject the object dependency implicitly.
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	Environment environment;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * Service To Create User in auth engine and third party application.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked" })
	public Message UserCreate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/**
		 * Initialize Response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Passing Parameter Map to Call Oauth Engine API
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();
			Map<String, String> headerMap = new LinkedHashMap<>();

			// Setting header parameters for calling auth engine API.
			headerMap.put("token", request.getHeader("token"));
			headerMap.put("user_key", request.getHeader("user_key"));
			headerMap.put("user_id", request.getHeader("user_id"));

			// Setting body parameters for calling auth engine API.
			passingMap.put("email", map.get("userId"));
			passingMap.put("password", map.get("password"));
			passingMap.put("password_question", "");
			passingMap.put("password_answer", "");
			passingMap.put("is_approved", "1");
			passingMap.put("application_id", "84");
			passingMap.put("role_id", map.get("role_id"));
			passingMap.put("csv_attributes_id", "");
			passingMap.put("csv_attributes_alias", "");
			passingMap.put("csv_attributes_value", "");
			
			StringBuilder authUserCreate = new StringBuilder();
			for (String key : passingMap.keySet()) {
				authUserCreate.append("&" + key + "=" + passingMap.get(key));
			}
			authUserCreate.deleteCharAt(0);
			
			// Calling Oauth Engine API for create user.
			Object urlResponseResult = urlCalling.getData(urlParameter.getUserCreate(), authUserCreate.toString(), headerMap);
//			System.out.println("urlResponseResult " + urlResponseResult);
			// Checking if response is not null
			if (urlResponseResult != null) {
				// Casting response in Message type
				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
//				System.out.println("urlMessage:-" + urlMessage.getObject());
				// Checking if response is valid or not
				if (urlMessage.isValid()) {
					List<Map<String, Object>> userCreateResponse = (List<Map<String, Object>>) urlMessage.getObject();
//					System.out.println("userCreateResponse " + userCreateResponse);
					
					if (String.valueOf(userCreateResponse.get(0).get("code")).equalsIgnoreCase("13.0")) {

						Map<String, String>	procMap = new HashMap<String, String>();
						// Setting parameters for calling third party procedure.
						procMap.put("user_key", String.valueOf(userCreateResponse.get(0).get("userKey")));
						procMap.put("user_id", map.get("userId"));
						procMap.put("user_name", map.get("userId"));
						procMap.put("role_id", map.get("role_id"));
						procMap.put("role_name", map.get("role_name"));
						procMap.put("group_id", map.get("group_id"));
						
						// Calling procedure to insert user into the third party db.
						Message userCreate = genericProcess.GenericProcedureCalling("18", procMap, null, request,
								response);

						//System.out.println("userCreate " + userCreate);
						if (userCreate.isValid()) {
							// Response Message from Procedure.
							return userCreate;
						} else {
							responseMessage.setDescription("Process fail");
							responseMessage.setObject(userCreate.getObject());
							responseMessage.setValid(false);
							return responseMessage;
						}
					} else {
						// Response Message from API.
						return urlMessage;
					}
				} else {
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
