/**
 * This package contain the controller class to create APIs for TopologyController data.
 */
package com.springiot.controllers.ignoreControllers;

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
public class TopologyControllerCUD {
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To insert the topology
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
	@ApiOperation(value = "/device/topology/insert", notes = "To insert the topology", response = GenericInventoryBiHourlyDeviceGetWithoutDataSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "origin_device", value = "Requires origin device"),
			@ApiImplicitParam(name = "destination_device", value = "Requires destination device"),
			@ApiImplicitParam(name = "origin_coordinate_x", value = "Requires origin coordinate x"),
			@ApiImplicitParam(name = "origin_coordinate_y", value = "Requires origin coordinate y"),
			@ApiImplicitParam(name = "destination_coordinate_x", value = "Requies the destination coordinate x"),
			@ApiImplicitParam(name = "destination_coordinate_y", value = "Requires  destination coordinate y"),
			@ApiImplicitParam(name = "edge", value = "Requires edge")})

	@RequestMapping(value = "/device/topology/insert", method = RequestMethod.POST)
	public @ResponseBody Message deviceTopologyInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("457", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
