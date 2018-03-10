package dao.impl.stax;


import dao.ParserDAO;
import constant.Constant;
import dao.exception.DAOException;
import entity.Book;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StAXParserImpl implements ParserDAO {
    @Override
    public List<Book> parsing() throws DAOException {
        try {
            List<Book>  bookList;
            BookStAXBuilder staxBuilder = new BookStAXBuilder();

            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOK_XML);

            staxBuilder.buildSetBook(inputStream);
            bookList = staxBuilder.getBook();
            return bookList;
        } catch (IOException | XMLStreamException e) {
            throw new DAOException("error DAOException: " + e);
        }

    }
}
