package topdown;

import java.awt.*;

public class Enemy extends GameObject{

    private Handler handle;
    private int health;
    private Game game;
    private int width;
    private int height;

    public Enemy(int x, int y, Type type, Handler handle, Game game){
        super(x, y, type);
        this.handle = handle;
        velX = 10;
        width = 20;
        height = 20;
        health = 100;
        this.game = game;
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
        g.setColor(Color.CYAN);
        g.fillRect(x, y, width, height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
