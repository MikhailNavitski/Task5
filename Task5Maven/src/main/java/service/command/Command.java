package service.command;

import entity.Book;
import service.exception.ServiceException;

import java.util.Set;

public interface Command {
    Set<Book> parsing() throws ServiceException;
}
