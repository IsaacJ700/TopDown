package topdown;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	/** Holds the position of the object on the X-axis. **/
    protected int x;
    
    /** Holds the position of the object on the Y-axis. **/
	protected int y;
	
	/** Holds the velocity of the object in the X-direction. **/
    protected float velX = 0;
    
    /** Holds the velocity of the object in the Y-direction. **/
    protected float velY = 0;
    
    /** Holds the Type of object the current object is. */
    protected Type type;
    
    /** Holds the handler object for the current object. **/
    protected Handler handle;

    public GameObject(final int x, final int y, final Type type, 
    		final Handler handle) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.handle = handle;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    /**
     * Returns the Type value for the current game object.
     * 
     * @return The Type value for the game object.
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type of the object to the value being passed.
     * 
     * @param type Holds a Type value for game object to be set to.
     */
    public void setType(final Type type) {
        this.type = type;
    }

    /**
     * Returns the position of the X value for the current game object.
     * 
     * @return The int value of the position on the X-axis.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the position of the X value for the current game object.
     * 
     * @param x Holds an int value for the position of the object on the X-axis.
     */
    public void setX(final int x) {
        this.x = x;
    }

    /**
     * Returns the position of the Y value for the current game object.
     * 
     * @return The int value of the position on the Y-axis.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the position of the Y value for the current game object.
     * 
     * @param y Holds an int value for the position of the object on the Y-axis.
     */
    public void setY(final int y) {
        this.y = y;
    }

    /**
     * Returns the velocity in the X-direction for the current game object.
     * 
     * @return The float value of the velocity in the X-direction.
     */
    public float getVelX() {
        return velX;
    }

    /**
     * Sets the velocity in the X-direction for the current game object.
     * 
     * @param velX Holds a float value for the velocity of the object.
     */
    public void setVelX(final float velX) {
        this.velX = velX;
    }

    /**
     * Returns the velocity in the Y-direction for the current game object.
     * 
     * @return The float value of the velocity in the Y-direction.
     */
    public float getVelY() {
        return velY;
    }

    /**
     * Sets the velocity in the Y-direction for the current game object.
     * 
     * @param velY Holds a float value for the velocity of the object.
     */
    public void setVelY(final float velY) {
        this.velY = velY;
    }
}
