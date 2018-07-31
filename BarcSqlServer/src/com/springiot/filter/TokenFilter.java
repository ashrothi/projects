/**
 * This package contains the classes use to apply filters in API and handle request.
 */
package com.springiot.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.springiot.constant.Constant;

/**
 * 
 * This class is used to Handle Request of API's and filter the request type.
 */
@Component
public class TokenFilter implements Filter {

	/**
	 * To Filter the request of API's
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * Set request type of API.
		 */
		HttpServletRequest request = (HttpServletRequest) req;

		String URIPatter = request.getRequestURI().substring(1);

		String URI = URIPatter.substring(URIPatter.indexOf("/"));

		// System.out.println("URI:- " + URI+"===== URIPatter="+URIPatter);
		/**
		 * To by pass require API from authentication process, apply filter
		 * here.
		 */
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/vehicle/get/score")
				|| URI.equals("/thirdparty/integration/token") || URI.equals("/validateuserkey")
				|| URI.equals("/swagger-ui.html") || URI.contains("/webjars/springfox") || URI.contains("/images")
				|| URI.contains("/swagger-resources") || URI.contains("/v2/api-docs") || URI.contains("/forgotpassword")
				|| URI.contains("/passwordreset") || URI.contains("/getallurl") || URI.contains("/getviewurl")
				|| URI.contains("/mapping/handler") || URI.contains("/getapiurl")
				|| URI.contains("/user/profile/create") || URI.contains("/country/get")
				|| URI.contains("/state/get/by/country/id") || URI.contains("/city/get/by/state/id")
				|| URI.contains("/barc/ping/server") || URI.contains("/barc/get/hashcode")
				|| URI.equals("/barc/media/url/get")) {

			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
			response.addHeader("Access-Control-Allow-Origin", "*");
			// response.setHeader("Access-Control-Allow-Headers", "*");
			chain.doFilter(req, res);

		} else {

			/**
			 * To Filter the request of API's for cross plateform
			 * authentication.
			 */
			String token = request.getParameter("token");

			if (Constant.map.get(token) == null) {
				HttpServletResponse response = (HttpServletResponse) res;
				response.sendError(401);
			} else {
				HttpServletResponse response = (HttpServletResponse) res;
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
				response.setHeader("Access-Control-Max-Age", "3600");
				response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
				response.addHeader("Access-Control-Allow-Origin", "*");
				// response.setHeader("Access-Control-Allow-Headers", "*");
				chain.doFilter(req, res);
			}

		}

	}

	/**
	 * Override methods while implementing filter class.
	 */
	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}