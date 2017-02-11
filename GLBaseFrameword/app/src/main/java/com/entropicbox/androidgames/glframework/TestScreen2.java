package com.entropicbox.androidgames.glframework;

public class TestScreen2 extends Screen {
	Pixmap red;
	Music music;

	public TestScreen2(Game game) {
		super(game);
		//	Initialize Game Elements Here
		red = game.g.newPixmap("red.png");
		red.x = 100;
		red.y = 100;


		music = game.a.newMusic("2.mp3");
		music.play();		
	}

	@Override
	public void update() {
		//	Update Game Elements Here
		red.theta++;

		int x1 = game.i.getTouchX(0);
		int y1 = game.i.getTouchY(0);

		int x2 = game.i.getTouchX(1);
		int y2 = game.i.getTouchY(1);


		red.x = x1;
		red.y = y1;
	}

	@Override
	public void present(Graphics g) {
		//	Present Game Elements Here
		g.drawPixmap(red);

	}

	public void deconstruct(Graphics g) {
		g.clearPixmap(red);
	}
}
