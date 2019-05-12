<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kopytg
  Date: 11.04.19
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Expense</title>
</head>
<body>
<h1>Add Your Expense!</h1>
<form:form modelAttribute="expense">
    ${fail_message}
    <table>
    <tr>
        <td>Enter the money of your Expense: </td>
        <td><form:input path="money" id="enteredCost"/></td>
    </tr>
    <tr>
        <td>Enter the category: </td>
        <td><form:input path="category" id="enteredCategory"/></td>
    </tr>
    <tr>
        <td>
            <input type="submit" value="Confirm the Expense"/>
        </td>
    </tr>
    </table>
</form:form>
</body>
</html>
