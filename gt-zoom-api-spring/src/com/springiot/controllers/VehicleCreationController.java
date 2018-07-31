/**
 * This package contain the controller class for Vehicles data management.
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
import com.springiot.swagger.response.GenericThirdPartyInsertUpdateDeleteSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class work as a controller which is used for CRUD for Vehicle Creation page.
 * 
 * @author: Mandeep Singh
 * @creation_date: 19-03-2018
 */
@Controller
public class VehicleCreationController {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;
	
	/**
	 * To insert a new vehicle.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/insert", notes = "To insert a new vehicle.", response = GenericThirdPartyInsertUpdateDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "vin", value = "Requires the vin", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "Requires the vehicle_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "year", value = "Requires the year", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "make", value = "Requires the make", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "model", value = "Requires the model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image1", value = "Requires the vehicle_image1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image2", value = "Requires the vehicle_image2", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image3", value = "Requires the vehicle_image3", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_status", value = "Requires the vehicle_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_color", value = "Requires the vehicle_color", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_body_type", value = "Requires the vehicle_body_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "license_plate", value = "Requires the license_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_state", value = "Requires the registration_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_width", value = "Requires the spec_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_height", value = "Requires the spec_height", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_interior_vol", value = "Requires the spec_interior_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_passenger_vol", value = "Requires the spec_passenger_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_cargo_vol", value = "Requires the spec_cargo_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_ground_clearence", value = "Requires the spec_ground_clearence.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_bed_length", value = "Requires the spec_bed_length.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_curb_weight", value = "Requires the spec_curb_weight.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_weight_ratings", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_towing_capcity", value = "Requires the spec_towing_capcity.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_max_payload", value = "Requires the spec_max_payload.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_city", value = "Requires the spec_epa_city.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_highway", value = "Requires the spec_epa_highway.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_combined", value = "Requires the spec_epa_combined.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary", value = "Requires the engine_summary.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Requires the engine_brand.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Requires the engine_aspiration.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Requires the engine_block_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Requires the engine_bore.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Requires the engine_cam_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Requires the engine_compression.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Requires the engine_cylinders.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Requires the engine_displacement.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Requires the engine_fuel_induction.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Requires the engine_fuel_quality.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Requires the engine_max_hp.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Requires the engine_max_torque.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Requires the engine_redline_rpm.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Requires the engine_stroke.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Requires the engine_valves.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary", value = "Requires the transmission_summary.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Requires the transmission_brand.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Requires the transmission_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gears", value = "Requires the transmission_gears.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_type", value = "Requires the fuel_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_quality", value = "Requires the fuel_quality.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_cap_tank1", value = "Requires the fuel_cap_tank1.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_cap_tank2", value = "Requires the fuel_cap_tank2.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "oil_cap", value = "Requires the oil_cap.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "distance_unit", value = "Requires the distance_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_volumne_unit", value = "Requires the fuel_volumne_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "measurement_unit", value = "Requires the measurement_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_name", value = "Requires the vehicle_name.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_number", value = "Requires the engine_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "chasis_number", value = "Requires the chasis_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "condition", value = "Requires the condition.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mileage", value = "Requires the mileage.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fleet_account_id", value = "Requires the fleet_account_id.", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/vehicle/insert", method = RequestMethod.POST)
	public @ResponseBody Message vehicleInsert(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("40", map, null, request, response);
		return message;
	}
	
	/**
	 * To update an existing vehicle.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/update", notes = "To update an existing vehicle.", response = GenericThirdPartyInsertUpdateDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires the vehicle_id", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vin", value = "Requires the vin", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_type", value = "Requires the vehicle_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "year", value = "Requires the year", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "make", value = "Requires the make", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "model", value = "Requires the model", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image1", value = "Requires the vehicle_image1", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image2", value = "Requires the vehicle_image2", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_image3", value = "Requires the vehicle_image3", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_status", value = "Requires the vehicle_status", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_color", value = "Requires the vehicle_color", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_body_type", value = "Requires the vehicle_body_type", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "license_plate", value = "Requires the license_plate", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "registration_state", value = "Requires the registration_state", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_width", value = "Requires the spec_width", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_height", value = "Requires the spec_height", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_interior_vol", value = "Requires the spec_interior_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_passenger_vol", value = "Requires the spec_passenger_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_cargo_vol", value = "Requires the spec_cargo_vol", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_ground_clearence", value = "Requires the spec_ground_clearence.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_bed_length", value = "Requires the spec_bed_length.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_curb_weight", value = "Requires the spec_curb_weight.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_weight_ratings", value = "Requires the offset", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_towing_capcity", value = "Requires the spec_towing_capcity.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_max_payload", value = "Requires the spec_max_payload.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_city", value = "Requires the spec_epa_city.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_highway", value = "Requires the spec_epa_highway.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "spec_epa_combined", value = "Requires the spec_epa_combined.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_summary", value = "Requires the engine_summary.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_brand", value = "Requires the engine_brand.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_aspiration", value = "Requires the engine_aspiration.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_block_type", value = "Requires the engine_block_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_bore", value = "Requires the engine_bore.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cam_type", value = "Requires the engine_cam_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_compression", value = "Requires the engine_compression.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_cylinders", value = "Requires the engine_cylinders.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_displacement", value = "Requires the engine_displacement.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_induction", value = "Requires the engine_fuel_induction.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_fuel_quality", value = "Requires the engine_fuel_quality.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_hp", value = "Requires the engine_max_hp.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_max_torque", value = "Requires the engine_max_torque.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_redline_rpm", value = "Requires the engine_redline_rpm.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_stroke", value = "Requires the engine_stroke.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_valves", value = "Requires the engine_valves.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_summary", value = "Requires the transmission_summary.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_brand", value = "Requires the transmission_brand.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_type", value = "Requires the transmission_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "transmission_gears", value = "Requires the transmission_gears.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_type", value = "Requires the fuel_type.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_quality", value = "Requires the fuel_quality.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_cap_tank1", value = "Requires the fuel_cap_tank1.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_cap_tank2", value = "Requires the fuel_cap_tank2.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "oil_cap", value = "Requires the oil_cap.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "distance_unit", value = "Requires the distance_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fuel_volumne_unit", value = "Requires the fuel_volumne_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "measurement_unit", value = "Requires the measurement_unit.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_name", value = "Requires the vehicle_name.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "engine_number", value = "Requires the engine_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "chasis_number", value = "Requires the chasis_number.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "condition", value = "Requires the condition.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "mileage", value = "Requires the mileage.", required = true, access = "query", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "fleet_account_id", value = "Requires the fleet_account_id.", required = true, access = "query", paramType = "query", dataType = "String") })
	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/vehicle/update", method = RequestMethod.POST)
	public @ResponseBody Message vehicleUpdate(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("41", map, null, request, response);
		return message;
	}
	
	/**
	 * To delete an existing vehicle.
	 * 
	 * @param map : Contains all the parameters.
	 * @param request : To get user_key,user_id from request header.
	 * @param response : To send response.
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/vehicle/delete", notes = "To delete an existing vehicle.", response = GenericThirdPartyInsertUpdateDeleteSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "Token is generated to access API", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_key", value = "Requires User Key of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "user_id", value = "Requires User Id of user", required = true, access = "header", paramType = "header", dataType = "String"),
			@ApiImplicitParam(name = "vehicle_id", value = "Requires the vehicle_id", required = true, access = "query", paramType = "query", dataType = "String") })

	/*
	 * Input Parameters are map,request and response.Map handles all
	 * manipulation in data received from procedure
	 */
	@RequestMapping(value = "/vehicle/delete", method = RequestMethod.POST)
	public @ResponseBody Message vehicleDelete(@ApiIgnore @RequestParam Map<String, String> map,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Message message = genericProcess.GenericProcedureCalling("42", map, null, request, response);
		return message;
	}
}
