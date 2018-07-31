package com.springiot.controllers;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springiot.response.Message;
import com.springiot.services.GrafanaServices;

@Controller
public class GrafanaController {

	@Autowired
	private GrafanaServices grafanaService;

	/**
	 * This API is base API used to add the datasource in Grafana as well as
	 * check the connectivity of the server.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/", method = RequestMethod.GET)
	public @ResponseBody Message testConnection(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */
		Message message = grafanaService.testConnection(request, response);

		return message;
	}

	@RequestMapping(value = "/**/search", method = RequestMethod.POST)
	public @ResponseBody Object findMetricOptions(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * Method getDevicesByDatatype() is called upon to get the data from
		 * respective database.
		 */

		Object message = grafanaService.findMetricOptions(request, response);

		return message;
	}

	/**
	 * This API returns the metrics based on the input after calling Platform
	 * API.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/query", method = RequestMethod.POST)

	public @ResponseBody Object returnMetrics(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Object responseObject = grafanaService.returnMetrics(request, response);

		return responseObject;
	}

	/**
	 * This API returns the annotations after calling Platform API.
	 * 
	 * @param request,HttpServletRequest
	 *            contains the incoming request
	 * @param response,HttpServletResponse
	 *            contains the response after calling API
	 * @return
	 */
	@RequestMapping(value = "/**/annotations", method = RequestMethod.POST)

	public @ResponseBody List<Map<String, Object>> annotations(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		List<Map<String, Object>> responseObject = grafanaService.annotations(request, response);

		return responseObject;
	}

}
