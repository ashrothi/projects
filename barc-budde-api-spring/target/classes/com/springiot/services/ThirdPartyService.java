/**
 * This package is particularly used to download excel file for the Device Model Details Page
 *  which includes data displayed in four sheets by calling different API's and 
 *  manipulating results for API's
 */
package com.springiot.services;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springiot.constant.ProcessParameter;
import com.springiot.constant.TableParameter;
import com.springiot.excel.DeviceModelDetailsExcel;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This is generic Method DownloadGenericProcedureCallingDeviceDetails() is used
 * when user needs to download excel file which includes data visualization on
 * different sheets. Three parameters are taken additionally,naming
 * report_api_url,report_name and timezone.
 * 
 * @author tanvigarg
 *
 */
@Service
public class ThirdPartyService {

	/*
	 * @Autowired is used to access the functionality of different classes.
	 */
	@Autowired
	private TableParameter tableParameter;

	@Autowired
	private GenericService genericService;
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * This is generic Method DownloadGenericProcedureCallingDeviceDetails() is
	 * used when user needs to download excel file which includes data
	 * Visualization on different sheets. Three parameters are taken
	 * additionally,naming report_api_url,report_name and timezone. Get the
	 * response from table report_header_mapping on the basis of report_api_url
	 * and retrieve column names and column Alias(Headers of excel file). And
	 * then set the headers first in excel file and then data accordingly to
	 * headers.
	 * 
	 * @param passingParameterMap,
	 *            Contains the parameter map(Input Parameters passed by
	 *            user) @return, Return the response message.
	 */

