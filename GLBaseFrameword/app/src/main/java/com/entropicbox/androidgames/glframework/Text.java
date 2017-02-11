package com.entropicbox.androidgames.glframework;

import java.util.ArrayList;
import java.util.TreeMap;

import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Pixmap;

public class Text {
	String text;
	int x, y;
	int max;
	ArrayList<Pixmap> letters = new ArrayList<Pixmap>();
	
	public Text(String text, int x, int y, int max, Graphics g) {
		this.text = text;
		this.x = x;
		this.y = y;
		this.max = max;
		
		for (int i = 0; i < text.length(); i++) {
			String s = this.text.substring(i, i+1);
			//System.out.println(s);
			letters.add(Letters.letterMap.get(s));
		} 
	}
	
	public void present(Graphics g) {
		int ct = 0;
		for (int i = 0; i < letters.size(); i++) {
			ct += letters.get(i).width;
			g.drawPixmap(letters.get(i), x+ct-letters.get(i).width, y);
		}
	}
	
	public void setText(String newText) {
		letters.clear();
		for (int i = 0; i < newText.length(); i++) {
			String s = newText.substring(i, i+1);
			letters.add(Letters.letterMap.get(s));
		}
	}
	
	public static class Letters {
		public static TreeMap<String, Pixmap> letterMap = new TreeMap<String, Pixmap>();
		public static void initLetters(Graphics g) {
			letterMap.put("A", g.newPixmap("Letters/A.png"));
			letterMap.put("B", g.newPixmap("Letters/B.png"));
			letterMap.put("C", g.newPixmap("Letters/C.png"));
			letterMap.put("D", g.newPixmap("Letters/D.png"));
			letterMap.put("E", g.newPixmap("Letters/E.png"));
			letterMap.put("F", g.newPixmap("Letters/F.png"));
			letterMap.put("G", g.newPixmap("Letters/G.png"));
			letterMap.put("H", g.newPixmap("Letters/H.png"));
			letterMap.put("I", g.newPixmap("Letters/I.png"));
			letterMap.put("J", g.newPixmap("Letters/J.png"));
			letterMap.put("K", g.newPixmap("Letters/K.png"));
			letterMap.put("L", g.newPixmap("Letters/L.png"));
			letterMap.put("M", g.newPixmap("Letters/M.png"));
			letterMap.put("N", g.newPixmap("Letters/N.png"));
			letterMap.put("O", g.newPixmap("Letters/O.png"));
			letterMap.put("P", g.newPixmap("Letters/P.png"));
			letterMap.put("Q", g.newPixmap("Letters/Q.png"));
			letterMap.put("R", g.newPixmap("Letters/R.png"));
			letterMap.put("S", g.newPixmap("Letters/S.png"));
			letterMap.put("T", g.newPixmap("Letters/T.png"));
			letterMap.put("U", g.newPixmap("Letters/U.png"));
			letterMap.put("V", g.newPixmap("Letters/V.png"));
			letterMap.put("W", g.newPixmap("Letters/W.png"));
			letterMap.put("X", g.newPixmap("Letters/X.png"));
			letterMap.put("Y", g.newPixmap("Letters/Y.png"));
			letterMap.put("Z", g.newPixmap("Letters/Z.png"));
			letterMap.put("1", g.newPixmap("Letters/1.png"));
			letterMap.put("2", g.newPixmap("Letters/2.png"));
			letterMap.put("3", g.newPixmap("Letters/3.png"));
			letterMap.put("4", g.newPixmap("Letters/4.png"));
			letterMap.put("5", g.newPixmap("Letters/5.png"));
			letterMap.put("6", g.newPixmap("Letters/6.png"));
			letterMap.put("7", g.newPixmap("Letters/7.png"));
			letterMap.put("8", g.newPixmap("Letters/8.png"));
			letterMap.put("9", g.newPixmap("Letters/9.png"));
			letterMap.put("0", g.newPixmap("Letters/0.png"));
			letterMap.put("_", g.newPixmap("Letters/_.png"));
		}
	}
}
