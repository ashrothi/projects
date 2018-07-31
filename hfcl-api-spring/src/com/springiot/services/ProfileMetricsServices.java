package com.springiot.services;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * This is a service class used for ProfileMetricsController and to display the
 * Profile Metrics KPIs.
 * 
 * @author tanvigarg
 *
 */

@Service
@SuppressWarnings("unchecked")
public class ProfileMetricsServices {

	@Autowired
	private KPIServices kpiServices;

	/**
	 * This method is specific for the sdcchDropRatePerBts KPI.
	 * 
	 * @param map,the
	 *            input parameter map.
	 * @param request,the
	 *            http servlet request required for the headers.
	 * @param response,the
	 *            http servlet response required for the headers.
	 * @return message,returns the response message.
	 */

	public Message sdcchDropRatePerBts(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		// Initialization of Message Class
		Message responseMessage = new Message();
		Map<String, Object> responseMap = new HashMap<>();

		try {

			LinkedHashMap<String, String> numeratorKPIMap = new LinkedHashMap<>();

			numeratorKPIMap.put("device_id", map.get("device_id").trim());
			numeratorKPIMap.put("data_source", map.get("data_source_numerator").trim());
			numeratorKPIMap.put("service_name", map.get("service_name_numerator").trim());
			numeratorKPIMap.put("from_date", map.get("from_date").trim());
			numeratorKPIMap.put("end_date", map.get("end_date").trim());

			Message message = kpiServices.getcallAttemptsPerTrx(numeratorKPIMap, request, response);

			Object responseNumeratorObject = message.getObject();

			Map<String, Object> responseNumeratorMap = (Map<String, Object>) responseNumeratorObject;

			Float numerator = Float.parseFloat(responseNumeratorMap.get("data").toString());

			System.out.println("Numerator is " + numerator);

			LinkedHashMap<String, String> denominatorKPIMap = new LinkedHashMap<>();

			denominatorKPIMap.put("device_id", map.get("device_id").trim());
			denominatorKPIMap.put("data_source", map.get("data_source_denominator").trim());
			denominatorKPIMap.put("service_name", map.get("service_name_denominator").trim());
			denominatorKPIMap.put("from_date", map.get("from_date").trim());
			denominatorKPIMap.put("end_date", map.get("end_date").trim());

			Message messageDenominator = kpiServices.getcallAttemptsPerTrx(denominatorKPIMap, request, response);

			Object responseDenominatorObject = messageDenominator.getObject();

			Map<String, Object> responseDenominatorMap = (Map<String, Object>) responseDenominatorObject;

			Float denominator = Float.parseFloat(responseDenominatorMap.get("data").toString());

			System.out.println("Denominator is " + denominator);

			if (numerator == 0 || denominator == 0) {

				System.out.println("KPI not calculated either numerator is zero or denominator is zero");

				responseMap.put("data", "0");

			} else {

				double valueForKpi = numerator / denominator;

				responseMap.put("data", valueForKpi);

			}

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(true);

		} catch (Exception exception) {
			exception.printStackTrace();

			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);

		}

