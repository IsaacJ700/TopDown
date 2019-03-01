package topdown;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class is used to read keystrokes and let program know if the player
 * should move in a specific direction.
 *
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class KeyControls extends KeyAdapter {

    /**
     * Instance of Handler class.
     */
    private Handler handle;

    /**
     * Instance of Game class.
     */
    private Game game;

    /**
     * Constructor initializes handle and game with the provided
     * instances
     *
     * @param handle represents the instance of Handler being used.
     * @param game   represents the instance of Game being used.
     */
    public KeyControls(Handler handle, Game game){
        this.handle = handle;
        this.game = game;
    }

    /**
     * Method checks keystrokes and then determines whether or not
     * the player should move in a direction.
     *
     * @param e represents the keystroke.
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handle.list.size(); i++){
            GameObject temp = handle.list.get(i);

            if (game.getState() != State.Game) {
                handle.setUp(false);
                handle.setDown(false);
                handle.setLeft(false);
                handle.setRight(false);
            }

            if (game.getState() == State.Game) {
                if (temp.getType() == Type.player) {
                    if (key == KeyEvent.VK_W)
                        handle.setUp(true);
                    if (key == KeyEvent.VK_A)
                        handle.setLeft(true);
                    if (key == KeyEvent.VK_S)
                        handle.setDown(true);
                    if (key == KeyEvent.VK_D)
                        handle.setRight(true);
                    if (key == KeyEvent.VK_ESCAPE)
                        game.setState(State.PauseMenu);
                }
            }
        }
    }

    /**
     * Method checks keystroke releases and then determines whether or
     * not the player should be halted
     *
     * @param e represents the keystroke.
     */
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for (int i = 0; i < handle.list.size(); i++) {
            GameObject temp = handle.list.get(i);

            if (game.getState() == State.Game) {
                if (temp.getType() == Type.player) {
                    if (key == KeyEvent.VK_W)
                        handle.setUp(false);
                    if (key == KeyEvent.VK_A)
                        handle.setLeft(false);
                    if (key == KeyEvent.VK_S)
                        handle.setDown(false);
                    if (key == KeyEvent.VK_D)
                        handle.setRight(false);
                }
            }
        }
    }
}
