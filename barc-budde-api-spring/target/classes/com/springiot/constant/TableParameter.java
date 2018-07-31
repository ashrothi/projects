/**
 * This package contain the classes used to store parameters and required data for token management and user validation.
 */
package com.springiot.constant;

import org.springframework.stereotype.Component;

/**
 * @author Garima Joshi 
 * This class is used to link with the database tables (history and current).
 */
@Component
public class TableParameter {

	private String report_header_mapping;

	public String getReport_header_mapping() {
		return report_header_mapping;
	}

	public void setReport_header_mapping(String report_header_mapping) {
		this.report_header_mapping = report_header_mapping;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableParameter [report_header_mapping=" + report_header_mapping + "]";
	}


}
