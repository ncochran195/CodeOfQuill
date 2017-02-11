package games.android.entropicbox.com.glbaseframework.model.Enemy;

import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Pixmap;

/**
 * Created by nicholascochran on 1/30/17.
 */

public abstract class Enemy2D extends Enemy {
    Pixmap left, right;

    public Enemy2D(Graphics g) {
        super(g);
    }

    public void update(int worldX, int worldY, int targetX, int targetY) {
        this.worldX = worldX;
        this.worldY = worldY;
        if (!dead) {
            if (worldX + x < targetX) {
                x += speed;
                current = right;
            } else if (worldX + x > targetX) {
                x -= speed;
                current = left;
            }

            if (worldY + y < targetY) {
                y += speed;
            } else if (worldY + y > targetY) {
                y -= speed;
            }
        }
        else {
            current.theta = 90;
            deathCt++;
        }

        boundingBox.update(worldX+x, worldY+y, current.width, current.height);
    }

    public void deconstruct(Graphics g) {
        g.clearPixmap(left);
        g.clearPixmap(right);
    }
}
