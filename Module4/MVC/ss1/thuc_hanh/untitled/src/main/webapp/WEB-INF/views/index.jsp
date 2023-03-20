<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/19/2022
  Time: 8:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/greeting" method="get">
    <input name="title">
    <button type="submit">submit</button>
  </form>
  <c:if test="${mess != null}">
  <h3>hello ${mess}</h3>
  </c:if>
  </body>
</html>
