/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

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
import com.springiot.services.ThirdPartyServices;
import com.springiot.swagger.response.SignUpSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used retrieve all vehicles or state
 * of vehicle or the type of vehicle or retrieve all vehicles based on some
 * specific criteria
 * 
 * @author Ankita Shrothi
 * @updated_by Garima Joshi
 * @updated_on 08-03-2018
 * @Updated_by Mandeep Singh
 * @updated_on 02-04-2018
 */
@Controller
public class ThirdPartyController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;
	
	@Autowired
	private ThirdPartyServices thirdPartyServices;

	/**
	 * To call detail about trips covered by the vehicle within the specific
	 * time.
	 * 
	 * @param map
	 *            : Here pass the required parameters for API call.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/calculate/trips", notes = "Get details of parameter from single device of Status table")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "user_key", value = "Here pass the user_key for the validation.", paramType = "Header"),
			@ApiImplicitParam(name = "user_id", value = "Here pass the user_name for the validation.", paramType = "Header"),
			@ApiImplicitParam(name = "start_time", value = "Here pass start date in epoch format for getting data in specific time interval."),
			@ApiImplicitParam(name = "end_time", value = "Here pass end date in epoch format for getting data in specific time interval."),
			@ApiImplicitParam(name = "device_id", value = "Here pass device_id for which user wants data."), })
	@RequestMapping(value = "/vehicle/calculate/trips", method = RequestMethod.POST)
	public @ResponseBody Message vehicleCalculateTrips(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//Message message = thirdPartyServices.tripServices(map, request, response);
		Message message = genericProcess.GenericProcedureCalling("5", map, null, request, response);

		return message;
	}

	/**
	 * To insert vehicle trip tags.
	 * 
	 * @param map
	 *            : Here pass the required parameters for API call.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/trip/tag/insert", notes = "To insert vehicle trip tags.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "vehicle_id", value = "Here pass the vehicle id.", paramType = "query"),
			@ApiImplicitParam(name = "tags_id", value = "Here pass the tags id.", paramType = "query"),
			@ApiImplicitParam(name = "trip_id", value = "Here pass trip id."),
			@ApiImplicitParam(name = "vehicle_tags_id", value = "Here pass the vehicle tags id.", paramType = "query"), })
	@RequestMapping(value = "/vehicle/trip/tag/insert", method = RequestMethod.POST)
	public @ResponseBody Message vehicleTripTagInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("38", map, null, request, response);
		return message;
	}

	/**
	 * To get vehicle trips by trip id.
	 * 
	 * @param map : Here pass the required parameters for API call.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/get/vehicle/trips/by/trip/id", notes = "To get vehicle trips by trip id.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Response.class),
			@ApiResponse(code = 401, response = URI.class, message = "Unauthorized"),
			@ApiResponse(code = 402, message = "Message for UUID", response = UUID.class),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 403, response = Long.class, message = "Forbidden"),
			@ApiResponse(code = 404, response = String.class, message = "Not Found"),
			@ApiResponse(code = 409, response = Response.class, message = "ID already taken"),
			@ApiResponse(code = 500, response = Response.class, message = "Failure") })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Here pass token generated for authenticating the HTTP request.", paramType = "Header"),
			@ApiImplicitParam(name = "from_date", value = "Here pass start date in epoch format."),
			@ApiImplicitParam(name = "end_date", value = "Here pass end date in epoch format."),
			@ApiImplicitParam(name = "trip_id", value = "Here pass trip id."), })
	@RequestMapping(value = "/get/vehicle/trips/by/trip/id", method = RequestMethod.POST)
	public @ResponseBody Message getVehicleTripsByTripId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("39", map, null, request, response);
		return message;
	}
	
	/**
	 * This api is for inserting trip into the third party database.
	 *  
	 * @param map : Here pass the required body parameters for API call.
	 * @param request : To get user_key,user_id from http request header.
	 * @param response : To send http response.
	 * @return Return the response message.
	 */
	@ApiOperation(value="/vehicle/trip/insert", notes="To insert the trip details in database", response = Message.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name="trip_id", value="Here pass trip id for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="device_id", value="Here pass device_id for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="fuel_consuption", value="Here pass fuel consuption for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="distance", value="Here pass distance of trip for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="mileage_kmpl", value="Here pass mileage kmpl for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="start_time", value="Here pass start time for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="end_time", value="Here pass end time for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="tag_id", value="Here pass tag id for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="country", value="Here pass country for which user wants data.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="state", value="Here pass start date in epoch format for getting data in specific time interval.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="city", value="Here pass the city.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="trip_duration", value="Here pass duration of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="harsh_brake", value="Here pass harsh brake of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="avg_speed", value="Here pass avg speed of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="hard_acceleration ", value="Here pass hard acceleration of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="driver_score", value="Here pass driver score of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="vehicle_score", value="Here pass vehicle score of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="start_latitude", value="Here pass start latitudeof trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="start_longitude", value="Here pass start longitude of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="start_address", value="Here pass start address of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="end_latitude ", value="Here pass end latitude of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="end_longitude   ", value="Here pass end longitude of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="end_address", value="Here pass end address of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="fuel_score", value="Here pass fuel score of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="lat_list", value="Here pass list of latitude of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="long_list", value="Here pass list of longitude of trip.", required = true, access = "query", paramType = "query", dataType = "String"), 
		@ApiImplicitParam(name="time_list", value="Here pass list of time stamp of trip.", required = true, access = "query", paramType = "query", dataType = "String")})
	@RequestMapping(value={"/vehicle/trip/insert"}, method={RequestMethod.POST})
	@ResponseBody
	public Message vehicleTripInsert(@ApiIgnore @RequestParam Map<String, String> map, 
			HttpServletRequest request, HttpServletResponse response)
	{
		Message message = thirdPartyServices.tripInsert(map, request, response);
		return message;
	}
}