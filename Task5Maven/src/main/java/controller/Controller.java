package controller;


import entity.Book;
import service.Service;
import service.ServiceFactory;
import service.exception.ServiceException;

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
        try {
            Set<Book> setBook;
            String firstValue = request.getParameter("SAX");
            String secondValue = request.getParameter("StAX");
            String thirdValue = request.getParameter("DOM");
            String page = request.getParameter("page");

            ServiceFactory factory = ServiceFactory.getInstance();
            Service service = factory.getService();
            setBook = service.determinant(firstValue, secondValue, thirdValue);

            request.setAttribute("books", setBook);
            request.setAttribute("page", page);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
//            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }
}
