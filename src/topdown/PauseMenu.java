package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Class used to display the pause menu.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class PauseMenu {

    /**
     * String used to hold the restart text.
     */
    private String restart;

    /**
     * String used to hold the quit text.
     */
    private String quit;

    /**
     * String used to hold the soundFX text.
     */
    private String soundFX;

    /**
     * String used to hold the back button text.
     */
    private String back;

    /**
     * Instance of Game class.
     */
    private  Game game;

    /**
     * Constructor initializes Strings and sets this game equal to the
     * instance provided.
     *
     * @param game The instance of Game being passed to this
     *             constructor.
     */
    public PauseMenu(final Game game) {
        restart = "Restart";
        quit = "Quit";
        soundFX = "Sound FX";
        back = "Back";
        this.game = game;
    }

    /**
     * Creates the 2D graphics for the Pause Menu.
     *
     * @param g The visual display for the 2D graphics in the pause
     * menu.
     */
    public void render(final Graphics2D g) {

        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.setFont(font);

        g.drawString(restart, 375, 300);
        g.drawString(soundFX, 335, 420);
        g.drawString(quit, 425, 540);

        g.drawRect(370, 240, 255, 70);
        g.drawRect(325, 360, 350, 70);
        g.drawRect(420, 480, 150, 70);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}
