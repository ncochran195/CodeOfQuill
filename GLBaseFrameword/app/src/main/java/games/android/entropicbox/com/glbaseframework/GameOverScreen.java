package games.android.entropicbox.com.glbaseframework;

import com.entropicbox.androidgames.glframework.*;

import games.android.entropicbox.com.glbaseframework.world.World;

public class GameOverScreen extends Screen {

    Text gameOverTxt;
    Text playerScore;

    public GameOverScreen(Game game) {
        super(game);
        gameOverTxt = new Text("GAME_OVER", 100, 100, 0, game.g);
        playerScore = new Text("SCORE_"+World.score, 200, 200, 0, game.g);
    }

    @Override
    public void update() {
        if (game.i.isTouchDown(0)) {
            World.score = 0;
            game.setScreen(new MainGameScreen(game));
        }
    }

    @Override
    public void present(Graphics g) {
        //	Present Game Elements Here
        playerScore.present(g);
        gameOverTxt.present(g);
    }

    @Override
    public void deconstruct(Graphics g) {
    }
}
