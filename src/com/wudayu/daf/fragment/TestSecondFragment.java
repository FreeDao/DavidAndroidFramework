package com.wudayu.daf.fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

import com.wudayu.daf.R;
import com.wudayu.daf.constant.WeatherCityCode;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.model.DafWeather;
import com.wudayu.daf.net.INetHandler;
import com.wudayu.daf.net.SAFNetHandler;
import com.wudayu.daf.net.protocol.WeatherResult;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:55:16 PM
 * @Description: David Wu created this file.
 *
 **/

@EFragment(R.layout.fragment_test_second)
public class TestSecondFragment extends BaseFragment {

	@ViewById
	TextView tvWeather;

	@Bean(SAFNetHandler.class)
	INetHandler netHandler;

	private DafWeather weather = null;

	@AfterViews
	void afterViews() {
		testWeather();
	}

	@Background
	void testWeather() {
		WeatherResult result = netHandler.getForWeather(WeatherCityCode.findCityCodeByCityName("苏州"));

		if (null == result) {
			goBackMainThread(getString(R.string.error_server_went_wrong), false);
			return;
		}

		weather = result.getWeather();
		goBackMainThread(null, true);
	}

	@UiThread
	void goBackMainThread(String msg, boolean success) {
		if (success) {
			doBindData();
		} else {
			Utils.toastMessage(this.getActivity(), msg);
		}
	}

	void doBindData() {
		tvWeather.setText(weather.toString());
	}

}
