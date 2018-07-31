package com.springiot.services;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.URLParameter;
import com.springiot.domain.TemplateSwagger;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.notification.NotificationByFcm;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import in.teramatrix.mailing.SendEmail;

@Service
@PropertySource(value = "classpath:/UserCreate.properties")
public class ThirdPartyServices {
	@Autowired
	Environment environment;
	@Autowired
	private HttpURLCalling urlCalling;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private URLParameter urlParameter;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private TrackingServices trackingServices;

	/**
	 * This method is used to call Platform API
	 * 
	 * @param map,the
	 *            input paramters required to call the API
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "serial" })
	public Message getMetadataStatusByTypeLimit(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of message class
		Message responseMessage = new Message();
		try {
			/*
			 * Initialize passingParameter for query string
			 */
			StringBuilder passingParameter = new StringBuilder();
			Map<String, String> passingMap = new LinkedHashMap<>();
			passingMap.put("token", request.getHeader("token"));
			passingMap.put("user_key", request.getHeader("user_key"));
			passingMap.put("user_id", request.getHeader("user_id"));
			passingMap.putAll(map);

			String accesskey = "";
			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
			
					headerMap.put("token", request.getHeader("token"));
					
				/**
				 * Appending every parameter in passingParameter string builder
				 * to make query string
				 */
				if (key.trim().equals("user_key") || key.trim().equals("user_id")) {
					headerMap.put(key, passingMap.get(key));

				} else {
					passingParameter.append("&" + key + "=" + passingMap.get(key));
				}

			}
			passingParameter.append("&access_key=" + accesskey);
			passingParameter.deleteCharAt(0);
			/**
			 * to print the query string
			 */
			/**
			 * Calling the Platform API's for service data
			 */
			Object urlResponseServiceResult = urlCalling.getData(
					urlParameter.getXfusionPlatformDeviceGetMetadataStatusByTypeLimit(), passingParameter.toString(),
					headerMap);

			if (urlResponseServiceResult != null) {
				Type type = new TypeToken<GenericMessages<Map<String, String>>>() {
				}.getType();
				/**
				 * Casting response from platform of service API into json
				 */
				GenericMessages<Map<String, Object>> urlServiceMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(urlResponseServiceResult.toString(), type);

				// Set the success response
				responseMessage.setDescription(urlServiceMessage.getDescription());
				responseMessage.setObject(urlServiceMessage.getObject());
				responseMessage.setValid(true);
			}
		}
		// Handling all exceptions
		catch (Exception exception) {
			// Set the failure response
			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

	@SuppressWarnings({ "static-access", "unchecked" })
	public Message sendSOS(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Initialization of message class
		 */
		Message message = new Message();
		try {
			/**
			 * To get user details on the basis on License number and device id
			 */
			Message getUserDetailMessage = genericProcess.GenericProcedureCalling("11", map, null, request, response);
			/*
			 * To check if response is valid
			 */
			if (getUserDetailMessage.isValid()) {
				/**
				 * To Cast Response in List<Map<String, Object>>format
				 */
				List<Map<String, Object>> getUserDetailList = (List<Map<String, Object>>) getUserDetailMessage
						.getObject();
				if (getUserDetailList.size() > 0) {

					// boolean flag = SendEmail.email(Username, Password, Socket
					// Port, Socket Class, AuthEmail, EmailHost, EmailPort,
					// builder, To, CC, BCC, Attachment, Subject, Message,
					// Message From Status, Message From, Message To, null);
					/**
					 * To send Email
					 */
					String[] toEmail = String.valueOf(getUserDetailList.get(0).get("emails")).split(",");
					String[] ccEmail = String.valueOf(environment.getProperty("mail.smtp.email.cc")).split(",");
					String[] bccEmail = String.valueOf(getUserDetailList.get(0).get("emails")).split(",");
					/**
					 * To set email template
					 */
					TemplateSwagger templateReport = new TemplateSwagger();
					getUserDetailList.get(0).putAll(map);
					boolean flag;
					StringBuilder builder = new StringBuilder();
					if (map.containsKey("alert_type")) {

						Long last_online_time = (new Date().getTime() - Long.parseLong(map.get("last_online_time")))
								/ 60000;

						getUserDetailList.get(0).remove("last_online_time");
						getUserDetailList.get(0).put("last_online_time", last_online_time);
						String responsedata = templateReport.TemplateReportFile("template/emailAlertTemplate.vm",
								getUserDetailList.get(0));
						flag = SendEmail.email(String.valueOf(environment.getProperty("mail.smtp.username")),
								String.valueOf(environment.getProperty("mail.smtp.password")),
								String.valueOf(environment.getProperty("mail.socket.port")),
								String.valueOf(environment.getProperty("mail.socket.class")),
								String.valueOf(environment.getProperty("mail.smtp.auth")),
								String.valueOf(environment.getProperty("mail.smtp.detail")),
								String.valueOf(environment.getProperty("mail.smtp.port")), builder, toEmail, ccEmail,
								bccEmail, null,
								String.valueOf(environment.getProperty("mail.smtp.email.subject.alert")), responsedata,
								String.valueOf(environment.getProperty("mail.smtp.email.status")),
								"ankita.shrothi@teramatrix.in", "ankita.shrothi@teramatrix.in", null);
					} else {
						String responsedata = templateReport.TemplateReportFile("template/emailSosTemplate.vm",
								getUserDetailList.get(0));
						flag = SendEmail.email(String.valueOf(environment.getProperty("mail.smtp.username")),
								String.valueOf(environment.getProperty("mail.smtp.password")),
								String.valueOf(environment.getProperty("mail.socket.port")),
								String.valueOf(environment.getProperty("mail.socket.class")),
								String.valueOf(environment.getProperty("mail.smtp.auth")),
								String.valueOf(environment.getProperty("mail.smtp.detail")),
								String.valueOf(environment.getProperty("mail.smtp.port")), builder, toEmail, ccEmail,
								bccEmail, null, String.valueOf(environment.getProperty("mail.smtp.email.subject.sos")),
								responsedata, String.valueOf(environment.getProperty("mail.smtp.email.status")),
								String.valueOf(environment.getProperty("mail.smtp.from")),
								"ankita.shrothi@teramatrix.in", null);

					}

					System.out.println("flag:- " + flag);
					if (flag == true) {

						message.setDescription("Email Sent Successfully");
						message.setObject(getUserDetailList);
						message.setValid(true);
						return message;
					} else {
						message.setDescription("Email Issue Encountered");
						message.setValid(false);
						return message;
					}

				} else {
					message.setDescription("No User Detail From Database");
					message.setValid(false);
					return message;
				}

			} else {
				message.setDescription("Unable to fetch User Info");
				message.setValid(false);
				return message;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	@SuppressWarnings("unchecked")
	public Boolean pushFCMNotificationGeoFenceUpdate(Object object) throws Exception {
		Boolean status = false;
		try {

			/**
			 * to get responseFromUpdateGeoFence in List<Map<String, Object>>
			 * format
			 */
			List<Map<String, Object>> responseFromUpdateGeoFence = (List<Map<String, Object>>) object;

			if (responseFromUpdateGeoFence.size() > 0) {
				/*
				 * Calling Procedure to get Fcm Id
				 */
				System.out.println("responseFromUpdateGeoFence:-" + responseFromUpdateGeoFence
						+ responseFromUpdateGeoFence.get(0).get("geofence_id").toString());
				Map<String, String> passinMAp = new LinkedHashMap<>();
				passinMAp.put("geofence_id", String.valueOf(responseFromUpdateGeoFence.get(0).get("geofence_id")));

				Message message = genericProcess.GenericProcedureCalling("17", passinMAp, null, null, null);
				/*
				 * To return date and time in formatted way in response
				 */

				if (message.isValid()) {
					List<Map<String, Object>> responseFromUpdateGeoFenceGcmIds = (List<Map<String, Object>>) message
							.getObject();
					if (responseFromUpdateGeoFenceGcmIds != null && responseFromUpdateGeoFenceGcmIds.size() > 0) {
						/**
						 * To Push Notification
						 */
						for (Map<String, Object> map : responseFromUpdateGeoFenceGcmIds) {

							// System.out.println("responseForFCM :- " + map);
							String fcmID = String.valueOf(map.get("gcm_id"));

							/**
							 * Calling push Notification Method
							 */
							map.put("status", 1);
							NotificationByFcm.pushFCMNotification(fcmID, responseFromUpdateGeoFence.get(0));
							status = true;
						}
					}

				}

				/**
				 * TO check if message is not null
				 */

			} else {
				/**
				 * If no notification sent
				 */
				status = false;
			}

		} catch (Exception e) {
			/*
			 * to catch exception if it comes
			 */

			throw e;
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	public Message deviceLiveTrackingData(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * To get all active devices
			 */
			Message getDevice = genericProcess.GenericProcedureCalling("16", map, null, request, response);
			/*
			 * To Check if response is valid
			 */
			if (getDevice.isValid()) {
				/*
				 * To cast response in List of Map
				 */
				List<Map<String, Object>> getDeviceList = (List<Map<String, Object>>) getDevice.getObject();
				StringBuilder deviceList = new StringBuilder();
				/**
				 * To get all devices in String
				 */
				if (getDeviceList.size() > 0) {
					for (Map<String, Object> map2 : getDeviceList) {
						deviceList.append(map2.get("device_id") + ",");
					}
					deviceList.deleteCharAt(deviceList.lastIndexOf(","));
					/**
					 * Passing Parameter map to call Platform to get Performance
					 * status data of devices
					 */
					LinkedHashMap<String, String> passingNewMap = new LinkedHashMap<>();
					passingNewMap.put("token", request.getHeader("token"));
					passingNewMap.put("device_id", deviceList.toString());
					passingNewMap.put("user_key", request.getHeader("user_key"));
					passingNewMap.put("user_id", request.getHeader("user_id"));
					passingNewMap.put("service_name",
							"location_parameters,location_parameters,location_parameters,phone_parameters,host_status,phone_parameters");
					passingNewMap.put("data_source",
							"latitude,latitude,location_accuracy,device_battery_percentage,host_status,device_charging_status");
					passingNewMap.put("pivot_data_required", "1");

					/*
					 * Calling Performance Service Status Get Many api of
					 * Platform
					 */
					List<Map<String, String>> getPerformanceServiceStatusGetMany = trackingServices
							.getXfusionPerformanceServiceMultipleDevicesGetManyLiveTracking(passingNewMap,request,response);
					/*
					 * To print Platform response
					 */

					// System.out.println("getPerformanceServiceStatusGetMany:--
					// " + getPerformanceServiceStatusGetMany);
					/**
					 * Iterate Device List
					 */
					StringBuilder builder = new StringBuilder();
					for (Map<String, Object> getDeviceListMap : getDeviceList) {
						/*
						 * Iterate Platform List
						 */
						for (Map<String, String> getPerformanceServiceStatusGetManyMap : getPerformanceServiceStatusGetMany) {
							/**
							 * If device From both the list are same than add
							 * getPerformanceServiceStatusGetManyMap into
							 * getDeviceListMap
							 * 
							 */
							if (getPerformanceServiceStatusGetManyMap.get("device_id")
									.equalsIgnoreCase(String.valueOf(getDeviceListMap.get("device_id")))) {
								builder.append(String.valueOf(getDeviceListMap.get("device_id")) + ",");
								// System.out.println("*****" +
								// getPerformanceServiceStatusGetManyMap.get("device_id")
								// + " ------------- " +
								// String.valueOf(getDeviceListMap.get("device_id")));
								getDeviceListMap.putAll(getPerformanceServiceStatusGetManyMap);
							}
						}

					}

					for (Map<String, Object> getDeviceListMap : getDeviceList) {
						if (!getDeviceListMap.containsKey("host_status_host_status")) {
							/**
							 * If no data from platform than add its default
							 * value
							 */
							getDeviceListMap.put("location_parameters_latitude", null);
							getDeviceListMap.put("location_parameters_longitude", null);
							getDeviceListMap.put("sys_timestamp", null);
							getDeviceListMap.put("location_parameters_location_accuracy", 0);
							getDeviceListMap.put("phone_parameters_device_battery_percentage", 0);
							getDeviceListMap.put("host_status_host_status", 0);
							getDeviceListMap.put("phone_parameters_device_charging_status", 0);
						}

					}
					/**
					 * Success Response
					 */
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(getDeviceList);
					responseMessage.setValid(true);

				} else {
					/*
					 * Failure response
					 */
					responseMessage.setDescription("No Data From Database");
					responseMessage.setValid(false);
				}

			} else {
				/*
				 * Failure response
				 */
				responseMessage.setDescription("Database Issue ");
				responseMessage.setValid(false);
			}

		} catch (Exception e) {
			/*
			 * Failure response
			 */
			e.printStackTrace();
			responseMessage.setDescription("Issue Encountered " + e.getMessage());
			responseMessage.setValid(false);
		}
		/**
		 * To return Response
		 */
		return responseMessage;
	}

	@SuppressWarnings("serial")
	public Message multipleLogsInsert(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			List<Object> LogResponsemessageList = new LinkedList<>();
			if (map.get("data") != null || !map.get("data").isEmpty()) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get log data which need to be update
				 */
				String logDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */

				List<Map<String, String>> logDataList = new Gson().fromJson(logDataToUpdate, type);
				// System.out.println("logDataList:- " +
				// logDataList);
				for (Map<String, String> map2 : logDataList) {
					map2.put("device_id", map.get("device_id"));
					map2.put("imei", map.get("imei"));
					map2.put("licence_key", map.get("licence_key"));
					map2.put("geofence_id", map.get("geofence_id"));

					Message DriverResponsemessage = genericProcess.GenericProcedureCalling("8", map2, null, request,
							response);
					LogResponsemessageList.add(DriverResponsemessage.getObject());
				}

				responseMessage.setDescription("Log Inserted  Successfully");
				responseMessage.setObject(LogResponsemessageList);
				responseMessage.setValid(true);
				return responseMessage;
			} else {
				/**
				 * if response is null
				 */
				responseMessage.setDescription("Error in Response from Adding Driver in ThirdParty");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/**
			 * If exception occur
			 */
			e.printStackTrace();
			throw e;

		}
	}

}
