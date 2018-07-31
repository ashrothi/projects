/**
 * This package contain  class HttpURLCalling is used to calling Rest API and SoapApiCalling use to calling SOAP API  
 */
package org.streaming.notification.http.client;

/**
 * To Import Classes to access their functionality
 */
import java.io.BufferedReader;
import com.orchastration.logger.TCPLogger;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.streaming.json.JsonModification;
import org.streaming.rule.config.Configuration;

//import com.orchastration.logger.OrchastrationLogger;

/**
 * 
 * HttpURLCalling class use as Component to call all Rest API and return Response of API with Response code 
 * 
 * 
 * @author Sachin Nahar
 *
 */
public class HttpURLCalling {

	/**
	 * getData(String url, String data, Map<String, String> headerMap) method use to call API with given parameter
	 * 
	 * @param url:API URL
	 * @param data: API body template with parameter and its value
	 * @param headerMap: Header parameter of API
	 * @return response with response code ie. #$#reponse_code#$#reponse
	 */
	public String getData(String url, String data, Map<String, String> headerMap,String methodType) {

		StringBuilder builder = new StringBuilder();

		System.out.println("parameters========" + url + "------------------" + data + "----------------" + headerMap
				+"-----------"+ methodType);
		TCPLogger.logger.info("parameters========" + url + "------------------" + data + "----------------" + headerMap
				+"-----------"+ methodType);

		try {
			URL obj = new URL(url); //TO get URL
			
			if (methodType.equalsIgnoreCase("GET")) {
				String getURL = url.concat("?" + data);
				
				obj = new URL(getURL);
			} 		
		 
			HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

			if (methodType.equalsIgnoreCase("GET")) {
				connection.setRequestMethod("GET");
			}
			if (methodType.equalsIgnoreCase("POST")) {
				connection.setRequestMethod("POST");
				
			}
			if (methodType.equalsIgnoreCase("PUT")) {
				connection.setRequestMethod("PUT");
			}
			if (methodType.equalsIgnoreCase("DELETE")) {
				connection.setRequestMethod("DELETE");
			}

			connection.setRequestMethod(methodType); //set Request Method
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			TCPLogger.logger.info("Header map is " + headerMap);

			//set request header

			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			if (headerMap != null) {
				for (String iterable_element : headerMap.keySet()) {
					TCPLogger.logger.info(iterable_element + "->" + headerMap.get(iterable_element));
					connection.setRequestProperty(iterable_element, headerMap.get(iterable_element));
				}

			}

			
			String urlParameters = data; // set body parameter through body template
			// Send post request
			if (methodType.equalsIgnoreCase("POST")) {
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
			}
			if (methodType.equalsIgnoreCase("PUT")) {
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setRequestMethod("PUT");
				connection.setDoInput(true);
				connection.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
			}
			
			/**
			 * To Get Response Code from called API
			 */
			int responseCode = connection.getResponseCode();
			TCPLogger.logger.info("\nSending "+ methodType+" request to URL : " + url);
			TCPLogger.logger.info(methodType+ " parameters : " + urlParameters);
			TCPLogger.logger.info("Response Code : " + responseCode);

//			builder.append("#$#"+String.valueOf(responseCode));

			/**
			 * If dosen't get success code than return error response string
			 */
			
			List<String> responseCodeArrayList=Arrays.asList(Configuration.success_reponse_code());
			
//			if (responseCode != 200) {
			if (!responseCodeArrayList.contains(String.valueOf(responseCode))) {
				builder.append("#$#"+String.valueOf(responseCode));
				builder.append("#$#"+String.valueOf(responseCode)+" issue occure");
				return builder.toString();
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			HashMap<String, String> map=new HashMap<>();
			JsonModification.parse(String.valueOf(response), map);
			if(map.containsKey(Configuration.errorCode())){
				responseCode=Integer.parseInt(map.get(Configuration.errorCode()));
			}
			builder.append("#$#"+String.valueOf(responseCode));
			builder.append("#$#"+String.valueOf(response));
			
			
			/**
			 * To Return the Response
			 */
			return builder.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			*/
			e.printStackTrace();
			TCPLogger.printStream.append(e.getMessage());
			builder.append("Error Msg: " + e.getMessage() + "\n");
			
			return builder.toString();
		}

	}

}