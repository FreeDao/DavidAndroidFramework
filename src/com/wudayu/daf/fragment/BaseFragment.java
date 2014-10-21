package com.wudayu.daf.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:53:03 PM
 * @Description: David Wu created this file.
 *
 **/

public class BaseFragment extends Fragment {

	Context mContext = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		mContext = getActivity();

		super.onCreate(savedInstanceState);
	}

}