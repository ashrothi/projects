/**
 * This package contain the class which is used specifically for Rule Engine.
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
import com.google.gson.Gson;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.HsqlService;
import com.springiot.services.IoTPublisherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for rule engine.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
@SuppressWarnings({ "unchecked", "static-access", "unused" })
public class RuleEngineControllerCUD {
	/**
	 * To access functionality of following Class methods
	 */
	@Autowired
	private GenericProcess genericProcess;
	/**
	 * To access functionality of GenericService Class.
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private HsqlService hsqlService;

	@Autowired
	private ProcessParameter processParameter;

	@Autowired
	private IoTPublisherService iotpublisher;

	/**
	 * To add new rule in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/rule/engine/add/rule", notes = "To add new rule in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requies the global rule id"),
			@ApiImplicitParam(name = "name", value = "Requies the name"),
			@ApiImplicitParam(name = "service_id ", value = "Requies the severity id"),
			@ApiImplicitParam(name = "service_name", value = "Requies the service name"),
			@ApiImplicitParam(name = "data_source_id ", value = "Requies the datasource id"),
			@ApiImplicitParam(name = "data_source_name", value = "Requies the data source name"),
			@ApiImplicitParam(name = "trigger_method", value = "Requies the trigger method"),
			@ApiImplicitParam(name = "value_under", value = "Requies the value under"),
			@ApiImplicitParam(name = "value_over", value = "Requies the value over"),
			@ApiImplicitParam(name = "value_from", value = "Requies the value from"),
			@ApiImplicitParam(name = "value_to", value = "Requies the value to"),
			@ApiImplicitParam(name = "value_equal", value = "Requies the value equal"),
			@ApiImplicitParam(name = "alarm_age", value = "Requies the alarm age"),
			@ApiImplicitParam(name = "description", value = "Requies the description"),
			@ApiImplicitParam(name = "is_in_conditional", value = "Requies the conditional"),
			@ApiImplicitParam(name = "alert", value = "Requies the alert"),
			@ApiImplicitParam(name = "devicemodel_id", value = "Requies the devicemodel id"),
			@ApiImplicitParam(name = "device_ids", value = "Requies the device ids"),
			@ApiImplicitParam(name = "rule_order", value = "Requies the rule order"),
			@ApiImplicitParam(name = "operator", value = "Requies the operator"),
			@ApiImplicitParam(name = "severity_id ", value = "Requies the severity id"),
			@ApiImplicitParam(name = "severity", value = "Requies the severity"),
			@ApiImplicitParam(name = "severity_colour ", value = "Requies the severity colour"),
			@ApiImplicitParam(name = "severity_priority ", value = "Requies the severity priority"),
			@ApiImplicitParam(name = "is_correlated ", value = "Requies the check bit is correlated or not"),
			@ApiImplicitParam(name = "rule_type", value = "Requies the rule type"),
			@ApiImplicitParam(name = "latitude ", value = "Requies the latitude"),
			@ApiImplicitParam(name = "longitude ", value = "Requies the longitude"),
			@ApiImplicitParam(name = "sequence", value = "Requies the sequence") })

	@RequestMapping(value = "/rule/engine/add/rule", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineAddrule(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Message iotHubMessage = new Message();
		Message message = new Message();
		try {

			message = genericProcess.GenericProcedureCallingMetaData("344", map, request, response);

			// System.out.println(" ruleDetails *********" + ruleDetails);
			if (message.isValid()) {

				List<Map<String, Object>> ruleDetails = (List<Map<String, Object>>) message.getObject();

				Object iotHubDetails = genericService.executeProcesureFromConfig(null,
						processParameter.getMaps().get("422").toString(), map.get("device_ids"), "Publisher",
						request.getHeader("user_key"), request.getHeader("user_id"));

				// System.out.println("iot hub details" + iotHubDetails);

				List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;

//				System.out.println("iotHubMap" + iotHubMap);

				for (int i = 0; i < iotHubMap.size(); i++) {

					// System.out.println(iotHubMap.size());

					if (iotHubMap.get(i).get("hsql_connection") != null) {
						String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','insert',now(),'')";

//						System.out.println("query is" + iotHubMap.get(i).get("hsql_connection").toString());

						Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
								iotHubMap.get(i).get("hsql_connection").toString(), query);

//						System.out.println("********************** " + messageHsqlDetails.getObject().toString());
					} else {
						System.out.println("Hsql Connection is null");
					}
				}
				/***
				 * For rule data to be pushed in IoT hub and then mqtt for data
				 * insert.
				 * 
				 */
				int ruleType = Integer.parseInt(map.get("rule_type"));
				/*
				 * Check if rule is for geofencing only for which the rule type
				 * is 1.
				 */
				if (ruleType == 1) {
					/*
					 * Call the method which will return the rule details.
					 */

					String ruleId = "";
					for (int i = 0; i < ruleDetails.size(); i++) {
						ruleId = ruleDetails.get(i).get("ID").toString();
						// System.out.println("ruleId " + ruleId);
					}

					Object dataPacket = genericService.executeProcesureFromMetaData(null,
							processParameter.getMaps().get("456").toString(), request.getHeader("user_key"),
							request.getHeader("user_id"), ruleId);
					/*
					 * Convert the data in formatted json and add additional
					 * parameter which will notify status.
					 */
					if (dataPacket != null) {
						String finalJson = new Gson().toJson(dataPacket).toString().replace("}]",
								", \"status\":\"insert\"}]");
						/*
						 * Call the method which will publish data in iot hub
						 * kafka topic.
						 */
						System.out.println(finalJson);

						iotHubMessage = iotpublisher.rulePublisher(finalJson);

//						System.out.println("iotHubMessage- " + iotHubMessage);

					} else {
						return message;
					}
				}

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		if (iotHubMessage.isValid()) {
			/*
			 * Return the response message.
			 */

			return iotHubMessage;
		} else {
			return message;
		}
	}

	/**
	 * To add new severity of device in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/rule/engine/device/add/severity", notes = "To add new severity of device in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_model_id", value = "Requies the devicemodel id"),
			@ApiImplicitParam(name = "service_name", value = "Requies the service name"),
			@ApiImplicitParam(name = "service_id", value = "Requies the service id"),
			@ApiImplicitParam(name = "datasource_id", value = "Requies the datasource id"),
			@ApiImplicitParam(name = "datasource_name", value = "Requies the datasource name"),
			@ApiImplicitParam(name = "severity_name", value = "Requies the severity name"),
			@ApiImplicitParam(name = "severity_priority", value = "Requies the severity priority"),
			@ApiImplicitParam(name = "severity_colour_code", value = "Requies the severity colour code") })

	@RequestMapping(value = "/rule/engine/device/add/severity", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceAddSeverity(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("345", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To get model devices of user's device in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/rule/engine/device/add/action", notes = "To add action of device in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requies the global rule id"),
			@ApiImplicitParam(name = "action_type_id", value = "Requies the action type id"),
			@ApiImplicitParam(name = "action_type_name", value = "Requies the action type name"),
			@ApiImplicitParam(name = "action_type_parameter_name", value = "Requies the action_type parameter name"),
			@ApiImplicitParam(name = "action_type_parameter_value", value = "Requies the action type parameter value"),
			@ApiImplicitParam(name = "action_user_ids", value = "Requies the action_user_ids"),
			@ApiImplicitParam(name = "action_phone", value = "Requies the action phone"),
			@ApiImplicitParam(name = "action_duration", value = "Requies the action duration"),
			@ApiImplicitParam(name = "organization_id", value = "Requies the organization id") })

	@RequestMapping(value = "/rule/engine/device/add/action", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceAddAction(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Object iotHubDetails = genericService.executeProcesureFromMetaData(null,
				processParameter.getMaps().get("432").toString(), request.getHeader("user_key"),
				request.getHeader("user_id"), map.get("global_rule_id"), "Publisher");

		// System.out.println("iot hub details" + iotHubDetails);

		List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;
		String ruleId = map.get("global_rule_id").toString() == null ? " "
				: map.get("global_rule_id").trim().toString();

		for (int i = 0; i < iotHubMap.size(); i++) {

			// System.out.println(iotHubMap.size());

			if (iotHubMap.get(i).get("hsql_connection") != null) {
				// String ruleId = map.get("rule_id").toString() == null ? "
				// " : map.get("rule_id").trim().toString();

				String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','update_action',now(),"
						+ ruleId + ");";

				// System.out.println("query is" + query);

				Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
						iotHubMap.get(i).get("hsql_connection").toString(), query);

				// System.out.println(messageHsqlDetails);
			} else {
				System.out.println("Hsql Connection is null");
			}

		}

		Message message = genericProcess.GenericProcedureCallingMetaData("349", map, request, response);

		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To delete the rule in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/rule/engine/rule/delete/rule", notes = "To delete the rule in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "rule_id", value = "Requies the rule id") })

	@RequestMapping(value = "/rule/engine/rule/delete/rule", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineRuleDeleteRule(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Object iotHubDetails = genericService.executeProcesureFromMetaData(null,
				processParameter.getMaps().get("432").toString(), request.getHeader("user_key"),
				request.getHeader("user_id"), map.get("rule_id"), "Publisher");

		// System.out.println("iot hub details" + iotHubDetails);

		List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;

		String ruleId = map.get("rule_id").toString() == null ? " " : map.get("rule_id").trim().toString();

		for (int i = 0; i < iotHubMap.size(); i++) {

			// System.out.println(iotHubMap.size());

			if (iotHubMap.get(i).get("hsql_connection") != null) {
				// String ruleId = map.get("rule_id").toString() == null ? "
				// " : map.get("rule_id").trim().toString();

				String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','delete',now(),"
						+ ruleId + ");";

				// System.out.println("query is" + query);

				Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
						iotHubMap.get(i).get("hsql_connection").toString(), query);

				// System.out.println(messageHsqlDetails);
			} else {
				System.out.println("Hsql Connection is null");
			}

		}

		Message message = genericProcess.GenericProcedureCallingMetaData("357", map, request, response);

		// System.out.println("message" + message);
		/***
		 * For rule data to be pushed in IoT hub and then mqtt for data delete.
		 * 
		 */
		/*
		 * Create the data in formatted json and add additional parameter which
		 * will notify status.
		 */
		String finalJson = "[{\"global_rule_id\":" + ruleId + ", \"status\":\"delete\"}]";
		/*
		 * Call the method which will publish data in iot hub kafka topic.
		 */
		iotpublisher.rulePublisher(finalJson);

		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To add new rule in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/rule/update/rule", notes = "To add new rule in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "rule_id", value = "Requies the rule id"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requies the global rule id"),
			@ApiImplicitParam(name = "name", value = "Requies the name"),
			@ApiImplicitParam(name = "service_id", value = "Requies the severity id"),
			@ApiImplicitParam(name = "service_name", value = "Requies the service name"),
			@ApiImplicitParam(name = "data_source_id ", value = "Requies the datasource id"),
			@ApiImplicitParam(name = "data_source_name", value = "Requies the data source name"),
			@ApiImplicitParam(name = "trigger_method", value = "Requies the trigger method"),
			@ApiImplicitParam(name = "value_under", value = "Requies the value under"),
			@ApiImplicitParam(name = "value_over", value = "Requies the value over"),
			@ApiImplicitParam(name = "value_from", value = "Requies the value from"),
			@ApiImplicitParam(name = "value_to", value = "Requies the value to"),
			@ApiImplicitParam(name = "value_equal", value = "Requies the value equal"),
			@ApiImplicitParam(name = "alarm_age", value = "Requies the alarm age"),
			@ApiImplicitParam(name = "description", value = "Requies the description"),
			@ApiImplicitParam(name = "is_in_conditional", value = "Requies the conditional"),
			@ApiImplicitParam(name = "is_alert", value = "Requies the alert"),
			@ApiImplicitParam(name = "devicemodel_id", value = "Requies the devicemodel id"),
			@ApiImplicitParam(name = "device_ids", value = "Requies the device ids"),
			@ApiImplicitParam(name = "rule_order", value = "Requies the rule order"),
			@ApiImplicitParam(name = "operator", value = "Requies the operator"),
			@ApiImplicitParam(name = "severity_id ", value = "Requies the severity id"),
			@ApiImplicitParam(name = "severity", value = "Requies the severity"),
			@ApiImplicitParam(name = "severity_colour ", value = "Requies the severity colour"),
			@ApiImplicitParam(name = "severity_priority ", value = "Requies the severity priority"),
			@ApiImplicitParam(name = "is_correlated", value = "Requies the bit for rule that is correlated"),
			@ApiImplicitParam(name = "rule_type", value = "Requies the rule type"),
			@ApiImplicitParam(name = "latitude ", value = "Requies the latitude"),
			@ApiImplicitParam(name = "longitude ", value = "Requies the longitude"),
			@ApiImplicitParam(name = "sequence", value = "Requies the sequence") })

	@RequestMapping(value = "/rule/update/rule", method = RequestMethod.POST)
	public @ResponseBody Message ruleUpdateRule(@RequestParam Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("399", map, request, response);

		if (message.isValid()) {
			List<Map<String, Object>> ruleDetails = (List<Map<String, Object>>) message.getObject();
			// System.out.println(" ruleDetails *********" + ruleDetails);

			Object iotHubDetails = genericService.executeProcesureFromConfig(null,
					processParameter.getMaps().get("422").toString(), map.get("device_ids"), "Publisher",
					request.getHeader("user_key"), request.getHeader("user_id"));

			// System.out.println("iot hub details" + iotHubDetails);

			List<Map<String, Object>> iotHubMap = (List<Map<String, Object>>) iotHubDetails;

			String ruleId = map.get("rule_id").toString() == null ? " " : map.get("rule_id").trim().toString();

			for (int i = 0; i < iotHubMap.size(); i++) {

				if (iotHubMap.get(i).get("hsql_connection") != null) {

					String query = "insert into rulestatus (change_status,change_discription,update_date,rule_id) values('1','update',now(),"
							+ ruleId + ");";

					// System.out.println("query is" + query);
					Message messageHsqlDetails = hsqlService.update("org.hsqldb.jdbc.JDBCDriver",
							iotHubMap.get(i).get("hsql_connection").toString(), query);

					// System.out.println(messageHsqlDetails);

				} else {
					System.out.println("Hsql connection is null");
				}
				/***
				 * For rule data to be pushed in IoT hub and then mqtt for data
				 * update.
				 * 
				 */

				int ruleType = Integer.parseInt(map.get("rule_type"));
				/*
				 * Check if rule is for geofencing only for which the rule type
				 * is 1.
				 */
				if (ruleType == 1) {
					/*
					 * Call the methos which will return the rule details.
					 */
					Object dataPacket = genericService.executeProcesureFromMetaData(null,
							processParameter.getMaps().get("456").toString(), request.getHeader("user_key"),
							request.getHeader("user_id"), ruleId);
					/*
					 * Convert the data in formatted json and add additional
					 * parameter which will notify status.
					 */
					if (dataPacket != null) {
						String finalJson = new Gson().toJson(dataPacket).toString().replace("}]",
								", \"status\":\"update\"}]");
						/*
						 * Call the method which will publish data in iot hub
						 * kafka topic.
						 */
						iotpublisher.rulePublisher(finalJson);
					}
				} else {
					return message;
				}
			}
		}

		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * To delete rule on basis of rule id in rule engine.
	 * 
	 * @param map,
	 *            Contains all the parameters.
	 * 
	 * @return message, Return the response message
	 * @throws Exception
	 */

	@ApiOperation(value = "/rule/delete/rule/by/rule/id", notes = "To delete rule on basis of rule id in rule engine")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "rule_id", value = "Requies the rule id") })

	@RequestMapping(value = "/rule/delete/rule/by/rule/id", method = RequestMethod.POST)
	public @ResponseBody Message RuleDeleteRuleByRuleId(@RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("408", map, request, response);

		return message;

	}
}
