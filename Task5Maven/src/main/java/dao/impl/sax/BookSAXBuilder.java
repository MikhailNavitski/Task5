package dao.impl.sax;

import entity.Book;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

class BookSAXBuilder {
    private Set<Book> books;
    private BookHandler handler;
    private XMLReader reader;
    private SAXParser saxParser;

    BookSAXBuilder() {
        handler = new BookHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    Set<Book> getBooks() {
        return books;
    }

    void buildSetBooks(InputStream inputStream) throws SAXException, IOException {
        saxParser.parse(inputStream,handler);
        books = handler.getBooks();
    }
}
