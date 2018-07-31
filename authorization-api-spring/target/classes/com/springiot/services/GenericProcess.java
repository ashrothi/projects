/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

import springfox.documentation.spring.web.json.Json;

import com.springiot.filter.ServerSideFiltering;

/**
 * This Class to Define GenericProcess Service For API's,used widely when the
 * generic procedures are being called.
 * 
 * @author tanvigarg
 *
 */

@Service
public class GenericProcess {

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
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result. Generic Procedure calling is used for the
	 * procedures of development database.
	 * 
	 * @param requestType,the
	 *            input procedure number which will be fetched from
	 *            mvc-dispatcher-servlet.xml file.
	 * @param map,
	 *            the input parameters required for procedure calling.
	 * 
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, returns the failure and success responses
	 * @throws Exception
	 */
	public Message GenericProcedureCalling(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// System.out.println("Generic Procedure Calling");

		// Initialization of Message class
		Message message = new Message();

		try {

			Message validateMessage = urlValidate(request, response);
			if (!validateMessage.isValid()) {
				return validateMessage;
			}
			// Instantiate the server filtering class
			ServerSideFiltering filter = new ServerSideFiltering();

			// Array of parameters
			Object[] storedProcedureParameter = null;

			// Initialization of map
			Map<String, Object> procedureRequestMap = processParameter.getMaps();

			// Initialization of ArrayList
			List<Object> parameterList = new ArrayList<>();

			String sql = null;
			String params = null;
			/*
			 * This matches the input parameters with the parameters of procedure and
			 * replacing them with the parameters provided by the user.
			 */
			if (procedureRequestMap.get(requestType) != null) {
				String value = procedureRequestMap.get(requestType).toString();

				// Manipulate sql procedure according to the parameter name wise
				params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));

				// Get the procedure values
				String sqlValue = value.substring(0, value.indexOf("("));
				String key = value.substring(value.indexOf("("));

				// Initialization of String Builder
				StringBuilder builder = new StringBuilder(
						key.replaceAll("[^,()]", "").replace(")", ",)").replace(",", "?,"));
				/*
				 * Check the value of params if empty or not
				 */
				if (params.isEmpty()) {
					sql = sqlValue + "()";

				} else {
					sql = sqlValue + "" + builder.deleteCharAt(builder.lastIndexOf(",")).toString();
				}
				System.out.println("\n Param :-" + params + "==" + sql);
			}

			/*
			 * Firstly split the parameters with comma,and then trim user_key and userId and
			 * manipulate according to our requirements and store it in a map.
			 */
			for (String checkString : params.split(",")) {

				// if (map == null) {
				// continue;
				// }
				/**
				 * To get Query String as per condition
				 */
				switch (checkString) {
				case "token":
					break;
				case "user_key":
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					break;
				case "user_id":
					parameterList.add(request.getHeader(checkString) != null ? request.getHeader(checkString) : null);
					break;

				default:

					if (!params.isEmpty()) {
						if (map.get(checkString.trim()) != null) {
							String value = map.get(checkString.trim());

							if (value.toString().isEmpty()) {
								parameterList.add(null);
							} else {
								parameterList.add(value);
							}
						} else {
							parameterList.add(null);
						}
					}
					break;
				}

				if (checkString.equalsIgnoreCase("in_condition")) {
					// Check map parameters is not null and should not be empty
					if (map.get(checkString) != null && !map.get(checkString).isEmpty()) {

						parameterList.add(filter.filterData(map.get(checkString.trim()).toString()));

						continue;
					}

				}
			}
			System.out.println("\n parameterList :-" + parameterList.toString() + "==" + sql);
			// Check the parameterList size is greater then zero
			if (parameterList.size() > 0) {
				storedProcedureParameter = parameterList.toArray();
			}

