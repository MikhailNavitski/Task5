package dao.impl.sax;

import entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class BookHandler extends DefaultHandler {
    private Set<Book> books;
    private Book book = null;
    private BookEnum bookEnum = null;
    private EnumSet<BookEnum> withText;

    BookHandler() {
        books = new HashSet<>();
        withText = EnumSet.range(BookEnum.AUTHOR, BookEnum.DESCRIPTION);
    }

    Set<Book> getBooks() {
        return books;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (qName.equalsIgnoreCase("book")) {
            book = new Book();
            book.setId(attrs.getValue(0));
        } else {
            BookEnum temp = BookEnum.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                bookEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("book".equals(qName)) {
            books.add(book);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (bookEnum != null) {
            switch (bookEnum) {
                case BOOK:
                    book.setId(s);
                    break;
                case AUTHOR:
                    book.setAuthor(s);
                    break;
                case TITLE:
                    book.setTitle(s);
                    break;
                case GENRE:
                    book.setGenre(s);
                    break;
                case PRICE:
                    book.setPrice(Double.parseDouble(s));
                    break;
                case PUBLISH_DATE:
                    book.setPublishDate(s);
                    break;
                case DESCRIPTION:
                    book.setDescription(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            bookEnum.getDeclaringClass(), bookEnum.name());
            }
        }
        bookEnum = null;
    }

}

