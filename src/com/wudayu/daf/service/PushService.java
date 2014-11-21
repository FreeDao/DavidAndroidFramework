package com.wudayu.daf.service;

import java.util.Timer;
import java.util.TimerTask;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EService;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.UiThread;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.wudayu.daf.MainApp;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.net.INetHandler;
import com.wudayu.daf.net.SAFNetHandler;
import com.wudayu.daf.receiver.PushReceiver_;

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

	@Bean(SAFNetHandler.class)
	INetHandler netHandler;

	@App
	MainApp mApp;

	Timer timer = null;

	public static final long PUSH_GAP = 5000;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		Utils.debug("onCreate() called ------------ ");
		
		registerBroadcast();

		timer = new Timer();
		timer.schedule(new PushTimerTask(this), 2000, PUSH_GAP);

		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Utils.debug("onStartCommand() called ------------ ");
		flags = START_STICKY;
		return super.onStartCommand(intent, flags, startId);
	}

	private void registerBroadcast() {
		IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);

		filter.addAction(Intent.ACTION_BOOT_COMPLETED);
		filter.addAction(Intent.ACTION_BATTERY_CHANGED);
		filter.addAction(Intent.ACTION_SCREEN_ON);

		BroadcastReceiver mReceiver = new PushReceiver_();

		registerReceiver(mReceiver, filter);
	}


	class PushTimerTask extends TimerTask {

		Context context;
		int i;

		public PushTimerTask(Context context) {
			Utils.debug("PushTimerTask() called ---------- ");
			this.context = context;
			this.i = 0;
		}

		@Override
		public void run() {
			/*
			String keyCode = "testKeyCode";

			NotificationCompat.Builder mBuilder =
			        new NotificationCompat.Builder(context)
					.setAutoCancel(true)
			        .setSmallIcon(R.drawable.ic_launcher)
			        .setContentTitle(getString(R.string.app_name))//getString(R.string.app_name))
			        .setContentText("Current = " + i++);

			Intent resultIntent = new Intent(context, MainActivity_.class);
			resultIntent.putExtra(ExtraNames.PUSH_TYPE, keyCode);

			TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
			stackBuilder.addNextIntent(resultIntent);
			PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
			mBuilder.setContentIntent(resultPendingIntent);
		
			notificationManager.notify(0x1022, mBuilder.build());
			*/

			toast(i++);
		}
	}

	@UiThread
	void toast(int i) {
		Utils.debug("I = " + i + ", netHandler = " + netHandler.hashCode());
	}

	@Override
	public void onDestroy() {
		Intent pushIntent = new Intent("com.wudayu.daf.push");
		sendBroadcast(pushIntent);

		super.onDestroy();
	}

}
