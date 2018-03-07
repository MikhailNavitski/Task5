package dao.impl.sax;

import dao.ParserDAO;
import entity.Book;

import java.util.Set;

public class SAXParserImpl implements ParserDAO {
    @Override
    public Set<Book> parsing() {
        Set<Book> bookSet ;
        BookSAXBuilder saxBuilder = new BookSAXBuilder();
        saxBuilder.buildSetBooks("resources//books.xml");
        bookSet = saxBuilder.getBooks();
        return bookSet;
    }
}
