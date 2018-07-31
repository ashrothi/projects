/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /flint/vehicle/get/all/details API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintVehicleGetAllDetailsSwagger {
	private String description;
/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<FlintVehicleGetAllDetails> object;

	/**
	 * @return the object
	 */
	public List<FlintVehicleGetAllDetails> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintVehicleGetAllDetails> object) {
		this.object = object;
	}

	private boolean valid;

	/**
	 * To get if object is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}
/**
	 * To set Object Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
/*
*TO get response parameter getter setter
*/
class FlintVehicleGetAllDetails {
	private String vehicle_id; 
	private String vehicle_vehicle_id; 
	private String vehicle_registration_number; 
	private String vehicle_number_plate; 
	private String vehicle_model_number; 
	private String vehicle_model_year; 
	private String vehicle_vehicle_type; 
	private String vehicle_vehicle_installation_date; 
	private String vehicle_image; 
	private String vehicle_is_national_permit; 
	private String vehicle_created_by; 
	private String vehicle_creation_time; 
	private String vehicle_last_modified_by; 
	private String vehicle_last_modified_time; 
	     
	private String vehicle_is_deleted; 
	private String vehicle_capacity_in_weight; 
	private String vehicle_length; 
	private String vehicle_breadth; 
	private String vehicle_height; 
	private String vehicle_vehicle_key; 
	private String vehicle_created_by_user_id; 
	private String vehicle_last_modified_by_user_id; 
	private String vehicle_latitude; 
	private String vehicle_longitude; 
	private String vehicle_oil_capacity; 
	private String vehicle_fuel_tank_2_capacity; 
	private String vehicle_fuel_tank_capacity; 
	private String vehicle_fuel_quality; 
	private String vehicle_fuel_type; 
	private String vehicle_estimated_fuel_economy_combined; 
	private String vehicle_estimated_fuel_economy_highway; 
	private String vehicle_estimated_fuel_economy_city; 
	private String vehicle_maximum_payload; 
	private String vehicle_towing_capacity; 
	private String vehicle_curb_weight; 
	private String vehicle_cargo_volume; 
	private String vehicle_bed_length; 
	private String vehicle_groun_clearance; 
	private String vehicle_passenger_capacity; 
	private String vehicle_interior_volume; 
	private String vehicle_approximate_price; 
	private String vehicle_body_subtype; 
	private String vehicle_body_type; 
	private String vehicle_colour; 
	private String vehicle_is_inactive; 
	private String vehicle_registration_state; 
	private String vehicle_license_plate; 
	private String vehicle_manufacturer; 
	private String vehicle_model; 
	private String vehicle_year; 
	private String vehicle_type; 
	private String vehicle_vin; 
	private String ehicle_name; 
	private String vehicle_address; 
	private String vehicle_created_by_user_key; 
	private String vehicle_last_modified_by_user_key; 

	private String vehicle_engine_id; 
	private String vehicle_engine_vehicle_id; 
	private String vehicle_engine_engine_summary; 
	private String vehicle_engine_engine_brand; 
	private String vehicle_engine_engine_aspiration; 
	private String vehicle_engine_engine_brand_copy1; 
	private String vehicle_engine_engine_block_type; 
	private String vehicle_engine_engine_bore; 
	private String vehicle_engine_engine_cam_type; 
	private String vehicle_engine_engine_compression; 
	private String vehicle_engine_engine_cylinders; 
	private String vehicle_engine_engine_displacement; 
	private String vehicle_engine_engine_fuel_induction; 
	private String vehicle_engine_engine_fuel_quality; 
	private String vehicle_engine_engine_max_hp; 
	private String vehicle_engine_engine_max_torque; 
	private String vehicle_engine_engine_redline_rpm; 
	private String vehicle_engine_engine_stroke; 
	private String vehicle_engine_engine_valves; 
	private String vehicle_engine_created_by_user_id; 
	private String vehicle_engine_created_by_user_key; 
	private String vehicle_engine_last_modified_by_user_id; 
	private String vehicle_engine_last_modified_by_user_key; 
	private String vehicle_engine_creation_time; 
	private String vehicle_engine_last_modified_time; 
	private String vehicle_transmission_wheels_id; 
	
