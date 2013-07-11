package graphics.fundamentals.antialiasing.demo;

import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * User: tflomin
 * Date: 09.07.13
 * Time: 11:22
 */
public class AntialiasingDemo extends JComponent {

    public static void main(String args[]) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(150, 100);
        JComponent test = new AntialiasingDemo();
        f.add(test);
        f.setVisible(true);
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setBackground(Color.WHITE);
        g2d.clearRect(0, 0, getWidth(), getHeight());

        // Draw line with default (aliased) rendering
        g2d.drawLine(0, 0, 50, 50);

        // Set antialiasing hint, draw line again
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(50, 0, 100, 50);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2d.drawString("LCD_HRGB", 30, 80);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HBGR);
        g2d.drawString("LCD_HBGR", 30, 100);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VRGB);
        g2d.drawString("LCD_VRGB", 30, 120);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_VBGR);
        g2d.drawString("LCD_VBGR", 30, 140);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.drawString("ANTIALIAS_ON", 30, 160);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        g2d.drawString("ANTIALIAS_OFF", 30, 180);

        Shape shape = g2d.getClip();
        Rectangle bounds = shape.getBounds();
        System.out.println("New");
        System.out.println("X = " + bounds.getX());
        System.out.println("Y = " + bounds.getY());

        g2d.dispose();
    }
}
