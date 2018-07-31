/**
 * 
 */
package com.springiot.service.processing;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * @author Mandeep Singh
 *
 */
public class GeoAddress {
	public static String getLocationInfo(double lat, double lng) {

		HttpGet httpGet = new HttpGet("https://maps.google.com/maps/api/geocode/json?latlng=" + lat + "," + lng
				+ "&key=AIzaSyB_wLlgJHLiIM8NuTS0O7l1NlPRYjptUYY&sensor=false");

		//System.out.println("hhtp" + httpGet.getMethod().toString());
		HttpClient client = new DefaultHttpClient();
		HttpResponse response;
		StringBuilder streamDataBuilder = new StringBuilder();
		try {
			response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			InputStream inputStream = entity.getContent();

			int streamReaderCounter;
			while ((streamReaderCounter = inputStream.read()) != -1) {
				streamDataBuilder.append((char) streamReaderCounter);

			}

		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}

		String streamDataString = streamDataBuilder.toString();

		JsonObject jsonStreamDataObject = (JsonObject) new JsonParser().parse(streamDataString);
		//System.out.println("jsonStreamDataObject" + jsonStreamDataObject.toString());
		JsonArray locationJsonArray;

		String formatted_Adddress = "";
		try {
			/**
			 * locationJsonArray store results key value of jsonStreamDataObject
			 * in Array
			 */

			locationJsonArray = jsonStreamDataObject.getAsJsonArray("results");
			System.out.println("locationJsonArray" + locationJsonArray);
			for (JsonElement jsonElement : locationJsonArray) {
				/**
				 * Getting formatted_address
				 */
				formatted_Adddress = jsonElement.getAsJsonObject().get("formatted_address").toString();

				System.out.println("Getting Address" + jsonElement.getAsJsonObject().get("formatted_address"));
				break;

			}

		} catch (JsonIOException e) {

		}

		return formatted_Adddress;
	}

}
