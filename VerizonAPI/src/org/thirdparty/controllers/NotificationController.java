
/**
 * This Package contains controllers of VERIZON API.
 */
package org.thirdparty.controllers;

/**
 * To Import Classes to access their functionality
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thirdparty.request.model.SIMActivated;
import org.thirdparty.services.SIMNotificationService;
import org.thirdparty.swagger.response.ApiResponseSwagger;
import com.google.gson.Gson;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
public class NotificationController {
	@Autowired
	private SIMNotificationService simNotificationService;

	/**
	 * This is the asynchronous notification sent for activateSIM request after
	 * successfully activating the SIM
	 * 
	 * 
	 * 
	 * @param request:::To
	 *            get HTTP Basic authentication,where consumer sends the
	 *            ‘user_name’ and ‘password’ separated by ‘:’, within a base64
	 *            and requestId and returnURL from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 * @throws Exception
	 */
	@ApiOperation(value = "/notifications/SIMActivated", notes = "This is the asynchronous notification sent for activateSIM request after successfully activating the SIM.", response = ApiResponseSwagger.class)
	@ApiImplicitParams({

			@ApiImplicitParam(name = "requestId", value = "Unique ID for the transaction generated by GM system.  Expected to be returned in any associated async responses.", required = true, access = "header", paramType = "header", dataType = "String") })
	@RequestMapping(value = "/notifications/SIMActivated", method = RequestMethod.POST)
	public ResponseEntity<?> SIMActivated(
			@ApiParam(name = "profile", value = "Data to OnBoard User. ") @RequestBody SIMActivated profile,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ResponseEntity<?> responseMessage = simNotificationService.simActivated(new Gson().toJson(profile).toString(),
				request, response);
		return responseMessage;

	}

}