package com.springiot.services;

import java.io.File;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.constant.Constant;
import com.springiot.constant.URLParameter;
import com.springiot.excel.Excel;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

@SuppressWarnings({ "unchecked", "serial" })
@Service
public class KPIServices {
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;
	@Autowired
	private GenericProcess genericProcess;

	public Message getDevicesByDatatype(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);
			/*
			 * Initialize response Message
			 */

			/*
			 * Initialize Passing Query String to call platform API
			 */
			StringBuilder passingParameter = new StringBuilder();
			/*
			 * Initialize access_key
			 */
			String accessKey = "";
			/*
			 * to create Passing Parameter Query String
			 */

			Map<String, String> headerMap = new LinkedHashMap<>();
			for (String key : passingMap.keySet()) {
				/*
				 * Retrieving the xFusion Platform Token
				 */
				if (request.getHeader("token") != null) {
					/*
					 * to get platform token
					 */
					Token token = (Token) Constant.xfusionPaleteform.get(request.getHeader("token").trim());
					/*
					 * to check if token is null and send error response
					 */
					if (token == null) {
						responseMessage.setDescription("Token is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}
					/*
					 * to append token in query string
					 */
					// passingParameter.append("token=" +
					// token.getAccess_token());
					// System.out.println("!!!!!!!!!!" +
					// token.getAccess_token());

					headerMap.put("token", token.getAccess_token());
					headerMap.put("userKey", token.getUserKey());
					headerMap.put("user_id", token.getUser_id());
					/*
					 * to get accessKey
					 */
					accessKey = token.getAccess_key();
					passingParameter.append("&" + key + "=" + passingMap.get(key));
					continue;
				}
				/*
				 * To append rest of the parameters
				 */

			}
			/*
			 * to append access_key in query string
			 */
			passingParameter.append("&" + "access_key" + "=" + accessKey);
			/*
			 * Printing passing parameter query string
			 */
			passingParameter.delete(0, 1);

			/*
			 * Calling XfusionPlatform Performance Service Status Devices Get
			 * Many API to get the data
			 */
			Object finalVehicleResponseMessage = urlCalling.getData(urlParameter.getDeviceGetMetadataStatusBytType(),
					passingParameter.toString(), headerMap);

			// System.out.println("!!!!!!!!!!!" + finalVehicleResponseMessage);

			/*
			 * To check if response in null or not
			 */
			if (finalVehicleResponseMessage != null) {
				/*
				 * Casting response in Generic Message format
				 */
				Type type = new TypeToken<GenericMessages<Map<String, Object>>>() {
				}.getType();
				/*
				 * Getting response in formatted way
				 */
				GenericMessages<Map<String, Object>> urlMessage = (GenericMessages<Map<String, Object>>) new Gson()
						.fromJson(finalVehicleResponseMessage.toString(), type);
				/*
				 * to get response in List of Map
				 */
				List<Map<String, Object>> deviceModelObject = urlMessage.getObject();

				/*
				 * to check if response is null
				 */
				if (deviceModelObject != null) {
					responseMessage.setDescription(urlMessage.getDescription());
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(true);
				} else {
					responseMessage.setDescription(urlMessage.getDescription());
					responseMessage.setObject(urlMessage.getObject());
					responseMessage.setValid(false);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return responseMessage;
	}

	public Message getcallAttemptsPerTrx(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();
		try {

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			Map<String, Object> responseMap = new HashMap<>();
			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				if (deviceModelObject.size() > 0) {

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// System.out.println("total value " + total);

					responseMap.put("data", total);
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

	public Message getcallSetupSuccessRate(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				String value = "";
				if (deviceModelObject.size() > 0) {
					value = deviceModelObject.get(deviceModelObject.size() - 1).get("current_value").toString();
				} else {
					value = "0";
				}

				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("data", value);

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

	public Message gettotalDownlinkData(Map<String, String> passingMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			// System.out.println("passingMap" + passingMap);
			// System.out.println("passingMap" + passingMap);

			Map<String, Object> xfusionPassingMap = new LinkedHashMap<>();
			xfusionPassingMap.putAll(passingMap);

			List<Map<String, Object>> deviceModelObject = genericProcess.getPlatformData(xfusionPassingMap, request,
					response);

			/*
			 * To check if response in null or not
			 */
			if (deviceModelObject != null) {

				double finalValue;

				if (deviceModelObject.size() > 0) {

					double total = 0.0;
					for (Map<String, Object> map : deviceModelObject) {
						Float value = Float.parseFloat(String.valueOf(map.get("current_value")));

						total = total + value;

					}

					// System.out.println("total value " + total);

					finalValue = total / 1024;
				} else {
					finalValue = 0;
				}

				Map<String, Object> responseMap = new HashMap<>();
				responseMap.put("data", finalValue);

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

	public Message downloadKPIData(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			Message data =  new Message();
			Message pcuData = new Message();
			Message btsData = new Message();
			
			/**
			 * to get the particular Report Name to generate Report
			 */

			if (map.get("report_name") == null&& map.containsKey("tag")) {
				map.put("tag", map.get("tag"));
				return data = genericProcess.GenericProcedureCalling("1", map, null, null);
			}
			System.out.println("voiceData" + data);
			String reportName = map.get("report_name").toString();
			map.remove("report_name");

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			
			map.put("tag", "PCU");
		    pcuData = genericProcess.GenericProcedureCalling("1", map, null, null);
			map.put("tag", "BTS");
			btsData = genericProcess.GenericProcedureCalling("1", map, null, null);

			Map<String, Object> finalReportData = new LinkedHashMap<>();
			if (pcuData.isValid() && btsData.isValid()) {
				
				List<Map<String, Object>> pcuList = (List<Map<String, Object>>) pcuData.getObject();
				List<Map<String, Object>> btsList = (List<Map<String, Object>>) btsData.getObject();

				finalReportData.put("PCU Data Metrics", pcuList);
				finalReportData.put("BTS Data Metrics", btsList);
			}

			/**
			 * If headerData is Valid
			 */
			if (finalReportData.size() > 0) {

				/**
				 * Get FilePath of downloded Excel
				 */
				String filePath = downloadReport(finalReportData, reportName);

				if (filePath != null) {

					System.out.println("file Path:- " + filePath);

					String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

					Map<String, Object> filePathMap = new HashMap<>();

					/**
					 * filePathMap to add path of Downloaded File
					 */
					filePathMap.put("file", finalPath);
					filePathMap.put("orignalPath", filePath);

					System.out.println(filePathMap);

					responseMessage.setDescription("Data is successfully downloaded");
					responseMessage.setObject(filePathMap);
					responseMessage.setValid(true);
					System.out.println("filePathMap" + filePathMap);
					return responseMessage;
				}

			} else {
				/**
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Data not available");
				responseMessage.setValid(false);
				System.out.println( "responseMessage" +  responseMessage);
				return responseMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * If try doesn't Work
			 */
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		/**
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Issue With File Generation.");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * downloadReport To create the Download the excel Report
	 * 
	 * @param headerData
	 *            list of map of Object From Procedure Calling
	 * @param reportHeader
	 *            list of Header in Excel
	 * @param sheetName
	 *            Sheet Name Of Report
	 * @return String file Path of the Downloaded File
	 */
	private String downloadReport(Map<String, Object> headerData, String sheetName) {

		try {

			/**
			 * Creates object of Excel Class
			 */
			Excel excel = new Excel();

			/**
			 * create workbook of XSSF format
			 */

			XSSFWorkbook workbook = excel.getXSSFWorkbook();

			/**
			 * Generating Path of new Downloaded path
			 */

			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);

			/**
			 * creating new file on server with the given path and checking if
			 * it is created
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			/**
			 * To set the Data in Excel File
			 */
			boolean flag = excel.setSheetData(workbook, headerData);
			System.out.println(flag);
			/**
			 * Check if data is set in file or not
			 */
			if (flag) {
				/**
				 * Creating new Excel as Downloaded Sheet
				 */
				return excel.createExcel(workbook, sheetName + "_" + endDate(), dir.getAbsolutePath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * if file is not created
		 */
		return null;
	}

	/**
	 * endDate Method to attach Date Time with Downloaded File
	 * 
	 * @return
	 * @throws Exception
	 */
	public String endDate() throws Exception {
		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

		String date = currentFormat.format(new Date());

		return date;

	}

	/**
	 * Convert date in requested format when it comes in MMM dd, yyyy hh:mm:ss
	 * format
	 * 
	 * @param dateStr
	 * @return
	 */
	/*public String convertDate(String dateStr) {

		DateFormat readFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
		DateFormat writeFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		Date date = null;
		try {
			date = readFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (date != null) {
			String formattedDate = writeFormat.format(date);

			return formattedDate;
		} else {
			return "";
		}

	}*/

	public Message downloadKPIDataForInterval(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		try {

			/**
			 * to get the particular Report Name to generate Report
			 */

			if (map.get("report_name") == null) {
				if (map.get("interval_type").equalsIgnoreCase("15min")) {
					map.put("tag",  map.get("tag"));
					Message voiceData = genericProcess.GenericProcedureCalling("2", map, null, null);
					return voiceData;
				} else if (map.get("interval_type").equalsIgnoreCase("hourly")) {
					map.put("tag", map.get("tag"));
					Message voiceData = genericProcess.GenericProcedureCalling("3", map, null, null);
					return voiceData;
				}
			}
			String reportName = map.get("report_name").toString();
			map.remove("report_name");

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */

			Message pcuData = new Message();
			Message btsData = new Message();
			if (map.get("interval_type").equalsIgnoreCase("15min")) {
				map.put("tag", "PCU");
			    pcuData = genericProcess.GenericProcedureCalling("2", map, null, null);
				map.put("tag", "BTS");
			    btsData = genericProcess.GenericProcedureCalling("2", map, null, null);
			} else if (map.get("interval_type").equalsIgnoreCase("hourly")) {
				map.put("tag", "PCU");
				pcuData = genericProcess.GenericProcedureCalling("3", map, null, null);
				map.put("tag", "BTS");
				btsData = genericProcess.GenericProcedureCalling("3", map, null, null);
			}

			Map<String, Object> finalReportData = new LinkedHashMap<>();
			if (pcuData.isValid() && btsData.isValid()) {
				List<Map<String, Object>> pcuList = (List<Map<String, Object>>) pcuData.getObject();
				List<Map<String, Object>> btsList = (List<Map<String, Object>>) btsData.getObject();

				finalReportData.put("PCU Data Metrics", pcuList);
				finalReportData.put("BTS Data Metrics", btsList);
			}

			// System.out.println(headerData.getObject());

			/**
			 * If headerData is Valid
			 */
			if (finalReportData.size() > 0) {

				/**
				 * Get FilePath of downloded Excel
				 */
				String filePath = downloadReport(finalReportData, reportName);

				if (filePath != null) {

					System.out.println("file Path:- " + filePath);

					String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

					Map<String, Object> filePathMap = new HashMap<>();

					/**
					 * filePathMap to add path of Downloaded File
					 */
					filePathMap.put("file", finalPath);
					filePathMap.put("orignalPath", filePath);

					System.out.println(filePathMap);

					responseMessage.setDescription("Data is successfully downloaded");
					responseMessage.setObject(filePathMap);
					responseMessage.setValid(true);
					return responseMessage;

				}

			} else {
				/**
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Data not available");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * If try doesn't Work
			 */
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		/**
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Issue With File Generation.");
		responseMessage.setValid(false);
		return responseMessage;
	}

}