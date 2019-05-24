<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kopytg
  Date: 19.05.19
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<head>
    <title>History</title>
</head>
<body style="background: bisque">
<h1 align="center">History</h1>
<table align="center">
    <td>
        <button onclick="window.location.href='/finance_manager_war_exploded/delete'">
            "I want to delete some of them."
        </button>
    </td>
    <td>
        <button onclick="window.location.href='/finance_manager_war_exploded/'">
            HOME
        </button>
    </td>
</table>

<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Date</th>
            <th>Category</th>
            <th>Name</th>
            <th>Money</th>
        </tr>
        <c:forEach items= "${expenses}" var="expense">
            <tr>
                <td><c:out value="${expense.id}" /></td>
                <td><c:out value="${expense.date}" /></td>
                <td><c:out value="${expense.category}" /></td>
                <td><c:out value="${expense.name}" /></td>
                <td><c:out value="${expense.money}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
