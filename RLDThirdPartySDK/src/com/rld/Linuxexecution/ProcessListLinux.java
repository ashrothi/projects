package com.rld.Linuxexecution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/*
 * Class is used to retrieve the process list and manipulate it according to the needs
 */
public class ProcessListLinux {

	/*
	 * Retrieve the process list of Linux OS-Type
	 */
	public String ProcessList() {
		List<HashMap<String, String>> finalList = new ArrayList<>();
		
		String final_json = "";
		BufferedReader inputPort = null;
		try {
			Process os_name = null;
			/*
			 * Calling of getRuntime() method to execute terminal command to get
			 * the Process List
			 */
			if (System.getProperty("os.name").equalsIgnoreCase("Linux")) {
				os_name = Runtime.getRuntime().exec("netstat -nlp");

				inputPort = new BufferedReader(new InputStreamReader(os_name.getInputStream()));
				String line = "";
				int count = 0;
				List<String> headers = new ArrayList<>();

				/*
				 * Manipulation in Process List to get the desired results
				 */
				boolean flag = false;
				while ((line = inputPort.readLine()) != null) {

					if (line.contains("Active UNIX domain")) {
						flag = true;
					}
					if (!flag) {

						if (count == 0) {
							count++;
							continue;
						}

						if (count == 1) {
							String arr[] = line.replaceAll("[\\s]+", ",").replaceAll("/", "_").split(",");
							for (int i = 0; i < arr.length; i++) {
								if (i == 3 || i == 5 || i == 8) {
									headers.add(arr[i] + arr[i + 1]);
									i++;
								} else {
									headers.add(arr[i]);
								}
							}
						}

						else {
							// System.out.println("headeres are:" + headers);
							String arr[] = line.replaceAll("[\\s]+", ",").split(",");

							if (arr.length == headers.size()) {
								HashMap<String, String> tmpMap = new HashMap<String, String>();
								for (int i = 0; i < headers.size(); i++) {

									if (arr[i].contains("/")) {
										tmpMap.put(headers.get(i), arr[i].split("/")[1]);
									} else {
										tmpMap.put(headers.get(i), arr[i]);
									}
								}
								finalList.add(tmpMap);
							}
						}
					}
					count++;
					// System.out.println("final json is" + final_json);
				}
				System.out.println("final json is" + final_json);
				Type listTypeJson = new TypeToken<List<HashMap<String, String>>>() {
				}.getType();
				final_json = new Gson().toJson(finalList, listTypeJson);
			}
			inputPort.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
		return final_json;
	}
}
