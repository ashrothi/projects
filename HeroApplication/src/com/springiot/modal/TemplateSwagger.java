package com.springiot.modal;

import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class TemplateSwagger {

	public static String TemplateReportFile(String name, Object dataObject) {
		try {

			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			
			ve.init();
			Template temp = ve.getTemplate(name);
		

			/* create a context and add data */
			VelocityContext context = new VelocityContext();
			
			context.put("object", dataObject);
			
			
			/* now render the template into a StringWriter */
			StringWriter writer = new StringWriter();
		
			temp.merge(context, writer);
					
			if (writer.toString() != null) {
				return writer.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}