/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.TrackingServices;
import com.springiot.swagger.response.FlintHistoryTrackingFilterSearchSwagger;
import com.springiot.swagger.response.FlintHistoryTrackingGetAllSwagger;
import com.springiot.swagger.response.FlintLiveTrackingGetAllSwagger;
import com.springiot.swagger.response.FlintTrackingFilterSearchSwagger;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * Application for Live Tracking
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
public class TrackingController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private TrackingServices trackingServices;
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To Retrieve all the Live Tracking
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
	@ApiOperation(value = "/flint/live/tracking/get/all", notes = "Retrieve all the Live Tracking ", response = FlintLiveTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "task_id ", value = "Requires task id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),

	})
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/live/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintLiveTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = trackingServices.flintLiveTrackingGetAll(map, request, response);
		return message;
	}

	/**
	 * To Retrieve all the History Tracking
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
	@ApiOperation(value = "/flint/history/tracking/get/all", notes = "Retrieve all the History Tracking ", response = FlintHistoryTrackingGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id ", value = "Requires device_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date ", value = "Requires end_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/history/tracking/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintHistoryTrackingGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = trackingServices.flintHistoryTrackingGetAll(map, request, response);
		return message;
	}

	/**
	 * Retrieve all the Live Tracking Data According to the Filter
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
	@ApiOperation(value = "/flint/tracking/filter/search", notes = "Retrieve all the Tracking Data According to the Filter on the basis of TicketID,RoleName or VehicleRegNo", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role_name to get all vehicles having open tickets in type RoleName ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket_id when we need on the basis of TicketID case ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit ", value = "Requires limit, if user wants to get Tracking by Ticket", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset ", value = "Requires offset,, if user wants to get Tracking by Ticket", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number ", value = "Requires registration_number, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_task_alias ", value = "Requires ticket_task_alias, if user wants to get Tracking by Order No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_id ", value = "Requires insert_user_id, if user wants to get Tracking by UserId", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_key ", value = "Requires insert_user_key, if user wants to get Tracking by UserId", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "type ", value = "Requires type of the search like TicketID to get all open tickets,RoleName to get all vehicle,VehicleRegNo to get ticket of particular Vehicle,OrderNo on the basis of ticket_task_alias,UserId on the basis of user id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/tracking/filter/search", method = RequestMethod.POST)
	public @ResponseBody Message flintLiveTrackingFilterSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */
		// if (map.get("type").equalsIgnoreCase("TicketID")) {
		// map.remove("type");
		// Message message = trackingServices.flintLiveTrackingFilterByTicketId(map,
		// request, response);
		// return message;
		// } else if (map.get("type").equalsIgnoreCase("RoleName")) {
		// map.remove("type");
		Message responseMessage = trackingServices.flintLiveTrackingFilterByRole(map, request, response);
		return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("VehicleRegNo")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintLiveTrackingFilterByRegNo(map, request, response);
		//
		// return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("UserId")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintLiveTrackingFilterByUserId(map, request, response);
		//
		// return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("OrderNo")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintLiveTrackingFilterByOrderNo(map, request, response);
		//
		// return responseMessage;
		// } else {
		// Message message = new Message();
		// message.setDescription("Error In Calling");
		// message.setValid(false);
		// return message;
		// }

	}

	/**
	 * Retrieve all the History Tracking Data According to the Filter
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
	@ApiOperation(value = "/flint/history/tracking/filter/search", notes = "Retrieve all the Tracking Data According to the Filter on the basis of TicketID,RoleName or VehicleRegNo", response = FlintHistoryTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name ", value = "Requires role_name when we need to get all vehicles having close tickets", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_id ", value = "Requires ticket_id when we need on the basis of TicketID case ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number ", value = "Requires registration_number, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ticket_task_alias ", value = "Requires ticket_task_alias, if user wants to get Tracking by Order No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_id ", value = "Requires insert_user_id, if user wants to get Tracking by UserId", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "insert_user_key ", value = "Requires insert_user_key, if user wants to get Tracking by UserId", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "type ", value = "Requires type of the search like TicketID to get all close tickets,RoleName to get all vehicle,VehicleRegNo to get ticket of particular Vehicle,OrderNo on the basis of ticket_task_alias,UserId on the basis of user id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/history/tracking/filter/search", method = RequestMethod.POST)
	public @ResponseBody Message flintHistoryTrackingFilterSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */
		// if (map.get("type").equalsIgnoreCase("TicketID")) {
		// map.remove("type");
		// Message message = trackingServices.flintVehicleHistoryFilterByTicketId(map,
		// request, response);
		// return message;
		// } else if (map.get("type").equalsIgnoreCase("RoleName")) {
		map.remove("type");
		Message responseMessage = trackingServices.flintVehicleHistoryFilterByRoleName(map, request, response);
		return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("VehicleRegNo")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintVehicleHistoryFilterByRegNo(map, request, response);
		//
		// return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("UserId")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintVehicleHistoryFilterByUserId(map, request, response);
		//
		// return responseMessage;
		// } else if (map.get("type").equalsIgnoreCase("OrderNo")) {
		// map.remove("type");
		// Message responseMessage =
		// trackingServices.flintVehicleHistoryFilterByOrderNo(map, request, response);
		//
		// return responseMessage;
		// } else {
		// Message message = new Message();
		// message.setDescription("Error In Calling");
		// message.setValid(false);
		// return message;
		// }

	}

	/**
	 * Retrieve all the Tickets on the basis of registration no
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
	@ApiOperation(value = "/flint/history/tracking/ticket/search/by/registration/number", notes = "Retrieve all the Tickets on the basis of registration no", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number ", value = "Requires registration_number, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "from_date ", value = "Requires from_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "to_date ", value = "Requires to_date", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/history/tracking/ticket/search/by/registration/number", method = RequestMethod.POST)
	public @ResponseBody Message flintHistoryTrackingTicketSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */

		Message message = genericProcess.GenericProcedureCalling("95", map, null, request, response);
		return message;

	}

	/**
	 * Retrieve all the Tickets on the basis of registration no
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
	@ApiOperation(value = "/flint/live/tracking/ticket/search/by/registration/number", notes = "Retrieve all the Tickets on the basis of registration no", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number ", value = "Requires registration_number, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/live/tracking/ticket/search/by/registration/number", method = RequestMethod.POST)
	public @ResponseBody Message flintLiveTrackingTicketSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */

		Message message = genericProcess.GenericProcedureCalling("96", map, null, request, response);
		return message;

	}

	/**
	 * Retrieve all the Tickets on the basis of registration no
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
	@ApiOperation(value = "/flint/insert/vehicle/driver", notes = "Retrieve all the Tickets on the basis of registration no", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Requires vehicle_id, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "license_key ", value = "Requires license_key, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_device_id ", value = "Requires vehicle_device_id, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "start_time ", value = "Requires start_time, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String"),})
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/insert/vehicle/driver", method = RequestMethod.POST)
	public @ResponseBody Message flintinsertvehicledriver(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */

		Message message = genericProcess.GenericProcedureCalling("114", map, null, request, response);
		return message;

	}

	/**
	 * Retrieve all the Tickets on the basis of registration no
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
	@ApiOperation(value = "/flint/insert/vehicle/driver/detach", notes = "Retrieve all the Tickets on the basis of registration no", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number ", value = "Requires registration_number, if user wants to get Tracking by Vehicle Registration No", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/insert/vehicle/driver/detach", method = RequestMethod.POST)
	public @ResponseBody Message flintinsertvehicledriverdetach(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */

		Message message = genericProcess.GenericProcedureCalling("115", map, null, request, response);
		return message;

	}

	/**
	 * Retrieve all the Tickets on the basis of registration no
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
	@ApiOperation(value = "/flint/get/open/ticket/device/get/all", notes = "Retrieve all the Tickets on the basis of registration no", response = FlintTrackingFilterSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id of specific user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organizaiton_id ", value = "Requires organizaiton_id", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Parameters for calling this method is map,request and response
	 */
	@RequestMapping(value = "/flint/get/open/ticket/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintgetopenticketdevicegetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * To check type of API calling and Call API accordingly
		 */

		Message message = genericProcess.GenericProcedureCalling("118", map, null, request, response);
		return message;

	}

}
