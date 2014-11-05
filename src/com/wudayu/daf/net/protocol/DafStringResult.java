package com.wudayu.daf.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 5, 2014, 11:28:37 PM
 * @Description: David Wu created this file.
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class DafStringResult extends BaseResult {

	@JsonProperty(value = "objValue")
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "DafStringResult [string=" + str + "]";
	}
}