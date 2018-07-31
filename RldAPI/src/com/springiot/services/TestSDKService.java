package com.springiot.services;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import com.springiot.constant.*;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.rld.apicalling.RLD;
import com.rld.main.SDKExecution;
import com.springiot.response.Message;

@Service
public class TestSDKService {

	public Message testService(String startDate, String endDate, String nccs, String ageGroup, Boolean male,
			Boolean female, Boolean isAllIndia, String megaCities, String tenTo75Lac, String urban, String rural,
			String email, String vendorId) throws Exception {

		Message message = new Message();

		try {

			SDKExecution execution = new SDKExecution();

			Object object = execution.pushDemographicData(startDate, endDate, nccs, ageGroup, male, female, isAllIndia,
					megaCities, tenTo75Lac, urban, rural, email, vendorId);

			System.out.println("object" + object);

			if (object.toString().contains("[{")) {
				Object response = RLD.GetDemographicData(email, vendorId);

				Type listTypeJson = new TypeToken<List<HashMap<String, Object>>>() {
				}.getType();
				List<HashMap<String, Object>> list = new Gson().fromJson(response.toString(), listTypeJson);

				System.out.println(response.toString().length());

				System.out.println(response.toString().substring(0, 100));

				// List<Response> list = (List<Response>) response;
				// System.out.println(list);

				message.setDescription("Process success");
				message.setObject(list);
				message.setValid(true);

			} else {
				message.setDescription("Process Fail");
				message.setObject(object);
				message.setValid(false);

			}
		} catch (Exception exception) {
			exception.printStackTrace();

			message.setDescription(exception.getMessage());
			message.setValid(false);
		}
		return message;

	}
}
