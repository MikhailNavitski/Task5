package dao.impl.stax;


import dao.ParserDAO;
import dao.constant.Constant;
import dao.exception.DAOException;
import entity.Book;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class StAXParserImpl implements ParserDAO {
    @Override
    public Set<Book> parsing() throws DAOException {
        try {
            Set<Book> bookSet;
            BookStAXBuilder staxBuilder = new BookStAXBuilder();

            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOKS_XML);

            staxBuilder.buildSetBook(inputStream);
            bookSet = staxBuilder.getBook();
            return bookSet;
        } catch (IOException | XMLStreamException e) {
            throw new DAOException("error DAOException: " + e);
        }

    }
}
