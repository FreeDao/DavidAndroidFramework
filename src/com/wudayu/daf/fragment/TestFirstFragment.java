package com.wudayu.daf.fragment;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.wudayu.daf.R;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.handler.IImageHandler;
import com.wudayu.daf.handler.UILImageHandler;
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
	@ViewById
	EditText edtTestAutohide;
	@ViewById
	ImageView ivTest;

	@Bean(UILImageHandler.class)
	IImageHandler imageHandler;

	@AfterViews
	void afterViews() {
		testData();
	}

	private void testData() {
		// HomePageBanner
		List<View> views = new ArrayList<View>();
		ImageView view1 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://pic1.win4000.com/wallpaper/d/53e85d4307c60.jpg", view1);
		view1.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_FIRST));
		ImageView view2 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://d.hiphotos.baidu.com/image/pic/item/72f082025aafa40fc8e997d5a964034f78f0198e.jpg", view2);
		view2.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_SECOND));
		ImageView view3 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://pic1.win4000.com/wallpaper/f/538eb7e2ee428.jpg", view3);
		view3.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_THIRD));
		ImageView view4 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://e.hiphotos.baidu.com/image/h%3D900%3Bcrop%3D0%2C0%2C1440%2C900/sign=6c166314be315c605c9567efbd8aa861/4ec2d5628535e5dd6bf96ade74c6a7efcf1b62de.jpg", view4);
		view4.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_FOURTH));
		ImageView view5 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://pic1.win4000.com/wallpaper/f/538eb7e2ee428.jpg", view5);
		view5.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_FIFTH));
		ImageView view6 = (ImageView) LayoutInflater.from(this.getActivity()).inflate(R.layout.item_img_banner_view, null);
		imageHandler.loadImage("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1301/14/c1/17394579_1358152845572_800x600.jpg", view6);
		view6.setOnClickListener(new BannerViewOnItemClickListener(this.getActivity(), BannerViewOnItemClickListener.IDENTIFIER_TEST_SIXTH));
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		views.add(view5);
		views.add(view6);
		bvBanner.setViews(views);
		bvBanner.setRolling(3000);

		// CountDownView
		tvCountDown.setCountDownAndStart(5000, 10);
		tvCountDown.setOnCountDownFinishListener(new CountDownView.OnCountDownFinishListener() {
			@Override
			public void onFinish() {
				if (TestFirstFragment.this.getActivity() != null) {
					Toast.makeText(TestFirstFragment.this.getActivity(), "Done", Toast.LENGTH_LONG).show();
					Utils.autoCloseKeyboard(TestFirstFragment.this.getActivity(), edtTestAutohide);
				}
			}
		});

		// ImageView
		imageHandler.loadImage("http://d.hiphotos.baidu.com/image/pic/item/72f082025aafa40fc8e997d5a964034f78f0198e.jpg", ivTest);
	}
	
}
