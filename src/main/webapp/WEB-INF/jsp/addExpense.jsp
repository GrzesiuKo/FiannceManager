<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    ${message}
    <table>
        <form:form modelAttribute="expense">
    <tr>
        <td>Enter the money of your Expense: </td>
        <td><form:input path="money" id="enteredCost"/></td>
    </tr>
    <tr>
        <td>Choose category: </td>

        <form:form modelAttribute="expenses">
        <select name="category">
            <c:forEach items="${expenses}" var="category">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select>
        </form:form>
    </tr>

        <tr>
            <td>Enter the name: </td>
            <td><form:input path="name" id="enteredName"/></td>
        </tr>
    <tr>
        <td>
            <input type="submit" value="Confirm the Expense"/>
        </td>
    </tr>
        </form:form>

        <tr>
            <td>
                <button onclick="window.location.href='/finance_manager_war_exploded/'">
                Home Page!!!
            </button>
            </td>
        </tr>
    </table>

<select name="category">
    <c:forEach items="${expenses}" var="category">
        <option value="${category.id}">${category.name}</option>
    </c:forEach>
</select>


</body>
</html>
