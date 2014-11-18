package com.wudayu.daf.net;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import android.content.Context;

import com.wudayu.daf.MainApp;
import com.wudayu.daf.constant.Constant;
import com.wudayu.daf.constant.Timeout;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.net.client.ImageClient;
import com.wudayu.daf.net.client.WeatherClient;
import com.wudayu.daf.net.protocol.BaseResult;
import com.wudayu.daf.net.protocol.DafStringResult;
import com.wudayu.daf.net.protocol.WeatherResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 31, 2014, 3:41:10 PM
 * @Description: David Wu created this file.
 *
 **/

@EBean(scope = Scope.Singleton)
public class SAFNetHandler implements INetHandler {

	@RootContext
	Context mContext;

	@App
	MainApp mApp;

	/**
	 * set timeout time
	 * 
	 * @param client
	 * @param time, use final integer from the class Timeout
	 */
	private void setTimeout(RestClientSupport client, int time) {
		client.getRestTemplate().setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		((HttpComponentsClientHttpRequestFactory) client.getRestTemplate().getRequestFactory()).setReadTimeout(time);
		((HttpComponentsClientHttpRequestFactory) client.getRestTemplate().getRequestFactory()).setConnectTimeout(time);
	}

	@RestService
	WeatherClient mWeatherClient;
	@Override
	public WeatherResult getForWeather(String code) {
		try {
			mWeatherClient.setHeader(HEADER_CONTENT_ENCODING, INetHandler.CONTANT_CODE);
			setTimeout(mWeatherClient, Timeout.TIMEOUT_THIRTY_SECONDS);

			return mWeatherClient.getWeather(Constant.SERVER_URL_WEATHER, code);
		} catch (Throwable e) {
			Utils.debug("getForWeather : " + e.toString());
		}
		return null;
	}

	@RestService
	ImageClient mImageClient;
	@Override
	public DafStringResult postForUploadPic(String relationId, String fileKey, String imagePath) {
		try {

			mImageClient.setHeader(HEADER_CONTENT_DISPOSITION, "form-data; name=\"" + fileKey + "\";");
			mImageClient.setHeader(HEADER_CONTENT_TYPE, "multipart/form-data");
			mImageClient.setHeader(HEADER_CONTENT_ENCODING, CONTANT_CODE);
			setTimeout(mImageClient, Timeout.TIMEOUT_ONE_MINUTE);

			MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
			params.add(fileKey, new FileSystemResource(imagePath));

			DafStringResult ss = mImageClient.uploadPic(Constant.SERVER_URL_FOR_SPRING, relationId == null ? "" : relationId, params);
			ssss(ss);
			return ss;
		} catch (Throwable e) {
			Utils.debug("postForUploadPic : " + e.toString());
		}
		return null;
	}

	@UiThread
	void ssss(BaseResult br) {
		
	}
}
