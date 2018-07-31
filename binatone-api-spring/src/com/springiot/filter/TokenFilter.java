/**
 * This package contain  class as Component  for Getting Header and request and response for the Calling the API 
 */
package com.springiot.filter;

/**
 * To Import Classes to access their functionality
 */
import java.io.IOException;
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
import com.springiot.response.Token;
import com.springiot.services.ThirdPartyServices;

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

	private ThirdPartyServices thirdPartyServices;

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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token,user_key,user_id");

		/**
		 * To Ignore the Given URL's from Token Check
		 */
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/swagger-ui.html")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs") || URI.contains("/thirdparty/integration/token")
				|| URI.equals("/getapiurl") || URI.equals("/mapping/handler") || URI.equals("/check")) {

			chain.doFilter(request, response);

		} else {
			/**
			 * To Filter the request of API's has token or not
			 */
			String tokenFromHeader = request.getHeader("token");
			String userKeyFromHeader = request.getHeader("user_key");
			String userIdFromHeader = request.getHeader("user_id");

			if (request.getMethod().trim().toString().equalsIgnoreCase("POST")) {

				if (Constant.map.get(tokenFromHeader) == null) {
					System.out.println("Token is not authorized");

					if (thirdPartyServices == null) {

						ServletContext servletContext = req.getServletContext();
						WebApplicationContext webApplicationContext = WebApplicationContextUtils
								.getWebApplicationContext(servletContext);
						thirdPartyServices = webApplicationContext.getBean(ThirdPartyServices.class);
					}

					String applicationKey = "9a959887-5946-11e6-9bb0-fe984cc15272";

					Map<String, String> parameterMap = new HashMap<>();
					parameterMap.put("token", tokenFromHeader);
					parameterMap.put("user_key", userKeyFromHeader);
					parameterMap.put("user_id", userIdFromHeader);
					parameterMap.put("application_key", applicationKey);

					// Retrieve from where the request is coming to API
					String Type = request.getHeader("User-Agent");
					System.out.println("type" + Type);

					Integer tokenType;
					if (Type.contains("okhttp")) {
						tokenType = 1;
					} else {
						tokenType = 0;
					}

					Message responseFromAuth = thirdPartyServices.validateToken(parameterMap, tokenType, request,
							response);

					System.out.println("responseFromAuth" + responseFromAuth.getObject());

					List<Map<String, Object>> tokenMap = (List<Map<String, Object>>) responseFromAuth.getObject();

					if (responseFromAuth.getObject() != null) {
						if (tokenMap.get(0).get("status").toString().equalsIgnoreCase("1.0")) {

							String token = tokenMap.get(0).get("access_token").toString();

							Token tokenClass = new Token();

							tokenClass.setAccess_key(tokenMap.get(0).get("access_key").toString());
							tokenClass.setAccess_token(tokenMap.get(0).get("access_token").toString());
							// tokenClass.setMessage(tokenMap.get(0).get("message").toString());
							tokenClass.setRoles_id(tokenMap.get(0).get("roles_id").toString());
							tokenClass.setRoles_name(tokenMap.get(0).get("roles_name").toString());

							tokenClass.setStatus(tokenMap.get(0).get("status").toString());
							tokenClass.setToken_type(tokenType);
							tokenClass.setUser_id(tokenMap.get(0).get("user_id").toString());
							tokenClass.setUserKey(tokenMap.get(0).get("user_key").toString());

							Constant.addTokon(token, tokenClass);

							request.setAttribute("access_key", tokenMap.get(0).get("access_key"));

							chain.doFilter(request, response);
						} else {
							response.getWriter().print("UnAuthrization");
							response.sendError(401);
							response.getWriter().flush();
						}
					} else {
						response.getWriter().print("UnAuthrization");
						response.sendError(401);
						response.getWriter().flush();
					}

				} else {
					System.out.println("api call with token in constant map ");

					Token tokenClass = (Token) Constant.map.get(tokenFromHeader);

					request.setAttribute("access_key", tokenClass.getAccess_key());

					/**
					 * It Will process the Api calling with the coming header
					 * and reverts back the response
					 */
					chain.doFilter(request, response);
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
