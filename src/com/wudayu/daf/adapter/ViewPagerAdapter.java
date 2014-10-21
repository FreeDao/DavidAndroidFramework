package com.wudayu.daf.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:44:06 PM
 * @Description: David Wu created this file.
 *
 **/

public class ViewPagerAdapter extends PagerAdapter {

	protected List<View> views;

	public ViewPagerAdapter() {
		this.views = new ArrayList<View>();
	}

	public void addAll(List<View> datas) {
		this.views.clear();
		this.views.addAll(datas);

		this.notifyDataSetChanged();
	}

	public void removeAll() {
		this.views.clear();
		this.notifyDataSetChanged();
	}

	public int getCount() {
		return views.size();
	}

	public View getView(int position) {
		return views.get(position);
	}

	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(views.get(position));

		return views.get(position);
	}

	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(views.get(position));
	}

	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
}
