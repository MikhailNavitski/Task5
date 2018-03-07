package service.impl;

import entity.Book;
import service.Service;
import service.command.Command;
import service.command.impl.DirectorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class ServiceCommand implements Service {

    public Set<Book> determinant(String firstValue, String secondValue, String thirdValue) {
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
