<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<head>
    <title>Add Expense</title>
</head>
<body style="background: bisque">
<h1 align="center">Add Your Expense</h1>

<h2 align="center" style="color: darkred">${message}</h2>

<table align="center">
    <form:form modelAttribute="expense">
        <tr>
            <td>Enter the money of your Expense:</td>
            <td><form:input path="money" id="enteredCost"/></td>
        </tr>
        <tr>
            <td>Enter the name:</td>
            <td><form:input path="name" id="enteredName"/></td>
        </tr>
        <tr>
            <td>Choose category:</td>
            <td>
                <form:select name="chooseCategory" path="category">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.name}">${category.name}</option>
                    </c:forEach>
                </form:select>

            </td>
        </tr>
        <tr style="alignment: center">
            <td>
                <input style="background: gold" type="submit" value="CONFIRM Expense"/>
            </td>
        </tr>
    </form:form>

    <tr style="height: 100px">
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/'">
                HOME
            </button>
        </td>

        <td><button onclick="window.location.href='/finance_manager_war_exploded/expenses'">
            SHOW Expenses
        </button></td>
    </tr>
</table>

</body>
</html>