	private String vehicle_transmission_wheels_vehicle_id; 
	private String vehicle_transmission_wheels_transmission_summary; 
	private String vehicle_transmission_wheels_transmission_brand; 
	private String vehicle_transmission_wheels_transmission_type; 
	private String vehicle_transmission_wheels_transmission_gear; 
	private String vehicle_transmission_wheels_wheels_drive_type; 
	private String vehicle_transmission_wheels_wheels_brake_system; 
	private String vehicle_transmission_wheels_wheels_front_track_width; 
	private String vehicle_transmission_wheels_wheels_rear_track_width; 
	private String vehicle_transmission_wheels_wheels_wheelbase; 
	private String vehicle_transmission_wheels_wheels_rear_wheel_diameter; 
	private String vehicle_transmission_wheels_wheels_front_wheel_diameter; 
	private String vehicle_transmission_wheels_wheels_rear_axle; 
	private String vehicle_transmission_wheels_wheels_front_tire_type; 
	private String vehicle_transmission_wheels_wheels_rear_tire_type; 
	private String vehicle_transmission_wheels_wheels_front_tire_psi; 
	private String vehicle_transmission_wheels_wheels_rear_tire_psi; 
	private String vehicle_transmission_wheels_created_by_user_id; 
	private String vehicle_transmission_wheels_created_by_user_key; 
	private String vehicle_transmission_wheels_last_modified_by_user_id; 
	private String vehicle_transmission_wheels_last_modified_by_user_key; 
	private String vehicle_transmission_wheels_creation_time; 
	private String vehicle_transmission_wheels_last_modified_time;
	/**
	 * @return the vehicle_id
	 */
	public String getVehicle_id() {
		return vehicle_id;
	}
	/**
	 * @param vehicle_id the vehicle_id to set
	 */
	public void setVehicle_id(String vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	/**
	 * @return the vehicle_vehicle_id
	 */
	public String getVehicle_vehicle_id() {
		return vehicle_vehicle_id;
	}
	/**
	 * @param vehicle_vehicle_id the vehicle_vehicle_id to set
	 */
	public void setVehicle_vehicle_id(String vehicle_vehicle_id) {
		this.vehicle_vehicle_id = vehicle_vehicle_id;
	}
	/**
	 * @return the vehicle_registration_number
	 */
	public String getVehicle_registration_number() {
		return vehicle_registration_number;
	}
	/**
	 * @param vehicle_registration_number the vehicle_registration_number to set
	 */
	public void setVehicle_registration_number(String vehicle_registration_number) {
		this.vehicle_registration_number = vehicle_registration_number;
	}
	/**
	 * @return the vehicle_number_plate
	 */
	public String getVehicle_number_plate() {
		return vehicle_number_plate;
	}
	/**
	 * @param vehicle_number_plate the vehicle_number_plate to set
	 */
	public void setVehicle_number_plate(String vehicle_number_plate) {
		this.vehicle_number_plate = vehicle_number_plate;
	}
	/**
	 * @return the vehicle_model_number
	 */
	public String getVehicle_model_number() {
		return vehicle_model_number;
	}
	/**
	 * @param vehicle_model_number the vehicle_model_number to set
	 */
	public void setVehicle_model_number(String vehicle_model_number) {
		this.vehicle_model_number = vehicle_model_number;
	}
	/**
	 * @return the vehicle_model_year
	 */
	public String getVehicle_model_year() {
		return vehicle_model_year;
	}
	/**
	 * @param vehicle_model_year the vehicle_model_year to set
	 */
	public void setVehicle_model_year(String vehicle_model_year) {
		this.vehicle_model_year = vehicle_model_year;
	}
	/**
	 * @return the vehicle_vehicle_type
	 */
	public String getVehicle_vehicle_type() {
		return vehicle_vehicle_type;
	}
	/**
	 * @param vehicle_vehicle_type the vehicle_vehicle_type to set
	 */
	public void setVehicle_vehicle_type(String vehicle_vehicle_type) {
		this.vehicle_vehicle_type = vehicle_vehicle_type;
	}
	/**
	 * @return the vehicle_vehicle_installation_date
	 */
	public String getVehicle_vehicle_installation_date() {
		return vehicle_vehicle_installation_date;
	}
	/**
	 * @param vehicle_vehicle_installation_date the vehicle_vehicle_installation_date to set
	 */
	public void setVehicle_vehicle_installation_date(String vehicle_vehicle_installation_date) {
		this.vehicle_vehicle_installation_date = vehicle_vehicle_installation_date;
	}
	/**
	 * @return the vehicle_image
	 */
	public String getVehicle_image() {
		return vehicle_image;
	}
	/**
	 * @param vehicle_image the vehicle_image to set
	 */
	public void setVehicle_image(String vehicle_image) {
		this.vehicle_image = vehicle_image;
	}
	/**
	 * @return the vehicle_is_national_permit
	 */
	public String getVehicle_is_national_permit() {
		return vehicle_is_national_permit;
	}
	/**
	 * @param vehicle_is_national_permit the vehicle_is_national_permit to set
	 */
	public void setVehicle_is_national_permit(String vehicle_is_national_permit) {
		this.vehicle_is_national_permit = vehicle_is_national_permit;
	}
	/**
	 * @return the vehicle_created_by
	 */
	public String getVehicle_created_by() {
		return vehicle_created_by;
	}
	/**
	 * @param vehicle_created_by the vehicle_created_by to set
	 */
	public void setVehicle_created_by(String vehicle_created_by) {
		this.vehicle_created_by = vehicle_created_by;
	}
	/**
	 * @return the vehicle_creation_time
	 */
	public String getVehicle_creation_time() {
		return vehicle_creation_time;
	}
	/**
	 * @param vehicle_creation_time the vehicle_creation_time to set
	 */
	public void setVehicle_creation_time(String vehicle_creation_time) {
		this.vehicle_creation_time = vehicle_creation_time;
	}
	/**
	 * @return the vehicle_last_modified_by
	 */
	public String getVehicle_last_modified_by() {
		return vehicle_last_modified_by;
	}
	/**
	 * @param vehicle_last_modified_by the vehicle_last_modified_by to set
	 */
	public void setVehicle_last_modified_by(String vehicle_last_modified_by) {
		this.vehicle_last_modified_by = vehicle_last_modified_by;
	}
	/**
	 * @return the vehicle_last_modified_time
	 */
	public String getVehicle_last_modified_time() {
		return vehicle_last_modified_time;
	}
	/**
	 * @param vehicle_last_modified_time the vehicle_last_modified_time to set
	 */
	public void setVehicle_last_modified_time(String vehicle_last_modified_time) {
		this.vehicle_last_modified_time = vehicle_last_modified_time;
	}
	/**
	 * @return the vehicle_is_deleted
	 */
	public String getVehicle_is_deleted() {
		return vehicle_is_deleted;
	}
	/**
	 * @param vehicle_is_deleted the vehicle_is_deleted to set
	 */
	public void setVehicle_is_deleted(String vehicle_is_deleted) {
		this.vehicle_is_deleted = vehicle_is_deleted;
	}
	/**
	 * @return the vehicle_capacity_in_weight
	 */
	public String getVehicle_capacity_in_weight() {
		return vehicle_capacity_in_weight;
	}
	/**
	 * @param vehicle_capacity_in_weight the vehicle_capacity_in_weight to set
	 */
	public void setVehicle_capacity_in_weight(String vehicle_capacity_in_weight) {
		this.vehicle_capacity_in_weight = vehicle_capacity_in_weight;
	}
	/**
	 * @return the vehicle_length
	 */
	public String getVehicle_length() {
		return vehicle_length;
	}
	/**
	 * @param vehicle_length the vehicle_length to set
	 */
	public void setVehicle_length(String vehicle_length) {
		this.vehicle_length = vehicle_length;
	}
	/**
	 * @return the vehicle_breadth
	 */
	public String getVehicle_breadth() {
		return vehicle_breadth;
	}
	/**
	 * @param vehicle_breadth the vehicle_breadth to set
	 */
	public void setVehicle_breadth(String vehicle_breadth) {
		this.vehicle_breadth = vehicle_breadth;
	}
	/**
	 * @return the vehicle_height
	 */
	public String getVehicle_height() {
		return vehicle_height;
	}
	/**
	 * @param vehicle_height the vehicle_height to set
	 */
	public void setVehicle_height(String vehicle_height) {
		this.vehicle_height = vehicle_height;
	}
	/**
	 * @return the vehicle_vehicle_key
	 */
	public String getVehicle_vehicle_key() {
		return vehicle_vehicle_key;
	}
	/**
	 * @param vehicle_vehicle_key the vehicle_vehicle_key to set
	 */
	public void setVehicle_vehicle_key(String vehicle_vehicle_key) {
		this.vehicle_vehicle_key = vehicle_vehicle_key;
	}
	/**
	 * @return the vehicle_created_by_user_id
	 */
	public String getVehicle_created_by_user_id() {
		return vehicle_created_by_user_id;
	}
	/**
	 * @param vehicle_created_by_user_id the vehicle_created_by_user_id to set
	 */
	public void setVehicle_created_by_user_id(String vehicle_created_by_user_id) {
		this.vehicle_created_by_user_id = vehicle_created_by_user_id;
	}
	/**
	 * @return the vehicle_last_modified_by_user_id
	 */
	public String getVehicle_last_modified_by_user_id() {
		return vehicle_last_modified_by_user_id;
	}
	/**
	 * @param vehicle_last_modified_by_user_id the vehicle_last_modified_by_user_id to set
	 */
	public void setVehicle_last_modified_by_user_id(String vehicle_last_modified_by_user_id) {
		this.vehicle_last_modified_by_user_id = vehicle_last_modified_by_user_id;
	}
	/**
	 * @return the vehicle_latitude
	 */
	public String getVehicle_latitude() {
		return vehicle_latitude;
	}
	/**
	 * @param vehicle_latitude the vehicle_latitude to set
	 */
	public void setVehicle_latitude(String vehicle_latitude) {
		this.vehicle_latitude = vehicle_latitude;
	}
	/**
	 * @return the vehicle_longitude
	 */
	public String getVehicle_longitude() {
		return vehicle_longitude;
	}
	/**
	 * @param vehicle_longitude the vehicle_longitude to set
	 */
	public void setVehicle_longitude(String vehicle_longitude) {
		this.vehicle_longitude = vehicle_longitude;
	}
	/**
	 * @return the vehicle_oil_capacity
	 */
	public String getVehicle_oil_capacity() {
		return vehicle_oil_capacity;
	}
	/**
	 * @param vehicle_oil_capacity the vehicle_oil_capacity to set
	 */
	public void setVehicle_oil_capacity(String vehicle_oil_capacity) {
		this.vehicle_oil_capacity = vehicle_oil_capacity;
	}
	/**
	 * @return the vehicle_fuel_tank_2_capacity
	 */
	public String getVehicle_fuel_tank_2_capacity() {
		return vehicle_fuel_tank_2_capacity;
	}
	/**
	 * @param vehicle_fuel_tank_2_capacity the vehicle_fuel_tank_2_capacity to set
	 */
	public void setVehicle_fuel_tank_2_capacity(String vehicle_fuel_tank_2_capacity) {
		this.vehicle_fuel_tank_2_capacity = vehicle_fuel_tank_2_capacity;
	}
	/**
	 * @return the vehicle_fuel_tank_capacity
	 */
	public String getVehicle_fuel_tank_capacity() {
		return vehicle_fuel_tank_capacity;
	}
	/**
	 * @param vehicle_fuel_tank_capacity the vehicle_fuel_tank_capacity to set
	 */
	public void setVehicle_fuel_tank_capacity(String vehicle_fuel_tank_capacity) {
		this.vehicle_fuel_tank_capacity = vehicle_fuel_tank_capacity;
	}
	/**
	 * @return the vehicle_fuel_quality
	 */
	public String getVehicle_fuel_quality() {
		return vehicle_fuel_quality;
	}
	/**
	 * @param vehicle_fuel_quality the vehicle_fuel_quality to set
	 */
	public void setVehicle_fuel_quality(String vehicle_fuel_quality) {
		this.vehicle_fuel_quality = vehicle_fuel_quality;
	}
	/**
	 * @return the vehicle_fuel_type
	 */
	public String getVehicle_fuel_type() {
		return vehicle_fuel_type;
	}
	/**
	 * @param vehicle_fuel_type the vehicle_fuel_type to set
	 */
	public void setVehicle_fuel_type(String vehicle_fuel_type) {
		this.vehicle_fuel_type = vehicle_fuel_type;
	}
	/**
	 * @return the vehicle_estimated_fuel_economy_combined
	 */
	public String getVehicle_estimated_fuel_economy_combined() {
		return vehicle_estimated_fuel_economy_combined;
	}
	/**
	 * @param vehicle_estimated_fuel_economy_combined the vehicle_estimated_fuel_economy_combined to set
	 */
	public void setVehicle_estimated_fuel_economy_combined(String vehicle_estimated_fuel_economy_combined) {
		this.vehicle_estimated_fuel_economy_combined = vehicle_estimated_fuel_economy_combined;
	}
	/**
	 * @return the vehicle_estimated_fuel_economy_highway
	 */
	public String getVehicle_estimated_fuel_economy_highway() {
		return vehicle_estimated_fuel_economy_highway;
	}
	/**
	 * @param vehicle_estimated_fuel_economy_highway the vehicle_estimated_fuel_economy_highway to set
	 */
	public void setVehicle_estimated_fuel_economy_highway(String vehicle_estimated_fuel_economy_highway) {
		this.vehicle_estimated_fuel_economy_highway = vehicle_estimated_fuel_economy_highway;
	}
	/**
	 * @return the vehicle_estimated_fuel_economy_city
	 */
	public String getVehicle_estimated_fuel_economy_city() {
		return vehicle_estimated_fuel_economy_city;
	}
	/**
	 * @param vehicle_estimated_fuel_economy_city the vehicle_estimated_fuel_economy_city to set
	 */
	public void setVehicle_estimated_fuel_economy_city(String vehicle_estimated_fuel_economy_city) {
		this.vehicle_estimated_fuel_economy_city = vehicle_estimated_fuel_economy_city;
	}
	/**
	 * @return the vehicle_maximum_payload
	 */
	public String getVehicle_maximum_payload() {
		return vehicle_maximum_payload;
	}
	/**
	 * @param vehicle_maximum_payload the vehicle_maximum_payload to set
	 */
	public void setVehicle_maximum_payload(String vehicle_maximum_payload) {
		this.vehicle_maximum_payload = vehicle_maximum_payload;
	}
	/**
	 * @return the vehicle_towing_capacity
	 */
	public String getVehicle_towing_capacity() {
		return vehicle_towing_capacity;
	}
	/**
	 * @param vehicle_towing_capacity the vehicle_towing_capacity to set
	 */
	public void setVehicle_towing_capacity(String vehicle_towing_capacity) {
		this.vehicle_towing_capacity = vehicle_towing_capacity;
	}
	/**
	 * @return the vehicle_curb_weight
	 */
	public String getVehicle_curb_weight() {
		return vehicle_curb_weight;
	}
	/**
	 * @param vehicle_curb_weight the vehicle_curb_weight to set
	 */
	public void setVehicle_curb_weight(String vehicle_curb_weight) {
		this.vehicle_curb_weight = vehicle_curb_weight;
	}
	/**
	 * @return the vehicle_cargo_volume
	 */
	public String getVehicle_cargo_volume() {
		return vehicle_cargo_volume;
	}
	/**
	 * @param vehicle_cargo_volume the vehicle_cargo_volume to set
	 */
	public void setVehicle_cargo_volume(String vehicle_cargo_volume) {
		this.vehicle_cargo_volume = vehicle_cargo_volume;
	}
	/**
	 * @return the vehicle_bed_length
	 */
	public String getVehicle_bed_length() {
		return vehicle_bed_length;
	}
	/**
	 * @param vehicle_bed_length the vehicle_bed_length to set
	 */
	public void setVehicle_bed_length(String vehicle_bed_length) {
		this.vehicle_bed_length = vehicle_bed_length;
	}
	/**
	 * @return the vehicle_groun_clearance
	 */
	public String getVehicle_groun_clearance() {
		return vehicle_groun_clearance;
	}
	/**
	 * @param vehicle_groun_clearance the vehicle_groun_clearance to set
	 */
	public void setVehicle_groun_clearance(String vehicle_groun_clearance) {
		this.vehicle_groun_clearance = vehicle_groun_clearance;
	}
	/**
	 * @return the vehicle_passenger_capacity
	 */
	public String getVehicle_passenger_capacity() {
		return vehicle_passenger_capacity;
	}
	/**
	 * @param vehicle_passenger_capacity the vehicle_passenger_capacity to set
	 */
	public void setVehicle_passenger_capacity(String vehicle_passenger_capacity) {
		this.vehicle_passenger_capacity = vehicle_passenger_capacity;
	}
	/**
	 * @return the vehicle_interior_volume
	 */
	public String getVehicle_interior_volume() {
		return vehicle_interior_volume;
	}
	/**
	 * @param vehicle_interior_volume the vehicle_interior_volume to set
	 */
	public void setVehicle_interior_volume(String vehicle_interior_volume) {
		this.vehicle_interior_volume = vehicle_interior_volume;
	}
	/**
	 * @return the vehicle_approximate_price
	 */
	public String getVehicle_approximate_price() {
		return vehicle_approximate_price;
	}
	/**
	 * @param vehicle_approximate_price the vehicle_approximate_price to set
	 */
	public void setVehicle_approximate_price(String vehicle_approximate_price) {
		this.vehicle_approximate_price = vehicle_approximate_price;
	}
	/**
	 * @return the vehicle_body_subtype
	 */
	public String getVehicle_body_subtype() {
		return vehicle_body_subtype;
	}
	/**
	 * @param vehicle_body_subtype the vehicle_body_subtype to set
	 */
	public void setVehicle_body_subtype(String vehicle_body_subtype) {
		this.vehicle_body_subtype = vehicle_body_subtype;
	}
	/**
	 * @return the vehicle_body_type
	 */
	public String getVehicle_body_type() {
		return vehicle_body_type;
	}
	/**
	 * @param vehicle_body_type the vehicle_body_type to set
	 */
	public void setVehicle_body_type(String vehicle_body_type) {
		this.vehicle_body_type = vehicle_body_type;
	}
	/**
	 * @return the vehicle_colour
	 */
	public String getVehicle_colour() {
		return vehicle_colour;
	}
	/**
	 * @param vehicle_colour the vehicle_colour to set
	 */
	public void setVehicle_colour(String vehicle_colour) {
		this.vehicle_colour = vehicle_colour;
	}
	/**
	 * @return the vehicle_is_inactive
	 */
	public String getVehicle_is_inactive() {
		return vehicle_is_inactive;
	}
	/**
	 * @param vehicle_is_inactive the vehicle_is_inactive to set
	 */
	public void setVehicle_is_inactive(String vehicle_is_inactive) {
		this.vehicle_is_inactive = vehicle_is_inactive;
	}
	/**
	 * @return the vehicle_registration_state
	 */
	public String getVehicle_registration_state() {
		return vehicle_registration_state;
	}
	/**
	 * @param vehicle_registration_state the vehicle_registration_state to set
	 */
	public void setVehicle_registration_state(String vehicle_registration_state) {
		this.vehicle_registration_state = vehicle_registration_state;
	}
	/**
	 * @return the vehicle_license_plate
	 */
	public String getVehicle_license_plate() {
		return vehicle_license_plate;
	}
	/**
	 * @param vehicle_license_plate the vehicle_license_plate to set
	 */
	public void setVehicle_license_plate(String vehicle_license_plate) {
		this.vehicle_license_plate = vehicle_license_plate;
	}
	/**
	 * @return the vehicle_manufacturer
	 */
	public String getVehicle_manufacturer() {
		return vehicle_manufacturer;
	}
	/**
	 * @param vehicle_manufacturer the vehicle_manufacturer to set
	 */
	public void setVehicle_manufacturer(String vehicle_manufacturer) {
		this.vehicle_manufacturer = vehicle_manufacturer;
	}
	/**
	 * @return the vehicle_model
	 */
	public String getVehicle_model() {
		return vehicle_model;
	}
	/**
	 * @param vehicle_model the vehicle_model to set
	 */
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}
	/**
	 * @return the vehicle_year
	 */
	public String getVehicle_year() {
		return vehicle_year;
	}
	/**
	 * @param vehicle_year the vehicle_year to set
	 */
	public void setVehicle_year(String vehicle_year) {
		this.vehicle_year = vehicle_year;
	}
	/**
	 * @return the vehicle_type
	 */
	public String getVehicle_type() {
		return vehicle_type;
	}
	/**
	 * @param vehicle_type the vehicle_type to set
	 */
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	/**
	 * @return the vehicle_vin
	 */
	public String getVehicle_vin() {
		return vehicle_vin;
	}
	/**
	 * @param vehicle_vin the vehicle_vin to set
	 */
	public void setVehicle_vin(String vehicle_vin) {
		this.vehicle_vin = vehicle_vin;
	}
	/**
	 * @return the ehicle_name
	 */
	public String getEhicle_name() {
		return ehicle_name;
	}
	/**
	 * @param ehicle_name the ehicle_name to set
	 */
	public void setEhicle_name(String ehicle_name) {
		this.ehicle_name = ehicle_name;
	}
	/**
	 * @return the vehicle_address
	 */
	public String getVehicle_address() {
		return vehicle_address;
	}
	/**
	 * @param vehicle_address the vehicle_address to set
	 */
	public void setVehicle_address(String vehicle_address) {
		this.vehicle_address = vehicle_address;
	}
	/**
	 * @return the vehicle_created_by_user_key
	 */
	public String getVehicle_created_by_user_key() {
		return vehicle_created_by_user_key;
	}
	/**
	 * @param vehicle_created_by_user_key the vehicle_created_by_user_key to set
	 */
	public void setVehicle_created_by_user_key(String vehicle_created_by_user_key) {
		this.vehicle_created_by_user_key = vehicle_created_by_user_key;
	}
	/**
	 * @return the vehicle_last_modified_by_user_key
	 */
	public String getVehicle_last_modified_by_user_key() {
		return vehicle_last_modified_by_user_key;
	}
	/**
	 * @param vehicle_last_modified_by_user_key the vehicle_last_modified_by_user_key to set
	 */
	public void setVehicle_last_modified_by_user_key(String vehicle_last_modified_by_user_key) {
		this.vehicle_last_modified_by_user_key = vehicle_last_modified_by_user_key;
	}
	/**
	 * @return the vehicle_engine_id
	 */
	public String getVehicle_engine_id() {
		return vehicle_engine_id;
	}
	/**
	 * @param vehicle_engine_id the vehicle_engine_id to set
	 */
	public void setVehicle_engine_id(String vehicle_engine_id) {
		this.vehicle_engine_id = vehicle_engine_id;
	}
	/**
	 * @return the vehicle_engine_vehicle_id
	 */
	public String getVehicle_engine_vehicle_id() {
		return vehicle_engine_vehicle_id;
	}
	/**
	 * @param vehicle_engine_vehicle_id the vehicle_engine_vehicle_id to set
	 */
	public void setVehicle_engine_vehicle_id(String vehicle_engine_vehicle_id) {
		this.vehicle_engine_vehicle_id = vehicle_engine_vehicle_id;
	}
	/**
	 * @return the vehicle_engine_engine_summary
	 */
	public String getVehicle_engine_engine_summary() {
		return vehicle_engine_engine_summary;
	}
	/**
	 * @param vehicle_engine_engine_summary the vehicle_engine_engine_summary to set
	 */
	public void setVehicle_engine_engine_summary(String vehicle_engine_engine_summary) {
		this.vehicle_engine_engine_summary = vehicle_engine_engine_summary;
	}
	/**
	 * @return the vehicle_engine_engine_brand
	 */
	public String getVehicle_engine_engine_brand() {
		return vehicle_engine_engine_brand;
	}
	/**
	 * @param vehicle_engine_engine_brand the vehicle_engine_engine_brand to set
	 */
	public void setVehicle_engine_engine_brand(String vehicle_engine_engine_brand) {
		this.vehicle_engine_engine_brand = vehicle_engine_engine_brand;
	}
	/**
	 * @return the vehicle_engine_engine_aspiration
	 */
	public String getVehicle_engine_engine_aspiration() {
		return vehicle_engine_engine_aspiration;
	}
	/**
	 * @param vehicle_engine_engine_aspiration the vehicle_engine_engine_aspiration to set
	 */
	public void setVehicle_engine_engine_aspiration(String vehicle_engine_engine_aspiration) {
		this.vehicle_engine_engine_aspiration = vehicle_engine_engine_aspiration;
	}
	/**
	 * @return the vehicle_engine_engine_brand_copy1
	 */
	public String getVehicle_engine_engine_brand_copy1() {
		return vehicle_engine_engine_brand_copy1;
	}
	/**
	 * @param vehicle_engine_engine_brand_copy1 the vehicle_engine_engine_brand_copy1 to set
	 */
	public void setVehicle_engine_engine_brand_copy1(String vehicle_engine_engine_brand_copy1) {
		this.vehicle_engine_engine_brand_copy1 = vehicle_engine_engine_brand_copy1;
	}
	/**
	 * @return the vehicle_engine_engine_block_type
	 */
	public String getVehicle_engine_engine_block_type() {
		return vehicle_engine_engine_block_type;
	}
	/**
	 * @param vehicle_engine_engine_block_type the vehicle_engine_engine_block_type to set
	 */
	public void setVehicle_engine_engine_block_type(String vehicle_engine_engine_block_type) {
		this.vehicle_engine_engine_block_type = vehicle_engine_engine_block_type;
	}
	/**
	 * @return the vehicle_engine_engine_bore
	 */
	public String getVehicle_engine_engine_bore() {
		return vehicle_engine_engine_bore;
	}
	/**
	 * @param vehicle_engine_engine_bore the vehicle_engine_engine_bore to set
	 */
	public void setVehicle_engine_engine_bore(String vehicle_engine_engine_bore) {
		this.vehicle_engine_engine_bore = vehicle_engine_engine_bore;
	}
	/**
	 * @return the vehicle_engine_engine_cam_type
	 */
	public String getVehicle_engine_engine_cam_type() {
		return vehicle_engine_engine_cam_type;
	}
	/**
	 * @param vehicle_engine_engine_cam_type the vehicle_engine_engine_cam_type to set
	 */
	public void setVehicle_engine_engine_cam_type(String vehicle_engine_engine_cam_type) {
		this.vehicle_engine_engine_cam_type = vehicle_engine_engine_cam_type;
	}
	/**
	 * @return the vehicle_engine_engine_compression
	 */
	public String getVehicle_engine_engine_compression() {
		return vehicle_engine_engine_compression;
	}
	/**
	 * @param vehicle_engine_engine_compression the vehicle_engine_engine_compression to set
	 */
	public void setVehicle_engine_engine_compression(String vehicle_engine_engine_compression) {
		this.vehicle_engine_engine_compression = vehicle_engine_engine_compression;
	}
	/**
	 * @return the vehicle_engine_engine_cylinders
	 */
	public String getVehicle_engine_engine_cylinders() {
		return vehicle_engine_engine_cylinders;
	}
	/**
	 * @param vehicle_engine_engine_cylinders the vehicle_engine_engine_cylinders to set
	 */
	public void setVehicle_engine_engine_cylinders(String vehicle_engine_engine_cylinders) {
		this.vehicle_engine_engine_cylinders = vehicle_engine_engine_cylinders;
	}
	/**
	 * @return the vehicle_engine_engine_displacement
	 */
	public String getVehicle_engine_engine_displacement() {
		return vehicle_engine_engine_displacement;
	}
	/**
	 * @param vehicle_engine_engine_displacement the vehicle_engine_engine_displacement to set
	 */
	public void setVehicle_engine_engine_displacement(String vehicle_engine_engine_displacement) {
		this.vehicle_engine_engine_displacement = vehicle_engine_engine_displacement;
	}
	/**
	 * @return the vehicle_engine_engine_fuel_induction
	 */
	public String getVehicle_engine_engine_fuel_induction() {
		return vehicle_engine_engine_fuel_induction;
	}
	/**
	 * @param vehicle_engine_engine_fuel_induction the vehicle_engine_engine_fuel_induction to set
	 */
	public void setVehicle_engine_engine_fuel_induction(String vehicle_engine_engine_fuel_induction) {
		this.vehicle_engine_engine_fuel_induction = vehicle_engine_engine_fuel_induction;
	}
	/**
	 * @return the vehicle_engine_engine_fuel_quality
	 */
	public String getVehicle_engine_engine_fuel_quality() {
		return vehicle_engine_engine_fuel_quality;
	}
	/**
	 * @param vehicle_engine_engine_fuel_quality the vehicle_engine_engine_fuel_quality to set
	 */
	public void setVehicle_engine_engine_fuel_quality(String vehicle_engine_engine_fuel_quality) {
		this.vehicle_engine_engine_fuel_quality = vehicle_engine_engine_fuel_quality;
	}
	/**
	 * @return the vehicle_engine_engine_max_hp
	 */
	public String getVehicle_engine_engine_max_hp() {
		return vehicle_engine_engine_max_hp;
	}
	/**
	 * @param vehicle_engine_engine_max_hp the vehicle_engine_engine_max_hp to set
	 */
	public void setVehicle_engine_engine_max_hp(String vehicle_engine_engine_max_hp) {
		this.vehicle_engine_engine_max_hp = vehicle_engine_engine_max_hp;
	}
	/**
	 * @return the vehicle_engine_engine_max_torque
	 */
	public String getVehicle_engine_engine_max_torque() {
		return vehicle_engine_engine_max_torque;
	}
	/**
	 * @param vehicle_engine_engine_max_torque the vehicle_engine_engine_max_torque to set
	 */
	public void setVehicle_engine_engine_max_torque(String vehicle_engine_engine_max_torque) {
		this.vehicle_engine_engine_max_torque = vehicle_engine_engine_max_torque;
	}
	/**
	 * @return the vehicle_engine_engine_redline_rpm
	 */
	public String getVehicle_engine_engine_redline_rpm() {
		return vehicle_engine_engine_redline_rpm;
	}
	/**
	 * @param vehicle_engine_engine_redline_rpm the vehicle_engine_engine_redline_rpm to set
	 */
	public void setVehicle_engine_engine_redline_rpm(String vehicle_engine_engine_redline_rpm) {
		this.vehicle_engine_engine_redline_rpm = vehicle_engine_engine_redline_rpm;
	}
	/**
	 * @return the vehicle_engine_engine_stroke
	 */
	public String getVehicle_engine_engine_stroke() {
		return vehicle_engine_engine_stroke;
	}
	/**
	 * @param vehicle_engine_engine_stroke the vehicle_engine_engine_stroke to set
	 */
	public void setVehicle_engine_engine_stroke(String vehicle_engine_engine_stroke) {
		this.vehicle_engine_engine_stroke = vehicle_engine_engine_stroke;
	}
	/**
	 * @return the vehicle_engine_engine_valves
	 */
	public String getVehicle_engine_engine_valves() {
		return vehicle_engine_engine_valves;
	}
	/**
	 * @param vehicle_engine_engine_valves the vehicle_engine_engine_valves to set
	 */
	public void setVehicle_engine_engine_valves(String vehicle_engine_engine_valves) {
		this.vehicle_engine_engine_valves = vehicle_engine_engine_valves;
	}
	/**
	 * @return the vehicle_engine_created_by_user_id
	 */
	public String getVehicle_engine_created_by_user_id() {
		return vehicle_engine_created_by_user_id;
	}
	/**
	 * @param vehicle_engine_created_by_user_id the vehicle_engine_created_by_user_id to set
	 */
	public void setVehicle_engine_created_by_user_id(String vehicle_engine_created_by_user_id) {
		this.vehicle_engine_created_by_user_id = vehicle_engine_created_by_user_id;
	}
	/**
	 * @return the vehicle_engine_created_by_user_key
	 */
	public String getVehicle_engine_created_by_user_key() {
		return vehicle_engine_created_by_user_key;
	}
	/**
	 * @param vehicle_engine_created_by_user_key the vehicle_engine_created_by_user_key to set
	 */
	public void setVehicle_engine_created_by_user_key(String vehicle_engine_created_by_user_key) {
		this.vehicle_engine_created_by_user_key = vehicle_engine_created_by_user_key;
	}
	/**
	 * @return the vehicle_engine_last_modified_by_user_id
	 */
	public String getVehicle_engine_last_modified_by_user_id() {
		return vehicle_engine_last_modified_by_user_id;
	}
	/**
	 * @param vehicle_engine_last_modified_by_user_id the vehicle_engine_last_modified_by_user_id to set
	 */
	public void setVehicle_engine_last_modified_by_user_id(String vehicle_engine_last_modified_by_user_id) {
		this.vehicle_engine_last_modified_by_user_id = vehicle_engine_last_modified_by_user_id;
	}
	/**
	 * @return the vehicle_engine_last_modified_by_user_key
	 */
	public String getVehicle_engine_last_modified_by_user_key() {
		return vehicle_engine_last_modified_by_user_key;
	}
	/**
	 * @param vehicle_engine_last_modified_by_user_key the vehicle_engine_last_modified_by_user_key to set
	 */
	public void setVehicle_engine_last_modified_by_user_key(String vehicle_engine_last_modified_by_user_key) {
		this.vehicle_engine_last_modified_by_user_key = vehicle_engine_last_modified_by_user_key;
	}
	/**
	 * @return the vehicle_engine_creation_time
	 */
	public String getVehicle_engine_creation_time() {
		return vehicle_engine_creation_time;
	}
	/**
	 * @param vehicle_engine_creation_time the vehicle_engine_creation_time to set
	 */
	public void setVehicle_engine_creation_time(String vehicle_engine_creation_time) {
		this.vehicle_engine_creation_time = vehicle_engine_creation_time;
	}
	/**
	 * @return the vehicle_engine_last_modified_time
	 */
	public String getVehicle_engine_last_modified_time() {
		return vehicle_engine_last_modified_time;
	}
	/**
	 * @param vehicle_engine_last_modified_time the vehicle_engine_last_modified_time to set
	 */
	public void setVehicle_engine_last_modified_time(String vehicle_engine_last_modified_time) {
		this.vehicle_engine_last_modified_time = vehicle_engine_last_modified_time;
	}
	/**
	 * @return the vehicle_transmission_wheels_id
	 */
	public String getVehicle_transmission_wheels_id() {
		return vehicle_transmission_wheels_id;
	}
	/**
	 * @param vehicle_transmission_wheels_id the vehicle_transmission_wheels_id to set
	 */
	public void setVehicle_transmission_wheels_id(String vehicle_transmission_wheels_id) {
		this.vehicle_transmission_wheels_id = vehicle_transmission_wheels_id;
	}
	/**
	 * @return the vehicle_transmission_wheels_vehicle_id
	 */
	public String getVehicle_transmission_wheels_vehicle_id() {
		return vehicle_transmission_wheels_vehicle_id;
	}
	/**
	 * @param vehicle_transmission_wheels_vehicle_id the vehicle_transmission_wheels_vehicle_id to set
	 */
	public void setVehicle_transmission_wheels_vehicle_id(String vehicle_transmission_wheels_vehicle_id) {
		this.vehicle_transmission_wheels_vehicle_id = vehicle_transmission_wheels_vehicle_id;
	}
	/**
	 * @return the vehicle_transmission_wheels_transmission_summary
	 */
	public String getVehicle_transmission_wheels_transmission_summary() {
		return vehicle_transmission_wheels_transmission_summary;
	}
	/**
	 * @param vehicle_transmission_wheels_transmission_summary the vehicle_transmission_wheels_transmission_summary to set
	 */
	public void setVehicle_transmission_wheels_transmission_summary(
			String vehicle_transmission_wheels_transmission_summary) {
		this.vehicle_transmission_wheels_transmission_summary = vehicle_transmission_wheels_transmission_summary;
	}
	/**
	 * @return the vehicle_transmission_wheels_transmission_brand
	 */
	public String getVehicle_transmission_wheels_transmission_brand() {
		return vehicle_transmission_wheels_transmission_brand;
	}
	/**
	 * @param vehicle_transmission_wheels_transmission_brand the vehicle_transmission_wheels_transmission_brand to set
	 */
	public void setVehicle_transmission_wheels_transmission_brand(String vehicle_transmission_wheels_transmission_brand) {
		this.vehicle_transmission_wheels_transmission_brand = vehicle_transmission_wheels_transmission_brand;
	}
	/**
	 * @return the vehicle_transmission_wheels_transmission_type
	 */
	public String getVehicle_transmission_wheels_transmission_type() {
		return vehicle_transmission_wheels_transmission_type;
	}
	/**
	 * @param vehicle_transmission_wheels_transmission_type the vehicle_transmission_wheels_transmission_type to set
	 */
	public void setVehicle_transmission_wheels_transmission_type(String vehicle_transmission_wheels_transmission_type) {
		this.vehicle_transmission_wheels_transmission_type = vehicle_transmission_wheels_transmission_type;
	}
	/**
	 * @return the vehicle_transmission_wheels_transmission_gear
	 */
	public String getVehicle_transmission_wheels_transmission_gear() {
		return vehicle_transmission_wheels_transmission_gear;
	}
	/**
	 * @param vehicle_transmission_wheels_transmission_gear the vehicle_transmission_wheels_transmission_gear to set
	 */
	public void setVehicle_transmission_wheels_transmission_gear(String vehicle_transmission_wheels_transmission_gear) {
		this.vehicle_transmission_wheels_transmission_gear = vehicle_transmission_wheels_transmission_gear;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_drive_type
	 */
	public String getVehicle_transmission_wheels_wheels_drive_type() {
		return vehicle_transmission_wheels_wheels_drive_type;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_drive_type the vehicle_transmission_wheels_wheels_drive_type to set
	 */
	public void setVehicle_transmission_wheels_wheels_drive_type(String vehicle_transmission_wheels_wheels_drive_type) {
		this.vehicle_transmission_wheels_wheels_drive_type = vehicle_transmission_wheels_wheels_drive_type;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_brake_system
	 */
	public String getVehicle_transmission_wheels_wheels_brake_system() {
		return vehicle_transmission_wheels_wheels_brake_system;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_brake_system the vehicle_transmission_wheels_wheels_brake_system to set
	 */
	public void setVehicle_transmission_wheels_wheels_brake_system(String vehicle_transmission_wheels_wheels_brake_system) {
		this.vehicle_transmission_wheels_wheels_brake_system = vehicle_transmission_wheels_wheels_brake_system;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_front_track_width
	 */
	public String getVehicle_transmission_wheels_wheels_front_track_width() {
		return vehicle_transmission_wheels_wheels_front_track_width;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_front_track_width the vehicle_transmission_wheels_wheels_front_track_width to set
	 */
	public void setVehicle_transmission_wheels_wheels_front_track_width(
			String vehicle_transmission_wheels_wheels_front_track_width) {
		this.vehicle_transmission_wheels_wheels_front_track_width = vehicle_transmission_wheels_wheels_front_track_width;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_rear_track_width
	 */
	public String getVehicle_transmission_wheels_wheels_rear_track_width() {
		return vehicle_transmission_wheels_wheels_rear_track_width;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_rear_track_width the vehicle_transmission_wheels_wheels_rear_track_width to set
	 */
	public void setVehicle_transmission_wheels_wheels_rear_track_width(
			String vehicle_transmission_wheels_wheels_rear_track_width) {
		this.vehicle_transmission_wheels_wheels_rear_track_width = vehicle_transmission_wheels_wheels_rear_track_width;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_wheelbase
	 */
	public String getVehicle_transmission_wheels_wheels_wheelbase() {
		return vehicle_transmission_wheels_wheels_wheelbase;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_wheelbase the vehicle_transmission_wheels_wheels_wheelbase to set
	 */
	public void setVehicle_transmission_wheels_wheels_wheelbase(String vehicle_transmission_wheels_wheels_wheelbase) {
		this.vehicle_transmission_wheels_wheels_wheelbase = vehicle_transmission_wheels_wheels_wheelbase;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_rear_wheel_diameter
	 */
	public String getVehicle_transmission_wheels_wheels_rear_wheel_diameter() {
		return vehicle_transmission_wheels_wheels_rear_wheel_diameter;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_rear_wheel_diameter the vehicle_transmission_wheels_wheels_rear_wheel_diameter to set
	 */
	public void setVehicle_transmission_wheels_wheels_rear_wheel_diameter(
			String vehicle_transmission_wheels_wheels_rear_wheel_diameter) {
		this.vehicle_transmission_wheels_wheels_rear_wheel_diameter = vehicle_transmission_wheels_wheels_rear_wheel_diameter;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_front_wheel_diameter
	 */
	public String getVehicle_transmission_wheels_wheels_front_wheel_diameter() {
		return vehicle_transmission_wheels_wheels_front_wheel_diameter;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_front_wheel_diameter the vehicle_transmission_wheels_wheels_front_wheel_diameter to set
	 */
	public void setVehicle_transmission_wheels_wheels_front_wheel_diameter(
			String vehicle_transmission_wheels_wheels_front_wheel_diameter) {
		this.vehicle_transmission_wheels_wheels_front_wheel_diameter = vehicle_transmission_wheels_wheels_front_wheel_diameter;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_rear_axle
	 */
	public String getVehicle_transmission_wheels_wheels_rear_axle() {
		return vehicle_transmission_wheels_wheels_rear_axle;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_rear_axle the vehicle_transmission_wheels_wheels_rear_axle to set
	 */
	public void setVehicle_transmission_wheels_wheels_rear_axle(String vehicle_transmission_wheels_wheels_rear_axle) {
		this.vehicle_transmission_wheels_wheels_rear_axle = vehicle_transmission_wheels_wheels_rear_axle;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_front_tire_type
	 */
	public String getVehicle_transmission_wheels_wheels_front_tire_type() {
		return vehicle_transmission_wheels_wheels_front_tire_type;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_front_tire_type the vehicle_transmission_wheels_wheels_front_tire_type to set
	 */
	public void setVehicle_transmission_wheels_wheels_front_tire_type(
			String vehicle_transmission_wheels_wheels_front_tire_type) {
		this.vehicle_transmission_wheels_wheels_front_tire_type = vehicle_transmission_wheels_wheels_front_tire_type;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_rear_tire_type
	 */
	public String getVehicle_transmission_wheels_wheels_rear_tire_type() {
		return vehicle_transmission_wheels_wheels_rear_tire_type;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_rear_tire_type the vehicle_transmission_wheels_wheels_rear_tire_type to set
	 */
	public void setVehicle_transmission_wheels_wheels_rear_tire_type(
			String vehicle_transmission_wheels_wheels_rear_tire_type) {
		this.vehicle_transmission_wheels_wheels_rear_tire_type = vehicle_transmission_wheels_wheels_rear_tire_type;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_front_tire_psi
	 */
	public String getVehicle_transmission_wheels_wheels_front_tire_psi() {
		return vehicle_transmission_wheels_wheels_front_tire_psi;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_front_tire_psi the vehicle_transmission_wheels_wheels_front_tire_psi to set
	 */
	public void setVehicle_transmission_wheels_wheels_front_tire_psi(
			String vehicle_transmission_wheels_wheels_front_tire_psi) {
		this.vehicle_transmission_wheels_wheels_front_tire_psi = vehicle_transmission_wheels_wheels_front_tire_psi;
	}
	/**
	 * @return the vehicle_transmission_wheels_wheels_rear_tire_psi
	 */
	public String getVehicle_transmission_wheels_wheels_rear_tire_psi() {
		return vehicle_transmission_wheels_wheels_rear_tire_psi;
	}
	/**
	 * @param vehicle_transmission_wheels_wheels_rear_tire_psi the vehicle_transmission_wheels_wheels_rear_tire_psi to set
	 */
	public void setVehicle_transmission_wheels_wheels_rear_tire_psi(
			String vehicle_transmission_wheels_wheels_rear_tire_psi) {
		this.vehicle_transmission_wheels_wheels_rear_tire_psi = vehicle_transmission_wheels_wheels_rear_tire_psi;
	}
	/**
	 * @return the vehicle_transmission_wheels_created_by_user_id
	 */
	public String getVehicle_transmission_wheels_created_by_user_id() {
		return vehicle_transmission_wheels_created_by_user_id;
	}
	/**
	 * @param vehicle_transmission_wheels_created_by_user_id the vehicle_transmission_wheels_created_by_user_id to set
	 */
	public void setVehicle_transmission_wheels_created_by_user_id(String vehicle_transmission_wheels_created_by_user_id) {
		this.vehicle_transmission_wheels_created_by_user_id = vehicle_transmission_wheels_created_by_user_id;
	}
	/**
	 * @return the vehicle_transmission_wheels_created_by_user_key
	 */
	public String getVehicle_transmission_wheels_created_by_user_key() {
		return vehicle_transmission_wheels_created_by_user_key;
	}
	/**
	 * @param vehicle_transmission_wheels_created_by_user_key the vehicle_transmission_wheels_created_by_user_key to set
	 */
	public void setVehicle_transmission_wheels_created_by_user_key(String vehicle_transmission_wheels_created_by_user_key) {
		this.vehicle_transmission_wheels_created_by_user_key = vehicle_transmission_wheels_created_by_user_key;
	}
	/**
	 * @return the vehicle_transmission_wheels_last_modified_by_user_id
	 */
	public String getVehicle_transmission_wheels_last_modified_by_user_id() {
		return vehicle_transmission_wheels_last_modified_by_user_id;
	}
	/**
	 * @param vehicle_transmission_wheels_last_modified_by_user_id the vehicle_transmission_wheels_last_modified_by_user_id to set
	 */
	public void setVehicle_transmission_wheels_last_modified_by_user_id(
			String vehicle_transmission_wheels_last_modified_by_user_id) {
		this.vehicle_transmission_wheels_last_modified_by_user_id = vehicle_transmission_wheels_last_modified_by_user_id;
	}
	/**
	 * @return the vehicle_transmission_wheels_last_modified_by_user_key
	 */
	public String getVehicle_transmission_wheels_last_modified_by_user_key() {
		return vehicle_transmission_wheels_last_modified_by_user_key;
	}
	/**
	 * @param vehicle_transmission_wheels_last_modified_by_user_key the vehicle_transmission_wheels_last_modified_by_user_key to set
	 */
	public void setVehicle_transmission_wheels_last_modified_by_user_key(
			String vehicle_transmission_wheels_last_modified_by_user_key) {
		this.vehicle_transmission_wheels_last_modified_by_user_key = vehicle_transmission_wheels_last_modified_by_user_key;
	}
	/**
	 * @return the vehicle_transmission_wheels_creation_time
	 */
	public String getVehicle_transmission_wheels_creation_time() {
		return vehicle_transmission_wheels_creation_time;
	}
	/**
	 * @param vehicle_transmission_wheels_creation_time the vehicle_transmission_wheels_creation_time to set
	 */
	public void setVehicle_transmission_wheels_creation_time(String vehicle_transmission_wheels_creation_time) {
		this.vehicle_transmission_wheels_creation_time = vehicle_transmission_wheels_creation_time;
	}
	/**
	 * @return the vehicle_transmission_wheels_last_modified_time
	 */
	public String getVehicle_transmission_wheels_last_modified_time() {
		return vehicle_transmission_wheels_last_modified_time;
	}
	/**
	 * @param vehicle_transmission_wheels_last_modified_time the vehicle_transmission_wheels_last_modified_time to set
	 */
	public void setVehicle_transmission_wheels_last_modified_time(String vehicle_transmission_wheels_last_modified_time) {
		this.vehicle_transmission_wheels_last_modified_time = vehicle_transmission_wheels_last_modified_time;
	}

}
