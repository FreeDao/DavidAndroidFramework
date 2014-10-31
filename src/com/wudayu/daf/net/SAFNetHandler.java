package com.wudayu.daf.net;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EBean.Scope;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import android.content.Context;

import com.wudayu.daf.MainApp;
import com.wudayu.daf.constant.Constant;
import com.wudayu.daf.constant.Timeout;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.net.client.WeatherClient;
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
}
