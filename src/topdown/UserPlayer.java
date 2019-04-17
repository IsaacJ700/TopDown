package topdown;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**********************************************************************
 * Class used to create the player GameObject and alter its properties.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class UserPlayer extends GameObject {

    /**
     * Instance of Handler class.
     */
    private Handler handle;

    /**
     * Used to store amount of health player has.
     */
    private int health;

    /**
     * Instance of the Game class.
     */
    private Game game;

    /**
     * Instance of SecondTimer class.
     */
    private SecondTimer timer;
    
    /**
     * Player's x coordinate.
     */
    private static int x;
    
    /**
     * Player's y coordinate.
     */
    private static int y;
    
    /**
     * Amount of bullets the user has left.
     */
    private static int bulletCount;
    
    /**
     * Amount of points the user has earned.
     */
    private static int score;

    /******************************************************************
     * Constructor creates a player object by accepting in various
     * parameters needed to determine the properties of the player.
     *
     * @param x   represents the x coordinate at which the player will
     *               spawn.
     * @param y   represents the y coordinate at which the player will
     *               spawn.
     * @param type represents the type of object.
     * @param handle represents the instance of the Handler class being
     *               passed down to this constructor.
     * @param game   represents the instance of the Game class being
     *               passed down to this constructor.
     *****************************************************************/
    public UserPlayer(final int x, final int y, final Type type,
                  final Handler handle, final Game game) {
        super(x, y, type, handle);
        health = 100;
        this.handle = handle;
        this.game = game;
        timer = new SecondTimer();
        
        setBulletCount(80);
        setScore(0);
    }

    /******************************************************************
     * Sets the score of points the user has earned.
     * 
     * @param points represents the score the player has.
     *****************************************************************/
    public static void setScore(final int points) {
    	score = points;
	}

    /******************************************************************
     * Returns the score of points the user has earned.
     * 
     * @return The score the player has earned.
     *****************************************************************/
    public static int getScore() {
		return score;
	}

    /******************************************************************
     * Sets the number of bullets the user has remaining.
     * 
     * @param count represents the bullets left.
     *****************************************************************/
    public static void setBulletCount(final int count) {
    	bulletCount = count;
	}

    /******************************************************************
     * Returns the number of bullets the user has left.
     * 
     * @return The number of bullets left.
     *****************************************************************/
    public static int getBulletCount() {
		return bulletCount;
	}

    /******************************************************************
     * Continuously updates the player's position, and checks to see if
     * the player has collided with an enemy.
     *****************************************************************/
    @Override
    public void tick() {
    	setX((int) (getX() + getVelX()));
        setY((int) (getY() + getVelY()));
        
        setPlayerX();
        setPlayerY();

        //Movement
        if (handle.isUp() && getY() > 0) {
        	setVelY(-3);
        } else if (!handle.isDown()) {
            setVelY(0);
        }

        if (handle.isDown() && getY() < game.getHEIGHT() - 40) {
        	setVelY(3);
        } else if (!handle.isUp()) {
        	setVelY(0);
        }

        if (handle.isRight() && getX() < game.getWIDTH() - 40) {
            setVelX(3);
        } else if (!handle.isLeft()) {
            setVelX(0);
        }

        if (handle.isLeft() && getX() > 0) {
        	setVelX(-3);
        } else if (!handle.isRight()) {
        	setVelX(0);
        }

        if (handle.isLeft() && handle.isRight()) {
        	setVelX(0);
        }

        if (handle.isUp() && handle.isDown()) {
        	setVelY(0);
        }

        for (int i = 0; i < handle.getList().size(); i++) {
            GameObject tempObject = handle.getList().get(i);
            
            // Remove health when enemy hits player.
            if (tempObject.getType() == Type.smallEnemy 
            		|| tempObject.getType() == Type.mediumEnemy 
            		|| tempObject.getType() == Type.largeEnemy 
            		|| tempObject.getType() == Type.bossEnemy
            		|| tempObject.getType() == Type.zombieEnemy 
            		|| tempObject.getType() == Type.shootingEnemy
            		|| tempObject.getType() == Type.randomEnemy
            		|| tempObject.getType() == Type.bullet
            			&& ((Bullet) tempObject).getShooter() 
            				== Type.shootingEnemy) {
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
            
            // Add health when player hits health pack.
            if (tempObject.getType() == Type.healthPack) {
            	if (getBounds().intersects(tempObject.getBounds())) {
                    health += 50;
                    if (health >= 100) {
                        health = 100;
                    }
                    handle.removeObject(tempObject);
                    
                    // Play sound for getting ammo.
                    playGetHealth();
                }
            }
            
            // Add bullets when player hits ammo pack.
            if (tempObject.getType() == Type.ammoPack) {
            	if (getBounds().intersects(tempObject.getBounds())) {
                    setBulletCount(getBulletCount() + 50);
                    handle.removeObject(tempObject);
                    
                    // Play sound for getting ammo.
                    playGetAmmo();
                }
            }
        }
    }

    /******************************************************************
     * Plays a healing sound for obtaining a health pack.
     *****************************************************************/
    public void playGetHealth() {

        //Plays a healing sound effect.
 		try {
			FileInputStream fileInputStream = new FileInputStream(
					"A-Tone-His_Self-1266414414.mp3");
			Player musicPlayer = new Player(fileInputStream);
			
			new Thread(new Runnable() {
				  public void run() {
					  try {
						musicPlayer.play();
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}
				  }
				}).start();
 			
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 			
 		} catch (JavaLayerException e) {
 			e.printStackTrace();
 		}
    }

    /******************************************************************
     * Plays a reloading sound for obtaining more ammo.
     *****************************************************************/
    public void playGetAmmo() {

        //Plays a reloading sound effect.
 		try {
			FileInputStream fileInputStream = new FileInputStream(
					"shotgun-reload-old_school-RA_The_"
					+ "Sun_God-580332022.mp3");
			Player musicPlayer = new Player(fileInputStream);
			
			new Thread(new Runnable() {
				  public void run() {
					  try {
						musicPlayer.play();
					} catch (JavaLayerException e) {
						e.printStackTrace();
					}
				  }
				}).start();
 			
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 			
 		} catch (JavaLayerException e) {
 			e.printStackTrace();
 		}
    }

    /******************************************************************
     * Draws the player with the given bounds.
     *
     * @param g visual display for the 2D graphics.
     *****************************************************************/
    @Override
    public void render(final Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(getX(), getY(), 40, 40);
    }

    /******************************************************************
     * Returns the boundaries of the player.
     *
     * @return The boundaries of the player as a rectangle.
     *****************************************************************/
    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 40, 40);
    }

    /******************************************************************
     * Returns an int that represents the current health of the player.
     *
     * @return The health of the current player.
     *****************************************************************/
    public int getHealth() {
        return health;
    }

    /******************************************************************
     * Sets the health for the player object to the amount passed.
     *
     * @param health The health to be set to the player object.
     *****************************************************************/
    public void setHealth(final int health) {
        this.health = health;
    }

    /******************************************************************
     * Returns the x coordinate of the current player.
     *
     * @return the x coordinate the player has.
     *****************************************************************/
    public static int getPlayerX() {
        return x;
    }

    /******************************************************************
     * Sets the x coordinate of the current player.
     *****************************************************************/
    public void setPlayerX() {
        this.x = getX();
    }

    /******************************************************************
     * Returns the y coordinate of the current player.
     *
     * @return the y coordinate the player has.
     *****************************************************************/
    public static int getPlayerY() {
        return y;
    }

    /******************************************************************
     * Sets the x coordinate of the current player.
     *****************************************************************/
    public void setPlayerY() {
        this.y = getY();
    }
}
