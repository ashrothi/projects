/**
 * This package contain  class as Component  for Getting Header and request and response for the Calling the API 
 */
package org.gmonstar.notification.filter;

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

import org.gmonstar.notification.response.model.Message;
import org.gmonstar.notification.services.GenericProcess;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * This class is for Getting Header and request and response for the Calling the
 * API This Class get the request header and send the response of the API and
 * send Https Error codes in case of error
 * 
 * @author Ankita Shrothi
 *
 */
@Component
public class TokenFilter implements Filter {

	private GenericProcess genericProcess;

	/**
	 * To Filter the request of API's
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		if (genericProcess == null) {

			ServletContext servletContext = req.getServletContext();
			WebApplicationContext webApplicationContext = WebApplicationContextUtils
					.getWebApplicationContext(servletContext);
			genericProcess = webApplicationContext.getBean(GenericProcess.class);
		}

		/**
		 * To get the Request
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		/**
		 * to get the URL of Application's API
		 */
		String URIPattern = request.getRequestURI().substring(1);
		String URI = URIPattern.substring(URIPattern.indexOf("/"));

		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token");

		if (URI.equals("/") || URI.equals("/swagger-ui.html") || URI.contains("/webjars/springfox")
				|| URI.contains("/images") || URI.contains("/swagger-resources") || URI.contains("/v2/api-docs")) {

			chain.doFilter(req, res);

		} else {
			/**
			 * To Filter the request of API's for cross plateform
			 */

			String token = null;

			if (URI.equals("/notification/dataUsageThresholdMet") || URI.equals("/notification/dataConsumed")
					|| URI.equals("/notification/orderStarted") || URI.equals("/notification/orderExpired")) {

				token = request.getParameter("token");

			} else {
				token = request.getHeader("token");

			}

			if (token == null) {
				response.sendError(401);
			} else {
				Map<String, String> map = new LinkedHashMap<>();
				map.put("token", token);
				try {
					
					Message message = genericProcess.GenericProcedureCalling("1", map, null, request, response);
					if (message.isValid()) {
						List<Map<String, Object>> formattedList = (List<Map<String, Object>>) message.getObject();
						if (formattedList.get(0).get("is_valid").toString().equalsIgnoreCase("1")) {
							chain.doFilter(request, response);
						} else {
							response.sendError(401);
						}
					}
				} catch (Exception e) {

					e.printStackTrace();
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
