package com.wudayu.daf.fragment;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wudayu.daf.R;
import com.wudayu.daf.listener.BannerViewOnItemClickListener;
import com.wudayu.daf.views.BannerView;
import com.wudayu.daf.views.CountDownView;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:52:32 PM
 * @Description: David Wu created this file.
 *
 **/

@EFragment(R.layout.fragment_test_first)
public class TestFirstFragment extends BaseFragment {

	@ViewById
	BannerView bvBanner;
	@ViewById
	CountDownView tvCountDown;

	@AfterViews
	void afterViews() {
		testData();
	}

	private void testData() {
		// Homepage Banner
		List<View> views = new ArrayList<View>();
		ImageView view = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		view.setBackgroundColor(Color.parseColor("#00FF00"));
		view.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_FIRST));
		ImageView view2 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		view2.setBackgroundColor(Color.parseColor("#FF0000"));
		view2.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_SECOND));
		ImageView view3 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		view3.setBackgroundColor(Color.parseColor("#0000FF"));
		view3.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_THIRD));
		views.add(view);
		views.add(view2);
		views.add(view3);
		bvBanner.setViews(views);
		bvBanner.setRolling(3000);

		// CountDownView
		tvCountDown.setCountDownAndStart(3000, 10);
		tvCountDown.setOnCountDownFinishListener(new CountDownView.OnCountDownFinishListener() {
			@Override
			public void onFinish() {
				Toast.makeText(TestFirstFragment.this.getActivity(), "Done", Toast.LENGTH_LONG).show();
			}
		});
	}
	
}
