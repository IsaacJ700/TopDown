package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

/**********************************************************************
 * Class used to determine/set enemy properties before inserting them
 * into the game.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class Enemy extends GameObject {

    /**
     * Holds the handler object for the enemy object.
     */
    private Handler handle;

    /**
     * Holds the amount of health an enemy object has.
     */
    private int health;

    /**
     * Holds the current game object.
     */
    private Game game;

    /**
     * Holds the type of enemy the object is.
     */
    private Type type;

    /**
     * Holds the size of the enemy object.
     */
    private int size;
    
    /**
     * Holds the time the enemy has been in one direction.
     */
    private int wait;
    
    /**
     * Holds the time the shooting enemy has been holding between
     * shots.
     */
    private int shootingWait;
    
    /**
     * Holds the color of the enemy object.
     */
    private Color color;
    
    /**
     * Holds the speed of the enemy object.
     */
    private int speed;

    /**
     * Used for the random enemy type generator.
     */
    private Random randomNum;
    
    /**
     * Holds the score received for killing enemy object.
     */
    private int score;


    /******************************************************************
     * Constructor creates an enemy object by accepting in various
     * parameters needed to determine the properties of the enemy.
     *
     * @param x represents the x coordinate at which the enemy will
     * spawn.
     * @param y represents the y coordinate at which the enemy will
     * spawn.
     * @param type represents the type of object.
     * @param handle represents the instance of the Handler class being
     * passed down to this constructor.
     * @param game represents the instance of the Game class being
     * passed down to this constructor.
     *****************************************************************/
    public Enemy(final int x, final int y, final Type type,
                 final Handler handle, final Game game) {
        super(x, y, type, handle);
        setVelX(10);
        this.handle = handle;
        this.game = game;
        randomNum = new Random();
        setEnemyType(type);
        setEnemySize(getEnemyType());
        setEnemyColor(getEnemyType());
        setEnemyHealth(getEnemyType());
        setEnemySpeed(getEnemyType());
        setEnemyDirection();
        setEnemyWait(0);
        setEnemyScore(getEnemyType());
    }

    /******************************************************************
     * Sets the score received for the enemy object based on the
     * enemy type.
     * 
     * @param type The enemy type of the current enemy object.
     *****************************************************************/
    public void setEnemyScore(final Type type) {
        if (type.equals(Type.smallEnemy)) {
            this.score = this.getEnemySize();
        } else if (type.equals(Type.mediumEnemy)) {
        	this.score = this.getEnemySize();
        } else if (type.equals(Type.largeEnemy)) {
        	this.score = this.getEnemySize();
        } else if (type.equals(Type.bossEnemy)) {
        	this.score = this.getEnemySize();
        } else if (type.equals(Type.shootingEnemy)) {
        	this.score = this.getEnemySize();
        } else if (type.equals(Type.zombieEnemy)) {
            this.score = this.getEnemySize() - (this.getEnemySize()
                    % 10);
        }
    }

    /******************************************************************
     * Returns the integer value for the score received from the enemy
     * object.
     * 
     * @return The int value for the score received from the enemy.
     *****************************************************************/
    public int getEnemyScore() {
    	return score;
    }

    /******************************************************************
     * Sets the amount of time the current enemy object has been
     * holding a direction.
     * 
     * @param wait The amount of time the enemy has been waiting.
     *****************************************************************/
    public void setEnemyWait(final int wait) {
    	this.wait = wait;
    }

    /******************************************************************
     * Returns the integer value for the amount of time the current
     * enemy object has been holding a direction.
     *
     * @return The int value for the length of time the enemy has been
     * waiting.
     *****************************************************************/
    public int getEnemyWait() {
    	return wait;
    }

    /******************************************************************
     * Sets the amount of time the current shooting enemy object
     * has been holding between shots.
     *
     * @param sWait The amount of time the enemy has been waiting
     * to shoot.
     *****************************************************************/
    public void setEnemyShootingWait(final int sWait) {
    	this.shootingWait = sWait;
    }

    /******************************************************************
     * Returns the integer value for the amount of time the current
     * shooting
     * enemy object has been holding between shots.
     *
     * @return The int value for the length of time the enemy has
     * been waiting
     * to shoot.
     *****************************************************************/
    public int getEnemyShootingWait() {
    	return shootingWait;
    }

    /******************************************************************
     * Sets the direction for the enemy to move in.
     *****************************************************************/
    public void setEnemyDirection() {
    	
    	int randomChoice = randomNum.nextInt(9);
    	
    	/* Checks if UserPlayer is in range or is a boss enemy or if
    	 shooting
    	 * enemy within range.
    	 */

        if ((Math.sqrt(Math.pow((UserPlayer.getPlayerX() -
                this.getX()), 2)
    			+ Math.pow((UserPlayer.getPlayerY() - this.getY()), 2)) 
    			< 200 || this.getEnemyType() == Type.bossEnemy 
    			|| (this.getEnemyType() == Type.shootingEnemy 
    			&& (Math.sqrt(Math.pow((UserPlayer.getPlayerX() 
    					- this.getX()), 2) 
    					+ Math.pow((UserPlayer.getPlayerY() 
    					- this.getY()), 2)) < 200)))) {
    		
    		if (this.getEnemyType() == Type.shootingEnemy) {
    			this.setVelX(0);
    			this.setVelY(0);
    		
        	// X+ Y+
    		} else if (this.getX() < UserPlayer.getPlayerX() 
        			&& this.getY() < UserPlayer.getPlayerY()) {
        		this.setVelX((int) Math.sqrt(Math.pow(getEnemySpeed(), 
        				2) / 2));
        		this.setVelY((int) Math.sqrt(Math.pow(getEnemySpeed(), 
        				2) / 2));
        		
        	// X+ Y-
        	} else if (this.getX() < UserPlayer.getPlayerX() 
        			&& this.getY() > UserPlayer.getPlayerY()) {
        		this.setVelX((int) Math.sqrt(Math.pow(
        				getEnemySpeed(), 2) / 2));
        		this.setVelY(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        	
        	// X+ 00
        	} else if (this.getX() < UserPlayer.getPlayerX() 
        			&& this.getY() == UserPlayer.getPlayerY()) {
        		this.setVelX((int) Math.sqrt(Math.pow(
        				getEnemySpeed(), 2) / 2));
        		this.setVelY(0);
        	
        	// X- Y+
        	} else if (this.getX() > UserPlayer.getPlayerX() 
        			&& this.getY() < UserPlayer.getPlayerY()) {
        		this.setVelX(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        		this.setVelY((int) Math.sqrt(Math.pow(
        				getEnemySpeed(), 2) / 2));
        	
        	// X- Y-
        	} else if (this.getX() > UserPlayer.getPlayerX() 
        			&& this.getY() > UserPlayer.getPlayerY()) {
        		this.setVelX(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        		this.setVelY(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        	
        	// X- 00
        	} else if (this.getX() > UserPlayer.getPlayerX() 
        			&& this.getY() == UserPlayer.getPlayerY()) {
        		this.setVelX(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        		this.setVelY(0);
        	
        	// 00 Y+
        	} else if (this.getX() == UserPlayer.getPlayerX() 
        			&& this.getY() < UserPlayer.getPlayerY()) {
        		this.setVelX(0);
        		this.setVelY((int) Math.sqrt(Math.pow(
        				getEnemySpeed(), 2) / 2));
        	
        	// 00 Y-
        	} else if (this.getX() == UserPlayer.getPlayerX() 
        			&& this.getY() > UserPlayer.getPlayerY()) {
        		this.setVelX(0);
        		this.setVelY(-1 * (int) Math.sqrt(
        				Math.pow(getEnemySpeed(), 2) / 2));
        	
        	// 00 00
        	} else {
        		this.setVelX(0);
        		this.setVelY(0);
        	}
    		
    	
    	// Decides if directions are positive, negative, or zero.
    	// X+ Y+
    	} else if (randomChoice == 0) {
            this.setVelX((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
            this.setVelY((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
    		
    	// X+ Y-
    	} else if (randomChoice == 1) {
            this.setVelX((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
    		this.setVelY(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
    	
    	// X+ 00
    	} else if (randomChoice == 2) {
            this.setVelX((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
    		this.setVelY(0);
    	
    	// X- Y+
    	} else if (randomChoice == 3) {
    		this.setVelX(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
            this.setVelY((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
    	
    	// X- Y-
    	} else if (randomChoice == 4) {
    		this.setVelX(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
    		this.setVelY(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
    	
    	// X- 00
    	} else if (randomChoice == 5) {
    		this.setVelX(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
    		this.setVelY(0);
    	
    	// 00 Y+
    	} else if (randomChoice == 6) {
    		this.setVelX(0);
            this.setVelY((int) Math.sqrt(Math.pow(getEnemySpeed(), 2)
                    / 2));
    	
    	// 00 Y-
    	} else if (randomChoice == 7) {
    		this.setVelX(0);
    		this.setVelY(-1 * (int) Math.sqrt(
    				Math.pow(getEnemySpeed(), 2) / 2));
    	
    	// 00 00
    	} else {
    		this.setVelX(0);
    		this.setVelY(0);
    	}
    }

    /******************************************************************
     * Returns an int that represents the speed of the enemy object.
     * 
     * @return The speed of the current enemy object.
     *****************************************************************/
    public int getEnemySpeed() {
    	return speed;
    }

    /******************************************************************
     * Sets the enemy speed for the enemy object based on the enemy type.
     * 
     * @param type The enemy type of the current enemy object.
     *****************************************************************/
    public void setEnemySpeed(final Type type) {
    	  if (type.equals(Type.smallEnemy)) {
    		  this.speed = 5;
          } else if (type.equals(Type.mediumEnemy)) {
        	  this.speed = 4;
          } else if (type.equals(Type.largeEnemy)) {
        	  this.speed = 3;
          } else if (type.equals(Type.bossEnemy)) {
        	  this.speed = 2;
          } else if (type.equals(Type.shootingEnemy)) {
        	  this.speed = 3;
          } else if (type.equals(Type.zombieEnemy)) {
        	  if (getEnemySize() > 80) {
              	this.speed = 2;
              } else if (getEnemySize() > 60) {
            	  this.speed = 3;
              } else if (getEnemySize() > 40) {
            	  this.speed = 3;
              } else {
            	  this.speed = 4;
              }
          }
    }

    /******************************************************************
     * Returns an int that represents the current health of the enemy
     * object.
     *
     * @return The health of the current enemy object.
     *****************************************************************/
    public int getHealth() {
        return health;
    }

    /******************************************************************
     * Sets the enemy health for the enemy object to the amount passed.
     *
     * @param health The health to be set to the current enemy object.
     *****************************************************************/
    public void setHealth(final int health) {
        this.health = health;
    }

    /******************************************************************
     * Sets the enemy health based on the type of the enemy object.
     *
     * @param type The enemy type of the current object.
     *****************************************************************/
    private void setEnemyHealth(final Type type) {
        if (type.equals(Type.smallEnemy)) {
            setHealth(20);
        } else if (type.equals(Type.mediumEnemy)) {
            setHealth(80);
        } else if (type.equals(Type.largeEnemy)) {
            setHealth(200);
        } else if (type.equals(Type.bossEnemy)) {
            setHealth(500);
        } else if (type.equals(Type.shootingEnemy)) {
            setHealth(80);
        } else if (type.equals(Type.zombieEnemy)) {
            if (getEnemySize() > 50) {
                setHealth(500);
            } else if (getEnemySize() > 25) {
                setHealth(350);
            } else if (getEnemySize() > 0) {
            	setHealth(200);
            } else {
            	setHealth(100);
            }
        }
    }

    /******************************************************************
     * Returns an int that represents the size of the enemy object.
     *
     * @return The size of the current enemy object.
     *****************************************************************/
    private int getEnemySize() {
        return size;
    }

    /******************************************************************
     * Sets the enemy size based on the type of the enemy object.
     *
     * @param type The enemy type of the current object.
     *****************************************************************/
    private void setEnemySize(final Type type) {
        if (type.equals(Type.smallEnemy)) {
            this.size = 20;
        } else if (type.equals(Type.mediumEnemy)) {
            this.size = 40;
        } else if (type.equals(Type.largeEnemy)) {
            this.size = 60;
        } else if (type.equals(Type.bossEnemy)) {
            this.size = 90;
        } else if (type.equals(Type.shootingEnemy)) {
            this.size = 40;
        } else if (type.equals(Type.zombieEnemy)) {
            this.size = (int) randomNum.nextInt(70) + 20;
        }
    }

    /******************************************************************
     * Returns a Color that represents the color of the enemy object.
     *
     * @return The color of the current enemy object.
     *****************************************************************/
    private Color getEnemyColor() {
        return color;
    }

    /******************************************************************
     * Sets the enemy color based on the type of the enemy object.
     *
     * @param type The enemy type of the current object.
     *****************************************************************/
    private void setEnemyColor(final Type type) {
        if (type.equals(Type.smallEnemy)) {
            this.color = Color.blue;
        } else if (type.equals(Type.mediumEnemy)) {
            this.color = Color.magenta;
        } else if (type.equals(Type.largeEnemy)) {
            this.color = Color.pink;
        } else if (type.equals(Type.bossEnemy)) {
            this.color = Color.red;
        } else if (type.equals(Type.shootingEnemy)) {
            this.color = Color.lightGray;
        } else if (type.equals(Type.zombieEnemy)) {
            this.color = Color.green;
        }

    }

    /******************************************************************
     * Returns a Type that represents the current object's enemy type.
     *
     * @return The type of the current enemy object.
     *****************************************************************/
    private Type getEnemyType() {
        return type;
    }

    /******************************************************************
     * Takes in the type of enemy and sets it to the object. If type
     * is of a random enemy type, then it gets a random enemy type.
     *
     * @param type The enemy type of the current object.
     *****************************************************************/
    private void setEnemyType(final Type type) {
        if (type == Type.randomEnemy) {
            this.type = getRandomEnemyType();
        } else {
            this.type = type;
        }
    }

    /******************************************************************
     * Returns a Type that represents a randomly selected enemy type.
     * This uses a random number generator to pick from a list all of
     * the possible enemy types.
     *
     * @return The randomly selected enemy for the random enemy type.
     *****************************************************************/
    private Type getRandomEnemyType() {

        Type[] enemyTypeArray = new Type[6];
        for (int i = 0; i < 7; i++) {
            enemyTypeArray = new Type[i];
        }

        enemyTypeArray[0] = Type.smallEnemy;
        enemyTypeArray[1] = Type.mediumEnemy;
        enemyTypeArray[2] = Type.largeEnemy;
        enemyTypeArray[3] = Type.bossEnemy;
        enemyTypeArray[4] = Type.zombieEnemy;
        enemyTypeArray[5] = Type.shootingEnemy;

        return enemyTypeArray[randomNum.nextInt(6)];
    }

    /******************************************************************
     * Method used to generate bullets from shooting type enemies
     *****************************************************************/
    private void beginEnemyShooting() {
        try {
        	new Bullet(Type.shootingEnemy, this.getX() + 15, 
        		this.getY() + 15, 
        		Type.bullet, handle, UserPlayer.getPlayerX(), 
        		UserPlayer.getPlayerY());
            handle.addObject(new Bullet(Type.shootingEnemy,
                    this.getX() + 15,
            		this.getY() + 15, 
            		Type.bullet, handle, UserPlayer.getPlayerX(),
            		UserPlayer.getPlayerY()));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /******************************************************************
     * Continuously updates the enemy position, and checks to see if
     * the enemy has collided with a UserPlayer's bullet.
     *****************************************************************/
    @Override
    public void tick() {
    	setX((int) (getX() + getVelX()));
        setY((int) (getY() + getVelY()));
        
        // Checks if the player is within range to begin chase.
        if ((Math.sqrt(Math.pow((UserPlayer.getPlayerX() -
                this.getX()), 2)
                + Math.pow((UserPlayer.getPlayerY() -
                this.getY()), 2))
        		< 200)) {

            // Don't chase if a shooting enemy, instead shoot at
            // player.
        	if (this.getEnemyType() == Type.shootingEnemy 
        			&& getEnemyShootingWait() <= 0) {
        		beginEnemyShooting();
        		setEnemyShootingWait(70);
        		
        	} else if (this.getEnemyType() == Type.shootingEnemy 
        			&& getEnemyShootingWait() > 0) {
        		setEnemyShootingWait(getEnemyShootingWait() - 1);
        	} else {
        		setEnemyDirection();
        	}
        }
        
        // Adds wait time to the enemy for current direction.
        setEnemyWait(getEnemyWait() - 1);
        if (getEnemyWait() <= 0) {
        	setEnemyDirection();
        	setEnemyWait((randomNum.nextInt(9) + 1) * 10);
        }

        // Changes direction if enemy hits edge of screen in the
        // X direction.
        if (getX() + getEnemySize() > game.getWIDTH()) {
        	setEnemyDirection();
        	setEnemyWait((randomNum.nextInt(9) + 1) * 10);
        	setX(game.getWIDTH() - getEnemySize());
        }
        
        if (getX() < 0) {
        	setEnemyDirection();
        	setEnemyWait((randomNum.nextInt(9) + 1) * 10);
        	setX(0);
        }

        // Changes direction if enemy hits edge of screen in
        // the Y direction.
        if (getY() + getEnemySize() > game.getHEIGHT()) {
        	setEnemyDirection();
        	setEnemyWait((randomNum.nextInt(9) + 1) * 10);
        	setY(game.getHEIGHT() - getEnemySize());
        }

        if (getY() < 0) {
        	setEnemyDirection();
        	setEnemyWait((randomNum.nextInt(9) + 1) * 10);
        	setY(0);
        }
        
        // Remove bullet if it hits the enemy.
        for (int i = 0; i < handle.getList().size(); i++) {
            GameObject tempObject = handle.getList().get(i);
            if (tempObject.getType() == Type.bullet
                    && ((Bullet) tempObject).getShooter() ==
                    Type.player) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    health -= 20;
                    if (health == 0) {
                    	UserPlayer.setScore(UserPlayer.getScore() 
                    			+ this.getEnemyScore());
                        handle.removeObject(this);
                    }
                    handle.removeObject(tempObject);
                }
            }
        }
    }

    /******************************************************************
     * Draws the enemy based on it's size and color.
     *
     * @param g visual display for the 2D graphics.
     *****************************************************************/
    @Override
    public void render(final Graphics g) {
        g.setColor(getEnemyColor());
        g.fillRect(getX(), getY(), getEnemySize(), getEnemySize());
    }

    /******************************************************************
     * Returns the boundaries of the enemy based on its size as a
     * rectangle.
     *
     * @return The boundaries of the enemy as a rectangle.
     *****************************************************************/
    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), getEnemySize(),
                getEnemySize());
    }
}
