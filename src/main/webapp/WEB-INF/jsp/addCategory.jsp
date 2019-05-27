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
    <title>Add Category</title>
</head>
<body style="background: bisque">
<h1>ADD Category :)</h1>

<h2 align="center" style="color: darkred">${message}</h2>
<table>

    <form:form modelAttribute="expense">
        <tr>
            <td>Enter the NAME of your Category:</td>
            <td><form:input path="category" id="enteredCategory"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="ADD"/>
            </td>
        </tr>
    </form:form>

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
