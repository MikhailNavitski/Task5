package dao.impl.stax;


import dao.ParserDAO;
import entity.Book;

import java.util.Set;

public class StAXParserImpl implements ParserDAO {
    @Override
    public Set<Book> parsing() {
        Set<Book> bookSet ;
        BookStAXBuilder staxBuilder = new BookStAXBuilder();
        staxBuilder.buildSetBook("resources//books.xml");
        bookSet = staxBuilder.getBook();
        return bookSet;
    }
}
