package service.command;

import entity.Book;
import service.exception.ServiceException;

import java.util.List;
import java.util.Set;

public interface Command {
    List<Book>  parsing() throws ServiceException;

}
