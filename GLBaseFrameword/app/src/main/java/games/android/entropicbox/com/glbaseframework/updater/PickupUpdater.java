package games.android.entropicbox.com.glbaseframework.updater;

import com.entropicbox.androidgames.glframework.Graphics;

import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.Pickup.Pickup;
import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;
import games.android.entropicbox.com.glbaseframework.world.World;

/**
 * Created by nicholascochran on 1/30/17.
 */

public class PickupUpdater {
    public static void update(PlayerCharacter player, List<Pickup> pickups, Graphics g) {
        for (Pickup pickup : pickups) {
            if (pickup.boundingBox.intersectsOrtho(player.boundingBox)) {
                World.weapons.clear();
                World.weapons.add(pickup.getWeapon(g));
                pickups.remove(pickup);
            }
        }
    }
}
