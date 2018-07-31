/**
 * This package contain the controller class to create APIs for inventory data.
 */
package com.springiot.controllers.ignoreControllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.swagger.response.DeviceAddDeviceSwagger;

import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class includes create,update and delete APi's specific for inventory of
 * device.
 * 
 * @author tanvigarg
 *
 */
@ApiIgnore
public class DeviceInventoryControllerCUD {

	@Autowired
	private GenericProcess genericProcess;


	/**
	 * To add device inventory in database.
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

	@ApiOperation(value = "/device/add/device", notes = "To add device inventory in database", response = DeviceAddDeviceSwagger.class)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "name", value = "Requires the device key"),
			@ApiImplicitParam(name = "alias", value = "Requires the device name"),
			@ApiImplicitParam(name = "ip_address", value = "Requires the ip address of device"),
			@ApiImplicitParam(name = "lattitude", value = "Requires the latitude of device"),
			@ApiImplicitParam(name = "longitutde", value = "Requires the longitude of device"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac address of device"),
			@ApiImplicitParam(name = "description", value = "Basic description of device"),
			@ApiImplicitParam(name = "elevation", value = "elevation of device"),
			@ApiImplicitParam(name = "hardware_version", value = "Requires hardware version of device"),
			@ApiImplicitParam(name = "software_version", value = "Requires software version of device"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "device_country", value = "Requires the county of device where device is inserted"),
			@ApiImplicitParam(name = "device_state", value = "Requires state of device"),
			@ApiImplicitParam(name = "device_city", value = "Requires the city of device where device is inserted"),
			@ApiImplicitParam(name = "parent_device", value = "Hierarchial postion of device"),
			@ApiImplicitParam(name = "organization_ids", value = "Requires the device organization id"),
			@ApiImplicitParam(name = "properties_ids", value = "Requires the int value of properties ids"),
			@ApiImplicitParam(name = "properties_names", value = "Requires the name of properties"),
			@ApiImplicitParam(name = "properties_values", value = "Requires the properties values"),
			@ApiImplicitParam(name = "is_configurable", value = "Requires the value of is configurable"),
			@ApiImplicitParam(name = "tags", value = "Requires the value of tags"),
			@ApiImplicitParam(name = "iccid", value = "Requires the iccid number"),
			@ApiImplicitParam(name = "imei", value = "Requires the imei number"),
			@ApiImplicitParam(name = "template_id", value = "Requires the id of template"),
			@ApiImplicitParam(name = "is_movable", value = "Requires the bit that is movable or not"), })

	@RequestMapping(value = "/device/add/device", method = RequestMethod.POST)
	public @ResponseBody Message deviceAddDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("33", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To delete all device.
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

	@ApiOperation(value = "/device/delete/device", notes = "Delete all device.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"), })

	@RequestMapping(value = "/device/delete/device", method = RequestMethod.POST)
	public @ResponseBody Message deviceDeleteDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("271", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the status of devices.
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
	@ApiOperation(value = "/device/update/device/status", notes = "To update the status of devices.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "device_status", value = "Requires the int value of device status"), })

	@RequestMapping(value = "/device/update/device/status", method = RequestMethod.POST)
	public @ResponseBody Message deviceUpdateDeviceStatus(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("275", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add models of devices.
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

	@ApiOperation(value = "/device/add/model", notes = "To add models of devices.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "name", value = "Requires the name"),
			@ApiImplicitParam(name = "alias", value = "Requires the alias"),
			@ApiImplicitParam(name = "device_type", value = "Requires the int value of  device type"),
			@ApiImplicitParam(name = "device_vendor", value = "Requires the int value of device vendor"),
			@ApiImplicitParam(name = "device_technology", value = "Requires the int value of device technology"),
			@ApiImplicitParam(name = "gis_icon", value = "Requires the gis icon"),
			@ApiImplicitParam(name = "icon", value = "Requires the icon value"),
			@ApiImplicitParam(name = "properties_names", value = "Requires the name of properties"),
			@ApiImplicitParam(name = "properties_alias", value = "Requires the alias of properties"),
			@ApiImplicitParam(name = "properties_data_types", value = "Requires the data of properties"),
			@ApiImplicitParam(name = "show_on_gis", value = "Requires the value of show on gis"),
			@ApiImplicitParam(name = "show_on_perofrmance_report", value = "Requires the value of show on perofrmance report"),
			@ApiImplicitParam(name = "template_name", value = "Requires the name of template"), })

	@RequestMapping(value = "/device/add/model", method = RequestMethod.POST)
	public @ResponseBody Message deviceAddModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("276", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the operational status of devices.
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
	@ApiOperation(value = "/device/update/operational/status", notes = "To update the operational status of devices.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "old_device_id", value = "Requires the old id of device"),
			@ApiImplicitParam(name = "new_device_id", value = "Requires the new id of device"),
			@ApiImplicitParam(name = "device_name", value = "Requires the name of user"),
			@ApiImplicitParam(name = "device_status", value = "Requires the status of device"), })

	@RequestMapping(value = "/device/update/operational/status", method = RequestMethod.POST)
	public @ResponseBody Message deviceUpdateOperationalStatus(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("279", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add the new types.
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

	@ApiOperation(value = "/device/add/type", notes = "To add the new types")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "type_name", value = "Requires the type name"),
			@ApiImplicitParam(name = "type_alias", value = "Requires the type alias of device"),
			@ApiImplicitParam(name = "vendor_id", value = "Requires the int value of vendor id"),
			@ApiImplicitParam(name = "color", value = "Requires the chart color"), })

	@RequestMapping(value = "/device/add/type", method = RequestMethod.POST)
	public @ResponseBody Message deviceAddType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("296", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add the new vendors.
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

	@ApiOperation(value = "/device/add/vendor", notes = "To add the new vendors")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "vendor_name", value = "Requires the name of vendor"),
			@ApiImplicitParam(name = "vendor_alias", value = "Requires the alias of vendor"),
			@ApiImplicitParam(name = "technology_id", value = "Requires the int value of technology id"), })

	@RequestMapping(value = "/device/add/vendor", method = RequestMethod.POST)
	public @ResponseBody Message deviceAddVendor(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("297", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add the new technology.
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

	@ApiOperation(value = "/device/add/technology", notes = "To add the new technology")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires user key of user"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id of user"),
			@ApiImplicitParam(name = "technology_name", value = "Requires the name of technology"),
			@ApiImplicitParam(name = "technology_alias", value = "Requires the alias of technology"), })

	@RequestMapping(value = "/device/add/technology", method = RequestMethod.POST)
	public @ResponseBody Message deviceAddTechnology(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("298", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the devices.
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

	@ApiOperation(value = "/device/update/device", notes = "to update the devices")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "name", value = "Requires the name"),
			@ApiImplicitParam(name = "alias", value = "Requires the alias"),
			@ApiImplicitParam(name = "ipaddress", value = "Requires the ip address"),
			@ApiImplicitParam(name = "lattitude", value = "Requires the latitude value"),
			@ApiImplicitParam(name = "longitutde", value = "Requires the longitude values"),
			@ApiImplicitParam(name = "mac_address", value = "Requires the mac address"),
			@ApiImplicitParam(name = "description", value = "Requires the description"),
			@ApiImplicitParam(name = "elevation", value = "Requires the elevation value"),
			@ApiImplicitParam(name = "hardware_version", value = "Requires the version of hardware"),
			@ApiImplicitParam(name = "software_version", value = "Requires the version of software"),
			@ApiImplicitParam(name = "device_id", value = "Requires the id of device"),
			@ApiImplicitParam(name = "device_country", value = "Requires the country name"),
			@ApiImplicitParam(name = "device_state", value = "Requires the state name"),
			@ApiImplicitParam(name = "device_city", value = "Requires the city name"),
			@ApiImplicitParam(name = "parent_device", value = "Requires the parent device"),
			@ApiImplicitParam(name = "organization_ids", value = "Requires the id of organization"),
			@ApiImplicitParam(name = "properties_ids", value = "Requires the id of properties"),
			@ApiImplicitParam(name = "properties_names", value = "Requires the name of properties"),
			@ApiImplicitParam(name = "properties_values", value = "Requires the value of properties"),
			@ApiImplicitParam(name = "is_configurable", value = "Requires the value of is configurable"),
			@ApiImplicitParam(name = "tags", value = "Requires the value of tags"),
			@ApiImplicitParam(name = "iccid", value = "Requires the iccid number(sim id)"),
			@ApiImplicitParam(name = "imei", value = "Requires the imei number"),
			@ApiImplicitParam(name = "template_id", value = "Requires the id of template"),
			@ApiImplicitParam(name = "is_movable", value = "Requires the bit that is movable or not"), })
	@RequestMapping(value = "/device/update/device", method = RequestMethod.POST)
	public @ResponseBody Message DeviceUpdateDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("314", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add model services and datasources.
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

	@ApiOperation(value = "/device/add/model/service/datasource", notes = "To add model services and datasources ")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "devicemodel_id", value = "Requires the device model id"),
			@ApiImplicitParam(name = "service_name", value = "Requires the service name"),
			@ApiImplicitParam(name = "service_alias", value = "Requires the service alias"),
			@ApiImplicitParam(name = "service_category", value = "Requires the service category"),
			@ApiImplicitParam(name = "datasource_name", value = "Requires the datasource name"),
			@ApiImplicitParam(name = "datasource_alias", value = "Requires the datasource alias"),
			@ApiImplicitParam(name = "datasource_mvalue", value = "Requires the datasource min value"),
			@ApiImplicitParam(name = "datasource_max_value", value = "Requires the datasource max value"),
			@ApiImplicitParam(name = "datasource_unit", value = "Requires the datasource unit"),
			@ApiImplicitParam(name = "data_item_source_type", value = "Requires the data item source type"),
			@ApiImplicitParam(name = "datasource_data_types", value = "Requires the datasource data types"),
			@ApiImplicitParam(name = "datasource_editable", value = "Requires the datasource editable"),
			@ApiImplicitParam(name = "datasource_chart", value = "Requires the datasource chart"),
			@ApiImplicitParam(name = "datasource_colour", value = "Requires the datasource colour"),
			@ApiImplicitParam(name = "datasource_is_shown_on_gis", value = "Requires the int value"),
			@ApiImplicitParam(name = "datasource_is_shown_on_report", value = "Requires the int value"),
			@ApiImplicitParam(name = "priority", value = "Requires the priority"),
			@ApiImplicitParam(name = "formula", value = "Requires the formula"),
			@ApiImplicitParam(name = "simulation_control", value = "Requires the simulation control"), })
	@RequestMapping(value = "/device/add/model/service/datasource", method = RequestMethod.POST)
	public @ResponseBody Message DeviceAddModelServiceDatasource(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("315", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To add error codes.
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

	@ApiOperation(value = "/device/add/model/error/codes", notes = " To add error codes ")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "devicemodel_id", value = "Requires the devicemodel id"),
			@ApiImplicitParam(name = "device_error_code_names", value = "Requires the device error code names"),
			@ApiImplicitParam(name = "device_error_code_alias", value = "Requires the device error code alias"), })
	@RequestMapping(value = "/device/add/model/error/codes", method = RequestMethod.POST)
	public @ResponseBody Message DeviceAddModelErrorCodes(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("316", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the device model.
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

	@ApiOperation(value = "/device/update/model", notes = "To update the device model")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the devicemodel id"),
			@ApiImplicitParam(name = "name", value = "Requires the name"),
			@ApiImplicitParam(name = "alias", value = "Requires the alias"),
			@ApiImplicitParam(name = "device_type", value = "Requires the devicetype"),
			@ApiImplicitParam(name = "device_vendor", value = "Requires the devicevendor"),
			@ApiImplicitParam(name = "device_technology", value = "Requires the devicetechnology"),
			@ApiImplicitParam(name = "gis_icon", value = "Requires the icon"),
			@ApiImplicitParam(name = "icon", value = "Requires the user id"),
			@ApiImplicitParam(name = "properties_names", value = "Requires the properties names"),
			@ApiImplicitParam(name = "properties_alias", value = "Requires the user id"),
			@ApiImplicitParam(name = "properties_data_types", value = "Requires the type of properties alias"),
			@ApiImplicitParam(name = "show_on_gis", value = "Requires the show on gis value"),
			@ApiImplicitParam(name = "show_on_perofrmance_report", value = "Requires the value of show on perofrmance report"),
			@ApiImplicitParam(name = "template_name", value = "Requires the name of template"), })
	@RequestMapping(value = "/device/update/model", method = RequestMethod.POST)
	public @ResponseBody Message deviceUpdateModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("337", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To update the device model.
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

	@ApiOperation(value = "/device/delete/model", notes = "To update the device model")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user key "),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id"),
			@ApiImplicitParam(name = "device_model_id", value = "Requires the device model id"), })
	@RequestMapping(value = "/device/delete/model", method = RequestMethod.POST)
	public @ResponseBody Message deviceDeleteModel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("338", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To insert organization on the basis of device.
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

	@ApiOperation(value = "/device/organization/insert", notes = "To update the device model")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "Token is generated to authenticate the device"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the user key "),
			@ApiImplicitParam(name = "device_id", value = "Requires the user id"), })
	@RequestMapping(value = "/device/organization/insert", method = RequestMethod.POST)
	public @ResponseBody Message deviceOrganizationInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * To call the procedure required for data processing.
		 */
			Message message = genericProcess.GenericProcedureCallingMetaData("416", map, request, response);
			/*
			 * Return the response message.
			 */
			return message;

	}

	/**
	 * To check the organization
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

	@ApiOperation(value = "/organization/check", notes = "To update the device model")
	@ApiImplicitParams({ @ApiImplicitParam(name = "organization_name", value = "Requires the organization name") })
	@RequestMapping(value = "/organization/check", method = RequestMethod.POST)
	public @ResponseBody Message organizationCheck(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * To call the procedure required for data processing.
		 */
		Message message = genericProcess.GenericProcedureCallingMetaData("417", map, request, response);
		/*
		 * Return the response message.
		 */
		return message;
	}
}
