/**
 * This package contains the class for calling rest APIS.
 */
package in.teramatrix.barc.apicalling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import java.io.OutputStream;

import com.google.gson.Gson;

import in.teramatrix.barc.logger.BarcLogger;

/**
 * This class is used for calling rest APIs. Here Defined the restAPIs URL. In
 * this class create Http connection to send parameters to API.
 * 
 * @author Mandeep Singh
 */
public class AccessRestAPI {

	/**
	 * This is default constructor of the class.
	 */
	public AccessRestAPI() {

	}

	/**
	 * This method is used for Calling API by making HTTP connection and sending required paramaters in JSON format.
	 * 
	 * @param jsonData : Here pass the parameters. 
	 * @param URL : Here pass the APIs URL.
	 * @param method : Here pass the request method is get or post.
	 * @return Boolean state, API is called or not.
	 */
	public static String callingAPI(String apiUrl, HashMap<String, Object> jsonData, String method) {

		StringBuilder result = new StringBuilder("");
		try {
			/**
			 * Initialize the URL and create connection.
			 */
			URL url = new URL(apiUrl);
			BarcLogger.logger.info("API Url: " + url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setDoOutput(true);
			connection.setRequestMethod(method);
			connection.setRequestProperty("Content-Type", "application/json");

			/**
			 * Initialize the Gson containing token and store its content in
			 * String type variable input.
			 */
			String input = new Gson().toJson(jsonData).toString();
			BarcLogger.logger.info("Final json: " + input);

			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();
			//System.out.println(connection.getInputStream().toString());

			/**
			 * Check for response code.
			 */
			if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {

				BarcLogger.logger.info("Response Code is:   " + connection.getResponseCode());
			} else {
				throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
			}

			/**
			 * Initialize bufferreader to handle the response retrieved from API.
			 */
			BufferedReader reader = new BufferedReader(new InputStreamReader((connection.getInputStream())));
			String output = "";
			//System.out.println("Output from Server :- ");

			while ((output = reader.readLine()) != null) {
				//System.out.println(output);
				result.append(output);
			}

			/**
			 * Close the connection.
			 */
			connection.disconnect();

			return result.toString();

		} catch (Exception exception) {
			BarcLogger.logger.info("API Connection Refused");
			exception.printStackTrace(BarcLogger.printStream);
			
			return result.toString();
		}
	}
}