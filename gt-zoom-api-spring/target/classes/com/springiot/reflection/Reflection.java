package com.springiot.reflection;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Reflection {
	
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		
		Reflection reflection=new Reflection();
		
		Object obj=reflection.getData(Reflection.class, "getObject","World",1);
		
		System.out.println(obj.toString());
		
	}
	
	
	public Object  getData(Class clz,String MethodName,Object... param)
	{
		try {
			
			Class args[]=new Class[param.length];
			
			for (int i = 0; i < args.length; i++) {
				args[i]=param[i].getClass();
			}
			
			//Object obj=clz.newInstance();
			
			Object obj=applicationContext.getBean(clz);
			
			
			
			Method method=clz.getDeclaredMethod(MethodName,args);
			Object outputObject=method.invoke(obj,param);
			
			
			System.out.println("outputObject:- "+outputObject);
			
			return outputObject;
			
			
			
		} catch (Exception e) {
			
			System.out.println("Error Message;- "+e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getObject(String value,Integer i)
	{
		return "getData Object:-"+value+"--"+i;
	}

}
