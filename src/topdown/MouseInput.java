package topdown;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    private Game game;
    private Handler handle;

    public MouseInput(Game game, Handler handle) {
        this.game = game;
        this.handle = handle;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if (game.getState() == State.Menu) {
            if (x >= 415 && x <= 585) {
                if (y >= 385 && y <= 465) {
                    //State is set to game
                    game.setState(State.Game);
                }
            }
            if (x >= 364 && x <= 636) {
                if (y >= 490 && y <= 570) {
                    //State is set to options
                    game.setState(State.OptionsMenu);
                }
            }
            if (x >= 430 && x <= 570) {
                if (y >= 590 && y <= 665) {
                    //IsRunning is set to false
                    System.exit(1);
                }
            }
        }
        else if (game.getState() == State.Game) {
            for (int i = 0; i < handle.list.size(); i++) {
                GameObject temp = handle.list.get(i);

                if (temp.getType() == Type.player) {
                    handle.addObject(new Bullet(temp.getX() + 15, temp.getY() + 15, Type.bullet, handle, x, y));
                }
            }
        }
        else if (game.getState() == State.OptionsMenu){
            if (x >= 72 && x <= 170){
                if (y >= 48 && y <= 86){
                    //Back Button... back to main menu
                    game.setState(State.Menu);
                }
            }
            if (x >= 355 && x <= 645){
                if (y >= 240 && y <= 310){
                    //controls menu
                }
            }
            if (x >= 355 && x <= 645){
                if (y >= 340 && y <= 410){
                    //SoundFX toggle
                }
            }
            if (x >= 380 && x <= 620){
                if (y >= 440 && y <= 510){
                    //credits screen
                }
            }
        }
        else if (game.getState() == State.PauseMenu){
            if (x >= 370 && x <= 625){
                if (y >= 240 && y <= 310){
                    //Restart game
                }
            }
            if (x >= 325 && x <= 675){
                if (y >= 340 && y <= 410){
                    //Toggle soundFX
                }
            }
            if (x >= 420 && x<= 570){
                if (y >= 440 && y <= 510){
                    System.exit(1);
                }
            }
            if (x >= 72 && x <= 170){
                if (y >= 48 && y <= 86){
                    game.setState(State.Game);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
