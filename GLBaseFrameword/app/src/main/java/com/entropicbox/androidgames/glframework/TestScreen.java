package com.entropicbox.androidgames.glframework;

public class TestScreen extends Screen {
	Pixmap red;
	Pixmap green;
	Pixmap blue;
	Sound beep;
	Text text;
	Screen bounceScreen;

	public TestScreen(Game game) {
		super(game);
		//	Initialize Game Elements Here
		red = game.g.newPixmap("red.png");
		red.x = 100;
		red.y = 100;
		
		green = game.g.newPixmap("green.png");
		green.x = 200;
		green.y = 200;
		
		blue = game.g.newPixmap("blue.png");
		blue.x = 300;
		blue.y = 300;

		text = new Text("TEST_TEXT", 0, 0, 0, game.g);
		
		beep = game.a.newSound("beep.mp3");
		
	}

	@Override
	public void update() {
		//	Update Game Elements Here
		red.theta++;
		green.theta++;
		blue.theta++;

		if (game.i.isTouchDown(0)) {
			beep.play(1);
			game.setScreen(new TestScreen2(game));
		}
	}

	@Override
	public void present(Graphics g) {
		// TODO Auto-generated method stub
		//	Present Game Elements Here
		g.drawPixmap(red);
		g.drawPixmap(green);
		g.drawPixmap(blue);

		text.present(g);
	}

	public void deconstruct(Graphics g) {
		g.clearPixmap(red);
		g.clearPixmap(green);
		g.clearPixmap(blue);
	}
}
