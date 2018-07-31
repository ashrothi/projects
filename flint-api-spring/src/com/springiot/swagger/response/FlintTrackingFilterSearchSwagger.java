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
 * This class contains response on /flint/tracking/filter/search API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintTrackingFilterSearchSwagger {
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

	private List<FlintTrackingFilterSearch> object;

	/**
	 * @return the object
	 */
	public List<FlintTrackingFilterSearch> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintTrackingFilterSearch> object) {
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
class FlintTrackingFilterSearch {
	private String open_tickets_id; 
	private String  open_tickets_ticket_id;  
	private String  total_open_tickets; 
	private String  open_tickets_task_id;  
	  
	private String  open_tickets_task_alias;  
	private String 	open_tickets_task_status; 
	private String open_tickets_consignee_name; 
	private String open_tickets_consigner_name; 
	private String open_tickets_reciever_name;  
	private String open_tickets_pickup_country;  
	private String open_tickets_pickup_state;  
	private String  open_tickets_pickup_city;   
	private String  open_tickets_pickup_address ;  
	private String  open_tickets_pickup_landmark;  
	private String  open_tickets_pickup_contact_no;  
	private String  open_tickets_consignee_key;  
	private String  open_tickets_dropoff_country;  
	private String  open_tickets_dropoff_state;  
	private String  open_tickets_dropoff_city;  
	private String open_tickets_dropoff_address;  
	private String  open_tickets_dropoff_landmark;  
	private String  open_tickets_dropoff_contact_no;  
	private String  open_tickets_consigner_key;   
	private String  open_tickets_product_type;  
	private String  open_tickets_product_value;  
	private String  open_tickets_number_of_items;   
	private String  open_tickets_volume_in_weight;  
	private String  open_tickets_volume_in_percentage;  
	private String  open_tickets_sla;  
	private String  open_tickets_estimated_arrival_days;  
	private String  open_tickets_vehicle_id;  
	private String open_tickets_created_by;  
	private String open_tickets_creation_time;  
	private String  open_tickets_last_modified_by;  
	private String  open_tickets_pickup_date;  
	private String  open_tickets_pickup_lat;  
	private String  open_tickets_pickup_long;  
	private String  open_tickets_dropoff_date;  
	private String  open_tickets_dropoff_lat;  
	private String  open_tickets_dropoff_long;  
	private String  open_tickets_time_stamp;  
	private String  open_tickets_is_task_closed;  
	private String  open_tickets_remarks; 
	private String  open_tickets_ticket_alias; 
	private String  open_tickets_last_modified_time; 
	private String open_tickets_pickup_email_id; 
	private String open_tickets_dropoff_email_id; 
	private String open_tickets_distance_from_source; 
	private String  vehicle_id; 
	private String  vehicle_vehicle_id; 
	private String  vehicle_registration_number; 
	private String 	vehicle_number_plate; 
	private String vehicle_model_number; 
	private String vehicle_model_year; 
	private String  vehicle_vehicle_type; 
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
	private String ehicle_longitude; 
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
	private String vehicle_name; 
	private String vehicle_address; 
	private String vehicle_created_by_user_key; 
	private String vehicle_last_modified_by_user_key; 
	private String transporter_organization_path; 
	private String device_driver_vehicle_device_id;
	/**
	 * @return the open_tickets_id
	 */
	public String getOpen_tickets_id() {
		return open_tickets_id;
	}
	/**
	 * @param open_tickets_id the open_tickets_id to set
	 */
	public void setOpen_tickets_id(String open_tickets_id) {
		this.open_tickets_id = open_tickets_id;
	}
	/**
	 * @return the open_tickets_ticket_id
	 */
	public String getOpen_tickets_ticket_id() {
		return open_tickets_ticket_id;
	}
	/**
	 * @param open_tickets_ticket_id the open_tickets_ticket_id to set
	 */
	public void setOpen_tickets_ticket_id(String open_tickets_ticket_id) {
		this.open_tickets_ticket_id = open_tickets_ticket_id;
	}
	/**
	 * @return the total_open_tickets
	 */
	public String getTotal_open_tickets() {
		return total_open_tickets;
	}
	/**
	 * @param total_open_tickets the total_open_tickets to set
	 */
	public void setTotal_open_tickets(String total_open_tickets) {
		this.total_open_tickets = total_open_tickets;
	}
	/**
	 * @return the open_tickets_task_id
	 */
	public String getOpen_tickets_task_id() {
		return open_tickets_task_id;
	}
	/**
	 * @param open_tickets_task_id the open_tickets_task_id to set
	 */
	public void setOpen_tickets_task_id(String open_tickets_task_id) {
		this.open_tickets_task_id = open_tickets_task_id;
	}
	/**
	 * @return the open_tickets_task_alias
	 */
	public String getOpen_tickets_task_alias() {
		return open_tickets_task_alias;
	}
	/**
	 * @param open_tickets_task_alias the open_tickets_task_alias to set
	 */
	public void setOpen_tickets_task_alias(String open_tickets_task_alias) {
		this.open_tickets_task_alias = open_tickets_task_alias;
	}
	/**
	 * @return the open_tickets_task_status
	 */
	public String getOpen_tickets_task_status() {
		return open_tickets_task_status;
	}
	/**
	 * @param open_tickets_task_status the open_tickets_task_status to set
	 */
	public void setOpen_tickets_task_status(String open_tickets_task_status) {
		this.open_tickets_task_status = open_tickets_task_status;
	}
	/**
	 * @return the open_tickets_consignee_name
	 */
	public String getOpen_tickets_consignee_name() {
		return open_tickets_consignee_name;
	}
	/**
	 * @param open_tickets_consignee_name the open_tickets_consignee_name to set
	 */
	public void setOpen_tickets_consignee_name(String open_tickets_consignee_name) {
		this.open_tickets_consignee_name = open_tickets_consignee_name;
	}
	/**
	 * @return the open_tickets_consigner_name
	 */
	public String getOpen_tickets_consigner_name() {
		return open_tickets_consigner_name;
	}
	/**
	 * @param open_tickets_consigner_name the open_tickets_consigner_name to set
	 */
	public void setOpen_tickets_consigner_name(String open_tickets_consigner_name) {
		this.open_tickets_consigner_name = open_tickets_consigner_name;
	}
	/**
	 * @return the open_tickets_reciever_name
	 */
	public String getOpen_tickets_reciever_name() {
		return open_tickets_reciever_name;
	}
	/**
	 * @param open_tickets_reciever_name the open_tickets_reciever_name to set
	 */
	public void setOpen_tickets_reciever_name(String open_tickets_reciever_name) {
		this.open_tickets_reciever_name = open_tickets_reciever_name;
	}
	/**
	 * @return the open_tickets_pickup_country
	 */
	public String getOpen_tickets_pickup_country() {
		return open_tickets_pickup_country;
	}
	/**
	 * @param open_tickets_pickup_country the open_tickets_pickup_country to set
	 */
	public void setOpen_tickets_pickup_country(String open_tickets_pickup_country) {
		this.open_tickets_pickup_country = open_tickets_pickup_country;
	}
	/**
	 * @return the open_tickets_pickup_state
	 */
	public String getOpen_tickets_pickup_state() {
		return open_tickets_pickup_state;
	}
	/**
	 * @param open_tickets_pickup_state the open_tickets_pickup_state to set
	 */
	public void setOpen_tickets_pickup_state(String open_tickets_pickup_state) {
		this.open_tickets_pickup_state = open_tickets_pickup_state;
	}
	/**
	 * @return the open_tickets_pickup_city
	 */
	public String getOpen_tickets_pickup_city() {
		return open_tickets_pickup_city;
	}
	/**
	 * @param open_tickets_pickup_city the open_tickets_pickup_city to set
	 */
	public void setOpen_tickets_pickup_city(String open_tickets_pickup_city) {
		this.open_tickets_pickup_city = open_tickets_pickup_city;
	}
	/**
	 * @return the open_tickets_pickup_address
	 */
	public String getOpen_tickets_pickup_address() {
		return open_tickets_pickup_address;
	}
	/**
	 * @param open_tickets_pickup_address the open_tickets_pickup_address to set
	 */
	public void setOpen_tickets_pickup_address(String open_tickets_pickup_address) {
		this.open_tickets_pickup_address = open_tickets_pickup_address;
	}
	/**
	 * @return the open_tickets_pickup_landmark
	 */
	public String getOpen_tickets_pickup_landmark() {
		return open_tickets_pickup_landmark;
	}
	/**
	 * @param open_tickets_pickup_landmark the open_tickets_pickup_landmark to set
	 */
	public void setOpen_tickets_pickup_landmark(String open_tickets_pickup_landmark) {
		this.open_tickets_pickup_landmark = open_tickets_pickup_landmark;
	}
	/**
	 * @return the open_tickets_pickup_contact_no
	 */
	public String getOpen_tickets_pickup_contact_no() {
		return open_tickets_pickup_contact_no;
	}
	/**
	 * @param open_tickets_pickup_contact_no the open_tickets_pickup_contact_no to set
	 */
	public void setOpen_tickets_pickup_contact_no(String open_tickets_pickup_contact_no) {
		this.open_tickets_pickup_contact_no = open_tickets_pickup_contact_no;
	}
	/**
	 * @return the open_tickets_consignee_key
	 */
	public String getOpen_tickets_consignee_key() {
		return open_tickets_consignee_key;
	}
	/**
	 * @param open_tickets_consignee_key the open_tickets_consignee_key to set
	 */
	public void setOpen_tickets_consignee_key(String open_tickets_consignee_key) {
		this.open_tickets_consignee_key = open_tickets_consignee_key;
	}
	/**
	 * @return the open_tickets_dropoff_country
	 */
	public String getOpen_tickets_dropoff_country() {
		return open_tickets_dropoff_country;
	}
	/**
	 * @param open_tickets_dropoff_country the open_tickets_dropoff_country to set
	 */
	public void setOpen_tickets_dropoff_country(String open_tickets_dropoff_country) {
		this.open_tickets_dropoff_country = open_tickets_dropoff_country;
	}
	/**
	 * @return the open_tickets_dropoff_state
	 */
	public String getOpen_tickets_dropoff_state() {
		return open_tickets_dropoff_state;
	}
	/**
	 * @param open_tickets_dropoff_state the open_tickets_dropoff_state to set
	 */
	public void setOpen_tickets_dropoff_state(String open_tickets_dropoff_state) {
		this.open_tickets_dropoff_state = open_tickets_dropoff_state;
	}
	/**
	 * @return the open_tickets_dropoff_city
	 */
	public String getOpen_tickets_dropoff_city() {
		return open_tickets_dropoff_city;
	}
	/**
	 * @param open_tickets_dropoff_city the open_tickets_dropoff_city to set
	 */
	public void setOpen_tickets_dropoff_city(String open_tickets_dropoff_city) {
		this.open_tickets_dropoff_city = open_tickets_dropoff_city;
	}
	/**
	 * @return the open_tickets_dropoff_address
	 */
	public String getOpen_tickets_dropoff_address() {
		return open_tickets_dropoff_address;
	}
	/**
	 * @param open_tickets_dropoff_address the open_tickets_dropoff_address to set
	 */
	public void setOpen_tickets_dropoff_address(String open_tickets_dropoff_address) {
		this.open_tickets_dropoff_address = open_tickets_dropoff_address;
	}
	/**
	 * @return the open_tickets_dropoff_landmark
	 */
	public String getOpen_tickets_dropoff_landmark() {
		return open_tickets_dropoff_landmark;
	}
	/**
	 * @param open_tickets_dropoff_landmark the open_tickets_dropoff_landmark to set
	 */
	public void setOpen_tickets_dropoff_landmark(String open_tickets_dropoff_landmark) {
		this.open_tickets_dropoff_landmark = open_tickets_dropoff_landmark;
	}
	/**
	 * @return the open_tickets_dropoff_contact_no
	 */
	public String getOpen_tickets_dropoff_contact_no() {
		return open_tickets_dropoff_contact_no;
	}
	/**
	 * @param open_tickets_dropoff_contact_no the open_tickets_dropoff_contact_no to set
	 */
	public void setOpen_tickets_dropoff_contact_no(String open_tickets_dropoff_contact_no) {
		this.open_tickets_dropoff_contact_no = open_tickets_dropoff_contact_no;
	}
	/**
	 * @return the open_tickets_consigner_key
	 */
	public String getOpen_tickets_consigner_key() {
		return open_tickets_consigner_key;
	}
	/**
	 * @param open_tickets_consigner_key the open_tickets_consigner_key to set
	 */
	public void setOpen_tickets_consigner_key(String open_tickets_consigner_key) {
		this.open_tickets_consigner_key = open_tickets_consigner_key;
	}
	/**
	 * @return the open_tickets_product_type
	 */
	public String getOpen_tickets_product_type() {
		return open_tickets_product_type;
	}
	/**
	 * @param open_tickets_product_type the open_tickets_product_type to set
	 */
	public void setOpen_tickets_product_type(String open_tickets_product_type) {
		this.open_tickets_product_type = open_tickets_product_type;
	}
	/**
	 * @return the open_tickets_product_value
	 */
	public String getOpen_tickets_product_value() {
		return open_tickets_product_value;
	}
	/**
	 * @param open_tickets_product_value the open_tickets_product_value to set
	 */
	public void setOpen_tickets_product_value(String open_tickets_product_value) {
		this.open_tickets_product_value = open_tickets_product_value;
	}
	/**
	 * @return the open_tickets_number_of_items
	 */
	public String getOpen_tickets_number_of_items() {
		return open_tickets_number_of_items;
	}
	/**
	 * @param open_tickets_number_of_items the open_tickets_number_of_items to set
	 */
	public void setOpen_tickets_number_of_items(String open_tickets_number_of_items) {
		this.open_tickets_number_of_items = open_tickets_number_of_items;
	}
	/**
	 * @return the open_tickets_volume_in_weight
	 */
	public String getOpen_tickets_volume_in_weight() {
		return open_tickets_volume_in_weight;
	}
	/**
	 * @param open_tickets_volume_in_weight the open_tickets_volume_in_weight to set
	 */
	public void setOpen_tickets_volume_in_weight(String open_tickets_volume_in_weight) {
		this.open_tickets_volume_in_weight = open_tickets_volume_in_weight;
	}
	/**
	 * @return the open_tickets_volume_in_percentage
	 */
	public String getOpen_tickets_volume_in_percentage() {
		return open_tickets_volume_in_percentage;
	}
	/**
	 * @param open_tickets_volume_in_percentage the open_tickets_volume_in_percentage to set
	 */
	public void setOpen_tickets_volume_in_percentage(String open_tickets_volume_in_percentage) {
		this.open_tickets_volume_in_percentage = open_tickets_volume_in_percentage;
	}
	/**
	 * @return the open_tickets_sla
	 */
	public String getOpen_tickets_sla() {
		return open_tickets_sla;
	}
	/**
	 * @param open_tickets_sla the open_tickets_sla to set
	 */
	public void setOpen_tickets_sla(String open_tickets_sla) {
		this.open_tickets_sla = open_tickets_sla;
	}
	/**
	 * @return the open_tickets_estimated_arrival_days
	 */
	public String getOpen_tickets_estimated_arrival_days() {
		return open_tickets_estimated_arrival_days;
	}
	/**
	 * @param open_tickets_estimated_arrival_days the open_tickets_estimated_arrival_days to set
	 */
	public void setOpen_tickets_estimated_arrival_days(String open_tickets_estimated_arrival_days) {
		this.open_tickets_estimated_arrival_days = open_tickets_estimated_arrival_days;
	}
	/**
	 * @return the open_tickets_vehicle_id
	 */
	public String getOpen_tickets_vehicle_id() {
		return open_tickets_vehicle_id;
	}
	/**
	 * @param open_tickets_vehicle_id the open_tickets_vehicle_id to set
	 */
	public void setOpen_tickets_vehicle_id(String open_tickets_vehicle_id) {
		this.open_tickets_vehicle_id = open_tickets_vehicle_id;
	}
	/**
	 * @return the open_tickets_created_by
	 */
	public String getOpen_tickets_created_by() {
		return open_tickets_created_by;
	}
	/**
	 * @param open_tickets_created_by the open_tickets_created_by to set
	 */
	public void setOpen_tickets_created_by(String open_tickets_created_by) {
		this.open_tickets_created_by = open_tickets_created_by;
	}
	/**
	 * @return the open_tickets_creation_time
	 */
	public String getOpen_tickets_creation_time() {
		return open_tickets_creation_time;
	}
	/**
	 * @param open_tickets_creation_time the open_tickets_creation_time to set
	 */
	public void setOpen_tickets_creation_time(String open_tickets_creation_time) {
		this.open_tickets_creation_time = open_tickets_creation_time;
	}
	/**
	 * @return the open_tickets_last_modified_by
	 */
	public String getOpen_tickets_last_modified_by() {
		return open_tickets_last_modified_by;
	}
	/**
	 * @param open_tickets_last_modified_by the open_tickets_last_modified_by to set
	 */
	public void setOpen_tickets_last_modified_by(String open_tickets_last_modified_by) {
		this.open_tickets_last_modified_by = open_tickets_last_modified_by;
	}
	/**
	 * @return the open_tickets_pickup_date
	 */
	public String getOpen_tickets_pickup_date() {
		return open_tickets_pickup_date;
	}
	/**
	 * @param open_tickets_pickup_date the open_tickets_pickup_date to set
	 */
	public void setOpen_tickets_pickup_date(String open_tickets_pickup_date) {
		this.open_tickets_pickup_date = open_tickets_pickup_date;
	}
	/**
	 * @return the open_tickets_pickup_lat
	 */
	public String getOpen_tickets_pickup_lat() {
		return open_tickets_pickup_lat;
	}
	/**
	 * @param open_tickets_pickup_lat the open_tickets_pickup_lat to set
	 */
	public void setOpen_tickets_pickup_lat(String open_tickets_pickup_lat) {
		this.open_tickets_pickup_lat = open_tickets_pickup_lat;
	}
	/**
	 * @return the open_tickets_pickup_long
	 */
	public String getOpen_tickets_pickup_long() {
		return open_tickets_pickup_long;
	}
	/**
	 * @param open_tickets_pickup_long the open_tickets_pickup_long to set
	 */
	public void setOpen_tickets_pickup_long(String open_tickets_pickup_long) {
		this.open_tickets_pickup_long = open_tickets_pickup_long;
	}
	/**
	 * @return the open_tickets_dropoff_date
	 */
	public String getOpen_tickets_dropoff_date() {
		return open_tickets_dropoff_date;
	}
	/**
	 * @param open_tickets_dropoff_date the open_tickets_dropoff_date to set
	 */
	public void setOpen_tickets_dropoff_date(String open_tickets_dropoff_date) {
		this.open_tickets_dropoff_date = open_tickets_dropoff_date;
	}
	/**
	 * @return the open_tickets_dropoff_lat
	 */
	public String getOpen_tickets_dropoff_lat() {
		return open_tickets_dropoff_lat;
	}
	/**
	 * @param open_tickets_dropoff_lat the open_tickets_dropoff_lat to set
	 */
	public void setOpen_tickets_dropoff_lat(String open_tickets_dropoff_lat) {
		this.open_tickets_dropoff_lat = open_tickets_dropoff_lat;
	}
	/**
	 * @return the open_tickets_dropoff_long
	 */
	public String getOpen_tickets_dropoff_long() {
		return open_tickets_dropoff_long;
	}
	/**
	 * @param open_tickets_dropoff_long the open_tickets_dropoff_long to set
	 */
	public void setOpen_tickets_dropoff_long(String open_tickets_dropoff_long) {
		this.open_tickets_dropoff_long = open_tickets_dropoff_long;
	}
	/**
	 * @return the open_tickets_time_stamp
	 */
	public String getOpen_tickets_time_stamp() {
		return open_tickets_time_stamp;
	}
	/**
	 * @param open_tickets_time_stamp the open_tickets_time_stamp to set
	 */
	public void setOpen_tickets_time_stamp(String open_tickets_time_stamp) {
		this.open_tickets_time_stamp = open_tickets_time_stamp;
	}
	/**
	 * @return the open_tickets_is_task_closed
	 */
	public String getOpen_tickets_is_task_closed() {
		return open_tickets_is_task_closed;
	}
	/**
	 * @param open_tickets_is_task_closed the open_tickets_is_task_closed to set
	 */
	public void setOpen_tickets_is_task_closed(String open_tickets_is_task_closed) {
		this.open_tickets_is_task_closed = open_tickets_is_task_closed;
	}
	/**
	 * @return the open_tickets_remarks
	 */
	public String getOpen_tickets_remarks() {
		return open_tickets_remarks;
	}
	/**
	 * @param open_tickets_remarks the open_tickets_remarks to set
	 */
	public void setOpen_tickets_remarks(String open_tickets_remarks) {
		this.open_tickets_remarks = open_tickets_remarks;
	}
	/**
	 * @return the open_tickets_ticket_alias
	 */
	public String getOpen_tickets_ticket_alias() {
		return open_tickets_ticket_alias;
	}
	/**
	 * @param open_tickets_ticket_alias the open_tickets_ticket_alias to set
	 */
	public void setOpen_tickets_ticket_alias(String open_tickets_ticket_alias) {
		this.open_tickets_ticket_alias = open_tickets_ticket_alias;
	}
	/**
	 * @return the open_tickets_last_modified_time
	 */
	public String getOpen_tickets_last_modified_time() {
		return open_tickets_last_modified_time;
	}
	/**
	 * @param open_tickets_last_modified_time the open_tickets_last_modified_time to set
	 */
	public void setOpen_tickets_last_modified_time(String open_tickets_last_modified_time) {
		this.open_tickets_last_modified_time = open_tickets_last_modified_time;
	}
	/**
	 * @return the open_tickets_pickup_email_id
	 */
	public String getOpen_tickets_pickup_email_id() {
		return open_tickets_pickup_email_id;
	}
	/**
	 * @param open_tickets_pickup_email_id the open_tickets_pickup_email_id to set
	 */
	public void setOpen_tickets_pickup_email_id(String open_tickets_pickup_email_id) {
		this.open_tickets_pickup_email_id = open_tickets_pickup_email_id;
	}
	/**
	 * @return the open_tickets_dropoff_email_id
	 */
	public String getOpen_tickets_dropoff_email_id() {
		return open_tickets_dropoff_email_id;
	}
	/**
	 * @param open_tickets_dropoff_email_id the open_tickets_dropoff_email_id to set
	 */
	public void setOpen_tickets_dropoff_email_id(String open_tickets_dropoff_email_id) {
		this.open_tickets_dropoff_email_id = open_tickets_dropoff_email_id;
	}
	/**
	 * @return the open_tickets_distance_from_source
	 */
	public String getOpen_tickets_distance_from_source() {
		return open_tickets_distance_from_source;
	}
	/**
	 * @param open_tickets_distance_from_source the open_tickets_distance_from_source to set
	 */
	public void setOpen_tickets_distance_from_source(String open_tickets_distance_from_source) {
		this.open_tickets_distance_from_source = open_tickets_distance_from_source;
	}
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
	 * @return the ehicle_longitude
	 */
	public String getEhicle_longitude() {
		return ehicle_longitude;
	}
	/**
	 * @param ehicle_longitude the ehicle_longitude to set
	 */
	public void setEhicle_longitude(String ehicle_longitude) {
		this.ehicle_longitude = ehicle_longitude;
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
	 * @return the transporter_organization_path
	 */
	public String getTransporter_organization_path() {
		return transporter_organization_path;
	}
	/**
	 * @param transporter_organization_path the transporter_organization_path to set
	 */
	public void setTransporter_organization_path(String transporter_organization_path) {
		this.transporter_organization_path = transporter_organization_path;
	}
	/**
	 * @return the device_driver_vehicle_device_id
	 */
	public String getDevice_driver_vehicle_device_id() {
		return device_driver_vehicle_device_id;
	}
	/**
	 * @param device_driver_vehicle_device_id the device_driver_vehicle_device_id to set
	 */
	public void setDevice_driver_vehicle_device_id(String device_driver_vehicle_device_id) {
		this.device_driver_vehicle_device_id = device_driver_vehicle_device_id;
	}

}
