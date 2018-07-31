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
 * This class contains response on /final/report/dust/get/tail/lamp API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportDustGetTailLampSwagger {
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

	private List<FinalReportDustGetTailLamp> object;

	/**
	 * @return the object
	 */
	public List<FinalReportDustGetTailLamp> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportDustGetTailLamp> object) {
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
class FinalReportDustGetTailLamp {
	private int id; 
	private int device_id; 
	private String device_name; 
	private String report_date; 
	private String vendor_code; 
	private String testing_version; 
	private String items; 
	private String test_requirement_and_specification; 
	private String before_test_result_n1; 
	private String before_test_result_n2; 
	private String after_test_result_n1; 
	private String after_test_result_n2; 
	private String age_drop_in_luminious_intensity_n1; 
	private String age_drop_in_luminious_intensity_n2; 
	private String judgement_n1; 
	private String judgement_n2;
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
	 * @return the items
	 */
	public String getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(String items) {
		this.items = items;
	}
	/**
	 * @return the test_requirement_and_specification
	 */
	public String getTest_requirement_and_specification() {
		return test_requirement_and_specification;
	}
	/**
	 * @param test_requirement_and_specification the test_requirement_and_specification to set
	 */
	public void setTest_requirement_and_specification(String test_requirement_and_specification) {
		this.test_requirement_and_specification = test_requirement_and_specification;
	}
	/**
	 * @return the before_test_result_n1
	 */
	public String getBefore_test_result_n1() {
		return before_test_result_n1;
	}
	/**
	 * @param before_test_result_n1 the before_test_result_n1 to set
	 */
	public void setBefore_test_result_n1(String before_test_result_n1) {
		this.before_test_result_n1 = before_test_result_n1;
	}
	/**
	 * @return the before_test_result_n2
	 */
	public String getBefore_test_result_n2() {
		return before_test_result_n2;
	}
	/**
	 * @param before_test_result_n2 the before_test_result_n2 to set
	 */
	public void setBefore_test_result_n2(String before_test_result_n2) {
		this.before_test_result_n2 = before_test_result_n2;
	}
	/**
	 * @return the after_test_result_n1
	 */
	public String getAfter_test_result_n1() {
		return after_test_result_n1;
	}
	/**
	 * @param after_test_result_n1 the after_test_result_n1 to set
	 */
	public void setAfter_test_result_n1(String after_test_result_n1) {
		this.after_test_result_n1 = after_test_result_n1;
	}
	/**
	 * @return the after_test_result_n2
	 */
	public String getAfter_test_result_n2() {
		return after_test_result_n2;
	}
	/**
	 * @param after_test_result_n2 the after_test_result_n2 to set
	 */
	public void setAfter_test_result_n2(String after_test_result_n2) {
		this.after_test_result_n2 = after_test_result_n2;
	}
	/**
	 * @return the age_drop_in_luminious_intensity_n1
	 */
	public String getAge_drop_in_luminious_intensity_n1() {
		return age_drop_in_luminious_intensity_n1;
	}
	/**
	 * @param age_drop_in_luminious_intensity_n1 the age_drop_in_luminious_intensity_n1 to set
	 */
	public void setAge_drop_in_luminious_intensity_n1(String age_drop_in_luminious_intensity_n1) {
		this.age_drop_in_luminious_intensity_n1 = age_drop_in_luminious_intensity_n1;
	}
	/**
	 * @return the age_drop_in_luminious_intensity_n2
	 */
	public String getAge_drop_in_luminious_intensity_n2() {
		return age_drop_in_luminious_intensity_n2;
	}
	/**
	 * @param age_drop_in_luminious_intensity_n2 the age_drop_in_luminious_intensity_n2 to set
	 */
	public void setAge_drop_in_luminious_intensity_n2(String age_drop_in_luminious_intensity_n2) {
		this.age_drop_in_luminious_intensity_n2 = age_drop_in_luminious_intensity_n2;
	}
	/**
	 * @return the judgement_n1
	 */
	public String getJudgement_n1() {
		return judgement_n1;
	}
	/**
	 * @param judgement_n1 the judgement_n1 to set
	 */
	public void setJudgement_n1(String judgement_n1) {
		this.judgement_n1 = judgement_n1;
	}
	/**
	 * @return the judgement_n2
	 */
	public String getJudgement_n2() {
		return judgement_n2;
	}
	/**
	 * @param judgement_n2 the judgement_n2 to set
	 */
	public void setJudgement_n2(String judgement_n2) {
		this.judgement_n2 = judgement_n2;
	}

}
