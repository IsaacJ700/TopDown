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
        Font font = new Font("Arial", Font.PLAIN, 90);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.RED);
        g.setFont(font);
        g.drawRect(265, 280, 470, 75);
        g.drawString(gameOver, 265, 350);

    }

}
