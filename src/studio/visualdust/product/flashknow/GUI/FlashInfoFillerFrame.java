package studio.visualdust.product.flashknow.GUI;

import studio.visualdust.product.flashknow.UITheme;
import studio.visualdust.product.gztwigets.GButton;
import studio.visualdust.product.gztwigets.GTextField;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FlashInfoFillerFrame extends JFrame {
    public GButton okButton = new GButton("好的");
    public GTextField ownerNameField = new GTextField("");
    public GTextField discriptionField = new GTextField("");
    JLabel ownerNameLabel = new JLabel("", JLabel.LEFT);
    JLabel discriptionLabel = new JLabel("请输入对该设备的描述", JLabel.LEFT);
    FlashInfoFillerFrame flashInfoFillerFrame = this;

    public FlashInfoFillerFrame(File drive) {
        this.setUndecorated(true);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setSize(500, 450);
        this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 250, Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 225);
        ownerNameLabel.setText("请问设备" + FileSystemView.getFileSystemView().getSystemDisplayName(drive) + "的拥有者是？");
        this.add(ownerNameLabel);
        this.add(ownerNameField);
        this.add(discriptionLabel);
        this.add(discriptionField);
        this.add(okButton);
        ownerNameLabel.setLocation(50, 50);
        ownerNameLabel.setSize(400, 50);
        ownerNameField.setLocation(50, 150);
        ownerNameField.SetSize(new Dimension(400, 50));
        discriptionLabel.setLocation(50, 200);
        discriptionLabel.setSize(400, 50);
        discriptionField.setLocation(50, 250);
        discriptionField.SetSize(new Dimension(400, 50));
        okButton.setLocation(350, 350);
        okButton.SetSize(new Dimension(100, 50));
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                flashInfoFillerFrame.setVisible(false);
            }
        });

        this.setVisible(true);
    }

    public String getOwnerName() {
        return ownerNameField.getText();
    }

    public String getDiscription() {
        return discriptionField.getText();
    }
}
