package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Credits {

    private Game game;
    private String back;
    private String name1;
    private String name2;
    private String name3;

    public Credits(final Game game) {
        this.game = game;
        back = "Back";
        name1 = "Isaac Jimenez";
        name2 = "Suman Gurung";
        name3 = "Nicholas English";
    }

    public void render(final Graphics2D g) {
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(name1, 250, 250);
        g.drawString(name2, 230, 400);
        g.drawString(name3, 200, 550);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }

}
