package games.android.entropicbox.com.glbaseframework.updater;

import com.entropicbox.androidgames.glframework.Graphics;

import java.util.List;
import java.util.Random;

import games.android.entropicbox.com.glbaseframework.model.Enemy.DummyEnemy;
import games.android.entropicbox.com.glbaseframework.model.Enemy.Enemy;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class EnemySpawner {
    static int spawnCt = 0;
    static int spawnRate = 100;

    public static void spawnEnemies(List<Enemy> enemies, Graphics g) {
        if (enemies.size() < 100)
            spawnCt++;
        if (spawnCt >= spawnRate) {
            spawnCt = 0;

            Enemy enemy = new DummyEnemy(g);
            Random random = new Random();
            int ranX = (int)(Math.random() * 2000);
            int ranY = (int)(Math.random() * 2000);
            enemy.x = ranX;
            enemy.y = ranY;

            enemies.add(enemy);
        }
    }
}
