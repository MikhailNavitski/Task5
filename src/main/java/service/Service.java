package service;

import entity.Book;

import java.util.Set;


public interface Service {
    Set<Book> determinant(String firstValue, String secondValue, String thirdValue);
}
