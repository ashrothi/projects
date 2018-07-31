/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

import java.util.Base64;
/**
 * To Import Classes to access their functionality
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.request.model.Message;

/**
 * This class work as a Service class for OAUth Engine's API and ThirdParty
 * Integration
 * 
 * @author Mandeep Singh
 */
@Service
@Transactional
public class AuthTokenServices {
	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;
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
	public Message oauthToken(String merchant_key, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			Message responseMessage = new Message();
			Map<String, String> passingMap = new HashMap<>();
			/**
			 * Checking if string contains BASIC
			 */
			if (merchant_key.contains("Basic")) {
				merchant_key = merchant_key.substring(5, merchant_key.length());
			}
			final String uuid = UUID.randomUUID().toString();
			Map<String, String> map = new LinkedHashMap<>();
			map.put("merchant_key", merchant_key.trim());
			map.put("token", uuid);
			
			Message message = genericProcess.GenericThirdPartyProcedureCalling("1", map, null, request, response);
			System.out.println("---------"+message);
			/*byte [] authArr = Base64.getDecoder().decode(merchant_key.trim()); 
			String auth = new String(authArr);
		    System.out.println("authorization header: " + auth);
		    
		    String user = auth.split(":")[0];
		    String pass = auth.split(":")[1];
		    
			passingMap.put("username", user);
			passingMap.put("password", pass);
			
			*//**
			 * Calling OL Core validateUser Method to Authenticate the user
			 *//*
			ResponseEntity<?> responseMessage = methodService.validateUser(user, pass, request, response);
			
			if (responseMessage.getStatusCode() != HttpStatus.UNAUTHORIZED) {
				Map<String, Object> formattedList = (Map<String, Object>) responseMessage.getBody();

				if (formattedList.get("is_valid").toString().equalsIgnoreCase("1")) {
					System.out.println("user valid");
				}
			}*/
			passingMap.put("msg", "User is valid.");
			passingMap.put("token", uuid);
			
			responseMessage.setObject(passingMap);
			responseMessage.setValid(true);
			
			return responseMessage;
	}
	
	/**
	 * To get the Authentication parameter from header coming as Basic with
	 * encoded string in base64
	 * 
	 * @param encodedString
	 * @return
	 */
	public static HashMap<String, String> authenticate(String encodedString) {
		/**
		 * Initializing the return Map
		 */
		HashMap<String, String> returnMap = new HashMap<>();
		try {
			/**
			 * Checking if string contains BASIC
			 */
			System.out.println(encodedString);
			if (encodedString.contains("Basic")) {
				encodedString = encodedString.substring(5, encodedString.length());
			}
			/**
			 * Breaking String to get user_name and password
			 */
			byte[] bytearr = Base64.getDecoder().decode(encodedString.trim());
			String authString = new String(bytearr);
			/**
			 * To get user_name
			 */
			String user = authString.split(":")[0];
			/**
			 * To get password
			 */
			String pass = authString.split(":")[1];
			/**
			 * Putting user_name and password in return MAp
			 */
			returnMap.put("user_name", user);
			returnMap.put("password", pass);

		} catch (Exception e) {
			/**
			 * To Print Exception if it comes
			 */
			System.out.println(org.apache.log4j.Level.ERROR);
			System.out.println(Priority.ERROR);
			e.printStackTrace();
		}
		/**
		 * Returns MAP containing user_name and password.
		 */
		return returnMap;
	}
}