package es.esy.kapcapx;

import es.esy.kapcapx.UI.MainForm;
import es.esy.kapcapx.serializationJAXB.Serialization;

import javax.xml.bind.JAXBException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;

public class Main {
    private static final String filename = "Tasks.xml";
    private static final String workDir = System.getProperty("user.dir");
    private static final String separator = System.getProperty("file.separator");

    public static void main(String[] args) {

        Tasks tasks = new Tasks();
        tasks.setTasks(new ArrayList<Task>());

        final String fullPath = workDir + separator + filename;

        if (!new File(fullPath).exists()) {
            try {
                Serialization.marshalingExample(fullPath, tasks);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }

        try {
            Tasks temp;
            temp = Serialization.unMarshalingExample(fullPath);
            if (temp.getTasks() != null){
                tasks = temp;
            }
        } catch (JAXBException e) {
            System.out.println("Ошибка не удалось прочитать файл");
            e.printStackTrace();
        }

        MainForm mainForm = new MainForm(tasks);
        mainForm.setVisible(true);

        mainForm.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Serialization.marshalingExample(fullPath, mainForm.getTasks());
                } catch (JAXBException jaxbe) {
                    System.out.println("Ошибка запись в файл не удалась");
                    jaxbe.printStackTrace();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

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
