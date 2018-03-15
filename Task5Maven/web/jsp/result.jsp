<%--
  Created by IntelliJ IDEA.
  User: MTX_BY
  Date: 28.02.2018
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Result</title>
    <link rel="stylesheet" href="/css/result.css">
</head>

<body>
<div class="main" align="center">
    <form action="../index.jsp">
        <button type="submit">Главная страница</button>
    </form>

</div>


<div class="pages" align="center">

    <c:set value="${requestScope.page+2}" var="pageCount"/>

    <c:if test="${pageCount gt requestScope.pageCount}">
        <c:set value="${requestScope.pageCount}" var="pageCount"/>
    </c:if>

    <c:set value="${requestScope.page}" var="firstPage"/>

    <c:if test="${requestScope.page!=1}">
        <a href="/test?page=${requestScope.page-1}&parser=${requestScope.parser}"> Prev </a>
    </c:if>

    <c:forEach begin="${firstPage}" end="${pageCount}" var="pageCount">
        <c:choose>
            <c:when test="${requestScope.page == pageCount}">
                ${pageCount}
            </c:when>
            <c:otherwise>
                <a href="/test?page=${pageCount}&parser=${requestScope.parser}"> ${pageCount} </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${requestScope.page!=requestScope.pageCount}">
        <a href="/test?page=${requestScope.page+1}&parser=${requestScope.parser}"> Next </a>
    </c:if>


</div>


<div class="result" align="center">
    <table border="1">
        <c:forEach var="book" items="${requestScope.books}" varStatus="status">
            <tr>
                <th>id</th>
                <th>author</th>
                <th>title</th>
                <th>genre</th>
                <th>price</th>
                <th>publishDate</th>
                <th>description</th>
            </tr>
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
</div>
</body>
</html>
