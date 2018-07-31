/**
 * This package contain  class as Component is used to call the Other API's of OauthEngine and XfusionPlatForm
 */
package com.springiot.http.client;

/**
 * To Import Classes to access their functionality
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * This class use as Component to call all API's of OauthEngine and
 * XfusionPlatForm and return their responses
 * 
 * @author Ankita Shrothi
 *
 */
@Component
public class HttpURLCalling {

	/**
	 * getData() to get the url and passingParameter to call API's
	 * 
	 * @param url
	 * @param passingParameter
	 * @return response
	 */
	public String getData(String url, String passingParameter, Map<String, String> headerMap) {

		try {
			URL urlToCall = new URL(url);

			HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

			// add reuqest header
			httpConectionWithUrl.setRequestMethod("POST");
			httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			System.out.println("Header map is " + headerMap);

			if (headerMap != null) {
				for (String Key : headerMap.keySet()) {
					httpConectionWithUrl.setRequestProperty(Key, headerMap.get(Key));
				}
			}

			/*
			 * To add headers to call other API's
			 */

			String urlParameters = passingParameter;

			// Send post request
			httpConectionWithUrl.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			/**
			 * To Get Response Code from called API
			 */
			int responseCode = httpConectionWithUrl.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			/**
			 * If dosen't get success code than return null
			 */
			if (responseCode != 200) {
				return null;
			}
			/**
			 * To get the response from the API which was called
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConectionWithUrl.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			/**
			 * To Return the Response
			 */
			return response.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 * 
			 */
			e.printStackTrace();
			return e.getMessage();
		}

	}

}