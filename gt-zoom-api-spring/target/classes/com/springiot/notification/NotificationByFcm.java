/**
 * This package contain  class for Sending Notification
 */
package com.springiot.notification;

/**
 * To Import Classes to access their functionality
 */
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 * 
 * This class is for Sending Notification To Android App for different Actions
 * Performed in Apllication
 * 
 * @author Ankita Shrothi
 *
 */
public class NotificationByFcm {
	// Method to send Notifications from server to client end.

	public final static String AUTH_KEY_FCM = "AIzaSyCSgx7M5SiqW2rSe9HkainuJ8No3BhmAkQ";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	// userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification(String userDeviceIdKey, Object datatoSend) throws Exception {
		/**
		 * Fcm Credentials
		 */
		String authKey = "AIzaSyCSgx7M5SiqW2rSe9HkainuJ8No3BhmAkQ";
		String FMCurl = "https://fcm.googleapis.com/fcm/send";
		/**
		 * To call Fcm Url
		 */
		URL url = new URL(FMCurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		/**
		 * To set connection Property
		 */
		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + authKey);
		conn.setRequestProperty("Content-Type", "application/json");
		/*
		 * To set data to send in Notification
		 */
		JSONObject json = new JSONObject();
		json.put("to", userDeviceIdKey.trim());
		json.put("data", datatoSend);
		// System.out.println("json" + json);
		/**
		 * To send Notification
		 */
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		conn.getOutputStream();

		System.out.println("Message Sent::::::::::::::::::::");
	}

}
