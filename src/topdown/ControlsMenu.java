package topdown;

import java.awt.*;

public class ControlsMenu{

    private String w;
    private String a;
    private String s;
    private String d;
    private String back;
    private String mouse;
    private String escape;
    private String spaceBar;
    private int start;
    private Game game;

    public ControlsMenu(Game game) {
        back = new String("Back");
        w = new String("W:  Move Up");
        a = new String("A:  Move Left");
        s = new String("S:  Move Down");
        d = new String("D:  Move Right");
        escape = new String("ESC:  Pause the game");
        mouse = new String("Left Mouse Button:  Shoot");
        spaceBar = "Space Bar: ";
        start = 120;
        this.game = game;
    }

    public void render(Graphics2D g){
        Font font = new Font("Arial", Font.ITALIC, 70);
        Font font2 = new Font("Arial", Font.PLAIN, 38);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWIDTH(), game.getHEIGHT());

        g.setColor(Color.WHITE);
        g.setFont(font);
        g.drawString(w, start, 200);
//        g.drawRect(300, 195, 400, 70);

        g.drawString(a, start, 275);
        g.drawString(s, start, 350);
        g.drawString(d, start, 425);
        g.drawString(escape, start, 500);
        g.drawString(mouse, start, 575);

        g.setFont(font2);
        g.setColor(Color.ORANGE);
        g.drawString(back, 80, 80);
    }
}