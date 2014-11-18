package com.wudayu.daf;

import java.util.Timer;
import java.util.TimerTask;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.SystemService;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import com.wudayu.daf.activity.MainActivity_;
import com.wudayu.daf.constant.ExtraNames;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Nov 18, 2014, 5:01:46 PM
 * @Description: David Wu created this file.
 *
 **/

@EService
public class PushService extends Service {


	@SystemService
	NotificationManager notificationManager;

	@App
	MainApp mApp;

	Timer timer = null;

	public static final long PUSH_GAP = 10000;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		// registerBroadCast();

		timer = new Timer();
		timer.schedule(new PushTimerTask(this), 2000, PUSH_GAP);

		super.onCreate();
	}

	public void registerBroadCast() {
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);

		filter.addAction(Intent.ACTION_BATTERY_CHANGED);

		// BroadcastReceiver mReceiver = new PushDaemonReceiver();

		// registerReceiver(mReceiver, filter);
	}


	class PushTimerTask extends TimerTask {

		Context context;

		public PushTimerTask(Context context) {
			this.context = context;
		}

		@Override
		public void run() {
			String keyCode = "testKeyCode";

			NotificationCompat.Builder mBuilder =
			        new NotificationCompat.Builder(context)
					.setAutoCancel(true)
			        .setSmallIcon(R.drawable.ic_launcher)
			        .setContentTitle(getString(R.string.app_name))//getString(R.string.app_name))
			        .setContentText("testContent");

			Intent resultIntent = new Intent(context, MainActivity_.class);
			resultIntent.putExtra(ExtraNames.PUSH_TYPE, keyCode);

			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
		
			notificationManager.notify(0x1022, mBuilder.build());
		}
	}

	@Override
	public void onDestroy() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				PushService_.intent(getApplicationContext()).start();
			}
		}, 5000);

		super.onDestroy();
	}
}
