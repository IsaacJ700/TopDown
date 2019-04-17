package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**********************************************************************
 * Class is used to render the main menu.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class Menu {

    /**
     * String used to hold Title text.
     */
    private String title;

    /**
     * String used to hold start button text.
     */
    private String start;

    /**
     * String used to hold options button text.
     */
    private String options;

    /**
     * String used to hold exit button text.
     */
    private String exit;

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
    public Menu(final Game game) {
        title = "2D Shooter";
        start = "Start";
        options = "Options";
        exit = "Exit";
        this.game = game;
    }

    /******************************************************************
     * Creates the 2D graphics for the Main Menu.
     *
     * @param g The visual display for the 2D graphics in the main
     * menu.
     *****************************************************************/
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
