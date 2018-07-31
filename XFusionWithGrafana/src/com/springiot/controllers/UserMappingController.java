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

@Controller
public class UserMappingController {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This API is used to insert organization in grafana
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message organizationInsert(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("1", map, request, response);

		return message;
	}

	/**
	 * This API is used to insert organization in grafana on the basis of user
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/user/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message userOrganizationInsert(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("2", map, request, response);

		return message;
	}

	/**
	 * This API is used to delete the respective user
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/user/delete", method = RequestMethod.POST)
	public @ResponseBody Message userDelete(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("3", map, request, response);

		return message;
	}

	/**
	 * This API is used to delete the respective user
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/user/update/organizations", method = RequestMethod.POST)
	public @ResponseBody Message userUpdateOrganizations(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("4", map, request, response);

		return message;
	}

	/**
	 * This API is used to update the organization
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/update/organization", method = RequestMethod.POST)
	public @ResponseBody Message updateOrganization(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("5", map, request, response);

		return message;
	}

	/**
	 * This API is used to delete the organization
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/delete/organization", method = RequestMethod.POST)
	public @ResponseBody Message deleteOrganizations(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("6", map, request, response);

		return message;
	}

	/**
	 * This API is used to retrieve roles of users
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/grafana/user/get/roles", method = RequestMethod.POST)
	public @ResponseBody Message userGetRoles(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("7", map, request, response);

		return message;
	}
}
