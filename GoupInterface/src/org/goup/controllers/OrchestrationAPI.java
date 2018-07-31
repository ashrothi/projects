/**
 * This Package contains controllers of Third Party Orchestration API.
 */
package org.goup.controllers;

import org.goup.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrchestrationAPI {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private ThirdPartyService thirdPartyService;

	

}
