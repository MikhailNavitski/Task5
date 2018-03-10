package dao.impl.stax;

import dao.impl.sax.BookEnum;
import entity.Book;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BookStAXBuilder {
    private List<Book> books = new ArrayList<>();
    private XMLInputFactory inputFactory;

    BookStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public List<Book>  getBook() {
        return books;
    }

    void buildSetBook(InputStream inputStream) throws IOException, XMLStreamException {
        XMLStreamReader reader;
        String name;
        reader = inputFactory.createXMLStreamReader(inputStream);
        while (reader.hasNext()) {
            int type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                if (BookEnum.valueOf(name.toUpperCase()) == BookEnum.BOOK) {
                    Book st = buildBook(reader);
                    books.add(st);
                }
            }
        }

    }


    private Book buildBook(XMLStreamReader reader) throws XMLStreamException {
        Book book = new Book();
        book.setId(reader.getAttributeValue(null, BookEnum.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (BookEnum.valueOf(name.toUpperCase())) {
                        case AUTHOR:
                            book.setAuthor(getXMLText(reader));
                            break;
                        case PRICE:
                            name = getXMLText(reader);
                            book.setPrice(Double.parseDouble(name));
                            break;
                        case TITLE:
                            book.setTitle(getXMLText(reader));
                            break;
                        case GENRE:
                            book.setGenre(getXMLText(reader));
                            break;
                        case PUBLISH_DATE:
                            book.setPublishDate(getXMLText(reader));
                            break;
                        case DESCRIPTION:
                            book.setDescription(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (BookEnum.valueOf(name.toUpperCase()) == BookEnum.BOOK) {
                        return book;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Book");

    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
