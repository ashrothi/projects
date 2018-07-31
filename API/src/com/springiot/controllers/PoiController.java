/**
 * This package contains the Controller for GMR Application.
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
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class PoiController {

	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To insert poi(point of interest)
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
	 */
	@ApiOperation(value = "/poi/insert", notes = "To insert point of interest", response = PoiInsertSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "label", value = "Requires label for poi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "latitude", value = "Requires the latitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "image_path", value = "Requires the path of image", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "poi_type", value = "Requires the type of POI", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "city", value = "Requires the name of city", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "state", value = "Requires the name of state", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "address", value = "Requires the name of country", required = true, access = "query", paramType = "query", dataType = "Int") })

	@RequestMapping(value = "/poi/insert", method = RequestMethod.POST)
	public @ResponseBody Message poiInsert(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
		return message;
	}

	/**
	 * To update poi(point of interest)
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
	 */
	@ApiOperation(value = "/poi/update", notes = "To update point of interest", response = PoiUpdateSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "poi_id", value = "Requires poi Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "label", value = "Requires the label for pi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description of poi", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "latitude", value = "Requires the latitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "image_path", value = "Requires the path of image", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "poi_type", value = "Requires the type of POI", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "city", value = "Requires the name of city", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "state", value = "Requires the name of state", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "address", value = "Requires the name of country", required = true, access = "query", paramType = "query", dataType = "Int") })

	@RequestMapping(value = "/poi/update", method = RequestMethod.POST)
	public @ResponseBody Message deviceGetMetadataStatusByTypeLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);
		return message;
	}

	/**
	 * To delete poi(point of interest)
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
	 */
	@ApiOperation(value = "/poi/delete", notes = "To delete point of interest", response = PoiDeleteSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "userKey", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "poi_id", value = "Requires poi Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "label", value = "Requires the label for pi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "description", value = "Requires the description of poi", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "latitude", value = "Requires the latitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "longitude", value = "Requires the longitude", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "image_path", value = "Requires the path of image", required = true, access = "query", paramType = "query", dataType = "Int"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit", required = true, access = "query", paramType = "query", dataType = "String"), })

	@RequestMapping(value = "/poi/delete", method = RequestMethod.POST)
	public @ResponseBody Message poiDelete(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);
		return message;
	}

	/**
	 * To get poi(point of interest) on the basis of poi id
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
	 */
	@ApiOperation(value = "/get/poi", notes = "To get poi(point of interest) on the basis of poi id", response = GetPoiSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),

			@ApiImplicitParam(name = "poi_id", value = "Requires poi Id of user", required = true, access = "query", paramType = "query", dataType = "String"),

	})

	@RequestMapping(value = "/get/poi", method = RequestMethod.POST)
	public @ResponseBody Message getPoi(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("3", map, null, request, response);
		return message;
	}

	/**
	 * To get poi(point of interest) list
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
	 */
	@ApiOperation(value = "/get/poi/list", notes = "To get poi(point of interest) list", response = GetPoiListSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/get/poi/list", method = RequestMethod.POST)
	public @ResponseBody Message getPoiList(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("4", map, null, request, response);
		return message;
	}

}
