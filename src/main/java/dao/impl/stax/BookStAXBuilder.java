package dao.impl.stax;

import dao.impl.sax.BookEnum;
import entity.Book;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BookStAXBuilder {
    private HashSet<Book> students = new HashSet<>();
    private XMLInputFactory inputFactory;

    public BookStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Book> getBook() {
        return students;
    }

    public void buildSetBook(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (BookEnum.valueOf(name.toUpperCase()) == BookEnum.BOOK) {
                        Book st = buildBook(reader);
                        students.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
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
