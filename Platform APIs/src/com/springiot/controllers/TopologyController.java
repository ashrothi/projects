/**
 * This package contain the controller class to create APIs for TopologyController data.
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
import com.springiot.swagger.response.GenericInventoryBiHourlyDeviceGetWithoutDataSwagger;
import com.springiot.swagger.response.TopologyDeviceGetAll;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Ankita Shrothi This class work as a controller which is used to
 *         create APIs to retrieve the Topology(device) metadata from xFusion
 *         database.
 */
@Controller
public class TopologyController {
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * Get all the Topology Data of the given device Id
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
	@ApiOperation(value = "/device/topology/get/by/device", notes = "Get all the Topology Data of the given device Id", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"), })

	@RequestMapping(value = "/device/topology/get/by/device", method = RequestMethod.POST)
	public @ResponseBody Message deviceTopologyGetByDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			/**
			 * Casting organization_id in Integer format
			 */
//			Integer organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
//			/**
//			 * Putting it in input parameter map
//			 */
//			map.put("organization_id", organizationId.toString());
			/**
			 * Displaying Parameter map
			 */
			// System.out.println("map is" + map);
			/*
			 * To call the procedure required for data processing.
			 */

			Message message = genericProcess.GenericProcedureCallingMetaData("458", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * Get all the Topology Data
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
	@ApiOperation(value = "/device/topology/get/all", notes = "Get all the Topology Data", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the ID of device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"), })

	@RequestMapping(value = "/device/topology/get/all", method = RequestMethod.POST)
	public @ResponseBody Message deviceTopologyGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

//			Integer organizationId = Integer.parseInt(String.valueOf(request.getAttribute("organization_id")));
//			/**
//			 * Putting it in input parameter map
//			 */
//			map.put("organization_id", organizationId.toString());
//			/**
//			 * Displaying Parameter map
//			 */
//		
			/*
			 * To call the procedure required for data processing.
			 */
			Message message = genericProcess.GenericProcedureCallingMetaData("459", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	@ApiOperation(value = "Retrieve all active alerts of a particular device", notes = "Retrieve all active alerts of a particular device ", response = TopologyDeviceGetAll.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated for authentication", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the unique identification of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "search_text", value = "Requires the search text", required = true, access = "query", paramType = "query") })
	@RequestMapping(value = "/toplology/device/get/all", method = RequestMethod.POST)
	public @ResponseBody Message PerformanceEventstatusAlertDeviceGetAll(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("461", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

}
