package org.goup.mno.interfaceImpl;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.orchestration.services.GenericMethodService;
import org.orchestration.services.OrchestrationGenericProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component
public class GTInterface {

	@Autowired(required = true)
	private GenericMethodService methodService;

	@Autowired(required = true)
	private OrchestrationGenericProcess orchestrationGenericProcess;

	Logger logger = Logger.getLogger(GTInterface.class);

	public ResponseEntity<?> getSimDetails(Map<String, String> parameterMap, String country_code, String operator,
			HttpServletRequest request, HttpServletResponse response) {

		// getting custom error codes for respective api
		// Map<String, Object> errorMap = methodService.getErrorCodes("getSimDetails",
		// request, response);
		// if (methodService == null) {
		//
		// ServletContext servletContext = ((HttpServletRequest)
		// request).getSession().getServletContext();
		// WebApplicationContext webApplicationContext = WebApplicationContextUtils
		// .getWebApplicationContext(servletContext);
		// methodService = webApplicationContext.getBean(GenericMethodService.class);
		// }
		try {
			logger.info("**********************************Get Sim Details API***********************************");

			// creating map for input parameters which will be send for OL core for api
			// calling
			parameterMap.put("country_code", country_code);
			parameterMap.put("operator_name", operator);

			// Calling OL Core genericExecuteApiMethod Method to execute the API
			System.out.println(methodService);

			System.out.println(parameterMap);
			ResponseEntity<?> responseMessage = methodService.genericExecuteApiMethod("getSimDetails", parameterMap,
					request, response);

			logger.info(
					"***********************************API End*****************************************************");

			// Returning Response
			return responseMessage;

		} catch (Exception exception) {

			// logger.setLevel(org.apache.log4j.Level.ERROR);
			// logger.setPriority(Priority.ERROR);
			// logger.error("Exception Error in Update SimProfile API ERROR ", exception);
			//
			// Map<String, Object> ErrorMessageMap = (Map<String, Object>)
			// errorMap.get("3");
			//
			// Map<String, Object> ErrorMessage = new HashMap<String, Object>((Map)
			// ErrorMessageMap);
			// ErrorMessage.remove("priority");
			// ErrorMessage.put("code", ErrorMessage.get("code"));
			// ErrorMessage.put("description",
			// ErrorMessage.get("description").toString().concat(exception.getMessage()));
			//
			// List<Map<String, Object>> ErrorList = new LinkedList<>();
			// ErrorList.add(ErrorMessage);
			// Map<String, Object> FinalErrorMessageMap = new LinkedHashMap<>();
			// FinalErrorMessageMap.put("errors", ErrorList);
			// logger.info("***********************************API
			// End*****************************************************");
			exception.printStackTrace();

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
