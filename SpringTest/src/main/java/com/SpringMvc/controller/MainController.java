package com.SpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SpringMvc.domain.Message;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld(ModelMap modelMap) {

		modelMap.addAttribute("message", "Hello index page!");

		return "index";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String test(ModelMap modelMap) {

		modelMap.addAttribute("message", "Hello Spring MVC Framework!");

		return "dashboard";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String test() {

		return "asasdasdasd";
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public @ResponseBody Message demo() {

		Message message = new Message();
		message.setDescription("SADASDASDASDASD");
		message.setValid(true);

		return message;
	}

}
