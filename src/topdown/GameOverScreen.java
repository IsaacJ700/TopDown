package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Class used to display the Game Over screen.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class GameOverScreen {

    /**
     * String holds the Game Over text.
     */
    private String gameOver;

    /**
     * String holds the Main Menu text.
     */
    private String mainMenu;

    /**
     * Instance of Game class.
     */
    private Game game;

    /**
     * Constructor initializes the Strings and sets this Game equal to
     * the instance ofGame provided in the parameters.
     *
     * @param game The instance of Game being passed to this
     * constructor.
     */
    public GameOverScreen(final Game game) {
        gameOver = "Game Over";
        mainMenu = "Main Menu";
        this.game = game;
    }

    /**
     * Creates the 2D graphics for the Game Over menu.
     *
     * @param g The visual display for the 2D graphics in the controls
     * menu.
     */
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
