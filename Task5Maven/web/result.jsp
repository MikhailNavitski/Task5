<%--
  Created by IntelliJ IDEA.
  User: MTX_BY
  Date: 08.03.2018
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Core: forEach</title></head>

<body>
<table>
    <tr>
        <td>id</td>
        <br>
        <td>author</td>
        <td>title</td>
        <td>genre</td>
        <td>price</td>
        <td>publishDate</td>
        <td>description</td>
    </tr>
    <c:forEach var="book" items="${requestScope.books}" varStatus="status">
        <tr>
            <td><c:out value="${ book.id }"/></td>
            <td><c:out value="${ book.author }"/></td>
            <td><c:out value="${ book.title}"/></td>
            <td><c:out value="${ book.genre }"/></td>
            <td><c:out value="${ book.price }"/></td>
            <td><c:out value="${ book.publishDate }"/></td>
            <td><c:out value="${ book.description }"/></td>
        </tr>
    </c:forEach>
</table>
<%--<div align="center">--%>
<%--<c:forEach var="elem" items="${requestScope.pagination}" varStatus="status">--%>
<%--<a href="/test?page=${elem}">${elem}</a>--%>

<%--</c:forEach>--%>

<%--</div>--%>

</body>
</html>
