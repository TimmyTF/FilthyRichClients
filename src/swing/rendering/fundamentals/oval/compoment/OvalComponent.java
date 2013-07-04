package swing.rendering.fundamentals.oval.compoment;

import javax.swing.*;
import java.awt.*;

/**
 * User: tflomin
 * Date: 01.07.13
 * Time: 10:19
 */
public class OvalComponent extends JComponent {
    public static void main(String[] args) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Oval");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new OvalComponent());
        frame.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        graphics.setColor(getBackground()); // set the same color as the background color...
        graphics.fillRect(0, 0, getWidth(), getHeight()); // and assign it to the rectangle area;
        graphics.setColor(Color.GRAY); // set color to gray...
        graphics.fillOval(0, 0, getWidth(), getHeight()); // and assign it to the oval area.
    }
}
