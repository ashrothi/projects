/**
 * This package contains class is used to set the request type of API.
 */
package com.springiot.http.client;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.*;

/**
 * This class is used to set the request type of API.
 *
 */
@Component
public class HttpURLCalling {

	/**
	 * getData() to get the url and data to call API's
	 * 
	 * @param url
	 * @param data
	 * @return response
	 */
	public String getData(String url, String data) {

		try {
			/*
			 * Initialize object of class URL.
			 */
			URL obj = new URL(url);
			// HttpsURLConnection con = (HttpsURLConnection)
			// obj.openConnection();
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Add request header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = data;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
//			System.out.println("\nSending 'POST' request to URL : " + url);
//			System.out.println("Post parameters : " + urlParameters);
//			System.out.println("Response Code : " + responseCode);

			if (responseCode != 200) {
				return null;
			}
			/*
			 * Read the input request.
			 */
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			/*
			 * Return the response.
			 */
			return response.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
