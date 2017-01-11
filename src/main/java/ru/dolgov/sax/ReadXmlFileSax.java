package ru.dolgov.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * BigComp
 * 11.01.2017.
 */
public class ReadXmlFileSax {
    public static Object ReadXml(String xmlFile) throws ParserConfigurationException, SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFile, handler);

            return handler.getObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
