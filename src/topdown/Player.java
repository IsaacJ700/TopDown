package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Creates the player object for the game.
 * 
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Player extends GameObject {

	/** The handler for the player object. **/
    private Handler handle;
    
    /** The amount of health the player has. **/
    private int health;
    
    /** The amount of money the player has. **/
    private int money;
    
    /** The amount left in the over shield. **/
    private int overShield;
    
    /** The current game object. **/
    private Game game;
    
    /** The current timer object. **/
    private SecondTimer timer;

    /**
     * Creates the player for the game.
     * 
     * @param x The x position of the player.
     * @param y the y position of the player.
     * @param type The type of object the player is.
     * @param handle The handler for the player.
     * @param game The current game being used.
     */
    public Player(final int x, final int y, final Type type, 
    		final Handler handle, final Game game) {
        super(x, y, type, handle);
        health = 100;
        money = 100;
        overShield = 0;
        this.handle = handle;
        this.game = game;
        timer = new SecondTimer();
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        //Movement
        if (handle.isUp() && y > 0) {
            velY = -3;
        } else if (!handle.isDown()) {
            velY = 0;
        }

        if (handle.isDown() && y < game.getHEIGHT() - 40) {
            velY = 3;
        } else if (!handle.isUp()) {
            velY = 0;
        }

        if (handle.isRight() && x < game.getWIDTH() - 40) {
            velX = 3;
        } else if (!handle.isLeft()) {
            velX = 0;
        }

        if (handle.isLeft() && x > 0) {
            velX = -3;
        } else if (!handle.isRight()) {
            velX = 0;
        }

        if (handle.isLeft() && handle.isRight()) {
            velX = 0;
        }

        if (handle.isUp() && handle.isDown()) {
            velY = 0;
        }

        for (int i = 0; i < handle.list.size(); i++) {
            GameObject tempObject = handle.list.get(i);
            if (tempObject.getType() == Type.smallEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (timer.isTimeUp()) {
                        health -= 10;
                        timer.setTime(System.currentTimeMillis());
                        if (health == 0) {
                            handle.removeObject(this);
                            game.setState(State.GameOver);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void render(final Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 40, 40);
    }

    /**
     * Returns the value as an integer of the player's current health.
     * 
     * @return The integer value for the player's health.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the player's health to the integer amount that is passed to the
     * function.
     * 
     * @param health The integer value for the player's health to be set to.
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     * Returns the money as an integer value for the current amount of money
     * the player has.
     * 
     * @return The amount of money the player currently has.
     */
    public int getMoney() {
        return money;
    }

    /**
     * Sets the player's money count to the amount passed to the function.
     * 
     * @param money The integer value for the money to be set for the player.
     */
    public void setMoney(final int money) {
        this.money = money;
    }

    /**
     * Returns the integer value for the player's current over shield amount.
     * 
     * @return The value left in the over shield as an integer.
     */
    public int getOverShield() {
        return overShield;
    }

    /**
     * Sets the over shield amount for the current player based on the amount
     * passed to the function.
     * 
     * @param overShield The integer value for the over shield to be set to.
     */
    public void setOverShield(final int overShield) {
        this.overShield = overShield;
    }
}
