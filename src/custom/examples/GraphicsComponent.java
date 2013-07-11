package custom.examples;

import swing.rendering.fundamentals.oval.compoment.OvalComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * User: tflomin
 * Date: 08.07.13
 * Time: 16:52
 */
public class GraphicsComponent extends JComponent {
    public static void main(String[] args) {
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.add(new GraphicsComponent());
        frame.setVisible(true);
    }

    /*@Override
    public void paintComponent(Graphics graphics) {
        Font newFont = graphics.getFont().deriveFont(Font.BOLD, 24f);

        Graphics2D graphics2d = (Graphics2D) graphics.create();
        graphics2d.setBackground(Color.WHITE);
        graphics2d.clearRect(0, 0, getWidth(), getHeight());

        graphics2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        graphics2d.drawLine(0, 0, 10, 10);
        graphics2d.dispose();

        graphics.setColor(Color.GREEN);

        graphics.setFont(newFont);
        graphics.drawString("String with new font", 20, 20);
    }*/

    @Override
    public void paintComponent(Graphics graphics) {
        Font newFont = graphics.getFont().deriveFont(Font.BOLD, 24f);

        Graphics2D graphics2d = (Graphics2D) graphics.create();
        graphics2d.setBackground(Color.WHITE);
        graphics2d.clearRect(0, 0, getWidth(), getHeight());


        graphics2d.setColor(Color.GREEN);

        graphics2d.setFont(newFont);
        graphics2d.drawString("String with new font", 20, 20);

        graphics2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        graphics2d.drawLine(40, 40, 100, 40);
        graphics2d.dispose();
    }

    /*@Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D) graphics.create();

        graphics2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        graphics2d.drawLine(0, 0, 10, 10);
        graphics2d.dispose();
    }*/
}
