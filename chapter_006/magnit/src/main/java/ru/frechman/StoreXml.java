package ru.frechman;

import ru.frechman.model.Entries;
import ru.frechman.model.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXml {

    private final File file;

    /***
     * @param target файл куда будут сохраняться данные.
     */
    public StoreXml(File target) {
        this.file = target;
    }

    /**
     * Сохраняет данные из list в файл target.
     *
     * @param list список entry.
     */
    public void save(List<Entry> list) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Entries(list), this.file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
