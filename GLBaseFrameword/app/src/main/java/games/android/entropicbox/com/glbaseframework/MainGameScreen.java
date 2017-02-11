package games.android.entropicbox.com.glbaseframework;

import com.entropicbox.androidgames.glframework.*;

import games.android.entropicbox.com.glbaseframework.world.World;

public class MainGameScreen extends Screen {
	
	Analog LStick;
	Analog RStick;
	World world;
	Text playerHealth;
	Text playerScore;
	
	public MainGameScreen(Game game) {
		super(game);
		//	Initialize Game Elements Here
		LStick = new Analog(game.g, 0, 400, 400, 768);
		RStick = new Analog(game.g, 880, 400, 1200, 768);
		world = new World(game.g);
		playerHealth = new Text("HEALTH_"+world.player.health, 0, 0, 0, game.g);
		playerScore = new Text("SCORE_"+World.score, 0, 32, 0, game.g);
	}

	@Override
	public void update() {
		//	Update Game Elements Here
        LStick.update(game.i);
		RStick.update(game.i);

        world.update(LStick, RStick, game);

		playerHealth = new Text("HEALTH_"+world.player.health, 0, 0, 0, game.g);
		playerScore = new Text("SCORE_"+World.score, 0, 32, 0, game.g);
    }

    @Override
	public void present(Graphics g) {
		//	Present Game Elements Here
		world.present(g);
		LStick.present(g);
		RStick.present(g);

		playerHealth.present(g);
		playerScore.present(g);
	}

	@Override
	public void deconstruct(Graphics g) {
		world.deconstruct(g);
		LStick.deconstruct(g);
		RStick.deconstruct(g);
	}
}
