package com.wudayu.daf;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import android.app.Application;

import com.nostra13.universalimageloader.utils.L;
import com.wudayu.daf.handler.IImageHandler;
import com.wudayu.daf.handler.UILImageHandler;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 28, 2014, 4:58:16 PM
 * @Description: David Wu created this file.
 *
 **/

@EApplication
public class MainApp extends Application {

	@Bean(UILImageHandler.class)
	IImageHandler imageHandler;
	
	@Override
	public void onCreate() {
		super.onCreate();
		initUIL();
	}

	private void initUIL() {
		imageHandler.initImageLoader();
		L.writeLogs(false);
	}

}
