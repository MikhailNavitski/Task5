package service;

import constant.Constant;
import entity.Book;
import service.command.Command;
import service.command.impl.DirectorImpl;
import service.creator.PageCreator;
import service.exception.ServiceException;
import service.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class ServiceCommand implements Service {
    @Override
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
            int pageCount = PageCreator.generatePages(bookList);

            List<Book> result = PageCreator.getBooks(page, bookList, pageCount);

            request.setAttribute("pageCount", pageCount);
            request.setAttribute("books", result);
            request.setAttribute("page", page);
            request.setAttribute("parser", parserType);

            return Constant.RESULT_PAGE;
        } catch (ServiceException e) {
            return Constant.ERROR_PAGE;
        }

    }

}

