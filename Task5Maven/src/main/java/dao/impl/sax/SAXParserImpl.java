package dao.impl.sax;

import dao.ParserDAO;
import constant.Constant;
import dao.exception.DAOException;
import entity.Book;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SAXParserImpl implements ParserDAO {
    @Override
    public List<Book> parsing() throws DAOException {
        try {
            List<Book>  bookList;
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOKS_XML);

            BookSAXBuilder saxBuilder = new BookSAXBuilder();



            saxBuilder.buildSetBooks(inputStream);
            bookList = saxBuilder.getBooks();
            return bookList;
        } catch (SAXException | IOException e) {
            throw new DAOException("error DAOException: " + e);

        }
    }
}
