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
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.ActiveAnswerGroupGetAllSwagger;
import com.springiot.swagger.response.CityGetByStateIdSwagger;
import com.springiot.swagger.response.GetRefAnswersByQuestionIdSwagger;

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
 *
 */
@Controller
public class AnswerGroupController {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * To get answer by answer group id
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

	@ApiOperation(value = "/answer/get/by/answer/group/id", notes = "To get answer  by answer group id", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "answer_group_id", value = "Requires answer_group_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/get/by/answer/group/id", method = RequestMethod.POST)
	public @ResponseBody Message answergetbyanswergroupid(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("51", map, null, request, response);
		return message;
	}

	/**
	 * To delete answer from group answer
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

	@ApiOperation(value = "/answer/group/answer/delete", notes = "To delete answer from group answer  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_deleted", value = "Requires is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/answer/delete", method = RequestMethod.POST)
	public @ResponseBody Message answergroupanswerdelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("52", map, null, request, response);
		return message;
	}

	/**
	 * To update answer group answer
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

	@ApiOperation(value = "/answer/group/answer/update", notes = "To update answer group answer ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_code", value = "Requires answer_code", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_text", value = "Requires answer_text", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group1", value = "Requires the group1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group2", value = "Requires the group2", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_group_id", value = "Requires the answer_group_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ref_question_code", value = "Requires the ref question code.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ref_answer_code", value = "Requires the ref answer code.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires the sort order.", required = true, access = "query", paramType = "query", dataType = "String") })
	
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/answer/update", method = RequestMethod.POST)
	public @ResponseBody Message answergroupanswerupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("53", map, null, request, response);
		return message;
	}

	/**
	 * To delete answer group
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

	@ApiOperation(value = "/answer/group/delete", notes = "To delete answer group  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_deleted", value = "Requires is deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/delete", method = RequestMethod.POST)
	public @ResponseBody Message answergroupdelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("54", map, null, request, response);
		return message;
	}

	/**
	 * To get all answer group
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

	@ApiOperation(value = "/answer/group/get/all", notes = "To get all answer group  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/get/all", method = RequestMethod.POST)
	public @ResponseBody Message answergroupgetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("55", map, null, request, response);
		return message;
	}

	/**
	 * To insert answer group
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

	@ApiOperation(value = "/master/answer/group/answer/insert", notes = "To insert answer group ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "answer_group_id", value = "Requires answer_group_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_group", value = "Requires answer_group", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_code", value = "Requires answer_code", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_text", value = "Requires the answer_text", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group1", value = "Requires the group1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "group2", value = "Requires the group2", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ref_question_code", value = "Requires ref question code.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "ref_answer_code", value = "Requires ref answer code.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires sort order", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "is_derived", value = "Requires is derived bit.", required = true, access = "header", paramType = "header", dataType = "String") })
	
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/answer/group/answer/insert", method = RequestMethod.POST)
	public @ResponseBody Message answergroupinsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("56", map, null, request, response);
		return message;
	}

	/**
	 * To update answer group
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

	@ApiOperation(value = "/answer/group/update", notes = "To update answer group  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_group", value = "Requires answer_group", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/update", method = RequestMethod.POST)
	public @ResponseBody Message answergroupupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("57", map, null, request, response);
		return message;
	}

	/**
	 * To master answer group insert
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

	@ApiOperation(value = "/master/answer/group/insert", notes = "To master answer group insert ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "answer_group", value = "Requires answer_group", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/answer/group/insert", method = RequestMethod.POST)
	public @ResponseBody Message masteranswergroupinsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("58", map, null, request, response);
		return message;
	}

	/**
	 * To delete master question
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

	@ApiOperation(value = "/master/question/delete", notes = "To delete master question  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_deleted", value = "Requires is_deleted bit.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/question/delete", method = RequestMethod.POST)
	public @ResponseBody Message masterquestiondelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("59", map, null, request, response);
		return message;
	}

	/**
	 * To insert master question
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

	@ApiOperation(value = "/master/question/insert", notes = "To insert master question   ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "question_text", value = "Requires question_text", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "question_code", value = "Requires question_code", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "answer_group_id", value = "Requires answer_group_id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "question_group", value = "Requires question_group", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "subcategory_id", value = "Requires subcategory_id", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "show_to_app", value = "Requires show to app bit.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_derived", value = "Requires is derived bit.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_cwe_question", value = "Requires is cwe question.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "is_household_question", value = "Requires is household question.", required = true, access = "query", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "sort_order", value = "Requires sort order", required = true, access = "query", paramType = "query", dataType = "String") })
	
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/question/insert", method = RequestMethod.POST)
	public @ResponseBody Message masterquestioninsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("60", map, null, request, response);
		return message;
	}

	/**
	 * To update master question
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

	@ApiOperation(value = "/master/question/update", notes = "To update master question   ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Requires id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "question_text", value = "Requires question_text", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "question_code", value = "Requires question_code", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "answer_group_id", value = "Requires answer_group_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "question_group", value = "Requires question_group", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_visible", value = "Requires is_visible", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "subcategory_id", value = "Requires subcategory_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "show_to_app", value = "Requires show to app bit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_derived", value = "Requires is derived bit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_cwe_question", value = "Requires is cwe question.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_household_question", value = "Requires is household question.", required = true, access = "query", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "sort_order", value = "Requires sort order", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/question/update", method = RequestMethod.POST)
	public @ResponseBody Message masterquestionupdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("61", map, null, request, response);
		return message;
	}

	/**
	 * To get all master subcategory
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

	@ApiOperation(value = "/master/subcategory/get/all", notes = "To get all master subcategory  ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/subcategory/get/all", method = RequestMethod.POST)
	public @ResponseBody Message mastersubcategorygetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("62", map, null, request, response);
		return message;
	}

	/**
	 * To get all limit master question
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

	@ApiOperation(value = "/master/question/get/all/limit", notes = "To get all limit master question   ", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "limit", value = "Requires limit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "offset", value = "Requires offset", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/master/question/get/all/limit", method = RequestMethod.POST)
	public @ResponseBody Message masterquestiongetalllimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("63", map, null, request, response);
		return message;
	}

	/**
	 * To get all group answer
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

	@ApiOperation(value = "/answer/group/answer/get/all", notes = "To get all group answer", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/answer/group/answer/get/all", method = RequestMethod.POST)
	public @ResponseBody Message answerGroupAnswergetall(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("77", map, null, request, response);
		return message;
	}

	/**
	 * To get all group answer
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

	@ApiOperation(value = "/get/ref/answer/groups", notes = "To get all group answer", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/get/ref/answer/groups", method = RequestMethod.POST)
	public @ResponseBody Message getrefanswergroups(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("82", map, null, request, response);
		return message;
	}

	/**
	 * To get all group answer
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
	@ApiOperation(value = "/get/ref/question", notes = "To get all group answer", response = CityGetByStateIdSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/get/ref/question", method = RequestMethod.POST)
	public @ResponseBody Message getrefquestion(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("83", map, null, request, response);
		return message;
	}

	/**
	 * To get all reference answers by question id.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message.
	 * @throws Exception
	 */
	@ApiOperation(value = "/get/ref/answers/by/question/id", notes = "To get all reference answers by question id.", response = GetRefAnswersByQuestionIdSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "question_code", value = "Here pass question code.", required = true, access = "query", paramType = "query", dataType = "String") })
		
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/get/ref/answers/by/question/id", method = RequestMethod.POST)
	public @ResponseBody Message getRefAnswersByQuestionId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("87", map, null, request, response);
		return message;
	}
	
	/**
	 * To get all active answer group.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header
	 * @param response : To send response
	 * @return Return the response message
	 */
	@ApiOperation(value = "/active/answer/group/get/all", notes = "To get all active answer group.", response = ActiveAnswerGroupGetAllSwagger.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "Token is generated to authenticate user to access API.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_key", value = "Requires User Key of user.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "user_id", value = "Requires user id of user for authentication.", required = true, access = "header", paramType = "header", dataType = "String"),
		@ApiImplicitParam(name = "limit", value = "Here pass limit.", required = true, access = "query", paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "offset", value = "Here pass offset.", required = true, access = "query", paramType = "query", dataType = "String") })
	
	@RequestMapping(value = "/active/answer/group/get/all", method = RequestMethod.POST)
	public @ResponseBody Message activeAnswerGroupGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) {

		Message message = genericProcess.GenericProcedureCalling("91", map, null, request, response);
		return message;
	}
}