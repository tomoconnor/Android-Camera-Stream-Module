package com.mandarinmedien.module.camerastream;

import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;

@Kroll.proxy(creatableInModule=CamerastreamModule.class)
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
		return createPreview();
	}
	
	public TiUIView createPreview()
	{
		return new AndroidCameraPreview(this);
	}
	
	public AndroidCameraPreview getImageView() {
		return (AndroidCameraPreview)getView(getTiContext().getActivity());
	}

	/*
	 * Camera Stuff
	 * 
	 */
	public void startCameraStream() throws Exception
	{
 
		_Camera = Camera.open();
		
		Parameters parameters = _Camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        _Camera.setParameters(parameters);
        
        SurfaceView tSur = new SurfaceView( getContext() );
		_Camera.setPreviewDisplay(tSur.getHolder() );
		
		_Camera.setPreviewCallback(new Camera.PreviewCallback() 
		{ 
			@Override 
			public void onPreviewFrame(byte[] data, Camera camera) 
			{  
				Log.d("onPreviewFrame", "onPreviewFrame");
				Log.d("onPreviewFrame", data.toString());
				
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