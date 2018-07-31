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
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
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
	@Autowired
	private GenericService genericService;
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
	@SuppressWarnings({ "unchecked", "unused" })
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
			 * To Check if the Login API is Called than Password user_key and
			 * token will not be in Parameter list
			 */
			String tokenValue = request.getHeader("token");

			Token token = (Token) Constant.map.get(tokenValue);

			if (methodName.equals("oauthToken")) {
				try {/**
						 * to get parameters in Array
						 */
					String[] args = inputarg.toString().split(",");
					finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (methodName.equals("oauthMobileToken")) {
				try {/**
						 * to get parameters in Array
						 */
					String[] args = inputarg.toString().split(",");
					finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
				} catch (Exception e) {
					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken") && classType.equals("java.util.LinkedHashMap")) {
				/**
				 * To get the Parameters which is Passed to call the API
				 */
				try {
					System.out.println("argsParamMap :-" + argsParam);
					if (argsParam != null) {/**
											 * To get check token Value
											 */

						if (tokenValue != null) {/**
													 * To get Token Value
													 */

							if (token != null) {/**
												 * Too get user_key and user_id
												 * from token
												 */
								user_key = token.getUserKey().toString();
								user_id = token.getUser_id().toString();

								System.out.println("user_key" + user_key + "user_id" + user_id);
							}
						}
						for (String key : argsParam.keySet()) {
							/**
							 * To get rest of the parameter passed in calling
							 * respective API
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
			genericService.executeProcesure(null, proParam.get("5").toString(), controllerName.toString(),
					finalInputArg.toString(), request.getRemoteHost(), URI, "", user_key, user_id,
					"08d31e35-ac87-11e6-b009-fe984cc15272", "api");

		} catch (Exception e) {/**
								 * To catch the exception if any
								 */
			e.printStackTrace();

		}

	}

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corresponding
	 * procedure.This method uses the concept of AOP,Aspect Object Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.*.*(..))", returning = "result")
	public void logAfterThrowingException(JoinPoint joinPoint, Object result) {

		try {

			// Initializing the variables
			String classType = null;
			StringBuilder InputArguments = new StringBuilder();
			String user_key = null;
			String user_id = null;
			Map<String, Object> argsParamMap = null;
			StringBuilder input = new StringBuilder();

			// Initializing the message class and get the results obtained after
			// method execution.
			Message message = (Message) result;

			// If message is not valid
			if (!message.isValid()) {
				String tokenValue = request.getHeader("token");

				Token token = (Token) Constant.map.get(tokenValue);
				System.out.println("token" + token.toString());
				// Initializing the map
				Map<String, Object> errorLogMap = processParameter.getMaps();
				// System.out.println("Error Log Map is :- " + errorLogMap);

				// For loop is used to get the arguments for the methods which
				// will give exception
				for (Object arguments : joinPoint.getArgs()) {

					// Get the class type
					classType = arguments.getClass().getName();

					// If class type is java.util.LinkedHashMap,then append it
					// in argsParamMap
					if (classType.equals("java.util.LinkedHashMap")) {
						argsParamMap = (Map<String, Object>) arguments;
						continue;
					}
					// System.out.println("args param map is :- " +
					// argsParamMap);
					// Append in stringBuilder input
					input.append(arguments + ",");
				}

				// Check the last index of String Builder
				if (input.lastIndexOf(",") > 0) {
					input.deleteCharAt(input.lastIndexOf(","));
					// System.out.println("input Parameter List:- " + input + "
					// / class type:- " + classType);
				}

				// System.out.println("input Parameter List:- " + argsParamMap +
				// " / class type:- " + classType);

				String name = joinPoint.getThis().getClass().getName();

				// Get the controller names
				String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

				// Get the method names
				String methodName = joinPoint.getSignature().getName();
				// System.out.println("Method name is :- " + methodName);

				// Check the method name equals oauthToken

				if (methodName.equals("oauthToken")) {
					try {/**
							 * to get parameters in Array
							 */
						String[] args = input.toString().split(",");
						InputArguments.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (methodName.equals("oauthMobileToken")) {
					try {/**
							 * to get parameters in Array
							 */
						String[] args = input.toString().split(",");
						InputArguments.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else if (!methodName.equals("oauthToken") && classType.equals("java.util.LinkedHashMap")) {
					/**
					 * To get the Parameters which is Passed to call the API
					 */
					try {
						System.out.println("argsParamMap :-" + argsParamMap);
						if (argsParamMap != null) {/**
													 * To get check token Value
													 */

							if (tokenValue != null) {/**
														 * To get Token Value
														 */

								if (token != null) {/**
													 * Too get user_key and
													 * user_id from token
													 */
									user_key = token.getUserKey().toString();
									user_id = token.getUser_id().toString();

									System.out.println("user_key" + user_key + "user_id" + user_id);
								}
							}
							for (String key : argsParamMap.keySet()) {
								/**
								 * To get rest of the parameter passed in
								 * calling respective API
								 */
								InputArguments.append(key + " = " + argsParamMap.get(key) + " ,");
							}
							if (InputArguments
									.length() > 0) {/**
													 * If size is more than than
													 * remove last , from the
													 * string
													 */
								InputArguments.deleteCharAt(InputArguments.lastIndexOf(","));
							}
						}
					} catch (Exception e) { /**
											 * To catch the Exception
											 */
						e.printStackTrace();
					}

				}

				System.out.println("ControllerName:- " + controllerName);
				System.out.println("Method Name:- " + methodName);
				System.out.println("Input Arguments are :- " + InputArguments);
				System.out.println("User Key is- " + user_key);
				String URIPatter = request.getRequestURI().substring(1);
				String URI = URIPatter.substring(URIPatter.indexOf("/"));
				System.out.println("Remote Address:- " + request.getRemoteHost());
				System.out.println("Remote Address:- " + URI);

				// Calling of this procedure to insert errors/exceptions in
				// table
				genericService.executeProcesure(null, errorLogMap.get("73").toString(), URI, InputArguments.toString(),
						request.getRemoteHost(), message.getDescription(), user_id, user_key,
						"08d31e35-ac87-11e6-b009-fe984cc15272");

			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
