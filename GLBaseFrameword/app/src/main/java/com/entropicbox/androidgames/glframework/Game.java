package com.entropicbox.androidgames.glframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.app.Activity;
import android.content.res.AssetManager;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

public class Game extends Activity implements Renderer {
	public static int gameWidth = 1280;
	public static int gameHeight = 768;
	public Graphics g;
	public Input i;
	public Audio a;	
	public FileIO f;
	Screen current;
	
	@Override
	public void onDrawFrame(GL10 gl) {
		update();
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // Reset the Modelview Matrix
        gl.glLoadIdentity();        
        //	Create a Subclass and Draw Here
        current.present(g);
	}

	public void update() {
		//	Create a Subclass and Update Here
		current.update();
	}
	
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {	 
	        gl.glViewport(0, 0, width, height);     //Reset The Current Viewport
	        gl.glMatrixMode(GL10.GL_PROJECTION);    //Select The Projection Matrix
	        gl.glLoadIdentity();                    //Reset The Projection Matrix
	 
	        //Calculate The Aspect Ratio Of The Window
	        GLU.gluOrtho2D(gl, 0, gameWidth, gameHeight, 0);
	        
	        gl.glMatrixMode(GL10.GL_MODELVIEW);     //Select The Modelview Matrix
	        gl.glLoadIdentity();                    //Reset The Modelview Matrix

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
	    gl.glEnable(GL10.GL_TEXTURE_2D);            //Enable Texture Mapping ( NEW )
	    gl.glShadeModel(GL10.GL_SMOOTH);            //Enable Smooth Shading
	    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    //Black Background
	    
	    gl.glEnable(GL10.GL_BLEND);
	    gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
	    
	    //	Graphics Setup Here
		g = new Graphics(this.getAssets(), gl);
		Text.Letters.initLetters(g);
		this.setScreen(new StartScreen(this));
	}
	
	public void setScreen(Screen current) {
		if (this.current != null)
			this.current.deconstruct(g);
		this.current = current;
	}
}
