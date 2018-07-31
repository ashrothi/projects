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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springiot.constant.TableParameter;
import com.springiot.domain.SwaggerClassGenerator;
import com.springiot.domain.TemplateSwagger;
import com.springiot.excel.Excel;
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
	@Autowired
	private GenericProcess genericProcess;

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

		/*
		 * // Retrieve user_key and user_id from Headers String user_key =
		 * request.getHeader("user_key"); String user_id =
		 * request.getHeader("user_id");
		 */

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
					.executeAnySqlQuery(SQL_QUERY.toString());
			// System.out.println("tableResponse" + tableResponse);
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
			// System.out.println("columnDataType" + columnDataType.toString());
			/*
			 * To get the Header while Downloading Excel
			 */
			String[] reportArray = columnAlias.split(",");
			for (int i = 0; i < reportArray.length; i++) {
				Header.add(reportArray[i]);
			}
			// System.out.println("Header" + Header);
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
				 * of excel file. //
				 */
				// System.out.println("headerDataUrlMessageList" +
				// headerDataUrlMessageList);

				for (Map<String, Object> dbData : headerDataUrlMessageList) {

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
				if (headerDataUrlMessageList.size() >= 0) {

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
			// String rootPath = "/home/";
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

	public Message downloadOrgConfig(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("map "+map.get("id"));
		try {
			Message message = new Message();
			/*Map<String, String> newpassingParameterMap = new LinkedHashMap<>();
			newpassingParameterMap.put("id", map.get("id"));*/
			//System.out.println("newpassingParameterMap "+newpassingParameterMap);
			Message userCreate = genericProcess.GenericProcedureCalling("79", map, null, request,
					response);
			//System.out.println("response from proc "+userCreate.getObject().);
			
			System.out.println("userCreate "+userCreate);
			List<Map<String, Object>> subscriptionDetaillist = (List<Map<String, Object>>) userCreate.getObject();
if(subscriptionDetaillist.size()==0 || subscriptionDetaillist.toString()==null){
	System.out.println("Data not available for this organization id");
	message.setDescription("Data not available for this organization id");
	return message;
	
}
			Map<String, String> templateMap = new HashMap<>();
			for (Map<String, Object> dbData : subscriptionDetaillist) {
				templateMap.put("name", dbData.get("ftp_user").toString());
				templateMap.put("ip", dbData.get("root_ftp_url").toString());
				templateMap.put("username", dbData.get("ftp_user").toString());
				templateMap.put("password", dbData.get("ftp_password").toString());
			}
			TemplateSwagger templateReport = new TemplateSwagger();
			String responsedata = templateReport.TemplateReportFile("template/config.vm", templateMap);
//System.out.println("responsedata for file reading"+responsedata);
			// String path = "/home/tanvigarg/Documents/" +
			// templateMap.get("name") + ".xml";//file extensionname
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);

			String value = SwaggerClassGenerator.generatePDF(responsedata,
					rootPath + File.separator + "webapps/tmpFiles/"+templateMap.get("name") + ".xml"); 
																		// return

			//System.out.println("value " + value);
			System.out.println("Server File Location=" + value);

			message.setDescription("You have successfully downloaded file=" +templateMap.get("name").toString() );
			message.setObject(value);
			message.setValid(true);
			return message;
		} catch (Exception e) {
			/**
			 * To Catch exception if it comes
			 */
			e.printStackTrace();

		}
		return null;
		
	}
	
}
