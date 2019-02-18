package topdown;

import java.awt.*;

public class GameScreen {

    private Game game;
    private Player player;
    private int startX;
    private int startY;

    public GameScreen (Game game, Player player) {
        startX = 60;
        startY = 60;
        this.game = game;
        this.player = player;
    }

    public void render(Graphics2D g){
        g.setColor(Color.gray);
        g.fillRect(0,0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.BLACK);
        g.fillRect(startX + 18, startY + 18, 110, 20);
        g.fillArc(startX + 108, startY + 18, 40, 40, 0, 90);
        g.fillRect(startX + 18, startY + 38, 204, 29);
        g.setColor(Color.CYAN);
        g.fillRect(startX + 20, startY + 40, player.getHealth() * 2, 25);
        g.setColor(Color.WHITE);
        g.drawString("Health: " + player.getHealth(), startX + 33, startY + 33);
        g.drawString("FPS: " + String.valueOf(game.getFrameCount()),900,700);
    }
}
