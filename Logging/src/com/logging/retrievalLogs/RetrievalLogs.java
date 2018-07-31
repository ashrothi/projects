/*
 * this package is used for the retrieval of logs.
 */
package com.logging.retrievalLogs;

import static com.logging.reflection.apis.ReflectionAPIs.executeReflection;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is require for the retrieval of logs with limit,count and all
 * logs.This class has also used the concept of reflection
 * 
 * @author tanvigarg
 *
 */
public class RetrievalLogs {

	/*
	 * This is generic method for the logs retrieval. 
	 */
	public Object GenericProcedureForLogs(String requestType, Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response, Object genericService, String methodNameReflection, Class... classes)
			throws Exception {

		Method method = executeReflection(genericService, methodNameReflection, classes);

		Object object = method.invoke(genericService, requestType, map, request, response);

		return object;

	}
}
