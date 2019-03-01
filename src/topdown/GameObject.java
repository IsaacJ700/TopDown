package topdown;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

    protected int x;
	protected int y;
    protected float velX = 0, velY = 0;
    protected Type type;
    protected Handler handle;

    public GameObject(final int x, final int y, final Type type, 
    		final Handler handle) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.handle = handle;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public void setVelX(final float velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(final float velY) {
        this.velY = velY;
    }
}
