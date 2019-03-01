package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GameOverScreen {

    private String gameOver;
    private String mainMenu;
    private Game game;

    public GameOverScreen(final Game game) {
        gameOver = "Game Over";
        mainMenu = "Main Menu";
        this.game = game;
    }

    public void render(final Graphics2D g) {
        Font font = new Font("Arial", Font.PLAIN, 120);
        Font font2 = new Font("Standard", Font.PLAIN, 80);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawString(gameOver, 188, 350);

        g.setColor(Color.WHITE);
        g.setFont(font2);
        g.drawString(mainMenu, 302, 575);
    }
}
