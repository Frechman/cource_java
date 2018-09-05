package ru.frechman;

import ru.frechman.config.Config;
import ru.frechman.model.Entry;
import ru.frechman.parser.MySaxHandler;
import ru.frechman.util.ConvertXSQT;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.Objects;

public class RunApp {

    public static void main(String[] args) throws Exception {

        Config config = new Config();
        try (StoreSql storeSql = new StoreSql(config)) {
            storeSql.createTable();
            storeSql.cleanTable();
            storeSql.generate(1000000);

            List<Entry> all = storeSql.getAll();

            File fileXml = new File("store.xml");
            StoreXml storeXml = new StoreXml(fileXml);
            storeXml.save(all);

            URI uri = Objects.requireNonNull(
                    RunApp.class.getClassLoader().getResource("scheme.xsl")).toURI();
            File fileDest = new File("storeDest.xml");
            File scheme = new File(uri);

            ConvertXSQT convertXSQT = new ConvertXSQT();
            convertXSQT.convert(fileXml, fileDest, scheme);

            MySaxHandler handler = new MySaxHandler();
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(fileDest, handler);
            System.out.println(handler.getSum());
        }
    }
}
