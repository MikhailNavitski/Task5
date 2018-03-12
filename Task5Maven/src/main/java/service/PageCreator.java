package service;

import constant.Constant;
import entity.Book;

import java.util.List;

public class PageCreator {

    public static List<Book> getBooks(String page, List<Book> bookList, int pageCount) {

        int start = (Integer.parseInt(page) - 1) * Constant.COUNT_OF_RECORTDS;
        int end = Constant.COUNT_OF_RECORTDS + start;
        if (Integer.parseInt(page) == pageCount) {

            bookList = bookList.subList(start, end - 1);
            return bookList;
        } else {
            bookList = bookList.subList(start, end);
            return bookList;
        }
    }

    public static int generatePages(List<Book> bookList) {
        if (bookList.size() % 2 == 0) {
            return bookList.size() / Constant.COUNT_OF_RECORTDS;

        } else {
            return bookList.size() / Constant.COUNT_OF_RECORTDS + 1;
        }

    }
}
