package studio.visualdust.product.flashknow.GUI;

import javax.swing.*;
import java.awt.*;

public class Console extends JFrame {
    int HEIGHT = 400;
    int WIDTH = 600;

    public JList driveList = new JList();
    JScrollPane listScollPane = new JScrollPane(driveList);

    Console console = this;

    public Console() {
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH / 2, Toolkit.getDefaultToolkit().getScreenSize().height - HEIGHT / 2);
        listScollPane.setLocation(0, 0);
        listScollPane.setSize(console.getContentPane().getSize());
    }
}
