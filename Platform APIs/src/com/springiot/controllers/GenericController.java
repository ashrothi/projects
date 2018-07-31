/**
 * This package contain the controller class for generic apis.
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
import com.springiot.swagger.response.*;
import com.logging.retrievalLogs.RetrievalLogs;
import com.springiot.controllers.ignoreControllers.GenericControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class is a controller for connecting Gateway with
 *         xFusion Api's.
 */
@Controller
@Api(value = "/", description = "Generic API which are using globaly")
public class GenericController extends GenericControllerCUD {
	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get list of all countries.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/devices/get/by/keyword", notes = "To get list of all countries", response = DevicesGetByKeywordSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "search_criteria", value = "Specific criteria for global search"), })

	@RequestMapping(value = "/devices/get/by/keyword", method = RequestMethod.POST)
	public @ResponseBody Message devicesGetByKeyword(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("414", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * This API will helps to retrieve all the errors
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 * 
	 */

	@ApiOperation(value = "/xfusion/exception/log/get/all", notes = "To get the error logs on the exception basis ", response = XfusionExceptionLogGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Requires the from date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Requires the end date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "limit ", value = "Requires the limit", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "offset ", value = "Requires the offset", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_api_url ", value = "Requires the url for downloading excel", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "report_name ", value = "Requires the name of excel report", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition for server side filtering", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/xfusion/exception/log/get/all", method = RequestMethod.POST)
	public @ResponseBody Message xfusioneExceptionLogGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// System.out.println("organization_id " +
		// String.valueOf(request.getAttribute("organization_id")));
		// Integer organizationId =
		// Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
		// map.put("organization_id", organizationId.toString());

		// To call the procedure required for data processing.
		RetrievalLogs retrievalLogs = new RetrievalLogs();
		Object object = retrievalLogs.GenericProcedureForLogs("418", map, request, response, genericProcess,
				"GenericProcedureLogs", String.class, Map.class, HttpServletRequest.class, HttpServletResponse.class);

		Message message = (Message) object;

		// Return the response message.
		return message;

	}

	/**
	 * This API will helps to retrieve count of errors.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 **/

	@ApiOperation(value = "/xfusion/exception/log/count", notes = "To get the errors count", response = InventoryMonthlyDeviceGetManyCountSwagger.class)

	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key ", value = "Requires the user_key", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id ", value = "Requires the user id ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "application_key ", value = "Requires the application key ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "from_date ", value = "Requires the from date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "end_date ", value = "Requires the end date ", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition for server side filtering", required = true, access = "query", paramType = "query"),

	})

	@RequestMapping(value = "/xfusion/exception/log/count", method = RequestMethod.POST)
	public @ResponseBody Message xfusioneExceptionLogCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//
		// Integer organizationId =
		// Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
		// map.put("organization_id", organizationId.toString());

		// To call the procedure required for data processing.
		RetrievalLogs retrievalLogs = new RetrievalLogs();
		Object object = retrievalLogs.GenericProcedureForLogs("419", map, request, response, genericProcess,
				"GenericProcedureLogs", String.class, Map.class, HttpServletRequest.class, HttpServletResponse.class);

		Message message = (Message) object;

		// Return the response message.

		return message;

	}

	/**
	 * To get settings of xFusion Platform
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/xfusion/settings", notes = "To get list of all countries", response = DevicesGetByKeywordSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "search_criteria", value = "Specific criteria for global search") })

	@RequestMapping(value = "/xfusion/settings", method = RequestMethod.POST)
	public @ResponseBody Message xfusionSettings(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingConfig("460", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	// @ApiOperation(value = "/**/", notes = "To call grafana api", response =
	// DevicesGetByKeywordSwagger.class)
	// @RequestMapping(value = "/**/", method = { RequestMethod.POST,
	// RequestMethod.GET }, headers = { "*/*" })
	// public @ResponseBody Message xfusionSettingsGrafana(@ApiIgnore @RequestParam
	// Map<String, String> map,
	// HttpServletRequest request, HttpServletResponse response) throws Exception {
	//
	// /*
	// * To call the procedure required for data processing.
	// */
	// Message message = grafanaServices.callGrafanaAPIs(map, request, response);
	// /*
	// * Return the response message.
	// */
	// return message;
	// }

	
//	@RequestMapping(value = "/**/", method = { RequestMethod.POST, RequestMethod.GET })
//	public @ResponseBody Message xfusionSettingsGrafana(@ApiIgnore @RequestParam Map<String, String> map,
//			HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//		/*
//		 * To call the procedure required for data processing.
//		 */
//		Message message = grafanaServices.callGrafanaAPIs(map, request, response);
//		/*
//		 * Return the response message.
//		 */
//		return message;
//	}
}
