<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/21/2022
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/find" method="get">
    <p>Tieng Anh</p>
    <input name="key" type="text">
    <button type="submit">Translate</button>
  </form>
  <c:if test="${mess!= null}">
    <p> ${mess}</p>
  </c:if>

  </body>
</html>
