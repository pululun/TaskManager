package es.esy.kapcapx;

import es.esy.kapcapx.serializationJAXB.Serialization;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Tasks tasks = new Tasks();
        tasks.setTasks(new ArrayList<Task>());

        Task task = new Task();
        task.setTitle("Сейчас");
        task.setDescription("Запилить сериализацию");
        task.setDate(new Date());
        task.setContacts("88006543210");

        Task task1 = new Task();
        task1.setTitle("Потом");
        task1.setDescription("Запилить добавление и удаление");
        task1.setDate(new Date());
        task1.setContacts("88000123456");

        tasks.getTasks().add(task);
        tasks.getTasks().add(task1);

        String path = "/home/pululun/Загрузки/test.xml";

        try {
            Serialization.marshalingExample(path, tasks);
        } catch (JAXBException e) {
            System.out.println("Ошибка запись в файл не удалась");
            e.printStackTrace();
        }

        Tasks tasks1 = null;

        try {
            tasks1 = Serialization.unMarshalingExample(path);
        } catch (JAXBException e) {
            System.out.println("Ошибка не удалось прочитать файл");
            e.printStackTrace();
        }

        for (Task t : tasks1.getTasks()) {
            System.out.println(t.getTitle());
            System.out.println(t.getDescription());
            System.out.println(t.getDate());
            System.out.println(t.getContacts());
        }

    }
}
