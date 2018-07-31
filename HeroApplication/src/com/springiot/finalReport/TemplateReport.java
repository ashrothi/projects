/**
 * This package contain  class To set template for Pdf Generation
 */
package com.springiot.finalReport;

/**
 * To Import Classes to access their functionality
 */
import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * 
 * This class is for getting the data which will be set in Velocity template for
 * pdf generation and return the set template data in string for pdf generation
 * 
 * @author Ankita Shrothi
 *
 */
public class TemplateReport {
	/**
	 * This Method will set the data in velocity template
	 * 
	 * @param name
	 *            : Name of the vm template in which data will be set
	 * @param dataObject
	 *            Data which will be set in template
	 * @return Set data in template
	 */
	public static String TemplateReportFile(String name, Object dataObject) {
		try {
			/*
			 * Initializing VelocityEngine object and setting their property
			 */
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();
			/*
			 * Getting template from the given path
			 */
			Template temp = ve.getTemplate(name);

			/* create a context and add data */
			VelocityContext context = new VelocityContext();

			context.put("object", dataObject);

			/* now render the template into a StringWriter */
			StringWriter writer = new StringWriter();
			/*
			 * Merging data with template
			 */
			temp.merge(context, writer);
			/*
			 * Check if Writer is null
			 */
			if (writer.toString() != null) {
				return writer.toString();
			}

		} catch (Exception e) {
			/*
			 * Print Exception if it comes
			 */
			e.printStackTrace();
		}
		/*
		 * If Process fails it will return null
		 */
		return null;
	}

}
