package swing.rendering.fundamentals.safe.repaint;

import java.awt.*;
import javax.swing.*;

/**
 * User: tflomin
 * Date: 05.07.13
 * Time: 17:51
 */
public class SafeComponent extends JLabel {
    public SafeComponent() {
        super("Safe Repaint");
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(SwingUtilities.isEventDispatchThread());
    }
}
