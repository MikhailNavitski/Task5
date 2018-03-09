package service.impl;

import dao.DAOFactory;
import dao.ParserDAO;
import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;
import service.command.Command;
import service.exception.ServiceException;

import javax.sql.rowset.serial.SerialException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Set;


public class ServiceSAX implements Command {
    @Override
    public Set<Book> parsing() throws ServiceException {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParserDAO parserSAX = factory.getParserSAX();
            Set<Book> setBook = parserSAX.parsing();
            return setBook;
        } catch (DAOException e) {
            throw new ServiceException("Service error:" + e);
        }

    }
}
