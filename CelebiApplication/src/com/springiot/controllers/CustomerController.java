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
import com.springiot.services.CustomerServices;
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
public class CustomerController {
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private CustomerServices customerService;

	/**
	 * Registeration of customer
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
	@ApiOperation(value = "/flint/create/customer", notes = "Registeration of customer", response = FlintCreateCustomerSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "email", value = "Requires the Email Address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name", value = "Requires first_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name", value = "Requires last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires the country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires the state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires the city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preferred_number", value = "Requires preferred_number	", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "phone_numbers", value = "Requires phone_numbers", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "address", value = "Requires address of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "prefered_contact_number", value = "Requires prefered_contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_group", value = "Requires the user_group", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sla", value = "Requires the sla", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "preference_id", value = "Requires the preference_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "cutomer_doc_name", value = "Requires document_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "cutomer_doc_path", value = "Requires document_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consignee_detail", value = "Requires the Json containing consignee consigner detail contains  (name,email_id,contact_number,company_name,office_contact_number,country,state,city,latitude,longitude,is_deleted,product_type,vehicle_type,load_weight,number_of_items,load_volume,user_type,consigne_doc_name,consigne_doc_path,alias,company_address,dropoff_location)", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/flint/create/customer", method = RequestMethod.POST)
	public @ResponseBody Message flintCustomerCreate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = customerService.flintCustomerCreate(map, request, response);
		return message;
	}

	/**
	 * To Update the customer information
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
	@ApiOperation(value = "/flint/customer/update", notes = "To Update the customer information", response = FlintCustomerUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),

			@ApiImplicitParam(name = "customer_key", value = "Requires the user_key of customer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "customer_id", value = "Requires User Id of customer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "first_name", value = "Requires license_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "last_name", value = "Requires is_deleted", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "prefered_contact_number", value = "Requires created_on", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_group", value = "Requires last_modified_on", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sla", value = "Requires driver_first_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_active", value = "Requires driver_middle_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires driver_last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "cutomer_doc_name", value = "Requires document_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "cutomer_doc_path", value = "Requires document_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consignee_detail", value = "Requires the Json containing (customer_id,name,email_id,contact_number,company_name,office_contact_number,country,state,city,latitude,longitude,is_deleted,product_type,vehicle_type,load_weight,number_of_items,load_volume,user_type,consigne_doc_name,consigne_doc_path,alias,company_address,dropoff_location)", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/customer/update", method = RequestMethod.POST)
	public @ResponseBody Message flintUpdateCustomer(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */

		Message message = customerService.flintCustomerUpdate(map, request, response);

