package org.goup.swagger.response;

public class ApiResponseSwagger {

	private APIResponse apiResponse;
	private APIErrorResponse error;
	/**
	 * @return the apiResponse
	 */
	public APIResponse getApiResponse() {
		return apiResponse;
	}
	/**
	 * @param apiResponse the apiResponse to set
	 */
	public void setApiResponse(APIResponse apiResponse) {
		this.apiResponse = apiResponse;
	}
	/**
	 * @return the error
	 */
	public APIErrorResponse getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(APIErrorResponse error) {
		this.error = error;
	}

}

class APIResponse {

	private String tracking_message_header;

	/**
	 * @return the tracking_message_header
	 */
	public String gettracking_message_header() {
		return tracking_message_header;
	}

	/**
	 * @param tracking_message_header
	 *            the tracking_message_header to set
	 */
	public void settracking_message_header(String tracking_message_header) {
		this.tracking_message_header = tracking_message_header;
	}

}

class APIErrorResponse {

	private String error_code;
	private String description;

	/**
	 * @return the error_code
	 */
	public String getError_code() {
		return error_code;
	}

	/**
	 * @param error_code
	 *            the error_code to set
	 */
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}