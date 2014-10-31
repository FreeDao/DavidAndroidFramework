package com.wudayu.daf.net.client;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;

import com.wudayu.daf.net.converter.MappingJacksonDavidHttpMessageConverter;
import com.wudayu.daf.net.protocol.WeatherResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 31, 2014, 3:56:33 PM
 * @Description: David Wu created this file.
 *
 **/

@Rest(converters = { FormHttpMessageConverter.class, MappingJacksonDavidHttpMessageConverter.class })
public interface WeatherClient extends RestClientErrorHandling, RestClientSupport, RestClientHeaders {
	@Get("{url}/{code}.html")
	@Accept(MediaType.TEXT_HTML_VALUE)
	WeatherResult getWeather(String url, String code);
}
