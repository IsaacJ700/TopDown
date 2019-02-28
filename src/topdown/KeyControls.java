package topdown;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControls extends KeyAdapter {

    private Handler handle;
    private Game game;

    public KeyControls(final Handler handle, final Game game) {
        this.handle = handle;
        this.game = game;
    }

    public void keyPressed(final KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handle.list.size(); i++) {
            GameObject temp = handle.list.get(i);

            if (temp.getType() == Type.player) {
                if (key == KeyEvent.VK_W) {
                    handle.setUp(true);
                }
                if (key == KeyEvent.VK_A) {
                    handle.setLeft(true);
                }
                if (key == KeyEvent.VK_S) {
                    handle.setDown(true);
                }
                if (key == KeyEvent.VK_D) {
                    handle.setRight(true);
                }
                if (key == KeyEvent.VK_ESCAPE) {
                    game.setState(State.PauseMenu);
                }
            }
        }
    }

    public void keyReleased(final KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handle.list.size(); i++) {
            GameObject temp = handle.list.get(i);

            if (temp.getType() == Type.player) {
                if (key == KeyEvent.VK_W) {
                    handle.setUp(false);
                }
                if (key == KeyEvent.VK_A) {
                    handle.setLeft(false);
                }
                if (key == KeyEvent.VK_S) {
                    handle.setDown(false);
                }
                if (key == KeyEvent.VK_D) {
                    handle.setRight(false);
                }
            }
        }
    }
}
