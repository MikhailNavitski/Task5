package service.validation;

import constant.Constant;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.SchemaFactory;
import java.io.IOException;
import java.io.InputStream;


public class Validator {
    public static boolean validation()  {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream fileName = contextClassLoader.getResourceAsStream(Constant.BOOKS_XML);
            InputStream fileSchema = contextClassLoader.getResourceAsStream(Constant.BOOK_XSD);
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new StreamSource(fileSchema)).newValidator().validate(new StreamSource(fileName));
        } catch (IOException | SAXException e) {
            return false;
        }
        return true;
    }
}

