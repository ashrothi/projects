package com.springiot.services;

import java.lang.reflect.Type;
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

import io.swagger.annotations.ApiImplicitParam;

/**
 * 
 * @author mandeepsingh
 *
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
	 * 
	 * @param passingMap
	 * @param request
	 * @param response
	 * @return
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
			} else if (existsThirdParty == 0 && existsPlatform != 0){
				orgCheck.put("message", "Organization doesn't exists in platform.");
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
	 * 
	 * @param passingMap
	 * @param request
	 * @param response
	 * @return
	 */
	public Message signUpProcess(Map<String, String> passingMap, HttpServletRequest request, HttpServletResponse response){
		Message message = new Message();
		int userCreationCode = 0;
		String authResponse = "";
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
			
			System.out.println("Calling API: "+urlParameter.getAuthURL());
			System.out.println("Parameters: "+authLoginParameter);
			System.out.println("Headers: "+"Empty");
			String authLoginResponseMessage = urlCalling.getData(urlParameter.getAuthURL(), authLoginParameter.toString(), new LinkedHashMap<>());
			System.out.println("Response: " + authLoginResponseMessage);
			
			if (authLoginResponseMessage != null) {
				// Casting response in required format
				Type type = new TypeToken<Map<String,Object>>() {
				}.getType();
				// Getting response in formatted way
				Map<String,Object> urlMessage = (Map<String,Object>) new Gson()
						.fromJson(authLoginResponseMessage, type);
				// to get response in List of Map
				authResponse = urlMessage.get("description").toString();
			}

			if(authResponse.equals("Login Success")){
				/*
				 * passingMap is used to store the input parameters from user which
				 * will be same as of the procedure being called upon.
				 */
				LinkedHashMap<String, String> userCreationMap = new LinkedHashMap<>();

				/*
				 * Adding some parameters to the map.
				 */
				userCreationMap.put("token", request.getHeader("token"));
				userCreationMap.put("user_key", request.getHeader("user_key"));
				userCreationMap.put("user_id", request.getHeader("user_id"));
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
					// Retrieving the xFusion Platform Token
					headerMap.put("token", request.getHeader("token"));

					// To append rest of the parameters
					if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
						headerMap.put(key, userCreationMap.get(key));

					} else {
						passingParameter.append("&" + key + "=" + userCreationMap.get(key));
					}
				}

				passingParameter.deleteCharAt(0);

				System.out.println("Calling API: "+urlParameter.getPlatformUserCreation());
				System.out.println("Parameters: "+passingParameter);
				System.out.println("Headers: "+headerMap);
				// Calling XfusionPlatform's API to get the data
				String userCreationResponseMessage = urlCalling.getData(urlParameter.getPlatformUserCreation(), passingParameter.toString(), headerMap);
				System.out.println("Response: " + userCreationResponseMessage);
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
					LinkedHashMap<String, String> authLogoutMap = new LinkedHashMap<>();
					
					authLogoutMap.put("token", request.getHeader("token"));
					authLogoutMap.put("user_key", request.getHeader("user_key"));
					authLogoutMap.put("user_id", request.getHeader("user_id"));
					StringBuilder authLogoutParameter = new StringBuilder();

					for (String key : authLogoutMap.keySet()) {
						authLogoutParameter.append("&" + key + "=" + authLogoutMap.get(key));
					}
					
					System.out.println("Calling API: " + urlParameter.getAuthLogout());
					System.out.println("Parameters: "+authLogoutParameter);
					System.out.println("Headers: "+headerMap);
					Object authLogoutResponse = urlCalling.getData(urlParameter.getAuthLogout(), authLogoutParameter.toString(),
							headerMap);
					System.out.println("Response: " + authLogoutResponse);
					
					LinkedHashMap<String, String> loginMap = new LinkedHashMap<>();
					loginMap.put("user_name", passingMap.get("new_user_name"));
					loginMap.put("password", passingMap.get("password"));
					loginMap.put("application_id", passingMap.get("application_id"));
					StringBuilder loginParameter = new StringBuilder();

					for (String key : loginMap.keySet()) {
						loginParameter.append("&" + key + "=" + loginMap.get(key));
					}
					System.out.println("Calling API: "+urlParameter.getPlatformLogin());
					System.out.println("Parameters: "+loginParameter);
					System.out.println("Headers: " + "empty");
					String loginResponse = urlCalling.getData(urlParameter.getPlatformLogin(), loginParameter.toString(),
							new LinkedHashMap<>());
					System.out.println("Response: " + loginResponse);
					if (loginResponse != null) {
						// Casting response in required format
						Type type = new TypeToken<Map<String,Object>>() {
						}.getType();
						// Getting response in formatted way
						Map<String,Object> urlMessage = (Map<String,Object>) new Gson()
								.fromJson(loginResponse, type);
						// to get response in List of Map
						userAuthResponse = urlMessage.get("description").toString();
					}
					if(userAuthResponse.equals("Login Success")){
						LinkedHashMap<String, String> orgInsertMap = new LinkedHashMap<>();
						orgInsertMap.put("organization_name", passingMap.get("organization_name"));
						orgInsertMap.put("city", passingMap.get("city"));
						orgInsertMap.put("country", passingMap.get("country"));
						orgInsertMap.put("description", passingMap.get("description"));
						orgInsertMap.put("color_code", passingMap.get("color_code"));
						StringBuilder orgInsertParameter = new StringBuilder();

						for (String key : orgInsertMap.keySet()) {
							orgInsertParameter.append("&" + key + "=" + orgInsertMap.get(key));
						}
						System.out.println("Calling API: "+urlParameter.getPlatformOrgInsert());
						System.out.println("Parameters: "+orgInsertParameter);
						System.out.println("Headers: "+headerMap);
						Object orgInsertResponse = urlCalling.getData(urlParameter.getPlatformOrgInsert(), orgInsertParameter.toString(),
								headerMap);
						System.out.println("Response: " + orgInsertResponse);					
						
						LinkedHashMap<String, String> orgMappingMap = new LinkedHashMap<>();
						
						orgMappingMap.put("insert_userKey", passingMap.get("insert_user_key"));
						orgMappingMap.put("insert_user_id", passingMap.get("insert_user_id"));
						orgMappingMap.put("organization_ids", passingMap.get("organization_ids"));
						orgMappingMap.put("access_key", passingMap.get("access_key"));
						StringBuilder orgMappingParameter = new StringBuilder();

						for (String key : orgMappingMap.keySet()) {
							orgMappingParameter.append("&" + key + "=" + orgMappingMap.get(key));
						}
						System.out.println("Calling API: "+urlParameter.getPlatformUserOrgMapping());
						System.out.println("Parameters: "+orgMappingParameter);
						System.out.println("Headers: "+headerMap);
						Object orgMappingResponse = urlCalling.getData(urlParameter.getPlatformUserOrgMapping(), orgMappingParameter.toString(),
								headerMap);
						System.out.println("Response: " + orgMappingResponse);

						LinkedHashMap<String, String> inheritTemplateMap = new LinkedHashMap<>();
						
						inheritTemplateMap.put("template_id", passingMap.get("template_id"));
						inheritTemplateMap.put("template_name", passingMap.get("template_name"));
						inheritTemplateMap.put("model_name", passingMap.get("model_name"));
						
						StringBuilder inheritTemplateParameter = new StringBuilder();

						for (String key : inheritTemplateMap.keySet()) {
							inheritTemplateParameter.append("&" + key + "=" + inheritTemplateMap.get(key));
						}
						System.out.println("Calling API: "+urlParameter.getPlatformInheritTemplate());
						System.out.println("Parameters: "+inheritTemplateParameter);
						System.out.println("Headers: "+headerMap);
						Object inheritTemplateResponse = urlCalling.getData(urlParameter.getPlatformInheritTemplate(), inheritTemplateParameter.toString(),
								headerMap);
						System.out.println("Response: " + inheritTemplateResponse);

						Map<String, String> gtZoomSignupMap = new HashMap<String, String>();
						gtZoomSignupMap.put("organization_name", passingMap.get("organization_name"));
						gtZoomSignupMap.put("currency", passingMap.get("currency"));
						gtZoomSignupMap.put("time_format", passingMap.get("time_format"));
						gtZoomSignupMap.put("user_key",	request.getHeader("user_key"));
						gtZoomSignupMap.put("user_id", request.getHeader("user_id"));
						gtZoomSignupMap.put("user_name", passingMap.get("new_user_name"));
						gtZoomSignupMap.put("user_image", passingMap.get("image_path"));
						gtZoomSignupMap.put("role_id", passingMap.get("role_id"));
						gtZoomSignupMap.put("role_name", passingMap.get("role_name"));
						gtZoomSignupMap.put("fleet_size", passingMap.get("fleet_size"));
						gtZoomSignupMap.put("gender", passingMap.get("gender"));
						gtZoomSignupMap.put("phone_number", passingMap.get("preferred_number"));
						
						System.out.println("Proc Parameters: " + gtZoomSignupMap);
						Message gtZoomSignup = genericProcess.GenericProcedureCalling("26", gtZoomSignupMap, null, request, response);
						List<Map<String, Object>> thirdPartySignupResponse = (List<Map<String, Object>>) gtZoomSignup.getObject();
						System.out.println("Response from proc: " + thirdPartySignupResponse);
						
						LinkedHashMap<String, String> platLogoutMap = new LinkedHashMap<>();
						
						platLogoutMap.put("token", request.getHeader("token"));
						platLogoutMap.put("user_key", request.getHeader("user_key"));
						platLogoutMap.put("user_id", request.getHeader("user_id"));
						StringBuilder platLogoutParameter = new StringBuilder();

						for (String key : platLogoutMap.keySet()) {
							platLogoutParameter.append("&" + key + "=" + platLogoutMap.get(key));
						}
						System.out.println("Calling API: " + urlParameter.getPlatformLogout());
						System.out.println("Parameters: " + platLogoutParameter);
						System.out.println("Headers: " + headerMap);
						Object platLogoutResponse = urlCalling.getData(urlParameter.getPlatformLogout(), platLogoutParameter.toString(),
								headerMap);
						System.out.println("Response: " + platLogoutResponse);
					}

				} else {
					message.setDescription("Process Success");
					message.setValid(true);
					message.setObject("User Creation Failed! OTP does not match with the user name.");
					return message;
				}
			} else {
				message.setDescription("Process Success");
				message.setValid(true);
				message.setObject("User Creation Failed! Root username or password is incorrect.");
				return message;
			}
			
			
			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject("");
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Process fail " + e.getMessage());
			message.setValid(true);

			return message;
		}
	}
}
