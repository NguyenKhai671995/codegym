<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 9/23/2022
  Time: 6:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h5>Sandwich Condiments</h5>
<form action="/find" method="get">
    <input type="checkbox" name="condiments" value="Lettuce"> <span>Lettuce</span>
    <input type="checkbox" name="condiments" value="Tomato"> <span>Tomato</span>
    <input type="checkbox" name="condiments" value="Mustard"> <span>Mustard</span>
    <input type="checkbox" name="condiments" value="Sprouts"> <span>Sprouts</span>
    <button type="submit">Save</button>
</form>
<p>Sandwich have ${name}</p>
</body>
</html>
