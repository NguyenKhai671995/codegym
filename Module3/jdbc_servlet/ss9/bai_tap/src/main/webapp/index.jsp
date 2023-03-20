<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/15/2022
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="mycss.css">
</head>
<body>
<form action="/myServlet" method="post">
    <p>Name Product</p>
    <input type="text" placeholder="Product Description" name="name">
    <p>Price</p>
    <input type="text" placeholder="List Price" name="price">
    <p>Discount Percent</p>
    <input type="text" placeholder="Discount Percent" name="discount">
    <button type="submit">Calculate Discount</button>
    <c:if test="${requestScope.message != null}">
        <p><c:out value="${requestScope.message}">${requestScope.message}</c:out></p>
    </c:if>
</form>
</body>
</html>
