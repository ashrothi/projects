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
		 * Getting the Object of res to set their property to get custom header
		 * as token, userKey and user_id
		 */

		HttpServletResponse response = (HttpServletResponse) res;
		// response.setHeader("Access-Control-Allow-Origin",
		// "http://192.168.1.33:8083");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token,userKey,user_id");
		response.setHeader("Access-Control-Allow-Credentials", "true");

		/**
		 * To Get Headers from request coming for API Calling
		 */
		// Enumeration<String> string = request.getHeaderNames();
		/**
		 * To Print the headers coming in request
		 *//*
			 * while (string.hasMoreElements()) { String name =
			 * string.nextElement(); System.out.println("header name:- " + name
			 * + "- value:-" + request.getHeader(name)); }
			 */
		/**
		 * To Ignore the Given URL's from Token Check
		 */

		System.out.println("URI----" + URI.contains("/query"));

		// System.out.println("TOKEN FILTER--" + request.getHeader("Cookie"));

		if (URI.contains("/") || URI.equals("/oauth/token") || URI.equals("/oauth/mobile/token")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.equals("/user/get/roles") || URI.contains("/query") || URI.contains("/search")
				|| URI.contains("/annotations") || URI.equals("/organization/insert")
				|| URI.equals("/user/organization/insert") || URI.equals("/user/delete")
				|| URI.equals("/user/update/organizations") || URI.equals("/update/organization")
				|| URI.equals("/delete/organization")) {

			chain.doFilter(request, response);

		} else {
					

			System.out.println("Token :-" + request.getHeader("token"));

			/**
			 * It Will process the Api calling with the coming header and
			 * reverts back the response
			 */
			chain.doFilter(request, response);

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
