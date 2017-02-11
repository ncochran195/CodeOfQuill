package games.android.entropicbox.com.glbaseframework;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.entropicbox.androidgames.glframework.*;

public class MagicGame extends Game {
	//	Declare Screens Here

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		super.onSurfaceCreated(gl, config);
		//	Initialize Screens Here
		this.setScreen(new MainGameScreen(this));
	}

}
