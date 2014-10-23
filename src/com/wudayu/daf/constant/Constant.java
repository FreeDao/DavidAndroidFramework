package com.wudayu.daf.constant;

import android.os.Environment;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 23, 2014, 4:51:22 PM
 * @Description: David Wu created this file.
 *
 **/

public class Constant {

	public static final String SD_CARD = Environment.getExternalStorageDirectory().getAbsolutePath();

	public static String SD_CARD_DAF = SD_CARD + "/daf/";
	public static String SD_DOWNLOAD = SD_CARD + "/daf/download/";
	public static String SD_LOG = SD_CARD + "/daf/log/";
	public static String SD_IMAGE_CACHE = SD_CARD + "/daf/image/cache/";

	public static final String PREFIX_HTTP = "http://";
	public static final String PREFIX_HTTPS = "https://";

	/** Test Address & Official Address */
	public static final String SERVER_URL_TEST = "";
	public static final String SERVER_URL_OFFICAL_PRE = "";
	public static final String SERVER_URL_OFFICAL = "";

	/** Default Server Address Prefix */
	public static final String PREFIX_DEFAULT = PREFIX_HTTP;
//	public static final String PREFIX_DEFAULT = PREFIX_HTTPS;

	/**
	 * Server URL Names
	 * 
	 * TODO Switch to the last one when publish
	 */
	public static final String SERVER_URL_NAME = SERVER_URL_TEST;
//	public static final String SERVER_URL_NAME = SERVER_URL_OFFICAL_PRE;
//	public static final String SERVER_URL_NAME = SERVER_URL_OFFICAL;

	/** Used by the Class which implements INetHandler */
	public static final String SERVER_URL_FOR_SPRING = PREFIX_DEFAULT + SERVER_URL_NAME;

	/** Debug Mode, TODO Change it to false when publish */
	public static final boolean DEBUG = true;

	/** Image Quality in Percentage */
	public static final int IMAGE_QUALITY = 60;

	/** Ignore Unknown Json Property, TODO Change it to true when publish */
	public static final boolean jsonIgnoreUnknown = false;

	/** Always Ignore Unknown Json Property */
	public static final boolean jsonIgnoreTooMuch = true;

}
