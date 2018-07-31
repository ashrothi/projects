package com.teramatrix.processData;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import com.teramatrix.initiator.ReportInitiator;
import com.teramatrix.logger.HfclLogger;
import com.teramatrix.main.HfclEscalationApp;

/**
 * This class is used to calculate KPi of PCU tag , initially all methods get
 * the device Id and plateform data in there parameter to calculate the KPI
 * values
 * 
 * @author Pooja singh
 * @since 11.may.2018
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class BTS implements ReportInitiator {

	static final GetData getData = new GetData();
	static final String tag = "BTS";

	@Override
	public void initial(String deviceId, Map<String, Object> platformData) {
		StartTime(deviceId, platformData);
		EndTime(deviceId, platformData);
		DeviceName(deviceId, platformData);
		CellID(deviceId, platformData);
		IPAddress(deviceId, platformData);
		BSCName(deviceId, platformData);
		CallSetupSuccessRate(deviceId, platformData);
		CallSetupSuccessRateNR(deviceId, platformData);
		CallSetupSuccessRateDR(deviceId, platformData);
		CallSuccessRate(deviceId, platformData);
		CallSuccessRateNR(deviceId, platformData);
		CallSuccessRateDR(deviceId, platformData);
		CSErlangs(deviceId, platformData);
		LCLSCSErlangs(deviceId, platformData);
		TotalChannelDrops(deviceId, platformData);
		SDCCHDropCount(deviceId, platformData);
		SDCCHDropRate(deviceId, platformData);
		SDCCHDropRateNR(deviceId, platformData);
		SDCCHDropRateDR(deviceId, platformData);
		TCHDropCount(deviceId, platformData);
		TCHDropRate(deviceId, platformData);
		TCHDropRateNR(deviceId, platformData);
		TCHDropRateDR(deviceId, platformData);
		TCHDropRatePrime(deviceId, platformData);
		TCHDropRatePrimeNR(deviceId, platformData);
		TCHDropRatePrimeDR(deviceId, platformData);
		ImmediateAssignmentProcedureSuccessRate(deviceId, platformData);
		ImmediateAssignmentProcedureSuccessRateNR(deviceId, platformData);
		ImmediateAssignmentProcedureSuccessRateDR(deviceId, platformData);
		SDCCHBlockingCount(deviceId, platformData);
		SDCCHBlockingRate(deviceId, platformData);
		SDCCHBlockingRateNR(deviceId, platformData);
		SDCCHBlockingRateDR(deviceId, platformData);
		TCHBlockingCount(deviceId, platformData);
		TCHBlockingRate(deviceId, platformData);
		TCHBlockingRateNR(deviceId, platformData);
		TCHBlockingRateDR(deviceId, platformData);
		NumberOfTchfAttempts(deviceId, platformData);
		NumberOfTchfSuccess(deviceId, platformData);
		NumberOfTchhAttempts(deviceId, platformData);
		NumberOfTchhSuccess(deviceId, platformData);
		NumberOfSDCCHAssignmentAttempts(deviceId, platformData);
		NumberOfSuccessfulSDCCHAssignments(deviceId, platformData);
		ExternalHandoverSuccessRate(deviceId, platformData);
		ExternalHandoverSuccessRateNR(deviceId, platformData);
		ExternalHandoverSuccessRateDR(deviceId, platformData);
		InternalHandoverSuccessRate(deviceId, platformData);
		InternalHandoverSuccessRateNR(deviceId, platformData);
		InternalHandoverSuccessRateDR(deviceId, platformData);
		InternalHandoverSuccessRatePrime(deviceId, platformData);
		InternalHandoverSuccessRatePrimeNR(deviceId, platformData);
		InternalHandoverSuccessRatePrimeDR(deviceId, platformData);
		TotalVoiceCallMinutes(deviceId, platformData);
		MeanHoldingTimeInSecs(deviceId, platformData);
		MeanHoldingTimeInSecsNR(deviceId, platformData);
		MeanHoldingTimeInSecsDR(deviceId, platformData);
		DLTCHRxQual0(deviceId, platformData);
		DLTCHRxQual1(deviceId, platformData);
		DLTCHRxQual2(deviceId, platformData);
		DLTCHRxQual3(deviceId, platformData);
		DLTCHRxQual4(deviceId, platformData);
		DLTCHRxQual5(deviceId, platformData);
		DLTCHRxQual6(deviceId, platformData);
		DLTCHRxQual7(deviceId, platformData);
		ULTCHRxQual0(deviceId, platformData);
		ULTCHRxQual1(deviceId, platformData);
		ULTCHRxQual2(deviceId, platformData);
		ULTCHRxQual3(deviceId, platformData);
		ULTCHRxQual4(deviceId, platformData);
		ULTCHRxQual5(deviceId, platformData);
		ULTCHRxQual6(deviceId, platformData);
		ULTCHRxQual7(deviceId, platformData);
		ULTCHRxQual0To5Percent(deviceId, platformData);
		DLTCHRxQual0To5Percent(deviceId, platformData);
		SDCCH8BlockingCount(deviceId, platformData);
		NumberOfRadioConnectionFailuresSDCCH4(deviceId, platformData);
		NumberOfRadioConnectionFailuresSDCCH8(deviceId, platformData);
		NumberOfRadioConnectionFailuresTCHH(deviceId, platformData);
		NumberOfRadioConnectionFailuresTCHF(deviceId, platformData);
		NumberOfSDCCH4AssignmentAttempts(deviceId, platformData);
		NumberOfSDCCH4AssignmentSuccess(deviceId, platformData);
		NumberOfSDCCH8AssignmentAttempts(deviceId, platformData);
		NumberOfSDCCH8AssignmentSuccess(deviceId, platformData);
		SDCCH4BlockingCount(deviceId, platformData);
		TCHHBlockingCount(deviceId, platformData);
		TCHFBlockingCount(deviceId, platformData);
		NumberOfPagingAttempts(deviceId, platformData);
		PercentSmartPages(deviceId, platformData);
		PercentSmartPagesNR(deviceId, platformData);
		PercentSmartPagesDR(deviceId, platformData);
		SmartPagingSuccessRate(deviceId, platformData);
		SmartPagingSuccessRateNR(deviceId, platformData);
		SmartPagingSuccessRateDR(deviceId, platformData);
		NumberOfEmergencyCalls(deviceId, platformData);
		NumberOfLocationUpdates(deviceId, platformData);
		TotalNumberOfCalls(deviceId, platformData);
		ExternalHandInSuccessRate(deviceId, platformData);
		ExternalHandInSuccessRateNR(deviceId, platformData);
		ExternalHandInSuccessRateDR(deviceId, platformData);

	}

	/*
	 *
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch.n.bm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch.n.lm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch4.n.bm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch4.n.lm +
	 * geranBscBtsHandoverSuccessCount.< all neighbours>.n
	 * 
	 * Denominator : Service_name = (geranBscTrxSubsequentAssignmentSuccessCount
	 * 'geranBscBtsHandoverSuccessCount_neighbts')
	 * 
	 * Data_source in [sdcch_lm, sdcch4_lm,sdcch_bm, sdcch4_bm,
	 * 'internal_neighbour','external_neighbour' ]
	 * 
	 */
	private void TCHDropRatePrimeDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate Prime -DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate Prime -DR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate Prime -DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TCH Drop Rate Prime = 100 * (geranBscTrxNumRadioConnectionFailures.n.bm +
	 * geranBscTrxNumRadioConnectionFailures.n.lm) Numerator : service_name in
	 * ('geranBscTrxNumRadioConnectionFailures') data_source in ('bm','lm') ]
	 * 
	 */
	private void TCHDropRatePrimeNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 100
					* (Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString())
							+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString()));

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate Prime -NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate Prime -NR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate Prime -NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TCH Drop Rate Prime = 100 * (geranBscTrxNumRadioConnectionFailures.n.bm +
	 * geranBscTrxNumRadioConnectionFailures.n.lm)
	 * ------------------------------------------------------------------------- ---
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch.n.bm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch.n.lm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch4.n.bm +
	 * geranBscTrxSubsequentAssignmentSuccessCount.n.sdcch4.n.lm +
	 * geranBscBtsHandoverSuccessCount.< all neighbours>.n
	 * 
	 * Numerator : service_name in ('geranBscTrxNumRadioConnectionFailures')
	 * data_source in ('bm','lm')
	 * 
	 * Denominator : Service_name = (geranBscTrxSubsequentAssignmentSuccessCount
	 * 'geranBscBtsHandoverSuccessCount_neighbts')
	 * 
	 * Data_source in [sdcch_lm, sdcch4_lm,sdcch_bm, sdcch4_bm,
	 * 'internal_neighbour','external_neighbour' ]
	 * 
	 */
	private void TCHDropRatePrime(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = 100 * (Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString()));

			double DR = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate Prime",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate Prime", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate Prime KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	// This method is used to get the start time of crone
	private void StartTime(String deviceId, Map<String, Object> platformData) {
		try {
			String startTime = HfclEscalationApp.beforeTime;

			long finaldata = Long.parseLong(startTime);

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "StartTime", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "StartTime", deviceId, tag);
			}

			HfclLogger.logger.info("Start Time KPI value : " + startTime);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	// This method is used to get the end time of crone
	private void EndTime(String deviceId, Map<String, Object> platformData) {
		try {
			long EndTime = HfclEscalationApp.currentTime;

			if (EndTime != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(EndTime)), "End Time", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "End Time", deviceId, tag);
			}

			HfclLogger.logger.info("End Time KPI value : " + EndTime);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	private void DeviceName(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void CellID(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void IPAddress(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void BSCName(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	/*
	 * This formula calculates the ratio of subsequent assignments to a traffic
	 * channel which succeed.
	 * 
	 * CallSetupSuccessRateBts = ΣgeranBscTrxSubsequentAssignmentSuccessCount
	 * ΣgeranBscTrxSubsequentAssignmentCommandCount condition
	 * 
	 * geranBscTrxSrcTei ∋ BTS geranBscTrxSrcChannelType = sdcch,sdcch4
	 * geranBscTrxDstTei ∋ BTS geranBscTrxDstChannelType = BM,LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentSuccessCount
	 * / geranBscTrxSubsequentAssignmentCommandCount Data_source in [sdcch_lm,
	 * sdcch4_lm,sdcch_bm, sdcch4_bm]
	 * 
	 */
	private void CallSetupSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			//
			double NR = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString());
			double DR = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_bm_sum").toString());

//			System.out.println(NR + "***************************************" + DR);
			double finaldata = (NR / DR)*100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Call Setup Success Rate",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Setup Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Call Setup Success Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This formula calculates the numerator of traffic channel which succeed.
	 * 
	 * CallSetupSuccessRateBtsNR = ΣgeranBscTrxSubsequentAssignmentSuccessCount
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentSuccessCount
	 * Data_source in [sdcch_lm, sdcch4_lm,sdcch_bm, sdcch4_bm]
	 */
	private void CallSetupSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Call Setup Success Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Setup Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Call Setup Success Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This formula calculates the ratio of subsequent assignments to a traffic
	 * channel which succeed.
	 * 
	 * CallSetupSuccessRateBtsDR = ΣgeranBscTrxSubsequentAssignmentCommandCount
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentCommandCount
	 * Data_source in [sdcch_lm, sdcch4_lm,sdcch_bm, sdcch4_bm]
	 * 
	 */
	private void CallSetupSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_bm_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Call Setup Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Setup Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Call Setup Success Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 100 - (100 * callDropRateNR / callDropRateDR) callDropRateNR =
	 * handoverT3103InternalTimeout + handoverT3103ExternalTimeout +
	 * handoverT8InternalTimeout + handoverT8ExternalTimeout + radioConnFailure
	 * 
	 * service_name in ('geranBscBtsChannelHandoverT3103TimeoutCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts'
	 * ,'geranBscTrxNumRadioConnectionFailures') data_source in
	 * ('internal_neighbour_lm', 'internal_neighbour_bm', 'external_neighbour_lm',
	 * 'external_neighbour_bm', 'internal_neighbour_lm', 'internal_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm', 'bm','lm')
	 * 
	 * callDropRateDR = geranBscTrxSubsequentAssignmentSuccessCount.<cell_id>.(sdcch
	 * and sdcch4).<cell_id>.(bm and lm) + handoverInExternalSuccessCount +
	 * handoverInInternalSuccessCount
	 * 
	 * service_name in ( 'geranBscTrxSubsequentAssignmentSuccessCount',
	 * 'geranBscBtsHandoverSuccessCount_neighbts') data_source in
	 * ('internal_neighbour','external_neighbour','sdcch_lm',
	 * 'sdcch4_lm','sdcch_bm', 'sdcch4_bm')
	 */
	private void CallSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString());

			double DR = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString());

			double finaldata = 100 - (100 * NR / DR);
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Call Success Rate", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Call Success Rate KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * service_name in ('geranBscBtsChannelHandoverT3103TimeoutCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts'
	 * ,'geranBscTrxNumRadioConnectionFailures')
	 * 
	 * data_source in ('internal_neighbour_lm', 'internal_neighbour_bm',
	 * 'external_neighbour_lm', 'external_neighbour_bm', 'internal_neighbour_lm',
	 * 'internal_neighbour_bm', 'external_neighbour_lm','external_neighbour_bm',
	 * 'bm','lm')
	 */
	private void CallSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Call Success Rate - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Call Success Rate - NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SUM service_name in ( 'geranBscBtsHandoverSuccessCount_neighbts',
	 * 'geranBscTrxSubsequentAssignmentSuccessCount' , )
	 * 
	 * data_source in ('internal_neighbour','external_neighbour',
	 * 'sdcch_bm','sdcch4_bm','sdcch_lm','sdcch4_lm')
	 * 
	 */
	private void CallSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Call Success Rate - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Call Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Call Success Rate - DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * CS Erlangs per BTS = Σ geranBscTrxNumMeasurementReports * 0.48
	 * 
	 * -------------------------------------------------------------------------
	 * ---- 3600 60 * 24
	 * 
	 * condition = geranBscTrxTei ∋ BTS geranBscTrxChannelType = BM, LM
	 * 
	 * Service : geranBscTrxNumMeasurementReports Ds : lm , bm
	 */
	private void CSErlangs(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = ((Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_bm_sum").toString())) * 0.48) / 3600;

			double finaldata = NR ;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "CS Erlangs", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "CS Erlangs", deviceId, tag);
			}

			HfclLogger.logger.info("CS Erlangs KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * LCLS CS Erlangs = Σ geranBscTrxNumMeasurementReportsLcls * 0.48/ 3600
	 * 
	 * condition = geranBscTrxTei ∋ BTS geranBscTrxChannelType = BM, LM
	 * 
	 * Service : geranBscTrxNumMeasurementReportsLcls Ds : lm , bm
	 * 
	 */
	private void LCLSCSErlangs(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = (Double.parseDouble(map.get("geranBscTrxNumMeasurementReportsLcls_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumMeasurementReportsLcls_lm_sum").toString())) * 0.48
					/ 3600;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "LCLS CS Erlangs", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "LCLS CS Erlangs", deviceId, tag);
			}

			HfclLogger.logger.info("LCLS CS Erlangs KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This provides a count of all dedicated channels between a BTS and mobile that
	 * are dropped due to the radio link. Total Channel Drops =
	 * Σ(geranBscTrxNumRadioConnectionFailures) +
	 * Σ(geranBscBtsHandoverT3103TimeoutCount + geranBscBtsHandoverT8TimeoutCount)
	 * 
	 * Condition 1 = geranBscTrxTei ∋ TEI in BTS, geranBscTrxChannelType = LM, BM,
	 * sdcch, sdcch4 Condition 2 = geranBscBtsCellId = BTS Cell ID,
	 * geranBscBtsNeighCellId ∋ Neighbor Cell IDs
	 * 
	 * service_name in ('geranBscBtsChannelHandoverT3103TimeoutCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts'
	 * ,'geranBscTrxNumRadioConnectionFailures')
	 * 
	 * data_source in ('internal_neighbour_lm','internal_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm','internal_neighbour_lm','
	 * internal_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm','bm','lm','sdcch','sdcch4 ')
	 */
	private void TotalChannelDrops(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Total Channel Drops",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Channel Drops", deviceId, tag);
			}

			HfclLogger.logger.info("Total Channel Drops KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * NumDroppedSdcchBts = Σ geranBscTrxNumRadioConnectionFailures Condition :
	 * geranBscTrxTei BTS geranBscTrxChannelType=sdcch,sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumRadioConnectionFailures
	 * Data_source in [sdcch,sdcch4]
	 */
	private void SDCCHDropCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Drop Count", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Drop Count", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Drop Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	/*
	 * This reports the percentage of mobiles that are dropped from a SDCCH channel
	 * on a BTS after successfully initiating a SDCCH channel on the BTS.
	 * 
	 * SDCCH Drop Rate Per BTS = ΣgeranBscTrxNumRadioConnectionFailures /
	 * ΣgeranBscTrxImmAssignmentSuccessCount
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = BM
	 * 
	 * Device_type = BTS Service_name(Numerator) =
	 * geranBscTrxNumRadioConnectionFailures Data_source(Numerator) in [sdcch,
	 * sdcch4] Service_name(Denominator) = geranBscTrxImmAssignmentSuccessCount
	 * Data_source(Denominator) in [sdcch, sdcch4]
	 */
	private void SDCCHDropRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());
			double DR = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());
			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Drop Rate", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Drop Rate", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Drop Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SDCCH Drop Rate Per BTS(NR) = ΣgeranBscTrxNumRadioConnectionFailures
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID
	 * 
	 * Device_type = BTS Service_name(Numerator) =
	 * geranBscTrxNumRadioConnectionFailures Data_source(Numerator) in [sdcch,
	 * sdcch4]
	 */
	private void SDCCHDropRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Drop Rate - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Drop Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Drop Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SDCCH Drop Rate Per BTS(DR) = ΣgeranBscTrxImmAssignmentSuccessCount
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID
	 * 
	 * Device_type = BTS Service_name(Numerator) =
	 * geranBscTrxImmAssignmentSuccessCount Data_source(Numerator) in [sdcch,
	 * sdcch4]
	 */
	private void SDCCHDropRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Drop Rate - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Drop Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Drop Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SUM :- service_name in ('geranBscBtsChannelHandoverT3103TimeoutCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts'
	 * ,'geranBscTrxNumRadioConnectionFailures')
	 * 
	 * data_source in ('internal_neighbour_lm','internal_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm','internal_neighbour_lm','
	 * internal_neighbour_bm', '
	 * external_neighbour_lm','external_neighbour_bm','bm','lm')
	 */
	private void TCHDropCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Count ", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Count ", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Count KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TCH Drop Rate
	 * 
	 * SUM :- service_name in ('geranBscBtsChannelHandoverT3103TimeoutCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts','
	 * geranBscTrxNumRadioConnectionFailures') and data_source in
	 * ('internal_neighbour_bm', internal_neighbour_lm', 'external_neighbour_lm',
	 * 'external_neighbour_bm', 'internal_neighbour_bm', 'internal_neighbour_lm',
	 * 'external_neighbour_lm', 'external_neighbour_bm','lm','bm')
	 */
	private void TCHDropRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_external_neighbour_bm_sum")
									.toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_internal_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SUM service_name in ('geranBscTrxNumRadioConnectionFailures') and data_source
	 * in ('lm','bm')
	 */
	private void TCHDropRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate - NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SUM service_name in ( 'geranBscTrxSubsequentAssignmentSuccessCount',
	 * 'geranBscBtsHandoverSuccessCount_neighbts')
	 * 
	 * data_source in ('internal_neighbour','external_neighbour','sdcch_lm',
	 * 'sdcch4_lm','sdcch_bm', 'sdcch4_bm')
	 */
	private void TCHDropRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Drop Rate - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Drop Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Drop Rate - DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * ImmAssignProcSuccRateBts = ΣgeranBscTrxImmAssignmentSuccessCount /
	 * ΣgeranBscTrxImmAssignmentCommandCount
	 * 
	 * condition : geranBscTrxChannelType = sdcch, sdcch4 geranBscTrxTei ∋ BTS
	 * 
	 * Num : geranBscTrxImmAssignmentSuccessCount Ds : sdcch, sdcch4
	 * 
	 * Denominator : geranBscTrxImmAssignmentCommandCount ,
	 * geranBscTrxImmAssignmentCommandCount Ds : sdcch, sdcch4
	 */

	private void ImmediateAssignmentProcedureSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch4_sum").toString());
			double DR = Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch4_sum").toString());
			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Immediate Assignment Procedure Success Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Immediate Assignment Procedure Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Immediate Assignment Procedure Success Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * ImmAssignProcSuccRateBtsNR = ΣgeranBscTrxImmAssignmentSuccessCount
	 * 
	 * condition : geranBscTrxChannelType = sdcch, sdcch4 geranBscTrxTei ∋ BTS
	 * 
	 * Num : geranBscTrxImmAssignmentSuccessCount Ds : sdcch, sdcch4
	 */
	private void ImmediateAssignmentProcedureSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch4_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Immediate Assignment Procedure Success Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Immediate Assignment Procedure Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Immediate Assignment Procedure Success Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * ImmAssignProcSuccRateBts = ΣgeranBscTrxImmAssignmentCommandCount
	 * 
	 * condition : geranBscTrxChannelType = sdcch, sdcch4 geranBscTrxTei ∋ BTS
	 * 
	 * Denominator : geranBscTrxImmAssignmentCommandCount ,
	 * geranBscTrxImmAssignmentCommandCount Ds : sdcch, sdcch4
	 */
	private void ImmediateAssignmentProcedureSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch4_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Immediate Assignment Procedure Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Immediate Assignment Procedure Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Immediate Assignment Procedure Success Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI provides the number of times a mobile tried to start a dedicated
	 * signaling channel but were blocked because the BTS had no available signaling
	 * channels due to congestion. SDCCH Blocking Count = Σ
	 * (geranBscBtsChannelBlockingCount)
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = sdcch,
	 * sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [sdcch, sdcch4]
	 */
	private void SDCCHBlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_sdcch4_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPIs tracks the number of SDCCH attempts that fail due to RF resources
	 * being unavailable.
	 * 
	 * SDCCHBlockingRate = ΣgeranBscBtsImmAssignmentRejectCount/
	 * ΣgeranBscBtsImmAssignmentCommandCount
	 * 
	 * Condition: geranBscBtsCellId = BTS geranBtsChannelRequestCause =
	 * emergency,answerPaging,CallOriginate,locUpd
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranBscBtsImmAssignmentRejectCount_answerPaging,
	 * geranBscBtsImmAssignmentRejectCount_callOriginate,
	 * geranBscBtsImmAssignmentRejectCount_emergency,
	 * geranBscBtsImmAssignmentRejectCount_locUpd ]
	 * 
	 * Data_source(Numerator) in [ geranBscBtsImmAssignmentRejectCount_answerPaging,
	 * geranBscBtsImmAssignmentRejectCount_callOriginate,
	 * geranBscBtsImmAssignmentRejectCount_emergency,
	 * geranBscBtsImmAssignmentRejectCount_locUpd ]
	 ** 
	 * Service_name(Denominator) in [
	 * geranBscBtsImmAssignmentCommandCount_answerPaging,
	 * geranBscBtsImmAssignmentCommandCount_callOriginate,
	 * geranBscBtsImmAssignmentCommandCount_emergency,
	 * geranBscBtsImmAssignmentCommandCount_locUpd ]
	 * 
	 * Data_source(Denominator) in [
	 * geranBscBtsImmAssignmentCommandCount_answerPaging,
	 * geranBscBtsImmAssignmentCommandCount_callOriginate,
	 * geranBscBtsImmAssignmentCommandCount_emergency,
	 * geranBscBtsImmAssignmentCommandCount_locUpd ]
	 ** 
	 * : consider 1 data_source per service_name
	 * 
	 */
	private void SDCCHBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = Double.parseDouble(map.get(
					"geranBscBtsImmAssignmentRejectCount_answerPaging_geranBscBtsImmAssignmentRejectCount_answerPaging_sum")
					.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_callOriginate_geranBscBtsImmAssignmentRejectCount_callOriginate_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_emergency_geranBscBtsImmAssignmentRejectCount_emergency_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_locUpd_geranBscBtsImmAssignmentRejectCount_locUpd_sum")
							.toString());

			double DR = Double.parseDouble(map.get(
					"geranBscBtsImmAssignmentCommandCount_answerPaging_geranBscBtsImmAssignmentCommandCount_answerPaging_sum")
					.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_callOriginate_geranBscBtsImmAssignmentCommandCount_callOriginate_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_emergency_geranBscBtsImmAssignmentCommandCount_emergency_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_locUpd_geranBscBtsImmAssignmentCommandCount_locUpd_sum")
							.toString());
			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Blocking Rate",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Blocking Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SDCCH Blocking Rate - NR = ΣgeranBscBtsImmAssignmentRejectCount
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranBscBtsImmAssignmentRejectCount_answerPaging,
	 * geranBscBtsImmAssignmentRejectCount_callOriginate,
	 * geranBscBtsImmAssignmentRejectCount_emergency,
	 * geranBscBtsImmAssignmentRejectCount_locUpd ]
	 * 
	 * Data_source(Numerator) in [ geranBscBtsImmAssignmentRejectCount_answerPaging,
	 * geranBscBtsImmAssignmentRejectCount_callOriginate,
	 * geranBscBtsImmAssignmentRejectCount_emergency,
	 * geranBscBtsImmAssignmentRejectCount_locUpd ]
	 */
	private void SDCCHBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get(
					"geranBscBtsImmAssignmentRejectCount_answerPaging_geranBscBtsImmAssignmentRejectCount_answerPaging_sum")
					.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_callOriginate_geranBscBtsImmAssignmentRejectCount_callOriginate_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_emergency_geranBscBtsImmAssignmentRejectCount_emergency_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentRejectCount_locUpd_geranBscBtsImmAssignmentRejectCount_locUpd_sum")
							.toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Blocking Rate - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Blocking Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SDCCH Blocking Rate - DR = ΣgeranBscBtsImmAssignmentCommandCount
	 ** 
	 * Service_name(Denominator) in [
	 * geranBscBtsImmAssignmentCommandCount_answerPaging,
	 * geranBscBtsImmAssignmentCommandCount_callOriginate,
	 * geranBscBtsImmAssignmentCommandCount_emergency,
	 * geranBscBtsImmAssignmentCommandCount_locUpd ]
	 * 
	 * Data_source(Denominator) in [
	 * geranBscBtsImmAssignmentCommandCount_answerPaging,
	 * geranBscBtsImmAssignmentCommandCount_callOriginate,
	 * geranBscBtsImmAssignmentCommandCount_emergency,
	 * geranBscBtsImmAssignmentCommandCount_locUpd ]
	 */
	private void SDCCHBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get(
					"geranBscBtsImmAssignmentCommandCount_answerPaging_geranBscBtsImmAssignmentCommandCount_answerPaging_sum")
					.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_callOriginate_geranBscBtsImmAssignmentCommandCount_callOriginate_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_emergency_geranBscBtsImmAssignmentCommandCount_emergency_sum")
							.toString())
					+ Double.parseDouble(map.get(
							"geranBscBtsImmAssignmentCommandCount_locUpd_geranBscBtsImmAssignmentCommandCount_locUpd_sum")
							.toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH Blocking Rate - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH Blocking Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI provides the number of times a mobile tried to start a voice channel
	 * but were blocked because the BTS had no available voice channels due to
	 * congestion. TCH Blocking Count = Σ(geranBscBtsChannelBlockingCount) Condition
	 * = geranBscBtsCellId = BTS Cell ID, geranBscBtsChannelType = LM, BM
	 * 
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [ bm, lm]
	 * 
	 */
	private void TCHBlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * TchBlockingRateBts = Σ geranBscBtsChannelBlockingCount/ Σ
	 * geranBscBtsChannelBlockingCount + Σ
	 * geranBscTrxSubsequentAssignmentCommandCount
	 * 
	 * condition (geranBscBtsChannelBlockingCount) = geranBscBtsCellId = BTS
	 * geranBscBtsChannelType = BM,LM
	 * 
	 * condition (geranBscTrxSubsequentAssignmentCommandCount) = Num :
	 * geranBscBtsChannelBlockingCount Ds : bm , lm
	 * 
	 * Denominator : S1 : geranBscBtsChannelBlockingCount DS1 : bm, lm S2 :
	 * geranBscTrxSubsequentAssignmentCommandCount DS2 :
	 * sdcch_lm,sdcch_bm,sdcch4_lm,sdcch4_bm
	 */
	private void TCHBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString());

			double DR = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_bm_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Blocking Rate", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Blocking Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TCH Blocking Rate - NR = Σ geranBscBtsChannelBlockingCount
	 * 
	 * Num : geranBscBtsChannelBlockingCount Ds : bm , lm
	 */
	private void TCHBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Blocking Rate - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Blocking Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TCH Blocking Rate - DR = Σ geranBscBtsChannelBlockingCount + Σ
	 * geranBscTrxSubsequentAssignmentCommandCount
	 * 
	 * service : S1 : geranBscBtsChannelBlockingCount DS1 : bm, lm S2 :
	 * geranBscTrxSubsequentAssignmentCommandCount DS2
	 * :sdcch_lm,sdcch_bm,sdcch4_lm,sdcch4_bm
	 */
	private void TCHBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH Blocking Rate - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("TCH Blocking Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of attempts to reserve a full rate TCH for a
	 * voice call. NumTchFCallAttemptsTrx
	 * =ΣgeranBscTrxSubsequentAssignmentCommandCount
	 * 
	 * condition geranBscTrxSrcTei∋BTS geranBscTrxSrcChannelType = sdcch,sdcch4
	 * geranBscTrxDstTei = TRX geranBscTrxDstChannelType=BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentCommandCount
	 * Data_source in [sdcch_bm, sdcch4_bm]
	 */
	private void NumberOfTchfAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number of TCH-F Attempts Per TRX", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number of TCH-F Attempts Per TRX", deviceId, tag);
			}

			HfclLogger.logger.info("Number of TCH-F Attempts Per TRX KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of successful attempts to reserve a full
	 * rate TCH for a voice call. NumTchFCallSuccessTrx
	 * =ΣgeranBscTrxSubsequentAssignmentSuccessCount
	 * 
	 * condition geranBscTrxSrcTei ∋ BTS geranBscTrxSrcChannelType = sdcch,sdcch4
	 * geranBscTrxDstTei = TRX geranBscTrxDstChannelType = BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentSuccessCount
	 * Data_source in [sdcch_bm, sdcch4_bm]
	 */
	private void NumberOfTchfSuccess(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number of TCH-F Success per TRX", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number of TCH-F Success per TRX", deviceId, tag);
			}

			HfclLogger.logger.info("Number of TCH-F Success per TRX KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of attempts to reserve a half rate TCH for a
	 * voice call. NumTchHCallAttemptsTrx =Σ
	 * geranBscTrxSubsequentAssignmentCommandCount
	 * 
	 * condition geranBscTrxSrcTei∋BTS geranBscTrxSrcChannelType = sdcch,sdcch4
	 * geranBscTrxDstTei = TRX geranBscTrxDstChannelType= LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentCommandCount
	 * Data_source in [sdcch_lm, sdcch4_lm]
	 */
	private void NumberOfTchhAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentCommandCount_sdcch4_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number of TCH-H Attempts Per TRX", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number of TCH-H Attempts Per TRX", deviceId, tag);
			}

			HfclLogger.logger.info("Number of TCH-H Attempts Per TRX KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of successful attempts to reserve a half
	 * rate TCH for a voice call. NumTchHCallSuccessTrx
	 * =ΣgeranBscTrxSubsequentAssignmentSuccessCount
	 * 
	 * condition geranBscTrxSrcTei ∋ BTS geranBscTrxSrcChannelType = sdcch,sdcch4
	 * geranBscTrxDstTei = TRX geranBscTrxDstChannelType= LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentSuccessCount
	 * Data_source in [sdcch_lm, sdcch4_lm]
	 */
	private void NumberOfTchhSuccess(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number of TCH-H Success per TRX", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number of TCH-H Success per TRX", deviceId, tag);
			}

			HfclLogger.logger.info("Number of TCH-H Success per TRX KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of attempts to assign a mobile to a SDCCH.
	 * 
	 * NumSdcchAttemptsTrx = Σ geranBscTrxImmAssignmentCommandCount
	 * 
	 * condition geranBscTrxTei = TRX geranBscTrxChannelType=sdcch,sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentCommandCount
	 * Data_source in [sdcch, sdcch4]
	 */
	private void NumberOfSDCCHAssignmentAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of SDCCH Assignment Attempts", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of SDCCH Assignment Attempts", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of SDCCH Assignment Attempts KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of times a mobile is successfully assigned to a
	 * SDCCH.
	 * 
	 * NumSdcchSuccessTrx = Σ geranBscTrxImmAssignmentSuccessCount
	 * 
	 * Condition geranBtsTrxTei = TRX geranBscTrxChannelType=sdcch,sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentSuccessCount
	 * Data_source in [sdcch,sdcch4]
	 */
	private void NumberOfSuccessfulSDCCHAssignments(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of Successful SDCCH Assignments", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Successful SDCCH Assignments", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Successful SDCCH Assignments KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateExternalBts = 100 X Numerator/Denominator
	 * 
	 * Numerator =handoverOutExternalCommandCount - handoverOutExternalFailureCount
	 * - handoverT8ExternalTimeout
	 * 
	 * Service name : 'geranBscBtsChannelHandoverCommandCount_bts',
	 * 'geranBscBtsChannelHandoverFailureCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts' Data_source:
	 * 'external_neighbour_lm','external_neighbour_bm' ,
	 * 'external_neighbour_lm','external_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm'
	 * 
	 * Denominator = Σ geranBscBtsChannelHandoverCommandCount.<cell_id>.(for each
	 * external neighbor cell_id).(bm and lm)
	 * 
	 * Service name : 'geranBscBtsChannelHandoverCommandCount_bts' Data_source:
	 * 'external_neighbour_lm','external_neighbour_bm'
	 */
	private void ExternalHandoverSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = 100 * (Double.parseDouble(
					map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverFailureCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverFailureCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString()));

			double DR = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_bm_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External Handover Success Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External Handover Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("External Handover Success Rate KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateExternalBtsNR = 100 X Numerator
	 * 
	 * Numerator =handoverOutExternalCommandCount - handoverOutExternalFailureCount
	 * - handoverT8ExternalTimeout
	 * 
	 * Service name : 'geranBscBtsChannelHandoverCommandCount_bts',
	 * 'geranBscBtsChannelHandoverFailureCount_bts',
	 * 'geranBscBtsChannelHandoverT8TimeoutCount_bts' Data_source:
	 * 'external_neighbour_lm','external_neighbour_bm' ,
	 * 'external_neighbour_lm','external_neighbour_bm',
	 * 'external_neighbour_lm','external_neighbour_bm'
	 */
	private void ExternalHandoverSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 100 * (Double.parseDouble(
					map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverFailureCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverFailureCount_bts_external_neighbour_bm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsChannelHandoverT8TimeoutCount_bts_external_neighbour_bm_sum").toString()));

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External Handover Success Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External Handover Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("External Handover Success Rate - NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateExternalBtsDR = Denominator
	 * 
	 * Denominator = Σ geranBscBtsChannelHandoverCommandCount.<cell_id>.(for each
	 * external neighbor cell_id).(bm and lm)
	 * 
	 * Service name : 'geranBscBtsChannelHandoverCommandCount_bts' Data_source:
	 * 'external_neighbour_lm','external_neighbour_bm'
	 */
	private void ExternalHandoverSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverCommandCount_bts_external_neighbour_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External Handover Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External Handover Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("External Handover Success Rate - DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateInternalBts = 100 X numerator / Denominator
	 * 
	 * Numerator = Σ geranBscBtsHandoverSuccessCount.(for each internal neighbor
	 * cell_id).<cell_id> + Σ geranBscBtsHandoverSuccessCount.<cell_id>.(for each
	 * internal neighbor cell_id)
	 * 
	 * service_name in ( 'geranBscBtsHandoverSuccessCount_bts',
	 * 'geranBscBtsHandoverSuccessCount_neighbts')
	 * 
	 * data_source in ('internal_neighbour',’internal_neighbour’)
	 * 
	 * Denominator = ( Σ geranBscBtsHandoverCommandCount.<cell_id>.(for each
	 * internal neighbor cell_id) + Σ geranBscBtsHandoverCommandCount.(for each
	 * external neighbor cell_id).<cell_id>) / 2
	 * 
	 * Service_name in ('geranBscBtsHandoverCommandCount_neighbts',
	 * 'geranBscBtsHandoverCommandCount_bts')
	 * 
	 * data_source in ('Internal_neighbour', 'internal_neighbour')
	 */
	private void InternalHandoverSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = 100 * (Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_bts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString()));

			double DR = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateInternalBtsNR = 100 X numerator
	 * 
	 * Numerator = Σ geranBscBtsHandoverSuccessCount.(for each internal neighbor
	 * cell_id).<cell_id> + Σ geranBscBtsHandoverSuccessCount.<cell_id>.(for each
	 * internal neighbor cell_id)
	 * 
	 * service_name in ( 'geranBscBtsHandoverSuccessCount_bts',
	 * 'geranBscBtsHandoverSuccessCount_neighbts')
	 * 
	 * data_source in ('internal_neighbour',’internal_neighbour’)
	 */
	private void InternalHandoverSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 100 * (Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_bts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString()));

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate - NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * HandoverSuccessRateInternalBtsDR = Denominator
	 * 
	 * Denominator = ( Σ geranBscBtsHandoverCommandCount.<cell_id>.(for each
	 * internal neighbor cell_id) + Σ geranBscBtsHandoverCommandCount.(for each
	 * external neighbor cell_id).<cell_id>) / 2
	 * 
	 * Service_name in ('geranBscBtsHandoverCommandCount_neighbts',
	 * 'geranBscBtsHandoverCommandCount_bts')
	 * 
	 * data_source in ('Internal_neighbour', 'internal_neighbour')
	 */
	private void InternalHandoverSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate - DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Internal Handover Success Rate Prime = (100 * ΣInternal Handover Success Rate
	 * Prime NR /Σ Internal Handover Success Rate Prime DR)
	 * 
	 * =100 * [ Σ geranBscBtsHandoverCommandCount.<cell_id>.(for each internal
	 * neighbor cell_id)/2 - Σ
	 * geranBscBtsChannelHandoverT3103TimeoutCount.<cell_id>.(for each internal
	 * neighbor cell_id).(bm and lm)]
	 * -------------------------------------------------------------------------
	 * ------------------------------------------------- [Σ
	 * geranBscBtsHandoverCommandCount.<cell_id>.(for each internal neighbor
	 * cell_id) / 2]
	 * 
	 * Numerator: Service_name in ( 'geranBscBtsHandoverCommandCount_bts',
	 * ‘geranBscBtsChannelHandoverT3103TimeoutCount_bts’) data_source in
	 * ('internal_neighbour', 'internal_neighbour_lm', 'internal_neighbour_bm'’)
	 * 
	 * Denominator: Service_name in ( 'geranBscBtsHandoverCommandCount_bts')
	 * data_source in ('internal_neighbour')
	 */
	private void InternalHandoverSuccessRatePrime(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = 100 * (Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString()));

			double DR = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate Prime", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate Prime", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate Prime KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * Numerator: Service_name in ( 'geranBscBtsHandoverCommandCount_bts',
	 * ‘geranBscBtsChannelHandoverT3103TimeoutCount_bts’) data_source in
	 * ('internal_neighbour', 'internal_neighbour_lm', 'internal_neighbour_bm'’)
	 */
	private void InternalHandoverSuccessRatePrimeNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 100 * (Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_lm_sum")
									.toString())
					+ Double.parseDouble(
							map.get("geranBscBtsChannelHandoverT3103TimeoutCount_bts_internal_neighbour_bm_sum")
									.toString()));

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate Prime - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate Prime - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate Prime - NR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Denominator: Service_name in ('geranBscBtsHandoverCommandCount_bts')
	 * data_source in ('internal_neighbour')
	 */
	private void InternalHandoverSuccessRatePrimeDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_bts_internal_neighbour_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Internal Handover Success Rate Prime - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Internal Handover Success Rate Prime - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Internal Handover Success Rate Prime - DR KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI calculates the total duration of voice calls. Since the SDCCH
	 * establishment duration is very small (as compared to TCH), this will be an
	 * approximate measure of the total voice call time. The number 0.48 is used as
	 * measurement reports are received at the interval of 480ms.
	 * 
	 * Total Voice Call Minutes per BTS = ΣgeranBscTrxNumMeasurementReports
	 * Condition * 0.48 / 60
	 * 
	 * Condition: geranBscTrxTei = BTS geranBscTrxChannelType = BM, LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumMeasurementReports Data_source
	 * in [lm,bm]
	 */
	private void TotalVoiceCallMinutes(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_bm_sum").toString())) * 0.48 / 60;

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Total Voice Call Minutes",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Voice Call Minutes", deviceId, tag);
			}

			HfclLogger.logger.info("Total Voice Call Minutes KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Mean Holding Time In Secs = Numerator/Denominator
	 * 
	 * Numerator = 'geranBscTrxNumMeasurementReports' * 0.48 service_name in (
	 * 'geranBscTrxNumMeasurementReports') data_source in ('lm','bm')
	 * 
	 * Denominator = SUM ( 'geranBscTrxSubsequentAssignmentSuccessCount',
	 * 'geranBscBtsHandoverSuccessCount_neighbts' ,'geranBscTrxNumActiveChannels' )
	 * service_name in ( 'geranBscTrxSubsequentAssignmentSuccessCount',
	 * 'geranBscBtsHandoverSuccessCount_neighbts' ,'geranBscTrxNumActiveChannels' )
	 * data_source in ( 'sdcch_lm','sdcch_bm','sdcch4_lm','sdcch4_bm',
	 * 'internal_neighbour','external_neighbour' , 'bm','lm' )
	 * 
	 */
	private void MeanHoldingTimeInSecs(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = 0.48 * (Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_bm_sum").toString()));

			double DR = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumActiveChannels_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumActiveChannels_lm_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Mean Holding Time In Secs ",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Mean Holding Time In Secs ", deviceId, tag);
			}

			HfclLogger.logger.info("Mean Holding Time In Secs KPI value :" + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * kpi value = Total Voice Call Minutes The number 0.48 is used as measurement
	 * reports are received at the interval of 480ms.
	 * 
	 * Condition: geranBscTrxTei = BTS geranBscTrxChannelType = BM, LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumMeasurementReports Data_source
	 * in [lm,bm]
	 */
	private void MeanHoldingTimeInSecsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = 0.48 * (Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxNumMeasurementReports_bm_sum").toString()));

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Mean Holding Time In Secs - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Mean Holding Time In Secs - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Mean Holding Time In Secs - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * kpi value = noOfSuccessCalls + handOverInInternalSuccessCount +
	 * handOverInExternalSuccessCount
	 * 
	 * service_name in ( 'geranBscBtsHandoverSuccessCount_neighbts',
	 * 'geranBscTrxSubsequentAssignmentSuccessCount' , )
	 * 
	 * data_source in ('internal_neighbour','external_neighbour',
	 * 'sdcch_bm','sdcch4_bm','sdcch_lm','sdcch4_lm')
	 */
	private void MeanHoldingTimeInSecsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_neighbts_internal_neighbour_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Mean Holding Time In Secs - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Mean Holding Time In Secs - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Mean Holding Time In Secs - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 0
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_0 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual0(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_0", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_0", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_0 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 1
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_1 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual1(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_1", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_1", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_1 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 2
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_2 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual2(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_2", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_2", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_2 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 3
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_3 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual3(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_3", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_3", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_3 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 4
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_4 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual4(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_4", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_4", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_4 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 5
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_5 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual5(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_5", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_5", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_5 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 6
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_6 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual6(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_6_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_6_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_6", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_6", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_6 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlTchRxQual(N) = Σ (geranBscTrxMobRxQualCount)
	 * 
	 * Condition: geranBscTrxTei = TRX geranBscTrxRxQualValue = 7
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxMobRxQualCount_7 Data_source in
	 * [lm,bm]
	 */
	private void DLTCHRxQual7(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_7_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_7_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual_7", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual_7", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual_7 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 0
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_0
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual0(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_0", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_0", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_0 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 1
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_1
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual1(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_1", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_1", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_1 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 2
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_2
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual2(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_2", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_2", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_2 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 3
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_3
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual3(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_3", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_3", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_3 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 4
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_4
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual4(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_4", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_4", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_4 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 5
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_5
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual5(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_5", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_5", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_5 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 6
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_6
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual6(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_6_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_6_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_6", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_6", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_6 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual(N) = Σ (geranBscTrxRxSubQualCount)
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxQualValue = 7
	 * geranBscTrxChannelType = LM,BM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxRxSubQualCount_7
	 * 
	 * Data_source in [lm,bm]
	 */
	private void ULTCHRxQual7(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_7_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_7_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual_7", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual_7", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual_7 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlTchRxQual-0To5-Percent = 100 X Σ (counter ) condition 1
	 * --------------------------------- Σ (counter ) condition 2
	 * 
	 * Condition 1 geranBscTrxTei = TRX geranBscTrxQualValue = 0..5
	 * geranBscTrxChannelType = LM, BM Condition 2 geranBscTrxTei = TRX
	 * geranBscTrxQualValue = 0..7 geranBscTrxChannelType = LM, BM counter =
	 * geranBscTrxRxSubQualCount if dtx is enabled or geranBscTrxRxQualCounter if
	 * dtx is disabled
	 * 
	 * Numerator : Service_name : geranBscTrxRxSubQualCount_0,
	 * geranBscTrxRxSubQualCount_1 geranBscTrxRxSubQualCount_2,
	 * geranBscTrxRxSubQualCount_3, geranBscTrxRxSubQualCount_4,
	 * geranBscTrxRxSubQualCount_5
	 ** 
	 * Data_source : [lm,bm]
	 * 
	 * Denominator : Service_name : geranBscTrxRxSubQualCount_0,
	 * geranBscTrxRxSubQualCount_1 geranBscTrxRxSubQualCount_2,
	 * geranBscTrxRxSubQualCount_3, geranBscTrxRxSubQualCount_4,
	 * geranBscTrxRxSubQualCount_5, geranBscTrxRxSubQualCount_6,
	 * geranBscTrxRxSubQualCount_7
	 ** 
	 * Data_source : [lm,bm]
	 ** 
	 * : consider all 2 data_source for each service_name
	 */
	private void ULTCHRxQual0To5Percent(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = (Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_bm_sum").toString())) * 100;

			double DR = Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_1_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_2_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_5_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_6_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_6_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_7_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxRxSubQualCount_7_bm_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UL TCH RxQual 0To5 Percent",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UL TCH RxQual 0To5 Percent", deviceId, tag);
			}

			HfclLogger.logger.info("UL TCH RxQual 0To5 Percent KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Numerator : Service_name : geranBscTrxMobRxQualCount_0,
	 * geranBscTrxMobRxQualCount_1 geranBscTrxMobRxQualCount_2,
	 * geranBscTrxMobRxQualCount_3, geranBscTrxMobRxQualCount_4,
	 * geranBscTrxMobRxQualCount_5
	 ** 
	 * Data_source : [lm,bm]
	 * 
	 * Denominator : Service_name : geranBscTrxMobRxQualCount_0,
	 * geranBscTrxMobRxQualCount_1 geranBscTrxMobRxQualCount_2,
	 * geranBscTrxMobRxQualCount_3, geranBscTrxMobRxQualCount_4,
	 * geranBscTrxMobRxQualCount_5, geranBscTrxMobRxQualCount_6,
	 * geranBscTrxMobRxQualCount_7
	 ** 
	 * Data_source : [lm,bm]
	 ** 
	 * : consider all 2 data_source for each service_name
	 */
	private void DLTCHRxQual0To5Percent(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = (Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_bm_sum").toString())) * 100;

			double DR = Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_0_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_1_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_2_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_3_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_5_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_6_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_6_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_7_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxMobRxQualCount_7_bm_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DL TCH RxQual 0To5 Percent",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DL TCH RxQual 0To5 Percent", deviceId, tag);
			}

			HfclLogger.logger.info("DL TCH RxQual 0To5 Percent KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * SDCCH8 Blocking Count = Σ (geranBscBtsChannelBlockingCount)
	 * 
	 * Condition : geranBscBtsCellId = BTS Cell ID, geranBscBtsChannelType = sdcch
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [sdcch]
	 * 
	 */
	private void SDCCH8BlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_sdcch_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH8 Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH8 Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH8 Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of mobiles which have successfully accessed a
	 * SDCCH4 channel, and then drops the call because of poor RF frequency
	 * conditions other than a handover procedure. Number Of Radio Connection
	 * Failures SDCCH4 = Σ geranBscTrxNumRadioConnectionFailures
	 * 
	 * Condition : geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumRadioConnectionFailures
	 * Data_source = sdcch4
	 */
	private void NumberOfRadioConnectionFailuresSDCCH4(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of Radio Connection Failures SDCCH4", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Radio Connection Failures SDCCH4", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Radio Connection Failures SDCCH4 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of mobiles which have successfully accessed a
	 * SDCCH8 channel, and then drops the call because of poor RF frequency
	 * conditions other than a handover procedure. Number Of Radio Connection
	 * Failures SDCCH8 = Σ geranBscTrxNumRadioConnectionFailures
	 * 
	 * Condition : geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = sdcch
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumRadioConnectionFailures
	 * Data_source = sdcch
	 */
	private void NumberOfRadioConnectionFailuresSDCCH8(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_sdcch_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of Radio Connection Failures SDCCH8 ", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Radio Connection Failures SDCCH8 ", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Radio Connection Failures SDCCH8 KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of mobiles which have successfully accessed a TCH
	 * half rate channel, and then subsequently, have an abnormal release excluding
	 * the procedure of handout. Number Of Radio Connection Failures TCH_H = Σ
	 * geranBscTrxNumRadioConnectionFailures
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumRadioConnectionFailures
	 * Data_source = lm
	 */
	private void NumberOfRadioConnectionFailuresTCHH(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of Radio Connection Failures TCH_H", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Radio Connection Failures TCH_H", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Radio Connection Failures TCH_H KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of mobiles which have successfully accessed a TCH
	 * half rate channel, and then subsequently, have an abnormal release excluding
	 * the procedure of handout. Number Of Radio Connection Failures TCH_H =
	 * ΣgeranBscTrxNumRadioConnectionFailures
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType = LM
	 * 
	 * Device_type = BTS Service_name = geranBscTrxNumRadioConnectionFailures
	 * Data_source = lm
	 */
	private void NumberOfRadioConnectionFailuresTCHF(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxNumRadioConnectionFailures_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of Radio Connection Failures TCH_F", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Radio Connection Failures TCH_F", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Radio Connection Failures TCH_F KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of SDCCH4 assignment attempts.
	 * 
	 * NumberOfSDCCH4AssignmentAttempts = Σ geranBscTrxImmAssignmentCommandCount
	 * 
	 * Condition
	 * 
	 * geranBscTrxTei = TRX geranBscTrxChannelType=sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentCommandCount
	 * Data_source = sdcch4
	 */
	private void NumberOfSDCCH4AssignmentAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of SDCCH4 Assignment Attempts", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of SDCCH4 Assignment Attempts", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of SDCCH4 Assignment Attempts  KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of SDDCH4 assignment successes.
	 * 
	 * NumberOfSDCCH4AssignmentSuccess = Σ geranBscTrxImmAssignmentSuccessCount
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxChannelType=sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentSuccessCount
	 * Data_source = sdcch4
	 * 
	 */
	private void NumberOfSDCCH4AssignmentSuccess(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of SDCCH4 Assignment Success", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of SDCCH4 Assignment Success", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of SDCCH4 Assignment Success KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of SDCCH8 assignment attempts.
	 * 
	 * NumberOfSDCCH8AssignmentAttempts = Σ geranBscTrxImmAssignmentCommandCount
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxChannelType=sdcch
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentCommandCount
	 * Data_source = sdcch
	 */
	private void NumberOfSDCCH8AssignmentAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentCommandCount_sdcch_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of SDCCH8 Assignment Attempts", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of SDCCH8 Assignment Attempts", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of SDCCH8 Assignment Attempts KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of SDDCH8 assignment successes.
	 * 
	 * NumberOfSDCCH8AssignmentSuccess = Σ geranBscTrxImmAssignmentSuccessCount
	 * 
	 * Condition geranBscTrxTei = TRX geranBscTrxChannelType=sdcch
	 * 
	 * Device_type = BTS Service_name = geranBscTrxImmAssignmentSuccessCount
	 * Data_source = sdcch
	 */
	private void NumberOfSDCCH8AssignmentSuccess(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscTrxImmAssignmentSuccessCount_sdcch_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Number Of SDCCH8 Assignment Success", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of SDCCH8 Assignment Success", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of SDCCH8 Assignment Success KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI provides the number of times a mobile tried to start a dedicated
	 * signaling channel but were blocked because the BTS had no available signaling
	 * channels due to congestion. SDCCH4 Blocking Count = Σ
	 * (geranBscBtsChannelBlockingCount)
	 * 
	 * Condition: geranBscBtsCellId = BTS Cell ID geranBscBtsChannelType =sdcch4
	 * 
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [sdcch4]
	 */
	private void SDCCH4BlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_sdcch4_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "SDCCH4 Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "SDCCH4 Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("SDCCH4 Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI provides the number of times a mobile tried to start a voice channel
	 * but were blocked because the BTS had no available voice channels due to
	 * congestion. TCH Blocking Count Half Rate = Σ(geranBscBtsChannelBlockingCount)
	 * Condition = geranBscBtsCellId = BTS Cell ID, geranBscBtsChannelType = LM
	 * 
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [ lm]
	 * 
	 */
	private void TCHHBlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH_H Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH_H Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("TCH_H Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI provides the number of times a mobile tried to start a voice channel
	 * but were blocked because the BTS had no available voice channels due to
	 * congestion. TCH Blocking Count Half Rate = Σ(geranBscBtsChannelBlockingCount)
	 * Condition = geranBscBtsCellId = BTS Cell ID, geranBscBtsChannelType = BM
	 * 
	 * Device_type = BTS Service_name = geranBscBtsChannelBlockingCount Data_source
	 * in [ bm]
	 * 
	 */
	private void TCHFBlockingCount(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map.get("geranBscBtsChannelBlockingCount_bm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "TCH_F Blocking Count",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "TCH_F Blocking Count", deviceId, tag);
			}

			HfclLogger.logger.info("TCH_F Blocking Count KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of paging attempts sent for the BTS over a
	 * collection Period.
	 * 
	 * Number Of Paging Attempts = geranBscBtsNumPagingAttempts
	 * 
	 * Condition Device_type = BTS Service_name = geranBscBtsNumPagingAttempts
	 * Data_source = geranBscBtsNumPagingAttempts
	 */
	private void NumberOfPagingAttempts(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Number Of Paging Attempts",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Paging Attempts", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Paging Attempts KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Percent Smart Pages =
	 * 
	 * ΣgeranBscBtsNumSmartPagingAttempts
	 * ----------------------------------------------------------------------- Σ
	 * geranBscBtsNumPagingAttempts - geranBscBtsNumSmartPagingFailures
	 * 
	 * Numerator : Service_name : geranBscBtsNumSmartPagingAttempts Data_source :
	 * geranBscBtsNumSmartPagingAttempts
	 * 
	 * Denominator : Service_name : geranBscBtsNumPagingAttempts,
	 * geranBscBtsNumSmartPagingFailures Data_source :
	 * [geranBscBtsNumPagingAttempts, geranBscBtsNumSmartPagingFailures]
	 */
	private void PercentSmartPages(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = Double.parseDouble(
					map.get("geranBscBtsNumSmartPagingAttempts_geranBscBtsNumSmartPagingAttempts_sum").toString());

			double DR = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsNumSmartPagingFailures_geranBscBtsNumSmartPagingFailures_sum").toString());
			;

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), " Percent Smart Pages",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), " Percent Smart Pages", deviceId, tag);
			}

			HfclLogger.logger.info(" Percent Smart Pages KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Percent Smart Pages NR = ΣgeranBscBtsNumSmartPagingAttempts
	 * 
	 * Numerator : Service_name : geranBscBtsNumSmartPagingAttempts Data_source :
	 * geranBscBtsNumSmartPagingAttempts
	 */
	private void PercentSmartPagesNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(
					map.get("geranBscBtsNumSmartPagingAttempts_geranBscBtsNumSmartPagingAttempts_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), " Percent Smart Pages - NR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), " Percent Smart Pages - NR", deviceId, tag);
			}

			HfclLogger.logger.info(" Percent Smart Pages -NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Percent Smart Pages DR = Σ geranBscBtsNumPagingAttempts -
	 * geranBscBtsNumSmartPagingFailures
	 * 
	 * Denominator : Service_name : geranBscBtsNumPagingAttempts,
	 * geranBscBtsNumSmartPagingFailures Data_source :
	 * [geranBscBtsNumPagingAttempts, geranBscBtsNumSmartPagingFailures]
	 */
	private void PercentSmartPagesDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString())
					+ Double.parseDouble(map
							.get("geranBscBtsNumSmartPagingFailures_geranBscBtsNumSmartPagingFailures_sum").toString());
			;

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), " Percent Smart Pages - DR",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), " Percent Smart Pages - DR", deviceId, tag);
			}

			HfclLogger.logger.info(" Percent Smart Pages - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * geranBscBtsNumSmartPagingAttempts - geranBscBtsNumSmartPagingFailures /
	 * geranBscBtsNumSmartPagingAttempts Numerator Service_name :
	 * geranBscBtsNumPagingAttempts, geranBscBtsNumSmartPagingFailures Data_source :
	 * [geranBscBtsNumPagingAttempts, geranBscBtsNumSmartPagingFailures]
	 * 
	 * Denominator Service_name : geranBscBtsNumPagingAttempts Data_source :
	 * [geranBscBtsNumPagingAttempts]
	 */
	private void SmartPagingSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString())
					- Double.parseDouble(map
							.get("geranBscBtsNumSmartPagingFailures_geranBscBtsNumSmartPagingFailures_sum").toString());

			double DR = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Smart Paging Success Rate ",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Smart Paging Success Rate ", deviceId, tag);
			}

			HfclLogger.logger.info("Smart Paging Success Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Smart Paging Success Rate = geranBscBtsNumSmartPagingAttempts -
	 * geranBscBtsNumSmartPagingFailures
	 * 
	 * Service_name : geranBscBtsNumPagingAttempts,
	 * geranBscBtsNumSmartPagingFailures Data_source :
	 * [geranBscBtsNumPagingAttempts, geranBscBtsNumSmartPagingFailures]
	 */
	private void SmartPagingSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString())
					- Double.parseDouble(map
							.get("geranBscBtsNumSmartPagingFailures_geranBscBtsNumSmartPagingFailures_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Smart Paging Success Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Smart Paging Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Smart Paging Success Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Smart Paging Success Rate (DR) = geranBscBtsNumSmartPagingAttempts
	 * 
	 * Service_name : geranBscBtsNumPagingAttempts Data_source :
	 * [geranBscBtsNumPagingAttempts]
	 */
	private void SmartPagingSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsNumPagingAttempts_geranBscBtsNumPagingAttempts_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Smart Paging Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Smart Paging Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Smart Paging Success Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of channel assignments made for GSM emergency
	 * calls. This is calculated per BTS over a collection period. Number of
	 * Emergency Calls = geranBscBtsImmAssignmentCommandCount.n.emergency
	 * geranBtsChannelRequestCause = emergency
	 * 
	 * SUM Condition Device_type = BTS Service_name =
	 * geranBscBtsImmAssignmentCommandCount_emergency Data_source =
	 * geranBscBtsImmAssignmentCommandCount_emergency
	 */
	private void NumberOfEmergencyCalls(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double.parseDouble(map.get(
					"geranBscBtsImmAssignmentCommandCount_emergency_geranBscBtsImmAssignmentCommandCount_emergency_sum")
					.toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Number Of Emergency Calls",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Emergency Calls", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Emergency Calls KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the number of channel assignments made for the location
	 * updaqte procedure. This is calculated per BTS over a collection period.
	 * 
	 * Number of Location Updates = geranBscBtsImmAssignmentCommandCount
	 * geranBtsChannelRequestCause = locUpd
	 * 
	 * Condition Device_type = BTS Service_name =
	 * geranBscBtsImmAssignmentCommandCount_locUpd Data_source =
	 * geranBscBtsImmAssignmentCommandCount_locUpd
	 * 
	 */
	private void NumberOfLocationUpdates(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(map
					.get("geranBscBtsImmAssignmentCommandCount_locUpd_geranBscBtsImmAssignmentCommandCount_locUpd_sum")
					.toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Number Of Location Updates",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Number Of Location Updates", deviceId, tag);
			}

			HfclLogger.logger.info("Number Of Location Updates KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of successful attempts to reserve a TCH for
	 * a voice call on a BTS. TotalNumberCallsBts = Σ NumTchFCallSuccessTrx +
	 * NumTchHCallSuccessTrx TRX = ΣgeranBscTrxSubsequentAssignmentSuccessCount +
	 * ΣgeranBscTrxSubsequentAssignmentSuccessCount
	 * 
	 * Device_type = BTS Service_name = geranBscTrxSubsequentAssignmentSuccessCount,
	 * geranBscTrxSubsequentAssignmentSuccessCount Data_source in [sdcch_bm,
	 * sdcch4_bm,sdcch_lm, sdcch4_lm]
	 */
	private void TotalNumberOfCalls(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_bm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_bm_sum").toString())
					+ Double.parseDouble(map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch_lm_sum").toString())
					+ Double.parseDouble(
							map.get("geranBscTrxSubsequentAssignmentSuccessCount_sdcch4_lm_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Total Number Of Calls",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Number Of Calls", deviceId, tag);
			}

			HfclLogger.logger.info("Total Number Of Calls KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * External HandIn Success Rate
	 * 
	 * = Σ geranBscBtsHandoverSuccessCount.<ext neighbours>.n
	 * -------------------------------------------------------------------------
	 * --------------- Σ geranBscBtsHandoverCommandCount.<ext neighbours>.n
	 * 
	 * Numerator : Service : 'geranBscBtsHandoverSuccessCount_neighbts' Data_source
	 * : ‘external_neighbour’
	 * 
	 * Denominator : Service : 'geranBscBtsHandoverCommandCount_neighbts'
	 * Data_source : ‘external_neighbour’
	 */
	private void ExternalHandInSuccessRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString());

			double DR = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_neighbts_external_neighbour_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External HandIn Success Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External HandIn Success Rate", deviceId, tag);
			}

			HfclLogger.logger.info("External HandIn Success Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Numerator : Service : 'geranBscBtsHandoverSuccessCount_neighbts' Data_source
	 * : ‘external_neighbour’
	 */
	private void ExternalHandInSuccessRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverSuccessCount_neighbts_external_neighbour_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External HandIn Success Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External HandIn Success Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("External HandIn Success - NR Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Denominator : Service : 'geranBscBtsHandoverCommandCount_neighbts'
	 * Data_source : ‘external_neighbour’
	 */
	private void ExternalHandInSuccessRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranBscBtsHandoverCommandCount_neighbts_external_neighbour_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"External HandIn Success Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "External HandIn Success Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("External HandIn Success Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

}
