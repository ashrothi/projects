/**
 * 
 */
package com.springiot.http.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Mandeep Singh
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
	public String getData(String url, String data,Map<String, String> headerMap) {

		try {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			System.out.println("headerMap: " + headerMap);
			if (headerMap != null) {
				for (String Key : headerMap.keySet()) {
					con.setRequestProperty(Key, headerMap.get(Key));
				}
			}
			String urlParameters = data;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			if (responseCode != 200) {
				return null;
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			return response.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
