/**
 * This package contain  class  for Pdf Generation
 */
package com.springiot.pdf;

/**
 * To Import Classes to access their functionality
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.html.simpleparser.StyleSheet;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * This class is for getting the data which will be set in Velocity template for
 * pdf generation and return the set template data in string for pdf generation
 * 
 * @author Ankita Shrothi
 *
 */
@SuppressWarnings("deprecation")

public class PDFGenerator {
	/**
	 * TO set Font style in Pdf
	 */
	final static String FONT = "./template/BOOKOS.TTF";

	/**
	 * To Generate Pdf File
	 * 
	 * @param data
	 *            :- data which will set in Pdf Document
	 * @param path:-
	 *            Where file will be write
	 * @return path of the file where file was written
	 */
	@SuppressWarnings("unused")
	public static String generatePDF(String data, String path) throws DocumentException, IOException {

		try {
			/*
			 * To create file in given path
			 */
			OutputStream file = new FileOutputStream(new File(path));
			/**
			 * Initializing document with page size setting
			 */
			Document document = new Document(PageSize.A3);
			/*
			 * PdfWriter instance to get document in the given path
			 */
			PdfWriter pdfWriter = PdfWriter.getInstance(document, file);
			/*
			 * Open Document
			 */
			document.open();
			HTMLWorker htmlWorker = new HTMLWorker(document);
			/**
			 * Setting New FOnt
			 */
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED);
			Font f = new Font(bf, 12);
			FontFactory.register(FONT, "Bookman Old Style"); // just give a path
			/**
			 * Setting CSS Style so that pdf will take all styling
			 */
			StyleSheet css = new StyleSheet();
			css.loadTagStyle("body", "face", "Bookman Old Style");
			css.loadTagStyle("body", "encoding", "UTF-8");
			css.loadTagStyle("body", "size", "9pt");
			htmlWorker.setStyleSheet(css);
			/*
			 * To write data in document
			 */
			htmlWorker.parse(new StringReader(data));
			/*
			 * Document and File Close
			 */
			document.close();
			file.close();
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

	/**
	 * To Generate Pdf File
	 * 
	 * @param data
	 *            :- data which will set in Pdf Document
	 * @param path:-
	 *            Where file will be write
	 * @return path of the file where file was written
	 */
	@SuppressWarnings("unused")
	public static String generateRelayPDF(String data, String path) throws DocumentException, IOException {

		try {
			/*
			 * To create file in given path
			 */
			OutputStream file = new FileOutputStream(new File(path));
			/**
			 * Initializing document with page size setting
			 */
			Document document = new Document(PageSize.A3.rotate());
			/*
			 * PdfWriter instance to get document in the given path
			 */
			PdfWriter.getInstance(document, file);
			/*
			 * Open Document
			 */
			document.open();

			HTMLWorker htmlWorker = new HTMLWorker(document);
			/**
			 * Setting New FOnt
			 */
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED);
			Font f = new Font(bf, 9);
			FontFactory.register(FONT, "Bookman Old Style"); // just give a path
			/**
			 * Setting CSS Style so that pdf will take all styling
			 */
			StyleSheet css = new StyleSheet();
			css.loadTagStyle("body", "face", "Bookman Old Style");
			css.loadTagStyle("body", "encoding", "UTF-8");
			css.loadTagStyle("body", "size", "9pt");
			htmlWorker.setStyleSheet(css);
			/*
			 * To write data in document
			 */
			htmlWorker.parse(new StringReader(data));
			/*
			 * Document and File Close
			 */
			document.close();
			file.close();
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

	/**
	 * To Generate Pdf File
	 * 
	 * @param data
	 *            :- data which will set in Pdf Document
	 * @param path:-
	 *            Where file will be write
	 * @return path of the file where file was written
	 */

	@SuppressWarnings("unused")
	public static String generateDustPDF(String data, String path) throws DocumentException, IOException {

		try {
			/*
			 * To create file in given path
			 */
			OutputStream file = new FileOutputStream(new File(path));
			/**
			 * Initializing document with page size setting
			 */
			Document document = new Document(PageSize.A3);
			/*
			 * PdfWriter instance to get document in the given path
			 */
			PdfWriter.getInstance(document, file);
			/*
			 * Open Document
			 */
			document.open();

			HTMLWorker htmlWorker = new HTMLWorker(document);
			/**
			 * Setting New FOnt
			 */
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			Font f = new Font(bf);
			FontFactory.register(FONT, "Bookman Old Style"); // just give a path
			/**
			 * Setting CSS Style so that pdf will take all styling
			 */
			StyleSheet css = new StyleSheet();
			css.loadTagStyle("body", "face", "Bookman Old Style");
			// css.loadTagStyle("body", "encoding", "UTF-8");
			// css.loadTagStyle("body", "size", "9pt");
			htmlWorker.setStyleSheet(css);
			/*
			 * To write data in document
			 */
			htmlWorker.parse(new StringReader(data));
			/*
			 * Document and File Close
			 */
			document.close();
			file.close();
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

	/**
	 * To Generate Horn Pdf File
	 * 
	 * @param data
	 *            :- data which will set in Pdf Document
	 * @param path:-
	 *            Where file will be write
	 * @return path of the file where file was written
	 */
	@SuppressWarnings("unused")
	public static String generateHornPDF(String data, String path) throws DocumentException, IOException {

		try {
			/*
			 * To create file in given path
			 */
			OutputStream file = new FileOutputStream(new File(path));
			/**
			 * Initializing document with page size setting
			 */
			Document document = new Document(PageSize.A2.rotate());
			/*
			 * PdfWriter instance to get document in the given path
			 */
			PdfWriter.getInstance(document, file);
			/*
			 * Open Document
			 */
			document.open();

			HTMLWorker htmlWorker = new HTMLWorker(document);
			/**
			 * Setting New FOnt
			 */
			BaseFont bf = BaseFont.createFont(FONT, BaseFont.WINANSI, BaseFont.EMBEDDED);
			Font f = new Font(bf);
			FontFactory.register(FONT, "Bookman Old Style"); // just give a path
			/**
			 * Setting CSS Style so that pdf will take all styling
			 */
			StyleSheet css = new StyleSheet();
			css.loadTagStyle("body", "face", "Bookman Old Style");
			css.loadTagStyle("body", "encoding", "UTF-8");
			css.loadTagStyle("body", "size", "9pt");
			htmlWorker.setStyleSheet(css);
			/*
			 * To write data in document
			 */
			htmlWorker.parse(new StringReader(data));
			/*
			 * Document and File Close
			 */
			document.close();
			file.close();
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
