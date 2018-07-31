/**
 * This package contain the service class for command Api.
 */
package com.springiot.services;

import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerMapping;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessage;
import com.springiot.response.Message;

/**
 * This class is defined as service which is used to call Grafana APIs related
 * to user mapping Apis.
 * 
 * @author tanvigarg
 */
@Service
public class GrafanaService {
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private URLParameter grafanaParameter;
	/**
	 * To access functionality of Generic Service.
	 */
	@Autowired
	private HttpURLCalling urlCalling;
	@Autowired
	private GenericProcess genericProcess;
	/**
	 * This is a generic method to call the Grafana APIs related to user mapping
	 * in grafana interface.
	 * 
	 * @param parameterMap,contains
	 *            all the input parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Message callGrafanaAPIs(Map<String, String> parameterMap, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of Response Message
		Message responseMessage = new Message();

		try {

			String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			// System.out.println("restOfTheUrl" + restOfTheUrl);

			String apiBaseUrl = grafanaParameter.getGrafanaAPI();
			// System.out.println("apiBaseUrl" + apiBaseUrl);

			String apiUrl = apiBaseUrl + restOfTheUrl;
			// System.out.println("apiUrl--" + apiUrl);

			// Initializing the String Builder
			Map<String, Object> queryStringMAp = genericProcess.getOAuthQuery(parameterMap, request, response);
			String queryString = queryStringMAp.get("passingString").toString();

			Map<String, String> headerMap = (Map<String, String>) queryStringMAp.get("passingHeader");

			/*
			 * Calling of Authorization Engine API and retrieve the results in
			 * Object urlResponseResult
			 */
			Object urlResponseResult = urlCalling.getData(apiUrl,queryString, headerMap);
			// System.out.println("Grafana API Response--" + urlResponseResult);

			@SuppressWarnings("serial")
			Type type = new TypeToken<GenericMessage<Map<String, Object>>>() {
			}.getType();

			// Convert the response retrieved after calling api is stored //
			// into Map

			GenericMessage<Map<String, Object>> urlMessage = (GenericMessage<Map<String, Object>>) new Gson()
					.fromJson(urlResponseResult.toString(), type);

			if (urlMessage.isValid()) {

				responseMessage.setDescription("Process Success");
				responseMessage.setObject(urlMessage.getObject());
				responseMessage.setValid(true);
			}

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		return responseMessage;
	}
}
