package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Wall extends GameObject {

	/** Holds the value for the width of the wall. **/
    private int width = 10;
    
    /** Holds the value for the height of the wall. **/
    private int height = 10;

    /** Holds the handler object for the enemy object. **/
    private Handler handle;

    public Wall(final int x, final int y, final Type type, 
    		final Handler handle) {
        super(x, y, type, handle);
        this.handle = handle;
    }

    /**
     * Returns integer value for the width of the wall.
     * 
     * @return The width of the wall.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the width of the wall based on the passed integer value.
     * 
     * @param w The width of the current wall.
     */
    public void setWidth(final int w) {
        width = w;
    }

    /**
     * Returns integer value for the height of the wall.
     * 
     * @return The height of the wall.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the height of the wall based on the passed integer value.
     * 
     * @param h The height of the current wall.
     */
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
