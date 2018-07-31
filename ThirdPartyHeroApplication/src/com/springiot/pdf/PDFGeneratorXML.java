/**
 * This package contain  class for Pdf Generation
 */
package com.springiot.pdf;

/**
 * To Import Classes to access their functionality
 */
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * 
 * This class is for getting the data of set template and generate Pdf File with
 * it
 * 
 * @author Ankita Shrothi
 *
 */
public class PDFGeneratorXML {
	/**
	 * To Generate Pdf File
	 * 
	 * @param data
	 *            :- data which will set in Pdf Document
	 * @param path:-
	 *            Where file will be write
	 * @return path of the file where file was written
	 */
	public static String generatePDF(String data, String path) {

		try {
			/**
			 * Initializing document with page size setting
			 */
			Document document = new Document(PageSize.A4_LANDSCAPE.rotate());
			/*
			 * PdfWriter instance to get document in the given path
			 */
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			/*
			 * Open Document
			 */
			document.open();

			InputStream in = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));

			// XMLWorkerHelper.getInstance().parseXHtml(writer, document,
			// new FileInputStream(data));
			/*
			 * Writing data in pdf
			 */
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, in);
			/*
			 * Document Close
			 */
			document.close();
			/*
			 * return path of file where file was written
			 */
			return path;

		} catch (Exception e) {
			/**
			 * Handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * If Process Fails return
		 */
		return null;

	}

}
