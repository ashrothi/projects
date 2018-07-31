/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This Class to Define TokenServices to validate token for the respective API's
 *
 */
@Service
@Transactional(readOnly = true)
@SuppressWarnings("unchecked")
public class TokenServices {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private ProcessParameter processParameter;

	/**
	 * oauthToken() method is used to generate token to validate user in
	 * Authorization Engine
	 * 
	 * @param token_type
	 * 
	 * @param req,the
	 *            request
	 * @param res,the
	 *            response
	 * @param username,the
	 *            user email id
	 * @param password,the
	 *            password
	 * @param applicationid,
	 *            the application key is required
	 * @param requestType,
	 *            the procedure number
	 * @return message
	 */
	@SuppressWarnings("unused")
	public Message oauthToken(HttpServletRequest request, HttpServletResponse response, String username,
			String password, String applicationid, Integer token_type, String requestType) {
		// Initialization of Message class
		Message message = new Message();

		try {

			// Get the procedures from mvc-dispatcher-servlet.xml file
			Map<String, Object> proMap = processParameter.getMaps();

			// Retrieve from where the request is coming to API
			String type = request.getHeader("User-Agent");

			Integer tokenType;
			if (token_type == null) {

				if (type.contains("okhttp")) {
					tokenType = 1;
				} else {
					tokenType = 0;
				}
			} else {
				tokenType = token_type;
			}

			// The response retrieved from procedure is stored in Object class
			Object responseFromprocedure = genericService.executeProcesure(null, proMap.get(requestType).toString(),
					username, password, applicationid, tokenType);
			System.out.println("responseFromprocedure " + responseFromprocedure);
			List<Map<String, String>> list = (List<Map<String, String>>) responseFromprocedure;

			// Check if user_key is not null
			if (list.get(0).get("user_key") != null) {

				String hsql = "insert into TokenStorage.auth_token (access_token,role_id,user_key,user_id,access_key,token_type,application_key,time) values ('"
						+ list.get(0).get("access_token").toString() + "','"
						+ String.valueOf(list.get(0).get("roles_id")) + "','" + list.get(0).get("user_key") + "','"
						+ list.get(0).get("user_id") + "','" + list.get(0).get("access_key") + "','" + tokenType + "','"
						+ applicationid + "',now())";
				// System.out.println("hsql is" + hsql);

				Object tokenPersistent = genericService.executeHSqlQuery(hsql);
				// System.out.println("tokenPersistent" +
				// tokenPersistent);

				Object apiCall = genericService.executeProcesure(null, proMap.get("94").toString(),
						list.get(0).get("user_key").toString(), list.get(0).get("user_id").toString(),
						String.valueOf(list.get(0).get("roles_id")));

				// Check result retrieved from procedure is not null
				if (apiCall != null) {
					ObjectMapper objectMapper = new ObjectMapper();
					String json = objectMapper.writeValueAsString(apiCall);
					Constant.accessmap.put(list.get(0).get("access_key"), json);

				}

				// Set the success response
				message.setDescription("Login Success");
				message.setObject(list.get(0));
				message.setValid(true);

				return message;
			}
			// Set the failure response
			else {
				message.setDescription("Login UnSuccess");
				message.setObject(list.get(0));
				message.setValid(true);

				return message;
			}

		}
		// Handing all exceptions
		catch (Exception e) {
			e.printStackTrace();
			// Set the failure response
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * oauthTokenExpire() method is used to check the expire of token
	 * 
	 * @param response
	 * @param request
	 * 
	 * @param map,the
	 *            input parameters required to call the API.
	 * @return message
	 */
	@SuppressWarnings("unused")
	public Message oauthTokenExpire(HttpServletRequest request, HttpServletResponse response) {
		// Initialize the message
		Message message = new Message();
		try {

			String tokenFromHeader = request.getHeader("token");

			String query = "delete from TokenStorage.auth_token where access_token='" + tokenFromHeader + "';";

			Object accessKeyQueryResponse = genericService.executeHSqlSelectQuery(query);

			Object object = genericService.executeProcesure(null, processParameter.getMaps().get("84").toString(),
					request.getHeader("user_key"), request.getHeader("user_id"), request.getHeader("token"));

			// System.out.println("object" + object);

			message.setDescription("Process Success");
			message.setObject(object);
			message.setValid(true);
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			message.setDescription(e.getMessage());
			message.setValid(false);

		}
		return message;
	}
}