		return message;

	}

	/**
	 * To get all the Customer information.
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
	@ApiOperation(value = "/flint/get/customer", notes = "To get all the Customer information.", response = FlintGetCustomerSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name", value = "Requires  role_name of customer", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomer(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = customerService.flintGetCustomer(map, request, response);
		return message;
	}

	/**
	 * To get all the User Tag
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

	@ApiOperation(value = "/flint/get/customer/user/tag", notes = "To get all the User Tag", response = FlintGetCustomerUserTagSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),

			@ApiImplicitParam(name = "user_tag_name ", value = "Requires the user_tag_name ", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer/user/tag", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomerUserTag(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("83", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer Preferences
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
	@ApiOperation(value = "/flint/get/customer/preferences", notes = "To get all the Customer Preferences", response = FlintGetCustomerPreferencesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),

			@ApiImplicitParam(name = "preference_id", value = "Requires the preference_id", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer/preferences", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomerPreference(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("82", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer Preferences
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
	@ApiOperation(value = "/flint/get/customer/add/user/tag", notes = "To get all the Customer Preferences", response = FlintGetCustomerAddUserTagSwagger.class)

	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_tag_name", value = "Requires the user_tag_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "sequence_number", value = "Requires the sequence_number", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer/add/user/tag", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomerAddUserTag(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("84", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Customer Key information.
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
	@ApiOperation(value = "/flint/get/customer/by/customer/key", notes = "To get all the Customer information.", response = FlintGetCustomerByCustomerKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "customer_key", value = "Requires  customer_key of customer", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer/by/customer/key", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomerByCustomerKey(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("87", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Seraching.
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
	@ApiOperation(value = "/flint/get/customer/search", notes = "To get all the Customer by Seraching", response = FlintGetCustomerSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name", value = "Requires  customer_key of customer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "keyword_to_search", value = "Requires  keyword_to_search", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "Requires  limit ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset", value = "Requires  offset", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/customer/search", method = RequestMethod.POST)
	public @ResponseBody Message flintGetCustomerSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = customerService.flintGetCustomerSearch(map, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Seraching.
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
	@ApiOperation(value = "/flint/get/consignee/consigner/search", notes = "To get all the Customer by Seraching", response = FlintGetCustomerSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "role_name", value = "Requires  customer_key of customer", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_type", value = "Requires  user_type", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/get/consignee/consigner/search", method = RequestMethod.POST)
	public @ResponseBody Message flintGetConsigneeConsignerSearch(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = customerService.flintGetConsigneeConsignerSearch(map, request, response);
		return message;
	}

	/**
	 * To delete Customer By Customer Key
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
	@ApiOperation(value = "/flint/delete/customer", notes = "To delete  Customer By Customer Key .", response = FlintGetCustomerByCustomerKeySwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "customer_user_id ", value = "Requires  customer_user_id  of customer", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/delete/customer", method = RequestMethod.POST)
	public @ResponseBody Message flintDeleteCustomerByCustomerKey(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("78", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Seraching.
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
	@ApiOperation(value = "/flint/insert/consignee/consigner", notes = "To get all the Customer by Seraching", response = FlintGetCustomerSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "Requires name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email_id", value = "Requires email_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "contact_number", value = "Requires contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "company_name", value = "Requires  company_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "office_contact_number", value = "Requires office_contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "latitude", value = "Requires latitude", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "longitude", value = "Requires longitude", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_type", value = "Requires vehicle_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "load_weight", value = "Requires  load_weight", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "load_volume", value = "Requires load_volume", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_type", value = "Requires  user_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consigne_doc_name", value = "Requires consigne_doc_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consigne_doc_path", value = "Requires consigne_doc_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "alias", value = "Requires  alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "company_address", value = "Requires  company_address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "dropoff_location", value = "Requires  dropoff_location", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/insert/consignee/consigner", method = RequestMethod.POST)
	public @ResponseBody Message flintInsertConsigneeConsigner(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("76", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Seraching.
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
	@ApiOperation(value = "/flint/update/consignee/consigner", notes = "To get all the Customer by Seraching", response = FlintGetCustomerSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "name", value = "Requires name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "email_id", value = "Requires email_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "contact_number", value = "Requires contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "company_name", value = "Requires  company_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "office_contact_number", value = "Requires office_contact_number", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "country", value = "Requires country", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "state", value = "Requires state", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "city", value = "Requires city", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "latitude", value = "Requires latitude", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "longitude", value = "Requires longitude", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "product_type", value = "Requires product_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "vehicle_type", value = "Requires vehicle_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "load_weight", value = "Requires  load_weight", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "number_of_items", value = "Requires number_of_items", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "load_volume", value = "Requires load_volume", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_active", value = "Requires driver_middle_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires driver_last_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_type", value = "Requires  user_type", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consigne_doc_name", value = "Requires consigne_doc_name", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "consigne_doc_path", value = "Requires consigne_doc_path", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "alias", value = "Requires  alias", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "company_address", value = "Requires  company_address", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "dropoff_location", value = "Requires  dropoff_location", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/update/consignee/consigner", method = RequestMethod.POST)
	public @ResponseBody Message flintUpdateConsigneeConsigner(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("79", map, null, request, response);
		return message;
	}

	/**
	 * To get all the Customer By Seraching.
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
	@ApiOperation(value = "/flint/delete/consignee/consigner", notes = "To get all the Customer by Seraching", response = FlintGetCustomerSearchSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "id", value = "Requires  id", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */

	@RequestMapping(value = "/flint/delete/consignee/consigner", method = RequestMethod.POST)
	public @ResponseBody Message flintDeleteConsigneeConsigner(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("93", map, null, request, response);
		return message;
	}
}
