package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**********************************************************************
 * Class is used to display the options menu.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class OptionsMenu {

    /**
     * String holds the controls text.
     */
    private String controls;

    /**
     * String holds the credits text.
     */
    private String credits;

    /**
     * String holds the back button text.
     */
    private String back;

    /**
     * Instance of Game class.
     */
    private Game game;

    /******************************************************************
     * Constructor initializes Strings and sets this game equal to the
     * instance provided.
     *
     * @param game The instance of Game being passed to this
     * constructor.
     *****************************************************************/
    public OptionsMenu(final Game game) {
        controls = "Controls";
        credits = "Credits";
        back = "Back";
        this.game = game;
    }

    /******************************************************************
     * Creates the 2D graphics for the Options Menu.
     *
     * @param g The visual display for the 2D graphics in the options
     * menu.
     *****************************************************************/
    public void render(final Graphics2D g) {

        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.setFont(font);

        g.drawString(controls, 356, 300);
        g.drawString(credits, 380, 540);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}
