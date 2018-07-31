/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting call vehicle data by device type from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class VehicleGetAllByDeviceTypeSwagger {
	private String description;
	private List<VehicleGetAllByDeviceType> object;
	private boolean valid;
	
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
	/**
	 * @return the object
	 */
	public List<VehicleGetAllByDeviceType> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<VehicleGetAllByDeviceType> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * This class is used for setting data into the object.
 */
class VehicleGetAllByDeviceType {
	// Initializing the variables.
	private Integer vehicle_id;
	private String vehicle_name;
	private String vin;
	private String year;
	private String model;
	private String engine_number;
	private String chasis_number;
	private String condition;
	private String vehicle_image1;
	private String vehicle_image2;
	private String vehicle_image3;
	private String vehicle_color;
	private String vehicle_body_type;
	private String license_plate;
	private String spec_width;
	private String spec_height;
	private String spec_interior_vol;
	private String spec_passenger_vol;
	private String spec_cargo_vol;
	private String spec_ground_clearence;
	private String spec_bed_length;
	private String spec_curb_weight;
	private String spec_weight_ratings;
	private String spec_towing_capcity;
	private String spec_max_payload;
	private String spec_epa_city;
	private String spec_epa_highway;
	private String spec_epa_combined;
	private String engine_summary;
	private String engine_brand;
	private String engine_aspiration;
	private String engine_block_type;
	private String engine_bore;
	private String engine_cam_type;
	private String engine_compression;
	private String engine_cylinders;
	private String engine_displacement;
	private String engine_fuel_induction;
	private String engine_fuel_quality;
	private String engine_max_hp;
	private String engine_max_torque;
	private String engine_redline_rpm;
	private String engine_stroke;
	private String engine_valves;
	private String transmission_summary;
	private String transmission_brand;
	private String transmission_type;
	private String transmission_gears;
	private Integer fuel_type_id;
	private String fuel_quality;
	private String fuel_cap_tank1;
	private String fuel_cap_tank2;
	private String oil_cap;
	private Integer vehicle_device_id;
	private Integer device_id;
	private String device_key;
	private String obd_id;
	private String bluetooth_addr;
	private String added_on;
	private Integer vehicle_device_is_active;
	private String device_type;
	private String gcmid;
	private Integer vehicle_fuel_expendtiure_id;
	private String from_date;
	private String to_date;
	private String sys_total_amount;
	private Integer vehicle_group_group_id;
	private String make;
	private String vehicle_status;
	private Integer vehicle_status_is_default;
	private Integer vehicle_type_id;
	private String vehicle_type;
	private String distance_unit;
	private String fuel_volumne_unit;
	private String measurement_unit;
	private String registration_state;
	private Integer fleet_account_id;
	private String job_title;
	private Integer currency;
	private Integer time_format;
	private String user_address;
	private String user_id;
	private String user_key;
	private String user_name;
	private Integer owner_id;
	private Integer is_owner;
	private Integer role_id;
	private String role_name;
	private Integer fleet_size;
	private String address;
	private String gender;
	private String user_image;
	private long phone_number;
	private Integer group_id;
	private String group_color;
	private String organization_name;
	private String group_name;
	private String group_path;
	private Integer group_level;
	private String fuel_type;
	private String tag_id;
	private String vehicle_tags_id;
	private String tag_name;
	private String lat_list;
	private String long_list;
	private String time_list;
	private Integer vehicle_trips_id;
	private String trip_id;
	private Float fuel_consumption;
	private Float distance;
	private Float mileage_kmpl;
	private long vehicle_trips_start_time;
	private long vehicle_trips_end_time;
	private Integer country;
	private Integer state;
	private Integer city;
	private Float trip_duration;
	private Integer harsh_brake;
	private Float avg_speed;
	private Integer hard_acceleration;
	private Float driver_score;
	private Float vehicle_score;
	private double start_latitude;
	private double start_longitude;
	private String start_address;
	private double end_latitude;
	private double end_longitude;
	private String end_address;
	private Float fuel_score;
	private Integer throttle_opening_numbers;
	private Float over_speeding_time;
	private Float idling_time;
	private Float idling_fuel_consumed;
	private String currency_name;
	private String currency_alias;
	/**
	 * @return the vehicle_id
	 */
	public Integer getVehicle_id() {
		return vehicle_id;
	}
	/**
	 * @param vehicle_id the vehicle_id to set
	 */
	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	/**
	 * @return the vehicle_name
	 */
	public String getVehicle_name() {
		return vehicle_name;
	}
	/**
	 * @param vehicle_name the vehicle_name to set
	 */
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	/**
	 * @return the vin
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * @param vin the vin to set
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the engine_number
	 */
	public String getEngine_number() {
		return engine_number;
	}
	/**
	 * @param engine_number the engine_number to set
	 */
	public void setEngine_number(String engine_number) {
		this.engine_number = engine_number;
	}
	/**
	 * @return the chasis_number
	 */
	public String getChasis_number() {
		return chasis_number;
	}
	/**
	 * @param chasis_number the chasis_number to set
	 */
	public void setChasis_number(String chasis_number) {
		this.chasis_number = chasis_number;
	}
	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the vehicle_image1
	 */
	public String getVehicle_image1() {
		return vehicle_image1;
	}
	/**
	 * @param vehicle_image1 the vehicle_image1 to set
	 */
	public void setVehicle_image1(String vehicle_image1) {
		this.vehicle_image1 = vehicle_image1;
	}
	/**
	 * @return the vehicle_image2
	 */
	public String getVehicle_image2() {
		return vehicle_image2;
	}
	/**
	 * @param vehicle_image2 the vehicle_image2 to set
	 */
	public void setVehicle_image2(String vehicle_image2) {
		this.vehicle_image2 = vehicle_image2;
	}
	/**
	 * @return the vehicle_image3
	 */
	public String getVehicle_image3() {
		return vehicle_image3;
	}
	/**
	 * @param vehicle_image3 the vehicle_image3 to set
	 */
	public void setVehicle_image3(String vehicle_image3) {
		this.vehicle_image3 = vehicle_image3;
	}
	/**
	 * @return the vehicle_color
	 */
	public String getVehicle_color() {
		return vehicle_color;
	}
	/**
	 * @param vehicle_color the vehicle_color to set
	 */
	public void setVehicle_color(String vehicle_color) {
		this.vehicle_color = vehicle_color;
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
	 * @return the license_plate
	 */
	public String getLicense_plate() {
		return license_plate;
	}
	/**
	 * @param license_plate the license_plate to set
	 */
	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}
	/**
	 * @return the spec_width
	 */
	public String getSpec_width() {
		return spec_width;
	}
	/**
	 * @param spec_width the spec_width to set
	 */
	public void setSpec_width(String spec_width) {
		this.spec_width = spec_width;
	}
	/**
	 * @return the spec_height
	 */
	public String getSpec_height() {
		return spec_height;
	}
	/**
	 * @param spec_height the spec_height to set
	 */
	public void setSpec_height(String spec_height) {
		this.spec_height = spec_height;
	}
	/**
	 * @return the spec_interior_vol
	 */
	public String getSpec_interior_vol() {
		return spec_interior_vol;
	}
	/**
	 * @param spec_interior_vol the spec_interior_vol to set
	 */
	public void setSpec_interior_vol(String spec_interior_vol) {
		this.spec_interior_vol = spec_interior_vol;
	}
	/**
	 * @return the spec_passenger_vol
	 */
	public String getSpec_passenger_vol() {
		return spec_passenger_vol;
	}
	/**
	 * @param spec_passenger_vol the spec_passenger_vol to set
	 */
	public void setSpec_passenger_vol(String spec_passenger_vol) {
		this.spec_passenger_vol = spec_passenger_vol;
	}
	/**
	 * @return the spec_cargo_vol
	 */
	public String getSpec_cargo_vol() {
		return spec_cargo_vol;
	}
	/**
	 * @param spec_cargo_vol the spec_cargo_vol to set
	 */
	public void setSpec_cargo_vol(String spec_cargo_vol) {
		this.spec_cargo_vol = spec_cargo_vol;
	}
	/**
	 * @return the spec_ground_clearence
	 */
	public String getSpec_ground_clearence() {
		return spec_ground_clearence;
	}
	/**
	 * @param spec_ground_clearence the spec_ground_clearence to set
	 */
	public void setSpec_ground_clearence(String spec_ground_clearence) {
		this.spec_ground_clearence = spec_ground_clearence;
	}
	/**
	 * @return the spec_bed_length
	 */
	public String getSpec_bed_length() {
		return spec_bed_length;
	}
	/**
	 * @param spec_bed_length the spec_bed_length to set
	 */
	public void setSpec_bed_length(String spec_bed_length) {
		this.spec_bed_length = spec_bed_length;
	}
	/**
	 * @return the spec_curb_weight
	 */
	public String getSpec_curb_weight() {
		return spec_curb_weight;
	}
	/**
	 * @param spec_curb_weight the spec_curb_weight to set
	 */
	public void setSpec_curb_weight(String spec_curb_weight) {
		this.spec_curb_weight = spec_curb_weight;
	}
	/**
	 * @return the spec_weight_ratings
	 */
	public String getSpec_weight_ratings() {
		return spec_weight_ratings;
	}
	/**
	 * @param spec_weight_ratings the spec_weight_ratings to set
	 */
	public void setSpec_weight_ratings(String spec_weight_ratings) {
		this.spec_weight_ratings = spec_weight_ratings;
	}
	/**
	 * @return the spec_towing_capcity
	 */
	public String getSpec_towing_capcity() {
		return spec_towing_capcity;
	}
	/**
	 * @param spec_towing_capcity the spec_towing_capcity to set
	 */
	public void setSpec_towing_capcity(String spec_towing_capcity) {
		this.spec_towing_capcity = spec_towing_capcity;
	}
	/**
	 * @return the spec_max_payload
	 */
	public String getSpec_max_payload() {
		return spec_max_payload;
	}
	/**
	 * @param spec_max_payload the spec_max_payload to set
	 */
	public void setSpec_max_payload(String spec_max_payload) {
		this.spec_max_payload = spec_max_payload;
	}
	/**
	 * @return the spec_epa_city
	 */
	public String getSpec_epa_city() {
		return spec_epa_city;
	}
	/**
	 * @param spec_epa_city the spec_epa_city to set
	 */
	public void setSpec_epa_city(String spec_epa_city) {
		this.spec_epa_city = spec_epa_city;
	}
	/**
	 * @return the spec_epa_highway
	 */
	public String getSpec_epa_highway() {
		return spec_epa_highway;
	}
	/**
	 * @param spec_epa_highway the spec_epa_highway to set
	 */
	public void setSpec_epa_highway(String spec_epa_highway) {
		this.spec_epa_highway = spec_epa_highway;
	}
	/**
	 * @return the spec_epa_combined
	 */
	public String getSpec_epa_combined() {
		return spec_epa_combined;
	}
	/**
	 * @param spec_epa_combined the spec_epa_combined to set
	 */
	public void setSpec_epa_combined(String spec_epa_combined) {
		this.spec_epa_combined = spec_epa_combined;
	}
	/**
	 * @return the engine_summary
	 */
	public String getEngine_summary() {
		return engine_summary;
	}
	/**
	 * @param engine_summary the engine_summary to set
	 */
	public void setEngine_summary(String engine_summary) {
		this.engine_summary = engine_summary;
	}
	/**
	 * @return the engine_brand
	 */
	public String getEngine_brand() {
		return engine_brand;
	}
	/**
	 * @param engine_brand the engine_brand to set
	 */
	public void setEngine_brand(String engine_brand) {
		this.engine_brand = engine_brand;
	}
	/**
	 * @return the engine_aspiration
	 */
	public String getEngine_aspiration() {
		return engine_aspiration;
	}
	/**
	 * @param engine_aspiration the engine_aspiration to set
	 */
	public void setEngine_aspiration(String engine_aspiration) {
		this.engine_aspiration = engine_aspiration;
	}
	/**
	 * @return the engine_block_type
	 */
	public String getEngine_block_type() {
		return engine_block_type;
	}
	/**
	 * @param engine_block_type the engine_block_type to set
	 */
	public void setEngine_block_type(String engine_block_type) {
		this.engine_block_type = engine_block_type;
	}
	/**
	 * @return the engine_bore
	 */
	public String getEngine_bore() {
		return engine_bore;
	}
	/**
	 * @param engine_bore the engine_bore to set
	 */
	public void setEngine_bore(String engine_bore) {
		this.engine_bore = engine_bore;
	}
	/**
	 * @return the engine_cam_type
	 */
	public String getEngine_cam_type() {
		return engine_cam_type;
	}
	/**
	 * @param engine_cam_type the engine_cam_type to set
	 */
	public void setEngine_cam_type(String engine_cam_type) {
		this.engine_cam_type = engine_cam_type;
	}
	/**
	 * @return the engine_compression
	 */
	public String getEngine_compression() {
		return engine_compression;
	}
	/**
	 * @param engine_compression the engine_compression to set
	 */
	public void setEngine_compression(String engine_compression) {
		this.engine_compression = engine_compression;
	}
	/**
	 * @return the engine_cylinders
	 */
	public String getEngine_cylinders() {
		return engine_cylinders;
	}
	/**
	 * @param engine_cylinders the engine_cylinders to set
	 */
	public void setEngine_cylinders(String engine_cylinders) {
		this.engine_cylinders = engine_cylinders;
	}
	/**
	 * @return the engine_displacement
	 */
	public String getEngine_displacement() {
		return engine_displacement;
	}
	/**
	 * @param engine_displacement the engine_displacement to set
	 */
	public void setEngine_displacement(String engine_displacement) {
		this.engine_displacement = engine_displacement;
	}
	/**
	 * @return the engine_fuel_induction
	 */
	public String getEngine_fuel_induction() {
		return engine_fuel_induction;
	}
	/**
	 * @param engine_fuel_induction the engine_fuel_induction to set
	 */
	public void setEngine_fuel_induction(String engine_fuel_induction) {
		this.engine_fuel_induction = engine_fuel_induction;
	}
	/**
	 * @return the engine_fuel_quality
	 */
	public String getEngine_fuel_quality() {
		return engine_fuel_quality;
	}
	/**
	 * @param engine_fuel_quality the engine_fuel_quality to set
	 */
	public void setEngine_fuel_quality(String engine_fuel_quality) {
		this.engine_fuel_quality = engine_fuel_quality;
	}
	/**
	 * @return the engine_max_hp
	 */
	public String getEngine_max_hp() {
		return engine_max_hp;
	}
	/**
	 * @param engine_max_hp the engine_max_hp to set
	 */
	public void setEngine_max_hp(String engine_max_hp) {
		this.engine_max_hp = engine_max_hp;
	}
	/**
	 * @return the engine_max_torque
	 */
	public String getEngine_max_torque() {
		return engine_max_torque;
	}
	/**
	 * @param engine_max_torque the engine_max_torque to set
	 */
	public void setEngine_max_torque(String engine_max_torque) {
		this.engine_max_torque = engine_max_torque;
	}
	/**
	 * @return the engine_redline_rpm
	 */
	public String getEngine_redline_rpm() {
		return engine_redline_rpm;
	}
	/**
	 * @param engine_redline_rpm the engine_redline_rpm to set
	 */
	public void setEngine_redline_rpm(String engine_redline_rpm) {
		this.engine_redline_rpm = engine_redline_rpm;
	}
	/**
	 * @return the engine_stroke
	 */
	public String getEngine_stroke() {
		return engine_stroke;
	}
	/**
	 * @param engine_stroke the engine_stroke to set
	 */
	public void setEngine_stroke(String engine_stroke) {
		this.engine_stroke = engine_stroke;
	}
	/**
	 * @return the engine_valves
	 */
	public String getEngine_valves() {
		return engine_valves;
	}
	/**
	 * @param engine_valves the engine_valves to set
	 */
	public void setEngine_valves(String engine_valves) {
		this.engine_valves = engine_valves;
	}
	/**
	 * @return the transmission_summary
	 */
	public String getTransmission_summary() {
		return transmission_summary;
	}
	/**
	 * @param transmission_summary the transmission_summary to set
	 */
	public void setTransmission_summary(String transmission_summary) {
		this.transmission_summary = transmission_summary;
	}
	/**
	 * @return the transmission_brand
	 */
	public String getTransmission_brand() {
		return transmission_brand;
	}
	/**
	 * @param transmission_brand the transmission_brand to set
	 */
	public void setTransmission_brand(String transmission_brand) {
		this.transmission_brand = transmission_brand;
	}
	/**
	 * @return the transmission_type
	 */
	public String getTransmission_type() {
		return transmission_type;
	}
	/**
	 * @param transmission_type the transmission_type to set
	 */
	public void setTransmission_type(String transmission_type) {
		this.transmission_type = transmission_type;
	}
	/**
	 * @return the transmission_gears
	 */
	public String getTransmission_gears() {
		return transmission_gears;
	}
	/**
	 * @param transmission_gears the transmission_gears to set
	 */
	public void setTransmission_gears(String transmission_gears) {
		this.transmission_gears = transmission_gears;
	}
	/**
	 * @return the fuel_type_id
	 */
	public Integer getFuel_type_id() {
		return fuel_type_id;
	}
	/**
	 * @param fuel_type_id the fuel_type_id to set
	 */
	public void setFuel_type_id(Integer fuel_type_id) {
		this.fuel_type_id = fuel_type_id;
	}
	/**
	 * @return the fuel_quality
	 */
	public String getFuel_quality() {
		return fuel_quality;
	}
	/**
	 * @param fuel_quality the fuel_quality to set
	 */
	public void setFuel_quality(String fuel_quality) {
		this.fuel_quality = fuel_quality;
	}
	/**
	 * @return the fuel_cap_tank1
	 */
	public String getFuel_cap_tank1() {
		return fuel_cap_tank1;
	}
	/**
	 * @param fuel_cap_tank1 the fuel_cap_tank1 to set
	 */
	public void setFuel_cap_tank1(String fuel_cap_tank1) {
		this.fuel_cap_tank1 = fuel_cap_tank1;
	}
	/**
	 * @return the fuel_cap_tank2
	 */
	public String getFuel_cap_tank2() {
		return fuel_cap_tank2;
	}
	/**
	 * @param fuel_cap_tank2 the fuel_cap_tank2 to set
	 */
	public void setFuel_cap_tank2(String fuel_cap_tank2) {
		this.fuel_cap_tank2 = fuel_cap_tank2;
	}
	/**
	 * @return the oil_cap
	 */
	public String getOil_cap() {
		return oil_cap;
	}
	/**
	 * @param oil_cap the oil_cap to set
	 */
	public void setOil_cap(String oil_cap) {
		this.oil_cap = oil_cap;
	}
	/**
	 * @return the vehicle_device_id
	 */
	public Integer getVehicle_device_id() {
		return vehicle_device_id;
	}
	/**
	 * @param vehicle_device_id the vehicle_device_id to set
	 */
	public void setVehicle_device_id(Integer vehicle_device_id) {
		this.vehicle_device_id = vehicle_device_id;
	}
	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_key
	 */
	public String getDevice_key() {
		return device_key;
	}
	/**
	 * @param device_key the device_key to set
	 */
	public void setDevice_key(String device_key) {
		this.device_key = device_key;
	}
	/**
	 * @return the obd_id
	 */
	public String getObd_id() {
		return obd_id;
	}
	/**
	 * @param obd_id the obd_id to set
	 */
	public void setObd_id(String obd_id) {
		this.obd_id = obd_id;
	}
	/**
	 * @return the bluetooth_addr
	 */
	public String getBluetooth_addr() {
		return bluetooth_addr;
	}
	/**
	 * @param bluetooth_addr the bluetooth_addr to set
	 */
	public void setBluetooth_addr(String bluetooth_addr) {
		this.bluetooth_addr = bluetooth_addr;
	}
	/**
	 * @return the added_on
	 */
	public String getAdded_on() {
		return added_on;
	}
	/**
	 * @param added_on the added_on to set
	 */
	public void setAdded_on(String added_on) {
		this.added_on = added_on;
	}
	/**
	 * @return the vehicle_device_is_active
	 */
	public Integer getVehicle_device_is_active() {
		return vehicle_device_is_active;
	}
	/**
	 * @param vehicle_device_is_active the vehicle_device_is_active to set
	 */
	public void setVehicle_device_is_active(Integer vehicle_device_is_active) {
		this.vehicle_device_is_active = vehicle_device_is_active;
	}
	/**
	 * @return the device_type
	 */
	public String getDevice_type() {
		return device_type;
	}
	/**
	 * @param device_type the device_type to set
	 */
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	/**
	 * @return the gcmid
	 */
	public String getGcmid() {
		return gcmid;
	}
	/**
	 * @param gcmid the gcmid to set
	 */
	public void setGcmid(String gcmid) {
		this.gcmid = gcmid;
	}
	/**
	 * @return the vehicle_fuel_expendtiure_id
	 */
	public Integer getVehicle_fuel_expendtiure_id() {
		return vehicle_fuel_expendtiure_id;
	}
	/**
	 * @param vehicle_fuel_expendtiure_id the vehicle_fuel_expendtiure_id to set
	 */
	public void setVehicle_fuel_expendtiure_id(Integer vehicle_fuel_expendtiure_id) {
		this.vehicle_fuel_expendtiure_id = vehicle_fuel_expendtiure_id;
	}
	/**
	 * @return the from_date
	 */
	public String getFrom_date() {
		return from_date;
	}
	/**
	 * @param from_date the from_date to set
	 */
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	/**
	 * @return the to_date
	 */
	public String getTo_date() {
		return to_date;
	}
	/**
	 * @param to_date the to_date to set
	 */
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	/**
	 * @return the sys_total_amount
	 */
	public String getSys_total_amount() {
		return sys_total_amount;
	}
	/**
	 * @param sys_total_amount the sys_total_amount to set
	 */
	public void setSys_total_amount(String sys_total_amount) {
		this.sys_total_amount = sys_total_amount;
	}
	/**
	 * @return the vehicle_group_group_id
	 */
	public Integer getVehicle_group_group_id() {
		return vehicle_group_group_id;
	}
	/**
	 * @param vehicle_group_group_id the vehicle_group_group_id to set
	 */
	public void setVehicle_group_group_id(Integer vehicle_group_group_id) {
		this.vehicle_group_group_id = vehicle_group_group_id;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the vehicle_status
	 */
	public String getVehicle_status() {
		return vehicle_status;
	}
	/**
	 * @param vehicle_status the vehicle_status to set
	 */
	public void setVehicle_status(String vehicle_status) {
		this.vehicle_status = vehicle_status;
	}
	/**
	 * @return the vehicle_status_is_default
	 */
	public Integer getVehicle_status_is_default() {
		return vehicle_status_is_default;
	}
	/**
	 * @param vehicle_status_is_default the vehicle_status_is_default to set
	 */
	public void setVehicle_status_is_default(Integer vehicle_status_is_default) {
		this.vehicle_status_is_default = vehicle_status_is_default;
	}
	/**
	 * @return the vehicle_type_id
	 */
	public Integer getVehicle_type_id() {
		return vehicle_type_id;
	}
	/**
	 * @param vehicle_type_id the vehicle_type_id to set
	 */
	public void setVehicle_type_id(Integer vehicle_type_id) {
		this.vehicle_type_id = vehicle_type_id;
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
	 * @return the distance_unit
	 */
	public String getDistance_unit() {
		return distance_unit;
	}
	/**
	 * @param distance_unit the distance_unit to set
	 */
	public void setDistance_unit(String distance_unit) {
		this.distance_unit = distance_unit;
	}
	/**
	 * @return the fuel_volumne_unit
	 */
	public String getFuel_volumne_unit() {
		return fuel_volumne_unit;
	}
	/**
	 * @param fuel_volumne_unit the fuel_volumne_unit to set
	 */
	public void setFuel_volumne_unit(String fuel_volumne_unit) {
		this.fuel_volumne_unit = fuel_volumne_unit;
	}
	/**
	 * @return the measurement_unit
	 */
	public String getMeasurement_unit() {
		return measurement_unit;
	}
	/**
	 * @param measurement_unit the measurement_unit to set
	 */
	public void setMeasurement_unit(String measurement_unit) {
		this.measurement_unit = measurement_unit;
	}
	/**
	 * @return the registration_state
	 */
	public String getRegistration_state() {
		return registration_state;
	}
	/**
	 * @param registration_state the registration_state to set
	 */
	public void setRegistration_state(String registration_state) {
		this.registration_state = registration_state;
	}
	/**
	 * @return the fleet_account_id
	 */
	public Integer getFleet_account_id() {
		return fleet_account_id;
	}
	/**
	 * @param fleet_account_id the fleet_account_id to set
	 */
	public void setFleet_account_id(Integer fleet_account_id) {
		this.fleet_account_id = fleet_account_id;
	}
	/**
	 * @return the job_title
	 */
	public String getJob_title() {
		return job_title;
	}
	/**
	 * @param job_title the job_title to set
	 */
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	/**
	 * @return the currency
	 */
	public Integer getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	/**
	 * @return the time_format
	 */
	public Integer getTime_format() {
		return time_format;
	}
	/**
	 * @param time_format the time_format to set
	 */
	public void setTime_format(Integer time_format) {
		this.time_format = time_format;
	}
	/**
	 * @return the user_address
	 */
	public String getUser_address() {
		return user_address;
	}
	/**
	 * @param user_address the user_address to set
	 */
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}
	/**
	 * @param user_key the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the owner_id
	 */
	public Integer getOwner_id() {
		return owner_id;
	}
	/**
	 * @param owner_id the owner_id to set
	 */
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	/**
	 * @return the is_owner
	 */
	public Integer getIs_owner() {
		return is_owner;
	}
	/**
	 * @param is_owner the is_owner to set
	 */
	public void setIs_owner(Integer is_owner) {
		this.is_owner = is_owner;
	}
	/**
	 * @return the role_id
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**
	 * @return the fleet_size
	 */
	public Integer getFleet_size() {
		return fleet_size;
	}
	/**
	 * @param fleet_size the fleet_size to set
	 */
	public void setFleet_size(Integer fleet_size) {
		this.fleet_size = fleet_size;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the user_image
	 */
	public String getUser_image() {
		return user_image;
	}
	/**
	 * @param user_image the user_image to set
	 */
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	/**
	 * @return the phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	/**
	 * @return the group_id
	 */
	public Integer getGroup_id() {
		return group_id;
	}
	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	/**
	 * @return the group_color
	 */
	public String getGroup_color() {
		return group_color;
	}
	/**
	 * @param group_color the group_color to set
	 */
	public void setGroup_color(String group_color) {
		this.group_color = group_color;
	}
	/**
	 * @return the organization_name
	 */
	public String getOrganization_name() {
		return organization_name;
	}
	/**
	 * @param organization_name the organization_name to set
	 */
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	/**
	 * @return the group_name
	 */
	public String getGroup_name() {
		return group_name;
	}
	/**
	 * @param group_name the group_name to set
	 */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	/**
	 * @return the group_path
	 */
	public String getGroup_path() {
		return group_path;
	}
	/**
	 * @param group_path the group_path to set
	 */
	public void setGroup_path(String group_path) {
		this.group_path = group_path;
	}
	/**
	 * @return the group_level
	 */
	public Integer getGroup_level() {
		return group_level;
	}
	/**
	 * @param group_level the group_level to set
	 */
	public void setGroup_level(Integer group_level) {
		this.group_level = group_level;
	}
	/**
	 * @return the fuel_type
	 */
	public String getFuel_type() {
		return fuel_type;
	}
	/**
	 * @param fuel_type the fuel_type to set
	 */
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	/**
	 * @return the tag_id
	 */
	public String getTag_id() {
		return tag_id;
	}
	/**
	 * @param tag_id the tag_id to set
	 */
	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}
	/**
	 * @return the vehicle_tags_id
	 */
	public String getVehicle_tags_id() {
		return vehicle_tags_id;
	}
	/**
	 * @param vehicle_tags_id the vehicle_tags_id to set
	 */
	public void setVehicle_tags_id(String vehicle_tags_id) {
		this.vehicle_tags_id = vehicle_tags_id;
	}
	/**
	 * @return the tag_name
	 */
	public String getTag_name() {
		return tag_name;
	}
	/**
	 * @param tag_name the tag_name to set
	 */
	public void setTag_name(String tag_name) {
		this.tag_name = tag_name;
	}
	/**
	 * @return the lat_list
	 */
	public String getLat_list() {
		return lat_list;
	}
	/**
	 * @param lat_list the lat_list to set
	 */
	public void setLat_list(String lat_list) {
		this.lat_list = lat_list;
	}
	/**
	 * @return the long_list
	 */
	public String getLong_list() {
		return long_list;
	}
	/**
	 * @param long_list the long_list to set
	 */
	public void setLong_list(String long_list) {
		this.long_list = long_list;
	}
	/**
	 * @return the time_list
	 */
	public String getTime_list() {
		return time_list;
	}
	/**
	 * @param time_list the time_list to set
	 */
	public void setTime_list(String time_list) {
		this.time_list = time_list;
	}
	/**
	 * @return the vehicle_trips_id
	 */
	public Integer getVehicle_trips_id() {
		return vehicle_trips_id;
	}
	/**
	 * @param vehicle_trips_id the vehicle_trips_id to set
	 */
	public void setVehicle_trips_id(Integer vehicle_trips_id) {
		this.vehicle_trips_id = vehicle_trips_id;
	}
	/**
	 * @return the trip_id
	 */
	public String getTrip_id() {
		return trip_id;
	}
	/**
	 * @param trip_id the trip_id to set
	 */
	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}
	/**
	 * @return the fuel_consumption
	 */
	public Float getFuel_consumption() {
		return fuel_consumption;
	}
	/**
	 * @param fuel_consumption the fuel_consumption to set
	 */
	public void setFuel_consumption(Float fuel_consumption) {
		this.fuel_consumption = fuel_consumption;
	}
	/**
	 * @return the distance
	 */
	public Float getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	/**
	 * @return the mileage_kmpl
	 */
	public Float getMileage_kmpl() {
		return mileage_kmpl;
	}
	/**
	 * @param mileage_kmpl the mileage_kmpl to set
	 */
	public void setMileage_kmpl(Float mileage_kmpl) {
		this.mileage_kmpl = mileage_kmpl;
	}
	/**
	 * @return the vehicle_trips_start_time
	 */
	public long getVehicle_trips_start_time() {
		return vehicle_trips_start_time;
	}
	/**
	 * @param vehicle_trips_start_time the vehicle_trips_start_time to set
	 */
	public void setVehicle_trips_start_time(long vehicle_trips_start_time) {
		this.vehicle_trips_start_time = vehicle_trips_start_time;
	}
	/**
	 * @return the vehicle_trips_end_time
	 */
	public long getVehicle_trips_end_time() {
		return vehicle_trips_end_time;
	}
	/**
	 * @param vehicle_trips_end_time the vehicle_trips_end_time to set
	 */
	public void setVehicle_trips_end_time(long vehicle_trips_end_time) {
		this.vehicle_trips_end_time = vehicle_trips_end_time;
	}
	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * @return the trip_duration
	 */
	public Float getTrip_duration() {
		return trip_duration;
	}
	/**
	 * @param trip_duration the trip_duration to set
	 */
	public void setTrip_duration(Float trip_duration) {
		this.trip_duration = trip_duration;
	}
	/**
	 * @return the harsh_brake
	 */
	public Integer getHarsh_brake() {
		return harsh_brake;
	}
	/**
	 * @param harsh_brake the harsh_brake to set
	 */
	public void setHarsh_brake(Integer harsh_brake) {
		this.harsh_brake = harsh_brake;
	}
	/**
	 * @return the avg_speed
	 */
	public Float getAvg_speed() {
		return avg_speed;
	}
	/**
	 * @param avg_speed the avg_speed to set
	 */
	public void setAvg_speed(Float avg_speed) {
		this.avg_speed = avg_speed;
	}
	/**
	 * @return the hard_acceleration
	 */
	public Integer getHard_acceleration() {
		return hard_acceleration;
	}
	/**
	 * @param hard_acceleration the hard_acceleration to set
	 */
	public void setHard_acceleration(Integer hard_acceleration) {
		this.hard_acceleration = hard_acceleration;
	}
	/**
	 * @return the driver_score
	 */
	public Float getDriver_score() {
		return driver_score;
	}
	/**
	 * @param driver_score the driver_score to set
	 */
	public void setDriver_score(Float driver_score) {
		this.driver_score = driver_score;
	}
	/**
	 * @return the vehicle_score
	 */
	public Float getVehicle_score() {
		return vehicle_score;
	}
	/**
	 * @param vehicle_score the vehicle_score to set
	 */
	public void setVehicle_score(Float vehicle_score) {
		this.vehicle_score = vehicle_score;
	}
	/**
	 * @return the start_latitude
	 */
	public double getStart_latitude() {
		return start_latitude;
	}
	/**
	 * @param start_latitude the start_latitude to set
	 */
	public void setStart_latitude(double start_latitude) {
		this.start_latitude = start_latitude;
	}
	/**
	 * @return the start_longitude
	 */
	public double getStart_longitude() {
		return start_longitude;
	}
	/**
	 * @param start_longitude the start_longitude to set
	 */
	public void setStart_longitude(double start_longitude) {
		this.start_longitude = start_longitude;
	}
	/**
	 * @return the start_address
	 */
	public String getStart_address() {
		return start_address;
	}
	/**
	 * @param start_address the start_address to set
	 */
	public void setStart_address(String start_address) {
		this.start_address = start_address;
	}
	/**
	 * @return the end_latitude
	 */
	public double getEnd_latitude() {
		return end_latitude;
	}
	/**
	 * @param end_latitude the end_latitude to set
	 */
	public void setEnd_latitude(double end_latitude) {
		this.end_latitude = end_latitude;
	}
	/**
	 * @return the end_longitude
	 */
	public double getEnd_longitude() {
		return end_longitude;
	}
	/**
	 * @param end_longitude the end_longitude to set
	 */
	public void setEnd_longitude(double end_longitude) {
		this.end_longitude = end_longitude;
	}
	/**
	 * @return the end_address
	 */
	public String getEnd_address() {
		return end_address;
	}
	/**
	 * @param end_address the end_address to set
	 */
	public void setEnd_address(String end_address) {
		this.end_address = end_address;
	}
	/**
	 * @return the fuel_score
	 */
	public Float getFuel_score() {
		return fuel_score;
	}
	/**
	 * @param fuel_score the fuel_score to set
	 */
	public void setFuel_score(Float fuel_score) {
		this.fuel_score = fuel_score;
	}
	/**
	 * @return the throttle_opening_numbers
	 */
	public Integer getThrottle_opening_numbers() {
		return throttle_opening_numbers;
	}
	/**
	 * @param throttle_opening_numbers the throttle_opening_numbers to set
	 */
	public void setThrottle_opening_numbers(Integer throttle_opening_numbers) {
		this.throttle_opening_numbers = throttle_opening_numbers;
	}
	/**
	 * @return the over_speeding_time
	 */
	public Float getOver_speeding_time() {
		return over_speeding_time;
	}
	/**
	 * @param over_speeding_time the over_speeding_time to set
	 */
	public void setOver_speeding_time(Float over_speeding_time) {
		this.over_speeding_time = over_speeding_time;
	}
	/**
	 * @return the idling_time
	 */
	public Float getIdling_time() {
		return idling_time;
	}
	/**
	 * @param idling_time the idling_time to set
	 */
	public void setIdling_time(Float idling_time) {
		this.idling_time = idling_time;
	}
	/**
	 * @return the idling_fuel_consumed
	 */
	public Float getIdling_fuel_consumed() {
		return idling_fuel_consumed;
	}
	/**
	 * @param idling_fuel_consumed the idling_fuel_consumed to set
	 */
	public void setIdling_fuel_consumed(Float idling_fuel_consumed) {
		this.idling_fuel_consumed = idling_fuel_consumed;
	}
	/**
	 * @return the currency_name
	 */
	public String getCurrency_name() {
		return currency_name;
	}
	/**
	 * @param currency_name the currency_name to set
	 */
	public void setCurrency_name(String currency_name) {
		this.currency_name = currency_name;
	}
	/**
	 * @return the currency_alias
	 */
	public String getCurrency_alias() {
		return currency_alias;
	}
	/**
	 * @param currency_alias the currency_alias to set
	 */
	public void setCurrency_alias(String currency_alias) {
		this.currency_alias = currency_alias;
	}
	
}