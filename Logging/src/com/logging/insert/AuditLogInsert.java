/**
 * This package is specifically meant for insertion of audit and error logs
 */
package com.logging.insert;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.hibernate.SessionFactory;

import static com.logging.reflection.apis.ReflectionAPIs.executeReflection;

/**
 * This class helps in insertion of audit log and uses the concept of AOP(Aspect
 * Object Programming).
 * 
 * @author tanvigarg
 *
 */
public class AuditLogInsert {

	/**
	 * 
	 * This method is used for Audit Logging whenever any api is being called,it
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

	@SuppressWarnings("unchecked")
	public void insertAuditLog(JoinPoint joinPoint, HttpServletRequest request, SessionFactory sessionFactory,
			String procedureName, String applicationKey, Integer organizationId, Object genericService,
			String methodNameReflection, Class... classes) {

		try {
			// Initializing the variables
			String classType = null;
			StringBuilder finalInputArg = new StringBuilder();

			String userKey = null;
			String user_id = null;

			Map<String, Object> argsParam = null;

			StringBuilder inputarg = new StringBuilder();

			// For loop is used to get the arguments for the methods which
			// will be exceuted
			for (Object obj : joinPoint.getArgs()) {

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

				String name = joinPoint.getThis().getClass().getName();

				String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

				String methodName = joinPoint.getSignature().getName();

				// Check the method name equals oauthToken
				if (methodName.equals("oauthToken")) {
					try {
						// The input params are spllited by comma and stored in
						// Array
						String[] args = inputarg.toString().split(",");

						finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);

					}
					// Handling all exceptions
					catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}

				}

				else if (!methodName.equals("oauthToken")) {

					try {
						if (argsParam != null) {
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
						System.out.println(e.getMessage());
						e.printStackTrace();
					}
				}

				String URIPatter = request.getRequestURI().substring(1);

				String URI = URIPatter.substring(URIPatter.indexOf("/"));

				userKey = request.getHeader("user_key");
				user_id = request.getHeader("user_id");

				if (request.getHeader("user_key") == null) {
					userKey = "";
					user_id = "";
				}

				System.out.println("userkey and user id in logging" + userKey + "user id" + user_id + "organizationId"
						+ organizationId);

				System.out.println(request.getLocalAddr());
				System.out.println("Remote Address:- " + request.getRemoteHost());
				System.out.println("Remote Address:- " + URI);

				Object[] obj = { controllerName.toString(), finalInputArg.toString(), request.getRemoteHost(), URI,
						userKey, user_id, applicationKey, organizationId };

				Method method = executeReflection(genericService, methodNameReflection, classes);

				method.invoke(genericService, null, procedureName, obj);

			}
		}
		// Handling all exceptions
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
