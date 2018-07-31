/**
 * This package contain  class HttpURLCalling is used to calling Rest API and SoapApiCalling use to calling SOAP API  
 */
package org.orchestration.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

//import com.orchastration.logger.OrchastrationLogger;

/**
 * 
 * SoapApiCalling class use as Component to call all SOAP API and return
 * Response of API with Response code
 * 
 * 
 * @author Sachin
 *
 */
@Component
public class OrchestrationSoapApiCalling {
	Logger logger = Logger.getLogger(OrchestrationSoapApiCalling.class);

	/**
	 * getData(String url, String data, Map<String, String> headerMap) method
	 * use to call SOAP API with given parameter
	 * 
	 * @param url:API
	 *            URL
	 * @param data:
	 *            API body template with parameter and its value
	 * @param headerMap:
	 *            Header parameter of API
	 * @return response with response code ie. #$#reponse_code#$#reponse
	 */
	public String getData(String url, String data, Map<String, String> headerMap) {

		StringBuilder builder = new StringBuilder();

		logger.info("update url:" + url);
		logger.info("parameters========" + url + "------------------" + data + "----------------" + headerMap);

		try {
			String soapURL = url;

			URL obj = new URL(soapURL); // To get URL

			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			connection.setRequestMethod("POST");// set Request Method
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setRequestProperty("content-type", "text/xml; charset=utf-8");
			// set
			// Content
			// Type
			// XML
			connection.setRequestProperty("SOAPAction", headerMap.get("soapAction"));
			// set
			// Content
			// Type
			// XML

			logger.info("Header map is " + headerMap);

			// set request header
			/*
			 * if (headerMap != null) { for (String key : headerMap.keySet()) {
			 * connection.setRequestProperty(key, headerMap.get(key).trim()); }
			 * 
			 * }
			 */

			String urlParameters = data;// set body parameter through body
										// template
			// Send post request
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			/**
			 * To Get Response Code from called API
			 */
			int responseCode = connection.getResponseCode();
			logger.info("\nSending 'POST' request to URL : " + url);
			logger.info("Post parameters : " + urlParameters);
			logger.info("Response Code : " + responseCode);

			// builder.append("#$#" + String.valueOf(responseCode));

			/**
			 * If dosen't get success code than return error response string
			 */
			if (responseCode != 200) {
				builder.append(responseCode + ":" + " Issue Encountered in calling API ");
				return builder.toString();
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			response.append(String.valueOf("responseCode:" + responseCode));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			builder.append(StringEscapeUtils.unescapeXml(String.valueOf(response)));
			logger.info("Response  : " + builder.toString());
			/**
			 * To Return the Response
			 */
			return builder.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 * 
			 */
			e.printStackTrace();
			builder.append("Error Msg: " + e.getMessage() + "\n");

			return builder.toString();
		}

	}
}