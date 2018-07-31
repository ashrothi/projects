package org.goup.constant;

import java.lang.reflect.Method;

public class Constant {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object executeMethods(String className, String methodName, Class[] paramType, Object[] paramValue)
			throws Exception {

		Class clz = Class.forName(className);

		Object obj = clz.newInstance();

		Method method = clz.getMethod(methodName, paramType);

		Object resultObject = method.invoke(obj, paramValue);

		return resultObject;
	}

}
