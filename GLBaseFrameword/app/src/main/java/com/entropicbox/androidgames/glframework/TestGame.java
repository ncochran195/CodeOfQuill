package com.entropicbox.androidgames.glframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TestGame extends Game {
	//	Declare Screens Here
	Screen testScreen;

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		//	Initialize Screens Here
		testScreen = new TestScreen(this);
		this.setScreen(testScreen);
	}

	
}