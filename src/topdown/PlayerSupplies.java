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

	 }

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(final Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
