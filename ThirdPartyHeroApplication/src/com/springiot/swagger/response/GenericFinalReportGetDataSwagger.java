/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /final/report/get/data APIs.
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GenericFinalReportGetDataSwagger {
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

	private List<GenericFinalReportGetData> object;

	/**
	 * @return the object
	 */
	public List<GenericFinalReportGetData> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GenericFinalReportGetData> object) {
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
class GenericFinalReportGetData {
	private int id; 
	private int device_id; 
	private String device_name;  
	private String part_name; 
	private String vendor_name; 
	private String vendor_code; 
	private String plant; 
	private String inspection_lot_no; 
	private long inspection_lot_date; 
	private String hmcl_part_code; 
	private String vendor_part_code; 
	private String vendor_mfg_location; 
	private int inspection_lot_qty; 
	private long part_mfg_date; 
	private String report_no; 
	private Date report_date; 
	private Date test_start_date; 
	private Date test_end_date; 
	private int no_of_samples; 
	private String testing_type; 
	private String objective; 
	private String modification_details; 
	private String test_standard; 
	private String test_condition_and_methord; 
	private String test_duration; 
	private String testing_version; 
	private int is_editable; 
	private int is_succesful;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the device_id
	 */
	public int getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	/**
	 * @return the part_name
	 */
	public String getPart_name() {
		return part_name;
	}
	/**
	 * @param part_name the part_name to set
	 */
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	/**
	 * @return the vendor_name
	 */
	public String getVendor_name() {
		return vendor_name;
	}
	/**
	 * @param vendor_name the vendor_name to set
	 */
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	/**
	 * @return the vendor_code
	 */
	public String getVendor_code() {
		return vendor_code;
	}
	/**
	 * @param vendor_code the vendor_code to set
	 */
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	/**
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}
	/**
	 * @param plant the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}
	/**
	 * @return the inspection_lot_no
	 */
	public String getInspection_lot_no() {
		return inspection_lot_no;
	}
	/**
	 * @param inspection_lot_no the inspection_lot_no to set
	 */
	public void setInspection_lot_no(String inspection_lot_no) {
		this.inspection_lot_no = inspection_lot_no;
	}
	/**
	 * @return the inspection_lot_date
	 */
	public long getInspection_lot_date() {
		return inspection_lot_date;
	}
	/**
	 * @param inspection_lot_date the inspection_lot_date to set
	 */
	public void setInspection_lot_date(long inspection_lot_date) {
		this.inspection_lot_date = inspection_lot_date;
	}
	/**
	 * @return the hmcl_part_code
	 */
	public String getHmcl_part_code() {
		return hmcl_part_code;
	}
	/**
	 * @param hmcl_part_code the hmcl_part_code to set
	 */
	public void setHmcl_part_code(String hmcl_part_code) {
		this.hmcl_part_code = hmcl_part_code;
	}
	/**
	 * @return the vendor_part_code
	 */
	public String getVendor_part_code() {
		return vendor_part_code;
	}
	/**
	 * @param vendor_part_code the vendor_part_code to set
	 */
	public void setVendor_part_code(String vendor_part_code) {
		this.vendor_part_code = vendor_part_code;
	}
	/**
	 * @return the vendor_mfg_location
	 */
	public String getVendor_mfg_location() {
		return vendor_mfg_location;
	}
	/**
	 * @param vendor_mfg_location the vendor_mfg_location to set
	 */
	public void setVendor_mfg_location(String vendor_mfg_location) {
		this.vendor_mfg_location = vendor_mfg_location;
	}
	/**
	 * @return the inspection_lot_qty
	 */
	public int getInspection_lot_qty() {
		return inspection_lot_qty;
	}
	/**
	 * @param inspection_lot_qty the inspection_lot_qty to set
	 */
	public void setInspection_lot_qty(int inspection_lot_qty) {
		this.inspection_lot_qty = inspection_lot_qty;
	}
	/**
	 * @return the part_mfg_date
	 */
	public long getPart_mfg_date() {
		return part_mfg_date;
	}
	/**
	 * @param part_mfg_date the part_mfg_date to set
	 */
	public void setPart_mfg_date(long part_mfg_date) {
		this.part_mfg_date = part_mfg_date;
	}
	/**
	 * @return the report_no
	 */
	public String getReport_no() {
		return report_no;
	}
	/**
	 * @param report_no the report_no to set
	 */
	public void setReport_no(String report_no) {
		this.report_no = report_no;
	}
	/**
	 * @return the report_date
	 */
	public Date getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	/**
	 * @return the test_start_date
	 */
	public Date getTest_start_date() {
		return test_start_date;
	}
	/**
	 * @param test_start_date the test_start_date to set
	 */
	public void setTest_start_date(Date test_start_date) {
		this.test_start_date = test_start_date;
	}
	/**
	 * @return the test_end_date
	 */
	public Date getTest_end_date() {
		return test_end_date;
	}
	/**
	 * @param test_end_date the test_end_date to set
	 */
	public void setTest_end_date(Date test_end_date) {
		this.test_end_date = test_end_date;
	}
	/**
	 * @return the no_of_samples
	 */
	public int getNo_of_samples() {
		return no_of_samples;
	}
	/**
	 * @param no_of_samples the no_of_samples to set
	 */
	public void setNo_of_samples(int no_of_samples) {
		this.no_of_samples = no_of_samples;
	}
	/**
	 * @return the testing_type
	 */
	public String getTesting_type() {
		return testing_type;
	}
	/**
	 * @param testing_type the testing_type to set
	 */
	public void setTesting_type(String testing_type) {
		this.testing_type = testing_type;
	}
	/**
	 * @return the objective
	 */
	public String getObjective() {
		return objective;
	}
	/**
	 * @param objective the objective to set
	 */
	public void setObjective(String objective) {
		this.objective = objective;
	}
	/**
	 * @return the modification_details
	 */
	public String getModification_details() {
		return modification_details;
	}
	/**
	 * @param modification_details the modification_details to set
	 */
	public void setModification_details(String modification_details) {
		this.modification_details = modification_details;
	}
	/**
	 * @return the test_standard
	 */
	public String getTest_standard() {
		return test_standard;
	}
	/**
	 * @param test_standard the test_standard to set
	 */
	public void setTest_standard(String test_standard) {
		this.test_standard = test_standard;
	}
	/**
	 * @return the test_condition_and_methord
	 */
	public String getTest_condition_and_methord() {
		return test_condition_and_methord;
	}
	/**
	 * @param test_condition_and_methord the test_condition_and_methord to set
	 */
	public void setTest_condition_and_methord(String test_condition_and_methord) {
		this.test_condition_and_methord = test_condition_and_methord;
	}
	/**
	 * @return the test_duration
	 */
	public String getTest_duration() {
		return test_duration;
	}
	/**
	 * @param test_duration the test_duration to set
	 */
	public void setTest_duration(String test_duration) {
		this.test_duration = test_duration;
	}
	/**
	 * @return the testing_version
	 */
	public String getTesting_version() {
		return testing_version;
	}
	/**
	 * @param testing_version the testing_version to set
	 */
	public void setTesting_version(String testing_version) {
		this.testing_version = testing_version;
	}
	/**
	 * @return the is_editable
	 */
	public int getIs_editable() {
		return is_editable;
	}
	/**
	 * @param is_editable the is_editable to set
	 */
	public void setIs_editable(int is_editable) {
		this.is_editable = is_editable;
	}
	/**
	 * @return the is_succesful
	 */
	public int getIs_succesful() {
		return is_succesful;
	}
	/**
	 * @param is_succesful the is_succesful to set
	 */
	public void setIs_succesful(int is_succesful) {
		this.is_succesful = is_succesful;
	} 

}
