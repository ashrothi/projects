/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.springiot.response.Message;

/**
 * This server class is used to remove all the extensions of media url and then
 * store in the database.
 * 
 * @author tanvi
 *
 */
@Service
@PropertySource(value = "classpath:/config.properties")
public class MediaUrlServices {

	// Access the functionality of some other class.
	@Autowired
	private GenericProcess genericProcess;
	@Autowired
	Environment environment;
	@Autowired
	private KafkaServices kafkaServices;

	/**
	 * This method helps to remove all infix annotations from the media url
	 * 
	 * @param mediaUrlToConvert,this
	 *            contains the media url
	 * @return
	 */
	public String mediaUrlConversion(String mediaUrlToConvert) {

		// Initializing the variables
		String response = "";
		StringBuilder builder = new StringBuilder();
		try {
			// Initializing the variables
			String mediaURL = "";
			String results = "";

			// check if multiple media url exists
			if (mediaUrlToConvert.contains("#ttpl#")) {

				// Split the media url with the separator
				String mediaURLArray[] = mediaUrlToConvert.split("#ttpl#");

				// For loop for handling multiple media urls.
				for (int i = 0; i < mediaURLArray.length; i++) {

					// Replace all the initials of media url like http,https or
					// www.
					if (mediaURLArray[i].contains("http")) {

						results = mediaURLArray[i].substring(mediaURLArray[i].indexOf("//") + 2);
						// System.out.println("mediaURL" + results);

						if (mediaURLArray[i].contains("www")) {

							results = results.substring(results.indexOf(".") + 1);

						}
					}
					// Check if media url contains www infix
					else if (mediaURLArray[i].contains("www")) {

						results = mediaURLArray[i].substring(mediaURLArray[i].indexOf(".") + 1);

					} else {
						results = mediaUrlToConvert;
					}

					builder.append(results + ",");
				}
				builder.deleteCharAt(builder.lastIndexOf(","));

			} else {
				// Replace all the initials of media url like http,https or www.
				if (mediaUrlToConvert.contains("http")) {

					mediaURL = mediaUrlToConvert.substring(mediaUrlToConvert.indexOf("//") + 2);

					// Check if media url contains www infix
					if (mediaURL.contains("www")) {

						mediaURL = mediaURL.substring(mediaURL.indexOf(".") + 1);

					}
				}
				// Check if media url contains www infix
				else if (mediaUrlToConvert.contains("www")) {

					mediaURL = mediaUrlToConvert.substring(mediaUrlToConvert.indexOf(".") + 1);

				} else {
					mediaURL = mediaUrlToConvert;
				}
				builder.append(mediaURL);
			}

		}
		// Handling all exceptions
		catch (Exception exception) {
			exception.printStackTrace();
		}

		// Returns the converted media url in response parameter
		response = builder.toString();
		return response;
	}

