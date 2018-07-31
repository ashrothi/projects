/**
 * This package contain the Service class for Third Party Services Service to get all API with some manipulation and logic applied on api according to the user
 */
package com.springiot.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

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
public class OrganizationService {
	@Autowired
	private GenericProcess genericProcess;

	public Message accessInsert(Map<String, String> map, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Message message = new Message();
		try {
			String[] masterQuesArray = map.get("master_ques_var_name").toString().split("\\#\\$\\#");
			String[] masterAnsArray = map.get("master_ans_var_name").toString().split("\\#\\$\\#");

			System.out.println("masterQuesArray ");
			map.remove("master_ques_var_name");
			map.remove("master_ans_var_name");
			System.out.println(masterAnsArray.length);
			Message deleteMessage = genericProcess.GenericProcedureCalling("30", map, null, request,
					response);
			for (int i = 0; i < masterAnsArray.length; i++) {

				System.out
						.println("masterQuesArray- " + masterQuesArray[i] + " \n masterAnsArray-" + masterAnsArray[i]);
				Map<String, String> passingMap = new LinkedHashMap<>();
				passingMap.put("master_ans_var_name", masterAnsArray[i]);
				passingMap.put("master_ques_var_name", masterQuesArray[i]);
				passingMap.putAll(map);
				Message accessMessage = genericProcess.GenericProcedureCalling("34", passingMap, null, request,
						response);
				System.out.println("accessMessage " + accessMessage.getObject());
				if (!accessMessage.isValid()) {
					message.setDescription("Issue in setting permission");
					message.setValid(false);
					return message;
				}
			}
			Message jobMessage = genericProcess.GenericProcedureCalling("80", map, null, request, response);

			message.setDescription("Process Success");
			message.setValid(true);
			message.setObject(jobMessage.getObject()); 
			return message;
		} catch (Exception e) {
			message.setDescription("Issue in setting permission " + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

}
