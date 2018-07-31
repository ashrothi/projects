package org.goup.services;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.goup.constant.Constant;
import org.goup.constant.OperatorInterfaceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("rawtypes")
public class GoupB2BService {
	
	@Autowired
	private OperatorInterfaceInfo operatorInterfaceInfo;

	public ResponseEntity<?> getSimDetails(Map<String, String> parameterMap,
			HttpServletRequest request, HttpServletResponse response) {
		
		String country_code=request.getHeader("country_code");
		String operator=request.getHeader("operator");
		
		String className=(String) operatorInterfaceInfo.getMaps().get("/"+operator);
		
		if(className==null)
		{
			return new ResponseEntity<>("Not Found Any Mapping.",HttpStatus.EXPECTATION_FAILED);
		}
		
		Class paramType[]= {Map.class,String.class,String.class,HttpServletRequest.class,HttpServletResponse.class};
		Object paramValue[]= {parameterMap,country_code,operator,request,response};
		
		try {
			Object object=Constant.executeMethods(className, "getSimDetails", paramType, paramValue);
			
			if(object!=null)
			{
				return (ResponseEntity<?>) object;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

}
