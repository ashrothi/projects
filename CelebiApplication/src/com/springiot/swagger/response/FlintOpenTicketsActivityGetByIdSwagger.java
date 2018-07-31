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
 * This class contains response on /flint/open/tickets/activity/get/by/id API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintOpenTicketsActivityGetByIdSwagger {
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

	private List<FlintOpenTicketsActivityGetById> object;

	/**
	 * @return the object
	 */
	public List<FlintOpenTicketsActivityGetById> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintOpenTicketsActivityGetById> object) {
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
class FlintOpenTicketsActivityGetById {
	private String ticket_id;
	private String task_id;
	private String task_status;
	private String created_by;
	private String creation_time;
	private String last_modified_by;    
	private String activity_remarks;
	private String ticket_alias;
	private String ticket_task_alias;
	private String task_status_id;
	private String task_status_name;
	private String task_status_alias;
	private String task_status_colour_code;
	private String task_status_sequence_number;
	private String task_status_is_shown_on_android;
	private String task_status_is_shown_on_web;
	private String task_status_data_type;
	private String task_status_image;
	private String open_tickets_id;
	private String open_tickets_ticket_id;
	private String open_tickets_task_id;
	private String open_tickets_consignee_name;
	private String open_tickets_consigner_name;
	private String open_tickets_reciever_name;
	private String open_tickets_task_name;
	private String open_tickets_task_alias;
	private String open_tickets_task_status;
	private String open_tickets_pickup_country;
	private String open_tickets_pickup_state;
	private String open_tickets_pickup_city;
	private String open_tickets_pickup_city_name;
	private String open_tickets_pickup_city_alias;
	private String open_tickets_pickup_address;
	private String open_tickets_pickup_landmark;
	private String open_tickets_pickup_contact_no;
	private String open_tickets_consignee_key;
	private String open_tickets_dropoff_country;
	private String open_tickets_dropoff_state;
	private String open_tickets_dropoff_city;
	private String open_tickets_dropoff_city_name;
	private String open_tickets_dropoff_city_alias;
	private String open_tickets_dropoff_address;
	private String open_tickets_dropoff_landmark;
	private String open_tickets_dropoff_contact_no;
	private String open_tickets_consigner_key;
	private String open_tickets_product_type;
	private String open_tickets_product_value;
	private String open_tickets_number_of_items;
	private String open_tickets_volume_in_weight;
	private String open_tickets_volume_in_percentage;
	private String open_tickets_sla;
	private String open_tickets_estimated_arrival_days;
	private String open_tickets_vehicle_id;
	private String open_tickets_created_by;	
	private String open_tickets_last_modified_by;    
	private String open_tickets_pickup_date;
	private String open_tickets_pickup_lat;
	private String open_tickets_pickup_long;
	private String open_tickets_dropoff_date;
	private String open_tickets_dropoff_lat;
	private String open_tickets_dropoff_long;
	private String open_tickets_time_stamp;
	private String open_tickets_is_task_closed;
	private String open_tickets_remarks;
	private String open_tickets_ticket_alias;
	private String open_tickets_ticket_task_alias ;
	private String distance_from_source;
	private String pickup_email_id;
	private String dropoff_email_id;
	private String driver_first_name;
	private String driver_middle_name ;
	private String driver_last_name;
	private String driver_contact_number;
	/**
	 * @return the ticket_id
	 */
	public String getTicket_id() {
		return ticket_id;
	}
	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}
	/**
	 * @return the task_id
	 */
	public String getTask_id() {
		return task_id;
	}
	/**
	 * @param task_id the task_id to set
	 */
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	/**
	 * @return the task_status
	 */
	public String getTask_status() {
		return task_status;
	}
	/**
	 * @param task_status the task_status to set
	 */
	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}
	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	/**
	 * @return the creation_time
	 */
	public String getCreation_time() {
		return creation_time;
	}
	/**
	 * @param creation_time the creation_time to set
	 */
	public void setCreation_time(String creation_time) {
		this.creation_time = creation_time;
	}
	/**
	 * @return the last_modified_by
	 */
	public String getLast_modified_by() {
		return last_modified_by;
	}
	/**
	 * @param last_modified_by the last_modified_by to set
	 */
	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	/**
	 * @return the activity_remarks
	 */
	public String getActivity_remarks() {
		return activity_remarks;
	}
	/**
	 * @param activity_remarks the activity_remarks to set
	 */
	public void setActivity_remarks(String activity_remarks) {
		this.activity_remarks = activity_remarks;
	}
	/**
	 * @return the ticket_alias
	 */
	public String getTicket_alias() {
		return ticket_alias;
	}
	/**
	 * @param ticket_alias the ticket_alias to set
	 */
	public void setTicket_alias(String ticket_alias) {
		this.ticket_alias = ticket_alias;
	}
	/**
	 * @return the ticket_task_alias
	 */
	public String getTicket_task_alias() {
		return ticket_task_alias;
	}
	/**
	 * @param ticket_task_alias the ticket_task_alias to set
	 */
	public void setTicket_task_alias(String ticket_task_alias) {
		this.ticket_task_alias = ticket_task_alias;
	}
	/**
	 * @return the task_status_id
	 */
	public String getTask_status_id() {
		return task_status_id;
	}
	/**
	 * @param task_status_id the task_status_id to set
	 */
	public void setTask_status_id(String task_status_id) {
		this.task_status_id = task_status_id;
	}
	/**
	 * @return the task_status_name
	 */
	public String getTask_status_name() {
		return task_status_name;
	}
	/**
	 * @param task_status_name the task_status_name to set
	 */
	public void setTask_status_name(String task_status_name) {
		this.task_status_name = task_status_name;
	}
	/**
	 * @return the task_status_alias
	 */
	public String getTask_status_alias() {
		return task_status_alias;
	}
	/**
	 * @param task_status_alias the task_status_alias to set
	 */
	public void setTask_status_alias(String task_status_alias) {
		this.task_status_alias = task_status_alias;
	}
	/**
	 * @return the task_status_colour_code
	 */
	public String getTask_status_colour_code() {
		return task_status_colour_code;
	}
	/**
	 * @param task_status_colour_code the task_status_colour_code to set
	 */
	public void setTask_status_colour_code(String task_status_colour_code) {
		this.task_status_colour_code = task_status_colour_code;
	}
	/**
	 * @return the task_status_sequence_number
	 */
	public String getTask_status_sequence_number() {
		return task_status_sequence_number;
	}
	/**
	 * @param task_status_sequence_number the task_status_sequence_number to set
	 */
	public void setTask_status_sequence_number(String task_status_sequence_number) {
		this.task_status_sequence_number = task_status_sequence_number;
	}
	/**
	 * @return the task_status_is_shown_on_android
	 */
	public String getTask_status_is_shown_on_android() {
		return task_status_is_shown_on_android;
	}
	/**
	 * @param task_status_is_shown_on_android the task_status_is_shown_on_android to set
	 */
	public void setTask_status_is_shown_on_android(String task_status_is_shown_on_android) {
		this.task_status_is_shown_on_android = task_status_is_shown_on_android;
	}
	/**
	 * @return the task_status_is_shown_on_web
	 */
	public String getTask_status_is_shown_on_web() {
		return task_status_is_shown_on_web;
	}
	/**
	 * @param task_status_is_shown_on_web the task_status_is_shown_on_web to set
	 */
	public void setTask_status_is_shown_on_web(String task_status_is_shown_on_web) {
		this.task_status_is_shown_on_web = task_status_is_shown_on_web;
	}
	/**
	 * @return the task_status_data_type
	 */
	public String getTask_status_data_type() {
		return task_status_data_type;
	}
	/**
	 * @param task_status_data_type the task_status_data_type to set
	 */
	public void setTask_status_data_type(String task_status_data_type) {
		this.task_status_data_type = task_status_data_type;
	}
	/**
	 * @return the task_status_image
	 */
	public String getTask_status_image() {
		return task_status_image;
	}
	/**
	 * @param task_status_image the task_status_image to set
	 */
	public void setTask_status_image(String task_status_image) {
		this.task_status_image = task_status_image;
	}
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
	 * @return the open_tickets_task_name
	 */
	public String getOpen_tickets_task_name() {
		return open_tickets_task_name;
	}
	/**
	 * @param open_tickets_task_name the open_tickets_task_name to set
	 */
	public void setOpen_tickets_task_name(String open_tickets_task_name) {
		this.open_tickets_task_name = open_tickets_task_name;
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
	 * @return the open_tickets_pickup_city_name
	 */
	public String getOpen_tickets_pickup_city_name() {
		return open_tickets_pickup_city_name;
	}
	/**
	 * @param open_tickets_pickup_city_name the open_tickets_pickup_city_name to set
	 */
	public void setOpen_tickets_pickup_city_name(String open_tickets_pickup_city_name) {
		this.open_tickets_pickup_city_name = open_tickets_pickup_city_name;
	}
	/**
	 * @return the open_tickets_pickup_city_alias
	 */
	public String getOpen_tickets_pickup_city_alias() {
		return open_tickets_pickup_city_alias;
	}
	/**
	 * @param open_tickets_pickup_city_alias the open_tickets_pickup_city_alias to set
	 */
	public void setOpen_tickets_pickup_city_alias(String open_tickets_pickup_city_alias) {
		this.open_tickets_pickup_city_alias = open_tickets_pickup_city_alias;
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
	 * @return the open_tickets_dropoff_city_name
	 */
	public String getOpen_tickets_dropoff_city_name() {
		return open_tickets_dropoff_city_name;
	}
	/**
	 * @param open_tickets_dropoff_city_name the open_tickets_dropoff_city_name to set
	 */
	public void setOpen_tickets_dropoff_city_name(String open_tickets_dropoff_city_name) {
		this.open_tickets_dropoff_city_name = open_tickets_dropoff_city_name;
	}
	/**
	 * @return the open_tickets_dropoff_city_alias
	 */
	public String getOpen_tickets_dropoff_city_alias() {
		return open_tickets_dropoff_city_alias;
	}
	/**
	 * @param open_tickets_dropoff_city_alias the open_tickets_dropoff_city_alias to set
	 */
	public void setOpen_tickets_dropoff_city_alias(String open_tickets_dropoff_city_alias) {
		this.open_tickets_dropoff_city_alias = open_tickets_dropoff_city_alias;
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
	 * @return the open_tickets_ticket_task_alias
	 */
	public String getOpen_tickets_ticket_task_alias() {
		return open_tickets_ticket_task_alias;
	}
	/**
	 * @param open_tickets_ticket_task_alias the open_tickets_ticket_task_alias to set
	 */
	public void setOpen_tickets_ticket_task_alias(String open_tickets_ticket_task_alias) {
		this.open_tickets_ticket_task_alias = open_tickets_ticket_task_alias;
	}
	/**
	 * @return the distance_from_source
	 */
	public String getDistance_from_source() {
		return distance_from_source;
	}
	/**
	 * @param distance_from_source the distance_from_source to set
	 */
	public void setDistance_from_source(String distance_from_source) {
		this.distance_from_source = distance_from_source;
	}
	/**
	 * @return the pickup_email_id
	 */
	public String getPickup_email_id() {
		return pickup_email_id;
	}
	/**
	 * @param pickup_email_id the pickup_email_id to set
	 */
	public void setPickup_email_id(String pickup_email_id) {
		this.pickup_email_id = pickup_email_id;
	}
	/**
	 * @return the dropoff_email_id
	 */
	public String getDropoff_email_id() {
		return dropoff_email_id;
	}
	/**
	 * @param dropoff_email_id the dropoff_email_id to set
	 */
	public void setDropoff_email_id(String dropoff_email_id) {
		this.dropoff_email_id = dropoff_email_id;
	}
	/**
	 * @return the driver_first_name
	 */
	public String getDriver_first_name() {
		return driver_first_name;
	}
	/**
	 * @param driver_first_name the driver_first_name to set
	 */
	public void setDriver_first_name(String driver_first_name) {
		this.driver_first_name = driver_first_name;
	}
	/**
	 * @return the driver_middle_name
	 */
	public String getDriver_middle_name() {
		return driver_middle_name;
	}
	/**
	 * @param driver_middle_name the driver_middle_name to set
	 */
	public void setDriver_middle_name(String driver_middle_name) {
		this.driver_middle_name = driver_middle_name;
	}
	/**
	 * @return the driver_last_name
	 */
	public String getDriver_last_name() {
		return driver_last_name;
	}
	/**
	 * @param driver_last_name the driver_last_name to set
	 */
	public void setDriver_last_name(String driver_last_name) {
		this.driver_last_name = driver_last_name;
	}
	/**
	 * @return the driver_contact_number
	 */
	public String getDriver_contact_number() {
		return driver_contact_number;
	}
	/**
	 * @param driver_contact_number the driver_contact_number to set
	 */
	public void setDriver_contact_number(String driver_contact_number) {
		this.driver_contact_number = driver_contact_number;
	}

}
