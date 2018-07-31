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
 * This class contains response on /final/report/shower/get/head/lamp API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportShowerGetHeadLampSwagger {
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

	private List<FinalReportShowerGetHeadLamp> object;

	/**
	 * @return the object
	 */
	public List<FinalReportShowerGetHeadLamp> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportShowerGetHeadLamp> object) {
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
class FinalReportShowerGetHeadLamp {
	private int id; 
	private int device_id; 
	private String device_name; 
	private String item1; 
	private String item2; 
	private String test_requirement_and_specification_item1; 
	private String test_requirement_and_specification_item2; 
	private String n1_before_test_result_item1; 
	private String n1_before_test_result_item2; 
	private String n2_before_test_result_item1; 
	private String n2_before_test_result_item2; 
	private String n1_after_test_result_item1; 
	private String n1_after_test_result_item2; 
	private String n2_after_test_result_item1; 
	private String n2_after_test_result_item2; 
	private int n1_before_test_judgement; 
	private int n2_before_test_judgement; 
	private int n1_after_test_judgement; 
	private int n2_after_test_judgement; 
	private String testing_version; 
	private String vendor_code; 
	private long report_date;
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
	 * @return the item1
	 */
	public String getItem1() {
		return item1;
	}
	/**
	 * @param item1 the item1 to set
	 */
	public void setItem1(String item1) {
		this.item1 = item1;
	}
	/**
	 * @return the item2
	 */
	public String getItem2() {
		return item2;
	}
	/**
	 * @param item2 the item2 to set
	 */
	public void setItem2(String item2) {
		this.item2 = item2;
	}
	/**
	 * @return the test_requirement_and_specification_item1
	 */
	public String getTest_requirement_and_specification_item1() {
		return test_requirement_and_specification_item1;
	}
	/**
	 * @param test_requirement_and_specification_item1 the test_requirement_and_specification_item1 to set
	 */
	public void setTest_requirement_and_specification_item1(String test_requirement_and_specification_item1) {
		this.test_requirement_and_specification_item1 = test_requirement_and_specification_item1;
	}
	/**
	 * @return the test_requirement_and_specification_item2
	 */
	public String getTest_requirement_and_specification_item2() {
		return test_requirement_and_specification_item2;
	}
	/**
	 * @param test_requirement_and_specification_item2 the test_requirement_and_specification_item2 to set
	 */
	public void setTest_requirement_and_specification_item2(String test_requirement_and_specification_item2) {
		this.test_requirement_and_specification_item2 = test_requirement_and_specification_item2;
	}
	/**
	 * @return the n1_before_test_result_item1
	 */
	public String getN1_before_test_result_item1() {
		return n1_before_test_result_item1;
	}
	/**
	 * @param n1_before_test_result_item1 the n1_before_test_result_item1 to set
	 */
	public void setN1_before_test_result_item1(String n1_before_test_result_item1) {
		this.n1_before_test_result_item1 = n1_before_test_result_item1;
	}
	/**
	 * @return the n1_before_test_result_item2
	 */
	public String getN1_before_test_result_item2() {
		return n1_before_test_result_item2;
	}
	/**
	 * @param n1_before_test_result_item2 the n1_before_test_result_item2 to set
	 */
	public void setN1_before_test_result_item2(String n1_before_test_result_item2) {
		this.n1_before_test_result_item2 = n1_before_test_result_item2;
	}
	/**
	 * @return the n2_before_test_result_item1
	 */
	public String getN2_before_test_result_item1() {
		return n2_before_test_result_item1;
	}
	/**
	 * @param n2_before_test_result_item1 the n2_before_test_result_item1 to set
	 */
	public void setN2_before_test_result_item1(String n2_before_test_result_item1) {
		this.n2_before_test_result_item1 = n2_before_test_result_item1;
	}
	/**
	 * @return the n2_before_test_result_item2
	 */
	public String getN2_before_test_result_item2() {
		return n2_before_test_result_item2;
	}
	/**
	 * @param n2_before_test_result_item2 the n2_before_test_result_item2 to set
	 */
	public void setN2_before_test_result_item2(String n2_before_test_result_item2) {
		this.n2_before_test_result_item2 = n2_before_test_result_item2;
	}
	/**
	 * @return the n1_after_test_result_item1
	 */
	public String getN1_after_test_result_item1() {
		return n1_after_test_result_item1;
	}
	/**
	 * @param n1_after_test_result_item1 the n1_after_test_result_item1 to set
	 */
	public void setN1_after_test_result_item1(String n1_after_test_result_item1) {
		this.n1_after_test_result_item1 = n1_after_test_result_item1;
	}
	/**
	 * @return the n1_after_test_result_item2
	 */
	public String getN1_after_test_result_item2() {
		return n1_after_test_result_item2;
	}
	/**
	 * @param n1_after_test_result_item2 the n1_after_test_result_item2 to set
	 */
	public void setN1_after_test_result_item2(String n1_after_test_result_item2) {
		this.n1_after_test_result_item2 = n1_after_test_result_item2;
	}
	/**
	 * @return the n2_after_test_result_item1
	 */
	public String getN2_after_test_result_item1() {
		return n2_after_test_result_item1;
	}
	/**
	 * @param n2_after_test_result_item1 the n2_after_test_result_item1 to set
	 */
	public void setN2_after_test_result_item1(String n2_after_test_result_item1) {
		this.n2_after_test_result_item1 = n2_after_test_result_item1;
	}
	/**
	 * @return the n2_after_test_result_item2
	 */
	public String getN2_after_test_result_item2() {
		return n2_after_test_result_item2;
	}
	/**
	 * @param n2_after_test_result_item2 the n2_after_test_result_item2 to set
	 */
	public void setN2_after_test_result_item2(String n2_after_test_result_item2) {
		this.n2_after_test_result_item2 = n2_after_test_result_item2;
	}
	/**
	 * @return the n1_before_test_judgement
	 */
	public int getN1_before_test_judgement() {
		return n1_before_test_judgement;
	}
	/**
	 * @param n1_before_test_judgement the n1_before_test_judgement to set
	 */
	public void setN1_before_test_judgement(int n1_before_test_judgement) {
		this.n1_before_test_judgement = n1_before_test_judgement;
	}
	/**
	 * @return the n2_before_test_judgement
	 */
	public int getN2_before_test_judgement() {
		return n2_before_test_judgement;
	}
	/**
	 * @param n2_before_test_judgement the n2_before_test_judgement to set
	 */
	public void setN2_before_test_judgement(int n2_before_test_judgement) {
		this.n2_before_test_judgement = n2_before_test_judgement;
	}
	/**
	 * @return the n1_after_test_judgement
	 */
	public int getN1_after_test_judgement() {
		return n1_after_test_judgement;
	}
	/**
	 * @param n1_after_test_judgement the n1_after_test_judgement to set
	 */
	public void setN1_after_test_judgement(int n1_after_test_judgement) {
		this.n1_after_test_judgement = n1_after_test_judgement;
	}
	/**
	 * @return the n2_after_test_judgement
	 */
	public int getN2_after_test_judgement() {
		return n2_after_test_judgement;
	}
	/**
	 * @param n2_after_test_judgement the n2_after_test_judgement to set
	 */
	public void setN2_after_test_judgement(int n2_after_test_judgement) {
		this.n2_after_test_judgement = n2_after_test_judgement;
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
	 * @return the report_date
	 */
	public long getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(long report_date) {
		this.report_date = report_date;
	} 

}
