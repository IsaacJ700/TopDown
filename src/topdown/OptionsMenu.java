package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Creates the options menu for the game.
 * 
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class OptionsMenu {

		/** Holds the string for the controls button. **/
        private String controls;
        
        /** Holds the string for the credits button. **/
        private String credits;
        
        /** Holds the string for the sound effect button. **/
        private String soundFX;
        
        /** Holds the string for the back button. **/
        private String back;
        
        /** Holds the current game object. **/
        private  Game game;

        /**
         * Creates the options menu for the game.
         * 
         * @param game The current game object.
         */
        public OptionsMenu(final Game game) {
            controls = "Controls";
            credits = "Credits";
            soundFX = "Sound FX";
            back = "Back";
            this.game = game;
        }

        /**
         * Renders the options menu screen for the game.
         * 
         * @param g The current game screen object.
         */
        public void render(final Graphics2D g) {

            Font font = new Font("Arial", Font.BOLD, 70);
            Font font2 = new Font("Arial", Font.PLAIN, 38);

            g.setColor(Color.BLACK);
            g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
            g.setColor(Color.WHITE);
            g.setFont(font);

            g.drawString(controls, 356, 300);
            g.drawString(soundFX, 335, 420);
            g.drawString(credits, 380, 540);

//            g.drawRect(355, 240, 290, 70);
//            g.drawRect(335, 360, 330, 70);
//            g.drawRect(380, 480, 240,70);
//            g.drawRect(72, 48, 98, 38);

            g.setFont(font2);
            g.setColor(Color.ORANGE);
            g.drawString(back, 80, 80);
        }
    }
