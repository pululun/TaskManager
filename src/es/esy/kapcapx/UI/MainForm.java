package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.Tasks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{
    private int frameWidth = 500;
    private int frameHeight = 600;
    private JList<Task> listTask;
    private Tasks tasks;
    private JButton addButton = new JButton("Добавить");
    private JButton delButton = new JButton("Удалить");

    public MainForm(Tasks tasks) {
        this.tasks = tasks;
        setTitle("Task Manager");
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(createBottomPanel(), BorderLayout.SOUTH);
        add(createListPanel());
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(listTask = createListTask()), BorderLayout.CENTER);
        return panel;
    }

    private JList<Task> createListTask() {
        DefaultListModel<Task> model = new DefaultListModel<>();
        for (Task task : tasks.getTasks()) {
            model.addElement(task);
        }
        JList<Task> list = new JList<>(model);
        list.setCellRenderer(new TaskRenderer());
        return list;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(500, 40));
        bottomPanel.setLayout(new GridLayout(1, 2));
        this.add(bottomPanel, BorderLayout.PAGE_END);
        bottomPanel.add(addButton);
        bottomPanel.add(delButton);
        addButton.addActionListener(new ButtonAddListener());
        delButton.addActionListener(new ButtonDelListener());
        return bottomPanel;
    }

    private class ButtonAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += " YES ";
            addButton.setText(message);
        }
    }

    private class ButtonDelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += " NO ";
            delButton.setText(message);
        }
    }
}
