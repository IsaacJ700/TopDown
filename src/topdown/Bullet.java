package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

/**
 * Class used to create bullets within the Game.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Bullet extends GameObject {

    /**
     * Holds the handler object for the enemy object.
     */
    private Handler handle;

    /**
     * Represents the length of the bullet.
     */
    private int width;

    /**
     * represents the height of the bullet.
     */
    private int height;

    /**
     * represents how far the bullet should travel.
     */
    private double distance;

    /**
     * represents how fast the bullet will travel.
     */
    private double speed;

    /**
     * Constructor accepts in multiple parameters and uses them to call
     * super and the calculateVelocity method.
     *
     * @param x represents the x coordinate at which it will spawn.
     * @param y represents the y coordinate at which it will spawn.
     * @param type represents the type of object.
     * @param handle represents the instance of Handler class being.
     *               used
     * @param xSpd represents the speed at which the bullet travels
     *               horizontally.
     * @param ySpd represents the speed at which the bullet travels
     *               vertically.
     * @throws IOException Thrown if the input operation fails.
     */
    public Bullet(final int x, final int y, final Type type,
                  final Handler handle, final int xSpd,
                  final int ySpd) throws IOException {
        super(x, y, type, handle);
        this.handle = handle;
        width = 5;
        height = 10;
        speed = 15;
        calculateVelocity(x, y, xSpd, ySpd);
    }

    /**
     * Determines the velocity of the bullet depending on where it is
     * shot from and towards what point.
     *
     * @param fromX Holds an int that represents the X-coordinate of
     * the bullet's origin.
     * @param fromY Holds an int that represents the Y-coordinate of
     * the bullet's origin.
     * @param toX Holds an int that represents the X-coordinate of
     * the bullet's destination.
     * @param toY Holds an int that represents the Y-coordinate of
     * the bullet's destination.
     */
    public void calculateVelocity(final int fromX, final int fromY,
                                  final int toX, final int toY) {

        distance = Math.sqrt(Math.pow((toX - fromX), 2)
                + Math.pow((toY - fromY), 2));

        //find Y
        velY = (float) ((toY - fromY) * speed / distance);
        //find X
        velX = (float) ((toX - fromX) * speed / distance);
    }

    /**
     * Updates the current position of the bullet.
     */
    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    /**
     * Updates the image of the bullet as it travels across the screen.
     * @param g represents the instance of the Graphics class used.
     */
    @Override
    public void render(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }

    /**
     * Returns the boundaries of the bullet as a rectangle.
     * @return the boundaries of the bullet as a rectangle.
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
