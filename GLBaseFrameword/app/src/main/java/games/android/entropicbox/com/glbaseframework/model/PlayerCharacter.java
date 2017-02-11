package games.android.entropicbox.com.glbaseframework.model;

import com.entropicbox.androidgames.glframework.*;

public class PlayerCharacter {
	public int x, y;
	Pixmap current;
	Pixmap N0, S0, W0, E0, NW0, NE0, SW0, SE0;
	Pixmap N1, S1, W1, E1, NW1, NE1, SW1, SE1;
	Pixmap N2, S2, W2, E2, NW2, NE2, SW2, SE2;
	Direction direction;
	int animCT;
	int FRAME1 = 10;
	int FRAME2 = 20;
	int FRAME3 = 30;
	int FRAME4 = 40;
	public BoundingBox boundingBox;
	public int health = 100;
	private int damagedCt;
	private boolean damaged = false;

	public PlayerCharacter(Graphics g) {
		N0 = g.newPixmap("Player/Base/char_N_0.png");
		S0 = g.newPixmap("Player/Base/char_S_0.png");
		W0 = g.newPixmap("Player/Base/char_W_0.png");
		E0 = g.newPixmap("Player/Base/char_E_0.png");
		NW0 = g.newPixmap("Player/Base/char_NW_0.png");
		NE0 = g.newPixmap("Player/Base/char_NE_0.png");
		SW0 = g.newPixmap("Player/Base/char_SW_0.png");
		SE0 = g.newPixmap("Player/Base/char_SE_0.png");
		
		N1 = g.newPixmap("Player/Base/char_N_1.png");
		S1 = g.newPixmap("Player/Base/char_S_1.png");
		W1 = g.newPixmap("Player/Base/char_W_1.png");
		E1 = g.newPixmap("Player/Base/char_E_1.png");
		NW1 = g.newPixmap("Player/Base/char_NW_1.png");
		NE1 = g.newPixmap("Player/Base/char_NE_1.png");
		SW1 = g.newPixmap("Player/Base/char_SW_1.png");
		SE1 = g.newPixmap("Player/Base/char_SE_1.png");
		
		N2 = g.newPixmap("Player/Base/char_N_2.png");
		S2 = g.newPixmap("Player/Base/char_S_2.png");
		W2 = g.newPixmap("Player/Base/char_W_2.png");
		E2 = g.newPixmap("Player/Base/char_E_2.png");
		NW2 = g.newPixmap("Player/Base/char_NW_2.png");
		NE2 = g.newPixmap("Player/Base/char_NE_2.png");
		SW2 = g.newPixmap("Player/Base/char_SW_2.png");
		SE2 = g.newPixmap("Player/Base/char_SE_2.png");
		
		current = S0;
		
		x = (Game.gameWidth/2)-(N0.width/2);
		y = (Game.gameHeight/2)-(N0.height)-20;
		
		animCT = 0;
		
		direction = Direction.S;

		this.boundingBox = new BoundingBox(current.x, current.y, current.width, current.height, g);
	}
	