		return responseMessage;

	}

	public Message uplinkTbfBlockingRate(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {
		Message responseMessage = new Message();
		Map<String, Object> responseMap = new HashMap<>();

		try {
//			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& \n " + map);
			LinkedHashMap<String, String> numeratorKPI1Map = new LinkedHashMap<>();

			numeratorKPI1Map.put("device_id", map.get("device_id").trim());
			numeratorKPI1Map.put("data_source", map.get("data_source_numerator_1").trim());
			numeratorKPI1Map.put("service_name", map.get("service_name_numerator_1").trim());
			numeratorKPI1Map.put("from_date", map.get("from_date").trim());
			numeratorKPI1Map.put("end_date", map.get("end_date").trim());

			Message messageKPI1 = kpiServices.getcallAttemptsPerTrx(numeratorKPI1Map, request, response);

			Object responseNumeratorObjectKpi1 = messageKPI1.getObject();

			Map<String, Object> responseNumeratorMapKpi1 = (Map<String, Object>) responseNumeratorObjectKpi1;

			Float numeratorKpi1 = Float.parseFloat(responseNumeratorMapKpi1.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi1);

			LinkedHashMap<String, String> numeratorKPI2Map = new LinkedHashMap<>();

			numeratorKPI2Map.put("device_id", map.get("device_id").trim());
			numeratorKPI2Map.put("data_source", map.get("data_source_numerator_2").trim());
			numeratorKPI2Map.put("service_name", map.get("service_name_numerator_2").trim());
			numeratorKPI2Map.put("from_date", map.get("from_date").trim());
			numeratorKPI2Map.put("end_date", map.get("end_date").trim());

			Message messageKPI2 = kpiServices.getcallAttemptsPerTrx(numeratorKPI2Map, request, response);

			Object responseNumeratorObjectKpi2 = messageKPI2.getObject();

			Map<String, Object> responseNumeratorMapKpi2 = (Map<String, Object>) responseNumeratorObjectKpi2;

			Float numeratorKpi2 = Float.parseFloat(responseNumeratorMapKpi2.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi2);

			Float numerator = numeratorKpi1 + numeratorKpi2;

			System.out.println("Final Numerator value" + numerator);

			LinkedHashMap<String, String> denominatorKPI1Map = new LinkedHashMap<>();

			denominatorKPI1Map.put("device_id", map.get("device_id").trim());
			denominatorKPI1Map.put("data_source", map.get("data_source_denominator_1").trim());
			denominatorKPI1Map.put("service_name", map.get("service_name_denominator_1").trim());
			denominatorKPI1Map.put("from_date", map.get("from_date").trim());
			denominatorKPI1Map.put("end_date", map.get("end_date").trim());

			Message messageDenominatorKpi1 = kpiServices.getcallAttemptsPerTrx(denominatorKPI1Map, request, response);

			Object responseDenominatorObjectKpi1 = messageDenominatorKpi1.getObject();

			Map<String, Object> responseDenominatorMapKpi1 = (Map<String, Object>) responseDenominatorObjectKpi1;

			Float denominatorKpi1 = Float.parseFloat(responseDenominatorMapKpi1.get("data").toString());

			System.out.println("Denominator is " + denominatorKpi1);

			LinkedHashMap<String, String> denominatorKPI2Map = new LinkedHashMap<>();

			denominatorKPI2Map.put("device_id", map.get("device_id").trim());
			denominatorKPI2Map.put("data_source", map.get("data_source_denominator_2").trim());
			denominatorKPI2Map.put("service_name", map.get("service_name_denominator_2").trim());
			denominatorKPI2Map.put("from_date", map.get("from_date").trim());
			denominatorKPI2Map.put("end_date", map.get("end_date").trim());

			Message messageDenominatorKpi2 = kpiServices.getcallAttemptsPerTrx(denominatorKPI2Map, request, response);

			Object responseDenominatorObjectKpi2 = messageDenominatorKpi2.getObject();

			Map<String, Object> responseDenominatorMapKpi2 = (Map<String, Object>) responseDenominatorObjectKpi2;

			Float denominatorKpi2 = Float.parseFloat(responseDenominatorMapKpi2.get("data").toString());

			System.out.println("Denominator is " + denominatorKpi2);

			Float denominator = denominatorKpi1 + denominatorKpi2;

			if (numerator == 0.0 || denominator == 0.0) {

				System.out.println("KPI not calculated either numerator is zero or denominator is zero");

				responseMap.put("data", "0");

			} else {

				Float valueForKpi = numerator / denominator;

				Float KpiValue = 1 - valueForKpi;

				responseMap.put("data", KpiValue);

			}

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(true);

		} catch (Exception exception) {
			exception.printStackTrace();

			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);

		}

		return responseMessage;
	}

	public Message gprsUplinkTbfBlockingRate(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();

		Map<String, Object> responseMap = new HashMap<>();

		try {

			LinkedHashMap<String, String> numeratorKPI1Map = new LinkedHashMap<>();

			numeratorKPI1Map.put("device_id", map.get("device_id").trim());
			numeratorKPI1Map.put("data_source", map.get("data_source").trim());
			numeratorKPI1Map.put("service_name", map.get("service_name_numerator_1").trim());
			numeratorKPI1Map.put("from_date", map.get("from_date").trim());
			numeratorKPI1Map.put("end_date", map.get("end_date").trim());

			Message messageKPI1 = kpiServices.getcallAttemptsPerTrx(numeratorKPI1Map, request, response);

			Object responseNumeratorObjectKpi1 = messageKPI1.getObject();

			Map<String, Object> responseNumeratorMapKpi1 = (Map<String, Object>) responseNumeratorObjectKpi1;

			Float numeratorKpi1 = Float.parseFloat(responseNumeratorMapKpi1.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi1);

			LinkedHashMap<String, String> numeratorKPI2Map = new LinkedHashMap<>();

			numeratorKPI2Map.put("device_id", map.get("device_id").trim());
			numeratorKPI2Map.put("data_source", map.get("data_source").trim());
			numeratorKPI2Map.put("service_name", map.get("service_name_numerator_2").trim());
			numeratorKPI2Map.put("from_date", map.get("from_date").trim());
			numeratorKPI2Map.put("end_date", map.get("end_date").trim());

			Message messageKPI2 = kpiServices.getcallAttemptsPerTrx(numeratorKPI2Map, request, response);

			Object responseNumeratorObjectKpi2 = messageKPI2.getObject();

			Map<String, Object> responseNumeratorMapKpi2 = (Map<String, Object>) responseNumeratorObjectKpi2;

			Float numeratorKpi2 = Float.parseFloat(responseNumeratorMapKpi2.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi2);

			Float numeratorKpi12 = numeratorKpi1 + numeratorKpi2;

			System.out.println("Final Numerator value of first two service name" + numeratorKpi12);

			LinkedHashMap<String, String> numeratorKPI3Map = new LinkedHashMap<>();

			numeratorKPI3Map.put("device_id", map.get("device_id").trim());
			numeratorKPI3Map.put("data_source", map.get("data_source").trim());
			numeratorKPI3Map.put("service_name", map.get("service_name_numerator_3").trim());
			numeratorKPI3Map.put("from_date", map.get("from_date").trim());
			numeratorKPI3Map.put("end_date", map.get("end_date").trim());

			Message messageKPI3 = kpiServices.getcallAttemptsPerTrx(numeratorKPI3Map, request, response);

			Object responseNumeratorObjectKpi3 = messageKPI3.getObject();

			Map<String, Object> responseNumeratorMapKpi3 = (Map<String, Object>) responseNumeratorObjectKpi3;

			Float numeratorKpi3 = Float.parseFloat(responseNumeratorMapKpi3.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi3);

			LinkedHashMap<String, String> numeratorKPI4Map = new LinkedHashMap<>();

			numeratorKPI4Map.put("device_id", map.get("device_id").trim());
			numeratorKPI4Map.put("data_source", map.get("data_source").trim());
			numeratorKPI4Map.put("service_name", map.get("service_name_numerator_4").trim());
			numeratorKPI4Map.put("from_date", map.get("from_date").trim());
			numeratorKPI4Map.put("end_date", map.get("end_date").trim());

			Message messageKPI4 = kpiServices.getcallAttemptsPerTrx(numeratorKPI4Map, request, response);

			Object responseNumeratorObjectKpi4 = messageKPI4.getObject();

			Map<String, Object> responseNumeratorMapKpi4 = (Map<String, Object>) responseNumeratorObjectKpi4;

			Float numeratorKpi4 = Float.parseFloat(responseNumeratorMapKpi4.get("data").toString());

			System.out.println("Numerator is " + numeratorKpi4);

			Float numeratorKpi34 = numeratorKpi3 + numeratorKpi4;

			System.out.println("Numerator value of last 2 service name" + numeratorKpi34);

			Float numerator = numeratorKpi12 - numeratorKpi34;

			System.out.println("Final Numerator value is" + numerator);

			LinkedHashMap<String, String> denominatorKPI1Map = new LinkedHashMap<>();

			denominatorKPI1Map.put("device_id", map.get("device_id").trim());
			denominatorKPI1Map.put("data_source", map.get("data_source").trim());
			denominatorKPI1Map.put("service_name", map.get("service_name_denominator_1").trim());
			denominatorKPI1Map.put("from_date", map.get("from_date").trim());
			denominatorKPI1Map.put("end_date", map.get("end_date").trim());

			Message messageDenominatorKpi1 = kpiServices.getcallAttemptsPerTrx(denominatorKPI1Map, request, response);

			Object responseDenominatorObjectKpi1 = messageDenominatorKpi1.getObject();

			Map<String, Object> responseDenominatorMapKpi1 = (Map<String, Object>) responseDenominatorObjectKpi1;

			Float denominatorKpi1 = Float.parseFloat(responseDenominatorMapKpi1.get("data").toString());

			System.out.println("Denominator is " + denominatorKpi1);

			LinkedHashMap<String, String> denominatorKPI2Map = new LinkedHashMap<>();

			denominatorKPI2Map.put("device_id", map.get("device_id").trim());
			denominatorKPI2Map.put("data_source", map.get("data_source").trim());
			denominatorKPI2Map.put("service_name", map.get("service_name_denominator_2").trim());
			denominatorKPI2Map.put("from_date", map.get("from_date").trim());
			denominatorKPI2Map.put("end_date", map.get("end_date").trim());

			Message messageDenominatorKpi2 = kpiServices.getcallAttemptsPerTrx(denominatorKPI2Map, request, response);

			Object responseDenominatorObjectKpi2 = messageDenominatorKpi2.getObject();

			Map<String, Object> responseDenominatorMapKpi2 = (Map<String, Object>) responseDenominatorObjectKpi2;

			Float denominatorKpi2 = Float.parseFloat(responseDenominatorMapKpi2.get("data").toString());

			System.out.println("Denominator is " + denominatorKpi2);

			Float denominator = denominatorKpi1 + denominatorKpi2;

			if (numerator == 0.0 || denominator == 0.0) {

				System.out.println("KPI not calculated either numerator is zero or denominator is zero");

				responseMap.put("data", "0");

			} else {

				Float valueForKpi = numerator / denominator;

				responseMap.put("data", valueForKpi);

			}

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(true);

		} catch (Exception exception) {
			exception.printStackTrace();

			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);

		}

		return responseMessage;
	}

	public Message totalVoiceCallMinutesPerBTS(Map<String, String> map, HttpServletRequest request,
			HttpServletResponse response) {

		Message responseMessage = new Message();

		Map<String, Object> responseMap = new HashMap<>();

		try {

			Message message = kpiServices.getcallAttemptsPerTrx(map, request, response);

			Object responseNumeratorObject = message.getObject();

			Map<String, Object> responseMapKPI = (Map<String, Object>) responseNumeratorObject;

			Float numeratorValue = Float.parseFloat(responseMapKPI.get("data").toString());

			System.out.println("Numerator is " + numeratorValue);

			if (numeratorValue == 0.0) {

				System.out.println("KPI not calculated either numerator is zero or denominator is zero");

				responseMap.put("data", "0");

			} else {

				Float valueKPI = numeratorValue / 60;

				double valueForKPI = valueKPI * 0.48;

				responseMap.put("data", valueForKPI);
			}

			responseMessage.setDescription("Process Success");
			responseMessage.setObject(responseMap);
			responseMessage.setValid(true);

		} catch (Exception exception) {
			exception.printStackTrace();

			responseMessage.setDescription("Process Fail");
			responseMessage.setValid(false);
		}
		return responseMessage;
	}

}
