package com.wudayu.daf.fragment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageView;

import com.wudayu.daf.R;
import com.wudayu.daf.constant.ImageLoaderHelper;
import com.wudayu.daf.constant.ReqCode;
import com.wudayu.daf.generic.Utils;
import com.wudayu.daf.handler.IImageHandler;
import com.wudayu.daf.handler.UILImageHandler;
import com.wudayu.daf.views.ProcessingDialog;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 21, 2014, 7:55:48 PM
 * @Description: David Wu created this file.
 *
 **/

@EFragment(R.layout.fragment_test_third)
public class TestThirdFragment extends BaseFragment {

	@ViewById
	ImageView ivHeader;

	@Bean(UILImageHandler.class)
	IImageHandler imageHandler;

	String takePicturePath = null;
	String cuttedImagePath = null;
	List<String> filePathes = new ArrayList<String>();
	String uploadedUUid = null;
	int currPicIndex = -1;
	ProcessingDialog processingDialog = null;

	@Click
	void ivHeader() {
		takePicturePath = imageHandler.getNewTmpImagePath();
		imageHandler.selectGetImageWay(this.getActivity(), ivHeader, takePicturePath);
	}

	public void cutTheImage(Uri uri) {
		cuttedImagePath = imageHandler.getNewTmpImagePath();
		imageHandler.cutTheImageHead(this.getActivity(), uri, cuttedImagePath);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			if (resultCode == Activity.RESULT_OK) {
				switch (requestCode) {
				// 如果是直接从相册获取
				case ReqCode.ALBUM:
					cutTheImage(data.getData());
					break;
				// 如果是调用相机拍照时
				case ReqCode.CAMERA:
					cutTheImage(Uri.fromFile(new File(takePicturePath)));
					break;
				// 取得裁剪后的图片
				case ReqCode.CUTTED:
					setPicToView(cuttedImagePath);
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setPicToView(String cuttedImagePath) {
		String compressedPath = imageHandler.compressImage(cuttedImagePath);
		imageHandler.loadHeaderImage(ImageLoaderHelper.URI_PREFIX_FILE + compressedPath, ivHeader);
		++currPicIndex;
		filePathes.add(compressedPath);

		processingDialog = new ProcessingDialog(mContext, false, null);
		processingDialog.show();
		uploadPic(compressedPath);
	}

	@Background
	void uploadPic(String filePath) {
		/*
		CsStringResult result = netHandler.postForUploadPic(mApp.getCurrUser().getId(), "picFile", filePath);
		if (result == null || !result.getResultSuccess()) {
			goBackMainThread(getString(R.string.error_server_went_wrong), false);
			return;
		}

		uploadedUUid = result.getStr();
		goBackMainThread(result.getResultMsg(), true);
		*/

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		goBackMainThread("Success ~", true);
	}

	@UiThread
	void goBackMainThread(String msg, boolean success) {
		dismissProcessingDialog();

		Utils.toastMessage(this.getActivity(), msg);
	}

	private void dismissProcessingDialog() {
		if (processingDialog != null)
			processingDialog.dismiss();
	}
}
