package com.wudayu.daf.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.wudayu.daf.R;
import com.wudayu.daf.views.PageSelectBar;


/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 20, 2014, 10:02:04 PM
 * @Description: David Wu created this file.
 *
 **/

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {

	@ViewById
	PageSelectBar psbMain;

	@AfterViews
	void afterViews() {
		
	}

}
