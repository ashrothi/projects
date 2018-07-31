/**
 * This package contain  class as Component  for Getting Header and request and response for the Calling the API 
 */
package com.springiot.filter;

/**
 * To Import Classes to access their functionality
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.springiot.constant.Constant;

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

	/**
	 * To Filter the request of API's
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		/**
		 * To get the Request
		 */
		HttpServletRequest request = (HttpServletRequest) req;
		/**
		 * to get the URL of Application's API
		 */
		String URIPatter = request.getRequestURI().substring(1);
		/**
		 * to get the URL of Application's API from first index of /
		 */
		String URI = URIPatter.substring(URIPatter.indexOf("/"));

		/**
		 * To Ignore the Given URL's from Token Check
		 */

		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/vehicle/get/score")
				|| URI.equals("/cyclescheduling/by/xfusion") || URI.equals("/swagger-ui.html")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs") || URI.equals("/dailyreportcheduling/by/hero")
				|| URI.equals("/getapiurl") || URI.equals("/getapiurl/class") || URI.equals("/mapping/handler")
				|| URI.equals("/check") || URI.equals("/download/daily/horn/report/Escalation")
				|| URI.equals("/download/daily/relay/report/Escalation")
				|| URI.equals("/download/daily/side/stand/report/Escalation")
				|| URI.equals("/download/planner/report/Escalation") || URI.equals("/forgotpassword")
				|| URI.equals("/passwordreset")) {

			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
			chain.doFilter(req, res);

		} else {
			/**
			 * To Filter the request of API's for cross plateform
			 */
			String token = request.getParameter("token");
			/**
			 * If token doesn't match with the saved token than it will through
			 * unAutherized Error
			 */
			if (Constant.map.get(token) == null) {

				HttpServletResponse response = (HttpServletResponse) res;
				response.sendError(401);
			} else {
				/**
				 * It Will process the Api calling with the coming header and
				 * reverts back the response
				 */
				HttpServletResponse response = (HttpServletResponse) res;
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
				response.setHeader("Access-Control-Max-Age", "3600");
				response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
				chain.doFilter(req, res);
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
