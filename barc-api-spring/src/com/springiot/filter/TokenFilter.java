package com.springiot.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.springiot.constant.Constant;
import com.springiot.response.Message;
import com.springiot.services.GenericProcess;

/**
 * @author Garima Joshi This class is used to Handle Request of API's and filter
 *         the respective url's.
 */
@Component
public class TokenFilter implements Filter {

	private GenericProcess genericProcess;

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
		 * Getting the Object of res to set their property to get custom header
		 * as token, user_key and user_id
		 */
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type,Access-Control-Allow-Headers, Authorization,X-Requested-With,token,user_key,user_id");

		// List of Specific URL's which does not requires token as a parameter
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/swagger-ui.html")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs") || URI.contains("/barc/ping/server")
				|| URI.equals("/barc/media/url/get") || URI.equals("/barc/user/login")) {

			chain.doFilter(requestType, response);

		}
		// In other API's we require token as a parameter.
		else {
			/**
			 * To Filter the request of API's has token or not
			 */
			String tokenFromHeader = requestType.getHeader("token");

			try {
				// System.out.println("token" + tokenFromHeader);

				// Check the the request Method is port or not
				if (requestType.getMethod().trim().toString().equalsIgnoreCase("POST")) {
					if (Constant.map.get(tokenFromHeader) == null) {

						// Calling of Generic Process class for calling
						// procedure to
						// validate token
						if (genericProcess == null) {

							ServletContext servletContext = req.getServletContext();
							WebApplicationContext webApplicationContext = WebApplicationContextUtils
									.getWebApplicationContext(servletContext);
							genericProcess = webApplicationContext.getBean(GenericProcess.class);
						}

						// Input parameters of procedure
						Map<String, Object> inputMap = new HashMap<>();
						inputMap.put("token", tokenFromHeader);

						// Calling of procedure
						Message message = genericProcess.GenericProcedureCalling("6", inputMap, requestType, response);

						// Cast the response into list<map>
						List<Map<String, Object>> responeMap = (List<Map<String, Object>>) message.getObject();
						// System.out.println(responeMap);

						// check token exits in dB or not
						if (responeMap.get(0).get("is_valid").toString().equalsIgnoreCase("1")) {
							long initialTime = new Date().getTime();

							chain.doFilter(req, res);
							long finalTime = new Date().getTime();
							System.out.println("response time :" + (finalTime - initialTime));
						}
						// if it does not exits gives 401
						else {
							response = (HttpServletResponse) res;
							response.sendError(401);
						}

					} else {

						chain.doFilter(req, res);
					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
