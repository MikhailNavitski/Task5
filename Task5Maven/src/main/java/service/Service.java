package service;



import javax.servlet.http.HttpServletRequest;



public interface Service {
    String determinant(String parserType,HttpServletRequest request,String page);
}
