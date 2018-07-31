/**
 * This package contain the Service class for sign up controller.
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

/**
 * This class contains business logic for registering new user into the third party application.
 * 
 * @author mandeepsingh
 * @creation_date 05-03-2018
 */
@Service
@Transactional
public class SignupServices {
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
	
	/**
	 * This method is used to check if the organization exists in 
	 * platform by calling platform api and in ThirdParty by calling
	 * the stored procedure.
	 * 
	 * @param passingMap : Here pass the required parameters.
	 * @param request : Here pass Http servlet request object.
	 * @param response : Here pass Http servlet response object.
	 * @return Message object containing the reponse of this API.
	 */
	@SuppressWarnings("unchecked")
	public Message checkOrg(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response){
		Message message = new Message();
		Map<String, Object> orgCheck = new HashMap<>();
		int existsPlatform = 0;
		int existsThirdParty = 0;
		try {
			StringBuilder passingParameter = new StringBuilder();
	
			// To Make query string to call platform API
			for (String key : passingMap.keySet()) {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
			}
			passingParameter.deleteCharAt(0);
			
			Object responseMessage = urlCalling.getData(urlParameter.getPlatformOrganizationCheck(), passingParameter.toString(),
					new LinkedHashMap<>());
			if (responseMessage != null) {
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/**
				 * Casting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(responseMessage.toString(), type);
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

				Double d = Double.valueOf(deviceModelObject.get(0).get("is_exist").toString()).doubleValue();
				existsPlatform = d.intValue();
			}
			
			Message orgThirdParty = genericProcess.GenericProcedureCalling("25", passingMap, null, request, response);
			List<Map<String, Object>> deviceInfoProcList = (List<Map<String, Object>>) orgThirdParty.getObject();
			existsThirdParty = Integer.valueOf(deviceInfoProcList.get(0).get("is_exists").toString());
			
			if(existsThirdParty == 0 && existsPlatform == 0){
				orgCheck.put("message", "Organization doesn't exists.");
				orgCheck.put("is_exist", "0");
			} else {
				orgCheck.put("message", "Organization alredy exists.");
				orgCheck.put("is_exist", "1");
			}
			
			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(orgCheck);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process fail " + e.getMessage());
			message.setValid(true);

			return message;
		}
		
	}
	
	/**
	 * This controller is used to register and sign up new user into the platform
	 * as well as Thirdparty db by calling api and stored procedure.
	 * 
	 * @param passingMap : Here pass the required parameters.
	 * @param request : Here pass Http servlet request object.
	 * @param response : Here pass Http servlet response object.
	 * @return Message object containing the reponse of this API.
	 */
	@SuppressWarnings("unchecked")
	public Message signUpProcess(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response){
		Message message = new Message();
		Map<String, Object> signUpResponse = new HashMap<>();
		int userCreationCode = 0;
		String authResponse = "";
		String rootToken = "";
		String rootUserKey = "";
		String rootUserId = "";
		String newUserToken = "";
		String newUserUserKey = "";
		String newUserUserId = "";
		String newUserAccessKey = "";
		int newUserOrgId = 0;
		String userAuthResponse = "";
		
		try{
			/*
			 * passingMap is used to store the input parameters from user which
			 * will be same as of the procedure being called upon.
			 */
			LinkedHashMap<String, String> authLoginMap = new LinkedHashMap<>();
			authLoginMap.put("user_name", passingMap.get("root_user_name"));
			authLoginMap.put("password", passingMap.get("root_user_password"));
			authLoginMap.put("application_id", passingMap.get("root_application_id"));
			StringBuilder authLoginParameter = new StringBuilder();
			for (String key : authLoginMap.keySet()) {
				authLoginParameter.append("&" + key + "=" + authLoginMap.get(key));
			}
			authLoginParameter.deleteCharAt(0);

			// Calling Auth login api for getting token of Auth Engine.
			String authLoginResponseMessage = urlCalling.getData(urlParameter.getAuthURL(), authLoginParameter.toString(), new LinkedHashMap<>());
//			System.out.println("Response: " + authLoginResponseMessage);

			// Check if resposne is not empty or null.
			if (authLoginResponseMessage != null) {
				// Casting response in required format
				Type type = new TypeToken<Map<String,Object>>() {
				}.getType();
				// Getting response in formatted way
				Map<String,Object> urlMessage = (Map<String,Object>) new Gson()
						.fromJson(authLoginResponseMessage, type);
				// to get response in List of Map
				authResponse = urlMessage.get("description").toString();
				
				String value = urlMessage.get("object").toString();
				value = value.substring(1, value.length()-1);
				String[] keyValuePairs = value.split(",");
				Map<String,String> rootMap = new HashMap<>();

				for(String pair : keyValuePairs)
				{
				    String[] entry = pair.split("="); 
				    rootMap.put(entry[0].trim(), entry[1]);
				}
				if(authResponse.equals("Login Success")){
					rootToken = rootMap.get("access_token").toString();
					rootUserKey = rootMap.get("user_key").toString();
					rootUserId = rootMap.get("user_id").toString();
				}
			}

			if(authResponse.equals("Login Success")){
				/*
				 * passingMap is used to store the input parameters from user which
				 * will be same as of the procedure being called upon.
				 */
				LinkedHashMap<String, String> userCreationMap = new LinkedHashMap<>();

				// Adding body parameters to the map.
				userCreationMap.put("username", passingMap.get("new_user_name"));
				userCreationMap.put("OTP", passingMap.get("OTP"));
				userCreationMap.put("password", passingMap.get("password"));
				userCreationMap.put("password_question", passingMap.get("password_question"));
				userCreationMap.put("password_answer", passingMap.get("password_answer"));
				userCreationMap.put("is_approved", passingMap.get("is_approved"));
				userCreationMap.put("application_id", passingMap.get("application_id"));
				userCreationMap.put("role_id", passingMap.get("role_id"));
				userCreationMap.put("first_name", passingMap.get("first_name"));
				userCreationMap.put("last_name", passingMap.get("last_name"));
				userCreationMap.put("country", passingMap.get("country"));
				userCreationMap.put("state", passingMap.get("state"));
				userCreationMap.put("city", passingMap.get("city"));
				userCreationMap.put("preferred_number", passingMap.get("preferred_number"));
				userCreationMap.put("phone_numbers", passingMap.get("phone_numbers"));
				userCreationMap.put("address", passingMap.get("address"));
				userCreationMap.put("creation_date", passingMap.get("creation_date"));
				userCreationMap.put("is_permanent_address", passingMap.get("is_permanent_address"));
				userCreationMap.put("image_path", passingMap.get("image_path"));
				userCreationMap.put("thumbail_image_path", passingMap.get("thumbnail_image_path"));
				userCreationMap.put("csv_attributes_id", passingMap.get("csv_attributes_id"));
				userCreationMap.put("csv_attributes_alias", passingMap.get("csv_attributes_alias"));
				userCreationMap.put("csv_attributes_value", passingMap.get("csv_attributes_value"));
				
				StringBuilder passingParameter = new StringBuilder();

				Map<String, String> headerMap = new LinkedHashMap<>();
				for (String key : userCreationMap.keySet()) {
					passingParameter.append("&" + key + "=" + userCreationMap.get(key));
				}
				passingParameter.deleteCharAt(0);

				// Calling User Creation api for generating user on Auth Engine.
				String userCreationResponseMessage = urlCalling.getData(urlParameter.getPlatformUserCreation(), passingParameter.toString(), new LinkedHashMap<>());
//				System.out.println("Response: " + userCreationResponseMessage);

				// Check if resposne is not empty or null.
				if (userCreationResponseMessage != null) {
					// Casting response in required format
					Type type = new TypeToken<Map<String,Object>>() {
					}.getType();
					// Getting response in formatted way
					Map<String,Object> urlMessage = (Map<String,Object>) new Gson()
							.fromJson(userCreationResponseMessage, type);
					// to get response in List of Map
					Object responseObject = urlMessage.get("object");

					// to check if response is null
					if (responseObject != null) {
						Map<String,Object> objectCode = (Map<String,Object>) new Gson()
								.fromJson(responseObject.toString(), type);
						Double d = Double.valueOf(objectCode.get("code").toString()).doubleValue();
						userCreationCode = d.intValue();
					}
				}

				if(userCreationCode == 13){
					Map<String, String> rootHeaderMap = new LinkedHashMap<>();
					
					rootHeaderMap.put("token", rootToken);
					rootHeaderMap.put("user_key", rootUserKey);
					rootHeaderMap.put("user_id", rootUserId);
					StringBuilder authLogoutParameter = new StringBuilder();

					// Calling Auth logout api for log out user from Auth Engine.
					Object authLogoutResponse = urlCalling.getData(urlParameter.getAuthLogout(), authLogoutParameter.toString(),
							rootHeaderMap);
//					System.out.println("Response: " + authLogoutResponse);
					
					LinkedHashMap<String, String> loginMap = new LinkedHashMap<>();
					loginMap.put("user_name", passingMap.get("new_user_name"));
					loginMap.put("password", passingMap.get("password"));
					loginMap.put("application_id", passingMap.get("platform_application_id"));
					StringBuilder loginParameter = new StringBuilder();

					for (String key : loginMap.keySet()) {
						loginParameter.append("&" + key + "=" + loginMap.get(key));
					}
					loginParameter.deleteCharAt(0);
					
					// Calling Platform login api for getting token of gFusion platform.
					String loginResponse = urlCalling.getData(urlParameter.getPlatformLogin(), loginParameter.toString(),
							new LinkedHashMap<>());
//					System.out.println("Response: " + loginResponse);

					// Check if resposne is not empty or null.
					if (loginResponse != null) {
						// Casting response in required format
						Type type = new TypeToken<Map<String,Object>>() {
						}.getType();
						// Getting response in formatted way
						Map<String,Object> urlMessage = (Map<String,Object>) new Gson()
								.fromJson(loginResponse, type);
						// to get response in List of Map
						userAuthResponse = urlMessage.get("description").toString();
						
						String value = urlMessage.get("object").toString();
						value = value.substring(1, value.length()-1);
						String[] keyValuePairs = value.split(",");
						Map<String,String> rootMap = new HashMap<>();

						for(String pair : keyValuePairs)
						{
						    String[] entry = pair.split("="); 
						    rootMap.put(entry[0].trim(), entry[1]);
						}
						if(userAuthResponse.equals("Login Success")){
							newUserToken = rootMap.get("access_token").toString();
							newUserUserKey = rootMap.get("user_key").toString();
							newUserUserId = rootMap.get("user_id").toString();
							newUserAccessKey = rootMap.get("access_key").toString();
						}
					}
					if(userAuthResponse.equals("Login Success")){
						// To append header parameters into a map.
						headerMap.put("token", newUserToken);
						headerMap.put("user_key", newUserUserKey);
						headerMap.put("user_id", newUserUserId);
						
						LinkedHashMap<String, String> orgInsertMap = new LinkedHashMap<>();
						orgInsertMap.put("parent_organization", passingMap.get("parent_organization"));
						orgInsertMap.put("organization_name", passingMap.get("organization_name"));
						orgInsertMap.put("city", passingMap.get("city"));
						orgInsertMap.put("country", passingMap.get("country"));
						orgInsertMap.put("description", passingMap.get("description"));
						orgInsertMap.put("color_code", passingMap.get("color_code"));
						StringBuilder orgInsertParameter = new StringBuilder();

						for (String key : orgInsertMap.keySet()) {
							orgInsertParameter.append("&" + key + "=" + orgInsertMap.get(key));
						}
						orgInsertParameter.deleteCharAt(0);

						// Calling Organization insert api for getting inserting the new user into gFusion platform.
						String orgInsertResponse = urlCalling.getData(urlParameter.getPlatformOrgInsert(), orgInsertParameter.toString(),
								headerMap);
//						System.out.println("Response: " + orgInsertResponse);

						// Check if resposne is not empty or null.
						if(orgInsertResponse != null){
							Type typeOrg = new TypeToken<Map<String,Object>>() {
							}.getType();
							Map<String,Object> orgMap = (Map<String,Object>) new Gson()
									.fromJson(orgInsertResponse, typeOrg);
							List<Map<String, Object>> orgList = new ArrayList<>();
							orgList = (List<Map<String, Object>>) orgMap.get("object");
							for (Map<String, Object> map : orgList) {
								if(map.get("msg").toString().equals("Group created")){
									Double d = Double.valueOf(map.get("organization_id").toString()).doubleValue();
									newUserOrgId = d.intValue();
								}
								else{
									signUpResponse.put("is_successful", "0");
									signUpResponse.put("message", "User Creation Failed! " + map.get("msg"));
								}
							}
						}
						
						LinkedHashMap<String, String> orgMappingMap = new LinkedHashMap<>();
						
						orgMappingMap.put("insert_userKey", newUserUserKey);
						orgMappingMap.put("insert_user_id", newUserUserId);
						orgMappingMap.put("organization_ids", Integer.toString(newUserOrgId));
						orgMappingMap.put("access_key", newUserAccessKey);
						StringBuilder orgMappingParameter = new StringBuilder();

						for (String key : orgMappingMap.keySet()) {
							orgMappingParameter.append("&" + key + "=" + orgMappingMap.get(key));
						}
						orgMappingParameter.deleteCharAt(0);

						// Calling User Organization Mapping api for mapping user with groups in gFusion platform.
						Object orgMappingResponse = urlCalling.getData(urlParameter.getPlatformUserOrgMapping(), orgMappingParameter.toString(),
								headerMap);
//						System.out.println("Response: " + orgMappingResponse);

						LinkedHashMap<String, String> inheritTemplateMap = new LinkedHashMap<>();
						
						inheritTemplateMap.put("template_id", passingMap.get("template_id"));
						inheritTemplateMap.put("template_name", passingMap.get("template_name"));
						inheritTemplateMap.put("model_name", passingMap.get("model_name"));
						
						StringBuilder inheritTemplateParameter = new StringBuilder();

						for (String key : inheritTemplateMap.keySet()) {
							inheritTemplateParameter.append("&" + key + "=" + inheritTemplateMap.get(key));
						}
						inheritTemplateParameter.deleteCharAt(0);

						// Calling Inherit Template api for inheriting template under the user in gFusion platform.
						Object inheritTemplateResponse = urlCalling.getData(urlParameter.getPlatformInheritTemplate(), inheritTemplateParameter.toString(),
								headerMap);
//						System.out.println("Response: " + inheritTemplateResponse);

						Map<String, String> gtZoomSignupMap = new HashMap<String, String>();
						gtZoomSignupMap.put("organization_name", passingMap.get("organization_name"));
						gtZoomSignupMap.put("currency", passingMap.get("currency"));
						gtZoomSignupMap.put("time_format", passingMap.get("time_format"));
						gtZoomSignupMap.put("userKey",	newUserUserKey);
						gtZoomSignupMap.put("userId", newUserUserId);
						gtZoomSignupMap.put("user_name", passingMap.get("first_name"));
						gtZoomSignupMap.put("user_image", passingMap.get("image_path"));
						gtZoomSignupMap.put("role_id", passingMap.get("role_id"));
						gtZoomSignupMap.put("role_name", passingMap.get("role_name"));
						gtZoomSignupMap.put("fleet_size", passingMap.get("fleet_size"));
						gtZoomSignupMap.put("gender", passingMap.get("gender"));
						gtZoomSignupMap.put("phone_number", passingMap.get("preferred_number"));

						// Calling third party procedure for inserting user into the third party.
						Message gtZoomSignup = genericProcess.GenericProcedureCalling("26", gtZoomSignupMap, null, request, response);
						List<Map<String, Object>> thirdPartySignupResponse = (List<Map<String, Object>>) gtZoomSignup.getObject();
//						System.out.println("Response from proc: " + thirdPartySignupResponse);
						
						StringBuilder platLogoutParameter = new StringBuilder();

						// Calling Platform logout api for log out user from gFusion platform.
						Object platLogoutResponse = urlCalling.getData(urlParameter.getPlatformLogout(), platLogoutParameter.toString(),
								headerMap);
//						System.out.println("Response: " + platLogoutResponse);
						
						signUpResponse.put("is_successful", "1");
						signUpResponse.put("message", "User created successful.");
					}
					else{
						signUpResponse.put("is_successful", "0");
						signUpResponse.put("message", "Login to platform failed for New User.");
					}
					
				} else {
					signUpResponse.put("is_successful", "0");
					signUpResponse.put("message", "User Creation Failed! OTP does not match with the user name.");
				}
			} else {
				signUpResponse.put("is_successful", "0");
				signUpResponse.put("message", "User Creation Failed! Root username or password is incorrect.");
			}

			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(signUpResponse);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process fail " + e.getMessage());
			message.setValid(true);

			return message;
		}
	}
}
