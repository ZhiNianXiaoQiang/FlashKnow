package studio.visualdust.product.flashknow;

import studio.visualdust.product.flashknow.GUI.Console;
import studio.visualdust.product.flashknow.Resource.Resource;
import studio.visualdust.product.flashknow.Runable.MainThread;
import studio.visualdust.product.flashknow.method.EventRW;
import studio.visualdust.product.flashknow.method.Speaker;
import studio.visualdust.product.gztwigets.GMessageWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlashKnowLuncher {
    public static void main(String[] args) {
        Speaker.Speak("移动存储设备身份识别正在启动。Supported by " + Resource.author);
        ImageIcon icon = null;
//        new SaySomething();
        Console console = new Console();
        new UITheme(console);
        try {
            icon = new ImageIcon(Resource.class.getResource("WindowIcon.png").toURI().toURL());
            console.setIconImage(icon.getImage());
            Thread.sleep(9000);
        } catch (Exception e) {
            EventRW.Write(e);
        }
        MainThread mainThread = new MainThread(console);

        if (SystemTray.isSupported()) {// 判断当前平台是否支持系统托盘
            PopupMenu trayPopMenu = new PopupMenu();
//        MenuItem titleMenuItem = new MenuItem("ScreenDark");
            MenuItem exitMenuItem = new MenuItem("EXIT");
            MenuItem consoleStatusMenuItem = new MenuItem("Hide/Show console");
            SystemTray systemTray;
            systemTray = SystemTray.getSystemTray();
            try {
                icon = new ImageIcon(Resource.class.getResource("SystemArrIcon.png").toURI().toURL());
                TrayIcon trayIcon = new TrayIcon(icon.getImage(), Resource.softName + Resource.version, trayPopMenu);
                systemTray.add(trayIcon);
            } catch (Exception e) {
                EventRW.Write(e);
            }
            trayPopMenu.addSeparator();
            trayPopMenu.add(consoleStatusMenuItem);
            consoleStatusMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    console.setVisible(!console.isVisible());
                    EventRW.Write((console.isVisible() ? "Show" : "Hide") + " the console window");
                }
            });
            trayPopMenu.addSeparator();
            trayPopMenu.add(exitMenuItem);
            exitMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GMessageWindow gMessageWindow = new GMessageWindow(console, 1, "Are you sure to exit ?");
                    gMessageWindow.okButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            Speaker.Speak("移动存储设备身份识别正在关闭");
                            EventRW.Write("User exited");
                            System.exit(0);
                        }
                    });
                }
            });
        }
    }
}
