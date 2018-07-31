/**
 * This package contain  class as Aspect is used to call to Insert the Logs for API's been accessed
 */
package com.springiot.logging;

/**
 * To Import Classes to access their functionality
 */
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.response.Token;

/**
 * 
 * This class use as Aspect is used to call to Insert the Logs for API's has
 * been accessed
 * 
 * @author Ankita Shrothi
 *
 */
@Aspect
public class AOPLogging {
	/**
	 * To Access the respective class Methods as their services
	 */

	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private ProcessParameter processParameter;
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired(required = true)
	private HttpServletRequest request;

	/**
	 * To get the Log and Insert it in Log insert procedure to store their logs
	 * 
	 * @param joinPoint
	 */
	@SuppressWarnings("unchecked")
	@After("execution(* com.springiot.controllers.*.*(..))")
	public void logAfterMappingHandler(JoinPoint joinPoint) {

		try {
			/**
			 * Initialize Parameter to store values to insert in Logs details
			 */
			Map<String, Object> proParam = processParameter.getMaps();

			String classType = null;
			String classTypeKeyValue = null;

			StringBuilder finalInputArg = new StringBuilder();

			String userKey = null;
			String user_id = null;

			Map<String, Object> argsParam = null;

			StringBuilder inputarg = new StringBuilder();

			for (Object obj : joinPoint.getArgs()) {
				/**
				 * To get the Class Type from Arguments of Joint
				 */
				classType = obj.getClass().getName();
				/**
				 * Checking Class Type
				 */
				if (classType.equals("java.util.LinkedHashMap")) {
					/**
					 * Add parameters in argsParam
					 */
					classTypeKeyValue = obj.getClass().getName();
					argsParam = (Map<String, Object>) obj;
					continue;
				}
				inputarg.append(obj + ",");
			}
			/**
			 * to check the input argument size
			 */
			if (inputarg.lastIndexOf(",") > 0) {
				inputarg.deleteCharAt(inputarg.lastIndexOf(","));
				// System.out.println("input Parameter List:- " + inputarg + " /
				// class type:- " + classType);
			}
			/**
			 * To Get The Class Type of the Controller where API is Called
			 */
			String name = joinPoint.getThis().getClass().getName();
			/**
			 * to get controller name
			 */
			String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));
			/**
			 * to get Method Name
			 */
			String methodName = joinPoint.getSignature().getName();
			/**
			 * To Check if the Login API is Called than Password UserKey and
			 * token will not be in Parameter list
			 */
			if (methodName.equals("oauthToken")) {
				try {/**
						 * to get parameters in Array
						 */
					String[] args = inputarg.toString().split(",");
					finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken") && classTypeKeyValue.equals("java.util.LinkedHashMap")) {
				/**
				 * To get the Parameters which is Passed to call the API
				 */
				try {
					if (argsParam != null) {/**
											 * To get check token Value
											 */
						String tokenValue = request.getHeader("token");
						if (tokenValue != null) {/**
													 * To get Token Value
													 */
							Token token = (Token) Constant.map.get(tokenValue.toString());
							// System.out.println("token" + token);
							if (token != null) {/**
												 * Too get userKey and user_id
												 * from token
												 */
								userKey = token.getUserKey().toString();
								user_id = token.getUser_id().toString();
							}
						}
						for (String key : argsParam
								.keySet()) {/**
											 * To get rest of the parameter
											 * passed in calling respective API
											 */
							finalInputArg.append(key + " = " + argsParam.get(key) + " ,");
						}
						if (finalInputArg
								.length() > 0) {/**
												 * If size is more than than
												 * remove last , from the string
												 */
							finalInputArg.deleteCharAt(finalInputArg.lastIndexOf(","));
						}
					}
				} catch (Exception e) { /**
										 * To catch the Exception
										 */
					e.printStackTrace();
				}

			}
			/**
			 * To get the url of API was Called
			 */
			String URIPatter = request.getRequestURI().substring(1);
			String URI = URIPatter.substring(URIPatter.indexOf("/"));
			/**
			 * To Insert the logs in the database by executing log insert
			 * procedure
			 */
			// genericService.executeProcesure(null,
			// proParam.get("5").toString(), controllerName.toString(),
			// finalInputArg.toString(), request.getRemoteHost(), URI, "",
			// userKey, user_id,
			// "08d31e35-ac87-11e6-b009-fe984cc15272", "api");

		} catch (Exception e) {/**
								 * To catch the exception if any
								 */
			e.printStackTrace();

		}

	}

	/**
	 * To Get the exception after storing the logs
	 * 
	 * @param joinPoint
	 * @param error
	 */
	@AfterThrowing(pointcut = "execution(* com.springiot.controllers.*.*(..))", throwing = "error")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable error) {

	}

}
