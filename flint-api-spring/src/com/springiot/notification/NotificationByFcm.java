/**
 * This package contain  class for Sending Notification
 */
package com.springiot.notification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * To Import Classes to access their functionality
 */
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springiot.domain.TemplateSwagger;
import com.springiot.response.Message;

import in.teramatrix.mailing.SendEmail;

/**
 * 
 * This class is for Sending Notification To Android App for different Actions
 * Performed in Apllication
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class NotificationByFcm {
	@Autowired
	Environment environment;
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
		System.out.println("json" + json);
		/**
		 * To send Notification
		 */
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		conn.getOutputStream();
		int responseCode = conn.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		/**
		 * To Return the Response
		 */
		System.out.println(response.toString());
		System.out.println("Message Sent::::::::::::::::::::" + responseCode);
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public Boolean sendMail(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Initialization of message class
		 */
		Message message = new Message();
		try {

			// boolean flag = SendEmail.email(Username, Password, Socket
			// Port, Socket Class, AuthEmail, EmailHost, EmailPort,
			// builder, To, CC, BCC, Attachment, Subject, Message,
			// Message From Status, Message From, Message To, null);
			/**
			 * To send Email
			 */
			map.put("emails", map.get("emails"));
			String[] toEmail = String.valueOf(map.get("emails")).split(",");
			String[] ccEmail = String.valueOf(environment.getProperty("mail.smtp.email.cc")).split(",");
			String[] bccEmail = String.valueOf(map.get("emails")).split(",");
			/**
			 * To set email template
			 */
			TemplateSwagger templateReport = new TemplateSwagger();

			boolean flag = false;
			StringBuilder builder = new StringBuilder();
			if (map.containsKey("new")) {

				String responsedata = templateReport.TemplateReportFile("template/emailAlertTemplate.vm", map);
				flag = SendEmail.email(String.valueOf(environment.getProperty("mail.smtp.username")),
						String.valueOf(environment.getProperty("mail.smtp.password")),
						String.valueOf(environment.getProperty("mail.socket.port")),
						String.valueOf(environment.getProperty("mail.socket.class")),
						String.valueOf(environment.getProperty("mail.smtp.auth")),
						String.valueOf(environment.getProperty("mail.smtp.detail")),
						String.valueOf(environment.getProperty("mail.smtp.port")), builder, toEmail, ccEmail, bccEmail,
						null, String.valueOf(environment.getProperty("mail.smtp.email.subject.alert")), responsedata,
						String.valueOf(environment.getProperty("mail.smtp.email.status")),
						String.valueOf(environment.getProperty("mail.smtp.from")), "ankita.shrothi@teramatrix.in",
						null);
			}
			if (map.containsKey("assigned_email_status")) {
				String responsedata = templateReport.TemplateReportFile("template/emailSosTemplate.vm", map);
				flag = SendEmail.email(String.valueOf(environment.getProperty("mail.smtp.username")),
						String.valueOf(environment.getProperty("mail.smtp.password")),
						String.valueOf(environment.getProperty("mail.socket.port")),
						String.valueOf(environment.getProperty("mail.socket.class")),
						String.valueOf(environment.getProperty("mail.smtp.auth")),
						String.valueOf(environment.getProperty("mail.smtp.detail")),
						String.valueOf(environment.getProperty("mail.smtp.port")), builder, toEmail, ccEmail, bccEmail,
						null, String.valueOf(environment.getProperty("mail.smtp.email.subject.sos")), responsedata,
						String.valueOf(environment.getProperty("mail.smtp.email.status")),
						String.valueOf(environment.getProperty("mail.smtp.from")), "ankita.shrothi@teramatrix.in",
						null);

			}
			if (map.containsKey("delivered_email")) {

				String responsedata = templateReport.TemplateReportFile("template/delivered.vm", map);
				flag = SendEmail.email(String.valueOf(environment.getProperty("mail.smtp.username")),
						String.valueOf(environment.getProperty("mail.smtp.password")),
						String.valueOf(environment.getProperty("mail.socket.port")),
						String.valueOf(environment.getProperty("mail.socket.class")),
						String.valueOf(environment.getProperty("mail.smtp.auth")),
						String.valueOf(environment.getProperty("mail.smtp.detail")),
						String.valueOf(environment.getProperty("mail.smtp.port")), builder, toEmail, ccEmail, bccEmail,
						null, String.valueOf(environment.getProperty("mail.smtp.email.subject.deleiver")), responsedata,
						String.valueOf(environment.getProperty("mail.smtp.email.status")),
						String.valueOf(environment.getProperty("mail.smtp.from")), "ankita.shrothi@teramatrix.in",
						null);
			}
			System.out.println("flag:- " + flag);
			if (flag == true) {

				return true;
			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
