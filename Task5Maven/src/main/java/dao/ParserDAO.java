package dao;


import dao.exception.DAOException;
import entity.Book;
import java.util.List;


public interface ParserDAO {
    List<Book> parsing() throws DAOException;
}
