package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObject {
	
	/** Holds the handler object for the enemy object. **/
    private Handler handle;
    
    /** Holds the amount of health an enemy object has. **/
    private int health;
    
    /** Holds the current game object. **/
    private Game game;
    
    /** Holds the type of enemy the object is. **/
    private Type type;
    
    /** Holds the size of the enemy object. **/
    private int size;
    
    /** Holds the color of the enemy object. **/
    private Color color;
    
    /** Used for the random enemy type generator. **/
    private Random randomNum;


    public Enemy(final int x, final int y, final Type type, 
    		final Handler handle, final Game game) {
        super(x, y, type, handle);
        velX = 10;
        this.handle = handle;
        this.game = game;
        randomNum = new Random();
        setEnemyType(type);
        setEnemySize(getEnemyType());
        setEnemyColor(getEnemyType());
        setEnemyHealth(getEnemyType());
    }

    /**
     * Returns an int that represents the current health of the enemy object.
     * 
     * @return The health of the current enemy object.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the enemy health for the enemy object to the amount passed.
     * 
     * @param health The health to be set to the current enemy object.
     */
    public void setHealth(final int health) {
        this.health = health;
    }
    
    /**
     * Sets the enemy health based on the type of the enemy object.
     * 
     * @param type The enemy type of the current object.
     */
    private void setEnemyHealth(final Type type) {
    	if (type.equals(Type.smallEnemy)) {
    		setHealth(20);
    	} else if (type.equals(Type.mediumEnemy)) {
    		setHealth(80);
    	} else if (type.equals(Type.largeEnemy)) {
    		setHealth(200);
    	} else if (type.equals(Type.bossEnemy)) {
    		setHealth(1000);
    	} else if (type.equals(Type.shootingEnemy)) {
    		setHealth(80);
    	} else if (type.equals(Type.zombieEnemy)) {
    		setHealth(this.getEnemySize() + 100);
    	}
    }
    
    /**
     * Returns an int that represents the size of the enemy object.
     * 
     * @return The size of the current enemy object.
     */
    private int getEnemySize() {
        return size;
    }
    
    /**
     * Sets the enemy size based on the type of the enemy object.
     * 
     * @param type The enemy type of the current object.
     */
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
    		this.size = randomNum.nextInt(70) + 20;
    	}
    }

    /**
     * Returns a Color that represents the color of the enemy object.
     * 
     * @return The color of the current enemy object.
     */
    private Color getEnemyColor() {
        return color;
    }
    
    /**
     * Sets the enemy color based on the type of the enemy object.
     * 
     * @param type The enemy type of the current object.
     */
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

    /**
     * Returns a Type that represents the current object's enemy type.
     * 
     * @return The type of the current enemy object.
     */
    private Type getEnemyType() {
        return type;
    }

    /**
     * Takes in the type of enemy and sets it to the object. If the type
     * is of random enemy type, then it gets a random enemy type. 
     * 
     * @param type The enemy type of the current object.
     */
    private void setEnemyType(final Type type) {
    	if (type == Type.randomEnemy) {
    		this.type = getRandomEnemyType();
    	} else {
    		this.type = type;
    	}
    }
    
    /**
     * Returns a Type that represents a randomly selected enemy type. This 
     * uses a random number generator to pick from a list all of the possible
     * enemy types.
     * 
     * @return The randomly selected enemy for the random enemy type.
     */
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

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x > game.getWIDTH()) {
            x = 0;
        }

        for (int i = 0; i < handle.list.size(); i++) {
            GameObject tempObject = handle.list.get(i);
            if (tempObject.getType() == Type.bullet) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    health -= 20;
                    if (health == 0) {
                        handle.removeObject(tempObject);
                        handle.removeObject(this);
                    }
                }
            }
        }
    }

    @Override
    public void render(final Graphics g) {
        g.setColor(getEnemyColor());
        g.fillRect(x, y, getEnemySize(), getEnemySize());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, getEnemySize(), getEnemySize());
    }

}
