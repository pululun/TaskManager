package es.esy.kapcapx.serializationJAXB;

import es.esy.kapcapx.Tasks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;



public class Serialization {

    public static void marshalingExample(String path, Tasks tasks) throws JAXBException {
        File file = new File(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Tasks.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(tasks, file);
    }


    public static Tasks unMarshalingExample(String path) throws JAXBException {
        File file = new File(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(Tasks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Tasks tasks = (Tasks) unmarshaller.unmarshal(file);
        return tasks;
    }
}