	public Message pingServer(Map<String, String> map, HttpServletRequest req, HttpServletResponse res) {
		Message message = new Message();
		// Map required for the input parameters of the calling procedure.
		Map<String, Object> inputMap = new LinkedHashMap<>();

		String ipAddress = req.getRemoteHost();

		StringBuilder builder = new StringBuilder();

		// Get the extension of media url
		String extension = FilenameUtils.getExtension(String.valueOf(map.get("media_url")));
		// System.out.println("extension --" + extension);

		// Get the extension type of media url.
		String extensionType = MimeUtils.guessExtensionFromMimeType(extension);
		// System.out.println("extensionType--" + extensionType);

		// Check extension type is video or not
		if (String.valueOf(extensionType).contains("video")) {
			String mediaURL = String.valueOf(map.get("media_url")).replace("video/mp4", "video%2Fmp4")
					.replace("video/webm", "video%2Fwebm").replace("video/3gpp", "video%2F3gpp");
			map.put("media_url", mediaURL);
			String mediaUrl = mediaUrlConversion(String.valueOf(map.get("media_url")));
			// System.out.println("mediaUrl" + mediaUrl);

			long time = System.currentTimeMillis() / 1000;

			// Retrieve from where the request is coming to API String
			String type = req.getHeader("User-Agent");
			// System.out.println("type" + type);

			String requestType = "";

			if (type.contains("okhttp")) {
				requestType = "mobile";
			} else {
				requestType = "web";
			}

			// Input parameters of the procedure
			inputMap.put("media_url", mediaUrl);
			inputMap.put("complete_media_url", map.get("media_url"));
			inputMap.put("hash_code", map.get("hash_code"));
			inputMap.put("tiny_url", map.get("tiny_url"));
			inputMap.put("ip_address", ipAddress);
			inputMap.put("log_time", time);
			inputMap.put("app_name", map.get("app_name"));
			inputMap.put("app_version", map.get("app_version"));
			inputMap.put("ad_duration", map.get("ad_duration"));
			inputMap.put("user_agent", map.get("user_agent"));
			inputMap.put("latitude", map.get("latitude"));
			inputMap.put("longitude", map.get("longitude"));
			inputMap.put("ad_click_url", map.get("ad_click_url"));
			inputMap.put("request_type", requestType);

			// Calling of procedure
			message = genericProcess.GenericProcedureCallingPingServer("1", inputMap);

		} else {
			// If media url is not valid means the media url is not of video
			// format
			String extensionValueMedia = "Media url not valid";
			builder.append(extensionValueMedia);

			// set the response message
			message.setDescription("Process Success");
			message.setObject(builder);
			message.setValid(true);
		}
		/*
		 * Return the response message.
		 */
		return message;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public Message getHashCode(Map<String, Object> map, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Message message = new Message();

		StringBuilder builder = new StringBuilder();

		// if (String.valueOf(map.get("media_url")).contains("video/mp4")) {
		String mediaURL = String.valueOf(map.get("media_url")).replace("video/mp4", "video%2Fmp4")
				.replace("video/webm", "video%2Fwebm").replace("video/3gpp", "video%2F3gpp");
		map.put("media_url", mediaURL);

		// Get the extension of media url
		String extension = FilenameUtils.getExtension(String.valueOf(map.get("media_url")));

		// Get the extension type of media url
		String extensionType = MimeUtils.guessExtensionFromMimeType(extension);

		// Media url extension type is video or not
		if (String.valueOf(extensionType).contains("video")) {

			String mediaUrl = mediaUrlConversion(String.valueOf(map.get("media_url")));
			// System.out.println("mediaUrl" + mediaUrl);

			String hostAddress = environment.getProperty("host.address");
			// System.out.println(hostAddress);

			// Calling of procedure to retrieve hashcode
			LinkedHashMap<String, Object> inputMap = new LinkedHashMap<>();
			inputMap.put("complete_media_url", String.valueOf(map.get("media_url")));
			inputMap.put("media_url", mediaUrl);
			inputMap.put("hostAddress", hostAddress);

			message = genericProcess.GenericProcedureCalling("2", inputMap, req, res);

			List<Map<String, Object>> data = (List<Map<String, Object>>) message.getObject();
			// System.out.println("data " + data);
			if (data.size() > 0 && data.get(0).get("is_exist").toString().equalsIgnoreCase("0")) {
				data.get(0).remove("is_exist");

				Boolean valid = kafkaServices.executeNotificationtoKafka(data, req, res);

			} else {
				data.get(0).remove("is_exist");

			}
			message.setDescription("Process Success");
			message.setObject(data);
			message.setValid(true);
			return message;

		} else {

			// Handled the case where media url has not valid extension type.
			String extensionValueMedia = "Media url not valid";
			builder.append(extensionValueMedia);

			message.setDescription("Process Success");
			message.setObject(builder);
			message.setValid(true);
		}
		return message;
	}
}
