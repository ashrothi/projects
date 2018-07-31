/**
 * This package is particularly used to dowload excel file for the Device Model Details Page
 *  which includes data displayed in four sheets by calling different API's and 
 *  manipulating results for API's
 */
package com.springiot.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * This class is used for create the xlsx downloadExcelFile for Device Model
 * Details page. For create xlsx downloadExcelFile here used the apache lib.
 * 
 * @author tanvi
 *
 */
public class DeviceModelDetailsExcel {

	/**
	 * This constructor is used for create the xlsx downloadExcelFile. For
	 * create xlsx downloadExcelFile here used the apache lib.
	 * 
	 * @return
	 */
	public void Excel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * From this method return XSSFWorkbook object, this class is used for
	 * create the xlsx downloadExcelFile. This object is used in DROOL
	 * downloadExcelFile(drl downloadExcelFile).
	 * 
	 * @return , return the XSSFWorkbook object.
	 */
	public XSSFWorkbook getXSSFWorkbook() {
		// This object required for create xlsx downloadExcelFile.
		XSSFWorkbook workbook = new XSSFWorkbook();
		return workbook;
	}

	/**
	 * This method is used for create the xlsx downloadExcelFile with different
	 * sheets and data.In this method pass the required values like XSSFWorkbook
	 * object, xlsx downloadExcelFile name(report name), downloadExcelFile
	 * location(where the downloadExcelFile will be create,in config
	 * downloadExcelFile defined child downloadExcelFile location), connection
	 * string(This is parent database connection string), processed report
	 * procedure(This is procedure function, this is used for add the processed
	 * report details).
	 * 
	 * In this method first set the data in object and object data write in
	 * created xlsx downloadExcelFile. After created the xlsx downloadExcelFile
	 * call the processed report procedure for update the processed report
	 * table. After created xlsx downloadExcelFile return the boolean value
	 * true.
	 * 
	 * @param workbook
	 *            , This is the xlsx downloadExcelFile object. This object
	 *            values pass from drl downloadExcelFile.
	 * @param reportName
	 *            , This is the xlsx downloadExcelFile name, this name is
	 *            defined in config downloadExcelFile.
	 * @param fileLocation
	 *            , where the downloadExcelFile will be create. In config
	 *            downloadExcelFile defined child downloadExcelFile location.
	 * @param connection
	 *            ,This is parent database connection string.
	 * @param processedReportPro
	 *            , This is procedure function which is defined in config
	 *            downloadExcelFile. This is used for add the processed report
	 *            details.
	 * @return
	 */
	public String createExcel(XSSFWorkbook workbook, String reportName, String fileLocation) {

		try {
			// Initialize downloadExcelFile object, and pass the xlsx
			// downloadExcelFile location.
			File downloadExcelFile = new File(fileLocation);
			/**
			 * To check the if fileLocation exist or not
			 */
			if (!downloadExcelFile.exists()) {
				downloadExcelFile.mkdirs();
			}

			// initialize the downloadExcelFile object for create xlsx
			// downloadExcelFile in given location
			File inputFile = new File(downloadExcelFile.getAbsolutePath() + "/" + reportName + ".xlsx");
			/**
			 * To get the Data and write in the downloadExcelFile
			 */
			FileOutputStream out = new FileOutputStream(inputFile);
			workbook.write(out);
			out.close();

			return inputFile.getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * To Set the data in Excel
	 * 
	 * @param workbook
	 *            ,to get the workbook to set data in it
	 * @param sheetName
	 *            ,The excelSetSheet name in which data will be set in ecxel
	 * @param headerData
	 *            ,The map containing data which needs to be displayed in rows
	 *            and columns.
	 * @param tableResponse
	 *            ,Report Header to set the Header in Excel
	 * @return boolean , return boolean value weather data is set in excel or
	 *         not
	 * 
	 */
	public boolean setSheetData(XSSFWorkbook workbook, String sheetName, Map<String, Object> headerData,
			List<Map<String, Object>> tableResponse) {

		try {
			// Initializing list which will be used to count the number of
			// sheets
			List<XSSFSheet> sheets = new ArrayList<>();
			/*
			 * For loop is used to add data to the above mentioned list and
			 * Simultaneously,create sheets
			 */

//			System.out.println("tableResponse" + tableResponse.size());

			String sheetNames = (String) headerData.keySet().toString();

			String sheetname[] = sheetNames.replace("[", "").replace("]", " ").replace("organization/get/", "")
					.replace("/", "").split(",");

			for (int i = 0; i < tableResponse.size(); i++) {
				sheets.add(i, workbook.createSheet(sheetname[i]));

			}

			// sheets.add(i, workbook.createSheet(sheetName + i));

			// For loop is used to set the headers as well as the data
			int i = 0;
			for (Map<String, Object> setHeaders : tableResponse) {

				// Get the headers from tableResponse(retrieved after SQL Query
				// execution)
				String header = setHeaders.get("column_alias").toString();

				// Array is created while splitting the headers with comma.
				String headerArray[] = header.split(",");

				// Get the Column Names (retrieved after SQL Query Execution)
				String data = setHeaders.get("column_names").toString();
				// Array is created while splitting the data with comma.
				List<String> dataArray = Arrays.asList(data.split(","));

				Sheet sheet = sheets.get(i);

				// Create first row for Headers in Excel File.
				Row excelHeader = sheet.createRow(0);

				// Set the headers in excel Sheets in the for loop so that
				// headers are displayed in every sheet
				for (int j = 0; j < headerArray.length; j++) {
					excelHeader.createCell(j).setCellValue(headerArray[j]);
				}

				// Get the data which needs to be displayed in excel sheet
				// converted into list<map>
				@SuppressWarnings("unchecked")
				List<Map<String, Object>> listData = (List<Map<String, Object>>) headerData
						.get(setHeaders.get("report_api_url"));

				// For loop is used to set the data
				for (int j = 0; j < listData.size(); j++) {

					// Initializing map which will overtime get the first list
					Map<String, Object> excelData = (Map<String, Object>) listData.get(j);

					// Create rows for the data
					Row dataRow = sheet.createRow(j + 1);

					// k is for columns loop
					int k = 0;
					// Adjust Limited Data in excel file,rest of the data is
					// discarded.
					for (String key : dataArray) {

						// If the valued retrieved from API is null,then Make
						// the cell Blank
						if (excelData.get(key.trim()) == null) {

							dataRow.createCell(k).setCellType(Cell.CELL_TYPE_BLANK);

							dataRow.createCell(k).setCellValue("");

						} else {
							// Else Fill the value in the respective Cell
							dataRow.createCell(k).setCellType(Cell.CELL_TYPE_STRING);

							dataRow.createCell(k).setCellValue(excelData.get(key.trim()).toString());
						}
						
						// Auto Size For the columns
						// sheet.autoSizeColumn(k);
						k++;
					}
				}
				i++;
			}
		}
		// Handling exceptions
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}
}
