package es.esy.kapcapx.action;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.IOException;

public class Tray{
    private static final String filename = "task_manager.gif";
    private static final String workDir = System.getProperty("user.dir");
    private static final String separator = System.getProperty("file.separator");
    private SystemTray systemTray = SystemTray.getSystemTray();
    private TrayIcon trayIcon;

    public Tray(JFrame jFrame) throws IOException {
        final String fullPath = workDir + separator + filename;
        trayIcon = new TrayIcon(ImageIO.read(new File(fullPath)), "Tray application");
        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(true);
                jFrame.setState(JFrame.NORMAL);
                removeTrayIcon();
            }
        });
        jFrame.addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == jFrame.ICONIFIED) {
                    jFrame.setVisible(false);
                    addTrayIcon();
                }
            }
        });
    }

    private void addTrayIcon() {
        try {
            systemTray.add(trayIcon);
            trayIcon.displayMessage("Task Manager", "Нажми дважды, что бы развернуть", TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void removeTrayIcon() {
        systemTray.remove(trayIcon);
    }
}
