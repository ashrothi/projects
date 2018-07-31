/**
 * @author Garima Joshi
 * This package contains the classes which is used as services in which business logic is implemented and to use these 
 * functionalities other classes autowired these service classes.
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
import org.springframework.transaction.annotation.Transactional;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessage;
import com.springiot.response.Message;

/**
 * This class is used to interact with Oauth Engine for the Authentication and
 * Authorization by generating token and validate the same.
 */
@Service
@Transactional
@SuppressWarnings({ "unchecked", "unused", "serial" })
@PropertySource(value = "/WEB-INF/download.properties")
public class TokenServices {
	/**
	 * To access functionality of HttpURLCalling class
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of urlParameter Class.
	 */
	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private ProcessParameter processParameter;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private com.springiot.genericService.GenericService genericService;
	@Autowired
	private UrlValidationKeyService urlValidationKeyService;
	@Autowired
	Environment environment;
	/**
	 * This method is used to provide token when third party Application
	 * interacts with Oauth Engine.
	 * 
	 * @param res
	 * @param req
	 * 
	 * @param username,
	 *            Contains the user name.
	 * @param password,
	 *            Contains the password.
	 * @param applicationid,
	 *            Contains the application ID.
	 * @return Message, Return the response message.
	 * 
	 */

	public Message oauthToken(String username, String password, String applicationid, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		/*
		 * Initialize the object of class Message which will store the response
		 * of method.
		 */

		Message responseMessage = new Message();
		/*
		 * To handle exceptions, try-catch block is used.
		 */
		try {

			// Retrieve from where the request is coming to API
			String RequestType = req.getHeader("User-Agent");
			// System.out.println("type" + RequestType);

			Integer tokenType;
			if (RequestType.contains("okhttp")) {
				tokenType = 1;
			} else {
				tokenType = 0;
			}

			// System.out.println("Before caLLING oauth api" +
			// System.currentTimeMillis());

			/*
			 * Create single string which contains user name, password and
			 * application id.
			 */
			String inputParams = "user_name=" + username.trim() + "&password=" + password.trim() + "&application_id="
					+ applicationid.trim() + "&token_type=" + tokenType;

			// System.out.println("Input params" + inputParams);

			/*
			 * Execute the API of Oauth engine's to validate the user and store
			 * its response in object.
			 */
			Object executeQuery = urlCalling.getData(urlParameter.getGatewayauthURL(), inputParams, null);

			Type type1 = new TypeToken<Message>() {
			}.getType();

			Message oauthResponse = new Gson().fromJson(executeQuery.toString(), type1);

			System.out.println("oauthMap" + oauthResponse.getObject());

			/*
			 * Check if executeQuery is not null.
			 */
			if (oauthResponse.isValid()) {

				/*
				 * Check if genericMessage is valid or not.
				 */

				Map<String, Object> oauthMap = (Map<String, Object>) oauthResponse.getObject();
				// System.out.println("Before caLLING organization procedure
				// api" + System.currentTimeMillis());

				if (oauthMap.get("status").toString().equalsIgnoreCase("true")) {

					List<Map<String, Object>> organizationMap = (List<Map<String, Object>>) genericService
							.executeProcesureFromMetaData(null, processParameter.getMaps().get("24").toString(),
									oauthMap.get("user_id"), oauthMap.get("user_key"));

					// System.out.println("getOrganizationId" +
					// getOrganizationId);

					// List<Map<String, Object>> organizationMap =
					// (List<Map<String, Object>>) getOrganizationId;

					Integer organisationId;

					if (organizationMap.size() > 0) {

						organisationId = (Integer) organizationMap.get(0).get("organization_id");
						oauthMap.putAll(organizationMap.get(0));
					} else {
						organisationId = 0;
					}

					// System.out.println("Before insert query " +
					// System.currentTimeMillis());

					req.setAttribute("organization_id", organisationId);
					String getPermissionParam = "role_id=" + oauthMap.get("roles_id");
					Map<String, String> headerMap = new LinkedHashMap<>();

					// Get the Authorization Engine token
					headerMap.put("token", String.valueOf(oauthMap.get("access_token")));
					headerMap.put("user_key", String.valueOf(oauthMap.get("user_key")));
					headerMap.put("user_id", String.valueOf(oauthMap.get("user_id")));
					if (Constant.accessmap.containsKey(oauthMap.get("access_key").toString())) {
						Object accessPermision = urlCalling.getData(urlParameter.getGetAllPermisions(),
								getPermissionParam, headerMap);
						// System.out.println("accessPermision " +
						// accessPermision);

						Constant.accessmap.put(oauthMap.get("access_key").toString(), accessPermision);
					}

					String hsql = "insert into TokenStorage.platform_token (access_token,role_id,user_key,user_id,access_key,token_type,application_key,organization_id,time) values ('"
							+ oauthMap.get("access_token") + "','" + oauthMap.get("roles_id") + "','"
							+ oauthMap.get("user_key") + "','" + oauthMap.get("user_id") + "','"
							+ oauthMap.get("access_key") + "','" + tokenType + "','" + applicationid + "','"
							+ organisationId + "',now())";
					// System.out.println("hsql is" + hsql);

					Object tokenPersistent = genericService.executeHSqlQuery(hsql);

				}

				responseMessage.setDescription(oauthResponse.getDescription());
				responseMessage.setObject(oauthMap);
				responseMessage.setValid(true);

			} else {

				responseMessage.setDescription(oauthResponse.getDescription());
				responseMessage.setObject(oauthResponse.getObject());
				responseMessage.setValid(false);
			}

		} catch (Exception exception) {
			exception.printStackTrace();
			responseMessage.setDescription(exception.getMessage());
			responseMessage.setValid(false);

		}

		return responseMessage;
	}

