/**
 * This package contain the Service class for Downloading all final reports 
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.io.File;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springiot.constant.CustomerService;
import com.springiot.constant.ProcessParameter;
import com.springiot.finalReport.TemplateReport;
import com.springiot.genericService.GenericService;
import com.springiot.pdf.PDFGenerator;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service class for Downloading all final reports and
 * calling escalation APi so that notification for generating final report can
 * be send
 * 
 * @author Ankita Shrothi
 *
 */
@Service
@Transactional
public class FinalReportServices {
	/**
	 * To Access the respective class Methods as their services
	 */
	@Autowired
	private GenericService genericService;

	@Autowired
	private ProcessParameter processParameter;

	@Autowired
	private CustomerService customerService;

	/**
	 * To Submit the Final Report to Get Pdf of Horn
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked", "serial" })
	public Message submitHornFinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		/**
		 * To get Host url link address
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";

		StringBuilder builder = new StringBuilder();

		Message message = new Message();

		/**
		 * Array of Procedure to generate Final Report
		 */
		String procedureId[] = new String[] { "85", "86", "107", "158", "80", "81", "66" };
		String procedureName[] = new String[] { "analysis", "conclusion", "signature", "screw", "beforeImage",
				"afterImage", "observation" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * to check if token is null than terminate the program
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/*
			 * to store the path of the generated PDF
			 */
			Map<String, Object> filePathMap = new HashMap<>();

			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/**
			 * To add logo in report
			 */
			templateMap.put("logo", logo);

			/**
			 * To get header in report
			 */
			responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
					processParameter.getMaps().get("53").toString(), map.get("vendor_code"), map.get("start_date"),
					map.get("end_date"), map.get("test_number"));
			System.out.println("header data:" + responseList);
			/*
			 * Check the size of responseList
			 */
			if (responseList.size() > 0) {
				templateMap.put("header", responseList.get(0));
				builder.append("header" + responseList.get(0).toString() + "\n");

			}

			/**
			 * Getting grid data
			 */

			responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
					processParameter.getMaps().get("100").toString(), map.get("vendor_code"), map.get("start_date"),
					map.get("end_date"), map.get("test_number"));
			System.out.println("GridData :" + responseList);

			builder.append("grid" + responseList.toString() + "\n");
			/**
			 * Initialize list to separate current,frequency,sound data from
			 * grid data
			 */
			List<Map<String, String>> current = new ArrayList<Map<String, String>>();
			List<Map<String, String>> frequency = new ArrayList<Map<String, String>>();
			List<Map<String, String>> sound = new ArrayList<Map<String, String>>();
			/**
			 * to separate current,frequency,sound data from grid data in
			 * separate list
			 */
			for (int i = 0; i < responseList.size();) {
				current.add(responseList.get(i));
				frequency.add(responseList.get(i + 1));
				sound.add(responseList.get(i + 2));
				i = i + 3;
			}
			/*
			 * Check size of the list than add in templateMap
			 */
			if (current.size() > 0) {
				templateMap.put("current", current);
				builder.append("current" + current.toString() + "\n");
			}
			/*
			 * Check size of the list than add in templateMap
			 */
			if (frequency.size() > 0) {
				templateMap.put("frequency", frequency);
				builder.append("frequency" + frequency.toString() + "\n");
			}
			/*
			 * Check size of the list than add in templateMap
			 */
			if (sound.size() > 0) {
				templateMap.put("sound", sound);
				builder.append("sound" + sound.toString() + "\n");
			}
			/*
			 * Add diagonal
			 */
			String dignol = customerService.getResource("classpath:template/dignol-img.png").getFile()
					.getAbsolutePath();

			/**
			 * To get diagonal image in screw setting
			 */
			templateMap.put("dignol", dignol);
			builder.append("diagonal" + dignol.toString() + "\n");
			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To Get Before and After Image and Signature Images
				 */
				responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
						processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
						map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
				System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
				if (responseList != null && responseList.size() > 0) {
					if (procedureId[i].equalsIgnoreCase("80") || procedureId[i].equalsIgnoreCase("81")
							|| procedureId[i].equalsIgnoreCase("66") || procedureId[i].equalsIgnoreCase("158")) {
						if (procedureId[i].equalsIgnoreCase("80") || procedureId[i].equalsIgnoreCase("81")) {
							for (int j = 0; j < responseList.size(); j++) {
								String imagePath = responseList.get(j).get("image_path");

								responseList.get(j).put("image_path",
										hostUrl + "/" + imagePath.substring(imagePath.indexOf("tmpFiles")));
							}
						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + " \n");
						}
					} else {
						if (procedureName[i].equalsIgnoreCase("signature")) {
							Map<String, String> map1 = responseList.get(0);
							for (String key : map1.keySet()) {
								String value = responseList.get(0).get(key);// .replaceAll("//",
								// "/");

								System.out.println(value + "==" + key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(0).put(key, value);
									continue;
								}

								responseList.get(0).put(key,
										hostUrl + "/" + value.substring(value.indexOf("tmpFiles")).replace("\\", "/"));
							}
						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList.get(0));
							builder.append("Signature" + responseList.get(0).toString() + "\n");
						}

					}
				}
			}

			/**
			 * getting result Data
			 */

			Type listType = new TypeToken<List<Map<String, String>>>() {
			}.getType();
			Map<String, String> negativeResultEmptyMap = new HashMap<>();
			List<Map<String, String>> negativeResultList = new LinkedList<>();
			/*
			 * To get the result
			 */
			List<List<Map<String, Object>>> obj = (List<List<Map<String, Object>>>) genericService
					.executeProcedureMultipleResultSet(null, processParameter.getMaps().get("95").toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"));

			Gson gson = new GsonBuilder().serializeNulls().create();
			String s = gson.toJson(obj.get(1));

			responseList = gson.fromJson(s, listType);

			System.out.println("result data :" + responseList);

			List<Map<String, String>> tmpList = new ArrayList<Map<String, String>>();

			new ArrayList<Integer>();

			for (int i = 0; i < responseList.size(); i++) {
				System.out.println(i);
				if (responseList.get(i).get("is_planned").trim().equalsIgnoreCase("N.G")) {

					negativeResultList.add(responseList.get(i));

				} else {
					tmpList.add(responseList.get(i));
				}

			}

			responseList = tmpList;
			System.out.println("responseList:" + responseList);
			/*
			 * Check size of the list than add in templateMap
			 */
			if (responseList.size() > 0)
				for (String key : responseList.get(0).keySet()) {
					negativeResultEmptyMap.put(key, "-");
				}

			int count = negativeResultList.size();

			if (responseList.size() > count && count > 0) {
				for (int i = count - 1; i < responseList.size() - 1; i++) {
					negativeResultList.add(i, negativeResultEmptyMap);
				}
			}
			if (responseList.size() < count) {
				for (int i = responseList.size(); i < count; i++) {
					responseList.add(i, negativeResultEmptyMap);
				}
			}

			if (responseList.size() > 0) {
				templateMap.put("posativeResult", responseList);
				builder.append("\n posativeResult :-" + responseList.toString());
			}
			/*
			 * Check size of the list than add in templateMap
			 */
			if (negativeResultList.size() > 0) {
				templateMap.put("negativeResult", negativeResultList);
				builder.append("negativeResultList" + negativeResultList.toString() + "\n");
			}

			System.out.println("posative result:" + responseList);
			System.out.println("negative result:" + negativeResultList);
			/*
			 * Check if template is not empty than pass it in TemplateReportFile
			 * to set data in it
			 */
			if (!templateMap.isEmpty()) {
				/**
				 * To Pass All Api response in template
				 */
				System.out.println("TEMPLATE MAP :-" + templateMap);
				TemplateReport templateReport = new TemplateReport();
				/*
				 * to set data in template and get in string to generate its PDF
				 */
				String responsedata = templateReport.TemplateReportFile("template/hornReport.vm", templateMap);
				/*
				 * Check if response data is null
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Template issue  " + " Response " + responsedata);
					message.setValid(false);
					return message;
				}
				/*
				 * To get path of generated pdf
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Horn-Report.pdf";

				System.out.println("html :" + responsedata);

				try {
					/**
					 * to generate pdf with set values in the given path
					 */
					String value = PDFGenerator.generateHornPDF(responsedata, path);
					System.out.println(value);
					/*
					 * check the value if its null thn send error response
					 */
					if (value == null) {
						message.setDescription("Execution Fail Because of PDF Generation" + "value" + value);
						message.setValid(false);
						return message;
					}
					filePathMap.put("file", path);
					filePathMap.put("orignalPath", path);
				} catch (Exception e) {
					/*
					 * If exception comes than error response will be return
					 */
					message.setDescription("Execution Fail can't genrate pdf" + e.getMessage());
					message.setValid(false);
					return message;
				}

				try {
					/**
					 * To call Escalation code of Final Submit
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1032", "0");

				} catch (Exception e) {
					/*
					 * to print exception
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public Message submitShowerFinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {

		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "64", "65", "108", "110", "109", "118", "78" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "115", "114" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {

			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("64") || procedureId[i].equalsIgnoreCase("65")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_cycle");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_cycle").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("118")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 3; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + "===" + imageProcedureName[i] + j + ": "
							+ imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/shower-report.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Shower_Tail.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generatePDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1049", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Success response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Relay
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitRelayFinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();
		/**
		 * Array of procedure to get the data of reports
		 */
		String procedureId[] = new String[] { "54", "57", "141", "142", "143", "145", "76" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };
		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "144", "144" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			Map<String, Object> filePathMap = new HashMap<>();
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {
				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("54") || procedureId[i].equalsIgnoreCase("57")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),
							map.get("vendor_code"), map.get("start_date"), map.get("end_date"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("145")) {
					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList.get(0));
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {
						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 6; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");

								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/relay-report.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "relay-report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateRelayPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1033", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitSideStandFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();
		/**
		 * Array of procedure to get the data of reports
		 */
		String procedureId[] = new String[] { "55", "58", "166", "167", "169", "170", "77" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };
		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "168", "168" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			Map<String, Object> filePathMap = new HashMap<>();
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append("logo" + logo.toString() + "\n");

			for (int i = 0; i < procedureId.length; i++) {
				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("55") || procedureId[i].equalsIgnoreCase("58")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),
							map.get("vendor_code"), map.get("start_date"), map.get("end_date"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList
							+ "responseList size" + responseList.size());

					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_cycle");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_cycle").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("170")) {
					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code").trim(), map.get("test_number").trim());
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0)
							templateMap.put(procedureName[i], responseList.get(0));
						builder.append(procedureName[i] + ":" + responseList.get(0).toString() + "\n");
					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {
						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");

								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						} /*
							 * Check size of the list than add in templateMap
							 */
						if (responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}

					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/side-stand.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;
				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "SIDE-STAND-report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generatePDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value " + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1034", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitDustHeadFinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {

		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "192", "189", "190", "191", "195", "196", "194" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "193", "193" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {
				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("192") || procedureId[i].equalsIgnoreCase("189")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),
							map.get("vendor_code"), map.get("start_date"), map.get("end_date"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("testing_condition_as_per_standard");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_cycle").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");

						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("196")) {
					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");

						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/dust-test-file.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Dust_Head.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1048", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Side Stand
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitDustTailFinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "212", "209", "210", "211", "215", "216", "214" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "213", "213" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {

			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("212") || procedureId[i].equalsIgnoreCase("209")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),
							map.get("vendor_code"), map.get("start_date"), map.get("end_date"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("testing_condition_as_per_standard");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_cycle").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						} /*
							 * Check size of the list than add in templateMap
							 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");

						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("216")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");

						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);
				/*
				 * To set all the data in template file
				 */
				TemplateReport templateReport = new TemplateReport();

				String responsedata = templateReport.TemplateReportFile("template/dust-test-file.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Dust_Tail.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1048", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}

	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitShowerHeadFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "232", "229", "230", "231", "235", "236", "234" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "233", "233" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {

			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("232") || procedureId[i].equalsIgnoreCase("229")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_method");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_method").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("236")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/shower-report.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Shower_Head.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1049", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitShowerFrontWrinkerFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report //
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "259", "256", "257", "258", "262", "263", "261" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "260", "260" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {

			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("259") || procedureId[i].equalsIgnoreCase("256")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_method");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_method").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						} /*
							 * Check size of the list than add in templateMap
							 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("263")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");

								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/shower-report.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Shower_Front_Wrinker.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1049", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitShowerRearWinkerFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "290", "265", "288", "289", "293", "294", "292" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "291", "291" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {

			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("290") || procedureId[i].equalsIgnoreCase("265")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_method");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_method").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						} /*
							 * Check size of the list than add in templateMap
							 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("294")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/shower-report.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Shower_Rear_Wrinker.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1049", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public Message submitShowerStarterRelayFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:7878";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "299", "296", "297", "298", "302", "303", "301" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "300", "300" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {
				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("299")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("test_method");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_method").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}

				else if (procedureId[i].equalsIgnoreCase("296")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),
							map.get("vendor_code"), map.get("start_date"), map.get("end_date"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("303")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 1; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/shower-new-lock.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Shower_Starter_Relay.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1049", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Submit the Final Report to Get Pdf of Shower
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @param request:::To
	 *            get userkey,user_id from request header
	 * 
	 * @param response:::To
	 *            send response
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public Message submitLockinalReport(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
		System.out.println(hostUrl);

		// String hostUrl = "http://192.168.1.73:4444";
		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "320", "339", "321", "322", "337", "325", "324" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "323", "323" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("320") || procedureId[i].equalsIgnoreCase("")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("testing_condition_as_per_standard");
								/*
								 * to get image path with host url;
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								if (!(responseList.get(k).get("test_cycle").equalsIgnoreCase("null"))) {
									responseList.get(k).put(key,
											hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
								} else {
									responseList.get(k).put(key, "");
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("325")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 0; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/lock.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription("Execution Fail Because of template" + builder + "response" + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Lock_Final_Report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation" + builder + "value" + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1057", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Download final report of Speedometer for Shower testing in Pdf.
	 * 
	 * @param map
	 *            : Contains all the parameters.
	 * @param request
	 *            : To get userkey,user_id from request header
	 * @param response
	 *            : To send response.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public Message submitShowerSpedometerFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0,Url.indexOf(req.getRequestURI().toString()));
		//String hostUrl = "http://192.168.1.73:7878";
		System.out.println(hostUrl);

		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "352", "359", "353", "354", "360", "357", "356" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "355", "355" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			System.out.println("logo" + logo);
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("352") || procedureId[i].equalsIgnoreCase("359")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								if (key.equalsIgnoreCase("test_actual_condition_image")) {
									String imagePath = responseList.get(k).get("test_actual_condition_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile = URLEncoder
											.encode(imagePath.substring(imagePath.indexOf("tmpFiles")), "UTF-8");
									System.out.println("actual condition image: " + tempFile);
									if (!(responseList.get(k).get("test_actual_condition_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}
								if (key.equalsIgnoreCase("test_condition_as_per_specification_image")) {
									String imagePath1 = responseList.get(k)
											.get("test_condition_as_per_specification_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile1 = URLEncoder
											.encode(imagePath1.substring(imagePath1.indexOf("tmpFiles")), "UTF-8");
									System.out.println("specific condition image: " + tempFile1);
									if (!(responseList.get(k).get("test_condition_as_per_specification_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile1.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("357")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 0; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/speedometer-shower.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription(
							"Execution Fail Because of template: " + builder + "response: " + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Speedometer_Final_Report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateRelayPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation: " + builder + "value: " + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1058", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (

		Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Download final report of Front Winker for Dust testing in Pdf.
	 * 
	 * @param map
	 *            : Contains all the parameters.
	 * @param request
	 *            : To get userkey,user_id from request header
	 * @param response
	 *            : To send response.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public Message submitDustWinkerFrontFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0,Url.indexOf(req.getRequestURI().toString()));
		//String hostUrl = "http://192.168.1.73:7878";
		System.out.println(hostUrl);

		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "376", "373", "374", "375", "379", "380", "378" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "377", "377" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("373")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),map.get("vendor_code"), map.get("start_date"),
							map.get("end_date"),  map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				if (procedureId[i].equalsIgnoreCase("376")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								if (key.equalsIgnoreCase("test_actual_condition_image")) {
									String imagePath = responseList.get(k).get("test_actual_condition_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile = URLEncoder
											.encode(imagePath.substring(imagePath.indexOf("tmpFiles")), "UTF-8");

									if (!(responseList.get(k).get("test_actual_condition_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}

								if (key.equalsIgnoreCase("test_condition_as_per_specification_image")) {
									String imagePath1 = responseList.get(k)
											.get("test_condition_as_per_specification_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile1 = URLEncoder
											.encode(imagePath1.substring(imagePath1.indexOf("tmpFiles")), "UTF-8");

									if (!(responseList.get(k).get("test_condition_as_per_specification_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile1.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("380")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 0; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/dust-front-winker.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription(
							"Execution Fail Because of template: " + builder + "response: " + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Front_Winker_Final_Report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation: " + builder + "value: " + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1059", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

	/**
	 * To Download final report of Rear Winker for Dust testing in Pdf.
	 * 
	 * @param map
	 *            : Contains all the parameters.
	 * @param request
	 *            : To get userkey, user_id from request header
	 * @param response
	 *            : To send response.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings({ "static-access", "unchecked" })
	public Message submitDustWinkerRearFinalReport(Map<String, String> map, HttpServletRequest req,
			HttpServletResponse res) {
		/**
		 * to get the host url to get images in report
		 */
		String Url = req.getRequestURL().toString();
		String hostUrl = Url.toString().substring(0,Url.indexOf(req.getRequestURI().toString()));
		//String hostUrl = "http://192.168.1.73:7878";
		System.out.println(hostUrl);

		StringBuilder builder = new StringBuilder();
		Message message = new Message();

		/**
		 * Array of procedure to get the data of reports
		 */
		Map<String, Object> filePathMap = new HashMap<>();
		String procedureId[] = new String[] { "398", "395", "396", "397", "401", "402", "400" };
		String procedureName[] = new String[] { "header", "grid", "analysis", "conclusion", "result", "signature",
				"observation" };

		/**
		 * To get before and after images for each component
		 */
		String imageProcedureId[] = new String[] { "399", "399" };
		String imageProcedureName[] = new String[] { "afterImageN", "beforeImageN" };
		/*
		 * To store all the responses of API which will be called to set the
		 * final report
		 */
		List<Map<String, String>> responseList = new ArrayList<Map<String, String>>();
		/**
		 * It will store all the Object which will set in template to generated
		 * pdf in a formatted way
		 */
		Map<String, Object> templateMap = new HashMap<>();
		/*
		 * To check if token value is null than return error response
		 */
		if (map.get("token") == null) {

			message.setDescription("token Needed.");
			message.setValid(false);
			return message;
		}

		try {
			/**
			 * To get Logo path
			 */
			String logo = customerService.getResource("classpath:template/hero-logo.png").getFile().getAbsolutePath();
			/*
			 * to add Logo in template Map
			 */
			templateMap.put("logo", logo);
			builder.append(logo.toString());

			for (int i = 0; i < procedureId.length; i++) {

				/**
				 * To get header and Grid Data by calling its API
				 */
				if (procedureId[i].equalsIgnoreCase("395")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(),map.get("vendor_code"), map.get("start_date"),
							map.get("end_date"),  map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				if (procedureId[i].equalsIgnoreCase("398")) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								if (key.equalsIgnoreCase("test_actual_condition_image")) {
									String imagePath = responseList.get(k).get("test_actual_condition_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile = URLEncoder
											.encode(imagePath.substring(imagePath.indexOf("tmpFiles")), "UTF-8");

									if (!(responseList.get(k).get("test_actual_condition_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}

								if (key.equalsIgnoreCase("test_condition_as_per_specification_image")) {
									String imagePath1 = responseList.get(k)
											.get("test_condition_as_per_specification_image");
									/*
									 * to get image path with host url;
									 */
									String tempFile1 = URLEncoder
											.encode(imagePath1.substring(imagePath1.indexOf("tmpFiles")), "UTF-8");

									if (!(responseList.get(k).get("test_condition_as_per_specification_image")
											.equalsIgnoreCase("null"))) {
										responseList.get(k).put(key,
												hostUrl + "/" + tempFile1.replace("%2F", "/").replace("+", "%20"));
									} else {
										responseList.get(k).put(key, "");
									}
								}

							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {
							templateMap.put(procedureName[i], responseList);
							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}
					}

				}
				/*
				 * To get signature data
				 */
				else if (procedureId[i].equalsIgnoreCase("402")) {

					/**
					 * To get signature images by calling its API
					 */
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureName[i] + ": " + procedureName[i] + ":" + responseList);
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {
								String value = mapSig.get(key);

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String tempFile = URLEncoder
										.encode(value.substring(value.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList.size() > 0) {

							templateMap.put(procedureName[i], responseList.get(0));

							builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
						}

					}

				}
				/*
				 * To get rest APIs data by calling its API
				 */
				else {
					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(procedureId[i].toString()).toString(), map.get("start_date"),
							map.get("end_date"), map.get("vendor_code"), map.get("test_number"));
					System.out.println(procedureId[i] + ": " + procedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						templateMap.put(procedureName[i], responseList);
						builder.append(procedureName[i] + ":" + responseList.toString() + "\n");
					}
				}
			}

			int statusBit = 0;
			for (int i = 0; i < imageProcedureId.length; i++) {
				/**
				 * TO call image API to get before and after Images by setting
				 * their status bit
				 */
				if (imageProcedureName[i].trim().toString().equalsIgnoreCase("beforeImageN")) {
					statusBit = 1;
				}
				System.out.println("status bit:- " + statusBit + "===" + imageProcedureName[i] + "/");
				for (int j = 0; j < 5; j++) {

					responseList = (List<Map<String, String>>) genericService.executeProcesure(null,
							processParameter.getMaps().get(imageProcedureId[i].toString()).toString(),
							map.get("start_date"), map.get("end_date"), map.get("vendor_code"), map.get("test_number"),
							j, statusBit);

					System.out.println(map.get("start_date") + "/" + map.get("end_date") + "/" + map.get("vendor_code")
							+ "/" + map.get("test_number") + "/" + j + "/" + statusBit + "===" + imageProcedureName[i]
							+ j + ": " + imageProcedureName[i] + ":" + responseList);
					/*
					 * Check size of the list than add in templateMap
					 */
					if (responseList != null && responseList.size() > 0) {

						for (int k = 0; k < responseList.size(); k++) {
							Map<String, String> mapSig = responseList.get(k);
							for (String key : mapSig.keySet()) {

								String value = String.valueOf(mapSig.get(key));

								if (value.indexOf("tmpFiles") == -1) {
									responseList.get(k).put(key, value);
									continue;
								}

								String imagePath = responseList.get(k).get("image_path");
								/*
								 * To get the image path with their host url
								 */
								String tempFile = URLEncoder.encode(imagePath.substring(imagePath.indexOf("tmpFiles")),
										"UTF-8");

								responseList.get(k).put(key,
										hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
							}

						}
						/*
						 * Check size of the list than add in templateMap
						 */
						if (responseList != null && responseList.size() > 0) {
							templateMap.put(imageProcedureName[i] + j, responseList);
							builder.append(imageProcedureName[i] + j + ":" + responseList.toString() + "\n");
						}
					}
				}

			}
			/*
			 * Check if template map is empty
			 */
			if (!templateMap.isEmpty()) {
				/*
				 * To print template map
				 */
				System.out.println("template Map;- " + templateMap);

				TemplateReport templateReport = new TemplateReport();
				/*
				 * To set all the data in template file
				 */
				String responsedata = templateReport.TemplateReportFile("template/dust-rear-winker.vm", templateMap);
				/*
				 * Check if response data is null than return error response
				 */
				if (responsedata == null) {
					message.setDescription(
							"Execution Fail Because of template: " + builder + "response: " + responsedata);
					message.setValid(false);
					return message;

				}
				/*
				 * to get the File path in which pdf will be created
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "Rear_Winker_Final_Report.pdf";

				System.out.println("html :" + responsedata);
				/*
				 * to generate pdf with data and the path of file where it has
				 * to be write
				 */
				String value = PDFGenerator.generateDustPDF(responsedata, path);

				System.out.println(value);
				/*
				 * To check if value is null than error response
				 */
				if (value == null) {
					message.setDescription("Execution Fail Because of PDF Generation: " + builder + "value: " + value);
					message.setValid(false);
					return message;
				}

				filePathMap.put("file", path);
				filePathMap.put("orignalPath", path);

				try {
					/**
					 * To call Escalation API
					 */
					Object object = genericService.executeProcesure(null,
							processParameter.getMaps().get("insertfile").toString(), path, "1060", "0");

					System.out.println(object);

				} catch (Exception e) {
					/**
					 * To Print escalation if it comes in process
					 */
					System.out.println(e.getMessage());
				}

			}
			/*
			 * return Sucess response
			 */
			message.setDescription("Process success");
			message.setObject(filePathMap);
			message.setValid(true);
			return message;

		} catch (Exception e) {
			/*
			 * Return Error response
			 */
			e.printStackTrace();
			message.setDescription("Execution Fail" + e.getMessage());
			message.setValid(false);
			return message;
		}
	}

}
