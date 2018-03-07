package es.esy.kapcapx;

import es.esy.kapcapx.UI.CompletedTaskForm;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.TimerTask;

public class TimeTask extends TimerTask {
    private Task task;
    private Date date;

    public TimeTask(Task task) {
        this.task = task;
        date = task.getDate();
    }

    @Override
    public void run() {
        if (!task.getChecked()) {
            CompletedTaskForm completedTaskForm = new CompletedTaskForm(task);
            completedTaskForm.setVisible(true);
            completedTaskForm.addWindowListener(new VisibleWindowListener());
        }
    }

    public Date getDate() {
        return date;
    }

    private class VisibleWindowListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {

        }

        @Override
        public void windowClosed(WindowEvent e) {
            task.setChecked(true);
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
    }
}
