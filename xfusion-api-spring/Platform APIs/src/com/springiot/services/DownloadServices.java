/**
 * This package contain the service class for download files.
 */
package com.springiot.services;

/**
 * This class is defined as service which is used to download the required api's data in file.
 */
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.constant.TableParameter;
import com.springiot.excel.Excel;
import com.springiot.excel.PerformanceExcel;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This is generic Method DownloadGenericProcedureCalling() is used when user
 * needs to download excel file for the Metadata database. Three parameters are
 * taken additionally,naming report_api_url,report_name and timezone.
 * 
 * @author tanvigarg
 *
 */
@Service
@Transactional(readOnly = true)
@Configuration
public class DownloadServices {

	@Autowired
	private TableParameter tableParameter;
	@Autowired
	private GenericService genericService;

	/*
	 * This is generic Method DownloadGenericProcedureCalling() is used when
	 * user needs to download excel file for the Metadata database. Three
	 * parameters are taken additionally,naming report_api_url,report_name and
	 * timezone. Get the response from table report_header_mapping on the basis
	 * of report_api_url and retrieve column names and column Alias(Headers of
	 * excel file). And then set the headers first in excel file and then data
	 * accordingly to headers.
	 */
	@SuppressWarnings({ "unchecked" })
	public Message DownloadGenericProcedureCalling(Map<String, String> passingParameterMap, Object SQLresponse) {
		Message responseMessage = new Message();

		try {
			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedure
			 */

			if (passingParameterMap.get("report_api_url") == null) {
				responseMessage.setDescription("Report URL is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportURL = passingParameterMap.get("report_api_url");
			passingParameterMap.remove("report_api_url");
			/*
			 * To get the particular Report Name to generate Report
			 */

			if (passingParameterMap.get("report_name") == null) {
				responseMessage.setDescription("Report name  is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportName = passingParameterMap.get("report_name").toString();
			passingParameterMap.remove("report_name");

			/*
			 * To get the particular Time Zone to generate Report
			 */
			String Timezone = "";
			if (passingParameterMap.containsKey("timezone")) {
				if (passingParameterMap.get("timezone") == null) {
					responseMessage.setDescription("Timezone is required.");
					responseMessage.setValid(false);
					return responseMessage;
				}
				Timezone = passingParameterMap.get("timezone").toString();
				passingParameterMap.remove("timezone");
			}

			String SQL_QUERY = "select * FROM " + tableParameter.getReport_header_mapping()
					+ "  WHERE report_api_url ='" + reportURL + "';";

			/*
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			List<Map<String, Object>> tableResponse = (List<Map<String, Object>>) genericService
					.executeAnySqlQueryMetaData(SQL_QUERY.toString());

			String columnAlias = "";
			String columnNames = "";
			String columnDataType = "";

			// Set the results retrieved from select query of table.
			for (int i = 0; i < tableResponse.size(); i++) {
				columnAlias = tableResponse.get(i).get("column_alias").toString().trim();
				columnNames = tableResponse.get(i).get("column_names").toString().trim();
				columnDataType = tableResponse.get(i).get("column_type").toString().trim();
			}

			List<Object> Header = new ArrayList<>();

			/*
			 * To get the Header while Downloading Excel
			 */
			String[] reportArray = columnAlias.split(",");
			for (int i = 0; i < reportArray.length; i++) {
				Header.add(reportArray[i]);
			}

			if (SQLresponse != null) {

				/*
				 * List<Map<String, Object>> of headerData Object
				 */
				List<Map<String, Object>> headerDataUrlMessageList = (List<Map<String, Object>>) SQLresponse;
				List<Map<String, Object>> finalDataSet = new ArrayList<>();

				String columnArray[] = columnNames.split(",");
				String columnDatatype[] = columnDataType.split(",");
				/*
				 * Adjustment of parameters data according to the column names
				 * of excel file.
				 */

				for (Map<String, Object> dbData : headerDataUrlMessageList) {

					LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
					Object time = null;
					String epochTime = "";

					for (int i = 0; i < columnDatatype.length; i++) {

						if (columnDatatype[i].toString().equals("DateTime")) {
							// Conversion of Date and Time in specific Formats
							// per the requirement.

							String columnNameforDate = columnArray[i];

							if (dbData.get(columnNameforDate) != null) {

								String data = String.valueOf(dbData.get(columnNameforDate).getClass());

								if (data.equalsIgnoreCase("class java.sql.Timestamp")) {

									java.sql.Timestamp timeq = (java.sql.Timestamp) dbData.get(columnNameforDate);

									Long epoch = timeq.getTime();

									epochTime = String.valueOf(epoch);

								} else {
									epochTime = dbData.get(columnNameforDate).toString();
								}

								time = timeConversion(epochTime, Timezone);

								dataMap.put(columnArray[i], time);
								continue;
							} else {
								dataMap.put(columnArray[i], "");
							}
						}
						dataMap.put(columnArray[i], dbData.get(columnArray[i].trim()));

					}
					finalDataSet.add(dataMap);

				}
				// finalDataSet is data for specific column Names(Headers) and
				// headerDataUrlMessageList is complete data response from
				// Procedure.

				/*
				 * If list size is not Zero
				 */
				if (headerDataUrlMessageList.size() > 0) {

					/*
					 * Get FilePath of downloaded Excel file
					 */
					String filePath = downloadReport(finalDataSet, Header, reportName, Timezone);

					if (filePath != null) {
						// Set File Path in Apache Tomcat.

						String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

						Map<String, Object> filePathMap = new HashMap<>();

						/*
						 * filePathMap to add path of Downloaded File
						 */
						filePathMap.put("file", finalPath);
						filePathMap.put("orignalPath", filePath);

						responseMessage.setDescription("Process Success");
						responseMessage.setObject(filePathMap);
						responseMessage.setValid(true);
						return responseMessage;
					}
				}

			} else {
				/*
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Issue With File Generation.No Data from Procedure");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/*
			 * If try doesn't Work
			 */
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		/*
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Process Fail,Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/*
	 * This method is specifically used for excel download of Performance
	 * Report.This is not a generic method for excel download for Performance
	 * Report.
	 */
	@SuppressWarnings("unchecked")
	public Message DownloadGenericProcedureCallingPerformance(Map<String, String> passingParameterMap,
			Object SQLresponse) {

		Message responseMessage = new Message();
		try {

			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedure
			 */
			if (passingParameterMap.get("report_api_url") == null) {
				responseMessage.setDescription("Report url is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportURL = passingParameterMap.get("report_api_url");
			passingParameterMap.remove("report_api_url");
			/*
			 * To get the particular Report Name to generate Report
			 */

			if (passingParameterMap.get("report_name") == null) {
				responseMessage.setDescription("Report name  is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportName = passingParameterMap.get("report_name").toString();
			passingParameterMap.remove("report_name");

			/*
			 * To get the particular Time Zone to generate Report
			 */
			if (passingParameterMap.get("timezone") == null) {
				responseMessage.setDescription("Timezone is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String Timezone = passingParameterMap.get("timezone").toString();
			passingParameterMap.remove("timezone");

			/*
			 * If headerData is Valid
			 */

			String SQL_QUERY = "select * FROM " + tableParameter.getReport_header_mapping()
					+ "  WHERE report_api_url ='" + reportURL + "';";
			/*
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			List<Map<String, Object>> tableResponse = (List<Map<String, Object>>) genericService
					.executeAnySqlQueryMetaData(SQL_QUERY.toString());

//			System.out.println("table Response" + tableResponse);

			String columnAlias = "";
			String columnNames = "";

			// Set the results retrieved from select query of table.
			for (int i = 0; i < tableResponse.size(); i++) {
				columnAlias = tableResponse.get(i).get("column_alias").toString().trim();
				columnNames = tableResponse.get(i).get("column_names").toString().trim();

			}

			List<Object> Header = new ArrayList<>();

			List<String> dbHeader = new ArrayList<>();

			String[] reportDBHeader = columnNames.split(",");
			// String[] columnDataType = columnType.split(",");
			/*
			 * To get the Header for Downloading Excel
			 */
			String[] reportArray = columnAlias.split(",");
			for (int i = 0; i < reportArray.length; i++) {
				Header.add(reportArray[i]);
				dbHeader.add(reportDBHeader[i]);
			}

			if (SQLresponse != null) {

				/*
				 * List<Map<String, Object>> of headerData Object
				 */
				List<Map<String, Object>> headerDataUrlMessageList = (List<Map<String, Object>>) SQLresponse;

				String columnArray[] = columnNames.split(",");
				/*
				 * Adjustment of parameters data according to the column names
				 * of excel file.
				 */
				for (Map<String, Object> dbData : headerDataUrlMessageList) {

					Object time = null;
					for (int i = 0; i < columnArray.length; i++) {

						if (columnArray[i].toString().equals("status_timestamp")) {

							Object date = dbData.get("status_timestamp");

							if (date != null) {

								time = timeConversion(date, Timezone);

								dbData.put(columnArray[i], time);
							} else {
								dbData.put(columnArray[i], null);
							}
							continue;
						}
					}
				}

				/*
				 * If list size is not Zero
				 */
				if (headerDataUrlMessageList.size() > 0) {

					/*
					 * Get FilePath of downloded Excel
					 */
					String filePath = downloadReportPerformance(headerDataUrlMessageList, Header, reportName, dbHeader,
							Timezone);

					if (filePath != null) {

						String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

						Map<String, Object> filePathMap = new HashMap<>();

						/*
						 * filePathMap to add path of Downloaded File
						 */
						filePathMap.put("file", finalPath);
						filePathMap.put("orignalPath", filePath);

						responseMessage.setDescription("Process Success");
						responseMessage.setObject(filePathMap);
						responseMessage.setValid(true);
						return responseMessage;

					}
				}

			} else {
				/*
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Issue With File Generation.No Data from Procedure");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/*
			 * If try doesn't Work
			 */
			e.printStackTrace();
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		/*
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Process Fail,Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	@SuppressWarnings({ "unchecked" })
	public Message DownloadGenericProcedureCallingPerformanceAPI(Map<String, String> passingParameterMap,
			Object SQLresponse) {
		Message responseMessage = new Message();
		try {
			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedure
			 */

			String reportURL = "";
			if (passingParameterMap.containsKey("report_api_url")) {

				if (passingParameterMap.get("report_api_url") == null) {
					responseMessage.setDescription("Report URL is required.");
					responseMessage.setValid(false);
					return responseMessage;
				}
				reportURL = passingParameterMap.get("report_api_url");
				passingParameterMap.remove("report_api_url");
			}
			/*
			 * To get the particular Report Name to generate Report
			 */
			String reportName = "";
			if (passingParameterMap.containsKey("report_name")) {

				if (passingParameterMap.get("report_name") == null) {
					responseMessage.setDescription("Report name  is required.");
					responseMessage.setValid(false);
					return responseMessage;
				}
				reportName = passingParameterMap.get("report_name").toString();
				passingParameterMap.remove("report_name");
			}
			/*
			 * To get the particular Time Zone to generate Report
			 */
			String Timezone = "";
			if (passingParameterMap.containsKey("timezone")) {
				if (passingParameterMap.get("timezone") == null) {
					responseMessage.setDescription("Timezone is required.");
					responseMessage.setValid(false);
					return responseMessage;
				}
				Timezone = passingParameterMap.get("timezone").toString();
				passingParameterMap.remove("timezone");
			}

			String SQL_QUERY = "select * FROM " + tableParameter.getReport_header_mapping()
					+ "  WHERE report_api_url ='" + reportURL + "';";

			/*
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			List<Map<String, Object>> tableResponse = (List<Map<String, Object>>) genericService
					.executeAnySqlQueryMetaData(SQL_QUERY.toString());

			//System.out.println("Response from mapping header table" + tableResponse);

			String columnAlias = "";
			String columnNames = "";
			String columnDataType = "";

			// Set the results retrieved from select query of table.
			for (int i = 0; i < tableResponse.size(); i++) {
				columnAlias = tableResponse.get(i).get("column_alias").toString().trim();
				columnNames = tableResponse.get(i).get("column_names").toString().trim();
				columnDataType = tableResponse.get(i).get("column_type").toString().trim();
			}

			List<Object> Header = new ArrayList<>();

			/*
			 * To get the Header while Downloading Excel
			 */
			String[] reportArray = columnAlias.split(",");
			for (int i = 0; i < reportArray.length; i++) {
				Header.add(reportArray[i]);
			}

			if (SQLresponse != null) {

				/*
				 * List<Map<String, Object>> of headerData Object
				 */
				List<Map<String, Object>> headerDataUrlMessageList = (List<Map<String, Object>>) SQLresponse;
				List<Map<String, Object>> finalDataSet = new ArrayList<>();

				String columnArray[] = columnNames.split(",");
				String columnDatatype[] = columnDataType.split(",");
				/*
				 * Adjustment of parameters data according to the column names
				 * of excel file.
				 */

				for (Map<String, Object> dbData : headerDataUrlMessageList) {

					LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();

					Object time = null;

					for (int i = 0; i < columnDatatype.length; i++) {

						if (columnDatatype[i].toString().equals("DateTime")) {
							// Conversion of Date and Time in specific Formats
							// per the requirement.
							String epochTime = "";

							String columnNameforDate = columnArray[i];

							String data = String.valueOf(dbData.get(columnNameforDate).getClass());

							if (data.equalsIgnoreCase("class java.sql.Timestamp")) {

								java.sql.Timestamp timeq = (java.sql.Timestamp) dbData.get(columnNameforDate);

								Long epoch = timeq.getTime();

								epochTime = String.valueOf(epoch);

							} else {
								epochTime = dbData.get(columnNameforDate).toString();
							}

							time = timeConversion(epochTime, Timezone);

							dataMap.put(columnArray[i], time);
							continue;
						}

						dataMap.put(columnArray[i], dbData.get(columnArray[i].trim()));

					}
//					System.out.println("Data map" + dataMap);
					finalDataSet.add(dataMap);

				}
				// finalDataSet is data for specific column Names(Headers) and
				// headerDataUrlMessageList is complete data response from
				// Procedure.

//				System.out.println("Final Data Set" + finalDataSet);
				/*
				 * If list size is not Zero
				 */
				if (Header.size() > 0) {

					/*
					 * Get FilePath of downloaded Excel file
					 */
					String filePath = downloadReport(finalDataSet, Header, reportName, Timezone);

					if (filePath != null) {
						// Set File Path in Apache Tomcat.

						String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

						Map<String, Object> filePathMap = new HashMap<>();

						/*
						 * filePathMap to add path of Downloaded File
						 */
						filePathMap.put("file", finalPath);
						filePathMap.put("orignalPath", filePath);

						responseMessage.setDescription("Process Success");
						responseMessage.setObject(filePathMap);
						responseMessage.setValid(true);
						return responseMessage;
					}
				}

			} else {

				// If headerData Object is not Valid

				responseMessage.setDescription("Issue With File Generation.No Data from Procedure");
				responseMessage.setValid(false);
				return responseMessage;
			}

		} catch (Exception e) {
			/*
			 * If try doesn't Work
			 */
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}

		/*
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Process Fail,Required Parameter is inappropriate");
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
	private String downloadReport(List<Map<String, Object>> headerData, List<Object> reportHeader, String sheetName,
			String Timezone) {

		try {

			/*
			 * Creates object of Excel Class
			 */
			Excel excel = new Excel();

			/*
			 * Create workbook of XSSF format
			 */

			XSSFWorkbook workbook = excel.getXSSFWorkbook();

			/*
			 * Generating Path of new Downloaded path
			 */

			String rootPath = System.getProperty("catalina.home");

			/*
			 * Creating new file on server with the given path and checking if
			 * it is created
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			/*
			 * To set the Data in Excel File
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, headerData, reportHeader);

			/*
			 * Check if data is set in file or not
			 */
			if (flag) {
				/*
				 * Creating new Excel as Downloaded Sheet
				 */
				return excel.createExcel(workbook, sheetName + "_" + endDate(Timezone), dir.getAbsolutePath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if file is not created
		 */
		return null;
	}

	private String downloadReportPerformance(List<Map<String, Object>> headerData, List<Object> reportHeader,
			String sheetName, List<String> dbHeader, String Timezone) {

//		System.out.println("headerData" + headerData);
		try {
			for (Map<String, Object> checkTimestampMap : headerData) {

				String updatedAge = "";

//				System.out.println("check_timestamp" + checkTimestampMap.get("check_timestamp") + "!!!!!!!"
//						+ checkTimestampMap.get("age"));

				if (checkTimestampMap.get("check_timestamp") != null
						&& checkTimestampMap.get("status_timestamp") != null) {

//					System.out.println("check time present" + checkTimestampMap.get("check_timestamp"));

					Object time = timeConversion(checkTimestampMap.get("check_timestamp"), Timezone);
//					System.out.println("time" + time);

					checkTimestampMap.put("check_timestamp", time);

					updatedAge = checkTimestampMap.get("age").toString() + "Since "
							+ checkTimestampMap.get("check_timestamp").toString();

//					System.out.println("updtaed age is" + updatedAge);

					checkTimestampMap.put("age", updatedAge);

				} else {
					checkTimestampMap.put("check_timestamp", null);
					checkTimestampMap.put("age", null);
				}
			}
//			System.out.println("!!!!!!!" + headerData);

			/*
			 * Creates object of Excel Class
			 */
			PerformanceExcel excel = new PerformanceExcel();

			/*
			 * Create workbook of XSSF format
			 */

			XSSFWorkbook workbook = excel.getXSSFWorkbook();

			/*
			 * Generating Path of new Downloaded Excel File.
			 */

			String rootPath = System.getProperty("catalina.home");

			/*
			 * Creating new file on server with the given path and checking if
			 * it is created
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			/*
			 * To set the Data in Excel File
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, headerData, reportHeader, dbHeader);

			/*
			 * Check if data is set in file or not
			 */
			if (flag) {
				/*
				 * Creating new Excel as Downloaded Sheet
				 */
				return excel.createExcel(workbook, sheetName + "_" + endDate(Timezone), dir.getAbsolutePath());
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}

		/*
		 * if file is not created
		 */
		return null;

	}

	/*
	 * endDate Method to attach Date Time with Downloaded File
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public String endDate(String Timezone) throws Exception {
		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd_HHmmss");

		String date = currentFormat.format(new Date());
		Date startDate = currentFormat.parse(date);

		/*
		 * String newDateString = currentFormat.format(startDate);
		 * System.out.println(newDateString);
		 */

		// Date dateNew = new Date(date);

		// int timezoneOffset = startDate.getTimezoneOffset();

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);

		int timeZone = Integer.parseInt(Timezone);
		cal.add(Calendar.MINUTE, -(timeZone));

		String finalDateTimezone = currentFormat.format(cal.getTime());

		return finalDateTimezone;

	}

	@SuppressWarnings("deprecation")
	public Object timeConversion(Object epochTime, String timezone) throws ParseException {

		/*
		 * 
		 */
		Date date;
		// When time received from procedure is in Date Format

		if (epochTime instanceof Date) {

			date = (Date) epochTime;

		} else
		// When time received from procedure is in Epoch Format
		{

			if (epochTime.toString().endsWith("000")) {
				long epochTimeLong = Long.parseLong(epochTime.toString());

				date = new Date(epochTimeLong);

			} else {
				String epochTimeNew = epochTime.toString() + "000";
				long epochTimeLong = Long.parseLong(epochTimeNew.toString());

				date = new Date(epochTimeLong);

			}

		}
		// Find offset(timezone) of my local server and convert accordingly
		int timezoneOffset = date.getTimezoneOffset();
		// Date adjusted in this format "dd MMM yyyy HH:mm"
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

		Date dateTime = dateFormat.parse(dateFormat.format(date));
		// String formatted = dateFormat.format(date);
		// Initializing calendar library.
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateTime);

		cal.add(Calendar.MINUTE, timezoneOffset);

		// String finalDate = dateFormat.format(cal.getTime());

		int timeZone = Integer.parseInt(timezone);
		cal.add(Calendar.MINUTE, -(timeZone));

		String finalDateTimezone = dateFormat.format(cal.getTime());

		return finalDateTimezone;
	}
}
