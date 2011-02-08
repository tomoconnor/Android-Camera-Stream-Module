package com.mandarinmedien.module.camerastream;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import ti.modules.titanium.ui.widget.TiUIButton;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;

@Kroll.proxy(creatableInModule=UIModule.class)
public class AndroidCameraPreviewProxy extends TiViewProxy
{
	private Camera _Camera;
	
	public byte[] byteImage; 
	
	public AndroidCameraPreviewProxy(TiContext tiContext)
	{
		super(tiContext);
	}
 
	@Override
	public TiUIView createView(Activity activity)
	{
		return new AndroidCameraPreview(this);
	}
	
	private AndroidCameraPreview getImageView() {
		return (AndroidCameraPreview)getView(getTiContext().getActivity());
	}

	/*
	 * Camera Stuff
	 * 
	 */
	public void startCameraStream() throws Exception
	{
		Parameters parameters = _Camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        _Camera.setParameters(parameters);
		
		_Camera = Camera.open();
		//_Camera.setPreviewDisplay( tSur.getHolder());
		_Camera.setPreviewCallback(new Camera.PreviewCallback() 
		{ 
			@Override 
			public void onPreviewFrame(byte[] data, Camera camera) 
			{  
				getImageView().setImageBlob(data);
			} 
		});
		
		_Camera.startPreview();
		
	};
	 
	public void stopCameraStream()
	{
		_Camera.stopPreview();
		_Camera.release();
	};	
}