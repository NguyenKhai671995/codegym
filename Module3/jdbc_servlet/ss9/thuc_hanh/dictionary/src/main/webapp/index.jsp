<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/17/2022
  Time: 6:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h5>Vietnamese Dictionary</h5>
<form action="/myServlet" method="post">
  <input type="text" placeholder="Enter you word" name="text">
  <button type="submit">Search</button>
  <c:if test="${requestScope.message != null}">
    <h1><c:out value="${requestScope.message}">${requestScope.message}</c:out></h1>
  </c:if>
</form>
  </body>
</html>
