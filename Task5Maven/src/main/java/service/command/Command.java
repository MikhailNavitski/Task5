package service.command;

import entity.Book;
import service.exception.ServiceException;

import java.util.List;

public interface Command {
    List<Book>  parsing() throws ServiceException;

}