	@SuppressWarnings({ "unchecked" })
	public Message DownloadSuscriptionDetails(Map<String, String> passingParameterMap, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();

		try {

			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedure
			 */
			Map<String, String> newpassingParameterMap = new LinkedHashMap<>();
			newpassingParameterMap.put("id", passingParameterMap.get("org_id"));
			newpassingParameterMap.put("org_id", passingParameterMap.get("org_id"));
			Message modelGetProperties = genericProcess.GenericProcedureCalling("29", newpassingParameterMap, null,
					request, response);

			System.out.println("modelGetProperties" + modelGetProperties.getObject());

			// Response from Procedure is converted into list<Map>
			List<Map<String, Object>> listModelGetProperties = (List<Map<String, Object>>) modelGetProperties
					.getObject();

			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedures.
			 */
			Message modelGetServices = genericProcess.GenericProcedureCalling("36", newpassingParameterMap, null,
					request, response);

			// Conversion of Object class into list<map>
			List<Map<String, Object>> listGetService = (List<Map<String, Object>>) modelGetServices.getObject();

			// initialization of new list
			List<Map<String, Object>> serviceList = new ArrayList<>();

			// Manipulation in displaying data in excel
			for (Map<String, Object> servicesMap : listGetService) {

				// Check if editable and priority is null
				if (servicesMap.get("file_name") == null && servicesMap.get("master_ques_var_name") == null
						&& servicesMap.get("master_ans_var_name") == null) {

					servicesMap.put("file_name", "");
					servicesMap.put("master_ques_var_name", "");
					servicesMap.put("master_ans_var_name", "");

				}

				serviceList.add(servicesMap);

			}

			Object modelGetServicesEdit = serviceList;
			// System.out.println("+++" + modelGetServicesEdit);

			Message subscriptionDetail = genericProcess.GenericProcedureCalling("45", newpassingParameterMap, null,
					request, response);

			// Mandatory Parameter used while downloading is report_api_url
			// which
			// is actually the url
			if (passingParameterMap.get("report_api_url") == null) {
				responseMessage.setDescription("Report URL is required.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			// Initialization of String Builder
			StringBuilder builder = new StringBuilder();

			// Remove parameter report_api_url from map.
			String reportURL = passingParameterMap.get("report_api_url");
			passingParameterMap.remove("report_api_url");

			// Append data in string builder
			builder.append("'" + reportURL + "/ORGANIZATION DETAILS',");
			// builder.append("'" + reportURL + "/properties',");
			builder.append("'" + reportURL + "/STUDY PERMISSION',");
			builder.append("'" + reportURL + "/SUBSCRIPTION DETAILS'");

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

			// Generate SQL Query to retrieve column names and column alias from
			// database.
			String SQL_QUERY = "select * FROM " + tableParameter.getReport_header_mapping()
					+ "  WHERE report_api_url in (" + builder + ");";

			// The data returned from table is converted into List<Map>
			List<Map<String, Object>> tableResponse = (List<Map<String, Object>>) genericService
					.executeAnySqlQuery(SQL_QUERY.toString());

			String columnAlias = "";
			String columnNames = "";
			String columnDataType = "";

			// Set the results retrieved from select query of table.
			for (int i = 0; i < tableResponse.size(); i++) {
				columnAlias = tableResponse.get(i).get("column_alias").toString().trim();
				columnNames = tableResponse.get(i).get("column_names").toString().trim();
				columnDataType = tableResponse.get(i).get("column_type").toString().trim();
			}
			List<Map<String, Object>> subscriptionDetaillist = (List<Map<String, Object>>) subscriptionDetail
					.getObject();

			/*
			 * List<Map<String, Object>> of headerData Object
			 */
			// List<Map<String, Object>> headerDataUrlMessageList =
			// (List<Map<String, Object>>) SQLresponse;
			List<Map<String, Object>> finalDataSet = new ArrayList<>();

			String columnArray[] = columnNames.split(",");
			String columnDatatype[] = columnDataType.split(",");
			for (Map<String, Object> dbData : subscriptionDetaillist) {

				LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
				Object time = null;
				String epochTime = "";
				// System.out.println("dbData " + dbData);
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

								epochTime = String.valueOf(epoch * 1000);

							} else {
								epochTime = dbData.get(columnNameforDate).toString();
								System.out.println("columnNameforDate " + epochTime);
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
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("organization/get/ORGANIZATION DETAILS", listModelGetProperties);
			// map.put("device/get/model/properties", listModelGetProperties);
			map.put("organization/get/STUDY PERMISSION", listGetService);
			map.put("organization/get/SUBSCRIPTION DETAILS", finalDataSet);

			// System.out.println("MAP IS --" + map);

			// Check if data returned from API's is not null then only download
			// else give exceptions
			if (modelGetServicesEdit != null && subscriptionDetail != null && modelGetProperties != null) {

				String filePath = downloadReportDeviceDetails(map, tableResponse, reportName, Timezone);

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
				} else {
					responseMessage.setDescription("Issue With File Generation.No Data from Procedure");
					responseMessage.setValid(false);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
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

			long epochTimeLong = Long.parseLong(epochTime.toString());

			date = new Date(epochTimeLong * 1000);

		}
		// System.out.println("date " + date);
		// Find offset(timezone) of my local server and convert accordingly
		int timezoneOffset = date.getTimezoneOffset();
		// Date adjusted in this format "dd MMM yyyy HH:mm"
		DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

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
		// System.out.println("objValue" + finalDateTimezone);

		return finalDateTimezone;
	}

	/**
	 * This Method is used to create workbook and set the file path for the
	 * downloaded excel file
	 * 
	 * @param headerData,
	 *            contains the data of excel file which needs to be displayed.
	 * @param tableResponse,contains
	 *            the headers(Column Alias) and data(Column Names) returned from
	 *            the table.
	 */
	private String downloadReportDeviceDetails(Map<String, Object> headerData, List<Map<String, Object>> tableResponse,
			String sheetName, String Timezone) {

		try {

			/*
			 * Creates object of DeviceModelDetailsExcel Class
			 */
			DeviceModelDetailsExcel excel = new DeviceModelDetailsExcel();

			/*
			 * Create workbook of XSSF format
			 */

			XSSFWorkbook workbook = excel.getXSSFWorkbook();

			/*
			 * Generating Path of new Downloaded Excel File.
			 */

			String rootPath = System.getProperty("catalina.home");

			// System.out.println("root Path:- " + rootPath);

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

			boolean flag = excel.setSheetData(workbook, sheetName, headerData, tableResponse);

			/*
			 * Check if data is set in file or not
			 */

			if (flag) {

				// Creating new Excel as Downloaded Sheet

				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if file is not created
		 */
		return null;
	}

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
}
