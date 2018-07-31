/**
 * This package contain  class as Component  for Getting Header and request and response for the Calling the API 
 */
package com.springiot.filter;

/**
 * To Import Classes to access their functionality
 */
import java.io.IOException;
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
import com.springiot.services.OAUTHTokenServices;

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

	private OAUTHTokenServices oauthServices;

	/**
	 * To Filter the request of API's
	 */
	@SuppressWarnings("unchecked")
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
		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/desktop/oauth/token")
				|| URI.equals("/swagger-ui.html") || URI.contains("/webjars/springfox") || URI.contains("/images")
				|| URI.contains("/swagger-resources") || URI.contains("/v2/api-docs")
				|| URI.contains("/thirdparty/integration/token") || URI.equals("/getapiurl")
				|| URI.equals("/mapping/handler") || URI.equals("/check")) {

			chain.doFilter(request, response);

		} else {
			/**
			 * To Filter the request of API's has token or not
			 */
			String userKeyFromHeader = request.getHeader("user_key");
			System.out.println(request.getHeader("user_key"));
			if (request.getMethod().trim().toString().equalsIgnoreCase("POST")) {

				if (Constant.map.get(userKeyFromHeader) == null) {
					// System.out.println("Token is not authorized");

					if (oauthServices == null) {

						ServletContext servletContext = req.getServletContext();
						WebApplicationContext webApplicationContext = WebApplicationContextUtils
								.getWebApplicationContext(servletContext);
						oauthServices = webApplicationContext.getBean(OAUTHTokenServices.class);
					}

					// Retrieve from where the request is coming to API
					String Type = request.getHeader("User-Agent");
					// System.out.println("type" + Type);

					Integer tokenType;
					if (Type.contains("okhttp")) {
						tokenType = 1;
					} else {
						tokenType = 0;
					}
					/**
					 * To validate token fron Auth
					 */
					Message responseFromAuth = oauthServices.validateToken(tokenType, request, response);
					/**
					 * Casting response of auth
					 */
					List<Map<String, Object>> tokenMap = (List<Map<String, Object>>) responseFromAuth.getObject();
					/**
					 * To check if responseFromAuth is not null
					 */
					if (responseFromAuth.getObject() != null) {
						if (tokenMap.get(0).get("status").toString().equalsIgnoreCase("1.0")) {

							System.out.println("tokenMap.get(0) " + tokenMap.get(0));
							String token = tokenMap.get(0).get("access_token").toString();
							String applicaionuserKey = tokenMap.get(0).get("user_key").toString();

							/**
							 * Setting token value
							 */
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
							tokenClass.setUser_key(tokenMap.get(0).get("user_key").toString());

							Constant.addTokon(applicaionuserKey, tokenClass);
							/**
							 * To set request Attribute
							 */

							request.setAttribute("access_key", tokenMap.get(0).get("access_key"));
							request.setAttribute("user_key", tokenMap.get(0).get("user_key"));
							request.setAttribute("user_id", tokenMap.get(0).get("user_id"));
							request.setAttribute("role_id", tokenMap.get(0).get("roles_id"));
							request.setAttribute("org_id",
									Constant.orgmap.get(String.valueOf(tokenMap.get(0).get("user_key"))));
							/**
							 * It Will process the Api calling with the coming
							 * header and reverts back the response
							 */
							chain.doFilter(request, response);
						} else {
							/**
							 * To send UnAuthrization response
							 */
							response.getWriter().print("UnAuthrization");
							response.sendError(401);
							response.getWriter().flush();
						}
					} else {
						/**
						 * To send UnAuthrization response
						 */
						response.getWriter().print("UnAuthrization");
						response.sendError(401);
						response.getWriter().flush();
					}

				} else {
					/**
					 * To set the request attribute
					 */

					Token tokenClass = (Token) Constant.map.get(userKeyFromHeader);
					request.setAttribute("access_key", tokenClass.getAccess_key());
					request.setAttribute("user_key", tokenClass.getUser_key());
					request.setAttribute("user_id", tokenClass.getUser_id());
					request.setAttribute("role_id", tokenClass.getRoles_id());
					request.setAttribute("org_id", Constant.orgmap.get(String.valueOf(tokenClass.getUser_key())));
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
