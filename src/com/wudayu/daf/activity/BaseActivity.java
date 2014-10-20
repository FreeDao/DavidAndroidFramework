package com.wudayu.daf.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;

import com.wudayu.daf.constant.BroadcastActions;

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

	protected Context context;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);

		context = BaseActivity.this;

		// 注册 关闭Activity本地广播
		LocalBroadcastManager.getInstance(context).registerReceiver(
				finishReceiver,
				new IntentFilter(BroadcastActions.FINISH_ACTIVITY));
	}

	/**
	 * 关闭Activity 广播接收器
	 */
	private BroadcastReceiver finishReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			finish();
		}
	};

	@Override
	protected void onDestroy() {
		try {
			// 注销广播接收器
			LocalBroadcastManager.getInstance(context).unregisterReceiver(
					finishReceiver);
		} catch (Exception e) {
//			Utils.debug("BaseActivity : " + e.toString());
		}

//		Utils.debug("ActivityDestroy ---> " + this.getClass().getSimpleName());
		super.onDestroy();
	}

	/**
	 * 通知所有的Activity关闭
	 */
	protected void closeAllActivity() {
		LocalBroadcastManager.getInstance(BaseActivity.this).sendBroadcast(
				new Intent(BroadcastActions.FINISH_ACTIVITY));
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		super.onActivityResult(arg0, arg1, arg2);
	}

}
