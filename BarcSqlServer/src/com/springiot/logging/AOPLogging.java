package com.springiot.logging;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import com.springiot.constant.Constant;
import com.springiot.constant.ProcessParameter;
import com.springiot.genericService.GenericService;
import com.springiot.response.Message;
import com.springiot.response.TokenSPResponse;

@Aspect
public class AOPLogging {

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	@Autowired(required = true)
	private HttpServletRequest request;

	@After("execution(* com.springiot.controllers.*.*(..))")
	public void logAfterMappingHandler(JoinPoint joinPoint) {

		try {

			Map<String, Object> proParam = processParameter.getMaps();

			String classType = null;

			StringBuilder finalInputArg = new StringBuilder();

			String userKey = null;

			Map<String, Object> argsParam = null;

			StringBuilder inputarg = new StringBuilder();

			for (Object obj : joinPoint.getArgs()) {

				classType = obj.getClass().getName();

				if (classType.equals("java.util.LinkedHashMap")) {
					argsParam = (Map<String, Object>) obj;

					continue;
				}

				inputarg.append(obj + ",");

			}

			if (inputarg.lastIndexOf(",") > 0) {
				inputarg.deleteCharAt(inputarg.lastIndexOf(","));
				System.out.println("input Parameter List:- " + inputarg + " / class type:- " + classType);
			}

			System.out.println("input Parameter List:- " + argsParam + " / class type:- " + classType);

			String name = joinPoint.getThis().getClass().getName();

			String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

			String methodName = joinPoint.getSignature().getName();

			if (methodName.equals("oauthToken")) {
				try {

					String[] args = inputarg.toString().split(",");

					finalInputArg.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			} else if (!methodName.equals("oauthToken") && classType.equals("java.util.LinkedHashMap")) {

				try {

					if (argsParam != null) {
						if (argsParam.get("token") != null) {
							TokenSPResponse token = (TokenSPResponse) Constant.map
									.get(argsParam.get("token").toString());

							if (token != null) {
								userKey = token.getUser_key().toString();
							}

						}

						for (String key : argsParam.keySet()) {
							finalInputArg.append(key + " = " + argsParam.get(key) + " ,");
						}

						if (finalInputArg.length() > 0) {
							finalInputArg.deleteCharAt(finalInputArg.lastIndexOf(","));
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}

			}

			System.out.println("ControllerName:- " + controllerName);

			System.out.println("Method Name:- " + methodName);

			System.out.println("Method Name:- " + finalInputArg);

			System.out.println("Method Name:- " + userKey);

			String URIPatter = request.getRequestURI().substring(1);

			String URI = URIPatter.substring(URIPatter.indexOf("/"));

			System.out.println(request.getLocalAddr());
			System.out.println("Remote Address:- " + request.getRemoteHost());
			System.out.println("Remote Address:- " + URI);

			System.out.println("================================================");

			genericService.executeProcesure(null, proParam.get("50").toString(), controllerName.toString(),
					finalInputArg.toString(), request.getRemoteHost(), URI, "", userKey,
					"19ab64ac-588e-11e6-85b9-fe984cc15272", "api");

		} catch (Exception e) {
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
	@SuppressWarnings("unchecked")
	@AfterReturning(pointcut = "execution(* com.springiot.controllers.*.*(..))", returning = "result")
	public void logAfterThrowingException(JoinPoint joinPoint, Object result) {
		System.out.println("Error Logging ");

		try {

			// Initializing the variables
			String classType = null;
			StringBuilder InputArguments = new StringBuilder();
			String userKey = null;
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
				System.out.println("Error Log Map is :- " + errorLogMap);

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
					System.out.println("input Parameter List:- " + input + " / class type:- " + classType);
				}

				System.out.println("input Parameter List:- " + argsParamMap + " / class type:- " + classType);

				// Get the name of
				String name = joinPoint.getThis().getClass().getName();

				String controllerName = name.substring(name.lastIndexOf(".") + 1, name.indexOf("$$"));

				String methodName = joinPoint.getSignature().getName();

				if (methodName.equals("oauthToken")) {
					try {

						String[] args = input.toString().split(",");

						InputArguments.append("username=" + args[2] + ", password=*****, applicationid=" + args[4]);

					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}

				} else if (!methodName.equals("oauthToken") && classType.equals("java.util.LinkedHashMap")) {

					try {

						if (argsParamMap != null) {
							if (argsParamMap.get("token") != null) {
								TokenSPResponse token = (TokenSPResponse) Constant.map
										.get(argsParamMap.get("token").toString());

								if (token != null) {
									userKey = token.getUser_key().toString();
									user_id = token.getUser_id().toString();
								}

							}

							for (String key : argsParamMap.keySet()) {
								InputArguments.append(key + " = " + argsParamMap.get(key) + " ,");
							}

							if (InputArguments.length() > 0) {
								InputArguments.deleteCharAt(InputArguments.lastIndexOf(","));
							}
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
						e.printStackTrace();
					}

				}

				System.out.println("ControllerName:- " + controllerName);

				System.out.println("Method Name:- " + methodName);

				System.out.println("Input Arguments are :- " + InputArguments);

				System.out.println("Method Name:- " + userKey);

				String URIPatter = request.getRequestURI().substring(1);

				String URI = URIPatter.substring(URIPatter.indexOf("/"));

				System.out.println(request.getLocalAddr());
				System.out.println("Remote Address:- " + request.getRemoteHost());
				System.out.println("Remote Address:- " + URI);

				genericService.executeProcesure(null, errorLogMap.get("51").toString(), URI, InputArguments.toString(),
						request.getRemoteHost(), message.getDescription(), user_id, userKey,
						"19ab64ac-588e-11e6-85b9-fe984cc15272");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
