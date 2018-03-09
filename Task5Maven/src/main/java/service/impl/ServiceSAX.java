package service.impl;

import dao.DAOFactory;
import dao.ParserDAO;
import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;
import service.command.Command;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Set;


public class ServiceSAX implements Command {
    @Override
    public  Set<Book> parsing() {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParserDAO parserSAX = factory.getParserSAX();
            Set<Book> setBook = parserSAX.parsing();
            return setBook;
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
