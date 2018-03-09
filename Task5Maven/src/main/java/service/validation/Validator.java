package service.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;

import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class Validator {
    public static boolean validation() throws SAXException {
        try {
            String fileName = "resources/books.xml";
            File fileSchema = new File("resources/books.xsd");
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(fileSchema).newValidator().validate(new StreamSource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

