/**
 * Here defined all required classes for excel creation.
 */
package com.springiot.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * This class is used for create the xlsx downloadExcelFile. For create xlsx
 * downloadExcelFile here used the apache lib.
 * 
 * @author TTPL
 *
 */
public class Excel {

	/**
	 * This constructor is used for create the xlsx downloadExcelFile. For
	 * create xlsx downloadExcelFile here used the apache lib.
	 */
	public Excel() {
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
			 * To get the Data and wite in the downloadExcelFile
			 */
			FileOutputStream out = new FileOutputStream(inputFile);
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

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
			List<Object> reportHeader) {

		try {
			// add the excelSetSheet name in xlsx downloadExcelFile
			XSSFSheet excelSetSheet = workbook.createSheet(sheetName);
			// add the headers in xlsx downloadExcelFile
			Row excelHeader = excelSetSheet.createRow(0);

			System.out.println(excelHeader.toString());

			for (int i = 0; i < reportHeader.size(); i++) {

				excelHeader.createCell(i).setCellValue((String) reportHeader.get(i));

			}

			// Insert the data in xlsx downloadExcelFile
			for (int i = 0; i < dataList.size(); i++) {

				Row dataRow = excelSetSheet.createRow(i + 1);
				/**
				 * to get each row data
				 */
				Map<String, Object> excleRowListMap = (Map<String, Object>) dataList.get(i);

				int j = 0;

				for (String key : excleRowListMap.keySet()) {

					String valueRes = String.valueOf(excleRowListMap.get(key));
					/**
					 * To handle the Null Value
					 */
					if (valueRes == null) {
						valueRes = "";
						continue;
					}

					/**
					 * To create cell and set the data accordingly
					 */
					try {

						int value = Integer.parseInt(valueRes);

						dataRow.createCell(j).setCellType(Cell.CELL_TYPE_NUMERIC);

						dataRow.createCell(j).setCellValue(value);

					} catch (Exception e) {

						try {

							double value = Double.parseDouble(valueRes);

							dataRow.createCell(j).setCellType(Cell.CELL_TYPE_NUMERIC);

							dataRow.createCell(j).setCellValue(value);

						} catch (Exception e2) {

							dataRow.createCell(j).setCellType(Cell.CELL_TYPE_STRING);

							dataRow.createCell(j).setCellValue(valueRes);
							if (valueRes == "") {
								dataRow.createCell(j).setCellType(Cell.CELL_TYPE_BLANK);

								dataRow.createCell(j).setCellValue(valueRes);

							}

						}

					}

					j++;
				}

			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