			// Check if procedure string is not null
			if (sql != null) {

				Object responseFromProcedure = null;
				// Check input parameters parameterList is null
				if (storedProcedureParameter == null) {
					responseFromProcedure = genericService.executeProcesure(null, sql);

				} else {
					responseFromProcedure = genericService.executeProcesure(null, sql, storedProcedureParameter);

				}

				// Set the success response of API
				if (responseFromProcedure != null) {
					message.setDescription("Process Success");
					message.setObject(responseFromProcedure);
					message.setValid(true);
					return message;
				} else {
					message.setDescription("Process Fail ");
					message.setValid(false);
					return message;
				}
			} else {
				message.setDescription("Process Fail ");
				message.setValid(false);
				return message;
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			// Set the failure response
			e.printStackTrace();
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
			// throw e;
		}
	}

	/**
	 * This method is used to validate access key for URL Permissions
	 * 
	 * @param requestType,the
	 *            procedure needs to be called
	 * @param map,the
	 *            input parameters specified by the user
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Message urlValidate(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Initialization of Message class
		Message message = new Message();

		try {
			/**
			 * To get procedure map
			 */
			Map<String, Object> proMap = processParameter.getMaps();
			/**
			 * to get req url
			 */
			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			Boolean valid = false;
			String applicationKey = "19ab64ac-588e-11e6-85b9-fe984cc15272";
			if (request.getHeader("token") == null||request.getHeader("token").toString().equalsIgnoreCase("")) {
				message.setDescription("Process Success");
				message.setObject(valid);
				message.setValid(true);
				return message;
			}
			//
			String hsqlQueryAccessKey = "select access_key,role_id,user_key,user_id from TokenStorage.auth_token where access_token='"
					+ String.valueOf(request.getHeader("token")) + "' and application_key='" + applicationKey + "';";

			// Casting the response to List<Object>
			List<Map<String, Object>> getTokenQuery = (List<Map<String, Object>>) genericService
					.executeHSqlSelectQuery(hsqlQueryAccessKey);

			System.out.println("getTokenQuery " + getTokenQuery);

			if (getTokenQuery.size()== 0) {
				Message message1 = tokenValidate(request, response);
				
				System.out.println("message1 "+message1.getObject().toString());
			}

			String accessKey = String.valueOf(getTokenQuery.get(0).get("ACCESS_KEY"));

			String roleId = String.valueOf(getTokenQuery.get(0).get("ROLE_ID"));

			request.setAttribute("access_key", accessKey);
			request.setAttribute("role_id", roleId);
			request.setAttribute("user_key", String.valueOf(getTokenQuery.get(0).get("USER_KEY")));
			request.setAttribute("user_id", String.valueOf(getTokenQuery.get(0).get("USER_ID")));
			/**
			 * To check if permission already exist or not
			 * 
			 */
			if (Constant.accessmap.get(request.getAttribute("access_key")) == null) {
				// /**
				// * to get role id
				// */
				// String roleId =
				// String.valueOf(request.getAttribute("role_id"));
				/**
				 * calling procedure to get api permissions
				 */
				Object apiCall = null;
				if (request.getHeader("user_key") == null) {
					apiCall = genericService.executeProcesure(null, proMap.get("94").toString(),
							request.getAttribute("user_key").toString(), request.getAttribute("user_id").toString(),
							roleId);
				} else {
					apiCall = genericService.executeProcesure(null, proMap.get("94").toString(),
							request.getHeader("user_key").toString(), request.getHeader("user_id").toString(), roleId);
				}

				// Check result retrieved from procedure is not null
				if (apiCall != null) {

					ObjectMapper objectMapper = new ObjectMapper();
					String json = objectMapper.writeValueAsString(apiCall);
					// System.out.println("json" + json);
					Constant.accessmap.put(String.valueOf(request.getAttribute("access_key")), json);

				}

			}
			/**
			 * to put permission in Map
			 */
			System.out
					.println("API Permission " + Constant.accessmap.get(request.getAttribute("access_key")).toString());
			System.out.println("URI " + URI + "is contain " + Constant.accessmap.get(request.getAttribute("access_key"))
					.toString().contains("\"" + URI + "\""));
			if (Constant.accessmap.get(request.getAttribute("access_key")).toString().contains("\"" + URI + "\"")) {
				valid = true;

				message.setDescription("Process Success");
				message.setObject(valid);
				message.setValid(true);

			} else {
				List<Map<String, Object>> responseMapList = new ArrayList<>();
				Map<String, Object> responseMap = new HashMap<>();

				// Set the response
				responseMap.put("msg", "you don't have permission to access this api");
				responseMap.put("url_status", false);
				responseMap.put("code", 28);
				responseMapList.add(responseMap);
				message.setDescription("Process Success");
				message.setObject(responseMapList);
				message.setValid(false);

			}
			return message;
		} catch (Exception exception) {
			// Set the failure response
			exception.printStackTrace();
			message.setDescription(exception.getMessage());
			message.setValid(false);
			return message;
		}

	}

	@SuppressWarnings("unchecked")
	public Message tokenValidate(HttpServletRequest request, HttpServletResponse response) {
		Message message = new Message();

		String applicationKey = "19ab64ac-588e-11e6-85b9-fe984cc15272";

		String updateQuery = "UPDATE TokenStorage.auth_token SET time=now() where access_token='"
				+ request.getHeader("token") + "'and application_key='" + applicationKey + "';";
		// System.out.println("!!!!!" + hsqlQuery);

		// Casting the response to List<Object>
		int getToken = (int) genericService.executeHSqlQuery(updateQuery);
		// System.out.println("getToken + " + getToken);
		// Check the row size retrieved from HSQL
		if (getToken == 0) {

			// Retrieve from where the request is coming to API String
			String type = request.getHeader("User-Agent");
			// System.out.println("type" + type);

			try {

				Integer tokenType;
				if (type.contains("okhttp")) {
					tokenType = 1;
				} else {
					tokenType = 0;
				}

				// Calling of Authorization API and get the results in
				// the Message class.

				Object tokenValidation = genericService.executeProcesure(null,
						processParameter.getMaps().get("82").toString(), request.getHeader("user_key"),
						request.getHeader("user_id"), request.getHeader("token"), applicationKey, tokenType);

				// Casting the response to the List<Map>
				List<Map<String, Object>> listRespone = (List<Map<String, Object>>) tokenValidation;
				System.out.println("listRespone : " + listRespone);

				if (String.valueOf(listRespone.get(0).get("status")).equalsIgnoreCase("0")) {
					// 401 response for unauthorization

					message.setValid(false);
					return message;

				} else {
					String hsql = "insert into TokenStorage.auth_token (access_token,role_id,user_key,user_id,access_key,token_type,application_key,time) values ('"
							+ listRespone.get(0).get("access_token").toString() + "','"
							+ String.valueOf(listRespone.get(0).get("roles_id")) + "','"
							+ listRespone.get(0).get("user_key") + "','" + listRespone.get(0).get("user_id") + "','"
							+ listRespone.get(0).get("access_key") + "','" + tokenType + "','" + applicationKey
							+ "',now())";
					System.out.println("hsql is" + hsql);

					Object tokenPersistent = genericService.executeHSqlQuery(hsql);

					request.setAttribute("access_key", String.valueOf(listRespone.get(0).get("access_key")));
					request.setAttribute("role_id", String.valueOf(listRespone.get(0).get("roles_id")));
					request.setAttribute("user_key", String.valueOf(listRespone.get(0).get("user_key")));
					request.setAttribute("user_id", String.valueOf(listRespone.get(0).get("user_id")));
					message.setValid(true);
					return message;
					// chain.doFilter(request, response);

				}

			} catch (Exception exception) {
				exception.printStackTrace();
				message.setValid(false);
				return message;

			}

		} else {

			String hsqlQueryAccessKey = "select access_key,role_id,user_key,user_id from TokenStorage.auth_token where access_token='"
					+ request.getHeader("token") + "' and application_key='" + applicationKey + "';";

			// Casting the response to List<Object>
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> getTokenQuery = (List<Map<String, Object>>) genericService
					.executeHSqlSelectQuery(hsqlQueryAccessKey);
			// System.out.println("getTokenQuery " + getTokenQuery);
			String accessKey = String.valueOf(getTokenQuery.get(0).get("ACCESS_KEY"));

			String roleId = String.valueOf(getTokenQuery.get(0).get("ROLE_ID"));

			request.setAttribute("access_key", accessKey);
			request.setAttribute("role_id", roleId);
			request.setAttribute("user_key", String.valueOf(getTokenQuery.get(0).get("USER_KEY")));
			request.setAttribute("user_id", String.valueOf(getTokenQuery.get(0).get("USER_ID")));
			message.setValid(true);
			return message;
			// chain.doFilter(request, response);
		}
	}
}