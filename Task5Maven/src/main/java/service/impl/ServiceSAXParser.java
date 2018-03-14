package service.impl;

import dao.DAOFactory;
import dao.ParserDAO;
import dao.exception.DAOException;
import entity.Book;

import service.command.Command;
import service.exception.ServiceException;

import java.util.List;



public class ServiceSAXParser implements Command {

    @Override
    public List<Book> parsing() throws ServiceException {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParserDAO parserSAX = factory.getParserSAX();
            List<Book> setBook = parserSAX.parsing();
            return setBook;
        } catch (DAOException e) {
            throw new ServiceException("Service error:" + e);
        }

    }


}
