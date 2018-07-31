/**
 * This package contain the Service class for All Third Party Application for Flint
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import com.springiot.constant.ProcessParameter;
import com.springiot.constant.URLParameter;
import com.springiot.genericService.GenericService;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.notification.NotificationByFcm;
import com.springiot.response.GenericMessages;
import com.springiot.response.Message;
import com.springiot.response.Token;

/**
 * 
 * This class work as a Service class for Application where all the manipulation
 * and business logic is applied according to the requirement and send in
 * requested format Integration
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@SuppressWarnings({ "unchecked", "serial", "unused" })
public class ThirdPartyServices {

	/*
	 * Autowired is used to inject the object dependency implicitly.It's a specific
	 * functionality of spring which requires less code.
	 */
	@Autowired
	private HttpURLCalling urlCalling;

	@Autowired
	private URLParameter urlParameter;

	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	private Object convertDateInEpoch(String replace) throws ParseException {

		DateFormat dF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // The mask
		Date date = dF.parse(replace); // parsing the String into a Date using
										// the mask

		return date.getTime();
	}

}