	public void update(int theta, boolean RStickTouched, boolean LStickTouched) {
		//	Determine which direction the character needs to face
		if (theta < 0) {
			// do nothing
		}
		else if (22 < theta && theta <= 67) {
			direction = Direction.NE;
		}
		else if (67 < theta && theta <= 112) {
			direction = Direction.N;
		}
		else if (112 < theta && theta <= 157) {
			direction = Direction.NW;
		}
		else if (157 < theta && theta <= 202) {
			direction = Direction.W;
		}
		else if (202 < theta && theta <= 247) {
			direction = Direction.SW;
		}
		else if (247 < theta && theta <= 292) {
			direction = Direction.S;
		}
		else if (292 < theta && theta <= 337) {
			direction = Direction.SE;
		}
		else {
			direction = Direction.E;
		}
		
		//	Determine animation
		if (LStickTouched && theta > 0) {
			animCT++;
			
			if (animCT >= FRAME4) {
				animCT = 0;
			}
			
			if (direction == Direction.N) {
				if (0 <= animCT && animCT < FRAME1) {
					current = N0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = N1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = N0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = N2;
				}
			}
			else if (direction == Direction.S) {
				if (0 <= animCT && animCT < FRAME1) {
					current = S0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = S1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = S0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = S2;
				}			
			}
			else if (direction == Direction.W) {
				if (0 <= animCT && animCT < FRAME1) {
					current = W0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = W1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = W0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = W2;
				}
			}
			else if (direction == Direction.E) {
				if (0 <= animCT && animCT < FRAME1) {
					current = E0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = E1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = E0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = E2;
				}
			}
			else if (direction == Direction.SE) {
				if (0 <= animCT && animCT < FRAME1) {
					current = SE0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = SE1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = SE0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = SE2;
				}
			}
			else if (direction == Direction.SW) {
				if (0 <= animCT && animCT < FRAME1) {
					current = SW0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = SW1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = SW0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = SW2;
				}
			}
			if (direction == Direction.NW) {
				if (0 <= animCT && animCT < FRAME1) {
					current = NW0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = NW1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = NW0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = NW2;
				}
			}
			if (direction == Direction.NE) {
				if (0 <= animCT && animCT < FRAME1) {
					current = NE0;
				}
				else if (FRAME1 <= animCT && animCT < FRAME2) {
					current = NE1;
				}
				else if (FRAME2 <= animCT && animCT < FRAME3) {
					current = NE0;
				}
				else if (FRAME3 <= animCT && animCT < FRAME4) {
					current = NE2;
				}
			}

		}
		else {
			if (direction == Direction.N) {
				current = N0;
			}
			else if (direction == Direction.S) {
				current = S0;
			}
			else if (direction == Direction.W) {
				current = W0;
			}
			else if (direction == Direction.E) {
				current = E0;
			}
			else if (direction == Direction.SE) {
				current = SE0;
			}
			else if (direction == Direction.SW) {
				current = SW0;
			}
			if (direction == Direction.NW) {
				current = NW0;
			}
			if (direction == Direction.NE) {
				current = NE0;
			}
		}
		
		current.x = x;
		current.y = y;

		if (damaged) {
			damagedCt++;
			if (damagedCt == 100) {
				damagedCt = 0;
				damaged = false;
			}
		}

		boundingBox.update(x, y, current.width, current.height);
	}
	
	public void present(Graphics g) {
		if (damaged) {
			if (    (12 <= damagedCt && damagedCt <= 25) ||
					(37 <= damagedCt && damagedCt <= 50) ||
					(62 <= damagedCt && damagedCt <= 75) ||
					(87 <= damagedCt && damagedCt <= 100) ) {
				g.drawPixmap(current);
			}
		}
		else {
			g.drawPixmap(current);
		}
		boundingBox.present(g);
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public enum Direction {
		N,S,W,E,NW,NE,SW,SE,NONE
	}

	public void damage(int damage) {
		if (!damaged) {
			health -= damage;
			damaged = true;
		}
	}

	public void deconstruct(Graphics g) {
		g.clearPixmap(N0);
		g.clearPixmap(S0);
		g.clearPixmap(W0);
		g.clearPixmap(E0);
		g.clearPixmap(NW0);
		g.clearPixmap(NE0);
		g.clearPixmap(SW0);
		g.clearPixmap(SE0);

		g.clearPixmap(N1);
		g.clearPixmap(S1);
		g.clearPixmap(W1);
		g.clearPixmap(E1);
		g.clearPixmap(NW1);
		g.clearPixmap(NE1);
		g.clearPixmap(SW1);
		g.clearPixmap(SE1);

		g.clearPixmap(N2);
		g.clearPixmap(S2);
		g.clearPixmap(W2);
		g.clearPixmap(E2);
		g.clearPixmap(NW2);
		g.clearPixmap(NE2);
		g.clearPixmap(SW2);
		g.clearPixmap(SE2);
	}
}

