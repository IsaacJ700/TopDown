package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Class used to display the Game Won screen.
 *
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class GameWonScreen {

    /**
     * String used to hold Game Over text.
     */
    private String gameOver;

    /**
     * String used to hold Main Menu text.
     */
    private String mainMenu;

    /**
     * Holds the current game object.
     */
    private Game game;

    /**
     * Constructor initializes Strings ad sets this Game equal to the
     * Game provided in the parameters.
     *
     * @param game represents the instance of Game that is being passed
     *             down to this constructor.
     */
    public GameWonScreen(final Game game) {
        gameOver = "You Won!!";
        mainMenu = "Main Menu";
        this.game = game;
    }

    /**
     * Renders the Game Won screen.
     *
     * @param g The 2D graphic screen to be rendered.
     */
    public void render(final Graphics2D g) {
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
