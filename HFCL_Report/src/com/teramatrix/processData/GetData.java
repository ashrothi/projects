/**
 * This package contains classes for processing on data.
 */
package com.teramatrix.processData;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.teramatrix.apiCalling.AccessRestApi;
import com.teramatrix.logger.HfclLogger;
import com.teramatrix.main.HfclEscalationApp;

import in.teramatrix.dbloader.DBProcess;

/**
 * This class is used for fetching data from the platform using API. Then the
 * data is sent to database by required queries.
 *
 * @author mandeepsingh
 *
 */
public class GetData {
	public static Map<String, String> deviceDetail;

	/**
	 * This method is used for getting the devices for a user.
	 * 
	 * @param token
	 *            : Here pass the auth token for calling api.
	 * @return List of devices got from API.
	 */
	public List<String> devicesByUser() {

		List<String> operationalDevices = new LinkedList<>();

		// LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
		try {

			/**
			 * Calling API using the method call.
			 */

			HashMap<String, String> map = new HashMap<>();
			map.put("device_type", HfclEscalationApp.getDeviceType);
			map.put("host_status", HfclEscalationApp.getDevicesHostStatus);
			map.put("access_key", HfclEscalationApp.accessKey);
			

			AccessRestApi restApiCall = new AccessRestApi();
			String apiResponse = restApiCall.callingRestAPIWithHeaders(HfclEscalationApp.getDevicesApiUrl, map);

			HfclLogger.logger.info("Response : " + apiResponse);

			JSONObject outerObject;
			outerObject = new JSONObject(apiResponse);
			JSONArray jsonArray = outerObject.getJSONArray("object");
			HfclLogger.logger.info("Number of Devices  :  " + jsonArray.length());
			Map<String, String> deviceMAp = new LinkedHashMap<>();
			for (int i = 0, size = jsonArray.length(); i < size; i++) {
				JSONObject objectInArray = jsonArray.getJSONObject(i);

				if (objectInArray.get("device_device_device_id") != null) {
					/**
					 * Retrieve required data from the response.
					 */
					Object deviceId = objectInArray.get("device_device_device_id");

					operationalDevices.add(deviceId.toString());
					deviceMAp.put(String.valueOf(objectInArray.get("device_device_device_id")),
							String.valueOf(objectInArray.get("device_device_alias")));
					/**
					 * Convert the response parameters into String and add it to
					 * List.
					 */

				}
			}

			deviceDetail = deviceMAp;
			// operationalDevices.deleteCharAt(operationalDevices.lastIndexOf(","));
			HfclLogger.logger.info("Complete details : " + operationalDevices.toString());

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
		return operationalDevices;
	}

	/**
	 * The method will get the current time and convert it into UTC epoch time.
	 * 
	 * @param currentDate
	 *            : Here pass the current date.
	 * @return The date in epoch format.
	 */
	public static String getGMTTime(Date currentDate) {

		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			/**
			 * Parse the date into format defined into df object.
			 */
			currentDate = dateTime.parse(df.format(currentDate));
			HfclLogger.logger.info("Current Date & Time as UTC::" + currentDate);
			/**
			 * Get epoch time in milliseconds.
			 */
			long date = (currentDate.getTime());
			// Return the epoch time.
			return Long.toString((date));
		} catch (Exception e) {
			long date = (new Date().getTime());
			HfclLogger.logger.info("Epoch Time as UTC : " + Long.toString((date)));
			// Return the epoch time.
			return Long.toString((date));
		}
	}

	public long getEndOfDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		// calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTimeInMillis();
	}

	public long getStartOfDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		// calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTimeInMillis();
	}

	public String getBefore(long epochTime, int time) {
		Calendar calendar = Calendar.getInstance();
		Date epoch = new Date(epochTime);
		calendar.setTime(epoch);
		calendar.add(Calendar.MINUTE, -time);
		Date result = calendar.getTime();
		System.out.println("end Time " + result);
		System.out.println("end Time " + result.getTime());
		return String.valueOf(result.getTime());
	}

	public void insertKPI(String value, String KPI, String deviceId, String tag) throws SQLException {

		// Getting database connection.
		Connection connection = DBProcess.getDbConnection(HfclEscalationApp.dbDriver, HfclEscalationApp.dbUrl);

		String query = "insert into " + HfclEscalationApp.tableName
				+ "(device_id,tag,kpi,current_value,systime,endtime,device_name) value(" + "'" + deviceId + "','" + tag
				+ "'" + "," + "'" + KPI + "','" + value + "','" + Long.parseLong(HfclEscalationApp.beforeTime) / 1000
				+ "','" + HfclEscalationApp.currentTime / 1000 + "','" + deviceDetail.get(deviceId) + "'" + ");";
		HfclLogger.logger.info("Query to be called :-" + query);
		// Call procedure for validating the playback_id and hashcode.
		DBProcess.executeQuery(connection, query);
		// Iterate over the resultset.
		connection.close();
		HfclLogger.logger.info("Inserted: ");

	}
}
