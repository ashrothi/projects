/**
 * Here defined all required classes for excel creation.
 */
package com.springiot.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class PerformanceExcel {

	/**
	 * @author Garima Joshi This class is used for create the xlsx
	 *         downloadExcelFile. For create xlsx downloadExcelFile here used
	 *         the apache lib.
	 *
	 */

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
	 * @param dataList
	 *            ,The list of map containing data which is to be set
	 * @param reportHeader
	 *            ,Report Header to set the Header in Excel
	 * @return boolean , return boolean value weather data is set in excel or
	 *         not
	 * 
	 */
	public boolean setSheetData(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> dataList,
			List<Object> reportHeader, List<String> dbHeader) {

		try {
			// add the excelSetSheet name in xlsx downloadExcelFile
			XSSFSheet excelSetSheet = workbook.createSheet(sheetName);
			// Create first row for Headers in Excel File.
			Row excelHeader = excelSetSheet.createRow(0);

			// Set the headers in excel file in above created row.
			for (int i = 0; i < reportHeader.size(); i++) {
				excelHeader.createCell(i).setCellValue((String) reportHeader.get(i));
			}

			int rowIndex = 1;
			int dataIndex = 2;

			// Insert the data in xlsx downloadExcelFile
			for (int i = 0; i < dataList.size(); i++) {

				// dataRowRowIndex is for sub headers for Additional Parameters
				// and dataRowDataIndex is for the data of sub headers.
				Row dataRowRowIndex = excelSetSheet.createRow(rowIndex);
				Row dataRowDataIndex = excelSetSheet.createRow(dataIndex);

				Map<String, Object> excleRowListMap = (Map<String, Object>) dataList.get(i);

				for (int j = 0; j < dbHeader.size(); j++) {

					String headerKey = dbHeader.get(j).trim();
					// Adjustment of data for sub headers for additional
					// Parameters
					if (headerKey.equals("?")) {

						List<String> DataSourceAlias = Arrays
								.asList(excleRowListMap.get("additional_datasource_alias").toString().split(","));

						List<String> currentValueList = Arrays
								.asList(excleRowListMap.get("additional_current_value").toString().split(","));

						if (DataSourceAlias != null && currentValueList != null) {

							try {
								// For Loop is used for the Data Source alias
								// Parameter and the Data source unit Parameter
								// and the combined data will be displayed in
								// new row of excel sheet.[These are the sub
								// headers]
								for (int k = 0; k < DataSourceAlias.size(); k++) {

									String valueRes = String.valueOf(DataSourceAlias.get(k));

									dataRowRowIndex.createCell(j + k).setCellType(Cell.CELL_TYPE_STRING);

									dataRowRowIndex.createCell(j + k).setCellValue(valueRes);

								}
								// For Loop is used for the current value
								// Parameter and the combined data will be
								// displayed in
								// new row of excel sheet[This is the data of
								// sub headers]
								for (int a = 0; a < currentValueList.size(); a++) {

									String valueRes = String.valueOf(currentValueList.get(a));

									dataRowDataIndex.createCell(j + a).setCellType(Cell.CELL_TYPE_STRING);
									dataRowDataIndex.createCell(j + a).setCellValue(valueRes);
								}
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
					}
					// Mapping of Actual Data of Headers.
					String valueRes = String.valueOf(excleRowListMap.get(headerKey));
					if (valueRes != null && j != dbHeader.size() - 1) {

						if (valueRes == "null" || valueRes == "NULL" || valueRes == null) {
							valueRes = "";

						}
						// System.out.println("Values in excel file" +
						// valueRes);
						dataRowRowIndex.createCell(j).setCellType(Cell.CELL_TYPE_STRING);

						dataRowRowIndex.createCell(j).setCellValue(valueRes);

						excelSetSheet.addMergedRegion(
								new org.apache.poi.ss.util.CellRangeAddress(rowIndex, dataIndex, j, j));
					} else if (j == dbHeader.size() - 1)
						;
					else {

						dataRowRowIndex.createCell(j).setCellType(Cell.CELL_TYPE_BLANK);

						dataRowRowIndex.createCell(j).setCellValue("");
						excelSetSheet.addMergedRegion(
								new org.apache.poi.ss.util.CellRangeAddress(rowIndex, dataIndex, j, j));

					}
					// excelSetSheet.autoSizeColumn(j);
				}

				rowIndex = dataIndex;
				rowIndex++;
				dataIndex = rowIndex;
				dataIndex++;

			}
		} catch (Exception e)

		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
