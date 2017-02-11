package games.android.entropicbox.com.glbaseframework.model.weapon;

import com.entropicbox.androidgames.glframework.*;

import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;
import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;

public class Katana extends Weapon {
    Pixmap N, S, E, W, NE, NW, SE, SW;
    Pixmap current;
    int swingCT;
    int COOLDOWN = 40;

    public Katana(Graphics g) {
        N = g.newPixmap("katana/char_katana_N.png");
        S = g.newPixmap("katana/char_katana_S.png");
        W = g.newPixmap("katana/char_katana_W.png");
        E = g.newPixmap("katana/char_katana_E.png");
        NW = g.newPixmap("katana/char_katana_NW.png");
        NE = g.newPixmap("katana/char_katana_NE.png");
        SW = g.newPixmap("katana/char_katana_SW.png");
        SE = g.newPixmap("katana/char_katana_SE.png");

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
                current.y = y-54-64;
            }
            else if (direction == PlayerCharacter.Direction.S) {
                current = S;
                current.x = x+24;
                current.y = y+54;
            }
            else if (direction == PlayerCharacter.Direction.W) {
                current = W;
                current.x = x-54-64;
                current.y = y+36;
            }
            else if (direction == PlayerCharacter.Direction.E) {
                current = E;
                current.x = x+54;
                current.y = y+36;
            }
            else if (direction == PlayerCharacter.Direction.NW) {
                current = NW;
                current.x = x-32-64+15;
                current.y = y-27-64+15;
            }
            else if (direction == PlayerCharacter.Direction.NE) {
                current = NE;
                current.x = x+32-15;
                current.y = y-27-64+15;
            }
            else if (direction == PlayerCharacter.Direction.SW) {
                current = SW;
                current.x = x-32-64+15;
                current.y = y+27-15;
            }
            else if (direction == PlayerCharacter.Direction.SE) {
                current = SE;
                current.x = x+32-15;
                current.y = y+27-15;
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
