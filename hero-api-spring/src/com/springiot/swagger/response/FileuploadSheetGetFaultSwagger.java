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
 * This class contains response on /fileupload/sheet/get/fault API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FileuploadSheetGetFaultSwagger {
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

	private List<FileuploadSheetGetFault> object;

	/**
	 * @return the object
	 */
	public List<FileuploadSheetGetFault> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FileuploadSheetGetFault> object) {
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
class FileuploadSheetGetFault {
	private String ComponentName; 
	private String VehicleModel; 
	private String VendorCode; 
	private String ComponentType; 
	private String PartNumber; 
	private String HmclLocation; 
	private String VendorTestLocation; 
	private String RepeatedOperation; 
	private String Shower; 
	private String Dust; 
	private String error;
	/**
	 * @return the componentName
	 */
	public String getComponentName() {
		return ComponentName;
	}
	/**
	 * @param componentName the componentName to set
	 */
	public void setComponentName(String componentName) {
		ComponentName = componentName;
	}
	/**
	 * @return the vehicleModel
	 */
	public String getVehicleModel() {
		return VehicleModel;
	}
	/**
	 * @param vehicleModel the vehicleModel to set
	 */
	public void setVehicleModel(String vehicleModel) {
		VehicleModel = vehicleModel;
	}
	/**
	 * @return the vendorCode
	 */
	public String getVendorCode() {
		return VendorCode;
	}
	/**
	 * @param vendorCode the vendorCode to set
	 */
	public void setVendorCode(String vendorCode) {
		VendorCode = vendorCode;
	}
	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return ComponentType;
	}
	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		ComponentType = componentType;
	}
	/**
	 * @return the partNumber
	 */
	public String getPartNumber() {
		return PartNumber;
	}
	/**
	 * @param partNumber the partNumber to set
	 */
	public void setPartNumber(String partNumber) {
		PartNumber = partNumber;
	}
	/**
	 * @return the hmclLocation
	 */
	public String getHmclLocation() {
		return HmclLocation;
	}
	/**
	 * @param hmclLocation the hmclLocation to set
	 */
	public void setHmclLocation(String hmclLocation) {
		HmclLocation = hmclLocation;
	}
	/**
	 * @return the vendorTestLocation
	 */
	public String getVendorTestLocation() {
		return VendorTestLocation;
	}
	/**
	 * @param vendorTestLocation the vendorTestLocation to set
	 */
	public void setVendorTestLocation(String vendorTestLocation) {
		VendorTestLocation = vendorTestLocation;
	}
	/**
	 * @return the repeatedOperation
	 */
	public String getRepeatedOperation() {
		return RepeatedOperation;
	}
	/**
	 * @param repeatedOperation the repeatedOperation to set
	 */
	public void setRepeatedOperation(String repeatedOperation) {
		RepeatedOperation = repeatedOperation;
	}
	/**
	 * @return the shower
	 */
	public String getShower() {
		return Shower;
	}
	/**
	 * @param shower the shower to set
	 */
	public void setShower(String shower) {
		Shower = shower;
	}
	/**
	 * @return the dust
	 */
	public String getDust() {
		return Dust;
	}
	/**
	 * @param dust the dust to set
	 */
	public void setDust(String dust) {
		Dust = dust;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	} 

}
