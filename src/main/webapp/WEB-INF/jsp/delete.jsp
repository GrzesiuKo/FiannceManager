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
    <title>Delete Expense</title>
</head>
<body>
<table>

    <form:form modelAttribute="expense">
    <tr>
        <td>Enter the ID of your Expense: </td>
        <td><form:input path="id" id="enteredID"/></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Delete it!"/>
        </td>
    </tr>
    </form:form>

    <tr>
        <td><button onclick="window.location.href='/finance_manager_war_exploded/expenses'">
            I don't remember man! I want to check it!!!
        </button></td>
    </tr>

   </table>
</body>
</html>
