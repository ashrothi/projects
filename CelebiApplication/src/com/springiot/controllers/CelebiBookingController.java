/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

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

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for CRUD for Customer and
 * manage Customer details
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class CelebiBookingController {
	@Autowired
	private GenericProcess genericProcess;

	@ApiOperation(value = "/flint/get/booking/service/details", notes = "To get all the booking service details", response = FlintGetCustomerUserTagSwagger.class)

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/booking/service/details", method = RequestMethod.POST)
	public @ResponseBody Message flintgetbookingservicedetails(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("97", map, null, request, response);
		return message;
	}

	@ApiOperation(value = "/flint/get/booking/details", notes = "To get all booking  details", response = FlintGetCustomerUserTagSwagger.class)

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/booking/details", method = RequestMethod.POST)
	public @ResponseBody Message flintgetbookingdetails(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("98", map, null, request, response);
		return message;
	}

	@ApiOperation(value = "/flint/get/origin/address", notes = "To get origin address", response = FlintGetCustomerUserTagSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "booking_service_id", value = "Requires booking_service_idr", required = true, access = "query", paramType = "query"),

			@ApiImplicitParam(name = "booking_id ", value = "Requires the booking_id ", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/origin/address", method = RequestMethod.POST)
	public @ResponseBody Message flintgetoriginaddress(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("99", map, null, request, response);
		return message;
	}

	@ApiOperation(value = "/flint/get/destination/address", notes = "To get all the destination address", response = FlintGetCustomerUserTagSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "booking_service_id", value = "Requires booking_service_idr", required = true, access = "query", paramType = "query"),

			@ApiImplicitParam(name = "booking_id ", value = "Requires the booking_id ", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/destination/address", method = RequestMethod.POST)
	public @ResponseBody Message flintgetdestinationaddress(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("100", map, null, request, response);
		return message;
	}

	@ApiOperation(value = "/flint/airline/prefix/get/all", notes = "To get all the destination address", response = FlintGetCustomerUserTagSwagger.class)

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/airline/prefix/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintairlineprefixgetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("116", map, null, request, response);
		return message;
	}

}
