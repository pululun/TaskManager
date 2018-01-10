package es.esy.kapcapx;

import es.esy.kapcapx.UI.MainForm;
import es.esy.kapcapx.serializationJAXB.Serialization;

import javax.xml.bind.JAXBException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        String path = "/home/pululun/Загрузки/test.xml";
        Tasks tasks = new Tasks();
        tasks.setTasks(new ArrayList<Task>());

        Tasks tasks1 = new Tasks();
        tasks1.setTasks(new ArrayList<Task>());

        try {
            tasks1 = Serialization.unMarshalingExample(path);
            if (tasks1.getTasks() != null){
                tasks = tasks1;
            }
        } catch (JAXBException e) {
            System.out.println("Ошибка не удалось прочитать файл");
            e.printStackTrace();
        }

        MainForm mainForm = new MainForm(tasks);
        mainForm.setVisible(true);

//        Act act = new Act();
//        act.taskAdd(tasks, "Сейчас", "Запилить сериализацию", new Date(), "88006543210");
//        act.taskAdd(tasks, "Потом", "Запилить добавление и удаление", new Date(), "88000123456");
//        act.taskAdd(tasks, "Не сегодня", "Запилить интерфейс", new Date(), "84525454654");
//        act.taskAdd(tasks, "Проба", "Запилить дополнителюное окно", new Date(), "84574459911");
//        act.taskRemove(tasks, "Потом");

//        for (Task t : tasks.getTasks()) {
//            System.out.println(t.getTitle());
//            System.out.println(t.getDescription());
//            System.out.println(t.getDate());
//            System.out.println(t.getContacts());
//        }

        mainForm.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Окно создано и отрыто");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Serialization.marshalingExample(path, mainForm.getTasks());
                } catch (JAXBException jaxbe) {
                    System.out.println("Ошибка запись в файл не удалась");
                    jaxbe.printStackTrace();
                }
                System.out.println("Кто то почти нажал на крестик!!");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Окно закрыто!");
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
