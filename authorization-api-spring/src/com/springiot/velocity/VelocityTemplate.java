/**
 * This package contain the class which set the velocity template engine and its properties value which can be pass as email body template.
 */
package com.springiot.velocity;

import java.io.StringWriter;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;

/**
 * This class set the velocity template engine and its properties value which
 * can be pass as email body template.
 * 
 * @author test_user
 *
 */
public class VelocityTemplate {

	public String readTemplate(String templateName, Object object) {
		try {

			// /* first, get and initialize an engine */
			// VelocityEngine ve = new VelocityEngine();
			// ve.init();
			// /* next, get the Template */
			// Template t = ve.getTemplate(templateName);
			// /* create a context and add data */
			// VelocityContext context = new VelocityContext();
			// context.put("object", model);
			// /* now render the template into a StringWriter */
			// StringWriter writer = new StringWriter();
			// t.merge(context, writer);
			// /* show the World */
			// return writer.toString();

			/* first, get and initialize an engine */
			VelocityEngine ve = new VelocityEngine();

			ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
					"org.apache.velocity.runtime.log.Log4JLogChute");

			ve.setProperty("runtime.log.logsystem.log4j.logger",
					"com.mindtree.igg.website.email.TemplateMergeUtilVelocityImpl");

			ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");

			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");

			// ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "/WebContent");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();

			/* Add that list to a VelocityContext */
			VelocityContext context = new VelocityContext();
			context.put("object", object);
			/* Get the Template */
			Template t = ve.getTemplate(templateName);

			/* Now render the template into a Writer */
			StringWriter writer = new StringWriter();
			t.merge(context, writer);
			/* Use the output in your email body */
			/*
			 * Return the template body.
			 */
			return writer.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
