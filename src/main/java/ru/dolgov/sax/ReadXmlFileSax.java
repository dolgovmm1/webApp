package ru.dolgov.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Class ReadXmlFileSax to parse xml-files and create objects based on this xml-files
 * @author M. Dolgov
 * 11.01.2017.
 */
public class ReadXmlFileSax {
    static final Logger log = LogManager.getLogger(ReadXmlFileSax.class.getName());

    /**
     * Method to parse xml file
     * @param xmlFile
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static Object ReadXml(String xmlFile) throws ParserConfigurationException, SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SaxHandler handler = new SaxHandler();
            saxParser.parse(xmlFile, handler);

            return handler.getObject();
        } catch (IOException ex) {
            log.debug("Error opening xml file " + xmlFile);
            ex.printStackTrace();
        }
        return null;
    }
}
