package com.wudayu.daf.net.client;

import org.androidannotations.annotations.rest.Accept;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.androidannotations.api.rest.RestClientHeaders;
import org.androidannotations.api.rest.RestClientSupport;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;

import com.wudayu.daf.net.INetHandler;
import com.wudayu.daf.net.protocol.DafStringResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 5, 2014, 11:34:06 PM
 * @Description: David Wu created this file.
 *
 **/

@Rest(converters = { ByteArrayHttpMessageConverter.class, FormHttpMessageConverter.class, StringHttpMessageConverter.class, MappingJackson2HttpMessageConverter.class })
public interface ImageClient extends RestClientErrorHandling, RestClientSupport, RestClientHeaders {
	@Post("{url}/rest/sys/uploadPic?id={relationId}")
	@Accept(MediaType.APPLICATION_JSON_VALUE)
	@RequiresHeader({INetHandler.HEADER_CONTENT_TYPE, INetHandler.HEADER_CONTENT_DISPOSITION})
	DafStringResult uploadPic(String url, String relationId,  MultiValueMap<String,Object> params);
}