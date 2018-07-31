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
import com.springiot.response.Message;
import com.springiot.services.GrafanaService;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class is a controller for connecting Gateway with
 *         xFusion Api's.
 */

@ApiIgnore
@Controller
public class GrafanaAPIController {

	@Autowired
	private GrafanaService grafanaServices;

	@RequestMapping(value = "/grafana/**/", method = { RequestMethod.POST, RequestMethod.GET })
	public @ResponseBody Message xfusionSettingsGrafana(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = grafanaServices.callGrafanaAPIs(map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
	//
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
}
