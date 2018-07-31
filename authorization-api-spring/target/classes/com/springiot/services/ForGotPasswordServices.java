/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.email.EmailStatus;
import com.springiot.email.SendEmail;
import com.springiot.response.Message;
import com.springiot.velocity.VelocityTemplate;

/**
 * This service class is used to perform operation related to forgot password
 * functionality.
 *
 */
@Service
public class ForGotPasswordServices {
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;
	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private EmailStatus emailStatus;

	/**
	 * This method is used to check if forgot password functionality is called,
	 * then email the updated password.
	 * 
	 * @param requestType,
	 *            the procedure number.
	 * @param map,the
	 *            input parameters
	 * 
	 * @return the list of map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Message forgotPassword(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initializing the message
		Message message = new Message();

		try {

			// The input param user_id is null and set the failure response
			if (request.getHeader("user_id") == null) {
				message.setDescription("user_id is required");
				message.setValid(false);
				return message;
			}

			// Initializaton of map and adding parameters to it.
			Map<String, String> param = new HashMap();
			param.put("user_id", request.getHeader("user_id"));

			// Calling of procedure and retrieve the results in message class
			Message forgotCodeMessage = genericProcess.GenericProcedureCalling(requestType, param, request, response);

			// If message class is valid
			if (forgotCodeMessage.isValid()) {

				// Convert the forgotCodeMessage message class results into
				// list<map>.
				List<Map<String, Object>> list = (List<Map<String, Object>>) forgotCodeMessage.getObject();

				// Check list's size is greater then zero
				if (list.size() > 0) {
					// Initialization of ArrayList
					List<Map<String, Object>> objectList = new ArrayList<>();

					// Get the zero index of above list
					Map<String, Object> objectMap = list.get(0);

					// The parameter in objectMap 'reset_code' should not be
					// null
					if (objectMap.get("reset_code") != null) {

						// Flag parameter used for acknowledgement of sending
						// mail
						boolean flag = sendForgotEmail(request.getHeader("user_id"),
								map.get("reset_url") + "" + objectMap.get("reset_code"));

						// Check if email is sent
						if (flag) {
							// adding parameters to map
							objectMap.put("email_status", 1);
						} else {
							// adding parameters to map
							objectMap.put("email_status", 0);
						}

					} else {
						objectMap.put("email_status", 0);
					}

					objectList.add(objectMap);

					// Set the success response
					message.setDescription("Process Success");
					message.setObject(objectList);
					message.setValid(true);
					return message;
				}
			}
		}
		// Handling the exceptions
		catch (Exception e) {
			message.setDescription(e.getMessage());
			message.setValid(false);
			return message;
		}

		// Set the failure response of calling API
		message.setDescription("Process Fail");
		message.setValid(false);
		return message;
	}

	/**
	 * This method is used to send email to particular user in the case of sign
	 * up(registration time) and at the time of forgot password to specific
	 * user.
	 * 
	 * @param emailTo,specify
	 *            the user email id
	 * @param url,
	 *            specify the url which will be redirected
	 * 
	 * 			@return, the boolean variable whether email sent or not
	 */
	private boolean sendForgotEmail(String emailTo, Object url) {
		try {

			// Initialization of Map and adding parameters to the map.
			Map<String, Object> dataMap = new HashMap<>();

			dataMap.put("url", url);

			// Read the template data

			String templateData = new VelocityTemplate().readTemplate("/template/passwordReset.vm", dataMap);

			// Check if template data is not null
			if (templateData != null) {

				// Initialization of string builder
				StringBuilder builder = new StringBuilder();

				// String array to which is used to send email to particular
				// user
				String[] to = null;

				if (emailTo != null) {
					to = emailTo.split(",");
				} else {
					to = emailStatus.getTo().split(",");
				}

				// bcc email users
				String[] bcc = emailStatus.getBcc().split(",");

				// cc email users
				String[] cc = emailStatus.getCc().split(",");

				// Flag parameter is used to acknowledge email sent or not
				boolean flag = SendEmail.email(emailStatus.getUsername().trim(), emailStatus.getPassword().trim(),
						emailStatus.getSocketPort().trim(), emailStatus.getSocketClass().trim(),
						emailStatus.getAuthEmail().trim(), emailStatus.getEmailHost().trim(),
						emailStatus.getEmailPort().trim(), builder, to, bcc, cc, null, emailStatus.getSubject().trim(),
						templateData, emailStatus.getMsgFromStatus().trim(), emailStatus.getUsername().trim(),
						emailStatus.getUsername().trim(), null);

				// Return the boolean variable
				return flag;

			} else {
				return false;
			}

		}
		// Handling the exceptions
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
