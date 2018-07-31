package newDemo;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxOperation {

	public static void main(String[] args) {

		try {

			List<List<Object>> excelDataList = new ArrayList<>();

			FileInputStream file = new FileInputStream(
					new File("/home/dushyant/Downloads/Sample_Format_2016-09-13_153956.xlsx"));

			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			
			int cellCount=sheet.getRow(0).getLastCellNum();

			for (int i = 0; i <= sheet.getLastRowNum(); i++) {

				List<Object> plannerMapList = new ArrayList<>();

				Row row = sheet.getRow(i);
				

				for (int j = 0; j < cellCount; j++) {

					Object value=null;
					
					Cell cell = row.getCell(j);
					
					if(cell==null)
					{
						//System.out.print(null+" ");
						plannerMapList.add("");
						continue;
					}
					
					
					switch (cell.getCellType()) {
					case 0:
						
						cell.setCellType(Cell.CELL_TYPE_NUMERIC);

						value = cell.getNumericCellValue();
						
						break;
						
					case 1:
						cell.setCellType(Cell.CELL_TYPE_STRING);

						value = cell.getStringCellValue();
						break;

					default:
						break;
					}

					plannerMapList.add(value);
					
				}

				excelDataList.add(plannerMapList);

			}

			System.out.println(excelDataList);
			
			
			for (int i = 0; i < excelDataList.size(); i++) {
				
				System.out.println(excelDataList.get(i).size());
				
			}
			file.close();

			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
