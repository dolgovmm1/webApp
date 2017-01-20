package ru.dolgov.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.dolgov.sax.reflection.ReflectionHelper;

/**
 * Class describe parsing xml file
 * @author M. Dolgov
 * 11.01.2017.
 */
public class SaxHandler extends DefaultHandler {
    public static final String CLASSNAME = "class";
    private String element = null;
    private Object object = null;

    public void startDocument() throws SAXException{
        System.out.println("Start document");
    }

    public void endDocument() throws SAXException{
        System.out.println("End document");
    }
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        if (!qName.equals(CLASSNAME)){
            element = qName;
        }else{
            String className = attributes.getValue(0);
            System.out.println("Classname: " + className);
            object = ReflectionHelper.createInstance(className);
        }
    }

    public void endElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{
        element = null;
    }

    public void characters(char ch[], int start, int lenght) throws SAXException{
        if (element != null){
            String value = new String(ch, start, lenght);
            System.out.println(element + " = " + value);
            ReflectionHelper.setFieldValue(object, element, value);
            element = null;
        }
    }

    public Object getObject() {
        return object;
    }
}
