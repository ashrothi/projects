/** This package contain the notification controller class of GlobeTouch Application.
  */
package org.gmonstar.notification.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gmonstar.notification.entity.model.UnsolicitedData;
import org.gmonstar.notification.response.model.Message;
import org.gmonstar.notification.services.NotificationService;
import org.gmonstar.notification.swagger.response.NotificationResponseSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class is used as a controller which is used for retrieving all
 * information from End Node specific user and send Notification to Kafka for
 * registering GM user and send success message as response to end nodes.
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class NotificationController {
	/**
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private NotificationService notificationservice;

	/**
	 * API to send email parameters to kafka queue in json format so that
	 * streaming layer will fetch the mail notification data from kafka and send
	 * mail accordingly
	 * 
	 * @param end_node_name
	 *            : End Server Name for eg:- BSS,Esim,
	 * @param smtp_host
	 *            : host of mail server
	 * @param smtp_port
	 *            : port of mail server
	 * @param smtp_username
	 *            username to access mail server
	 * @param smtp_password
	 *            -password of user
	 * @param subject
	 *            -subject of mail
	 * @param body
	 *            -content of mail body
	 * @param from
	 *            -mail from user
	 * @param to
	 *            -mail to users
	 * @param cc
	 *            -cc users of mail
	 * @param bcc
	 *            -bcc users of mail
	 * @param socket_port
	 *            -socket port of mail server
	 * @param socket_class
	 *            -socket class of mail server
	 * @param smtp_auth
	 *            -smtp_auth permision of mail server to send mail
	 * @param email_title
	 *            -title of email_id you want to send mail from
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/generic/mail/notification", notes = "This API sends notification as Email on the given Mail Address. Here user need to pass all the parameters. The response includes the Notification id of the sent Email.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "end_node_name", value = "Here pass end_node name that is the server name which is calling the notification API.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smtp_host", value = "Here pass smtp host of the Email server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smtp_port", value = "Here pass smtp port of the Email server.", required = true, access = "query", paramType = "query", dataType = "int"),
			@ApiImplicitParam(name = "smtp_username", value = "Here pass smtp username for authenticating to Email Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smtp_password", value = "Here pass smtp password for authenticating to Email Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subject", value = "Here pass subject for Email body.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "body", value = "Here pass message for content of Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from", value = "Here pass Email id from which user wants to send Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to", value = "Here pass Email id to whom user wants to send Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cc", value = "Here pass Email id to whom user wants to send Carbon Copy of Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "bcc", value = "Here pass Email id to whom user wants to send Blind Carbon Copy of Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email_title", value = "Here pass email title for the senders email address to show in Email.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/generic/mail/notification", method = RequestMethod.POST)
	public @ResponseBody Message mailNotification(@RequestParam String end_node_name, @RequestParam String smtp_host,
			@RequestParam String smtp_port, @RequestParam String smtp_username, @RequestParam String smtp_password,
			@RequestParam String subject, @RequestParam String body, @RequestParam String from, @RequestParam String to,
			@RequestParam String cc, @RequestParam String bcc, @RequestParam String email_title,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.emailNotification(end_node_name, smtp_host, smtp_port, smtp_username,
				smtp_password, subject, body, from, to, cc, bcc, email_title, request, response);
		return message;
	}

	/**
	 * API to call sms notification with all its server and end user details to
	 * send sms notification
	 * 
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * @param notification_msg
	 *            -Content of the sms to be send to client
	 * @param mobile_nos
	 *            -Mobile nos to whom all messages has to be send
	 * @param smse_username
	 *            SMS server username
	 * @param smse_password
	 *            - SMS server password
	 * @param smse_ip
	 *            -SMS serers ip address
	 * @param smse_port
	 *            -SMS server port no
	 * @param from
	 *            -SMS comming From
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/generic/sms/notification", notes = "This API sends notification as SMS to the user on a given mobile number. Here user need to pass all the parameters. The response includes the Notification id of the sent SMS.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "notification_msg", value = "Here pass message for content of SMS.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mobile_nos", value = "Here pass mobile numbers on which user wants to send SMS.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "applicaton_key", value = "Here pass application key of the specific user.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_node_name", value = "Here pass end_node name that is the server name which is calling the notification API.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smse_username", value = "Here pass smse username for authentication on SMS Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smse_password", value = "Here pass smse password for authentication on SMS Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smse_ip", value = "Here pass smse ip for authentication on SMS Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "smse_port", value = "Here pass smse port for authentication on SMS Server.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from", value = "Here pass mobile number from which user wants to send SMS.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/generic/sms/notification", method = RequestMethod.POST)
	public @ResponseBody Message smsNotification(@RequestParam String end_node_name,
			@RequestParam String notification_msg, @RequestParam String mobile_nos, @RequestParam String smse_username,
			@RequestParam String smse_password, @RequestParam String smse_ip, @RequestParam String smse_port,
			@RequestParam String from, HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.smsNotification(end_node_name, notification_msg, mobile_nos,
				smse_username, smse_password, smse_ip, smse_port, from, request, response);
		return message;
	}

	/**
	 * API for webhook Notification to call api or to send notification in
	 * database with all its detail of end user API as Well as Database
	 * credentials
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param db_url
	 *            -Requires database url with port ,username and password
	 * @param db_driver
	 *            -Required driver of database to establish connesction with it
	 * @param table_name
	 *            -Table name where data has to be insert
	 * @param table_parameter
	 *            -Column names of table of the give database
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/generic/webhooks/notification", notes = "This API calls the external server API on the basis of API type i.e. REST or SOAP and Method Type i.e. Post, Get, Put and Option using webhooks. User need to pass all the parameters. The response includes the Notification id of the API call.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "end_node_name", value = "Here pass end_node name that is the server name which is calling the notification API.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "api_url", value = "Here pass the url of the API to be called.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "body_parameter", value = "Here pass the parameters to be passed for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "header_parameter", value = "Here pass the parameters to be passed as headers for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "api_type", value = "Here pass the type of api to be called i.e. SOAP, REST etc.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "method_type", value = "Here pass the method of api to be called i.e. POST, GET, OPTIONS, DELETE etc.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "db_url", value = "Here pass the connection string for database. i.e. '<DataBase_Connection_Type>://<Host_Name>:<Port>/<DataBase_Name>?user=<DataBase_User>&password=<DataBase_Password>'", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "db_type", value = "Here pass the type or driver for database. i.e. for mysql driver is org.mysql.Driver'", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "table_name", value = "Here pass the name of database table to insert data.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "table_parameter", value = "Here pass table parameter for inserting data.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/generic/webhooks/notification", method = RequestMethod.POST)
	public @ResponseBody Message webHookNotification(@RequestParam String end_node_name, @RequestParam String api_url,
			@RequestParam String body_parameter, @RequestParam String header_parameter, @RequestParam String api_type,
			@RequestParam String method_type, @RequestParam String db_url, @RequestParam String db_type,
			@RequestParam String table_name, @RequestParam String table_parameter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.webHookNotification(end_node_name, api_url, body_parameter,
				header_parameter, api_type, method_type, db_url, db_type, table_name, table_parameter, request,
				response);
		return message;
	}

	/**
	 * API to send email parameters to kafka queue in json format so that
	 * streaming layer will fetch the mail notification data from kafka and send
	 * mail accordingly
	 * 
	 * @param end_node_name
	 *            -End Server Name for eg:- BSS,Esim,XFusion
	 * 
	 * @param subject
	 *            -subject of mail
	 * @param body
	 *            -content of mail body
	 * 
	 * @param to
	 *            -mail to users
	 * @param cc
	 *            -cc users of mail
	 * @param bcc
	 *            -bcc users of mail
	 * 
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/custom/mail/notification", notes = "This API sends notification as Email on the given Mail Address. User need to pass the address details for sending Email. The response includes the Notification id of the sent Email.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "subject", value = "Here pass subject for Email body.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "body", value = "Here pass message for content of Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to", value = "Here pass Email id to whom user wants to send Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cc", value = "Here pass Email id to whom user wants to send Carbon Copy of Email.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "bcc", value = "Here pass Email id to whom user wants to send Blind Carbon Copy of Email.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/custom/mail/notification", method = RequestMethod.POST)
	public @ResponseBody Message mailAutomateNotification(@RequestParam String subject, @RequestParam String body,
			@RequestParam String to, @RequestParam String cc, @RequestParam String bcc, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.emailAutomateNotification(subject, body, to, cc, bcc, request, response);
		return message;
	}

	/**
	 * API to call sms notification with all end user details to send sms
	 * notification
	 * 
	 * 
	 * @param notification_msg
	 *            -Content of the sms to be send to client
	 * @param mobile_nos
	 *            -Mobile nos to whom all messages has to be send
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiIgnore
	@ApiOperation(value = "/custom/sms/notification", notes = "This API sends notification as SMS to the user on a given mobile number. User need to pass the reception mobile number for sending SMS. The response includes the Notification id of the sent SMS.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "notification_msg", value = "Here pass message for content of SMS.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mobile_nos", value = "Here pass mobile numbers on which user wants to send SMS.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/custom/sms/notification", method = RequestMethod.POST)
	public @ResponseBody Message smsAutomateNotification(@RequestParam String notification_msg,
			@RequestParam String mobile_nos, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.smsAutomateNotification(notification_msg, mobile_nos, request, response);
		return message;
	}

	/**
	 * API for webhook Notification to call REST api with all its detail of end
	 * user API credentials
	 * 
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/rest/webhooks/notification", notes = "This API calls the external server API on the basis of API type i.e. REST and Method Type i.e. Post, Get, Put and Option using webhooks. User need to pass details for calling API. The response includes the Notification id of the API call.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "api_url", value = "Here pass the url of the API to be called.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "body_parameter", value = "Here pass the parameters to be passed in JSON formatfor the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "header_parameter", value = "Here pass the parameters to be passed in JSON format as headers for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "method_type", value = "Here pass the request method of api to be called i.e. POST, GET, OPTIONS, DELETE etc.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/rest/webhooks/notification", method = RequestMethod.POST)
	public @ResponseBody Message webHookApiNotification(@RequestParam String api_url,
			@RequestParam String body_parameter, @RequestParam String header_parameter,
			@RequestParam String method_type, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.webHookApiNotification(api_url, body_parameter, header_parameter,
				method_type, request, response);
		return message;
	}

	/**
	 * API for webhook Notification to call SOAP api with all its detail of end
	 * user API credentials
	 * 
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/soap/webhooks/notification", notes = "This API calls the external server API on the basis of API type i.e.  SOAP and Method Type i.e. Post, Get, Put and Option using webhooks. User need to pass details for calling API. The response includes the Notification id of the API call.", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "api_url", value = "Here pass the url of the API to be called.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "body_parameter", value = "Here pass the parameters to be passed in JSON formatfor the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "header_parameter", value = "Here pass the parameters to be passed in JSON format as headers for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "service_url", value = "Here pass the  service url for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "soap_action", value = "Here pass the  soap action for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "soap_parameter_name", value = "Here pass the  soap parameter name (i.e Namespace Declaration with service url )for the API call.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "method_type", value = "Here pass the request method of api to be called i.e. POST, GET, OPTIONS, DELETE etc.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/soap/webhooks/notification", method = RequestMethod.POST)
	public @ResponseBody Message webHookSoapApiNotification(@RequestParam String api_url,
			@RequestParam String body_parameter, @RequestParam String header_parameter,
			@RequestParam String service_url, @RequestParam String soap_action,
			@RequestParam String soap_parameter_name, @RequestParam String method_type, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.webHookSoapApiNotification(api_url, body_parameter, header_parameter,
				service_url, soap_action, soap_parameter_name, method_type, request, response);
		return message;
	}

	/**
	 * API for webhook Notification to call REST api with all its detail of end
	 * user API credentials
	 * 
	 * @param api_url
	 *            -API url which has to be called
	 * @param body_parameter
	 *            -Body Parameter of API
	 * @param header_parameter
	 *            -Header Parameter (payload) of API
	 * @param api_type
	 *            -Requires api type (SOAP/REST)
	 * @param method_type
	 *            -Requires api type (POST, GET, OPTIONS, DELETE)
	 * @param request
	 *            -HttpServletRequest request to get requested machines
	 *            parameter like host ,url ,headers
	 * @param response
	 * @return Message { "description": "string",
	 * 
	 *         "object": [ { "notification_id": "string" } ],
	 * 
	 *         "valid": true }
	 * @throws Exception
	 */
	@ApiOperation(value = "/notification/{eventType}", notes = "This API calls the external server API on the basis of API type i.e.Notification to GM that the Order has been started, become active or Order Expired,Notification to GM to Notify data usage on an order", response = NotificationResponseSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass authentication token generated to access API in headers.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/notification/{eventType}", method = RequestMethod.POST)
	public @ResponseBody Message customNotification(
			@ApiParam(name = "unsolicitedData", value = "Request the data for Unsolicitate data ") @RequestBody UnsolicitedData unsolicitedData,
			@PathVariable String eventType, HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * API GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = notificationservice.customNotification(new Gson().toJson(unsolicitedData).toString(),
				eventType, request, response);
		return message;
	}

}