package com.wudayu.daf.views;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

import com.wudayu.daf.R;

/**
*
* @author: Wu Dayu
* @En_Name: David Wu
* @E-mail: wudayu@gmail.com
* @Created Time: Oct 21, 2014, 11:09:16 AM
* @Description: David Wu created this file.
*
**/

public class ProcessingDialog extends AlertDialog {

	public ProcessingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public ProcessingDialog(Context context, int theme) {
		super(context, theme);
	}

	public ProcessingDialog(Context context) {
		super(context);
	}

	@Override
	public void show() {
		super.show();

		setContentView(R.layout.layout_davidwu_processing_dialog);
		ImageView ivCircle = (ImageView) findViewById(R.id.iv_processing);
		ivCircle.setBackgroundResource(R.drawable.processing_dialog_animation);
		AnimationDrawable frameAnimation = (AnimationDrawable) ivCircle.getBackground();
		frameAnimation.start();
	}

}