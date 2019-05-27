<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kopytg
  Date: 19.05.19
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<head>
    <title>Delete Category</title>
</head>
<body style="background: bisque">
<h1>DELETE Your Category!</h1>

<h2 align="center" style="color: darkred">${message}</h2>
<table>

    <form:form modelAttribute="category">
        <tr>
            <td>Enter the ID of your Category:</td>
            <td><form:input path="id" id="enteredID"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Delete it!"/>
            </td>
        </tr>
    </form:form>

    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/categories'">
                "I don't remember. I want to check it."
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/'">
                HOME
            </button>
        </td>
    </tr>

</table>
</body>
</html>
