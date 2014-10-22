package com.wudayu.daf.views;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 10:29:17 AM
 * @Description: David Wu created this file.
 *
 **/

public class BaseViewPager extends ViewPager {

	private static final int ROLL = 0x10;
	private static final int TIME_GAP = 10000;

	Timer rollTimer = null;
	boolean isTouching = false;

	public BaseViewPager(Context context) {
		super(context);

		init();
	}

	public BaseViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);

		init();
	}

	private void init() {}

	public void setRollable(boolean rollable) {
		if (rollTimer != null) {
			rollTimer.cancel();
			rollTimer = null;
		}

		if (this.getAdapter() == null || !rollable || this.getAdapter().getCount() < 2) {
			isTouching = false;
			
			return;
		}

		rollTimer = new Timer();
		rollTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = BaseViewPager.ROLL;
				mHandler.sendMessage(msg);
			}
		}, BaseViewPager.TIME_GAP, BaseViewPager.TIME_GAP);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
			case MotionEvent.ACTION_MOVE:
				isTouching = true;
				break;
			case MotionEvent.ACTION_UP:
				isTouching = false;
				break;
			default:
				break;
		}
		return super.onTouchEvent(event);
	}

	@SuppressLint("HandlerLeak")
	Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == BaseViewPager.ROLL && !isTouching) {
				BaseViewPager.this.setCurrentItem((BaseViewPager.this.getCurrentItem() + 1) % getAdapter().getCount());
			}
		}
	};

	@Override
	protected void onDetachedFromWindow() {
		if (rollTimer != null)
			rollTimer.cancel();

		super.onDetachedFromWindow();
	}

	/* 设置页面滚动时间代码，就目前而言不需要
	void init() {
		try {
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(this.getContext(),
                    new AccelerateInterpolator());
            field.set(this, scroller);
            scroller.setmDuration(200);
        } catch (Exception e) {
            Log.e("BaseViewPager", e.toString());
        }
	}

	class FixedSpeedScroller extends Scroller {
	    private int mDuration = 1500;

	    public FixedSpeedScroller(Context context) {
	        super(context);
	    }

	    public FixedSpeedScroller(Context context, Interpolator interpolator) {
	        super(context, interpolator);
	    }

	    @Override
	    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
	        // Ignore received duration, use fixed one instead
	        super.startScroll(startX, startY, dx, dy, mDuration);
	    }

	    @Override
	    public void startScroll(int startX, int startY, int dx, int dy) {
	        // Ignore received duration, use fixed one instead
	        super.startScroll(startX, startY, dx, dy, mDuration);
	    }

	    public void setmDuration(int time) {
	        mDuration = time;
	    }

	    public int getmDuration() {
	        return mDuration;
	    }
	}
	*/
}