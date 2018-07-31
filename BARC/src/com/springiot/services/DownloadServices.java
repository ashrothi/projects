/**
 * This package contain the Services class for Download Reports.
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.io.File;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.google.gson.reflect.TypeToken;
import com.springiot.constant.CustomerService;
import com.springiot.excel.*;
import com.springiot.response.Message;

/**
 * DownloadServices class do all the operations related to downloading the
 * report
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class DownloadServices {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private CustomerService customerService;

	/**
	 * To Download Excel file from the respective API's by entering their
	 * request type and parameters to call the API
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked" })
	public Message DownloadGenericProcedureCalling(Map<String, Object> map, String requestType) {
		Message responseMessage = new Message();
		try {

			/**
			 * to get the particular Report Name to generate Report
			 */

			if (map.get("report_name") == null) {
				responseMessage.setDescription("Report Name  Need.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportName = map.get("report_name").toString();
			map.remove("report_name");

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			Message headerData = genericProcess.GenericProcedureCalling(requestType, map, null, null);
			// System.out.println(headerData.getObject());

			/**
			 * If headerData is Valid
			 */
			if (headerData.isValid()) {

				/**
				 * List<Map<String, Object>> of headerData Object
				 */
				List<Map<String, Object>> headerDataUrlMessageList = (List<Map<String, Object>>) headerData.getObject();
				// System.out.println("headerDataUrlMessageList " +
				// headerDataUrlMessageList);

				/**
				 * If list size is not Zero
				 */
				if (headerDataUrlMessageList.size() > 0) {
					List<Object> Header = new ArrayList<>();

					/**
					 * To get the Header for Downloading Excel
					 */
					Header.addAll(headerDataUrlMessageList.get(0).keySet());
					// System.out.println(Header.toString());

					/**
					 * Get FilePath of downloded Excel
					 */
					String filePath = downloadReport(headerDataUrlMessageList, Header, reportName);

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

			} else {
				/**
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Issue With File Generation.No Data from Procedure");
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
	private String downloadReport(List<Map<String, Object>> headerData, List<Object> reportHeader, String sheetName) {

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
			boolean flag = excel.setSheetData(workbook, sheetName, headerData, reportHeader);
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
	public String convertDate(String dateStr) {

		DateFormat readFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
		DateFormat writeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

	}

}
