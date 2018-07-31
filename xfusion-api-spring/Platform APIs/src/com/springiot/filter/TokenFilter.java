package com.springiot.filter;

import java.io.IOException;
import java.util.Date;
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
import com.springiot.services.UrlValidationKeyService;

/**
 * @author Garima Joshi This class is used to Handle Request of API's and filter
 *         the respective url's.
 */
@Component
public class TokenFilter implements Filter {

	private UrlValidationKeyService urlValidationKeyService;

	/**
	 * To Filter the request of API's
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		// Initialization of HttpServletRequest class
		HttpServletRequest requestType = (HttpServletRequest) req;

		String URIPatter = requestType.getRequestURI().substring(1);

		String URI = URIPatter.substring(URIPatter.indexOf("/"));

		/**
		 * Getting the Object of res to set their property to get custom header as
		 * token, user_key and user_id
		 */

		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type,Access-Control-Allow-Headers, Authorization,X-Requested-With,token,user_key,user_id");

		response.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,/;q=0.8");
		// List of Specific URL's which does not requires token as a parameter
		if (URI.equals("/") || URI.equals("/xfusionusers") || URI.equals("/oauth/token") || URI.equals("/rule/status")
				|| URI.equals("/upload/firmware/file") || URI.contains("/user/get/info/by/user/key")
				|| URI.equals("/swagger-ui.html")|| URI.contains("/swagger-ui.html") || URI.contains("/webjars/springfox") || URI.contains("/images")
				|| URI.contains("/swagger-resources") || URI.contains("/v2/api-docs") || URI.contains("/getapiurl")
				|| URI.contains("/mapping/handler") || URI.contains("/forgotpassword") || URI.contains("/passwordreset")
				|| URI.contains("/thirdparty/integration/token") || URI.contains("/iothub/publisher")
				|| URI.contains("/organization/check") || URI.contains("/city/get/city")
				|| URI.contains("/country/get/country") || URI.contains("/state/get/state") || URI.contains("/test")
				|| URI.equals("/plain/text/to/encrypted/format") || URI.equals("/encrypted/text/to/plain/format")
				|| URI.equals("/user/get/info/by/user/key") || URI.equals("/getapiurl")
				|| URI.equals("/mapping/handler") || URI.equals("/forgotpassword") || URI.equals("/passwordreset")
				|| URI.equals("/thirdparty/integration/token") || URI.equals("/iothub/publisher")
				|| URI.equals("/organization/check") || URI.equals("/city/get/city")
				|| URI.equals("/country/get/country") || URI.equals("/state/get/state")) {

			long initialTime = new Date().getTime();

			chain.doFilter(requestType, response);
			long finalTime = new Date().getTime();
			System.out.println("response time :" + (finalTime - initialTime));

		}

		// In other API's we require token as a parameter.
		else {
			/**
			 * To Filter the request of API's has token or not
			 */

			// String tokenFromHeader = requestType.getHeader("token");

			try {

				// Check the the request Method is port or not
				if (requestType.getMethod().trim().toString().equalsIgnoreCase("POST")) {

					// // Calling of Generic Service class
					if (urlValidationKeyService == null) {

						ServletContext servletContext = req.getServletContext();
						WebApplicationContext webApplicationContext = WebApplicationContextUtils
								.getWebApplicationContext(servletContext);
						urlValidationKeyService = webApplicationContext.getBean(UrlValidationKeyService.class);
					}
					Message validUrl = urlValidationKeyService.tokenValidateURL(requestType, response);

					if (validUrl.isValid()) {
						long initialTime = new Date().getTime();
						chain.doFilter(requestType, response);
						long finalTime = new Date().getTime();
						System.out.println("response time :" + (finalTime - initialTime));
					} else {
						response.sendError(401);
					}

				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
