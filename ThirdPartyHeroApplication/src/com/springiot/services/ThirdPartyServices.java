/**
 * This package contain the Service class for Third Party Services Service to get all API with some manipulation and logic applied on api according to the user
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class ThirdPartyServices {

	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private GenericService genericService;

	@Autowired
	private MappingHandlerService mappingHandlerService;

	/**
	 * Service to Get Planner Name Detail It give the planner according to the
	 * month
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 * 
	 */
	@SuppressWarnings({ "serial", "unused" })
	public Message getPlannerName(String requestType, Map<String, String> map) {
		Message responseMessage = new Message();

		try {
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			Message plannerName = genericProcess.GenericProcedureCalling(requestType, map, null);
			/*
			 * To Print response
			 */
			System.out.println("planner Json:- " + new Gson().toJson(plannerName.getObject()));

			/**
			 * To Check if plannerName is not null
			 */
			if (plannerName != null) {
				/*
				 * Casting response in List<Map<String, Object>> format
				 */
				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				String plannerDataToUpdate = new Gson().toJson(plannerName.getObject());
				/**
				 * To make List of Map of Json data of Planner Procedure
				 * response
				 */
				List<Map<String, Object>> gridDataList = new Gson().fromJson(plannerDataToUpdate, type);

				/**
				 * Creating a Multimap so that we can store Multiple value of
				 * Single key in a map
				 */

				Multimap<String, Object> plannerDataMultimap = ArrayListMultimap.create();
				/*
				 * Store response monthwise
				 */
				for (Map<String, Object> inuploadListMap : gridDataList) {
					plannerDataMultimap.put(inuploadListMap.get("month").toString(), inuploadListMap);
				}
				/**
				 * List of To add all map of plannerDataMultimap in
				 * plannerMapList
				 */
				List<Object> plannerMapList = new ArrayList<>();
				/*
				 * to get each month from multimap
				 */
				for (String key : plannerDataMultimap.keySet()) {

					/**
					 * gridDataFinalMap to set Data as required .to get the
					 * Planner Name Month wise
					 */
					Map<String, Object> plannerDataFinalMap = new HashMap<>();

					/**
					 * Inserting Value month wise in plannerDataFinalMap
					 */
					plannerDataFinalMap.put("month", key.replace(".0", ""));
					plannerDataFinalMap.put("planner", plannerDataMultimap.get(key));

					/**
					 * Adding plannerDataFinalMap in plannerMapList
					 */
					plannerMapList.add(plannerDataFinalMap);

				}

				/**
				 * To Make Json of Final Response
				 */
				String finalMonthwisePlannerResult = new Gson().toJson(plannerMapList);
				/*
				 * to check if response is not null
				 */
				if (plannerMapList != null) {
					/**
					 * Sucess Message with required format of data
					 */
					responseMessage.setDescription("Final Otput");
					responseMessage.setObject(plannerMapList);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Upload Inventory To upload The excel master list and insert its data
	 * into the given table in DB
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public Message uploadInventory(String requestType, Map<String, String> map) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * Initializing variables to get it from procedure and use it in
			 * other Procedure
			 */
			String file_path = "";
			String file_id = "";
			String token = "";

			/**
			 * To Upload the File Upload detail by calling its stored procedure
			 */
			Message uplodedFile = genericProcess.GenericProcedureCalling(requestType, map, null);

			/**
			 * Check if the upload file is valid or not
			 */
			if (!uplodedFile.isValid()) {

				responseMessage.setDescription("File Not Found");
				responseMessage.setValid(false);
				return responseMessage;
			}

			/**
			 * uploadlist is gridDataList of map of uplodedFile
			 */
			List<Map<String, Object>> uploadlist = (List<Map<String, Object>>) uplodedFile.getObject();

			System.out.println(uplodedFile.getObject());

			/**
			 * To get File_id from uplodedFile
			 */
			for (Map<String, Object> inuploadListMap : uploadlist) {
				file_id = inuploadListMap.get("file_id").toString().trim();
			}

			/**
			 * To get file_path from uplodedFile
			 */
			if (map.get("file_path") == null) {
				System.out.println("path is null");
			}
			file_path = map.get("file_path").toString().trim();
			map.remove("file_path");
			System.out.println(file_path);

			/**
			 * To get token from uplodedFile
			 */
			if (map.get("token") == null) {
				System.out.println("token is null");
			}
			token = map.get("token").toString();
			map.remove("token");

			/**
			 * To Get Json of Uploaded excel data
			 */
			String uploadData = new Gson().toJson(uplodedFile.getObject());

			/**
			 * To check if uplodedFile is not null
			 */
			if (!(uplodedFile == null)) {

				List<List<Object>> gridDataList = new ArrayList<>();

				/**
				 * To Get the File Path of Excel to be Uploaded
				 */
				FileInputStream file = new FileInputStream(new File(file_path));

				/**
				 * To Declare XSSFWorkbook object as workbook in given Excel
				 */
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				/**
				 * To Get First Sheet of the workbook
				 */
				XSSFSheet sheet = workbook.getSheetAt(0);

				/**
				 * To get no of columns in the excel
				 */
				int cellCount = sheet.getRow(0).getLastCellNum();

				/**
				 * Iterator Till last row of the excel
				 */
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {

					/**
					 * Declaring list of Object to store each row as map and add
					 * that map in list
					 */
					List<Object> gridMapList = new ArrayList<>();

					/**
					 * To get particular row
					 */
					Row row = sheet.getRow(i);
					/**
					 * Iterator To get each column value in respective row
					 */
					for (int j = 0; j < cellCount; j++) {
						/**
						 * Variable to store cell value
						 */
						Object cellValue = null;
						/**
						 * To get Each cell
						 */
						Cell cell = row.getCell(j);
						/**
						 * To check if cell value is null
						 */
						if (cell == null) {
							gridMapList.add("");
							continue;
						}
						/**
						 * To assign cellValue according to cell Type
						 */
						switch (cell.getCellType()) {
						case 0:
							cell.setCellType(Cell.CELL_TYPE_NUMERIC);
							cellValue = cell.getNumericCellValue();
							break;
						case 1:
							cell.setCellType(Cell.CELL_TYPE_STRING);
							cellValue = cell.getStringCellValue().trim();
							break;
						default:
							break;
						}
						/**
						 * To add Value in gridMapList
						 */
						gridMapList.add(cellValue);
					}
					/**
					 * To add gridMapList in gridDataList
					 */
					gridDataList.add(gridMapList);
				}
				System.out.println(gridDataList);
				/**
				 * To close workbook and file
				 */
				workbook.close();

				file.close();
				// System.out.println("Header "+gridDataList.get(0).toString());
				// System.out.println("Header Size"+gridDataList.get(0).size());

				/**
				 * To Check no of coloum is equal to 12 or not
				 */
				if (!(gridDataList.get(0).size() == 12)) {

					Map<String, String> passingParameterMap = new HashMap<>();
					passingParameterMap.put("token", token);
					passingParameterMap.put("file_id", file_id);
					passingParameterMap.put("is_faulty", "2");
					System.out.println("passingParameterMap " + passingParameterMap);

					/**
					 * To call the Procedure is their is issue in uploading data
					 * because of column no
					 */
					Message uplodedSuccess = genericProcess.GenericProcedureCalling("20", passingParameterMap, null);

					responseMessage
							.setDescription("Found column issue with the uploaded file. Inventory was not uploaded");
					responseMessage.setObject(uplodedSuccess);
					responseMessage.setValid(false);
					return responseMessage;

				}

				/**
				 * To creat insert query dynamically according to the data
				 */
				String dataInsertSqlQuery = createDynamicQuery(gridDataList, "inventory_parts_temporary_current", null);

				System.out.println(dataInsertSqlQuery.trim());

				StringBuilder executeSqlQueryBuilder = new StringBuilder();

				if (dataInsertSqlQuery != null) {
					/**
					 * To execute the Insert the data by passing insert query to
					 * insert the data in database
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);
					executeSqlQueryBuilder.append(executeSqlQueryStatus);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure
						 */
						System.out.println("inserted successfully");
						// Call Procedure To distribute data from temporary
						// table to main Tables
						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", token);
						passingParameterMap.put("file_id", file_id);
						System.out.println("passingParameterMap " + passingParameterMap);
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("10", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							System.out.println(uplodedSuccess.getObject());

							/**
							 * Success status
							 */
							responseMessage.setDescription("Inventory is successfully uploaded");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					} else {
						System.out.println(" Not inserted successfully");
						// Call Procedure
						/**
						 * If data Not inserted successfully than call update
						 * file status Procedure as faulty
						 */
						Map<String, String> passingParameterMap = new HashMap<>();
						passingParameterMap.put("token", token);
						passingParameterMap.put("file_id", file_id);
						passingParameterMap.put("is_faulty", "2");
						System.out.println("passingParameterMap " + passingParameterMap);

						Message uplodedSuccess = genericProcess.GenericProcedureCalling("20", passingParameterMap,
								null);

						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {
							System.out.println(uplodedSuccess.getObject());
							responseMessage.setDescription(
									"Fault in File- Issue found with column names,Inventory was not uploaded. Please upload correct file.");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(false);
							return responseMessage;
						}
					}
				} else {
					/**
					 * Error Status
					 */
					System.out.println("Found column issue with the uploaded file. Inventory was not uploaded");
					responseMessage.setDescription("Extra Column Data In Excel File To Insert");
					responseMessage.setObject(null);
					responseMessage.setValid(false);
					return responseMessage;
				}
				/*
				 * Return Success response message
				 */
				responseMessage.setDescription("Inventory Updated Successfully");
				responseMessage.setObject(uploadData);
				responseMessage.setValid(true);
				return responseMessage;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		responseMessage.setDescription("Failed Process");
		responseMessage.setObject(null);
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To create the insert query for the data came in gridDataList where keys
	 * are column name and their vales are the values to insert in table name
	 * 
	 * @param gridDataList
	 * @param tableName
	 * @param type
	 * @return
	 */
	private static String createDynamicQuery(List<List<Object>> gridDataList, String tableName, Object type) {
		try {
			/*
			 * to check grid size
			 */
			if (gridDataList.size() == 0) {
				return null;
			}
			/*
			 * To store columns name
			 */
			StringBuilder sqlQueryHeaderBuilder = new StringBuilder();
			/*
			 * To store values which has to insert in database
			 */
			StringBuilder sqlQueryBuilder = new StringBuilder();

			sqlQueryBuilder.append("insert into " + tableName.trim() + " (");

			/**
			 * To get column names and replace few Column name getting from
			 * excel according to the name of column in Database
			 */
			sqlQueryBuilder.append(gridDataList.get(0).toString().trim().replaceAll(", ", ",").replaceAll(" ", "_")
					.replaceAll("S.NO", "s_no").replace("VENDOR", "VENDOR_NAME").replace("DATE(DD-MM-YYYY)", "DATE")
					.trim().replaceAll("SHOWER_TESTING", "SHOWER").replaceAll("DUST_TESTING", "DUST")
					.replaceAll("VENDOR_NAME_CODE", "VENDOR_CODE")
					.replaceAll("VENDOR_NAME_LOCATION", "VENDOR_TEST_LOCATION"));
			sqlQueryHeaderBuilder.append(sqlQueryBuilder.toString());
			sqlQueryHeaderBuilder.deleteCharAt(sqlQueryHeaderBuilder.indexOf("["));
			sqlQueryHeaderBuilder.deleteCharAt(sqlQueryHeaderBuilder.lastIndexOf("]"));

			sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.indexOf("["));
			sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.lastIndexOf("]"));
			sqlQueryBuilder.append(") values");
			gridDataList.remove(0);

			/**
			 * To get values from each row of excel to insert in database
			 */

			for (Object list2 : gridDataList) {
				sqlQueryBuilder.append("('" + list2.toString().replaceAll(",", "','").trim() + "'");

				sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.indexOf("["));
				sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.lastIndexOf("]"));
				sqlQueryBuilder.append("),");
			}

			sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.lastIndexOf(","));

			if (type != null) {
				/**
				 * If values are duplicate than to update in table
				 */
				if (((String) type).equalsIgnoreCase("update")) {
					sqlQueryBuilder.append(" ON DUPLICATE KEY UPDATE ");
					sqlQueryBuilder.deleteCharAt(sqlQueryBuilder.indexOf("["));
					sqlQueryHeaderBuilder.deleteCharAt(sqlQueryHeaderBuilder.indexOf("["));
					sqlQueryBuilder.append(sqlQueryHeaderBuilder.toString().trim());
				}

			}

			sqlQueryBuilder.append(";");
			/**
			 * Returns dynamic insert query
			 */
			return sqlQueryBuilder.toString().trim();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/**
		 * if fault in data and unable to create insert query than it will
		 * return null
		 */
		return null;
	}

	@SuppressWarnings({ "serial", "unused" })
	public Message finalReportGetResult(String requestType, Map<String, String> map) {
		Message responseMessage = new Message();

		try {
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result
			 */
			// Message gridData =
			// genericProcess.GenericProcedureCalling(requestType, map, null);

			Message resultResponseData = genericProcess.GenericProcedureCallingMultipleResult(requestType, map, null,
					2);

			System.out.println("planner Json:- " + new Gson().toJson(resultResponseData.getObject()));

			/**
			 * To Check if gridData is not null
			 */
			if (resultResponseData != null) {

				/**
				 * To Get Json format of the coming response
				 */
				Type type = new TypeToken<List<Map<String, Object>>>() {
				}.getType();
				String resultDataToUpdate = new Gson().toJson(resultResponseData.getObject());

				List<Map<String, Object>> gridDataList = new Gson().fromJson(resultDataToUpdate, type);

				// System.out.println(gridDataList);

				/**
				 * Using MultiMap to store multiple value of single Key
				 */
				Multimap<String, Object> resultDataMultimap = ArrayListMultimap.create();

				/**
				 * Grouping the Map on the basis of is_planned key in
				 * gridDataList to resultDataMultimap
				 */
				for (Map<String, Object> inuploadListMap : gridDataList) {
					resultDataMultimap.put(inuploadListMap.get("is_planned").toString(), inuploadListMap);
				}

				System.out.println(resultDataMultimap);

				/**
				 * Defining final response of result as resultMapList
				 */
				List<Object> resultMapList = new ArrayList<>();

				for (String key : resultDataMultimap.keySet()) {

					/**
					 * resultDataFinalMap to set Data as required .to get the
					 * is_planned wise
					 */
					Map<String, Object> resultDataFinalMap = new HashMap<>();

					resultDataFinalMap.put("is_planned", key.replace(".0", ""));
					resultDataFinalMap.put("Data", resultDataMultimap.get(key));

					resultMapList.add(resultDataFinalMap);

				}

				String res = new Gson().toJson(resultMapList);

				System.out.println(res);

				if (resultMapList != null) {
					/**
					 * Sucess Message with required format of data
					 */
					responseMessage.setDescription("Final Otput");
					responseMessage.setObject(resultMapList);
					responseMessage.setValid(true);
					return responseMessage;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Error Code
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage() + e.getStackTrace());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Update Grid Data of Horn Final Report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "serial", "null" })
	public Message finalReportInsertGrid(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {
			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();
				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */
				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "temporary_final_report_horn", null);
				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */
						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));
						passingParameterMap.put("is_updatable", map.get("is_updatable"));

						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("99", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					} else {
						/**
						 * Returning Error response response
						 */
						responseMessage.setDescription("Error In Inserting Data" + executeSqlQueryStatus.toString());
						responseMessage.setValid(false);
						return responseMessage;

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To create the insert query for the data came in gridDataList where keys
	 * are column name and their vales are the values to insert in table name
	 * 
	 * @param gridDataList
	 * @param tableName
	 * @param type
	 * @return
	 */
	private String createDynamicReprtQuery(List<Map<String, String>> gridDataList, String tableName, Object type) {
		try {
			/*
			 * to check grid size
			 */
			if (gridDataList.size() == 0) {
				return null;
			}
			/*
			 * To store columns name
			 */
			StringBuilder columnNameBuilder = new StringBuilder();
			/*
			 * To store values which has to insert in database
			 */
			StringBuilder tableValueBuilder = new StringBuilder();
			/*
			 * TO CREATE INSERT QUERY
			 */
			tableValueBuilder.append("insert into " + tableName + " (");

			for (String set : gridDataList.get(0).keySet()) {
				tableValueBuilder.append("`" + set + "`,");
				columnNameBuilder.append(" " + set + "=" + set + " , ");
			}

			columnNameBuilder.deleteCharAt(columnNameBuilder.lastIndexOf(","));

			tableValueBuilder.deleteCharAt(tableValueBuilder.lastIndexOf(","));
			tableValueBuilder.append(") values");

			for (Map<String, String> mapres : gridDataList) {

				tableValueBuilder.append("(");
				/*
				 * TO INSERT VALUES IN TABLE
				 */
				for (String set : mapres.keySet()) {
					if (String.valueOf(mapres.get(set)).equalsIgnoreCase("null")) {
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + mapres.get(set));
						
						mapres.put(set, "");

					}
					tableValueBuilder.append("'" + mapres.get(set) + "',");
				}
				tableValueBuilder.deleteCharAt(tableValueBuilder.lastIndexOf(","));
				tableValueBuilder.append("),");

			}
			tableValueBuilder.deleteCharAt(tableValueBuilder.lastIndexOf(","));
			/**
			 * WEATHER TO INSERT OR UPDATE
			 */
			if (type != null) {

				if (((String) type).equalsIgnoreCase("update")) {
					tableValueBuilder.append(" ON DUPLICATE KEY UPDATE ");
					tableValueBuilder.append(columnNameBuilder);
				}

			}

			tableValueBuilder.append(";");
			/*
			 * RETURN INSERT QUERY
			 */
			return tableValueBuilder.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * CONVERT EPOCH TIME IN DATE-TIME FORMAT
	 */
	@SuppressWarnings("unused")
	private String convertEpochDate(String dateString) {
		Date d = new Date(Long.parseLong(dateString));
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatted = format.format(d);
		System.out.println(formatted);
		return formatted;
	}

	/**
	 * To Update Grid Data of Relay final report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message finalReportInsertGridRelay(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */

				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "temporary_final_report_relay", null);
				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */

						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));
						passingParameterMap.put("is_updatable", map.get("is_updatable"));

						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("159", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Update Gride Data of Side Stand Final Report To insert the form data
	 * of updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message finalReportInsertGridSideStand(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {

				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */

				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "temporary_final_report_side_stand",
						null);

				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */

						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));
						passingParameterMap.put("is_updatable", map.get("is_updatable"));

						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("177", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Update Gride Data of Planner Final Report To insert the form data of
	 * updated value in Planner into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message finalReportInsertGridPlanner(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */

				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "temporary_planner", null);
				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */
						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));

						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("208", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {
							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Upload Calendar Holiday Inventory to upload excel file for annual
	 * holiday into database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public Message uploadHolidayInventory(String requestType, Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Upload the File Upload detail by calling its stored procedure
			 */
			Message uplodedFile = genericProcess.GenericProcedureCalling(requestType, map, null);

			/**
			 * Check if the upload file is valid or not
			 */
			if (!uplodedFile.isValid()) {

				responseMessage.setDescription("File Not Found");
				responseMessage.setValid(false);
				return responseMessage;
			}

			/**
			 * uploadlist is gridDataList of map of uplodedFile
			 */
			List<Map<String, Object>> uploadlist = (List<Map<String, Object>>) uplodedFile.getObject();

			/*
			 * Initializing Variables to use it in calling APIs
			 */
			String file_path = "";
			String file_id = "";
			String token = "";
			/**
			 * To get File_id from uplodedFile
			 */
			for (Map<String, Object> inuploadListMap : uploadlist) {
				file_id = inuploadListMap.get("file_id").toString().trim();
			}

			/**
			 * To get file_path from uplodedFile
			 */
			if (map.get("file_path") == null) {

				responseMessage.setDescription("File path is null");
				responseMessage.setValid(false);
				return responseMessage;
			}
			/*
			 * to get file path
			 */
			file_path = map.get("file_path").toString().trim();
			map.remove("file_path");

			/**
			 * To get token from uplodedFile
			 */
			if (map.get("token") == null) {

				responseMessage.setDescription("token is null");
				responseMessage.setValid(false);
				return responseMessage;
			}
			token = map.get("token").toString();
			map.remove("token");

			String uploadData = new Gson().toJson(uplodedFile.getObject());

			/**
			 * To check if uplodedFile is not null
			 */
			if (!(uplodedFile == null)) {

				List<List<Object>> gridDataList = new ArrayList<>();
				/**
				 * To Get the File Path of Excel to be Uploaded
				 */
				FileInputStream file = new FileInputStream(new File(file_path));
				/**
				 * To Declare XSSFWorkbook object as workbook in given Excel
				 */
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				/**
				 * To Get First Sheet of the workbook
				 */
				XSSFSheet sheet = workbook.getSheetAt(0);
				/**
				 * To get no of columns in the excel
				 */
				int cellCount = sheet.getRow(0).getLastCellNum();
				/**
				 * Iterator Till last row of the excel
				 */
				for (int i = 0; i <= sheet.getLastRowNum(); i++) {
					/**
					 * Declaring list of Object to store each row as map and add
					 * that map in list
					 */
					List<Object> plannerMapList = new ArrayList<>();
					/**
					 * To get particular row
					 */
					Row row = sheet.getRow(i);
					/**
					 * Iterator To get each column value in respective row
					 */
					for (int j = 0; j < cellCount; j++) {
						/**
						 * Variable to store cell value
						 */
						Object value = null;
						/**
						 * To get Each cell
						 */
						Cell cell = row.getCell(j);
						/**
						 * To check if cell value is null
						 */
						if (cell == null) {
							plannerMapList.add("");
							continue;
						}
						/**
						 * To assign cellValue according to cell Type
						 */
						switch (cell.getCellType()) {
						case 0:
							if (DateUtil.isCellDateFormatted(cell)) {
								cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								value = convertDate(cell.getDateCellValue().toString());
								System.out.println(value);
								break;
							} else {
								cell.setCellType(Cell.CELL_TYPE_NUMERIC);
								value = cell.getNumericCellValue();
								break;
							}
						case 1:
							/*
							 * TO GET DATE FORMAT FROM EXCEL
							 */
							Pattern dateFrmtPtrn = Pattern
									.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");
							Matcher mtch = dateFrmtPtrn.matcher(cell.getStringCellValue().replaceFirst(" ", "").trim());
							if (mtch.matches()) {
								cell.setCellType(Cell.CELL_TYPE_STRING);
								try {
									value = convertDate(cell.getStringCellValue().toString());
								} catch (Exception e) {
									value = convertDateOther(cell.getStringCellValue().toString());
								}
							} else {
								cell.setCellType(Cell.CELL_TYPE_STRING);
								value = cell.getStringCellValue().trim();
							}
							break;
						default:
							break;
						}
						/**
						 * To add Value in gridMapList
						 */
						plannerMapList.add(value);
					}
					/**
					 * To add gridMapList in gridDataList
					 */
					gridDataList.add(plannerMapList);
				}

				/**
				 * To close workbook and file
				 */
				workbook.close();

				file.close();

				if (!(gridDataList.get(0).size() == 3)) {
					responseMessage
							.setDescription("Found column issue with the uploaded file. Inventory was not uploaded");
					responseMessage.setObject(null);
					responseMessage.setValid(false);
					return responseMessage;
				}
				String dataInsertSqlQuery = createDynamicQuery(gridDataList, "temp_holiday_calendar", null);

				StringBuilder executeSqlQueryBuilder = new StringBuilder();
				/*
				 * check if dataInsertSqlQuery is not null
				 */
				if (dataInsertSqlQuery != null) {
					/*
					 * Execute sql query
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);
					executeSqlQueryBuilder.append(executeSqlQueryStatus);
					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {
						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure
						 */
						System.out.println("inserted successfully");

						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", token);
						/*
						 * Generic Procedure Calling to update file status
						 */

						Message uplodedSuccess = genericProcess.GenericProcedureCalling("253", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (uplodedSuccess.isValid()) {
							/*
							 * Return response
							 */

							responseMessage.setDescription("Calender Inventory Updated Successfully");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						} else {
							/*
							 * return error response
							 */
							responseMessage.setDescription(
									"File Updated Successfully in Temprory Table  But Data is Not Distributed in Database");
							responseMessage.setObject(null);
							responseMessage.setValid(false);
							return responseMessage;
						}

					}
				} else {
					/*
					 * Return Found column issue with the uploaded file.
					 * Inventory was not uploaded response
					 */
					System.out.println("Found column issue with the uploaded file. Inventory was not uploaded");
					responseMessage.setDescription("Extra Column Data In Excel File To Insert");
					responseMessage.setObject(null);
					responseMessage.setValid(false);
					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Failed Process");
		responseMessage.setObject(null);
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * TO CHANGE DATE FORMAT
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	private Object convertDateOther(String dateString) throws ParseException {
		SimpleDateFormat parseFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = parseFormat.parse(dateString);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(date1);
		return result.replaceFirst(" ", "");
	}

	/**
	 * TO CHANGE DATE FORMAT
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public String convertDate(String dateString) throws ParseException {
		SimpleDateFormat parseFormat1 = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");

		Date date = parseFormat1.parse(dateString);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(date);
		return result.replaceFirst(" ", "");

	}

	/**
	 * uPDATE urlS TO ENTER URLS IN DATABASE
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Message UpdateUrl(Map<String, String> map) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();
		try {
			/*
			 * checking if token is not null
			 */
			if (map.get("token") != null) {
				/*
				 * to call get APIs Mapping Api to get all urls
				 */
				Message gridToUpdate = mappingHandlerService.getAPIsMapping();
				List<Map<String, String>> gridDataList = new LinkedList<>();
				List<Map<String, Object>> responseList = (List<Map<String, Object>>) gridToUpdate.getObject();
				/*
				 * to get all urls
				 */
				for (Map<String, Object> map2 : responseList) {
					Map<String, String> tempMap = new HashMap<>();
					tempMap.put("url", map2.get("url").toString());
					gridDataList.add(tempMap);

				}
				/*
				 * to get insert query for inserting all urls in database
				 */
				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "url_mapping", null);

				/*
				 * Check if dataInsertSqlQuery is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure
						 */
						System.out.println("inserted successfully");

						/*
						 * Return response
						 */

						responseMessage.setDescription("Your Data is Succesfully Updated in Database");
						responseMessage.setObject(executeSqlQueryStatus);
						responseMessage.setValid(true);
						return responseMessage;

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * return exception response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;
		}

		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Update Grid Data of shower starter final report To insert the form
	 * data of updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message finalReportInsertGridDataShowerStarter(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */

				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList,
						"temporary_final_report_shower_starter_relay", null);
				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */

						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));
						passingParameterMap.put("is_updatable", map.get("is_updatable"));
						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("338", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;

	}

	/**
	 * To Update Grid Data of lock final report To insert the form data of
	 * updated value into the database
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("serial")
	public Message finalReportInsertGridDataLock(Map<String, String> map) {
		/*
		 * Initialize response message
		 */
		Message responseMessage = new Message();
		try {

			/**
			 * To Check if gridData is not null
			 */
			if (map.get("data") != null) {
				/*
				 * Casting data in List<Map<String, String>> format
				 */
				Type type = new TypeToken<List<Map<String, String>>>() {
				}.getType();
				/*
				 * To get grid data which need to be update
				 */
				String gridDataToUpdate = map.get("data").toString();

				/*
				 * To get data in formatted form
				 */
				List<Map<String, String>> gridDataList = new Gson().fromJson(gridDataToUpdate, type);
				/*
				 * to create Insert query to insert data in database
				 */

				String dataInsertSqlQuery = createDynamicReprtQuery(gridDataList, "temporary_final_report_lock ", null);
				/*
				 * to check if query is not null
				 */
				if (dataInsertSqlQuery != null) {
					/**
					 * Sucess Message with required format of data
					 */
					Object executeSqlQueryStatus = genericService.executeAnySqlQuery(dataInsertSqlQuery);

					/**
					 * Check If Query inserted Data or not
					 */
					if (executeSqlQueryStatus != null) {

						/**
						 * If Data Inserted Successfully than Calling Update
						 * Distribution Procedure adding Parameter to call it
						 */

						Map<String, String> passingParameterMap = new HashMap<>();

						passingParameterMap.put("token", map.get("token"));
						passingParameterMap.put("is_updatable", map.get("is_updatable"));
						/**
						 * GenericProcedureCalling method of genericProcess
						 * calling to get the stored Procedure result
						 */
						Message uplodedSuccess = genericProcess.GenericProcedureCalling("340", passingParameterMap,
								null);
						/**
						 * Checking uplodedSuccess is not null
						 */
						if (!(uplodedSuccess == null)) {

							/*
							 * Returning response
							 */

							responseMessage.setDescription("Your Data is Succesfully Updated in Database");
							responseMessage.setObject(uplodedSuccess.getObject());
							responseMessage.setValid(true);
							return responseMessage;
						}

					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * Returning Exception response response
			 */
			responseMessage.setDescription("Error In Handling" + e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * When something went wrong with method or parameter are nor correct
		 */
		responseMessage.setDescription("Error In Handling");
		responseMessage.setValid(false);
		return responseMessage;

	}
}
