<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 8/25/2022
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2> <a href="/users">List of Users</a> </h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user" items="${userList}" varStatus="name">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form method="get">
        <input type="hidden" name="action" value="sort">
        <button type="submit" >sort</button>
    </form>
    <form method="get">
        <input type="hidden" name="action" value="search" >
        <input type="text" name="idSearch" >
        <button type="submit">SearchId</button>
        <input type="text" name="countrySearch" >
        <button type="submit">SearchCountry</button>
    </form>


</div>
</body>
</html>
