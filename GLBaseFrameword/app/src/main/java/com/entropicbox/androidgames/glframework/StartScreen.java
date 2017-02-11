package com.entropicbox.androidgames.glframework;

public class StartScreen extends Screen {

	public StartScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update() {
		//	Put your screen here.
		Screen start = new TestScreen(game);
		game.setScreen(start);
	}

	@Override
	public void present(Graphics g) {
		//	Loading screen.
	}

	@Override
	public void deconstruct(Graphics g) {
		//	Cleanup loading screen assets
	}

}
