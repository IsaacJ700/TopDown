package topdown;

import java.awt.*;

public class OptionsMenu{

        private String controls;
        private String credits;
        private String soundFX;
        private String back;
        private  Game game;

        public OptionsMenu(Game game) {
            controls = "Controls";
            credits = "Credits";
            soundFX = "Sound FX";
            back = "Back";
            this.game = game;
        }

        public void render(Graphics2D g){

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