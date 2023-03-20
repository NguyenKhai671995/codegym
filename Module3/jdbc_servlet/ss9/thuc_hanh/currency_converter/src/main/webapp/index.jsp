<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/17/2022
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h3>Currency Converter</h3>
  <form action="/converter" method="post">
    <p>Rate:</p>
    <input type="number" placeholder="Rate" name="rate" required>
    <p>USD:</p>
    <input type="number" placeholder="USD" name="usd" required>
    <button type="submit">Converter</button>
    <c:if test="${requestScope.message != null}">
      <h1><c:out value=" Tong tien: ${requestScope.message}"> ${requestScope.message}</c:out></h1>
    </c:if>
  </form>
  </body>
</html>
