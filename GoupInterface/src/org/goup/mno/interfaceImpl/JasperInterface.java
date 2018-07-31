package org.goup.mno.interfaceImpl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class JasperInterface {
	
	public ResponseEntity<?> getSimDetails(Map<String, String> paramMap, String country_code, String operator,
			HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<>("{'MNO':'"+operator+"','Country':'"+country_code+"'}",HttpStatus.ACCEPTED) ;
	}

}
