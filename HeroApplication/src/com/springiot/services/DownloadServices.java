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
	public Message DownloadGenericProcedureCalling(Map<String, String> passingParameterMap) {
		Message responseMessage = new Message();
		try {

			String requestType = "";

			/**
			 * to get the particular RquestType to call respective Stored
			 * Procedure
			 */
			if (passingParameterMap.get("requestType") == null) {
				responseMessage.setDescription("Request Type Need.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			requestType = passingParameterMap.get("requestType").toString();
			passingParameterMap.remove("requestType");
			/**
			 * to get the particular Report Name to generate Report
			 */

			if (passingParameterMap.get("report_name") == null) {
				responseMessage.setDescription("Report Name  Need.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			String reportName = passingParameterMap.get("report_name").toString();
			passingParameterMap.remove("report_name");

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			Message headerData = genericProcess.GenericProcedureCalling(requestType, passingParameterMap, null);
			System.out.println(headerData.getObject());

			/**
			 * If headerData is Valid
			 */
			if (headerData.isValid()) {

				/**
				 * List<Map<String, Object>> of headerData Object
				 */
				List<Map<String, Object>> headerDataUrlMessageList = (List<Map<String, Object>>) headerData.getObject();
				System.out.println(headerDataUrlMessageList);

				/**
				 * If list size is not Zero
				 */
				if (headerDataUrlMessageList.size() > 0) {
					List<Object> Header = new ArrayList<>();

					/**
					 * To get the Header for Downloading Excel
					 */
					Header.addAll(headerDataUrlMessageList.get(0).keySet());
					System.out.println(Header.toString());

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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
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
	 * downloadDailyReportHorn To Download Daily Horn Report with Template Data
	 * 
	 * @param passingParameterMap
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public Message downloadDailyReportHorn(Map<String, String> passingParameterMap) {

		/*
		 * To initialize the response mesage
		 */
		Message responseMessage = new Message();

		try {
			/*
			 * Passing parameter map to get header
			 */
			Map<String, String> headerPassingParameter = new HashMap<>();

			/**
			 * to get the particular RquestType to call respective Stored
			 * Procedure
			 */
			/*
			 * to check if device_id is null
			 */
			if (passingParameterMap.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("device_id", passingParameterMap.get("device_id"));
			/*
			 * to check if report date is null
			 */
			if (passingParameterMap.get("report_date") == null) {

				responseMessage.setDescription("report_date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("report_date", passingParameterMap.get("report_date"));

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure header Data
			 */
			Message headerData = genericProcess.GenericProcedureCalling("48", headerPassingParameter, null);
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure daily Report Grid Data
			 */
			Message dailyReportData = genericProcess.GenericProcedureCalling("32", passingParameterMap, null);
			System.out.println(dailyReportData.getObject());
			/**
			 * If headerData and Grid data is valid is Valid
			 */
			if (headerData.isValid() && dailyReportData.isValid()) {
				/**
				 * List<Map<String, Object>> of headerData Object
				 */

				new TypeToken<Map<String, String>>() {
				}.getType();

				Map<String, Object> headerDataUrlMessageList = new HashMap<String, Object>();

				try {
					List<HashMap<String, Object>> dailyReportDataList = (List<HashMap<String, Object>>) headerData
							.getObject();
					headerDataUrlMessageList = dailyReportDataList.get(0);

				} catch (Exception e) {
					System.out.println("inside exception");
				}
				/*
				 * to get grid data in List<Map<String, Object>> format
				 */
				List<Map<String, Object>> reportDataUrlMessageList = (List<Map<String, Object>>) dailyReportData
						.getObject();

				List<Map<String, Object>> reportDataUrlMessage = new ArrayList<>();
				/**
				 * to remove parameter which are not needed in setting the data
				 */
				for (Map<String, Object> map : reportDataUrlMessageList) {
					map.remove("device_id");
					map.remove("device_no");
					map.remove("id");
					map.remove("report_date");
					map.remove("slot");
					reportDataUrlMessage.add(map);
				}
				/**
				 * to check if both header and grid data is not null
				 */
				if (!(headerDataUrlMessageList == null) && !(reportDataUrlMessageList == null)) {

					/**
					 * If list size is not Zero
					 */
					if (headerDataUrlMessageList.size() > 0) {

						/**
						 * Get FilePath of downloded Excel
						 */
						String filePath = downloadHornReport(reportDataUrlMessage, headerDataUrlMessageList,
								"Daily_Report_Horn" + endDate());
						if (filePath != null) {

							String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

							Map<String, Object> filePathMap = new HashMap<>();

							/**
							 * filePathMap to add path of Downloaded File
							 */
							filePathMap.put("file", finalPath);
							filePathMap.put("orignalPath", filePath);
							/*
							 * Return response
							 */
							responseMessage.setDescription("Data is successfully downloaded");
							responseMessage.setObject(filePathMap);
							responseMessage.setValid(true);
							return responseMessage;

						}

					}
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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To create excel report of horn and return its path
	 * 
	 * @param dailyReportDatalist
	 * @param headerDataUrlMessageList
	 * @param sheetName
	 * @return
	 */
	private String downloadHornReport(List<Map<String, Object>> dailyReportDatalist,
			Map<String, Object> headerDataUrlMessageList, String sheetName) {

		try {

			/**
			 * Creates object of Excel Class
			 */
			ExcelDailyHorn excel = new ExcelDailyHorn();
			/*
			 * to get workbook
			 */
			XSSFWorkbook workbook = excel.getXSSFWorkbook(customerService);
			/*
			 * to get server path where file will be write
			 */
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);
			/*
			 * To get directory
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			/*
			 * if directory doesn't exist than create directory
			 */
			if (!dir.exists())
				dir.mkdirs();
			/*
			 * To get boolean value that file is set or not
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, dailyReportDatalist, headerDataUrlMessageList);
			System.out.println(flag);
			/*
			 * if file set successfully than return file path
			 */
			if (flag) {
				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * if process fails return null
		 */
		return null;
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

	/**
	 * To Download File Of Daily Report Of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message downloadDailyReportSS(Map<String, String> passingParameterMap) {
		/*
		 * To initialize the response mesage
		 */
		Message responseMessage = new Message();

		try {
			/*
			 * Passing parameter map to get header
			 */
			Map<String, String> headerPassingParameter = new HashMap<>();

			/*
			 * to check if device_id is null
			 */

			if (passingParameterMap.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("device_id", passingParameterMap.get("device_id"));
			/*
			 * to check if report date is null
			 */
			if (passingParameterMap.get("report_date") == null) {

				responseMessage.setDescription("report_date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("report_date", passingParameterMap.get("report_date"));
			// passingParameterMap.remove("device_id");
			System.out.println("headerPassingParameter" + headerPassingParameter.toString());
			System.out.println("passingParameterMap" + passingParameterMap.toString());

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure header Data
			 */
			Message headerData = genericProcess.GenericProcedureCalling("38", headerPassingParameter, null);
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure daily Report Grid Data
			 */
			Message dailyReportData = genericProcess.GenericProcedureCalling("36", passingParameterMap, null);
			System.out.println(dailyReportData.getObject());
			/**
			 * If headerData and Grid data is valid is Valid
			 */
			if (headerData.isValid() && dailyReportData.isValid()) {
				/**
				 * List<Map<String, Object>> of headerData Object
				 */

				new TypeToken<Map<String, String>>() {
				}.getType();

				Map<String, Object> headerDataUrlMessageList = new HashMap<String, Object>();
				//
				try {
					List<HashMap<String, Object>> dailyReportDataList = (List<HashMap<String, Object>>) headerData
							.getObject();
					headerDataUrlMessageList = dailyReportDataList.get(0);

					System.out.println("Header Data List:" + headerDataUrlMessageList);
				} catch (Exception e) {
					System.out.println("inside exception");
				}
				/*
				 * to get grid data in List<Map<String, Object>> format
				 */
				List<Map<String, Object>> reportDataUrlMessageList = (List<Map<String, Object>>) dailyReportData
						.getObject();
				System.out.println("Data List:" + reportDataUrlMessageList);

				List<Map<String, Object>> reportDataUrlMessage = new ArrayList<>();
				/**
				 * to remove parameter which are not needed in setting the data
				 */
				for (Map<String, Object> map : reportDataUrlMessageList) {
					map.remove("device_id");
					map.remove("device_no");
					map.remove("id");
					map.remove("report_date");
					map.remove("slot");

					reportDataUrlMessage.add(map);
				}
				/**
				 * to check if both header and grid data is not null
				 */
				if (!(headerDataUrlMessageList == null) && !(reportDataUrlMessage == null)) {

					/**
					 * If list size is not Zero
					 */
					if (headerDataUrlMessageList.size() > 0) {

						/**
						 * Get FilePath of downloded Excel
						 */
						String filePath = downloadSSReport(reportDataUrlMessage, headerDataUrlMessageList,
								"Daily_Report_Side_Stand" + endDate());
						if (filePath != null) {

							System.out.println("file Path:- " + filePath);

							String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

							Map<String, Object> filePathMap = new HashMap<>();

							/**
							 * filePathMap to add path of Downloaded File
							 */
							filePathMap.put("file", finalPath);
							filePathMap.put("orignalPath", filePath);
							/*
							 * Return response
							 */
							responseMessage.setDescription("Data is successfully downloaded");
							responseMessage.setObject(filePathMap);
							responseMessage.setValid(true);
							return responseMessage;

						}

					}
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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	private String downloadSSReport(List<Map<String, Object>> dailyReportDatalist,
			Map<String, Object> headerDataUrlMessageList, String sheetName) {
		try {

			/**
			 * Creates object of Excel Class
			 */
			ExcelDailySideStand excel = new ExcelDailySideStand();
			/*
			 * to get workbook
			 */
			XSSFWorkbook workbook = excel.getXSSFWorkbook(customerService);
			/*
			 * to get server path where file will be write
			 */
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);
			/*
			 * To get directory
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			/*
			 * if directory doesn't exist than create directory
			 */
			if (!dir.exists())
				dir.mkdirs();
			/*
			 * To get boolean value that file is set or not
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, dailyReportDatalist, headerDataUrlMessageList);
			System.out.println(flag);
			/*
			 * if file set successfully than return file path
			 */
			if (flag) {
				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * if process fails return null
		 */
		return null;
	}

	/**
	 * To Download File Of Daily Report Of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked" })
	public Message downloadDailyReportRelay(Map<String, String> passingParameterMap) {
		/*
		 * To initialize the response mesage
		 */
		Message responseMessage = new Message();

		try {/*
				 * Passing parameter map to get header
				 */
			Map<String, String> headerPassingParameter = new HashMap<>();

			/*
			 * to check if device_id is null
			 */

			if (passingParameterMap.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("device_id", passingParameterMap.get("device_id"));
			/*
			 * to check if report date is null
			 */
			if (passingParameterMap.get("report_date") == null) {

				responseMessage.setDescription("report_date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("report_date", passingParameterMap.get("report_date"));

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure header Data
			 */
			Message headerData = genericProcess.GenericProcedureCalling("37", headerPassingParameter, null);
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure daily Report Grid Data
			 */
			Message dailyReportData = genericProcess.GenericProcedureCalling("35", passingParameterMap, null);

			/**
			 * If headerData and Grid data is valid is Valid
			 */
			if (headerData.isValid() && dailyReportData.isValid()) {
				/**
				 * List<Map<String, Object>> of headerData Object
				 */

				new TypeToken<Map<String, String>>() {
				}.getType();

				Map<String, Object> headerDataUrlMessageList = new HashMap<String, Object>();
				//
				try {
					List<HashMap<String, Object>> dailyReportDataList = (List<HashMap<String, Object>>) headerData
							.getObject();
					headerDataUrlMessageList = dailyReportDataList.get(0);

					System.out.println("header data List:" + headerDataUrlMessageList);
				} catch (Exception e) {
					System.out.println("inside exception");
				}
				/*
				 * to get grid data in List<Map<String, Object>> format
				 */
				List<Map<String, Object>> reportDataUrlMessageList = (List<Map<String, Object>>) dailyReportData
						.getObject();
				System.out.println(reportDataUrlMessageList);

				List<Map<String, Object>> reportDataUrlMessage = new ArrayList<>();
				/**
				 * to remove parameter which are not needed in setting the data
				 */
				for (Map<String, Object> map : reportDataUrlMessageList) {
					map.remove("device_id");
					map.remove("device_no");
					map.remove("id");
					map.remove("report_date");
					map.remove("slot");

					reportDataUrlMessage.add(map);
				}
				/**
				 * to check if both header and grid data is not null
				 */
				if (!(headerDataUrlMessageList == null) && !(reportDataUrlMessageList == null)) {

					/**
					 * If list size is not Zero
					 */
					if (headerDataUrlMessageList.size() > 0) {

						/**
						 * Get FilePath of downloded Excel
						 */
						String filePath = downloadRelayReport(reportDataUrlMessage, headerDataUrlMessageList,
								"Daily_Report_Relay" + endDate());
						if (filePath != null) {

							/**
							 * Get FilePath of downloded Excel
							 */
							String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

							Map<String, Object> filePathMap = new HashMap<>();

							/**
							 * filePathMap to add path of Downloaded File
							 */
							filePathMap.put("file", finalPath);
							filePathMap.put("orignalPath", filePath);
							/*
							 * Return response
							 */

							responseMessage.setDescription("Data is successfully downloaded");
							responseMessage.setObject(filePathMap);
							responseMessage.setValid(true);
							return responseMessage;

						}

					}
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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To create excel report of Relay and return its path
	 * 
	 * @param dailyReportDatalist
	 * @param headerDataUrlMessageList
	 * @param sheetName
	 * @return
	 */
	private String downloadRelayReport(List<Map<String, Object>> dailyReportDatalist,
			Map<String, Object> headerDataUrlMessageList, String sheetName) {

		try {

			/**
			 * Creates object of Excel Class
			 */
			ExcelDailyRelay excel = new ExcelDailyRelay();
			/*
			 * to get workbook
			 */
			XSSFWorkbook workbook = excel.getXSSFWorkbook(customerService);
			/*
			 * to get server path where file will be write
			 */
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);
			/*
			 * To get directory
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			/*
			 * if directory doesn't exist than create directory
			 */
			if (!dir.exists())
				dir.mkdirs();
			/*
			 * To get boolean value that file is set or not
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, dailyReportDatalist, headerDataUrlMessageList);
			System.out.println(flag);
			/*
			 * if file set successfully than return file path
			 */
			if (flag) {
				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * if process fails return null
		 */
		return null;
	}

	/**
	 * To Download File Of Excel Planner Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message downloadDailyPlanner(Map<String, String> passingParameterMap, HttpServletRequest req,
			HttpServletResponse res) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();

		try {
			/**
			 * To get Host url link address
			 */
			String Url = req.getRequestURL().toString();
			String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
			System.out.println(hostUrl);

			// String hostUrl = "http://192.168.1.73:7878";
			/*
			 * to check if token is null
			 */
			if (passingParameterMap.get("token") == null) {

				responseMessage.setDescription("token Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result to get planner header
			 */
			Message plannerHeaderData = genericProcess.GenericProcedureCalling("33", passingParameterMap, null);
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result to get planner Equipment
			 */
			Message plannerEquipmentExcelData = genericProcess.GenericProcedureCalling("34", passingParameterMap, null);
			System.out.println("plannerEquipmentExcelData" + plannerEquipmentExcelData.getObject());
			/**
			 * If plannerHeaderData is Valid
			 */
			if (plannerHeaderData.isValid() && plannerEquipmentExcelData.isValid()) {
				/**
				 * List<Map<String, Object>> of headerData Object
				 */

				List<HashMap<String, Object>> plannerData = (List<HashMap<String, Object>>) plannerHeaderData
						.getObject();
				Map<String, Object> plannerHeaderMap = new HashMap<String, Object>();
				Map<String, String> passingSignatureParameter = new HashMap<>();
				passingSignatureParameter.put("planner_number", passingParameterMap.get("planner_number"));
				passingSignatureParameter.put("planner_version", passingParameterMap.get("planner_version"));

				List<Map<String, Object>> plannerDataList = new ArrayList<>();
				try {
					/**
					 * Removing not needed parameter
					 */
					for (HashMap<String, Object> hashMap : plannerData) {
						plannerHeaderMap.put("planner_name", hashMap.get("planner_name"));
						plannerHeaderMap.put("planner_version", hashMap.get("planner_version"));
						plannerHeaderMap.put("planner_number", hashMap.get("planner_number"));
						plannerHeaderMap.put("creation_date", hashMap.get("creation_date"));

						hashMap.remove("id");
						hashMap.remove("planner_name");
						hashMap.remove("planner_version");
						hashMap.remove("planner_number");
						hashMap.remove("creation_date");
						hashMap.remove("vibration");
						hashMap.remove("vibration_duration");
						hashMap.remove("thermocycle");
						hashMap.remove("thermocycle_duration");
						hashMap.remove("thermal_shock");
						hashMap.remove("thermal_shock_duration");
						hashMap.remove("environmental");
						hashMap.remove("environmental_duration");
						hashMap.remove("revised_date");
						hashMap.remove("repeated_operation");
						hashMap.remove("shower");
						hashMap.remove("dust");
						hashMap.remove("vibration");
						hashMap.remove("model");
						hashMap.remove("ro_testing_status");
						hashMap.remove("shower_testing_status");
						hashMap.remove("dust_testing_status");

						plannerDataList.add(hashMap);
					}
					/*
					 * Checking plannerDataList is not null
					 */
					if (plannerDataList.size() == 0) {
						responseMessage.setDescription("Download Fail Planner Data is Null");
						responseMessage.setValid(false);
						return responseMessage;
					}

				} catch (Exception e) {
					System.out.println("inside exception");
				}
				/*
				 * to get plannerEquipmentDataList in List<Map<String, Object>>
				 * format
				 */
				List<Map<String, Object>> plannerEquipmentDataList = (List<Map<String, Object>>) plannerEquipmentExcelData
						.getObject();
				List<Map<String, Object>> EquipmentDataeList = new ArrayList<>();
				/**
				 * removing not needed parameter
				 */
				for (Map<String, Object> map : plannerEquipmentDataList) {
					map.remove("creation_date");
					map.remove("is_submitted");
					EquipmentDataeList.add(map);
				}
				/**
				 * Getting signature for planner download
				 */
				List<Map<String, Object>> plannerSignatureExcelData = (List<Map<String, Object>>) genericProcess
						.GenericProcedureCalling("183", passingSignatureParameter, null).getObject();
				if (plannerSignatureExcelData != null && plannerSignatureExcelData.size() > 0) {

					for (int k = 0; k < plannerSignatureExcelData.size(); k++) {
						Map<String, Object> mapSig = plannerSignatureExcelData.get(k);
						for (String key : mapSig.keySet()) {
							String pdfGenrationResponse = mapSig.get(key).toString();
							/*
							 * to check if its on server or not
							 */
							if (pdfGenrationResponse.indexOf("tmpFiles") == -1) {
								plannerSignatureExcelData.get(k).put(key, pdfGenrationResponse);
								continue;
							}
							/*
							 * to get image path in formated way
							 */
							String tempFile = URLEncoder.encode(pdfGenrationResponse
									.substring(pdfGenrationResponse.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

							plannerSignatureExcelData.get(k).put(key,
									hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
						}

					}
				}
				/**
				 * If list size is not Zero
				 */
				if (!(plannerDataList == null) && !(plannerEquipmentDataList == null)) {
					/**
					 * Get FilePath of downloded Excel
					 */
					String filePath = downloadPlanner(EquipmentDataeList, plannerDataList, plannerHeaderMap,
							plannerSignatureExcelData, "Planner" + endDate());
					/*
					 * to check file path is not null
					 */
					if (filePath != null) {

						System.out.println("file Path:- " + filePath);

						String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

						Map<String, Object> filePathMap = new HashMap<>();

						/**
						 * filePathMap to add path of Downloaded File
						 */
						filePathMap.put("file", finalPath);
						filePathMap.put("orignalPath", filePath);
						/*
						 * return response
						 */
						responseMessage.setDescription("Data is successfully downloaded");
						responseMessage.setObject(filePathMap);
						responseMessage.setValid(true);
						return responseMessage;

					}

				} else {
					responseMessage.setDescription("Downloading failed");
					responseMessage.setValid(false);
					return responseMessage;

				}
			}

			else {
				/**
				 * If headerData Object is not Valid
				 */
				responseMessage.setDescription("Issue With File Generation....");
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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To generate planner excel report and return its path
	 * 
	 * @param plannerEquipmentDataList
	 * @param plannerDataList
	 * @param headerPlanner
	 * @param plannerSignatureExcelData
	 * @param sheetName
	 * @return
	 */
	private String downloadPlanner(List<Map<String, Object>> plannerEquipmentDataList,
			List<Map<String, Object>> plannerDataList, Map<String, Object> headerPlanner,
			List<Map<String, Object>> plannerSignatureExcelData, String sheetName) {

		try {

			/**
			 * Creates object of Excel Class
			 */
			ExcelPlanner excel = new ExcelPlanner();
			/*
			 * to get workbook
			 */
			XSSFWorkbook workbook = excel.getXSSFWorkbook(customerService);
			/*
			 * to get server path where file will be write
			 */
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);
			/*
			 * To get directory
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			/*
			 * if directory doesn't exist than create directory
			 */
			if (!dir.exists())
				dir.mkdirs();
			/*
			 * To get boolean value that file is set or not
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, plannerEquipmentDataList, plannerDataList,
					plannerSignatureExcelData, headerPlanner);
			/*
			 * if file set successfully than return file path
			 */
			if (flag) {
				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * if process fails return null
		 */
		return null;
	}

	/**
	 * To Download File Of Lock Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message downloadDailyExcelReportLock(Map<String, String> passingParameterMap) {

		/*
		 * To initialize the response mesage
		 */
		Message responseMessage = new Message();

		try {
			/*
			 * Passing parameter map to get header
			 */
			Map<String, String> headerPassingParameter = new LinkedHashMap<String, String>();

			/*
			 * to check if device_id is null
			 */

			if (passingParameterMap.get("device_id") == null) {

				responseMessage.setDescription("device_id Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("device_id", passingParameterMap.get("device_id"));
			/*
			 * to check if report date is null
			 */
			if (passingParameterMap.get("report_date") == null) {

				responseMessage.setDescription("report_date Needed.");
				responseMessage.setValid(false);
				return responseMessage;
			}
			headerPassingParameter.put("report_date", passingParameterMap.get("report_date"));
			headerPassingParameter.put("cycle", passingParameterMap.get("cycle"));

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure header Data
			 */
			Message headerData = genericProcess.GenericProcedureCalling("316", headerPassingParameter, null);
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure daily Report Grid Data
			 */
			Message dailyReportData = genericProcess.GenericProcedureCalling("317", passingParameterMap, null);
			System.out.println(dailyReportData.getObject());
			/**
			 * If headerData is Valid
			 */
			if (headerData.isValid() && dailyReportData.isValid()) {
				/**
				 * List<Map<String, Object>> of headerData Object
				 */

				new TypeToken<Map<String, String>>() {
				}.getType();

				Map<String, Object> headerDataUrlMessageList = new HashMap<String, Object>();
				//
				try {
					List<HashMap<String, Object>> dailyReportDataList = (List<HashMap<String, Object>>) headerData
							.getObject();
					headerDataUrlMessageList = dailyReportDataList.get(0);

					System.out.println("header data List:" + headerDataUrlMessageList);
				} catch (Exception e) {
					System.out.println("inside exception");
				}
				/*
				 * to get grid data in List<Map<String, Object>> format
				 */
				List<Map<String, Object>> reportDataUrlMessageList = (List<Map<String, Object>>) dailyReportData
						.getObject();

				List<Map<String, Object>> reportDataUrlMessage = new ArrayList<>();
				/**
				 * to remove parameter which are not needed in setting the data
				 */
				for (Map<String, Object> map : reportDataUrlMessageList) {
					map.remove("device_id");
					map.remove("device_no");
					map.remove("id");
					map.remove("report_date");
					map.remove("slot");
					map.remove("status");

					reportDataUrlMessage.add(map);
				}
				/**
				 * to check if both header and grid data is not null
				 */
				if (!(headerDataUrlMessageList == null) && !(reportDataUrlMessageList == null)) {

					/**
					 * If list size is not Zero
					 */
					if (headerDataUrlMessageList.size() > 0) {

						/**
						 * Get FilePath of downloded Excel
						 */
						String filePath = downloadLockReport(reportDataUrlMessage, headerDataUrlMessageList,
								"Daily_Report_Lock_Cycle" + passingParameterMap.get("cycle") + "_" + endDate());
						if (filePath != null) {

							System.out.println("file Path:- " + filePath);

							String finalPath = filePath.substring(filePath.lastIndexOf("webapps") + 8);

							Map<String, Object> filePathMap = new HashMap<>();

							/**
							 * filePathMap to add path of Downloaded File
							 */
							filePathMap.put("file", finalPath);
							filePathMap.put("orignalPath", filePath);
							/*
							 * Return response
							 */
							responseMessage.setDescription("Data is successfully downloaded");
							responseMessage.setObject(filePathMap);
							responseMessage.setValid(true);
							return responseMessage;

						}

					}
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
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	private String downloadLockReport(List<Map<String, Object>> dailyReportDatalist,
			Map<String, Object> headerDataUrlMessageList, String sheetName) {

		try {

			/**
			 * Creates object of Excel Class
			 */
			ExcelDailyReportLock excel = new ExcelDailyReportLock();
			/*
			 * to get workbook
			 */
			XSSFWorkbook workbook = excel.getXSSFWorkbook(customerService);
			/*
			 * to get server path where file will be write
			 */
			String rootPath = System.getProperty("catalina.home");

			System.out.println("root Path:- " + rootPath);
			/*
			 * To get directory
			 */
			File dir = new File(rootPath + File.separator + "webapps/tmpFiles");
			/*
			 * if directory doesn't exist than create directory
			 */
			if (!dir.exists())
				dir.mkdirs();
			/*
			 * To get boolean value that file is set or not
			 */
			boolean flag = excel.setSheetData(workbook, sheetName, dailyReportDatalist, headerDataUrlMessageList);
			System.out.println(flag);
			/*
			 * if file set successfully than return file path
			 */
			if (flag) {
				return excel.createExcel(workbook, sheetName, dir.getAbsolutePath());
			}

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * if process fails return null
		 */
		return null;
	}

}
