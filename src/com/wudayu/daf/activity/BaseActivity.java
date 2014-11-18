package com.wudayu.daf.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;

import com.wudayu.daf.constant.BroadcastActions;
import com.wudayu.daf.generic.Utils;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 20, 2014, 9:52:39 PM
 * @Description: David Wu created this file.
 *
 **/

public class BaseActivity extends FragmentActivity {

	protected Context mContext;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		mContext = BaseActivity.this;

		// register close all Activity Broadcast
		LocalBroadcastManager.getInstance(mContext).registerReceiver(finishReceiver, new IntentFilter(BroadcastActions.FINISH_ACTIVITY));
	}

	private BroadcastReceiver finishReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			finish();
		}
	};

	@Override
	protected void onDestroy() {
		// unregister close all Activity Broadcast
		try {
			LocalBroadcastManager.getInstance(mContext).unregisterReceiver(finishReceiver);
		} catch (Exception e) {
			Utils.debug("BaseActivity : " + e.toString());
		}

		super.onDestroy();
	}

	protected void closeAllActivity() {
		LocalBroadcastManager.getInstance(BaseActivity.this).sendBroadcast(new Intent(BroadcastActions.FINISH_ACTIVITY));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

}
