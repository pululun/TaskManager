package es.esy.kapcapx.UI;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.Tasks;
import es.esy.kapcapx.action.Act;

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
    private Task task;
    private String titleTask;
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

    public void addTask() {
        Act act = new Act();
        act.taskAdd(tasks, task.getTitle(), task.getDescription(), task.getDate(), task.getContacts());
        updateListTask(tasks);
    }

    public void deleteTask() {
        Act act = new Act();
        act.taskRemove(tasks, this.titleTask);
        updateListTask(tasks);
    }

    private void updateListTask(Tasks tasks) {
        DefaultListModel<Task> model = new DefaultListModel<>();
        for (Task task : tasks.getTasks()) {
            model.addElement(task);
        }
        listTask.setModel(model);
    }

    private void setTask(Task task) {
        this.task = task;
        System.out.println(task.toString());
    }

    public Tasks getTasks() {
        return tasks;
    }

    private void setTitleTask(String titleTask) {
        this.titleTask = titleTask;
    }

    public String getTitleTask() {
        return titleTask;
    }

    private class ButtonAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddForm addForm = new AddForm();
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
                    if (addForm.getTask() != null) {
                        setTask(addForm.getTask());
                        addTask();
                    }
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
            DeleteForm deleteForm = new DeleteForm();
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
                    if (deleteForm.getTitleTask() != null) {
                        setTitleTask(deleteForm.getTitleTask());
                        deleteTask();
                    }
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
