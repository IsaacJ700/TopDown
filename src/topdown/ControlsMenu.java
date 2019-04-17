package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**********************************************************************
 * Class used to display the controls menu.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class ControlsMenu {

    /**
     * Holds the string description for the 'w' button on the keyboard.
     */
    private String w;

    /**
     * Holds the string description for the 'a' button on the keyboard.
     */
    private String a;

    /**
     * Holds the string description for the 's' button on the keyboard.
     */
    private String s;

    /**
     * Holds the string description for the 'd' button on the keyboard.
     */
    private String d;

    /**
     * Holds the on-screen "back" button string.
     */
    private String back;

    /**
     * Holds the string description for the left mouse button.
     */
    private String mouse;

    /**
     * Holds the string description for the "esc" button on the
     * keyboard.
     */
    private String escape;

    /**
     * Holds the string description for the space bar on the keyboard.
     */
    private String spaceBar;

    /**
     * Holds the integer value of the starting X-coordinate for the
     * text descriptions on the screen.
     */
    private int start;

    /**
     * Holds the current game object.
     */
    private Game game;

    /******************************************************************
     * Constructor initializes strings to be used to display controls
     * for the game. It also takes in a Game as a parameter and sets it
     * equal to the instance of Game created above.
     *
     * @param game represents the instance of Game that is being passed
     *             down to this constructor.
     *****************************************************************/
    public ControlsMenu(final Game game) {
        back = new String("Back");
        w = new String("W:  Move Up");
        a = new String("A:  Move Left");
        s = new String("S:  Move Down");
        d = new String("D:  Move Right");
        escape = new String("ESC:  Pause the game");
        mouse = new String("Left Mouse Button:  Shoot");
        spaceBar = "Space Bar: ";
        start = 120;
        this.game = game;
    }

    /******************************************************************
     * Creates the 2D graphics for the controls menu.
     *
     * @param g The visual display for the 2D graphics in the controls
     * menu.
     *****************************************************************/
    public void render(final Graphics2D g) {
        Font font = new Font("Arial", Font.ITALIC, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        //Paint the entire screen black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());

        //Draw the strings over the black screen
        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(w, start, 200);
        g.drawString(a, start, 275);
        g.drawString(s, start, 350);
        g.drawString(d, start, 425);
        g.drawString(escape, start, 500);
        g.drawString(mouse, start, 575);

        //Draw the back button string
        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}
