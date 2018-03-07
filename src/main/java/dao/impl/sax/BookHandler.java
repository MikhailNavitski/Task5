package dao.impl.sax;

import entity.Book;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class BookHandler extends DefaultHandler {
    private Set<Book> books;
    private Book current = null;
    private BookEnum currentEnum = null;
    private EnumSet<BookEnum> withText;

    BookHandler() {
        books = new HashSet<>();
        withText = EnumSet.range(BookEnum.AUTHOR, BookEnum.DESCRIPTION);
    }

    Set<Book> getBooks() {
        return books;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("book".equals(localName)) {
            current = new Book();
            current.setId(attrs.getValue(0));
        } else {
            BookEnum temp = BookEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("book".equals(localName)) {
            books.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case BOOK:
                    current.setId(s);
                    break;
                case AUTHOR:
                    current.setAuthor(s);
                    break;
                case TITLE:
                    current.setTitle(s);
                    break;
                case GENRE:
                    current.setGenre(s);
                    break;
                case PRICE:
                    current.setPrice(Double.parseDouble(s));
                    break;
                case PUBLISH_DATE:
                    current.setPublishDate(s);
                    break;
                case DESCRIPTION:
                    current.setDescription(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }

}

