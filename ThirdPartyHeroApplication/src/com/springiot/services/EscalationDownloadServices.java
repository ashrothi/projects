/**
 * This package contain the Services class for calling daily report and planner report to get file attachment for esclation
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.excel.ExcelDailyHorn;
import com.springiot.excel.ExcelDailyRelay;
import com.springiot.excel.ExcelDailySideStand;
import com.springiot.response.Message;

/**
 * EscalationDownloadServices class for calling daily report and planner report to get file attachment for esclation
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class EscalationDownloadServices {

	/**
	 * To access functionality of following Class function
	 */
	@SuppressWarnings("unused")
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private DownloadServices downloadServices;

	@Autowired
	private DownloadPDFService downloadPDFService;

	/**
	 * To {@link ExcelDailyHorn} Horn Escalation
	 * 
	 * @param map
	 * @return
	 */
	public Message downloadDailyReportHorn(Map<String, String> map) {
		Message responseMessage = new Message();

		/**
		 * To Check device_id and report_date is null or not
		 */
		try {
			if (map.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			if (map.get("report_date") == null) {

				responseMessage.setDescription("Report Date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			List<Object> responseList = new ArrayList<>();

			/**
			 * to get all device_id
			 */
			String device_id[] = map.get("device_id").toString().split(",");
			/**
			 * To download report for all devices
			 */
			for (String deviceName : device_id) {

				try {

					System.out.println(deviceName);

					/**
					 * Passing Parameter to call Daily Report Horn Download Api
					 */
					LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
					linkedHashMap.put("device_id", deviceName);
					linkedHashMap.put("report_date", map.get("report_date"));
					linkedHashMap.put("status", "");
					linkedHashMap.put("limit", "");
					linkedHashMap.put("offset", "");
					linkedHashMap.put("page", "");
					linkedHashMap.put("page_size", "");
					/**
					 * Calling API to download report
					 */

					Message responseFromApi = downloadServices.downloadDailyReportHorn(linkedHashMap);
					/**
					 * Response from Api is not null
					 */
					if (responseFromApi.getObject() != null) {
						responseList.add(responseFromApi.getObject());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			/**
			 * Report with their Respective paths
			 */
			responseMessage.setDescription("Report List");
			responseMessage.setObject(responseList);
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			/**
			 * Exception if comes
			 */
			e.printStackTrace();
		}
		/*
		 * Error response
		 */
		responseMessage.setDescription("Issues With Report Generation");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To {@link ExcelDailyRelay} Relay Escalation
	 * 
	 * @param map
	 * @return
	 */
	public Message downloadDailyReportRelay(Map<String, String> map) {
		Message responseMessage = new Message();

		/**
		 * To check if deice_id or report_date is null
		 */
		try {
			if (map.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			if (map.get("report_date") == null) {

				responseMessage.setDescription("Report Date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			List<Object> list = new ArrayList<>();

			/**
			 * List of Devices
			 * 
			 */
			String device_id[] = map.get("device_id").toString().split(",");

			for (String deviceName : device_id) {

				try {

					System.out.println(deviceName);

					/**
					 * Passing Parameter to call Relay Daily Report Download
					 */
					LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
					linkedHashMap.put("device_id", deviceName);
					linkedHashMap.put("report_date", map.get("report_date"));
					linkedHashMap.put("status", "");
					linkedHashMap.put("limit", "");
					linkedHashMap.put("offset", "");
					linkedHashMap.put("page", "");
					linkedHashMap.put("page_size", "");

					/**
					 * Response from Api
					 */
					Message responseFromApi = downloadServices.downloadDailyReportRelay(linkedHashMap);

					if (responseFromApi.getObject() != null) {
						list.add(responseFromApi.getObject());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			/**
			 * All Reports with their respective paths
			 */
			responseMessage.setDescription("Report List");
			responseMessage.setObject(list);
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			e.printStackTrace();
		}

		responseMessage.setDescription("Issues With Report Generation");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To {@link ExcelDailySideStand} Side Stand Escalation
	 * 
	 * @param map
	 * @return
	 */
	public Message downloadDailyReportSideStand(Map<String, String> map) {
		Message responseMessage = new Message();

		/**
		 * Check if Report Date and Device_id is null
		 */
		try {
			if (map.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			if (map.get("report_date") == null) {

				responseMessage.setDescription("Report Date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			List<Object> list = new ArrayList<>();

			/**
			 * To get Device Id
			 */
			String device_id[] = map.get("device_id").toString().split(",");

			for (String deviceName : device_id) {

				try {

					System.out.println(deviceName);

					/**
					 * To Call Side Stand Daily Report Api
					 */
					LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
					linkedHashMap.put("device_id", deviceName);
					linkedHashMap.put("report_date", map.get("report_date"));
					linkedHashMap.put("status", "");
					linkedHashMap.put("limit", "");
					linkedHashMap.put("offset", "");
					linkedHashMap.put("page", "");
					linkedHashMap.put("page_size", "");

					Message responseFromApi = downloadServices.downloadDailyReportSS(linkedHashMap);

					if (responseFromApi.getObject() != null) {
						list.add(responseFromApi.getObject());
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			/**
			 * All Reports with their Path
			 */
			responseMessage.setDescription("Report List");
			responseMessage.setObject(list);
			responseMessage.setValid(true);
			return responseMessage;

		} catch (Exception e) {
			e.printStackTrace();
		}

		responseMessage.setDescription("Issues With Report Generation");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * to {@link DownloadServices} Planner Escalation
	 * 
	 * @param map
	 * @param req
	 * @param res
	 * @return
	 */
	public Message downloadPlannerReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		return downloadPDFService.downloadDailyPlanner(map, req, res);

	}

}
