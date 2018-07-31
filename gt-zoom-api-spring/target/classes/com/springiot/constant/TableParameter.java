/**
 * This package contain the classes used to store parameters and required data for token management and user validation.
 */
package com.springiot.constant;

import org.springframework.stereotype.Component;

/**
 * This class is used to link with the database tables (history and current).
 * 
 * @author Garima Joshi
 * @Updated_by Mandeep Singh
 * @updated_on 02-04-2018
 */
@Component
public class TableParameter {

	private String table_name;
	private String report_header_mapping;

	/**
	 * @return the table_name
	 */
	public String getTable_name() {
		return table_name;
	}

	/**
	 * @param table_name the table_name to set
	 */
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	/**
	 * @return the report_header_mapping
	 */
	public String getReport_header_mapping() {
		return report_header_mapping;
	}

	/**
	 * @param report_header_mapping the report_header_mapping to set
	 */
	public void setReport_header_mapping(String report_header_mapping) {
		this.report_header_mapping = report_header_mapping;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableParameter [table_name=" + table_name + ", report_header_mapping=" + report_header_mapping + "]";
	}

}
