package custom.examples;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

/**
 * User: tflomin
 * Date: 08.07.13
 * Time: 10:17
 */
public class ClownButton {
    private static Button button = new Button("Okay");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.setBackground(Color.lightGray);
        button.setPreferredSize(new Dimension(50, 30));

        frame.add(button, BorderLayout.SOUTH);

        // java.util.Timer usage
        /*java.util.Timer clown = new java.util.Timer();
        clown.schedule(new TimerTask() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        button.setForeground(getRandomColor());
                    }
                });
            }
        }, 0, 3000);*/

        // javax.swing.Timer usage
        javax.swing.Timer clown = new javax.swing.Timer(3000,
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        button.setForeground(getRandomColor());
                    }
                });
        clown.start();

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static Color getRandomColor() {
        System.out.println("getRandomColor");
        Random rand = new Random();
        if (rand.nextInt() % 2 == 0)
            return Color.BLUE;
        else if (rand.nextInt() % 5 == 0)
            return Color.RED;
        else if (rand.nextInt() % 9 == 0)
            return Color.GREEN;
        else
            return Color.magenta;
    }
}
