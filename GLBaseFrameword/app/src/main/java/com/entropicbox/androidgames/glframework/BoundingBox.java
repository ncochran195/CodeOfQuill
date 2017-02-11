package com.entropicbox.androidgames.glframework;

/**
 * Created by nicholascochran on 1/29/17.
 */

public class BoundingBox {
    int x, y, width, height;
    Pixmap image;

    public BoundingBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public BoundingBox(int x, int y, int width, int height, Graphics g) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //image = g.newPixmap("bound.png");
        //image.width = width;
        //image.height = height;
    }

    public void update(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        if (image != null) {
            image.width = width;
            image.height = height;
        }
    }

    public boolean intersectsOrtho(BoundingBox other) {
        int aMinX = this.x;
        int aMinY = this.y;
        int aMaxX = this.x + this.width;
        int aMaxY = this.y + this.height;

        int bMinX = other.x;
        int bMinY = other.y;
        int bMaxX = other.x + other.width;
        int bMaxY = other.y + other.height;

        if (aMaxX < bMinX) return false; // a is left of b
        if (aMinX > bMaxX) return false; // a is right of b
        if (aMaxY < bMinY) return false; // a is above b
        if (aMinY > bMaxY) return false; // a is below b
        return true; // boxes overlap
    }

    public boolean onScreen() {
        return 0 <= x+width && x <= Game.gameWidth && 0 <= y + height && y <= Game.gameHeight;
    }

    public void present(Graphics g) {
        if (image != null)
            g.drawPixmap(image, x, y);
    }

    public void deconstruct(Graphics g) {
        if (image != null)
            g.clearPixmap(image);
    }
}
