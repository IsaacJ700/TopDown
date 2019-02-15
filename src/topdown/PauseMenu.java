package topdown;

import java.awt.*;

public class PauseMenu{

    private String restart;
    private String quit;
    private String soundFX;
    private String back;
    private  Game game;

    public PauseMenu(Game game) {
        restart = "Restart";
        quit = "Quit";
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

        g.drawString(restart, 375, 300);
        g.drawString(soundFX, 335, 400);
        g.drawString(quit, 425, 500);

        g.drawRect(370, 240, 255, 70);
        g.drawRect(325, 340, 350, 70);
        g.drawRect(420, 440, 150,70);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}