package com.wudayu.daf.net.protocol;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wudayu.daf.model.DafWeather;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 31, 2014, 3:52:30 PM
 * @Description: David Wu created this file.
 *
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResult {

	@JsonProperty(value = "weatherinfo")
	private DafWeather weather;

	public DafWeather getWeather() {
		return weather;
	}

	public void setWeather(DafWeather weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "CsCityResult [weather=" + weather.toString() + "]";
	}

}