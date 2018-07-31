/**
 * This package contain  class as Component  for Getting Header and request and response for the Calling the API 
 */
package com.springiot.filter;

/**
 * To Import Classes to access their functionality
 */
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.springiot.request.model.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.InterfaceServices;

/**
 * This class is for Getting Header and request and response for the Calling the
 * API This Class get the request header and send the response of the API and
 * send Https Error codes in case of error
 * 
 * @author Mandeep Singh
 *
 */
@Component
public class TokenFilter implements Filter {

	private InterfaceServices methodService;
	/**
	 * To Filter the request of API's
	 */
	@Autowired
	private GenericProcess genericProcess;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		/**
		 * To get the Request
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		/**
		 * to get the URL of Application's API
		 */
		String URIPattern = request.getRequestURI().substring(1);
		String URI = URIPattern.substring(URIPattern.indexOf("/"));
		/**
		 * To set the response properties
		 */
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type,Accept, Access-Control-Allow-Headers, Authorization, X-Requested-With,user_name,password,requestId,returnUrl,Accept");
		/**
		 * To Bypass the API url from Authentication
		 */
		if (URI.equals("/") || URI.equals("/swagger-ui.html") || URI.equals("/getAuthorization/token")
				|| URI.equals("/push/notification") || URI.equals("/onboarding") || URI.equals("/push/gc/api")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs")) {
			/**
			 * To process API
			 */
			chain.doFilter(req, res);

		} else {
			/**
			 * To Access the functionality of the GenericMethodService Defined
			 * in the Application
			 */
			if (genericProcess == null) {

				ServletContext servletContext = req.getServletContext();
				WebApplicationContext webApplicationContext = WebApplicationContextUtils
						.getWebApplicationContext(servletContext);
				genericProcess = webApplicationContext.getBean(GenericProcess.class);
			}
			if (methodService == null) {

				ServletContext servletContext = req.getServletContext();
				WebApplicationContext webApplicationContext = WebApplicationContextUtils
						.getWebApplicationContext(servletContext);
				methodService = webApplicationContext.getBean(InterfaceServices.class);
			}
			/**
			 * To check if header doesn't contains auth token
			 */
			if (request.getHeader("authToken") == null) {
				/**
				 * To Send Error Response
				 */
				response.sendError(401);
			} else {
				/**
				 * Initializing passingMap to call OL Procedure
				 */
				Map<String, String> passingMap = new LinkedHashMap<>();
				passingMap.put("token", request.getHeader("authToken"));

				try {
					/**
					 * Calling Third party procedure to authorize user.
					 */
					Message message = genericProcess.GenericThirdPartyProcedureCalling("2", passingMap, null, request,
							response);
					List<Map<String, Object>> valid = (List<Map<String, Object>>) message.getObject();
					/**
					 * To check if response is valid
					 */
					 if (valid.get(0).get("is_valid").toString().equalsIgnoreCase("1"))
					 {
						 chain.doFilter(request, response);
					 } else {
						 /**
						  * To Send Error Response
						  */
						 response.sendError(401);
					 }
				} catch (Exception e) {
					/**
					 * If Exception Occurs
					 */
					e.printStackTrace();
					response.sendError(400, e.getMessage());
				}
			}
		}
	}

	/**
	 * init Method to call within a method
	 */
	public void init(FilterConfig filterConfig) {
	}

	/**
	 * To destroy the API session
	 */
	public void destroy() {
	}

}