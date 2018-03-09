package service.impl;

import entity.Book;
import service.Service;
import service.command.Command;
import service.command.impl.DirectorImpl;
import service.exception.ServiceException;

import java.util.Set;


public class ServiceCommand implements Service {

    public Set<Book> determinant(String parserType) {
        try {
            DirectorImpl director = DirectorImpl.getInstance();
            director.addMap();
            Command command = director.getCommand(parserType);
            Set<Book> bookSet = command.parsing();
            return bookSet;
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        return null;
    }
}

