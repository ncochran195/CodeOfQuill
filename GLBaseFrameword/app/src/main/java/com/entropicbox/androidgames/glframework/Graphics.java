package com.entropicbox.androidgames.glframework;

import java.io.IOException;
import java.io.InputStream;
import javax.microedition.khronos.opengles.GL10;


import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;

public class Graphics {
	AssetManager assets;
	GL10 gl;
	
	public Graphics(AssetManager assets, GL10 gl) {
		this.assets = assets;
		this.gl = gl;
	}
	
   	private Bitmap newBitmap(String fileName) {
        Config config = Config.ARGB_8888;
        
        Options options = new Options();
        options.inPreferredConfig = config;
        
        InputStream in = null;
        Bitmap bitmap = null;
        try {
            in = assets.open(fileName);
            bitmap = BitmapFactory.decodeStream(in);
            if (bitmap == null)
                throw new RuntimeException("Couldn't load bitmap from asset '"
                        + fileName + "'");
        } catch (IOException e) {
			System.out.println("Couldn't load bitmap from asset '"
					+ fileName + "'");
			if (!fileName.contains("tileMissing"))
        		return newBitmap("Tiles/tileMissing.png");
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }        
        return bitmap;
   	}
   	
   	public Pixmap newPixmap(String filename) {
   		Pixmap p = new Pixmap();
   		
   		Bitmap b;
   		if (BitmapMap.map.containsKey(filename)) {
   			b = BitmapMap.map.get(filename);
   		}
   		else {
   			b = newBitmap(filename);
   			BitmapMap.map.put(filename, b);
   		}
   		p.loadGLTexture(gl, b);
	       		
	    return p;
   	}
   	
   	public void drawPixmap(Pixmap p) {
   		if (0 <= p.x+p.width && p.x <= Game.gameWidth && 0 <= p.y + p.height && p.y <= Game.gameHeight)
   			p.draw(gl);
   	}
   	
   	public void drawPixmap(Pixmap p, int x, int y) {
   		p.x = x;
   		p.y = y;
   		p.draw(gl);
   	}
   	public void drawPixmap(Pixmap p, int x, int y, int theta) {
   		p.x = x;
   		p.y = y;
   		p.theta = theta;
   		p.draw(gl);
   	}
   	
   	public void clearPixmap(Pixmap p) {
   		p.clear(gl);
   	}
}
