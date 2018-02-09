package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;

import javax.swing.*;
import java.awt.*;

public class CompletedTaskForm extends JFrame {
    private Task task;
    private String titleForm = "Время выполнения вышло";
    private int width = 480;
    private int height = 170;
    private JPanel panel = new JPanel();
    private JLabel lTitle = new JLabel();
    private JLabel lDescription = new JLabel();
    private JLabel lDate = new JLabel();
    private JLabel lContacts = new JLabel();

    public CompletedTaskForm(Task task) {
        this.task = task;
        setTitle(titleForm);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setAlwaysOnTop(true);

        add(panel, BorderLayout.CENTER);

        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(null);
        lTitle.setText(task.getTitle());
        lDescription.setText(task.getDescription());
        lDate.setText(String.valueOf(task.getDate()));
        lContacts.setText(task.getContacts());
        panel.add(lTitle);
        panel.add(lDescription);
        panel.add(lDate);
        panel.add(lContacts);
        Insets insets = this.getInsets();
        Dimension sizeTitle = new Dimension(160, 15);
        Dimension sizeDescription = new Dimension(480, 15);
        Dimension sizeDate = new Dimension(235, 15);
        Dimension sizeContacts = new Dimension(160, 15);
        lTitle.setBounds(2 + insets.left, 2 + insets.top, sizeTitle.width, sizeTitle.height);
        lDescription.setBounds(12 + insets.left, 50 + insets.top, sizeDescription.width, sizeDescription.height);
        lDate.setBounds(240 + insets.left, 2 + insets.top, sizeDate.width, sizeDate.height);
        lContacts.setBounds(330 + insets.left, 110 + insets.top, sizeContacts.width, sizeContacts.height);
    }
}
