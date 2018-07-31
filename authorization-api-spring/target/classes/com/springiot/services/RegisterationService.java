/**
 * This package is used to provide permissions to particular users to access some API's and views on the application.
 */
package com.springiot.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springiot.constant.ProcessParameter;
import com.springiot.email.EmailStatus;
import com.springiot.email.SendEmail;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.velocity.VelocityTemplate;

/**
 * This method is used to verify user at the Registeration time(sign up). This
 * will check first the user already exits or not,if it does not exist,then
 * generate OTP and send mail with the OTP for user verification
 * 
 * @author tanvigarg
 *
 */
@Service
public class RegisterationService {
	/**
	 * To access the following service class method.
	 */
	@Autowired
	private ProcessParameter processParameter;
	/**
	 * To access the following service class method.
	 */
	@Autowired
	private GenericService genericService;
	/**
	 * To access the following service class method.
	 */
	@Autowired
	private EmailStatus emailStatus;
	/**
	 * To access functionality of GenericProcess service class method.
	 */
	@Autowired
	private GenericProcess genericProcess;

	@SuppressWarnings({ "unchecked" })
	public Message userVerification(String username, HttpServletRequest request, HttpServletResponse response) {

		Message message = new Message();
		try {
			// initialization of map,used to set the API Response
			Map<String, Object> responseMap = new HashMap<>();

			// Map is used to get all the procedures
			Map<String, Object> procedureMap = processParameter.getMaps();
			String userVerificationSql = null;

			// Check if map contains particular procedure number
			if (procedureMap.get("79") != null) {
				userVerificationSql = procedureMap.get("79").toString();
			}

			// Response Message when sql is null
			if (userVerificationSql == null) {
				message.setDescription("Sql Not get");
				message.setValid(false);
				return message;
			}

			// Calling of Procedure and retrieve the data in the object
			Object userExistsResponse = genericService.executeProcesure(null, userVerificationSql, username);

			// Converts the above object response into List<Map>
			List<Map<String, Object>> userExistsMap = (List<Map<String, Object>>) userExistsResponse;

			// Check by the keyword "code",user already exists or not
			if (userExistsMap.get(0).get("msgcode").toString().equals("1")) {

				// Generate Otp(random number)
				Random randomNumber = new Random();
				int otp = randomNumber.nextInt(999999);

				String sql = null;

				// Check if map contains particular procedure number
				if (procedureMap.get("78") != null) {
					sql = procedureMap.get("78").toString();
				}

				// Response Message when sql is null
				if (sql == null) {
					message.setDescription("Sql Not get");
					message.setValid(false);
					return message;
				}

				// Initialization of map and adding parameters to it
				Map<String, Object> map = new HashMap<>();
				map.put("user_name", username);
				map.put("otp", otp);
				map.put("created_by", username);

				// Calling of procedure and get the results in Object
				Object objectResponse = genericService.executeProcesure(null, sql, map.get("user_name"), map.get("otp"),
						map.get("created_by"));

				// Convert the above retrieved response into list<map>
				List<Map<String, Object>> mapResponse = (List<Map<String, Object>>) objectResponse;

				// Check when user is verified,needs to send email to user
				if (mapResponse.get(0).get("code").toString().equals("1")) {

					// Initialization of map and adding parameters to it
					Map<String, Object> dataMap = new HashMap<>();
					dataMap.put("otp", otp);

					// Read the template data for sending email to user
					String templateData = new VelocityTemplate().readTemplate("/template/Email.vm", dataMap);

					// Check if data from template is not null
					if (templateData != null) {

						// Initializing the String Builder
						StringBuilder builder = new StringBuilder();

						String[] userEmail = null;

						// Check the valid username
						if (username != null) {

							userEmail = username.split(",");

						} else {

							userEmail = emailStatus.getTo().split(",");
						}
						// bcc email
						String[] bcc = emailStatus.getBcc().split(",");

						// cc email
						String[] cc = emailStatus.getCc().split(",");

						// Flag will tell us the email sent or not
						boolean flag = SendEmail.email(emailStatus.getUsername().trim(),
								emailStatus.getPassword().trim(), emailStatus.getSocketPort().trim(),
								emailStatus.getSocketClass().trim(), emailStatus.getAuthEmail().trim(),
								emailStatus.getEmailHost().trim(), emailStatus.getEmailPort().trim(), builder,
								userEmail, bcc, cc, null, emailStatus.getSignUpSubject().trim(), templateData,
								emailStatus.getMsgSignUpTime().trim(), emailStatus.getUsername().trim(),
								emailStatus.getUsername().trim(), null);

						// Set the parameters for response map
						responseMap.put("code", userExistsMap.get(0).get("msgcode"));

						// Check flag is true
						if (flag) {
							// set the success response
							message.setDescription("Email Sent");
							message.setObject(responseMap);
							message.setValid(true);
							return message;
						} else {
							// Set the parameters for response map
							responseMap.put("code", userExistsMap.get(0).get("msgcode"));

							// set the failure response
							message.setDescription("Email id is incorrect");
							message.setObject(responseMap);
							message.setValid(true);
							return message;
						}
					} else {
						message.setDescription("Not able to read template");
						return message;
					}
				}
			} else {

				// responseMap.put("otp", otp);
				responseMap.put("code", userExistsMap.get(0).get("msgcode"));
				// set the response
				message.setDescription("User already Exists");
				message.setObject(responseMap);
				message.setValid(true);
				return message;
			}
		}
		// Handling the exceptions
		catch (Exception exception) {
			exception.getStackTrace();
			message.setDescription("Process Fail " + exception.getMessage());
			message.setValid(false);
			return message;
		}
		return message;

	}

