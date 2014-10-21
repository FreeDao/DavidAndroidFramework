package com.wudayu.daf.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:43:15 PM
 * @Description: David Wu created this file.
 *
 **/

public class MainActivityPageAdapter extends FragmentPagerAdapter {
	List<Fragment> fragments = null;

	public MainActivityPageAdapter(FragmentManager fm) {
		super(fm);
		fragments = new ArrayList<Fragment>();
	}

	public void addAll(List<Fragment> pages) {
		fragments.clear();
		fragments.addAll(pages);
		this.notifyDataSetChanged();
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

}