package service;

import constant.Constant;
import entity.Book;
import service.command.Command;
import service.command.impl.DirectorImpl;
import service.exception.ServiceException;
import service.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class ServiceCommand implements Service {

    public String determinant(HttpServletRequest request) {
        try {
            if (!Validator.validation()) {
                return Constant.VALIDATION_PAGE;
            }
            DirectorImpl director = DirectorImpl.getInstance();
            director.addMap();

            String parserType = request.getParameter("parser");
            String page = request.getParameter("page");

            Command command = director.getCommand(parserType);
            List<Book> bookList = command.parsing();
            List<Book> result = getBooks(page, bookList);


            request.setAttribute("pageCount", Constant.PAGE_COUNT);
            request.setAttribute("books", result);
            request.setAttribute("page", page);
            request.setAttribute("parser", parserType);

            return Constant.RESULT_PAGE;
        } catch (ServiceException e) {
            return Constant.ERROR_PAGE;
        }

    }

    @Override
    public List<Book> getBooks(String page, List<Book> bookList) {
        int start = (Integer.parseInt(page) - 1) * Constant.COUNT_OF_RECORTDS;
        int end = Constant.COUNT_OF_RECORTDS + start;
        bookList = bookList.subList(start, end);
        return bookList;
    }
}

