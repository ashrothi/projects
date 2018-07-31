package com.springiot.controllers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springiot.response.Message;
import com.springiot.services.GenericProcess;
import com.springiot.services.MimeUtils;
import com.springiot.swagger.response.UploadImageSwagger;
import com.springiot.swagger.response.XfusionUsersGetApiAccessSwagger;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * This class is a controller class used for the voot demo application.
 */
@Controller
public class BarcController {

	// Access the functionality of some other class.
	@Autowired
	private MimeUtils mimeUtils;

	// Access the functionality of some other class.
	@Autowired
	private GenericProcess genericProcess;

	/**
	 * This api is used to ping the barc server and returns the success or
	 * failure response.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */

	@ApiOperation(value = "/barc/ping/server", notes = "This API is used to ping server to inform that the media URL was accessed locally using cache ", response = XfusionUsersGetApiAccessSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "media_url", value = "Requires the media url", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_name", value = "Requires the application name", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_version", value = "Requires the version of app", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ad_duration", value = "Requires the duration of ad", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_agent", value = "Requires the agent of user", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires the location latitude", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the location longitude", required = false, paramType = "query", dataType = "String") })

	@RequestMapping(value = "/barc/ping/server", method = RequestMethod.POST)
	public @ResponseBody Message oauthToken(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, String> map) {
		/*
		 * To call the procedure required for data processing.
		 */
		Message message = new Message();
		try {

			// Map required for the input parameters of the calling procedure.
			Map<String, Object> inputMap = new LinkedHashMap<>();

			String ipAddress = req.getRemoteHost();

			String mediaURL = "";
			String results = "";

			StringBuilder builder = new StringBuilder();

			// Get the extension of media url
			String extension = FilenameUtils.getExtension(map.get("media_url").toString());
			System.out.println("extension --" + extension);

			// Get the extension type of media url.
			String extensionType = mimeUtils.guessExtensionFromMimeType(extension);
			System.out.println("extensionType--" + extensionType);

			// Check extension type is video or not
			if (String.valueOf(extensionType).contains("video")) {

				// Check whether multiple media url exists or not
				if (map.get("media_url").toString().equals("#ttpl#")) {

					// If exists,then split the media urls.
					String mediaURLArray[] = map.get("media_url").toString().split("#ttpl#");

					for (int i = 0; i < mediaURLArray.length; i++) {

						// Replace the initial url strings like hhtp,https or
						// www.
						if (mediaURLArray[i].contains("http")) {

							results = mediaURLArray[i].substring(mediaURLArray[i].indexOf("//") + 2);
							System.out.println("mediaURL" + results);

							if (mediaURLArray[i].contains("www")) {

								results = results.substring(results.indexOf(".") + 1);
								System.out.println("mediaURL" + results);
							}

						} else if (mediaURLArray[i].contains("www")) {

							results = mediaURLArray[i].substring(mediaURLArray[i].indexOf(".") + 1);
							System.out.println("mediaURL" + results);

						} else {
							results = map.get("media_url").toString();
						}

						// append the results in builder.
						builder.append(results + ",");

					}
					System.out.println("BUILDER__" + builder);
					builder.deleteCharAt(builder.lastIndexOf(","));

				}

				// If there's only one media url presnt
				else {

					// Replace all the initials of media url like http,https or
					// www.
					if (map.get("media_url").toString().contains("http")) {

						mediaURL = map.get("media_url").toString()
								.substring(map.get("media_url").toString().indexOf("//") + 2);
						System.out.println("mediaURL" + mediaURL);

						if (mediaURL.contains("www")) {

							mediaURL = mediaURL.substring(mediaURL.indexOf(".") + 1);
							System.out.println("mediaURL" + mediaURL);

						}

					} else if (map.get("media_url").toString().contains("www")) {

						mediaURL = map.get("media_url").toString()
								.substring(map.get("media_url").toString().indexOf(".") + 1);
						System.out.println("mediaURL" + mediaURL);

					} else {
						mediaURL = map.get("media_url").toString();
					}
					builder.append(mediaURL);
				}

				long time = System.currentTimeMillis() / 1000;

				// Input parameters of the procedure
				inputMap.put("media_url", builder.toString());
				inputMap.put("ip_address", ipAddress);
				inputMap.put("log_time", time);
				inputMap.put("app_name", map.get("app_name"));
				inputMap.put("app_version", map.get("app_version"));
				inputMap.put("ad_duration", map.get("ad_duration"));
				inputMap.put("user_agent", map.get("user_agent"));
				inputMap.put("latitude", map.get("latitude"));
				inputMap.put("longitude", map.get("longitude"));

				// Calling of procedure
				message = genericProcess.GenericProcedureCalling("1", inputMap);

			} else

			{
				// If media url is not valid means the media url is not of video
				// format
				String extensionValueMedia = "Media url not valid";
				builder.append(extensionValueMedia);

				// set the response message
				message.setDescription("Process Success");
				message.setObject(builder);
				message.setValid(true);

			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		/*
		 * Return the response message.
		 */
		return message;

	}

	/**
	 * This api is used to return hashcode for the respective medis uel.
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */
	@ApiOperation(value = "/barc/get/hashcode", notes = "This API helps to retrieve unique hash code and tiny url associated with media URL. ", response = UploadImageSwagger.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "media_url", value = "Requires the media url", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_name", value = "Requires the application name", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "app_version", value = "Requires the version of app", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "ad_duration", value = "Requires the duration of ad", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "user_agent", value = "Requires the agent of user", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "latitude", value = "Requires the location latitude", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "longitude", value = "Requires the location longitude", required = false, paramType = "query", dataType = "String") })

	@RequestMapping(value = "/barc/get/hashcode", method = RequestMethod.POST)
	public @ResponseBody Message getHashcode(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		Message message = new Message();

		/*
		 * To call the procedure required for data processing.
		 */
		String mediaURL = "";
		String results = "";

		StringBuilder builder = new StringBuilder();

		// Get the extension of media url
		String extension = FilenameUtils.getExtension(map.get("media_url").toString());
		System.out.println("extension --" + extension);

		// Get the extension type of media url
		String extensionType = mimeUtils.guessExtensionFromMimeType(extension);
		System.out.println("extensionType--" + extensionType);

		// Media url exension type is video or not
		if (String.valueOf(extensionType).contains("video")) {

			if (map.get("media_url").toString().contains("#ttpl#")) {

				String mediaURLArray[] = map.get("media_url").toString().split("#ttpl#");

				// For loop for handling multiple media urls.
				for (int i = 0; i < mediaURLArray.length; i++) {

					// Replace all the initials of media url like http,https or
					// www.
					if (mediaURLArray[i].contains("http")) {

						results = mediaURLArray[i].substring(mediaURLArray[i].indexOf("//") + 2);
						System.out.println("mediaURL" + results);

						if (mediaURLArray[i].contains("www")) {

							results = results.substring(results.indexOf(".") + 1);
							System.out.println("mediaURL" + results);

						}

					} else if (mediaURLArray[i].contains("www")) {

						results = mediaURLArray[i].substring(mediaURLArray[i].indexOf(".") + 1);
						System.out.println("mediaURL" + results);

					} else {
						results = map.get("media_url").toString();
					}

					builder.append(results + ",");

				}
				System.out.println("BUILDER__" + builder);
				builder.deleteCharAt(builder.lastIndexOf(","));

			} else {
				// Replace all the initials of media url like http,https or www.
				if (map.get("media_url").toString().contains("http")) {

					mediaURL = map.get("media_url").toString()
							.substring(map.get("media_url").toString().indexOf("//") + 2);
					System.out.println("mediaURL" + mediaURL);

					if (mediaURL.contains("www")) {

						mediaURL = mediaURL.substring(mediaURL.indexOf(".") + 1);
						System.out.println("mediaURL" + mediaURL);

					}

				} else if (map.get("media_url").toString().contains("www")) {

					mediaURL = map.get("media_url").toString()
							.substring(map.get("media_url").toString().indexOf(".") + 1);
					System.out.println("mediaURL" + mediaURL);

				} else {
					mediaURL = map.get("media_url").toString();
				}
				builder.append(mediaURL);
			}

			// Calling of procedure to retrieve hashcode
			Map<String, Object> map1 = new HashMap<>();
			map1.put("media_url", builder.toString());

			message = genericProcess.GenericProcedureCalling("2", map1);

			long time = System.currentTimeMillis() / 1000;

			if (message.isValid()) {

				// Calling of procedure to insert audit logs
				Map<String, Object> inputMap = new LinkedHashMap<>();

				String ipAddress = req.getRemoteHost();

				inputMap.put("media_url", builder.toString());
				inputMap.put("ip_address", ipAddress);
				inputMap.put("log_time", time);
				inputMap.put("app_name", map.get("app_name"));
				inputMap.put("app_version", map.get("app_version"));
				inputMap.put("ad_duration", map.get("ad_duration"));
				inputMap.put("user_agent", map.get("user_agent"));
				inputMap.put("latitude", map.get("latitude"));
				inputMap.put("longitude", map.get("longitude"));

				// Set the response message
				Message Responsemessage = genericProcess.GenericProcedureCalling("1", inputMap);

			}
		} else {

			// Handled the case where media url has not valid extension type.
			String extensionValueMedia = "Media url not valid";
			builder.append(extensionValueMedia);

			message.setDescription("Process Success");
			message.setObject(builder);
			message.setValid(true);

		}

		/*
		 * Return the response message.
		 */
		return message;
	}

	/**
	 * This api is used to redirect from tiny url to the respective media url
	 * 
	 * @param req,contains
	 *            the httpservlet request.
	 * @param res,contains
	 *            the httpservlet response
	 * @param map,contains
	 *            all the input parameters
	 * @return
	 */
	@ApiIgnore
	@RequestMapping(value = "/barc/media/url/get", method = RequestMethod.POST)
	public @ResponseBody Message getTinyUrlToMainUrl(HttpServletRequest req, HttpServletResponse res,
			@ApiIgnore @RequestParam Map<String, Object> map) {

		// Calling of the procedure
		Message Responsemessage = genericProcess.GenericProcedureCalling("3", map);

		return Responsemessage;

	}

}
