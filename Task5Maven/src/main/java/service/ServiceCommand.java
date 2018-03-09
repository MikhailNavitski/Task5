package service;

import constant.Constant;
import entity.Book;
import service.command.Command;
import service.command.impl.DirectorImpl;
import service.exception.ServiceException;
import service.validation.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


public class ServiceCommand implements Service {

    public String determinant(String parserType, HttpServletRequest request, String page) {
        try {
            if (!Validator.validation()) {
                return Constant.VALIDATION_PAGE;
            }
            DirectorImpl director = DirectorImpl.getInstance();
            director.addMap();
            Command command = director.getCommand(parserType);
            Set<Book> bookSet = command.parsing();
            request.setAttribute("books", bookSet);
            request.setAttribute("page", page);
            return Constant.RESULT_PAGE;
        } catch (ServiceException e) {
            return Constant.ERROR_PAGE;
        }

    }
}

