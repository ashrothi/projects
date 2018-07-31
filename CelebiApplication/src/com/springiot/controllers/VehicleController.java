/**
 * This package contain the controller class for Third Party Application for Flint
 */
package com.springiot.controllers;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.VehicleService;
import com.springiot.swagger.response.*;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * This class work as a controller which is used for CRUD for Vehicle and manage
 * Vehicle details
 * 
 * @author Ankita Shrothi
 *
 */
@Controller
@EnableAsync
public class VehicleController {
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private VehicleService vehicleService;

	/**
	 * Registration of vehicle
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
	@ApiOperation(value = "/flint/vehicle/add/vehicle", notes = "Registeration of vehicle", response = FlintVehicleAddVehicleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "organization_id", value = "Requires the organization_id", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "registration_number", value = "Required registration_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "model_number", value = "Required model_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "Required vehicle_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_national_permit", value = "Required is_national_permit", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "state_ids", value = "Required state_ids", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "capacity_in_weight", value = "Required capacity_in_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "length", value = "Required length", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "breadth", value = "Required breadth", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "height", value = "Required height", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_tank_capacity", value = "Required fuel_tank_capacity", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_quality", value = "Required fuel_quality", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_type", value = "Required fuel_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "maximum_payload", value = "Required maximum_payload", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "towing_capacity", value = "Required towing_capacity", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "curb_weight", value = "Required curb_weight", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cargo_volume", value = "Required cargo_volume", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "bed_length", value = "Required bed_length", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ground_clearance", value = "Required ground_clearance", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "passenger_capacity", value = "Required passenger_capacity", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_state", value = "Required registration_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "license_plate", value = "Required license_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_purchasing_date", value = "Required vehicle_purchasing_date", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "status ", value = "Required status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ownership ", value = "Required ownership", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "chaisis_number", value = "Required chaisis_number", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla", value = "Required sla", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "make ", value = "Required make", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_highway ", value = "Required epa_highway", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_capacity ", value = "Required epa_capacity", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_combined ", value = "Required epa_combined", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_variants ", value = "Required product_variants", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gross_vehicle_gross_rating", value = "Required gross_vehicle_gross_rating", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary ", value = "Required engine_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Required engine_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Required engine_aspiration", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Required engine_block_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Required engine_bore", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Required engine_cam_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Required engine_compression", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Required engine_cylinders", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Required engine_displacement", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Required engine_fuel_induction", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Required engine_fuel_quality", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Required engine_max_hp", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Required engine_max_torque", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Required engine_redline_rpm", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Required engine_stroke", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Required engine_valves", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary ", value = "Required transmission_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Required transmission_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Required transmission_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gear", value = "Required transmission_gear", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_drive_type", value = "Required wheels_drive_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_brake_system", value = "Required wheels_brake_system", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_track_width", value = "Required wheels_front_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_track_width", value = "Required wheels_rear_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_wheelbase", value = "Required wheels_wheelbase", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_wheel_diameter", value = "Required wheels_rear_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_wheel_diameter", value = "Required wheels_front_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_axle", value = "Required wheels_rear_axle", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_type", value = "Required wheels_front_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required wheels_rear_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_psi", value = "Required wheels_front_tire_psi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_psi", value = "Required wheels_rear_tire_psi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "document_name", value = "Required document_name", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "document_path", value = "Required document_path", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "primary_meter", value = "Required primary_meter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "current_reading", value = "Required current_reading", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Required latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Required longitude", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/add/vehicle", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleAddVehicle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = vehicleService.flintVehicleCreateVehicle(map, request, response);
		return message;
	}

	/**
	 * Helps to map vehicle with the user
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
	@ApiIgnore
	@ApiOperation(value = "/flint/user/vehicle/map", notes = "Helps to map vehicle with the user", response = FlintUserVehicleMapSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "edit_user_key", value = "Requires user key which needs to be edited", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "edit_user_id", value = "Required user id which needs to be edited", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires vehicle id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "edit_user_type", value = "Requires user type to be edited", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/user/vehicle/map", method = RequestMethod.POST)
	public @ResponseBody Message flintUserVehicleMap(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("20", map, null, request, response);
		return message;
	}

	/**
	 * Helps to map vehicle with device
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/map/device", notes = "Helps to map vehicle with device", response = FlintVehicleMapDeviceSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Required vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "device_id", value = "Required device_id", required = true, access = "query", paramType = "query", dataType = "String"), })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/map/device", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleMapDevice(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("16", map, null, request, response);
		return message;
	}

	/**
	 * Registeration of vehicle engine
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/add/engine", notes = "Registeration of vehicle engine", response = FlintVehicleAddEngineSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Required vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "Required vehicle_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary", value = "Required engine_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Required engine_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Required engine_aspiration", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand_copy1", value = "Required engine_brand_copy1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Required engine_block_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Required engine_bore", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Required engine_cam_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Required engine_compression", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Required engine_cylinders", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Required engine_displacement", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Required engine_fuel_induction", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Required engine_fuel_quality", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Required engine_max_hp", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Required engine_max_torque", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Required engine_redline_rpm", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Required engine_stroke", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Required engine_valves", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/add/engine", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleAddEngine(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("41", map, null, request, response);
		return message;
	}

	/**
	 * Registeration of vehicle traqnsmission wheels
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/add/transmission/wheels", notes = "Registeration of vehicle traqnsmission wheels", response = FlintVehicleAddTransmissionWheelsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Required vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "Required vehicle_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary", value = "Required transmission_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Required transmission_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Required transmission_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gear", value = "Required transmission_gear", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_drive_type", value = "Required wheels_drive_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_brake_system", value = "Required wheels_brake_system", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_track_width", value = "Required wheels_front_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_track_width", value = "Required wheels_rear_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels__wheelbase", value = "Required wheels__wheelbase", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_wheel_diameter", value = "Required wheels_rear_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_wheel_diameter", value = "Required wheels_rear_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_wheel_diameter", value = "Required wheels_front_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_axle", value = "Required wheels_rear_axle", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_type", value = "Required wheels_front_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required wheels_rear_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required wheels_rear_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_psi", value = "Required wheels_front_tire_psi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_psi", value = "Required wheels_rear_tire_psi", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/add/transmission/wheels", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleAddTransmissionWheel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("42", map, null, request, response);
		return message;
	}

	/**
	 * To get body type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/body/type", notes = "To   get body type ", response = FlintGetBodyTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/body/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetBodyType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("35", map, null, request, response);
		return message;
	}

	/**
	 * To get engine block type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/engine/block/type", notes = "To  get engine block type", response = FlintGetEngineBlockTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/engine/block/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetEngineBlockType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("36", map, null, request, response);
		return message;
	}

	/**
	 * To get engine cam type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/engine/cam/type", notes = "To get engine cam type", response = FlintGetEngineCamTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/engine/cam/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetEngineCamType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("37", map, null, request, response);
		return message;
	}

	/**
	 * To get fuel type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/fuel/type", notes = "To get fuel type ", response = FlintGetFuelTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/fuel/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetFuelType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("38", map, null, request, response);
		return message;
	}

	/**
	 * To get wheels drive type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/wheels/drive/type", notes = "To get wheels drive type", response = FlintGetWheelsDriveTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/wheels/drive/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetWheelsDriveType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("39", map, null, request, response);
		return message;
	}

	/**
	 * To get wheels tire type
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
	@ApiIgnore
	@ApiOperation(value = "/flint/get/wheels/tire/type", notes = "To get wheels tire type ", response = FlintGetWheelsTireTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires the user id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/wheels/tire/type", method = RequestMethod.POST)
	public @ResponseBody Message flintGetWheelsTireType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("40", map, null, request, response);
		return message;
	}

	/**
	 * To retrieve the vehicle type
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
	@ApiOperation(value = "/flint/vehicle/get/vehicle/type", notes = "To retrieve the vehicle type", response = FlintVehicleGetVehicleTypeSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/vehicle/type", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetVehicleType(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message responseMessage = vehicleService.flintVehicleGetVehicleType(map, request, response);
		return responseMessage;

	}

	/**
	 * To get all details of Vehicle
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
	@ApiOperation(value = "/flint/vehicle/get/all", notes = "To get all details of  Vehicle", response = FlintVehicleGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/all", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetAll(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = vehicleService.flintVehicleGetAll(map, request, response);
		return responseMessage;
	}

	/**
	 * To get all Vehicle Criteria
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
	@ApiOperation(value = "/flint/vehicle/get/all/criteria", notes = "To get all Vehicle Criteria", response = FlintVehicleGetAllCriteriaSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "pickup_location", value = "requires pick up location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dropoff_location", value = "requires dropoff location", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "required_volume", value = "requires required volume", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "requires type of vehicle", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/all/criteria", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetAllCriteria(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = vehicleService.flintVehicleGetAllCriteria(map, request, response);
		return responseMessage;
	}

	/**
	 * To retrieve details the vehicles
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
	@ApiOperation(value = "/flint/vehicle/get/vehicles", notes = "To retrieve details  the vehicles", response = FlintVehicleGetVehiclesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/vehicles", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetVehicles(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("role_name")) {
			Message responseMessage = vehicleService.flintVehicleGetVehicles(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To retrieve the vehicle engines details
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/get/vehicles/engines", notes = "To retrieve the vehicle engines details", response = FlintVehicleGetVehiclesEnginesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/vehicles/engines", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetVehicleEngine(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("role_name")) {
			Message responseMessage = vehicleService.flintVehicleGetVehicleEngine(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Get All Device Details
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
	@ApiOperation(value = "/flint/vehicle/get/all/details", notes = "To Get All Device Details", response = FlintVehicleGetAllDetailsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/all/details", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetAllDetails(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("role_name")) {
			Message responseMessage = vehicleService.flintVehicleGetAllDetails(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Get Vehicle Transmission Wheels
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/get/transmission/wheels", notes = "To Get Vehicle Transmission Wheel", response = FlintVehicleGetTransmissionWheelsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/transmission/wheels", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetTransmissionWheel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("role_name")) {
			Message responseMessage = vehicleService.flintVehicleGetTransmissionWheel(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To Delete Vehicle
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
	@ApiOperation(value = "/flint/delete/vehicle", notes = "To  Delete Vehicle ", response = FlintDeleteVehicleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "role_name", value = "requires role_name of User", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "requires vehicle_key of Vehicle", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "requires vehicle_id of Vehicle", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "requires id of Vehicle", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/delete/vehicle", method = RequestMethod.POST)
	public @ResponseBody Message flintDeleteVehicle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (map.containsKey("role_name")) {
			Message responseMessage = vehicleService.flintDeleteVehicle(map, request, response);
			return responseMessage;
		}
		Message responseMessage = new Message();
		responseMessage.setDescription("Incorrect Parameters ");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * Update Registeration of vehicle
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

	@ApiOperation(value = "/flint/vehicle/update/vehicle", notes = "Update Registeration of vehicle", response = FlintVehicleUpdateVehicleSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "model_number", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "is_national_permit", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "state_ids", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "capacity_in_weight", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "length", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "breadth", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "height", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_tank_capacity", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_quality", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "maximum_payload", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "towing_capacity", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "curb_weight", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "cargo_volume", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "bed_length", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ground_clearance", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "passenger_capacity", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_state", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "license_plate", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_purchasing_date", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "status ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ownership ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "chaisis_number", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "sla", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "make ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_highway ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_capacity ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "epa_combined ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "product_variants ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "gross_vehicle_gross_rating", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary ", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gear", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_drive_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_brake_system", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_track_width", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_track_width", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_wheelbase", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_wheel_diameter", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_wheel_diameter", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_axle", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_psi", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_psi", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "document_name", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "document_path", value = "Required number_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "primary_meter", value = "Required primary_meter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "current_reading", value = "Required current_reading", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Required latitude", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Required longitude", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/update/vehicle", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleUpdateVehicle(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("51", map, null, request, response);
		return message;
	}

	/**
	 * Update Registeration of vehicle engine
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/update/engine", notes = " Update Registeration of vehicle engine", response = FlintVehicleUpdateEngineSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Required vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "Required vehicle_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary", value = "Required engine_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Required engine_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Required engine_aspiration", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand_copy1", value = "Required engine_brand_copy1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Required engine_block_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Required engine_bore", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Required engine_cam_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Required engine_compression", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Required engine_cylinders", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Required engine_displacement", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Required engine_fuel_induction", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Required engine_fuel_quality", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Required engine_max_hp", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Required engine_max_torque", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Required engine_redline_rpm", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Required engine_stroke", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Required engine_valves", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/update/engine", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleUpdateEngine(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("53", map, null, request, response);
		return message;
	}

	/**
	 * Update Registeration of vehicle traqnsmission wheels
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
	@ApiIgnore
	@ApiOperation(value = "/flint/vehicle/update/transmission/wheels", notes = "Update Registeration of vehicle traqnsmission wheels", response = FlintVehicleUpdateTransmissionWheelsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Required user_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Required user_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "id", value = "Required id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Required vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_key", value = "Required vehicle_key", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary", value = "Required transmission_summary", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Required transmission_brand", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Required transmission_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gear", value = "Required transmission_gear", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_drive_type", value = "Required wheels_drive_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_brake_system", value = "Required wheels_brake_system", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_track_width", value = "Required wheels_front_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_track_width", value = "Required wheels_rear_track_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels__wheelbase", value = "Required wheels__wheelbase", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_wheel_diameter", value = "Required wheels_rear_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_wheel_diameter", value = "Required wheels_front_wheel_diameter", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_axle", value = "Required wheels_rear_axle", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_type", value = "Required wheels_front_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required wheels_rear_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_type", value = "Required wheels_rear_tire_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_front_tire_psi", value = "Required wheels_front_tire_psi", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "wheels_rear_tire_psi", value = "Required wheels_rear_tire_psi", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/update/transmission/wheels", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleUpdateTransmissionWheel(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("52", map, null, request, response);
		return message;
	}

	/**
	 * To get all the audit logs with limit.
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
	@ApiOperation(value = "/flint/get/dropdown/options", notes = "To get  the Drop Down information.", response = FlintGetDropdownOptionsSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_key", value = "Requires the user_key of User", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query"),
			@ApiImplicitParam(name = "type_alias", value = "Requires  type_id of dropdwn", required = true, access = "query", paramType = "query") })

	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */

