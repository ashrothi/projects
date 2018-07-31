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
 * This class contains response on  API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintOpenTicketsGetAllWebSwagger {
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

	private List<FlintOpenTicketsGetAllWeb> object;

	/**
	 * @return the object
	 */
	public List<FlintOpenTicketsGetAllWeb> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintOpenTicketsGetAllWeb> object) {
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
class FlintOpenTicketsGetAllWeb {
	private String open_tickets_id;
	private String ticket_id; 
	private String task_id; 
	private String task_name; 
	private String  task_alias; 
	private String task_status;
	private String consignee_name;
	private String consigner_name;
	private String reciever_name; 
	private String pickup_country; 
	private String  pickup_state; 
	private String pickup_city;
	private String pickup_city_alias; 
	private String dropoff_city_alias;
	private String pickup_city_name; 
	private String dropoff_city_name; 
	private String pickup_address; 
	private String pickup_landmark; 
	private String  pickup_contact_no; 
	private String consignee_key; 
	private String dropoff_country; 
	private String dropoff_state; 
	private String  dropoff_city; 
	private String dropoff_address; 
	private String  dropoff_landmark; 
	private String dropoff_contact_no; 
	private String consigner_key; 
	private String   product_type; 
	private String  product_value; 
	private String number_of_items; 
	private String volume_in_weight; 
	private String volume_in_percentage; 
	private String  sla; 
	private String  estimated_arrival_days; 
	private String  vehicle_id; 
	private String  created_by; 
	private String  creation_time; 
	private String last_modified_by; 
	private String pickup_date; 
	private String pickup_lat; 
	private String pickup_long; 
	private String  dropoff_date; 
	private String dropoff_lat; 
	private String dropoff_long; 
	private String time_stamp; 
	private String is_task_closed; 
	private String ticket_task_alias;
	private String pickup_state_name;
	private String pickup_state_alias;
	private String pickup_country_name;
	private String pickup_country_alias;
	private String dropoff_state_name;
	private String dropoff_state_alias;
	private String dropoff_country_name;
	private String dropoff_country_alias; 
	private String vehicle_last_modified_by_user_id;
	private String vehicle_created_by_user_id;
	private String last_modified_time;
	private String remarks;
	private String ticket_alias;  
	private String pickup_email_id;
	private String dropoff_email_id;
	private String distance_from_source;
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
	 * @return the sla
	 */
	public String getSla() {
		return sla;
	}
	/**
	 * @param sla the sla to set
	 */
	public void setSla(String sla) {
		this.sla = sla;
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
