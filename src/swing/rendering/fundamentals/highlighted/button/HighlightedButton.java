package swing.rendering.fundamentals.highlighted.button;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * User: tflomin
 * Date: 01.07.13
 * Time: 10:36
 */
public class HighlightedButton extends JButton {
    static final int HIGHLIGHT_SIZE = 18;
    BufferedImage highlight = new BufferedImage(HIGHLIGHT_SIZE, HIGHLIGHT_SIZE, BufferedImage.TYPE_INT_ARGB);

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
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.add(new JButton("Standard"));
        frame.add(new HighlightedButton("Highlighted"));
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics); // paints standard swing button...
        graphics.drawImage(highlight, getWidth() / 4, getHeight() / 4, null); // and then we do our little magic.
    }

    public HighlightedButton(String label) {
        super(label);
        Graphics2D graphics2D = highlight.createGraphics();
        graphics2D.setComposite(AlphaComposite.Clear);
        graphics2D.fillRect(0, 0, HIGHLIGHT_SIZE, HIGHLIGHT_SIZE);
        graphics2D.setComposite(AlphaComposite.SrcOver);

        float radius = (float) HIGHLIGHT_SIZE / 2.0f;
        Point2D center = new Point2D.Float(radius, radius);
        float[] dist = {0.0f, .85f};
        Color[] colors = {Color.WHITE, new Color(255, 255, 255, 0)};

        RadialGradientPaint paint = new RadialGradientPaint(center, radius, dist, colors);
        graphics2D.setPaint(paint);
        graphics2D.fillOval(0, 0, HIGHLIGHT_SIZE, HIGHLIGHT_SIZE);
        graphics2D.dispose();
    }
}
