package com.wudayu.daf.receiver;

import org.androidannotations.annotations.EReceiver;

import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.service.PushService_;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 19, 2014, 4:19:16 PM
 * @Description: David Wu created this file.
 *
 **/

@EReceiver
public class PushReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Utils.debug("PushReceiver.onReceive() ------------------");
		PushService_.intent(context).start();
	}

}
