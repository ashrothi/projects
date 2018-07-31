/**
 * This package is used for the concept of reflection API's
 */
package com.logging.reflection.apis;

import java.lang.reflect.Method;

/*
 * This class is a generic class which will be required for the insertion as well as the retrieval of audit and error logs
 */
public class ReflectionAPIs {

	/**
	 * This method involves the concept of reflection
	 * 
	 * @param obj,this
	 *            is the class's object
	 * 
	 * @param methodName,
	 *            the method name which needs reflection
	 * 
	 * @param parameterType
	 * @return
	 * @throws Exception
	 */
	public static Method executeReflection(Object obj, String methodName, Class<?>... parameterType) throws Exception {
		try {

			Method method = obj.getClass().getMethod(methodName, parameterType);

			return method;
		}
		// Handling all exceptions
		catch (Exception e) {
			throw e;
		}
	}
}
