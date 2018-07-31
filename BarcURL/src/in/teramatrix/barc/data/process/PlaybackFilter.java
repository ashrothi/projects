package in.teramatrix.barc.data.process;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import in.teramatrix.barc.apicalling.AccessRestAPI;
import in.teramatrix.barc.configuration.Configuration;
import in.teramatrix.barc.dbloader.DBProcess;
import in.teramatrix.barc.logger.BarcLogger;

/**
 * This class is used for filtering the data on the basis of playback_id and
 * hashcode and then pushing the unique records using the API.
 * 
 * @author Mandeep Singh
 *
 */
public class PlaybackFilter {
	/**
	 * This method is used to filter the playback_id and hashcodes as required
	 * and then calling the API.
	 * 
	 * @param message
	 *            : Here pass the data received from the kafka.
	 */
	public static void dataFilter(String message) {
		List<Map<String, Object>> finalList = new ArrayList<Map<String, Object>>();
		// Parsing GSON to in lenient mode.
		JsonReader reader = new JsonReader(new StringReader(message));
		reader.setLenient(true);
		try {
			// Convert the data into the HashMap.
			Type collectionType = new TypeToken<List<HashMap<String, Object>>>() {
			}.getType();
			List<HashMap<String, Object>> data = new Gson().fromJson(reader, collectionType);

			// Iterate over the data retrieved from the kafka.
			for (Map<String, Object> map2 : data) {
				if (String.valueOf(map2.get("complete_media_url")).contains("redirector.gvt1.com")
						&& String.valueOf(map2.get("complete_media_url")).contains("videoplayback")
						&& String.valueOf(map2.get("complete_media_url")).contains("source")
						&& String.valueOf(map2.get("complete_media_url")).contains("gfp_video_ads")) {

					// Getting playback id from the map.
					String mediaUrl = String.valueOf(map2.get("complete_media_url"));
					String tempmediaUrl = mediaUrl
							.substring(mediaUrl.indexOf("videoplayback/id/") + "videoplayback/id/".length());
					String playBackId = tempmediaUrl.substring(0, tempmediaUrl.indexOf("/"));

					// Getting hashcode from the map.
					String hashCode = String.valueOf(map2.get("hashcode"));

					// Getting database connection.
					Connection connection = DBProcess.getDbConnection(Configuration.getDbDriver(),
							Configuration.getDbUrl());

					StringBuilder procedure = new StringBuilder();
					procedure.append(Configuration.getProcedureName() + "'" + playBackId + "', '" + hashCode + "');");
					BarcLogger.logger.info("Procedure to be called :-" + procedure);
					// Call procedure for validating the playback_id and hashcode.
					ResultSet resultSet = DBProcess.callProcedure(connection, procedure.toString());
					// Iterate over the resultset.
					while (resultSet.next()) {
						String msg = resultSet.getString("msg");
						String code = resultSet.getString("is_exists");

						BarcLogger.logger.info("message: " + msg);
						BarcLogger.logger.info("is exists bit: " + code);

						// if (code.trim().equalsIgnoreCase("0")) {
						finalList.add(map2);
						// }
					}
				} else {
					finalList.add(map2);
				}
			}

			if (!finalList.isEmpty()) {
				// Send data using API.
				HashMap<String, Object> parameterMap = new HashMap<>();
				// Here define type of HTTP request method
				String method = "POST";

				// Append the parameter strings to API
				String apiUrl = Configuration.getApiUrl();
				for (Map<String, Object> hashMap : finalList) {

					String url = String.valueOf(hashMap.get("complete_media_url"));
					String requestId = String.valueOf(hashMap.get("hashcode"));

					parameterMap.put("RequestId", requestId);
					parameterMap.put("Url", url);
				}
				// Calling the API.
				String result = AccessRestAPI.callingAPI(apiUrl, parameterMap, method);
				BarcLogger.logger.info("API Response: " + result);
			}

		} catch (Exception e) {
			e.printStackTrace(BarcLogger.printStream);
		}
	}
}
