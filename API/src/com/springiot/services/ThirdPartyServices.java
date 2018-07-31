/**
 * This package contain the Service class for for ThirdParty ApI's
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

@Service
public class ThirdPartyServices {
	/**
	 * To access functionality of following Class function
	 */

	@Autowired
	private GenericServices genericServices;

	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private URLParameter urlParameter;

	public Message tripManagement(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Message alertStatusReport(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		// Initialization of Message
		Message responseMessage = new Message();
		try {

			/*
			 * passingMap is used to store the input parameters from user which
			 * will be same as of the procedure being called upon.
			 */
			LinkedHashMap<String, String> passingMap = new LinkedHashMap<>();

			/*
			 * Adding some parameters to the map.
			 */
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.put("device_id", map.get("device_id"));

			// Initialization of Map and adding paramters to it

			// Initialization of map and is used to put the alerts data into
			// that map
			LinkedHashMap<String, String> alertsMap = new LinkedHashMap<>();
			alertsMap.put("device_id", map.get("device_id"));
			alertsMap.put("from_date", map.get("from_date"));
			alertsMap.put("end_date", map.get("end_date"));
			alertsMap.put("limit", map.get("limit"));
			alertsMap.put("offset", map.get("offset"));
			alertsMap.put("in_condition", map.get("in_condition"));

			// Response retrieved after calling Platform Api is store into
			// message class
			Message alertsReponse = genericServices.alertDeviceTypeGetAllLimit(alertsMap, request);
			// System.out.println("alertsReponse" + alertsReponse.getObject());
			List<Map<String, Object>> alertDataList = (List<Map<String, Object>>) alertsReponse.getObject();
			alertDataList.sort((Map<String, Object> o1, Map<String, Object> o2) -> o1.get("sys_timestamp").toString()
					.compareTo(o2.get("sys_timestamp").toString()));

			// for (Map<String, Object> alertDataListMap : alertDataList) {
			//
			// }

			// Set the success response
			responseMessage.setDescription("Process Success");
			responseMessage.setObject(alertDataList);
			responseMessage.setValid(true);
			return responseMessage;

			// Set the failure response

		}
		/*
		 * Handling the occurring exceptions.
		 */catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Error" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}

	/**
	 * This method is used to validate token from authorization engine respect
	 * to the persistent token.
	 * 
	 * @param parameterMap,the
	 *            map contains he input parameters required for the calling of
	 *            this procedure
	 * @param token_type,this
	 *            means that the token is for web or for mobile.
	 * @param request,the
	 *            http servlet request required for the headers.
	 * @param response,the
	 *            http servlet response required for the headers.
	 * @return responseMessage,the message class is returned as response.
	 */
	public Message validateToken(Map<String, String> parameterMap, Integer token_type, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("validateToken");

		// Initialization of Response Message
		Message responseMessage = new Message();

		// Remove access key from the map.
		parameterMap.remove("access_key");

		parameterMap.put("token", request.getHeader("token"));
		parameterMap.put("user_key", request.getHeader("user_key"));
		parameterMap.put("user_id", request.getHeader("user_id"));

		// Retrieve from where the request is coming to API
		String RequestType = request.getHeader("User-Agent");
		System.out.println("type" + RequestType);

		parameterMap.put("token_type", token_type.toString());

		try {
			// Initilaizing the String Builder
			StringBuilder passingParameter = new StringBuilder();

			Map<String, String> headerMap = new LinkedHashMap<>();

			for (String key : parameterMap.keySet()) {

				// Get the Authorization token
				headerMap.put("token", request.getHeader("token"));

				/*
				 * to append rest of the parameter
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put("user_key", parameterMap.get("user_key"));
					headerMap.put("user_id", parameterMap.get("user_id"));
				} else {
					passingParameter.append("&" + key + "=" + parameterMap.get(key));
				}

			}
			passingParameter.delete(0, 1);

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			System.out.println("passingParameter" + passingParameter);

			Object urlResponse = urlCalling.getData(urlParameter.getValidateToken(), passingParameter.toString(),
					headerMap);

			System.out.println("urlResponse" + urlResponse);

			@SuppressWarnings("serial")
			Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			@SuppressWarnings("unchecked")
			GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
					.fromJson(urlResponse.toString(), type);

			/*
			 * List<Object> listObjects = new ArrayList<>();
			 * listObjects.add(urlMessage.getObject());
			 */

			// Check if list of objects is not null and size greater then zero
			if (!urlResponse.toString().isEmpty() || urlResponse.toString().length() > 0) {
				// Set the response message for success
				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
				return responseMessage;

			}
			// Set the response message for failure
			else {
				responseMessage.setDescription("No Data Available");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(false);

				return responseMessage;
			}
		} catch (Exception e) {
			// Set the failure response
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}
	}
}
