package swing.rendering.fundamentals.image.loader.ImageLoader;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * User: tflomin
 * Date: 08.07.13
 * Time: 11:26
 */
public class ImageLoader extends JFrame {
    private JTextArea log;
    private JPanel viewer;

    public ImageLoader() {
        super("Image Loader");

        this.log = new JTextArea(4, 4);
        this.viewer = new JPanel();

        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] files = new String[] {
                        "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Bodie_small.png", "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Carmela_small.png",
                        "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Unknown.png", "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Denied.png",
                        "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Death Valley_small.png", "D:\\FilthyRichClients\\src\\swing\\rendering\\fundamentals\\image\\loader\\ImageLoader\\Lake_small.png"
                };
                new ImageLoadingWorker(log, viewer, files).execute();
            }
        });

        add(new JScrollPane(log), BorderLayout.NORTH);
        add(new JScrollPane(viewer), BorderLayout.CENTER);
        add(start, BorderLayout.SOUTH);

        setSize(360, 280);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageLoader().setVisible(true);
            }
        });
    }
}
