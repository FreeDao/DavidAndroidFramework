package com.wudayu.daf.activity;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.wudayu.daf.R;
import com.wudayu.daf.adapter.MainActivityPageAdapter;
import com.wudayu.daf.fragment.TestFirstFragment;
import com.wudayu.daf.fragment.TestFirstFragment_;
import com.wudayu.daf.fragment.TestSecondFragment;
import com.wudayu.daf.fragment.TestSecondFragment_;
import com.wudayu.daf.fragment.TestThirdFragment;
import com.wudayu.daf.fragment.TestThirdFragment_;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.service.PushService_;
import com.wudayu.daf.views.PageSelectBar;
import com.wudayu.daf.views.SwitchViewPager;


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

	private static final int PAGE_COUNT = 3;

	@ViewById
	SwitchViewPager vpMain;
	@ViewById
	PageSelectBar psbMain;

	TestFirstFragment testFirstFragment = null;
	TestSecondFragment testSecondFragment = null;
	TestThirdFragment testThirdFragment = null;

	@AfterViews
	void afterViews() {
		initFragments();
		PushService_.intent(mContext).start();
	}

	private void initFragments() {
		MainActivityPageAdapter adapter = new MainActivityPageAdapter(getSupportFragmentManager());

		List<Fragment> fragments = new ArrayList<Fragment>();
		testFirstFragment = new TestFirstFragment_();
		testSecondFragment = new TestSecondFragment_();
		testThirdFragment = new TestThirdFragment_();

		fragments.add(testFirstFragment);
		fragments.add(testSecondFragment);
		fragments.add(testThirdFragment);

		adapter.addAll(fragments);
		vpMain.setAdapter(adapter);
		vpMain.setOffscreenPageLimit(PAGE_COUNT - 1);
		vpMain.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int pos) {
				psbMain.selectItemUI(pos);
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {}
			@Override
			public void onPageScrollStateChanged(int arg0) {}
		});
		psbMain.setPageSelectBarOnPageSelectedListener(new PageSelectBar.PageSelectBarOnPageSelectedListener() {
			@Override
			public void onPageSelected(int position) {
				vpMain.setCurrentItem(position);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		testFirstFragment.onActivityResult(requestCode, resultCode, data);
		testSecondFragment.onActivityResult(requestCode, resultCode, data);
		testThirdFragment.onActivityResult(requestCode, resultCode, data);

		super.onActivityResult(requestCode, resultCode, data);
	}

	/*
	 * Double press back button to exit
	 */
	private static long back_pressed = 0;
	@Override
	public void onBackPressed() {
		if (back_pressed + 2000 > System.currentTimeMillis()) {
			super.closeAllActivity();
			super.onBackPressed();
		} else {
			Utils.toastMessage(this, getString(R.string.str_double_close));
		}

		back_pressed = System.currentTimeMillis();
	}

}
