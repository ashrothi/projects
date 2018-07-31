package newDemo;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class A {
	 /**
	   * The code inserts an image to a specific 
	   * cell of a excel sheet
	   */
	  @SuppressWarnings("resource")
	public static void main(String[] args)
	  {
	 
	   try
	   {
	    //Creating a excel workbook
	    HSSFWorkbook wb=new HSSFWorkbook();
	    System.out.println("The work book is created");
	    //Pointing the excel file to FileOutputStream where image needs to be inserted
	    FileOutputStream fos=new FileOutputStream("/home/tanvigarg/Desktop/Planner2016-10-21_180717.xlsx");
	    System.out.println("File sample.xls is created");
	    //Pointing the image file to FileInputStream which needs to be inserted in excel sheet
	    FileInputStream fis=new FileInputStream("/home/tanvigarg/Pictures/corrupted record(2016 08 28).png");
	    //Creating a ByteArrayOutputStream object
	    ByteArrayOutputStream img_bytes=new ByteArrayOutputStream();
	    int b;
	    //The loop reads each byte from input stream and puts it into the byte array    
	    while((b=fis.read())!=-1)
	    img_bytes.write(b);
	    //Closing the input stream as it is not required further
	    fis.close();
	    //Creating HSSFClientAnchor object
	    HSSFClientAnchor anchor = new HSSFClientAnchor();
	    int col1=1,row1=1;
	    //HSSFClientAnchor object mainly sets the excel cell location where 
	    //the image needs to be inserted
	    //(col1, row1, x1, y1, col2, row2, x2, y2)   
	    anchor.setAnchor((short)col1, row1, 0, 0,(short) ++col1, ++row1, 0, 0);
	    anchor.setAnchorType(2);
	    //Converts the byte array stream to JPEG image 
	    int index=wb.addPicture(img_bytes.toByteArray(),HSSFWorkbook.PICTURE_TYPE_PNG);
	    //Gets sheet from the workbook
	    HSSFSheet sheet=wb.getSheetAt(0);
	    //Creating HSSFPatriarch object
	    HSSFPatriarch patriarch=sheet.createDrawingPatriarch();
	    //Creating picture with anchor and index information
	    patriarch.createPicture(anchor,index);
	    //Write workbook with the data
	    wb.write(fos);
	    System.out.println("Writing data to the xls file");
	    //Close FileOutputStream as it will no longer be required
	    fos.close();
	    System.out.println("File closed");
	   }
	   catch(IOException ioe)
	   {
	   System.out.println("Hi ! You got an exception. "+ioe.getMessage());
	   }
	  }
	  public void abh()
	  {
		  System.out.println("hello");
	  }

}
