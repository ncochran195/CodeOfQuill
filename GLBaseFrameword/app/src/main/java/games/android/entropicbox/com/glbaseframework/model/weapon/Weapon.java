package games.android.entropicbox.com.glbaseframework.model.weapon;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;

import java.util.ArrayList;
import java.util.List;

import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;

/**
 * Created by nicholascochran on 1/29/17.
 */

public abstract class Weapon {
    public List<BoundingBox> boundingBoxs = new ArrayList<BoundingBox>();
    public int damage;

    public abstract void update(PlayerCharacter.Direction direction, int x, int y);

    public abstract void present(Graphics g);

    public abstract void deconstruct(Graphics g);
}
