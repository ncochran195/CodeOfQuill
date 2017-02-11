package games.android.entropicbox.com.glbaseframework.world;

import com.entropicbox.androidgames.glframework.Analog;
import com.entropicbox.androidgames.glframework.Game;
import com.entropicbox.androidgames.glframework.Graphics;

import java.util.ArrayList;
import java.util.List;

import games.android.entropicbox.com.glbaseframework.GameOverScreen;
import games.android.entropicbox.com.glbaseframework.model.Enemy.DummyEnemy;
import games.android.entropicbox.com.glbaseframework.model.Enemy.Enemy;
import games.android.entropicbox.com.glbaseframework.model.Pickup.KatanaPickup;
import games.android.entropicbox.com.glbaseframework.model.Pickup.Pickup;
import games.android.entropicbox.com.glbaseframework.model.PlayerCharacter;
import games.android.entropicbox.com.glbaseframework.model.weapon.Katana;
import games.android.entropicbox.com.glbaseframework.model.weapon.Sword;
import games.android.entropicbox.com.glbaseframework.model.weapon.Weapon;
import games.android.entropicbox.com.glbaseframework.updater.EnemyCleaner;
import games.android.entropicbox.com.glbaseframework.updater.EnemySpawner;
import games.android.entropicbox.com.glbaseframework.updater.EnemyUpdater;
import games.android.entropicbox.com.glbaseframework.updater.PickupUpdater;
import games.android.entropicbox.com.glbaseframework.updater.PlayerUpdater;
import games.android.entropicbox.com.glbaseframework.updater.WeaponsUpdater;

public class World {
    //  World Variables
    public int x, y;
    int worldSpeed = 6;
	TileMap tileMap;
    public static int score = 0;

    //  Player Variables
    public PlayerCharacter player;
    public static List<Weapon> weapons = new ArrayList<Weapon>();
    public static List<Pickup> pickups = new ArrayList<Pickup>();

    //  Enemies Variables
    List<Enemy> enemies = new ArrayList<Enemy>();

	public World(Graphics g) {
		tileMap = new TileMap(g);
		x = y = -1000;
        player = new PlayerCharacter(g);
        Weapon sword = new Sword(g);
        weapons.add(sword);
        Enemy enemy = new DummyEnemy(g);
        enemies.add(enemy);

        Pickup pickup = new KatanaPickup(g, 1000, 0);
        pickups.add(pickup);
    }
	
	public void update(Analog LStick, Analog RStick, Game game) {
        if (!deconstructing) {
            UpdateLocation(LStick);

            tileMap.update(x, y);

            EnemyUpdater.updateEnemiesLocation(enemies, x, y, player.x, player.y);

            UpdatePlayerAndWeapons(LStick, RStick);

            EnemyUpdater.updateEnemiesDamage(enemies, weapons);

            EnemyCleaner.cleanEnemies(enemies, game.g);

            EnemySpawner.spawnEnemies(enemies, game.g);

            PlayerUpdater.update(player, enemies);

            for (Pickup pickup : pickups) {
                pickup.update(x, y, pickup.x, pickup.y);
            }

            PickupUpdater.update(player, pickups, game.g);

            if (player.health == 0) {
                game.setScreen(new GameOverScreen(game));
            }
        }
    }

    private void UpdatePlayerAndWeapons(Analog LStick, Analog RStick) {
        boolean RStickTouched = RStick.isTouched();
        boolean LStickTouched = LStick.isTouched();
        int theta = -1;
        if (RStickTouched) {
            theta = (int)RStick.getTheta();
        }
        else {
            theta = (int)LStick.getTheta();
        }

        player.update(theta, RStickTouched, LStickTouched);

        UpdateWeapons(RStickTouched, theta);
    }

    private void UpdateWeapons(boolean RStickTouched, int theta) {
        if (RStickTouched && theta > 0) {
            WeaponsUpdater.updateWeapons(weapons, player.getDirection(), player.x, player.y);
        }
        else {
            WeaponsUpdater.updateWeapons(weapons, PlayerCharacter.Direction.NONE, player.x, player.y);
        }
    }

    private void UpdateLocation(Analog LStick) {
        int dx = 0;
        int dy = 0;
        double theta = LStick.getTheta();
        double r = LStick.getR();
        if (theta > 0) {
            dx = (int)(worldSpeed*r*Math.cos(Math.toRadians(theta)));
            dy = (int)(worldSpeed*r*Math.sin(Math.toRadians(theta)));
        }
        x -= dx;
        y += dy;
    }

    public void present(Graphics g) {
        if (!deconstructing) {
            tileMap.present(g);

            EnemyUpdater.presentEnemies(enemies, g);

            presentPlayerAndWeapons(g);

            for (Pickup pickup : pickups) {
                pickup.present(g);
            }
        }
    }

    private void presentPlayerAndWeapons(Graphics g) {
        PlayerCharacter.Direction direction = player.getDirection();
        if (direction == PlayerCharacter.Direction.N || direction == PlayerCharacter.Direction.NW || direction == PlayerCharacter.Direction.NE) {
            WeaponsUpdater.presentWeapons(weapons, g);
            player.present(g);
        }
        else {
            player.present(g);
            WeaponsUpdater.presentWeapons(weapons, g);
        }
    }

    public boolean deconstructing = false;
    public void deconstruct(Graphics g) {
        deconstructing = true;
        player.deconstruct(g);
        for (Weapon weapon : weapons) {
            weapon.deconstruct(g);
        }
        tileMap.deconstruct(g);
        for (Enemy enemy : enemies) {
            enemy.deconstruct(g);
        }
        for (Pickup pickup : pickups) {
            pickup.deconstruct(g);
        }
    }
}
