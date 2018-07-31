/**
 * This package is used for logging purposes like error and audit logging.
 */
package com.springiot.logging;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;

/**
 * This class is used specifically for the Logging purposes. The audit logs are
 * generated after any any api being called and error logs are generated while
 * any exception occurs while calling api.
 * 
 * @author tanvigarg
 *
 */
@Aspect
public class AOPLogging {

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	@Autowired(required = true)
	private HttpServletRequest request;

	/**
	 * This method is used for Audit Logging whenever any api is being called,it
	 * will display audit logs as well as insert the audit logs in the
	 * Corresponding procedure.This method uses the concept of AOP,Aspect Object
	 * Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	@After("execution(* com.springiot.controllers.*.*(..))")
	public void logAfterMappingHandler(JoinPoint joinPoint) {

		// TokenSPResponse token = (TokenSPResponse)
		// Constant.map.get(argsParam.get("token").toString());

		try {
			// Initializing the variables
			Map<String, Object> proParam = processParameter.getMaps();
			String classType = null;
			StringBuilder finalInputArg = new StringBuilder();
			String user_key = "";
			Map<String, Object> argsParam = null;

			StringBuilder inputarg = new StringBuilder();

			// For loop is used to get the arguments for the methods which
			// will be exceuted
			for (Object obj : joinPoint.getArgs()) {

				if (obj != null) {

					// Get the class type
					classType = obj.getClass().getName();

					// If class type is java.util.LinkedHashMap,then append it
					// in argsParamMap
					if (classType.equals("java.util.LinkedHashMap")) {
						argsParam = (Map<String, Object>) obj;

						continue;
					}
					// Append in stringBuilder inputarg
					inputarg.append(obj + ",");
				}

				// Check the last index of String Builder
				if (inputarg.lastIndexOf(",") > 0) {
					inputarg.deleteCharAt(inputarg.lastIndexOf(","));

				}
			}
			String name = joinPoint.getThis().getClass().getName();

			String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

			String methodName = joinPoint.getSignature().getName();

			// Check the method name equals oauthToken
			if (methodName.equals("oauthToken")) {
				try {
					// The input params are splited by comma and stored in
					// Array
					String[] args = inputarg.toString().split(",");

					finalInputArg.append("user_name=" + args[2] + ", password=*****, application_id=" + args[4]);
				}
				// Handling all exceptions
				catch (Exception e) {

					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken")) {

				try {

					if (argsParam != null) {
						if (argsParam.get("token") != null) {

							String tokenValue = argsParam.get("token").toString();
							// String hsqlQuery = "select user_key from
							// TokenStorage.auth_token where access_token='"
							// + tokenValue + "';";
							//
							// // System.out.println("!!!!" + hsqlQuery);
							//
							// List<Map<String, Object>> getToken =
							// (List<Map<String, Object>>) genericService
							// .executeHSqlSelectQuery(hsqlQuery);

							if (request.getHeader("user_key") != null) {
								user_key = String.valueOf(request.getHeader("user_key"));
							} else {
								user_key = String.valueOf(request.getAttribute("user_key"));
							}
							// if (tokenValue != null) {
							// user_key =
							// getToken.get(0).get("USER_KEY").toString();
							// }

						}
						// Append the parameters to String Builder required
						// for calling of Procedure
						for (String key : argsParam.keySet()) {
							finalInputArg.append(key + " = " + argsParam.get(key) + " ,");
						}
						// Append the parameters to String Builder required
						// for calling of Procedure
						if (finalInputArg.length() > 0) {
							finalInputArg.deleteCharAt(finalInputArg.lastIndexOf(","));
						}
					}

				}
				// Handling all exceptions
				catch (Exception e) {

					e.printStackTrace();
				}

			}

			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));

			// System.out.println(request.getLocalAddr());
			// System.out.println("Remote Address:- " +
			// request.getRemoteHost());
			// System.out.println("Remote Address:- " + URI);

			genericService.executeProcesure(null, proParam.get("50").toString(), controllerName.toString(),
					finalInputArg.toString(), request.getRemoteHost(), URI, 0, request.getHeader("user_key"),
					"19ab64ac-588e-11e6-85b9-fe984cc15272", "api");

		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corrosponding
	 * procedure.This method uses the concept of AOP,Aspect Obbject Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.*.*(..))", returning = "result")
	public void logAfterThrowingException(JoinPoint joinPoint, Object result) {
		// System.out.println("Error Logging ");

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

				// Initializing the map
				Map<String, Object> errorLogMap = processParameter.getMaps();

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

					// Append in stringBuilder input
					input.append(arguments + ",");
				}

				// Check the last index of String Builder
				if (input.lastIndexOf(",") > 0) {
					input.deleteCharAt(input.lastIndexOf(","));

				}

				String name = joinPoint.getThis().getClass().getName();

				// Get the controller names
				String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

				// Get the method names
				String methodName = joinPoint.getSignature().getName();

				// Check the method name equals oauthToken
				if (methodName.equals("oauthToken")) {
					try {

						// The input params are spllited by comma and stored in
						// Array
						String[] args = input.toString().split(",");
						// Append to the String Builder
						InputArguments.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);

					}
					// Handling all exceptions
					catch (Exception e) {

						e.printStackTrace();
					}

				} else if (!methodName.equals("oauthToken")) {

					try {
						// Check if argsParamMap is not null
						if (argsParamMap != null) {
							// Check token is not null
							if (argsParamMap.get("token") != null) {
								String tokenValue = argsParamMap.get("token").toString();
								// String hsqlQuery = "select user_key from
								// TokenStorage.auth_token where access_token='"
								// + tokenValue + "';";
								//
								// // System.out.println("!!!!" + hsqlQuery);
								// //
								// List<Map<String, Object>> getToken =
								// (List<Map<String, Object>>) genericService
								// .executeHSqlSelectQuery(hsqlQuery);
								// // System.out.println("tokenPersistent" +
								// // getToken.get(0));
								//
								// // Append the parameters to String Builder
								// // required
								// // for calling of Procedure
								//
								// if (tokenValue != null) {
								// user_key =
								// getToken.get(0).get("USER_KEY").toString();
								// }

								if (request.getHeader("user_key") != null) {
									user_key = String.valueOf(request.getHeader("user_key"));
								} else {
									user_key = String.valueOf(request.getAttribute("user_key"));
								}
							}

							// Append the parameters to String Builder required
							// for calling of Procedure
							for (String key : argsParamMap.keySet()) {
								InputArguments.append(key + " = " + argsParamMap.get(key) + " ,");
							}

							if (InputArguments.length() > 0) {
								InputArguments.deleteCharAt(InputArguments.lastIndexOf(","));
							}
						}
					}
					// Handling all exceptions
					catch (Exception e) {

						e.printStackTrace();
					}
				}

				String URIPatter = request.getRequestURI().substring(1);

				String URI = URIPatter.substring(URIPatter.indexOf("/"));
				//
				// System.out.println(request.getLocalAddr());
				// System.out.println("Remote Address:- " +
				// request.getRemoteHost());
				// System.out.println("Remote Address:- " + URI);

				// Calling of this procedure to insert errors/exceptions in
				// table
				genericService.executeProcesure(null, errorLogMap.get("51").toString(), URI, InputArguments.toString(),
						request.getRemoteHost(), message.getDescription(), request.getHeader("user_id"),
						request.getHeader("user_key"), "19ab64ac-588e-11e6-85b9-fe984cc15272");
			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used for Error Logging whenever any exception occurs,it
	 * will display errors as well as insert the errors in the corresponding
	 * procedure.This method uses the concept of AOP,Aspect Object
	 * Programming.This method is used for the package
	 * com.springiot.controllers.ignoreControllers because all the classes in
	 * this package are not considered as controllers.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param result,
	 *            this is the result obtained after any method execution.
	 * 
	 * @author tanvigarg
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.ignoreControllers.*.*(..))", returning = "result")
	public void logAfterThrowingError(JoinPoint joinPoint, Object result) {
		// System.out.println("Ignore Controllers");

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

					// Append in stringBuilder input
					input.append(arguments + ",");
				}

				// Check the last index of String Builder
				if (input.lastIndexOf(",") > 0) {
					input.deleteCharAt(input.lastIndexOf(","));

				}

				String name = joinPoint.getThis().getClass().getName();

				// Get the controller names
				String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

				// Get the method names
				String methodName = joinPoint.getSignature().getName();

				// Check the method name equals oauthToken
				if (methodName.equals("oauthToken")) {
					try {

						// The input params are spllited by comma and stored in
						// Array
						String[] args = input.toString().split(",");
						// Append to the String Builder
						InputArguments.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);

					}
					// Handling all exceptions
					catch (Exception e) {

						e.printStackTrace();
					}

				} else if (!methodName.equals("oauthToken") && classType.equals("java.util.LinkedHashMap")) {

					try {
						// Check if argsParamMap is not null
						if (argsParamMap != null) {
							// Check token is not null
							if (argsParamMap.get("token") != null) {
								String tokenValue = argsParamMap.get("token").toString();
								// String hsqlQuery = "select user_key from
								// TokenStorage.auth_token where access_token='"
								// + tokenValue + "';";
								//
								// // System.out.println("!!!!" + hsqlQuery);
								//
								// List<Map<String, Object>> getToken =
								// (List<Map<String, Object>>) genericService
								// .executeHSqlSelectQuery(hsqlQuery);
								// // System.out.println("tokenPersistent" +
								// // getToken.get(0));
								//
								// // Append the parameters to String Builder
								// // required
								// // for calling of Procedure
								//
								// if (tokenValue != null) {
								// user_key =
								// getToken.get(0).get("USER_KEY").toString();
								// }
								//

								if (request.getHeader("user_key") != null) {
									user_key = String.valueOf(request.getHeader("user_key"));
								} else {
									user_key = String.valueOf(request.getAttribute("user_key"));
								}
							}

							// Append the parameters to String Builder required
							// for calling of Procedure
							for (String key : argsParamMap.keySet()) {
								InputArguments.append(key + " = " + argsParamMap.get(key) + " ,");
							}

							if (InputArguments.length() > 0) {
								InputArguments.deleteCharAt(InputArguments.lastIndexOf(","));
							}
						}
					}
					// Handling all exceptions
					catch (Exception e) {

						e.printStackTrace();
					}
				}

				String URIPatter = request.getRequestURI().substring(1);

				String URI = URIPatter.substring(URIPatter.indexOf("/"));

				// System.out.println(request.getLocalAddr());
				// System.out.println("Remote Address:- " +
				// request.getRemoteHost());
				// System.out.println("Remote Address:- " + URI);

				// Calling of this procedure to insert errors/exceptions in
				// table
				genericService.executeProcesure(null, errorLogMap.get("51").toString(), URI, InputArguments.toString(),
						request.getRemoteHost(), message.getDescription(), request.getHeader("user_id"),
						request.getHeader("user_key"), "19ab64ac-588e-11e6-85b9-fe984cc15272");

			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
