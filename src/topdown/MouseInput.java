package topdown;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 * Class used to read mouseInput from the user.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class MouseInput implements MouseListener {

    /**
     * Instance of Game class.
     */
    private Game game;

    /**
     * Instance of Handler class.
     */

    private Handler handle;

    /**
     * Constructor initializes handle and game with the provided
     * instances.
     *
     * @param handle represents the instance of Handler being used.
     * @param game   represents the instance of Game being used.
     */
    public MouseInput(final Game game, final Handler handle) {
        this.game = game;
        this.handle = handle;
    }

    @Override
    public void mouseClicked(final MouseEvent e) {

    }

    /**
     * Method determines what shall happen when the user clicks the
     * left mouse button.
     *
     * @param e represents the MouseEvent that just occurred.
     */
    @Override
    public void mousePressed(final MouseEvent e) {
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
                    //Quit the game
                    System.exit(1);
                }
            }
        } else if (game.getState() == State.Game) {
            //Add bullets when mouse clicked
            for (int i = 0; i < handle.getList().size(); i++) {
                GameObject temp = handle.getList().get(i);
                if (temp.getType() == Type.player) {
                    try {
                        handle.addObject(new Bullet(temp.getX() + 15, 
                        		temp.getY() + 15, 
                        		Type.bullet, handle, x, y));
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        } else if (game.getState() == State.OptionsMenu) {
            if (x >= 72 && x <= 170) {
                if (y >= 48 && y <= 86) {
                    //Back Button... back to main menu
                    game.setState(State.Menu);
                }
            }
            if (x >= 355 && x <= 645) {
                if (y >= 240 && y <= 310) {
                    //controls menu
                    game.setState(State.ControlsMenu);
                }
            }
            if (x >= 355 && x <= 665) {
                if (y >= 360 && y <= 430) {
                    game.setState(game.getState()); //SoundFX toggle
                }
            }
            if (x >= 380 && x <= 620) {
                if (y >= 480 && y <= 550) {
                    //credits screen
                    game.setState(State.Credits);
                }
            }
        } else if (game.getState() == State.PauseMenu) {
            if (x >= 370 && x <= 625) {
                if (y >= 240 && y <= 310) {
                    //Restart button
                    game.reset();
                    game.setState(State.Menu);
                }
            }
            if (x >= 325 && x <= 675) {
                if (y >= 360 && y <= 430) {
                    //Toggle soundFX
                	game.setState(game.getState());
                }
            }
            if (x >= 420 && x <= 570) {
                if (y >= 480 && y <= 550) {
                    //Quit the game
                    System.exit(1);
                }
            }
            if (x >= 72 && x <= 170) {
                if (y >= 48 && y <= 86) {
                    //Return back to the game (Back button)
                    game.setState(State.Game);
                }
            }
        } else if (game.getState() == State.ControlsMenu) {
            if (x >= 72 && x <= 170) {
                if (y >= 48 && y <= 86) {
                    //Return back to the options menu (Back button)
                    game.setState(State.OptionsMenu);
                }
            }
        } else if (game.getState() == State.GameOver 
        			|| game.getState() == State.GameWon) {
            if (x >= 300 && x <= 700) {
                if (y >= 510 && y <= 580) {
                    //Reset game and load main menu
                    game.reset();
                    game.setState(State.Menu);
                }
            }
        } else if (game.getState() == State.Credits) {
            if (x >= 72 && x <= 170) {
                if (y >= 48 && y <= 86) {
                    //Return back to the options menu (Back button)
                    game.setState(State.OptionsMenu);
                }
            }
        }
    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }
}
