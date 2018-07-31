/**
 * This package contain the controller class for Third Party Application apis.
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
import com.springiot.services.DownloadServices;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.MasterActiveCategoryGetByLevelIdSwagger;
import com.springiot.swagger.response.MasterActiveLevelGetAllSwagger;
import com.springiot.swagger.response.MasterActiveSubcategoryGetAllSwagger;
import com.springiot.swagger.response.OrganizationDeleteSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used to create apis for Third Party
 * for File Operations Application
 * 
 * @author Ankita Shrothi
 * @author Garima Joshi from : 08/01/2018
 *
 */
@Controller
public class FileController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private DownloadServices downloadService;

	/**
	 * To Delete the Study Files
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get user_key,user_id from request header
	 *            barc_budde_study_access_get_by_study_id
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@ApiOperation(value = "/study/delete", notes = "To Delete the Study Files")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/delete", method = RequestMethod.POST)
	public @ResponseBody Message studyDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
		return message;
	}

	/**
	 * To get the Study Files
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
	@ApiOperation(value = "/study/get", notes = "To get the Study Files")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "start_date", value = "Requires the Start Date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires the limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "condition", value = "Requires the condition ", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/get", method = RequestMethod.POST)
	public @ResponseBody Message studyGet(@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("2", map, null, request, response);
		return message;
	}

	/**
	 * To insert the Study Files
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
	@ApiOperation(value = "/study/insert", notes = "To get the Study Files")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "start_date", value = "Requires the Start Date ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "end_date", value = "Requires the End Date ", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/insert", method = RequestMethod.POST)
	public @ResponseBody Message studyInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("8", map, null, request, response);
		return message;
	}

	/**
	 * To get the Study Files by Org Id
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
	@ApiOperation(value = "/study/get/by/org/id", notes = "To get the Study Files by Org Id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires the org_id ", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/get/by/org/id", method = RequestMethod.POST)
	public @ResponseBody Message studyGetByOrgId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("36", map, null, request, response);
		return message;
	}

	/**
	 * To get study access by study id
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
	@ApiOperation(value = "/study/access/get/by/study/id", notes = "To get study access by study id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires the organization id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study id", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/access/get/by/study/id", method = RequestMethod.POST)
	public @ResponseBody Message studyaccessgetbystudyid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("37", map, null, request, response);
		return message;
	}

	/**
	 * To get study access by master ques
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
	@ApiOperation(value = "/study/access/get/by/master/ques", notes = "To get study access by master ques")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study_id ", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "master_ques_var_name", value = "Requires the master_ques_var_name ", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/access/get/by/master/ques", method = RequestMethod.POST)
	public @ResponseBody Message studyaccessgetbymasterques(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("38", map, null, request, response);
		return message;
	}

	/**
	 * To get study access by study id
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
	@ApiOperation(value = "/study/get/all", notes = "To get study access by study id")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	@RequestMapping(value = "/study/get/all", method = RequestMethod.POST)
	public @ResponseBody Message studygetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("39", map, null, request, response);
		return message;
	}

	/**
	 * To get master ans by question
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
	@ApiOperation(value = "/get/answers/by/question/id", notes = "To get master ans by question")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "master_parent_question_id", value = "Requires the master_parent_question_id ", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/get/answers/by/question/id", method = RequestMethod.POST)
	public @ResponseBody Message getmasteransbyquestion(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("40", map, null, request, response);
		return message;
	}

	/**
	 * To get master ques by study id
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
	@ApiOperation(value = "/master/question/get/all", notes = "To get master ques by study id")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	@RequestMapping(value = "/master/question/get/all", method = RequestMethod.POST)
	public @ResponseBody Message getmasterquesbystudyid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("41", map, null, request, response);
		return message;
	}

	/**
	 * To Update the Vendor Name in Study Files
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
	@ApiOperation(value = "/study/update", notes = "To Update the Vendor Name Study Files")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "study_id", value = "Requires the study id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "vendor_name", value = "Requires the vendor name", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/update", method = RequestMethod.POST)
	public @ResponseBody Message studyUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("64", map, null, request, response);
		return message;
	}

	/**
	 * To insert master level
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
	@ApiOperation(value = "/master/level/insert", notes = "To insert master level")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "level", value = "Requires the level", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/level/insert", method = RequestMethod.POST)
	public @ResponseBody Message masterLevelInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("65", map, null, request, response);
		return message;
	}

	/**
	 * To update master level
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
	@ApiOperation(value = "/master/level/update", notes = "To update master level")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "level_id", value = "Requires the level id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "level", value = "Requires the level", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/level/update", method = RequestMethod.POST)
	public @ResponseBody Message masterLevelUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("66", map, null, request, response);
		return message;
	}

	/**
	 * To delete master level
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
	@ApiOperation(value = "/master/level/delete", notes = "To delete master level")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "level_id", value = "Requires the level id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/level/delete", method = RequestMethod.POST)
	public @ResponseBody Message masterLevelDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("67", map, null, request, response);
		return message;
	}

	/**
	 * To get all master level
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
	@ApiOperation(value = "/master/level/get/all", notes = "To get all master level")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })
	@RequestMapping(value = "/master/level/get/all", method = RequestMethod.POST)
	public @ResponseBody Message masterLevelGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("68", map, null, request, response);
		return message;
	}

	/**
	 * To delete master category
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
	@ApiOperation(value = "/master/category/delete", notes = "To delete master category")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "category_id", value = "Requires the category id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/category/delete", method = RequestMethod.POST)
	public @ResponseBody Message masterCategoryDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("69", map, null, request, response);
		return message;
	}

	/**
	 * To get all master category
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
	@ApiOperation(value = "/master/category/get/all", notes = "To get all master category")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })
	@RequestMapping(value = "/master/category/get/all", method = RequestMethod.POST)
	public @ResponseBody Message masterCategoryGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("70", map, null, request, response);
		return message;
	}

	/**
	 * To get master category by level id.
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
	@ApiOperation(value = "/master/category/get/by/level/id", notes = "To get master category by level id.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "level_id", value = "Requires the level id", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/category/get/by/level/id", method = RequestMethod.POST)
	public @ResponseBody Message masterCategoryGetByLevelId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("71", map, null, request, response);
		return message;
	}

	/**
	 * To insert master category.
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
	@ApiOperation(value = "/master/category/insert", notes = "To insert master category.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "category", value = "Requires the category", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "level_id", value = "Requires the level id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort order.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/category/insert", method = RequestMethod.POST)
	public @ResponseBody Message masterCategoryInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("72", map, null, request, response);
		return message;
	}

	/**
	 * To update master category.
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
	@ApiOperation(value = "/master/category/update", notes = "To update master category.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "category_id", value = "Requires the category id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "category", value = "Requires the category", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort order.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/category/update", method = RequestMethod.POST)
	public @ResponseBody Message masterCategoryUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("73", map, null, request, response);
		return message;
	}

	/**
	 * To delete master subcategory.
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
	@ApiOperation(value = "/master/subcategory/delete", notes = "To delete master subcategory.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "subcategory_id", value = "Requires the subcategory id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_deleted", value = "Requires the is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/subcategory/delete", method = RequestMethod.POST)
	public @ResponseBody Message masterSubcategoryDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("74", map, null, request, response);
		return message;
	}

	/**
	 * To insert master subcategory.
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
	@ApiOperation(value = "/master/subcategory/insert", notes = "To insert master subcategory.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "subcategory", value = "Requires the subcategory.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "category_id", value = "Requires the category id.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort order.", required = true, access = "query", paramType = "query", dataType = "String") })
	@RequestMapping(value = "/master/subcategory/insert", method = RequestMethod.POST)
	public @ResponseBody Message masterSubcategoryInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("75", map, null, request, response);
		return message;
	}

	/**
	 * To update master subcategory.
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
	@ApiOperation(value = "/master/subcategory/update", notes = "To update master subcategory.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "subcategory_id", value = "Requires the subcategory id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subcategory", value = "Requires the subcategory", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort order.", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/master/subcategory/update", method = RequestMethod.POST)
	public @ResponseBody Message masterSubcategoryUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("76", map, null, request, response);
		return message;
	}

	/**
	 * To get master subcategory.
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
	@ApiOperation(value = "/master/subcategory/get", notes = "To get master subcategory.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	@RequestMapping(value = "/master/subcategory/get", method = RequestMethod.POST)
	public @ResponseBody Message masterSubcategoryGet(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("78", map, null, request, response);
		return message;
	}

	/**
	 * To download the config File contains ftp details.
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
	@ApiOperation(value = "/org/config/download", notes = "To download the config Fil contains ftp details.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires the org id", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/org/config/download", method = RequestMethod.POST)
	public @ResponseBody Message orgConfigDownload(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {
		Message message = downloadService.downloadOrgConfig(map, request, response);

		// Message message = genericProcess.GenericProcedureCalling("1", map,
		// null, request, response);
		return message;
	}

	/**
	 * To insert study queue.
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
	@ApiOperation(value = "/study/queue/insert", notes = "To insert study queue.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires the organization id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study id", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/study/queue/insert", method = RequestMethod.POST)
	public @ResponseBody Message studyQueueInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("80", map, null, request, response);
		return message;
	}

	/**
	 * To insert study queue.
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
	@ApiOperation(value = "/is/job/in/processing", notes = "To check is job in processing.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "org_id", value = "Requires the organization id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "study_id", value = "Requires the study id", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/is/job/in/processing", method = RequestMethod.POST)
	public @ResponseBody Message isjobinprocessing(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("81", map, null, request, response);
		return message;
	}

	/**
	 * To insert study queue.
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
	@ApiOperation(value = "/category/sort/order/update", notes = "To update category sort order")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "category_id", value = "Requires the category id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort_order", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/category/sort/order/update", method = RequestMethod.POST)
	public @ResponseBody Message categorysortorderupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("85", map, null, request, response);
		return message;
	}

	/**
	 * To insert study queue.
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
	@ApiOperation(value = "/subcategory/sort/order/update", notes = "To update subcategory sort order")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "subcategory_id", value = "Requires the subcategory id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort_order", required = true, access = "query", paramType = "query", dataType = "String") })

	@RequestMapping(value = "/subcategory/sort/order/update", method = RequestMethod.POST)
	public @ResponseBody Message subcategorysortorderupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("86", map, null, request, response);
		return message;
	}

	/**
	 * To get all active level in master data.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@ApiOperation(value = "/master/active/level/get/all", notes = "To get all active level in master data.", response = MasterActiveLevelGetAllSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })
	
	@RequestMapping(value = "/master/active/level/get/all", method = RequestMethod.POST)
	public @ResponseBody Message masterActiveLevelGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("88", map, null, request, response);
		return message;
	}

	/**
	 * To get active category in master data by level id.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@ApiOperation(value = "/master/active/category/get/by/level/id", notes = "To get active category in master data by level id.", response = MasterActiveCategoryGetByLevelIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "level_id", value = "Requires level id.", required = true, access = "query", paramType = "query", dataType = "String") })
	
	@RequestMapping(value = "/master/active/category/get/by/level/id", method = RequestMethod.POST)
	public @ResponseBody Message masterActiveCategoryGetByLevelId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("89", map, null, request, response);
		return message;
	}

	/**
	 * To get all active subcategory in master data.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@ApiOperation(value = "/master/active/subcategory/get/all", notes = "To get all active subcategory in master data.", response = MasterActiveSubcategoryGetAllSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })
	
	@RequestMapping(value = "/master/active/subcategory/get/all", method = RequestMethod.POST)
	public @ResponseBody Message masterActiveSubcategoryGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("90", map, null, request, response);
		return message;
	}
	
	/**
	 * To get if study is active or inactive on desktop application.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@ApiOperation(value = "/study/active/inactive", notes = "To get if study is active or inactive on desktop application.", response = OrganizationDeleteSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "study_id", value = "Token is generated to authenticate user to access API.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_deleted", value = "Token is generated to authenticate user to access API.", required = true, access = "query", paramType = "query", dataType = "String") })
	
	@RequestMapping(value = "/study/active/inactive", method = RequestMethod.POST)
	public @ResponseBody Message studyActiveInactive(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("92", map, null, request, response);
		return message;
	}
}