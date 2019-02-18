package topdown;

import java.awt.*;

public class Wall extends GameObject {

    private int Width = 10;
    private int Height = 10;

    private Handler handle;

    public Wall(int x, int y, Type type, Handler handle){
        super(x, y, type, handle);
        this.handle = handle;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, Width, Height);
//        g.
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, Width, Height);
    }
}
