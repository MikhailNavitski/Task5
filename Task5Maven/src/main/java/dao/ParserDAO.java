package dao;


import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Set;

public interface ParserDAO {
    Set<Book> parsing() throws DAOException;
}
