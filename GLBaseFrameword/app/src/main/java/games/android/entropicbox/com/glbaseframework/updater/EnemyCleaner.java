package games.android.entropicbox.com.glbaseframework.updater;

import com.entropicbox.androidgames.glframework.Graphics;

import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.Enemy.Enemy;
import games.android.entropicbox.com.glbaseframework.world.World;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class EnemyCleaner {
    public static void cleanEnemies(List<Enemy> enemies, Graphics g) {
        for (int i = enemies.size()-1; i >= 0; i--) {
            Enemy enemy = enemies.get(i);
            if (enemy.deathCt > 100) {
                enemy.deconstruct(g);
                enemy = null;
                enemies.remove(i);
                System.gc();
                World.score++;
            }
        }
    }
}
