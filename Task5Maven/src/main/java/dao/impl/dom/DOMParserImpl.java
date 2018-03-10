package dao.impl.dom;


import dao.ParserDAO;
import constant.Constant;
import dao.exception.DAOException;
import entity.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DOMParserImpl implements ParserDAO {

    @Override
    public List<Book> parsing() throws DAOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = contextClassLoader.getResourceAsStream(Constant.BOOK_XML);

            Document document = documentBuilder.parse(inputStream);
            List<Book> bookList;
            bookList = creatingBook(document);
            return bookList;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new DAOException("error DAOException: " + e);
        }
    }

    private static Book buildBook(Element bookElement) {
        Book book = new Book();
        book.setId(bookElement.getAttribute("id"));
        book.setAuthor(getElementTextContent(bookElement, "author"));
        book.setTitle(getElementTextContent(bookElement, "title"));
        book.setGenre(getElementTextContent(bookElement, "genre"));
        book.setPrice(Double.parseDouble(getElementTextContent(bookElement, "price")));
        book.setPublishDate(getElementTextContent(bookElement, "publish_date"));
        book.setDescription(getElementTextContent(bookElement, "description"));
        return book;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

    private static List<Book> creatingBook(Document document) {
        List<Book> bookList = new ArrayList<>();
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("book");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element bookElement = (Element) nodeList.item(i);
            Book book = buildBook(bookElement);
            bookList.add(book);
        }
        return bookList;
    }
}
