/**
 * 
 */
package com.mandarinmedien.module.camerastream;

import java.io.ByteArrayOutputStream;

import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.CompressFormat;
import android.widget.ImageView;

/**
 * @author toni
 *
 */
public class AndroidCameraPreview extends TiUIView {

	public ImageView myImage;
	
	public AndroidCameraPreview(TiViewProxy proxy) {
		super(proxy);
			
		myImage = new ImageView(proxy.getContext());
		
		setNativeView(myImage);
	}
	
	void setImageBlob(byte[] data)
	{

		ByteArrayOutputStream tBAStream = new ByteArrayOutputStream();
		
		Bitmap tBM = BitmapFactory.decodeByteArray(data, 0, data.length);
 
		tBM.compress(CompressFormat.JPEG, 75, tBAStream);
		
		byte[] tBA  = tBAStream.toByteArray();
		
		Bitmap tBM2 = BitmapFactory.decodeByteArray(tBA, 0, tBA.length);

		myImage.setImageBitmap(tBM2);
		
	}
	

}
