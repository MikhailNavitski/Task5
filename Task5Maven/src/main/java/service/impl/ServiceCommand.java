package service.impl;


import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;
import service.Service;
import service.command.Command;
import service.command.impl.DirectorImpl;
import service.exception.ServiceException;
import service.validation.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class ServiceCommand implements Service {

    public Set<Book> determinant(String firstValue, String secondValue, String thirdValue) throws ServiceException {
        //            if (!Validator.validation()) {
//                return null;
//            }
        List<String> parser = new ArrayList<>();
        parser.add(firstValue);
        parser.add(secondValue);
        parser.add(thirdValue);
        parser.removeAll(Collections.singleton(null));
        DirectorImpl director = DirectorImpl.getInstance();
        director.addMap();
        Command command = director.getCommand(parser.get(0));
        Set<Book> bookSet = command.parsing();
        return bookSet;
    }


}

