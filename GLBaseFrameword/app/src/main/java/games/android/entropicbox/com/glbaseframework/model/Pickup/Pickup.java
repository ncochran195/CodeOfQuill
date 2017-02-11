package games.android.entropicbox.com.glbaseframework.model.Pickup;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;

import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;

/**
 * Created by nicholascochran on 1/30/17.
 */

public abstract class Pickup {
    public int x, y;
    public BoundingBox boundingBox;

    public abstract Weapon getWeapon(Graphics g);

    public abstract void present(Graphics g);

    public abstract void deconstruct(Graphics g);

    public abstract void update(int worldX, int worldY, int x, int y);
}
