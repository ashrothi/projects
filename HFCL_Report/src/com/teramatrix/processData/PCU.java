package com.teramatrix.processData;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

import com.teramatrix.initiator.ReportInitiator;
import com.teramatrix.logger.HfclLogger;
import com.teramatrix.main.HfclEscalationApp;

/**
 * This class is used to calculate KPi of PCU tag , initially all methods get
 * the device Id and plateform data in there paramter to calculate the KPI
 * values
 * 
 * @author Pooja singh
 * @since 11.may.2018
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class PCU implements ReportInitiator {
	static final GetData getData = new GetData();
	static final String tag = "PCU";

	@Override
	public void initial(String deviceId, Map<String, Object> platformData) {
		StartTime(deviceId, platformData);
		EndTime(deviceId, platformData);
		DeviceName(deviceId, platformData);
		CellID(deviceId, platformData);
		IPAddress(deviceId, platformData);
		BSCName(deviceId, platformData);
		DLPSErlangs(deviceId, platformData);
		ULPSErlangs(deviceId, platformData);
		TotalDataCalls(deviceId, platformData);
		TotalDownlinkDataInKByte(deviceId, platformData);
		TotalUplinkDataInKByte(deviceId, platformData);
		DownlinkDataThroughputInKbps(deviceId, platformData);
		DownlinkDataThroughputInKbpsNR(deviceId, platformData);
		DownlinkDataThroughputInKbpsDR(deviceId, platformData);
		UplinkDataThroughputInKbps(deviceId, platformData);
		UplinkDataThroughputInKbpsNR(deviceId, platformData);
		UplinkDataThroughputInKbpsDR(deviceId, platformData);
		TbfAbnormalReleaseRate(deviceId, platformData);
		TbfAbnormalReleaseRateNR(deviceId, platformData);
		TbfAbnormalReleaseRateDR(deviceId, platformData);
		EgprsDownlinkDataThroughputInKbps(deviceId, platformData);
		EgprsDownlinkDataThroughputInKbpsNR(deviceId, platformData);
		EgprsDownlinkDataThroughputInKbpsDR(deviceId, platformData);
		EgprsUplinkDataThroughputInKbps(deviceId, platformData);
		EgprsUplinkDataThroughputInKbpsNR(deviceId, platformData);
		EgprsUplinkDataThroughputInKbpsDR(deviceId, platformData);
		GprsDownlinkDataThroughputInKbps(deviceId, platformData);
		GprsDownlinkDataThroughputInKbpsNR(deviceId, platformData);
		GprsDownlinkDataThroughputInKbpsDR(deviceId, platformData);
		GprsUplinkDataThroughputInKbps(deviceId, platformData);
		GprsUplinkDataThroughputInKbpsNR(deviceId, platformData);
		GprsUplinkDataThroughputInKbpsDR(deviceId, platformData);
		DownlinkDataRetransmissionRate(deviceId, platformData);
		DownlinkDataRetransmissionRateNR(deviceId, platformData);
		DownlinkDataRetransmissionRateDR(deviceId, platformData);
		UplinkDataRetransmissionRate(deviceId, platformData);
		UplinkDataRetransmissionRateNR(deviceId, platformData);
		UplinkDataRetransmissionRateDR(deviceId, platformData);
		GprsUplinkTbfBlockingRate(deviceId, platformData);
		GprsUplinkTbfBlockingRateNR(deviceId, platformData);
		GprsUplinkTbfBlockingRateDR(deviceId, platformData);
		GprsDownlinkTbfBlockingRate(deviceId, platformData);
		GprsDownlinkTbfBlockingRateNR(deviceId, platformData);
		GprsDownlinkTbfBlockingRateDR(deviceId, platformData);
		EgprsDownlinkTbfBlockingRate(deviceId, platformData);
		EgprsDownlinkTbfBlockingRateNR(deviceId, platformData);
		EgprsDownlinkTbfBlockingRateDR(deviceId, platformData);
		EgprsUplinkTbfBlockingRate(deviceId, platformData);
		EgprsUplinkTbfBlockingRateNR(deviceId, platformData);
		EgprsUplinkTbfBlockingRateDR(deviceId, platformData);
		DlMcs1Count(deviceId, platformData);
		DlMcs2Count(deviceId, platformData);
		DlMcs3Count(deviceId, platformData);
		DlMcs4Count(deviceId, platformData);
		DlMcs5Count(deviceId, platformData);
		DlMcs6Count(deviceId, platformData);
		DlMcs7Count(deviceId, platformData);
		DlMcs8Count(deviceId, platformData);
		DlMcs9Count(deviceId, platformData);
		UlMcs1Count(deviceId, platformData);
		UlMcs2Count(deviceId, platformData);
		UlMcs3Count(deviceId, platformData);
		UlMcs4Count(deviceId, platformData);
		UlMcs5Count(deviceId, platformData);
		UlMcs6Count(deviceId, platformData);
		UlMcs7Count(deviceId, platformData);
		UlMcs8Count(deviceId, platformData);
		UlMcs9Count(deviceId, platformData);
		DlCs1Count(deviceId, platformData);
		DlCs2Count(deviceId, platformData);
		DlCs3Count(deviceId, platformData);
		DlCs4Count(deviceId, platformData);
		UlCs1Count(deviceId, platformData);
		UlCs2Count(deviceId, platformData);
		UlCs3Count(deviceId, platformData);
		UlCs4Count(deviceId, platformData);
	}

	/*
	 * Service_name(Denominator) = geranPcuV2PerformanceTotalTbfCount
	 * 
	 * ( Denominator) = [gprs_uplink,egprs_uplink,gprs_downlink,egprs_downlink]
	 */
	private void TbfAbnormalReleaseRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_downlink_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Tbf Abnormal Release Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Tbf Abnormal Release Rate- DR", deviceId, tag);
			}

			HfclLogger.logger.info("Tbf Abnormal Release Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Service_name(Numerator) = geranPcuV2PerformanceTotalTbfCount,
	 * geranPcuV2PerformanceTotalSuccessfulTbfCount Data_source(Numerator) =
	 * [gprs_uplink,egprs_uplink,gprs_downlink,egprs_downlink]
	 */
	private void TbfAbnormalReleaseRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = (Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_downlink_sum").toString()))
					- (Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_egprs_uplink_sum").toString())
							+ Double.parseDouble(map
									.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_egprs_downlink_sum")
											.toString()));

			double finaldata = NR * 100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Tbf Abnormal Release Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Tbf Abnormal Release Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Tbf Abnormal Release Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * TBF Abnormal Release Rate = Numerator *100 / Denominator
	 * Service_name(Numerator) = geranPcuV2PerformanceTotalTbfCount,
	 * geranPcuV2PerformanceTotalSuccessfulTbfCount
	 * 
	 * Data_source(Numerator) =
	 * [gprs_uplink,egprs_uplink,gprs_downlink,egprs_downlink]
	 * Service_name(Denominator) = geranPcuV2PerformanceTotalTbfCount
	 * 
	 * Data_source( Denominator) =
	 * [gprs_uplink,egprs_uplink,gprs_downlink,egprs_downlink]
	 */
	private void TbfAbnormalReleaseRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double NR = (100
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_uplink_sum").toString())
					+ 100 * Double
							.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_uplink_sum").toString())
					+ 100 * Double
							.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_downlink_sum").toString())
					+ 100 * Double
							.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_downlink_sum").toString()))
					- (100 * Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_gprs_uplink_sum").toString())
							+ 100 * Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_egprs_uplink_sum").toString())
							+ 100 * Double.parseDouble(map
									.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_gprs_downlink_sum").toString())
							+ 100 * Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalSuccessfulTbfCount_egprs_downlink_sum")
											.toString()));

			double DR = Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_downlink_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Tbf Abnormal Release Rate",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Tbf Abnormal Release Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Tbf Abnormal Release Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * Data Retransmission Rate - DR=
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.egprs.dl Service_name(Denominator) =
	 * geranPcuV2PerformanceTotalRlcTxBlocks Data_source( Denominator) =
	 * [gprs_downlink,egprs_downlink]
	 */
	private void DownlinkDataRetransmissionRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_gprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcTxBlocks_egprs_downlink_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Retransmission Rate – DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Retransmission Rate – DR", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Retransmission Rate – DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlCs4Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Data_source = [gprs_uplink]
	 */
	private void UlCs4Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlCs4Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlCs4Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlCs4Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlCs3Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Data_source = [gprs_uplink]
	 */
	private void UlCs3Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlCs3Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlCs3Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlCs3Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlCs2Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Data_source = [gprs_uplink]
	 */
	private void UlCs2Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count_gprs_downlink_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlCs2Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlCs2Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlCs2Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlCs1Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Data_source = [gprs_uplink]
	 */
	private void UlCs1Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlCs1Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlCs1Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlCs1Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlCs4Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Data_source = [gprs_downlink]
	 */
	private void DlCs4Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlCs4Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlCs4Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlCs4Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlCs3Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Data_source = [gprs_downlink]
	 */
	private void DlCs3Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlCs3Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlCs3Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlCs3Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlCs2Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Data_source = [gprs_downlink]
	 */
	private void DlCs2Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlCs2Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlCs2Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlCs2Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlCs1Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Data_source = [gprs_downlink]
	 */
	private void DlCs1Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlCs1Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlCs1Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlCs1Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs9Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs9Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs9Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs9Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs9Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs8Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs8Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs8Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs8Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs8Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs7Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs7Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs7Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs7Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs7Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs6Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs6Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs6Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs6Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs6Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs5Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs5Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs5Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs5Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs5Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs4Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs4Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs4Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs4Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs4Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs3Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs3Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs3Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs3Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs3Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs2Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs2Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs2Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs2Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs2Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * UlMcs1Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Data_source = [egprs_uplink]
	 */
	private void UlMcs1Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "UlMcs1Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "UlMcs1Count", deviceId, tag);
			}
			HfclLogger.logger.info("UlMcs1Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * DlMcs9Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs9Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme9Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs9Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs9Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs9Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs8Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs8Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme8Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs8Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs8Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs8Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs7Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs7Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme7Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs7Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs7Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs7Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs6Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs6Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme6Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs6Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs6Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs6Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs5Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs5Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme5Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs5Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs5Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs5Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs4Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs4Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme4Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs4Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs4Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs4Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs3Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs3Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme3Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs3Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs3Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs3Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}

	}

	/*
	 * DlMcs2Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs2Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme2Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs2Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs2Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs2Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * DlMcs1Count = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Service_name = geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count
	 * Data_source = [egprs_downlink]
	 */
	private void DlMcs1Count(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double.parseDouble(
					map.get("geranPcuV2PerformanceRlcTxBlocksAtChanCodingScheme1Count_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "DlMcs1Count", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "DlMcs1Count", deviceId, tag);
			}
			HfclLogger.logger.info("DlMcs1Count KPI Value : " + finaldata);
		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the EGPRS downlink throughput (in kbps) carried on a BTS over
	 * the collection period. Conditions:
	 * 
	 * Egprs Downlink Data Throughput In Kbps = Σ8 * 100
	 * *(geranPcuV2PerformanceTotalBytesSent)/ Σ1024
	 * *(geranPcuV2PerformanceTotalTimeSpent)
	 * 
	 * geranPcuV2PerformanceAccess = egprs geranPcuV2Performance direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source = egprs_downlink
	 * 
	 * EgprsDownlinklinkDataThroughput -NR=
	 * 
	 * 1/1024* Σ8 *(geranPcuV2PerformanceTotalBytesSent)
	 */
	private void EgprsDownlinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double sumOfNR = 8 * 100 * (Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_egprs_downlink_sum").toString()));
			double sumOfDR = 1024
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_downlink_sum").toString());
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Downlink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Data Throughput In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 1/1024* Σ8 *(geranPcuV2PerformanceTotalBytesSent)
	 */
	private void EgprsDownlinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = 1 / 1024 * (8
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_egprs_downlink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Downlink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Σ(geranPcuV2PerformanceTotalTimeSpent)/100
	 */
	private void EgprsDownlinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_downlink_sum").toString()) / 100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Data Throughput In Kbps - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Downlink Data Throughput In Kbps - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Data Throughput In Kbps - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the EGPRS uplink throughput (in kbps) carried on a BTS over
	 * the collection period. Egprs uplink Data Throughput In Kbps = Σ8 * 100
	 * *(geranPcuV2PerformanceTotalBytesSent)/ Σ1024
	 * *(geranPcuV2PerformanceTotalTimeSpent)
	 * 
	 * Condition : geranPcuV2PerformanceAccess = egprs geranPcuV2Performance
	 * direction = ul
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source = egprs_uplink
	 * 
	 */
	private void EgprsUplinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double sumOfNR = 8 * 100
					* (Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_egprs_uplink_sum").toString()));
			double sumOfDR = 1024
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_uplink_sum").toString());
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Uplink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Uplink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Uplink Data Throughput In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 1/1024* Σ8 * (geranPcuV2PerformanceTotalBytesSent)
	 */
	private void EgprsUplinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = 1 / 1024 * (8
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_egprs_uplink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Uplink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Uplink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Uplink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Σ(geranPcuV2PerformanceTotalTimeSpent)/100
	 */
	private void EgprsUplinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_downlink_sum").toString()) / 100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Uplink Data Throughput In Kbps - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Uplink Data Throughput In Kbps - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Uplink Data Throughput In Kbps - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the GPRS downlink throughput (in kbps) carried on a BTS over
	 * the collection period.
	 * 
	 * Gprs Downlink Data Throughput In Kbps = Σ8 * 100
	 * *(geranPcuV2PerformanceTotalBytesSent)/ Σ1024
	 * *(geranPcuV2PerformanceTotalTimeSpent)
	 * 
	 * Conditions:
	 * 
	 * geranPcuV2PerformanceAccess = Gprs geranPcuV2Performance direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source = gprs_downlink
	 */
	private void GprsDownlinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double sumOfNR = 8 * 100
					* (Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_downlink_sum").toString()));
			double sumOfDR = 1024
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_downlink_sum").toString());
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Data Throughput In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 1/1024 *Σ8 *(geranPcuV2PerformanceTotalBytesSent)
	 */
	private void GprsDownlinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = 1 / 1024 * (8
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_downlink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Σ(geranPcuV2PerformanceTotalTimeSpent)/100
	 */
	private void GprsDownlinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_downlink_sum").toString()) / 100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Data Throughput In Kbps - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Data Throughput In Kbps - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Data Throughput In Kbps - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the GPRS uplink throughput (in kbps) carried on a BTS over
	 * the collection period.
	 * 
	 * Gprs uplink Data Throughput In Kbps = Σ8 * 100
	 * *(geranPcuV2PerformanceTotalBytesSent)/ Σ1024
	 * *(geranPcuV2PerformanceTotalTimeSpent) Condition geranPcuV2PerformanceAccess
	 * = Gprs geranPcuV2Performance direction = ul
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source = gprs_uplink
	 * 
	 */
	private void GprsUplinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double sumOfNR = 8 * 100
					* (Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_uplink_sum").toString()));
			double sumOfDR = 1024
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_uplink_sum").toString());
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Data Throughput In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 1/1024 * Σ8 *(geranPcuV2PerformanceTotalBytesSent)
	 */
	private void GprsUplinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = 1 / 1024 * (8
					* Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_uplink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Σ(geranPcuV2PerformanceTotalTimeSpent)/100
	 */
	private void GprsUplinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_uplink_sum").toString()) / 100;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Data Throughput In Kbps - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Data Throughput In Kbps - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Data Throughput In Kbps - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 100*(geranPcuV2PerformanceTotalRlcReTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.egprs.dl) /
	 * 
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.egprs.dl
	 * 
	 * Downlink Data Retransmission Rate - NR=
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.egprs.dl
	 * 
	 * Data Retransmission Rate - DR=
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.egprs.dl
	 * 
	 * Service_name(Numerator) = geranPcuV2PerformanceTotalRlcReTxBlocks,
	 * Data_source(Numerator) = [gprs_downlink,egprs_downlink]
	 * Service_name(Denominator) = geranPcuV2PerformanceTotalRlcTxBlocks
	 * Data_source( Denominator) = [gprs_downlink,egprs_downlink]
	 */
	private void DownlinkDataRetransmissionRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = (Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_gprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_egprs_downlink_sum").toString()))
					* 100;

			double DR = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_gprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcTxBlocks_egprs_downlink_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Retransmission Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Retransmission Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Retransmission Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * Downlink Data Retransmission Rate - NR=
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.gprs.dl +
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.egprs.dl
	 * 
	 * Service_name(Numerator) = geranPcuV2PerformanceTotalRlcReTxBlocks,
	 * Data_source(Numerator) = [gprs_downlink,egprs_downlink]
	 */
	private void DownlinkDataRetransmissionRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_gprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_egprs_downlink_sum").toString()))
					* 100;

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Retransmission Rate – NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Retransmission Rate – NR", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Retransmission Rate – NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 100*(geranPcuV2PerformanceTotalRlcReTxBlocks.n.gprs.ul +
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.egprs.ul) /
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.gprs.ul +
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.egprs.ul
	 * 
	 * Service_name(Numerator) = geranPcuV2PerformanceTotalRlcReTxBlocks
	 * Data_source(Numerator) = [gprs_uplink,egprs_uplink] Service_name(Denominator)
	 * = geranPcuV2PerformanceTotalRlcTxBlocks Data_source( Denominator) =
	 * [gprs_uplink,egprs_uplink]
	 */
	private void UplinkDataRetransmissionRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double NR = (Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_gprs_uplink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_egprs_uplink_sum").toString()))
					* 100;

			double DR = Double.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_egprs_uplink_sum").toString());

			double finaldata = NR / DR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Retransmission Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Retransmission Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Retransmission Rate KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Uplink Data Retransmission Rate - NR=
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.gprs.ul +
	 * geranPcuV2PerformanceTotalRlcReTxBlocks.n.egprs.ul)
	 */
	private void UplinkDataRetransmissionRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_gprs_uplink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2PerformanceTotalRlcReTxBlocks_egprs_uplink_sum").toString()))
					* 100;

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Retransmission Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Retransmission Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Retransmission Rate - NR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Uplink Data Retransmission Rate - DR=
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.gprs.ul +
	 * geranPcuV2PerformanceTotalRlcTxBlocks.n.egprs.ul
	 */
	private void UplinkDataRetransmissionRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalRlcTxBlocks_egprs_uplink_sum").toString());

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Retransmission Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Retransmission Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Retransmission Rate - DR KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Gprs Uplink Tbf Blocking Rate - NR= Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * Gprs Uplink Tbf Blocking Rate - DR= Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * Conditions :
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranPcuV2TbfAllocationAttemptCount, geranPcuV2TbfReallocationAttemptCount,
	 * geranPcuV2TbfAllocationSuccessCount, geranPcuV2TbfReallocationSuccessCount ]
	 * 
	 * Data_source(Numerator) in [ gprs_uplink]
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ gprs_uplink]
	 ** 
	 * 
	 * : consider both data_source for each service_name
	 * 
	 */
	private void GprsUplinkTbfBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double nr = (Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_uplink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_gprs_uplink_sum").toString()));
			double dr = Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_uplink_sum").toString());
			double finaldata = nr / dr;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Tbf Blocking Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Tbf Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Tbf Blocking Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Gprs Uplink Tbf Blocking Rate - NR= Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 */
	private void GprsUplinkTbfBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_uplink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_gprs_uplink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Tbf Blocking Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Tbf Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Tbf Blocking Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Gprs Uplink Tbf Blocking Rate - DR = Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount.)
	 */
	private void GprsUplinkTbfBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_uplink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Uplink Tbf Blocking Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Uplink Tbf Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Uplink Tbf Blocking Rate - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * gprs Downlink Tbf Blocking Rate - NR = Σ (geranPcuV2TbfAllocationAttemptCount
	 * + geranPcuV2TbfReallocationAttemptCount) -
	 * (geranPcuV2TbfAllocationSuccessCount + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * gprs Downlink Tbf Blocking Rate - DR= Σ (geranPcuV2TbfAllocationAttemptCount
	 * + geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * Conditions :
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranPcuV2TbfAllocationSuccessCount, geranPcuV2TbfReallocationSuccessCount,
	 * geranPcuV2TbfAllocationAttemptCount, geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Numerator) in [ gprs_downlink]
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ gprs_downlink] : consider both data_source for
	 * each service_name
	 */
	private void GprsDownlinkTbfBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double nr = (Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_downlink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_gprs_downlink_sum").toString()));
			double dr = Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_downlink_sum").toString());
			double finaldata = nr / dr;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Tbf Blocking Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Tbf Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Tbf Blocking Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * gprs Downlink Tbf Blocking Rate - NR = Σ (geranPcuV2TbfAllocationAttemptCount
	 * + geranPcuV2TbfReallocationAttemptCount) -
	 * (geranPcuV2TbfAllocationSuccessCount + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * Data_source(Numerator) in [ gprs_downlink]
	 * 
	 */
	private void GprsDownlinkTbfBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_downlink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_gprs_downlink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Tbf Blocking Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Tbf Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Tbf Blocking Rate - NR Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * gprs Downlink Tbf Blocking Rate - DR= Σ (geranPcuV2TbfAllocationAttemptCount
	 * + geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * Conditions :
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ gprs_downlink] : consider both data_source for
	 * each service_name
	 */
	private void GprsDownlinkTbfBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_gprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Gprs Downlink Tbf Blocking Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Tbf Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Gprs Downlink Tbf Blocking Rate - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Egprs Downlink Tbf Blocking Rate - NR=
	 * 
	 * Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * Egprs Downlink Tbf Blocking Rate - DR = Σ
	 * (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * 
	 * Conditions :
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranPcuV2TbfAllocationSuccessCount, geranPcuV2TbfReallocationSuccessCount,
	 * geranPcuV2TbfAllocationAttemptCount, geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Numerator) in [ egprs_downlink]
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ egprs_downlink]
	 ** 
	 * : consider both data_source for each service_name
	 * 
	 */
	private void EgprsDownlinkTbfBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double nr = (Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2TbfReallocationAttemptCount_egprs_downlink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_egprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_egprs_downlink_sum").toString()));
			double dr = Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2TbfReallocationAttemptCount_egprs_downlink_sum").toString());
			double finaldata = nr / dr;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Tbf Blocking Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Downlink Tbf Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Tbf Blocking Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Egprs Downlink Tbf Blocking Rate - NR=
	 * 
	 * Σ (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 */
	private void EgprsDownlinkTbfBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2TbfReallocationAttemptCount_egprs_downlink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_egprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_egprs_downlink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Tbf Blocking Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs Downlink Tbf Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Tbf Blocking Rate - NR Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Egprs Downlink Tbf Blocking Rate - DR = Σ
	 * (geranPcuV2TbfAllocationAttemptCount +
	 * geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 */
	private void EgprsDownlinkTbfBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_downlink_sum").toString())
					+ Double.parseDouble(
							map.get("geranPcuV2TbfReallocationAttemptCount_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs Downlink Tbf Blocking Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs Downlink Tbf Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs Downlink Tbf Blocking Rate - DR Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Egprs Uplink Tbf Blocking Rate = numerator * 100 / denominator
	 * 
	 * Egprs Uplink Tbf Blocking Rate - NR = Σ (geranPcuV2TbfAllocationAttemptCount+
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * Egprs Uplink Tbf Blocking Rate - DR = Σ (geranPcuV2TbfAllocationAttemptCount+
	 * geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * Conditions :
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranPcuV2TbfAllocationSuccessCount, geranPcuV2TbfReallocationSuccessCount,
	 * geranPcuV2TbfAllocationAttemptCount, geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Numerator) in [ egprs_uplink]
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ egprs_uplink]
	 ** 
	 * : consider both data_source for each service_name
	 */
	private void EgprsUplinkTbfBlockingRate(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double nr = (Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_egprs_uplink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_egprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_egprs_uplink_sum").toString()));
			double dr = Double.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_egprs_uplink_sum").toString());
			double finaldata = nr / dr;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs uplink Tbf Blocking Rate", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs uplink Tbf Blocking Rate", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs uplink Tbf Blocking Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * Egprs Uplink Tbf Blocking Rate - NR = Σ (geranPcuV2TbfAllocationAttemptCount+
	 * geranPcuV2TbfReallocationAttemptCount) - (geranPcuV2TbfAllocationSuccessCount
	 * + geranPcuV2TbfReallocationSuccessCount)
	 * 
	 * Device_type = BTS Service_name(Numerator) in [
	 * geranPcuV2TbfAllocationSuccessCount, geranPcuV2TbfReallocationSuccessCount,
	 * geranPcuV2TbfAllocationAttemptCount, geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Numerator) in [ egprs_uplink]
	 */
	private void EgprsUplinkTbfBlockingRateNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = (Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_egprs_uplink_sum").toString()))
					- (Double.parseDouble(map.get("geranPcuV2TbfAllocationSuccessCount_egprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2TbfReallocationSuccessCount_egprs_uplink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs uplink Tbf Blocking Rate - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Egprs uplink Tbf Blocking Rate - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs uplink Tbf Blocking Rate - NR Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * Egprs Uplink Tbf Blocking Rate - DR = Σ (geranPcuV2TbfAllocationAttemptCount+
	 * geranPcuV2TbfReallocationAttemptCount.)
	 * 
	 * Conditions :
	 ** 
	 * Service_name(Denominator) in [ geranPcuV2TbfAllocationAttemptCount,
	 * geranPcuV2TbfReallocationAttemptCount ]
	 * 
	 * Data_source(Denominator) in [ egprs_uplink]
	 ** 
	 * : consider both data_source for each service_name
	 */
	private void EgprsUplinkTbfBlockingRateDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2TbfAllocationAttemptCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2TbfReallocationAttemptCount_egprs_uplink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Egprs uplink Tbf Blocking Rate - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Gprs uplink Tbf Blocking Rate - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Egprs uplink Tbf Blocking Rate - DR Rate KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * Uplink Data Throughput In Kbps - DR = Σ(geranPcuV2PerformanceTotalTimeSpent
	 * )/ 100
	 * 
	 * Conditions geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = ul
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_uplink,egprs_uplink]
	 * 
	 */
	private void UplinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = ((Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_uplink_sum").toString()))
					/ 100);
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Throughput In Kbps - DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Throughput In Kbps - DR", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Throughput In Kbps - DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 *
	 * UplinkDataThroughput -NR = 1/1024 X Σ(geranPcuV2PerformanceTotalBytesSent) x
	 * 8 Conditions geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = ul
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_uplink,egprs_uplink]
	 * 
	 */
	private void UplinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 1 / 1024
					* ((Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_uplink_sum").toString()))
							* 8);
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the aggregate LLC data throughput on the downlink in kilobits
	 * per second.
	 * 
	 * Downlink Data Throughput -NR= 1/1024 X Σ
	 * (geranPcuV2PerformanceTotalBytesSent) x 8
	 * 
	 * Downlink Data Throughput In Kbps - DR = Σ
	 * (geranPcuV2PerformanceTotalTimeSpent) / 100
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_downlink,egprs_downlink]
	 */
	private void DownlinkDataThroughputInKbpsDR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = ((Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_downlink_sum").toString()))
					/ 100);
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Throughput In Kbps – DR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Throughput In Kbps – DR", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Throughput In Kbps – DR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the aggregate LLC data throughput on the downlink in kilobits
	 * per second.
	 * 
	 * Downlink Data Throughput -NR= 1/1024 X Σ
	 * (geranPcuV2PerformanceTotalBytesSent) x 8
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_downlink,egprs_downlink]
	 */
	private void DownlinkDataThroughputInKbpsNR(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 1 / 1024
					* ((Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_downlink_sum").toString()))
							* 8);
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Throughput In Kbps - NR", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Throughput In Kbps - NR", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Throughput In Kbps - NR KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * Downlink Data Throughput In Kbps - DR = Σ
	 * (geranPcuV2PerformanceTotalTimeSpent) / 100
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_downlink,egprs_downlink]
	 */
	private void UplinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double sumOfNR = 1 / 1024
					* ((Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_uplink_sum").toString()))
							* 8);
			double sumOfDR = ((Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_uplink_sum").toString()))
					/ 100);
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Uplink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Uplink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Uplink Data Throughput In Kbps In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the aggregate LLC data throughput on the downlink in kilobits
	 * per second.
	 * 
	 * Downlink Data Throughput -NR= 1/1024 X Σ
	 * (geranPcuV2PerformanceTotalBytesSent) x 8 Downlink Data Throughput In Kbps -
	 * DR = Σ (geranPcuV2PerformanceTotalTimeSpent) / 100
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * geranPcuV2PerformanceTotalTimeSpent
	 * 
	 * Data_source in [gprs_downlink,egprs_downlink]
	 * 
	 */
	private void DownlinkDataThroughputInKbps(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double sumOfNR = 1 / 1024
					* ((Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_downlink_sum").toString()))
							* 8);
			double sumOfDR = ((Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTimeSpent_egprs_downlink_sum").toString()))
					/ 100);
			double finaldata = sumOfNR / sumOfDR;
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Downlink Data Throughput In Kbps", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Downlink Data Throughput In Kbps", deviceId, tag);
			}

			HfclLogger.logger.info("Downlink Data Throughput In Kbps KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total aggregate LLC data on the uplink in kilobytes.
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = ul
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * Data_source in [gprs_uplink,egprs_uplink]
	 * 
	 */
	private void TotalUplinkDataInKByte(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 1 / 1024
					* (Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_uplink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_uplink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Total Uplink Data In KByte",
						deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Uplink Data In KByte", deviceId, tag);
			}

			HfclLogger.logger.info("Total Uplink Data In KByte KPI Value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total aggregate LLC data on the downlink in kilobytes.
	 * 
	 * Conditions : geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance
	 * direction = dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalBytesSent
	 * Data_source in [gprs_downlink,egprs_downlink]
	 * 
	 */
	private void TotalDownlinkDataInKByte(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");

			double finaldata = 1 / 1024
					* (Double.parseDouble(map.get("geranPcuV2PerformanceTotalBytesSent_gprs_downlink_sum").toString())
							+ Double.parseDouble(
									map.get("geranPcuV2PerformanceTotalBytesSent_egprs_downlink_sum").toString()));
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)),
						"Total Downlink Data In KByte", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Downlink Data In KByte", deviceId, tag);
			}

			HfclLogger.logger.info("Total Downlink Data In KByte KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	/*
	 * This KPI tracks the total number of data calls successfully established.
	 * 
	 * TotalDataCalls = Σ geranPcuV2PerformanceTotalSuccessfulTbfCount Σ
	 * geranPcuV2PerformanceTotalTbfCount Conditions :
	 * 
	 * geranPcuV2PerformanceAccess = egprs, gprs geranPcuV2Performance direction =
	 * ul, dl
	 * 
	 * Device_type = BTS Service_name = geranPcuV2PerformanceTotalTbfCount
	 * Data_source in [gprs_uplink,gprs_downlink,egprs_uplink,egprs_downlink]
	 * 
	 */
	private void TotalDataCalls(String deviceId, Map<String, Object> platformData) {
		try {
			Map<String, Double> map = (Map<String, Double>) platformData.get("platformSumResponse");
			double finaldata = Double
					.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_gprs_downlink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_uplink_sum").toString())
					+ Double.parseDouble(map.get("geranPcuV2PerformanceTotalTbfCount_egprs_downlink_sum").toString());
			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "Total Data Calls", deviceId,
						tag);
			} else {
				getData.insertKPI(String.valueOf(0), "Total Data Calls", deviceId, tag);
			}

			HfclLogger.logger.info("Total Data Calls KPI value : " + finaldata);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	private void ULPSErlangs(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void DLPSErlangs(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void BSCName(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void DeviceName(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void IPAddress(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	private void CellID(String deviceId, Map<String, Object> platformData) {
		// TODO Auto-generated method stub

	}

	// This Kpi is used to get end time
	private void EndTime(String deviceId, Map<String, Object> platformData) {
		try {
			String EndTime = HfclEscalationApp.beforeTime;

			long finaldata = Long.parseLong(EndTime);

			if (finaldata != 0) {
				DecimalFormat df = new DecimalFormat("#.##");
				df.setRoundingMode(RoundingMode.CEILING);
				getData.insertKPI(String.valueOf(HfclEscalationApp.df.format(finaldata)), "EndTime", deviceId, tag);
			} else {
				getData.insertKPI(String.valueOf(0), "EndTime", deviceId, tag);
			}

			HfclLogger.logger.info("End Time KPI value : " + EndTime);

		} catch (Exception e) {
			HfclLogger.logger.info("Exception occur in getting devices.");
			e.printStackTrace(HfclLogger.printStream);
			e.printStackTrace();
		}
	}

	// This Method is used to get start time of crone
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

}
