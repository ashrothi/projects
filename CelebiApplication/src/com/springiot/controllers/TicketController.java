/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/**
 * To Import Classes to access their functionality
 */
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springiot.notification.NotificationByFcm;
import com.springiot.response.Message;
import com.springiot.services.FileUploadService;
import com.springiot.services.GenericProcess;
import com.springiot.services.ThirdPartyServices;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used retrieve all ticket details and
 * their tasks details as well as to create and update it
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class TicketController {
	@Autowired
	private NotificationByFcm notificationByFCM;
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private ThirdPartyServices thirdPartyServices;

	@Autowired
	private FileUploadService fileUploadService;

	/**
	 * To Insert the Open Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "/flint/open/ticket/insert", notes = "To Insert the Open Ticket", response = FlintOpenTicketInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_status", value = "Requires the task_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_country", value = "Requires pickup_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_state", value = "Requires pickup_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_city ", value = "Requires  pickup_city ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_address", value = "Requires pickup_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_landmark", value = "Requires pickup_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_contact_no", value = "Requires  pickup_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_key", value = "Requires consignee_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_country", value = "Requires dropoff_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_state", value = "Requires dropoff_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_city", value = "Requires dropoff_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_address", value = "Requires dropoff_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_landmark", value = "Requires dropoff_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_contact_no", value = "Requires dropoff_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_value", value = "Requires product_value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_weight", value = "Requires volume_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_percentage", value = "Requires volume_percentage", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla", value = "Requires sla_minutes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_date", value = "Requires pickup_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_lat", value = "Requires pickup_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_long", value = "Requires pickup_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_date", value = "Requires dropoff_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_lat", value = "Requires dropoff_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_long", value = "Requires dropoff_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_name", value = "Requires consignee name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_name", value = "Requires consigner name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "reciever_name", value = "Requires receiver name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "distance_from_source", value = "Requires distance from source", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_email_id", value = "Requires pickup_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_email_id", value = "Requires dropoff_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_name", value = "Requires consigner_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_name", value = "Requires consignee_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_path", value = "Requires consigner_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_path", value = "Requires consignee_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_id", value = "Requires consigner_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "booking_id", value = "Requires booking_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "booking_service_id", value = "Requires booking_service_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "route_price_id", value = "Requires route_price_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/ticket/insert", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
		if (message.isValid() && map.get("task_status").equalsIgnoreCase("1")) {
			List<Map<String, String>> result = (List<Map<String, String>>) message.getObject();
			result.get(0).put("new", "1");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.get(0).get("creation_time").toString()));
			calendar.add(Calendar.MINUTE, 330);
			result.get(0).put("creation_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
			Boolean status = notificationByFCM.sendMail(result.get(0), request, response);
			if (status == true) {
				return message;
			} else {
				message.setDescription("Ticket inserted Issue in mail send");
				message.setValid(false);
				return message;
			}

		} else {
			message.setDescription("Issue in Creating Order");
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Update The Open Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ApiOperation(value = "/flint/open/ticket/update", notes = "To Update The Open Ticket", response = FlintOpenTicketUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_status", value = "Requires the task_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_country", value = "Requires pickup_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_state", value = "Requires pickup_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_city ", value = "Requires  pickup_city ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_address", value = "Requires pickup_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_landmark", value = "Requires pickup_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_contact_no", value = "Requires  pickup_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_key", value = "Requires consignee_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_country", value = "Requires dropoff_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_state", value = "Requires dropoff_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_city", value = "Requires dropoff_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_address", value = "Requires dropoff_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_landmark", value = "Requires dropoff_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_contact_no", value = "Requires dropoff_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_value", value = "Requires product_value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_weight", value = "Requires volume_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_percentage", value = "Requires volume_percentage", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla_minutes", value = "Requires sla_minutes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_date", value = "Requires pickup_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_lat", value = "Requires pickup_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_long", value = "Requires pickup_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_date", value = "Requires dropoff_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_lat", value = "Requires dropoff_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_long", value = "Requires dropoff_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id", value = "Requires ticket_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id", value = "Requires task_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_task_closed", value = "Requires is_task_closed", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_name", value = "Requires consignee name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_name", value = "Requires consigner name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "reciever_name", value = "Requires receiver name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "remarks", value = "Requires remarks", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "files", value = "Requires Files to be Uploaded", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_email_id", value = "Requires pickup_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_email_id", value = "Requires dropoff_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_name", value = "Requires consigner_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_name", value = "Requires consignee_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_path", value = "Requires consigner_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_path", value = "Requires consignee_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_id", value = "Requires consigner_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_id", value = "Requires consignee_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "activity_document_name", value = "Requires activity_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "activity_document_path", value = "Requires activity_document_path", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/ticket/update", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response, @RequestParam("files") MultipartFile[] files)
			throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message messageFileUpload = fileUploadService.uploadMultipleFile(files, "");

		if (messageFileUpload.isValid()) {
			map.put("files", messageFileUpload.getObject().toString());
			Message message = genericProcess.GenericProcedureCalling("10", map, null, request, response);

			if (message.isValid() && map.get("task_status").equalsIgnoreCase("2")) {

				List<Map<String, String>> result = (List<Map<String, String>>) message.getObject();
				result.get(0).put("assigned_email_status", "1");
				System.out.println(" **************************************************** creation_time"
						+ result.get(0).get("creation_time"));

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.get(0).get("creation_time")));
				calendar.add(Calendar.MINUTE, 330);
				result.get(0).put("creation_time",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

				Boolean statusEmail = notificationByFCM.sendMail(result.get(0), request, response);

				Boolean status = thirdPartyServices.pushFCMNotificationOpenTicket(message.getObject());
				if (status == true) {
					if (statusEmail == true) {
						return message;
					} else {
						message.setDescription("Ticket Updated Issue in mail send");
						message.setValid(false);
						return message;
					}
				}

			}
			if (message.isValid() && map.get("task_status").equalsIgnoreCase("9")) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				List<Map<String, String>> result = (List<Map<String, String>>) message.getObject();
				result.get(0).put("delivered_email", "1");
				result.get(0).put("delivered_time", dateFormat.format(date));

				System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(result.get(0).get("delivered_time").toString()));
				calendar.add(Calendar.MINUTE, 330);
				result.get(0).put("delivered_time",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

				Calendar calendar1 = Calendar.getInstance();
				calendar1
						.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(result.get(0).get("creation_time")));
				calendar1.add(Calendar.MINUTE, 330);
				result.get(0).put("creation_time",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar1.getTime()));

				Boolean statusEmail = notificationByFCM.sendMail(result.get(0), request, response);

				if (statusEmail == true) {
					return message;
				} else {
					message.setDescription("Ticket Deliver Issue in mail send");
					message.setValid(false);
					return message;
				}

			}

			return message;

		}
		return messageFileUpload;

	}

	/**
	 * To get all Close Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/close/tickets/get/all", notes = "To get all Close Ticket", response = FlintCloseTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role name  ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to_date ", value = "Requires to_date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/close/tickets/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintCloseTicketGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = thirdPartyServices.flintCloseTicketsGetAll("54", map, null, request, response);
		return message;
	}

	/**
	 * To get all Open Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/tickets/get/all", notes = "To get all Open Ticket ", response = FlintOpenTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/tickets/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = thirdPartyServices.flintOpenTicketsGetAll("12", map, null, request, response);
		return message;
	}

	/**
	 * To get information of open ticket tasks
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/task/get/info", notes = "To get information of open ticket tasks", response = FlintOpenTaskGetInfoSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/task/get/info", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTaskGetInfo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("24", map, null, request, response);
		return message;
	}

	/**
	 * To get information of Open tickets
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/ticket/get/info", notes = "To get information of Open tickets", response = FlintOpenTicketGetInfoSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/ticket/get/info", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketGetInfo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("23", map, null, request, response);
		return message;
	}

	/**
	 * To get information of closed tickets task
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/closed/task/get/info", notes = "To get information of closed  tickets task", response = FlintClosedTaskGetInfoSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/closed/task/get/info", method = RequestMethod.POST)
	public @ResponseBody Message flintCloseTaskGetInfo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("28", map, null, request, response);
		return message;
	}

	/**
	 * To get all closed Ticket Info
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/closed/ticket/get/info", notes = "To get all closed Ticket Info ", response = FlintClosedTicketGetInfoSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/closed/ticket/get/info", method = RequestMethod.POST)
	public @ResponseBody Message flintClosedTicketGetInfo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("29", map, null, request, response);
		return message;
	}

	/**
	 * To get information of closed tickets activity bt id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/closed/tickets/activity/get/by/id", notes = "To get information of closed tickets activity bt id", response = FlintClosedTicketsActivityGetByIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/closed/tickets/activity/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message flintClosedTicketsActivityGetById(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("30", map, null, request, response);
		return message;
	}

	/**
	 * To get all Open Ticket for Mobile
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/tickets/get/all/mobile", notes = "To get all Open Ticket for Mobile ", response = FlintOpenTicketsGetAllMobileSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/tickets/get/all/mobile", method = RequestMethod.POST)
	public @ResponseBody Object flintOpenTicketGetAllMobile(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = thirdPartyServices.flintOpenTicketsGetAllWeb("117", map, null, request, response);
		return message.getObject();
	}

	/**
	 * To get all close Ticket for Mobile
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/close/tickets/get/all/mobile", notes = "To get all close Ticket for Mobile ", response = FlintCloseTicketsGetAllMobileSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to_date ", value = "Requires to_date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/close/tickets/get/all/mobile", method = RequestMethod.POST)
	public @ResponseBody Object flintCloseTicketsGetAllMobile(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = thirdPartyServices.flintCloseTicketsGetAllMobile("11", map, request, response);
		return message.getObject();
	}

	/**
	 * To get Open ticket Activity by id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/tickets/activity/get/by/id", notes = "To get Open ticket Activity by id", response = FlintOpenTicketsActivityGetByIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id", value = "Requires ticket_id user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/tickets/activity/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketsActivityGetById(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("27", map, null, request, response);
		return message;
	}

	/**
	 * To get Task Info by Task Alias
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/get/task/info/by/task/alias", notes = "To get Task Info by Task Alias", response = FlintGetTaskInfoByTaskAliasSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "ticket_task_alias", value = "Requires ticket_id user", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/task/info/by/task/alias", method = RequestMethod.POST)
	public @ResponseBody Message flintGetTaskInfoByTaskAlias(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("56", map, null, request, response);
		return message;
	}

	/**
	 * To get Open ticket Activity by id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/open/tickets/track/order/activity/get/by/id", notes = "To get Open ticket Activity by id to track order", response = FlintOpenTicketsTrackOrderActivityGetByIdSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id", value = "Requires ticket_id user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/open/tickets/track/order/activity/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message flintOpenTicketsTrackOrderActivityGetById(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("27", map, null, request, response);
		return message;
	}

	/**
	 * To get information of closed tickets activity bt id
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/closed/tickets/track/order/activity/get/by/id", notes = "To get information of closed tickets activity bt id", response = FlintClosedTicketsTrackOrderActivityGetByIdSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/closed/tickets/track/order/activity/get/by/id", method = RequestMethod.POST)
	public @ResponseBody Message flintClosedTicketsTrackOrderActivityGetById(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("30", map, null, request, response);
		return message;
	}

	/**
	 * To Insert the Open Ticket for future
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/saved/open/ticket/insert", notes = "To Insert the Open Ticket for future", response = FlintSavedOpenTicketInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_status", value = "Requires the task_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_country", value = "Requires pickup_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_state", value = "Requires pickup_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_city ", value = "Requires  pickup_city ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_address", value = "Requires pickup_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_landmark", value = "Requires pickup_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_contact_no", value = "Requires  pickup_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_key", value = "Requires consignee_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_country", value = "Requires dropoff_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_state", value = "Requires dropoff_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_city", value = "Requires dropoff_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_address", value = "Requires dropoff_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_landmark", value = "Requires dropoff_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_contact_no", value = "Requires dropoff_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_value", value = "Requires product_value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_in_weight", value = "Requires volume_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_in_percentage", value = "Requires volume_percentage", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla", value = "Requires sla_minutes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_date", value = "Requires pickup_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_lat", value = "Requires pickup_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_long", value = "Requires pickup_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_date", value = "Requires dropoff_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_lat", value = "Requires dropoff_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_long", value = "Requires dropoff_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_name", value = "Requires consignee name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_name", value = "Requires consigner name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "reciever_name", value = "Requires receiver name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "distance_from_source", value = "Requires distance from source", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_email_id", value = "Requires pickup_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_email_id", value = "Requires dropoff_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "scheduled_date", value = "Requires scheduled_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_name", value = "Requires consigner_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_name", value = "Requires consignee_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_path", value = "Requires consigner_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_path", value = "Requires consignee_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_id", value = "Requires consigner_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_id", value = "Requires consignee_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/saved/open/ticket/insert", method = RequestMethod.POST)
	public @ResponseBody Message flintSavedOpenTicketInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("68", map, null, request, response);

		return message;
	}

	/**
	 * To get all saved Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/saved/open/tickets/get/all", notes = "To get all saved  Ticket ", response = FlintOpenTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role name", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/saved/open/tickets/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintSavedOpenTicketGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = thirdPartyServices.flintSavedOpenTicketGetAll("90", map, null, request, response);
		return message;
	}

	/**
	 * To delete saved Ticket
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/saved/open/tickets/delete", notes = "To delete saved  Ticket ", response = FlintOpenTicketsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/saved/open/tickets/delete", method = RequestMethod.POST)
	public @ResponseBody Message flintSavedOpenTicketDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = thirdPartyServices.flintSavedOpenTicketGetAll("92", map, null, request, response);
		return message;
	}

	/**
	 * To Insert the Open Ticket for future
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/flint/saved/open/ticket/update", notes = "To Insert the Open Ticket for future", response = FlintSavedOpenTicketInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_status", value = "Requires the task_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_country", value = "Requires pickup_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_state", value = "Requires pickup_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_city ", value = "Requires  pickup_city ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_address", value = "Requires pickup_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_landmark", value = "Requires pickup_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_contact_no", value = "Requires  pickup_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_key", value = "Requires consignee_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_country", value = "Requires dropoff_country", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_state", value = "Requires dropoff_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_city", value = "Requires dropoff_city", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_address", value = "Requires dropoff_address", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_landmark", value = "Requires dropoff_landmark", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_contact_no", value = "Requires dropoff_contact_no", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_value", value = "Requires product_value", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_in_weight", value = "Requires volume_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "volume_in_percentage", value = "Requires volume_percentage", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla", value = "Requires sla_minutes", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_date", value = "Requires pickup_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_lat", value = "Requires pickup_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_long", value = "Requires pickup_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_date", value = "Requires dropoff_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_lat", value = "Requires dropoff_lat", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_long", value = "Requires dropoff_long", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_name", value = "Requires consignee name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_name", value = "Requires consigner name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "reciever_name", value = "Requires receiver name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "distance_from_source", value = "Requires distance from source", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_email_id", value = "Requires pickup_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_email_id", value = "Requires dropoff_email_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "scheduled_date", value = "Requires scheduled_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_name", value = "Requires consigner_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_name", value = "Requires consignee_document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_document_path", value = "Requires consigner_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_document_path", value = "Requires consignee_document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consigner_id", value = "Requires consigner_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "consignee_id", value = "Requires consignee_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/saved/open/ticket/update", method = RequestMethod.POST)
	public @ResponseBody Message flintSavedOpenTicketUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("94", map, null, request, response);

		return message;
	}
}
