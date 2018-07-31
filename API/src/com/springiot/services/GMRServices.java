/**
 * This package contain the Services class for GMR APIs.
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.constant.URLParameter;
import com.springiot.http.client.HttpURLCalling;
import com.springiot.response.Message;

/**
 * GMRServices class do all the operations related to call GMR APIs.
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class GMRServices {
	/*
	 * Autowired is used to inject the object dependency implicitly.It's a
	 * specific functionality of spring which requires less code.
	 */
	@Autowired
	private GenericServices genericServices;
	@Autowired
	private GenericProcess genericProcess;

	@SuppressWarnings("unchecked")
	public Message getAllVehicles(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		Message responseMessage = new Message();
		try {
			/**
			 * To Call Platform to get all Vehicles
			 */
			map.put("device_type", "0");
			map.put("host_status", "0");
			map.put("limit", "100");
			map.put("offset", "0");
			map.put("in_condition", "");
			/**
			 * To get response from Platform
			 */
			Message message = genericServices.getMetadataStatusByTypeLimit(map, request, response);
			/**
			 * To get vehicle from ThirdParty DB
			 */
			if (message.isValid()) {
				List<Map<String, Object>> getVehicle = (List<Map<String, Object>>) message.getObject();
				Message getAllVehicle = genericProcess.GenericProcedureCalling("23", map, null, request, response);
				if (getAllVehicle.isValid()) {
					List<Map<String, Object>> getThirPartyVehicle = (List<Map<String, Object>>) message.getObject();
					for (Map<String, Object> getVehiclemap : getVehicle) {

						for (Map<String, Object> getThirPartyVehiclemap : getThirPartyVehicle) {
							if (String.valueOf(getThirPartyVehiclemap.get("registration_number"))
									.equalsIgnoreCase(String.valueOf(getVehiclemap.get("device_device_alias")))) {
								getVehiclemap.putAll(getThirPartyVehiclemap);

							} else {
								getVehiclemap.put("is_vehicle_realesed", 1);
							}
						}

					}
					if (getVehicle.size() > 0) {
						responseMessage.setDescription("Process Success");
						responseMessage.setObject(getVehicle);
						responseMessage.setValid(true);
					} else {
						responseMessage.setDescription("No Data Availabe");
						responseMessage.setValid(false);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			responseMessage.setDescription("Process Fail " + e.getMessage());
			responseMessage.setValid(false);

		}
		return responseMessage;
	}
}