	@RequestMapping(value = "/flint/get/dropdown/options", method = RequestMethod.POST)
	public @ResponseBody Message flintGetDropDownOpyionDriver(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		 * Method GenericProcedureCalling() is called upon to get the data from
		 * respective database.
		 */
		Message message = genericProcess.GenericProcedureCalling("74", map, null, request, response);
		return message;
	}

	/**
	 * To retrieve details the vehicle
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
	@ApiOperation(value = "/flint/get/vehicle/by/registrationno", notes = "To retrieve details  the vehicle", response = FlintVehicleGetVehiclesSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_number", value = "requires registration_number of Vehicle", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/get/vehicle/by/registrationno", method = RequestMethod.POST)
	public @ResponseBody Message flintGetVehicleByRegistrationNo(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("88", map, null, request, response);
		return message;

	}

	/**
	 * To get all details of Vehicle
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
	@ApiOperation(value = "/flint/vehicle/get/all/by/user/id", notes = "To get all details of  Vehicle", response = FlintVehicleGetAllSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "requires vehicle_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "capacity", value = "requires capacity ", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all manipulation in
	 * data received from procedure
	 */
	@RequestMapping(value = "/flint/vehicle/get/all/by/user/id", method = RequestMethod.POST)
	public @ResponseBody Message flintVehicleGetAllByUser(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Message responseMessage = genericProcess.GenericProcedureCalling("111", map, null, request, response);
		return responseMessage;
	}
}
