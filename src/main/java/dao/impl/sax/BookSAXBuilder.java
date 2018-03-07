package dao.impl.sax;

import entity.Book;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

class BookSAXBuilder {
    private Set<Book> books;
    private BookHandler sh;
    private XMLReader reader;

    BookSAXBuilder() {
        sh = new BookHandler();
        try {
           reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler( sh);
        } catch (SAXException e) {
            System.out.println("error");
        }
    }

    Set<Book> getBooks() {
        return books;
    }

    void buildSetBooks(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        books = sh.getBooks();
    }
}
