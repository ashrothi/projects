/**
 * This package contains the class for calling the API.
 */
package com.teramatrix.apiCalling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.teramatrix.logger.HfclLogger;
import com.teramatrix.main.HfclEscalationApp;

/**
 * The class is used for calling Rest APIs. Also the class is used to get the
 * auth token from the platform.
 * 
 * @author Mandeep Singh
 *
 */
public class AccessRestApi {

	/**
	 * This method is used for calling the API where parameters are sent as key
	 * value pair.
	 *
	 * @param URL
	 *            : Here pass API URL here.
	 * @param params
	 *            : Here pass map of parameters to send on API.
	 * @return Output string retrieved from API.
	 */
	public String callingRestAPI(String URL, HashMap<String, String> params) {

		StringBuilder result = new StringBuilder("");
		try {

			/**
			 * Initialize the URL and create connection.
			 */
			System.out.println("url:" + URL);
			URL url = new URL(URL);
			/**
			 * Set properties for HTTP connection.
			 */
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");

			StringBuilder urlParams = new StringBuilder();
			/**
			 * Split the parameters in key value parameters.
			 */
			if (params.size() != 0) {

				for (String key : params.keySet()) {
					// System.out.println("key : " + key + ", value :" +
					// params.get(key));
					urlParams.append(key + "=" + params.get(key) + "&");
				}
				urlParams.deleteCharAt(urlParams.lastIndexOf("&"));
				// System.out.println(urlParams);
			}
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(urlParams.toString().getBytes());
			outputStream.flush();
			// System.out.println(connection.getInputStream().toString());

			/**
			 * Check for response code.
			 */
			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

				// System.out.println("Response Code is: " +
				// connection.getResponseCode());
			} else {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			/**
			 * Store output of API into the buffer reader and print it line by
			 * line.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			// System.out.println("Output from Server .... \n");
			String output = "";
			while ((output = reader.readLine()) != null) {
				// System.out.println(output);
				result.append(output);
			}

			/**
			 * Close the HTTP connection.
			 */
			connection.disconnect();

			System.out.println("API called.");
			return result.toString();

		} catch (Exception exception) {
			System.out.println("API Connection Refused");
			exception.printStackTrace();

			return result.toString();
		}
	}

	/**
	 * This method is used for calling the API where parameters are sent as key
	 * value pair.
	 *
	 * @param URL
	 *            : Here pass API URL here.
	 * @param params
	 *            : Here pass map of parameters to send on API.
	 * @return Output string retrieved from API.
	 */
	public String callingRestAPIWithHeaders(String URL, HashMap<String, String> params) {

		StringBuilder result = new StringBuilder("");
		try {

			/**
			 * Initialize the URL and create connection.
			 */
			HfclLogger.logger.info("\n ** Api Url:" + URL);
			URL url = new URL(URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("token", getAuthToken());
			connection.setRequestProperty("user_id", HfclEscalationApp.authUserName);
			connection.setRequestProperty("userKey", HfclEscalationApp.userKey);

			StringBuilder urlParams = new StringBuilder();
			/**
			 * Split the parameters in key value parameters.
			 */
			if (params.size() != 0) {

				for (String key : params.keySet()) {
					urlParams.append(key + "=" + params.get(key) + "&");
				}
				urlParams.deleteCharAt(urlParams.lastIndexOf("&"));

			}

			HfclLogger.logger.info("Para:   " + urlParams);
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(urlParams.toString().getBytes());
			outputStream.flush();

			/**
			 * Check for response code.
			 */
			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

				HfclLogger.logger.info("Response Code is:   " + connection.getResponseCode());
			} else {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			/**
			 * Store output of API into the buffer reader and print it line by
			 * line.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			String output = "";
			while ((output = reader.readLine()) != null) {
				// System.out.println(output);
				result.append(output);
			}

			/**
			 * Close the connection
			 */
			connection.disconnect();

			// System.out.println("API called.");
			return result.toString();

		} catch (Exception exception) {
			System.out.println("API Connection Refused: " + exception);
			exception.printStackTrace();

			return result.toString();
		}
	}

	/**
	 * This method is used for getting Auth token for accessing Rest APIs of
	 * xFusion Platform by sending username, password and application id.
	 * 
	 * @return Auth Token retrieved from the API.
	 */
	public String getAuthToken() {

		String authEngineUrl = HfclEscalationApp.authApiUrl;

		/**
		 * Initialize the HashMap for storing parameters to get Auth Token.
		 */
		HashMap<String, String> authEngineparams = new LinkedHashMap<String, String>();
		authEngineparams.put("username", HfclEscalationApp.authUserName);
		authEngineparams.put("password", HfclEscalationApp.authPassword);
		authEngineparams.put("applicationid", HfclEscalationApp.applicationID);

		/**
		 * Initializing the object of this class to call the method for calling
		 * API.
		 */
		AccessRestApi accessRestAPI = new AccessRestApi();
		String authTokenString = accessRestAPI.callingRestAPI(authEngineUrl, authEngineparams);

		/**
		 * Retrieving the auth token from the response of API.
		 */
		String authToken = getAccessToken(authTokenString);

		System.out.println("Token : " + authToken);

		return authToken;
	}

	/**
	 * This method is used for getting Auth token for accessing Rest APIs of
	 * xFusion Platform by sending username, password and application id.
	 * 
	 * @param jsonString
	 *            : Here pass the response from API.
	 * @return Access Token from the string.
	 */
	public static String getAccessToken(String jsonString) {
		JSONObject outerObject;
		String result = new String();
		try {
			outerObject = new JSONObject(jsonString);

			return outerObject.getJSONObject("object").get("access_token").toString();
		} catch (JSONException e) {
			System.out.println("object is null inside access token");
			e.printStackTrace();
			return result;
		}
	}
}