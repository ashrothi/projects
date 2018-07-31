/**
 * This package contain the classes used to perform service based operation which can be auto wired to access its methods.
 */
package com.springiot.services;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public final class MimeUtils {
	private static final Map<String, String> mimeTypeToExtensionMap = new HashMap<String, String>();
	private static final Map<String, String> extensionToMimeTypeMap = new HashMap<String, String>();

	static {
		// The following table is based on /etc/mime.types data minus
		// chemical/* MIME types and MIME types that don't map to any
		// file extensions. We also exclude top-level domain names to
		// deal with cases like:
		//
		// mail.google.com/a/google.com
		//
		// and "active" MIME types (due to potential security issues).
		// Note that this list is _not_ in alphabetical order and must not be
		// sorted.
		// The "most popular" extension must come first, so that it's the one
		// returned
		// by guessExtensionFromMimeType.

		// Video Extensions
		add("avi", "video/avi");
		add("dl", "video/dl");
		add("dif", "video/dv");
		add("dv", "video/dv");
		add("fli", "video/fli");
		add("m4v", "video/m4v");
		add("ts", "video/mp2ts");
		add("mpeg", "video/mpeg");
		add("mpg", "video/mpeg");
		add("mpe", "video/mpeg");
		add("mp4", "video/mp4");
		add("vob", "video/mpeg");
		add("ogv", "video/ogg");
		add("qt", "video/quicktime");
		add("mov", "video/quicktime");
		add("mxu", "video/vnd.mpegurl");
		add("webm", "video/webm");
		add("lsf", "video/x-la-asf");
		add("lsx", "video/x-la-asf");
		add("mkv", "video/x-matroska");
		add("mng", "video/x-mng");
		add("asf", "video/x-ms-asf");
		add("asx", "video/x-ms-asf");
		add("wm", "video/x-ms-wm");
		add("wmv", "video/x-ms-wmv");
		add("wmx", "video/x-ms-wmx");
		add("wvx", "video/x-ms-wvx");
		add("movie", "video/x-sgi-movie");
		add("wrf", "video/x-webex");
		add("m3u8", "video/x-webex");
		add("mpd", "video/x-webex");
		add("3gp", "video/x-webex");

	}

	private static void add(String mimeType, String extension) {
		// If we have an existing x -> y mapping, we do not want to
		// override it with another mapping x -> y2.
		// If a mime type maps to several extensions
		// the first extension added is considered the most popular
		// so we do not want to overwrite it later.
		if (!mimeTypeToExtensionMap.containsKey(mimeType)) {
			mimeTypeToExtensionMap.put(mimeType, extension);
		}
		if (!extensionToMimeTypeMap.containsKey(extension)) {
			extensionToMimeTypeMap.put(extension, mimeType);
		}
	}

	private MimeUtils() {
	}

	/**
	 * Returns true if the given case insensitive MIME type has an entry in the
	 * map.
	 * 
	 * @param mimeType
	 *            A MIME type (i.e. text/plain)
	 * @return True if a extension has been registered for the given case
	 *         insensitive MIME type.
	 */
	public static boolean hasMimeType(String mimeType) {
		return (guessExtensionFromMimeType(mimeType) != null);
	}

	/**
	 * Returns the MIME type for the given case insensitive file extension.
	 * 
	 * @param extension
	 *            A file extension without the leading '.'
	 * @return The MIME type has been registered for the given case insensitive
	 *         file extension or null if there is none.
	 */
	public static String guessMimeTypeFromExtension(String extension) {
		if (extension == null || extension.isEmpty()) {
			return null;
		}
		extension = extension.toLowerCase(Locale.US);
		return extensionToMimeTypeMap.get(extension);
	}

	/**
	 * Returns true if the given case insensitive extension has a registered
	 * MIME type.
	 * 
	 * @param extension
	 *            A file extension without the leading '.'
	 * @return True if a MIME type has been registered for the given case
	 *         insensitive file extension.
	 */
	public static boolean hasExtension(String extension) {
		return (guessMimeTypeFromExtension(extension) != null);
	}

	/**
	 * Returns the registered extension for the given case insensitive MIME
	 * type. Note that some MIME types map to multiple extensions. This call
	 * will return the most common extension for the given MIME type.
	 * 
	 * @param mimeType
	 *            A MIME type (i.e. text/plain)
	 * @return The extension has been registered for the given case insensitive
	 *         MIME type or null if there is none.
	 */
	public static String guessExtensionFromMimeType(String mimeType) {
		// System.out.println("mimeType" + mimeType);

		if (mimeType == null || mimeType.isEmpty()) {
			return null;
		}
		mimeType = mimeType.toLowerCase(Locale.US);

		// System.out.println("mimeType-----" + mimeType);
		// System.out.println("mimeTypeToExtensionMap" +
		// mimeTypeToExtensionMap);

		return mimeTypeToExtensionMap.get(mimeType);
	}
}