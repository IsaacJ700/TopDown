package topdown;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**********************************************************************
 * Class used to create bullets within the Game.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
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
     * The number of bullets the user has left.
     */
    private int bulletCount;
    
    /**
     * The shooter of the current bullet.
     * 
     * The number of bullets the user has left.
     */
    private Type shooter;

    /******************************************************************
     * Constructor accepts in multiple parameters and uses them to call
     * super and the calculateVelocity method.
     * 
     * @param shooter represents who shot the bullet.
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
     *****************************************************************/
    public Bullet(final Type shooter, final int x, final int y,
                  final Type type,
                  final Handler handle, final int xSpd,
                  final int ySpd) throws IOException {
        super(x, y, type, handle);
       
        // If the bullet is shot from the player.
        if (shooter == Type.player) {
	        // What to do if no bullets are left.
	        if (UserPlayer.getBulletCount() == 0) {
	        	playClick();
	        	        
	        // What to do if bullets can be shot.
	    	} else if (UserPlayer.getBulletCount() > 0) {
	        	playShot();
	        	UserPlayer.setBulletCount(
	        			UserPlayer.getBulletCount() - 1);
	            this.handle = handle;
	            width = 5;
	            height = 10;
	            speed = 15;
	        }
        
	    // If the bullet was shot from the shooting enemy.
        } else if (shooter == Type.shootingEnemy) {
        	playEnemyShot();
            this.handle = handle;
            width = 5;
            height = 10;
            speed = 15;
        }
        
        calculateVelocity(getX(), getY(), xSpd, ySpd);
        setShooter(shooter);
    }

    /******************************************************************
     * Sets the shooter of the current bullet object.
     * 
     * @param shooter The object type that shot the bullet.
     *****************************************************************/
    public void setShooter(final Type shooter) {
    	this.shooter = shooter;
    }

    /******************************************************************
     * Returns the Type value for the shooter of the current bullet
     * object.
     * 
     * @return The Type value for the shooter of the bullet.
     *****************************************************************/
    public Type getShooter() {
    	return shooter;
    }

    /******************************************************************
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
     *****************************************************************/
    public void calculateVelocity(final int fromX, final int fromY,
                                  final int toX, final int toY) {

        distance = Math.sqrt(Math.pow((toX - fromX), 2)
                + Math.pow((toY - fromY), 2));

        //find Y
        setVelY((float) ((toY - fromY) * speed / distance));
        //find X
        setVelX((float) ((toX - fromX) * speed / distance));
    }

    /******************************************************************
     * Plays a shooting sound for the current bullet shot from the
     * enemy.
     *****************************************************************/
    public void playEnemyShot() {

        //Plays a shooting sound effect.
 		try {
			FileInputStream fileInputStream = new FileInputStream(
				"Rifle-SoundBible.com-283898562.mp3");
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
     * Plays a shooting sound for the current bullet.
     *****************************************************************/
    public void playShot() {

        //Plays a shooting sound effect.
 		try {
			FileInputStream fileInputStream = new FileInputStream(
				"GUN_FIRE-GoodSoundForYou-820112263.mp3");
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
     * Plays a clicking sound for no bullets being shot.
     *****************************************************************/
    public void playClick() {

        //Plays a clicking sound effect.
 		try {
			FileInputStream fileInputStream = new FileInputStream(
				"Finger Breaking-SoundBible.com-567843392.mp3");
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
     * Updates the current position of the bullet.
     *****************************************************************/
    @Override
    public void tick() {
        setX((int) (getX() + getVelX()));
        setY((int) (getY() + getVelY()));
    }

    /******************************************************************
     * Updates the image of the bullet as it travels across the screen.
     * @param g represents the instance of the Graphics class used.
     *****************************************************************/
    @Override
    public void render(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), width, height);
    }

    /******************************************************************
     * Returns the boundaries of the bullet as a rectangle.
     * @return the boundaries of the bullet as a rectangle.
     *****************************************************************/
    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), width, height);
    }
}
