package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Creates a wall to be used as a way to block movement in-game.
 * 
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Wall extends GameObject {

    /**
     * Holds the value for the width of the wall.
     */
    private int width;

    /**
     * Holds the value for the height of the wall.
     */
    private int height;

    /**
     * Holds the handler object for the enemy object.
     */
    private Handler handle;

    /**
     * Constructor initializes parameters and calls on the super class.
     *
     * @param x The integer value for the x position of the wall.
     * @param y The integer value for the y position of the wall.
     * @param type The type of object the wall is.
     * @param handle The handler for the object.
     */
    public Wall(final int x, final int y, final Type type, 
    		final Handler handle) {
        super(x, y, type, handle);
        this.handle = handle;
        width = 10;
        height = 10;
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

    /**
     * Updates the properties of the wall continuously.
     */
    @Override
    public void tick() {

    }

    /**
     * Renders the wall continuously.
     *
     * @param g the instance of Graphics that is being used.
     */
    @Override
    public void render(final Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    /**
     * Returns the boundaries o the wall as a rectangle.
     * @return the boundaries of the wall.
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
