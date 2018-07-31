/**
 * This package contain the controller class for Third Party Application for GTZoom.
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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.CurrencyGetAllSwagger;
import com.springiot.swagger.response.GenericGetAllSwagger;
import com.springiot.swagger.response.UnitsGetAllSwagger;
import com.springiot.swagger.response.VehicleStatusGetAllSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for getting
 * data from metadata by generic procedure calling.
 * 
 * @author Mandeep Singh
 * @creation_date 28-02-2018
 */
@Controller
public class MetadataController {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericProcess genericProcess;
	
	/**
	 * To get all the units.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/units/get/all", notes = "To get all the units.", response = UnitsGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })
	
	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/units/get/all", method = RequestMethod.POST)
	public @ResponseBody Message unitsGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("27", map, null, request, response);
		return message;
	}
	
	/**
	 * To get all the vehicle manufactures names.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "vehicle/manufacturers/get/all", notes = "To get all the vehicle manufactures names.", response = GenericGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })
	
	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/vehicle/manufacturers/get/all", method = RequestMethod.POST)
	public @ResponseBody Message vehicleManufacturersGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("28", map, null, request, response);
		return message;
	}
	
	/**
	 * To get status of all the vehicles.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/status/get/all", notes = "To get status of all the vehicles.", response = VehicleStatusGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })

	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/vehicle/status/get/all", method = RequestMethod.POST)
	public @ResponseBody Message vehicleStatusGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("29", map, null, request, response);
		return message;
	}
	
	/**
	 * To get all the vehicle types.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/types/get/all", notes = "To get all the vehicle types.", response = GenericGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })

	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/vehicle/types/get/all", method = RequestMethod.POST)
	public @ResponseBody Message vehicleTypesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("30", map, null, request, response);
		return message;
	}
	
	/**
	 * To get all the fuel types.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/fueltypes/get/all", notes = "To get all the fuel types.", response = GenericGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })

	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/fueltypes/get/all", method = RequestMethod.POST)
	public @ResponseBody Message fuelTypesGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("31", map, null, request, response);
		return message;
	}
	
	/**
	 * To get all the types of currencies.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/currency/get/all", notes = "To get all the currencies.", response = CurrencyGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			 })

	/* 
	 * Input Parameters are map,request and response. Map handles all data as Post parameters.
	 */
	@RequestMapping(value = "/currency/get/all", method = RequestMethod.POST)
	public @ResponseBody Message currencyGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*
		 * This method is called to get the data from database.
		 */
		Message message = genericProcess.GenericProcedureCalling("32", map, null, request, response);
		return message;
	}
}
