package topdown;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window {

    private static JFrame frame;

    public Window(final int width, final int height, 
    		final String title, final Game game) {

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
