<%--
  Created by IntelliJ IDEA.
  User: MTX_BY
  Date: 27.02.2018
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Parsing</title>
</head>
<body>
<form action="/test" method="post">
    <div align="center">
        <p><input type="submit" name="SAX" value="SAX"></p>
        <p><input type="submit" name="StAX" value="StAX"></p>
        <p><input type="submit" name="DOM" value="DOM"></p>
    </div>
</form>
<div align="left">
    <table>
        <c:forEach items="${setBook}" var="good">
            <tr>
                <td><c:out value="${good}"/></td>
            </tr>

            <%--<c:out value="${good.getGenre}"/>--%>
            <%--<c:out value="${good.getPrice}"/>--%>
            <%--<c:out value="${good.getPublishDate}"/>--%>
            <%--<c:out value="${good.getDescription}"/>--%>
        </c:forEach>
    </table>
</div>
</body>
</html>
