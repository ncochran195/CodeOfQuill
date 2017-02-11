package com.entropicbox.androidgames.glframework;

import java.util.TreeMap;

import android.graphics.Bitmap;

public class BitmapMap {
	public static TreeMap<String, Bitmap> map = new TreeMap<String, Bitmap>();
	public BitmapMap() {
		
	}
	public void addBitmap(Bitmap b, String s) {
		for (int i = 0; i < map.size(); i++) {
			if (!map.containsKey(s)) {
				map.put(s, b);
			}
		}
	}
}