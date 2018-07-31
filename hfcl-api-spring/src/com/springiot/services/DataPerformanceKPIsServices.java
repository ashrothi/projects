/**
 * This package contain the Service class for All Third Party Application for HFCL
 */
package com.springiot.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * This service class is used to calculate the data performance metrics KPIs for
 * APIs
 * 
 * @author tanvigarg
 *
 */
@Service
public class DataPerformanceKPIsServices {

	
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This method is to calculate the KPI for download link data throughput by
	 * applying some mathematical operations.
	 * 
	 * @param passingMap,is
	 *            the input passing parameters map.
	 * @param request,the
	 *            http servlet request required for the headers.
	 * @param response,the
	 *            http servlet response required for the headers.
	 * @return response,the response message required to UI Team
	 */

	public Message downlinkDataThroughput(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {

		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();

		try {

			// pasiing parameters of xFusion Platform API
			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap.put("data_source", "gprs_downlink,egprs_downlink");
			xfusionPassingMap.put("service_name",
					"geranPcuV2PerformanceTotalBytesSent,geranPcuV2PerformanceTotalBytesSent");
			xfusionPassingMap.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap.put("end_date", passingMap.get("end_date").trim());

			// pasiing parameters of xFusion Platform API
			Map<String, Object> xfusionPassingMap1 = new LinkedHashMap<>();
			xfusionPassingMap1.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap1.put("data_source", "gprs_downlink,egprs_downlink");
			xfusionPassingMap1.put("service_name",
					"geranPcuV2PerformanceTotalTimeSpent,geranPcuV2PerformanceTotalTimeSpent");
			xfusionPassingMap1.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap1.put("end_date", passingMap.get("end_date").trim());

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);
			List<Map<String, Object>> deviceModelObject1 = genericProcess.getPlatformData(xfusionPassingMap1, request,
					response);

			Map<String, Object> responseMap = new HashMap<>();
			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				// Mathematical calculations to calculate KPI results
				if (deviceModelObject.size() > 0 & deviceModelObject1.size() > 0) {

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// StringBuilder builder1 = new StringBuilder();
					double total1 = 0.0;
					for (Map<String, Object> map1 : deviceModelObject1) {
						Float value = Float.parseFloat(String.valueOf(map1.get("current_value")));

						total1 = total1 + value;

					}

					// System.out.println("total value " + total1);

					double finalValue;

					if (total1 == 0.0 || total == 0.0) {
						finalValue = 0;

					} else {
						double numValue = total * 8;
						double denValue = total1 / 100;

						// System.out.println("numValue" + numValue);
						// System.out.println("denValue" + denValue);

						if (numValue == 0.0 || denValue == 0.0) {

							finalValue = 0;

						} else {
							double divide = numValue / denValue;

							finalValue = divide / 1024;
						}
					}

					responseMap.put("data", finalValue);
				} else {

					responseMap.put("data", "0");
				}

				/*
				 * to check if response is null
				 */

				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}

	public Message downlinkEgprsDataThroughput(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			System.out.println("passingMap" + passingMap);

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap.put("data_source", passingMap.get("data_source"));
			xfusionPassingMap.put("service_name", "geranPcuV2PerformanceTotalBytesSent");
			xfusionPassingMap.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap.put("end_date", passingMap.get("end_date").trim());

			Map<String, Object> xfusionPassingMap1 = new LinkedHashMap<>();
			xfusionPassingMap1.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap1.put("data_source", passingMap.get("data_source"));
			xfusionPassingMap1.put("service_name", "geranPcuV2PerformanceTotalTimeSpent");
			xfusionPassingMap1.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap1.put("end_date", passingMap.get("end_date").trim());
			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);
			List<Map<String, Object>> deviceModelObject1 = genericProcess.getPlatformData(xfusionPassingMap1, request,
					response);

			Map<String, Object> responseMap = new HashMap<>();
			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null && deviceModelObject1 != null) {

				if (deviceModelObject.size() > 0 & deviceModelObject1.size() > 0) {
					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// StringBuilder builder1 = new StringBuilder();
					double total1 = 0.0;
					for (Map<String, Object> map1 : deviceModelObject1) {
						Float value = Float.parseFloat(String.valueOf(map1.get("current_value")));

						total1 = total1 + value;

					}

					// System.out.println("total value " + total1);

					double finalValue;

					if (total1 == 0.0 || total == 0.0) {
						finalValue = 0;

					} else {
						double numValue = total * 8 * 100;
						double denValue = total1 * 1024;

						// System.out.println("numValue" + numValue);
						// System.out.println("denValue" + denValue);

						if (numValue == 0.0 || denValue == 0.0) {

							finalValue = 0;

						} else {
							finalValue = numValue / denValue;

						}
					}

					responseMap.put("data", finalValue);
				} else {

					responseMap.put("data", "0");
				}

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}
		} catch (

		Exception e) {
			throw e;
		}
		return responseMessage;

	}

	public Message uplinkDataThroughput(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap.put("data_source", "gprs_uplink,egprs_uplink");
			xfusionPassingMap.put("service_name",
					"geranPcuV2PerformanceTotalBytesSent,geranPcuV2PerformanceTotalBytesSent");
			xfusionPassingMap.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap.put("end_date", passingMap.get("end_date").trim());

			Map<String, Object> xfusionPassingMap1 = new LinkedHashMap<>();
			xfusionPassingMap1.put("device_id", passingMap.get("device_id"));
			xfusionPassingMap1.put("data_source", "gprs_uplink,egprs_uplink");
			xfusionPassingMap1.put("service_name",
					"geranPcuV2PerformanceTotalTimeSpent,geranPcuV2PerformanceTotalTimeSpent");
			xfusionPassingMap1.put("from_date", passingMap.get("from_date").trim());
			xfusionPassingMap1.put("end_date", passingMap.get("end_date").trim());
			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);
			List<Map<String, Object>> deviceModelObject1 = genericProcess.getPlatformData(xfusionPassingMap1, request,
					response);

			Map<String, Object> responseMap = new HashMap<>();
			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				if (deviceModelObject.size() > 0 & deviceModelObject1.size() > 0) {

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// StringBuilder builder1 = new StringBuilder();
					double total1 = 0.0;
					for (Map<String, Object> map1 : deviceModelObject1) {
						Float value = Float.parseFloat(String.valueOf(map1.get("current_value")));

						total1 = total1 + value;

					}

					double finalValue;

					if (total1 == 0.0 || total == 0.0) {
						finalValue = 0;

					} else {
						double numValue = total * 8;
						double denValue = total1 / 100;

						// System.out.println("numValue" + numValue);
						// System.out.println("denValue" + denValue);

						if (numValue == 0.0 || denValue == 0.0) {

							finalValue = 0;

						} else {
							double divide = numValue / denValue;

							finalValue = divide / 1024;
						}
					}

					responseMap.put("data", finalValue);
				} else {

					responseMap.put("data", "0");
				}

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription("Process Success");
					responseMessage.setObject(responseMap);
					responseMessage.setValid(true);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}

}
