/**
 * This package contain the class which is used specifically for Rule Engine.
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

import com.springiot.controllers.ignoreControllers.RuleEngineControllerCUD;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;

import com.springiot.swagger.response.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Garima Joshi This class work as a controller which is used to create
 *         apis for data required for rule engine.
 */
@Controller
@Api(value = "/", description = "For all device details requires for rule engine")
public class RuleEngineController extends RuleEngineControllerCUD {
	/**
	 * To access functionality of following Class methods
	 */
	@Autowired
	private GenericProcess genericProcess;

	

	/**
	 * To get model services of user's device in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/get/model/services", notes = "To get model services of user's device in rule engine", response = RuleEngineDeviceGetModelServicesSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_model_id", value = "Requies the devicetype id"), })

	@RequestMapping(value = "/rule/engine/device/get/model/services", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceGetModelServices(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("346", map, request, response);
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
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/rule/engine/user/device/get/model", notes = "To get model devices of user's device in rule engine", response = RuleEngineUserDeviceGetModelSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_type_id", value = "Requies the devicetype id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/user/device/get/model", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineUserDeviceGetModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("347", map, request, response);
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
	 * @param HttpServletRequest,this
	 *            is required for the headers in the API while calling.
	 * @param HttpServletResponse,this
	 *            is required for the headers in the API while calling.
	 * @return message, Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/rule/engine/device/get/by/model", notes = "To get model devices of user's device in rule engine", response = RuleEngineDeviceGetByModelSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_model_id", value = "Requies the devicetype id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/get/by/model", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceGetByModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("348", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get model service and data source of device in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/get/model/service/datasource", notes = "To get model service and data source of device in rule engine", response = RuleEngineDeviceGetModelServiceDatasourceSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_model_id", value = "Requies the devicetype id"),
			@ApiImplicitParam(name = "service_id", value = "Requies the service id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/get/model/service/datasource", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceGetModelServiceDatasource(
			@ApiIgnore @RequestParam Map<String, String> map, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("350", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get action list in rule engine.
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
	@ApiOperation(value = "/rule/engine/rule/get/action", notes = "To get action list in rule engine", response = RuleEngineRuleGetActionSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "global_user_id", value = "Requies the global user ID"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/rule/get/action", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineRuleGetAction(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("351", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get action parameters of device in rule engine.
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
	@ApiOperation(value = "/rule/engine/rule/get/action/parameter", notes = "To get action parameters of device in rule engine", response = RuleEngineRuleGetActionParameterSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "action_type_id", value = "Requies the action type id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/rule/get/action/parameter", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineRuleGetActionParameter(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("352", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get severity of user's device in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/get/severity", notes = "To get severity of user's device in rule engine", response = RuleEngineDeviceGetSeveritySwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_model_id", value = "Requies the device model id"),
			@ApiImplicitParam(name = "service_id", value = "Requies the service id"),
			@ApiImplicitParam(name = "datasource_id", value = "Requies the datasource id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/get/severity", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceGetSeverity(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("353", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get rules of device type in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/type/get/rules", notes = "To get rules of device type in rule engine", response = RuleEngineDeviceTypeGetRulesSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "devicetype_id", value = "Requies the device type id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/type/get/rules", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceTypeGetRules(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("354", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get count of rules for device type in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/type/get/rules/count", notes = "To get count of rules for device type in rule engine", response = InventoryMonthlyDeviceGetManyCountSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user ID"),
			@ApiImplicitParam(name = "device_type_id", value = "Requires the device type id"),
			@ApiImplicitParam(name = "is_correlated ", value = "Requires the check bit is correlated or not"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition for Server Side Filtering"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/type/get/rules/count", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceTypeGetRulesCount(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("355", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get all the rule with defined with limit in rule engine.
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
	@ApiOperation(value = "/rule/engine/device/type/get/rules/limit", notes = "To get all the rule with defined with limit in rule engine", response = RuleEngineDeviceTypeGetRulesLimitSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "UserKey"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "device_type_id", value = "Requies the device type id"),
			@ApiImplicitParam(name = "limit", value = "Requies the limit"),
			@ApiImplicitParam(name = "offset", value = "Requies the offset"),
			@ApiImplicitParam(name = "is_correlated", value = "Requies the check bit is correlated or not"),
			@ApiImplicitParam(name = "in_condition ", value = "Requires the condition for Server Side Filtering"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/engine/device/type/get/rules/limit", method = RequestMethod.POST)
	public @ResponseBody Message ruleEngineDeviceTypeGetRulesLimit(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("356", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the sub rule in rule engine.
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
	@ApiOperation(value = "/rule/get/sub/rule", notes = "To get the sub rule in rule engine", response = RuleGetSubRuleSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "rule_id", value = "Requies the rule id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/get/sub/rule", method = RequestMethod.POST)
	public @ResponseBody Message ruleGetSubRule(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("398", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get the sub rule in rule engine.
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
	@ApiOperation(value = "/action/get/action", notes = "To get the sub rule in rule engine", response = ActionGetActionSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/action/get/action", method = RequestMethod.POST)
	public @ResponseBody Message ruleGetAction(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("402", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get rule on basis of rule id in rule engine.
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
	@ApiOperation(value = "/rule/device/get/by/rule/id", notes = " To get rule on basis of rule id in rule engine", response = RuleDeviceGetByRuleIdSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "rule_id", value = "Requies the rule id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/device/get/by/rule/id", method = RequestMethod.POST)
	public @ResponseBody Message RuleDeviceGetByRuleId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("409", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To get rule on basis of global rule id in rule engine.
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
	@ApiOperation(value = "/rule/get/rules/by/global/rule/id", notes = " To get rule on basis of global rule id in rule engine", response = RuleGetRulesByGlobalRuleIdSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requies the user ID"),
			@ApiImplicitParam(name = "global_rule_id", value = "Requies the rule id"), })

	@ApiResponses(value = { @ApiResponse(code = 201, message = "Get The Response Code", response = Message.class) })
	@RequestMapping(value = "/rule/get/rules/by/global/rule/id", method = RequestMethod.POST)
	public @ResponseBody Message ruleDeviceGetRulesByGlobalRuleId(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("411", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}
}
