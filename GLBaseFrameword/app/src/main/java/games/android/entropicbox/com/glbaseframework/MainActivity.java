package games.android.entropicbox.com.glbaseframework;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.entropicbox.androidgames.glframework.Audio;
import com.entropicbox.androidgames.glframework.Game;
import com.entropicbox.androidgames.glframework.Input;
import com.entropicbox.androidgames.glframework.TestGame;

public class MainActivity extends MagicGame {
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView surfaceView = new GLSurfaceView(this);
        surfaceView.setRenderer(this);
        setContentView(surfaceView);
        //	Setup Here
        //	ONLY FOR NON-GRAPHICAL ELEMENTS
        i = new Input(this, surfaceView, (float) Game.gameWidth/getWindowManager().getDefaultDisplay().getWidth(), (float)Game.gameHeight/getWindowManager().getDefaultDisplay().getHeight(), false, 0);
        a = new Audio(this);
    }
}
