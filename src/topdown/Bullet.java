package topdown;

import java.awt.*;

public class Bullet extends GameObject {

    private Handler handle;

    public Bullet(int x, int y, Type type, Handler handle, int xSpd, int ySpd) {
        super(x, y, type, handle);
        this.handle = handle;
        calculateVelocity(x, y, xSpd, ySpd);
    }

    public void calculateVelocity(int fromX, int fromY, int toX, int toY) {
        double distance = Math.sqrt(Math.pow((toX - fromX), 2) + Math.pow((toY - fromY), 2));
        double speed = 15; //set the speed in [2,n)  n should be < 20 for normal speed
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
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 5, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 10);
    }
}
