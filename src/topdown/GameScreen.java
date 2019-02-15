package topdown;

import java.awt.*;

public class GameScreen {

    private Game game;
    private Player player;

    public GameScreen (Game game, Player player) {
        this.game = game;
        this.player = player;
    }

    public void render(Graphics2D g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.drawString("Health:",100,100);
        g.setColor(Color.RED);
        g.fillRect(100, 120, player.getHealth() * 2, 25);
        g.setColor(Color.WHITE);
        g.drawRect(100, 120, 200, 25);
        g.drawString("FPS: " + String.valueOf(game.getFrameCount()),900,700);
    }
}
