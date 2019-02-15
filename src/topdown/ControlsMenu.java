package topdown;

import java.awt.*;

public class ControlsMenu{

    private String w;
    private String a;
    private String s;
    private String d;
    private String escape;
    private String spacebar;
    private Game game;

    public ControlsMenu(Game game) {
        w = new String("W: Move Up");
        a = new String("A: Move Left");
        s = new String("S: Move Down");
        d = new String("D: Move Right");
        escape = new String("ESC: Pause the game");
        spacebar = "Spacebar: ";
        this.game = game;
    }

    public void render(Graphics2D g){
        Font font = new Font("Arial", Font.BOLD, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());
        g.setColor(Color.WHITE);
        g.setFont(font);

    }
}