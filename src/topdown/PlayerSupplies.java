package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Class used to create and place supplies that the user/player can use.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class PlayerSupplies extends GameObject {

    /**
     * Holds the handler object for the supply object.
     */
    private Handler handle;

    /**
     * Holds the current game object.
     */
    private Game game;

    /**
     * Holds the type of supply the object is.
     */
    private Type type;

    /**
     * Holds the size of the supply object.
     */
    private int size;
    
    /**
     * Holds the time the supply may use.
     */
    private int wait;
    
    /**
     * Holds the color of the supply object.
     */
    private Color color;
	
	/**
     * Constructor creates a supply object by accepting in various
     * parameters needed to determine the properties of the supply.
     *
     * @param x represents the x coordinate at which the supply will
     * spawn.
     * @param y represents the y coordinate at which the supply will
     * spawn.
     * @param type represents the type of object.
     * @param handle represents the instance of the Handler class being
     * passed down to this constructor.
     * @param game represents the instance of the Game class being
     * passed down to this constructor.
     */
	public PlayerSupplies(final int x, final int y, final Type type,
              final Handler handle, final Game game) {
		super(x, y, type, handle);
		setVelX(10);
		this.handle = handle;
		this.game = game;

		createSupply(type);
		setX(x);
		setY(y);
	 }

	/**
	 * Creates the player supply objects.
	 * 
	 * @param type is the object type of the player supply.
	 */
	private void createSupply(final Type type) {
		setSupplyWait(50);
		setSupplyType(type);
		
		if (type == Type.healthPack) {
			setSupplySize(20);
			setSupplyColor(Color.WHITE);
		}
		
		if (type == Type.ammoPack) {
			setSupplySize(20);
			setSupplyColor(Color.ORANGE);
		}
		
	}

	/**
	 * Sets the color of the current supply object.
	 * 
	 * @param color represents the objects current color.
	 */
	private void setSupplyColor(final Color color) {
		this.color = color;
	}
	
	/**
	 * Returns the current objects color.
	 * 
	 * @return The Color value for the object's color.
	 */
	private Color getSupplyColor() {
		return color;
	}
	
	/**
	 * Sets the size of the current supply object.
	 * 
	 * @param size represents the objects current size.
	 */
	private void setSupplySize(final int size) {
		this.size = size;
	}
	
	/**
	 * Returns the current objects size.
	 * 
	 * @return The int value for the object's size.
	 */
	private int getSupplySize() {
		return size;
	}
	
	/**
	 * Sets the wait time of the current supply object before changing 
	 * colors.
	 * 
	 * @param wait represents the objects current wait time.
	 */
	private void setSupplyWait(final int wait) {
		this.wait = wait;
	}
	
	/**
	 * Returns the wait time for the current supply object for changing 
	 * colors.
	 * 
	 * @return The int value for the object's remaining wait time.
	 */
	private int getSupplyWait() {
		return wait;
	}
	
	/**
	 * Sets the Type of the current supply object.
	 * 
	 * @param type represents the objects current type.
	 */
	private void setSupplyType(final Type type) {
		this.type = type;
	}
	
	/**
	 * Returns the type of the current supply object.
	 * 
	 * @return The Type value for the object's type.
	 */
	private Type getSupplyType() {
		return type;
	}

	@Override
	public void tick() {
		
		// Decreases time to zero.
		setSupplyWait(getSupplyWait() - 1);
		
		// Item is a health pack:
		if (getSupplyWait() <= 0 
				&& this.getSupplyType() == Type.healthPack) {
			
			// Flashes color
			if (getSupplyColor() == Color.WHITE) {
				setSupplyColor(Color.GREEN);
				setSupplyWait(50);
			} else {
				setSupplyColor(Color.WHITE);
				setSupplyWait(50);
			}
		}
		
		// Item is an ammo pack:
		if (getSupplyWait() <= 0 
				&& this.getSupplyType() == Type.ammoPack) {
			
			// Flashes color
			if (getSupplyColor() == Color.ORANGE) {
				setSupplyColor(Color.BLACK);
				setSupplyWait(50);
			} else {
				setSupplyColor(Color.ORANGE);
				setSupplyWait(50);
			}
		}
		
	}

    /**
     * Draws the player supply based on it's size and color.
     *
     * @param g visual display for the 2D graphics.
     */
    @Override
    public void render(final Graphics g) {
        g.setColor(getSupplyColor());
        g.fillRect(getX(), getY(), getSupplySize(), getSupplySize());
    }

    /**
     * Returns the boundaries of the player supplies based on its size as a
     * rectangle.
     *
     * @return The boundaries of the player supply as a rectangle.
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getSupplySize(), getSupplySize());
    }
	
}
