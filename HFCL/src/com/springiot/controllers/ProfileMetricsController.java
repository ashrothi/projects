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
import com.springiot.services.ProfileMetricsServices;
import com.springiot.swagger.response.KPISwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This controller class is used to display KPIs related to theProfile Metrics
 * 
 * @author tanvigarg
 *
 */
@Controller
public class ProfileMetricsController {

	@Autowired
	private ProfileMetricsServices profileMetricservices;

	@ApiOperation(value = "/uplink/tbf/blocking/rate", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name_numerator_1", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "data_source_numerator_1", value = "Requies the data source of numerator"),
			@ApiImplicitParam(name = "service_name_numerator_2", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "data_source_numerator_2", value = "Requies the data source of numerator"),
			@ApiImplicitParam(name = "service_name_denominator_1", value = "Requies the service name of denominator"),
			@ApiImplicitParam(name = "data_source_denominator_1", value = "Requies the data source of denominator"),
			@ApiImplicitParam(name = "service_name_denominator_2", value = "Requies the service name of denominator"),
			@ApiImplicitParam(name = "data_source_denominator_2", value = "Requies the data source of denominator"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/uplink/tbf/blocking/rate", method = RequestMethod.POST)
	public @ResponseBody Message uplinkTbfBlockingRate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = profileMetricservices.uplinkTbfBlockingRate(map, request, response);

		return message;
	}

	@ApiOperation(value = "/gprs/uplink/tbf/blocking/rate", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name_numerator_1", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "service_name_numerator_2", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "service_name_numerator_3", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "service_name_numerator_4", value = "Requies the service name of numerator"),
			@ApiImplicitParam(name = "service_name_denominator_1", value = "Requies the service name of denominator"),
			@ApiImplicitParam(name = "service_name_denominator_2", value = "Requies the service name of denominator"),
			@ApiImplicitParam(name = "data_source", value = "Requies the data source of denominator"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/gprs/uplink/tbf/blocking/rate", method = RequestMethod.POST)
	public @ResponseBody Message gprsUplinkTbfBlockingRate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = profileMetricservices.gprsUplinkTbfBlockingRate(map, request, response);

		return message;
	}

	@ApiOperation(value = "/total/voice/call/minutes/per/bts", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name", value = "Requies the service name "),
			@ApiImplicitParam(name = "data_source", value = "Requies the data source of denominator"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/total/voice/call/minutes/per/bts", method = RequestMethod.POST)
	public @ResponseBody Message totalVoiceCallMinutesPerBTS(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = profileMetricservices.totalVoiceCallMinutesPerBTS(map, request, response);

		return message;
	}

}
