package dao;


import entity.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Set;

public interface ParserDAO {
    Set<Book> parsing() throws ParserConfigurationException,SAXException,IOException;
}
