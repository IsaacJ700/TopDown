package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Credits {

    private Game game;
    private String back;

    public Credits(final Game game) {
        this.game = game;
        back = new String("Back");
    }

    public void render(final Graphics2D g) {
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.ORANGE);
        g.setFont(font2);
        g.drawString(back, 80, 80);
    }

}
