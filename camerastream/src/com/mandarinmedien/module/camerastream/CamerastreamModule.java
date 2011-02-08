/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.mandarinmedien.module.camerastream;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.view.TiUIView;

import android.util.Log;

@Kroll.module(name="Camerastream", id="com.mandarinmedien.module.camerastream")
public class CamerastreamModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "CamerastreamModule";
	private static final boolean DBG = TiConfig.LOGD;
	private AndroidCameraPreviewProxy acPP;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;
	
	public CamerastreamModule(TiContext tiContext) {
		super(tiContext);
		

	}
	
	 @Kroll.method
	public TiUIView returnView()
	{
		return acPP.getImageView();
	}
	 @Kroll.method
	public void startCameraStream() throws Exception
	{
		Log.d("MY-CAMERA","CamerastreamModule");
		
		acPP  = new AndroidCameraPreviewProxy(this.getTiContext());
		acPP.createPreview();

		acPP.startCameraStream();
	}
	 @Kroll.method
	public void stopCameraStream()
	{
		acPP.stopCameraStream();
	}
}
