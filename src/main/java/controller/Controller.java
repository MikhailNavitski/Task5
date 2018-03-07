package controller;


import entity.Book;
import service.Service;
import service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Book> setBook;
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        String firstValue = request.getParameter("SAX");
        String secondValue = request.getParameter("StAX");
        String thirdValue = request.getParameter("DOM");
        ServiceFactory factory = ServiceFactory.getInstance();
        Service service = factory.getService();
        setBook = service.determinant(firstValue, secondValue, thirdValue);
        request.setAttribute("setBook", setBook);

        dispatcher.forward(request, response);

    }
}
