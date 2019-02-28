package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {

    private int width = 10;
    private int height = 10;

    private Handler handle;

    public Wall(final int x, final int y, final Type type, 
    		final Handler handle) {
        super(x, y, type, handle);
        this.handle = handle;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int w) {
        width = w;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int h) {
        height = h;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(final Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
//        g.
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
