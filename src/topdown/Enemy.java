package topdown;

import java.awt.*;
import java.util.Random;
import java.util.Arrays;

public class Enemy extends GameObject{
    private Handler handle;
    private int health;
    private Game game;
    private int width;
    private int height;
    protected Type type;
    protected int size;
    protected Color color;
    
	Random randomNum = new Random();


    public Enemy(int x, int y, Type type, Handler handle, Game game){
    	super(x, y, type);
        this.handle = handle;
        velX = 10;
        width = 20;
        height = 20;
        health = 100;
        this.game = game;        
    	
        setEnemyType(type);
        setEnemySize(getEnemyType());
        setEnemyColor(getEnemyType());
    }

    public void followLogic(){

    }


    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x > game.getWIDTH()){
            x = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(getEnemyColor());
        g.fillRect(x, y, getEnemySize(), getEnemySize());
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
    
    private void setEnemySize(Type type) {
    	if( type.equals( Type.smallEnemy ))
    		this.size = 20;
    	else if( type.equals( Type.mediumEnemy ))
    		this.size = 40;
    	else if( type.equals( Type.largeEnemy ))
    		this.size = 60;
    	else if( type.equals( Type.bossEnemy ))
    		this.size = 90;
    	else if( type.equals( Type.shootingEnemy ))
    		this.size = 40;
    	else if( type.equals( Type.zombieEnemy ))
    		this.size = randomNum.nextInt(70) + 20;
    }
    
    private int getEnemySize() {
    	return size;
    }
    
    private void setEnemyColor(Type type) {
    	if( type.equals( Type.smallEnemy ))
    		this.color = Color.blue;
    	else if( type.equals( Type.mediumEnemy ))
    		this.color = Color.magenta;
    	else if( type.equals( Type.largeEnemy ))
    		this.color = Color.pink;
    	else if( type.equals( Type.bossEnemy ))
    		this.color = Color.red;
    	else if( type.equals( Type.shootingEnemy ))
    		this.color = Color.lightGray;
    	else if( type.equals( Type.zombieEnemy ))
    		this.color = Color.green;

    }
    
    private Color getEnemyColor() {
    	return color;
    }
    
    private void setEnemyType(Type type ) {
    	if(type == Type.randomEnemy)
    		this.type = getRandomEnemyType();
    	else
    		this.type = type;
    }
    
    private Type getEnemyType() {
    	return type;
    }
    
    private Type getRandomEnemyType() {
    	
    	Type[] enemyTypeArray = new Type[6];
    	for(int i=0; i<7; i++)
    		enemyTypeArray = new Type[i];
    	
    	enemyTypeArray[0] = Type.smallEnemy;
    	enemyTypeArray[1] = Type.mediumEnemy;
    	enemyTypeArray[2] = Type.largeEnemy;
    	enemyTypeArray[3] = Type.bossEnemy;
    	enemyTypeArray[4] = Type.zombieEnemy;
    	enemyTypeArray[5] = Type.shootingEnemy;
    	
    	return enemyTypeArray[randomNum.nextInt(6)];
    }
}
