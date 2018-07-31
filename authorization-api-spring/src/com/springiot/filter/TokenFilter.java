/**
 * This package contains the classes use to apply filters in API and handle request.
 */
package com.springiot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;

/**
 * 
 * This class is used to Handle Request of API's and filter the request type.
 */
@Component
public class TokenFilter implements Filter {

	private GenericProcess genericProcess;
	// private ProcessParameter processParameter;

	private static final String applicationKey = "19ab64ac-588e-11e6-85b9-fe984cc15272";

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
		 * Getting the Object of res to set their property to get custom header
		 * as token, user_key and user_id
		 */
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.addHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization,X-Requested-With,token,user_key,user_id");
		response.setHeader("Access-Control-Request-Headers", "token,user_key,user_id");

		/**
		 * To by pass require API from authentication process, apply filter
		 * here.
		 */
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.contains("/swagger-ui.html")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs") || URI.equals("/forgotpassword") || URI.equals("/passwordreset")
				|| URI.equals("/getallurl") || URI.equals("/getviewurl") || URI.equals("/mapping/handler")
				|| URI.equals("/getapiurl") || URI.equals("/user/profile/create") || URI.equals("/country/get")
				|| URI.equals("/state/get/by/country/id") || URI.equals("/city/get/by/state/id")
				|| URI.equals("/user/verification") || URI.equals("/validate/accesskey/url")
				|| URI.equals("/user/creation/signup")) {

			chain.doFilter(request, response);

		} else {

			/**
			 * To Filter the request of API's has token or not
			 */

			if (request.getMethod().trim().toString().equalsIgnoreCase("POST")) {

				if (genericProcess == null) {


					ServletContext servletContext = req.getServletContext();
					WebApplicationContext webApplicationContext = WebApplicationContextUtils
							.getWebApplicationContext(servletContext);
					genericProcess = webApplicationContext.getBean(GenericProcess.class);
				}
				Message message = genericProcess.tokenValidate(request, response);
				if (message.isValid()) {
					chain.doFilter(request, response);
				} else {
					response.sendError(401);
				}

			
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