	/**
	 * This method is used to provide the functionality of forget password.
	 * 
	 * @param username,
	 *            Contains the user name.
	 * @param password,
	 *            Contains the password.
	 * @param applicationid,
	 *            Contains the application ID.
	 * @return Message, Return the response message.
	 * 
	 */
	public Message forgotPassword(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Message responseMessage = new Message();
		try {
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			// Calling of OAuth Engine API and get the result in Object
			// urlResponseResult
			Object urlResponseResult = urlCalling.getData(urlParameter.getForgotPassword(), queryString, headerMap);

			// Check if response returned from API is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);
				if (urlMessage.isValid()) {

					responseMessage.setDescription("Process Success");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);
					return responseMessage;
				} else {
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * This method is used to update password and uses Authorization Engine to
	 * perform the task for updation in password.
	 * 
	 * @param map,contains
	 *            the input parameters.
	 * @return message
	 */

	public Message passwordUpdate(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Message responseMessage = new Message();
		try {

			map.put("token", request.getHeader("token"));
			map.put("user_key", request.getHeader("user_key"));
			map.put("user_id", request.getHeader("user_id"));

			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");
			// Get the result of calling OAuth Engine API
			Object urlResponseResult = urlCalling.getData(urlParameter.getChangePassword(), queryString, headerMap);

			// Check if API's response is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					// Set the response Message for the success
					responseMessage.setDescription("Updated Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					// Set the response Message for the failure
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
					return responseMessage;
				}
			}
		} catch (Exception e) {
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		// Set the response Message for the failure
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * This method is used to reset password,after calling Oauth Engine API's
	 * 
	 * @param map,contains
	 *            input parameters specified by user.
	 * @return message
	 */
	public Message passwordReset(Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Message responseMessage = new Message();
		try {

			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(map, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			// Calling of OAuth Engine API
			Object urlResponseResult = urlCalling.getData(urlParameter.getResetPassword(), queryString, headerMap);

			// Check the response from API is null or not
			if (urlResponseResult != null) {

				Message urlMessage = (Message) new Gson().fromJson(urlResponseResult.toString(), Message.class);

				if (urlMessage.isValid()) {
					// Set the response Message for the success
					responseMessage.setDescription("Reset Successfully");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);

					return responseMessage;
				} else {
					// Set the response Message for the failure
					responseMessage.setDescription("Not Found");
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);

					return responseMessage;
				}
			}

		} catch (Exception e) {
			// Set the response Message for the failure
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
		// Set the response Message for the failure
		responseMessage.setDescription("Process Fail");
		responseMessage.setValid(false);
		return responseMessage;
	}

	public Message oauthTokenExpire(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Initialization of Response Message
		Message responseMessage = new Message();

		try {

			// Initializing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			headerMap.put("user_key", request.getHeader("user_key"));
			headerMap.put("user_id", request.getHeader("user_id"));
			// Get the Authorization token
			headerMap.put("token", request.getHeader("token"));

			String tokenFromHeader = request.getHeader("token");

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			// System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getTokenExpire(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			String query = "delete from TokenStorage.platform_token where access_token='" + tokenFromHeader + "';";
			// System.out.println("!!!!!" + query);

			Object accessKeyQueryResponse = genericService.executeHSqlQuery(query);

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(urlResponse);
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}
}