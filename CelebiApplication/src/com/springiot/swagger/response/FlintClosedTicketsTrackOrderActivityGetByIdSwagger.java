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
 * This class contains response on /flint/closed/tickets/track/order/activity/get/by/id API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintClosedTicketsTrackOrderActivityGetByIdSwagger {
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

	private List<FlintClosedTicketsTrackOrderActivityGetById> object;

	/**
	 * @return the object
	 */
	public List<FlintClosedTicketsTrackOrderActivityGetById> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintClosedTicketsTrackOrderActivityGetById> object) {
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
class FlintClosedTicketsTrackOrderActivityGetById {
	private String ticket_id;
	private String task_id;
	private String task_status;
	private String created_by;
	private String creation_time;
	private String last_modified_by;
	private String last_modified_time;
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
	private String closed_tickets_id;
	private String closed_tickets_ticket_id;
	private String closed_tickets_task_id;
	private String closed_tickets_consignee_name;
	private String closed_tickets_consigner_name;
	private String closed_tickets_reciever_name;
	private String closed_tickets_task_name;
	private String closed_tickets_task_alias;
	private String closed_tickets_task_status;
	private String closed_tickets_pickup_country;
	private String closed_tickets_pickup_state;
	private String closed_tickets_pickup_city;
	private String closed_tickets_pickup_city_name;
	private String closed_tickets_pickup_city_alias;
	private String closed_tickets_pickup_address;
	private String closed_tickets_pickup_landmark;
	private String closed_tickets_pickup_contact_no;
	private String closed_tickets_consignee_key;
	private String closed_tickets_dropoff_country;
	private String closed_tickets_dropoff_state;
	private String closed_tickets_dropoff_city;
	private String closed_tickets_dropoff_city_name;
	private String closed_tickets_dropoff_city_alias;
	private String closed_tickets_dropoff_address;
	private String closed_tickets_dropoff_landmark;
	private String closed_tickets_dropoff_contact_no;
	private String closed_tickets_consigner_key;
	private String closed_tickets_product_type;
	private String closed_tickets_product_value;
	private String closed_tickets_number_of_items;
	private String closed_tickets_volume_in_weight;
	private String closed_tickets_volume_in_percentage;
	private String closed_tickets_sla;
	private String closed_tickets_estimated_arrival_days;
	private String closed_tickets_vehicle_id;
	private String closed_tickets_created_by;
	private String closed_tickets_creation_time;
	private String closed_tickets_last_modified_by;
	private String closed_tickets_last_modified_time;
	private String closed_tickets_pickup_date;
	private String closed_tickets_pickup_lat;
	private String closed_tickets_pickup_long;
	private String closed_tickets_dropoff_date;
	private String closed_tickets_dropoff_lat;
	private String closed_tickets_dropoff_long;
	private String closed_tickets_time_stamp;
	private String closed_tickets_is_task_closed;
	private String closed_tickets_remarks;
	private String closed_tickets_ticket_alias;
	private String closed_tickets_ticket_task_alias;
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
	 * @return the last_modified_time
	 */
	public String getLast_modified_time() {
		return last_modified_time;
	}
	/**
	 * @param last_modified_time the last_modified_time to set
	 */
	public void setLast_modified_time(String last_modified_time) {
		this.last_modified_time = last_modified_time;
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
	 * @return the closed_tickets_id
	 */
	public String getClosed_tickets_id() {
		return closed_tickets_id;
	}
	/**
	 * @param closed_tickets_id the closed_tickets_id to set
	 */
	public void setClosed_tickets_id(String closed_tickets_id) {
		this.closed_tickets_id = closed_tickets_id;
	}
	/**
	 * @return the closed_tickets_ticket_id
	 */
	public String getClosed_tickets_ticket_id() {
		return closed_tickets_ticket_id;
	}
	/**
	 * @param closed_tickets_ticket_id the closed_tickets_ticket_id to set
	 */
	public void setClosed_tickets_ticket_id(String closed_tickets_ticket_id) {
		this.closed_tickets_ticket_id = closed_tickets_ticket_id;
	}
	/**
	 * @return the closed_tickets_task_id
	 */
	public String getClosed_tickets_task_id() {
		return closed_tickets_task_id;
	}
	/**
	 * @param closed_tickets_task_id the closed_tickets_task_id to set
	 */
	public void setClosed_tickets_task_id(String closed_tickets_task_id) {
		this.closed_tickets_task_id = closed_tickets_task_id;
	}
	/**
	 * @return the closed_tickets_consignee_name
	 */
	public String getClosed_tickets_consignee_name() {
		return closed_tickets_consignee_name;
	}
	/**
	 * @param closed_tickets_consignee_name the closed_tickets_consignee_name to set
	 */
	public void setClosed_tickets_consignee_name(String closed_tickets_consignee_name) {
		this.closed_tickets_consignee_name = closed_tickets_consignee_name;
	}
	/**
	 * @return the closed_tickets_consigner_name
	 */
	public String getClosed_tickets_consigner_name() {
		return closed_tickets_consigner_name;
	}
	/**
	 * @param closed_tickets_consigner_name the closed_tickets_consigner_name to set
	 */
	public void setClosed_tickets_consigner_name(String closed_tickets_consigner_name) {
		this.closed_tickets_consigner_name = closed_tickets_consigner_name;
	}
	/**
	 * @return the closed_tickets_reciever_name
	 */
	public String getClosed_tickets_reciever_name() {
		return closed_tickets_reciever_name;
	}
	/**
	 * @param closed_tickets_reciever_name the closed_tickets_reciever_name to set
	 */
	public void setClosed_tickets_reciever_name(String closed_tickets_reciever_name) {
		this.closed_tickets_reciever_name = closed_tickets_reciever_name;
	}
	/**
	 * @return the closed_tickets_task_name
	 */
	public String getClosed_tickets_task_name() {
		return closed_tickets_task_name;
	}
	/**
	 * @param closed_tickets_task_name the closed_tickets_task_name to set
	 */
	public void setClosed_tickets_task_name(String closed_tickets_task_name) {
		this.closed_tickets_task_name = closed_tickets_task_name;
	}
	/**
	 * @return the closed_tickets_task_alias
	 */
	public String getClosed_tickets_task_alias() {
		return closed_tickets_task_alias;
	}
	/**
	 * @param closed_tickets_task_alias the closed_tickets_task_alias to set
	 */
	public void setClosed_tickets_task_alias(String closed_tickets_task_alias) {
		this.closed_tickets_task_alias = closed_tickets_task_alias;
	}
	/**
	 * @return the closed_tickets_task_status
	 */
	public String getClosed_tickets_task_status() {
		return closed_tickets_task_status;
	}
	/**
	 * @param closed_tickets_task_status the closed_tickets_task_status to set
	 */
	public void setClosed_tickets_task_status(String closed_tickets_task_status) {
		this.closed_tickets_task_status = closed_tickets_task_status;
	}
	/**
	 * @return the closed_tickets_pickup_country
	 */
	public String getClosed_tickets_pickup_country() {
		return closed_tickets_pickup_country;
	}
	/**
	 * @param closed_tickets_pickup_country the closed_tickets_pickup_country to set
	 */
	public void setClosed_tickets_pickup_country(String closed_tickets_pickup_country) {
		this.closed_tickets_pickup_country = closed_tickets_pickup_country;
	}
	/**
	 * @return the closed_tickets_pickup_state
	 */
	public String getClosed_tickets_pickup_state() {
		return closed_tickets_pickup_state;
	}
	/**
	 * @param closed_tickets_pickup_state the closed_tickets_pickup_state to set
	 */
	public void setClosed_tickets_pickup_state(String closed_tickets_pickup_state) {
		this.closed_tickets_pickup_state = closed_tickets_pickup_state;
	}
	/**
	 * @return the closed_tickets_pickup_city
	 */
	public String getClosed_tickets_pickup_city() {
		return closed_tickets_pickup_city;
	}
	/**
	 * @param closed_tickets_pickup_city the closed_tickets_pickup_city to set
	 */
	public void setClosed_tickets_pickup_city(String closed_tickets_pickup_city) {
		this.closed_tickets_pickup_city = closed_tickets_pickup_city;
	}
	/**
	 * @return the closed_tickets_pickup_city_name
	 */
	public String getClosed_tickets_pickup_city_name() {
		return closed_tickets_pickup_city_name;
	}
	/**
	 * @param closed_tickets_pickup_city_name the closed_tickets_pickup_city_name to set
	 */
	public void setClosed_tickets_pickup_city_name(String closed_tickets_pickup_city_name) {
		this.closed_tickets_pickup_city_name = closed_tickets_pickup_city_name;
	}
	/**
	 * @return the closed_tickets_pickup_city_alias
	 */
	public String getClosed_tickets_pickup_city_alias() {
		return closed_tickets_pickup_city_alias;
	}
	/**
	 * @param closed_tickets_pickup_city_alias the closed_tickets_pickup_city_alias to set
	 */
	public void setClosed_tickets_pickup_city_alias(String closed_tickets_pickup_city_alias) {
		this.closed_tickets_pickup_city_alias = closed_tickets_pickup_city_alias;
	}
	/**
	 * @return the closed_tickets_pickup_address
	 */
	public String getClosed_tickets_pickup_address() {
		return closed_tickets_pickup_address;
	}
	/**
	 * @param closed_tickets_pickup_address the closed_tickets_pickup_address to set
	 */
	public void setClosed_tickets_pickup_address(String closed_tickets_pickup_address) {
		this.closed_tickets_pickup_address = closed_tickets_pickup_address;
	}
	/**
	 * @return the closed_tickets_pickup_landmark
	 */
	public String getClosed_tickets_pickup_landmark() {
		return closed_tickets_pickup_landmark;
	}
	/**
	 * @param closed_tickets_pickup_landmark the closed_tickets_pickup_landmark to set
	 */
	public void setClosed_tickets_pickup_landmark(String closed_tickets_pickup_landmark) {
		this.closed_tickets_pickup_landmark = closed_tickets_pickup_landmark;
	}
	/**
	 * @return the closed_tickets_pickup_contact_no
	 */
	public String getClosed_tickets_pickup_contact_no() {
		return closed_tickets_pickup_contact_no;
	}
	/**
	 * @param closed_tickets_pickup_contact_no the closed_tickets_pickup_contact_no to set
	 */
	public void setClosed_tickets_pickup_contact_no(String closed_tickets_pickup_contact_no) {
		this.closed_tickets_pickup_contact_no = closed_tickets_pickup_contact_no;
	}
	/**
	 * @return the closed_tickets_consignee_key
	 */
	public String getClosed_tickets_consignee_key() {
		return closed_tickets_consignee_key;
	}
	/**
	 * @param closed_tickets_consignee_key the closed_tickets_consignee_key to set
	 */
	public void setClosed_tickets_consignee_key(String closed_tickets_consignee_key) {
		this.closed_tickets_consignee_key = closed_tickets_consignee_key;
	}
	/**
	 * @return the closed_tickets_dropoff_country
	 */
	public String getClosed_tickets_dropoff_country() {
		return closed_tickets_dropoff_country;
	}
	/**
	 * @param closed_tickets_dropoff_country the closed_tickets_dropoff_country to set
	 */
	public void setClosed_tickets_dropoff_country(String closed_tickets_dropoff_country) {
		this.closed_tickets_dropoff_country = closed_tickets_dropoff_country;
	}
	/**
	 * @return the closed_tickets_dropoff_state
	 */
	public String getClosed_tickets_dropoff_state() {
		return closed_tickets_dropoff_state;
	}
	/**
	 * @param closed_tickets_dropoff_state the closed_tickets_dropoff_state to set
	 */
	public void setClosed_tickets_dropoff_state(String closed_tickets_dropoff_state) {
		this.closed_tickets_dropoff_state = closed_tickets_dropoff_state;
	}
	/**
	 * @return the closed_tickets_dropoff_city
	 */
	public String getClosed_tickets_dropoff_city() {
		return closed_tickets_dropoff_city;
	}
	/**
	 * @param closed_tickets_dropoff_city the closed_tickets_dropoff_city to set
	 */
	public void setClosed_tickets_dropoff_city(String closed_tickets_dropoff_city) {
		this.closed_tickets_dropoff_city = closed_tickets_dropoff_city;
	}
	/**
	 * @return the closed_tickets_dropoff_city_name
	 */
	public String getClosed_tickets_dropoff_city_name() {
		return closed_tickets_dropoff_city_name;
	}
	/**
	 * @param closed_tickets_dropoff_city_name the closed_tickets_dropoff_city_name to set
	 */
	public void setClosed_tickets_dropoff_city_name(String closed_tickets_dropoff_city_name) {
		this.closed_tickets_dropoff_city_name = closed_tickets_dropoff_city_name;
	}
	/**
	 * @return the closed_tickets_dropoff_city_alias
	 */
	public String getClosed_tickets_dropoff_city_alias() {
		return closed_tickets_dropoff_city_alias;
	}
	/**
	 * @param closed_tickets_dropoff_city_alias the closed_tickets_dropoff_city_alias to set
	 */
	public void setClosed_tickets_dropoff_city_alias(String closed_tickets_dropoff_city_alias) {
		this.closed_tickets_dropoff_city_alias = closed_tickets_dropoff_city_alias;
	}
	/**
	 * @return the closed_tickets_dropoff_address
	 */
	public String getClosed_tickets_dropoff_address() {
		return closed_tickets_dropoff_address;
	}
	/**
	 * @param closed_tickets_dropoff_address the closed_tickets_dropoff_address to set
	 */
	public void setClosed_tickets_dropoff_address(String closed_tickets_dropoff_address) {
		this.closed_tickets_dropoff_address = closed_tickets_dropoff_address;
	}
	/**
	 * @return the closed_tickets_dropoff_landmark
	 */
	public String getClosed_tickets_dropoff_landmark() {
		return closed_tickets_dropoff_landmark;
	}
	/**
	 * @param closed_tickets_dropoff_landmark the closed_tickets_dropoff_landmark to set
	 */
	public void setClosed_tickets_dropoff_landmark(String closed_tickets_dropoff_landmark) {
		this.closed_tickets_dropoff_landmark = closed_tickets_dropoff_landmark;
	}
	/**
	 * @return the closed_tickets_dropoff_contact_no
	 */
	public String getClosed_tickets_dropoff_contact_no() {
		return closed_tickets_dropoff_contact_no;
	}
	/**
	 * @param closed_tickets_dropoff_contact_no the closed_tickets_dropoff_contact_no to set
	 */
	public void setClosed_tickets_dropoff_contact_no(String closed_tickets_dropoff_contact_no) {
		this.closed_tickets_dropoff_contact_no = closed_tickets_dropoff_contact_no;
	}
	/**
	 * @return the closed_tickets_consigner_key
	 */
	public String getClosed_tickets_consigner_key() {
		return closed_tickets_consigner_key;
	}
	/**
	 * @param closed_tickets_consigner_key the closed_tickets_consigner_key to set
	 */
	public void setClosed_tickets_consigner_key(String closed_tickets_consigner_key) {
		this.closed_tickets_consigner_key = closed_tickets_consigner_key;
	}
	/**
	 * @return the closed_tickets_product_type
	 */
	public String getClosed_tickets_product_type() {
		return closed_tickets_product_type;
	}
	/**
	 * @param closed_tickets_product_type the closed_tickets_product_type to set
	 */
	public void setClosed_tickets_product_type(String closed_tickets_product_type) {
		this.closed_tickets_product_type = closed_tickets_product_type;
	}
	/**
	 * @return the closed_tickets_product_value
	 */
	public String getClosed_tickets_product_value() {
		return closed_tickets_product_value;
	}
	/**
	 * @param closed_tickets_product_value the closed_tickets_product_value to set
	 */
	public void setClosed_tickets_product_value(String closed_tickets_product_value) {
		this.closed_tickets_product_value = closed_tickets_product_value;
	}
	/**
	 * @return the closed_tickets_number_of_items
	 */
	public String getClosed_tickets_number_of_items() {
		return closed_tickets_number_of_items;
	}
	/**
	 * @param closed_tickets_number_of_items the closed_tickets_number_of_items to set
	 */
	public void setClosed_tickets_number_of_items(String closed_tickets_number_of_items) {
		this.closed_tickets_number_of_items = closed_tickets_number_of_items;
	}
	/**
	 * @return the closed_tickets_volume_in_weight
	 */
	public String getClosed_tickets_volume_in_weight() {
		return closed_tickets_volume_in_weight;
	}
	/**
	 * @param closed_tickets_volume_in_weight the closed_tickets_volume_in_weight to set
	 */
	public void setClosed_tickets_volume_in_weight(String closed_tickets_volume_in_weight) {
		this.closed_tickets_volume_in_weight = closed_tickets_volume_in_weight;
	}
	/**
	 * @return the closed_tickets_volume_in_percentage
	 */
	public String getClosed_tickets_volume_in_percentage() {
		return closed_tickets_volume_in_percentage;
	}
	/**
	 * @param closed_tickets_volume_in_percentage the closed_tickets_volume_in_percentage to set
	 */
	public void setClosed_tickets_volume_in_percentage(String closed_tickets_volume_in_percentage) {
		this.closed_tickets_volume_in_percentage = closed_tickets_volume_in_percentage;
	}
	/**
	 * @return the closed_tickets_sla
	 */
	public String getClosed_tickets_sla() {
		return closed_tickets_sla;
	}
	/**
	 * @param closed_tickets_sla the closed_tickets_sla to set
	 */
	public void setClosed_tickets_sla(String closed_tickets_sla) {
		this.closed_tickets_sla = closed_tickets_sla;
	}
	/**
	 * @return the closed_tickets_estimated_arrival_days
	 */
	public String getClosed_tickets_estimated_arrival_days() {
		return closed_tickets_estimated_arrival_days;
	}
	/**
	 * @param closed_tickets_estimated_arrival_days the closed_tickets_estimated_arrival_days to set
	 */
	public void setClosed_tickets_estimated_arrival_days(String closed_tickets_estimated_arrival_days) {
		this.closed_tickets_estimated_arrival_days = closed_tickets_estimated_arrival_days;
	}
	/**
	 * @return the closed_tickets_vehicle_id
	 */
	public String getClosed_tickets_vehicle_id() {
		return closed_tickets_vehicle_id;
	}
	/**
	 * @param closed_tickets_vehicle_id the closed_tickets_vehicle_id to set
	 */
	public void setClosed_tickets_vehicle_id(String closed_tickets_vehicle_id) {
		this.closed_tickets_vehicle_id = closed_tickets_vehicle_id;
	}
	/**
	 * @return the closed_tickets_created_by
	 */
	public String getClosed_tickets_created_by() {
		return closed_tickets_created_by;
	}
	/**
	 * @param closed_tickets_created_by the closed_tickets_created_by to set
	 */
	public void setClosed_tickets_created_by(String closed_tickets_created_by) {
		this.closed_tickets_created_by = closed_tickets_created_by;
	}
	/**
	 * @return the closed_tickets_creation_time
	 */
	public String getClosed_tickets_creation_time() {
		return closed_tickets_creation_time;
	}
	/**
	 * @param closed_tickets_creation_time the closed_tickets_creation_time to set
	 */
	public void setClosed_tickets_creation_time(String closed_tickets_creation_time) {
		this.closed_tickets_creation_time = closed_tickets_creation_time;
	}
	/**
	 * @return the closed_tickets_last_modified_by
	 */
	public String getClosed_tickets_last_modified_by() {
		return closed_tickets_last_modified_by;
	}
	/**
	 * @param closed_tickets_last_modified_by the closed_tickets_last_modified_by to set
	 */
	public void setClosed_tickets_last_modified_by(String closed_tickets_last_modified_by) {
		this.closed_tickets_last_modified_by = closed_tickets_last_modified_by;
	}
	/**
	 * @return the closed_tickets_last_modified_time
	 */
	public String getClosed_tickets_last_modified_time() {
		return closed_tickets_last_modified_time;
	}
	/**
	 * @param closed_tickets_last_modified_time the closed_tickets_last_modified_time to set
	 */
	public void setClosed_tickets_last_modified_time(String closed_tickets_last_modified_time) {
		this.closed_tickets_last_modified_time = closed_tickets_last_modified_time;
	}
	/**
	 * @return the closed_tickets_pickup_date
	 */
	public String getClosed_tickets_pickup_date() {
		return closed_tickets_pickup_date;
	}
	/**
	 * @param closed_tickets_pickup_date the closed_tickets_pickup_date to set
	 */
	public void setClosed_tickets_pickup_date(String closed_tickets_pickup_date) {
		this.closed_tickets_pickup_date = closed_tickets_pickup_date;
	}
	/**
	 * @return the closed_tickets_pickup_lat
	 */
	public String getClosed_tickets_pickup_lat() {
		return closed_tickets_pickup_lat;
	}
	/**
	 * @param closed_tickets_pickup_lat the closed_tickets_pickup_lat to set
	 */
	public void setClosed_tickets_pickup_lat(String closed_tickets_pickup_lat) {
		this.closed_tickets_pickup_lat = closed_tickets_pickup_lat;
	}
	/**
	 * @return the closed_tickets_pickup_long
	 */
	public String getClosed_tickets_pickup_long() {
		return closed_tickets_pickup_long;
	}
	/**
	 * @param closed_tickets_pickup_long the closed_tickets_pickup_long to set
	 */
	public void setClosed_tickets_pickup_long(String closed_tickets_pickup_long) {
		this.closed_tickets_pickup_long = closed_tickets_pickup_long;
	}
	/**
	 * @return the closed_tickets_dropoff_date
	 */
	public String getClosed_tickets_dropoff_date() {
		return closed_tickets_dropoff_date;
	}
	/**
	 * @param closed_tickets_dropoff_date the closed_tickets_dropoff_date to set
	 */
	public void setClosed_tickets_dropoff_date(String closed_tickets_dropoff_date) {
		this.closed_tickets_dropoff_date = closed_tickets_dropoff_date;
	}
	/**
	 * @return the closed_tickets_dropoff_lat
	 */
	public String getClosed_tickets_dropoff_lat() {
		return closed_tickets_dropoff_lat;
	}
	/**
	 * @param closed_tickets_dropoff_lat the closed_tickets_dropoff_lat to set
	 */
	public void setClosed_tickets_dropoff_lat(String closed_tickets_dropoff_lat) {
		this.closed_tickets_dropoff_lat = closed_tickets_dropoff_lat;
	}
	/**
	 * @return the closed_tickets_dropoff_long
	 */
	public String getClosed_tickets_dropoff_long() {
		return closed_tickets_dropoff_long;
	}
	/**
	 * @param closed_tickets_dropoff_long the closed_tickets_dropoff_long to set
	 */
	public void setClosed_tickets_dropoff_long(String closed_tickets_dropoff_long) {
		this.closed_tickets_dropoff_long = closed_tickets_dropoff_long;
	}
	/**
	 * @return the closed_tickets_time_stamp
	 */
	public String getClosed_tickets_time_stamp() {
		return closed_tickets_time_stamp;
	}
	/**
	 * @param closed_tickets_time_stamp the closed_tickets_time_stamp to set
	 */
	public void setClosed_tickets_time_stamp(String closed_tickets_time_stamp) {
		this.closed_tickets_time_stamp = closed_tickets_time_stamp;
	}
	/**
	 * @return the closed_tickets_is_task_closed
	 */
	public String getClosed_tickets_is_task_closed() {
		return closed_tickets_is_task_closed;
	}
	/**
	 * @param closed_tickets_is_task_closed the closed_tickets_is_task_closed to set
	 */
	public void setClosed_tickets_is_task_closed(String closed_tickets_is_task_closed) {
		this.closed_tickets_is_task_closed = closed_tickets_is_task_closed;
	}
	/**
	 * @return the closed_tickets_remarks
	 */
	public String getClosed_tickets_remarks() {
		return closed_tickets_remarks;
	}
	/**
	 * @param closed_tickets_remarks the closed_tickets_remarks to set
	 */
	public void setClosed_tickets_remarks(String closed_tickets_remarks) {
		this.closed_tickets_remarks = closed_tickets_remarks;
	}
	/**
	 * @return the closed_tickets_ticket_alias
	 */
	public String getClosed_tickets_ticket_alias() {
		return closed_tickets_ticket_alias;
	}
	/**
	 * @param closed_tickets_ticket_alias the closed_tickets_ticket_alias to set
	 */
	public void setClosed_tickets_ticket_alias(String closed_tickets_ticket_alias) {
		this.closed_tickets_ticket_alias = closed_tickets_ticket_alias;
	}
	/**
	 * @return the closed_tickets_ticket_task_alias
	 */
	public String getClosed_tickets_ticket_task_alias() {
		return closed_tickets_ticket_task_alias;
	}
	/**
	 * @param closed_tickets_ticket_task_alias the closed_tickets_ticket_task_alias to set
	 */
	public void setClosed_tickets_ticket_task_alias(String closed_tickets_ticket_task_alias) {
		this.closed_tickets_ticket_task_alias = closed_tickets_ticket_task_alias;
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
