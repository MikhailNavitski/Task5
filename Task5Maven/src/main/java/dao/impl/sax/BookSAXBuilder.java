package dao.impl.sax;

import entity.Book;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

class BookSAXBuilder {
    private List<Book> books;
    private BookHandler handler;
    private SAXParser saxParser;

    BookSAXBuilder() {
        handler = new BookHandler();
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    List<Book>  getBooks() {
        return books;
    }

    void buildSetBooks(InputStream inputStream) throws SAXException, IOException {
        saxParser.parse(inputStream,handler);
        books = handler.getBooks();
    }
}
