package com.rld.accessapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import com.rld.common.CommonInterface;

/* 
 * Class is used to build the connection with the Rest Api and get the data from the same.
 * The parameters of Api is in HashMap which will be provided by user and  check the response code of Api.
*/

public class AccessRestAPI implements CommonInterface {
	/*
	 * CallingRestApi method has two parameters,one is URL of Api and other one
	 * is input parameters of Api
	 */
	@Override
	public String callingRestAPI(String URL, HashMap<String, String> params) {

		StringBuilder result_restApi = new StringBuilder("");
		try {

			// Initializing the URL of Api.
			System.out.println("url:" + URL);
			URL url = new URL(URL);

			// Create a connection with Api.
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Api Request Type Description
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("charset", "utf-8");

			// Input Parameters of Api in Map
			StringBuilder urlParams = new StringBuilder();
			if (params.size() != 0) {

				for (String key : params.keySet()) {
					// System.out.println("key : " + key + ", value :" +
					// params.get(key));
					urlParams.append(key + "=" + params.get(key) + "&");
				}
				urlParams.deleteCharAt(urlParams.lastIndexOf("&"));
				System.out.println("URL Params : " + urlParams);
			}
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(urlParams.toString().getBytes());
			outputStream.flush();
			// System.out.println(connection.getInputStream().toString());

			// Check for response code of API

			System.out.println("connection.getResponseCode() :-" + connection.getResponseCode());
			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

				System.out.println("Response Code is:   " + connection.getResponseCode());

			} else {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

			String output = "";
			while ((output = reader.readLine()) != null) {
				// System.out.println(output);
				result_restApi.append(output);
			}

			/**
			 * Close the connection
			 */
			connection.disconnect();

			// Return true if executed successfully.
			return result_restApi.toString();

		} catch (Exception exception) {

			System.out.println("API Connection Refused");
			exception.printStackTrace();
			result_restApi.append(exception.getMessage());

			return result_restApi.toString();
		}
	}
}
