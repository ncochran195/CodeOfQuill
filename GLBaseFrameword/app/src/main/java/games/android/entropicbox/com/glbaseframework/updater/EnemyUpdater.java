package games.android.entropicbox.com.glbaseframework.updater;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;

import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.Enemy.Enemy;
import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class EnemyUpdater {

    public static void updateEnemiesLocation(List<Enemy> enemies, int worldX, int worldY, int targetX, int targetY) {
        for (Enemy enemy : enemies) {
            enemy.update(worldX, worldY, targetX, targetY);
        }
    }

    public static void updateEnemiesDamage(List<Enemy> enemies, List<Weapon> weapons) {
        for (Enemy enemy : enemies) {
            if (enemy.boundingBox.onScreen()) {
                for (Weapon weapon : weapons) {
                    for (BoundingBox damageBox : weapon.boundingBoxs) {
                        if (damageBox.intersectsOrtho(enemy.boundingBox)) {
                            enemy.damage(weapon.damage);
                        }
                    }
                }
            }
        }
    }

    public static void presentEnemies(List<Enemy> enemies, Graphics g) {
        for (Enemy enemy : enemies) {
            enemy.present(g);
        }
    }
}
