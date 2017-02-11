//	LOGIC FROM THE BOOK BEGINNING ANDROID GAMES (WHERE I LEARNED HOW TO MAKE ANDROID GAMES)
package com.entropicbox.androidgames.glframework;

import java.util.List;

import com.entropicbox.androidgames.glframework.MultiTouchHandler.TouchEvent;

import android.content.Context;
import android.view.View;

public class Input {
    AccelerometerHandler accelHandler;
    MultiTouchHandler touchHandler;

    public Input(Context context, View view, float scaleX, float scaleY, boolean isPhone, int barHeight) {
        accelHandler = new AccelerometerHandler(context);
        touchHandler = new MultiTouchHandler(view, scaleX, scaleY, isPhone, barHeight);        
    }
    
    public boolean isTouchDown(int pointer) {
        return touchHandler.isTouchDown(pointer);
    }

    
    public int getTouchX(int pointer) {
    	if (this.isTouchDown(pointer)) {
    		return touchHandler.getTouchX(pointer);
    	}
    	else return Integer.MAX_VALUE;
    }

    
    public int getTouchY(int pointer) {
    	if (this.isTouchDown(pointer)) {
    		return touchHandler.getTouchY(pointer);
    	}
    	else return Integer.MAX_VALUE;
    }

    
    public float getAccelX() {
        return accelHandler.getAccelX();
    }

    
    public float getAccelY() {
        return accelHandler.getAccelY();
    }

    
    public float getAccelZ() {
        return accelHandler.getAccelZ();
    }

    
    public List<TouchEvent> getTouchEvents() {
        return touchHandler.getTouchEvents();
    }
}
