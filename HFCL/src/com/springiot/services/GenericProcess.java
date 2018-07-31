package com.springiot.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

@Service
public class GenericProcess {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;
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

	@SuppressWarnings({ "unchecked", "serial" })
	public List<Map<String, Object>> getPlatformData(Map<String, Object> xfusionPassingMap, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();

			/*
			 * Initialize access_key
			 */
			String accessKey = "";
			/*
			 * to create Passing Parameter Query String
			 */
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : xfusionPassingMap.keySet()) {
				/*
				 * Retrieving the xFusion Platform Token
				 */
				if (request.getHeader("token") != null) {
					/*
					 * to get platform token
					 */
					Token token = (Token) Constant.xfusionPaleteform.get(request.getHeader("token").trim());
					/*
					 * to check if token is null and send error response
					 */
					if (token == null) {
						return null;
					}
					/*
					 * to append token in query string
					 */

					headerMap.put("token", token.getAccess_token());
					headerMap.put("userKey", token.getUserKey());
					headerMap.put("user_id", token.getUser_id());
					/*
					 * to get accessKey
					 */
					accessKey = token.getAccess_key();

					/*
					 * To append rest of the parameters
					 */

					// System.out.println("key" + key);

					passingParameter.append("&" + key + "=" + xfusionPassingMap.get(key));

					continue;
				}

			}

			/*
			 * to append access_key in query string
			 */
			passingParameter.append("&" + "access_key" + "=" + accessKey);

			/*
			 * Printing passing parameter query string
			 */
			passingParameter.delete(0, 1);
			/*
			 * Calling XfusionPlatform Performance Service Status Devices Get
			 * Many API to get the data
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(urlParameter.getPerformanceService(),
					passingParameter.toString(), headerMap);
			if (finalVehicleResponseMessage != null) {

				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

				// System.out.println("finalVehicleResponseMessage
				// ------------------------------------ \n"
				// + finalVehicleResponseMessage);
				return deviceModelObject;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	/**
	 * GenericProcedureCalling() method is used to return the Result when API is
	 * being hit and return the result. Generic Procedure calling is used for
	 * the procedures of development database.
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

			
			// Array of parameters
			Object[] storedProcedureParameter = null;

			// Initialization of map
			Map<String, Object> procedureRequestMap = processParameter.getMaps();

			// Initialization of ArrayList
			List<Object> parameterList = new ArrayList<>();

			String sql = null;
			String params = null;
			/*
			 * This matches the input parameters with the parameters of
			 * procedure and replacing them with the parameters provided by the
			 * user.
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
			 * Firstly split the parameters with comma,and then trim user_key
			 * and userId and manipulate according to our requirements and store
			 * it in a map.
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

}
