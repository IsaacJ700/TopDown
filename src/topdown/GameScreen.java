package topdown;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class used to display the Game screen.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class GameScreen {

    /**
     * Holds the current game object.
     */
    private Game game;

    /**
     * Holds the current player object.
     */
    private UserPlayer player;

    /**
     * Holds the starting position for the object on the X-axis.
     */
    private int startX;

    /**
     * Holds the starting position for the object on the Y-axis.
     */
    private int startY;

    /**
     * Constructor initializes variables and sets this Game equal to
     * the provided instance of Game, and same for Player.
     *
     * @param game represents the instance of Game that is being passed
     *               down to this constructor.
     * @param player represents the instance of Player that is being
     *               passes down to this constructor
     */
    public GameScreen(final Game game, final UserPlayer player) {
        startX = 60;
        startY = 60;
        this.game = game;
        this.player = player;
    }

    /**
     * Renders the screen overlay HUD for the in-game screen.
     *
     * @param g The 2D graphic screen to be rendered.
     */
    public void render(final Graphics2D g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.BLACK);
        g.fillRect(startX + 18, startY + 18, 110, 20);
        g.fillArc(startX + 108, startY + 18, 40, 40, 0, 90);
        g.fillRect(startX + 18, startY + 38, 204, 29);
        g.setColor(Color.CYAN);
        g.fillRect(startX + 20, startY + 40, player.getHealth() * 2, 25);
        g.setColor(Color.WHITE);
        g.drawString("Health: " + player.getHealth(), startX + 33, startY + 33);
        g.drawString("FPS: " + String.valueOf(game.getFrameCount()), 900, 700);
    }
}
