package controller;


import entity.Book;
import service.Service;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.Set;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Book> setBook;

        String page = request.getParameter("page");
        String parserType = request.getParameter("parser");

        ServiceFactory factory = ServiceFactory.getInstance();
        Service service = factory.getService();
        setBook = service.determinant(parserType);

        request.setAttribute("books", setBook);
        request.setAttribute("page", page);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }
}
