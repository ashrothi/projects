/**
 * This package contain the Services class for Android API.
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;
import com.springiot.response.Token;

/**
 * 
 * This class work as a Service which is used to create apis for Phone
 * Notification
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@Transactional
@SuppressWarnings({ "unused" })
public class AndroidService {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private GenericService genericService;

	/**
	 * To get all notification on Android Application and set templates for
	 * following notification codes
	 * 
	 * PLANNER_CREATED: 1001, PRE_NOTIFICATION_PLANNER_CREATION: 1002,
	 * NOTIFICATION_INVENTORY_SETTINGS_UPDATE: 1003, HORN_TESTING_STARTED: 1004,
	 * HORN_TESTING_FINISHED: 1005, COUNT_COMPONENTS_PUNCHED_OUT: 1006,
	 * DAILY_REPORT_HORN_NOTIFICATION: 1009, PLANNER_CREATED_UNPLANNED: 1010,
	 * DEFAULT_INVENTORY_UPDATE: 1011, PLANNER_PARTS_NOTIFY_USER: 1013,
	 * DAILY_REPORT_RELAY_NOTIFICATION: 1014, RELAY_TESTING_STARTED_RO: 1015,
	 * RELAY_TESTING_FINISHED_RO: 1016, FINAL_REPORT_RO_HORN_NOTIFICATION: 1017,
	 * RO_RELAY_FINAL_REPORT_CREATION:1018, RO_RELAY_COMPONENTS_TO_PUNCH_OUT:
	 * 1019, RO_HORN_TESTING_NOT_STARTED_AS_PLANNED: 1020,
	 * RO_RELAY_TESTING_NOT_STARTED_AS_PLANNED: 1021,
	 * RO_SIDE_STAND_SWITCH_TESTING_NOT_STARTED_AS_PLANNED: 1022,
	 * RO_SIDE_STAND_SWITCH_TESTING_FINISHED: 1023,
	 * RO_SIDE_STAND_SWITCH_TESTING_STARTED: 1024,
	 * GENERATION_OF_DAILY_SIDE_STAND_SWITCH_REPORT: 1025,
	 * RO_SIDE_STAND_SWITCH_FINAL_REPORT_CREATION: 1026,
	 * VERIFY_AVAILABILITY_OF_PARTS_IN_INVENTORY: 1027,
	 * RO_HORN_TEST_NOT_STARTED_AS_PLANNED: 1028,
	 * RO_SIDE_STAND_SWITCH_TEST_NOT_STARTED_AS_PLANNED: 1029,
	 * RO_RELAY_TEST_NOT_STARTED_AS_PLANNED: 1030, PLANNER_FINAL_SUBMISSION:
	 * 1031, FINAL_REPORT_RO_HORN_FINAL_SUBMISSION: 1032,
	 * FINAL_REPORT_RO_RELAY_FINAL_SUBMISSION: 1033,
	 * FINAL_REPORT_RO_SIDE_STAND_FINAL_SUBMISSION: 1034,
	 * DUST_TESTING_STARTED:1035, DUST_TESTING_NOT_STARTED:1036,
	 * SHOWER_TESTING_STARTED:1037, SHOWER_TESTING_NOT_STARTED:1038,
	 * GET_Lock_RO_PLANNER_PARTS_FROM_WAREHOUSE:1050,
	 * RO_LOCK_TESTING_STARTED:1051, RO_LOCK_TESTING_FINISHED:1052,
	 * RO_LOCK_COMPONENTS_TO_PUNCH_OUT:1053,
	 * GENERATION_OF_DAILY_LOCK_REPORT:1054,
	 * RO_LOCK_TESTING_NOT_STARTED_AS_PLANNED:1055,
	 * LOCK_FINAL_REPORT_CREATION:1056, FINAL_REPORT_LOCK_FINAL_SUBMISSION:1057,
	 * 
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message notificationForHero(Map<String, String> map) {
		Message responseMessage = new Message();

		try {
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			Message notificationResponse = genericProcess.GenericProcedureCalling("130", map, null);

			System.out.println("Notification Json:- " + new Gson().toJson(notificationResponse.getObject()));

			/**
			 * To Check if gridData is not null
			 */
			if (notificationResponse.isValid()) {

				/**
				 * To Form the Json From the response object
				 */
				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				String notificationDataToUpdate = new Gson().toJson(notificationResponse.getObject());
				/*
				 * to get response in List of Map format
				 */
				List<Map<String, Object>> notificationDataList = new Gson().fromJson(notificationDataToUpdate, type);
				/*
				 * Initializing the manipulative response
				 */
				List<Map<String, Object>> finalNotificationDataList = new ArrayList<>();

				/**
				 * To add Notification Message in Each notification Come in
				 * notificationDataList
				 */
				for (Map<String, Object> notificationDataListMap : notificationDataList) {

					/*
					 * To get notification code
					 */
					int notificationCode = Integer.parseInt(notificationDataListMap.get("notification_code_code")
							.toString().replace(".0", "").trim().replace(".0", "").trim());
					/**
					 * Create templates of notification according to the
					 * notification code
					 */
					switch (notificationCode) {
					/*
					 * template for Planner has been created. Please approve.
					 */
					case 1001: {

						String notification = "Planner" + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString()
								+ ") has been created. Please approve.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1002: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1003: {

						String notification = "Planner is about to create. Please change the Planner Settings as needed.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1004: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " has been started on " + notificationDataListMap.get("test_start_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1005: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " is completed on " + notificationDataListMap.get("test_end_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1006: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1009: {

						String notification = "Daily Report for " + notificationDataListMap.get("part_code").toString()
								+ " of vendor " + notificationDataListMap.get("vendor").toString()
								+ " running at slot no. " + notificationDataListMap.get("part_position").toString()
								+ " is generated.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1010: {

						String notification = "Planner " + notificationDataListMap.get("planner_name") + "("
								+ notificationDataListMap.get("planner_number") + ".v"
								+ notificationDataListMap.get("planner_version")
								+ ") has been created for unplanned case. Please approve it.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1011: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1013: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString()
								+ ") has been created. Please collect the parts and their samples as mentioned in Planner.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1014: {

						String notification = "Daily Report for " + notificationDataListMap.get("part_code").toString()
								+ " of vendor " + notificationDataListMap.get("vendor").toString()
								+ " running at slot no. " + notificationDataListMap.get("part_position").toString()
								+ " is generated.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1015: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " has been started on " + notificationDataListMap.get("test_start_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1016: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " is completed on " + notificationDataListMap.get("test_end_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1017: {

						String notification = notificationDataListMap.get("description").toString() + " for part code "
								+ notificationDataListMap.get("part_code").toString() + "and vendor code "
								+ notificationDataListMap.get("vendor_code").toString() + "and testing version "
								+ notificationDataListMap.get("testing_version").toString() + "";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1018: {

						String notification = notificationDataListMap.get("description").toString() + " for part code "
								+ notificationDataListMap.get("part_code").toString() + " and vendor code "
								+ notificationDataListMap.get("vendor_code").toString() + " and testing version "
								+ notificationDataListMap.get("testing_version").toString() + ". ";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1019: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1020: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1021: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1022: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1023: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " is completed on " + notificationDataListMap.get("test_end_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1024: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
								+ " has been started on " + notificationDataListMap.get("test_start_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1025: {

						String notification = "Daily Report for " + notificationDataListMap.get("part_code").toString()
								+ " of vendor " + notificationDataListMap.get("vendor").toString()
								+ " running at slot no. " + notificationDataListMap.get("part_position").toString()
								+ " is generated.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1026: {

						String notification = notificationDataListMap.get("description").toString() + " for part code "
								+ notificationDataListMap.get("part_code").toString() + "and vendor code "
								+ notificationDataListMap.get("vendor_code").toString() + "and testing version "
								+ notificationDataListMap.get("testing_version").toString() + "";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1027: {

						String notification = "Check the availability of component in 'Inventory'";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1028: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ")has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1029: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ")has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1030: {

						String notification = "Planner " + notificationDataListMap.get("planner_name").toString() + "("
								+ notificationDataListMap.get("planner_number").toString() + ".v"
								+ notificationDataListMap.get("planner_version").toString() + ")has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1031: {

						String notification = "Planner" + notificationDataListMap.get("planner_name") + "("
								+ notificationDataListMap.get("planner_number") + ".v"
								+ notificationDataListMap.get("planner_version") + ") has been created.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1032: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
								+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
								+ "and part code " + notificationDataListMap.get("part_code") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1033: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
								+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
								+ "and part code " + notificationDataListMap.get("part_code") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for Testing done for
					 */
					case 1034: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
								+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
								+ "and part code " + notificationDataListMap.get("part_code") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for Testing of Component is not started
					 */
					case 1035: {

						String notification = "" + notificationDataListMap.get("testing_name")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code ") + " has been started.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1036: {

						String notification = "" + notificationDataListMap.get("testing_name ")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code") + "is not started.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1037: {

						String notification = "" + notificationDataListMap.get("testing_name")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code ") + " has been started.";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 1038: {

						String notification = "" + notificationDataListMap.get("testing_name ")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code") + "is not started.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
						
					case 1046: {

						String notification = "Test for " + notificationDataListMap.get("machine_name") 
						+ " and part code " + notificationDataListMap.get("part_code") 
						+ " is completed on " + notificationDataListMap.get("test_end_date") 
						+ " and Final Report Created.";
						
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
						
					case 1047: {

						String notification = "Test for " + notificationDataListMap.get("machine_name") 
								+ " and part code " + notificationDataListMap.get("part_code") 
								+ " is completed on " + notificationDataListMap.get("test_end_date") 
								+ " and Final Report Created.";
						
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
						
					case 1051: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
						+ " has been started on " + notificationDataListMap.get("test_start_date") + ".";

						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1052: {

						String notification = "Test for " + notificationDataListMap.get("machine_name")
						+ " is completed on " + notificationDataListMap.get("test_end_date") + ".";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1053: {

						String notification = "" + notificationDataListMap.get("testing_name")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code") + "is not started.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1054: {

						String notification = "Daily Report for " + notificationDataListMap.get("part_code").toString()
								+ " of vendor " + notificationDataListMap.get("vendor").toString()
								+ " running at slot no. " + notificationDataListMap.get("part_position").toString()
								+ " is generated.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1055: {

						String notification = "" + notificationDataListMap.get("testing_name ")
								+ " testing for component " + notificationDataListMap.get("machine_name")
								+ " and part code " + notificationDataListMap.get("part_code") + "is not started.";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1056: {

						String notification = notificationDataListMap.get("description").toString() + " for part code "
								+ notificationDataListMap.get("part_code").toString() + " and vendor code "
								+ notificationDataListMap.get("vendor_code").toString() + " and testing version "
								+ notificationDataListMap.get("testing_version").toString() + ". ";
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					case 1057: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
						+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
						+ "and part code " + notificationDataListMap.get("part_code") + ".";
						
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;

					case 1058: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
						+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
						+ "and part code " + notificationDataListMap.get("part_code") + ".";
					
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;

					case 1059: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
						+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
						+ "and part code " + notificationDataListMap.get("part_code") + ".";
						
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;
					
					case 1060: {

						String notification = "" + notificationDataListMap.get("notification_code_description")
						+ "has been done for vendor name " + notificationDataListMap.get("vendor_name")
						+ "and part code " + notificationDataListMap.get("part_code") + ".";
					
						notificationDataListMap.put("notification", notification);
						finalNotificationDataList.add(notificationDataListMap);
					}
						continue;

					default:
						break;
					}

				}

				/**
				 * To Check if finalNotificationDataList is not null
				 */
				if (finalNotificationDataList != null) {
					/**
					 * Sucess Message with required format of data
					 */
					responseMessage.setDescription("Final Otput For Notification");
					responseMessage.setObject(finalNotificationDataList);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * To Print Exception
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage() + e.getStackTrace());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To get all Alerts on Android Application Android Application and set
	 * templates for following notification codes *
	 * ALERT_NO_LOGS_GENERATED_HORN: 2007, ALERT_ZERO_VALUES_HORN: 2008,
	 * ALERT_ZERO_VALUES_RELAY_RO: 2010, ALERT_NO_LOGS_GENERATED_RELAY: 2011,
	 * RO_NO_LOGS_FROM_SIDE_STAND_SWITCH_MACHINE: 2012,
	 * RO_ZERO_VALUES_ALERT_FOR_SIDE_STAND_SWITCH_LOG: 2013,
	 * RO_NO_LOGS_FROM_LOCK_MACHINE: 2016,
	 * RO_ZERO_VALUES_ALERT_FOR_LOCK_LOG:2017
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message alertsForHero(Map<String, String> map) {

		Message responseMessage = new Message();

		try {
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			Message alertResponse = genericProcess.GenericProcedureCalling("131", map, null);
			/*
			 * to print response
			 */
			System.out.println("alertResponse" + alertResponse.getObject());

			/**
			 * To Check if gridData is not null
			 */
			if (alertResponse.isValid()) {

				/**
				 * To make Json from the alertResponse Object
				 */
				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				/*
				 * to get json string
				 */
				String alertDataToUpdate = new Gson().toJson(alertResponse.getObject());
				/*
				 * to get the response in defined format
				 */
				List<Map<String, Object>> alertDataList = new Gson().fromJson(alertDataToUpdate, type);
				/*
				 * Initializing the manipulative response
				 */
				List<Map<String, Object>> finalAlertDataList = new ArrayList<>();

				/**
				 * To set Alert message for each alerts in alertDataList on the
				 * basis of their notification_code_code
				 */
				for (Map<String, Object> notificationDataListMap : alertDataList) {
					/*
					 * to get notification_code_code
					 */
					int notificationCode = Integer.parseInt(
							notificationDataListMap.get("notification_code_code").toString().replace(".0", "").trim());
					/*
					 * to make alerts according to the code
					 */
					switch (notificationCode) {
					/*
					 * template for following code
					 */
					case 2007: {

						String alertMessage = "  " + notificationDataListMap.get("machine_name")
								+ "   machine stopped working.";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 2008: {

						String alertMessage = "Log Alerts generated for  " + notificationDataListMap.get("part_name")
								+ ".";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 2010: {

						String alertMessage = "Log Alerts generated for " + notificationDataListMap.get("part_name")
								+ ".";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 2011: {

						String alertMessage = "" + notificationDataListMap.get("machine_name")
								+ "  machine stopped working.";
						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 2012: {

						String alertMessage = "" + notificationDataListMap.get("machine_name")
								+ "  machine stopped working.";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					/*
					 * template for following code
					 */
					case 2013: {

						String alertMessage = "Log Alerts generated for " + notificationDataListMap.get("part_name")
								+ ".";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					case 2016: {

						String alertMessage = "Log Alerts generated for " + notificationDataListMap.get("part_name")
								+ ".";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
					case 2017: {

						String alertMessage = "Log Alerts generated for " + notificationDataListMap.get("part_name")
								+ ".";

						notificationDataListMap.put("alert", alertMessage);
						finalAlertDataList.add(notificationDataListMap);
					}
						continue;
						

					default:
						break;
					}

				}
				/**
				 * To Check if finalAlertDataList is not null
				 */
				if (finalAlertDataList != null) {
					/**
					 * Sucess Message with required format of data
					 */
					responseMessage.setDescription("Final Otput For Alerts");
					responseMessage.setObject(finalAlertDataList);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}
			/**
			 * Error Messages
			 */
			else {
				responseMessage.setDescription("Error In Data   :-");
				responseMessage.setObject(alertResponse);
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/*
			 * Handling exception if comes in process
			 */
			e.printStackTrace();
			responseMessage.setDescription("Error In Handling   :-" + e.getMessage() + e.getStackTrace().toString());
			responseMessage.setValid(false);
			return responseMessage;
		}
		/*
		 * Error response
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;

	}

}
