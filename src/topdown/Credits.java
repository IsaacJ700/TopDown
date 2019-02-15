package topdown;

import java.awt.*;

public class Credits {

    private Game game;

    public Credits(Game game){
        this.game = game;
    }

    public void render(Graphics2D g){
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.setFont(font);
    }

}
