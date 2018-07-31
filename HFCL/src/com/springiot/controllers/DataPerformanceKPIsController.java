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
import com.springiot.services.DataPerformanceKPIsServices;
import com.springiot.services.ProfileMetricsServices;
import com.springiot.swagger.response.KPISwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class DataPerformanceKPIsController {

	@Autowired
	private DataPerformanceKPIsServices dataServices;

	@Autowired
	private ProfileMetricsServices profileMetricservices;

	// KPI NUM 4
	@ApiOperation(value = "/downlink/data/throughput", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	
	@RequestMapping(value = "/downlink/data/throughput", method = RequestMethod.POST)
	public @ResponseBody Message downlinkData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = dataServices.downlinkDataThroughput(map, request, response);

		return message;
	}

	// KPI NUM 5 and 6 and 8 and 9
	@ApiOperation(value = "/egprs/downlink/data/throughput", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source", value = "Specific parameter from data"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	
	@RequestMapping(value = "/egprs/downlink/data/throughput", method = RequestMethod.POST)
	public @ResponseBody Message egprsdownlinkData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = dataServices.downlinkEgprsDataThroughput(map, request, response);

		return message;
	}

	@ApiOperation(value = "/uplink/data/throughput", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	
	@RequestMapping(value = "/uplink/data/throughput", method = RequestMethod.POST)
	public @ResponseBody Message uplinkData(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = dataServices.uplinkDataThroughput(map, request, response);

		return message;
	}

	@ApiOperation(value = "/sdcch/drop/rate/per/bts", notes = "Returns all the data for summation KPIS", response = KPISwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name_numerator", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source_numerator", value = "Requies the user ID"),
			@ApiImplicitParam(name = "service_name_denominator", value = "Requies the user ID"),
			@ApiImplicitParam(name = "data_source_denominator", value = "Requies the user ID"),
			@ApiImplicitParam(name = "from_date", value = "specific time interval you want data"),
			@ApiImplicitParam(name = "end_date", value = "specific time interval you want data") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	
	@RequestMapping(value = "/sdcch/drop/rate/per/bts", method = RequestMethod.POST)
	public @ResponseBody Message sdcchDropRatePerBts(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = profileMetricservices.sdcchDropRatePerBts(map, request, response);

		return message;
	}

}
