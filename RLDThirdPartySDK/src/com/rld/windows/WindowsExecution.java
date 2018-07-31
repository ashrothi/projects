package com.rld.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

/*
 * Class is used to retrieve the process list and manipulate it according to the needs
 */
public class WindowsExecution {
	/*
	 * Retrieve the process list of Windows OS-Type
	 */
	public String ProcessList() {

		/*
		 * Manipulating the output of two window commands
		 */
		String final_processList = "";
		HashMap<String, String> processName = getProccessName();
		HashMap<String, String> getPorts = getPorts();

		// System.out.println("map_port:"+getPorts);
		// System.out.println("map_process:"+processName);

		List<HashMap<String, String>> finalList = new ArrayList<>();
		for (String key : getPorts.keySet()) {
			/*
			 * Matching the PID from both commands
			 */
			if (processName.containsKey(key)) {
				if (processName.get(key).contains("Tomcat")) {
					String appName = "Tomcat";
					if (System.getProperty("user.dir").length() > 0) {
						String Directory = System.getProperty("user.dir");
						appName = Directory.substring(Directory.lastIndexOf("\\") + 1);
						System.out.println("app name:" + appName);
					}
					HashMap<String, String> hashMap = new HashMap<>();
					hashMap.put("PID", key);
					hashMap.put("Port", getPorts.get(key));
					hashMap.put("ProcessName", appName);

					System.out.println("app name:" + appName);
					System.out.println("hash map values are" + hashMap);
					finalList.add(hashMap);

				} else {
					HashMap<String, String> hashMap = new HashMap<>();
					hashMap.put("PID", key);
					hashMap.put("Port", getPorts.get(key));
					hashMap.put("ProcessName", processName.get(key));

					System.out.println("app name");
					System.out.println("hash map values are" + hashMap);
					finalList.add(hashMap);

					// System.out.println("final json is" + final_processList);

				}
			}
		}

		Type listTypeJson = new TypeToken<List<HashMap<String, String>>>() {
		}.getType();
		final_processList = new Gson().toJson(finalList, listTypeJson);
		System.out.println("Completed" + finalList);
		return final_processList;
	}

	HashMap<String, String> map_port = new HashMap<>();
	HashMap<String, String> map_process = new HashMap<>();

	/*
	 * Retrieving the PID and Ports via cmd command
	 */
	public HashMap<String, String> getPorts() {
		String line = null;
		// HashMap<String, String> map_port = new HashMap<>();
		try {
			Process processCommand = null;
			/*
			 * Executing the getRuntime() method to execute command in cmd
			 */
			String cmd = "netstat -a -n -o";
			processCommand = Runtime.getRuntime().exec(cmd);

			BufferedReader inputPort = new BufferedReader(new InputStreamReader(processCommand.getInputStream()));
			/*
			 * Manipulating the output of command
			 */
			int count = 0;
			while ((line = inputPort.readLine()) != null) {
				if (count < 4) {
					count++;
					continue;
				}
				try {
					String arr[] = line.trim().replaceAll("\\s+", ",").split(",");

					map_port.put(arr[4].trim(), arr[1]);
				} catch (Exception e) {

				}
				count++;
			}

			System.out.println("map:" + map_port);
			inputPort.close();

		} catch (Exception err) {
			err.printStackTrace();
		}
		System.out.println("Map port is " + map_port);
		return map_port;
	}

	/*
	 * Retrieving the PID and ProcessName via cmd command
	 */
	public HashMap<String, String> getProccessName() {
		String line = null;

		try {
			Process processCommand = null;
			/*
			 * Executing the getRuntime() method to execute command in cmd
			 */
			processCommand = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

			BufferedReader inputPort = new BufferedReader(new InputStreamReader(processCommand.getInputStream()));

			int count = 0;
			/*
			 * Manipulating the output of command
			 */
			while ((line = inputPort.readLine()) != null) {

				if (count > 2) {
					String aArr[] = line.split("\\s{2,}");
					for (int i = 0; i < aArr.length; i++) {
						if (aArr[0].contains("/")) {
							map_process.put(aArr[1].split(" ")[0].trim(), aArr[0].split("/")[1]);
						} else {
							map_process.put(aArr[1].split(" ")[0].trim(), aArr[0]);
						}
					}
				}
				count++;
			}
			System.out.println(map_process);
			inputPort.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
		System.out.println("Map  is " + map_process);
		return map_process;
	}
}