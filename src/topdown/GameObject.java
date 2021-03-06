package topdown;

import java.awt.Graphics;
import java.awt.Rectangle;

/**********************************************************************
 * Abstract class used to monitor and alter the properties of
 * GameObjects.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public abstract class GameObject {

    /** Holds the position of the object on the X-axis. **/
    private int x;

    /** Holds the position of the object on the Y-axis. **/
    private int y;

    /** Holds the velocity of the object in the X-direction. **/
    private float velX = 0;

    /** Holds the velocity of the object in the Y-direction. **/
    private float velY = 0;

    /** Holds the Type of object the current object is. */
    private Type type;

    /** Holds the handler object for the current object. **/
    private Handler handle;

    /******************************************************************
     * Constructor takes in many parameters and uses them to determine
     * the properties of the GameObject.
     *
     * @param x      the coordinate at which the object will spawn
     * @param y      the y coordinate at which the object will spawn
     * @param type   the type of object this GameObject is
     * @param handle the instance of Handler that this object will use
     *****************************************************************/
    public GameObject(final int x, final int y, final Type type,
                      final Handler handle) {
        setX(x);
        setY(y);
        this.type = type;
        this.handle = handle;
    }

    /******************************************************************
     * Continuously updates the property of the game.
     *****************************************************************/
    public abstract void tick();

    /******************************************************************
     * Renders the current game object.
     * 
     * @param g The graphic of the current game object.
     *****************************************************************/
    public abstract void render(Graphics g);

    /******************************************************************
     * Returns the bonds of the current rectangle.
     * 
     * @return The bounds of the rectangle.
     *****************************************************************/
    public abstract Rectangle getBounds();

    /******************************************************************
     * Returns the Type value for the current game object.
     *
     * @return The Type value for the game object.
     *****************************************************************/
    public Type getType() {
        return type;
    }

    /******************************************************************
     * Sets the type of the object to the value being passed.
     *
     * @param type Holds a Type value for game object to be set to.
     *****************************************************************/
    public void setType(final Type type) {
        this.type = type;
    }

    /******************************************************************
     * Returns the position of the X value for the current game object.
     *
     * @return The int value of the position on the X-axis.
     *****************************************************************/
    public int getX() {
        return x;
    }

    /******************************************************************
     * Sets the position of the X value for the current game object.
     *
     * @param x Holds an int value for the position of the object on
     * the X-axis.
     *****************************************************************/
    public void setX(final int x) {
        this.x = x;
    }

    /******************************************************************
     * Returns the position of the Y value for the current game object.
     *
     * @return The int value of the position on the Y-axis.
     *****************************************************************/
    public int getY() {
        return y;
    }

    /******************************************************************
     * Sets the position of the Y value for the current game object.
     *
     * @param y Holds an int value for the position of the object on
     * the Y-axis.
     *****************************************************************/
    public void setY(final int y) {
        this.y = y;
    }

    /******************************************************************
     * Returns the velocity in the X-direction for the current game
     * object.
     *
     * @return The float value of the velocity in the X-direction.
     *****************************************************************/
    public float getVelX() {
        return velX;
    }

    /******************************************************************
     * Sets the velocity in the X-direction for the current game
     * object.
     *
     * @param velX Holds a float value for the velocity of the object.
     *****************************************************************/
    public void setVelX(final float velX) {
        this.velX = velX;
    }

    /******************************************************************
     * Returns the velocity in the Y-direction for the current game
     * object.
     *
     * @return The float value of the velocity in the Y-direction.
     *****************************************************************/
    public float getVelY() {
        return velY;
    }

    /******************************************************************
     * Sets the velocity in the Y-direction for the current game
     * object.
     *
     * @param velY Holds a float value for the velocity of the object.
     *****************************************************************/
    public void setVelY(final float velY) {
        this.velY = velY;
    }
}
