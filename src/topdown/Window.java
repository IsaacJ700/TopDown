package topdown;

import javax.swing.*;
import java.awt.*;

public class Window {

    public static JFrame frame;

    public Window (int width, int height, String title, Game game){

        frame = new JFrame(title);
        frame.setUndecorated(true);
        frame.pack();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
