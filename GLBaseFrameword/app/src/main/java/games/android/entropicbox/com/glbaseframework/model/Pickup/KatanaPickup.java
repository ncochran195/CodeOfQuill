package games.android.entropicbox.com.glbaseframework.model.Pickup;

import com.entropicbox.androidgames.glframework.BoundingBox;
import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Pixmap;

import games.android.entropicbox.com.glbaseframework.model.weapon.Katana;
import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;

/**
 * Created by nicholascochran on 1/30/17.
 */

public class KatanaPickup extends Pickup {
    int worldX, worldY;
    Pixmap pixmap;

    public KatanaPickup(Graphics g, int x, int y) {
        pixmap = g.newPixmap("katana/char_katana_S.png");
        this.x = x;
        this.y = y;

        boundingBox = new BoundingBox(Integer.MIN_VALUE, Integer.MIN_VALUE, pixmap.width, pixmap.height);
    }

    public void update(int worldX, int worldY, int x, int y) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.x = x;
        this.y = y;

        boundingBox.update(worldX + x, worldY + y, pixmap.width, pixmap.height);
    }

    public void present(Graphics g) {
        g.drawPixmap(pixmap, worldX + x, worldY + y);
        boundingBox.present(g);
    }

    public void deconstruct(Graphics g) {
        g.clearPixmap(pixmap);
        boundingBox.deconstruct(g);
    }

    public Weapon getWeapon(Graphics g) {
        return new Katana(g);
    }
}
