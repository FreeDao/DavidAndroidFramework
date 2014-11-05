package com.wudayu.daf.net;

import com.wudayu.daf.net.protocol.DafStringResult;
import com.wudayu.daf.net.protocol.WeatherResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 31, 2014, 3:22:41 PM
 * @Description: David Wu created this file.
 *
 **/

public interface INetHandler {

	public static final String HEADER_CLIENT_SESSION = "client-session";
	public static final String HEADER_CLIENT_VERSION = "client-version";
	public static final String HEADER_API_VERSION = "api-version";
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
	public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
	public static final String HEADER_CONNECTION = "Connection";
	public static final String HEADER_REGION_CODE = "Region-Code";
	public static final String HEADER_HOST = "Host";

	public static final String CONTANT_CODE = "UTF-8";

	/** 获取天气 */
	public WeatherResult getForWeather(String code);

	/** 上传图片 */
	public DafStringResult postForUploadPic(String relationId, String fileKey, String imagePath);
}
