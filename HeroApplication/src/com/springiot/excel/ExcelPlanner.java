package com.springiot.excel;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;

import com.springiot.constant.CustomerService;

public class ExcelPlanner {
	public ExcelPlanner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * From this method return XSSFWorkbook object, this class is used for
	 * create the xlsx templateExcelFile. This object is used in DROOL
	 * templateExcelFile(drl templateExcelFile).
	 * 
	 * @return , return the XSSFWorkbook object.
	 * @throws IOException
	 */
	public XSSFWorkbook getXSSFWorkbook(CustomerService customerService) throws IOException {

		// ClassLoader classLoader = getClass().getClassLoader();
		// FileInputStream templateExcelFile = new FileInputStream(
		// new
		// File(classLoader.getResource("Templates/TemplateDailyReportHorn.xlsx").getFile()));

		/* This object required for create xlsx templateExcelFile. */
		Resource resource = customerService.getResource("classpath:com/springiot/excel/Planner Sample Template.xlsx");

		InputStream is = resource.getInputStream();

		XSSFWorkbook workbook = new XSSFWorkbook(is);
		return workbook;

	}

	/**
	 * This method is used for create the xlsx templateExcelFile with different
	 * sheets and data.In this method pass the required values like XSSFWorkbook
	 * object, xlsx templateExcelFile name(report name), templateExcelFile
	 * location(where the templateExcelFile will be create,in config
	 * templateExcelFile defined child templateExcelFile location), connection
	 * string(This is parent database connection string), processed report
	 * procedure(This is procedure function, this is used for add the processed
	 * report details).
	 * 
	 * In this method first set the data in object and object data write in
	 * created xlsx templateExcelFile. After created the xlsx templateExcelFile
	 * call the processed report procedure for update the processed report
	 * table. After created xlsx templateExcelFile return the boolean value
	 * true.
	 * 
	 * @param workbook
	 *            , This is the xlsx templateExcelFile object. This object
	 *            values pass from drl templateExcelFile.
	 * @param reportName
	 *            , This is the xlsx templateExcelFile name, this name is
	 *            defined in config templateExcelFile.
	 * @param fileLocation
	 *            , where the templateExcelFile will be create. In config
	 *            templateExcelFile defined child templateExcelFile location.
	 * @param connection
	 *            ,This is parent database connection string.
	 * @param processedReportPro
	 *            , This is procedure function which is defined in config
	 *            templateExcelFile. This is used for add the processed report
	 *            details.
	 * @return
	 */
	public String createExcel(XSSFWorkbook workbook, String reportName, String fileLocation) {

		try {
			// Initialize templateExcelFile object, and pass the xlsx
			// templateExcelFile location.
			File downloadExcelFile = new File(fileLocation);
			/**
			 * To check the if fileLocation exist or not
			 */
			if (!downloadExcelFile.exists()) {
				downloadExcelFile.mkdirs();
			}

			// initialize the templateExcelFile object for create xlsx
			// templateExcelFile in given location
			// File inputFile = new File("/home/ankita/Desktop/DailyHornReport"
			// + new Date() + ".xlsx");
			File inputFile = new File(downloadExcelFile.getAbsolutePath() + "/" + reportName + ".xlsx");

			/**
			 * To get the Data and write in the downloadExcelFile
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
	 * @param plannerDataList
	 * @param plannerSignatureExcelData
	 * @param dataList
	 *            ,The list of map containing data which is to be set
	 * @param reportHeader
	 *            ,Report Header to set the Header in Excel
	 * @return boolean , return boolean value weather data is set in excel or
	 *         not
	 * 
	 */
	public boolean setSheetData(XSSFWorkbook workbook, String sheetName,
			List<Map<String, Object>> plannerEquipmentDataList, List<Map<String, Object>> plannerDataList,
			List<Map<String, Object>> plannerSignatureExcelData, Map<String, Object> headerPlanner) {

		try {
			// add the excelSetSheet name in xlsx templateExcelFile
			XSSFSheet excelSetSheet = workbook.getSheetAt(0);

			CellStyle cellStyle = workbook.createCellStyle();
			CreationHelper createHelper = workbook.getCreationHelper();
			short dateFormat = createHelper.createDataFormat().getFormat("yyyy-MM-dd");
			cellStyle.setDataFormat(dateFormat);
			/*
			 * To set Header of template
			 */
			for (int rowIndex = 0; rowIndex < 4; rowIndex++) {

				Row row = excelSetSheet.getRow(rowIndex);
				row.getRowStyle();
				switch (rowIndex) {
				case 0:
					row.getCell(2).setCellValue(String.valueOf(headerPlanner.get("planner_name")));
					break;
				case 3:
					row.getCell(4).setCellValue(String.valueOf(headerPlanner.get("planner_number")));
					System.out.println("planner_version " + String.valueOf(headerPlanner.get("planner_version")));
					row.getCell(8).setCellValue(String.valueOf(headerPlanner.get("planner_version")));
					break;
				default:
					break;
				}

			}
			int count = 7;

			// excelSetSheet.shiftRows(7, plannerDataList.size(),
			// plannerDataList.size()+1, true, true);
			for (int rowIndex = 0; rowIndex < plannerDataList.size(); rowIndex++) {
				excelSetSheet.shiftRows(rowIndex + 7, excelSetSheet.getLastRowNum(), 1);
			}
			/*
			 * To set Planner grid Data
			 */
			for (int rowIndex = 0; rowIndex < plannerDataList.size(); rowIndex++) {
				count++;

				Row dataRow = excelSetSheet.createRow(rowIndex + 7);
				dataRow.setRowStyle(excelSetSheet.getColumnStyle(rowIndex + 6));
				dataRow.getRowStyle();

				Map<String, Object> maplist = (Map<String, Object>) plannerDataList.get(rowIndex);

				// System.out.println(maplist);
				int cellIndex = 0;

				for (String key : maplist.keySet()) {

					String valueRes = String.valueOf(maplist.get(key));

					try {

						int value = Integer.parseInt(valueRes);

						dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

						dataRow.createCell(cellIndex).setCellValue(value);

						System.out.println();
					} catch (Exception e) {

						try {

							double value = Double.parseDouble(valueRes);

							dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

							dataRow.createCell(cellIndex).setCellValue(value);

						} catch (Exception e2) {
							dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_STRING);

							dataRow.createCell(cellIndex).setCellValue(valueRes);
						}

					}

					cellIndex++;
				}

			}
			/**
			 * To set Planner Equipment data
			 */
			for (int rowIndex = 0; rowIndex < plannerEquipmentDataList.size(); rowIndex++) {
				excelSetSheet.shiftRows(rowIndex + count + 8, excelSetSheet.getLastRowNum(), 1);
				Row dataRow = excelSetSheet.createRow(rowIndex + count + 8);
				dataRow.setRowStyle(excelSetSheet.getColumnStyle(rowIndex + count + 7));
				dataRow.getRowStyle();
				/**
				 * to get each row data
				 */
				Map<String, Object> excleRowListMap = (Map<String, Object>) plannerEquipmentDataList.get(rowIndex);

				// System.out.println(excleRowListMap);
				int cellIndex = 0;

				for (String key : excleRowListMap.keySet()) {

					String valueRes = String.valueOf(excleRowListMap.get(key));
					/**
					 * To handle the Null Value
					 */
					// if (valueRes == null) {
					// valueRes = "";
					// continue;
					// }

					/**
					 * To create cell and set the data accordingly
					 */

					try {

						int value = Integer.parseInt(valueRes);

						dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

						dataRow.createCell(cellIndex).setCellValue(value);

						System.out.println();
					} catch (Exception e) {

						try {

							double value = Double.parseDouble(valueRes);

							dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_NUMERIC);

							dataRow.createCell(cellIndex).setCellValue(value);

						} catch (Exception e2) {

							try {

								dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_STRING);

								dataRow.createCell(cellIndex).setCellValue(valueRes);

							} catch (Exception e3) {

								dataRow.createCell(cellIndex).setCellType(Cell.CELL_TYPE_BLANK);

								dataRow.createCell(cellIndex).setCellValue(valueRes);
							}

						}

					}

					cellIndex++;

				}

			}

			System.out.println("count" + count);
			count = count + plannerEquipmentDataList.size() + 12;
			System.out.println("count" + count);
			/**
			 * To set planner Signatures
			 */
			if (plannerSignatureExcelData.size() > 0) {

				List<Map<String, Object>> preparedBy = new ArrayList<>();
				List<Map<String, Object>> aprovedBy = new ArrayList<>();
				for (Map<String, Object> map : plannerSignatureExcelData) {
					if (map.get("category").toString().equalsIgnoreCase("prepared")) {
						preparedBy.add(map);
					} else {
						aprovedBy.add(map);
					}

				}
				System.out.println("prepared" + preparedBy.toString() + "\n aproved" + aprovedBy.toString());

				Row dataRow = excelSetSheet.getRow(count + 1);
				dataRow.setHeight((short) 1000);
				dataRow.getRowStyle();

				dataRow.getCell(0);

				for (int rowIndex = 0; rowIndex < preparedBy.size(); rowIndex++) {

					URL url = new URL(preparedBy.get(rowIndex).get("image_path").toString());
					InputStream fis = new BufferedInputStream(url.openStream());

					// //Creating a ByteArrayOutputStream object
					ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
					int byteIndex;
					// The loop reads each byte from input stream and puts it
					// into
					// the byte array
					while ((byteIndex = fis.read()) != -1) {
						img_bytes.write(byteIndex);
					}
					// Closing the input stream as it is not required further
					fis.close();
					XSSFClientAnchor anchor = new XSSFClientAnchor();
					anchor.setCol1(rowIndex);
					anchor.setRow1(dataRow.getRowNum());
					anchor.setCol2(rowIndex + 1);
					anchor.setRow2(dataRow.getRowNum() + 1);
					anchor.setDx1(20);
					anchor.setDx2(20);
					anchor.setDy1(10);
					anchor.setDy2(10);
					anchor.getDx1();
					anchor.getDx2();
					anchor.getDy1();
					anchor.getDy2();
					// Converts the byte array stream to JPEG image
					int index = workbook.addPicture(img_bytes.toByteArray(), XSSFWorkbook.PICTURE_TYPE_PNG);
					// Gets sheet from the workbook

					// Creating HSSFPatriarch object
					XSSFDrawing patriarch = excelSetSheet.createDrawingPatriarch();
					// Creating picture with anchor and index information
					patriarch.createPicture(anchor, index);
				}
				dataRow.getCell(6);
				for (int rowIndex = 0; rowIndex < aprovedBy.size(); rowIndex++) {
					URL url = new URL(aprovedBy.get(rowIndex).get("image_path").toString());
					InputStream fis = new BufferedInputStream(url.openStream());
					// Creating a ByteArrayOutputStream object
					ByteArrayOutputStream img_bytes = new ByteArrayOutputStream();
					int byteIndex;
					// The loop reads each byte from input stream and puts it
					// into
					// the byte array
					while ((byteIndex = fis.read()) != -1)
						img_bytes.write(byteIndex);
					// Closing the input stream as it is not required further
					fis.close();
					XSSFClientAnchor anchor = new XSSFClientAnchor();
					anchor.setCol1(rowIndex + 6);
					anchor.setRow1(dataRow.getRowNum());
					anchor.setCol2(rowIndex + 7);
					anchor.setRow2(dataRow.getRowNum() + 1);
					anchor.setDx1(20);
					anchor.setDx2(20);
					anchor.setDy1(10);
					anchor.setDy2(10);
					anchor.getDx1();
					anchor.getDx2();
					anchor.getDy1();
					anchor.getDy2();
					// Converts the byte array stream to JPEG image
					int index = workbook.addPicture(img_bytes.toByteArray(), XSSFWorkbook.PICTURE_TYPE_PNG);
					// Gets sheet from the workbook

					// Creating HSSFPatriarch object
					XSSFDrawing patriarch = excelSetSheet.createDrawingPatriarch();
					// Creating picture with anchor and index information
					patriarch.createPicture(anchor, index);
				}
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * To get date which will be append with the file name
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
	 * To convert the date in formatted way
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public String convertDate(Object date) throws ParseException {

		DateFormat currentFormat = new SimpleDateFormat("yyyy-MM-dd");

		// java.sql.Timestamp ts = (java.sql.Timestamp) date;
		String formatteddate = currentFormat.format(date);
		// String out = ts.toString();

		if (formatteddate != null) {

			return formatteddate;
		} else {
			return "";
		}
	}
}
