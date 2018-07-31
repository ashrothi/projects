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
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
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

}
