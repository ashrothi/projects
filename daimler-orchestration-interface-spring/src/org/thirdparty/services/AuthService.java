/**
 * This Package contains Services of Third Party Orchestration Method.
 */
package org.thirdparty.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.orchestration.services.GenericMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

/**
 * This Class is to Authenticate the User By Getting Encoded String From User
 * and Send it to OL Core for authorization.
 * 
 * @author Ankita Shrothi
 *
 */
@SuppressWarnings({ "deprecation" })
public class AuthService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	Environment environment;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired(required = true)
	private GenericMethodService methodService;
	
	static Logger logger = Logger.getLogger(AuthService.class);
	/**
	 * This Method is used to Authenticate the user.User Needs to Pass user_name
	 * and password
	 * 
	 * @param user_name
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ResponseEntity<?> authenticateUser(String user_name, String password, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/**
		 * Defining parameterMap to get the user_name and password from the
		 * encoded String
		 */

		Map<String, String> parameterMap = new LinkedHashMap<>();
		/**
		 * to get the user_name
		 */
		byte[] userarr = Base64.getDecoder().decode(user_name);
		String user = new String(userarr);
		/**
		 * to get the password
		 */
		byte[] passarr = Base64.getDecoder().decode(password);
		String pass = new String(passarr);
		/**
		 * To put the user_name and password in parameterMap
		 */
		parameterMap.put("user_name", user);
		parameterMap.put("password", pass);
		/**
		 * Calling OL Core validateUser Method to Authenticate the user
		 */
		ResponseEntity<?> responseMessage = methodService.validateUser(user, pass, request, response);
		/**
		 * Return response
		 */
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
			if (encodedString.contains("Basic")) {
				encodedString = encodedString.substring(5, encodedString.length());
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
			}
			

		} catch (Exception e) {
			/**
			 * To Print Exception if it comes
			 */
			logger.setLevel(org.apache.log4j.Level.ERROR);
			logger.setPriority(Priority.ERROR);
			logger.error("ERROR", e);
			e.printStackTrace();
		}
		/**
		 * Returns MAP containing user_name and password.
		 */
		return returnMap;
	}
}
