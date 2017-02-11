package games.android.entropicbox.com.glbaseframework.model.Enemy;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Pixmap;

/**
 * Created by nicholascochran on 1/29/17.
 */

public abstract class Enemy {
    Pixmap current;
    public int x, y = 0;
    int worldX, worldY = 0;
    int speed = 1;
    public BoundingBox boundingBox;
    public boolean dead = false;
    public int health = 12;
    public int deathCt = 0;
    public int damage = 10;

    public Enemy(Graphics g) {
    }

    public abstract void update(int worldX, int worldY, int targetX, int targetY);

    public void present(Graphics g) {
        if (boundingBox.onScreen()) {
            g.drawPixmap(current, worldX + x, worldY + y);
            boundingBox.present(g);
        }
    }

    public void damage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            destroy();
        }
    }

    public void deconstruct(Graphics g) {
        boundingBox.deconstruct(g);
        boundingBox = null;
    }

    public void destroy() {
        this.dead = true;
    }
}
