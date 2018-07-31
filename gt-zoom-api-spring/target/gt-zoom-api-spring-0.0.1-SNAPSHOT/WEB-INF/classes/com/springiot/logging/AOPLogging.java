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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
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
@PropertySource(value = "classpath:/UserCreate.properties")
public class AOPLogging {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericService genericService;
	@Autowired
	Environment environment;
	@Autowired
	private ProcessParameter processParameter;

	@Autowired(required = true)
	private HttpServletRequest request;

	/**
	 * To get the Log and Insert it in Log insert procedure to store their logs
	 * 
	 * @param joinPoint
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@After("execution(* com.springiot.controllers.*.*(..))")
	public void logAfterMappingHandler(JoinPoint joinPoint) {

		try {

			Map<String, Object> proParam = processParameter.getMaps();
			/**
			 * Initialize Parameter to store values to insert in Logs details
			 */
			String classType = null;
			String classTypeKeyValue = null;

			StringBuilder finalInputArg = new StringBuilder();

			String user_key = null;
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
					classTypeKeyValue = obj.getClass().getName();
					/**
					 * Add parameters in argsParam
					 */

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
				System.out.println("input Parameter List:- " + inputarg + " / class type:- " + classType);
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
			 * To Check if the Login API is Called than Password user_key and
			 * token will not be in Parameter list
			 */
			if (methodName.equals("oauthToken")) {
				try {
					/**
					 * to get parameters in Array
					 */

					String[] args = inputarg.toString().split(",");

					finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken")) {
				/**
				 * To get the Parameters which is Passed to call the API
				 */
				try {
					if (argsParam != null) {
						/**
						 * To get check token Value
						 */
						String tokenValue = request.getHeader("token");

						if (tokenValue != null) {
							/**
							 * To get Token Value
							 */
							Token token = (Token) Constant.map.get(tokenValue.toString());
							System.out.println("token" + token.toString());
							if (token != null) {
								/**
								 * Too get user_key and user_id from token
								 */
								user_key = token.getUser_key().toString();
								user_id = token.getUser_id().toString();
							}
						}
						for (String key : argsParam.keySet()) {
							/**
							 * To get rest of the parameter passed in calling
							 * respective API
							 */
							finalInputArg.append(key + " = " + argsParam.get(key) + " ,");
						}
						if (finalInputArg.length() > 0) {
							/**
							 * If size is more than than remove last , from the
							 * string
							 */
							finalInputArg.deleteCharAt(finalInputArg.lastIndexOf(","));
						}
					}
				} catch (Exception e) {
					/**
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
			genericService.executeProcesure(null, proParam.get("4").toString(), controllerName.toString(),
					finalInputArg.toString(), request.getRemoteHost(), URI, user_key, user_id,
					String.valueOf(environment.getProperty("application.key")), request.getAttribute("org_id"));

		} catch (Exception e) {
			/**
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
		/**
		 * Printing the Error
		 */
		System.out.println("Exception:- " + error.toString());

	}

}
