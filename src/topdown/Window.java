package topdown;

import java.awt.Dimension;
import javax.swing.JFrame;


/**
 * Used to create a window for the game screen to be played in.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Window {

	/** Holds the frame for the game screen. **/
    private static JFrame frame;

    /**
     * Creates a window for the game screen to be played in.
     * 
     * @param width The integer value for the width of the window.
     * @param height The integer value for the height of the window.
     * @param title The title for the window as a string.
     * @param game Holds the current game object.
     */
    public Window(final int width, final int height, 
    		final String title, final Game game) {

        frame = new JFrame(title);
        frame.setUndecorated(true);
        frame.pack();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