	/**
	 * This method is used to check email and opt verification,if it's verified,then
	 * create user Profile
	 * 
	 * @param request,the
	 *            procedure number.
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public Message userCreationSignup(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initializing the response map
		HashMap<String, Object> responsemap = new HashMap<>();

		Message message = new Message();
		try {
			// Map is used to get all the procedures
			Map<String, Object> procedureMap = processParameter.getMaps();
			String userVerificationSql = null;

			// Check if map contains particular procedure number
			if (procedureMap.get("81") != null) {
				userVerificationSql = procedureMap.get("81").toString();
			}

			// Response Message when sql is null
			if (userVerificationSql == null) {
				message.setDescription("Sql Not get");
				message.setValid(false);
				return message;
			}
			// Calling of Procedure and retrieve the data in the object
			Object userExistsResponse = genericService.executeProcesure(null, userVerificationSql, map.get("username"),
					map.get("OTP"));

			// Convert the data retrieved into list<map>
			List<Map<String, Object>> procedureResponse = (List<Map<String, Object>>) userExistsResponse;

			// Username and OTP matches condition
			if (procedureResponse.get(0).get("msgcode").toString().equals("1")) {

				map.remove("OTP");

				// calling of user Profile create procedure
				Message userCreationMessage = genericProcess.GenericProcedureCalling("61", map, request, response);

				// Convert the data retrieved into list<map>
				List<Map<String, Object>> userCreatedCode = (List<Map<String, Object>>) userCreationMessage.getObject();

				// Check if user is not created already
				if (userCreatedCode.get(0).get("code").toString().equals("13")) {
					responsemap.putAll(userCreatedCode.get(0));
					responsemap.put("code", userCreatedCode.get(0).get("code").toString());
					// Set the response of API Calling
					message.setDescription("User created Successfully");
					message.setObject(responsemap);
					message.setValid(true);
					return message;
				} else {
					responsemap.put("code", "0");
					// Set the response of API Calling
					message.setDescription(userCreatedCode.get(0).get("msg").toString());
					message.setObject(responsemap);
					message.setValid(true);
					return message;
				}
			}
			// When username and otp does not match
			else {
				responsemap.put("code", "0");
				// Set the response of API Calling
				message.setDescription(procedureResponse.get(0).get("msg").toString());
				message.setObject(responsemap);
				message.setValid(true);
				return message;
			}
		}
		// handling exceptions
		catch (Exception exception) {

			return message;
		}
	}
}
