/**
 * This package contain  class as Component is used to call the Other API's of OauthEngine and XfusionPlatForm
 */
package org.orchestration.http.client;

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
public class OrchestrationHttpURLCalling {

	/**
	 * getData() to get the url and passingParameter to call API's
	 * 
	 * @param url
	 * @param passingParameter
	 * @return response
	 */
	public String getOrchestrationData(String url, String passingParameter, Map<String, String> headerMap,
			String methodType) {
		StringBuilder responseString = new StringBuilder();
		try {

			URL urlToCall;
			if (methodType.equalsIgnoreCase("GET")) {
				String string = "";
				if (passingParameter.isEmpty() && url.contains("?")) {
					string = url;
				} else if (!passingParameter.isEmpty() && url.contains("?")) {
					string = url.concat("&" + passingParameter);
				} else {
					string = url.concat("?" + passingParameter);
				}

				System.out.println("string " + string);
				urlToCall = new URL(string);
			} else {
				urlToCall = new URL(url);
			}

			HttpURLConnection httpConectionWithUrl = (HttpURLConnection) urlToCall.openConnection();

			// add reuqest header

			if (methodType.equalsIgnoreCase("GET")) {
				httpConectionWithUrl.setRequestMethod("GET");

			}
			if (methodType.equalsIgnoreCase("POST")) {
				httpConectionWithUrl.setRequestMethod("POST");

			}
			if (methodType.equalsIgnoreCase("PUT")) {
				httpConectionWithUrl.setRequestMethod("PUT");
			}
			if (methodType.equalsIgnoreCase("DELETE")) {
				httpConectionWithUrl.setRequestMethod("DELETE");
			}

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
			// System.out.println("urlParameters" + urlParameters + "url" +
			// url);
			// Send post request
			if (methodType.equalsIgnoreCase("POST")) {
				httpConectionWithUrl.setDoOutput(true);
				httpConectionWithUrl.setRequestProperty("Content-Type", "application/json");
				DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
			}
			if (methodType.equalsIgnoreCase("PUT")) {
				httpConectionWithUrl.setRequestProperty("Content-Type", "application/json");
				httpConectionWithUrl.setRequestMethod("PUT");
				httpConectionWithUrl.setDoInput(true);
				httpConectionWithUrl.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(httpConectionWithUrl.getOutputStream());
				wr.writeBytes(urlParameters);
				wr.flush();
				wr.close();
			}

			/**
			 * To Get Response Code from called API
			 */
			int responseCode = httpConectionWithUrl.getResponseCode();
			System.out.println("Sending  request to URL : " + url);
			System.out.println("Sending  request to URL Type : " + httpConectionWithUrl.getRequestMethod());
			System.out.println("Sending parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			/**
			 * If dosen't get success code than return null
			 */

			/**
			 * To get the response from the API which was called
			 */
			if (responseCode != 200) {
				responseString.append(responseCode + ":" + " Issue Encountered in calling API ");
				return responseString.toString();
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(httpConectionWithUrl.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			response.append(String.valueOf("responseCode:" + responseCode));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			/**
			 * To Return the Response
			 */
			System.out.println("response" + response.toString());
			return response.toString();

		} catch (Exception e) {
			/**
			 * To Catch the exception if it was unable to process the request
			 * 
			 */
			e.printStackTrace();
			responseString.append("Error " + e.getMessage());
			return responseString.toString();

		}
	}

}
