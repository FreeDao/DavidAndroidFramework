package com.wudayu.daf.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 10:22:14 AM
 * @Description: David Wu created this file.
 *
 **/

public class NoSlideViewPager extends BaseViewPager {

	public NoSlideViewPager(Context context) {
		super(context);
	}

	public NoSlideViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
  
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		return false;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		return false;
	}
}
