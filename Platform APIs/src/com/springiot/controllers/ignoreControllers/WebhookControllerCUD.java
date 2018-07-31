/**
 * This package contains the class which is used as a controller to create apis for webhooks.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.HsqlService;
import com.springiot.swagger.response.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for webhooks.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
@SuppressWarnings({ "static-access", "unused", "unchecked" })
public class WebhookControllerCUD {

	/**
	 * To access functionality of following service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private HsqlService hsqlService;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	/**
	 * Insert the webhook specific events
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * 
	 * @return message, Return the response message
	 */

	@ApiOperation(value = "/webhook/insert/event", notes = "Insert the webhook specific events", response = WebhookUpdateEventSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"),
			@ApiImplicitParam(name = "webhook_name", value = "Requires the name of webhook"),
			@ApiImplicitParam(name = "webhook_description", value = "Requires the description of webhook"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requires the global rule id"),
			@ApiImplicitParam(name = "webhook_category", value = "Requires the category of webhook"),
			@ApiImplicitParam(name = "payload_destination_id", value = "Requires the payload destination id"),
			@ApiImplicitParam(name = "payload_destination_parameter_key", value = "Requires the palyload destination parameter key"),
			@ApiImplicitParam(name = "payload_destination_parameter_value", value = "Requires the payload destination parameter value"), })

	@RequestMapping(value = "/webhook/insert/event", method = RequestMethod.POST)
	public @ResponseBody Message webhookInsertEvents(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("428", map, request, response);

		if (message.isValid()) {

			Object iotHubDetails = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("432").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"), map.get("global_rule_id"), "Publisher");

			String ruleId = map.get("global_rule_id").toString();
			List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;

			for (int i = 0; i < iotHubMap.size(); i++) {

				if (iotHubMap.get(i).get("hsql_connection") != null) {
					String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','update',now(),"
							+ ruleId + ");";

					Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
							iotHubMap.get(i).get("hsql_connection").toString(), query);

				} else {
					System.out.println("Hsql Connection is null");
				}

			}
		}

		// Return the response message.
		return message;

	}

	/**
	 * Update the webhook specific events
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/webhook/update/event", notes = "Update the webhook specific events", response = WebhookUpdateEventSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"),
			@ApiImplicitParam(name = "webhook_name", value = "Requires the name of webhook"),
			@ApiImplicitParam(name = "webhook_description", value = "Requires the description of webhook"),
			@ApiImplicitParam(name = "payload_destination_id", value = "Requires the payload destination id"),
			@ApiImplicitParam(name = "payload_destination_parameter_key", value = "Requires the palyload destination parameter key"),
			@ApiImplicitParam(name = "payload_destination_parameter_value", value = "Requires the payload destination parameter value"),
			@ApiImplicitParam(name = "webhook_event_id", value = "Requires the webhook event id"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requires the global rule id"), })
	@RequestMapping(value = "/webhook/update/event", method = RequestMethod.POST)
	public @ResponseBody Message webhookUpdateEvents(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("429", map, request, response);

		if (message.isValid()) {

			Object iotHubDetails = genericService.executeProcesureFromMetaData(null,
					processParameter.getMaps().get("432").toString(), request.getHeader("user_key"),
					request.getHeader("user_id"), map.get("global_rule_id"), "Publisher");

			List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;

			for (int i = 0; i < iotHubMap.size(); i++) {

				String ruleId = map.get("global_rule_id").toString();
				if (iotHubMap.get(i).get("hsql_connection") != null) {
					String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','update',now(),"
							+ ruleId + ");";

					Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
							iotHubMap.get(i).get("hsql_connection").toString(), query);

				} else {
					System.out.println("Hsql Connection is null");
				}

			}
		}

		// Return the response message.
		return message;

	}

	/**
	 * Delete the webhook specific events
	 * 
	 * @param map,
	 *            Contains all the input parameters specified by user.
	 * 
	 * @return message, Return the response message
	 */
	@ApiOperation(value = "/webhook/delete/event", notes = "Delete the webhook specific events", response = WebhookUpdateEventSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"),
			@ApiImplicitParam(name = "webhook_event_id", value = "Requires the webhook event id"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requires the global rule id"), })
	@RequestMapping(value = "/webhook/delete/event", method = RequestMethod.POST)
	public @ResponseBody Message webhookDeleteEvents(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */

		Object iotHubDetails = genericService.executeProcesureFromMetaData(null,
				processParameter.getMaps().get("432").toString(), request.getHeader("user_key"),
				request.getHeader("user_id"), map.get("global_rule_id"), "Publisher");

		List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;
		String ruleId = map.get("global_rule_id").toString();
		for (int i = 0; i < iotHubMap.size(); i++) {

			if (iotHubMap.get(i).get("hsql_connection") != null) {
				String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','update',now(),"
						+ ruleId + ");";

				Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
						iotHubMap.get(i).get("hsql_connection").toString(), query);

			} else {
				System.out.println("Hsql Connection is null");
			}

		}
		Message message = genericProcess.GenericProcedureCallingMetaData("430", map, request, response);

		// }
		// Return the response message.
		return message;

	}
}
