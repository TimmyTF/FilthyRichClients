package graphics.fundamentals.diagonal.line.demo;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * User: tflomin
 * Date: 11.07.13
 * Time: 11:09
 */
public class DiagonalLineDemo extends JComponent {

    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame("Diagonal Line Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 100);
        f.add(new DiagonalLineDemo());
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        g.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
    }
}

