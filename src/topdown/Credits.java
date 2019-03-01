package topdown;

import java.awt.*;

public class Credits {

    private Game game;
    private String back;

    public Credits(Game game){
        this.game = game;
        back = new String("Back");
    }

    public void render(Graphics2D g){
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.ORANGE);
        g.setFont(font2);
        g.drawString(back, 80, 80);
    }

}
