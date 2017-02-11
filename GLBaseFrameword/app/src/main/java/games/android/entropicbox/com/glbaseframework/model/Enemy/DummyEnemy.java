package games.android.entropicbox.com.glbaseframework.model.Enemy;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;

/**
 * Created by nicholascochran on 1/30/17.
 */

public class DummyEnemy extends Enemy2D {

    public DummyEnemy(Graphics g) {
        super(g);

        left = g.newPixmap("Enemies/Dummy/EnemyLeft.png");
        right = g.newPixmap("Enemies/Dummy/EnemyRight.png");

        current = right;

        this.boundingBox = new BoundingBox(current.x, current.y, current.width, current.height, g);
    }
}

