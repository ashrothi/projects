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

		/**
		 * To Get Headers from request coming for API Calling
		 */
		Enumeration<String> string = request.getHeaderNames();
		/**
		 * To Print the headers coming in request
		 */
		while (string.hasMoreElements()) {
			String name = string.nextElement();

		}

		/**
		 * Getting the Object of res to set their property to get custom header
		 * as token, userKey and user_id
		 */
		HttpServletResponse response = (HttpServletResponse) res;

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "POST, GET,OPTIONS, DELETE");
		response.addHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization,X-Requested-With,token,userKey,user_id");
		response.setHeader("Access-Control-Request-Headers", "token,userKey,user_id");

		/**
		 * To by pass require API from authentication process, apply filter
		 * here.
		 */
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/vehicle/get/score")

				|| URI.equals("/swagger-ui.html") || URI.contains("/webjars/springfox") || URI.contains("/images")
				|| URI.contains("/swagger-resources") || URI.contains("/v2/api-docs")
				|| URI.equals("/demographic/data")) {

			chain.doFilter(request, response);

		} else {

			/**
			 * To Filter the request of API's has token or not
			 */
			String token = request.getHeader("token");

			if (Constant.map.get(token) == null) {

				/**
				 * If token doesn't match with the saved token than it will
				 * through unAutherized Error
				 */
				response.getWriter().print("UnAuthrization");
				response.getWriter().flush();

			} else {

			

				/**
				 * It Will process the Api calling with the coming header and
				 * reverts back the response
				 */
				chain.doFilter(request, response);
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
