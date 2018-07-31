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
import com.springiot.constant.Constant;
import com.springiot.response.Message;
import com.springiot.services.DownloadServices;
import com.springiot.services.GenericProcess;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class helps to provide the user mapping APIs for BARC.
 * 
 * @author ttpl
 *
 */
@ApiIgnore
@Controller
public class UserMappingController {

	// Access the functionality of some other class.
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	private DownloadServices downloadServices;

	/**
	 * This api is used to redirect from tiny url to the respective media url
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/media/url/get", method = RequestMethod.POST)
	public @ResponseBody Message getTinyUrlToMainUrl(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("3", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to create new user
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/create/user", method = RequestMethod.POST)
	public @ResponseBody Message createUser(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("4", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to login the BARC Admin page
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/barc/user/login", method = RequestMethod.POST)
	public @ResponseBody Message loginUser(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("5", map, req, res);

		java.util.List<Map<String, Object>> responseList = (java.util.List<Map<String, Object>>) Responsemessage
				.getObject();
		// System.out.println("responseList " + responseList);
		if (responseList.get(0).get("access_token") != null) {
			String token = responseList.get(0).get("access_token").toString();

			Constant.map.put(token, responseList);
		}

		return Responsemessage;
	}

	/**
	 * This api is used to create role.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/create/role", method = RequestMethod.POST)
	public @ResponseBody Message createRole(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("7", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to retrieve all the roles
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/get/roles", method = RequestMethod.POST)
	public @ResponseBody Message getRoles(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {
		map.put("token", req.getHeader("token"));

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("8", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to retrieve all the users
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/get/users", method = RequestMethod.POST)
	public @ResponseBody Message getUsers(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		map.put("token", req.getHeader("token"));
		// System.out.println("map is" + map);
		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("9", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to delete role
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/delete/role", method = RequestMethod.POST)
	public @ResponseBody Message deleteRole(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("10", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to delete user
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/delete/user", method = RequestMethod.POST)
	public @ResponseBody Message deleteUser(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("11", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to update the user
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/update/user", method = RequestMethod.POST)
	public @ResponseBody Message update(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("12", map, req, res);

		return Responsemessage;
	}

	/**
	 * This api is used to change the password
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@RequestMapping(value = "/barc/change/password", method = RequestMethod.POST)
	public @ResponseBody Message barcChange(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("13", map, req, res);

		return Responsemessage;
	}

	@RequestMapping(value = "/barc/url/mapping/get", method = RequestMethod.POST)
	public @ResponseBody Message barcUrlMappingGet(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		Message message = downloadServices.DownloadGenericProcedureCalling(map, "16");
		return message;
	}

}
