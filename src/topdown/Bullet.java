package topdown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bullet extends GameObject {

    private Handler handle;
    private BufferedImage bullet;

    public Bullet(final int x, final int y, final Type type, 
    		final Handler handle, final int xSpd, 
    		final int ySpd) throws IOException {
        super(x, y, type, handle);
        this.handle = handle;
        calculateVelocity(x, y, xSpd, ySpd);
//        bullet = read(new File("Bullet.jpg"));
    }

    public void calculateVelocity(final int fromX, final int fromY, 
    		final int toX, final int toY) {
    	
    	double distance = Math.sqrt(Math.pow((toX - fromX), 2) 
    						+ Math.pow((toY - fromY), 2));
    	//set the speed in [2,n)  n should be < 20 for normal speed
    	double speed = 15;
        //find Y
        velY = (float) ((toY - fromY) * speed / distance);
        //find X
        velX = (float) ((toX - fromX) * speed / distance);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(final Graphics g) {
//        g.drawImage(bullet, x, y, (ImageObserver) this);
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 5, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 10);
    }
}
