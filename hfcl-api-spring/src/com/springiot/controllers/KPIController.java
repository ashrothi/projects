/**
 * This package contain the controller class for KPIs for Dashboard in HFCL
 */
package com.springiot.controllers;

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
import com.springiot.services.KPIServices;
import com.springiot.swagger.response.GetDevicesByDeviceTypeSwagger;
import com.springiot.swagger.response.KPISwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller is used for displaying all the KPIs on the dashboard
 * 
 * @author tanvigarg
 *
 */
@Controller
public class KPIController {

	@Autowired
	private KPIServices kpiServices;

	/**
	 * To get all the devices on the basis of device type
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/get/devices/by/devicetype", notes = "Returns all the devices on the basis of device type", response = GetDevicesByDeviceTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "device_type", value = "Requires the type of device", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "host_status", value = "Requires the host status", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/get/devices/by/devicetype", method = RequestMethod.POST)
	public @ResponseBody Message auditLogGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = kpiServices.getDevicesByDatatype(map, request, response);

		return message;
	}

	/**
	 * This API is used to provides the data for all of the summation KPIs
	 * required on the dashboard
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/call/attempts/per/trx", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/call/attempts/per/trx", method = RequestMethod.POST)
	public @ResponseBody Message callAttemptsPerTrx(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = kpiServices.getcallAttemptsPerTrx(map, request, response);

		return message;
	}

	/**
	 * This API is used to provides the data for all of the last occurring data
	 * KPIs required on the dashboard
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/number/paging/attempts", notes = "Returns all the data for all of the last occurring data KPIs", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/number/paging/attempts", method = RequestMethod.POST)
	public @ResponseBody Message callSetupSuccessRate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = kpiServices.getcallSetupSuccessRate(map, request, response);

		return message;
	}

	/**
	 * This API is used to provides the data for all of the summation KPIs
	 * required on the dashboard
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	// KPI NUM 2 and 3
	@ApiOperation(value = "/total/downlink/data", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "service_name", value = "specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/total/downlink/data", method = RequestMethod.POST)
	public @ResponseBody Message totalDownlinkData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = kpiServices.gettotalDownlinkData(map, request, response);

		return message;
	}
}
