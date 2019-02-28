package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Menu {

    private String title;
    private String start;
    private String options;
    private String exit;
    private Game game;

    public Menu(final Game game) {
        title = "2D Shooter";
        start = "Start";
        options = "Options";
        exit = "Exit";
        this.game = game;
    }

    public void render(final Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);

        Font font = new Font("Arial", Font.BOLD, 70);
        Font titleFont = new Font("TitleFont", Font.ITALIC + Font.BOLD, 95);

        g.setFont(titleFont);
        g.drawString(title, 245, 225);
        g.setFont(font);
        g.setColor(Color.ORANGE);
        g.drawString(start, 420, 450);
        g.drawString(options, 367, 550);
        g.drawString(exit, 435, 650);
    }
}
