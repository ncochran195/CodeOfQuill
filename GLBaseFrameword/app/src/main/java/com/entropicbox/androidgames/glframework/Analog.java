package com.entropicbox.androidgames.glframework;

import com.entropicbox.androidgames.glframework.Graphics;
import com.entropicbox.androidgames.glframework.Input;
import com.entropicbox.androidgames.glframework.Pixmap;

public class Analog {
	Pixmap base;
	Pixmap stick;
	int x, y;
	int baseX, baseY;
	int baseCenterX, baseCenterY;
	int stickX, stickY;
	int stickCenterX, stickCenterY;
	int touchPointer;
	boolean moveBase;
	double theta;
	double r;
	
	int boundX1, boundY1;
	int boundX2, boundY2;
	
	public Analog(Graphics g, int boundX1, int boundY1, int boundX2, int boundY2) {
		this.base = g.newPixmap("Controls/analogBase.png");
		this.stick = g.newPixmap("Controls/analogStick.png");
		this.moveBase = true;
		this.touchPointer = -1;
		
		this.boundX1 = boundX1;
		this.boundY1 = boundY1;
		this.boundX2 = boundX2;
		this.boundY2 = boundY2;
	}
	
	public void update(Input i) {
		int tx0 = i.getTouchX(0);
		int ty0 = i.getTouchY(0);
		int tx1 = i.getTouchX(1);
		int ty1 = i.getTouchY(1);
		baseCenterX = base.x + base.width/2;
		baseCenterY = base.y + base.height/2;
		double dy = baseCenterY - stickCenterY;
		double dx = stickCenterX - baseCenterX;		
		
		//	Set the pointer that is in the bounds of the analog.
		if (tx0 >= boundX1 && tx0 <= boundX2 && ty0 >= boundY1 && ty0 <= boundY2 && i.isTouchDown(0) && moveBase) {
			touchPointer = 0;
			base.x = i.getTouchX(touchPointer) - (base.width/2);
			base.y = i.getTouchY(touchPointer) - (base.height/2);
			stick.x = base.x;
			stick.y = base.y;
			moveBase = false;
		}
		else if (tx1 >= boundX1 && tx1 <= boundX2 && ty1 >= boundY1 && ty1 <= boundY2 && i.isTouchDown(1) && moveBase) {
			touchPointer = 1;
			base.x = (i.getTouchX(touchPointer) - (base.width/2));
			base.y = (i.getTouchY(touchPointer) - (base.height/2));
			moveBase = false;
		}
		
		if (!moveBase) {
			stickCenterX = i.getTouchX(touchPointer);
			stickCenterY = i.getTouchY(touchPointer);	
		}
		else {
			stickCenterX = baseCenterX;
			stickCenterY = baseCenterY;
		}
				
		double rd = Math.sqrt(Math.pow(dy, 2) + Math.pow(dx, 2));
		r = Math.ceil(rd);
		if (dx == 0) {
			if (dy > 0) {
				theta = 90.;
			}
			else if (dy < 0) {
				theta = 270.;
			}
		}
		else if (dy == 0) {
			if (dx > 0) {
				theta = 0.;
			}
			else if (dx < 0) {
				theta = 180.;
			}
		}
		else if (dx == 0 && dy == 0) {
			theta = 0;
		}
		else {
			theta = Math.toDegrees((Math.atan(dy/dx)));
		}
		if (dx >= 0 && dy >= 0)
			theta += 0;
		else if ((dx < 0 && dy > 0) || (dx < 0 && dy < 0))
			theta += 180;
		else if (dx > 0 && dy < 0) {
			theta += 360;
		}

		if (r > 100) {
			r = 100;
		}
					
		if (!moveBase) {
			stick.x = base.x+base.width/2 + (int) (r*Math.cos(Math.toRadians(theta))-stick.width/2);
			stick.y = base.y+base.height/2 + (int) (-r*Math.sin(Math.toRadians(theta)) - stick.width/2);
		}
		
		if (!i.isTouchDown(touchPointer)) {
			moveBase = true;
			base.x = -500;
			base.y = -500;
			stick.x = -500;
			stick.y = -500;
			theta = -1;
		}
		
        double ddx = 0;
        double ddy = 0;
		if (theta > 0) {
			ddx = Math.cos(Math.toRadians(theta));
			ddy = Math.sin(Math.toRadians(theta));
		}
	}
	
	public void present(Graphics g) {
		g.drawPixmap(base);
		g.drawPixmap(stick);
	}
	
	public double getTheta() {
		return theta;
	}
	public double getR() {
		return r/100;
	}
	public boolean isTouched() {
		return !moveBase;
	}

	public void deconstruct(Graphics g) {
		g.clearPixmap(this.base);
		g.clearPixmap(this.stick);
	}
}