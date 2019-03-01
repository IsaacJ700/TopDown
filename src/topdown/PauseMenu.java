package topdown;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class PauseMenu {

    private String restart;
    private String quit;
    private String soundFX;
    private String back;
    private  Game game;

    public PauseMenu(final Game game) {
        restart = "Restart";
        quit = "Quit";
        soundFX = "Sound FX";
        back = "Back";
        this.game = game;
    }

    public void render(final Graphics2D g) {

        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.setFont(font);

        g.drawString(restart, 375, 300);
        g.drawString(soundFX, 335, 420);
        g.drawString(quit, 425, 540);

        g.drawRect(370, 240, 255, 70);
        g.drawRect(325, 360, 350, 70);
        g.drawRect(420, 480, 150, 70);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}
