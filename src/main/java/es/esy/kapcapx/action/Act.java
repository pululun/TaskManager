package es.esy.kapcapx.action;

import es.esy.kapcapx.Task;
import es.esy.kapcapx.Tasks;

import java.util.Date;
import java.util.Iterator;

public class Act {

    public void taskAdd(Tasks tasks, String title, String description, Date date, String contacts) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDate(date);
        task.setContacts(contacts);
        tasks.getTasks().add(task);
    }

    public void taskRemove(Tasks tasks, String title) {
        Iterator<Task> i = tasks.getTasks().iterator();
        while (i.hasNext()) {
            if (title.compareTo(i.next().getTitle()) == 0) {
                i.remove();
            }
        }
    }

    public boolean findTitleTask(Tasks tasks, String title) {
        boolean existenceJobName = false;
        for (Task task : tasks.getTasks()) {
            if (title.compareTo(task.getTitle()) == 0) {
                existenceJobName = true;
                break;
            } else {
                existenceJobName = false;
            }
        }
        return existenceJobName;
    }

}