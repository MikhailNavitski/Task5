package service.impl;

import dao.DAOFactory;
import dao.ParserDAO;
import dao.exception.DAOException;
import entity.Book;

import service.command.Command;
import service.exception.ServiceException;

import java.util.List;



public class ServiceDOMParser implements Command {


    @Override
    public List<Book> parsing() throws ServiceException {
        try {
            DAOFactory factory = DAOFactory.getInstance();
            ParserDAO parserDOM = factory.getParserDOM();
            List<Book>  setBook = parserDOM.parsing();
            return setBook;
        } catch (DAOException e) {
            throw new ServiceException("Service error:" + e);
        }

    }
}
