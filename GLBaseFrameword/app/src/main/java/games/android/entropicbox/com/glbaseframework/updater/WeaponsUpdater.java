package games.android.entropicbox.com.glbaseframework.updater;

import com.entropicbox.androidgames.glframework.Graphics;

import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;
import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class WeaponsUpdater {

    public static void updateWeapons(List<Weapon> weapons, PlayerCharacter.Direction playerDirection, int playerX, int playerY) {
        for (Weapon weapon : weapons) {
            weapon.update(playerDirection, playerX, playerY);
        }
    }

    public static void presentWeapons(List<Weapon> weapons, Graphics g) {
        for (Weapon weapon : weapons) {
            weapon.present(g);
        }
    }
}
