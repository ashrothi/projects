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
 * This class contains response on /final/report/get/horn API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportGetHornSwagger {
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

	private List<FinalReportGetHorn> object;

	/**
	 * @return the object
	 */
	public List<FinalReportGetHorn> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportGetHorn> object) {
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
class FinalReportGetHorn {

	private int id; 
	private int device_id; 
	private String device_name; 
	private String vendor_code; 
	private String model; 
	private String horn_type; 
	private String part_code; 
	private int lot_no; 
	private int lot_quantity; 
	private String report_date; 
	private String general_per_parameter; 
	private String hmcl_specification_before_test_min_specification; 
	private float hmcl_specification_before_test_max_specification; 
	private String hmcl_before_test; 
	private String hmcl_specification_after_test_min_specification; 
	private String hmcl_specification_after_test_max_specification; 
	private String hmcl_after_test; 
	private float reading_before_test; 
	private float reading_after_test; 
	private float difference; 
	private String reading_after_2_hrs; 
	private String difference_after_2_hrs; 
	private String judgement; 
	private int is_planned; 
	private String testing_version;
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
	 * @return the horn_type
	 */
	public String getHorn_type() {
		return horn_type;
	}
	/**
	 * @param horn_type the horn_type to set
	 */
	public void setHorn_type(String horn_type) {
		this.horn_type = horn_type;
	}
	/**
	 * @return the part_code
	 */
	public String getPart_code() {
		return part_code;
	}
	/**
	 * @param part_code the part_code to set
	 */
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	/**
	 * @return the lot_no
	 */
	public int getLot_no() {
		return lot_no;
	}
	/**
	 * @param lot_no the lot_no to set
	 */
	public void setLot_no(int lot_no) {
		this.lot_no = lot_no;
	}
	/**
	 * @return the lot_quantity
	 */
	public int getLot_quantity() {
		return lot_quantity;
	}
	/**
	 * @param lot_quantity the lot_quantity to set
	 */
	public void setLot_quantity(int lot_quantity) {
		this.lot_quantity = lot_quantity;
	}
	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	/**
	 * @return the general_per_parameter
	 */
	public String getGeneral_per_parameter() {
		return general_per_parameter;
	}
	/**
	 * @param general_per_parameter the general_per_parameter to set
	 */
	public void setGeneral_per_parameter(String general_per_parameter) {
		this.general_per_parameter = general_per_parameter;
	}
	/**
	 * @return the hmcl_specification_before_test_min_specification
	 */
	public String getHmcl_specification_before_test_min_specification() {
		return hmcl_specification_before_test_min_specification;
	}
	/**
	 * @param hmcl_specification_before_test_min_specification the hmcl_specification_before_test_min_specification to set
	 */
	public void setHmcl_specification_before_test_min_specification(
			String hmcl_specification_before_test_min_specification) {
		this.hmcl_specification_before_test_min_specification = hmcl_specification_before_test_min_specification;
	}
	/**
	 * @return the hmcl_specification_before_test_max_specification
	 */
	public float getHmcl_specification_before_test_max_specification() {
		return hmcl_specification_before_test_max_specification;
	}
	/**
	 * @param hmcl_specification_before_test_max_specification the hmcl_specification_before_test_max_specification to set
	 */
	public void setHmcl_specification_before_test_max_specification(
			float hmcl_specification_before_test_max_specification) {
		this.hmcl_specification_before_test_max_specification = hmcl_specification_before_test_max_specification;
	}
	/**
	 * @return the hmcl_before_test
	 */
	public String getHmcl_before_test() {
		return hmcl_before_test;
	}
	/**
	 * @param hmcl_before_test the hmcl_before_test to set
	 */
	public void setHmcl_before_test(String hmcl_before_test) {
		this.hmcl_before_test = hmcl_before_test;
	}
	/**
	 * @return the hmcl_specification_after_test_min_specification
	 */
	public String getHmcl_specification_after_test_min_specification() {
		return hmcl_specification_after_test_min_specification;
	}
	/**
	 * @param hmcl_specification_after_test_min_specification the hmcl_specification_after_test_min_specification to set
	 */
	public void setHmcl_specification_after_test_min_specification(String hmcl_specification_after_test_min_specification) {
		this.hmcl_specification_after_test_min_specification = hmcl_specification_after_test_min_specification;
	}
	/**
	 * @return the hmcl_specification_after_test_max_specification
	 */
	public String getHmcl_specification_after_test_max_specification() {
		return hmcl_specification_after_test_max_specification;
	}
	/**
	 * @param hmcl_specification_after_test_max_specification the hmcl_specification_after_test_max_specification to set
	 */
	public void setHmcl_specification_after_test_max_specification(String hmcl_specification_after_test_max_specification) {
		this.hmcl_specification_after_test_max_specification = hmcl_specification_after_test_max_specification;
	}
	/**
	 * @return the hmcl_after_test
	 */
	public String getHmcl_after_test() {
		return hmcl_after_test;
	}
	/**
	 * @param hmcl_after_test the hmcl_after_test to set
	 */
	public void setHmcl_after_test(String hmcl_after_test) {
		this.hmcl_after_test = hmcl_after_test;
	}
	/**
	 * @return the reading_before_test
	 */
	public float getReading_before_test() {
		return reading_before_test;
	}
	/**
	 * @param reading_before_test the reading_before_test to set
	 */
	public void setReading_before_test(float reading_before_test) {
		this.reading_before_test = reading_before_test;
	}
	/**
	 * @return the reading_after_test
	 */
	public float getReading_after_test() {
		return reading_after_test;
	}
	/**
	 * @param reading_after_test the reading_after_test to set
	 */
	public void setReading_after_test(float reading_after_test) {
		this.reading_after_test = reading_after_test;
	}
	/**
	 * @return the difference
	 */
	public float getDifference() {
		return difference;
	}
	/**
	 * @param difference the difference to set
	 */
	public void setDifference(float difference) {
		this.difference = difference;
	}
	/**
	 * @return the reading_after_2_hrs
	 */
	public String getReading_after_2_hrs() {
		return reading_after_2_hrs;
	}
	/**
	 * @param reading_after_2_hrs the reading_after_2_hrs to set
	 */
	public void setReading_after_2_hrs(String reading_after_2_hrs) {
		this.reading_after_2_hrs = reading_after_2_hrs;
	}
	/**
	 * @return the difference_after_2_hrs
	 */
	public String getDifference_after_2_hrs() {
		return difference_after_2_hrs;
	}
	/**
	 * @param difference_after_2_hrs the difference_after_2_hrs to set
	 */
	public void setDifference_after_2_hrs(String difference_after_2_hrs) {
		this.difference_after_2_hrs = difference_after_2_hrs;
	}
	/**
	 * @return the judgement
	 */
	public String getJudgement() {
		return judgement;
	}
	/**
	 * @param judgement the judgement to set
	 */
	public void setJudgement(String judgement) {
		this.judgement = judgement;
	}
	/**
	 * @return the is_planned
	 */
	public int getIs_planned() {
		return is_planned;
	}
	/**
	 * @param is_planned the is_planned to set
	 */
	public void setIs_planned(int is_planned) {
		this.is_planned = is_planned;
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

}
