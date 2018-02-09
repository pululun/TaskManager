package es.esy.kapcapx.action;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.Tasks;
import es.esy.kapcapx.TimeTask;

import java.util.Timer;

public class TimeManipulation {
    private static Timer timer = new Timer();

    public static void updateTimeTask(Tasks tasks) {
        cancelTimerTask();
        for (Task task : tasks.getTasks()) {
            TimeTask timeTask = new TimeTask(task);
            timer.schedule(timeTask, timeTask.getDate());
        }
    }

    private static void cancelTimerTask() {
            timer.cancel();
            timer.purge();
    }
}
