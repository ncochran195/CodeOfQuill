package games.android.entropicbox.com.glbaseframework.model.weapon;

import com.entropicbox.androidgames.glframework.*;

import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;

public class Sword extends Weapon {
	Pixmap N, S, E, W, NE, NW, SE, SW;
	Pixmap current;
	int swingCT;
	int COOLDOWN = 40;
	
	public Sword(Graphics g) {
		N = g.newPixmap("sword/char_blade_N.png");
		S = g.newPixmap("sword/char_blade_S.png");
		W = g.newPixmap("sword/char_blade_W.png");
		E = g.newPixmap("sword/char_blade_E.png");
		NW = g.newPixmap("sword/char_blade_NW.png");
		NE = g.newPixmap("sword/char_blade_NE.png");
		SW = g.newPixmap("sword/char_blade_SW.png");
		SE = g.newPixmap("sword/char_blade_SE.png");
		
		current = S;

		current.x = Integer.MAX_VALUE;
		current.y = Integer.MAX_VALUE;

		this.damage = 6;

		BoundingBox mainBox = new BoundingBox(current.x, current.y, current.width, current.height, g);
		boundingBoxs.add(0, mainBox);
	}
	
	public void update(PlayerCharacter.Direction direction, int x, int y) {
		if (direction != PlayerCharacter.Direction.NONE)
			swingCT++;
		else
			swingCT = 0;

		if (swingCT >= COOLDOWN) {
			swingCT = 0;
		}
		
		if (direction != PlayerCharacter.Direction.NONE && swingCT <= COOLDOWN/2) {			
			if (direction == PlayerCharacter.Direction.N) {
				current = N;
				current.x = x+24;
				current.y = y-54;
			}
			else if (direction == PlayerCharacter.Direction.S) {
				current = S;
				current.x = x+24;
				current.y = y+54;
			}
			else if (direction == PlayerCharacter.Direction.W) {
				current = W;
				current.x = x-54;
				current.y = y+36;
			}
			else if (direction == PlayerCharacter.Direction.E) {
				current = E;
				current.x = x+54;
				current.y = y+36;
			}
			else if (direction == PlayerCharacter.Direction.NW) {
				current = NW;
				current.x = x-32;
				current.y = y-27;
			}
			else if (direction == PlayerCharacter.Direction.NE) {
				current = NE;
				current.x = x+32;
				current.y = y-27;
			}
			else if (direction == PlayerCharacter.Direction.SW) {
				current = SW;
				current.x = x-32;
				current.y = y+27;
			}
			else if (direction == PlayerCharacter.Direction.SE) {
				current = SE;
				current.x = x+32;
				current.y = y+27;
			}
		}
		else {
			current = N;
			current.x = Integer.MIN_VALUE;
			current.y = Integer.MIN_VALUE;
		}
		boundingBoxs.get(0).update(current.x, current.y, current.width, current.height);
	}
	
	public void present(Graphics g) {
		g.drawPixmap(current);
		for (BoundingBox boundingBox : boundingBoxs) {
			boundingBox.present(g);
		}
	}

	public void deconstruct(Graphics g) {
		g.clearPixmap(N);
		g.clearPixmap(S);
		g.clearPixmap(W);
		g.clearPixmap(E);
		g.clearPixmap(NE);
		g.clearPixmap(NW);
		g.clearPixmap(SE);
		g.clearPixmap(SW);
		for (BoundingBox bbox : boundingBoxs) {
			bbox.deconstruct(g);
		}
	}
}
