package com.springiot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.TestSDKService;

@Controller
public class TestSDKController {

	@Autowired
	private TestSDKService testSDKService;

	@RequestMapping(value = "/demographic/data", method = RequestMethod.POST)

	public @ResponseBody Message usersGetApiAccess(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam String nccs, @RequestParam String ageGroup, @RequestParam Boolean male,
			@RequestParam Boolean female, @RequestParam Boolean isAllIndia, @RequestParam String megaCities,
			@RequestParam String tenTo75Lac, @RequestParam String urban, @RequestParam String rural,
			@RequestParam String email, @RequestParam String vendorId) throws Exception {

		Message message = testSDKService.testService(startDate, endDate, nccs, ageGroup, male, female, isAllIndia,
				megaCities, tenTo75Lac, urban, rural, email, vendorId);

		return message;

	}

}
