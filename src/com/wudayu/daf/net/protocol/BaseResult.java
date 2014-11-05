package com.wudayu.daf.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 5, 2014, 11:28:03 PM
 * @Description: David Wu created this file.
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResult {

	@JsonProperty(value = "result")
	private boolean result;

	@JsonProperty(value = "value")
	private String value;

	public boolean getResultSuccess() {
		return result;
	}

	public String getResultMsg() {
		return value;
	}

	@Override
	public String toString() {
		return "result = " + result + ", value = " + value;
	}
}