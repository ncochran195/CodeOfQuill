package games.android.entropicbox.com.glbaseframework.world;

import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Pixmap;

import java.util.HashMap;
import java.util.Map;

public class TileMap {
	Pixmap[][] tilemap = new Pixmap[60][60];
	int x, y;
	
	public TileMap(Graphics g) {
		x = y = 100;
		for (int row = 0; row < tilemap.length; row++) {
			for (int col = 0; col < tilemap[0].length; col++) {
				tilemap[row][col] = g.newPixmap("Tiles/grass.png");
				tilemap[row][col].x = x + col*tilemap[row][col].width;
				tilemap[row][col].y = y + row*tilemap[row][col].height;
			}
		}
	}
	
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
		
		for (int row = 0; row < tilemap.length; row++) {
			for (int col = 0; col < tilemap[0].length; col++) {
				tilemap[row][col].x = x + col*tilemap[row][col].width;
				tilemap[row][col].y = y + row*tilemap[row][col].height;
			}
		}
	}

	public void present(Graphics g) {
		for (int row = 0; row < tilemap.length; row++) {
			for (int col = 0; col < tilemap[0].length; col++) {
				g.drawPixmap(tilemap[row][col]);
			}
		}
	}

	public void deconstruct(Graphics g) {
		for (int row = 0; row < tilemap.length; row++) {
			for (int col = 0; col < tilemap[0].length; col++) {
				g.clearPixmap(tilemap[row][col]);
			}
		}
	}
}
