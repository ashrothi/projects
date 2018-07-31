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
 * This class contains response on /flint/close/tickets/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintCloseTicketsGetAllSwagger {
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

	private List<FlintCloseTicketsGetAll> object;

	/**
	 * @return the object
	 */
	public List<FlintCloseTicketsGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintCloseTicketsGetAll> object) {
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
class FlintCloseTicketsGetAll {
	private String closed_tickets_id;
	private String ticket_id ;
	private String task_id; 
	private String task_name; 
	private String task_count;
	private String task_alias; 
	private String task_status;
	private String consignee_name ;
	private String consigner_name;
	private String reciever_name ; 
	private String pickup_country; 
	private String pickup_state; 
	private String pickup_city; 
	private String pickup_address ; 
	private String pickup_landmark; 
	private String pickup_contact_no; 
	private String consignee_key; 
	private String dropoff_country; 
	private String dropoff_state ; 
	private String dropoff_city; 
	private String dropoff_address; 
	private String dropoff_landmark; 
	private String dropoff_contact_no ; 
	private String consigner_key; 
	private String product_type; 
	private String product_value; 
	private String number_of_items;
	private String total_number_of_items;

	private String volume_in_weight; 
		
	private String total_volume_in_weight;
	private String volume_in_percentage; 

	private String total_volume_in_percentage;
	       
	private String sla_in_hours; 
	private String estimated_arrival_days; 
	private String remaining_duration;
	private String vehicle_id; 

	private String creation_time; 
	private String last_modified_by; 
	private String pickup_date;
	private String pickup_lat; 
	private String pickup_long; 
	private String dropoff_date; 
	private String dropoff_lat; 
	private String dropoff_long; 
	private String time_stamp; 
	private String is_task_closed; 
	private String remarks;
	private String colour_code;
	private String ticket_alias;
	private String ticket_task_alias;
	private String pickup_city_name;
	private String pickup_city_alias;
	private String pickup_state_name;
	private String pickup_state_alias;
	private String pickup_country_name;
	private String pickup_country_alias;
	private String dropoff_city_name;
	private String dropoff_city_alias;
	private String dropoff_state_name;
	private String dropoff_state_alias;
	private String dropoff_country_name;
	private String dropoff_country_alias;
	private String transporter_organization_path;
	private String driver_first_name;
	private String driver_middle_name;
	private String driver_last_name;
	private String driver_contact_number;
	private String device_driver_vehicle_device_id;
	private String device_driver_vehicle_gcm_id;
	private String distance_from_source;
	private String pickup_email_id;
	private String dropoff_email_id;
	      
	private String vehicle_vehicle_id ;
	private String vehicle_registration_number;
	private String vehicle_number_plate;
	private String vehicle_model_number ;
	private String vehicle_model_year ;
	private String vehicle_vehicle_type ;
	private String vehicle_vehicle_installation_date;
	private String vehicle_image;
	private String vehicle_is_national_permit ;
	private String vehicle_created_by ;
	private String vehicle_created_by_user_id;
	private String vehicle_creation_time ;
	private String vehicle_last_modified_by;
	private String vehicle_last_modified_by_user_id;
	private String vehicle_last_modified_time ;

	private String vehicle_is_deleted ;
	private String vehicle_capacity_in_weight;
	private String vehicle_length ;
	private String vehicle_breadth;
	private String vehicle_height ;
	private String vehicle_type_id;
	private String vehicle_type_name ;
	private String vehicle_type_alias;
	private String vehicle_type_icon;
	private String vehicle_type_map_icon;
	private String vehicle_vehicle_key;
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
	 * @return the task_name
	 */
	public String getTask_name() {
		return task_name;
	}
	/**
	 * @param task_name the task_name to set
	 */
	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	/**
	 * @return the task_count
	 */
	public String getTask_count() {
		return task_count;
	}
	/**
	 * @param task_count the task_count to set
	 */
	public void setTask_count(String task_count) {
		this.task_count = task_count;
	}
	/**
	 * @return the task_alias
	 */
	public String getTask_alias() {
		return task_alias;
	}
	/**
	 * @param task_alias the task_alias to set
	 */
	public void setTask_alias(String task_alias) {
		this.task_alias = task_alias;
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
	 * @return the consignee_name
	 */
	public String getConsignee_name() {
		return consignee_name;
	}
	/**
	 * @param consignee_name the consignee_name to set
	 */
	public void setConsignee_name(String consignee_name) {
		this.consignee_name = consignee_name;
	}
	/**
	 * @return the consigner_name
	 */
	public String getConsigner_name() {
		return consigner_name;
	}
	/**
	 * @param consigner_name the consigner_name to set
	 */
	public void setConsigner_name(String consigner_name) {
		this.consigner_name = consigner_name;
	}
	/**
	 * @return the reciever_name
	 */
	public String getReciever_name() {
		return reciever_name;
	}
	/**
	 * @param reciever_name the reciever_name to set
	 */
	public void setReciever_name(String reciever_name) {
		this.reciever_name = reciever_name;
	}
	/**
	 * @return the pickup_country
	 */
	public String getPickup_country() {
		return pickup_country;
	}
	/**
	 * @param pickup_country the pickup_country to set
	 */
	public void setPickup_country(String pickup_country) {
		this.pickup_country = pickup_country;
	}
	/**
	 * @return the pickup_state
	 */
	public String getPickup_state() {
		return pickup_state;
	}
	/**
	 * @param pickup_state the pickup_state to set
	 */
	public void setPickup_state(String pickup_state) {
		this.pickup_state = pickup_state;
	}
	/**
	 * @return the pickup_city
	 */
	public String getPickup_city() {
		return pickup_city;
	}
	/**
	 * @param pickup_city the pickup_city to set
	 */
	public void setPickup_city(String pickup_city) {
		this.pickup_city = pickup_city;
	}
	/**
	 * @return the pickup_address
	 */
	public String getPickup_address() {
		return pickup_address;
	}
	/**
	 * @param pickup_address the pickup_address to set
	 */
	public void setPickup_address(String pickup_address) {
		this.pickup_address = pickup_address;
	}
	/**
	 * @return the pickup_landmark
	 */
	public String getPickup_landmark() {
		return pickup_landmark;
	}
	/**
	 * @param pickup_landmark the pickup_landmark to set
	 */
	public void setPickup_landmark(String pickup_landmark) {
		this.pickup_landmark = pickup_landmark;
	}
	/**
	 * @return the pickup_contact_no
	 */
	public String getPickup_contact_no() {
		return pickup_contact_no;
	}
	/**
	 * @param pickup_contact_no the pickup_contact_no to set
	 */
	public void setPickup_contact_no(String pickup_contact_no) {
		this.pickup_contact_no = pickup_contact_no;
	}
	/**
	 * @return the consignee_key
	 */
	public String getConsignee_key() {
		return consignee_key;
	}
	/**
	 * @param consignee_key the consignee_key to set
	 */
	public void setConsignee_key(String consignee_key) {
		this.consignee_key = consignee_key;
	}
	/**
	 * @return the dropoff_country
	 */
	public String getDropoff_country() {
		return dropoff_country;
	}
	/**
	 * @param dropoff_country the dropoff_country to set
	 */
	public void setDropoff_country(String dropoff_country) {
		this.dropoff_country = dropoff_country;
	}
	/**
	 * @return the dropoff_state
	 */
	public String getDropoff_state() {
		return dropoff_state;
	}
	/**
	 * @param dropoff_state the dropoff_state to set
	 */
	public void setDropoff_state(String dropoff_state) {
		this.dropoff_state = dropoff_state;
	}
	/**
	 * @return the dropoff_city
	 */
	public String getDropoff_city() {
		return dropoff_city;
	}
	/**
	 * @param dropoff_city the dropoff_city to set
	 */
	public void setDropoff_city(String dropoff_city) {
		this.dropoff_city = dropoff_city;
	}
	/**
	 * @return the dropoff_address
	 */
	public String getDropoff_address() {
		return dropoff_address;
	}
	/**
	 * @param dropoff_address the dropoff_address to set
	 */
	public void setDropoff_address(String dropoff_address) {
		this.dropoff_address = dropoff_address;
	}
	/**
	 * @return the dropoff_landmark
	 */
	public String getDropoff_landmark() {
		return dropoff_landmark;
	}
	/**
	 * @param dropoff_landmark the dropoff_landmark to set
	 */
	public void setDropoff_landmark(String dropoff_landmark) {
		this.dropoff_landmark = dropoff_landmark;
	}
	/**
	 * @return the dropoff_contact_no
	 */
	public String getDropoff_contact_no() {
		return dropoff_contact_no;
	}
	/**
	 * @param dropoff_contact_no the dropoff_contact_no to set
	 */
	public void setDropoff_contact_no(String dropoff_contact_no) {
		this.dropoff_contact_no = dropoff_contact_no;
	}
	/**
	 * @return the consigner_key
	 */
	public String getConsigner_key() {
		return consigner_key;
	}
	/**
	 * @param consigner_key the consigner_key to set
	 */
	public void setConsigner_key(String consigner_key) {
		this.consigner_key = consigner_key;
	}
	/**
	 * @return the product_type
	 */
	public String getProduct_type() {
		return product_type;
	}
	/**
	 * @param product_type the product_type to set
	 */
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	/**
	 * @return the product_value
	 */
	public String getProduct_value() {
		return product_value;
	}
	/**
	 * @param product_value the product_value to set
	 */
	public void setProduct_value(String product_value) {
		this.product_value = product_value;
	}
	/**
	 * @return the number_of_items
	 */
	public String getNumber_of_items() {
		return number_of_items;
	}
	/**
	 * @param number_of_items the number_of_items to set
	 */
	public void setNumber_of_items(String number_of_items) {
		this.number_of_items = number_of_items;
	}
	/**
	 * @return the total_number_of_items
	 */
	public String getTotal_number_of_items() {
		return total_number_of_items;
	}
	/**
	 * @param total_number_of_items the total_number_of_items to set
	 */
	public void setTotal_number_of_items(String total_number_of_items) {
		this.total_number_of_items = total_number_of_items;
	}
	/**
	 * @return the volume_in_weight
	 */
	public String getVolume_in_weight() {
		return volume_in_weight;
	}
	/**
	 * @param volume_in_weight the volume_in_weight to set
	 */
	public void setVolume_in_weight(String volume_in_weight) {
		this.volume_in_weight = volume_in_weight;
	}
	/**
	 * @return the total_volume_in_weight
	 */
	public String getTotal_volume_in_weight() {
		return total_volume_in_weight;
	}
	/**
	 * @param total_volume_in_weight the total_volume_in_weight to set
	 */
	public void setTotal_volume_in_weight(String total_volume_in_weight) {
		this.total_volume_in_weight = total_volume_in_weight;
	}
	/**
	 * @return the volume_in_percentage
	 */
	public String getVolume_in_percentage() {
		return volume_in_percentage;
	}
	/**
	 * @param volume_in_percentage the volume_in_percentage to set
	 */
	public void setVolume_in_percentage(String volume_in_percentage) {
		this.volume_in_percentage = volume_in_percentage;
	}
	/**
	 * @return the total_volume_in_percentage
	 */
	public String getTotal_volume_in_percentage() {
		return total_volume_in_percentage;
	}
	/**
	 * @param total_volume_in_percentage the total_volume_in_percentage to set
	 */
	public void setTotal_volume_in_percentage(String total_volume_in_percentage) {
		this.total_volume_in_percentage = total_volume_in_percentage;
	}
	/**
	 * @return the sla_in_hours
	 */
	public String getSla_in_hours() {
		return sla_in_hours;
	}
	/**
	 * @param sla_in_hours the sla_in_hours to set
	 */
	public void setSla_in_hours(String sla_in_hours) {
		this.sla_in_hours = sla_in_hours;
	}
	/**
	 * @return the estimated_arrival_days
	 */
	public String getEstimated_arrival_days() {
		return estimated_arrival_days;
	}
	/**
	 * @param estimated_arrival_days the estimated_arrival_days to set
	 */
	public void setEstimated_arrival_days(String estimated_arrival_days) {
		this.estimated_arrival_days = estimated_arrival_days;
	}
	/**
	 * @return the remaining_duration
	 */
	public String getRemaining_duration() {
		return remaining_duration;
	}
	/**
	 * @param remaining_duration the remaining_duration to set
	 */
	public void setRemaining_duration(String remaining_duration) {
		this.remaining_duration = remaining_duration;
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
	 * @return the pickup_date
	 */
	public String getPickup_date() {
		return pickup_date;
	}
	/**
	 * @param pickup_date the pickup_date to set
	 */
	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}
	/**
	 * @return the pickup_lat
	 */
	public String getPickup_lat() {
		return pickup_lat;
	}
	/**
	 * @param pickup_lat the pickup_lat to set
	 */
	public void setPickup_lat(String pickup_lat) {
		this.pickup_lat = pickup_lat;
	}
	/**
	 * @return the pickup_long
	 */
	public String getPickup_long() {
		return pickup_long;
	}
	/**
	 * @param pickup_long the pickup_long to set
	 */
	public void setPickup_long(String pickup_long) {
		this.pickup_long = pickup_long;
	}
	/**
	 * @return the dropoff_date
	 */
	public String getDropoff_date() {
		return dropoff_date;
	}
	/**
	 * @param dropoff_date the dropoff_date to set
	 */
	public void setDropoff_date(String dropoff_date) {
		this.dropoff_date = dropoff_date;
	}
	/**
	 * @return the dropoff_lat
	 */
	public String getDropoff_lat() {
		return dropoff_lat;
	}
	/**
	 * @param dropoff_lat the dropoff_lat to set
	 */
	public void setDropoff_lat(String dropoff_lat) {
		this.dropoff_lat = dropoff_lat;
	}
	/**
	 * @return the dropoff_long
	 */
	public String getDropoff_long() {
		return dropoff_long;
	}
	/**
	 * @param dropoff_long the dropoff_long to set
	 */
	public void setDropoff_long(String dropoff_long) {
		this.dropoff_long = dropoff_long;
	}
	/**
	 * @return the time_stamp
	 */
	public String getTime_stamp() {
		return time_stamp;
	}
	/**
	 * @param time_stamp the time_stamp to set
	 */
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	/**
	 * @return the is_task_closed
	 */
	public String getIs_task_closed() {
		return is_task_closed;
	}
	/**
	 * @param is_task_closed the is_task_closed to set
	 */
	public void setIs_task_closed(String is_task_closed) {
		this.is_task_closed = is_task_closed;
	}
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the colour_code
	 */
	public String getColour_code() {
		return colour_code;
	}
	/**
	 * @param colour_code the colour_code to set
	 */
	public void setColour_code(String colour_code) {
		this.colour_code = colour_code;
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
	 * @return the pickup_city_name
	 */
	public String getPickup_city_name() {
		return pickup_city_name;
	}
	/**
	 * @param pickup_city_name the pickup_city_name to set
	 */
	public void setPickup_city_name(String pickup_city_name) {
		this.pickup_city_name = pickup_city_name;
	}
	/**
	 * @return the pickup_city_alias
	 */
	public String getPickup_city_alias() {
		return pickup_city_alias;
	}
	/**
	 * @param pickup_city_alias the pickup_city_alias to set
	 */
	public void setPickup_city_alias(String pickup_city_alias) {
		this.pickup_city_alias = pickup_city_alias;
	}
	/**
	 * @return the pickup_state_name
	 */
	public String getPickup_state_name() {
		return pickup_state_name;
	}
	/**
	 * @param pickup_state_name the pickup_state_name to set
	 */
	public void setPickup_state_name(String pickup_state_name) {
		this.pickup_state_name = pickup_state_name;
	}
	/**
	 * @return the pickup_state_alias
	 */
	public String getPickup_state_alias() {
		return pickup_state_alias;
	}
	/**
	 * @param pickup_state_alias the pickup_state_alias to set
	 */
	public void setPickup_state_alias(String pickup_state_alias) {
		this.pickup_state_alias = pickup_state_alias;
	}
	/**
	 * @return the pickup_country_name
	 */
	public String getPickup_country_name() {
		return pickup_country_name;
	}
	/**
	 * @param pickup_country_name the pickup_country_name to set
	 */
	public void setPickup_country_name(String pickup_country_name) {
		this.pickup_country_name = pickup_country_name;
	}
	/**
	 * @return the pickup_country_alias
	 */
	public String getPickup_country_alias() {
		return pickup_country_alias;
	}
	/**
	 * @param pickup_country_alias the pickup_country_alias to set
	 */
	public void setPickup_country_alias(String pickup_country_alias) {
		this.pickup_country_alias = pickup_country_alias;
	}
	/**
	 * @return the dropoff_city_name
	 */
	public String getDropoff_city_name() {
		return dropoff_city_name;
	}
	/**
	 * @param dropoff_city_name the dropoff_city_name to set
	 */
	public void setDropoff_city_name(String dropoff_city_name) {
		this.dropoff_city_name = dropoff_city_name;
	}
	/**
	 * @return the dropoff_city_alias
	 */
	public String getDropoff_city_alias() {
		return dropoff_city_alias;
	}
	/**
	 * @param dropoff_city_alias the dropoff_city_alias to set
	 */
	public void setDropoff_city_alias(String dropoff_city_alias) {
		this.dropoff_city_alias = dropoff_city_alias;
	}
	/**
	 * @return the dropoff_state_name
	 */
	public String getDropoff_state_name() {
		return dropoff_state_name;
	}
	/**
	 * @param dropoff_state_name the dropoff_state_name to set
	 */
	public void setDropoff_state_name(String dropoff_state_name) {
		this.dropoff_state_name = dropoff_state_name;
	}
	/**
	 * @return the dropoff_state_alias
	 */
	public String getDropoff_state_alias() {
		return dropoff_state_alias;
	}
	/**
	 * @param dropoff_state_alias the dropoff_state_alias to set
	 */
	public void setDropoff_state_alias(String dropoff_state_alias) {
		this.dropoff_state_alias = dropoff_state_alias;
	}
	/**
	 * @return the dropoff_country_name
	 */
	public String getDropoff_country_name() {
		return dropoff_country_name;
	}
	/**
	 * @param dropoff_country_name the dropoff_country_name to set
	 */
	public void setDropoff_country_name(String dropoff_country_name) {
		this.dropoff_country_name = dropoff_country_name;
	}
	/**
	 * @return the dropoff_country_alias
	 */
	public String getDropoff_country_alias() {
		return dropoff_country_alias;
	}
	/**
	 * @param dropoff_country_alias the dropoff_country_alias to set
	 */
	public void setDropoff_country_alias(String dropoff_country_alias) {
		this.dropoff_country_alias = dropoff_country_alias;
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
	/**
	 * @return the device_driver_vehicle_gcm_id
	 */
	public String getDevice_driver_vehicle_gcm_id() {
		return device_driver_vehicle_gcm_id;
	}
	/**
	 * @param device_driver_vehicle_gcm_id the device_driver_vehicle_gcm_id to set
	 */
	public void setDevice_driver_vehicle_gcm_id(String device_driver_vehicle_gcm_id) {
		this.device_driver_vehicle_gcm_id = device_driver_vehicle_gcm_id;
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
	 * @return the vehicle_type_id
	 */
	public String getVehicle_type_id() {
		return vehicle_type_id;
	}
	/**
	 * @param vehicle_type_id the vehicle_type_id to set
	 */
	public void setVehicle_type_id(String vehicle_type_id) {
		this.vehicle_type_id = vehicle_type_id;
	}
	/**
	 * @return the vehicle_type_name
	 */
	public String getVehicle_type_name() {
		return vehicle_type_name;
	}
	/**
	 * @param vehicle_type_name the vehicle_type_name to set
	 */
	public void setVehicle_type_name(String vehicle_type_name) {
		this.vehicle_type_name = vehicle_type_name;
	}
	/**
	 * @return the vehicle_type_alias
	 */
	public String getVehicle_type_alias() {
		return vehicle_type_alias;
	}
	/**
	 * @param vehicle_type_alias the vehicle_type_alias to set
	 */
	public void setVehicle_type_alias(String vehicle_type_alias) {
		this.vehicle_type_alias = vehicle_type_alias;
	}
	/**
	 * @return the vehicle_type_icon
	 */
	public String getVehicle_type_icon() {
		return vehicle_type_icon;
	}
	/**
	 * @param vehicle_type_icon the vehicle_type_icon to set
	 */
	public void setVehicle_type_icon(String vehicle_type_icon) {
		this.vehicle_type_icon = vehicle_type_icon;
	}
	/**
	 * @return the vehicle_type_map_icon
	 */
	public String getVehicle_type_map_icon() {
		return vehicle_type_map_icon;
	}
	/**
	 * @param vehicle_type_map_icon the vehicle_type_map_icon to set
	 */
	public void setVehicle_type_map_icon(String vehicle_type_map_icon) {
		this.vehicle_type_map_icon = vehicle_type_map_icon;
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

}
