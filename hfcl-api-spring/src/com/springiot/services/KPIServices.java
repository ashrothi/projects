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

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

@Service
public class KPIServices {
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

	@SuppressWarnings({ "unchecked", "serial" })
	public Message getDevicesByDatatype(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);
			/*
			 * Initialize response Message
			 */

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
			for (String key : passingMap.keySet()) {
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
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * to append token in query string
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					// System.out.println("!!!!!!!!!!" +
					// token.getAccess_token());

					headerMap.put("token", token.getAccess_token());
					headerMap.put("userKey", token.getUserKey());
					headerMap.put("user_id", token.getUser_id());
					/*
					 * to get accessKey
					 */
					accessKey = token.getAccess_key();
					passingParameter.append("&" + key + "=" + passingMap.get(key));
					continue;
				}
				/*
				 * To append rest of the parameters
				 */

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
			Object finalVehicleResponseMessage = urlCalling.getData(urlParameter.getDeviceGetMetadataStatusBytType(),
					passingParameter.toString(), headerMap);

//			System.out.println("!!!!!!!!!!!" + finalVehicleResponseMessage);

			/*
			 * To check if response in null or not
			 */
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
				/*
				 * to get response in List of Map
				 */
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription(urlMessage.getDescription());
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);
				} else {
					responseMessage.setDescription(urlMessage.getDescription());
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}

	public Message getcallAttemptsPerTrx(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();
		try {


			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			Map<String, Object> responseMap = new HashMap<>();
			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				if (deviceModelObject.size() > 0) {

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// System.out.println("total value " + total);

					responseMap.put("data", total);
				} else {

					responseMap.put("data", "0");
				}

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}

	public Message getcallSetupSuccessRate(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				String value = "";
				if (deviceModelObject.size() > 0) {
					value = deviceModelObject.get(deviceModelObject.size() - 1).get("current_value").toString();
				} else {
					value = "0";
				}

				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("data", value);

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}

		} catch (

		Exception e) {
			throw e;
		}
		return responseMessage;
	}

	public Message gettotalDownlinkData(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);
			// System.out.println("passingMap" + passingMap);

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				double finalValue;

				if (deviceModelObject.size() > 0) {
					

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// System.out.println("total value " + total);

					finalValue = total / 1024;
				} else {
					finalValue = 0;
				}

				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("data", finalValue);

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}
}