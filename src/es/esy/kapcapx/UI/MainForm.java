package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.Tasks;
import es.esy.kapcapx.action.TimeManipulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
        TimeManipulation.updateTimeTask(tasks);
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JScrollPane jScrollPane = new JScrollPane(listTask = createListTask());
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(jScrollPane, BorderLayout.CENTER);
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

    private void updateListTask(Tasks tasks) {
        DefaultListModel<Task> model = new DefaultListModel<>();
        for (Task task : tasks.getTasks()) {
            model.addElement(task);
        }
        listTask.setModel(model);
    }

    public Tasks getTasks() {
        return tasks;
    }

    private class ButtonAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddForm addForm = new AddForm(tasks);
            addForm.setVisible(true);
            addForm.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    setEnabled(false);
                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    updateListTask(tasks);
                    setEnabled(true);
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
        }
    }

    private class ButtonDelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DeleteForm deleteForm = new DeleteForm(tasks);
            deleteForm.setVisible(true);
            deleteForm.addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {
                    setEnabled(false);
                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    updateListTask(tasks);
                    setEnabled(true);
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
        }
    }
}
