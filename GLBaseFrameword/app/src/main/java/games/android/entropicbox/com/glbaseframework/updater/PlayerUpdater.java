package games.android.entropicbox.com.glbaseframework.updater;

import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.Enemy.Enemy;
import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class PlayerUpdater {

    public static void update(PlayerCharacter playerCharacter, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy.boundingBox.onScreen() && !enemy.dead) {
                if (enemy.boundingBox.intersectsOrtho(playerCharacter.boundingBox)) {
                    playerCharacter.damage(enemy.damage);
                }
            }
        }
    }

}
