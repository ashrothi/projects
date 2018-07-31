/**
 * This package contain the Services class for download Planner PDF.
 */
package com.springiot.services;

/**
 * To Import Classes to access their functionality
 */
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.springiot.constant.CustomerService;
import com.springiot.finalReport.TemplateReport;
import com.springiot.pdf.PDFGeneratorXML;
import com.springiot.response.Message;

/**
 * 
 * This class work as a Service which is used to create apis download Planner
 * PDF.
 * 
 * @author Ankita Shrothi
 *
 */
@Service
public class DownloadPDFService {

	/**
	 * To access functionality of following Class function
	 */
	@Autowired
	private GenericProcess genericProcess;

	@Autowired
	private CustomerService customerService;
	/**
	 * To Download File Of Planner Report
	 * 
	 * @param map::::Contains
	 *            all the parameters.
	 * 
	 * @return Return the response message
	 */
	@SuppressWarnings("unchecked")
	public Message downloadDailyPlanner(Map<String, String> passingParameterMap, HttpServletRequest req,
			HttpServletResponse res) {
		/*
		 * Initialize response Message
		 */
		Message responseMessage = new Message();

		try {

			/**
			 * To get Host url link address
			 */
			String Url = req.getRequestURL().toString();
			String hostUrl = Url.toString().substring(0, Url.indexOf(req.getRequestURI().toString()));
			System.out.println(hostUrl);

			// String hostUrl = "http://192.168.1.97:4444";
			/**
			 * to check planner_number is null
			 */
			if (passingParameterMap.get("planner_number") == null) {

				responseMessage.setDescription("Planner No Reqiuired.");
				responseMessage.setValid(false);
				return responseMessage;
			}

			Map<String, Object> templateVmData = new HashMap<>();
			Map<String, String> passingSignatureParameter = new HashMap<>();
			passingSignatureParameter.put("planner_number", passingParameterMap.get("planner_number"));
			passingSignatureParameter.put("planner_version", passingParameterMap.get("planner_version"));

			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result to get planner header
			 */
			List<Map<String, Object>> plannerHeaderData = (List<Map<String, Object>>) genericProcess
					.GenericProcedureCalling("33", passingParameterMap, null).getObject();
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result to get planner Equipment
			 */
			List<Map<String, Object>> plannerEquipmentExcelData = (List<Map<String, Object>>) genericProcess
					.GenericProcedureCalling("34", passingParameterMap, null).getObject();
			/**
			 * GenericProcedureCalling method of genericProcess calling to get
			 * the stored Procedure result to get planner Signature
			 */
			List<Map<String, Object>> plannerSignatureExcelData = (List<Map<String, Object>>) genericProcess
					.GenericProcedureCalling("183", passingSignatureParameter, null).getObject();
			/**
			 * to get signature with their image path
			 */
			if (plannerSignatureExcelData != null && plannerSignatureExcelData.size() > 0) {

				for (int k = 0; k < plannerSignatureExcelData.size(); k++) {
					Map<String, Object> mapSig = plannerSignatureExcelData.get(k);
					for (String key : mapSig.keySet()) {
						String pdfGenrationResponse = mapSig.get(key).toString();
						/*
						 * to check if its on server or not
						 */
						if (pdfGenrationResponse.indexOf("tmpFiles") == -1) {
							plannerSignatureExcelData.get(k).put(key, pdfGenrationResponse);
							continue;
						}
						/*
						 * to get image path in formated way
						 */
						String tempFile = URLEncoder.encode(pdfGenrationResponse
								.substring(pdfGenrationResponse.indexOf("tmpFiles")).replace("\\", "/"), "UTF-8");

						plannerSignatureExcelData.get(k).put(key,
								hostUrl + "/" + tempFile.replace("%2F", "/").replace("+", "%20"));
					}

				}

				templateVmData.put("plannerSignature", plannerSignatureExcelData);
			}
			/**
			 * If plannerHeaderData is Valid
			 */
			if (plannerHeaderData.size() > 0 && plannerEquipmentExcelData.size() > 0) {
				/**
				 * to get logo
				 */
				Resource resource = customerService.getResource("classpath:template/hero-logo.png");
				/**
				 * to get logo path
				 */
				String logo = resource.getFile().getAbsolutePath();
				/**
				 * to get year
				 */
				String date = new SimpleDateFormat("yyyy").format(new Date());
				/**
				 * TO put all the responses and data which need to be set in pdf
				 */

				templateVmData.put("logo", logo);
				templateVmData.put("date", date);
				templateVmData.put("header", "Planner Report");
				templateVmData.put("plannerno", passingParameterMap.get("planner_number"));
				templateVmData.put("plannerHeader", plannerHeaderData);
				templateVmData.put("plannerEquipment", plannerEquipmentExcelData);

				/**
				 * To get Path of server where file will be write
				 */
				String path = System.getProperty("catalina.home") + File.separator + "webapps/tmpFiles/"
						+ "planner.pdf";
				/**
				 * to get file path of velocity template
				 */
				String FilePath = createTemplateFiles("template/planer-gurgaon-daily.vm", path, templateVmData);
				/**
				 * to check file path is not null
				 */
				if (FilePath != null) {
					Map<String, Object> filePathMap = new HashMap<>();
					filePathMap.put("file", FilePath);
					filePathMap.put("orignalPath", FilePath);
					/*
					 * Return response with file path
					 */
					responseMessage.setDescription("Data is successfully downloaded");
					responseMessage.setObject(filePathMap);
					responseMessage.setValid(true);
					return responseMessage;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			/**
			 * If try doesn't Work
			 */
			responseMessage.setDescription(e.getMessage());
			responseMessage.setValid(false);
			return responseMessage;

		}
		/**
		 * If the parameters are not correct
		 */
		responseMessage.setDescription("Process Fail Required Parameter is inappropriate");
		responseMessage.setValid(false);
		return responseMessage;
	}

	/**
	 * To create template to make pdf of planner
	 * 
	 * @param templateName
	 * @param FilePath
	 * @param templateVmData
	 * @return
	 */
	private String createTemplateFiles(String templateName, String FilePath, Map<String, Object> templateVmData) {
		try {
			/**
			 * Get all set data from template
			 */
			String data = TemplateReport.TemplateReportFile(templateName, templateVmData);
			/**
			 * to generate pdf file and get its path
			 */
			String pdfGenrationResponse = PDFGeneratorXML.generatePDF(data, FilePath);
			/**
			 * return pdf file path
			 */
			return pdfGenrationResponse;

		} catch (Exception e) {
			/*
			 * to handle exception
			 */
			e.printStackTrace();
		}
		/*
		 * return null if process fails
		 */
		return null;
	}

}
