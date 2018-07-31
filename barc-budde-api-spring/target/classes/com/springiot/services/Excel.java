/**
 * Here defined all required classes for excel creation.
 */
package com.springiot.services;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * This class is used for create the xlsx file. For create xlsx file here used
 * the apache lib.
 * 
 * @author TTPL
 *
 */
public class Excel {

	/**
	 * This constructor is used for create the xlsx file. For create xlsx file
	 * here used the apache lib.
	 */
	public Excel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * From this method return XSSFWorkbook object, this class is used for
	 * create the xlsx file. This object is used in DROOL file(drl file).
	 * 
	 * @return , return the XSSFWorkbook object.
	 */
	public XSSFWorkbook getXSSFWorkbook() {
		
		
		// This object required for create xlsx file.
		XSSFWorkbook workbook = new XSSFWorkbook();
		return workbook;
	}

	/**
	 * This method is used for create the xlsx file with different sheets and
	 * data.In this method pass the required values like XSSFWorkbook object,
	 * xlsx file name(report name), file location(where the file will be
	 * create,in config file defined child file location), connection
	 * string(This is parent database connection string), processed report
	 * procedure(This is procedure function, this is used for add the processed
	 * report details).
	 * 
	 * In this method first set the data in object and object data write in
	 * created xlsx file. After created the xlsx file call the processed report
	 * procedure for update the processed report table. After created xlsx file
	 * return the boolean value true.
	 * 
	 * @param workbook
	 *            , This is the xlsx file object. This object values pass from
	 *            drl file.
	 * @param reportName
	 *            , This is the xlsx file name, this name is defined in config
	 *            file.
	 * @param fileLocation
	 *            , where the file will be create. In config file defined child
	 *            file location.
	 * @param connection
	 *            ,This is parent database connection string.
	 * @param processedReportPro
	 *            , This is procedure function which is defined in config file.
	 *            This is used for add the processed report details.
	 * @return
	 */
	public String createExcel(XSSFWorkbook workbook, String reportName, String fileLocation) {

		try {
			// Initialize file object, and pass the xlsx file location.
			File file = new File(fileLocation);

			if (!file.exists()) {
				file.mkdirs();
			}

			// initialize the file object for create xlsx file in given location
			File inputFile = new File(file.getAbsolutePath() + "/" + reportName + ".xlsx");

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

	public boolean setSheetData(XSSFWorkbook workbook, String sheetName, List<Map<String, Object>> dataList,
			List<Object> reportHeader) {

		try {
			// add the sheet name in xlsx file
			XSSFSheet sheet = workbook.createSheet(sheetName);
			// add the headers in xlsx file
			Row header = sheet.createRow(0);
			
			
			for (int i = 0; i < reportHeader.size(); i++) {
				header.createCell(i).setCellValue((String) reportHeader.get(i));
			}

			// Insert the data in xlsx file
			for (int i = 0; i < dataList.size(); i++) {

				Row dataRow = sheet.createRow(i + 1);

				Map<String, Object> maplist = (Map<String, Object>) dataList.get(i);

				int j = 0;

				for (String key : maplist.keySet()) {

					String valueRes = String.valueOf(maplist.get(key));
					
					
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
