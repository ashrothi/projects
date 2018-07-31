/**
 * This package is particularly used to download excel file for the Device Model Details Page
 *  which includes data displayed in four sheets by calling different API's and 
 *  manipulating results for API's
 */
package com.springiot.services;

import java.io.File;
import java.text.DateFormat;
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
public class DownloadDeviceDetailsService {

	/*
	 * @Autowired is used to access the functionality of different classes.
	 */
	@Autowired
	private TableParameter tableParameter;

	@Autowired
	private GenericService genericService;

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
	public Message DownloadGenericProcedureCallingDeviceDetails(Map<String, String> passingParameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();

		// Retrieve user_key and user_id from Headers
		String user_key = request.getHeader("user_key");
		String user_id = request.getHeader("user_id");

		try {

			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedure
			 */
			Object modelGetProperties = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("339").toString(), user_key, user_id,
					passingParameterMap.get("device_model_id"));

			// System.out.println("modelGetProperties" + modelGetProperties);

			// Response from Procedure is converted into list<Map>
			List<Map<String, Object>> listModelGetProperties = (List<Map<String, Object>>) modelGetProperties;

			// Initialization of lists
			List<Object> listDetails = new ArrayList<>();
			List<Object> listProperties = new ArrayList<>();

			// Breaking of list listModelGetProperties into two different
			// lists,these two different lists will be used to display data in
			// first and second sheet.

			// Initializing the map.
			Map<String, Object> parametersMapDetails = new HashMap<>();
			// Adding Parameters to map

			parametersMapDetails.put("device_devicetemplate_name",
					listModelGetProperties.get(0).get("device_devicetemplate_name").toString());

			parametersMapDetails.put("device_devicemodel_name",
					listModelGetProperties.get(0).get("device_devicemodel_name").toString());
			parametersMapDetails.put("device_devicemodel_alias",
					listModelGetProperties.get(0).get("device_devicemodel_alias").toString());
			parametersMapDetails.put("device_devicetechnology_alias",
					listModelGetProperties.get(0).get("device_devicetechnology_alias").toString());
			parametersMapDetails.put("device_devicevendor_alias",
					listModelGetProperties.get(0).get("device_devicevendor_alias").toString());
			parametersMapDetails.put("device_devicetype_alias",
					listModelGetProperties.get(0).get("device_devicetype_alias").toString());

			listDetails.add(parametersMapDetails);

			for (int i = 0; i < listModelGetProperties.size(); i++) {
				// Initializing the map.
				Map<String, Object> parametersMapProperties = new HashMap<>();
				// Adding Parameters to map
				parametersMapProperties.put("device_properties_name",
						(listModelGetProperties.get(i).get("device_properties_name")) != null
								? listModelGetProperties.get(i).get("device_properties_name").toString() : "");

				parametersMapProperties.put("device_properties_alias",
						(listModelGetProperties.get(i).get("device_properties_alias")) != null
								? listModelGetProperties.get(i).get("device_properties_alias").toString() : "");
				parametersMapProperties.put("service_servicedatatypes_name",
						(listModelGetProperties.get(i).get("service_servicedatatypes_name")) != null
								? listModelGetProperties.get(i).get("service_servicedatatypes_name").toString() : "");

				parametersMapProperties.put("device_model_properties_is_visible_on_performance_report",
						(listModelGetProperties.get(i)
								.get("device_model_properties_is_visible_on_performance_report")) != null
										? listModelGetProperties.get(i)
												.get("device_model_properties_is_visible_on_performance_report")
												.toString()
										: "");
				parametersMapProperties.put("device_model_properties_is_visible_on_gis",
						(listModelGetProperties.get(i).get("device_model_properties_is_visible_on_gis")) != null
								? listModelGetProperties.get(i).get("device_model_properties_is_visible_on_gis")
										.toString()
								: "");

				listProperties.add(parametersMapProperties);
			}

			/*
			 * To get the particular RquestType to call respective Stored
			 * Procedures.
			 */
			Object modelGetServices = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("341").toString(), user_key, user_id,
					passingParameterMap.get("device_model_id"));

			// Conversion of Object class into list<map>
			List<Map<String, Object>> listGetService = (List<Map<String, Object>>) modelGetServices;

			// initialization of new list
			List<Map<String, Object>> serviceList = new ArrayList<>();

			// Manipulation in displaying data in excel
			for (Map<String, Object> servicesMap : listGetService) {

				// Check if editable and priority is null
				if (servicesMap.get("service_servicedatasource_is_editable") == null
						&& servicesMap.get("service_servicedatasource_priority") == null) {

					servicesMap.put("service_servicedatasource_is_editable", "");
					servicesMap.put("service_servicedatasource_priority", "");

				}
				// Check for specific value of editable field
				else if (servicesMap.get("service_servicedatasource_is_editable").toString().equalsIgnoreCase("0")) {
					servicesMap.put("service_servicedatasource_is_editable", "Read");

				}

				else {
					servicesMap.put("service_servicedatasource_is_editable", "Read Write");
				}

				// Check for specific value of priority field
				if (servicesMap.get("service_servicedatasource_priority").toString().equalsIgnoreCase("1")) {
					servicesMap.put("service_servicedatasource_priority", "High");
				} else if (servicesMap.get("service_servicedatasource_priority").toString().equalsIgnoreCase("2")) {
					servicesMap.put("service_servicedatasource_priority", "Medium");
				} else {
					servicesMap.put("service_servicedatasource_priority", "Low");
				}

				serviceList.add(servicesMap);

			}

			Object modelGetServicesEdit = serviceList;
			// System.out.println("+++" + modelGetServicesEdit);

			Object modelGetErrorCodes = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("340").toString(), user_key, user_id,
					passingParameterMap.get("device_model_id"));

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
			builder.append("'" + reportURL + "/details',");
			builder.append("'" + reportURL + "/properties',");
			builder.append("'" + reportURL + "/sensors',");
			builder.append("'" + reportURL + "/error/codes'");

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
					.executeAnySqlQueryMetaData(SQL_QUERY.toString());

			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put("device/get/model/details", listDetails);
			map.put("device/get/model/properties", listModelGetProperties);
			map.put("device/get/model/sensors", modelGetServicesEdit);
			map.put("device/get/model/error/codes", modelGetErrorCodes);

			// System.out.println("MAP IS --" + map);

			// Check if data returned from API's is not null then only download
			// else give exceptions
			if (modelGetServicesEdit != null && modelGetErrorCodes != null && modelGetProperties != null) {

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
