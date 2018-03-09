package dao;


import dao.impl.dom.DOMParserImpl;
import dao.impl.sax.SAXParserImpl;
import dao.impl.stax.StAXParserImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ParserDAO parserDOM = new DOMParserImpl();
    private final ParserDAO parserSAX = new SAXParserImpl();
    private final ParserDAO parserStAX = new StAXParserImpl();

    private DAOFactory() {
    }

    public ParserDAO getParserDOM() {
        return parserDOM;
    }

    public ParserDAO getParserStAX() {
        return parserStAX;
    }

    public ParserDAO getParserSAX() {
        return parserSAX;
    }

    public static DAOFactory getInstance() {
        return instance;
    }

}
