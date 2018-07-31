/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

import java.lang.reflect.Type;
/**
 * To Import Classes to access their functionality
 */
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Platform's API and ThirdParty
 * Integration with platform
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class XFusionService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private URLParameter urlParameter;
	@Autowired
	Environment environment;

	private Map<String, Object> getPlatformQuery(LinkedHashMap<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		new Message();
		/*
		 * Initialize string builder to make parameter string to pass in calling API
		 */
		Map<String, Object> passainMap = new LinkedHashMap<>();
		StringBuilder passingParameter = new StringBuilder();
		/**
		 * To create Query String to call OAuth API
		 */
		Map<String, String> headerMap = new LinkedHashMap<>();
		for (String key : passingMap.keySet()) {

			/*
			 * To append Token in query String
			 */
			// passingParameter.append("token=" + token.getAccess_token());
			headerMap.put("token", request.getHeader("token"));
			/*
			 * 
			 * /* To append rest Parameter
			 */
			if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
				headerMap.put(key, passingMap.get(key));

			} else {
				passingParameter.append("&" + key + "=" + passingMap.get(key));
			}

		}

		passingParameter.deleteCharAt(0);
		/*
		 * Check if String is not empty
		 */
		if (!passingParameter.toString().isEmpty()) {

			/*
			 * return Passing String
			 */
			passainMap.put("passingHeader", headerMap);
			passainMap.put("passingString", passingParameter);

			return passainMap;
		}
		/**
		 * return null if something went wrong
		 */
		passainMap.put("passingHeader", headerMap);
		return passainMap;
	}
}