package com.entropicbox.androidgames.glframework;

public abstract class Screen {
	protected Game game;
	public Screen (Game game) {
		this.game = game;
	}
	
	public abstract void update();
	
	public abstract void present(Graphics g);

	public abstract void deconstruct(Graphics g);
}
