package swing.rendering.fundamentals.freeze.edt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: tflomin
 * Date: 05.07.13
 * Time: 11:17
 */
public class FreezeEDT extends JFrame implements ActionListener {
    public FreezeEDT() {
        super("Freeze");
        JButton freezer = new JButton("Freeze");
        freezer.addActionListener(this);
        add(freezer);
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException evt) {
            System.err.println("InterruptedException");
        }
    }

    // TODO: 1. some day...
    /*public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            public void run() {
                String text = readHugeFile();
                // Bad code alert: modifying textArea on this thread
                // violates the EDT rule
                textArea.setText(text);
            }
        }).start();
    }*/

    // TODO: 2. some day later than the previous example...
    /*public void actionPerformed(ActionEvent e) {
        new Thread(new Runnable() {
            public void run() {
                final String text = readHugeFile();
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        textArea.setText(text);
                    }
                });
            }
        }).start();
    }*/

    public static void main(String... args) {
        FreezeEDT edt = new FreezeEDT();
        edt.setVisible(true);
    }

    // TODO: 2. ...
    /*public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FreezeEDT edt = new FreezeEDT();
                edt.setVisible(true);
            }
        });
    }*/
}
