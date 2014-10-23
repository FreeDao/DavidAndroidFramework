# DavidAndroidFramework

## Overview

**DavidAndroidFramework**, a framework for developing android faster, include image utils, network utils, views and so on.

## Parts
	
**1) Package and Class Introduction**  
**2) How 2 use it**

## Package and Class Introduction

1. ###com.wudayu.daf.Activity
####BaseActivity
		BaseActivity is the root class for every Activity.  It includes a local BroadcastReceiver for closing all activities. Besides that, if we want do something for every Activity, we should do that in BaseActivity.  
####MainActivity
		MainActivity is really the Main Acitivity for Daf. After all data loaded, the interface user will see is MainActivity. It contains a ViewPager and a PageSelectBar.  

2. ###com.wudayu.daf.adapter	  
####MainActivityPageAdapter
		MainAcitivityPageAdapter is a subclass of ViewPagerAdapter for managing the triple fragments on the MainActivity.
####ViewPagerAdapter
		ViewPagerAdapter is a subclass of PagerAdapter. It is used for set Views to ViewPager. It's a View PagerAdapter.

3. ###com.wudayu.daf.constant
####BroadcastActions
		BroadcastActions contains the indentifier for every local BroadcastReceiver.

4. ###com.wudayu.daf.fragment
####BaseFragment
		BaseFragment is the root class for every Fragment. It initialize the mContext which point to getActivity(). Nothing more.

5. ###com.wudayu.daf.listener
####BannerViewOnItemClickListener
		BannerViewOnItemClickListener is the OnClickListener for the Banner which is on the first fragment.

6. ###com.wudayu.daf.views
####imagezoom.GestureImageView
		The classes in imagezoom package are supporting for imagezoom.GestureImageView. GestureImageView is a subclass for ImageView, but it can zoom in and zoom out.
####BannerView
		The BannerView is the View that holds Banners. OnClickListeners can be setted in it. And BannerView can switch banner automaticly by setRolling() function.
####BaseViewPager
		BaseViewPager extends from support.v4.view.ViewPager. It can change the speed when Viewpager slides. But that code was commented.
####CountDownView
		CountDownView is used for showing count down.
####DotPageIndicator
		DotPageIndicator is an indicator for showing the page which the user selected in the ViewPager. It's extend from PageIndicator.
####NoSlideViewPager
		NoSlideViewPager is a subclass for ViewPager, it makes the ViewPager unslidable.
####PageIndicator
		PageIndicator is an interface for ViewPager indicator.
####PageSelectBar
		PageSelectBar is the buttons on the buttom of MainActivity. It helps the ViewPager to select the right page.
####ProcessingDialog
		ProcessingDialog is an AlertDialog. When the application do something cost time, we use it.
####SelectPicPopupWindow
		SelectPicPopupWindow is an board for selecting whether the user wanna use camera or choose image from gallery.
####SlideBarBaseView
		SlideBarBaseView is a vertical View for scrolling. It has alphabet, and it can control a listview to wherever the letter starts.
####SwitchViewPager
		SwitchViewPager is a ViewPager that can automaticly switch pages.