package ru.frechman.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySaxHandler extends DefaultHandler {

    private Long sum = 0L;

    public Long getSum() {
        return sum;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        String href = attributes.getValue("href");
        if (localName.equals("entry") && !href.isEmpty()) {
            this.sum += Long.valueOf(href);
        }
    }
}
