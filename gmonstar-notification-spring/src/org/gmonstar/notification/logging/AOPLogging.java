/**
 * This package contain  class as Aspect is used to call to Insert the Logs for API's been accessed
 */
package org.gmonstar.notification.logging;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.gmonstar.notification.constant.ProcessParameter;
import org.gmonstar.notification.genericService.GenericService;
import org.gmonstar.notification.response.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 
 * This class use as Aspect is used to call to Insert the Logs for API's has
 * been accessed
 * 
 * @author Ankita Shrothi
 *
 */
@Aspect
@PropertySource(value = "classpath:/ApiConfiguration.properties")
public class AOPLogging {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	Environment environment;
	@Autowired
	private GenericService genericService;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private ProcessParameter processParameter;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired(required = true)
	private HttpServletRequest request;

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corrosponding
	 * procedure.This method uses the concept of AOP,Aspect Obbject
	 * Programming.This method is used for the package
	 * com.springiot.controllers.ignoreControllers because all the classes in
	 * this package are not considered as controllers.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */

	@SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "execution(* org.gmonstar.notification.controllers.*.*(..))", returning = "result")
	public void logAfterThrowingError(JoinPoint joinPoint, Object result) {

		try {

			// Initializing the variables
			String classType = null;
			StringBuilder InputArgumentsName = new StringBuilder();
			StringBuilder InputArgumentsValue = new StringBuilder();

			StringBuilder input = new StringBuilder();

			// Initializing the message class and get the results obtained after
			// method execution.
			Message message = (Message) result;

			// If message is not valid

			// Initializing the map
			Map<String, Object> errorLogMap = processParameter.getMaps();
			// System.out.println("Error Log Map is :- " + errorLogMap);

			// For loop is used to get the arguments for the methods which
			// will give exception
			for (Object arguments : joinPoint.getArgs()) {

				// Get the class type
				classType = arguments.getClass().getName();

				// If class type is java.util.LinkedHashMap,then append it
				// in argsParamMap
				if (classType.equals("java.util.LinkedHashMap")) {
					continue;
				}

				// Append in stringBuilder input
				input.append(arguments + ",");
			}

			// Check the last index of String Builder
			if (input.lastIndexOf(",") > 0) {
				input.deleteCharAt(input.lastIndexOf(","));
				System.out.println("input Parameter List:- " + input + " / class type:- " + classType);
			}

			// System.out.println("input Parameter List:- " + argsParamMap + " /
			// class type:- " + classType);
			String name = joinPoint.getThis().getClass().getName();
			/**
			 * to get controller name
			 */
			String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));
			// Get the method names
			String method_name = joinPoint.getSignature().getName();

			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));

			// System.out.println(request.getLocalAddr());

			String[] args = input.toString().split(",");
			// Check the method name equals oauthToken
			if (method_name.equals("mailNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|smtp_host|#@|smtp_port|#@|smtp_username|#@|smtp_password|#@|subject|#@|body|#@|from|#@|to|#@|cc|#@|bcc|#@|socket_port|#@|socket_class|#@|smtp_auth|#@|email_title|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|" + args[0] + "|#@|"
							+ request.getRemoteHost() + "|#@|" + "mail" + "|#@|" + args[1] + "|#@|" + args[2] + "|#@|"
							+ args[3] + "|#@|" + args[4] + "|#@|" + args[5] + "|#@|" + args[6] + "|#@|" + args[7]
							+ "|#@|" + args[8] + "|#@|" + args[9] + "|#@|" + args[10] + "|#@|" + args[11] + "|#@|"
							+ args[12] + "|#@|" + args[13] + "|#@|" + args[14] + "|#@|" + controllerName + "|#@|"
							+ "mailNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {

					e.printStackTrace();
				}

			} else if (method_name.equals("smsNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_msg|#@| notificationtype|#@|mobile_nos|#@|smse_username|#@|smse_password|#@|smse_ip|#@|smse_port|#@|from|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(
							request.getHeader("token") + "|#@|" + args[0] + "|#@|" + request.getRemoteHost() + "|#@|"
									+ args[1] + "|#@|" + "SMS" + "|#@|" + args[2] + "|#@|" + args[3] + "|#@|" + args[4]
									+ "|#@|" + args[5] + "|#@|" + args[6] + "|#@|" + args[7] + "|#@|" + controllerName
									+ "|#@|" + "smsNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {

					e.printStackTrace();
				}

			} else if (method_name.equals("webHookNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated
					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type|#@|method_type|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|" + args[0] + "|#@|"
							+ request.getRemoteHost() + "|#@|" + "WEBHOOK" + "|#@|" + args[1] + "|#@|" + args[2]
							+ "|#@|" + args[3] + "|#@|" + args[4] + "|#@|" + args[5] + "|#@|" + args[6] + "|#@|"
							+ args[7] + "|#@|" + args[8] + "|#@|" + args[9] + "|#@|" + controllerName + "|#@|"
							+ "webHookNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} else if (method_name.equals("mailAutomateNotification")) {
				try {
					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|smtp_host|#@|smtp_port|#@|smtp_username|#@|smtp_password|#@|subject|#@|body|#@|from|#@|to|#@|cc|#@|bcc|#@|socket_port|#@|socket_class|#@|smtp_auth|#@|email_title|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|"
							+ environment.getProperty(request.getRemoteHost()) + "|#@|" + request.getRemoteHost()
							+ "|#@|" + "mail" + "|#@|" + environment.getProperty("mail.smtp.detail") + "|#@|"
							+ environment.getProperty("mail.smtp.port") + "|#@|"
							+ environment.getProperty("mail.smtp.username") + "|#@|"
							+ environment.getProperty("mail.smtp.password") + "|#@|" + args[0] + "|#@|" + args[1]
							+ "|#@|" + args[2] + "|#@|" + args[3] + "|#@|" + args[4] + "|#@|" + args[5] + "|#@|"
							+ environment.getProperty("mail.socket.port") + "|#@|"
							+ environment.getProperty("mail.socket.class") + "|#@|"
							+ environment.getProperty("mail.smtp.auth") + "|#@|"
							+ environment.getProperty("mail.smtp.email.title") + "|#@|" + controllerName + "|#@|"
							+ "mailNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}

				// Handling all exceptions
				catch (Exception e) {
					// System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} else if (method_name.equals("smsAutomateNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_msg|#@| notificationtype|#@|mobile_nos|#@|smse_username|#@|smse_password|#@|smse_ip|#@|smse_port|#@|from|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|"
							+ environment.getProperty(request.getRemoteHost()) + "|#@|" + request.getRemoteHost()
							+ "|#@|" + args[0] + "|#@|" + "SMS" + "|#@|" + args[1] + "|#@|"
							+ environment.getProperty("sms.smse.username") + "|#@|"
							+ environment.getProperty("sms.smse.password") + "|#@|"
							+ environment.getProperty("sms.smse.ip") + "|#@|" + environment.getProperty("sms.smse.port")
							+ "|#@|" + environment.getProperty("sms.from") + "|#@|" + controllerName + "|#@|"
							+ "smsNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} else if (method_name.equals("webHookApiNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type|#@|method_type|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|"
							+ environment.getProperty(request.getRemoteHost()) + "|#@|" + request.getRemoteHost()
							+ "|#@|" + "WEBHOOK" + "|#@|" + args[0] + "|#@|" + args[1] + "|#@|" + args[2] + "|#@|"
							+ "REST" + "|#@|" + args[3] + "|#@|" + environment.getProperty("webhook.db.url") + "|#@|"
							+ environment.getProperty("webhook.db.diver") + "|#@|"
							+ environment.getProperty("webhook.table_name") + "|#@|"
							+ environment.getProperty("webhook.table_parameter") + "|#@|" + controllerName + "|#@|"
							+ "webHookNotification" + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {
					// System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} else if (method_name.equals("webHookSoapApiNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|api_url|#@|body_parameter|#@|header_parameter|#@|api_type||#@|service_url||#@|soap_action|#@|soap_parameter_name|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|method_type|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getHeader("token") + "|#@|"
							+ environment.getProperty(request.getRemoteHost()) + "|#@|" + request.getRemoteHost()
							+ "|#@|" + "WEBHOOK" + "|#@|" + args[0] + "|#@|" + args[1] + "|#@|" + args[2] + "|#@|"
							+ "SOAP" + "|#@|" + args[3] + "|#@|" + args[4] + "|#@|" + args[5] + "|#@|"
							+ environment.getProperty("webhook.db.url") + "|#@|"
							+ environment.getProperty("webhook.db.diver") + "|#@|"
							+ environment.getProperty("webhook.table_name") + "|#@|"
							+ environment.getProperty("webhook.table_parameter") + "|#@|" + args[6] + "|#@|"
							+ controllerName + "|#@|" + method_name + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {
					// System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} else if (method_name.equals("customNotification")) {
				try {

					// Append to the String Builder of parameter and their
					// values comma seprated

					InputArgumentsName.append(
							"token|#@|end_node_name|#@|end_node_ip|#@|notification_type|#@|data|#@|eventType|#@|db_url|#@|db_driver|#@|table_name|#@|table_parameter|#@|method_type|#@|controller_name|#@|method_name|#@|host_ip|#@|api_url");
					InputArgumentsValue.append(request.getParameter("token") + "|#@|"
							+ environment.getProperty(request.getRemoteHost()) + "|#@|" + request.getRemoteHost()
							+ "|#@|" + "WEBHOOK" + "|#@|" + args[0] + "|#@|" + args[1] + "|#@|"
							+ environment.getProperty("webhook.db.url") + "|#@|"
							+ environment.getProperty("webhook.db.diver") + "|#@|"
							+ environment.getProperty("webhook.table_name") + "|#@|"
							+ environment.getProperty("webhook.table_parameter") + "|#@|" + "POST" + "|#@|"
							+ controllerName + "|#@|" + method_name + "|#@|" + request.getRemoteHost() + "|#@|" + URI);

				}
				// Handling all exceptions
				catch (Exception e) {
					// System.out.println(e.getMessage());
					e.printStackTrace();
				}

			}

			// Calling of this procedure to insert errors/exceptions in
			// table

			if (environment.getProperty("audit.log.error").equalsIgnoreCase("true")) {
				if (!message.isValid()) {
					Map<String, Object> map = (Map<String, Object>) message.getObject();
					genericService.executeProcesure(null, errorLogMap.get("3").toString(), map.get("notification_id"),
							request.getRemoteHost(), request.getHeader("token"), "0", message.getDescription(),
							InputArgumentsName.toString(), InputArgumentsValue.toString());

				}
			}

			if (environment.getProperty("audit.log.response").equalsIgnoreCase("true")) {
				if (!message.isValid()) {
					Map<String, Object> map = (Map<String, Object>) message.getObject();
					InputArgumentsName.append(",response");
					InputArgumentsValue.append(message.getObject().toString());
					genericService.executeProcesure(null, errorLogMap.get("3").toString(), map.get("notification_id"),
							request.getRemoteHost(), args[0], "1", message.getDescription(),
							InputArgumentsName.toString(), InputArgumentsValue.toString());
				}
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
