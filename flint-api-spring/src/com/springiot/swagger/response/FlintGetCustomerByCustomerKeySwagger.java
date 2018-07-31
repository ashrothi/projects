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
 * This class contains response on /flint/get/customer/by/customer/key API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetCustomerByCustomerKeySwagger {
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

	private List<FlintGetCustomerByCustomerKey> object;

	/**
	 * @return the object
	 */
	public List<FlintGetCustomerByCustomerKey> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetCustomerByCustomerKey> object) {
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
class FlintGetCustomerByCustomerKey {
	private String users_id;
	private String user_key;
	private String first_name;
	private String last_name;
	private String prefered_contact_number;
	private String user_group;
	private String sla;
	private String is_active;
	private String users_is_deleted;
	private String consignee_consigner_id;
	private String consignee_consigner_customer_id;
	private String name;
	private String email_id;
	private String contact_number;
	private String company_name;
	private String office_contact_number;
	private String country;
	private String state;
	private String city;
	private String latitude;
	private String longitude;
	private String consignee_consigner_is_deleted;
	private String product_type;
	private String vehicle_type;
	private String load_weight;
	private String number_of_items;
	private String load_volume;
	private String user_type;
	private String documents_id;
	private String document_name;
	private String document_alias;
	private String document_type;
	private String document_path;
	private String object_type;
	private String object_id;
	private String documents_is_deleted;
	/**
	 * @return the users_id
	 */
	public String getUsers_id() {
		return users_id;
	}
	/**
	 * @param users_id the users_id to set
	 */
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
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
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the prefered_contact_number
	 */
	public String getPrefered_contact_number() {
		return prefered_contact_number;
	}
	/**
	 * @param prefered_contact_number the prefered_contact_number to set
	 */
	public void setPrefered_contact_number(String prefered_contact_number) {
		this.prefered_contact_number = prefered_contact_number;
	}
	/**
	 * @return the user_group
	 */
	public String getUser_group() {
		return user_group;
	}
	/**
	 * @param user_group the user_group to set
	 */
	public void setUser_group(String user_group) {
		this.user_group = user_group;
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
	 * @return the is_active
	 */
	public String getIs_active() {
		return is_active;
	}
	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	/**
	 * @return the users_is_deleted
	 */
	public String getUsers_is_deleted() {
		return users_is_deleted;
	}
	/**
	 * @param users_is_deleted the users_is_deleted to set
	 */
	public void setUsers_is_deleted(String users_is_deleted) {
		this.users_is_deleted = users_is_deleted;
	}
	/**
	 * @return the consignee_consigner_id
	 */
	public String getConsignee_consigner_id() {
		return consignee_consigner_id;
	}
	/**
	 * @param consignee_consigner_id the consignee_consigner_id to set
	 */
	public void setConsignee_consigner_id(String consignee_consigner_id) {
		this.consignee_consigner_id = consignee_consigner_id;
	}
	/**
	 * @return the consignee_consigner_customer_id
	 */
	public String getConsignee_consigner_customer_id() {
		return consignee_consigner_customer_id;
	}
	/**
	 * @param consignee_consigner_customer_id the consignee_consigner_customer_id to set
	 */
	public void setConsignee_consigner_customer_id(String consignee_consigner_customer_id) {
		this.consignee_consigner_customer_id = consignee_consigner_customer_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * @param email_id the email_id to set
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * @return the contact_number
	 */
	public String getContact_number() {
		return contact_number;
	}
	/**
	 * @param contact_number the contact_number to set
	 */
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	/**
	 * @return the company_name
	 */
	public String getCompany_name() {
		return company_name;
	}
	/**
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	/**
	 * @return the office_contact_number
	 */
	public String getOffice_contact_number() {
		return office_contact_number;
	}
	/**
	 * @param office_contact_number the office_contact_number to set
	 */
	public void setOffice_contact_number(String office_contact_number) {
		this.office_contact_number = office_contact_number;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the consignee_consigner_is_deleted
	 */
	public String getConsignee_consigner_is_deleted() {
		return consignee_consigner_is_deleted;
	}
	/**
	 * @param consignee_consigner_is_deleted the consignee_consigner_is_deleted to set
	 */
	public void setConsignee_consigner_is_deleted(String consignee_consigner_is_deleted) {
		this.consignee_consigner_is_deleted = consignee_consigner_is_deleted;
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
	 * @return the load_weight
	 */
	public String getLoad_weight() {
		return load_weight;
	}
	/**
	 * @param load_weight the load_weight to set
	 */
	public void setLoad_weight(String load_weight) {
		this.load_weight = load_weight;
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
	 * @return the load_volume
	 */
	public String getLoad_volume() {
		return load_volume;
	}
	/**
	 * @param load_volume the load_volume to set
	 */
	public void setLoad_volume(String load_volume) {
		this.load_volume = load_volume;
	}
	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}
	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	/**
	 * @return the documents_id
	 */
	public String getDocuments_id() {
		return documents_id;
	}
	/**
	 * @param documents_id the documents_id to set
	 */
	public void setDocuments_id(String documents_id) {
		this.documents_id = documents_id;
	}
	/**
	 * @return the document_name
	 */
	public String getDocument_name() {
		return document_name;
	}
	/**
	 * @param document_name the document_name to set
	 */
	public void setDocument_name(String document_name) {
		this.document_name = document_name;
	}
	/**
	 * @return the document_alias
	 */
	public String getDocument_alias() {
		return document_alias;
	}
	/**
	 * @param document_alias the document_alias to set
	 */
	public void setDocument_alias(String document_alias) {
		this.document_alias = document_alias;
	}
	/**
	 * @return the document_type
	 */
	public String getDocument_type() {
		return document_type;
	}
	/**
	 * @param document_type the document_type to set
	 */
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	/**
	 * @return the document_path
	 */
	public String getDocument_path() {
		return document_path;
	}
	/**
	 * @param document_path the document_path to set
	 */
	public void setDocument_path(String document_path) {
		this.document_path = document_path;
	}
	/**
	 * @return the object_type
	 */
	public String getObject_type() {
		return object_type;
	}
	/**
	 * @param object_type the object_type to set
	 */
	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}
	/**
	 * @return the object_id
	 */
	public String getObject_id() {
		return object_id;
	}
	/**
	 * @param object_id the object_id to set
	 */
	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}
	/**
	 * @return the documents_is_deleted
	 */
	public String getDocuments_is_deleted() {
		return documents_is_deleted;
	}
	/**
	 * @param documents_is_deleted the documents_is_deleted to set
	 */
	public void setDocuments_is_deleted(String documents_is_deleted) {
		this.documents_is_deleted = documents_is_deleted;
	}

}
