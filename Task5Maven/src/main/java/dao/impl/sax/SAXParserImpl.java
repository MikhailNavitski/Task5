package dao.impl.sax;

import dao.ParserDAO;
import constant.Constant;
import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class SAXParserImpl implements ParserDAO {
    @Override
    public Set<Book> parsing() throws DAOException {
        try {
            Set<Book> bookSet;
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOKS_XML);

            BookSAXBuilder saxBuilder = new BookSAXBuilder();



            saxBuilder.buildSetBooks(inputStream);
            bookSet = saxBuilder.getBooks();
            return bookSet;
        } catch (SAXException | IOException e) {
            throw new DAOException("error DAOException: " + e);

        }
    }
}
