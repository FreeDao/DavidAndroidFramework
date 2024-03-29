package com.wudayu.daf.views;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wudayu.daf.R;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 2:53:37 PM
 * @Description: David Wu created this file.
 *
 **/

public class PageSelectBar extends LinearLayout {

	private Context mContext;
	private List<View> mItems;
	// image resources active
	private int[] imgActived = new int[]{R.drawable.page_select_01_on, R.drawable.page_select_02_on, R.drawable.page_select_03_on};
	// image resources inactive
	private int[] imgInActived = new int[]{R.drawable.page_select_01_off, R.drawable.page_select_02_off, R.drawable.page_select_03_off};
	// words
	private int[] texts = new int[]{R.string.page_select_01, R.string.page_select_02, R.string.page_select_03};
	// words color active
	private int textsColorActived = R.color.col_app;
	// words color inactive
	private int textsColorInActived = R.color.letter_grey_deep_11;
	// background resource active
	private int[] bgActived = null;
	// background resource inactive
	private int[] bgInActived = null;

	private PageSelectBarOnPageSelectedListener mPageSelectedListener = null;

	public PageSelectBar(Context context) {
		super(context);
		init(context);
	}

	public PageSelectBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		this.mContext = context;
		this.mItems = new ArrayList<View>();

		renderPageSelectBar();
		selectItem(0);
	}

	private void renderPageSelectBar() {
		for (int i = 0; i < texts.length; ++i) {
			View item = LayoutInflater.from(mContext).inflate(R.layout.item_page_select_bar, this, false);
			this.addView(item);
			mItems.add(item);
			item.setOnClickListener(new PageOnClickListener(i));
		}
	}

	public void selectItemUI(int position) {
		for (int i = 0; i < mItems.size(); ++i) {
			View item = mItems.get(i);
			RelativeLayout rl = (RelativeLayout) item.findViewById(R.id.rl_page_select_bar_item);
			ImageView iv = (ImageView) item.findViewById(R.id.iv_page_select_bar_item);
			TextView tv = (TextView) item.findViewById(R.id.tv_page_select_bar_item);

			if (i == position) {
				if (texts != null)
					tv.setText(texts[i]);
				if (textsColorActived > 0)
					tv.setTextColor(mContext.getResources().getColor(textsColorActived));
				if (imgActived != null)
					iv.setImageResource(imgActived[i]);
				if (bgActived != null)
					rl.setBackgroundResource(bgActived[i]);
			} else {
				if (texts != null)
					tv.setText(texts[i]);
				if (textsColorInActived > 0)
					tv.setTextColor(mContext.getResources().getColor(textsColorInActived));
				if (imgInActived != null)
					iv.setImageResource(imgInActived[i]);
				if (bgInActived != null)
					rl.setBackgroundResource(bgInActived[i]);
			}
		}
	}

	private void selectItem(int position) {
		selectItemUI(position);

		if (this.mPageSelectedListener != null)
			this.mPageSelectedListener.onPageSelected(position);
	}

	private class PageOnClickListener implements OnClickListener {
		private int position;

		public PageOnClickListener(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View v) {
			selectItem(this.position);
		}
	}

	public interface PageSelectBarOnPageSelectedListener {
		public void onPageSelected(int position);
	}

	public void setPageSelectBarOnPageSelectedListener(PageSelectBarOnPageSelectedListener pageSelectedListener) {
		this.mPageSelectedListener = pageSelectedListener;
	}
	
}
