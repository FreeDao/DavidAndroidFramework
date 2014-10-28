package com.wudayu.daf.constant;

/**
 *
 * @author: Wu Dayu
 * @En_Name: David Wu
 * @E-mail: wudayu@gmail.com
 * @Created Time: Oct 28, 2014, 4:38:51 PM
 * @Description: David Wu created this file.
 *
 **/

public class ImageLoaderHelper {

	/**
	 * String imageUri = "http://site.com/image.png"; // from Web
	 * String imageUri = "file:///mnt/sdcard/image.png"; // from SD card
	 * String imageUri = "content://media/external/audio/albumart/13"; // from content provider
	 * String imageUri = "assets://image.png"; // from assets
	 * String imageUri = "drawable://" + R.drawable.image; // from drawables (only images, non-9patch)
	 */

	public static final String URI_PREFIX_FILE = "file://";

	public static final String URI_PREFIX_ASSETS = "assets://";

	public static final String URI_PREFIX_DRAWABLE = "drawable://";

}
