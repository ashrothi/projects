/**
 * This package is specifically meant for insertion of audit and error logs
 */
package com.logging.insert;

import static com.logging.reflection.apis.ReflectionAPIs.executeReflection;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.hibernate.SessionFactory;

/**
 * This class helps in insertion of error log and uses the concept of AOP(Aspect
 * Object Programming).
 * 
 * @author tanvigarg
 *
 */
public class ErrorLogInsert {

	/**
	 * 
	 * This method is used for Error Logging whenever any api is being called,it
	 * will display audit logs as well as insert the audit logs in the
	 * Corresponding procedure.This method uses the concept of AOP,Aspect Object
	 * Programming.
	 * 
	 * @param joinPoint,this
	 *            point could be a method being called, an exception being
	 *            thrown, or even a field being modified
	 * @param request,
	 *            this is the http servlet request.
	 * 
	 * @param sessionFactory,
	 *            this is used to maintain session.
	 *
	 * @param procedureName,
	 *            this is used for the procedure name.
	 * 
	 * @param applicationKey,this
	 *            is specific to application in which logs are being genertaed
	 * @param methodNameReflection,this
	 *            is used in which reflection is required
	 * @author tanvigarg
	 */
	public void errorLogInsertion(JoinPoint joinPoint, Object result, HttpServletRequest request,
			SessionFactory sessionFactory, String procedureName, String applicationKey, Integer organizationId,
			Object genericService, String methodNameReflection, String messageDesciption, Class... classes) {
		try {

			// Initializing the variables
			String classType = null;
			StringBuilder InputArguments = new StringBuilder();
			String userKey = null;
			String user_id = null;
			Map<String, Object> argsParamMap = null;
			StringBuilder input = new StringBuilder();

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
				System.out.println("args param map is :- " + argsParamMap);
				// Append in stringBuilder input
				input.append(arguments + ",");
			}

			// Check the last index of String Builder
			if (input.lastIndexOf(",") > 0) {
				input.deleteCharAt(input.lastIndexOf(","));
				System.out.println("input Parameter List:- " + input + " / class type:- " + classType);
			}

			System.out.println("input Parameter List:- " + argsParamMap + " / class type:- " + classType);

			String name = joinPoint.getThis().getClass().getName();

			// Get the controller names
			String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

			// Get the method names
			String methodName = joinPoint.getSignature().getName();
			System.out.println("Method name is :- " + methodName);

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
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken")) {

				try {
					// Check if argsParamMap is not null
					if (argsParamMap != null) {

						// Append the paramters to String Builder required
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
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}

			userKey = request.getHeader("user_key");
			user_id = request.getHeader("user_id");

			if (request.getHeader("user_key") == null) {
				userKey = "";
				user_id = "";
			}

			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));

			System.out.println(request.getLocalAddr());
			System.out.println("Remote Address:- " + request.getRemoteHost());
			System.out.println("Remote Address:- " + URI);

			// Calling of this procedure to insert errors/exceptions in
			// table
			System.out.println("userkey and user id in logging" + userKey + "user id" + user_id + "organizationId"
					+ organizationId);
			Object[] obj = { URI, InputArguments.toString(), request.getRemoteHost(), messageDesciption, user_id,
					userKey, applicationKey, organizationId };

			for (int i = 0; i < obj.length; i++) {
				System.out.println("obj[i] " + obj[i]);
			}

			Method method = executeReflection(genericService, methodNameReflection, classes);

			method.invoke(genericService, null, procedureName, obj);

		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
