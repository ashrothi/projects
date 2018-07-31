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
	private OAUTHTokenServices oauthTokenService;

	/**
	 * To Filter the request of API's
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		/**
		 * To get the Request
		 */
		HttpServletRequest requestType = (HttpServletRequest) req;
		/**
		 * to get the URL of Application's API
		 */
		String URIPatter = requestType.getRequestURI().substring(1);
		/**
		 * to get the URL of Application's API from first index of /
		 */
		String URI = URIPatter.substring(URIPatter.indexOf("/"));
		
		/**
		 * Getting the Object of res to set their property to get custom header
		 * as token, userKey and user_id
		 */
		
		HttpServletResponse response = (HttpServletResponse) res;
		if(URI.contains("/query")|| URI.contains("/search")||URI.contains("/annotation")){
			System.out.println("allow origin ");
			//response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers",
					"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token,userKey,user_id");
			response.setHeader("Access-Control-Allow-Credentials", "true");

		}else{
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With,token,user_key,user_id");
		response.setHeader("Access-Control-Expose-Headers", "token,user_key,user_id");
		}
		/**
		 * To Ignore the Given URL's from Token Check
		 */

		if (URI.equals("/") || URI.equals("/oauth/token") || URI.equals("/oauth/mobile/token")
				|| URI.equals("/gt/onstar/device/register") || URI.equals("/swagger-ui.html")
				|| URI.contains("/webjars/springfox") || URI.contains("/images") || URI.contains("/swagger-resources")
				|| URI.contains("/v2/api-docs") || URI.contains("/thirdparty/integration/token")
				|| URI.equals("/getapiurl") || URI.equals("/flint/get/task/info/by/task/alias")
				|| URI.equals("/flint/closed/tickets/track/order/activity/get/by/id")
				|| URI.equals("/flint/open/tickets/track/order/activity/get/by/id") || URI.equals("/getapiurl/class")
				|| URI.equals("/mapping/handler") || URI.equals("/check") ||  URI.contains("/query") || URI.contains("/search")
				|| URI.contains("/annotations") || URI.contains("/check/organization") ) {

			chain.doFilter(requestType, response);

		} else {
			/**
			 * /** To Filter the request of API's has token or not
			 */
			String tokenFromHeader = requestType.getHeader("token");
			

			try {
				// System.out.println("token" + tokenFromHeader);

				if (requestType.getMethod().trim().toString().equalsIgnoreCase("POST")) {

					if (Constant.map.get(tokenFromHeader) == null) {
						// System.out.println("Token is not authorized");

						if (oauthTokenService == null) {

							ServletContext servletContext = req.getServletContext();
							WebApplicationContext webApplicationContext = WebApplicationContextUtils
									.getWebApplicationContext(servletContext);
							oauthTokenService = webApplicationContext.getBean(OAUTHTokenServices.class);
						}

						Message responseFromAuth = oauthTokenService.validateToken(requestType, response);

						// System.out.println("responseFromAuth" +
						// responseFromAuth.getObject());

						List<Map<String, Object>> tokenMap = (List<Map<String, Object>>) responseFromAuth.getObject();

						if (responseFromAuth.getObject() != null) {
							if (tokenMap.get(0).get("status").toString().equalsIgnoreCase("1.0")) {

								// System.out.println("Token Found in
								// database");
								String token = tokenMap.get(0).get("access_token").toString();

								Token tokenClass = new Token();

								tokenClass.setAccess_key(tokenMap.get(0).get("access_key").toString());
								tokenClass.setAccess_token(tokenMap.get(0).get("access_token").toString());
								// tokenClass.setMessage(tokenMap.get(0).get("message").toString());
								tokenClass.setRoles_id(tokenMap.get(0).get("roles_id").toString());
								tokenClass.setRoles_name(tokenMap.get(0).get("roles_name").toString());
								tokenClass.setStatus(tokenMap.get(0).get("status").toString());

								tokenClass.setUser_id(tokenMap.get(0).get("user_id").toString());
								tokenClass.setUser_key(tokenMap.get(0).get("user_key").toString());

								Constant.addTokon(token, tokenClass);

								requestType.setAttribute("access_key", tokenMap.get(0).get("access_key"));
								requestType.setAttribute("user_key", tokenMap.get(0).get("user_key"));
								requestType.setAttribute("user_id", tokenMap.get(0).get("user_id"));
								requestType.setAttribute("role_id", tokenMap.get(0).get("roles_id"));
								requestType.setAttribute("org_id", Constant.organizationId.get(String.valueOf(tokenMap.get(0).get("user_key"))));
								chain.doFilter(requestType, response);
							} else {

								response.sendError(401);
							}
						} else {

							response.sendError(401);
						}

					} else {
						// System.out.println("api call with token in constant
						// map ");

						Token tokenClass = (Token) Constant.map.get(tokenFromHeader);

						requestType.setAttribute("access_key", tokenClass.getAccess_key());
						requestType.setAttribute("user_key", tokenClass.getUser_key());
						requestType.setAttribute("user_id", tokenClass.getUser_id());
						requestType.setAttribute("role_id", tokenClass.getRoles_id());
						requestType.setAttribute("org_id", Constant.organizationId.get(String.valueOf(tokenClass.getUser_key())));
						/**
						 * It Will process the Api calling with the coming
						 * header and reverts back the response
						 */
						chain.doFilter(requestType, response);
					}

				} else {
					chain.doFilter(requestType, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
