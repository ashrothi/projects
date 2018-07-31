/**
 * This package contain  class as Component is used to call the Other API's of OauthEngine and XfusionPlatForm
 */
package org.goup.http.client;

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
 * This class use as Component to call all API's of End Nodes and return their
 * responses
 * 
 * @author Ankita Shrothi
 *
 */
@Component
public class HttpURLCalling {

	/**
	 * This Method is used to Call the API's of End Node Server with Their
	 * Request Method Type
	 * 
	 * @param url
	 * @param passingParameter
	 * @param headerMap
	 * @return
	 */
	public String getData(String url, String passingParameter, Map<String, String> headerMap) {

		try {
			URL urlToCall = new URL(url);

			HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

			// add reuqest header
			httpConectionWithUrl.setRequestMethod("POST");
			httpConectionWithUrl.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			if (headerMap != null) {
				for (String iterable_element : headerMap.keySet()) {
					System.out.println(iterable_element + "->" + headerMap.get(iterable_element));
					httpConectionWithUrl.setRequestProperty(iterable_element, headerMap.get(iterable_element));
				}

			}

			/*
			 * To add headers to call other API's
			 */

			String urlParameters = passingParameter;
			System.out.println("urlParameters" + urlParameters + "url" + url);
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
