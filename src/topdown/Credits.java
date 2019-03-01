package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Class used to display the Credits submenu.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Credits {

    /**
     * Creates an instance of the Game class.
     */
    private Game game;

    /**
     * Creates a String used for the back button.
     */
    private String back;

    /**
     * Creates a String used to hold the name of a developer.
     */
    private String name1;

    /**
     * Creates a String used to hold the name of a developer.
     */
    private String name2;

    /**
     * Creates a String used to hold the name of a developer.
     */
    private String name3;

    /**
     * Constructor initializes the Strings and sets the passed down
     * instance of Game to this class's instance of Game.
     *
     * @param game represents the instance of Game that is being passed
     *             down to this constructor.
     */
    public Credits(final Game game) {
        this.game = game;
        back = "Back";
        name1 = "Isaac Jimenez";
        name2 = "Suman Gurung";
        name3 = "Nicholas English";
    }

    /**
     * Creates the 2D graphics for the Credits menu.
     *
     * @param g The visual display for the 2D graphics in the controls
     * menu.
     */
    public void render(final Graphics2D g) {
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        //Paint the entire screen black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());

        //Draw the developer name Strings
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(name1, 250, 250);
        g.drawString(name2, 230, 400);
        g.drawString(name3, 200, 550);

        //Draw the back button
        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }

}
