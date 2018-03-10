package service;


import entity.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface Service {
    String determinant(HttpServletRequest request);

    List<Book> getBooks(String page, List<Book>  bookSet);
}
