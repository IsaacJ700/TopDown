package topdown;

import java.awt.*;

public class GameWonScreen {

    private String gameOver;
    private String mainMenu;
    private Game game;

    public GameWonScreen(Game game) {
        gameOver = "You Won!!";
        mainMenu = "Main Menu";
        this.game = game;
    }

    public void render(Graphics2D g) {
        Font font = new Font("Arial", Font.PLAIN, 150);
        Font font2 = new Font("Standard", Font.PLAIN, 80);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.YELLOW);
        g.setFont(font);
        g.drawString(gameOver, 152, 350);

        g.setColor(Color.WHITE);
        g.setFont(font2);
        g.drawString(mainMenu, 302, 575);
    }

}
